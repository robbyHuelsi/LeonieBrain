package modules.parser;

import java.io.Serializable;

import Persons.PersonList;
import main.*;
import modules.Module;

public class Attractiveness implements IParser, Serializable{
	private static final long serialVersionUID = 1L;
	private Start start;

	public boolean parse(String data, Start start) {
		this.start = start;
		
		System.out.println("Attractiveness: " + data);
		start.getPersonList().getCurrPerson().setAttractiveness(Float.parseFloat(data), start);
		return true;
	}

	public boolean removeParsedInformation() {
		return true;
	}
}
