package modules.parser;


import main.Start;
import modules.Module;
import vBrain.*;

public interface IParser {

	public boolean parse(String data, Start start);
	
	public boolean removeParsedInformation();
}