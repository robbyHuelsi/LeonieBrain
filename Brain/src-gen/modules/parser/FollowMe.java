package modules.parser;

import java.io.Serializable;

import main.Start;

public class FollowMe implements IParser, Serializable {
	private static final long serialVersionUID = 1L;
	private Start start;
	
	private boolean personFound;
	private boolean personLost;

	public boolean parse(String data, Start start) {
		this.start = start;
		
		//TODO Muss getestet werden
		
		if (data.equals("FOUND")) {
			this.setPersonLost(false);
			this.setPersonFound(true);
			return true;
		}else if(data.equals("LOST")){
			this.setPersonFound(false);
			this.setPersonLost(true);
			return true;
		}else if(data.contains("DETAILS")){
			//TODO implement parse DETAILS
		}
		
		return false;
	}

	public boolean removeParsedInformation() {
		this.personFound = false;
		this.personLost = false;
		return true;
	}
	
	public boolean isPersonFound() {
		return personFound;
	}

	public void setPersonFound(boolean personFound) {
		this.personFound = personFound;
		
		if (personFound) {
			//TODO implement raisePersonFound
		}
	}

	public boolean isPersonLost() {
		return personLost;
	}

	public void setPersonLost(boolean personLost) {
		this.personLost = personLost;
		
		if (personLost) {
			//TODO implement raisePersonLost
		}
	}

}
