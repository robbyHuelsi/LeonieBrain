package modules.parser;

import java.io.Serializable;

import main.Start;

public class FollowMe implements IParser, Serializable {
	private static final long serialVersionUID = 1L;
	private Start start;
	
	private int nextPersonXPos;
	private int nextPersonYPos;
	
	private boolean detectionPersonFound;
	private boolean trackingPersonLost;

	/*
	 * data contains information about people in the view of Leonie. 
	 * If there is someone to follow or the person Leonie is following is out of the view.
	 * When there is an obsticle in the path, Leonie will avoid this 
	 */
	public boolean parse(String data, Start start) {
		this.start = start;
		
		if (data.equals("FOUND")) {
			//test
			this.setDetectionPersonFound(true);
			return true;
			
		}else if(data.equals("LOST")){
			this.setTrackingPersonLost(true);
			return true;
			
		}else if(data.contains("DETAILS#")){
			//Detection Details (Array Personen mit Raumkoordinate)
			//#FOLLOWME#DETAILS#[x : int],y;x,y;x,y#
			String[] persons = data.substring(8).split(";");
			if (!persons[0].isEmpty()) {
				this.setNextPersonXPos(Integer.parseInt(persons[0].split(",")[0]));
				this.setNextPersonYPos(Integer.parseInt(persons[0].split(",")[1]));
				this.setDetectionPersonFound(true);
			}
			return true;
		}else if(data.contains("AVOID")){
			System.out.println("TEST: " + data);
			 //Start avoidance: #FOLLOWME#AVOID#1 
			 //End avoidance:   #FOLLOWME#AVOID#0
			
			String avoidOnOff = data.substring(6);
			if (avoidOnOff.contains("1")){
				start.getStatemachine().raiseEventOfSCI("FollowMe", "obstacleDetected");
				return true;
			}else if (avoidOnOff.contains("0")){
				start.getStatemachine().raiseEventOfSCI("FollowMe", "obstacleAvoidDone");
				return true;
			}
		}
		return false;
	}

	public boolean removeParsedInformation() {
		this.detectionPersonFound = false;
		this.trackingPersonLost = false;
		return true;
	}
	
	public boolean isDetectionPersonFound() {
		return detectionPersonFound;
	}

	public void setDetectionPersonFound(boolean personFound) {
		this.detectionPersonFound = personFound;
		
		if (personFound) {
			start.getStatemachine().raiseEventOfSCI("FollowMe","detectionPersonFound");
		}
	}

	public boolean isTrackingPersonLost() {
		return trackingPersonLost;
	}

	public void setTrackingPersonLost(boolean personLost) {
		this.trackingPersonLost = personLost;
		
		if (personLost) {
			start.getStatemachine().raiseEventOfSCI("FollowMe","trackingPersonLost");
		}
	}

	public int getNextPersonXPos() {
		return nextPersonXPos;
	}

	public void setNextPersonXPos(int nextPersonXPos) {
		this.nextPersonXPos = nextPersonXPos;
	}

	public int getNextPersonYPos() {
		return nextPersonYPos;
	}

	public void setNextPersonYPos(int nextPersonYPos) {
		this.nextPersonYPos = nextPersonYPos;
	}
	
	

}
