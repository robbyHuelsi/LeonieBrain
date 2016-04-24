package udp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.yakindu.scr.brain.BrainStatemachine;

import main.Start;
import vbrain.Person;
import vbrain.PersonList;

public class MessageParser {

	// Expected form of message: #SENDER#DATA
	public static boolean ParseMessage(String message) {
		Start start = Start.instanceOf();
		BrainStatemachine brain = start.getBrain();
		PersonList personList = Start.getPersonList();

		// Get sender and process message
		String sender;
		String data;

		// Capture sender in group 1 and message in group 2
		// Pattern explanation:
		// \\A# --> first character is a '#'
		// ([\\w]*)# --> capture any number of word-characters, up to the last #
		// in the string. Store in group 1
		// ([\\S]*) --> capture every following non-whitespace-character in
		// group 2
		Pattern pattern = Pattern.compile("\\A#([\\w]*)#([\\S]*)#");
		Matcher m = pattern.matcher(message);
		if (m.find()) {

			sender = m.group(1);
			data = m.group(2);

			System.out.println(sender + ": " + data);

			// Decide what should be done, depending on sender
			switch (sender) {
			case "VBRAIN": // Pattern vbrainPattern =
							// Pattern.compile("\\A#([\\w]*)#([\\S]*)");
							// Matcher vbrainbM = vbrainPattern.matcher(data);
							// System.out.println(data);
							// if(vbrainbM.find()){

				if (data.contains("#STAT#")) {
					String dataStat = data.substring(6);
					System.out.println("Statische Daten: " + dataStat);
					String[] attributePartsVBS = dataStat.split(";");

					int faceId = Integer.parseInt(attributePartsVBS[0]);
					System.out.println("Face ID: " + faceId);

					personList.setCurrPersonID(faceId);
					if (personList.hasPersonWithID(faceId)) {
						// Person already exists

					} else {

						Person p = new Person(brain, dataStat);
						System.out.println(p.toString());
						personList.addPerson(p);
					}

				} else if (data.contains("#DYN#")) {
					String dataDyn = data.substring(5);
					System.out.println("Dynamische Daten: " + dataDyn);
					String[] attributePartsVBD = dataDyn.split(";");

					if (attributePartsVBD[0].contains("1")) {
						System.out.println("Face found");

						brain.getSCIVBrain().setCountFoundFaces(1);

						int faceId = Integer.parseInt(attributePartsVBD[1]);
						System.out.println("Face ID: " + faceId);
						personList.setCurrPersonID(faceId);
						if (personList.hasPersonWithID(faceId)) {
							Person p = personList.getPersonByID(faceId);
							p.addDynData(dataDyn);
							System.out.println(p.getCurrDynData().toString());
						}

					} else {
						brain.getSCIVBrain().setCountFoundFaces(0);
						// System.out.println(" no face");
					}
				} else if (data.contains("#EMOTION#")) {
					String dataEmo = data.substring(9);
					// Emotion e;
					// e.fromInt(Integer.parseInt(vbrainbM.group(2)));

					System.out.println("Emotion: " + dataEmo);

					Person p = personList.getCurrPerson();
					if (p != null) {
						p.getCurrDynData().setEmotion(Integer.parseInt(dataEmo));
						System.out.println(p.toString());
					}
				}
				// }

				// TODO: Die Variablen

				return true;
			// break;

			case "HBRAIN":
				if (data == "1") {
					brain.getSCIHBrain().setTTSReady(false);
					System.out.println("TSS jabbering");
				} else {
					brain.getSCIHBrain().setTTSReady(true);
					System.out.println("TTS ready");
				}

				return true;
			// break;

			case "NOISEDETECTION":
				// #NOISEDETECTION#1;30;32# [0]: (bool)found [1]:
				// (int)angle_body [2]: (int)angle_noise
				String[] attributePartsND = data.split(";");
				if (attributePartsND[0].contains("1")) {
					System.out.println("Noise detected: " + attributePartsND[1]);
					brain.getSCIKinect2().setNoiseDetected(true);
					brain.getSCIKinect2().setNoiseAngle(Integer.parseInt(attributePartsND[1]));
				} else {
					System.out.println("No noises");
					brain.getSCIKinect2().setNoiseDetected(false);
				}
				return true;
			// break;

			case "HANDGESTURES":
				String[] attributePartsHG = data.split(";");
				// System.out.println(attributePartsHG[0]);
				if (attributePartsHG[0].contains("1")) {
					System.out.println("Handgestutre detected: " + attributePartsHG[1]);
					brain.getSCILeapMotion().setGestureDetected(true);
					brain.getSCILeapMotion().setGesture(attributePartsHG[1]);
				} else {
					System.out.println("Handgestutre not detected");
					brain.getSCILeapMotion().setGestureDetected(true);
				}
				return true;
			// break;

			case "SMARTCONTROL":
				System.out.println("SMARTCONTROL");

				return true;
			// break;

			case "STT":
				System.out.println("Input text: " + data);
				brain.getSCISTT().setSpeakerMsg(data);
				return true;
			// break;

			case "NAV":
				System.out.println("NAV: " + data);
				return true;
			// break;

			case "ATTRACT":
				System.out.println("Attractiveness: " + data);
				return true;
			// break;

			case "":
			default:
				System.out.println(sender + ": " + data);
				return false;
			// break;
			}
		}

		System.out.println("Unfound: " + m.toString() + "\n" + message);

		return false;
	}

}
