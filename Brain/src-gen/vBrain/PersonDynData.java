package vBrain;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

import main.Start;


public class PersonDynData implements Serializable {

	private Date dateAdded;
	private int headgesture;
	private boolean speaking;
	private int emotion;
	private float distance;
	
	
	public PersonDynData(){
		this.dateAdded = Calendar.getInstance().getTime();
	}
	
	public PersonDynData(int inHeadgesture, boolean inSpeaking, int inEmotions, float inDistance, Start inStart){
		this();
		
		this.setHeadgesture(inHeadgesture, inStart);
		this.setSpeaking(inSpeaking, inStart);
		this.setEmotion(inEmotions, inStart);
		this.setDistance(inDistance, inStart);
	}
	
	public PersonDynData(String attributeData, Start inStart){
		this();
		
		String[] attributeParts = attributeData.split(";");
		this.setHeadgesture(Integer.parseInt(attributeParts[2]), inStart);
		this.setSpeaking(Boolean.valueOf(attributeParts[3]), inStart);
		this.setEmotion(Integer.parseInt(attributeParts[4]), inStart);
		this.setDistance(Float.parseFloat(attributeParts[5]), inStart);
		
	}
	 

	public int getHeadgesture() {
		return headgesture;
	}

	public void setHeadgesture(int headgesture, Start inStart) {
		this.headgesture = headgesture;
		
		if(inStart != null){
			//TODO: inB.getSCICurrPerson().setCurrHeadgestures(headgesture);
			//TODO: inB.getSCIVBrain().setNessesaryToSavePersonList(true);
		}
	}

	public boolean isSpeaking() {
		return speaking;
	}

	public void setSpeaking(boolean speaking, Start inStart) {
		this.speaking = speaking;
		
		if(inStart != null){
			//TODO: inB.getSCICurrPerson().setCurrSpeaking(speaking);
			//TODO: inB.getSCIVBrain().setNessesaryToSavePersonList(true);
		}
	}

	public int getEmotion() {
		return emotion;
	}

	public void setEmotion(int emotion, Start inStart) {
		this.emotion = emotion;
		
		if(inStart != null){
			//TODO: inB.getSCICurrPerson().setCurrEmotion(emotion);
			//TODO: inB.getSCIVBrain().setNessesaryToSavePersonList(true);
			System.out.println("Emotion set");
		}
		
	}

	public float getDistance() {
		return distance;
	}

	public void setDistance(float distance, Start inStart) {
		this.distance = distance;
		
		if(inStart != null){
			//TODO: inB.getSCICurrPerson().setCurrDistance(distance);
			//TODO: inB.getSCIVBrain().setNessesaryToSavePersonList(true);
		}
	}

	public Date getDateAdded() {
		return dateAdded;
	}

	public String toString() {
		return "PersonDynData [" + (dateAdded!=null?"dateAdded=" + dateAdded.toString() + ", ":"") + "headgesture=" + headgesture + ", speaking=" + speaking + ", emotion=" + emotion + ", distance=" + distance + "]";
	}
	
	
}
