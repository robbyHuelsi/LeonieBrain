package modules.parser;

import java.io.Serializable;

import main.Start;

public class MicAry implements IParser, Serializable {
	private static final long serialVersionUID = 1L;
	private Start start;
	
	private boolean noiseDetected;
	private boolean noiseEndDetected;
	private int noiseAngle;

	public boolean parse(String data, Start start) {
		this.start = start;
		//TODO there is no microphone array hardware at the moment..
		
		if (data.equals("NOISEEND")) {
			this.setNoiseDetected(false);
			this.setNoiseEndDetected(true);
			return true;
			
		}else if(data.contains("NOISE#")){
			this.setNoiseEndDetected(false);
			
			try {
				int angle = Integer.parseInt(data.substring(6));
				this.setNoiseAngle(angle);
				this.setNoiseDetected(true);
				return true;
			} catch (Exception e) {
				start.getLog().error("MicrophoneArray: Parsing angle to int failed");
				return false;
			}
		}
		
		return false;
	}

	public boolean removeParsedInformation() {
		this.noiseDetected = false;
		this.noiseEndDetected = false;
		this.noiseAngle = 0;
		return true;
	}

	public boolean isNoiseDetected() {
		return noiseDetected;
	}

	public void setNoiseDetected(boolean noiseDetected) {
		this.noiseDetected = noiseDetected;
		
		if (noiseDetected) {
			//TODO implement raiseNoiseDetected
		}
	}

	public boolean isNoiseEndDetected() {
		return noiseEndDetected;
	}

	public void setNoiseEndDetected(boolean noiseEndDetected) {
		this.noiseEndDetected = noiseEndDetected;
		
		if (noiseEndDetected) {
			//TODO implement raiseNoiseEndDetected
		}
	}

	public int getNoiseAngle() {
		return noiseAngle;
	}

	public void setNoiseAngle(int noiseAngle) {
		this.noiseAngle = noiseAngle;
	}
	
	

}
