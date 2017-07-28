package org.yakindu.scr.test_facerecognition;

import org.yakindu.scr.IStatemachine;
import org.yakindu.scr.ITimerCallback;

public interface ITest_FaceRecognitionStatemachine extends ITimerCallback,IStatemachine {

	public interface SCIBGF {
	
		public long getEventNum();
		
		public void setEventNum(long value);
		
		public long getRandNum();
		
		public void setRandNum(long value);
		
		public void setSCIBGFOperationCallback(SCIBGFOperationCallback operationCallback);
	
	}
	
	public interface SCIBGFOperationCallback {
	
		public void printToConsole(String msg);
		
		public String intToString(long inInt);
		
		public long getRandNum(long max);
		
		public long getGWPByName(String inName);
		
		public boolean containsString(String main, String check);
		
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
	
		public void raisePersonDetected();
		
		public void raiseNoiseDeviatinWithoutBoneDetected();
		
		public void raiseNoiseWithBoneDetected();
		
		public void raiseWavingDetected();
		
		public void setSCIKinect2OperationCallback(SCIKinect2OperationCallback operationCallback);
	
	}
	
	public interface SCIKinect2OperationCallback {
	
		public long getNoiseAngle();
		
		public double getWavingX();
		
		public double getWavingY();
		
		public void sendNoiseDetectionOnOff(boolean inOnOff);
		
		public void sendWavingDetectionOnOff(boolean inOnOff);
		
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
		
		public void sendGoToPhi(long angle);
		
		public void sendSearchOnOff(boolean inOnOff);
		
		public void sendPanCamera(long inPan);
		
		public void sendTiltCamera(long inTilt);
		
		public void sendPanTiltCamera(long inPan, long inTilt);
		
		public void sendSaveRuntimeStartPoint();
		
		public void sendSaveRuntimeEndPoint();
		
		public void sendGoToRuntimeEndPoint();
		
	}
	
	public SCIMira getSCIMira();
	
	public interface SCISTT {
	
		public void raiseSpokenTextReceived();
		
		public void raiseIncomprehensible();
		
		public void raiseAnswerReceived();
		
		public void raiseActionReceived();
		
		public void raiseActionsReceived();
		
		public void setSCISTTOperationCallback(SCISTTOperationCallback operationCallback);
	
	}
	
	public interface SCISTTOperationCallback {
	
		public String getSpokenText();
		
		public String getAnswer();
		
		public String getInstruction();
		
		public String getObject();
		
		public long getActionListLength();
		
		public String getInstructionFromActionListAt(long i);
		
		public String getObjectFromActionListAt(long i);
		
		public String getLocationFromActionListAt(long i);
		
		public String getAllActionCommandsSentence();
		
		public String getSingleActionCommandSentence(long i);
		
		public void sendSpeechDetectionSmalltalk(long timeout);
		
		public void sendSpeechDetectionYesNo(long timeout);
		
		public void sendSpeechDetectionName(long timeout);
		
		public void sendSpeechDetectionActions(long timeout);
		
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
	
}
