package udp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import vbrain.Person;

public class MessageParser
{
	// Expected form of message: #SENDER#DATA
	public static boolean ParseMessage(String message){
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
			
			// Decide what should be done, depending on sender
			switch (sender){
				case "VBRAIN" : Person p = Person.createObjectFromString(data);
								// TODO: Use filename of DB
								p.serialize("DATABANK.txt");
								break;
				// TODO: Add missing cases
				default : return false;				
			}
		}		
		
		return false;		
	}
}
