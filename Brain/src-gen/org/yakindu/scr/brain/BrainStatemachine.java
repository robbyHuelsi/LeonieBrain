package org.yakindu.scr.brain;
import org.yakindu.scr.ITimer;

public class BrainStatemachine implements IBrainStatemachine {

	protected class SCIUdpInterfaceImpl implements SCIUdpInterface {

		private SCIUdpInterfaceOperationCallback operationCallback;

		public void setSCIUdpInterfaceOperationCallback(SCIUdpInterfaceOperationCallback operationCallback) {
			this.operationCallback = operationCallback;
		}

	}

	protected SCIUdpInterfaceImpl sCIUdpInterface;

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

	protected class SCICurrPersonImpl implements SCICurrPerson {

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

	protected class SCISTTImpl implements SCISTT {

		private String speakerMsg;

		public String getSpeakerMsg() {
			return speakerMsg;
		}

		public void setSpeakerMsg(String value) {
			this.speakerMsg = value;
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
		mainBrain_Init, mainBrain_FaceDataInterpretation, mainBrain_FaceDataInterpretation_FaceDataInterpretation_PersonKnown, mainBrain_FaceDataInterpretation_FaceDataInterpretation_PersonUnknown, mainBrain_TurnToNoise, mainBrain_Idle, mainBrain_MoveToPerson, mainBrain_SearchForChat, mainBrain_SearchForChat_SearchForChat_Standing, mainBrain_SearchForChat_SearchForChat_Walking, gatherData_ReceiveUDPString, gatherData_InitGatherData, test_InitTest, test_Speak, $NullState$
	};

	private final State[] stateVector = new State[3];

	private int nextStateIndex;

	private ITimer timer;

	private final boolean[] timeEvents = new boolean[1];

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
		sCIAci = new SCIAciImpl();
		sCICurrPerson = new SCICurrPersonImpl();
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
		for (int i = 0; i < 3; i++) {
			stateVector[i] = State.$NullState$;
		}

		clearEvents();
		clearOutEvents();

		sCIAci.setCountFoundFaces(0);

		sCICurrPerson.setId(0);

		sCICurrPerson.setKnown(false);

		sCICurrPerson.setFirstname("");

		sCICurrPerson.setLastname("");

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

		sCIKinect2.setGesture("");

		sCIKinect2.setNoiseDetected(false);

		sCIKinect2.setNoiseAngle("");

		sCILeapMotion.setGestureDetected(false);

		sCILeapMotion.setGesture("");

		sCIScitosRemoteControl.setEmergencyStop(false);

		sCIOpenDail.setSpeakerMsg("");

		sCIOpenDail.setLeonieMsg("");

		sCISTT.setSpeakerMsg("");

		sCIFaceAnimation.setEmotion("");

		setT(0);
	}

	public void enter() {
		if (!initialized)
			throw new IllegalStateException(
					"The state machine needs to be initialized first by calling the init() function.");

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
			case gatherData_ReceiveUDPString :
				return stateVector[1] == State.gatherData_ReceiveUDPString;
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
	public SCIAci getSCIAci() {
		return sCIAci;
	}
	public SCICurrPerson getSCICurrPerson() {
		return sCICurrPerson;
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
		return 1 == 0;
	}

	private boolean check_MainBrain_FaceDataInterpretation_tr1_tr1() {
		return sCIAci.countFoundFaces < 0;
	}

	private boolean check_MainBrain_TurnToNoise_tr0_tr0() {
		return sCIAci.countFoundFaces > 0;
	}

	private boolean check_MainBrain_TurnToNoise_tr1_tr1() {
		return sCIAci.countFoundFaces < 0;
	}

	private boolean check_MainBrain_MoveToPerson_tr0_tr0() {
		return sCICurrPerson.currDistance < 10;
	}

	private boolean check_MainBrain_SearchForChat_tr0_tr0() {
		return 1 == 0;
	}

	private boolean check_MainBrain_SearchForChat_tr1_tr1() {
		return sCIAci.countFoundFaces > 0;
	}

	private boolean check_MainBrain_SearchForChat_SearchForChat_Standing_tr0_tr0() {
		return true;
	}

	private boolean check_MainBrain_SearchForChat_SearchForChat_Walking_tr0_tr0() {
		return 0 == 1;
	}

	private boolean check_GatherData_InitGatherData_tr0_tr0() {
		return onTriggerDataGatherer;
	}

	private boolean check_Test_InitTest_tr0_tr0() {
		return timeEvents[0];
	}

	private boolean check_MainBrain_FaceDataInterpretation_FaceDataInterpretation__choice_0_tr0_tr0() {
		return sCICurrPerson.known == false;
	}

	private boolean check_MainBrain_FaceDataInterpretation_FaceDataInterpretation__choice_0_tr1_tr1() {
		return sCICurrPerson.known == true;
	}

	private void effect_MainBrain_Init_tr0() {
		exitSequence_MainBrain_Init();

		enterSequence_MainBrain_SearchForChat_default();
	}

	private void effect_MainBrain_FaceDataInterpretation_tr0() {
		exitSequence_MainBrain_FaceDataInterpretation();

		enterSequence_MainBrain_Idle_default();
	}

	private void effect_MainBrain_FaceDataInterpretation_tr1() {
		exitSequence_MainBrain_FaceDataInterpretation();

		enterSequence_MainBrain_SearchForChat_default();
	}

	private void effect_MainBrain_TurnToNoise_tr0() {
		exitSequence_MainBrain_TurnToNoise();

		enterSequence_MainBrain_MoveToPerson_default();
	}

	private void effect_MainBrain_TurnToNoise_tr1() {
		exitSequence_MainBrain_TurnToNoise();

		enterSequence_MainBrain_SearchForChat_default();
	}

	private void effect_MainBrain_MoveToPerson_tr0() {
		exitSequence_MainBrain_MoveToPerson();

		enterSequence_MainBrain_FaceDataInterpretation_default();
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

	private void effect_MainBrain_SearchForChat_SearchForChat_Walking_tr0() {
		exitSequence_MainBrain_SearchForChat_SearchForChat_Walking();

		enterSequence_MainBrain_SearchForChat_SearchForChat_Standing_default();
	}

	private void effect_GatherData_InitGatherData_tr0() {
		exitSequence_GatherData_InitGatherData();

		enterSequence_GatherData_ReceiveUDPString_default();
	}

	private void effect_Test_InitTest_tr0() {
		exitSequence_Test_InitTest();

		enterSequence_Test_Speak_default();
	}

	private void effect_MainBrain_FaceDataInterpretation_FaceDataInterpretation__choice_0_tr0() {
		enterSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_PersonUnknown_default();
	}

	private void effect_MainBrain_FaceDataInterpretation_FaceDataInterpretation__choice_0_tr1() {
		enterSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_PersonKnown_default();
	}

	/* Entry action for state 'Init'. */
	private void entryAction_MainBrain_Init() {
		sCIUdpInterface.operationCallback.receive();

		sCIUdpInterface.operationCallback.sendToVBrain_ACIonOff(true);
	}

	/* Entry action for state 'PersonUnknown'. */
	private void entryAction_MainBrain_FaceDataInterpretation_FaceDataInterpretation_PersonUnknown() {
		sCIUdpInterface.operationCallback.sendToHBrain_TTS("Bist du männlich oder weiblich");
	}

	/* Entry action for state 'TurnToNoise'. */
	private void entryAction_MainBrain_TurnToNoise() {
		sCIUdpInterface.operationCallback.sendToVBrain_ACIonOff(false);

		sCIUdpInterface.operationCallback.sendToHBrain_TTS("Oh, somebody is behind me");

		sCIUdpInterface.operationCallback.sendToNav_goToLC("0", "1");
	}

	/* Entry action for state 'MoveToPerson'. */
	private void entryAction_MainBrain_MoveToPerson() {
		sCIUdpInterface.operationCallback.sendToVBrain_ACIonOff(false);

		sCIUdpInterface.operationCallback.sendToNav_searchOnOff(false);
	}

	/* Entry action for state 'Standing'. */
	private void entryAction_MainBrain_SearchForChat_SearchForChat_Standing() {
		sCIUdpInterface.operationCallback.sendToNav_searchOnOff(false);
	}

	/* Entry action for state 'Walking'. */
	private void entryAction_MainBrain_SearchForChat_SearchForChat_Walking() {
		sCIUdpInterface.operationCallback.sendToNav_searchOnOff(true);
	}

	/* Entry action for state 'ReceiveUDPString'. */
	private void entryAction_GatherData_ReceiveUDPString() {
		sCIUdpInterface.operationCallback.receive();
	}

	/* Entry action for state 'InitTest'. */
	private void entryAction_Test_InitTest() {

		timer.setTimer(this, 0, 100 * 1000, false);

		sCIUdpInterface.operationCallback.print("Test alle 60 Sekunden");
	}

	/* Exit action for state 'InitTest'. */
	private void exitAction_Test_InitTest() {
		timer.unsetTimer(this, 0);
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

	/* 'default' enter sequence for state PersonKnown */
	private void enterSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_PersonKnown_default() {
		nextStateIndex = 0;
		stateVector[0] = State.mainBrain_FaceDataInterpretation_FaceDataInterpretation_PersonKnown;
	}

	/* 'default' enter sequence for state PersonUnknown */
	private void enterSequence_MainBrain_FaceDataInterpretation_FaceDataInterpretation_PersonUnknown_default() {
		entryAction_MainBrain_FaceDataInterpretation_FaceDataInterpretation_PersonUnknown();

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
		entryAction_MainBrain_MoveToPerson();

		nextStateIndex = 0;
		stateVector[0] = State.mainBrain_MoveToPerson;
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

	/* 'default' enter sequence for state ReceiveUDPString */
	private void enterSequence_GatherData_ReceiveUDPString_default() {
		entryAction_GatherData_ReceiveUDPString();

		nextStateIndex = 1;
		stateVector[1] = State.gatherData_ReceiveUDPString;
	}

	/* 'default' enter sequence for state InitGatherData */
	private void enterSequence_GatherData_InitGatherData_default() {
		nextStateIndex = 1;
		stateVector[1] = State.gatherData_InitGatherData;
	}

	/* 'default' enter sequence for state InitTest */
	private void enterSequence_Test_InitTest_default() {
		entryAction_Test_InitTest();

		nextStateIndex = 2;
		stateVector[2] = State.test_InitTest;
	}

	/* 'default' enter sequence for state Speak */
	private void enterSequence_Test_Speak_default() {
		nextStateIndex = 2;
		stateVector[2] = State.test_Speak;
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
	}

	/* Default exit sequence for state Walking */
	private void exitSequence_MainBrain_SearchForChat_SearchForChat_Walking() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for state ReceiveUDPString */
	private void exitSequence_GatherData_ReceiveUDPString() {
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

		exitAction_Test_InitTest();
	}

	/* Default exit sequence for state Speak */
	private void exitSequence_Test_Speak() {
		nextStateIndex = 2;
		stateVector[2] = State.$NullState$;
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
		if (check_MainBrain_FaceDataInterpretation_tr0_tr0()) {
			effect_MainBrain_FaceDataInterpretation_tr0();
		} else {
			if (check_MainBrain_FaceDataInterpretation_tr1_tr1()) {
				effect_MainBrain_FaceDataInterpretation_tr1();
			} else {
			}
		}
	}

	/* The reactions of state PersonUnknown. */
	private void react_MainBrain_FaceDataInterpretation_FaceDataInterpretation_PersonUnknown() {
		if (check_MainBrain_FaceDataInterpretation_tr0_tr0()) {
			effect_MainBrain_FaceDataInterpretation_tr0();
		} else {
			if (check_MainBrain_FaceDataInterpretation_tr1_tr1()) {
				effect_MainBrain_FaceDataInterpretation_tr1();
			} else {
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

	/* The reactions of state MoveToPerson. */
	private void react_MainBrain_MoveToPerson() {
		if (check_MainBrain_MoveToPerson_tr0_tr0()) {
			effect_MainBrain_MoveToPerson_tr0();
		}
	}

	/* The reactions of state Standing. */
	private void react_MainBrain_SearchForChat_SearchForChat_Standing() {
		if (check_MainBrain_SearchForChat_tr0_tr0()) {
			effect_MainBrain_SearchForChat_tr0();
		} else {
			if (check_MainBrain_SearchForChat_tr1_tr1()) {
				effect_MainBrain_SearchForChat_tr1();
			} else {
				effect_MainBrain_SearchForChat_SearchForChat_Standing_tr0();
			}
		}
	}

	/* The reactions of state Walking. */
	private void react_MainBrain_SearchForChat_SearchForChat_Walking() {
		if (check_MainBrain_SearchForChat_tr0_tr0()) {
			effect_MainBrain_SearchForChat_tr0();
		} else {
			if (check_MainBrain_SearchForChat_tr1_tr1()) {
				effect_MainBrain_SearchForChat_tr1();
			} else {
				if (check_MainBrain_SearchForChat_SearchForChat_Walking_tr0_tr0()) {
					effect_MainBrain_SearchForChat_SearchForChat_Walking_tr0();
				}
			}
		}
	}

	/* The reactions of state ReceiveUDPString. */
	private void react_GatherData_ReceiveUDPString() {
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

	/* Default react sequence for initial entry  */
	private void react_MainBrain_FaceDataInterpretation_FaceDataInterpretation__entry_Default() {
		react_MainBrain_FaceDataInterpretation_FaceDataInterpretation__choice_0();
	}

	/* Default react sequence for initial entry  */
	private void react_MainBrain_SearchForChat_SearchForChat__entry_Default() {
		enterSequence_MainBrain_SearchForChat_SearchForChat_Walking_default();
	}

	/* Default react sequence for initial entry  */
	private void react_GatherData__entry_Default() {
		enterSequence_GatherData_InitGatherData_default();
	}

	/* Default react sequence for initial entry  */
	private void react_Test__entry_Default() {
		enterSequence_Test_InitTest_default();
	}

	public void runCycle() {
		if (!initialized)
			throw new IllegalStateException(
					"The state machine needs to be initialized first by calling the init() function.");

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
				case gatherData_ReceiveUDPString :
					react_GatherData_ReceiveUDPString();
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
