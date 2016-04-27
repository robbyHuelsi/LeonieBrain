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

		private boolean sTTReady;

		public boolean getSTTReady() {
			return sTTReady;
		}

		public void setSTTReady(boolean value) {
			this.sTTReady = value;
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
		mainBrain_Init, mainBrain_FaceDataInterpretation, mainBrain_FaceDataInterpretation_FaceDataInterpretation_PersonKnownWithName, mainBrain_FaceDataInterpretation_FaceDataInterpretation_UnknownGirl, mainBrain_FaceDataInterpretation_FaceDataInterpretation_PersonKnownWithoutName, mainBrain_FaceDataInterpretation_FaceDataInterpretation_UnknownFemaleTeen, mainBrain_FaceDataInterpretation_FaceDataInterpretation_UnknownWomen, mainBrain_FaceDataInterpretation_FaceDataInterpretation_UnknownBoy, mainBrain_FaceDataInterpretation_FaceDataInterpretation_UnknownMaleTeen, mainBrain_FaceDataInterpretation_FaceDataInterpretation_UnknownMen, mainBrain_FaceDataInterpretation_FaceDataInterpretation_Greetings_KnownPerson, mainBrain_FaceDataInterpretation_FaceDataInterpretation_Greetings_UnknownPerson, mainBrain_FaceDataInterpretation_FaceDataInterpretation_Greetings_UnknownPerson_AskForName_asking, mainBrain_FaceDataInterpretation_FaceDataInterpretation_Greetings_UnknownPerson_AskForName_init, mainBrain_FaceDataInterpretation_FaceDataInterpretation_Greetings_UnknownPerson_AskForName_STT_1, mainBrain_FaceDataInterpretation_FaceDataInterpretation_Greetings_UnknownPerson_AskForName_Copy_1_AtWP02, mainBrain_FaceDataInterpretation_FaceDataInterpretation_Greetings_UnknownPerson_AskForName_STT3, mainBrain_FaceDataInterpretation_FaceDataInterpretation_Greetings_KnownPersonWithoutName, mainBrain_FaceDataInterpretation_FaceDataInterpretation_AboutRobotica_1, mainBrain_FaceDataInterpretation_FaceDataInterpretation_AboutRobotica_2, mainBrain_FaceDataInterpretation_FaceDataInterpretation_RandomTopic_1, mainBrain_FaceDataInterpretation_FaceDataInterpretation_RandomTopic_2, mainBrain_FaceDataInterpretation_FaceDataInterpretation_Prompt_2, mainBrain_FaceDataInterpretation_FaceDataInterpretation_Prompt_1, mainBrain_FaceDataInterpretation_FaceDataInterpretation_AfterGreetings, mainBrain_FaceDataInterpretation_FaceDataInterpretation_Farewell_1, mainBrain_FaceDataInterpretation_FaceDataInterpretation_Farewell_2, mainBrain_FaceDataInterpretation_FaceDataInterpretation_Farewell_3, mainBrain_FaceDataInterpretation_FaceDataInterpretation_Farewell_4, mainBrain_FaceDataInterpretation_FaceDataInterpretation_Selection, mainBrain_FaceDataInterpretation_FaceDataInterpretation_Selection_1, mainBrain_FaceDataInterpretation_FaceDataInterpretation_RandomTopic_3, mainBrain_FaceDataInterpretation_FaceDataInterpretation_Selection_2, mainBrain_FaceDataInterpretation_FaceDataInterpretation_AlternativeConv_1, mainBrain_FaceDataInterpretation_FaceDataInterpretation_Selection_3, mainBrain_FaceDataInterpretation_FaceDataInterpretation__final_, mainBrain_FaceDataInterpretation_FaceDataInterpretation_STT_2, mainBrain_FaceDataInterpretation_FaceDataInterpretation_RandomTopic_4, mainBrain_FaceDataInterpretation_FaceDataInterpretation_STT_3, mainBrain_FaceDataInterpretation_FaceDataInterpretation_STT_4, mainBrain_FaceDataInterpretation_FaceDataInterpretation_AlternativeConv_2, mainBrain_FaceDataInterpretation_FaceDataInterpretation_AboutRobotica_3, mainBrain_FaceDataInterpretation_FaceDataInterpretation_STT_5, mainBrain_FaceDataInterpretation_FaceDataInterpretation_AfterGreetings_2, mainBrain_FaceDataInterpretation_FaceDataInterpretation_Closing, mainBrain_FaceDataInterpretation_FaceDataInterpretation_STT_6, mainBrain_FaceDataInterpretation_FaceDataInterpretation_filter, mainBrain_FaceDataInterpretation_FaceDataInterpretation_filter_2, mainBrain_GoToWP02, mainBrain_Idle, mainBrain_StopLeonie, mainBrain_SearchForChat, mainBrain_SearchForChat_SearchForChat_Standing, mainBrain_SearchForChat_SearchForChat_Walking, mainBrain_GoToWP03_Noise, mainBrain_Copy_2_TurnToNoise, mainBrain_GoToWP01, mainBrain_AtWP02, mainBrain_AtWP03_FingerAlphabet, mainBrain_AtWP01, mainBrain_GoToWP01___ACI, mainBrain_AtWP01___ACI, mainBrain_STT1, mainBrain_Copy_1_AtWP02, mainBrain_STT2, mainBrain_STT3, mainBrain_GoToGWP, mainBrain_AtGWP, savePersonList_Save, savePersonList_Init, $NullState$
	};

	private final State[] stateVector = new State[2];

	private int nextStateIndex;

	private ITimer timer;

	private final boolean[] timeEvents = new boolean[12];

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
		for (int i = 0; i < 2; i++) {
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

		sCISTT.setSTTReady(false);

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

		enterSequence_SavePersonList_default();
	}

	public void exit() {
		exitSequence_MainBrain();

		exitSequence_SavePersonList();
	}

	/**
	 * @see IStatemachine#isActive()
	 */
	public boolean isActive() {

		return stateVector[0] != State.$NullState$ || stateVector[1] != State.$NullState$;
	}

	/** 
	* Always returns 'false' since this state machine can never become final.
	*
	 * @see IStatemachine#isFinal() 
	 */
	public boolean isFinal() {
		return false;
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
				return stateVector[0]
						.ordinal() >= State.mainBrain_FaceDataInterpretation_FaceDataInterpretation_Greetings_UnknownPerson
								.ordinal()
						&& stateVector[0]
								.ordinal() <= State.mainBrain_FaceDataInterpretation_FaceDataInterpretation_Greetings_UnknownPerson_AskForName_STT3
										.ordinal();
			case mainBrain_FaceDataInterpretation_FaceDataInterpretation_Greetings_UnknownPerson_AskForName_asking :
				return stateVector[0] == State.mainBrain_FaceDataInterpretation_FaceDataInterpretation_Greetings_UnknownPerson_AskForName_asking;
			case mainBrain_FaceDataInterpretation_FaceDataInterpretation_Greetings_UnknownPerson_AskForName_init :
				return stateVector[0] == State.mainBrain_FaceDataInterpretation_FaceDataInterpretation_Greetings_UnknownPerson_AskForName_init;
			case mainBrain_FaceDataInterpretation_FaceDataInterpretation_Greetings_UnknownPerson_AskForName_STT_1 :
				return stateVector[0] == State.mainBrain_FaceDataInterpretation_FaceDataInterpretation_Greetings_UnknownPerson_AskForName_STT_1;
			case mainBrain_FaceDataInterpretation_FaceDataInterpretation_Greetings_UnknownPerson_AskForName_Copy_1_AtWP02 :
				return stateVector[0] == State.mainBrain_FaceDataInterpretation_FaceDataInterpretation_Greetings_UnknownPerson_AskForName_Copy_1_AtWP02;
			case mainBrain_FaceDataInterpretation_FaceDataInterpretation_Greetings_UnknownPerson_AskForName_STT3 :
				return stateVector[0] == State.mainBrain_FaceDataInterpretation_FaceDataInterpretation_Greetings_UnknownPerson_AskForName_STT3;
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
			case mainBrain_GoToWP02 :
				return stateVector[0] == State.mainBrain_GoToWP02;
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
			case mainBrain_GoToWP03_Noise :
				return stateVector[0] == State.mainBrain_GoToWP03_Noise;
			case mainBrain_Copy_2_TurnToNoise :
				return stateVector[0] == State.mainBrain_Copy_2_TurnToNoise;
			case mainBrain_GoToWP01 :
				return stateVector[0] == State.mainBrain_GoToWP01;
			case mainBrain_AtWP02 :
				return stateVector[0] == State.mainBrain_AtWP02;
			case mainBrain_AtWP03_FingerAlphabet :
				return stateVector[0] == State.mainBrain_AtWP03_FingerAlphabet;
			case mainBrain_AtWP01 :
				return stateVector[0] == State.mainBrain_AtWP01;
			case mainBrain_GoToWP01___ACI :
				return stateVector[0] == State.mainBrain_GoToWP01___ACI;
			case mainBrain_AtWP01___ACI :
				return stateVector[0] == State.mainBrain_AtWP01___ACI;
			case mainBrain_STT1 :
				return stateVector[0] == State.mainBrain_STT1;
			case mainBrain_Copy_1_AtWP02 :
				return stateVector[0] == State.mainBrain_Copy_1_AtWP02;
			case mainBrain_STT2 :
				return stateVector[0] == State.mainBrain_STT2;
			case mainBrain_STT3 :
				return stateVector[0] == State.mainBrain_STT3;
			case mainBrain_GoToGWP :
				return stateVector[0] == State.mainBrain_GoToGWP;
			case mainBrain_AtGWP :
				return stateVector[0] == State.mainBrain_AtGWP;
			case savePersonList_Save :
				return stateVector[1] == State.savePersonList_Save;
			case savePersonList_Init :
				return stateVector[1] == State.savePersonList_Init;
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
		return timeEvents[1];
	}

	private boolean check_MainBrain_Init_tr2_tr2() {
		return true;
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
		return 1 == 0;
	}

	private boolean check_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Greetings_UnknownPerson_AskForName_asking_tr0_tr0() {
		return sCIHBrain.tTSReady == true;
	}

	private boolean check_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Greetings_UnknownPerson_AskForName_init_tr0_tr0() {
		return sCIHBrain.tTSReady == true;
	}

	private boolean check_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Greetings_UnknownPerson_AskForName_STT_1_tr0_tr0() {
		return timeEvents[2];
	}

	private boolean check_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Greetings_UnknownPerson_AskForName_Copy_1_AtWP02_tr0_tr0() {
		return true;
	}

	private boolean check_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Greetings_UnknownPerson_AskForName_STT3_tr0_tr0() {
		return sCISTT.sTTReady == true;
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

	private boolean check_MainBrain_FaceDataInterpretation_FaceDataInterpretation_STT_2_tr0_tr0() {
		return (timeEvents[3]) && sCISTT.sTTReady == true;
	}

	private boolean check_MainBrain_FaceDataInterpretation_FaceDataInterpretation_RandomTopic_4_tr0_tr0() {
		return sCIHBrain.tTSReady == true;
	}

	private boolean check_MainBrain_FaceDataInterpretation_FaceDataInterpretation_STT_3_tr0_tr0() {
		return (timeEvents[4]) && sCISTT.sTTReady == true;
	}

	private boolean check_MainBrain_FaceDataInterpretation_FaceDataInterpretation_STT_4_tr0_tr0() {
		return (timeEvents[5]) && sCISTT.sTTReady == true;
	}

	private boolean check_MainBrain_FaceDataInterpretation_FaceDataInterpretation_AlternativeConv_2_tr0_tr0() {
		return sCIHBrain.tTSReady == true;
	}

	private boolean check_MainBrain_FaceDataInterpretation_FaceDataInterpretation_AboutRobotica_3_tr0_tr0() {
		return sCIHBrain.tTSReady == true;
	}

	private boolean check_MainBrain_FaceDataInterpretation_FaceDataInterpretation_STT_5_tr0_tr0() {
		return (timeEvents[6]) && sCISTT.sTTReady == true;
	}

	private boolean check_MainBrain_FaceDataInterpretation_FaceDataInterpretation_AfterGreetings_2_tr0_tr0() {
		return sCIHBrain.tTSReady == true;
	}

	private boolean check_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Closing_tr0_tr0() {
		return sCIHBrain.tTSReady == true;
	}

	private boolean check_MainBrain_FaceDataInterpretation_FaceDataInterpretation_STT_6_tr0_tr0() {
		return (timeEvents[7]) && sCISTT.sTTReady == true;
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

	private boolean check_MainBrain_GoToWP02_tr0_tr0() {
		return sCIScitosRemoteControl.arrivedWP == true;
	}

	private boolean check_MainBrain_StopLeonie_tr0_tr0() {
		return sCICurrPerson.currDistance < 10;
	}

	private boolean check_MainBrain_SearchForChat_tr0_tr0() {
		return sCIVBrain.countFoundFaces > 0;
	}

	private boolean check_MainBrain_SearchForChat_tr1_tr1() {
		return true;
	}

	private boolean check_MainBrain_SearchForChat_SearchForChat_Standing_tr0_tr0() {
		return timeEvents[8];
	}

	private boolean check_MainBrain_SearchForChat_SearchForChat_Walking_tr0_tr0() {
		return timeEvents[9];
	}

	private boolean check_MainBrain_GoToWP03_Noise_tr0_tr0() {
		return sCIScitosRemoteControl.arrivedWP == true;
	}

	private boolean check_MainBrain_Copy_2_TurnToNoise_tr0_tr0() {
		return sCIVBrain.countFoundFaces > 0;
	}

	private boolean check_MainBrain_Copy_2_TurnToNoise_tr1_tr1() {
		return sCIVBrain.countFoundFaces > 0;
	}

	private boolean check_MainBrain_GoToWP01_tr0_tr0() {
		return sCIScitosRemoteControl.arrivedWP == true;
	}

	private boolean check_MainBrain_AtWP02_tr0_tr0() {
		return sCIKinect2.noiseDetected == true;
	}

	private boolean check_MainBrain_AtWP03_FingerAlphabet_tr0_tr0() {
		return sCIKinect2.noiseDetected == true;
	}

	private boolean check_MainBrain_GoToWP01___ACI_tr0_tr0() {
		return sCIScitosRemoteControl.arrivedWP == true;
	}

	private boolean check_MainBrain_AtWP01___ACI_tr0_tr0() {
		return 1 == 0;
	}

	private boolean check_MainBrain_AtWP01___ACI_tr1_tr1() {
		return sCIVBrain.countFoundFaces > 0;
	}

	private boolean check_MainBrain_STT1_tr0_tr0() {
		return sCIHBrain.tTSReady == true;
	}

	private boolean check_MainBrain_Copy_1_AtWP02_tr0_tr0() {
		return 1 == 0;
	}

	private boolean check_MainBrain_STT2_tr0_tr0() {
		return timeEvents[10];
	}

	private boolean check_MainBrain_STT3_tr0_tr0() {
		return sCISTT.sTTReady == true;
	}

	private boolean check_MainBrain_GoToGWP_tr0_tr0() {
		return sCIScitosRemoteControl.arrivedWP == true;
	}

	private boolean check_MainBrain_AtGWP_tr0_tr0() {
		return true;
	}

	private boolean check_SavePersonList_Save_tr0_tr0() {
		return timeEvents[11];
	}

	private boolean check_SavePersonList_Init_tr0_tr0() {
		return 1 == 0;
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

		enterSequence_MainBrain_GoToGWP_default();
	}

	private void effect_MainBrain_Init_tr1() {
		exitSequence_MainBrain_Init();

		enterSequence_MainBrain_STT1_default();
	}

	private void effect_MainBrain_Init_tr2() {
		exitSequence_MainBrain_Init();

		enterSequence_MainBrain_GoToWP01___ACI_default();
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

		enterSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_AfterGreetings_default();
	}

	private void effect_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Greetings_UnknownPerson_AskForName_asking_tr0() {
		exitSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Greetings_UnknownPerson_AskForName_asking();

		enterSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Greetings_UnknownPerson_AskForName_STT_1_default();
	}

	private void effect_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Greetings_UnknownPerson_AskForName_init_tr0() {
		exitSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Greetings_UnknownPerson_AskForName_init();

		enterSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Greetings_UnknownPerson_AskForName_asking_default();
	}

	private void effect_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Greetings_UnknownPerson_AskForName_STT_1_tr0() {
		exitSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Greetings_UnknownPerson_AskForName_STT_1();

		enterSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Greetings_UnknownPerson_AskForName_STT3_default();
	}

	private void effect_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Greetings_UnknownPerson_AskForName_Copy_1_AtWP02_tr0() {
		exitSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Greetings_UnknownPerson_AskForName_Copy_1_AtWP02();
	}

	private void effect_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Greetings_UnknownPerson_AskForName_STT3_tr0() {
		exitSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Greetings_UnknownPerson_AskForName_STT3();

		enterSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Greetings_UnknownPerson_AskForName_Copy_1_AtWP02_default();
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

	private void effect_MainBrain_GoToWP02_tr0() {
		exitSequence_MainBrain_GoToWP02();

		enterSequence_MainBrain_AtWP02_default();
	}

	private void effect_MainBrain_StopLeonie_tr0() {
		exitSequence_MainBrain_StopLeonie();

		enterSequence_MainBrain_FaceDataInterpretation_default();
	}

	private void effect_MainBrain_SearchForChat_tr0() {
		exitSequence_MainBrain_SearchForChat();

		enterSequence_MainBrain_StopLeonie_default();
	}

	private void effect_MainBrain_SearchForChat_tr1() {
		exitSequence_MainBrain_SearchForChat();

		enterSequence_MainBrain_Copy_2_TurnToNoise_default();
	}

	private void effect_MainBrain_SearchForChat_SearchForChat_Standing_tr0() {
		exitSequence_MainBrain_SearchForChat_SearchForChat_Standing();

		enterSequence_MainBrain_SearchForChat_SearchForChat_Walking_default();
	}

	private void effect_MainBrain_SearchForChat_SearchForChat_Walking_tr0() {
		exitSequence_MainBrain_SearchForChat_SearchForChat_Walking();

		enterSequence_MainBrain_SearchForChat_SearchForChat_Standing_default();
	}

	private void effect_MainBrain_GoToWP03_Noise_tr0() {
		exitSequence_MainBrain_GoToWP03_Noise();

		enterSequence_MainBrain_AtWP03_FingerAlphabet_default();
	}

	private void effect_MainBrain_Copy_2_TurnToNoise_tr0() {
		exitSequence_MainBrain_Copy_2_TurnToNoise();

		enterSequence_MainBrain_StopLeonie_default();
	}

	private void effect_MainBrain_Copy_2_TurnToNoise_tr1() {
		exitSequence_MainBrain_Copy_2_TurnToNoise();

		enterSequence_MainBrain_FaceDataInterpretation_default();
	}

	private void effect_MainBrain_GoToWP01_tr0() {
		exitSequence_MainBrain_GoToWP01();

		enterSequence_MainBrain_AtWP01_default();
	}

	private void effect_MainBrain_AtWP02_tr0() {
		exitSequence_MainBrain_AtWP02();

		enterSequence_MainBrain_GoToWP03_Noise_default();
	}

	private void effect_MainBrain_AtWP03_FingerAlphabet_tr0() {
		exitSequence_MainBrain_AtWP03_FingerAlphabet();

		enterSequence_MainBrain_GoToWP01_default();
	}

	private void effect_MainBrain_GoToWP01___ACI_tr0() {
		exitSequence_MainBrain_GoToWP01___ACI();

		enterSequence_MainBrain_AtWP01___ACI_default();
	}

	private void effect_MainBrain_AtWP01___ACI_tr0() {
		exitSequence_MainBrain_AtWP01___ACI();

		enterSequence_MainBrain_GoToWP02_default();
	}

	private void effect_MainBrain_AtWP01___ACI_tr1() {
		exitSequence_MainBrain_AtWP01___ACI();

		enterSequence_MainBrain_FaceDataInterpretation_default();
	}

	private void effect_MainBrain_STT1_tr0() {
		exitSequence_MainBrain_STT1();

		enterSequence_MainBrain_STT2_default();
	}

	private void effect_MainBrain_Copy_1_AtWP02_tr0() {
		exitSequence_MainBrain_Copy_1_AtWP02();

		enterSequence_MainBrain_GoToWP01___ACI_default();
	}

	private void effect_MainBrain_STT2_tr0() {
		exitSequence_MainBrain_STT2();

		enterSequence_MainBrain_STT3_default();
	}

	private void effect_MainBrain_STT3_tr0() {
		exitSequence_MainBrain_STT3();

		enterSequence_MainBrain_Copy_1_AtWP02_default();
	}

	private void effect_MainBrain_GoToGWP_tr0() {
		exitSequence_MainBrain_GoToGWP();

		enterSequence_MainBrain_AtGWP_default();
	}

	private void effect_MainBrain_AtGWP_tr0() {
		exitSequence_MainBrain_AtGWP();

		enterSequence_MainBrain_SearchForChat_default();
	}

	private void effect_SavePersonList_Save_tr0() {
		exitSequence_SavePersonList_Save();

		enterSequence_SavePersonList_Save_default();
	}

	private void effect_SavePersonList_Init_tr0() {
		exitSequence_SavePersonList_Init();

		enterSequence_SavePersonList_Save_default();
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

		timer.setTimer(this, 0, 2 * 1000, false);

		timer.setTimer(this, 1, 2 * 1000, false);

		sCIUdpInterface.operationCallback.receive();

		sCIKinect2.setNoiseDetected(false);
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
		sCIUdpInterface.operationCallback.sendToHBrain_TTS("Hey Guy");
	}

	/* Entry action for state 'UnknownMen'. */
	private void entryAction_MainBrain_FaceDataInterpretation_FaceDataInterpretation_UnknownMen() {
		sCIUdpInterface.operationCallback.sendToHBrain_TTS("Hello Sir");
	}

	/* Entry action for state 'Greetings_KnownPerson'. */
	private void entryAction_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Greetings_KnownPerson() {
		sCIUdpInterface.operationCallback.sendToHBrain_TTS("How are you doing");
	}

	/* Entry action for state 'asking'. */
	private void entryAction_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Greetings_UnknownPerson_AskForName_asking() {
		sCIUdpInterface.operationCallback.sendToHBrain_TTS("I have never seen you before. What is your name?");
	}

	/* Entry action for state 'STT_1'. */
	private void entryAction_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Greetings_UnknownPerson_AskForName_STT_1() {

		timer.setTimer(this, 2, 5 * 1000, false);

		sCIUdpInterface.operationCallback.sendToSTT_detectionOnOff(true);
	}

	/* Entry action for state 'Copy_1_AtWP02'. */
	private void entryAction_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Greetings_UnknownPerson_AskForName_Copy_1_AtWP02() {
		sCIUdpInterface.operationCallback.sendToHBrain_TTS3("If think your name is ", sCISTT.speakerMsg,
				". Is that right? Please say yes or no");

		sCICurrPerson.operationCallback.setFirstname(sCISTT.speakerMsg);
	}

	/* Entry action for state 'STT3'. */
	private void entryAction_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Greetings_UnknownPerson_AskForName_STT3() {
		sCIUdpInterface.operationCallback.sendToSTT_detectionOnOff(false);
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

	/* Entry action for state 'STT_2'. */
	private void entryAction_MainBrain_FaceDataInterpretation_FaceDataInterpretation_STT_2() {

		timer.setTimer(this, 3, 2 * 1000, false);

		sCIUdpInterface.operationCallback.sendToSTT_detectionOnOff(true);
	}

	/* Entry action for state 'RandomTopic_4'. */
	private void entryAction_MainBrain_FaceDataInterpretation_FaceDataInterpretation_RandomTopic_4() {
		sCIUdpInterface.operationCallback.sendToHBrain_TTS("Hahah, I will tell you anyway");
	}

	/* Entry action for state 'STT_3'. */
	private void entryAction_MainBrain_FaceDataInterpretation_FaceDataInterpretation_STT_3() {

		timer.setTimer(this, 4, 2 * 1000, false);

		sCIUdpInterface.operationCallback.sendToSTT_detectionOnOff(true);
	}

	/* Entry action for state 'STT_4'. */
	private void entryAction_MainBrain_FaceDataInterpretation_FaceDataInterpretation_STT_4() {

		timer.setTimer(this, 5, 4 * 1000, false);

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

		timer.setTimer(this, 6, 3 * 1000, false);

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

		timer.setTimer(this, 7, 3 * 1000, false);

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

	/* Entry action for state 'GoToWP02'. */
	private void entryAction_MainBrain_GoToWP02() {
		sCIKinect2.setNoiseDetected(false);

		sCIUdpInterface.operationCallback.sendToVBrain_ACIonOff(false);

		sCIUdpInterface.operationCallback.sendToHBrain_TTS("WP02 I am coming");

		sCIUdpInterface.operationCallback.sendToNav_searchOnOff(true);
	}

	/* Entry action for state 'StopLeonie'. */
	private void entryAction_MainBrain_StopLeonie() {
		sCIUdpInterface.operationCallback.sendToNav_searchOnOff(false);
	}

	/* Entry action for state 'Standing'. */
	private void entryAction_MainBrain_SearchForChat_SearchForChat_Standing() {

		timer.setTimer(this, 8, 5 * 1000, false);

		sCIUdpInterface.operationCallback.sendToNav_searchOnOff(false);
	}

	/* Entry action for state 'Walking'. */
	private void entryAction_MainBrain_SearchForChat_SearchForChat_Walking() {

		timer.setTimer(this, 9, 200 * 1000, false);

		sCIUdpInterface.operationCallback.sendToNav_searchOnOff(true);
	}

	/* Entry action for state 'GoToWP03-Noise'. */
	private void entryAction_MainBrain_GoToWP03_Noise() {
		sCIUdpInterface.operationCallback
				.sendToHBrain_TTS("Oh some noise behind me! It is coming from WP03. I am starting");

		sCIUdpInterface.operationCallback.sendToKinect2_detectionOnOff(false);

		sCIKinect2.setNoiseDetected(false);

		sCIUdpInterface.operationCallback.sendToNav_searchOnOff(true);
	}

	/* Entry action for state 'Copy_2_TurnToNoise'. */
	private void entryAction_MainBrain_Copy_2_TurnToNoise() {
		sCIUdpInterface.operationCallback.sendToHBrain_TTS("WP3, you are behind me");

		sCIUdpInterface.operationCallback.sendToNav_searchOnOff(true);
	}

	/* Entry action for state 'GoToWP01'. */
	private void entryAction_MainBrain_GoToWP01() {
		sCIKinect2.setNoiseDetected(false);

		sCIUdpInterface.operationCallback.sendToNav_searchOnOff(true);

		sCIUdpInterface.operationCallback.sendToHBrain_TTS("Tobias at WP01, I am coming");

		sCIUdpInterface.operationCallback.sendToNav_searchOnOff(true);
	}

	/* Entry action for state 'AtWP02'. */
	private void entryAction_MainBrain_AtWP02() {
		sCIScitosRemoteControl.setArrivedWP(false);

		sCIUdpInterface.operationCallback.sendToHBrain_TTS("Nice to be here at Point 02 of my journey");

		sCIKinect2.setNoiseDetected(false);

		sCIUdpInterface.operationCallback.sendToKinect2_detectionOnOff(true);
	}

	/* Entry action for state 'AtWP03-FingerAlphabet'. */
	private void entryAction_MainBrain_AtWP03_FingerAlphabet() {
		sCIScitosRemoteControl.setArrivedWP(false);

		sCIUdpInterface.operationCallback.sendToHBrain_TTS("Why did you call me?");

		sCIUdpInterface.operationCallback.sendToHBrain_TTS("Whom shell I visit now?");

		sCIUdpInterface.operationCallback.sendToHBrain_TTS("Can you spell that?");

		sCIUdpInterface.operationCallback.sendToHBrain_TTS("You send me away, you do not like me?");

		sCIUdpInterface.operationCallback.sendToHBrain_TTS("I better go now!");

		sCIKinect2.setNoiseDetected(true);
	}

	/* Entry action for state 'AtWP01'. */
	private void entryAction_MainBrain_AtWP01() {
		sCIScitosRemoteControl.setArrivedWP(false);

		sCIUdpInterface.operationCallback.sendToHBrain_TTS("Hi Tobie");

		sCIUdpInterface.operationCallback.sendToHBrain_TTS("Now I will go to sleep, it's late already");
	}

	/* Entry action for state 'GoToWP01 - ACI'. */
	private void entryAction_MainBrain_GoToWP01___ACI() {
		sCIUdpInterface.operationCallback.sendToNav_goToGWP("4");

		sCIUdpInterface.operationCallback.sendToHBrain_TTS("To detect a face I am walking to Waypoint 4");
	}

	/* Entry action for state 'AtWP01 - ACI'. */
	private void entryAction_MainBrain_AtWP01___ACI() {
		sCIScitosRemoteControl.setArrivedWP(false);

		sCIHBrain.setTTSReady(false);

		sCIUdpInterface.operationCallback.sendToHBrain_TTS("Now, I am looking for a face in front of me.");

		sCIUdpInterface.operationCallback.sendToVBrain_ACIonOff(true);
	}

	/* Entry action for state 'STT1'. */
	private void entryAction_MainBrain_STT1() {
		sCIHBrain.setTTSReady(false);

		sCIUdpInterface.operationCallback.sendToHBrain_TTS("Hello. Nice to meet you. What is your name?");
	}

	/* Entry action for state 'Copy_1_AtWP02'. */
	private void entryAction_MainBrain_Copy_1_AtWP02() {
		sCIHBrain.setTTSReady(false);

		sCIScitosRemoteControl.setArrivedWP(false);

		sCIUdpInterface.operationCallback.sendToHBrain_TTS3("If think your name is ", sCISTT.speakerMsg,
				". Is that right?");

		sCIKinect2.setNoiseDetected(false);

		sCIUdpInterface.operationCallback.sendToKinect2_detectionOnOff(true);
	}

	/* Entry action for state 'STT2'. */
	private void entryAction_MainBrain_STT2() {

		timer.setTimer(this, 10, 5 * 1000, false);

		sCIHBrain.setTTSReady(false);

		sCISTT.setSpeakerMsg("");

		sCISTT.setSTTReady(false);

		sCIUdpInterface.operationCallback.sendToSTT_detectionOnOff(true);
	}

	/* Entry action for state 'STT3'. */
	private void entryAction_MainBrain_STT3() {
		sCIUdpInterface.operationCallback.sendToSTT_detectionOnOff(false);
	}

	/* Entry action for state 'GoToGWP'. */
	private void entryAction_MainBrain_GoToGWP() {
		sCIUdpInterface.operationCallback.sendToHBrain_TTS("I will go now to a global waypoint");

		sCIScitosRemoteControl.setArrivedWP(false);

		sCIUdpInterface.operationCallback.sendToNav_goToGWP("4");
	}

	/* Entry action for state 'AtGWP'. */
	private void entryAction_MainBrain_AtGWP() {
		sCIUdpInterface.operationCallback.sendToHBrain_TTS("Yeah, I am there at the waypoint");
	}

	/* Entry action for state 'Save'. */
	private void entryAction_SavePersonList_Save() {

		timer.setTimer(this, 11, 5 * 1000, false);

		sCIBGF.operationCallback.savePersonList();
	}

	/* Exit action for state 'Init'. */
	private void exitAction_MainBrain_Init() {
		timer.unsetTimer(this, 0);

		timer.unsetTimer(this, 1);
	}

	/* Exit action for state 'STT_1'. */
	private void exitAction_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Greetings_UnknownPerson_AskForName_STT_1() {
		timer.unsetTimer(this, 2);
	}

	/* Exit action for state 'STT_2'. */
	private void exitAction_MainBrain_FaceDataInterpretation_FaceDataInterpretation_STT_2() {
		timer.unsetTimer(this, 3);
	}

	/* Exit action for state 'STT_3'. */
	private void exitAction_MainBrain_FaceDataInterpretation_FaceDataInterpretation_STT_3() {
		timer.unsetTimer(this, 4);
	}

	/* Exit action for state 'STT_4'. */
	private void exitAction_MainBrain_FaceDataInterpretation_FaceDataInterpretation_STT_4() {
		timer.unsetTimer(this, 5);
	}

	/* Exit action for state 'STT_5'. */
	private void exitAction_MainBrain_FaceDataInterpretation_FaceDataInterpretation_STT_5() {
		timer.unsetTimer(this, 6);
	}

	/* Exit action for state 'STT_6'. */
	private void exitAction_MainBrain_FaceDataInterpretation_FaceDataInterpretation_STT_6() {
		timer.unsetTimer(this, 7);
	}

	/* Exit action for state 'Standing'. */
	private void exitAction_MainBrain_SearchForChat_SearchForChat_Standing() {
		timer.unsetTimer(this, 8);
	}

	/* Exit action for state 'Walking'. */
	private void exitAction_MainBrain_SearchForChat_SearchForChat_Walking() {
		timer.unsetTimer(this, 9);
	}

	/* Exit action for state 'STT2'. */
	private void exitAction_MainBrain_STT2() {
		timer.unsetTimer(this, 10);
	}

	/* Exit action for state 'Save'. */
	private void exitAction_SavePersonList_Save() {
		timer.unsetTimer(this, 11);
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
		enterSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Greetings_UnknownPerson_AskForName_default();
	}

	/* 'default' enter sequence for state asking */
	private void enterSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Greetings_UnknownPerson_AskForName_asking_default() {
		entryAction_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Greetings_UnknownPerson_AskForName_asking();

		nextStateIndex = 0;
		stateVector[0] = State.mainBrain_FaceDataInterpretation_FaceDataInterpretation_Greetings_UnknownPerson_AskForName_asking;
	}

	/* 'default' enter sequence for state init */
	private void enterSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Greetings_UnknownPerson_AskForName_init_default() {
		nextStateIndex = 0;
		stateVector[0] = State.mainBrain_FaceDataInterpretation_FaceDataInterpretation_Greetings_UnknownPerson_AskForName_init;
	}

	/* 'default' enter sequence for state STT_1 */
	private void enterSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Greetings_UnknownPerson_AskForName_STT_1_default() {
		entryAction_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Greetings_UnknownPerson_AskForName_STT_1();

		nextStateIndex = 0;
		stateVector[0] = State.mainBrain_FaceDataInterpretation_FaceDataInterpretation_Greetings_UnknownPerson_AskForName_STT_1;
	}

	/* 'default' enter sequence for state Copy_1_AtWP02 */
	private void enterSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Greetings_UnknownPerson_AskForName_Copy_1_AtWP02_default() {
		entryAction_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Greetings_UnknownPerson_AskForName_Copy_1_AtWP02();

		nextStateIndex = 0;
		stateVector[0] = State.mainBrain_FaceDataInterpretation_FaceDataInterpretation_Greetings_UnknownPerson_AskForName_Copy_1_AtWP02;
	}

	/* 'default' enter sequence for state STT3 */
	private void enterSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Greetings_UnknownPerson_AskForName_STT3_default() {
		entryAction_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Greetings_UnknownPerson_AskForName_STT3();

		nextStateIndex = 0;
		stateVector[0] = State.mainBrain_FaceDataInterpretation_FaceDataInterpretation_Greetings_UnknownPerson_AskForName_STT3;
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

	/* 'default' enter sequence for state GoToWP02 */
	private void enterSequence_MainBrain_GoToWP02_default() {
		entryAction_MainBrain_GoToWP02();

		nextStateIndex = 0;
		stateVector[0] = State.mainBrain_GoToWP02;
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

	/* 'default' enter sequence for state GoToWP03-Noise */
	private void enterSequence_MainBrain_GoToWP03_Noise_default() {
		entryAction_MainBrain_GoToWP03_Noise();

		nextStateIndex = 0;
		stateVector[0] = State.mainBrain_GoToWP03_Noise;
	}

	/* 'default' enter sequence for state Copy_2_TurnToNoise */
	private void enterSequence_MainBrain_Copy_2_TurnToNoise_default() {
		entryAction_MainBrain_Copy_2_TurnToNoise();

		nextStateIndex = 0;
		stateVector[0] = State.mainBrain_Copy_2_TurnToNoise;
	}

	/* 'default' enter sequence for state GoToWP01 */
	private void enterSequence_MainBrain_GoToWP01_default() {
		entryAction_MainBrain_GoToWP01();

		nextStateIndex = 0;
		stateVector[0] = State.mainBrain_GoToWP01;
	}

	/* 'default' enter sequence for state AtWP02 */
	private void enterSequence_MainBrain_AtWP02_default() {
		entryAction_MainBrain_AtWP02();

		nextStateIndex = 0;
		stateVector[0] = State.mainBrain_AtWP02;
	}

	/* 'default' enter sequence for state AtWP03-FingerAlphabet */
	private void enterSequence_MainBrain_AtWP03_FingerAlphabet_default() {
		entryAction_MainBrain_AtWP03_FingerAlphabet();

		nextStateIndex = 0;
		stateVector[0] = State.mainBrain_AtWP03_FingerAlphabet;
	}

	/* 'default' enter sequence for state AtWP01 */
	private void enterSequence_MainBrain_AtWP01_default() {
		entryAction_MainBrain_AtWP01();

		nextStateIndex = 0;
		stateVector[0] = State.mainBrain_AtWP01;
	}

	/* 'default' enter sequence for state GoToWP01 - ACI */
	private void enterSequence_MainBrain_GoToWP01___ACI_default() {
		entryAction_MainBrain_GoToWP01___ACI();

		nextStateIndex = 0;
		stateVector[0] = State.mainBrain_GoToWP01___ACI;
	}

	/* 'default' enter sequence for state AtWP01 - ACI */
	private void enterSequence_MainBrain_AtWP01___ACI_default() {
		entryAction_MainBrain_AtWP01___ACI();

		nextStateIndex = 0;
		stateVector[0] = State.mainBrain_AtWP01___ACI;
	}

	/* 'default' enter sequence for state STT1 */
	private void enterSequence_MainBrain_STT1_default() {
		entryAction_MainBrain_STT1();

		nextStateIndex = 0;
		stateVector[0] = State.mainBrain_STT1;
	}

	/* 'default' enter sequence for state Copy_1_AtWP02 */
	private void enterSequence_MainBrain_Copy_1_AtWP02_default() {
		entryAction_MainBrain_Copy_1_AtWP02();

		nextStateIndex = 0;
		stateVector[0] = State.mainBrain_Copy_1_AtWP02;
	}

	/* 'default' enter sequence for state STT2 */
	private void enterSequence_MainBrain_STT2_default() {
		entryAction_MainBrain_STT2();

		nextStateIndex = 0;
		stateVector[0] = State.mainBrain_STT2;
	}

	/* 'default' enter sequence for state STT3 */
	private void enterSequence_MainBrain_STT3_default() {
		entryAction_MainBrain_STT3();

		nextStateIndex = 0;
		stateVector[0] = State.mainBrain_STT3;
	}

	/* 'default' enter sequence for state GoToGWP */
	private void enterSequence_MainBrain_GoToGWP_default() {
		entryAction_MainBrain_GoToGWP();

		nextStateIndex = 0;
		stateVector[0] = State.mainBrain_GoToGWP;
	}

	/* 'default' enter sequence for state AtGWP */
	private void enterSequence_MainBrain_AtGWP_default() {
		entryAction_MainBrain_AtGWP();

		nextStateIndex = 0;
		stateVector[0] = State.mainBrain_AtGWP;
	}

	/* 'default' enter sequence for state Save */
	private void enterSequence_SavePersonList_Save_default() {
		entryAction_SavePersonList_Save();

		nextStateIndex = 1;
		stateVector[1] = State.savePersonList_Save;
	}

	/* 'default' enter sequence for state Init */
	private void enterSequence_SavePersonList_Init_default() {
		nextStateIndex = 1;
		stateVector[1] = State.savePersonList_Init;
	}

	/* 'default' enter sequence for region MainBrain */
	private void enterSequence_MainBrain_default() {
		react_MainBrain__entry_Default();
	}

	/* 'default' enter sequence for region FaceDataInterpretation */
	private void enterSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_default() {
		react_MainBrain_FaceDataInterpretation_FaceDataInterpretation__entry_Default();
	}

	/* 'default' enter sequence for region AskForName */
	private void enterSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Greetings_UnknownPerson_AskForName_default() {
		react_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Greetings_UnknownPerson_AskForName__entry_Default();
	}

	/* 'default' enter sequence for region SearchForChat */
	private void enterSequence_MainBrain_SearchForChat_SearchForChat_default() {
		react_MainBrain_SearchForChat_SearchForChat__entry_Default();
	}

	/* 'default' enter sequence for region SavePersonList */
	private void enterSequence_SavePersonList_default() {
		react_SavePersonList__entry_Default();
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
		exitSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Greetings_UnknownPerson_AskForName();
	}

	/* Default exit sequence for state asking */
	private void exitSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Greetings_UnknownPerson_AskForName_asking() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for state init */
	private void exitSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Greetings_UnknownPerson_AskForName_init() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for state STT_1 */
	private void exitSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Greetings_UnknownPerson_AskForName_STT_1() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;

		exitAction_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Greetings_UnknownPerson_AskForName_STT_1();
	}

	/* Default exit sequence for state Copy_1_AtWP02 */
	private void exitSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Greetings_UnknownPerson_AskForName_Copy_1_AtWP02() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for state STT3 */
	private void exitSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Greetings_UnknownPerson_AskForName_STT3() {
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

	/* Default exit sequence for state GoToWP02 */
	private void exitSequence_MainBrain_GoToWP02() {
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

	/* Default exit sequence for state GoToWP03-Noise */
	private void exitSequence_MainBrain_GoToWP03_Noise() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for state Copy_2_TurnToNoise */
	private void exitSequence_MainBrain_Copy_2_TurnToNoise() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for state GoToWP01 */
	private void exitSequence_MainBrain_GoToWP01() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for state AtWP02 */
	private void exitSequence_MainBrain_AtWP02() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for state AtWP03-FingerAlphabet */
	private void exitSequence_MainBrain_AtWP03_FingerAlphabet() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for state AtWP01 */
	private void exitSequence_MainBrain_AtWP01() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for state GoToWP01 - ACI */
	private void exitSequence_MainBrain_GoToWP01___ACI() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for state AtWP01 - ACI */
	private void exitSequence_MainBrain_AtWP01___ACI() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for state STT1 */
	private void exitSequence_MainBrain_STT1() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for state Copy_1_AtWP02 */
	private void exitSequence_MainBrain_Copy_1_AtWP02() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for state STT2 */
	private void exitSequence_MainBrain_STT2() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;

		exitAction_MainBrain_STT2();
	}

	/* Default exit sequence for state STT3 */
	private void exitSequence_MainBrain_STT3() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for state GoToGWP */
	private void exitSequence_MainBrain_GoToGWP() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for state AtGWP */
	private void exitSequence_MainBrain_AtGWP() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for state Save */
	private void exitSequence_SavePersonList_Save() {
		nextStateIndex = 1;
		stateVector[1] = State.$NullState$;

		exitAction_SavePersonList_Save();
	}

	/* Default exit sequence for state Init */
	private void exitSequence_SavePersonList_Init() {
		nextStateIndex = 1;
		stateVector[1] = State.$NullState$;
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

			case mainBrain_FaceDataInterpretation_FaceDataInterpretation_Greetings_UnknownPerson_AskForName_asking :
				exitSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Greetings_UnknownPerson_AskForName_asking();
				break;

			case mainBrain_FaceDataInterpretation_FaceDataInterpretation_Greetings_UnknownPerson_AskForName_init :
				exitSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Greetings_UnknownPerson_AskForName_init();
				break;

			case mainBrain_FaceDataInterpretation_FaceDataInterpretation_Greetings_UnknownPerson_AskForName_STT_1 :
				exitSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Greetings_UnknownPerson_AskForName_STT_1();
				break;

			case mainBrain_FaceDataInterpretation_FaceDataInterpretation_Greetings_UnknownPerson_AskForName_Copy_1_AtWP02 :
				exitSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Greetings_UnknownPerson_AskForName_Copy_1_AtWP02();
				break;

			case mainBrain_FaceDataInterpretation_FaceDataInterpretation_Greetings_UnknownPerson_AskForName_STT3 :
				exitSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Greetings_UnknownPerson_AskForName_STT3();
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

			case mainBrain_GoToWP02 :
				exitSequence_MainBrain_GoToWP02();
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

			case mainBrain_GoToWP03_Noise :
				exitSequence_MainBrain_GoToWP03_Noise();
				break;

			case mainBrain_Copy_2_TurnToNoise :
				exitSequence_MainBrain_Copy_2_TurnToNoise();
				break;

			case mainBrain_GoToWP01 :
				exitSequence_MainBrain_GoToWP01();
				break;

			case mainBrain_AtWP02 :
				exitSequence_MainBrain_AtWP02();
				break;

			case mainBrain_AtWP03_FingerAlphabet :
				exitSequence_MainBrain_AtWP03_FingerAlphabet();
				break;

			case mainBrain_AtWP01 :
				exitSequence_MainBrain_AtWP01();
				break;

			case mainBrain_GoToWP01___ACI :
				exitSequence_MainBrain_GoToWP01___ACI();
				break;

			case mainBrain_AtWP01___ACI :
				exitSequence_MainBrain_AtWP01___ACI();
				break;

			case mainBrain_STT1 :
				exitSequence_MainBrain_STT1();
				break;

			case mainBrain_Copy_1_AtWP02 :
				exitSequence_MainBrain_Copy_1_AtWP02();
				break;

			case mainBrain_STT2 :
				exitSequence_MainBrain_STT2();
				break;

			case mainBrain_STT3 :
				exitSequence_MainBrain_STT3();
				break;

			case mainBrain_GoToGWP :
				exitSequence_MainBrain_GoToGWP();
				break;

			case mainBrain_AtGWP :
				exitSequence_MainBrain_AtGWP();
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

			case mainBrain_FaceDataInterpretation_FaceDataInterpretation_Greetings_UnknownPerson_AskForName_asking :
				exitSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Greetings_UnknownPerson_AskForName_asking();
				break;

			case mainBrain_FaceDataInterpretation_FaceDataInterpretation_Greetings_UnknownPerson_AskForName_init :
				exitSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Greetings_UnknownPerson_AskForName_init();
				break;

			case mainBrain_FaceDataInterpretation_FaceDataInterpretation_Greetings_UnknownPerson_AskForName_STT_1 :
				exitSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Greetings_UnknownPerson_AskForName_STT_1();
				break;

			case mainBrain_FaceDataInterpretation_FaceDataInterpretation_Greetings_UnknownPerson_AskForName_Copy_1_AtWP02 :
				exitSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Greetings_UnknownPerson_AskForName_Copy_1_AtWP02();
				break;

			case mainBrain_FaceDataInterpretation_FaceDataInterpretation_Greetings_UnknownPerson_AskForName_STT3 :
				exitSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Greetings_UnknownPerson_AskForName_STT3();
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

	/* Default exit sequence for region AskForName */
	private void exitSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Greetings_UnknownPerson_AskForName() {
		switch (stateVector[0]) {
			case mainBrain_FaceDataInterpretation_FaceDataInterpretation_Greetings_UnknownPerson_AskForName_asking :
				exitSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Greetings_UnknownPerson_AskForName_asking();
				break;

			case mainBrain_FaceDataInterpretation_FaceDataInterpretation_Greetings_UnknownPerson_AskForName_init :
				exitSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Greetings_UnknownPerson_AskForName_init();
				break;

			case mainBrain_FaceDataInterpretation_FaceDataInterpretation_Greetings_UnknownPerson_AskForName_STT_1 :
				exitSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Greetings_UnknownPerson_AskForName_STT_1();
				break;

			case mainBrain_FaceDataInterpretation_FaceDataInterpretation_Greetings_UnknownPerson_AskForName_Copy_1_AtWP02 :
				exitSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Greetings_UnknownPerson_AskForName_Copy_1_AtWP02();
				break;

			case mainBrain_FaceDataInterpretation_FaceDataInterpretation_Greetings_UnknownPerson_AskForName_STT3 :
				exitSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Greetings_UnknownPerson_AskForName_STT3();
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

	/* Default exit sequence for region SavePersonList */
	private void exitSequence_SavePersonList() {
		switch (stateVector[1]) {
			case savePersonList_Save :
				exitSequence_SavePersonList_Save();
				break;

			case savePersonList_Init :
				exitSequence_SavePersonList_Init();
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
				effect_MainBrain_Init_tr2();
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

	/* The reactions of state asking. */
	private void react_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Greetings_UnknownPerson_AskForName_asking() {
		if (check_MainBrain_FaceDataInterpretation_tr0_tr0()) {
			effect_MainBrain_FaceDataInterpretation_tr0();
		} else {
			if (check_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Greetings_UnknownPerson_tr0_tr0()) {
				effect_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Greetings_UnknownPerson_tr0();
			} else {
				if (check_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Greetings_UnknownPerson_AskForName_asking_tr0_tr0()) {
					effect_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Greetings_UnknownPerson_AskForName_asking_tr0();
				}
			}
		}
	}

	/* The reactions of state init. */
	private void react_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Greetings_UnknownPerson_AskForName_init() {
		if (check_MainBrain_FaceDataInterpretation_tr0_tr0()) {
			effect_MainBrain_FaceDataInterpretation_tr0();
		} else {
			if (check_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Greetings_UnknownPerson_tr0_tr0()) {
				effect_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Greetings_UnknownPerson_tr0();
			} else {
				if (check_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Greetings_UnknownPerson_AskForName_init_tr0_tr0()) {
					effect_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Greetings_UnknownPerson_AskForName_init_tr0();
				}
			}
		}
	}

	/* The reactions of state STT_1. */
	private void react_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Greetings_UnknownPerson_AskForName_STT_1() {
		if (check_MainBrain_FaceDataInterpretation_tr0_tr0()) {
			effect_MainBrain_FaceDataInterpretation_tr0();
		} else {
			if (check_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Greetings_UnknownPerson_tr0_tr0()) {
				effect_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Greetings_UnknownPerson_tr0();
			} else {
				if (check_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Greetings_UnknownPerson_AskForName_STT_1_tr0_tr0()) {
					effect_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Greetings_UnknownPerson_AskForName_STT_1_tr0();
				}
			}
		}
	}

	/* The reactions of state Copy_1_AtWP02. */
	private void react_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Greetings_UnknownPerson_AskForName_Copy_1_AtWP02() {
		if (check_MainBrain_FaceDataInterpretation_tr0_tr0()) {
			effect_MainBrain_FaceDataInterpretation_tr0();
		} else {
			if (check_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Greetings_UnknownPerson_tr0_tr0()) {
				effect_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Greetings_UnknownPerson_tr0();
			} else {
				effect_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Greetings_UnknownPerson_AskForName_Copy_1_AtWP02_tr0();
			}
		}
	}

	/* The reactions of state STT3. */
	private void react_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Greetings_UnknownPerson_AskForName_STT3() {
		if (check_MainBrain_FaceDataInterpretation_tr0_tr0()) {
			effect_MainBrain_FaceDataInterpretation_tr0();
		} else {
			if (check_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Greetings_UnknownPerson_tr0_tr0()) {
				effect_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Greetings_UnknownPerson_tr0();
			} else {
				if (check_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Greetings_UnknownPerson_AskForName_STT3_tr0_tr0()) {
					effect_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Greetings_UnknownPerson_AskForName_STT3_tr0();
				}
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

	/* The reactions of state GoToWP02. */
	private void react_MainBrain_GoToWP02() {
		if (check_MainBrain_GoToWP02_tr0_tr0()) {
			effect_MainBrain_GoToWP02_tr0();
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
			effect_MainBrain_SearchForChat_tr1();
		}
	}

	/* The reactions of state Walking. */
	private void react_MainBrain_SearchForChat_SearchForChat_Walking() {
		if (check_MainBrain_SearchForChat_tr0_tr0()) {
			effect_MainBrain_SearchForChat_tr0();
		} else {
			effect_MainBrain_SearchForChat_tr1();
		}
	}

	/* The reactions of state GoToWP03-Noise. */
	private void react_MainBrain_GoToWP03_Noise() {
		if (check_MainBrain_GoToWP03_Noise_tr0_tr0()) {
			effect_MainBrain_GoToWP03_Noise_tr0();
		}
	}

	/* The reactions of state Copy_2_TurnToNoise. */
	private void react_MainBrain_Copy_2_TurnToNoise() {
		if (check_MainBrain_Copy_2_TurnToNoise_tr0_tr0()) {
			effect_MainBrain_Copy_2_TurnToNoise_tr0();
		} else {
			if (check_MainBrain_Copy_2_TurnToNoise_tr1_tr1()) {
				effect_MainBrain_Copy_2_TurnToNoise_tr1();
			}
		}
	}

	/* The reactions of state GoToWP01. */
	private void react_MainBrain_GoToWP01() {
		if (check_MainBrain_GoToWP01_tr0_tr0()) {
			effect_MainBrain_GoToWP01_tr0();
		}
	}

	/* The reactions of state AtWP02. */
	private void react_MainBrain_AtWP02() {
		if (check_MainBrain_AtWP02_tr0_tr0()) {
			effect_MainBrain_AtWP02_tr0();
		}
	}

	/* The reactions of state AtWP03-FingerAlphabet. */
	private void react_MainBrain_AtWP03_FingerAlphabet() {
		if (check_MainBrain_AtWP03_FingerAlphabet_tr0_tr0()) {
			effect_MainBrain_AtWP03_FingerAlphabet_tr0();
		}
	}

	/* The reactions of state AtWP01. */
	private void react_MainBrain_AtWP01() {
	}

	/* The reactions of state GoToWP01 - ACI. */
	private void react_MainBrain_GoToWP01___ACI() {
		if (check_MainBrain_GoToWP01___ACI_tr0_tr0()) {
			effect_MainBrain_GoToWP01___ACI_tr0();
		}
	}

	/* The reactions of state AtWP01 - ACI. */
	private void react_MainBrain_AtWP01___ACI() {
		if (check_MainBrain_AtWP01___ACI_tr0_tr0()) {
			effect_MainBrain_AtWP01___ACI_tr0();
		} else {
			if (check_MainBrain_AtWP01___ACI_tr1_tr1()) {
				effect_MainBrain_AtWP01___ACI_tr1();
			}
		}
	}

	/* The reactions of state STT1. */
	private void react_MainBrain_STT1() {
		if (check_MainBrain_STT1_tr0_tr0()) {
			effect_MainBrain_STT1_tr0();
		}
	}

	/* The reactions of state Copy_1_AtWP02. */
	private void react_MainBrain_Copy_1_AtWP02() {
		if (check_MainBrain_Copy_1_AtWP02_tr0_tr0()) {
			effect_MainBrain_Copy_1_AtWP02_tr0();
		}
	}

	/* The reactions of state STT2. */
	private void react_MainBrain_STT2() {
		if (check_MainBrain_STT2_tr0_tr0()) {
			effect_MainBrain_STT2_tr0();
		}
	}

	/* The reactions of state STT3. */
	private void react_MainBrain_STT3() {
		if (check_MainBrain_STT3_tr0_tr0()) {
			effect_MainBrain_STT3_tr0();
		}
	}

	/* The reactions of state GoToGWP. */
	private void react_MainBrain_GoToGWP() {
		if (check_MainBrain_GoToGWP_tr0_tr0()) {
			effect_MainBrain_GoToGWP_tr0();
		}
	}

	/* The reactions of state AtGWP. */
	private void react_MainBrain_AtGWP() {
		effect_MainBrain_AtGWP_tr0();
	}

	/* The reactions of state Save. */
	private void react_SavePersonList_Save() {
		if (check_SavePersonList_Save_tr0_tr0()) {
			effect_SavePersonList_Save_tr0();
		}
	}

	/* The reactions of state Init. */
	private void react_SavePersonList_Init() {
		if (check_SavePersonList_Init_tr0_tr0()) {
			effect_SavePersonList_Init_tr0();
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
	private void react_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Greetings_UnknownPerson_AskForName__entry_Default() {
		enterSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Greetings_UnknownPerson_AskForName_init_default();
	}

	/* Default react sequence for initial entry  */
	private void react_MainBrain_SearchForChat_SearchForChat__entry_Default() {
		enterSequence_MainBrain_SearchForChat_SearchForChat_Standing_default();
	}

	/* Default react sequence for initial entry  */
	private void react_SavePersonList__entry_Default() {
		enterSequence_SavePersonList_Init_default();
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
				case mainBrain_FaceDataInterpretation_FaceDataInterpretation_Greetings_UnknownPerson_AskForName_asking :
					react_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Greetings_UnknownPerson_AskForName_asking();
					break;
				case mainBrain_FaceDataInterpretation_FaceDataInterpretation_Greetings_UnknownPerson_AskForName_init :
					react_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Greetings_UnknownPerson_AskForName_init();
					break;
				case mainBrain_FaceDataInterpretation_FaceDataInterpretation_Greetings_UnknownPerson_AskForName_STT_1 :
					react_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Greetings_UnknownPerson_AskForName_STT_1();
					break;
				case mainBrain_FaceDataInterpretation_FaceDataInterpretation_Greetings_UnknownPerson_AskForName_Copy_1_AtWP02 :
					react_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Greetings_UnknownPerson_AskForName_Copy_1_AtWP02();
					break;
				case mainBrain_FaceDataInterpretation_FaceDataInterpretation_Greetings_UnknownPerson_AskForName_STT3 :
					react_MainBrain_FaceDataInterpretation_FaceDataInterpretation_Greetings_UnknownPerson_AskForName_STT3();
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
				case mainBrain_GoToWP02 :
					react_MainBrain_GoToWP02();
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
				case mainBrain_GoToWP03_Noise :
					react_MainBrain_GoToWP03_Noise();
					break;
				case mainBrain_Copy_2_TurnToNoise :
					react_MainBrain_Copy_2_TurnToNoise();
					break;
				case mainBrain_GoToWP01 :
					react_MainBrain_GoToWP01();
					break;
				case mainBrain_AtWP02 :
					react_MainBrain_AtWP02();
					break;
				case mainBrain_AtWP03_FingerAlphabet :
					react_MainBrain_AtWP03_FingerAlphabet();
					break;
				case mainBrain_AtWP01 :
					react_MainBrain_AtWP01();
					break;
				case mainBrain_GoToWP01___ACI :
					react_MainBrain_GoToWP01___ACI();
					break;
				case mainBrain_AtWP01___ACI :
					react_MainBrain_AtWP01___ACI();
					break;
				case mainBrain_STT1 :
					react_MainBrain_STT1();
					break;
				case mainBrain_Copy_1_AtWP02 :
					react_MainBrain_Copy_1_AtWP02();
					break;
				case mainBrain_STT2 :
					react_MainBrain_STT2();
					break;
				case mainBrain_STT3 :
					react_MainBrain_STT3();
					break;
				case mainBrain_GoToGWP :
					react_MainBrain_GoToGWP();
					break;
				case mainBrain_AtGWP :
					react_MainBrain_AtGWP();
					break;
				case savePersonList_Save :
					react_SavePersonList_Save();
					break;
				case savePersonList_Init :
					react_SavePersonList_Init();
					break;
				default :
					// $NullState$
			}
		}

		clearEvents();
	}
}
