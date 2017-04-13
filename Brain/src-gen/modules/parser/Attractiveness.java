package modules.parser;

import java.io.Serializable;

import main.*;
import modules.Module;

public class Attractiveness implements IParser, Serializable{
	private static final long serialVersionUID = 1L;
	private Start start;
	private float attractiveness;

	public boolean parse(String data, Start start) {
		this.start = start;
		
		System.out.println("Attractiveness: " + data);
		this.setAttractiveness(Float.parseFloat(data));
		return true;
	}

	public float getAttractiveness() {
		return attractiveness;
	}

	public void setAttractiveness(float attractiveness) {
		this.attractiveness = attractiveness;
		
		//TODO: brain.getSCICurrPerson().setAttractiveness(att);
	    start.getPersonList().save();
	}
}
