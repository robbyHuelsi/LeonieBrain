package org.yakindu.scr.test_noise;

import org.yakindu.scr.IStatemachine;

public interface ITest_NoiseStatemachine extends IStatemachine {

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
	
}
