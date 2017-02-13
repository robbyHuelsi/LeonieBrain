package modules.parser;

import org.yakindu.scr.brain.BrainStatemachine;

import main.Start;
import vBrain.*;

public interface Iparser {

	public boolean parse(String data, BrainStatemachine brain, Start start);
}
