package modules.parser;

import java.io.Serializable;

import org.yakindu.scr.brain.BrainStatemachine;

import main.*;

public class HBrain implements IParser, Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public boolean parse(String data, BrainStatemachine brain, Start start) {
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
