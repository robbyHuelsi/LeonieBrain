package org.yakindu.scr.braganca;

import org.yakindu.scr.IStatemachine;
import org.yakindu.scr.ITimerCallback;

public interface IBragancaStatemachine extends ITimerCallback,IStatemachine {

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
	
	public interface SCIHBrain {
	
		public boolean getTTSReady();
		
		public void setTTSReady(boolean value);
		
		public void setSCIHBrainOperationCallback(SCIHBrainOperationCallback operationCallback);
	
	}
	
	public interface SCIHBrainOperationCallback {
	
		public void sendTTS(String inText);
		
		public void sendTTS2(String inT1, String inT2);
		
		public void sendTTS3(String inT1, String inT2, String inT3);
		
		public void sendTTS_num(long inNum);
		
		public void sendTTSWithPos(String inPos, String inText);
		
		public void sendPersonPosition();
		
	}
	
	public SCIHBrain getSCIHBrain();
	
	public interface SCIVBrain {
	
		public long getCountFoundFaces();
		
		public void setCountFoundFaces(long value);
		
		public boolean getNessesaryToSavePersonList();
		
		public void setNessesaryToSavePersonList(boolean value);
		
		public void setSCIVBrainOperationCallback(SCIVBrainOperationCallback operationCallback);
	
	}
	
	public interface SCIVBrainOperationCallback {
	
		public void sendACIOnOff(boolean inOnOff);
		
		public void savePersonList();
		
	}
	
	public SCIVBrain getSCIVBrain();
	
	public interface SCIAttractiveness {
	
		public double getOld_attr();
		
		public void setOld_attr(double value);
		
		public void setSCIAttractivenessOperationCallback(SCIAttractivenessOperationCallback operationCallback);
	
	}
	
	public interface SCIAttractivenessOperationCallback {
	
		public void sendToAttr_estimate();
		
		public void setOldAttr();
		
	}
	
	public SCIAttractiveness getSCIAttractiveness();
	
	public interface SCIKinect2 {
	
		public String getGesture();
		
		public void setGesture(String value);
		
		public boolean getNoiseDetected();
		
		public void setNoiseDetected(boolean value);
		
		public long getNoiseAngle();
		
		public void setNoiseAngle(long value);
		
		public void setSCIKinect2OperationCallback(SCIKinect2OperationCallback operationCallback);
	
	}
	
	public interface SCIKinect2OperationCallback {
	
		public void sendNoiseDetectionOnOff(boolean inOnOff);
		
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
		
		public void setSCILeapMotionOperationCallback(SCILeapMotionOperationCallback operationCallback);
	
	}
	
	public interface SCILeapMotionOperationCallback {
	
		public void sendGestureDetectionOnOff(long inOnOff);
		
	}
	
	public SCILeapMotion getSCILeapMotion();
	
	public interface SCIMira {
	
		public boolean getEmergencyStop();
		
		public void setEmergencyStop(boolean value);
		
		public boolean getBumpered();
		
		public void setBumpered(boolean value);
		
		public boolean getBlocked();
		
		public void setBlocked(boolean value);
		
		public boolean getArrivedWP();
		
		public void setArrivedWP(boolean value);
		
		public void setSCIMiraOperationCallback(SCIMiraOperationCallback operationCallback);
	
	}
	
	public interface SCIMiraOperationCallback {
	
		public void sendGoToGWP(long inWayPoint);
		
		public void sendGoToNextGWPForConf();
		
		public void sendTurnBody(String inAngle);
		
		public void sendBodyUTurn();
		
		public void sendTurnHead(String inAngle);
		
		public void sendGoToLC(String inX, String inY);
		
		public void sendSearchOnOff(boolean inOnOff);
		
	}
	
	public SCIMira getSCIMira();
	
	public interface SCISTT {
	
		public boolean getSTTReady();
		
		public void setSTTReady(boolean value);
		
		public String getSpeakerMsg();
		
		public void setSpeakerMsg(String value);
		
		public String getFilteredMsg();
		
		public void setFilteredMsg(String value);
		
		public String getFilterBubble();
		
		public void setFilterBubble(String value);
		
		public void setSCISTTOperationCallback(SCISTTOperationCallback operationCallback);
	
	}
	
	public interface SCISTTOperationCallback {
	
		public void sendSpeechDetectionOnOff(long inOnOff);
		
	}
	
	public SCISTT getSCISTT();
	
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
	
}
