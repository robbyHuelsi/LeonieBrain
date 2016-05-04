package vbrain;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;
import java.util.Vector;

import org.yakindu.scr.brain.BrainStatemachine;

import vbrain.PersonDynData;


public class Person implements Serializable{	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int personID; // = -1;
	private Map<Integer, Float> faces;
	private boolean known;
	private String firstName;
	private String lastName;
	private int estimatedAge;
	private int bdYear;
	private int bdMonth;
	private int bdDay;
	private boolean gender; // male = 0, female = 1
	private int ethnicity; // european = 0, africa = 1, asian = 2
	private boolean glasses;
	private double attractiveness;
	private Vector<PersonDynData> dynData;
	
	public Person (int inPersonID){
		this.faces = new HashMap<Integer, Float>();
		this.dynData = new Vector<PersonDynData>();
		this.personID = inPersonID;
		this.firstName = "";
		this.lastName = "";
		
		
	}
	
	public Person (int inPersonID, BrainStatemachine inB, String attributeData){
		this(inPersonID);
		
		String[] attributeParts = attributeData.split(";");

		this.setKnown(false, inB);
//		person.setFirstName(attributeParts[2]);
//		person.setLastName(attributeParts[3]);
		this.setEstimatedAge(Integer.parseInt(attributeParts[1]), inB);
//		person.setBdYear();
//		person.setBdMonth(Integer.parseInt(attributeParts[5]));
//		person.setBdDay(Integer.parseInt(attributeParts[6]));
		this.setGender(attributeParts[2].contains("1")?true:false, inB);
		this.setEthnicity(Integer.parseInt(attributeParts[3]), inB);
		this.setGlasses(attributeParts[4].contains("1")?true:false, inB);
		this.setAttractiveness(Double.parseDouble(attributeParts[5]), inB);
		
		if(attributeParts.length >= 7 && attributeParts[6].contains("_")){
			String[] confOfIds = attributeParts[6].split("_");
			for(int i = 0; i < confOfIds.length; i++){
				System.out.println(confOfIds[i]);

				if(confOfIds[i] != ""){
					String[] confOfId = confOfIds[i].split("=");
					this.addResemblance(Integer.parseInt(confOfId[0]), Float.parseFloat(confOfId[1]));
				}
			}
		}
		
	}
	

	public int getPersonID() {
		return personID;
	}

	public void setPersonID(int personID, BrainStatemachine inB) {
		this.personID = personID;
		if(inB != null){
			inB.getSCICurrPerson().setPersonID(personID);
			inB.getSCIVBrain().setNessesaryToSavePersonList(true);
		}
	}
	
	public boolean isKnown(){
		return this.known;
	}
	
	public void setKnown(boolean inKnown, BrainStatemachine inB){
		this.known = inKnown;
		System.out.println("Person known = " + inKnown);
		if(inB != null){
			inB.getSCICurrPerson().setKnown(inKnown);
			inB.getSCIVBrain().setNessesaryToSavePersonList(true);
		}
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName, BrainStatemachine inB) {
		this.firstName = firstName;
		System.out.println("Person Firstname = " + firstName);
		if(inB != null){
			inB.getSCICurrPerson().setFirstname(firstName);
			inB.getSCIVBrain().setNessesaryToSavePersonList(true);
		}
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName, BrainStatemachine inB) {
		this.lastName = lastName;
		if(inB != null){
			inB.getSCICurrPerson().setLastname(lastName);
			inB.getSCIVBrain().setNessesaryToSavePersonList(true);
		}
	}
	
	public int getEstimatedAge() {
		return estimatedAge;
	}
	
	public void setEstimatedAge(int estimatedAge, BrainStatemachine inB) {
		this.estimatedAge = estimatedAge;
		if(inB != null){
			inB.getSCICurrPerson().setEstimatedAge(estimatedAge);
			inB.getSCIVBrain().setNessesaryToSavePersonList(true);
		}
	}

	public int getBdYear() {
		return bdYear;
	}
	
	public void setBdYear(int bdYear, BrainStatemachine inB) {
		this.bdYear = bdYear;
		if(inB != null){
			inB.getSCICurrPerson().setBdYear(bdYear);
			inB.getSCIVBrain().setNessesaryToSavePersonList(true);
		}
	}

	public int getBdMonth() {
		return bdMonth;
	}

	public boolean setBdMonth(int bdMonth, BrainStatemachine inB) {
		if(bdMonth >= 1 && bdMonth <= 12){
			this.bdMonth = bdMonth;
			
			if(inB != null){
				inB.getSCICurrPerson().setBdMounth(bdMonth);
				inB.getSCIVBrain().setNessesaryToSavePersonList(true);
			}
			return true;
		}
		
		return false;
	}

	public int getBdDay() {
		return bdDay;
	}

	public boolean setBdDay(int bdDay, BrainStatemachine inB) {
		if(bdDay >= 1 && bdDay <= 31){
			this.bdDay = bdDay;
			
			if(inB != null){
				inB.getSCICurrPerson().setBdDay(bdDay);
				inB.getSCIVBrain().setNessesaryToSavePersonList(true);
			}
			return true;
		}
		
		return false;
	}

	public boolean getGender() {
		return gender;
	}

	public void setGender(boolean gender, BrainStatemachine inB) {
		this.gender = gender;
		
		if(inB != null){
			inB.getSCICurrPerson().setGender(gender);
			inB.getSCIVBrain().setNessesaryToSavePersonList(true);
		}
	}

	public int getEthnicity() {
		return ethnicity;
	}

	public boolean setEthnicity(int ethnicGroup, BrainStatemachine inB) {
		if(ethnicGroup >= 0 && ethnicGroup <= 2){		
			this.ethnicity = ethnicGroup;
			
			if(inB != null){
				inB.getSCICurrPerson().setEthnicity(ethnicGroup);
				inB.getSCIVBrain().setNessesaryToSavePersonList(true);
			}
			return true;
		}
		
		return false;	
	}

	public boolean hasGlasses() {
		return glasses;
	}

	public void setGlasses(boolean glasses, BrainStatemachine inB) {
		this.glasses = glasses;
		System.out.println("Has glasses: " + (glasses?"yes":"no"));
		if(inB != null){
			inB.getSCICurrPerson().setGlasses(glasses);
			inB.getSCIVBrain().setNessesaryToSavePersonList(true);
		}
	}

	public double getAttractiveness() {
		return attractiveness;
	}

	public void setAttractiveness(double attractiveness, BrainStatemachine inB) {
		this.attractiveness = attractiveness;
		
		if(inB != null){
			inB.getSCICurrPerson().setAttractiveness(attractiveness);
			inB.getSCIVBrain().setNessesaryToSavePersonList(true);
		}
	}
	
	public Map<Integer, Float> getFaces() {
		return faces;
	}
	
	public int getFaceWithHeighestConfi(){
		float higthesConfi = 0;
		int tmpID = 0;
		
		for(Map.Entry<Integer, Float> f : this.getFaces().entrySet()){	
			if(higthesConfi < f.getValue()){
				higthesConfi = f.getValue();
				tmpID = f.getKey();
			}
		}
		
		return tmpID;
	}

	public void setFaces(Map<Integer, Float> inC) {
		faces = inC;
	}
	
	public void addResemblance(Integer inId, Float inC){
		this.faces.put(inId, inC);
	}
	
	public void addDynData(PersonDynData inDD){
		this.dynData.add(inDD);
	}
	
	public void addDynData(String dataString, BrainStatemachine inB){
		this.dynData.add(new PersonDynData(inB, dataString));
	}
	
	public PersonDynData getCurrDynData(){
		if (this.dynData == null || this.dynData.size() == 0) return null;
		return this.dynData.lastElement();
	}

	@Override
	public String toString() {
		return "Person [personID=" + personID + ",\n faces=" + faces + ",\n known=" + known
				+ ",\n firstName= " + firstName + " ,\n lastName=" + lastName + ",\n estimatedAge=" + estimatedAge + ",\n bdYear="
				+ bdYear + ",\n bdMonth=" + bdMonth + ",\n bdDay=" + bdDay + ",\n gender=" + (gender == true?"female":"male") + ",\n ethnicity="
				+ (ethnicity==0?"white":(ethnicity==1?"black":"asian")) + ",\n glasses=" + glasses + ",\n attractiveness=" + attractiveness + ",\n dynData=" + dynData.toString()
				+ "]";
	}
	
	
	
	// Returns a string containing the values of all attributes of this object
	// The values are divided by semicolons and they are ordered as follows:
	// ID; ACIfaces; firstName; lastName; bdYear; bdMonth; bdDay; gender; ethnicGroup; glasses; attractiveness
	// The elements of ACIfaces are separated by "/"
	/*private String convertDataToString()
	{
		StringJoiner sj = new StringJoiner(";");
		
		sj.add(Integer.toString(getPersonID()));
		
		// Add values in ACIfaces, divided by "/"
		Vector<Integer> vector = getACIfaces();
		if(vector != null){			
			String data = "";
			for(int i = 0; i < vector.size(); i++){
				data += vector.elementAt(i).toString();
				if(i < vector.size() - 1){
					data += "/";
				}
			}
			sj.add(data);
		}
		else{
			sj.add("");
		}			
		
		sj.add(getFirstName());
		sj.add(getLastName());
		sj.add(Integer.toString(getBdYear()));
		sj.add(Integer.toString(getBdMonth()));
		sj.add(Integer.toString(getBdDay()));
		sj.add(Boolean.toString(getGender()));
		sj.add(Integer.toString(getEthnicGroup()));
		sj.add(Boolean.toString(hasGlasses()));
		sj.add(Double.toString(getAttractiveness()));
		
		return sj.toString();
	}*/
	
	// Write object data to a new line at the end of a textFile
	// Return whether operation was successful
	/*public boolean serialize(String filename)	{
		try(PrintWriter output = new PrintWriter(new FileWriter(filename, true))){				
		    output.println(convertDataToString());
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
			return false;
		} catch (IOException e1) {
			System.out.println("IOException");
			return false;
		}
			
		return true;
	}*/
	
	// Read textFile which contains data for objects of this class,
	// create those objects and return them in a Vector
	// Returns null in case of error
	/*static public Vector<Person> deserialize(String filename){
		try(BufferedReader fileReader = new BufferedReader(new FileReader(filename))){
			Vector<Person> result = new Vector<Person>(0,1);
			
			// Read lines and create one object per line
			String line;
			while((line = fileReader.readLine()) != null){		
				result.add(createObjectFromString(line));
	        }
			
			return result;
		} catch (IOException ioe) {
			System.out.println("IOException");
			return null;
		} catch (Exception e) {
			System.out.println("Some error occurred");
			return null;
		}
	}*/
	
	
	
	// Create object from string with the following form:
	// ID;V1/V2/V3/...;firstName;lastName;year;month;day;gender;ethnicGroup;glasses;attractiveness
	
}
