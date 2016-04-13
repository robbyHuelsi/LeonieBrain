package vbrain;

import java.time.LocalDateTime;

import org.yakindu.scr.brain.BrainStatemachine;

public class PersonDynData {
	
	private BrainStatemachine brain;

	private LocalDateTime dateAdded;
	private int headgesture;
	private boolean speaking;
	private int emotion;
	private float distance;
	
	
	public PersonDynData(){
		this.dateAdded = LocalDateTime.now();
	}
	
	public PersonDynData(BrainStatemachine inBrain){
		this.brain = inBrain;
	}
	
	public PersonDynData(BrainStatemachine inBrain, int inHeadgesture, boolean inSpeaking, int inEmotions, float inDistance){
		this.brain = inBrain;
		
		this.headgesture = inHeadgesture;
		this.speaking = inSpeaking;
		this.emotion = inEmotions;
		this.distance = inDistance;
	}
	
	public PersonDynData(BrainStatemachine inBrain, String attributeData){
		this.brain = inBrain;
		
		String[] attributeParts = attributeData.split(";");
		this.headgesture = Integer.parseInt(attributeParts[2]);
		this.speaking = Boolean.valueOf(attributeParts[3]);
		this.emotion = Integer.parseInt(attributeParts[4]);
		this.distance = Float.parseFloat(attributeParts[5]);
		
	}

	public int getHeadgesture() {
		return headgesture;
	}

	public void setHeadgesture(int headgesture) {
		this.headgesture = headgesture;
		
		if(brain != null){
			brain.getSCICurrPerson().setCurrHeadgestures(headgesture);
		}
	}

	public boolean isSpeaking() {
		return speaking;
	}

	public void setSpeaking(boolean speaking) {
		this.speaking = speaking;
		
		if(brain != null){
			brain.getSCICurrPerson().setCurrSpeaking(speaking);
		}
	}

	public int getEmotion() {
		return emotion;
	}

	public void setEmotion(int emotion) {
		this.emotion = emotion;
		
		if(brain != null){
			brain.getSCICurrPerson().setCurrEmotion(emotion);
		}
	}

	public float getDistance() {
		return distance;
	}

	public void setDistance(float distance) {
		this.distance = distance;
		
		if(brain != null){
			brain.getSCICurrPerson().setCurrDistance(distance);
		}
	}

	public LocalDateTime getDateAdded() {
		return dateAdded;
	}
}
