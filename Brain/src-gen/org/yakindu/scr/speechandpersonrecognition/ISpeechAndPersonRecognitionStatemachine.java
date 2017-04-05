package org.yakindu.scr.speechandpersonrecognition;

import org.yakindu.scr.IStatemachine;
import org.yakindu.scr.ITimerCallback;

public interface ISpeechAndPersonRecognitionStatemachine extends ITimerCallback,IStatemachine {

	public interface SCInterface {
	
	}
	
	public SCInterface getSCInterface();
	
	public interface SCIHBrain {
	
		public boolean getTTSReady();
		
		public void setTTSReady(boolean value);
		
		public boolean getTTSFinished();
		
		public void setTTSFinished(boolean value);
		
	}
	
	public SCIHBrain getSCIHBrain();
	
	public interface SCIUdpInterface {
	
		public void raiseReady();
		
		public void raiseTurnAroundFinished();
		
		public void setSCIUdpInterfaceOperationCallback(SCIUdpInterfaceOperationCallback operationCallback);
	
	}
	
	public interface SCIUdpInterfaceOperationCallback {
	
		public void receive(long connection);
		
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
	
}
