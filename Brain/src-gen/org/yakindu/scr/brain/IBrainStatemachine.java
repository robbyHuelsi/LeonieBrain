package org.yakindu.scr.brain;

import org.yakindu.scr.IStatemachine;
import org.yakindu.scr.ITimerCallback;

public interface IBrainStatemachine extends ITimerCallback,IStatemachine {

	public interface SCIBGF {
	
		public long getEventNum();
		
		public void setEventNum(long value);
		
		public long getRandNum();
		
		public void setRandNum(long value);
		
		public void setSCIBGFOperationCallback(SCIBGFOperationCallback operationCallback);
	
	}
	
	public interface SCIBGFOperationCallback {
	
		public void printToConsole(String msg);
		
		public void newRandNum(long max);
		
	}
	
	public SCIBGF getSCIBGF();
	
	public interface SCIUdpInterface {
	
		public void setSCIUdpInterfaceOperationCallback(SCIUdpInterfaceOperationCallback operationCallback);
	
	}
	
	public interface SCIUdpInterfaceOperationCallback {
	
		public void receive();
		
		public void sendToVBrain_ACIonOff(boolean inOnOff);
		
		public void sendToHBrain_TTS(String inText);
		
		public void sendToHBrain_TTS2(String inT1, String inT2);
		
		public void sendToHBrain_TTS3(String inT1, String inT2, String inT3);
		
		public void sendToHBrain_TTS_num(long inNum);
		
		public void sendToHBrain_TTSWithPos(String inPos, String inText);
		
		public void sendToHBrain_PersonPosition();
		
		public void sendToKinect2_detectionOnOff(boolean inOnOff);
		
		public void sendToLeapMotion_detectionOnOff(long inOnOff);
		
		public void sendToSTT_detectionOnOff(long inOnOff);
		
		public void sendToNav_goToGWP(long inWayPoint);
		
		public void sendToNav_goToNextGWPForConf();
		
		public void sendToNav_turnBody(String inAngle);
		
		public void sendToNav_bodyUTurn();
		
		public void sendToNav_turnHead(String inAngle);
		
		public void sendToNav_goToLC(String inX, String inY);
		
		public void sendToNav_searchOnOff(boolean inOnOff);
		
	}
	
	public SCIUdpInterface getSCIUdpInterface();
	
	public interface SCIVBrain {
	
		public long getCountFoundFaces();
		
		public void setCountFoundFaces(long value);
		
		public boolean getNessesaryToSavePersonList();
		
		public void setNessesaryToSavePersonList(boolean value);
		
		public void setSCIVBrainOperationCallback(SCIVBrainOperationCallback operationCallback);
	
	}
	
	public interface SCIVBrainOperationCallback {
	
		public void savePersonList();
		
	}
	
	public SCIVBrain getSCIVBrain();
	
	public interface SCICurrPerson {
	
		public long getPersonID();
		
		public void setPersonID(long value);
		
		public boolean getKnown();
		
		public void setKnown(boolean value);
		
		public String getFirstname();
		
		public void setFirstname(String value);
		
		public String getLastname();
		
		public void setLastname(String value);
		
		public long getEstimatedAge();
		
		public void setEstimatedAge(long value);
		
		public long getBdYear();
		
		public void setBdYear(long value);
		
		public long getBdMounth();
		
		public void setBdMounth(long value);
		
		public long getBdDay();
		
		public void setBdDay(long value);
		
		public boolean getGender();
		
		public void setGender(boolean value);
		
		public long getEthnicity();
		
		public void setEthnicity(long value);
		
		public boolean getGlasses();
		
		public void setGlasses(boolean value);
		
		public double getAttractiveness();
		
		public void setAttractiveness(double value);
		
		public long getCurrHeadgestures();
		
		public void setCurrHeadgestures(long value);
		
		public boolean getCurrSpeaking();
		
		public void setCurrSpeaking(boolean value);
		
		public long getCurrEmotion();
		
		public void setCurrEmotion(long value);
		
		public double getCurrDistance();
		
		public void setCurrDistance(double value);
		
		public void setSCICurrPersonOperationCallback(SCICurrPersonOperationCallback operationCallback);
	
	}
	
	public interface SCICurrPersonOperationCallback {
	
		public void resetCurrPerson();
		
		public void setKnown(boolean inKnown);
		
		public void setFirstname(String inFirstname);
		
		public void setLastname(String inLastname);
		
		public void setBdYear(long inBdYear);
		
		public void setBdMounth(long inBdMointh);
		
		public void setBdDay(long inBdDay);
		
		public void setGender(boolean inGender);
		
		public void setEthnicity(long inEthnicity);
		
		public void setAttractiveness(double attr);
		
	}
	
	public SCICurrPerson getSCICurrPerson();
	
	public interface SCIAtt {
	
		public double getOld_attr();
		
		public void setOld_attr(double value);
		
		public void setSCIAttOperationCallback(SCIAttOperationCallback operationCallback);
	
	}
	
	public interface SCIAttOperationCallback {
	
		public void sendToAttr_estimate();
		
		public void setOldAttr();
		
	}
	
	public SCIAtt getSCIAtt();
	
	public interface SCIHBrain {
	
		public boolean getTTSReady();
		
		public void setTTSReady(boolean value);
		
	}
	
	public SCIHBrain getSCIHBrain();
	
	public interface SCIKinect2 {
	
		public String getGesture();
		
		public void setGesture(String value);
		
		public boolean getNoiseDetected();
		
		public void setNoiseDetected(boolean value);
		
		public long getNoiseAngle();
		
		public void setNoiseAngle(long value);
		
	}
	
	public SCIKinect2 getSCIKinect2();
	
	public interface SCILeapMotion {
	
		public boolean getGestureDetected();
		
		public void setGestureDetected(boolean value);
		
		public String getGesture();
		
		public void setGesture(String value);
		
		public boolean getStringFinished();
		
		public void setStringFinished(boolean value);
		
		public String getDetectedString();
		
		public void setDetectedString(String value);
		
	}
	
	public SCILeapMotion getSCILeapMotion();
	
	public interface SCIScitosRemoteControl {
	
		public boolean getEmergencyStop();
		
		public void setEmergencyStop(boolean value);
		
		public boolean getBumpered();
		
		public void setBumpered(boolean value);
		
		public boolean getBlocked();
		
		public void setBlocked(boolean value);
		
		public boolean getArrivedWP();
		
		public void setArrivedWP(boolean value);
		
	}
	
	public SCIScitosRemoteControl getSCIScitosRemoteControl();
	
	public interface SCISTT {
	
		public boolean getSTTReady();
		
		public void setSTTReady(boolean value);
		
		public String getSpeakerMsg();
		
		public void setSpeakerMsg(String value);
		
		public String getFilteredMsg();
		
		public void setFilteredMsg(String value);
		
		public String getFilterBubble();
		
		public void setFilterBubble(String value);
		
	}
	
	public SCISTT getSCISTT();
	
	public interface SCIFaceAnimation {
	
		public String getEmotion();
		
		public void setEmotion(String value);
		
	}
	
	public SCIFaceAnimation getSCIFaceAnimation();
	
}
