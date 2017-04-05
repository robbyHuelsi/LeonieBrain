package modules.parser;

import java.io.Serializable;

import org.yakindu.scr.brain.BrainStatemachine;

import main.*;
import vBrain.PersonList;

public class Mira implements IParser, Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public boolean parse(String data, BrainStatemachine brain, Start start) {
		System.out.println("NAV: " + data);
		//Arrived waypoint by pilot:  #NAV##ARR_WP#1#   //#NAV##ARR_WP#1# (=> arrived at global waypoint 
		//Path blocked:  #NAV##PATH_BLOCKED#1#      	//#NAV##PATH_BLOCKED#1#  (=> path is blocked
		//Bumpered: #NAV##BUMPERED#1#            		//#NAV##BUMPERED#1#  (=> leonie is bumpered
		if (data.contains("#ARR_WP#")) {
			System.out.println("Arrived at next waypoint: ");
			brain.getSCIScitosRemoteControl().setArrivedWP(true);
			
		} else if (data.contains("#PATH_BLOCKED#1")) {
			System.out.println("No way found");
			brain.getSCIScitosRemoteControl().setBlocked(true);
		} else if (data.contains("#BUMPERED#1")) {
			System.out.println("Leonie was bumperd");
			brain.getSCIScitosRemoteControl().setBumpered(true);
		}

		return true;
	}


}
