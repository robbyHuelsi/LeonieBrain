package modules.parser;

import java.io.Serializable;

import main.*;
import modules.Module;

public class LeapMotion implements IParser, Serializable{
	private static final long serialVersionUID = 1L;
	private Start start;
	
	// Parsed information
	private boolean gestureDetected;
	private boolean stringFinished;
	private String gesture;
	private String gesturedString;

	public boolean parse(String data, Start start) {
		this.start = start;
		
		String[] attributePartsHG = data.split(";");
		//System.out.println(data);
		if (attributePartsHG[0].contains("0")){
			//System.out.println("LeapMotion: nothing detected");
			this.setGestureDetected(false);
			this.setStringFinished(false);
			
		}else if(attributePartsHG.length > 1){
			if(attributePartsHG[0].equals("1")) {
				this.setGesture(attributePartsHG[1]);
				this.setGestureDetected(true);
				System.out.println("LeapMotion: " + attributePartsHG[1] + " detected");
			} else if (attributePartsHG[0].equals("2")) {
				System.out.println("Finished string is " + attributePartsHG[1]);
				this.setGesturedString(attributePartsHG[1]);
				this.setStringFinished(true);
			}
		}
		
		return true;
		
	}

	public boolean isGestureDetected() {
		return gestureDetected;
	}

	public void setGestureDetected(boolean gestureDetected) {
		this.gestureDetected = gestureDetected;
		
		if (gestureDetected) {
			start.getStatemachine().raiseEventOfSCI("LeapMotion","gestureDetected");
		}
	}

	public boolean isStringFinished() {
		return stringFinished;
	}

	public void setStringFinished(boolean stringFinished) {
		this.stringFinished = stringFinished;
		
		if (stringFinished) {
			start.getStatemachine().raiseEventOfSCI("LeapMotion","stringFinished");
		}
	}

	public String getGesture() {
		return gesture;
	}

	public void setGesture(String gesture) {
		this.gesture = gesture;
	}

	public String getGesturedString() {
		return gesturedString;
	}

	public void setGesturedString(String gesturedString) {
		this.gesturedString = gesturedString;
	}

	public boolean removeParsedInformation() {
		this.gestureDetected = false;
		this.stringFinished = false;
		this.gesture = "";
		this.gesturedString = "";
		
		return true;
	}



}