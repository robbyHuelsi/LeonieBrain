package org.yakindu.scr.helpmecarry;

import org.yakindu.scr.IStatemachine;
import org.yakindu.scr.ITimerCallback;

public interface IHelpMeCarryStatemachine extends ITimerCallback,IStatemachine {

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
	
	public interface SCIKinect2 {
	
		public void raisePersonDetected();
		
		public void raiseNoiseDetected();
		
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
	
	public interface SCIFollowMe {
	
		public void raiseDetectionPersonFound();
		
		public void raiseTrackingPersonLost();
		
		public void setSCIFollowMeOperationCallback(SCIFollowMeOperationCallback operationCallback);
	
	}
	
	public interface SCIFollowMeOperationCallback {
	
		public void sendDetectionOff();
		
		public void sendDetectionOn();
		
		public void sendRequestDetectionDetails();
		
		public void sendTrackingOff();
		
		public void sendTrackingOnAtPos(long x, long y);
		
		public void sendTrackingOnAtNext();
		
		public long getNextPersonXPos();
		
		public long getNextpersonYPos();
		
	}
	
	public SCIFollowMe getSCIFollowMe();
	
}
