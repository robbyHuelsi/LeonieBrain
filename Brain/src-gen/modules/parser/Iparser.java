package modules.parser;

import org.yakindu.scr.brain.BrainStatemachine;

import main.Start;
import vBrain.PersonList;

public interface Iparser {

	public boolean parse(String data, BrainStatemachine brain, Start start);
}
