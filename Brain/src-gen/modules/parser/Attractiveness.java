package modules.parser;

import java.io.Serializable;

import Persons.PersonList;
import main.*;
import modules.Module;

public class Attractiveness implements IParser, Serializable{
	private static final long serialVersionUID = 1L;
	private Start start;
	
	private float attrativeness;
	private boolean attractivenessDetected;
	private boolean noFaceFound;

	public boolean parse(String data, Start start) {
		this.start = start;
		
		System.out.println("Attractiveness: " + data);
		//start.getPersonList().getCurrPerson().setAttractiveness(Float.parseFloat(data), start);
		
		if (data.contains("NOFACE")) {
			this.setAttractivenessDetected(false);
			this.setNoFaceFound(true);
		}else{
			try {
				this.setAttrativeness(Float.parseFloat(data));
				this.setNoFaceFound(false);
				this.setAttractivenessDetected(true);
			
			} catch (Exception e) {
				System.err.println("Attract: String to Float failed");
				return false;
			}
		}
		
		return true;
	}
		
		

	public float getAttrativeness() {
		return attrativeness;
	}



	public void setAttrativeness(float attrativeness) {
		this.attrativeness = attrativeness;
	}



	public boolean isAttractivenessDetected() {
		return attractivenessDetected;
	}



	public void setAttractivenessDetected(boolean attractivenessDetected) {
		this.attractivenessDetected = attractivenessDetected;
		
		if (attractivenessDetected) {
			start.getStatemachine().raiseEventOfSCI("Attractiveness","attractivenessDetected");
		}
	}

	

	public boolean isNoFaceFound() {
		return noFaceFound;
	}



	public void setNoFaceFound(boolean noFaceFound) {
		this.noFaceFound = noFaceFound;
		
		if (noFaceFound) {
			start.getStatemachine().raiseEventOfSCI("Attractiveness","noFaceFound");
		}
	}



	public boolean removeParsedInformation() {
		
		attrativeness = -1;
		
		attractivenessDetected = false;
		
		return true;
	}
}
