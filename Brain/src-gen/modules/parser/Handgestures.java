package modules.parser;

import org.yakindu.scr.brain.BrainStatemachine;

import main.*;

public class HandGestures implements IParser{

	@Override
	public boolean parse(String data, BrainStatemachine brain, Start start) {
		String[] attributePartsHG = data.split(";");
		//System.out.println(data);
		if (attributePartsHG[0].contains("0")){
			//System.out.println("LeapMotion: nothing detected");
			brain.getSCILeapMotion().setGestureDetected(false);
			brain.getSCILeapMotion().setStringFinished(false);
		}else if(attributePartsHG.length > 1){
			if(attributePartsHG[0].contains("1")) {
				brain.getSCILeapMotion().setGesture(attributePartsHG[1]);
				brain.getSCILeapMotion().setGestureDetected(true);
//				if(attributePartsHG[1].contains("true") && attributePartsHG[1].contains("false")) {
//				start.instanceOf().
//				}
				System.out.println("LeapMotion: " + attributePartsHG[1] + " detected");
			} else if (attributePartsHG[0].contains("2")) {
				System.out.println("Finished string is " + attributePartsHG[1]);
				brain.getSCILeapMotion().setDetectedString(attributePartsHG[1]);
				brain.getSCILeapMotion().setStringFinished(true);
			}
		}
		
		return true;
		
	}


}
