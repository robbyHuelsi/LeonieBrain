package modules.parser;

import org.yakindu.scr.brain.BrainStatemachine;
import main.Start;

public class CNS implements IParser{

	@Override
	public boolean parse(String data, BrainStatemachine brain, Start start) {
		if (data.contains("#CNS#")) {
			String attributes = data.substring(5);
			String[] attributeIpPort = attributes.split(";");
			String name = attributeIpPort[0];
			String ip = attributeIpPort[1];
			int port = Integer.parseInt(attributeIpPort[2]);
					
			start.getModules().addModule(name, ip, port, true);
		
		}
		
		return true;
	}
}
