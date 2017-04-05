package modules.parser;

import java.io.Serializable;

import org.yakindu.scr.brain.BrainStatemachine;
import main.*;

public class Attractiveness implements IParser, Serializable{

	@Override
	public boolean parse(String data, BrainStatemachine brain, Start start) {
		   System.out.println("Attractiveness: " + data);
		    float att = Float.parseFloat(data);
		    brain.getSCICurrPerson().setAttractiveness(att);
		    start.getPersonList().save();
		    return true;
		}
}
