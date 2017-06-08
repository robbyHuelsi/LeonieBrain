package modules.parser;

import java.io.Serializable;

import org.yakindu.scr.braganca.IBragancaStatemachine.SCIMira;

import Persons.PersonList;
import main.*;
import modules.Module;

public class Mira implements IParser, Serializable{
	private static final long serialVersionUID = 1L;
	private Start start;
	
	// Parsed information
	private boolean emergencyStop;
	private boolean arrivedWP;
	private boolean blocked;
	private boolean bumpered;

	public boolean parse(String data, Start start) {
		this.start = start;
		//Arrived waypoint by pilot:  #MIRA#ARR_WP#1#   //#MIRA#ARR_WP#1# (=> arrived at global waypoint 
		//Path blocked:  #MIRA#PATH_BLOCKED#1#      	//#MIRA#PATH_BLOCKED#1#  (=> path is blocked
		//Bumpered: #MIRA#BUMPERED#1#            		//#MIRA#BUMPERED#1#  (=> leonie is bumpered
		if (data.contains("ARR_WP")) {
			this.setArrivedWP(true);
		} else if (data.contains("PATH_BLOCKED#1")) {
			this.setBlocked(true);
		} else if (data.contains("BUMPERED#1")) {
			this.setBumpered(true);
		}else{
			this.setEmergencyStop(true);
		}

		return true;
	}
	
	

	public boolean isEmergencyStop() {
		return emergencyStop;
	}



	public void setEmergencyStop(boolean emergencyStop) {
		this.emergencyStop = emergencyStop;
		
		if (emergencyStop) {
			start.getLog().log("Emergency Stop");
			start.getStatemachine().raiseEventOfSCI("Mira","emergencyStop");
		}
	}



	public boolean isArrivedWP() {
		return arrivedWP;
	}

	public void setArrivedWP(boolean arrivedWP) {
		this.arrivedWP = arrivedWP;
		if (arrivedWP) {
			start.getLog().log("Arrived at next waypoint: ");
			start.getStatemachine().raiseEventOfSCI("Mira","arrivedWP");
		}
	}

	public boolean isBlocked() {
		return blocked;
	}

	public void setBlocked(boolean blocked) {
		this.blocked = blocked;

		if (blocked) {
			start.getLog().log("No way found");
			start.getStatemachine().raiseEventOfSCI("Mira","blocked");
		}
	}

	public boolean isBumpered() {
		return bumpered;
	}

	public void setBumpered(boolean bumpered) {
		this.bumpered = bumpered;

		if (bumpered) {
			start.getLog().log("Leonie was bumperd");
			start.getStatemachine().raiseEventOfSCI("Mira","bumpered");
		}	
	}



	public boolean removeParsedInformation() {
		this.emergencyStop = false;
		this.arrivedWP = false;
		this.blocked = false;
		this.bumpered = false;
		
		return true;
	}


}
