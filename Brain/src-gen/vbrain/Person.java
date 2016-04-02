package vbrain;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringJoiner;
import java.util.Vector;

public class Person {	
	private int personID = -1;
	private Vector<Integer> ACIfaces;
	private String firstName;
	private String lastName;
	private int bdYear;
	private int bdMonth;
	private int bdDay;
	private boolean gender; // male = 0, female = 1
	private int ethnicGroup; // white = 0, black = 1, asian = 2
	private boolean glasses;
	private double attractiveness;

	public int getPersonID() {
		return personID;
	}

	public void setPersonID(int personID) {
		this.personID = personID;
	}

	public Vector<Integer> getACIfaces() {
		return ACIfaces;
	}

	public void setACIfaces(Vector<Integer> aCIfaces) {
		ACIfaces = aCIfaces;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getBdYear() {
		return bdYear;
	}

	public void setBdYear(int bdYear) {
		this.bdYear = bdYear;
	}

	public int getBdMonth() {
		return bdMonth;
	}

	public boolean setBdMonth(int bdMonth) {
		if(bdMonth >= 1 && bdMonth <= 12){
			this.bdMonth = bdMonth;
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
			return true;
		}
		
		return false;
	}

	public boolean getGender() {
		return gender;
	}

	public void setGender(boolean gender) {
		this.gender = gender;
	}

	public int getEthnicGroup() {
		return ethnicGroup;
	}

	public boolean setEthnicGroup(int ethnicGroup) {
		if(ethnicGroup >= 0 && ethnicGroup <= 2){		
			this.ethnicGroup = ethnicGroup;
			return true;
		}
		
		return false;	
	}

	public boolean hasGlasses() {
		return glasses;
	}

	public void setGlasses(boolean glasses) {
		this.glasses = glasses;
	}

	public double getAttractiveness() {
		return attractiveness;
	}

	public void setAttractiveness(double attractiveness) {
		this.attractiveness = attractiveness;
	}
	
	// Returns a string containing the values of all attributes of this object
	// The values are divided by semicolons and they are ordered as follows:
	// ID; ACIfaces; firstName; lastName; bdYear; bdMonth; bdDay; gender; ethnicGroup; glasses; attractiveness
	// The elements of ACIfaces are separated by "/"
	private String convertDataToString()
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
	}
	
	// Write object data to a new line at the end of a textFile
	// Return whether operation was successful
	public boolean serialize(String filename)	{
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
	}
	
	// Read textFile which contains data for objects of this class,
	// create those objects and return them in a Vector
	// Returns null in case of error
	static public Vector<Person> deserialize(String filename){
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
	}
	
	// Create object from string with the following form:
	// ID;V1/V2/V3/...;firstName;lastName;year;month;day;gender;ethnicGroup;glasses;attractiveness
	static public Person createObjectFromString(String attributeData){
		String[] attributeParts = attributeData.split(";");

		Person person = new Person();
		person.setPersonID(Integer.parseInt(attributeParts[0]));
		
		//Create ACIfaces vector
		String[] vectorParts = attributeParts[1].split("/");
		if(vectorParts.length > 0){
			Vector<Integer> ACIf = new Vector<Integer>(1,1);
			for(String vectorElement : vectorParts){
				ACIf.add(Integer.parseInt(vectorElement));
			}
			person.setACIfaces(ACIf);
		}
		
		person.setFirstName(attributeParts[2]);
		person.setLastName(attributeParts[3]);
		person.setBdYear(Integer.parseInt(attributeParts[4]));
		person.setBdMonth(Integer.parseInt(attributeParts[5]));
		person.setBdDay(Integer.parseInt(attributeParts[6]));
		person.setGender(Boolean.valueOf(attributeParts[7]));
		person.setEthnicGroup(Integer.parseInt(attributeParts[8]));
		person.setGlasses(Boolean.valueOf(attributeParts[9]));
		person.setAttractiveness(Double.parseDouble(attributeParts[10]));
		
		return person;
	}
}
