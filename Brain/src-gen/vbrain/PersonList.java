package vbrain;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Vector;

import vbrain.Person; 

public class PersonList{
	
	private Vector<Person> personList;
	private int currPersonID = -1;
	private String filePath = "PersonList.brain";
	
	public PersonList(){
		if(this.load()){
			//personList wurde geladen aus Datei
			System.out.println(this.toString());
		}else{
			this.personList = new Vector<Person>();
		}
	}
	
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
	

	public String toString() {
		return "PersonList [personList=" + personList + ", currPersonID=" + currPersonID + "]";
	}

	public boolean load(){
		File f = new File(this.filePath);
		if(f==null || !f.exists() || f.isDirectory()) { 
		    System.out.println("No personList-File found");
		    return false;
		}
		
		ObjectInputStream objectinputstream = null;
		try {
			FileInputStream streamIn = new FileInputStream(filePath);
		    objectinputstream = new ObjectInputStream(streamIn);

		    Object obj= null;
		      // lese ein objekt nach dem anderen aus dem inputstream. das letzte 
		      // object, welches gelesen wird, ist null. dieses muss allerdings explizit
		      // geschrieben worden sein; andernfalls wird eine EOFException geworfen.
		      while ( (obj= objectinputstream.readObject()) != null ){
		      	this.addPerson((Person) obj);
		      }
		    System.out.println("Opening done");
		    return true;
		} catch (Exception e) {
			System.err.println("Opening failed");
		    e.printStackTrace();
		    return false;
		} finally {
		    if(objectinputstream != null){
		        try {
					objectinputstream .close();
				} catch (IOException e) {
					
				}
		    } 
		}
	}
	
	public boolean save(){
		try{  
			FileOutputStream fout = new FileOutputStream(this.filePath);
			ObjectOutputStream oos = new ObjectOutputStream(fout);
			
			for(Person p : this.personList){
				oos.writeObject(p);
			}
			oos.writeObject( null );
			oos.flush();
			oos.close();
			System.out.println("Saving done");
			return true;
		}catch(Exception ex){
			System.err.println("Saving failed");
			ex.printStackTrace();
			return false;
		}
	}
	
	
	
}

