package modules.parser;

import java.io.Serializable;

import main.*;
import modules.Module;

public class HBrain implements IParser, Serializable{
	private static final long serialVersionUID = 1L;
	private Start start;
	
	/*
	 * true when text output is finished
	 */
	private boolean TTSReady;

	public boolean parse(String data, Start start) {
		this.start = start;
		
		if (data.contains("1")) {
			this.setTTSReady(false);
		} else if(data.contains("0")){
			this.setTTSReady(true);
		}
		return true;
		
	}
	
	public boolean isTTSReady() {
		return TTSReady;
	}

	/*
	 * set transition in statemachine if TTS is finished/ready
	 */
	public void setTTSReady(boolean tTSReady) {
		TTSReady = tTSReady;
		if (tTSReady) {
			start.getStatemachine().raiseEventOfSCI("HBrain","TTSReady");
			//start.getLog().log("TTS ready");
		}else{
			//brain.getSCIHBrain().setTTSReady(false); //War auch vor dem Umbau auskommentiert
			start.getLog().log("TSS jabbering");
		}
	}

	public boolean removeParsedInformation() {
		this.TTSReady = false;
		return true;
	}

}
