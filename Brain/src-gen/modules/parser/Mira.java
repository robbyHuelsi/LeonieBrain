package modules.parser;

import java.io.Serializable;

import main.*;
import modules.Module;
import vBrain.PersonList;

public class Mira implements IParser, Serializable{
	private static final long serialVersionUID = 1L;
	private Start start;
	
	private boolean arrivedWP;
	private boolean blocked;
	private boolean bumpered;
	private int eventNumber;

	public boolean parse(String data, Start start) {
		System.out.println("NAV: " + data);
		//Arrived waypoint by pilot:  #NAV##ARR_WP#1#   //#NAV##ARR_WP#1# (=> arrived at global waypoint 
		//Path blocked:  #NAV##PATH_BLOCKED#1#      	//#NAV##PATH_BLOCKED#1#  (=> path is blocked
		//Bumpered: #NAV##BUMPERED#1#            		//#NAV##BUMPERED#1#  (=> leonie is bumpered
		if (data.contains("#ARR_WP#")) {
			this.setArrivedWP(true);
		} else if (data.contains("#PATH_BLOCKED#1")) {
			this.setBlocked(true);
		} else if (data.contains("#BUMPERED#1")) {
			this.setBumpered(true);
		}

		return true;
	}

	public boolean isArrivedWP() {
		return arrivedWP;
	}

	public void setArrivedWP(boolean arrivedWP) {
		this.arrivedWP = arrivedWP;
		//TODO brain.getSCIMira().setArrivedWP(arrivedWP);
		if (arrivedWP) {
			System.out.println("Arrived at next waypoint: ");
		}
	}

	public boolean isBlocked() {
		return blocked;
	}

	public void setBlocked(boolean blocked) {
		this.blocked = blocked;
		//TODO brain.getSCIMira().setBlocked(blocked);
		if (blocked) {
			System.out.println("No way found");
		}
	}

	public boolean isBumpered() {
		return bumpered;
	}

	public void setBumpered(boolean bumpered) {
		this.bumpered = bumpered;
		//TODO brain.getSCIMira().setBumpered(bumpered);
		if (bumpered) {
			System.out.println("Leonie was bumperd");
		}	
	}

	public int getEventNumber() {
		return eventNumber;
	}

	public void setEventNumber(int eventNumber) {
		this.eventNumber = eventNumber;
		//TODO brain.getSCIMira().setEventNum(eventNumber);
	}


}
