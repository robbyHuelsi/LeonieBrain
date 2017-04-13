package communication;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import callbacks.OpCallbackImplBGF;
import main.Start;
import modules.parser.*;
import vBrain.Person;
import vBrain.PersonList;

public class MessageParser {

	// Expected form of message: #SENDER#DATA
	@SuppressWarnings("static-access")
	public static boolean ParseMessage(String message) {
		Start start = Start.instanceOf();
		PersonList personList = Start.getPersonList();
		// OpCallbackImpl opCallback = start.getOp;

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
		// ----------------------------------------------------------------------
		// ----------------------------------------------------------------------
		if (m.find() == true) {
			sender = m.group(1);
			data = m.group(2);
//			System.out.println(sender + ": " + data);

			// Decide what should be done, depending on sender
			boolean parsingDone = false;
			try {
				// ----------------------------------------------------------------------
				// ----------------------------------------------------------------------
				// General code to start parse
				parsingDone = ((IParser) start.getModules().getParser(sender)).parse(data, start);
			} catch (Exception e) {
				// parsing failed.
				parsingDone = false;
			}

			if (parsingDone) {
				return true;
			} else {
				// For Sender with old module names
				switch (sender) {
				case "NAV":
					((IParser) start.getModules().getParser("Mira")).parse(data, start);
					System.out.println("ToDo: Update sender name NAV to Mira");
					return true;
				// break;

				case "ATTR2":
					((IParser) start.getModules().getParser("Attractiveness")).parse(data, start);
					System.out.println("ToDo: Update sender name ATTR2 to Attractiveness");
					return true;
				// break;
					
				case "HandGestures":
					((IParser) start.getModules().getParser("LeapMotion")).parse(data, start);
					System.out.println("ToDo: Update sender name HandGestures to LeapMotion");
					return true;
				// break;
					
				case "NoiseDetection":
					((IParser) start.getModules().getParser("Kinect2")).parse(data, start);
					System.out.println("ToDo: Update sender name NoiseDetection to Kinect2");
					return true;
				// break;

				case "":
				default:
					System.out.println("No parser for " + sender + ": " + data);
					return false;
				// break;
				}
			}

		}

		System.out.println("Unfound: " + m.toString() + "\n" + message);
		return false;
	}
}
