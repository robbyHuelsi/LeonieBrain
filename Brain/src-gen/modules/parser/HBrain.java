package modules.parser;

import java.io.Serializable;

import main.*;
import modules.Module;

public class HBrain implements IParser, Serializable{
	private static final long serialVersionUID = 1L;
	private Start start;
	private boolean TTSReady;

	@Override
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

	public void setTTSReady(boolean tTSReady) {
		TTSReady = tTSReady;
		if (tTSReady) {
			//TODO: brain.getSCIHBrain().setTTSReady(true);
			//((SCIHBrain) start.getSCI("HBrain")).setTTSReady(true);
			//System.out.println("TTS ready");
		}else{
			//brain.getSCIHBrain().setTTSReady(false); //War auch vor dem Umbau auskommentiert
			System.out.println("TSS jabbering");
		}
	}

}
