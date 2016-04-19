package vbrain;

import java.util.Vector;

import vbrain.Person; 

public class PersonList {
	
	private Vector<Person> personList;
	private int currPersonID = -1;
	
	
	public boolean hasPersons(){
		return !personList.isEmpty();
	}
	
	public void addPerson (Person inP){
		personList.add(inP);
	}

	public boolean hasPersonWithID(int id){
		if(personList == null || personList.isEmpty()) return false;
		
		for (Person p : personList){
			if (p.getPersonID() == id) return true;
		}
		return false;
	}
	
	public Person getPersonByID(int id){
		if(id == -1) return null;
		for (Person p : personList){
			if (p.getPersonID() == id) return p;
		}
		return null;
	}

	public int getCurrPersonID() {
		return currPersonID;
	}

	public void setCurrPersonID(int currPersonID) {
		this.currPersonID = currPersonID;
	}
	
	public Person getCurrPerson(){
		return this.getPersonByID(this.getCurrPersonID());
	}
}

