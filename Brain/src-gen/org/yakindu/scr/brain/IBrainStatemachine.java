package org.yakindu.scr.brain;
import org.yakindu.scr.IStatemachine;
import org.yakindu.scr.ITimerCallback;

public interface IBrainStatemachine extends ITimerCallback, IStatemachine {

	public interface SCIBGF {
		public long getRandNum();
		public void setRandNum(long value);

		public void setSCIBGFOperationCallback(SCIBGFOperationCallback operationCallback);
	}

	public interface SCIBGFOperationCallback {
		public void printToConsole(String msg);
		public void newRandNum(long max);
	}

	public SCIBGF getSCIBGF();

	public interface SCIUdpInterface {

		public void setSCIUdpInterfaceOperationCallback(SCIUdpInterfaceOperationCallback operationCallback);
	}

	public interface SCIUdpInterfaceOperationCallback {
		public void receive();
		public void sendToVBrain_ACIonOff(boolean inOnOff);
		public void sendToHBrain_TTS(String inText);
		public void sendToHBrain_TTS2(String inT1, String inT2);
		public void sendToHBrain_TTS3(String inT1, String inT2, String inT3);
		public void sendToHBrain_TTSWithPos(String inPos, String inText);
		public void sendToHBrain_PersonPosition();
		public void sendToKinect2_detectionOnOff(boolean inOnOff);
		public void sendToLeapMotion_detectionOnOff(boolean inOnOff);
		public void sendToSTT_detectionOnOff(boolean inOnOff);
		public void sendToNav_goToGWP(String inWayPoint);
		public void sendToNav_goToLC(String inX, String inY);
		public void sendToNav_searchOnOff(boolean inOnOff);
	}

	public SCIUdpInterface getSCIUdpInterface();

	public interface SCIVBrain {
		public long getCountFoundFaces();
		public void setCountFoundFaces(long value);

	}

	public SCIVBrain getSCIVBrain();

	public interface SCICurrPerson {
		public long getId();
		public void setId(long value);
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
		public void setKnown(boolean inKnown);
		public void setFirstname(String inFirstname);
		public void setLastname(String inLastname);
		public void setBdYear(long inBdYear);
		public void setBdMounth(long inBdMointh);
		public void setBdDay(long inBdDay);
		public void setGender(boolean inGender);
		public void setEthnicity(long inEthnicity);
	}

	public SCICurrPerson getSCICurrPerson();

	public interface SCIHBrain {
		public boolean getTTSReady();
		public void setTTSReady(boolean value);

	}

	public SCIHBrain getSCIHBrain();

	public interface SCIKinect2 {
		public String getGesture();
		public void setGesture(String value);
		public boolean getNoiseDetected();
		public void setNoiseDetected(boolean value);
		public String getNoiseAngle();
		public void setNoiseAngle(String value);

	}

	public SCIKinect2 getSCIKinect2();

	public interface SCILeapMotion {
		public boolean getGestureDetected();
		public void setGestureDetected(boolean value);
		public String getGesture();
		public void setGesture(String value);

	}

	public SCILeapMotion getSCILeapMotion();

	public interface SCIScitosRemoteControl {
		public boolean getEmergencyStop();
		public void setEmergencyStop(boolean value);
		public boolean getBumpered();
		public void setBumpered(boolean value);
		public boolean getBlocked();
		public void setBlocked(boolean value);
		public boolean getArrivedWP();
		public void setArrivedWP(boolean value);

	}

	public SCIScitosRemoteControl getSCIScitosRemoteControl();

	public interface SCIOpenDail {
		public String getSpeakerMsg();
		public void setSpeakerMsg(String value);
		public String getLeonieMsg();
		public void setLeonieMsg(String value);

	}

	public SCIOpenDail getSCIOpenDail();

	public interface SCISTT {
		public boolean getSTTready();
		public void setSTTready(boolean value);
		public String getSpeakerMsg();
		public void setSpeakerMsg(String value);
		public String getFilteredMsg();
		public void setFilteredMsg(String value);

		public void setSCISTTOperationCallback(SCISTTOperationCallback operationCallback);
	}

	public interface SCISTTOperationCallback {
		public void filter(String filterString);
	}

	public SCISTT getSCISTT();

	public interface SCIFaceAnimation {
		public String getEmotion();
		public void setEmotion(String value);

	}

	public SCIFaceAnimation getSCIFaceAnimation();

}
