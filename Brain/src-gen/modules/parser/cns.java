package modules.parser;

import org.yakindu.scr.brain.BrainStatemachine;
import main.Start;

public class cns implements Iparser{

	@Override
	public boolean parse(String data, BrainStatemachine brain, Start start) {

		if (data.contains("#CNS#")) {
			String attributes = data.substring(5);
			System.out.println("attributes: " + attributes);
			String[] attributeIpPort = attributes.split(";");
			String name = attributeIpPort[0];
			System.out.println("Name: " + name);
			String ip = attributeIpPort[1];
			System.out.println("IP: " + ip);
			int port = Integer.parseInt(attributeIpPort[2]);
			System.out.println("Port: " + port);
					
		start.getModules().addModule(name, ip, port, true);
		
		}return true;
	}
}
