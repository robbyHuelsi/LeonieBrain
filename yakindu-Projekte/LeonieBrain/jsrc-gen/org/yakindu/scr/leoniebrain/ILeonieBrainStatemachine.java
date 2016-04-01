package org.yakindu.scr.leoniebrain;
import org.yakindu.scr.IStatemachine;
import org.yakindu.scr.ITimerCallback;

public interface ILeonieBrainStatemachine extends ITimerCallback, IStatemachine {

	public interface SCIACIface_stat {
		public String getFaceID();
		public void setFaceID(String value);
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

	public interface SCIAci {
		public long getCountFoundFaces();
		public void setCountFoundFaces(long value);

	}

	public SCIAci getSCIAci();

	public interface SCIKinect {
		public String getGeste();
		public void setGeste(String value);

	}

	public SCIKinect getSCIKinect();

	public interface SCILeapMotion {
		public String getGeste();
		public void setGeste(String value);

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
