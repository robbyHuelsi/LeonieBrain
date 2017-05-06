package org.yakindu.scr.openchallenge;

import org.yakindu.scr.IStatemachine;
import org.yakindu.scr.ITimerCallback;

public interface IOpenChallengeStatemachine extends ITimerCallback,IStatemachine {

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
	
	public interface SCIAttractiveness {
	
		public void raiseAttractivenessDetected();
		
		public void raiseNoFaceFound();
		
		public double getAttTemp();
		
		public void setAttTemp(double value);
		
		public void setSCIAttractivenessOperationCallback(SCIAttractivenessOperationCallback operationCallback);
	
	}
	
	public interface SCIAttractivenessOperationCallback {
	
		public void sendToAttr_estimate();
		
		public double getAttractiveness();
		
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
		
		public void raiseActionReceived();
		
		public void raiseAnswerReceived();
		
		public void setSCISTTOperationCallback(SCISTTOperationCallback operationCallback);
	
	}
	
	public interface SCISTTOperationCallback {
	
		public String getSpokenText();
		
		public String getAnswer();
		
		public String getInstruction();
		
		public String getObject();
		
		public void sendSpeechDetectionOff();
		
		public void sendSpeechDetectionSmalltalk();
		
		public void sendSpeechDetectionYesNo();
		
		public void sendSpeechDetectionName();
		
	}
	
	public SCISTT getSCISTT();
	
}
