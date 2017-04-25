package modules.parser;

import java.io.Serializable;
import java.util.Vector;

import Persons.PersonCrowd;
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
		String[] datas = data.split("#");
		String[] crowd = datas[1].split("//+");
			
		for(int i = 0; i < crowd.length; i++){
			String[] person = crowd[i].split(";");
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
			this.setCrowdDetected(true);
			return true;
		}else{
			System.out.println("There is not the same number of Persons in personList (" + personList.size() + ") like total count (" + total + ")");
			return false;
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
		/*if (this.objList.isEmpty()) {
			return "[:-(] I didn't found objects.";
		}else{
			String sum = "[:-)] I found " + this.objList.size() + " objects!";
			Vector<Objects.object> ol = this.objList;
			while (!ol.isEmpty()) {
				String oName = ol.get(0).getName();
				int oCount = 0;
				for (int i = 0; i < ol.size(); i++) {
					if (ol.get(i).equals(oName)) {
						oCount++;
						ol.remove(i);
						i--;
					}
				}
				if (oCount == 1) {
					sum += " There is one " + oName + ".";
				}else{
					sum += " There are " + oCount + " times " + oName + ".";
				}
				
			}
			return sum;
		
		}*/
		return null;
	}
}
