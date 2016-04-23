package org.yakindu.scr.brain;
import org.yakindu.scr.ITimer;

public class BrainStatemachine implements IBrainStatemachine {

	protected class SCIBGFImpl implements SCIBGF {

		private SCIBGFOperationCallback operationCallback;

		public void setSCIBGFOperationCallback(SCIBGFOperationCallback operationCallback) {
			this.operationCallback = operationCallback;
		}

		private long randNum;

		public long getRandNum() {
			return randNum;
		}

		public void setRandNum(long value) {
			this.randNum = value;
		}

	}

	protected SCIBGFImpl sCIBGF;

	protected class SCIUdpInterfaceImpl implements SCIUdpInterface {

		private SCIUdpInterfaceOperationCallback operationCallback;

		public void setSCIUdpInterfaceOperationCallback(SCIUdpInterfaceOperationCallback operationCallback) {
			this.operationCallback = operationCallback;
		}

	}

	protected SCIUdpInterfaceImpl sCIUdpInterface;

	protected class SCIVBrainImpl implements SCIVBrain {

		private long countFoundFaces;

		public long getCountFoundFaces() {
			return countFoundFaces;
		}

		public void setCountFoundFaces(long value) {
			this.countFoundFaces = value;
		}

	}

	protected SCIVBrainImpl sCIVBrain;

	protected class SCICurrPersonImpl implements SCICurrPerson {

		private SCICurrPersonOperationCallback operationCallback;

		public void setSCICurrPersonOperationCallback(SCICurrPersonOperationCallback operationCallback) {
			this.operationCallback = operationCallback;
		}

		private long id;

		public long getId() {
			return id;
		}

		public void setId(long value) {
			this.id = value;
		}

		private boolean known;

		public boolean getKnown() {
			return known;
		}

		public void setKnown(boolean value) {
			this.known = value;
		}

		private String firstname;

		public String getFirstname() {
			return firstname;
		}

		public void setFirstname(String value) {
			this.firstname = value;
		}

		private String lastname;

		public String getLastname() {
			return lastname;
		}

		public void setLastname(String value) {
			this.lastname = value;
		}

		private long estimatedAge;

		public long getEstimatedAge() {
			return estimatedAge;
		}

		public void setEstimatedAge(long value) {
			this.estimatedAge = value;
		}

		private long bdYear;

		public long getBdYear() {
			return bdYear;
		}

		public void setBdYear(long value) {
			this.bdYear = value;
		}

		private long bdMounth;

		public long getBdMounth() {
			return bdMounth;
		}

		public void setBdMounth(long value) {
			this.bdMounth = value;
		}

		private long bdDay;

		public long getBdDay() {
			return bdDay;
		}

		public void setBdDay(long value) {
			this.bdDay = value;
		}

		private boolean gender;

		public boolean getGender() {
			return gender;
		}

		public void setGender(boolean value) {
			this.gender = value;
		}

		private long ethnicity;

		public long getEthnicity() {
			return ethnicity;
		}

		public void setEthnicity(long value) {
			this.ethnicity = value;
		}

		private boolean glasses;

		public boolean getGlasses() {
			return glasses;
		}

		public void setGlasses(boolean value) {
			this.glasses = value;
		}

		private double attractiveness;

		public double getAttractiveness() {
			return attractiveness;
		}

		public void setAttractiveness(double value) {
			this.attractiveness = value;
		}

		private long currHeadgestures;

		public long getCurrHeadgestures() {
			return currHeadgestures;
		}

		public void setCurrHeadgestures(long value) {
			this.currHeadgestures = value;
		}

		private boolean currSpeaking;

		public boolean getCurrSpeaking() {
			return currSpeaking;
		}

		public void setCurrSpeaking(boolean value) {
			this.currSpeaking = value;
		}

		private long currEmotion;

		public long getCurrEmotion() {
			return currEmotion;
		}

		public void setCurrEmotion(long value) {
			this.currEmotion = value;
		}

		private double currDistance;

		public double getCurrDistance() {
			return currDistance;
		}

		public void setCurrDistance(double value) {
			this.currDistance = value;
		}

	}

	protected SCICurrPersonImpl sCICurrPerson;

	protected class SCIHBrainImpl implements SCIHBrain {

		private boolean tTSReady;

		public boolean getTTSReady() {
			return tTSReady;
		}

		public void setTTSReady(boolean value) {
			this.tTSReady = value;
		}

	}

	protected SCIHBrainImpl sCIHBrain;

	protected class SCIKinect2Impl implements SCIKinect2 {

		private String gesture;

		public String getGesture() {
			return gesture;
		}

		public void setGesture(String value) {
			this.gesture = value;
		}

		private boolean noiseDetected;

		public boolean getNoiseDetected() {
			return noiseDetected;
		}

		public void setNoiseDetected(boolean value) {
			this.noiseDetected = value;
		}

		private long noiseAngle;

		public long getNoiseAngle() {
			return noiseAngle;
		}

		public void setNoiseAngle(long value) {
			this.noiseAngle = value;
		}

	}

	protected SCIKinect2Impl sCIKinect2;

	protected class SCILeapMotionImpl implements SCILeapMotion {

		private boolean gestureDetected;

		public boolean getGestureDetected() {
			return gestureDetected;
		}

		public void setGestureDetected(boolean value) {
			this.gestureDetected = value;
		}

		private String gesture;

		public String getGesture() {
			return gesture;
		}

		public void setGesture(String value) {
			this.gesture = value;
		}

	}

	protected SCILeapMotionImpl sCILeapMotion;

	protected class SCIScitosRemoteControlImpl implements SCIScitosRemoteControl {

		private boolean emergencyStop;

		public boolean getEmergencyStop() {
			return emergencyStop;
		}

		public void setEmergencyStop(boolean value) {
			this.emergencyStop = value;
		}

		private boolean bumpered;

		public boolean getBumpered() {
			return bumpered;
		}

		public void setBumpered(boolean value) {
			this.bumpered = value;
		}

		private boolean blocked;

		public boolean getBlocked() {
			return blocked;
		}

		public void setBlocked(boolean value) {
			this.blocked = value;
		}

		private boolean arrivedWP;

		public boolean getArrivedWP() {
			return arrivedWP;
		}

		public void setArrivedWP(boolean value) {
			this.arrivedWP = value;
		}

	}

	protected SCIScitosRemoteControlImpl sCIScitosRemoteControl;

	protected class SCIOpenDailImpl implements SCIOpenDail {

		private String speakerMsg;

		public String getSpeakerMsg() {
			return speakerMsg;
		}

		public void setSpeakerMsg(String value) {
			this.speakerMsg = value;
		}

		private String leonieMsg;

		public String getLeonieMsg() {
			return leonieMsg;
		}

		public void setLeonieMsg(String value) {
			this.leonieMsg = value;
		}

	}

	protected SCIOpenDailImpl sCIOpenDail;

	protected class SCISTTImpl implements SCISTT {

		private SCISTTOperationCallback operationCallback;

		public void setSCISTTOperationCallback(SCISTTOperationCallback operationCallback) {
			this.operationCallback = operationCallback;
		}

		private boolean sTTready;

		public boolean getSTTready() {
			return sTTready;
		}

		public void setSTTready(boolean value) {
			this.sTTready = value;
		}

		private String speakerMsg;

		public String getSpeakerMsg() {
			return speakerMsg;
		}

		public void setSpeakerMsg(String value) {
			this.speakerMsg = value;
		}

		private String filteredMsg;

		public String getFilteredMsg() {
			return filteredMsg;
		}

		public void setFilteredMsg(String value) {
			this.filteredMsg = value;
		}

	}

	protected SCISTTImpl sCISTT;

	protected class SCIFaceAnimationImpl implements SCIFaceAnimation {

		private String emotion;

		public String getEmotion() {
			return emotion;
		}

		public void setEmotion(String value) {
			this.emotion = value;
		}

	}

	protected SCIFaceAnimationImpl sCIFaceAnimation;

	private boolean initialized = false;

	public enum State {
		mainBrain_Init, mainBrain_FaceDataInterpretation, mainBrain_FaceDataInterpretation_FaceDataInterpretation_PersonKnownWithName, mainBrain_FaceDataInterpretation_FaceDataInterpretation_UnknownGirl, mainBrain_FaceDataInterpretation_FaceDataInterpretation_PersonKnownWithoutName, mainBrain_FaceDataInterpretation_FaceDataInterpretation_UnknownFemaleTeen, mainBrain_FaceDataInterpretation_FaceDataInterpretation_UnknownWomen, mainBrain_FaceDataInterpretation_FaceDataInterpretation_UnknownBoy, mainBrain_FaceDataInterpretation_FaceDataInterpretation_UnknownMaleTeen, mainBrain_FaceDataInterpretation_FaceDataInterpretation_UnknownMen, mainBrain_FaceDataInterpretation_FaceDataInterpretation_Greetings_KnownPerson, mainBrain_FaceDataInterpretation_FaceDataInterpretation_Greetings_UnknownPerson, mainBrain_FaceDataInterpretation_FaceDataInterpretation_Greetings_KnownPersonWithoutName, mainBrain_FaceDataInterpretation_FaceDataInterpretation_AboutRobotica_1, mainBrain_FaceDataInterpretation_FaceDataInterpretation_AboutRobotica_2, mainBrain_FaceDataInterpretation_FaceDataInterpretation_RandomTopic_1, mainBrain_FaceDataInterpretation_FaceDataInterpretation_RandomTopic_2, mainBrain_FaceDataInterpretation_FaceDataInterpretation_Prompt_2, mainBrain_FaceDataInterpretation_FaceDataInterpretation_Prompt_1, mainBrain_FaceDataInterpretation_FaceDataInterpretation_AfterGreetings, mainBrain_FaceDataInterpretation_FaceDataInterpretation_Farewell_1, mainBrain_FaceDataInterpretation_FaceDataInterpretation_Farewell_2, mainBrain_FaceDataInterpretation_FaceDataInterpretation_Farewell_3, mainBrain_FaceDataInterpretation_FaceDataInterpretation_Farewell_4, mainBrain_FaceDataInterpretation_FaceDataInterpretation_Selection, mainBrain_FaceDataInterpretation_FaceDataInterpretation_Selection_1, mainBrain_FaceDataInterpretation_FaceDataInterpretation_RandomTopic_3, mainBrain_FaceDataInterpretation_FaceDataInterpretation_Selection_2, mainBrain_FaceDataInterpretation_FaceDataInterpretation_AlternativeConv_1, mainBrain_FaceDataInterpretation_FaceDataInterpretation_Selection_3, mainBrain_FaceDataInterpretation_FaceDataInterpretation__final_, mainBrain_FaceDataInterpretation_FaceDataInterpretation_STT_1, mainBrain_FaceDataInterpretation_FaceDataInterpretation_STT_2, mainBrain_FaceDataInterpretation_FaceDataInterpretation_RandomTopic_4, mainBrain_FaceDataInterpretation_FaceDataInterpretation_STT_3, mainBrain_FaceDataInterpretation_FaceDataInterpretation_STT_4, mainBrain_FaceDataInterpretation_FaceDataInterpretation_AlternativeConv_2, mainBrain_FaceDataInterpretation_FaceDataInterpretation_AboutRobotica_3, mainBrain_FaceDataInterpretation_FaceDataInterpretation_STT_5, mainBrain_FaceDataInterpretation_FaceDataInterpretation_AfterGreetings_2, mainBrain_FaceDataInterpretation_FaceDataInterpretation_Closing, mainBrain_FaceDataInterpretation_FaceDataInterpretation_STT_6, mainBrain_FaceDataInterpretation_FaceDataInterpretation_filter, mainBrain_FaceDataInterpretation_FaceDataInterpretation_filter_2, mainBrain_TurnToNoise, mainBrain_Idle, mainBrain_StopLeonie, mainBrain_SearchForChat, mainBrain_SearchForChat_SearchForChat_Standing, mainBrain_SearchForChat_SearchForChat_Walking, $NullState$
	};

	private final State[] stateVector = new State[1];

	private int nextStateIndex;

	private ITimer timer;

	private final boolean[] timeEvents = new boolean[9];

	private long t;

	protected void setT(long value) {
		t = value;
	}

	protected long getT() {
		return t;
	}

	public BrainStatemachine() {

		sCIBGF = new SCIBGFImpl();
		sCIUdpInterface = new SCIUdpInterfaceImpl();
		sCIVBrain = new SCIVBrainImpl();
		sCICurrPerson = new SCICurrPersonImpl();
		sCIHBrain = new SCIHBrainImpl();
		sCIKinect2 = new SCIKinect2Impl();
		sCILeapMotion = new SCILeapMotionImpl();
		sCIScitosRemoteControl = new SCIScitosRemoteControlImpl();
		sCIOpenDail = new SCIOpenDailImpl();
		sCISTT = new SCISTTImpl();
		sCIFaceAnimation = new SCIFaceAnimationImpl();
	}

	public void init() {
		this.initialized = true;
		if (timer == null) {
			throw new IllegalStateException("timer not set.");
		}
		for (int i = 0; i < 1; i++) {
			stateVector[i] = State.$NullState$;
		}

		clearEvents();
		clearOutEvents();

		sCIBGF.setRandNum(0);

		sCIVBrain.setCountFoundFaces(0);

		sCICurrPerson.setId(0);

		sCICurrPerson.setKnown(false);

		sCICurrPerson.setFirstname("");

		sCICurrPerson.setLastname("");

		sCICurrPerson.setEstimatedAge(0);

		sCICurrPerson.setBdYear(0);

		sCICurrPerson.setBdMounth(0);

		sCICurrPerson.setBdDay(0);

		sCICurrPerson.setGender(false);

		sCICurrPerson.setEthnicity(0);

		sCICurrPerson.setGlasses(false);

		sCICurrPerson.setAttractiveness(0.0);

		sCICurrPerson.setCurrHeadgestures(0);

		sCICurrPerson.setCurrSpeaking(false);

		sCICurrPerson.setCurrEmotion(0);

		sCICurrPerson.setCurrDistance(0.0);

		sCIHBrain.setTTSReady(false);

		sCIKinect2.setGesture("");

		sCIKinect2.setNoiseDetected(false);

		sCIKinect2.setNoiseAngle(0);

		sCILeapMotion.setGestureDetected(false);

		sCILeapMotion.setGesture("");

		sCIScitosRemoteControl.setEmergencyStop(false);

		sCIScitosRemoteControl.setBumpered(false);

		sCIScitosRemoteControl.setBlocked(false);

		sCIScitosRemoteControl.setArrivedWP(false);

		sCIOpenDail.setSpeakerMsg("");

		sCIOpenDail.setLeonieMsg("");

		sCISTT.setSTTready(false);

		sCISTT.setSpeakerMsg("");

		sCISTT.setFilteredMsg("");

		sCIFaceAnimation.setEmotion("");

		setT(0);
	}

	public void enter() {
		if (!initialized)
			throw new IllegalStateException(
					"The statemachine needs to be initialized first by calling the init() function.");

		if (timer == null) {
			throw new IllegalStateException("timer not set.");
		}
		enterSequence_MainBrain_default();
	}

	public void exit() {
		exitSequence_MainBrain();
	}

	/**
	 * @see IStatemachine#isActive()
	 */
	public boolean isActive() {

		return stateVector[0] != State.$NullState$;
	}

	/** 
	 * @see IStatemachine#isFinal() 
	 */
	public boolean isFinal() {
		return (stateVector[0] == State.mainBrain_FaceDataInterpretation_FaceDataInterpretation__final_);
	}

	/**
	* This method resets the incoming events (time events included).
	*/
	protected void clearEvents() {

		for (int i = 0; i < timeEvents.length; i++) {
			timeEvents[i] = false;
		}
	}

	/**
	* This method resets the outgoing events.
	*/
	protected void clearOutEvents() {
	}

	/**
	* Returns true if the given state is currently active otherwise false.
	*/
	public boolean isStateActive(State state) {
		switch (state) {
			case mainBrain_Init :
				return stateVector[0] == State.mainBrain_Init;
			case mainBrain_FaceDataInterpretation :
				return stateVector[0].ordinal() >= State.mainBrain_FaceDataInterpretation.ordinal() && stateVector[0]
						.ordinal() <= State.mainBrain_FaceDataInterpretation_FaceDataInterpretation_filter_2.ordinal();
			case mainBrain_FaceDataInterpretation_FaceDataInterpretation_PersonKnownWithName :
				return stateVector[0] == State.mainBrain_FaceDataInterpretation_FaceDataInterpretation_PersonKnownWithName;
			case mainBrain_FaceDataInterpretation_FaceDataInterpretation_UnknownGirl :
				return stateVector[0] == State.mainBrain_FaceDataInterpretation_FaceDataInterpretation_UnknownGirl;
			case mainBrain_FaceDataInterpretation_FaceDataInterpretation_PersonKnownWithoutName :
				return stateVector[0] == State.mainBrain_FaceDataInterpretation_FaceDataInterpretation_PersonKnownWithoutName;
			case mainBrain_FaceDataInterpretation_FaceDataInterpretation_UnknownFemaleTeen :
				return stateVector[0] == State.mainBrain_FaceDataInterpretation_FaceDataInterpretation_UnknownFemaleTeen;
			case mainBrain_FaceDataInterpretation_FaceDataInterpretation_UnknownWomen :
				return stateVector[0] == State.mainBrain_FaceDataInterpretation_FaceDataInterpretation_UnknownWomen;
			case mainBrain_FaceDataInterpretation_FaceDataInterpretation_UnknownBoy :
				return stateVector[0] == State.mainBrain_FaceDataInterpretation_FaceDataInterpretation_UnknownBoy;
			case mainBrain_FaceDataInterpretation_FaceDataInterpretation_UnknownMaleTeen :
				return stateVector[0] == State.mainBrain_FaceDataInterpretation_FaceDataInterpretation_UnknownMaleTeen;
			case mainBrain_FaceDataInterpretation_FaceDataInterpretation_UnknownMen :
				return stateVector[0] == State.mainBrain_FaceDataInterpretation_FaceDataInterpretation_UnknownMen;
			case mainBrain_FaceDataInterpretation_FaceDataInterpretation_Greetings_KnownPerson :
				return stateVector[0] == State.mainBrain_FaceDataInterpretation_FaceDataInterpretation_Greetings_KnownPerson;
			case mainBrain_FaceDataInterpretation_FaceDataInterpretation_Greetings_UnknownPerson :
				return stateVector[0] == State.mainBrain_FaceDataInterpretation_FaceDataInterpretation_Greetings_UnknownPerson;
			case mainBrain_FaceDataInterpretation_FaceDataInterpretation_Greetings_KnownPersonWithoutName :
				return stateVector[0] == State.mainBrain_FaceDataInterpretation_FaceDataInterpretation_Greetings_KnownPersonWithoutName;
			case mainBrain_FaceDataInterpretation_FaceDataInterpretation_AboutRobotica_1 :
				return stateVector[0] == State.mainBrain_FaceDataInterpretation_FaceDataInterpretation_AboutRobotica_1;
			case mainBrain_FaceDataInterpretation_FaceDataInterpretation_AboutRobotica_2 :
				return stateVector[0] == State.mainBrain_FaceDataInterpretation_FaceDataInterpretation_AboutRobotica_2;
			case mainBrain_FaceDataInterpretation_FaceDataInterpretation_RandomTopic_1 :
				return stateVector[0] == State.mainBrain_FaceDataInterpretation_FaceDataInterpretation_RandomTopic_1;
			case mainBrain_FaceDataInterpretation_FaceDataInterpretation_RandomTopic_2 :
				return stateVector[0] == State.mainBrain_FaceDataInterpretation_FaceDataInterpretation_RandomTopic_2;
			case mainBrain_FaceDataInterpretation_FaceDataInterpretation_Prompt_2 :
				return stateVector[0] == State.mainBrain_FaceDataInterpretation_FaceDataInterpretation_Prompt_2;
			case mainBrain_FaceDataInterpretation_FaceDataInterpretation_Prompt_1 :
				return stateVector[0] == State.mainBrain_FaceDataInterpretation_FaceDataInterpretation_Prompt_1;
			case mainBrain_FaceDataInterpretation_FaceDataInterpretation_AfterGreetings :
				return stateVector[0] == State.mainBrain_FaceDataInterpretation_FaceDataInterpretation_AfterGreetings;
			case mainBrain_FaceDataInterpretation_FaceDataInterpretation_Farewell_1 :
				return stateVector[0] == State.mainBrain_FaceDataInterpretation_FaceDataInterpretation_Farewell_1;
			case mainBrain_FaceDataInterpretation_FaceDataInterpretation_Farewell_2 :
				return stateVector[0] == State.mainBrain_FaceDataInterpretation_FaceDataInterpretation_Farewell_2;
			case mainBrain_FaceDataInterpretation_FaceDataInterpretation_Farewell_3 :
				return stateVector[0] == State.mainBrain_FaceDataInterpretation_FaceDataInterpretation_Farewell_3;
			case mainBrain_FaceDataInterpretation_FaceDataInterpretation_Farewell_4 :
				return stateVector[0] == State.mainBrain_FaceDataInterpretation_FaceDataInterpretation_Farewell_4;
			case mainBrain_FaceDataInterpretation_FaceDataInterpretation_Selection :
				return stateVector[0] == State.mainBrain_FaceDataInterpretation_FaceDataInterpretation_Selection;
			case mainBrain_FaceDataInterpretation_FaceDataInterpretation_Selection_1 :
				return stateVector[0] == State.mainBrain_FaceDataInterpretation_FaceDataInterpretation_Selection_1;
			case mainBrain_FaceDataInterpretation_FaceDataInterpretation_RandomTopic_3 :
				return stateVector[0] == State.mainBrain_FaceDataInterpretation_FaceDataInterpretation_RandomTopic_3;
			case mainBrain_FaceDataInterpretation_FaceDataInterpretation_Selection_2 :
				return stateVector[0] == State.mainBrain_FaceDataInterpretation_FaceDataInterpretation_Selection_2;
			case mainBrain_FaceDataInterpretation_FaceDataInterpretation_AlternativeConv_1 :
				return stateVector[0] == State.mainBrain_FaceDataInterpretation_FaceDataInterpretation_AlternativeConv_1;
			case mainBrain_FaceDataInterpretation_FaceDataInterpretation_Selection_3 :
				return stateVector[0] == State.mainBrain_FaceDataInterpretation_FaceDataInterpretation_Selection_3;
			case mainBrain_FaceDataInterpretation_FaceDataInterpretation__final_ :
				return stateVector[0] == State.mainBrain_FaceDataInterpretation_FaceDataInterpretation__final_;
			case mainBrain_FaceDataInterpretation_FaceDataInterpretation_STT_1 :
				return stateVector[0] == State.mainBrain_FaceDataInterpretation_FaceDataInterpretation_STT_1;
			case mainBrain_FaceDataInterpretation_FaceDataInterpretation_STT_2 :
				return stateVector[0] == State.mainBrain_FaceDataInterpretation_FaceDataInterpretation_STT_2;
			case mainBrain_FaceDataInterpretation_FaceDataInterpretation_RandomTopic_4 :
				return stateVector[0] == State.mainBrain_FaceDataInterpretation_FaceDataInterpretation_RandomTopic_4;
			case mainBrain_FaceDataInterpretation_FaceDataInterpretation_STT_3 :
				return stateVector[0] == State.mainBrain_FaceDataInterpretation_FaceDataInterpretation_STT_3;
			case mainBrain_FaceDataInterpretation_FaceDataInterpretation_STT_4 :
				return stateVector[0] == State.mainBrain_FaceDataInterpretation_FaceDataInterpretation_STT_4;
			case mainBrain_FaceDataInterpretation_FaceDataInterpretation_AlternativeConv_2 :
				return stateVector[0] == State.mainBrain_FaceDataInterpretation_FaceDataInterpretation_AlternativeConv_2;
			case mainBrain_FaceDataInterpretation_FaceDataInterpretation_AboutRobotica_3 :
				return stateVector[0] == State.mainBrain_FaceDataInterpretation_FaceDataInterpretation_AboutRobotica_3;
			case mainBrain_FaceDataInterpretation_FaceDataInterpretation_STT_5 :
				return stateVector[0] == State.mainBrain_FaceDataInterpretation_FaceDataInterpretation_STT_5;
			case mainBrain_FaceDataInterpretation_FaceDataInterpretation_AfterGreetings_2 :
				return stateVector[0] == State.mainBrain_FaceDataInterpretation_FaceDataInterpretation_AfterGreetings_2;
			case mainBrain_FaceDataInterpretation_FaceDataInterpretation_Closing :
				return stateVector[0] == State.mainBrain_FaceDataInterpretation_FaceDataInterpretation_Closing;
			case mainBrain_FaceDataInterpretation_FaceDataInterpretation_STT_6 :
				return stateVector[0] == State.mainBrain_FaceDataInterpretation_FaceDataInterpretation_STT_6;
			case mainBrain_FaceDataInterpretation_FaceDataInterpretation_filter :
				return stateVector[0] == State.mainBrain_FaceDataInterpretation_FaceDataInterpretation_filter;
			case mainBrain_FaceDataInterpretation_FaceDataInterpretation_filter_2 :
				return stateVector[0] == State.mainBrain_FaceDataInterpretation_FaceDataInterpretation_filter_2;
			case mainBrain_TurnToNoise :
				return stateVector[0] == State.mainBrain_TurnToNoise;
			case mainBrain_Idle :
				return stateVector[0] == State.mainBrain_Idle;
			case mainBrain_StopLeonie :
				return stateVector[0] == State.mainBrain_StopLeonie;
			case mainBrain_SearchForChat :
				return stateVector[0].ordinal() >= State.mainBrain_SearchForChat.ordinal()
						&& stateVector[0].ordinal() <= State.mainBrain_SearchForChat_SearchForChat_Walking.ordinal();
			case mainBrain_SearchForChat_SearchForChat_Standing :
				return stateVector[0] == State.mainBrain_SearchForChat_SearchForChat_Standing;
			case mainBrain_SearchForChat_SearchForChat_Walking :
				return stateVector[0] == State.mainBrain_SearchForChat_SearchForChat_Walking;
			default :
				return false;
		}
	}

	/**
	* Set the {@link ITimer} for the state machine. It must be set
	* externally on a timed state machine before a run cycle can be correct
	* executed.
	* 
	* @param timer
	*/
	public void setTimer(ITimer timer) {
		this.timer = timer;
	}

	/**
	* Returns the currently used timer.
	* 
	* @return {@link ITimer}
	*/
	public ITimer getTimer() {
		return timer;
	}

	public void timeElapsed(int eventID) {
		timeEvents[eventID] = true;
	}

	public SCIBGF getSCIBGF() {
		return sCIBGF;
	}
	public SCIUdpInterface getSCIUdpInterface() {
		return sCIUdpInterface;
	}
	public SCIVBrain getSCIVBrain() {
		return sCIVBrain;
	}
	public SCICurrPerson getSCICurrPerson() {
		return sCICurrPerson;
	}
	public SCIHBrain getSCIHBrain() {
		return sCIHBrain;
	}
	public SCIKinect2 getSCIKinect2() {
		return sCIKinect2;
	}
	public SCILeapMotion getSCILeapMotion() {
		return sCILeapMotion;
	}
	public SCIScitosRemoteControl getSCIScitosRemoteControl() {
		return sCIScitosRemoteControl;
	}
	public SCIOpenDail getSCIOpenDail() {
		return sCIOpenDail;
	}
	public SCISTT getSCISTT() {
		return sCISTT;
	}
	public SCIFaceAnimation getSCIFaceAnimation() {
		return sCIFaceAnimation;
	}

	private boolean check_MainBrain_Init_tr0_tr0() {
		return timeEvents[0];
	}

	private boolean check_MainBrain_Init_tr1_tr1() {
		return sCIVBrain.countFoundFaces > 0;
	}

	private boolean check_MainBrain_Init_tr2_tr2() {
		return sCIKinect2.noiseAngle < 0;
	}

	private boolean check_MainBrain_FaceDataInterpretation_tr0_tr0() {
		return 1 == 0;
	}

	private boolean check_MainBrain_FaceDataInterpretation_FaceDataInterpretation_PersonKnownWithName_tr0_tr0() {
		return true;
	}

	private boolean check_MainBrain_FaceDataInterpretation_FaceDataInterpretation_UnknownGirl_tr0_tr0() {
		return sCIHBrain.tTSReady == true;
	}

	private boolean check_MainBrain_FaceDataInterpretation_FaceDataInterpretation_PersonKnownWithoutName_tr0_tr0() {
		return true;
	}

	private boolean check_MainBrain_FaceDataInterpretation_FaceDataInterpretation_UnknownFemaleTeen_tr0_tr0() {
		return sCIHBrain.tTSReady == true;
	}

	private boolean check_MainBrain_FaceDataInterpretation_FaceDataInterpretation_UnknownWomen_tr0_tr0() {
		return sCIHBrain.tTSReady == true;
	}

	private boolean check_MainBrain_FaceDataInterpretation_FaceDataInterpretation_UnknownBoy_tr0_tr0() {
		return sCIHBrain.tTSReady == true;
	}

	private boolean check_MainBrain_FaceDataInterpretation_FaceDataInterpretation_UnknownMaleTeen_tr0_tr0() {
		return sCIHBrain.tTSReady == true;
	}

	private boolean check_MainBrain_FaceDataInterpretation_FaceDataInterpretation_UnknownMen_tr0_tr0() {
		return sCIHBrain.tTSReady == true;
	}

	private boolean check_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Greetings_KnownPerson_tr0_tr0() {
		return sCIHBrain.tTSReady == true;
	}

	private boolean check_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Greetings_UnknownPerson_tr0_tr0() {
		return sCIHBrain.tTSReady == true;
	}

	private boolean check_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Greetings_KnownPersonWithoutName_tr0_tr0() {
		return sCIHBrain.tTSReady == true;
	}

	private boolean check_MainBrain_FaceDataInterpretation_FaceDataInterpretation_AboutRobotica_1_tr0_tr0() {
		return sCIHBrain.tTSReady == true;
	}

	private boolean check_MainBrain_FaceDataInterpretation_FaceDataInterpretation_AboutRobotica_2_tr0_tr0() {
		return sCIHBrain.tTSReady == true;
	}

	private boolean check_MainBrain_FaceDataInterpretation_FaceDataInterpretation_RandomTopic_1_tr0_tr0() {
		return sCIHBrain.tTSReady == true;
	}

	private boolean check_MainBrain_FaceDataInterpretation_FaceDataInterpretation_RandomTopic_2_tr0_tr0() {
		return sCIHBrain.tTSReady == true;
	}

	private boolean check_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Prompt_2_tr0_tr0() {
		return sCIHBrain.tTSReady == true;
	}

	private boolean check_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Prompt_1_tr0_tr0() {
		return sCIHBrain.tTSReady == true;
	}

	private boolean check_MainBrain_FaceDataInterpretation_FaceDataInterpretation_AfterGreetings_tr0_tr0() {
		return sCIHBrain.tTSReady == true;
	}

	private boolean check_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Farewell_1_tr0_tr0() {
		return sCIHBrain.tTSReady == true;
	}

	private boolean check_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Farewell_2_tr0_tr0() {
		return sCIHBrain.tTSReady == true;
	}

	private boolean check_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Farewell_3_tr0_tr0() {
		return sCIHBrain.tTSReady == true;
	}

	private boolean check_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Farewell_4_tr0_tr0() {
		return sCIHBrain.tTSReady == true;
	}

	private boolean check_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Selection_tr0_tr0() {
		return true;
	}

	private boolean check_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Selection_tr1_tr1() {
		return sCIBGF.randNum == 2;
	}

	private boolean check_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Selection_tr2_tr2() {
		return sCIBGF.randNum == 0;
	}

	private boolean check_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Selection_tr3_tr3() {
		return sCIBGF.randNum == 1;
	}

	private boolean check_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Selection_1_tr0_tr0() {
		return sCIBGF.randNum == 0;
	}

	private boolean check_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Selection_1_tr1_tr1() {
		return true;
	}

	private boolean check_MainBrain_FaceDataInterpretation_FaceDataInterpretation_RandomTopic_3_tr0_tr0() {
		return sCIHBrain.tTSReady == true;
	}

	private boolean check_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Selection_2_tr0_tr0() {
		return sCIBGF.randNum == 0;
	}

	private boolean check_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Selection_2_tr1_tr1() {
		return true;
	}

	private boolean check_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Selection_2_tr2_tr2() {
		return sCIBGF.randNum == 1;
	}

	private boolean check_MainBrain_FaceDataInterpretation_FaceDataInterpretation_AlternativeConv_1_tr0_tr0() {
		return sCIHBrain.tTSReady == true;
	}

	private boolean check_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Selection_3_tr0_tr0() {
		return true;
	}

	private boolean check_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Selection_3_tr1_tr1() {
		return sCIBGF.randNum == 1;
	}

	private boolean check_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Selection_3_tr2_tr2() {
		return sCIBGF.randNum == 0;
	}

	private boolean check_MainBrain_FaceDataInterpretation_FaceDataInterpretation_STT_1_tr0_tr0() {
		return (timeEvents[1]) && sCISTT.sTTready == true;
	}

	private boolean check_MainBrain_FaceDataInterpretation_FaceDataInterpretation_STT_2_tr0_tr0() {
		return (timeEvents[2]) && sCISTT.sTTready == true;
	}

	private boolean check_MainBrain_FaceDataInterpretation_FaceDataInterpretation_RandomTopic_4_tr0_tr0() {
		return sCIHBrain.tTSReady == true;
	}

	private boolean check_MainBrain_FaceDataInterpretation_FaceDataInterpretation_STT_3_tr0_tr0() {
		return (timeEvents[3]) && sCISTT.sTTready == true;
	}

	private boolean check_MainBrain_FaceDataInterpretation_FaceDataInterpretation_STT_4_tr0_tr0() {
		return (timeEvents[4]) && sCISTT.sTTready == true;
	}

	private boolean check_MainBrain_FaceDataInterpretation_FaceDataInterpretation_AlternativeConv_2_tr0_tr0() {
		return sCIHBrain.tTSReady == true;
	}

	private boolean check_MainBrain_FaceDataInterpretation_FaceDataInterpretation_AboutRobotica_3_tr0_tr0() {
		return sCIHBrain.tTSReady == true;
	}

	private boolean check_MainBrain_FaceDataInterpretation_FaceDataInterpretation_STT_5_tr0_tr0() {
		return (timeEvents[5]) && sCISTT.sTTready == true;
	}

	private boolean check_MainBrain_FaceDataInterpretation_FaceDataInterpretation_AfterGreetings_2_tr0_tr0() {
		return sCIHBrain.tTSReady == true;
	}

	private boolean check_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Closing_tr0_tr0() {
		return sCIHBrain.tTSReady == true;
	}

	private boolean check_MainBrain_FaceDataInterpretation_FaceDataInterpretation_STT_6_tr0_tr0() {
		return (timeEvents[6]) && sCISTT.sTTready == true;
	}

	private boolean check_MainBrain_FaceDataInterpretation_FaceDataInterpretation_filter_tr0_tr0() {
		return (sCISTT.filteredMsg == null ? "yes" == null : sCISTT.filteredMsg.equals("yes"));
	}

	private boolean check_MainBrain_FaceDataInterpretation_FaceDataInterpretation_filter_tr1_tr1() {
		return true;
	}

	private boolean check_MainBrain_FaceDataInterpretation_FaceDataInterpretation_filter_2_tr0_tr0() {
		return (sCISTT.filteredMsg == null ? "yes" == null : sCISTT.filteredMsg.equals("yes"));
	}

	private boolean check_MainBrain_FaceDataInterpretation_FaceDataInterpretation_filter_2_tr1_tr1() {
		return true;
	}

	private boolean check_MainBrain_TurnToNoise_tr0_tr0() {
		return sCIVBrain.countFoundFaces > 0;
	}

	private boolean check_MainBrain_TurnToNoise_tr1_tr1() {
		return sCIVBrain.countFoundFaces < 0;
	}

	private boolean check_MainBrain_StopLeonie_tr0_tr0() {
		return sCICurrPerson.currDistance < 10;
	}

	private boolean check_MainBrain_SearchForChat_tr0_tr0() {
		return sCIVBrain.countFoundFaces > 0;
	}

	private boolean check_MainBrain_SearchForChat_SearchForChat_Standing_tr0_tr0() {
		return timeEvents[7];
	}

	private boolean check_MainBrain_SearchForChat_SearchForChat_Walking_tr0_tr0() {
		return timeEvents[8];
	}

	private boolean check_MainBrain_FaceDataInterpretation_FaceDataInterpretation__choice_0_tr1_tr1() {
		return sCICurrPerson.known == true;
	}

	private boolean check_MainBrain_FaceDataInterpretation_FaceDataInterpretation__choice_0_tr0_tr0() {
		return true;
	}

	private boolean check_MainBrain_FaceDataInterpretation_FaceDataInterpretation__choice_1_tr0_tr0() {
		return (sCICurrPerson.firstname == null ? "" != null : !sCICurrPerson.firstname.equals(""));
	}

	private boolean check_MainBrain_FaceDataInterpretation_FaceDataInterpretation__choice_1_tr1_tr1() {
		return true;
	}

	private boolean check_MainBrain_FaceDataInterpretation_FaceDataInterpretation__choice_2_tr0_tr0() {
		return sCICurrPerson.gender == true;
	}

	private boolean check_MainBrain_FaceDataInterpretation_FaceDataInterpretation__choice_2_tr1_tr1() {
		return true;
	}

	private boolean check_MainBrain_FaceDataInterpretation_FaceDataInterpretation__choice_3_tr0_tr0() {
		return sCICurrPerson.estimatedAge <= 18;
	}

	private boolean check_MainBrain_FaceDataInterpretation_FaceDataInterpretation__choice_3_tr2_tr2() {
		return sCICurrPerson.estimatedAge >= 30;
	}

	private boolean check_MainBrain_FaceDataInterpretation_FaceDataInterpretation__choice_3_tr1_tr1() {
		return true;
	}

	private boolean check_MainBrain_FaceDataInterpretation_FaceDataInterpretation__choice_4_tr0_tr0() {
		return sCICurrPerson.estimatedAge <= 18;
	}

	private boolean check_MainBrain_FaceDataInterpretation_FaceDataInterpretation__choice_4_tr1_tr1() {
		return sCICurrPerson.estimatedAge >= 30;
	}

	private boolean check_MainBrain_FaceDataInterpretation_FaceDataInterpretation__choice_4_tr2_tr2() {
		return true;
	}

	private void effect_MainBrain_Init_tr0() {
		exitSequence_MainBrain_Init();

		enterSequence_MainBrain_SearchForChat_default();
	}

	private void effect_MainBrain_Init_tr1() {
		exitSequence_MainBrain_Init();

		enterSequence_MainBrain_FaceDataInterpretation_default();
	}

	private void effect_MainBrain_Init_tr2() {
		exitSequence_MainBrain_Init();

		enterSequence_MainBrain_TurnToNoise_default();
	}

	private void effect_MainBrain_FaceDataInterpretation_tr0() {
		exitSequence_MainBrain_FaceDataInterpretation();

		enterSequence_MainBrain_Idle_default();
	}

	private void effect_MainBrain_FaceDataInterpretation_FaceDataInterpretation_PersonKnownWithName_tr0() {
		exitSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_PersonKnownWithName();

		enterSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Greetings_KnownPerson_default();
	}

	private void effect_MainBrain_FaceDataInterpretation_FaceDataInterpretation_UnknownGirl_tr0() {
		exitSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_UnknownGirl();

		enterSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Greetings_UnknownPerson_default();
	}

	private void effect_MainBrain_FaceDataInterpretation_FaceDataInterpretation_PersonKnownWithoutName_tr0() {
		exitSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_PersonKnownWithoutName();

		enterSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_STT_6_default();
	}

	private void effect_MainBrain_FaceDataInterpretation_FaceDataInterpretation_UnknownFemaleTeen_tr0() {
		exitSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_UnknownFemaleTeen();

		enterSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Greetings_UnknownPerson_default();
	}

	private void effect_MainBrain_FaceDataInterpretation_FaceDataInterpretation_UnknownWomen_tr0() {
		exitSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_UnknownWomen();

		enterSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Greetings_UnknownPerson_default();
	}

	private void effect_MainBrain_FaceDataInterpretation_FaceDataInterpretation_UnknownBoy_tr0() {
		exitSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_UnknownBoy();

		enterSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Greetings_UnknownPerson_default();
	}

	private void effect_MainBrain_FaceDataInterpretation_FaceDataInterpretation_UnknownMaleTeen_tr0() {
		exitSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_UnknownMaleTeen();

		enterSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Greetings_UnknownPerson_default();
	}

	private void effect_MainBrain_FaceDataInterpretation_FaceDataInterpretation_UnknownMen_tr0() {
		exitSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_UnknownMen();

		enterSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Greetings_UnknownPerson_default();
	}

	private void effect_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Greetings_KnownPerson_tr0() {
		exitSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Greetings_KnownPerson();

		enterSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_STT_5_default();
	}

	private void effect_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Greetings_UnknownPerson_tr0() {
		exitSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Greetings_UnknownPerson();

		enterSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_STT_1_default();
	}

	private void effect_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Greetings_KnownPersonWithoutName_tr0() {
		exitSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Greetings_KnownPersonWithoutName();

		enterSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Selection_1_default();
	}

	private void effect_MainBrain_FaceDataInterpretation_FaceDataInterpretation_AboutRobotica_1_tr0() {
		exitSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_AboutRobotica_1();

		enterSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Closing_default();
	}

	private void effect_MainBrain_FaceDataInterpretation_FaceDataInterpretation_AboutRobotica_2_tr0() {
		exitSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_AboutRobotica_2();

		enterSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Closing_default();
	}

	private void effect_MainBrain_FaceDataInterpretation_FaceDataInterpretation_RandomTopic_1_tr0() {
		exitSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_RandomTopic_1();

		enterSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Closing_default();
	}

	private void effect_MainBrain_FaceDataInterpretation_FaceDataInterpretation_RandomTopic_2_tr0() {
		exitSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_RandomTopic_2();

		enterSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Closing_default();
	}

	private void effect_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Prompt_2_tr0() {
		exitSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Prompt_2();

		enterSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_STT_2_default();
	}

	private void effect_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Prompt_1_tr0() {
		exitSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Prompt_1();

		enterSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_STT_3_default();
	}

	private void effect_MainBrain_FaceDataInterpretation_FaceDataInterpretation_AfterGreetings_tr0() {
		exitSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_AfterGreetings();

		enterSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Selection_1_default();
	}

	private void effect_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Farewell_1_tr0() {
		exitSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Farewell_1();

		enterSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation__final__default();
	}

	private void effect_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Farewell_2_tr0() {
		exitSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Farewell_2();

		enterSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation__final__default();
	}

	private void effect_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Farewell_3_tr0() {
		exitSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Farewell_3();

		enterSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation__final__default();
	}

	private void effect_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Farewell_4_tr0() {
		exitSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Farewell_4();

		enterSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation__final__default();
	}

	private void effect_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Selection_tr0() {
		exitSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Selection();

		enterSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Farewell_1_default();
	}

	private void effect_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Selection_tr1() {
		exitSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Selection();

		enterSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Farewell_2_default();
	}

	private void effect_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Selection_tr2() {
		exitSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Selection();

		enterSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Farewell_3_default();
	}

	private void effect_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Selection_tr3() {
		exitSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Selection();

		enterSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Farewell_4_default();
	}

	private void effect_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Selection_1_tr0() {
		exitSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Selection_1();

		enterSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Prompt_2_default();
	}

	private void effect_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Selection_1_tr1() {
		exitSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Selection_1();

		enterSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Prompt_1_default();
	}

	private void effect_MainBrain_FaceDataInterpretation_FaceDataInterpretation_RandomTopic_3_tr0() {
		exitSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_RandomTopic_3();

		enterSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Closing_default();
	}

	private void effect_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Selection_2_tr0() {
		exitSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Selection_2();

		enterSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_AboutRobotica_1_default();
	}

	private void effect_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Selection_2_tr1() {
		exitSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Selection_2();

		enterSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_AboutRobotica_2_default();
	}

	private void effect_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Selection_2_tr2() {
		exitSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Selection_2();

		enterSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_AboutRobotica_3_default();
	}

	private void effect_MainBrain_FaceDataInterpretation_FaceDataInterpretation_AlternativeConv_1_tr0() {
		exitSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_AlternativeConv_1();

		enterSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_STT_4_default();
	}

	private void effect_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Selection_3_tr0() {
		exitSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Selection_3();

		enterSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_RandomTopic_2_default();
	}

	private void effect_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Selection_3_tr1() {
		exitSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Selection_3();

		enterSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_RandomTopic_3_default();
	}

	private void effect_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Selection_3_tr2() {
		exitSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Selection_3();

		enterSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_RandomTopic_1_default();
	}

	private void effect_MainBrain_FaceDataInterpretation_FaceDataInterpretation_STT_1_tr0() {
		exitSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_STT_1();

		enterSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_AfterGreetings_default();
	}

	private void effect_MainBrain_FaceDataInterpretation_FaceDataInterpretation_STT_2_tr0() {
		exitSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_STT_2();

		enterSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_filter_default();
	}

	private void effect_MainBrain_FaceDataInterpretation_FaceDataInterpretation_RandomTopic_4_tr0() {
		exitSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_RandomTopic_4();

		enterSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Selection_3_default();
	}

	private void effect_MainBrain_FaceDataInterpretation_FaceDataInterpretation_STT_3_tr0() {
		exitSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_STT_3();

		enterSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_filter_2_default();
	}

	private void effect_MainBrain_FaceDataInterpretation_FaceDataInterpretation_STT_4_tr0() {
		exitSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_STT_4();

		enterSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_AlternativeConv_2_default();
	}

	private void effect_MainBrain_FaceDataInterpretation_FaceDataInterpretation_AlternativeConv_2_tr0() {
		exitSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_AlternativeConv_2();

		enterSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Selection_2_default();
	}

	private void effect_MainBrain_FaceDataInterpretation_FaceDataInterpretation_AboutRobotica_3_tr0() {
		exitSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_AboutRobotica_3();

		enterSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Closing_default();
	}

	private void effect_MainBrain_FaceDataInterpretation_FaceDataInterpretation_STT_5_tr0() {
		exitSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_STT_5();

		enterSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_AfterGreetings_2_default();
	}

	private void effect_MainBrain_FaceDataInterpretation_FaceDataInterpretation_AfterGreetings_2_tr0() {
		exitSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_AfterGreetings_2();

		enterSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Selection_1_default();
	}

	private void effect_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Closing_tr0() {
		exitSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Closing();

		enterSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Selection_default();
	}

	private void effect_MainBrain_FaceDataInterpretation_FaceDataInterpretation_STT_6_tr0() {
		exitSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_STT_6();

		enterSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Greetings_KnownPersonWithoutName_default();
	}

	private void effect_MainBrain_FaceDataInterpretation_FaceDataInterpretation_filter_tr0() {
		exitSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_filter();

		enterSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Selection_3_default();
	}

	private void effect_MainBrain_FaceDataInterpretation_FaceDataInterpretation_filter_tr1() {
		exitSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_filter();

		enterSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_RandomTopic_4_default();
	}

	private void effect_MainBrain_FaceDataInterpretation_FaceDataInterpretation_filter_2_tr0() {
		exitSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_filter_2();

		enterSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Selection_2_default();
	}

	private void effect_MainBrain_FaceDataInterpretation_FaceDataInterpretation_filter_2_tr1() {
		exitSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_filter_2();

		enterSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_AlternativeConv_1_default();
	}

	private void effect_MainBrain_TurnToNoise_tr0() {
		exitSequence_MainBrain_TurnToNoise();

		enterSequence_MainBrain_StopLeonie_default();
	}

	private void effect_MainBrain_TurnToNoise_tr1() {
		exitSequence_MainBrain_TurnToNoise();

		enterSequence_MainBrain_SearchForChat_default();
	}

	private void effect_MainBrain_StopLeonie_tr0() {
		exitSequence_MainBrain_StopLeonie();

		enterSequence_MainBrain_FaceDataInterpretation_default();
	}

	private void effect_MainBrain_SearchForChat_tr0() {
		exitSequence_MainBrain_SearchForChat();

		enterSequence_MainBrain_StopLeonie_default();
	}

	private void effect_MainBrain_SearchForChat_SearchForChat_Standing_tr0() {
		exitSequence_MainBrain_SearchForChat_SearchForChat_Standing();

		enterSequence_MainBrain_SearchForChat_SearchForChat_Walking_default();
	}

	private void effect_MainBrain_SearchForChat_SearchForChat_Walking_tr0() {
		exitSequence_MainBrain_SearchForChat_SearchForChat_Walking();

		enterSequence_MainBrain_SearchForChat_SearchForChat_Standing_default();
	}

	private void effect_MainBrain_FaceDataInterpretation_FaceDataInterpretation__choice_0_tr1() {
		react_MainBrain_FaceDataInterpretation_FaceDataInterpretation__choice_1();
	}

	private void effect_MainBrain_FaceDataInterpretation_FaceDataInterpretation__choice_0_tr0() {
		react_MainBrain_FaceDataInterpretation_FaceDataInterpretation__choice_2();
	}

	private void effect_MainBrain_FaceDataInterpretation_FaceDataInterpretation__choice_1_tr0() {
		enterSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_PersonKnownWithName_default();
	}

	private void effect_MainBrain_FaceDataInterpretation_FaceDataInterpretation__choice_1_tr1() {
		enterSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_PersonKnownWithoutName_default();
	}

	private void effect_MainBrain_FaceDataInterpretation_FaceDataInterpretation__choice_2_tr0() {
		react_MainBrain_FaceDataInterpretation_FaceDataInterpretation__choice_3();
	}

	private void effect_MainBrain_FaceDataInterpretation_FaceDataInterpretation__choice_2_tr1() {
		react_MainBrain_FaceDataInterpretation_FaceDataInterpretation__choice_4();
	}

	private void effect_MainBrain_FaceDataInterpretation_FaceDataInterpretation__choice_3_tr0() {
		enterSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_UnknownGirl_default();
	}

	private void effect_MainBrain_FaceDataInterpretation_FaceDataInterpretation__choice_3_tr2() {
		enterSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_UnknownWomen_default();
	}

	private void effect_MainBrain_FaceDataInterpretation_FaceDataInterpretation__choice_3_tr1() {
		enterSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_UnknownFemaleTeen_default();
	}

	private void effect_MainBrain_FaceDataInterpretation_FaceDataInterpretation__choice_4_tr0() {
		enterSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_UnknownBoy_default();
	}

	private void effect_MainBrain_FaceDataInterpretation_FaceDataInterpretation__choice_4_tr1() {
		enterSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_UnknownMen_default();
	}

	private void effect_MainBrain_FaceDataInterpretation_FaceDataInterpretation__choice_4_tr2() {
		enterSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_UnknownMaleTeen_default();
	}

	/* Entry action for state 'Init'. */
	private void entryAction_MainBrain_Init() {

		timer.setTimer(this, 0, 100 * 1000, false);

		sCIUdpInterface.operationCallback.receive();

		sCIUdpInterface.operationCallback.sendToVBrain_ACIonOff(true);
	}

	/* Entry action for state 'PersonKnownWithName'. */
	private void entryAction_MainBrain_FaceDataInterpretation_FaceDataInterpretation_PersonKnownWithName() {
		sCIUdpInterface.operationCallback.sendToHBrain_TTS2("Hey ", sCICurrPerson.firstname);
	}

	/* Entry action for state 'UnknownGirl'. */
	private void entryAction_MainBrain_FaceDataInterpretation_FaceDataInterpretation_UnknownGirl() {
		sCIUdpInterface.operationCallback.sendToHBrain_TTS("Hi girl");
	}

	/* Entry action for state 'PersonKnownWithoutName'. */
	private void entryAction_MainBrain_FaceDataInterpretation_FaceDataInterpretation_PersonKnownWithoutName() {
		sCIUdpInterface.operationCallback.sendToHBrain_TTS(
				"Hey there You look familiar I did not get your name last time Please tell me your name");
	}

	/* Entry action for state 'UnknownFemaleTeen'. */
	private void entryAction_MainBrain_FaceDataInterpretation_FaceDataInterpretation_UnknownFemaleTeen() {
		sCIUdpInterface.operationCallback.sendToHBrain_TTS("Hi female Teen");
	}

	/* Entry action for state 'UnknownWomen'. */
	private void entryAction_MainBrain_FaceDataInterpretation_FaceDataInterpretation_UnknownWomen() {
		sCIUdpInterface.operationCallback.sendToHBrain_TTS("Hi pretty Lady");
	}

	/* Entry action for state 'UnknownBoy'. */
	private void entryAction_MainBrain_FaceDataInterpretation_FaceDataInterpretation_UnknownBoy() {
		sCIUdpInterface.operationCallback.sendToHBrain_TTS("Hi Boy");
	}

	/* Entry action for state 'UnknownMaleTeen'. */
	private void entryAction_MainBrain_FaceDataInterpretation_FaceDataInterpretation_UnknownMaleTeen() {
		sCIUdpInterface.operationCallback.sendToHBrain_TTS("Hi male Teen");
	}

	/* Entry action for state 'UnknownMen'. */
	private void entryAction_MainBrain_FaceDataInterpretation_FaceDataInterpretation_UnknownMen() {
		sCIUdpInterface.operationCallback.sendToHBrain_TTS("Hey guy");
	}

	/* Entry action for state 'Greetings_KnownPerson'. */
	private void entryAction_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Greetings_KnownPerson() {
		sCIUdpInterface.operationCallback.sendToHBrain_TTS("How are you doing");
	}

	/* Entry action for state 'Greetings_UnknownPerson'. */
	private void entryAction_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Greetings_UnknownPerson() {
		sCIUdpInterface.operationCallback.sendToHBrain_TTS("I have never seen you before What is your name");
	}

	/* Entry action for state 'Greetings_KnownPersonWithoutName'. */
	private void entryAction_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Greetings_KnownPersonWithoutName() {
		sCIUdpInterface.operationCallback.sendToSTT_detectionOnOff(false);

		sCICurrPerson.operationCallback.setFirstname(sCISTT.speakerMsg);

		sCIUdpInterface.operationCallback.sendToHBrain_TTS("Nice to see you again.");
	}

	/* Entry action for state 'AboutRobotica_1'. */
	private void entryAction_MainBrain_FaceDataInterpretation_FaceDataInterpretation_AboutRobotica_1() {
		sCIUdpInterface.operationCallback
				.sendToHBrain_TTS("I am so excited to be here cause I get to make new friends");
	}

	/* Entry action for state 'AboutRobotica_2'. */
	private void entryAction_MainBrain_FaceDataInterpretation_FaceDataInterpretation_AboutRobotica_2() {
		sCIUdpInterface.operationCallback
				.sendToHBrain_TTS("Oh I saw a handsome robot just now If only I can talk to him");
	}

	/* Entry action for state 'RandomTopic_1'. */
	private void entryAction_MainBrain_FaceDataInterpretation_FaceDataInterpretation_RandomTopic_1() {
		sCIUdpInterface.operationCallback.sendToHBrain_TTS(
				"My university is located in Reutlingen the ninth largest city in Baden-Württemberg ");
	}

	/* Entry action for state 'RandomTopic_2'. */
	private void entryAction_MainBrain_FaceDataInterpretation_FaceDataInterpretation_RandomTopic_2() {
		sCIUdpInterface.operationCallback.sendToHBrain_TTS(
				"My home Reutlingen is nicknamed The Gate to the Swabian Alb The landscape surrounding my university is truly breathtaking");
	}

	/* Entry action for state 'Prompt_2'. */
	private void entryAction_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Prompt_2() {
		sCIUdpInterface.operationCallback.sendToHBrain_TTS("Do you want to know more about where I come from ");
	}

	/* Entry action for state 'Prompt_1'. */
	private void entryAction_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Prompt_1() {
		sCIUdpInterface.operationCallback.sendToHBrain_TTS("Are you having fun here");
	}

	/* Entry action for state 'AfterGreetings'. */
	private void entryAction_MainBrain_FaceDataInterpretation_FaceDataInterpretation_AfterGreetings() {
		sCIUdpInterface.operationCallback.sendToSTT_detectionOnOff(false);

		sCICurrPerson.operationCallback.setFirstname(sCISTT.speakerMsg);

		sCIUdpInterface.operationCallback.sendToHBrain_TTS(
				"You have a nice name Sadly I am quite bad with names I do apologize if I mispronounce your name the next time we meet");
	}

	/* Entry action for state 'Farewell_1'. */
	private void entryAction_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Farewell_1() {
		sCIUdpInterface.operationCallback.sendToHBrain_TTS("It is nice meeting you Till next time take care");
	}

	/* Entry action for state 'Farewell_2'. */
	private void entryAction_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Farewell_2() {
		sCIUdpInterface.operationCallback.sendToHBrain_TTS(
				"We might not see each other again which is sad I like you human I wish you all the best in your future undertakings Stay happy and healthy");
	}

	/* Entry action for state 'Farewell_3'. */
	private void entryAction_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Farewell_3() {
		sCIUdpInterface.operationCallback.sendToHBrain_TTS("Pleasure to meet you dear human.");
	}

	/* Entry action for state 'Farewell_4'. */
	private void entryAction_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Farewell_4() {
		sCIUdpInterface.operationCallback.sendToHBrain_TTS("See you again auf Wiedersehen");
	}

	/* Entry action for state 'Selection'. */
	private void entryAction_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Selection() {
		sCIBGF.operationCallback.newRandNum(4);
	}

	/* Entry action for state 'Selection_1'. */
	private void entryAction_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Selection_1() {
		sCIBGF.operationCallback.newRandNum(2);
	}

	/* Entry action for state 'RandomTopic_3'. */
	private void entryAction_MainBrain_FaceDataInterpretation_FaceDataInterpretation_RandomTopic_3() {
		sCIUdpInterface.operationCallback
				.sendToHBrain_TTS("My family is called the RT Lions They are an awesome and I love them very much");
	}

	/* Entry action for state 'Selection_2'. */
	private void entryAction_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Selection_2() {
		sCIBGF.operationCallback.newRandNum(2);
	}

	/* Entry action for state 'AlternativeConv_1'. */
	private void entryAction_MainBrain_FaceDataInterpretation_FaceDataInterpretation_AlternativeConv_1() {
		sCIUdpInterface.operationCallback.sendToHBrain_TTS("Why");
	}

	/* Entry action for state 'Selection_3'. */
	private void entryAction_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Selection_3() {
		sCIBGF.operationCallback.newRandNum(3);
	}

	/* Entry action for state 'STT_1'. */
	private void entryAction_MainBrain_FaceDataInterpretation_FaceDataInterpretation_STT_1() {

		timer.setTimer(this, 1, 3 * 1000, false);

		sCIUdpInterface.operationCallback.sendToSTT_detectionOnOff(true);
	}

	/* Entry action for state 'STT_2'. */
	private void entryAction_MainBrain_FaceDataInterpretation_FaceDataInterpretation_STT_2() {

		timer.setTimer(this, 2, 2 * 1000, false);

		sCIUdpInterface.operationCallback.sendToSTT_detectionOnOff(true);
	}

	/* Entry action for state 'RandomTopic_4'. */
	private void entryAction_MainBrain_FaceDataInterpretation_FaceDataInterpretation_RandomTopic_4() {
		sCIUdpInterface.operationCallback.sendToHBrain_TTS("Hahah, I will tell you anyway");
	}

	/* Entry action for state 'STT_3'. */
	private void entryAction_MainBrain_FaceDataInterpretation_FaceDataInterpretation_STT_3() {

		timer.setTimer(this, 3, 2 * 1000, false);

		sCIUdpInterface.operationCallback.sendToSTT_detectionOnOff(true);
	}

	/* Entry action for state 'STT_4'. */
	private void entryAction_MainBrain_FaceDataInterpretation_FaceDataInterpretation_STT_4() {

		timer.setTimer(this, 4, 4 * 1000, false);

		sCIUdpInterface.operationCallback.sendToSTT_detectionOnOff(true);
	}

	/* Entry action for state 'AlternativeConv_2'. */
	private void entryAction_MainBrain_FaceDataInterpretation_FaceDataInterpretation_AlternativeConv_2() {
		sCIUdpInterface.operationCallback.sendToSTT_detectionOnOff(false);

		sCIUdpInterface.operationCallback.sendToHBrain_TTS("Oh I see");
	}

	/* Entry action for state 'AboutRobotica_3'. */
	private void entryAction_MainBrain_FaceDataInterpretation_FaceDataInterpretation_AboutRobotica_3() {
		sCIUdpInterface.operationCallback.sendToHBrain_TTS("It is my first time here");
	}

	/* Entry action for state 'STT_5'. */
	private void entryAction_MainBrain_FaceDataInterpretation_FaceDataInterpretation_STT_5() {

		timer.setTimer(this, 5, 3 * 1000, false);

		sCIUdpInterface.operationCallback.sendToSTT_detectionOnOff(true);
	}

	/* Entry action for state 'AfterGreetings_2'. */
	private void entryAction_MainBrain_FaceDataInterpretation_FaceDataInterpretation_AfterGreetings_2() {
		sCIUdpInterface.operationCallback.sendToSTT_detectionOnOff(false);

		sCIUdpInterface.operationCallback.sendToHBrain_TTS("Good to know");
	}

	/* Entry action for state 'Closing'. */
	private void entryAction_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Closing() {
		sCIUdpInterface.operationCallback
				.sendToHBrain_TTS("Would love to chat with you more but so many people to meet so little time hahah");
	}

	/* Entry action for state 'STT_6'. */
	private void entryAction_MainBrain_FaceDataInterpretation_FaceDataInterpretation_STT_6() {

		timer.setTimer(this, 6, 3 * 1000, false);

		sCIUdpInterface.operationCallback.sendToSTT_detectionOnOff(true);
	}

	/* Entry action for state 'filter'. */
	private void entryAction_MainBrain_FaceDataInterpretation_FaceDataInterpretation_filter() {
		sCIUdpInterface.operationCallback.sendToSTT_detectionOnOff(false);

		sCISTT.operationCallback.filter("");
	}

	/* Entry action for state 'filter_2'. */
	private void entryAction_MainBrain_FaceDataInterpretation_FaceDataInterpretation_filter_2() {
		sCIUdpInterface.operationCallback.sendToSTT_detectionOnOff(false);

		sCISTT.operationCallback.filter("");
	}

	/* Entry action for state 'TurnToNoise'. */
	private void entryAction_MainBrain_TurnToNoise() {
		sCIUdpInterface.operationCallback.sendToHBrain_TTS("Oh, somebody is behind me");

		sCIUdpInterface.operationCallback.sendToNav_goToLC("0", "1");

		sCIUdpInterface.operationCallback.sendToNav_searchOnOff(false);
	}

	/* Entry action for state 'StopLeonie'. */
	private void entryAction_MainBrain_StopLeonie() {
		sCIUdpInterface.operationCallback.sendToNav_searchOnOff(false);
	}

	/* Entry action for state 'Standing'. */
	private void entryAction_MainBrain_SearchForChat_SearchForChat_Standing() {

		timer.setTimer(this, 7, 5 * 1000, false);

		sCIUdpInterface.operationCallback.sendToNav_searchOnOff(false);
	}

	/* Entry action for state 'Walking'. */
	private void entryAction_MainBrain_SearchForChat_SearchForChat_Walking() {

		timer.setTimer(this, 8, 200 * 1000, false);

		sCIUdpInterface.operationCallback.sendToNav_searchOnOff(true);
	}

	/* Exit action for state 'Init'. */
	private void exitAction_MainBrain_Init() {
		timer.unsetTimer(this, 0);
	}

	/* Exit action for state 'STT_1'. */
	private void exitAction_MainBrain_FaceDataInterpretation_FaceDataInterpretation_STT_1() {
		timer.unsetTimer(this, 1);
	}

	/* Exit action for state 'STT_2'. */
	private void exitAction_MainBrain_FaceDataInterpretation_FaceDataInterpretation_STT_2() {
		timer.unsetTimer(this, 2);
	}

	/* Exit action for state 'STT_3'. */
	private void exitAction_MainBrain_FaceDataInterpretation_FaceDataInterpretation_STT_3() {
		timer.unsetTimer(this, 3);
	}

	/* Exit action for state 'STT_4'. */
	private void exitAction_MainBrain_FaceDataInterpretation_FaceDataInterpretation_STT_4() {
		timer.unsetTimer(this, 4);
	}

	/* Exit action for state 'STT_5'. */
	private void exitAction_MainBrain_FaceDataInterpretation_FaceDataInterpretation_STT_5() {
		timer.unsetTimer(this, 5);
	}

	/* Exit action for state 'STT_6'. */
	private void exitAction_MainBrain_FaceDataInterpretation_FaceDataInterpretation_STT_6() {
		timer.unsetTimer(this, 6);
	}

	/* Exit action for state 'Standing'. */
	private void exitAction_MainBrain_SearchForChat_SearchForChat_Standing() {
		timer.unsetTimer(this, 7);
	}

	/* Exit action for state 'Walking'. */
	private void exitAction_MainBrain_SearchForChat_SearchForChat_Walking() {
		timer.unsetTimer(this, 8);
	}

	/* 'default' enter sequence for state Init */
	private void enterSequence_MainBrain_Init_default() {
		entryAction_MainBrain_Init();

		nextStateIndex = 0;
		stateVector[0] = State.mainBrain_Init;
	}

	/* 'default' enter sequence for state FaceDataInterpretation */
	private void enterSequence_MainBrain_FaceDataInterpretation_default() {
		enterSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_default();
	}

	/* 'default' enter sequence for state PersonKnownWithName */
	private void enterSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_PersonKnownWithName_default() {
		entryAction_MainBrain_FaceDataInterpretation_FaceDataInterpretation_PersonKnownWithName();

		nextStateIndex = 0;
		stateVector[0] = State.mainBrain_FaceDataInterpretation_FaceDataInterpretation_PersonKnownWithName;
	}

	/* 'default' enter sequence for state UnknownGirl */
	private void enterSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_UnknownGirl_default() {
		entryAction_MainBrain_FaceDataInterpretation_FaceDataInterpretation_UnknownGirl();

		nextStateIndex = 0;
		stateVector[0] = State.mainBrain_FaceDataInterpretation_FaceDataInterpretation_UnknownGirl;
	}

	/* 'default' enter sequence for state PersonKnownWithoutName */
	private void enterSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_PersonKnownWithoutName_default() {
		entryAction_MainBrain_FaceDataInterpretation_FaceDataInterpretation_PersonKnownWithoutName();

		nextStateIndex = 0;
		stateVector[0] = State.mainBrain_FaceDataInterpretation_FaceDataInterpretation_PersonKnownWithoutName;
	}

	/* 'default' enter sequence for state UnknownFemaleTeen */
	private void enterSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_UnknownFemaleTeen_default() {
		entryAction_MainBrain_FaceDataInterpretation_FaceDataInterpretation_UnknownFemaleTeen();

		nextStateIndex = 0;
		stateVector[0] = State.mainBrain_FaceDataInterpretation_FaceDataInterpretation_UnknownFemaleTeen;
	}

	/* 'default' enter sequence for state UnknownWomen */
	private void enterSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_UnknownWomen_default() {
		entryAction_MainBrain_FaceDataInterpretation_FaceDataInterpretation_UnknownWomen();

		nextStateIndex = 0;
		stateVector[0] = State.mainBrain_FaceDataInterpretation_FaceDataInterpretation_UnknownWomen;
	}

	/* 'default' enter sequence for state UnknownBoy */
	private void enterSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_UnknownBoy_default() {
		entryAction_MainBrain_FaceDataInterpretation_FaceDataInterpretation_UnknownBoy();

		nextStateIndex = 0;
		stateVector[0] = State.mainBrain_FaceDataInterpretation_FaceDataInterpretation_UnknownBoy;
	}

	/* 'default' enter sequence for state UnknownMaleTeen */
	private void enterSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_UnknownMaleTeen_default() {
		entryAction_MainBrain_FaceDataInterpretation_FaceDataInterpretation_UnknownMaleTeen();

		nextStateIndex = 0;
		stateVector[0] = State.mainBrain_FaceDataInterpretation_FaceDataInterpretation_UnknownMaleTeen;
	}

	/* 'default' enter sequence for state UnknownMen */
	private void enterSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_UnknownMen_default() {
		entryAction_MainBrain_FaceDataInterpretation_FaceDataInterpretation_UnknownMen();

		nextStateIndex = 0;
		stateVector[0] = State.mainBrain_FaceDataInterpretation_FaceDataInterpretation_UnknownMen;
	}

	/* 'default' enter sequence for state Greetings_KnownPerson */
	private void enterSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Greetings_KnownPerson_default() {
		entryAction_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Greetings_KnownPerson();

		nextStateIndex = 0;
		stateVector[0] = State.mainBrain_FaceDataInterpretation_FaceDataInterpretation_Greetings_KnownPerson;
	}

	/* 'default' enter sequence for state Greetings_UnknownPerson */
	private void enterSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Greetings_UnknownPerson_default() {
		entryAction_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Greetings_UnknownPerson();

		nextStateIndex = 0;
		stateVector[0] = State.mainBrain_FaceDataInterpretation_FaceDataInterpretation_Greetings_UnknownPerson;
	}

	/* 'default' enter sequence for state Greetings_KnownPersonWithoutName */
	private void enterSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Greetings_KnownPersonWithoutName_default() {
		entryAction_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Greetings_KnownPersonWithoutName();

		nextStateIndex = 0;
		stateVector[0] = State.mainBrain_FaceDataInterpretation_FaceDataInterpretation_Greetings_KnownPersonWithoutName;
	}

	/* 'default' enter sequence for state AboutRobotica_1 */
	private void enterSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_AboutRobotica_1_default() {
		entryAction_MainBrain_FaceDataInterpretation_FaceDataInterpretation_AboutRobotica_1();

		nextStateIndex = 0;
		stateVector[0] = State.mainBrain_FaceDataInterpretation_FaceDataInterpretation_AboutRobotica_1;
	}

	/* 'default' enter sequence for state AboutRobotica_2 */
	private void enterSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_AboutRobotica_2_default() {
		entryAction_MainBrain_FaceDataInterpretation_FaceDataInterpretation_AboutRobotica_2();

		nextStateIndex = 0;
		stateVector[0] = State.mainBrain_FaceDataInterpretation_FaceDataInterpretation_AboutRobotica_2;
	}

	/* 'default' enter sequence for state RandomTopic_1 */
	private void enterSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_RandomTopic_1_default() {
		entryAction_MainBrain_FaceDataInterpretation_FaceDataInterpretation_RandomTopic_1();

		nextStateIndex = 0;
		stateVector[0] = State.mainBrain_FaceDataInterpretation_FaceDataInterpretation_RandomTopic_1;
	}

	/* 'default' enter sequence for state RandomTopic_2 */
	private void enterSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_RandomTopic_2_default() {
		entryAction_MainBrain_FaceDataInterpretation_FaceDataInterpretation_RandomTopic_2();

		nextStateIndex = 0;
		stateVector[0] = State.mainBrain_FaceDataInterpretation_FaceDataInterpretation_RandomTopic_2;
	}

	/* 'default' enter sequence for state Prompt_2 */
	private void enterSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Prompt_2_default() {
		entryAction_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Prompt_2();

		nextStateIndex = 0;
		stateVector[0] = State.mainBrain_FaceDataInterpretation_FaceDataInterpretation_Prompt_2;
	}

	/* 'default' enter sequence for state Prompt_1 */
	private void enterSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Prompt_1_default() {
		entryAction_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Prompt_1();

		nextStateIndex = 0;
		stateVector[0] = State.mainBrain_FaceDataInterpretation_FaceDataInterpretation_Prompt_1;
	}

	/* 'default' enter sequence for state AfterGreetings */
	private void enterSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_AfterGreetings_default() {
		entryAction_MainBrain_FaceDataInterpretation_FaceDataInterpretation_AfterGreetings();

		nextStateIndex = 0;
		stateVector[0] = State.mainBrain_FaceDataInterpretation_FaceDataInterpretation_AfterGreetings;
	}

	/* 'default' enter sequence for state Farewell_1 */
	private void enterSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Farewell_1_default() {
		entryAction_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Farewell_1();

		nextStateIndex = 0;
		stateVector[0] = State.mainBrain_FaceDataInterpretation_FaceDataInterpretation_Farewell_1;
	}

	/* 'default' enter sequence for state Farewell_2 */
	private void enterSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Farewell_2_default() {
		entryAction_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Farewell_2();

		nextStateIndex = 0;
		stateVector[0] = State.mainBrain_FaceDataInterpretation_FaceDataInterpretation_Farewell_2;
	}

	/* 'default' enter sequence for state Farewell_3 */
	private void enterSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Farewell_3_default() {
		entryAction_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Farewell_3();

		nextStateIndex = 0;
		stateVector[0] = State.mainBrain_FaceDataInterpretation_FaceDataInterpretation_Farewell_3;
	}

	/* 'default' enter sequence for state Farewell_4 */
	private void enterSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Farewell_4_default() {
		entryAction_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Farewell_4();

		nextStateIndex = 0;
		stateVector[0] = State.mainBrain_FaceDataInterpretation_FaceDataInterpretation_Farewell_4;
	}

	/* 'default' enter sequence for state Selection */
	private void enterSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Selection_default() {
		entryAction_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Selection();

		nextStateIndex = 0;
		stateVector[0] = State.mainBrain_FaceDataInterpretation_FaceDataInterpretation_Selection;
	}

	/* 'default' enter sequence for state Selection_1 */
	private void enterSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Selection_1_default() {
		entryAction_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Selection_1();

		nextStateIndex = 0;
		stateVector[0] = State.mainBrain_FaceDataInterpretation_FaceDataInterpretation_Selection_1;
	}

	/* 'default' enter sequence for state RandomTopic_3 */
	private void enterSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_RandomTopic_3_default() {
		entryAction_MainBrain_FaceDataInterpretation_FaceDataInterpretation_RandomTopic_3();

		nextStateIndex = 0;
		stateVector[0] = State.mainBrain_FaceDataInterpretation_FaceDataInterpretation_RandomTopic_3;
	}

	/* 'default' enter sequence for state Selection_2 */
	private void enterSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Selection_2_default() {
		entryAction_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Selection_2();

		nextStateIndex = 0;
		stateVector[0] = State.mainBrain_FaceDataInterpretation_FaceDataInterpretation_Selection_2;
	}

	/* 'default' enter sequence for state AlternativeConv_1 */
	private void enterSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_AlternativeConv_1_default() {
		entryAction_MainBrain_FaceDataInterpretation_FaceDataInterpretation_AlternativeConv_1();

		nextStateIndex = 0;
		stateVector[0] = State.mainBrain_FaceDataInterpretation_FaceDataInterpretation_AlternativeConv_1;
	}

	/* 'default' enter sequence for state Selection_3 */
	private void enterSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Selection_3_default() {
		entryAction_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Selection_3();

		nextStateIndex = 0;
		stateVector[0] = State.mainBrain_FaceDataInterpretation_FaceDataInterpretation_Selection_3;
	}

	/* Default enter sequence for state null */
	private void enterSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation__final__default() {
		nextStateIndex = 0;
		stateVector[0] = State.mainBrain_FaceDataInterpretation_FaceDataInterpretation__final_;
	}

	/* 'default' enter sequence for state STT_1 */
	private void enterSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_STT_1_default() {
		entryAction_MainBrain_FaceDataInterpretation_FaceDataInterpretation_STT_1();

		nextStateIndex = 0;
		stateVector[0] = State.mainBrain_FaceDataInterpretation_FaceDataInterpretation_STT_1;
	}

	/* 'default' enter sequence for state STT_2 */
	private void enterSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_STT_2_default() {
		entryAction_MainBrain_FaceDataInterpretation_FaceDataInterpretation_STT_2();

		nextStateIndex = 0;
		stateVector[0] = State.mainBrain_FaceDataInterpretation_FaceDataInterpretation_STT_2;
	}

	/* 'default' enter sequence for state RandomTopic_4 */
	private void enterSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_RandomTopic_4_default() {
		entryAction_MainBrain_FaceDataInterpretation_FaceDataInterpretation_RandomTopic_4();

		nextStateIndex = 0;
		stateVector[0] = State.mainBrain_FaceDataInterpretation_FaceDataInterpretation_RandomTopic_4;
	}

	/* 'default' enter sequence for state STT_3 */
	private void enterSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_STT_3_default() {
		entryAction_MainBrain_FaceDataInterpretation_FaceDataInterpretation_STT_3();

		nextStateIndex = 0;
		stateVector[0] = State.mainBrain_FaceDataInterpretation_FaceDataInterpretation_STT_3;
	}

	/* 'default' enter sequence for state STT_4 */
	private void enterSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_STT_4_default() {
		entryAction_MainBrain_FaceDataInterpretation_FaceDataInterpretation_STT_4();

		nextStateIndex = 0;
		stateVector[0] = State.mainBrain_FaceDataInterpretation_FaceDataInterpretation_STT_4;
	}

	/* 'default' enter sequence for state AlternativeConv_2 */
	private void enterSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_AlternativeConv_2_default() {
		entryAction_MainBrain_FaceDataInterpretation_FaceDataInterpretation_AlternativeConv_2();

		nextStateIndex = 0;
		stateVector[0] = State.mainBrain_FaceDataInterpretation_FaceDataInterpretation_AlternativeConv_2;
	}

	/* 'default' enter sequence for state AboutRobotica_3 */
	private void enterSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_AboutRobotica_3_default() {
		entryAction_MainBrain_FaceDataInterpretation_FaceDataInterpretation_AboutRobotica_3();

		nextStateIndex = 0;
		stateVector[0] = State.mainBrain_FaceDataInterpretation_FaceDataInterpretation_AboutRobotica_3;
	}

	/* 'default' enter sequence for state STT_5 */
	private void enterSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_STT_5_default() {
		entryAction_MainBrain_FaceDataInterpretation_FaceDataInterpretation_STT_5();

		nextStateIndex = 0;
		stateVector[0] = State.mainBrain_FaceDataInterpretation_FaceDataInterpretation_STT_5;
	}

	/* 'default' enter sequence for state AfterGreetings_2 */
	private void enterSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_AfterGreetings_2_default() {
		entryAction_MainBrain_FaceDataInterpretation_FaceDataInterpretation_AfterGreetings_2();

		nextStateIndex = 0;
		stateVector[0] = State.mainBrain_FaceDataInterpretation_FaceDataInterpretation_AfterGreetings_2;
	}

	/* 'default' enter sequence for state Closing */
	private void enterSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Closing_default() {
		entryAction_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Closing();

		nextStateIndex = 0;
		stateVector[0] = State.mainBrain_FaceDataInterpretation_FaceDataInterpretation_Closing;
	}

	/* 'default' enter sequence for state STT_6 */
	private void enterSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_STT_6_default() {
		entryAction_MainBrain_FaceDataInterpretation_FaceDataInterpretation_STT_6();

		nextStateIndex = 0;
		stateVector[0] = State.mainBrain_FaceDataInterpretation_FaceDataInterpretation_STT_6;
	}

	/* 'default' enter sequence for state filter */
	private void enterSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_filter_default() {
		entryAction_MainBrain_FaceDataInterpretation_FaceDataInterpretation_filter();

		nextStateIndex = 0;
		stateVector[0] = State.mainBrain_FaceDataInterpretation_FaceDataInterpretation_filter;
	}

	/* 'default' enter sequence for state filter_2 */
	private void enterSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_filter_2_default() {
		entryAction_MainBrain_FaceDataInterpretation_FaceDataInterpretation_filter_2();

		nextStateIndex = 0;
		stateVector[0] = State.mainBrain_FaceDataInterpretation_FaceDataInterpretation_filter_2;
	}

	/* 'default' enter sequence for state TurnToNoise */
	private void enterSequence_MainBrain_TurnToNoise_default() {
		entryAction_MainBrain_TurnToNoise();

		nextStateIndex = 0;
		stateVector[0] = State.mainBrain_TurnToNoise;
	}

	/* 'default' enter sequence for state Idle */
	private void enterSequence_MainBrain_Idle_default() {
		nextStateIndex = 0;
		stateVector[0] = State.mainBrain_Idle;
	}

	/* 'default' enter sequence for state StopLeonie */
	private void enterSequence_MainBrain_StopLeonie_default() {
		entryAction_MainBrain_StopLeonie();

		nextStateIndex = 0;
		stateVector[0] = State.mainBrain_StopLeonie;
	}

	/* 'default' enter sequence for state SearchForChat */
	private void enterSequence_MainBrain_SearchForChat_default() {
		enterSequence_MainBrain_SearchForChat_SearchForChat_default();
	}

	/* 'default' enter sequence for state Standing */
	private void enterSequence_MainBrain_SearchForChat_SearchForChat_Standing_default() {
		entryAction_MainBrain_SearchForChat_SearchForChat_Standing();

		nextStateIndex = 0;
		stateVector[0] = State.mainBrain_SearchForChat_SearchForChat_Standing;
	}

	/* 'default' enter sequence for state Walking */
	private void enterSequence_MainBrain_SearchForChat_SearchForChat_Walking_default() {
		entryAction_MainBrain_SearchForChat_SearchForChat_Walking();

		nextStateIndex = 0;
		stateVector[0] = State.mainBrain_SearchForChat_SearchForChat_Walking;
	}

	/* 'default' enter sequence for region MainBrain */
	private void enterSequence_MainBrain_default() {
		react_MainBrain__entry_Default();
	}

	/* 'default' enter sequence for region FaceDataInterpretation */
	private void enterSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_default() {
		react_MainBrain_FaceDataInterpretation_FaceDataInterpretation__entry_Default();
	}

	/* 'default' enter sequence for region SearchForChat */
	private void enterSequence_MainBrain_SearchForChat_SearchForChat_default() {
		react_MainBrain_SearchForChat_SearchForChat__entry_Default();
	}

	/* Default exit sequence for state Init */
	private void exitSequence_MainBrain_Init() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;

		exitAction_MainBrain_Init();
	}

	/* Default exit sequence for state FaceDataInterpretation */
	private void exitSequence_MainBrain_FaceDataInterpretation() {
		exitSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation();
	}

	/* Default exit sequence for state PersonKnownWithName */
	private void exitSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_PersonKnownWithName() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for state UnknownGirl */
	private void exitSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_UnknownGirl() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for state PersonKnownWithoutName */
	private void exitSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_PersonKnownWithoutName() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for state UnknownFemaleTeen */
	private void exitSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_UnknownFemaleTeen() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for state UnknownWomen */
	private void exitSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_UnknownWomen() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for state UnknownBoy */
	private void exitSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_UnknownBoy() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for state UnknownMaleTeen */
	private void exitSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_UnknownMaleTeen() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for state UnknownMen */
	private void exitSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_UnknownMen() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for state Greetings_KnownPerson */
	private void exitSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Greetings_KnownPerson() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for state Greetings_UnknownPerson */
	private void exitSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Greetings_UnknownPerson() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for state Greetings_KnownPersonWithoutName */
	private void exitSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Greetings_KnownPersonWithoutName() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for state AboutRobotica_1 */
	private void exitSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_AboutRobotica_1() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for state AboutRobotica_2 */
	private void exitSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_AboutRobotica_2() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for state RandomTopic_1 */
	private void exitSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_RandomTopic_1() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for state RandomTopic_2 */
	private void exitSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_RandomTopic_2() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for state Prompt_2 */
	private void exitSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Prompt_2() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for state Prompt_1 */
	private void exitSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Prompt_1() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for state AfterGreetings */
	private void exitSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_AfterGreetings() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for state Farewell_1 */
	private void exitSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Farewell_1() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for state Farewell_2 */
	private void exitSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Farewell_2() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for state Farewell_3 */
	private void exitSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Farewell_3() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for state Farewell_4 */
	private void exitSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Farewell_4() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for state Selection */
	private void exitSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Selection() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for state Selection_1 */
	private void exitSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Selection_1() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for state RandomTopic_3 */
	private void exitSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_RandomTopic_3() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for state Selection_2 */
	private void exitSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Selection_2() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for state AlternativeConv_1 */
	private void exitSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_AlternativeConv_1() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for state Selection_3 */
	private void exitSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Selection_3() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for final state. */
	private void exitSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation__final_() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for state STT_1 */
	private void exitSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_STT_1() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;

		exitAction_MainBrain_FaceDataInterpretation_FaceDataInterpretation_STT_1();
	}

	/* Default exit sequence for state STT_2 */
	private void exitSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_STT_2() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;

		exitAction_MainBrain_FaceDataInterpretation_FaceDataInterpretation_STT_2();
	}

	/* Default exit sequence for state RandomTopic_4 */
	private void exitSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_RandomTopic_4() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for state STT_3 */
	private void exitSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_STT_3() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;

		exitAction_MainBrain_FaceDataInterpretation_FaceDataInterpretation_STT_3();
	}

	/* Default exit sequence for state STT_4 */
	private void exitSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_STT_4() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;

		exitAction_MainBrain_FaceDataInterpretation_FaceDataInterpretation_STT_4();
	}

	/* Default exit sequence for state AlternativeConv_2 */
	private void exitSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_AlternativeConv_2() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for state AboutRobotica_3 */
	private void exitSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_AboutRobotica_3() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for state STT_5 */
	private void exitSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_STT_5() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;

		exitAction_MainBrain_FaceDataInterpretation_FaceDataInterpretation_STT_5();
	}

	/* Default exit sequence for state AfterGreetings_2 */
	private void exitSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_AfterGreetings_2() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for state Closing */
	private void exitSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Closing() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for state STT_6 */
	private void exitSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_STT_6() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;

		exitAction_MainBrain_FaceDataInterpretation_FaceDataInterpretation_STT_6();
	}

	/* Default exit sequence for state filter */
	private void exitSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_filter() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for state filter_2 */
	private void exitSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_filter_2() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for state TurnToNoise */
	private void exitSequence_MainBrain_TurnToNoise() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for state Idle */
	private void exitSequence_MainBrain_Idle() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for state StopLeonie */
	private void exitSequence_MainBrain_StopLeonie() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for state SearchForChat */
	private void exitSequence_MainBrain_SearchForChat() {
		exitSequence_MainBrain_SearchForChat_SearchForChat();
	}

	/* Default exit sequence for state Standing */
	private void exitSequence_MainBrain_SearchForChat_SearchForChat_Standing() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;

		exitAction_MainBrain_SearchForChat_SearchForChat_Standing();
	}

	/* Default exit sequence for state Walking */
	private void exitSequence_MainBrain_SearchForChat_SearchForChat_Walking() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;

		exitAction_MainBrain_SearchForChat_SearchForChat_Walking();
	}

	/* Default exit sequence for region MainBrain */
	private void exitSequence_MainBrain() {
		switch (stateVector[0]) {
			case mainBrain_Init :
				exitSequence_MainBrain_Init();
				break;

			case mainBrain_FaceDataInterpretation_FaceDataInterpretation_PersonKnownWithName :
				exitSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_PersonKnownWithName();
				break;

			case mainBrain_FaceDataInterpretation_FaceDataInterpretation_UnknownGirl :
				exitSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_UnknownGirl();
				break;

			case mainBrain_FaceDataInterpretation_FaceDataInterpretation_PersonKnownWithoutName :
				exitSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_PersonKnownWithoutName();
				break;

			case mainBrain_FaceDataInterpretation_FaceDataInterpretation_UnknownFemaleTeen :
				exitSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_UnknownFemaleTeen();
				break;

			case mainBrain_FaceDataInterpretation_FaceDataInterpretation_UnknownWomen :
				exitSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_UnknownWomen();
				break;

			case mainBrain_FaceDataInterpretation_FaceDataInterpretation_UnknownBoy :
				exitSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_UnknownBoy();
				break;

			case mainBrain_FaceDataInterpretation_FaceDataInterpretation_UnknownMaleTeen :
				exitSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_UnknownMaleTeen();
				break;

			case mainBrain_FaceDataInterpretation_FaceDataInterpretation_UnknownMen :
				exitSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_UnknownMen();
				break;

			case mainBrain_FaceDataInterpretation_FaceDataInterpretation_Greetings_KnownPerson :
				exitSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Greetings_KnownPerson();
				break;

			case mainBrain_FaceDataInterpretation_FaceDataInterpretation_Greetings_UnknownPerson :
				exitSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Greetings_UnknownPerson();
				break;

			case mainBrain_FaceDataInterpretation_FaceDataInterpretation_Greetings_KnownPersonWithoutName :
				exitSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Greetings_KnownPersonWithoutName();
				break;

			case mainBrain_FaceDataInterpretation_FaceDataInterpretation_AboutRobotica_1 :
				exitSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_AboutRobotica_1();
				break;

			case mainBrain_FaceDataInterpretation_FaceDataInterpretation_AboutRobotica_2 :
				exitSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_AboutRobotica_2();
				break;

			case mainBrain_FaceDataInterpretation_FaceDataInterpretation_RandomTopic_1 :
				exitSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_RandomTopic_1();
				break;

			case mainBrain_FaceDataInterpretation_FaceDataInterpretation_RandomTopic_2 :
				exitSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_RandomTopic_2();
				break;

			case mainBrain_FaceDataInterpretation_FaceDataInterpretation_Prompt_2 :
				exitSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Prompt_2();
				break;

			case mainBrain_FaceDataInterpretation_FaceDataInterpretation_Prompt_1 :
				exitSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Prompt_1();
				break;

			case mainBrain_FaceDataInterpretation_FaceDataInterpretation_AfterGreetings :
				exitSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_AfterGreetings();
				break;

			case mainBrain_FaceDataInterpretation_FaceDataInterpretation_Farewell_1 :
				exitSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Farewell_1();
				break;

			case mainBrain_FaceDataInterpretation_FaceDataInterpretation_Farewell_2 :
				exitSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Farewell_2();
				break;

			case mainBrain_FaceDataInterpretation_FaceDataInterpretation_Farewell_3 :
				exitSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Farewell_3();
				break;

			case mainBrain_FaceDataInterpretation_FaceDataInterpretation_Farewell_4 :
				exitSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Farewell_4();
				break;

			case mainBrain_FaceDataInterpretation_FaceDataInterpretation_Selection :
				exitSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Selection();
				break;

			case mainBrain_FaceDataInterpretation_FaceDataInterpretation_Selection_1 :
				exitSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Selection_1();
				break;

			case mainBrain_FaceDataInterpretation_FaceDataInterpretation_RandomTopic_3 :
				exitSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_RandomTopic_3();
				break;

			case mainBrain_FaceDataInterpretation_FaceDataInterpretation_Selection_2 :
				exitSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Selection_2();
				break;

			case mainBrain_FaceDataInterpretation_FaceDataInterpretation_AlternativeConv_1 :
				exitSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_AlternativeConv_1();
				break;

			case mainBrain_FaceDataInterpretation_FaceDataInterpretation_Selection_3 :
				exitSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Selection_3();
				break;

			case mainBrain_FaceDataInterpretation_FaceDataInterpretation__final_ :
				exitSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation__final_();
				break;

			case mainBrain_FaceDataInterpretation_FaceDataInterpretation_STT_1 :
				exitSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_STT_1();
				break;

			case mainBrain_FaceDataInterpretation_FaceDataInterpretation_STT_2 :
				exitSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_STT_2();
				break;

			case mainBrain_FaceDataInterpretation_FaceDataInterpretation_RandomTopic_4 :
				exitSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_RandomTopic_4();
				break;

			case mainBrain_FaceDataInterpretation_FaceDataInterpretation_STT_3 :
				exitSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_STT_3();
				break;

			case mainBrain_FaceDataInterpretation_FaceDataInterpretation_STT_4 :
				exitSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_STT_4();
				break;

			case mainBrain_FaceDataInterpretation_FaceDataInterpretation_AlternativeConv_2 :
				exitSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_AlternativeConv_2();
				break;

			case mainBrain_FaceDataInterpretation_FaceDataInterpretation_AboutRobotica_3 :
				exitSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_AboutRobotica_3();
				break;

			case mainBrain_FaceDataInterpretation_FaceDataInterpretation_STT_5 :
				exitSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_STT_5();
				break;

			case mainBrain_FaceDataInterpretation_FaceDataInterpretation_AfterGreetings_2 :
				exitSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_AfterGreetings_2();
				break;

			case mainBrain_FaceDataInterpretation_FaceDataInterpretation_Closing :
				exitSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Closing();
				break;

			case mainBrain_FaceDataInterpretation_FaceDataInterpretation_STT_6 :
				exitSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_STT_6();
				break;

			case mainBrain_FaceDataInterpretation_FaceDataInterpretation_filter :
				exitSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_filter();
				break;

			case mainBrain_FaceDataInterpretation_FaceDataInterpretation_filter_2 :
				exitSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_filter_2();
				break;

			case mainBrain_TurnToNoise :
				exitSequence_MainBrain_TurnToNoise();
				break;

			case mainBrain_Idle :
				exitSequence_MainBrain_Idle();
				break;

			case mainBrain_StopLeonie :
				exitSequence_MainBrain_StopLeonie();
				break;

			case mainBrain_SearchForChat_SearchForChat_Standing :
				exitSequence_MainBrain_SearchForChat_SearchForChat_Standing();
				break;

			case mainBrain_SearchForChat_SearchForChat_Walking :
				exitSequence_MainBrain_SearchForChat_SearchForChat_Walking();
				break;

			default :
				break;
		}
	}

	/* Default exit sequence for region FaceDataInterpretation */
	private void exitSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation() {
		switch (stateVector[0]) {
			case mainBrain_FaceDataInterpretation_FaceDataInterpretation_PersonKnownWithName :
				exitSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_PersonKnownWithName();
				break;

			case mainBrain_FaceDataInterpretation_FaceDataInterpretation_UnknownGirl :
				exitSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_UnknownGirl();
				break;

			case mainBrain_FaceDataInterpretation_FaceDataInterpretation_PersonKnownWithoutName :
				exitSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_PersonKnownWithoutName();
				break;

			case mainBrain_FaceDataInterpretation_FaceDataInterpretation_UnknownFemaleTeen :
				exitSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_UnknownFemaleTeen();
				break;

			case mainBrain_FaceDataInterpretation_FaceDataInterpretation_UnknownWomen :
				exitSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_UnknownWomen();
				break;

			case mainBrain_FaceDataInterpretation_FaceDataInterpretation_UnknownBoy :
				exitSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_UnknownBoy();
				break;

			case mainBrain_FaceDataInterpretation_FaceDataInterpretation_UnknownMaleTeen :
				exitSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_UnknownMaleTeen();
				break;

			case mainBrain_FaceDataInterpretation_FaceDataInterpretation_UnknownMen :
				exitSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_UnknownMen();
				break;

			case mainBrain_FaceDataInterpretation_FaceDataInterpretation_Greetings_KnownPerson :
				exitSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Greetings_KnownPerson();
				break;

			case mainBrain_FaceDataInterpretation_FaceDataInterpretation_Greetings_UnknownPerson :
				exitSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Greetings_UnknownPerson();
				break;

			case mainBrain_FaceDataInterpretation_FaceDataInterpretation_Greetings_KnownPersonWithoutName :
				exitSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Greetings_KnownPersonWithoutName();
				break;

			case mainBrain_FaceDataInterpretation_FaceDataInterpretation_AboutRobotica_1 :
				exitSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_AboutRobotica_1();
				break;

			case mainBrain_FaceDataInterpretation_FaceDataInterpretation_AboutRobotica_2 :
				exitSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_AboutRobotica_2();
				break;

			case mainBrain_FaceDataInterpretation_FaceDataInterpretation_RandomTopic_1 :
				exitSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_RandomTopic_1();
				break;

			case mainBrain_FaceDataInterpretation_FaceDataInterpretation_RandomTopic_2 :
				exitSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_RandomTopic_2();
				break;

			case mainBrain_FaceDataInterpretation_FaceDataInterpretation_Prompt_2 :
				exitSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Prompt_2();
				break;

			case mainBrain_FaceDataInterpretation_FaceDataInterpretation_Prompt_1 :
				exitSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Prompt_1();
				break;

			case mainBrain_FaceDataInterpretation_FaceDataInterpretation_AfterGreetings :
				exitSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_AfterGreetings();
				break;

			case mainBrain_FaceDataInterpretation_FaceDataInterpretation_Farewell_1 :
				exitSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Farewell_1();
				break;

			case mainBrain_FaceDataInterpretation_FaceDataInterpretation_Farewell_2 :
				exitSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Farewell_2();
				break;

			case mainBrain_FaceDataInterpretation_FaceDataInterpretation_Farewell_3 :
				exitSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Farewell_3();
				break;

			case mainBrain_FaceDataInterpretation_FaceDataInterpretation_Farewell_4 :
				exitSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Farewell_4();
				break;

			case mainBrain_FaceDataInterpretation_FaceDataInterpretation_Selection :
				exitSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Selection();
				break;

			case mainBrain_FaceDataInterpretation_FaceDataInterpretation_Selection_1 :
				exitSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Selection_1();
				break;

			case mainBrain_FaceDataInterpretation_FaceDataInterpretation_RandomTopic_3 :
				exitSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_RandomTopic_3();
				break;

			case mainBrain_FaceDataInterpretation_FaceDataInterpretation_Selection_2 :
				exitSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Selection_2();
				break;

			case mainBrain_FaceDataInterpretation_FaceDataInterpretation_AlternativeConv_1 :
				exitSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_AlternativeConv_1();
				break;

			case mainBrain_FaceDataInterpretation_FaceDataInterpretation_Selection_3 :
				exitSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Selection_3();
				break;

			case mainBrain_FaceDataInterpretation_FaceDataInterpretation__final_ :
				exitSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation__final_();
				break;

			case mainBrain_FaceDataInterpretation_FaceDataInterpretation_STT_1 :
				exitSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_STT_1();
				break;

			case mainBrain_FaceDataInterpretation_FaceDataInterpretation_STT_2 :
				exitSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_STT_2();
				break;

			case mainBrain_FaceDataInterpretation_FaceDataInterpretation_RandomTopic_4 :
				exitSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_RandomTopic_4();
				break;

			case mainBrain_FaceDataInterpretation_FaceDataInterpretation_STT_3 :
				exitSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_STT_3();
				break;

			case mainBrain_FaceDataInterpretation_FaceDataInterpretation_STT_4 :
				exitSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_STT_4();
				break;

			case mainBrain_FaceDataInterpretation_FaceDataInterpretation_AlternativeConv_2 :
				exitSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_AlternativeConv_2();
				break;

			case mainBrain_FaceDataInterpretation_FaceDataInterpretation_AboutRobotica_3 :
				exitSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_AboutRobotica_3();
				break;

			case mainBrain_FaceDataInterpretation_FaceDataInterpretation_STT_5 :
				exitSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_STT_5();
				break;

			case mainBrain_FaceDataInterpretation_FaceDataInterpretation_AfterGreetings_2 :
				exitSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_AfterGreetings_2();
				break;

			case mainBrain_FaceDataInterpretation_FaceDataInterpretation_Closing :
				exitSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Closing();
				break;

			case mainBrain_FaceDataInterpretation_FaceDataInterpretation_STT_6 :
				exitSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_STT_6();
				break;

			case mainBrain_FaceDataInterpretation_FaceDataInterpretation_filter :
				exitSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_filter();
				break;

			case mainBrain_FaceDataInterpretation_FaceDataInterpretation_filter_2 :
				exitSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_filter_2();
				break;

			default :
				break;
		}
	}

	/* Default exit sequence for region SearchForChat */
	private void exitSequence_MainBrain_SearchForChat_SearchForChat() {
		switch (stateVector[0]) {
			case mainBrain_SearchForChat_SearchForChat_Standing :
				exitSequence_MainBrain_SearchForChat_SearchForChat_Standing();
				break;

			case mainBrain_SearchForChat_SearchForChat_Walking :
				exitSequence_MainBrain_SearchForChat_SearchForChat_Walking();
				break;

			default :
				break;
		}
	}

	/* The reactions of state Init. */
	private void react_MainBrain_Init() {
		if (check_MainBrain_Init_tr0_tr0()) {
			effect_MainBrain_Init_tr0();
		} else {
			if (check_MainBrain_Init_tr1_tr1()) {
				effect_MainBrain_Init_tr1();
			} else {
				if (check_MainBrain_Init_tr2_tr2()) {
					effect_MainBrain_Init_tr2();
				}
			}
		}
	}

	/* The reactions of state PersonKnownWithName. */
	private void react_MainBrain_FaceDataInterpretation_FaceDataInterpretation_PersonKnownWithName() {
		if (check_MainBrain_FaceDataInterpretation_tr0_tr0()) {
			effect_MainBrain_FaceDataInterpretation_tr0();
		} else {
			effect_MainBrain_FaceDataInterpretation_FaceDataInterpretation_PersonKnownWithName_tr0();
		}
	}

	/* The reactions of state UnknownGirl. */
	private void react_MainBrain_FaceDataInterpretation_FaceDataInterpretation_UnknownGirl() {
		if (check_MainBrain_FaceDataInterpretation_tr0_tr0()) {
			effect_MainBrain_FaceDataInterpretation_tr0();
		} else {
			if (check_MainBrain_FaceDataInterpretation_FaceDataInterpretation_UnknownGirl_tr0_tr0()) {
				effect_MainBrain_FaceDataInterpretation_FaceDataInterpretation_UnknownGirl_tr0();
			}
		}
	}

	/* The reactions of state PersonKnownWithoutName. */
	private void react_MainBrain_FaceDataInterpretation_FaceDataInterpretation_PersonKnownWithoutName() {
		if (check_MainBrain_FaceDataInterpretation_tr0_tr0()) {
			effect_MainBrain_FaceDataInterpretation_tr0();
		} else {
			effect_MainBrain_FaceDataInterpretation_FaceDataInterpretation_PersonKnownWithoutName_tr0();
		}
	}

	/* The reactions of state UnknownFemaleTeen. */
	private void react_MainBrain_FaceDataInterpretation_FaceDataInterpretation_UnknownFemaleTeen() {
		if (check_MainBrain_FaceDataInterpretation_tr0_tr0()) {
			effect_MainBrain_FaceDataInterpretation_tr0();
		} else {
			if (check_MainBrain_FaceDataInterpretation_FaceDataInterpretation_UnknownFemaleTeen_tr0_tr0()) {
				effect_MainBrain_FaceDataInterpretation_FaceDataInterpretation_UnknownFemaleTeen_tr0();
			}
		}
	}

	/* The reactions of state UnknownWomen. */
	private void react_MainBrain_FaceDataInterpretation_FaceDataInterpretation_UnknownWomen() {
		if (check_MainBrain_FaceDataInterpretation_tr0_tr0()) {
			effect_MainBrain_FaceDataInterpretation_tr0();
		} else {
			if (check_MainBrain_FaceDataInterpretation_FaceDataInterpretation_UnknownWomen_tr0_tr0()) {
				effect_MainBrain_FaceDataInterpretation_FaceDataInterpretation_UnknownWomen_tr0();
			}
		}
	}

	/* The reactions of state UnknownBoy. */
	private void react_MainBrain_FaceDataInterpretation_FaceDataInterpretation_UnknownBoy() {
		if (check_MainBrain_FaceDataInterpretation_tr0_tr0()) {
			effect_MainBrain_FaceDataInterpretation_tr0();
		} else {
			if (check_MainBrain_FaceDataInterpretation_FaceDataInterpretation_UnknownBoy_tr0_tr0()) {
				effect_MainBrain_FaceDataInterpretation_FaceDataInterpretation_UnknownBoy_tr0();
			}
		}
	}

	/* The reactions of state UnknownMaleTeen. */
	private void react_MainBrain_FaceDataInterpretation_FaceDataInterpretation_UnknownMaleTeen() {
		if (check_MainBrain_FaceDataInterpretation_tr0_tr0()) {
			effect_MainBrain_FaceDataInterpretation_tr0();
		} else {
			if (check_MainBrain_FaceDataInterpretation_FaceDataInterpretation_UnknownMaleTeen_tr0_tr0()) {
				effect_MainBrain_FaceDataInterpretation_FaceDataInterpretation_UnknownMaleTeen_tr0();
			}
		}
	}

	/* The reactions of state UnknownMen. */
	private void react_MainBrain_FaceDataInterpretation_FaceDataInterpretation_UnknownMen() {
		if (check_MainBrain_FaceDataInterpretation_tr0_tr0()) {
			effect_MainBrain_FaceDataInterpretation_tr0();
		} else {
			if (check_MainBrain_FaceDataInterpretation_FaceDataInterpretation_UnknownMen_tr0_tr0()) {
				effect_MainBrain_FaceDataInterpretation_FaceDataInterpretation_UnknownMen_tr0();
			}
		}
	}

	/* The reactions of state Greetings_KnownPerson. */
	private void react_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Greetings_KnownPerson() {
		if (check_MainBrain_FaceDataInterpretation_tr0_tr0()) {
			effect_MainBrain_FaceDataInterpretation_tr0();
		} else {
			if (check_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Greetings_KnownPerson_tr0_tr0()) {
				effect_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Greetings_KnownPerson_tr0();
			}
		}
	}

	/* The reactions of state Greetings_UnknownPerson. */
	private void react_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Greetings_UnknownPerson() {
		if (check_MainBrain_FaceDataInterpretation_tr0_tr0()) {
			effect_MainBrain_FaceDataInterpretation_tr0();
		} else {
			if (check_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Greetings_UnknownPerson_tr0_tr0()) {
				effect_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Greetings_UnknownPerson_tr0();
			}
		}
	}

	/* The reactions of state Greetings_KnownPersonWithoutName. */
	private void react_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Greetings_KnownPersonWithoutName() {
		if (check_MainBrain_FaceDataInterpretation_tr0_tr0()) {
			effect_MainBrain_FaceDataInterpretation_tr0();
		} else {
			if (check_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Greetings_KnownPersonWithoutName_tr0_tr0()) {
				effect_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Greetings_KnownPersonWithoutName_tr0();
			}
		}
	}

	/* The reactions of state AboutRobotica_1. */
	private void react_MainBrain_FaceDataInterpretation_FaceDataInterpretation_AboutRobotica_1() {
		if (check_MainBrain_FaceDataInterpretation_tr0_tr0()) {
			effect_MainBrain_FaceDataInterpretation_tr0();
		} else {
			if (check_MainBrain_FaceDataInterpretation_FaceDataInterpretation_AboutRobotica_1_tr0_tr0()) {
				effect_MainBrain_FaceDataInterpretation_FaceDataInterpretation_AboutRobotica_1_tr0();
			}
		}
	}

	/* The reactions of state AboutRobotica_2. */
	private void react_MainBrain_FaceDataInterpretation_FaceDataInterpretation_AboutRobotica_2() {
		if (check_MainBrain_FaceDataInterpretation_tr0_tr0()) {
			effect_MainBrain_FaceDataInterpretation_tr0();
		} else {
			if (check_MainBrain_FaceDataInterpretation_FaceDataInterpretation_AboutRobotica_2_tr0_tr0()) {
				effect_MainBrain_FaceDataInterpretation_FaceDataInterpretation_AboutRobotica_2_tr0();
			}
		}
	}

	/* The reactions of state RandomTopic_1. */
	private void react_MainBrain_FaceDataInterpretation_FaceDataInterpretation_RandomTopic_1() {
		if (check_MainBrain_FaceDataInterpretation_tr0_tr0()) {
			effect_MainBrain_FaceDataInterpretation_tr0();
		} else {
			if (check_MainBrain_FaceDataInterpretation_FaceDataInterpretation_RandomTopic_1_tr0_tr0()) {
				effect_MainBrain_FaceDataInterpretation_FaceDataInterpretation_RandomTopic_1_tr0();
			}
		}
	}

	/* The reactions of state RandomTopic_2. */
	private void react_MainBrain_FaceDataInterpretation_FaceDataInterpretation_RandomTopic_2() {
		if (check_MainBrain_FaceDataInterpretation_tr0_tr0()) {
			effect_MainBrain_FaceDataInterpretation_tr0();
		} else {
			if (check_MainBrain_FaceDataInterpretation_FaceDataInterpretation_RandomTopic_2_tr0_tr0()) {
				effect_MainBrain_FaceDataInterpretation_FaceDataInterpretation_RandomTopic_2_tr0();
			}
		}
	}

	/* The reactions of state Prompt_2. */
	private void react_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Prompt_2() {
		if (check_MainBrain_FaceDataInterpretation_tr0_tr0()) {
			effect_MainBrain_FaceDataInterpretation_tr0();
		} else {
			if (check_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Prompt_2_tr0_tr0()) {
				effect_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Prompt_2_tr0();
			}
		}
	}

	/* The reactions of state Prompt_1. */
	private void react_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Prompt_1() {
		if (check_MainBrain_FaceDataInterpretation_tr0_tr0()) {
			effect_MainBrain_FaceDataInterpretation_tr0();
		} else {
			if (check_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Prompt_1_tr0_tr0()) {
				effect_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Prompt_1_tr0();
			}
		}
	}

	/* The reactions of state AfterGreetings. */
	private void react_MainBrain_FaceDataInterpretation_FaceDataInterpretation_AfterGreetings() {
		if (check_MainBrain_FaceDataInterpretation_tr0_tr0()) {
			effect_MainBrain_FaceDataInterpretation_tr0();
		} else {
			if (check_MainBrain_FaceDataInterpretation_FaceDataInterpretation_AfterGreetings_tr0_tr0()) {
				effect_MainBrain_FaceDataInterpretation_FaceDataInterpretation_AfterGreetings_tr0();
			}
		}
	}

	/* The reactions of state Farewell_1. */
	private void react_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Farewell_1() {
		if (check_MainBrain_FaceDataInterpretation_tr0_tr0()) {
			effect_MainBrain_FaceDataInterpretation_tr0();
		} else {
			if (check_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Farewell_1_tr0_tr0()) {
				effect_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Farewell_1_tr0();
			}
		}
	}

	/* The reactions of state Farewell_2. */
	private void react_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Farewell_2() {
		if (check_MainBrain_FaceDataInterpretation_tr0_tr0()) {
			effect_MainBrain_FaceDataInterpretation_tr0();
		} else {
			if (check_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Farewell_2_tr0_tr0()) {
				effect_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Farewell_2_tr0();
			}
		}
	}

	/* The reactions of state Farewell_3. */
	private void react_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Farewell_3() {
		if (check_MainBrain_FaceDataInterpretation_tr0_tr0()) {
			effect_MainBrain_FaceDataInterpretation_tr0();
		} else {
			if (check_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Farewell_3_tr0_tr0()) {
				effect_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Farewell_3_tr0();
			}
		}
	}

	/* The reactions of state Farewell_4. */
	private void react_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Farewell_4() {
		if (check_MainBrain_FaceDataInterpretation_tr0_tr0()) {
			effect_MainBrain_FaceDataInterpretation_tr0();
		} else {
			if (check_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Farewell_4_tr0_tr0()) {
				effect_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Farewell_4_tr0();
			}
		}
	}

	/* The reactions of state Selection. */
	private void react_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Selection() {
		if (check_MainBrain_FaceDataInterpretation_tr0_tr0()) {
			effect_MainBrain_FaceDataInterpretation_tr0();
		} else {
			effect_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Selection_tr0();
		}
	}

	/* The reactions of state Selection_1. */
	private void react_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Selection_1() {
		if (check_MainBrain_FaceDataInterpretation_tr0_tr0()) {
			effect_MainBrain_FaceDataInterpretation_tr0();
		} else {
			if (check_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Selection_1_tr0_tr0()) {
				effect_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Selection_1_tr0();
			} else {
				effect_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Selection_1_tr1();
			}
		}
	}

	/* The reactions of state RandomTopic_3. */
	private void react_MainBrain_FaceDataInterpretation_FaceDataInterpretation_RandomTopic_3() {
		if (check_MainBrain_FaceDataInterpretation_tr0_tr0()) {
			effect_MainBrain_FaceDataInterpretation_tr0();
		} else {
			if (check_MainBrain_FaceDataInterpretation_FaceDataInterpretation_RandomTopic_3_tr0_tr0()) {
				effect_MainBrain_FaceDataInterpretation_FaceDataInterpretation_RandomTopic_3_tr0();
			}
		}
	}

	/* The reactions of state Selection_2. */
	private void react_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Selection_2() {
		if (check_MainBrain_FaceDataInterpretation_tr0_tr0()) {
			effect_MainBrain_FaceDataInterpretation_tr0();
		} else {
			if (check_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Selection_2_tr0_tr0()) {
				effect_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Selection_2_tr0();
			} else {
				effect_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Selection_2_tr1();
			}
		}
	}

	/* The reactions of state AlternativeConv_1. */
	private void react_MainBrain_FaceDataInterpretation_FaceDataInterpretation_AlternativeConv_1() {
		if (check_MainBrain_FaceDataInterpretation_tr0_tr0()) {
			effect_MainBrain_FaceDataInterpretation_tr0();
		} else {
			if (check_MainBrain_FaceDataInterpretation_FaceDataInterpretation_AlternativeConv_1_tr0_tr0()) {
				effect_MainBrain_FaceDataInterpretation_FaceDataInterpretation_AlternativeConv_1_tr0();
			}
		}
	}

	/* The reactions of state Selection_3. */
	private void react_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Selection_3() {
		if (check_MainBrain_FaceDataInterpretation_tr0_tr0()) {
			effect_MainBrain_FaceDataInterpretation_tr0();
		} else {
			effect_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Selection_3_tr0();
		}
	}

	/* The reactions of state null. */
	private void react_MainBrain_FaceDataInterpretation_FaceDataInterpretation__final_() {
		if (check_MainBrain_FaceDataInterpretation_tr0_tr0()) {
			effect_MainBrain_FaceDataInterpretation_tr0();
		} else {
		}
	}

	/* The reactions of state STT_1. */
	private void react_MainBrain_FaceDataInterpretation_FaceDataInterpretation_STT_1() {
		if (check_MainBrain_FaceDataInterpretation_tr0_tr0()) {
			effect_MainBrain_FaceDataInterpretation_tr0();
		} else {
			if (check_MainBrain_FaceDataInterpretation_FaceDataInterpretation_STT_1_tr0_tr0()) {
				effect_MainBrain_FaceDataInterpretation_FaceDataInterpretation_STT_1_tr0();
			}
		}
	}

	/* The reactions of state STT_2. */
	private void react_MainBrain_FaceDataInterpretation_FaceDataInterpretation_STT_2() {
		if (check_MainBrain_FaceDataInterpretation_tr0_tr0()) {
			effect_MainBrain_FaceDataInterpretation_tr0();
		} else {
			if (check_MainBrain_FaceDataInterpretation_FaceDataInterpretation_STT_2_tr0_tr0()) {
				effect_MainBrain_FaceDataInterpretation_FaceDataInterpretation_STT_2_tr0();
			}
		}
	}

	/* The reactions of state RandomTopic_4. */
	private void react_MainBrain_FaceDataInterpretation_FaceDataInterpretation_RandomTopic_4() {
		if (check_MainBrain_FaceDataInterpretation_tr0_tr0()) {
			effect_MainBrain_FaceDataInterpretation_tr0();
		} else {
			if (check_MainBrain_FaceDataInterpretation_FaceDataInterpretation_RandomTopic_4_tr0_tr0()) {
				effect_MainBrain_FaceDataInterpretation_FaceDataInterpretation_RandomTopic_4_tr0();
			}
		}
	}

	/* The reactions of state STT_3. */
	private void react_MainBrain_FaceDataInterpretation_FaceDataInterpretation_STT_3() {
		if (check_MainBrain_FaceDataInterpretation_tr0_tr0()) {
			effect_MainBrain_FaceDataInterpretation_tr0();
		} else {
			if (check_MainBrain_FaceDataInterpretation_FaceDataInterpretation_STT_3_tr0_tr0()) {
				effect_MainBrain_FaceDataInterpretation_FaceDataInterpretation_STT_3_tr0();
			}
		}
	}

	/* The reactions of state STT_4. */
	private void react_MainBrain_FaceDataInterpretation_FaceDataInterpretation_STT_4() {
		if (check_MainBrain_FaceDataInterpretation_tr0_tr0()) {
			effect_MainBrain_FaceDataInterpretation_tr0();
		} else {
			if (check_MainBrain_FaceDataInterpretation_FaceDataInterpretation_STT_4_tr0_tr0()) {
				effect_MainBrain_FaceDataInterpretation_FaceDataInterpretation_STT_4_tr0();
			}
		}
	}

	/* The reactions of state AlternativeConv_2. */
	private void react_MainBrain_FaceDataInterpretation_FaceDataInterpretation_AlternativeConv_2() {
		if (check_MainBrain_FaceDataInterpretation_tr0_tr0()) {
			effect_MainBrain_FaceDataInterpretation_tr0();
		} else {
			if (check_MainBrain_FaceDataInterpretation_FaceDataInterpretation_AlternativeConv_2_tr0_tr0()) {
				effect_MainBrain_FaceDataInterpretation_FaceDataInterpretation_AlternativeConv_2_tr0();
			}
		}
	}

	/* The reactions of state AboutRobotica_3. */
	private void react_MainBrain_FaceDataInterpretation_FaceDataInterpretation_AboutRobotica_3() {
		if (check_MainBrain_FaceDataInterpretation_tr0_tr0()) {
			effect_MainBrain_FaceDataInterpretation_tr0();
		} else {
			if (check_MainBrain_FaceDataInterpretation_FaceDataInterpretation_AboutRobotica_3_tr0_tr0()) {
				effect_MainBrain_FaceDataInterpretation_FaceDataInterpretation_AboutRobotica_3_tr0();
			}
		}
	}

	/* The reactions of state STT_5. */
	private void react_MainBrain_FaceDataInterpretation_FaceDataInterpretation_STT_5() {
		if (check_MainBrain_FaceDataInterpretation_tr0_tr0()) {
			effect_MainBrain_FaceDataInterpretation_tr0();
		} else {
			if (check_MainBrain_FaceDataInterpretation_FaceDataInterpretation_STT_5_tr0_tr0()) {
				effect_MainBrain_FaceDataInterpretation_FaceDataInterpretation_STT_5_tr0();
			}
		}
	}

	/* The reactions of state AfterGreetings_2. */
	private void react_MainBrain_FaceDataInterpretation_FaceDataInterpretation_AfterGreetings_2() {
		if (check_MainBrain_FaceDataInterpretation_tr0_tr0()) {
			effect_MainBrain_FaceDataInterpretation_tr0();
		} else {
			if (check_MainBrain_FaceDataInterpretation_FaceDataInterpretation_AfterGreetings_2_tr0_tr0()) {
				effect_MainBrain_FaceDataInterpretation_FaceDataInterpretation_AfterGreetings_2_tr0();
			}
		}
	}

	/* The reactions of state Closing. */
	private void react_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Closing() {
		if (check_MainBrain_FaceDataInterpretation_tr0_tr0()) {
			effect_MainBrain_FaceDataInterpretation_tr0();
		} else {
			if (check_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Closing_tr0_tr0()) {
				effect_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Closing_tr0();
			}
		}
	}

	/* The reactions of state STT_6. */
	private void react_MainBrain_FaceDataInterpretation_FaceDataInterpretation_STT_6() {
		if (check_MainBrain_FaceDataInterpretation_tr0_tr0()) {
			effect_MainBrain_FaceDataInterpretation_tr0();
		} else {
			if (check_MainBrain_FaceDataInterpretation_FaceDataInterpretation_STT_6_tr0_tr0()) {
				effect_MainBrain_FaceDataInterpretation_FaceDataInterpretation_STT_6_tr0();
			}
		}
	}

	/* The reactions of state filter. */
	private void react_MainBrain_FaceDataInterpretation_FaceDataInterpretation_filter() {
		if (check_MainBrain_FaceDataInterpretation_tr0_tr0()) {
			effect_MainBrain_FaceDataInterpretation_tr0();
		} else {
			if (check_MainBrain_FaceDataInterpretation_FaceDataInterpretation_filter_tr0_tr0()) {
				effect_MainBrain_FaceDataInterpretation_FaceDataInterpretation_filter_tr0();
			} else {
				effect_MainBrain_FaceDataInterpretation_FaceDataInterpretation_filter_tr1();
			}
		}
	}

	/* The reactions of state filter_2. */
	private void react_MainBrain_FaceDataInterpretation_FaceDataInterpretation_filter_2() {
		if (check_MainBrain_FaceDataInterpretation_tr0_tr0()) {
			effect_MainBrain_FaceDataInterpretation_tr0();
		} else {
			if (check_MainBrain_FaceDataInterpretation_FaceDataInterpretation_filter_2_tr0_tr0()) {
				effect_MainBrain_FaceDataInterpretation_FaceDataInterpretation_filter_2_tr0();
			} else {
				effect_MainBrain_FaceDataInterpretation_FaceDataInterpretation_filter_2_tr1();
			}
		}
	}

	/* The reactions of state TurnToNoise. */
	private void react_MainBrain_TurnToNoise() {
		if (check_MainBrain_TurnToNoise_tr0_tr0()) {
			effect_MainBrain_TurnToNoise_tr0();
		} else {
			if (check_MainBrain_TurnToNoise_tr1_tr1()) {
				effect_MainBrain_TurnToNoise_tr1();
			}
		}
	}

	/* The reactions of state Idle. */
	private void react_MainBrain_Idle() {
	}

	/* The reactions of state StopLeonie. */
	private void react_MainBrain_StopLeonie() {
		if (check_MainBrain_StopLeonie_tr0_tr0()) {
			effect_MainBrain_StopLeonie_tr0();
		}
	}

	/* The reactions of state Standing. */
	private void react_MainBrain_SearchForChat_SearchForChat_Standing() {
		if (check_MainBrain_SearchForChat_tr0_tr0()) {
			effect_MainBrain_SearchForChat_tr0();
		} else {
			if (check_MainBrain_SearchForChat_SearchForChat_Standing_tr0_tr0()) {
				effect_MainBrain_SearchForChat_SearchForChat_Standing_tr0();
			}
		}
	}

	/* The reactions of state Walking. */
	private void react_MainBrain_SearchForChat_SearchForChat_Walking() {
		if (check_MainBrain_SearchForChat_tr0_tr0()) {
			effect_MainBrain_SearchForChat_tr0();
		} else {
			if (check_MainBrain_SearchForChat_SearchForChat_Walking_tr0_tr0()) {
				effect_MainBrain_SearchForChat_SearchForChat_Walking_tr0();
			}
		}
	}

	/* The reactions of state null. */
	private void react_MainBrain_FaceDataInterpretation_FaceDataInterpretation__choice_0() {
		if (check_MainBrain_FaceDataInterpretation_FaceDataInterpretation__choice_0_tr1_tr1()) {
			effect_MainBrain_FaceDataInterpretation_FaceDataInterpretation__choice_0_tr1();
		} else {
			effect_MainBrain_FaceDataInterpretation_FaceDataInterpretation__choice_0_tr0();
		}
	}

	/* The reactions of state null. */
	private void react_MainBrain_FaceDataInterpretation_FaceDataInterpretation__choice_1() {
		if (check_MainBrain_FaceDataInterpretation_FaceDataInterpretation__choice_1_tr0_tr0()) {
			effect_MainBrain_FaceDataInterpretation_FaceDataInterpretation__choice_1_tr0();
		} else {
			effect_MainBrain_FaceDataInterpretation_FaceDataInterpretation__choice_1_tr1();
		}
	}

	/* The reactions of state null. */
	private void react_MainBrain_FaceDataInterpretation_FaceDataInterpretation__choice_2() {
		if (check_MainBrain_FaceDataInterpretation_FaceDataInterpretation__choice_2_tr0_tr0()) {
			effect_MainBrain_FaceDataInterpretation_FaceDataInterpretation__choice_2_tr0();
		} else {
			effect_MainBrain_FaceDataInterpretation_FaceDataInterpretation__choice_2_tr1();
		}
	}

	/* The reactions of state null. */
	private void react_MainBrain_FaceDataInterpretation_FaceDataInterpretation__choice_3() {
		if (check_MainBrain_FaceDataInterpretation_FaceDataInterpretation__choice_3_tr0_tr0()) {
			effect_MainBrain_FaceDataInterpretation_FaceDataInterpretation__choice_3_tr0();
		} else {
			if (check_MainBrain_FaceDataInterpretation_FaceDataInterpretation__choice_3_tr2_tr2()) {
				effect_MainBrain_FaceDataInterpretation_FaceDataInterpretation__choice_3_tr2();
			} else {
				effect_MainBrain_FaceDataInterpretation_FaceDataInterpretation__choice_3_tr1();
			}
		}
	}

	/* The reactions of state null. */
	private void react_MainBrain_FaceDataInterpretation_FaceDataInterpretation__choice_4() {
		if (check_MainBrain_FaceDataInterpretation_FaceDataInterpretation__choice_4_tr0_tr0()) {
			effect_MainBrain_FaceDataInterpretation_FaceDataInterpretation__choice_4_tr0();
		} else {
			if (check_MainBrain_FaceDataInterpretation_FaceDataInterpretation__choice_4_tr1_tr1()) {
				effect_MainBrain_FaceDataInterpretation_FaceDataInterpretation__choice_4_tr1();
			} else {
				effect_MainBrain_FaceDataInterpretation_FaceDataInterpretation__choice_4_tr2();
			}
		}
	}

	/* Default react sequence for initial entry  */
	private void react_MainBrain__entry_Default() {
		enterSequence_MainBrain_Init_default();
	}

	/* Default react sequence for initial entry  */
	private void react_MainBrain_FaceDataInterpretation_FaceDataInterpretation__entry_Default() {
		react_MainBrain_FaceDataInterpretation_FaceDataInterpretation__choice_0();
	}

	/* Default react sequence for initial entry  */
	private void react_MainBrain_SearchForChat_SearchForChat__entry_Default() {
		enterSequence_MainBrain_SearchForChat_SearchForChat_Standing_default();
	}

	public void runCycle() {
		if (!initialized)
			throw new IllegalStateException(
					"The statemachine needs to be initialized first by calling the init() function.");

		clearOutEvents();

		for (nextStateIndex = 0; nextStateIndex < stateVector.length; nextStateIndex++) {

			switch (stateVector[nextStateIndex]) {
				case mainBrain_Init :
					react_MainBrain_Init();
					break;
				case mainBrain_FaceDataInterpretation_FaceDataInterpretation_PersonKnownWithName :
					react_MainBrain_FaceDataInterpretation_FaceDataInterpretation_PersonKnownWithName();
					break;
				case mainBrain_FaceDataInterpretation_FaceDataInterpretation_UnknownGirl :
					react_MainBrain_FaceDataInterpretation_FaceDataInterpretation_UnknownGirl();
					break;
				case mainBrain_FaceDataInterpretation_FaceDataInterpretation_PersonKnownWithoutName :
					react_MainBrain_FaceDataInterpretation_FaceDataInterpretation_PersonKnownWithoutName();
					break;
				case mainBrain_FaceDataInterpretation_FaceDataInterpretation_UnknownFemaleTeen :
					react_MainBrain_FaceDataInterpretation_FaceDataInterpretation_UnknownFemaleTeen();
					break;
				case mainBrain_FaceDataInterpretation_FaceDataInterpretation_UnknownWomen :
					react_MainBrain_FaceDataInterpretation_FaceDataInterpretation_UnknownWomen();
					break;
				case mainBrain_FaceDataInterpretation_FaceDataInterpretation_UnknownBoy :
					react_MainBrain_FaceDataInterpretation_FaceDataInterpretation_UnknownBoy();
					break;
				case mainBrain_FaceDataInterpretation_FaceDataInterpretation_UnknownMaleTeen :
					react_MainBrain_FaceDataInterpretation_FaceDataInterpretation_UnknownMaleTeen();
					break;
				case mainBrain_FaceDataInterpretation_FaceDataInterpretation_UnknownMen :
					react_MainBrain_FaceDataInterpretation_FaceDataInterpretation_UnknownMen();
					break;
				case mainBrain_FaceDataInterpretation_FaceDataInterpretation_Greetings_KnownPerson :
					react_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Greetings_KnownPerson();
					break;
				case mainBrain_FaceDataInterpretation_FaceDataInterpretation_Greetings_UnknownPerson :
					react_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Greetings_UnknownPerson();
					break;
				case mainBrain_FaceDataInterpretation_FaceDataInterpretation_Greetings_KnownPersonWithoutName :
					react_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Greetings_KnownPersonWithoutName();
					break;
				case mainBrain_FaceDataInterpretation_FaceDataInterpretation_AboutRobotica_1 :
					react_MainBrain_FaceDataInterpretation_FaceDataInterpretation_AboutRobotica_1();
					break;
				case mainBrain_FaceDataInterpretation_FaceDataInterpretation_AboutRobotica_2 :
					react_MainBrain_FaceDataInterpretation_FaceDataInterpretation_AboutRobotica_2();
					break;
				case mainBrain_FaceDataInterpretation_FaceDataInterpretation_RandomTopic_1 :
					react_MainBrain_FaceDataInterpretation_FaceDataInterpretation_RandomTopic_1();
					break;
				case mainBrain_FaceDataInterpretation_FaceDataInterpretation_RandomTopic_2 :
					react_MainBrain_FaceDataInterpretation_FaceDataInterpretation_RandomTopic_2();
					break;
				case mainBrain_FaceDataInterpretation_FaceDataInterpretation_Prompt_2 :
					react_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Prompt_2();
					break;
				case mainBrain_FaceDataInterpretation_FaceDataInterpretation_Prompt_1 :
					react_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Prompt_1();
					break;
				case mainBrain_FaceDataInterpretation_FaceDataInterpretation_AfterGreetings :
					react_MainBrain_FaceDataInterpretation_FaceDataInterpretation_AfterGreetings();
					break;
				case mainBrain_FaceDataInterpretation_FaceDataInterpretation_Farewell_1 :
					react_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Farewell_1();
					break;
				case mainBrain_FaceDataInterpretation_FaceDataInterpretation_Farewell_2 :
					react_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Farewell_2();
					break;
				case mainBrain_FaceDataInterpretation_FaceDataInterpretation_Farewell_3 :
					react_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Farewell_3();
					break;
				case mainBrain_FaceDataInterpretation_FaceDataInterpretation_Farewell_4 :
					react_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Farewell_4();
					break;
				case mainBrain_FaceDataInterpretation_FaceDataInterpretation_Selection :
					react_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Selection();
					break;
				case mainBrain_FaceDataInterpretation_FaceDataInterpretation_Selection_1 :
					react_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Selection_1();
					break;
				case mainBrain_FaceDataInterpretation_FaceDataInterpretation_RandomTopic_3 :
					react_MainBrain_FaceDataInterpretation_FaceDataInterpretation_RandomTopic_3();
					break;
				case mainBrain_FaceDataInterpretation_FaceDataInterpretation_Selection_2 :
					react_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Selection_2();
					break;
				case mainBrain_FaceDataInterpretation_FaceDataInterpretation_AlternativeConv_1 :
					react_MainBrain_FaceDataInterpretation_FaceDataInterpretation_AlternativeConv_1();
					break;
				case mainBrain_FaceDataInterpretation_FaceDataInterpretation_Selection_3 :
					react_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Selection_3();
					break;
				case mainBrain_FaceDataInterpretation_FaceDataInterpretation__final_ :
					react_MainBrain_FaceDataInterpretation_FaceDataInterpretation__final_();
					break;
				case mainBrain_FaceDataInterpretation_FaceDataInterpretation_STT_1 :
					react_MainBrain_FaceDataInterpretation_FaceDataInterpretation_STT_1();
					break;
				case mainBrain_FaceDataInterpretation_FaceDataInterpretation_STT_2 :
					react_MainBrain_FaceDataInterpretation_FaceDataInterpretation_STT_2();
					break;
				case mainBrain_FaceDataInterpretation_FaceDataInterpretation_RandomTopic_4 :
					react_MainBrain_FaceDataInterpretation_FaceDataInterpretation_RandomTopic_4();
					break;
				case mainBrain_FaceDataInterpretation_FaceDataInterpretation_STT_3 :
					react_MainBrain_FaceDataInterpretation_FaceDataInterpretation_STT_3();
					break;
				case mainBrain_FaceDataInterpretation_FaceDataInterpretation_STT_4 :
					react_MainBrain_FaceDataInterpretation_FaceDataInterpretation_STT_4();
					break;
				case mainBrain_FaceDataInterpretation_FaceDataInterpretation_AlternativeConv_2 :
					react_MainBrain_FaceDataInterpretation_FaceDataInterpretation_AlternativeConv_2();
					break;
				case mainBrain_FaceDataInterpretation_FaceDataInterpretation_AboutRobotica_3 :
					react_MainBrain_FaceDataInterpretation_FaceDataInterpretation_AboutRobotica_3();
					break;
				case mainBrain_FaceDataInterpretation_FaceDataInterpretation_STT_5 :
					react_MainBrain_FaceDataInterpretation_FaceDataInterpretation_STT_5();
					break;
				case mainBrain_FaceDataInterpretation_FaceDataInterpretation_AfterGreetings_2 :
					react_MainBrain_FaceDataInterpretation_FaceDataInterpretation_AfterGreetings_2();
					break;
				case mainBrain_FaceDataInterpretation_FaceDataInterpretation_Closing :
					react_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Closing();
					break;
				case mainBrain_FaceDataInterpretation_FaceDataInterpretation_STT_6 :
					react_MainBrain_FaceDataInterpretation_FaceDataInterpretation_STT_6();
					break;
				case mainBrain_FaceDataInterpretation_FaceDataInterpretation_filter :
					react_MainBrain_FaceDataInterpretation_FaceDataInterpretation_filter();
					break;
				case mainBrain_FaceDataInterpretation_FaceDataInterpretation_filter_2 :
					react_MainBrain_FaceDataInterpretation_FaceDataInterpretation_filter_2();
					break;
				case mainBrain_TurnToNoise :
					react_MainBrain_TurnToNoise();
					break;
				case mainBrain_Idle :
					react_MainBrain_Idle();
					break;
				case mainBrain_StopLeonie :
					react_MainBrain_StopLeonie();
					break;
				case mainBrain_SearchForChat_SearchForChat_Standing :
					react_MainBrain_SearchForChat_SearchForChat_Standing();
					break;
				case mainBrain_SearchForChat_SearchForChat_Walking :
					react_MainBrain_SearchForChat_SearchForChat_Walking();
					break;
				default :
					// $NullState$
			}
		}

		clearEvents();
	}
}
