package org.yakindu.scr.brain;
import org.yakindu.scr.ITimer;

public class BrainStatemachine implements IBrainStatemachine {

	protected class SCIUdpInterfaceImpl implements SCIUdpInterface {

		private SCIUdpInterfaceOperationCallback operationCallback;

		public void setSCIUdpInterfaceOperationCallback(SCIUdpInterfaceOperationCallback operationCallback) {
			this.operationCallback = operationCallback;
		}

		private String message;

		public String getMessage() {
			return message;
		}

		public void setMessage(String value) {
			this.message = value;
		}

	}

	protected SCIUdpInterfaceImpl sCIUdpInterface;

	protected class SCIACIface_statImpl implements SCIACIface_stat {

		private long faceID;

		public long getFaceID() {
			return faceID;
		}

		public void setFaceID(long value) {
			this.faceID = value;
		}

		private long confidence;

		public long getConfidence() {
			return confidence;
		}

		public void setConfidence(long value) {
			this.confidence = value;
		}

		private long age;

		public long getAge() {
			return age;
		}

		public void setAge(long value) {
			this.age = value;
		}

		private boolean gender;

		public boolean getGender() {
			return gender;
		}

		public void setGender(boolean value) {
			this.gender = value;
		}

		private long ethnicty;

		public long getEthnicty() {
			return ethnicty;
		}

		public void setEthnicty(long value) {
			this.ethnicty = value;
		}

		private boolean glasses;

		public boolean getGlasses() {
			return glasses;
		}

		public void setGlasses(boolean value) {
			this.glasses = value;
		}

		private long attractiveness;

		public long getAttractiveness() {
			return attractiveness;
		}

		public void setAttractiveness(long value) {
			this.attractiveness = value;
		}

	}

	protected SCIACIface_statImpl sCIACIface_stat;

	protected class SCIACIface_dynImpl implements SCIACIface_dyn {

		private long headGestures;

		public long getHeadGestures() {
			return headGestures;
		}

		public void setHeadGestures(long value) {
			this.headGestures = value;
		}

		private boolean speaking;

		public boolean getSpeaking() {
			return speaking;
		}

		public void setSpeaking(boolean value) {
			this.speaking = value;
		}

		private String emotions;

		public String getEmotions() {
			return emotions;
		}

		public void setEmotions(String value) {
			this.emotions = value;
		}

		private long distance;

		public long getDistance() {
			return distance;
		}

		public void setDistance(long value) {
			this.distance = value;
		}

	}

	protected SCIACIface_dynImpl sCIACIface_dyn;

	protected class SCIPersonImpl implements SCIPerson {

		private long personID;

		public long getPersonID() {
			return personID;
		}

		public void setPersonID(long value) {
			this.personID = value;
		}

		private String aCIface;

		public String getACIface() {
			return aCIface;
		}

		public void setACIface(String value) {
			this.aCIface = value;
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

		private long bdDay;

		public long getBdDay() {
			return bdDay;
		}

		public void setBdDay(long value) {
			this.bdDay = value;
		}

		private long bdMounth;

		public long getBdMounth() {
			return bdMounth;
		}

		public void setBdMounth(long value) {
			this.bdMounth = value;
		}

		private long bdYear;

		public long getBdYear() {
			return bdYear;
		}

		public void setBdYear(long value) {
			this.bdYear = value;
		}

		private boolean gender;

		public boolean getGender() {
			return gender;
		}

		public void setGender(boolean value) {
			this.gender = value;
		}

		private long ethnic;

		public long getEthnic() {
			return ethnic;
		}

		public void setEthnic(long value) {
			this.ethnic = value;
		}

		private boolean glasses;

		public boolean getGlasses() {
			return glasses;
		}

		public void setGlasses(boolean value) {
			this.glasses = value;
		}

		private long attractiveness;

		public long getAttractiveness() {
			return attractiveness;
		}

		public void setAttractiveness(long value) {
			this.attractiveness = value;
		}

	}

	protected SCIPersonImpl sCIPerson;

	protected class SCIAciImpl implements SCIAci {

		private long countFoundFaces;

		public long getCountFoundFaces() {
			return countFoundFaces;
		}

		public void setCountFoundFaces(long value) {
			this.countFoundFaces = value;
		}

	}

	protected SCIAciImpl sCIAci;

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

		private String noiseAngle;

		public String getNoiseAngle() {
			return noiseAngle;
		}

		public void setNoiseAngle(String value) {
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

	protected class SCIMiraImpl implements SCIMira {

		private boolean randMove;

		public boolean getRandMove() {
			return randMove;
		}

		public void setRandMove(boolean value) {
			this.randMove = value;
		}

	}

	protected SCIMiraImpl sCIMira;

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
		mainBrain_Init, mainBrain_FaceDataInterpretation, mainBrain_FaceDataInterpretation_FaceDataInterpretation_PersonKnown, mainBrain_FaceDataInterpretation_FaceDataInterpretation_PersonUnknown, mainBrain_TurnToNoise, mainBrain_Idle, mainBrain_MoveToPerson, mainBrain_SearchForChat, mainBrain_SearchForChat_SearchForChat_Standing, mainBrain_SearchForChat_SearchForChat_Walking, mainBrain_StartGatherData, gatherData_ReceiveUDPString, gatherData_ParseStringForData, gatherData_InitGatherData, test_InitTest, test_Speak, $NullState$
	};

	private final State[] stateVector = new State[3];

	private int nextStateIndex;

	private ITimer timer;

	private final boolean[] timeEvents = new boolean[3];

	private boolean start;

	private boolean textMsg;

	private boolean onTriggerDataGatherer;

	private long t;

	protected void setT(long value) {
		t = value;
	}

	protected long getT() {
		return t;
	}

	public BrainStatemachine() {

		sCIUdpInterface = new SCIUdpInterfaceImpl();
		sCIACIface_stat = new SCIACIface_statImpl();
		sCIACIface_dyn = new SCIACIface_dynImpl();
		sCIPerson = new SCIPersonImpl();
		sCIAci = new SCIAciImpl();
		sCIKinect2 = new SCIKinect2Impl();
		sCILeapMotion = new SCILeapMotionImpl();
		sCIScitosRemoteControl = new SCIScitosRemoteControlImpl();
		sCIOpenDail = new SCIOpenDailImpl();
		sCIMira = new SCIMiraImpl();
		sCIFaceAnimation = new SCIFaceAnimationImpl();
	}

	public void init() {
		this.initialized = true;
		if (timer == null) {
			throw new IllegalStateException("timer not set.");
		}
		for (int i = 0; i < 3; i++) {
			stateVector[i] = State.$NullState$;
		}

		clearEvents();
		clearOutEvents();

		sCIUdpInterface.setMessage("");

		sCIACIface_stat.setFaceID(0);

		sCIACIface_stat.setConfidence(0);

		sCIACIface_stat.setAge(0);

		sCIACIface_stat.setGender(false);

		sCIACIface_stat.setEthnicty(0);

		sCIACIface_stat.setGlasses(false);

		sCIACIface_stat.setAttractiveness(0);

		sCIACIface_dyn.setHeadGestures(0);

		sCIACIface_dyn.setSpeaking(false);

		sCIACIface_dyn.setEmotions("");

		sCIACIface_dyn.setDistance(0);

		sCIPerson.setPersonID(0);

		sCIPerson.setACIface("");

		sCIPerson.setFirstname("");

		sCIPerson.setLastname("");

		sCIPerson.setBdDay(0);

		sCIPerson.setBdMounth(0);

		sCIPerson.setBdYear(0);

		sCIPerson.setGender(false);

		sCIPerson.setEthnic(0);

		sCIPerson.setGlasses(false);

		sCIPerson.setAttractiveness(0);

		sCIAci.setCountFoundFaces(0);

		sCIKinect2.setGesture("");

		sCIKinect2.setNoiseDetected(false);

		sCIKinect2.setNoiseAngle("");

		sCILeapMotion.setGestureDetected(false);

		sCILeapMotion.setGesture("");

		sCIScitosRemoteControl.setEmergencyStop(false);

		sCIOpenDail.setSpeakerMsg("");

		sCIOpenDail.setLeonieMsg("");

		sCIMira.setRandMove(false);

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

		enterSequence_GatherData_default();

		enterSequence_Test_default();
	}

	public void exit() {
		exitSequence_MainBrain();

		exitSequence_GatherData();

		exitSequence_Test();
	}

	/**
	 * @see IStatemachine#isActive()
	 */
	public boolean isActive() {

		return stateVector[0] != State.$NullState$ || stateVector[1] != State.$NullState$
				|| stateVector[2] != State.$NullState$;
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
		start = false;
		textMsg = false;
		onTriggerDataGatherer = false;

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
						.ordinal() <= State.mainBrain_FaceDataInterpretation_FaceDataInterpretation_PersonUnknown
								.ordinal();
			case mainBrain_FaceDataInterpretation_FaceDataInterpretation_PersonKnown :
				return stateVector[0] == State.mainBrain_FaceDataInterpretation_FaceDataInterpretation_PersonKnown;
			case mainBrain_FaceDataInterpretation_FaceDataInterpretation_PersonUnknown :
				return stateVector[0] == State.mainBrain_FaceDataInterpretation_FaceDataInterpretation_PersonUnknown;
			case mainBrain_TurnToNoise :
				return stateVector[0] == State.mainBrain_TurnToNoise;
			case mainBrain_Idle :
				return stateVector[0] == State.mainBrain_Idle;
			case mainBrain_MoveToPerson :
				return stateVector[0] == State.mainBrain_MoveToPerson;
			case mainBrain_SearchForChat :
				return stateVector[0].ordinal() >= State.mainBrain_SearchForChat.ordinal()
						&& stateVector[0].ordinal() <= State.mainBrain_SearchForChat_SearchForChat_Walking.ordinal();
			case mainBrain_SearchForChat_SearchForChat_Standing :
				return stateVector[0] == State.mainBrain_SearchForChat_SearchForChat_Standing;
			case mainBrain_SearchForChat_SearchForChat_Walking :
				return stateVector[0] == State.mainBrain_SearchForChat_SearchForChat_Walking;
			case mainBrain_StartGatherData :
				return stateVector[0] == State.mainBrain_StartGatherData;
			case gatherData_ReceiveUDPString :
				return stateVector[1] == State.gatherData_ReceiveUDPString;
			case gatherData_ParseStringForData :
				return stateVector[1] == State.gatherData_ParseStringForData;
			case gatherData_InitGatherData :
				return stateVector[1] == State.gatherData_InitGatherData;
			case test_InitTest :
				return stateVector[2] == State.test_InitTest;
			case test_Speak :
				return stateVector[2] == State.test_Speak;
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

	public SCIUdpInterface getSCIUdpInterface() {
		return sCIUdpInterface;
	}
	public SCIACIface_stat getSCIACIface_stat() {
		return sCIACIface_stat;
	}
	public SCIACIface_dyn getSCIACIface_dyn() {
		return sCIACIface_dyn;
	}
	public SCIPerson getSCIPerson() {
		return sCIPerson;
	}
	public SCIAci getSCIAci() {
		return sCIAci;
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
	public SCIMira getSCIMira() {
		return sCIMira;
	}
	public SCIFaceAnimation getSCIFaceAnimation() {
		return sCIFaceAnimation;
	}

	private void raiseStart() {
		start = true;
	}

	private void raiseTextMsg() {
		textMsg = true;
	}

	private void raiseOnTriggerDataGatherer() {
		onTriggerDataGatherer = true;
	}

	private boolean check_MainBrain_Init_tr0_tr0() {
		return true;
	}

	private boolean check_MainBrain_FaceDataInterpretation_tr0_tr0() {
		return true;
	}

	private boolean check_MainBrain_TurnToNoise_tr0_tr0() {
		return sCIAci.countFoundFaces > 0;
	}

	private boolean check_MainBrain_TurnToNoise_tr1_tr1() {
		return sCIAci.countFoundFaces > 0;
	}

	private boolean check_MainBrain_MoveToPerson_tr0_tr0() {
		return sCIACIface_dyn.distance < 10;
	}

	private boolean check_MainBrain_SearchForChat_SearchForChat_Standing_tr0_tr0() {
		return timeEvents[0];
	}

	private boolean check_MainBrain_SearchForChat_SearchForChat_Standing_tr1_tr1() {
		return sCIKinect2.noiseDetected == true;
	}

	private boolean check_MainBrain_SearchForChat_SearchForChat_Standing_tr2_tr2() {
		return sCIAci.countFoundFaces > 0;
	}

	private boolean check_MainBrain_SearchForChat_SearchForChat_Walking_tr0_tr0() {
		return timeEvents[1];
	}

	private boolean check_MainBrain_SearchForChat_SearchForChat_Walking_tr1_tr1() {
		return sCIKinect2.noiseDetected == true;
	}

	private boolean check_MainBrain_SearchForChat_SearchForChat_Walking_tr2_tr2() {
		return sCIAci.countFoundFaces > 0;
	}

	private boolean check_MainBrain_StartGatherData_tr0_tr0() {
		return true;
	}

	private boolean check_GatherData_ReceiveUDPString_tr0_tr0() {
		return true;
	}

	private boolean check_GatherData_ParseStringForData_tr0_tr0() {
		return true;
	}

	private boolean check_GatherData_InitGatherData_tr0_tr0() {
		return onTriggerDataGatherer;
	}

	private boolean check_Test_InitTest_tr0_tr0() {
		return sCILeapMotion.gestureDetected == true;
	}

	private boolean check_Test_Speak_tr0_tr0() {
		return timeEvents[2];
	}

	private boolean check_MainBrain_FaceDataInterpretation_FaceDataInterpretation__choice_0_tr0_tr0() {
		return sCIACIface_stat.confidence < 90;
	}

	private boolean check_MainBrain_FaceDataInterpretation_FaceDataInterpretation__choice_0_tr1_tr1() {
		return sCIACIface_stat.confidence >= 90;
	}

	private void effect_MainBrain_Init_tr0() {
		exitSequence_MainBrain_Init();

		enterSequence_MainBrain_StartGatherData_default();
	}

	private void effect_MainBrain_FaceDataInterpretation_tr0() {
		exitSequence_MainBrain_FaceDataInterpretation();

		enterSequence_MainBrain_Idle_default();
	}

	private void effect_MainBrain_TurnToNoise_tr0() {
		exitSequence_MainBrain_TurnToNoise();

		enterSequence_MainBrain_MoveToPerson_default();
	}

	private void effect_MainBrain_TurnToNoise_tr1() {
		exitSequence_MainBrain_TurnToNoise();

		enterSequence_MainBrain_SearchForChat_EntrySearchForChat();
	}

	private void effect_MainBrain_MoveToPerson_tr0() {
		exitSequence_MainBrain_MoveToPerson();

		enterSequence_MainBrain_FaceDataInterpretation_EntryFaceDataInterpretation();
	}

	private void effect_MainBrain_SearchForChat_tr0() {
		exitSequence_MainBrain_SearchForChat();

		enterSequence_MainBrain_TurnToNoise_default();
	}

	private void effect_MainBrain_SearchForChat_tr1() {
		exitSequence_MainBrain_SearchForChat();

		enterSequence_MainBrain_MoveToPerson_default();
	}

	private void effect_MainBrain_SearchForChat_SearchForChat_Standing_tr0() {
		exitSequence_MainBrain_SearchForChat_SearchForChat_Standing();

		enterSequence_MainBrain_SearchForChat_SearchForChat_Walking_default();
	}

	private void effect_MainBrain_SearchForChat_SearchForChat_Standing_tr1() {
		exitSequence_MainBrain_SearchForChat_SearchForChat_Standing();

		react_MainBrain_SearchForChat_SearchForChat_ExitNoiseDetected();
	}

	private void effect_MainBrain_SearchForChat_SearchForChat_Standing_tr2() {
		exitSequence_MainBrain_SearchForChat_SearchForChat_Standing();

		react_MainBrain_SearchForChat_SearchForChat_ExitFaceFound();
	}

	private void effect_MainBrain_SearchForChat_SearchForChat_Walking_tr0() {
		exitSequence_MainBrain_SearchForChat_SearchForChat_Walking();

		enterSequence_MainBrain_SearchForChat_SearchForChat_Standing_default();
	}

	private void effect_MainBrain_SearchForChat_SearchForChat_Walking_tr1() {
		exitSequence_MainBrain_SearchForChat_SearchForChat_Walking();

		react_MainBrain_SearchForChat_SearchForChat_ExitNoiseDetected();
	}

	private void effect_MainBrain_SearchForChat_SearchForChat_Walking_tr2() {
		exitSequence_MainBrain_SearchForChat_SearchForChat_Walking();

		react_MainBrain_SearchForChat_SearchForChat_ExitFaceFound();
	}

	private void effect_MainBrain_StartGatherData_tr0() {
		exitSequence_MainBrain_StartGatherData();

		enterSequence_MainBrain_SearchForChat_EntrySearchForChat();
	}

	private void effect_GatherData_ReceiveUDPString_tr0() {
		exitSequence_GatherData_ReceiveUDPString();

		enterSequence_GatherData_ParseStringForData_default();
	}

	private void effect_GatherData_ParseStringForData_tr0() {
		exitSequence_GatherData_ParseStringForData();

		enterSequence_GatherData_ReceiveUDPString_default();
	}

	private void effect_GatherData_InitGatherData_tr0() {
		exitSequence_GatherData_InitGatherData();

		enterSequence_GatherData_ReceiveUDPString_default();
	}

	private void effect_Test_InitTest_tr0() {
		exitSequence_Test_InitTest();

		enterSequence_Test_Speak_default();
	}

	private void effect_Test_Speak_tr0() {
		exitSequence_Test_Speak();

		enterSequence_Test_InitTest_default();
	}

	private void effect_MainBrain_FaceDataInterpretation_FaceDataInterpretation__choice_0_tr0() {
		enterSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_PersonUnknown_default();
	}

	private void effect_MainBrain_FaceDataInterpretation_FaceDataInterpretation__choice_0_tr1() {
		enterSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_PersonKnown_default();
	}

	/* Entry action for state 'TurnToNoise'. */
	private void entryAction_MainBrain_TurnToNoise() {
		sCIUdpInterface.operationCallback.sendToHBrain_TTS("Hello");
	}

	/* Entry action for state 'Standing'. */
	private void entryAction_MainBrain_SearchForChat_SearchForChat_Standing() {

		timer.setTimer(this, 0, 10 * 1000, false);

		sCIMira.setRandMove(false);
	}

	/* Entry action for state 'Walking'. */
	private void entryAction_MainBrain_SearchForChat_SearchForChat_Walking() {

		timer.setTimer(this, 1, 20 * 1000, false);

		sCIMira.setRandMove(true);
	}

	/* Entry action for state 'StartGatherData'. */
	private void entryAction_MainBrain_StartGatherData() {
		raiseOnTriggerDataGatherer();
	}

	/* Entry action for state 'ReceiveUDPString'. */
	private void entryAction_GatherData_ReceiveUDPString() {
		sCIUdpInterface.operationCallback.receive();
	}

	/* Entry action for state 'ParseStringForData'. */
	private void entryAction_GatherData_ParseStringForData() {
		sCIUdpInterface.operationCallback.parseString();
	}

	/* Entry action for state 'Speak'. */
	private void entryAction_Test_Speak() {

		timer.setTimer(this, 2, 5 * 1000, false);

		sCIUdpInterface.operationCallback.sendToHBrain_TTS(sCILeapMotion.gesture);
	}

	/* Exit action for state 'Standing'. */
	private void exitAction_MainBrain_SearchForChat_SearchForChat_Standing() {
		timer.unsetTimer(this, 0);
	}

	/* Exit action for state 'Walking'. */
	private void exitAction_MainBrain_SearchForChat_SearchForChat_Walking() {
		timer.unsetTimer(this, 1);
	}

	/* Exit action for state 'Speak'. */
	private void exitAction_Test_Speak() {
		timer.unsetTimer(this, 2);
	}

	/* 'default' enter sequence for state Init */
	private void enterSequence_MainBrain_Init_default() {
		nextStateIndex = 0;
		stateVector[0] = State.mainBrain_Init;
	}

	/* 'EntryFaceDataInterpretation' enter sequence for state FaceDataInterpretation */
	private void enterSequence_MainBrain_FaceDataInterpretation_EntryFaceDataInterpretation() {
		enterSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_EntryFaceDataInterpretation();
	}

	/* 'default' enter sequence for state PersonKnown */
	private void enterSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_PersonKnown_default() {
		nextStateIndex = 0;
		stateVector[0] = State.mainBrain_FaceDataInterpretation_FaceDataInterpretation_PersonKnown;
	}

	/* 'default' enter sequence for state PersonUnknown */
	private void enterSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_PersonUnknown_default() {
		nextStateIndex = 0;
		stateVector[0] = State.mainBrain_FaceDataInterpretation_FaceDataInterpretation_PersonUnknown;
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

	/* 'default' enter sequence for state MoveToPerson */
	private void enterSequence_MainBrain_MoveToPerson_default() {
		nextStateIndex = 0;
		stateVector[0] = State.mainBrain_MoveToPerson;
	}

	/* 'EntrySearchForChat' enter sequence for state SearchForChat */
	private void enterSequence_MainBrain_SearchForChat_EntrySearchForChat() {
		enterSequence_MainBrain_SearchForChat_SearchForChat_EntrySearchForChat();
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

	/* 'default' enter sequence for state StartGatherData */
	private void enterSequence_MainBrain_StartGatherData_default() {
		entryAction_MainBrain_StartGatherData();

		nextStateIndex = 0;
		stateVector[0] = State.mainBrain_StartGatherData;
	}

	/* 'default' enter sequence for state ReceiveUDPString */
	private void enterSequence_GatherData_ReceiveUDPString_default() {
		entryAction_GatherData_ReceiveUDPString();

		nextStateIndex = 1;
		stateVector[1] = State.gatherData_ReceiveUDPString;
	}

	/* 'default' enter sequence for state ParseStringForData */
	private void enterSequence_GatherData_ParseStringForData_default() {
		entryAction_GatherData_ParseStringForData();

		nextStateIndex = 1;
		stateVector[1] = State.gatherData_ParseStringForData;
	}

	/* 'default' enter sequence for state InitGatherData */
	private void enterSequence_GatherData_InitGatherData_default() {
		nextStateIndex = 1;
		stateVector[1] = State.gatherData_InitGatherData;
	}

	/* 'default' enter sequence for state InitTest */
	private void enterSequence_Test_InitTest_default() {
		nextStateIndex = 2;
		stateVector[2] = State.test_InitTest;
	}

	/* 'default' enter sequence for state Speak */
	private void enterSequence_Test_Speak_default() {
		entryAction_Test_Speak();

		nextStateIndex = 2;
		stateVector[2] = State.test_Speak;
	}

	/* 'default' enter sequence for region MainBrain */
	private void enterSequence_MainBrain_default() {
		react_MainBrain__entry_Default();
	}

	/* 'EntryFaceDataInterpretation' enter sequence for region FaceDataInterpretation */
	private void enterSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_EntryFaceDataInterpretation() {
		react_MainBrain_FaceDataInterpretation_FaceDataInterpretation_EntryFaceDataInterpretation();
	}

	/* 'EntrySearchForChat' enter sequence for region SearchForChat */
	private void enterSequence_MainBrain_SearchForChat_SearchForChat_EntrySearchForChat() {
		react_MainBrain_SearchForChat_SearchForChat_EntrySearchForChat();
	}

	/* 'default' enter sequence for region GatherData */
	private void enterSequence_GatherData_default() {
		react_GatherData__entry_Default();
	}

	/* 'default' enter sequence for region Test */
	private void enterSequence_Test_default() {
		react_Test__entry_Default();
	}

	/* Default exit sequence for state Init */
	private void exitSequence_MainBrain_Init() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for state FaceDataInterpretation */
	private void exitSequence_MainBrain_FaceDataInterpretation() {
		exitSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation();
	}

	/* Default exit sequence for state PersonKnown */
	private void exitSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_PersonKnown() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for state PersonUnknown */
	private void exitSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_PersonUnknown() {
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

	/* Default exit sequence for state MoveToPerson */
	private void exitSequence_MainBrain_MoveToPerson() {
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

	/* Default exit sequence for state StartGatherData */
	private void exitSequence_MainBrain_StartGatherData() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for state ReceiveUDPString */
	private void exitSequence_GatherData_ReceiveUDPString() {
		nextStateIndex = 1;
		stateVector[1] = State.$NullState$;
	}

	/* Default exit sequence for state ParseStringForData */
	private void exitSequence_GatherData_ParseStringForData() {
		nextStateIndex = 1;
		stateVector[1] = State.$NullState$;
	}

	/* Default exit sequence for state InitGatherData */
	private void exitSequence_GatherData_InitGatherData() {
		nextStateIndex = 1;
		stateVector[1] = State.$NullState$;
	}

	/* Default exit sequence for state InitTest */
	private void exitSequence_Test_InitTest() {
		nextStateIndex = 2;
		stateVector[2] = State.$NullState$;
	}

	/* Default exit sequence for state Speak */
	private void exitSequence_Test_Speak() {
		nextStateIndex = 2;
		stateVector[2] = State.$NullState$;

		exitAction_Test_Speak();
	}

	/* Default exit sequence for region MainBrain */
	private void exitSequence_MainBrain() {
		switch (stateVector[0]) {
			case mainBrain_Init :
				exitSequence_MainBrain_Init();
				break;

			case mainBrain_FaceDataInterpretation_FaceDataInterpretation_PersonKnown :
				exitSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_PersonKnown();
				break;

			case mainBrain_FaceDataInterpretation_FaceDataInterpretation_PersonUnknown :
				exitSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_PersonUnknown();
				break;

			case mainBrain_TurnToNoise :
				exitSequence_MainBrain_TurnToNoise();
				break;

			case mainBrain_Idle :
				exitSequence_MainBrain_Idle();
				break;

			case mainBrain_MoveToPerson :
				exitSequence_MainBrain_MoveToPerson();
				break;

			case mainBrain_SearchForChat_SearchForChat_Standing :
				exitSequence_MainBrain_SearchForChat_SearchForChat_Standing();
				break;

			case mainBrain_SearchForChat_SearchForChat_Walking :
				exitSequence_MainBrain_SearchForChat_SearchForChat_Walking();
				break;

			case mainBrain_StartGatherData :
				exitSequence_MainBrain_StartGatherData();
				break;

			default :
				break;
		}
	}

	/* Default exit sequence for region FaceDataInterpretation */
	private void exitSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation() {
		switch (stateVector[0]) {
			case mainBrain_FaceDataInterpretation_FaceDataInterpretation_PersonKnown :
				exitSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_PersonKnown();
				break;

			case mainBrain_FaceDataInterpretation_FaceDataInterpretation_PersonUnknown :
				exitSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_PersonUnknown();
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

	/* Default exit sequence for region GatherData */
	private void exitSequence_GatherData() {
		switch (stateVector[1]) {
			case gatherData_ReceiveUDPString :
				exitSequence_GatherData_ReceiveUDPString();
				break;

			case gatherData_ParseStringForData :
				exitSequence_GatherData_ParseStringForData();
				break;

			case gatherData_InitGatherData :
				exitSequence_GatherData_InitGatherData();
				break;

			default :
				break;
		}
	}

	/* Default exit sequence for region Test */
	private void exitSequence_Test() {
		switch (stateVector[2]) {
			case test_InitTest :
				exitSequence_Test_InitTest();
				break;

			case test_Speak :
				exitSequence_Test_Speak();
				break;

			default :
				break;
		}
	}

	/* The reactions of state Init. */
	private void react_MainBrain_Init() {
		effect_MainBrain_Init_tr0();
	}

	/* The reactions of state PersonKnown. */
	private void react_MainBrain_FaceDataInterpretation_FaceDataInterpretation_PersonKnown() {
		effect_MainBrain_FaceDataInterpretation_tr0();
	}

	/* The reactions of state PersonUnknown. */
	private void react_MainBrain_FaceDataInterpretation_FaceDataInterpretation_PersonUnknown() {
		effect_MainBrain_FaceDataInterpretation_tr0();
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

	/* The reactions of state MoveToPerson. */
	private void react_MainBrain_MoveToPerson() {
		if (check_MainBrain_MoveToPerson_tr0_tr0()) {
			effect_MainBrain_MoveToPerson_tr0();
		}
	}

	/* The reactions of state Standing. */
	private void react_MainBrain_SearchForChat_SearchForChat_Standing() {
		if (check_MainBrain_SearchForChat_SearchForChat_Standing_tr0_tr0()) {
			effect_MainBrain_SearchForChat_SearchForChat_Standing_tr0();
		} else {
			if (check_MainBrain_SearchForChat_SearchForChat_Standing_tr1_tr1()) {
				effect_MainBrain_SearchForChat_SearchForChat_Standing_tr1();
			} else {
				if (check_MainBrain_SearchForChat_SearchForChat_Standing_tr2_tr2()) {
					effect_MainBrain_SearchForChat_SearchForChat_Standing_tr2();
				}
			}
		}
	}

	/* The reactions of state Walking. */
	private void react_MainBrain_SearchForChat_SearchForChat_Walking() {
		if (check_MainBrain_SearchForChat_SearchForChat_Walking_tr0_tr0()) {
			effect_MainBrain_SearchForChat_SearchForChat_Walking_tr0();
		} else {
			if (check_MainBrain_SearchForChat_SearchForChat_Walking_tr1_tr1()) {
				effect_MainBrain_SearchForChat_SearchForChat_Walking_tr1();
			} else {
				if (check_MainBrain_SearchForChat_SearchForChat_Walking_tr2_tr2()) {
					effect_MainBrain_SearchForChat_SearchForChat_Walking_tr2();
				}
			}
		}
	}

	/* The reactions of state StartGatherData. */
	private void react_MainBrain_StartGatherData() {
		effect_MainBrain_StartGatherData_tr0();
	}

	/* The reactions of state ReceiveUDPString. */
	private void react_GatherData_ReceiveUDPString() {
		effect_GatherData_ReceiveUDPString_tr0();
	}

	/* The reactions of state ParseStringForData. */
	private void react_GatherData_ParseStringForData() {
		effect_GatherData_ParseStringForData_tr0();
	}

	/* The reactions of state InitGatherData. */
	private void react_GatherData_InitGatherData() {
		if (check_GatherData_InitGatherData_tr0_tr0()) {
			effect_GatherData_InitGatherData_tr0();
		}
	}

	/* The reactions of state InitTest. */
	private void react_Test_InitTest() {
		if (check_Test_InitTest_tr0_tr0()) {
			effect_Test_InitTest_tr0();
		}
	}

	/* The reactions of state Speak. */
	private void react_Test_Speak() {
		if (check_Test_Speak_tr0_tr0()) {
			effect_Test_Speak_tr0();
		}
	}

	/* The reactions of state null. */
	private void react_MainBrain_FaceDataInterpretation_FaceDataInterpretation__choice_0() {
		if (check_MainBrain_FaceDataInterpretation_FaceDataInterpretation__choice_0_tr0_tr0()) {
			effect_MainBrain_FaceDataInterpretation_FaceDataInterpretation__choice_0_tr0();
		} else {
			if (check_MainBrain_FaceDataInterpretation_FaceDataInterpretation__choice_0_tr1_tr1()) {
				effect_MainBrain_FaceDataInterpretation_FaceDataInterpretation__choice_0_tr1();
			}
		}
	}

	/* Default react sequence for initial entry  */
	private void react_MainBrain__entry_Default() {
		enterSequence_MainBrain_Init_default();
	}

	/* Default react sequence for initial entry EntryFaceDataInterpretation */
	private void react_MainBrain_FaceDataInterpretation_FaceDataInterpretation_EntryFaceDataInterpretation() {
		react_MainBrain_FaceDataInterpretation_FaceDataInterpretation__choice_0();
	}

	/* Default react sequence for initial entry EntrySearchForChat */
	private void react_MainBrain_SearchForChat_SearchForChat_EntrySearchForChat() {
		enterSequence_MainBrain_SearchForChat_SearchForChat_Standing_default();
	}

	/* Default react sequence for initial entry  */
	private void react_GatherData__entry_Default() {
		enterSequence_GatherData_InitGatherData_default();
	}

	/* Default react sequence for initial entry  */
	private void react_Test__entry_Default() {
		enterSequence_Test_InitTest_default();
	}

	/* The reactions of exit ExitNoiseDetected. */
	private void react_MainBrain_SearchForChat_SearchForChat_ExitNoiseDetected() {
		effect_MainBrain_SearchForChat_tr0();
	}

	/* The reactions of exit ExitFaceFound. */
	private void react_MainBrain_SearchForChat_SearchForChat_ExitFaceFound() {
		effect_MainBrain_SearchForChat_tr1();
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
				case mainBrain_FaceDataInterpretation_FaceDataInterpretation_PersonKnown :
					react_MainBrain_FaceDataInterpretation_FaceDataInterpretation_PersonKnown();
					break;
				case mainBrain_FaceDataInterpretation_FaceDataInterpretation_PersonUnknown :
					react_MainBrain_FaceDataInterpretation_FaceDataInterpretation_PersonUnknown();
					break;
				case mainBrain_TurnToNoise :
					react_MainBrain_TurnToNoise();
					break;
				case mainBrain_Idle :
					react_MainBrain_Idle();
					break;
				case mainBrain_MoveToPerson :
					react_MainBrain_MoveToPerson();
					break;
				case mainBrain_SearchForChat_SearchForChat_Standing :
					react_MainBrain_SearchForChat_SearchForChat_Standing();
					break;
				case mainBrain_SearchForChat_SearchForChat_Walking :
					react_MainBrain_SearchForChat_SearchForChat_Walking();
					break;
				case mainBrain_StartGatherData :
					react_MainBrain_StartGatherData();
					break;
				case gatherData_ReceiveUDPString :
					react_GatherData_ReceiveUDPString();
					break;
				case gatherData_ParseStringForData :
					react_GatherData_ParseStringForData();
					break;
				case gatherData_InitGatherData :
					react_GatherData_InitGatherData();
					break;
				case test_InitTest :
					react_Test_InitTest();
					break;
				case test_Speak :
					react_Test_Speak();
					break;
				default :
					// $NullState$
			}
		}

		clearEvents();
	}
}
