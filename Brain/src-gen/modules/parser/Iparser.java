package modules.parser;

import org.yakindu.scr.brain.BrainStatemachine;

import vBrain.PersonList;

public interface Iparser {

	public boolean parse(String data, BrainStatemachine brain, PersonList personList);
}
