package modules.parser;

import org.yakindu.scr.brain.BrainStatemachine;

import main.*;

public class HBrain implements IParser{

	@Override
	public boolean parse(String data, BrainStatemachine brain, Start start) {
		//System.out.println("HBrain: " + data);
		if (data.contains("1")) {
			//brain.getSCIHBrain().setTTSReady(false);
			System.out.println("TSS jabbering");
		} else if(data.contains("0")){
			brain.getSCIHBrain().setTTSReady(true);
			//System.out.println("TTS ready");
		}

		return true;
		
	}

}
