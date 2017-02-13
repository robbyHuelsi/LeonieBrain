package modules.parser;

import org.yakindu.scr.brain.BrainStatemachine;

import main.Start;

public class cns implements Iparser{

	@Override
	public boolean parse(String data, BrainStatemachine brain, Start start) {
		// TODO Auto-generated method stub
		
		start.getModules().addModule(name, ip, port, true);
		
		return false;
	}

}
