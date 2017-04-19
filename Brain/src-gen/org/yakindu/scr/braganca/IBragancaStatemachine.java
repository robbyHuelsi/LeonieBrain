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
		
		public long getRandNum(long max);
		
	}
	
	public SCIBGF getSCIBGF();
	
	public interface SCIHBrain {
	
		public void raiseTTSReady();
		
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
	
		public void setSCIVBrainOperationCallback(SCIVBrainOperationCallback operationCallback);
	
	}
	
	public interface SCIVBrainOperationCallback {
	
		public long getCountFoundFaces();
		
		public void resetCountFoundFaces();
		
		public boolean isNessesaryToSavePersonList();
		
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
		
	}
	
	public SCIAttractiveness getSCIAttractiveness();
	
	public interface SCIKinect2 {
	
		public void raiseNoiseDetected();
		
		public void setSCIKinect2OperationCallback(SCIKinect2OperationCallback operationCallback);
	
	}
	
	public interface SCIKinect2OperationCallback {
	
		public String getGesture();
		
		public long getNoiseAngle();
		
		public void sendNoiseDetectionOnOff(boolean inOnOff);
		
	}
	
	public SCIKinect2 getSCIKinect2();
	
	public interface SCILeapMotion {
	
		public void raiseGestureDetected();
		
		public void raiseStringFinished();
		
		public void setSCILeapMotionOperationCallback(SCILeapMotionOperationCallback operationCallback);
	
	}
	
	public interface SCILeapMotionOperationCallback {
	
		public String getGesture();
		
		public void resetGesture();
		
		public String getDetectedString();
		
		public void resetDetectedString();
		
		public void sendGestureDetectionOnOff(long inOnOff);
		
	}
	
	public SCILeapMotion getSCILeapMotion();
	
	public interface SCIMira {
	
		public void raiseEmergencyStop();
		
		public void raiseBumpered();
		
		public void raiseBlocked();
		
		public void raiseArrivedWP();
		
		public void setSCIMiraOperationCallback(SCIMiraOperationCallback operationCallback);
	
	}
	
	public interface SCIMiraOperationCallback {
	
		public void sendGoToGWP(long inWayPoint);
		
		public void sendGoToNextGWPForConf();
		
		public void sendTurnBody(long inAngle);
		
		public void sendBodyUTurn();
		
		public void sendTurnHead(long inAngle);
		
		public void sendGoToLC(long inX, long inY);
		
		public void sendSearchOnOff(boolean inOnOff);
		
	}
	
	public SCIMira getSCIMira();
	
	public interface SCISTT {
	
		public void raiseTextReceived();
		
		public void raiseIncomprehensible();
		
		public void raiseActionReceived();
		
		public void setSCISTTOperationCallback(SCISTTOperationCallback operationCallback);
	
	}
	
	public interface SCISTTOperationCallback {
	
		public String getText();
		
		public String getInstruction();
		
		public String getObject();
		
		public void sendSpeechDetectionOff();
		
		public void sendSpeechDetectionSmalltalk();
		
		public void sendSpeechDetectionYesNo();
		
		public void sendSpeechDetectionName();
		
	}
	
	public SCISTT getSCISTT();
	
	public interface SCICurrPerson {
	
		public void setSCICurrPersonOperationCallback(SCICurrPersonOperationCallback operationCallback);
	
	}
	
	public interface SCICurrPersonOperationCallback {
	
		public long getPersonID();
		
		public boolean isKnown();
		
		public String getFirstname();
		
		public String getLastname();
		
		public long getEstimatedAge();
		
		public long getBdYear();
		
		public long getBdMounth();
		
		public long getBdDay();
		
		public boolean getGender();
		
		public long getEthnicity();
		
		public boolean hasGlasses();
		
		public double getAttractiveness();
		
		public long getCurrHeadgestures();
		
		public boolean isCurrSpeaking();
		
		public long getCurrEmotion();
		
		public double getCurrDistance();
		
		public void resetCurrPerson();
		
		public void resetCurrEmotion();
		
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
	
	public interface SCICrowdDetection {
	
		public void setSCICrowdDetectionOperationCallback(SCICrowdDetectionOperationCallback operationCallback);
	
	}
	
	public interface SCICrowdDetectionOperationCallback {
	
		public void detectionOnOff(boolean onOff);
		
	}
	
	public SCICrowdDetection getSCICrowdDetection();
	
	public interface SCIMicrophoneArray {
	
		public void setSCIMicrophoneArrayOperationCallback(SCIMicrophoneArrayOperationCallback operationCallback);
	
	}
	
	public interface SCIMicrophoneArrayOperationCallback {
	
		public long getNoiseAngle();
		
		public void detectionOnOff(boolean onOff);
		
	}
	
	public SCIMicrophoneArray getSCIMicrophoneArray();
	
}
