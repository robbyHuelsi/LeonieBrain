package modules.parser;

import java.io.Serializable;

import main.*;
import modules.Module;

public class Kinect2 implements IParser, Serializable{
	private static final long serialVersionUID = 1L;
	private Start start;
	
	private boolean noiseDetected;
	private int noiseAngle;
	private String gesture;

	@Override
	public boolean parse(String data, Start start) {
		this.start = start;
		// #NOISEDETECTION#1;30;32# [0]: (bool)found [1]:
		// (int)angle_body [2]: (int)angle_noise
		String[] attributePartsND = data.split(";");
		if (attributePartsND[0].contains("1")) {
			System.out.println("Noise detected: " + attributePartsND[1]);
			this.setNoiseDetected(true);
			this.setNoiseAngle(Integer.parseInt(attributePartsND[1]));
		} else {
			//System.out.println("No noises");
			this.setNoiseDetected(false);
		}
		return true;
		
	}

	public boolean isNoiseDetected() {
		return noiseDetected;
	}

	public void setNoiseDetected(boolean noiseDetected) {
		this.noiseDetected = noiseDetected;
		//TODO: brain.getSCIKinect2().setNoiseDetected(noiseDetected);
	}

	public int getNoiseAngle() {
		return noiseAngle;
	}

	public void setNoiseAngle(int noiseAngle) {
		this.noiseAngle = noiseAngle;
		//TODO: brain.getSCIKinect2().setNoiseAngle(noiseAngle);
	}

	public String getGesture() {
		return gesture;
	}

	public void setGesture(String gesture) {
		this.gesture = gesture;
	}

}