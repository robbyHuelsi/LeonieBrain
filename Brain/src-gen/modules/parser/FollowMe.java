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
			String[] persons = data.substring(8).split(";");
			if (!persons[0].isEmpty()) {
				this.setNextPersonXPos(Integer.parseInt(persons[0].split(",")[0]));
				this.setNextPersonYPos(Integer.parseInt(persons[0].split(",")[1]));
				this.setDetectionPersonFound(true);
			}
			return true;
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
