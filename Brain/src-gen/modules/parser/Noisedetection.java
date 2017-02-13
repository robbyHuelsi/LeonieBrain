package modules.parser;

import org.yakindu.scr.brain.BrainStatemachine;

import main.*;

public class Noisedetection implements Iparser{

	@Override
	public boolean parse(String data, BrainStatemachine brain, Start start) {
		// #NOISEDETECTION#1;30;32# [0]: (bool)found [1]:
		// (int)angle_body [2]: (int)angle_noise
		String[] attributePartsND = data.split(";");
		if (attributePartsND[0].contains("1")) {
			System.out.println("Noise detected: " + attributePartsND[1]);
			brain.getSCIKinect2().setNoiseDetected(true);
			brain.getSCIKinect2().setNoiseAngle(Integer.parseInt(attributePartsND[1]));
		} else {
			//System.out.println("No noises");
			brain.getSCIKinect2().setNoiseDetected(false);
		}
		return true;
		
	}

}
