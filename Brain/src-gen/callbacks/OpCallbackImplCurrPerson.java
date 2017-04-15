package callbacks;

import main.Start;
import vBrain.PersonList;

public class OpCallbackImplCurrPerson implements
	org.yakindu.scr.braganca.IBragancaStatemachine.SCICurrPersonOperationCallback,
	org.yakindu.scr.speechandpersonrecognition.ISpeechAndPersonRecognitionStatemachine.SCICurrPersonOperationCallback
{
	
	private PersonList personList = Start.getPersonList();
	
	public void setKnown(boolean inKnown) {
		if(personList.getCurrPerson() != null){
			personList.getCurrPerson().setKnown(inKnown, Start.instanceOf());
		}
	}

	
	public void setFirstname(String inFirstname) {
		if(personList.getCurrPerson() != null){
			personList.getCurrPerson().setFirstName(inFirstname, Start.instanceOf());
		}	
	}

	
	public void setLastname(String inLastname) {
		if(personList.getCurrPerson() != null){
			personList.getCurrPerson().setLastName(inLastname, Start.instanceOf());
		}		
	}

	
	public void setBdYear(long inBdYear) {
		if(personList.getCurrPerson() != null){
			personList.getCurrPerson().setBdYear((int)inBdYear, Start.instanceOf());
		}			
	}

	
	public void setBdMounth(long inBdMointh) {
		if(personList.getCurrPerson() != null){
			personList.getCurrPerson().setBdMonth((int)inBdMointh, Start.instanceOf());
		}	
	}

	
	public void setBdDay(long inBdDay) {
		if(personList.getCurrPerson() != null){
			personList.getCurrPerson().setBdDay((int)inBdDay, Start.instanceOf());
		}			
	}

	
	public void setGender(boolean inGender) {
		if(personList.getCurrPerson() != null){
			personList.getCurrPerson().setGender(inGender, Start.instanceOf());
		}	
	}

	
	public void setEthnicity(long inEthnicity) {
		if(personList.getCurrPerson() != null){
			personList.getCurrPerson().setEthnicity((int)inEthnicity, Start.instanceOf());
		}			
	}
	
	public void setAttractiveness(double inAttr) {
		if(personList.getCurrPerson() != null){
			personList.getCurrPerson().setAttractiveness((int)inAttr, Start.instanceOf());
		}	
	}

	public void resetCurrPerson() {
		personList.setCurrPerson(null, Start.instanceOf());
	}


	public long getPersonID() {
		if(personList.getCurrPerson() != null){
			return personList.getCurrPerson().getPersonID();
		}else{
			System.err.println("No current person");
			return -1;
		}
	}


	public boolean isKnown() {
		if(personList.getCurrPerson() != null){
			return personList.getCurrPerson().isKnown();
		}else{
			System.err.println("No current person");
			return false;
		}
	}


	public String getFirstname() {
		if(personList.getCurrPerson() != null){
			return personList.getCurrPerson().getFirstName();
		}else{
			System.err.println("No current person");
			return "";
		}
	}	


	public String getLastname() {
		if(personList.getCurrPerson() != null){
			return personList.getCurrPerson().getLastName();
		}else{
			System.err.println("No current person");
			return "";
		}
	}


	public long getEstimatedAge() {
		if(personList.getCurrPerson() != null){
			return personList.getCurrPerson().getEstimatedAge();
		}else{
			System.err.println("No current person");
			return -1;
		}
	}


	public long getBdYear() {
		if(personList.getCurrPerson() != null){
			return personList.getCurrPerson().getBdYear();
		}else{
			System.err.println("No current person");
			return -1;
		}
	}


	public long getBdMounth() {
		if(personList.getCurrPerson() != null){
			return personList.getCurrPerson().getBdMonth();
		}else{
			System.err.println("No current person");
			return -1;
		}
	}


	public long getBdDay() {
		if(personList.getCurrPerson() != null){
			return personList.getCurrPerson().getBdDay();
		}else{
			System.err.println("No current person");
			return -1;
		}
	}


	public boolean getGender() {
		if(personList.getCurrPerson() != null){
			return personList.getCurrPerson().getGender();
		}else{
			System.err.println("No current person");
			return false;
		}
	}


	public long getEthnicity() {
		if(personList.getCurrPerson() != null){
			return personList.getCurrPerson().getEthnicity();
		}else{
			System.err.println("No current person");
			return -1;
		}
	}


	public boolean hasGlasses() {
		if(personList.getCurrPerson() != null){
			return personList.getCurrPerson().hasGlasses();
		}else{
			System.err.println("No current person");
			return false;
		}
	}


	public double getAttractiveness() {
		if(personList.getCurrPerson() != null){
			return personList.getCurrPerson().getAttractiveness();
		}else{
			System.err.println("No current person");
			return -1;
		}
	}


	public long getCurrHeadgestures() {
		if(personList.getCurrPerson() != null){
			return personList.getCurrPerson().getCurrDynData().getHeadgesture();
		}else{
			System.err.println("No current person");
			return -1;
		}
	}


	public boolean isCurrSpeaking() {
		if(personList.getCurrPerson() != null){
			return personList.getCurrPerson().getCurrDynData().isSpeaking();
		}else{
			System.err.println("No current person");
			return false;
		}
	}


	public long getCurrEmotion() {
		if(personList.getCurrPerson() != null){
			return personList.getCurrPerson().getCurrDynData().getEmotion();
		}else{
			System.err.println("No current person");
			return -1;
		}
	}


	public double getCurrDistance() {
		if(personList.getCurrPerson() != null){
			return personList.getCurrPerson().getCurrDynData().getDistance();
		}else{
			System.err.println("No current person");
			return -1;
		}
	}


	public void resetCurrEmotion() {
		if(personList.getCurrPerson() != null){
			personList.getCurrPerson().getCurrDynData().setEmotion(-1, Start.instanceOf());
		}
	}

}
