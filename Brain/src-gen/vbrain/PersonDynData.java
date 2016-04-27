package vbrain;

import java.time.LocalDateTime;

import org.yakindu.scr.brain.BrainStatemachine;

public class PersonDynData {

	private LocalDateTime dateAdded;
	private int headgesture;
	private boolean speaking;
	private int emotion;
	private float distance;
	
	
	public PersonDynData(){
		this.dateAdded = LocalDateTime.now();
	}
	
	public PersonDynData(BrainStatemachine inB, int inHeadgesture, boolean inSpeaking, int inEmotions, float inDistance){
		
		this.setHeadgesture(inHeadgesture, inB);
		this.setSpeaking(inSpeaking, inB);
		this.setEmotion(inEmotions, inB);
		this.setDistance(inDistance, inB);
	}
	
	public PersonDynData(BrainStatemachine inB, String attributeData){
		
		String[] attributeParts = attributeData.split(";");
		this.setHeadgesture(Integer.parseInt(attributeParts[2]), inB);
		this.setSpeaking(Boolean.valueOf(attributeParts[3]), inB);
		this.setEmotion(Integer.parseInt(attributeParts[4]), inB);
		this.setDistance(Float.parseFloat(attributeParts[5]), inB);
		
	}
	 

	public int getHeadgesture() {
		return headgesture;
	}

	public void setHeadgesture(int headgesture, BrainStatemachine inB) {
		this.headgesture = headgesture;
		
		if(inB != null){
			inB.getSCICurrPerson().setCurrHeadgestures(headgesture);
		}
	}

	public boolean isSpeaking() {
		return speaking;
	}

	public void setSpeaking(boolean speaking, BrainStatemachine inB) {
		this.speaking = speaking;
		
		if(inB != null){
			inB.getSCICurrPerson().setCurrSpeaking(speaking);
		}
	}

	public int getEmotion() {
		return emotion;
	}

	public void setEmotion(int emotion, BrainStatemachine inB) {
		this.emotion = emotion;
		
		if(inB != null){
			inB.getSCICurrPerson().setCurrEmotion(emotion);
		}
	}

	public float getDistance() {
		return distance;
	}

	public void setDistance(float distance, BrainStatemachine inB) {
		this.distance = distance;
		
		if(inB != null){
			inB.getSCICurrPerson().setCurrDistance(distance);
		}
	}

	public LocalDateTime getDateAdded() {
		return dateAdded;
	}

	@Override
	public String toString() {
		return "PersonDynData [dateAdded=" + dateAdded + ", headgesture=" + headgesture + ", speaking=" + speaking + ", emotion=" + emotion + ", distance=" + distance + "]";
	}
	
	
}
