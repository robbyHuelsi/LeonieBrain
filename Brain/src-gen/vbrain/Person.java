package vbrain;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;
import java.util.Vector;

import org.yakindu.scr.brain.BrainStatemachine;

import vbrain.PersonDynData;


public class Person {	
	private BrainStatemachine brain;
	
	private int personID; // = -1;
	private Map<Integer, Float> resemblance;
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
	
	public Person (){
		this.resemblance = new HashMap<Integer, Float>();
		this.dynData = new Vector<PersonDynData>();
	}
	
	public Person (BrainStatemachine inBrain){
		this();
		this.brain = inBrain;
	}
	
	public Person (BrainStatemachine inBrain, String attributeData){
		this(inBrain);
		
		String[] attributeParts = attributeData.split(";");

		this.setPersonID(Integer.parseInt(attributeParts[0]));
		this.setKnown(false);
//		person.setFirstName(attributeParts[2]);
//		person.setLastName(attributeParts[3]);
		this.setEstimatedAge(Integer.parseInt(attributeParts[1]));
//		person.setBdYear();
//		person.setBdMonth(Integer.parseInt(attributeParts[5]));
//		person.setBdDay(Integer.parseInt(attributeParts[6]));
		this.setGender(attributeParts[2]=="1"?true:false);
		this.setEthnicity(Integer.parseInt(attributeParts[3]));
		this.setGlasses(Boolean.valueOf(attributeParts[4]));
		this.setAttractiveness(Double.parseDouble(attributeParts[5]));
		
		if(attributeParts[6].contains("_")){
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

	public void setPersonID(int personID) {
		this.personID = personID;
		if(brain != null){
			brain.getSCICurrPerson().setId(personID);
		}
	}
	
	public boolean isKnown(){
		return this.known;
	}
	
	public void setKnown(boolean inKnown){
		this.known = inKnown;
		if(brain != null){
			brain.getSCICurrPerson().setKnown(inKnown);
		}
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
		if(brain != null){
			brain.getSCICurrPerson().setFirstname(firstName);
		}
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
		if(brain != null){
			brain.getSCICurrPerson().setLastname(lastName);
		}
	}
	
	public int getEstimatedAge() {
		return estimatedAge;
	}
	
	public void setEstimatedAge(int estimatedAge) {
		this.estimatedAge = estimatedAge;
		if(brain != null){
			brain.getSCICurrPerson().setEstimatedAge(estimatedAge);
		}
	}

	public int getBdYear() {
		return bdYear;
	}
	
	public void setBdYear(int bdYear) {
		this.bdYear = bdYear;
		if(brain != null){
			brain.getSCICurrPerson().setBdYear(bdYear);
		}
	}

	public int getBdMonth() {
		return bdMonth;
	}

	public boolean setBdMonth(int bdMonth) {
		if(bdMonth >= 1 && bdMonth <= 12){
			this.bdMonth = bdMonth;
			
			if(brain != null){
				brain.getSCICurrPerson().setBdMounth(bdMonth);
			}
			return true;
		}
		
		return false;
	}

	public int getBdDay() {
		return bdDay;
	}

	public boolean setBdDay(int bdDay) {
		if(bdDay >= 1 && bdDay <= 31){
			this.bdDay = bdDay;
			
			if(brain != null){
				brain.getSCICurrPerson().setBdDay(bdDay);
			}
			return true;
		}
		
		return false;
	}

	public boolean getGender() {
		return gender;
	}

	public void setGender(boolean gender) {
		this.gender = gender;
		
		if(brain != null){
			brain.getSCICurrPerson().setGender(gender);
		}
	}

	public int getEthnicity() {
		return ethnicity;
	}

	public boolean setEthnicity(int ethnicGroup) {
		if(ethnicGroup >= 0 && ethnicGroup <= 2){		
			this.ethnicity = ethnicGroup;
			
			if(brain != null){
				brain.getSCICurrPerson().setEthnicity(ethnicGroup);
			}
			return true;
		}
		
		return false;	
	}

	public boolean hasGlasses() {
		return glasses;
	}

	public void setGlasses(boolean glasses) {
		this.glasses = glasses;
		
		if(brain != null){
			brain.getSCICurrPerson().setGlasses(glasses);
		}
	}

	public double getAttractiveness() {
		return attractiveness;
	}

	public void setAttractiveness(double attractiveness) {
		this.attractiveness = attractiveness;
		
		if(brain != null){
			brain.getSCICurrPerson().setAttractiveness(attractiveness);
		}
	}
	
	public Map<Integer, Float> getResemblances() {
		return resemblance;
	}

	public void setResemblances(Map<Integer, Float> inC) {
		resemblance = inC;
	}
	
	public void addResemblance(Integer inId, Float inC){
		this.resemblance.put(inId, inC);
	}
	
	public void addDynData(PersonDynData inDD){
		this.dynData.add(inDD);
	}
	
	public void addDynData(String dataString){
		this.dynData.add(new PersonDynData(brain, dataString));
	}
	
	public PersonDynData getCurrDynData(){
		return this.dynData.lastElement();
	}

	@Override
	public String toString() {
		return "Person [brain=" + brain + ", personID=" + personID + ", resemblance=" + resemblance + ", known=" + known
				+ ", firstName=" + firstName + ", lastName=" + lastName + ", estimatedAge=" + estimatedAge + ", bdYear="
				+ bdYear + ", bdMonth=" + bdMonth + ", bdDay=" + bdDay + ", gender=" + (gender == true?"female":"male") + ", ethnicity="
				+ (ethnicity==0?"white":(ethnicity==1?"black":"asian")) + ", glasses=" + glasses + ", attractiveness=" + attractiveness + ", dynData=" + dynData
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
