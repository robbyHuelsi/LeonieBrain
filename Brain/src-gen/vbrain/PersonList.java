package vBrain;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Map;
import java.util.Vector;

import main.Start;
import vBrain.Person; 

public class PersonList{
	private Vector<Person> personList;
	private Person currPerson = null;
	private String filePath = System.getProperty ("user.home") + "PersonList.brain";
	
	public PersonList(){
		if(this.load()){
			//personList wurde geladen aus Datei
			System.out.println(this.toString());
		}else{
			this.personList = new Vector<Person>();
		}
	}
	
	public int getUnusedPersonID(){
		int hightestID = 0;
		for(Person p : this.personList){
			if(hightestID < p.getPersonID()){hightestID = p.getPersonID();}
		}
		return ++hightestID;
	}
	
	public boolean hasPersons(){
		return !personList.isEmpty();
	}
	
	public void addPerson (Person inP){
		personList.add(inP);
	}

//	public boolean hasPersonWithID(int id){
//		if(personList == null || personList.isEmpty()) return false;
//		
//		for (Person p : personList){
//			if (p.getPersonID() == id) return true;
//		}
//		return false;
//	}
	
//	public boolean hasPersonWithFaceID(int id){
//		if(personList == null || personList.isEmpty()) return false;
//		
//		for (Person p : personList){
//			if (p.getFaces().containsKey(id)) return true;
//		}
//		return false;
//	}
	
	public Person getPersonByFaceID(int id){
		if(id == -1) return null;
		for (Person p : personList){
			if (p.getFaceId() == id) return p;
		}
		return null;
	}
	
//	public Person getPersonByFaceID(int id){
//		if(id == -1) return null;
//		Person p = null;
//		
//		
//		for (Person tmpP : this.personList){
//			if(tmpP.getFaces()!=null){
//				if(tmpP.getFaceWithHeighestConfi() == id) return tmpP;
//			}
//		}
//		
////		return p;
//		
//		return null;
//	}

//	public int getCurrPersonID() {
//		return currPersonID;
//	}
	
	
	public void setCurrPerson(Person inCurrPerson) {
		if(this.currPerson != inCurrPerson){
			this.currPerson = inCurrPerson;
			
			if (inCurrPerson != null){
				Start.instanceOf().getBrain().getSCICurrPerson().setPersonID(inCurrPerson.getPersonID());
				Start.instanceOf().getBrain().getSCICurrPerson().setKnown(inCurrPerson.isKnown());
				Start.instanceOf().getBrain().getSCICurrPerson().setFirstname(inCurrPerson.getFirstName());
				Start.instanceOf().getBrain().getSCICurrPerson().setLastname(inCurrPerson.getLastName());
				Start.instanceOf().getBrain().getSCICurrPerson().setEstimatedAge(inCurrPerson.getEstimatedAge());
				Start.instanceOf().getBrain().getSCICurrPerson().setBdYear(inCurrPerson.getBdYear());
				Start.instanceOf().getBrain().getSCICurrPerson().setBdMounth(inCurrPerson.getBdMonth());
				Start.instanceOf().getBrain().getSCICurrPerson().setBdDay(inCurrPerson.getBdDay());
				Start.instanceOf().getBrain().getSCICurrPerson().setGender(inCurrPerson.getGender());
				Start.instanceOf().getBrain().getSCICurrPerson().setEthnicity(inCurrPerson.getEthnicity());
				Start.instanceOf().getBrain().getSCICurrPerson().setGlasses(inCurrPerson.hasGlasses());
//				Start.instanceOf().getBrain().getSCICurrPerson().setAttractiveness(inCurrPerson.getAttractiveness());
				
			}else{
				Start.instanceOf().getBrain().getSCICurrPerson().setPersonID(-1);
				Start.instanceOf().getBrain().getSCICurrPerson().setKnown(false);
				Start.instanceOf().getBrain().getSCICurrPerson().setFirstname("");
				Start.instanceOf().getBrain().getSCICurrPerson().setLastname("");
				Start.instanceOf().getBrain().getSCICurrPerson().setEstimatedAge(-1);
				Start.instanceOf().getBrain().getSCICurrPerson().setBdYear(0);
				Start.instanceOf().getBrain().getSCICurrPerson().setBdMounth(0);
				Start.instanceOf().getBrain().getSCICurrPerson().setBdDay(0);
				Start.instanceOf().getBrain().getSCICurrPerson().setGender(false);
				Start.instanceOf().getBrain().getSCICurrPerson().setEthnicity(0);
				Start.instanceOf().getBrain().getSCICurrPerson().setGlasses(false);
				Start.instanceOf().getBrain().getSCICurrPerson().setAttractiveness(-1);
				
			}
		}

	}
	
	public void setCurrPersonByFaceID(int inFaceID) {
		if(this.currPerson==null || inFaceID != this.getCurrPerson().getFaceId()){
			this.setCurrPerson(getPersonByFaceID(inFaceID));
		}
	}
	
	public Person getCurrPerson(){
		return this.currPerson;
	}
	
	public int getLengthOfList(){
		return this.personList.size();
	}
	
	
	
	
	public boolean setCurrPersonFirstname(String inFirstname) {
		if(this.getCurrPerson() != null){
			this.getCurrPerson().setFirstName(inFirstname, Start.instanceOf().getBrain());
			return true;
		}else{
			return false;
		}
	}
	
	
	

	public String toString() {
		return "PersonList [personList=" + personList + ", " + (currPerson!=null?("currPerson=" + currPerson.toString()):"no currPerson") + "]";
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
		      	this.personList = ((Vector<Person>) obj);
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
			File f = new File(this.filePath);
			
			FileOutputStream fout = new FileOutputStream(f);
			ObjectOutputStream oos = new ObjectOutputStream(fout);
		
			System.out.println(this.personList);
			oos.writeObject(this.personList);
		
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

