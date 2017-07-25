package org.yakindu.scr.storinggroceries;

import org.yakindu.scr.IStatemachine;
import org.yakindu.scr.ITimerCallback;

public interface IStoringGroceriesStatemachine extends ITimerCallback,IStatemachine {

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
		
		public void sendInterrupt();
		
	}
	
	public SCIMira getSCIMira();
	
	public interface SCIObjectDetection {
	
		public void raiseReady();
		
		public void raiseAnalyseDone();
		
		public void raiseObjectDetected();
		
		public void setSCIObjectDetectionOperationCallback(SCIObjectDetectionOperationCallback operationCallback);
	
	}
	
	public interface SCIObjectDetectionOperationCallback {
	
		public void sendPing();
		
		public void sendAnalyseCupboard();
		
		public void sendAnalyseTable();
		
		public void sendPrintPDF();
		
		public String getSummaryText();
		
		public String getNewesObject();
		
	}
	
	public SCIObjectDetection getSCIObjectDetection();
	
}
