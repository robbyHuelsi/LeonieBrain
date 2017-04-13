package vBrain;

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

import main.Start;
import vBrain.PersonDynData;


public class Person implements Serializable{	
	private static final long serialVersionUID = 1L;
	
	private int personID; // = -1;
	//private Map<Integer, Float> faces;
	private int faceID;
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
		//this.faces = new HashMap<Integer, Float>();
		this.dynData = new Vector<PersonDynData>();
		this.personID = inPersonID;
		this.firstName = "";
		this.lastName = "";
		
		
	}
	
	public Person (int inPersonID, Start inStart, String attributeData){
		this(inPersonID);
		
		String[] attributeParts = attributeData.split(";");

		this.setKnown(false, inStart);
		this.setFaceId(Integer.parseInt(attributeParts[0]));
//		person.setFirstName(attributeParts[2]);
//		person.setLastName(attributeParts[3]);
		this.setEstimatedAge(Integer.parseInt(attributeParts[1]), inStart);
//		person.setBdYear();
//		person.setBdMonth(Integer.parseInt(attributeParts[5]));
//		person.setBdDay(Integer.parseInt(attributeParts[6]));
		this.setGender(attributeParts[2].contains("1")?true:false, inStart);
		this.setEthnicity(Integer.parseInt(attributeParts[3]), inStart);
		this.setGlasses(attributeParts[4].contains("1")?true:false, inStart);
		this.setAttractiveness(Double.parseDouble(attributeParts[5]), inStart);
		
//		if(attributeParts.length >= 7 && attributeParts[6].contains("_")){
//			String[] confOfIds = attributeParts[6].split("_");
//			for(int i = 0; i < confOfIds.length; i++){
//				System.out.println(confOfIds[i]);
//
//				if(confOfIds[i] != ""){
//					String[] confOfId = confOfIds[i].split("=");
//					this.addResemblance(Integer.parseInt(confOfId[0]), Float.parseFloat(confOfId[1]));
//				}
//			}
//		}
		
	}
	

	public int getPersonID() {
		return personID;
	}

	public void setPersonID(int personID, Start inStart) {
		this.personID = personID;
		if(inStart != null){
			//TODO: inB.getSCICurrPerson().setPersonID(personID);
			//TODO: inB.getSCIVBrain().setNessesaryToSavePersonList(true);
		}
	}
	
	public int getFaceId(){
		return this.faceID;
	}
	
	public void setFaceId(int inFaceId){
		this.faceID = inFaceId;
	}
	
	
	public boolean isKnown(){
		return this.known;
	}
	
	public void setKnown(boolean inKnown, Start inStart){
		this.known = inKnown;
		System.out.println("Person known = " + inKnown);
		if(inStart != null){
			//TODO: inB.getSCICurrPerson().setKnown(inKnown);
			//TODO: inB.getSCIVBrain().setNessesaryToSavePersonList(true);
		}
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName, Start inStart) {
		this.firstName = firstName;
		System.out.println("Person Firstname = " + firstName);
		if(inStart != null){
			//TODO: inB.getSCICurrPerson().setFirstname(firstName);
			//TODO: inB.getSCIVBrain().setNessesaryToSavePersonList(true);
		}
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName, Start inStart) {
		this.lastName = lastName;
		if(inStart != null){
			//TODO: inB.getSCICurrPerson().setLastname(lastName);
			//TODO: inB.getSCIVBrain().setNessesaryToSavePersonList(true);
		}
	}
	
	public int getEstimatedAge() {
		return estimatedAge;
	}
	
	public void setEstimatedAge(int estimatedAge, Start inStart) {
		this.estimatedAge = estimatedAge;
		if(inStart != null){
			//TODO: inB.getSCICurrPerson().setEstimatedAge(estimatedAge);
			//TODO: inB.getSCIVBrain().setNessesaryToSavePersonList(true);
		}
	}

	public int getBdYear() {
		return bdYear;
	}
	
	public void setBdYear(int bdYear, Start inStart) {
		this.bdYear = bdYear;
		if(inStart != null){
			//TODO: inB.getSCICurrPerson().setBdYear(bdYear);
			//TODO: inB.getSCIVBrain().setNessesaryToSavePersonList(true);
		}
	}

	public int getBdMonth() {
		return bdMonth;
	}

	public boolean setBdMonth(int bdMonth, Start inStart) {
		if(bdMonth >= 1 && bdMonth <= 12){
			this.bdMonth = bdMonth;
			
			if(inStart != null){
				//TODO: inB.getSCICurrPerson().setBdMounth(bdMonth);
				//TODO: inB.getSCIVBrain().setNessesaryToSavePersonList(true);
			}
			return true;
		}
		
		return false;
	}

	public int getBdDay() {
		return bdDay;
	}

	public boolean setBdDay(int bdDay, Start inStart) {
		if(bdDay >= 1 && bdDay <= 31){
			this.bdDay = bdDay;
			
			if(inStart != null){
				//TODO: inB.getSCICurrPerson().setBdDay(bdDay);
				//TODO: inB.getSCIVBrain().setNessesaryToSavePersonList(true);
			}
			return true;
		}
		
		return false;
	}

	public boolean getGender() {
		return gender;
	}

	public void setGender(boolean gender, Start inStart) {
		this.gender = gender;
		
		if(inStart != null){
			//TODO: inB.getSCICurrPerson().setGender(gender);
			//TODO: inB.getSCIVBrain().setNessesaryToSavePersonList(true);
		}
	}

	public int getEthnicity() {
		return ethnicity;
	}

	public boolean setEthnicity(int ethnicGroup, Start inStart) {
		if(ethnicGroup >= 0 && ethnicGroup <= 2){		
			this.ethnicity = ethnicGroup;
			
			if(inStart != null){
				//TODO: inB.getSCICurrPerson().setEthnicity(ethnicGroup);
				//TODO: inB.getSCIVBrain().setNessesaryToSavePersonList(true);
			}
			return true;
		}
		
		return false;	
	}

	public boolean hasGlasses() {
		return glasses;
	}

	public void setGlasses(boolean glasses, Start inStart) {
		this.glasses = glasses;
		System.out.println("Has glasses: " + (glasses?"yes":"no"));
		if(inStart != null){
			//TODO: inB.getSCICurrPerson().setGlasses(glasses);
			//TODO: inB.getSCIVBrain().setNessesaryToSavePersonList(true);
		}
	}

	public double getAttractiveness() {
		return attractiveness;
	}

	public void setAttractiveness(double attractiveness, Start inStart) {
		this.attractiveness = attractiveness;
		
		if(inStart != null){
			//TODO: inB.getSCICurrPerson().setAttractiveness(attractiveness);
			//TODO: inB.getSCIVBrain().setNessesaryToSavePersonList(true);
		}
	}
	
//	public Map<Integer, Float> getFaces() {
//		return faces;
//	}
	
//	public int getFaceWithHeighestConfi(){
//		float higthesConfi = 0;
//		int tmpID = 0;
//		
//		for(Map.Entry<Integer, Float> f : this.getFaces().entrySet()){	
//			if(higthesConfi < f.getValue()){
//				higthesConfi = f.getValue();
//				tmpID = f.getKey();
//			}
//		}
//		
//		return tmpID;
//	}

//	public void setFaces(Map<Integer, Float> inC) {
//		faces = inC;
//	}
	

	
//	public void addResemblance(Integer inId, Float inC){
//		this.faces.put(inId, inC);
//	}
	
	public void addDynData(PersonDynData inDD){
		this.dynData.add(inDD);
	}
	
	public void addDynData(String dataString, Start inStart){
		this.dynData.add(new PersonDynData(dataString, inStart));
	}
	
	public PersonDynData getCurrDynData(){
		if (this.dynData == null || this.dynData.size() == 0) return null;
		return this.dynData.lastElement();
	}

	@Override
	public String toString() {
		return "Person [personID=" + personID + ",\n faceID=" + faceID + ",\n known=" + known
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
