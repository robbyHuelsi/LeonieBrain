package udp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import vbrain.Person;

public class MessageParser
{
	public static boolean ParseMessage(String message){
		// Get sender and process message
		String sender;
		String data;
		
		Pattern pattern = Pattern.compile("\\A#([\\w]*)#([\\S]*)");
		Matcher m = pattern.matcher(message);
		if(m.find()){
			sender = m.group(1);
			data = m.group(2);
			
			// Decide what should be done, depending on sender
			switch (sender){
				case "VBRAIN" : Person p = Person.createObjectFromString(data);
								p.serialize("DATABANK.txt");
								break;
				// Add missing cases
				default : return false;				
			}
		}		
		
		return false;		
	}
}
