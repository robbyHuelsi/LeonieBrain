package org.yakindu.scr.leoniebrain;
import org.yakindu.scr.ITimer;

public class LeonieBrainStatemachine implements ILeonieBrainStatemachine {

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

		private String faceID;

		public String getFaceID() {
			return faceID;
		}

		public void setFaceID(String value) {
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

	protected class SCIKinectImpl implements SCIKinect {

		private String geste;

		public String getGeste() {
			return geste;
		}

		public void setGeste(String value) {
			this.geste = value;
		}

	}

	protected SCIKinectImpl sCIKinect;

	protected class SCILeapMotionImpl implements SCILeapMotion {

		private String geste;

		public String getGeste() {
			return geste;
		}

		public void setGeste(String value) {
			this.geste = value;
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
		_0_Init, _0_FaceDataInterpretation, _0_FaceDataInterpretation__region0_PersonKnown, _0_FaceDataInterpretation__region0_PersonUnknown, _0_TurnToNoise, _0_Idle, _0_MoveToPerson, _0_SearchForChar, _0_SearchForChar__region0_Standing, _0_SearchForChar__region0_Walking, _0_GatherData, _0_GatherData__region0_ReceiveUDPString, _0_GatherData__region0_ParseStringForData, $NullState$
	};

	private final State[] stateVector = new State[1];

	private int nextStateIndex;

	private ITimer timer;

	private final boolean[] timeEvents = new boolean[2];

	private boolean start;

	private boolean faceFound;

	private boolean noiseDetected;

	private boolean textMsg;

	private boolean onTriggerDataGatherer;

	private long t;

	protected void setT(long value) {
		t = value;
	}

	protected long getT() {
		return t;
	}

	public LeonieBrainStatemachine() {

		sCIUdpInterface = new SCIUdpInterfaceImpl();
		sCIACIface_stat = new SCIACIface_statImpl();
		sCIACIface_dyn = new SCIACIface_dynImpl();
		sCIAci = new SCIAciImpl();
		sCIKinect = new SCIKinectImpl();
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
		for (int i = 0; i < 1; i++) {
			stateVector[i] = State.$NullState$;
		}

		clearEvents();
		clearOutEvents();

		sCIUdpInterface.setMessage("");

		sCIACIface_stat.setFaceID("");

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

		sCIAci.setCountFoundFaces(0);

		sCIKinect.setGeste("");

		sCILeapMotion.setGeste("");

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
					"The state machine needs to be initialized first by calling the init() function.");

		if (timer == null) {
			throw new IllegalStateException("timer not set.");
		}
		enterSequence__0_default();
	}

	public void exit() {
		exitSequence__0();
	}

	/**
	 * @see IStatemachine#isActive()
	 */
	public boolean isActive() {

		return stateVector[0] != State.$NullState$;
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
		faceFound = false;
		noiseDetected = false;
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
			case _0_Init :
				return stateVector[0] == State._0_Init;
			case _0_FaceDataInterpretation :
				return stateVector[0].ordinal() >= State._0_FaceDataInterpretation.ordinal()
						&& stateVector[0].ordinal() <= State._0_FaceDataInterpretation__region0_PersonUnknown.ordinal();
			case _0_FaceDataInterpretation__region0_PersonKnown :
				return stateVector[0] == State._0_FaceDataInterpretation__region0_PersonKnown;
			case _0_FaceDataInterpretation__region0_PersonUnknown :
				return stateVector[0] == State._0_FaceDataInterpretation__region0_PersonUnknown;
			case _0_TurnToNoise :
				return stateVector[0] == State._0_TurnToNoise;
			case _0_Idle :
				return stateVector[0] == State._0_Idle;
			case _0_MoveToPerson :
				return stateVector[0] == State._0_MoveToPerson;
			case _0_SearchForChar :
				return stateVector[0].ordinal() >= State._0_SearchForChar.ordinal()
						&& stateVector[0].ordinal() <= State._0_SearchForChar__region0_Walking.ordinal();
			case _0_SearchForChar__region0_Standing :
				return stateVector[0] == State._0_SearchForChar__region0_Standing;
			case _0_SearchForChar__region0_Walking :
				return stateVector[0] == State._0_SearchForChar__region0_Walking;
			case _0_GatherData :
				return stateVector[0].ordinal() >= State._0_GatherData.ordinal()
						&& stateVector[0].ordinal() <= State._0_GatherData__region0_ParseStringForData.ordinal();
			case _0_GatherData__region0_ReceiveUDPString :
				return stateVector[0] == State._0_GatherData__region0_ReceiveUDPString;
			case _0_GatherData__region0_ParseStringForData :
				return stateVector[0] == State._0_GatherData__region0_ParseStringForData;
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
	public SCIAci getSCIAci() {
		return sCIAci;
	}
	public SCIKinect getSCIKinect() {
		return sCIKinect;
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

	private void raiseFaceFound() {
		faceFound = true;
	}

	private void raiseNoiseDetected() {
		noiseDetected = true;
	}

	private void raiseTextMsg() {
		textMsg = true;
	}

	private void raiseOnTriggerDataGatherer() {
		onTriggerDataGatherer = true;
	}

	private boolean check__0_Init_tr0_tr0() {
		return start;
	}

	private boolean check__0_FaceDataInterpretation_tr0_tr0() {
		return true;
	}

	private boolean check__0_TurnToNoise_tr0_tr0() {
		return faceFound;
	}

	private boolean check__0_MoveToPerson_tr0_tr0() {
		return sCIACIface_dyn.distance < 10;
	}

	private boolean check__0_SearchForChar__region0_Standing_tr0_tr0() {
		return timeEvents[0];
	}

	private boolean check__0_SearchForChar__region0_Standing_tr1_tr1() {
		return noiseDetected;
	}

	private boolean check__0_SearchForChar__region0_Standing_tr2_tr2() {
		return onTriggerDataGatherer;
	}

	private boolean check__0_SearchForChar__region0_Standing_tr3_tr3() {
		return faceFound;
	}

	private boolean check__0_SearchForChar__region0_Walking_tr0_tr0() {
		return timeEvents[1];
	}

	private boolean check__0_SearchForChar__region0_Walking_tr1_tr1() {
		return noiseDetected;
	}

	private boolean check__0_SearchForChar__region0_Walking_tr2_tr2() {
		return onTriggerDataGatherer;
	}

	private boolean check__0_SearchForChar__region0_Walking_tr3_tr3() {
		return faceFound;
	}

	private boolean check__0_GatherData__region0_ReceiveUDPString_tr0_tr0() {
		return true;
	}

	private boolean check__0_GatherData__region0_ParseStringForData_tr0_tr0() {
		return true;
	}

	private boolean check__0_FaceDataInterpretation__region0__choice_0_tr0_tr0() {
		return sCIACIface_stat.confidence < 90;
	}

	private boolean check__0_FaceDataInterpretation__region0__choice_0_tr1_tr1() {
		return sCIACIface_stat.confidence >= 90;
	}

	private void effect__0_Init_tr0() {
		exitSequence__0_Init();

		enterSequence__0_SearchForChar__region0_Standing_default();
	}

	private void effect__0_FaceDataInterpretation_tr0() {
		exitSequence__0_FaceDataInterpretation();

		enterSequence__0_Idle_default();
	}

	private void effect__0_TurnToNoise_tr0() {
		exitSequence__0_TurnToNoise();

		enterSequence__0_MoveToPerson_default();
	}

	private void effect__0_MoveToPerson_tr0() {
		exitSequence__0_MoveToPerson();

		react__0_FaceDataInterpretation__region0__choice_0();
	}

	private void effect__0_SearchForChar__region0_Standing_tr0() {
		exitSequence__0_SearchForChar__region0_Standing();

		enterSequence__0_SearchForChar__region0_Walking_default();
	}

	private void effect__0_SearchForChar__region0_Standing_tr1() {
		exitSequence__0_SearchForChar();

		enterSequence__0_TurnToNoise_default();
	}

	private void effect__0_SearchForChar__region0_Standing_tr2() {
		exitSequence__0_SearchForChar();

		enterSequence__0_GatherData__region0_ReceiveUDPString_default();
	}

	private void effect__0_SearchForChar__region0_Standing_tr3() {
		exitSequence__0_SearchForChar();

		enterSequence__0_MoveToPerson_default();
	}

	private void effect__0_SearchForChar__region0_Walking_tr0() {
		exitSequence__0_SearchForChar__region0_Walking();

		enterSequence__0_SearchForChar__region0_Standing_default();
	}

	private void effect__0_SearchForChar__region0_Walking_tr1() {
		exitSequence__0_SearchForChar();

		enterSequence__0_TurnToNoise_default();
	}

	private void effect__0_SearchForChar__region0_Walking_tr2() {
		exitSequence__0_SearchForChar();

		enterSequence__0_GatherData__region0_ReceiveUDPString_default();
	}

	private void effect__0_SearchForChar__region0_Walking_tr3() {
		exitSequence__0_SearchForChar();

		enterSequence__0_MoveToPerson_default();
	}

	private void effect__0_GatherData__region0_ReceiveUDPString_tr0() {
		exitSequence__0_GatherData__region0_ReceiveUDPString();

		enterSequence__0_GatherData__region0_ParseStringForData_default();
	}

	private void effect__0_GatherData__region0_ParseStringForData_tr0() {
		exitSequence__0_GatherData__region0_ParseStringForData();

		enterSequence__0_GatherData__region0_ReceiveUDPString_default();
	}

	private void effect__0_FaceDataInterpretation__region0__choice_0_tr0() {
		enterSequence__0_FaceDataInterpretation__region0_PersonUnknown_default();
	}

	private void effect__0_FaceDataInterpretation__region0__choice_0_tr1() {
		enterSequence__0_FaceDataInterpretation__region0_PersonKnown_default();
	}

	/* Entry action for state 'Standing'. */
	private void entryAction__0_SearchForChar__region0_Standing() {

		timer.setTimer(this, 0, 10 * 1000, false);

		sCIMira.setRandMove(false);
	}

	/* Entry action for state 'Walking'. */
	private void entryAction__0_SearchForChar__region0_Walking() {

		timer.setTimer(this, 1, 20 * 1000, false);

		sCIMira.setRandMove(true);
	}

	/* Entry action for state 'ReceiveUDPString'. */
	private void entryAction__0_GatherData__region0_ReceiveUDPString() {
		sCIUdpInterface.operationCallback.receive();
	}

	/* Entry action for state 'ParseStringForData'. */
	private void entryAction__0_GatherData__region0_ParseStringForData() {
		sCIUdpInterface.operationCallback.parseString();
	}

	/* Exit action for state 'Standing'. */
	private void exitAction__0_SearchForChar__region0_Standing() {
		timer.unsetTimer(this, 0);
	}

	/* Exit action for state 'Walking'. */
	private void exitAction__0_SearchForChar__region0_Walking() {
		timer.unsetTimer(this, 1);
	}

	/* 'default' enter sequence for state Init */
	private void enterSequence__0_Init_default() {
		nextStateIndex = 0;
		stateVector[0] = State._0_Init;
	}

	/* 'default' enter sequence for state PersonKnown */
	private void enterSequence__0_FaceDataInterpretation__region0_PersonKnown_default() {
		nextStateIndex = 0;
		stateVector[0] = State._0_FaceDataInterpretation__region0_PersonKnown;
	}

	/* 'default' enter sequence for state PersonUnknown */
	private void enterSequence__0_FaceDataInterpretation__region0_PersonUnknown_default() {
		nextStateIndex = 0;
		stateVector[0] = State._0_FaceDataInterpretation__region0_PersonUnknown;
	}

	/* 'default' enter sequence for state TurnToNoise */
	private void enterSequence__0_TurnToNoise_default() {
		nextStateIndex = 0;
		stateVector[0] = State._0_TurnToNoise;
	}

	/* 'default' enter sequence for state Idle */
	private void enterSequence__0_Idle_default() {
		nextStateIndex = 0;
		stateVector[0] = State._0_Idle;
	}

	/* 'default' enter sequence for state MoveToPerson */
	private void enterSequence__0_MoveToPerson_default() {
		nextStateIndex = 0;
		stateVector[0] = State._0_MoveToPerson;
	}

	/* 'default' enter sequence for state Standing */
	private void enterSequence__0_SearchForChar__region0_Standing_default() {
		entryAction__0_SearchForChar__region0_Standing();

		nextStateIndex = 0;
		stateVector[0] = State._0_SearchForChar__region0_Standing;
	}

	/* 'default' enter sequence for state Walking */
	private void enterSequence__0_SearchForChar__region0_Walking_default() {
		entryAction__0_SearchForChar__region0_Walking();

		nextStateIndex = 0;
		stateVector[0] = State._0_SearchForChar__region0_Walking;
	}

	/* 'default' enter sequence for state ReceiveUDPString */
	private void enterSequence__0_GatherData__region0_ReceiveUDPString_default() {
		entryAction__0_GatherData__region0_ReceiveUDPString();

		nextStateIndex = 0;
		stateVector[0] = State._0_GatherData__region0_ReceiveUDPString;
	}

	/* 'default' enter sequence for state ParseStringForData */
	private void enterSequence__0_GatherData__region0_ParseStringForData_default() {
		entryAction__0_GatherData__region0_ParseStringForData();

		nextStateIndex = 0;
		stateVector[0] = State._0_GatherData__region0_ParseStringForData;
	}

	/* 'default' enter sequence for region 0 */
	private void enterSequence__0_default() {
		react__0__entry_Default();
	}

	/* Default exit sequence for state Init */
	private void exitSequence__0_Init() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for state FaceDataInterpretation */
	private void exitSequence__0_FaceDataInterpretation() {
		exitSequence__0_FaceDataInterpretation__region0();
	}

	/* Default exit sequence for state PersonKnown */
	private void exitSequence__0_FaceDataInterpretation__region0_PersonKnown() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for state PersonUnknown */
	private void exitSequence__0_FaceDataInterpretation__region0_PersonUnknown() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for state TurnToNoise */
	private void exitSequence__0_TurnToNoise() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for state Idle */
	private void exitSequence__0_Idle() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for state MoveToPerson */
	private void exitSequence__0_MoveToPerson() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for state SearchForChar */
	private void exitSequence__0_SearchForChar() {
		exitSequence__0_SearchForChar__region0();
	}

	/* Default exit sequence for state Standing */
	private void exitSequence__0_SearchForChar__region0_Standing() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;

		exitAction__0_SearchForChar__region0_Standing();
	}

	/* Default exit sequence for state Walking */
	private void exitSequence__0_SearchForChar__region0_Walking() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;

		exitAction__0_SearchForChar__region0_Walking();
	}

	/* Default exit sequence for state ReceiveUDPString */
	private void exitSequence__0_GatherData__region0_ReceiveUDPString() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for state ParseStringForData */
	private void exitSequence__0_GatherData__region0_ParseStringForData() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for region 0 */
	private void exitSequence__0() {
		switch (stateVector[0]) {
			case _0_Init :
				exitSequence__0_Init();
				break;

			case _0_FaceDataInterpretation__region0_PersonKnown :
				exitSequence__0_FaceDataInterpretation__region0_PersonKnown();
				break;

			case _0_FaceDataInterpretation__region0_PersonUnknown :
				exitSequence__0_FaceDataInterpretation__region0_PersonUnknown();
				break;

			case _0_TurnToNoise :
				exitSequence__0_TurnToNoise();
				break;

			case _0_Idle :
				exitSequence__0_Idle();
				break;

			case _0_MoveToPerson :
				exitSequence__0_MoveToPerson();
				break;

			case _0_SearchForChar__region0_Standing :
				exitSequence__0_SearchForChar__region0_Standing();
				break;

			case _0_SearchForChar__region0_Walking :
				exitSequence__0_SearchForChar__region0_Walking();
				break;

			case _0_GatherData__region0_ReceiveUDPString :
				exitSequence__0_GatherData__region0_ReceiveUDPString();
				break;

			case _0_GatherData__region0_ParseStringForData :
				exitSequence__0_GatherData__region0_ParseStringForData();
				break;

			default :
				break;
		}
	}

	/* Default exit sequence for region null */
	private void exitSequence__0_FaceDataInterpretation__region0() {
		switch (stateVector[0]) {
			case _0_FaceDataInterpretation__region0_PersonKnown :
				exitSequence__0_FaceDataInterpretation__region0_PersonKnown();
				break;

			case _0_FaceDataInterpretation__region0_PersonUnknown :
				exitSequence__0_FaceDataInterpretation__region0_PersonUnknown();
				break;

			default :
				break;
		}
	}

	/* Default exit sequence for region null */
	private void exitSequence__0_SearchForChar__region0() {
		switch (stateVector[0]) {
			case _0_SearchForChar__region0_Standing :
				exitSequence__0_SearchForChar__region0_Standing();
				break;

			case _0_SearchForChar__region0_Walking :
				exitSequence__0_SearchForChar__region0_Walking();
				break;

			default :
				break;
		}
	}

	/* Default exit sequence for region null */
	private void exitSequence__0_GatherData__region0() {
		switch (stateVector[0]) {
			case _0_GatherData__region0_ReceiveUDPString :
				exitSequence__0_GatherData__region0_ReceiveUDPString();
				break;

			case _0_GatherData__region0_ParseStringForData :
				exitSequence__0_GatherData__region0_ParseStringForData();
				break;

			default :
				break;
		}
	}

	/* The reactions of state Init. */
	private void react__0_Init() {
		if (check__0_Init_tr0_tr0()) {
			effect__0_Init_tr0();
		}
	}

	/* The reactions of state PersonKnown. */
	private void react__0_FaceDataInterpretation__region0_PersonKnown() {
		effect__0_FaceDataInterpretation_tr0();
	}

	/* The reactions of state PersonUnknown. */
	private void react__0_FaceDataInterpretation__region0_PersonUnknown() {
		effect__0_FaceDataInterpretation_tr0();
	}

	/* The reactions of state TurnToNoise. */
	private void react__0_TurnToNoise() {
		if (check__0_TurnToNoise_tr0_tr0()) {
			effect__0_TurnToNoise_tr0();
		}
	}

	/* The reactions of state Idle. */
	private void react__0_Idle() {
	}

	/* The reactions of state MoveToPerson. */
	private void react__0_MoveToPerson() {
		if (check__0_MoveToPerson_tr0_tr0()) {
			effect__0_MoveToPerson_tr0();
		}
	}

	/* The reactions of state Standing. */
	private void react__0_SearchForChar__region0_Standing() {
		if (check__0_SearchForChar__region0_Standing_tr0_tr0()) {
			effect__0_SearchForChar__region0_Standing_tr0();
		} else {
			if (check__0_SearchForChar__region0_Standing_tr1_tr1()) {
				effect__0_SearchForChar__region0_Standing_tr1();
			} else {
				if (check__0_SearchForChar__region0_Standing_tr2_tr2()) {
					effect__0_SearchForChar__region0_Standing_tr2();
				} else {
					if (check__0_SearchForChar__region0_Standing_tr3_tr3()) {
						effect__0_SearchForChar__region0_Standing_tr3();
					}
				}
			}
		}
	}

	/* The reactions of state Walking. */
	private void react__0_SearchForChar__region0_Walking() {
		if (check__0_SearchForChar__region0_Walking_tr0_tr0()) {
			effect__0_SearchForChar__region0_Walking_tr0();
		} else {
			if (check__0_SearchForChar__region0_Walking_tr1_tr1()) {
				effect__0_SearchForChar__region0_Walking_tr1();
			} else {
				if (check__0_SearchForChar__region0_Walking_tr2_tr2()) {
					effect__0_SearchForChar__region0_Walking_tr2();
				} else {
					if (check__0_SearchForChar__region0_Walking_tr3_tr3()) {
						effect__0_SearchForChar__region0_Walking_tr3();
					}
				}
			}
		}
	}

	/* The reactions of state ReceiveUDPString. */
	private void react__0_GatherData__region0_ReceiveUDPString() {
		effect__0_GatherData__region0_ReceiveUDPString_tr0();
	}

	/* The reactions of state ParseStringForData. */
	private void react__0_GatherData__region0_ParseStringForData() {
		effect__0_GatherData__region0_ParseStringForData_tr0();
	}

	/* The reactions of state null. */
	private void react__0_FaceDataInterpretation__region0__choice_0() {
		if (check__0_FaceDataInterpretation__region0__choice_0_tr0_tr0()) {
			effect__0_FaceDataInterpretation__region0__choice_0_tr0();
		} else {
			if (check__0_FaceDataInterpretation__region0__choice_0_tr1_tr1()) {
				effect__0_FaceDataInterpretation__region0__choice_0_tr1();
			}
		}
	}

	/* Default react sequence for initial entry  */
	private void react__0__entry_Default() {
		enterSequence__0_Init_default();
	}

	public void runCycle() {
		if (!initialized)
			throw new IllegalStateException(
					"The state machine needs to be initialized first by calling the init() function.");

		clearOutEvents();

		for (nextStateIndex = 0; nextStateIndex < stateVector.length; nextStateIndex++) {

			switch (stateVector[nextStateIndex]) {
				case _0_Init :
					react__0_Init();
					break;
				case _0_FaceDataInterpretation__region0_PersonKnown :
					react__0_FaceDataInterpretation__region0_PersonKnown();
					break;
				case _0_FaceDataInterpretation__region0_PersonUnknown :
					react__0_FaceDataInterpretation__region0_PersonUnknown();
					break;
				case _0_TurnToNoise :
					react__0_TurnToNoise();
					break;
				case _0_Idle :
					react__0_Idle();
					break;
				case _0_MoveToPerson :
					react__0_MoveToPerson();
					break;
				case _0_SearchForChar__region0_Standing :
					react__0_SearchForChar__region0_Standing();
					break;
				case _0_SearchForChar__region0_Walking :
					react__0_SearchForChar__region0_Walking();
					break;
				case _0_GatherData__region0_ReceiveUDPString :
					react__0_GatherData__region0_ReceiveUDPString();
					break;
				case _0_GatherData__region0_ParseStringForData :
					react__0_GatherData__region0_ParseStringForData();
					break;
				default :
					// $NullState$
			}
		}

		clearEvents();
	}
}
