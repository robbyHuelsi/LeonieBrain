package udp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.yakindu.scr.brain.BrainStatemachine;

import main.Start;

import vbrain.Person;

public class MessageParser
{
	
	// Expected form of message: #SENDER#DATA
	public static boolean ParseMessage(String message){
		Start start = Start.instanceOf();
		BrainStatemachine brain = start.getBrain();
		
		// Get sender and process message
		String sender;
		String data;
		
		// Capture sender in group 1 and message in group 2
		// Pattern explanation:
		// \\A# --> first character is a '#'
		// ([\\w]*)# --> capture any number of word-characters, up to the last # in the string. Store in group 1
		// ([\\S]*) --> capture every following non-whitespace-character in group 2
		Pattern pattern = Pattern.compile("\\A#([\\w]*)#([\\S]*)");
		Matcher m = pattern.matcher(message);
		if(m.find()){

			sender = m.group(1);
			data = m.group(2);
			
			//System.out.println(sender + ": " + data);
			
			// Decide what should be done, depending on sender
			switch (sender){
				case "VBRAIN" : 		Pattern vbrainPattern = Pattern.compile("\\A#([\\w]*)#([\\S]*)");
										Matcher vbrainbM = vbrainPattern.matcher(data);
										
										if (vbrainbM.group(1).equals("STAT")){
											String[] attributePartsVBS = vbrainbM.group(2).split(";");
											
											brain.getSCIACIface_stat().setFaceID(Integer.parseInt(attributePartsVBS[0]));
											brain.getSCIACIface_stat().setConfidence(0);
											brain.getSCIACIface_stat().setAge(Integer.parseInt(attributePartsVBS[1]));
											brain.getSCIACIface_stat().setGender(attributePartsVBS[2].contains("1")?true:false);
											brain.getSCIACIface_stat().setEthnicty(Integer.parseInt(attributePartsVBS[3]));
											brain.getSCIACIface_stat().setGlasses(attributePartsVBS[4].contains("1")?true:false);
											brain.getSCIACIface_stat().setAttractiveness(Integer.parseInt(attributePartsVBS[5]));
										}else{
											
										}
										
										
										
										//Person p = Person.createObjectFromString(data);
										// TODO: Use filename of DB
										//p.serialize("DATABANK.txt");
										
										
										// TODO: Die Variablen 
										
										return true;
										//break;
										
				case "HBRAIN" :			System.out.println("HBrain");
				
										return true;
										//break;
										
				case "NOISEDETECTION" :	String[] attributePartsND = data.split(";");
										if(attributePartsND[2].contains("1")){
											System.out.println("Noise detected: " + attributePartsND[0]);
											brain.getSCIKinect2().setNoiseDetected(true);
											//brain.getSCIKinect2().setNoiseAngle(Integer.parseInt(attributePartsND[0]));
											brain.getSCIKinect2().setNoiseAngle(attributePartsND[0]);
										}else{
											brain.getSCIKinect2().setNoiseDetected(false);
										}
										return true;
										//break;
										
				case "HANDGESTURES" :	String[] attributePartsHG = data.split(";");	
										//System.out.println(attributePartsHG[0]);
										if(attributePartsHG[0].contains("1")){
											System.out.println("Handgestutre detected: " + attributePartsHG[1]);
											brain.getSCILeapMotion().setGestureDetected(true);
											brain.getSCILeapMotion().setGesture(attributePartsHG[1]);
										}else{
											System.out.println("Handgestutre not detected");
											brain.getSCILeapMotion().setGestureDetected(true);
										}
										return true;
										//break;
										
				case "SMARTCONTROL" :	System.out.println("SMARTCONTROL");
							
										return true;
										//break;
										
				case "STT" :			System.out.println("Input text: " + data);
										return true;
										//break;
										
				case "NAV" :			System.out.println("NAV");
										return true;
										//break;
										
				case "ATTRACT" :		System.out.println("Attractiveness: " + data);
										return true;
										//break;
									
				case "":
				default :				System.out.println(sender + ": " + data);
										return false;
										//break;							
			}
		}		

		System.out.println("Unfound: " + m.toString() + "\n" + message);
		
		return false;		
	}
	
	
}
