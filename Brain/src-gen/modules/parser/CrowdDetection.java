package modules.parser;

import java.io.Serializable;
import java.util.ArrayList;

import Persons.PersonCrowd;
import main.Start;
import modules.Module;

public class CrowdDetection implements IParser, Serializable{
	private static final long serialVersionUID = 1L;
	private Start start;
	
	// Parsed information
	private int countTotal = 0;
	private int countFemale = 0;
	private int countMale = 0;
	private int countUnder21 = 0;
	private int ageSum = 0;
	private int ageAverage = 0;
	private int standing = 0;
	private int sitting = 0;
	private int lying = 0;
	
	private ArrayList<PersonCrowd> crowdList = new ArrayList<>();
	
	private boolean crowdDetected;

	public boolean parse(String data, Start start) {
		/*	#sender#total#gender1;age1;position1+gender2;age2;position2+ etc. #
			sendername: “crowd”
			total: Gesamtanzahl
			gender: 0=male ; 1=female
		 */
		
		this.start = start;
		
		//TODO Muss getestet werden
		
		String[] crowd = data.split("#");
		//if people detected
		if (crowd[0]!=null) {
			this.setCountTotal(Integer.parseInt(crowd[0]));
			
			String[] people = crowd[1].split("+");
			
			for(int counter=1; counter<=this.getCountTotal(); counter++){
				String[] p = people[counter].split(";");

				int gender=Integer.parseInt(p[0]);
				int age=Integer.parseInt(p[1]);
				int position=Integer.parseInt(p[2]);
				PersonCrowd person = new PersonCrowd(gender, age, position);
				crowdList.add(person);
			}
		}	
	
		return true;
	}

	
	public void setAttributes(){
		for( PersonCrowd k: crowdList )
		{
			//gender: 0=male ; 1=female ; -1=not detectable
			if(k.getGender()==0){
				setCountMale(getCountMale()+1);
			}
			else if(k.getGender()==1){
				setCountFemale(getCountFemale()+1);
			}
			//age
			if(k.getAge()>=0){
				setAgeSum(getAgeSum()+k.getAge());
			}
			if(k.getAge()<21){
				setCountUnder21(getCountUnder21()+1);
			}
			//position  0:stehen, 1=sitzen, 2=liegen
			if(k.getPosition()==0){
				setStanding(getStanding()+1);
			}
			else if(k.getPosition()==1){
				setSitting(getSitting()+1);
			}
			else if(k.getPosition()==2){
				setLying(getLying()+1);
			}
		}
		//age average
		setAgeAverage(getAgeSum() / getCountTotal());
	}
	
	
	public int getAgeAverage() {
		return ageAverage;
	}


	public void setAgeAverage(int ageAverage) {
		this.ageAverage = ageAverage;
	}


	public int getStanding() {
		return standing;
	}


	public void setStanding(int standing) {
		this.standing = standing;
	}


	public int getSitting() {
		return sitting;
	}


	public void setSitting(int sitting) {
		this.sitting = sitting;
	}


	public int getLying() {
		return lying;
	}


	public void setLying(int lying) {
		this.lying = lying;
	}


	public int getAgeSum() {
		return ageSum;
	}


	public void setAgeSum(int sumAge) {
		this.ageSum = sumAge;
	}


	public int getCountTotal() {
		return countTotal;
	}

	public void setCountTotal(int countTotal) {
		this.countTotal = countTotal;
	}

	public int getCountFemale() {
		return countFemale;
	}

	public void setCountFemale(int countFemale) {
		this.countFemale = countFemale;
	}

	public int getCountMale() {
		return countMale;
	}

	public void setCountMale(int countMale) {
		this.countMale = countMale;
	}

	public int getCountUnder21() {
		return countUnder21;
	}

	public void setCountUnder21(int countUnder21) {
		this.countUnder21 = countUnder21;
	}

	public boolean isCrowdDetected() {
		return crowdDetected;
	}


	public void setCrowdDetected(boolean crowdDetected) {
		this.crowdDetected = crowdDetected;
		
		if (crowdDetected) {
			//TODO implement raiseCrowdDetected
		}
	}


	public boolean removeParsedInformation() {
		this.countTotal = -1;
		this.countFemale = -1;
		this.countMale = -1;
		this.countUnder21 = -1;
		this.ageSum = -1;
		this.ageAverage = -1;
		this.standing = -1;
		this.sitting = -1;
		this.lying = -1;
		this.crowdList = new ArrayList<>();
		this.crowdDetected = false;
		
		return true;
	}

}
