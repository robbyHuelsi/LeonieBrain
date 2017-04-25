package modules.parser;

import java.io.Serializable;
import java.util.Vector;

import Persons.PersonCrowd;
import Persons.PersonList;
import main.Start;
import modules.Module;

public class CrowdDet implements IParser, Serializable{
	private static final long serialVersionUID = 1L;
	private Start start;
		
	private Vector<PersonCrowd> personList = new Vector<PersonCrowd>();
	private boolean crowdDetected;


	public boolean parse(String data, Start start) {
		// #CROWDDET#[totalCount:int]#[gender1:int];[age1:int];[position1:int]+[gender2:int];[age2:int];[position2:int]+ etc. #
		//gender: -1 = not detectable; 0 = male ; 1 = female
		//age: -1 = not detectable
		//position: 0 = stehen; 1 = sitzen; 2 = liegen

		
		//TODO Muss getestet werden
		
		this.start = start;
		
		this.personList.removeAllElements();
		if (!data.equals("0#")) {
			String[] datas = data.split("#");
			String[] crowd = datas[1].split(";");
				
			for(int i = 0; i < crowd.length; i++){
				String[] person = crowd[i].split(",");
				try {
					System.out.println(crowd[i]);
					int gender = Integer.parseInt(person[0]);
					int age = Integer.parseInt(person[1]);
					int position = Integer.parseInt(person[2]);
					personList.add(new PersonCrowd(gender, age, position));
				} catch (Exception e) {
					System.err.println("CrowdDet: Parsing string to int failed");
				}
			}
			int total = Integer.parseInt(datas[0]);
			if (total == personList.size()) {
				if (total > 0) {
					// Hier sollte das Programm eingentlich nie reingehen...
					this.setCrowdDetected(true);
				}
				return true;
			}else{
				System.out.println("There is not the same number of Persons in personList (" + personList.size() + ") like total count (" + total + ")");
				return false;
			}
		}else{
			return true; //Keine Person
		}
		
	}
	

	public boolean isCrowdDetected() {
		return crowdDetected;
	}


	public void setCrowdDetected(boolean crowdDetected) {
		this.crowdDetected = crowdDetected;
		
		if (crowdDetected) {
			start.getStatemachine().raiseEventOfSCI("CrowdDetection","detected");
		}
	}


	public boolean areAllGendersDetected() {
		Vector<PersonCrowd> pl = this.personList; //Es kann sein, dass von einem anderen Thread der Vector geupdatet wird.
		for (PersonCrowd p : pl) {
			if (p.getGender() == -1) {
				return false;
			}
		}
		return true;
	}


	public boolean areAllAgesDetected() {
		Vector<PersonCrowd> pl = this.personList; //Es kann sein, dass von einem anderen Thread der Vector geupdatet wird.
		for (PersonCrowd p : pl) {
			if (p.getAge() == -1) {
				return false;
			}
		}
		return true;
	}
	
	public int getTotalCount() {
		return this.personList.size();
	}
	
	public int getSpecificCount(long gender, long minAge, long maxAge, long position){
		Vector<PersonCrowd> pl = this.personList;
		
		int removeCounter;
		for (int i = 0; i < pl.size(); i++) {
			removeCounter = 0;
			
			//gender: -1 = not detectable; 0 = male ; 1 = female
			if (gender != -1 && pl.get(i).getGender() != gender) {
				pl.remove(i);
				removeCounter++;
				
			//age: -1 = not detectable
			}else if(minAge != -1 && pl.get(i).getAge() < minAge ){
				pl.remove(i);
				removeCounter++;
			}else if(maxAge != -1 && pl.get(i).getAge() > maxAge){
				pl.remove(i);
				removeCounter++;
				
			//position: 0 = stehen; 1 = sitzen; 2 = liegen
			}else if(position != 1 && pl.get(i).getPosition() != position){
				pl.remove(i);
				removeCounter++;
			}
			
			i -= removeCounter;
		}
		
		return pl.size();
		
	}


	public boolean removeParsedInformation() {
		this.personList.removeAllElements();
		this.crowdDetected = false;
		
		return true;
	}
	
	public String getSummaryString(){
		if (this.personList.isEmpty()) {
			return "[:-(] I didn't find some people.";
		}else{
			String sum;
			if (this.personList.size() == 1) {
				sum = "[:-)] I found one person!";
				if (this.personList.get(0).getGender() == 0) {
					sum += " He is male.";
				}else if (this.personList.get(0).getGender() == 1){
					sum += " She is female.";
				}else{
					sum += " I'm not sure what the gender of this person is.";
				}
				
				if (this.personList.get(0).getAge() == -1) {
					sum += " I was not able to get the age.";
				}else{
					sum += " I think the person is approximately" + this.personList.get(0).getAge() + " years old.";
				}
				
				if (this.personList.get(0).getPosition() == 0) {
					sum += " The person is standing.";
				}else if (this.personList.get(0).getPosition() == 1){
					sum += " The person is sitting.";
				}else if(this.personList.get(0).getPosition() == 2){
					sum += " The person is lying.";
				}
			}else{
				sum = "[:-)] I found " + this.personList.size() + " persons!";
				
				int male = 0;
				int female = 0;
				int unknownGender = 0;
				int standing = 0;
				int sitting = 0;
				int lying = 0;
				//int unknownPos = 0;
				int young = 0;
				int middleAged = 0;
				int old = 0;
				int unknownAge = 0;
				
				for (PersonCrowd person : personList) {
					if(person.getGender() == -1){unknownGender++;}
					if(person.getGender() == 0){male++;}
					if(person.getGender() == 1){female++;}
					
					if(person.getAge() == -1){unknownAge++;}
					if(person.getAge() > 0 && person.getAge() < 25){young++;}
					if(person.getAge() > 24 && person.getAge() < 55){middleAged++;}
					if(person.getAge() > 54){old++;}
					
					if(person.getPosition() == 0){standing++;}
					if(person.getPosition() == 1){sitting++;}
					if(person.getPosition() == 2){lying++;}
				}
				
				if (female == 1) {
						sum += " One person is female.";
				}else if (female > 1){
					sum += " " + female + " of them are female.";
				}
				
				if (male == 1) {
					sum += " One person is male.";
				}else if (male > 1){
					sum += " " + male + " of them are male.";
				}
				
				if (unknownGender == 1) {
					sum += " For one person I was not able to get the gender.";
				}else if (unknownGender > 1){
					sum += " For " + unknownGender + " persons I was not able to get the gender.";
				}
				
				
				if (young == 1) {
						sum += " One person is young.";
				}else if (young > 1){
					sum += " " + young + " of the people are young.";
				}
				
				if (middleAged == 1) {
					sum += " One person is middle aged.";
				}else if (middleAged > 1){
					sum += " " + middleAged + " of the people are middle aged.";
				}
				
				if (old == 1) {
					sum += " One person seems old.";
				}else if (old > 1){
					sum += " " + old + " of the people seem old.";
				}
				
				if (unknownAge == 1) {
					sum += " For one person I was not able to detect the age.";
				}else if (unknownAge > 1){
					sum += " For " + unknownAge + " persons I was not able to detect the age.";
				}
				
				
				if (standing == 1) {
						sum += " One person is standing.";
				}else if (standing > 1){
					sum += " " + standing + " of the persons are standing.";
				}
				
				if (sitting == 1) {
					sum += " One person is stitting.";
				}else if (sitting > 1){
					sum += " " + sitting + " of the persons are sitting.";
				}
				
				if (lying == 1) {
					sum += " One person is lying.";
				}else if (lying > 1){
					sum += " " + lying + " of the persons are lying.";
				}
			}
			
			
				
			
			return sum;
		
		}
	}
}
