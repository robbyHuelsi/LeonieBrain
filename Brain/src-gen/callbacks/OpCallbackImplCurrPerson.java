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
		personList.setCurrPerson(null);
	}


	@Override
	public long getPersonID() {
		return personList.getCurrPerson().getPersonID();
	}


	@Override
	public boolean isKnown() {
		return personList.getCurrPerson().isKnown();
	}


	@Override
	public String getFirstname() {
		return personList.getCurrPerson().getFirstName();
	}


	@Override
	public String getLastname() {
		return personList.getCurrPerson().getLastName();
	}


	@Override
	public long getEstimatedAge() {
		return personList.getCurrPerson().getEstimatedAge();
	}


	@Override
	public long getBdYear() {
		return personList.getCurrPerson().getBdYear();
	}


	@Override
	public long getBdMounth() {
		return personList.getCurrPerson().getBdMonth();
	}


	@Override
	public long getBdDay() {
		return personList.getCurrPerson().getBdDay();
	}


	@Override
	public boolean getGender() {
		return personList.getCurrPerson().getGender();
	}


	@Override
	public long getEthnicity() {
		return personList.getCurrPerson().getEthnicity();
	}


	@Override
	public boolean hasGlasses() {
		return personList.getCurrPerson().hasGlasses();
	}


	@Override
	public double getAttractiveness() {
		return personList.getCurrPerson().getAttractiveness();
	}


	@Override
	public long getCurrHeadgestures() {
		return personList.getCurrPerson().getCurrDynData().getHeadgesture();
	}


	@Override
	public boolean isCurrSpeaking() {
		return personList.getCurrPerson().getCurrDynData().isSpeaking();
	}


	@Override
	public long getCurrEmotion() {
		return personList.getCurrPerson().getCurrDynData().getEmotion();
	}


	@Override
	public double getCurrDistance() {
		return personList.getCurrPerson().getCurrDynData().getDistance();
	}


	@Override
	public void resetCurrEmotion() {
		personList.getCurrPerson().getCurrDynData().setEmotion(-1, Start.instanceOf());
	}

}
