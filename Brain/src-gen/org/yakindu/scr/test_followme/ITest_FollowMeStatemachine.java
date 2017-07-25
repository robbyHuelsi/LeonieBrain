package org.yakindu.scr.test_followme;

import org.yakindu.scr.IStatemachine;
import org.yakindu.scr.ITimerCallback;

public interface ITest_FollowMeStatemachine extends ITimerCallback,IStatemachine {

	public interface SCIFollowMe {
	
		public void raiseDetectionPersonFound();
		
		public void raiseTrackingPersonLost();
		
		public void raiseObstacleDetected();
		
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
	
}
