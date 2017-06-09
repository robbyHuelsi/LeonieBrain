package modules.parser;


import Persons.*;
import main.Start;
import modules.Module;

public interface IParser {

	public boolean parse(String data, Start start);
	
	public boolean removeParsedInformation();
}