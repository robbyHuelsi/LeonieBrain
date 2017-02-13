package communication;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.yakindu.scr.brain.BrainStatemachine;

import callbacks.OpCallbackImpl;
import main.Start;
import modules.parser.*;
import vBrain.Person;
import vBrain.PersonList;

public class MessageParser implements Iparser{

	private static Iparser parse;
	// Expected form of message: #SENDER#DATA
	public static boolean ParseMessage(String message) {
		//System.out.println(message);
		Start start = Start.instanceOf();
		BrainStatemachine brain = start.getBrain();
		PersonList personList = Start.getPersonList();
		//OpCallbackImpl opCallback = start.getOp;

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
		Pattern pattern = Pattern.compile("\\A#([\\w]*)#([\\S\\D]*)#");
		Matcher m = pattern.matcher(message);
		if (m.find()) {

			sender = m.group(1);
			data = m.group(2);

			//System.out.println(sender + ": " + data);

			// Decide what should be done, depending on sender
			switch (sender) {
			case "VBRAIN": // Pattern vbrainPattern =
							// Pattern.compile("\\A#([\\w]*)#([\\S]*)");
							// Matcher vbrainbM = vbrainPattern.matcher(data);
							// System.out.println(data);
							// if(vbrainbM.find()){
				parse = new VBrain();
				parse.parse(data, brain, start);
				return true;
			// break;

			case "HBRAIN":
				parse = new HBrain();
				parse.parse(data, brain, start);
				
				return true;
			// break;

			case "NOISEDETECTION":
				parse = new Noisedetection();
				parse.parse(data, brain, start); 
				return true;
			// break;

			case "HANDGESTURES":
				parse = new Handgestures();
				parse.parse(data, brain, start); 
				return true;
			// break;

			case "SMARTCONTROL":
				System.out.println("SMARTCONTROL");

				return true;
			// break;

			case "STT":
				parse = new Stt();
				parse.parse(data, brain, start); 
				return true;
			// break;

			case "NAV":
				parse = new Nav();
				parse.parse(data, brain, start); 
				return true;
			// break;

			case "ATTR2":
				parse = new Attr2();
				parse.parse(data, brain, start); 
				return true;
			   // break;
			
			case "CNS":
				parse = new cns();
				parse.parse(data, brain, start);
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

	@Override
	public boolean parse(String data, BrainStatemachine brain, Start start) {
		return false;
	}



}
