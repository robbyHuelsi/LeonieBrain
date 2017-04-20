package modules.parser;

import java.io.Serializable;

import main.Start;
import modules.Module;

public class CNS implements IParser, Serializable{
	private static final long serialVersionUID = 1L;

	public boolean parse(String data, Start start) {
		String[] attributes = data.split(";");
		String name = attributes[0];
		String ip = attributes[1];
		int port = Integer.parseInt(attributes[2]);
				
		start.getModules().addModule(name, ip, port, true);
		
		return true;
	}

	public boolean removeParsedInformation() {
		return true;
	}
}