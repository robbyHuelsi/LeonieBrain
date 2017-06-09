package Persons;

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
	
	public PersonDynData(int inHeadgesture, boolean inSpeaking, int inEmotion, float inDistance){
		this();
		
		this.headgesture = inHeadgesture;
		this.speaking = inSpeaking;
		this.emotion = inEmotion;
		this.distance = inDistance;
	}
	
	public PersonDynData(String attributeData){
		this();
		
		String[] attributeParts = attributeData.split(";");
		this.headgesture = Integer.parseInt(attributeParts[2]);
		this.speaking = Boolean.valueOf(attributeParts[3]);
		this.emotion = Integer.parseInt(attributeParts[4]);
		this.distance = Float.parseFloat(attributeParts[5]);
	}
	 

	public int getHeadgesture() {
		return headgesture;
	}

	public void setHeadgesture(int headgesture, Start inStart) {
		if(inStart != null && this.headgesture != headgesture){
			this.headgesture = headgesture;
			inStart.getPersonList().save();
		}
	}

	public boolean isSpeaking() {
		return speaking;
	}

	public void setSpeaking(boolean speaking, Start inStart) {
		if(inStart != null && this.speaking != speaking){
			this.speaking = speaking;
			inStart.getPersonList().save();
		}
	}

	public int getEmotion() {
		return emotion;
	}

	public void setEmotion(int emotion, Start inStart) {
		System.out.println("Emotion set");
		if(inStart != null && this.emotion != emotion){
			this.emotion = emotion;
			inStart.getPersonList().save();
		}
		
	}

	public float getDistance() {
		return distance;
	}

	public void setDistance(float distance, Start inStart) {
		if(inStart != null && this.distance != distance){
			this.distance = distance;
			inStart.getPersonList().save();
		}
	}

	public Date getDateAdded() {
		return dateAdded;
	}

	public String toString() {
		return "PersonDynData [" + (dateAdded!=null?"dateAdded=" + dateAdded.toString() + ", ":"") + "headgesture=" + headgesture + ", speaking=" + speaking + ", emotion=" + emotion + ", distance=" + distance + "]";
	}
	
	
}
