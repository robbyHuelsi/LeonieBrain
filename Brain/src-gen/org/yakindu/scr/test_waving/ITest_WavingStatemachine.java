package org.yakindu.scr.test_waving;

import org.yakindu.scr.IStatemachine;
import org.yakindu.scr.ITimerCallback;

public interface ITest_WavingStatemachine extends ITimerCallback,IStatemachine {

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
