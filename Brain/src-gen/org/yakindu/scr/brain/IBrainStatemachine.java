package org.yakindu.scr.brain;
import org.yakindu.scr.IStatemachine;
import org.yakindu.scr.ITimerCallback;

public interface IBrainStatemachine extends ITimerCallback, IStatemachine {

	public interface SCIUdpInterface {
		public String getMessage();
		public void setMessage(String value);

		public void setSCIUdpInterfaceOperationCallback(SCIUdpInterfaceOperationCallback operationCallback);
	}

	public interface SCIUdpInterfaceOperationCallback {
		public void receive();
		public void parseString();
		public void sendToHBrain_TTS(String inText);
		public void sendToHBrain_TTSWithPos(String inPos, String inText);
		public void sendToHBrain_PersonPosition();
		public void sendToKinect2_detectionOnOff(boolean inOnOff);
		public void sendToLeapMotion_detectionOnOff(boolean inOnOff);
		public void sendToSTT_detectionOnOff(boolean inOnOff);
	}

	public SCIUdpInterface getSCIUdpInterface();

	public interface SCIACIface_stat {
		public long getFaceID();
		public void setFaceID(long value);
		public long getConfidence();
		public void setConfidence(long value);
		public long getAge();
		public void setAge(long value);
		public boolean getGender();
		public void setGender(boolean value);
		public long getEthnicty();
		public void setEthnicty(long value);
		public boolean getGlasses();
		public void setGlasses(boolean value);
		public long getAttractiveness();
		public void setAttractiveness(long value);

	}

	public SCIACIface_stat getSCIACIface_stat();

	public interface SCIACIface_dyn {
		public long getHeadGestures();
		public void setHeadGestures(long value);
		public boolean getSpeaking();
		public void setSpeaking(boolean value);
		public String getEmotions();
		public void setEmotions(String value);
		public long getDistance();
		public void setDistance(long value);

	}

	public SCIACIface_dyn getSCIACIface_dyn();

	public interface SCIPerson {
		public long getPersonID();
		public void setPersonID(long value);
		public String getACIface();
		public void setACIface(String value);
		public String getFirstname();
		public void setFirstname(String value);
		public String getLastname();
		public void setLastname(String value);
		public long getBdDay();
		public void setBdDay(long value);
		public long getBdMounth();
		public void setBdMounth(long value);
		public long getBdYear();
		public void setBdYear(long value);
		public boolean getGender();
		public void setGender(boolean value);
		public long getEthnic();
		public void setEthnic(long value);
		public boolean getGlasses();
		public void setGlasses(boolean value);
		public long getAttractiveness();
		public void setAttractiveness(long value);

	}

	public SCIPerson getSCIPerson();

	public interface SCIAci {
		public long getCountFoundFaces();
		public void setCountFoundFaces(long value);

	}

	public SCIAci getSCIAci();

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

	}

	public SCIScitosRemoteControl getSCIScitosRemoteControl();

	public interface SCIOpenDail {
		public String getSpeakerMsg();
		public void setSpeakerMsg(String value);
		public String getLeonieMsg();
		public void setLeonieMsg(String value);

	}

	public SCIOpenDail getSCIOpenDail();

	public interface SCIMira {
		public boolean getRandMove();
		public void setRandMove(boolean value);

	}

	public SCIMira getSCIMira();

	public interface SCIFaceAnimation {
		public String getEmotion();
		public void setEmotion(String value);

	}

	public SCIFaceAnimation getSCIFaceAnimation();

}
