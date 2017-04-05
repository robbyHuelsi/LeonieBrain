package modules.parser;

import java.io.Serializable;

import org.yakindu.scr.brain.BrainStatemachine;
import main.Start;

public class CNS implements IParser, Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public boolean parse(String data, BrainStatemachine brain, Start start) {
		String[] attributes = data.split(";");
		String name = attributes[0];
		String ip = attributes[1];
		int port = Integer.parseInt(attributes[2]);
				
		start.getModules().addModule(name, ip, port, true);
		
		return true;
	}
}