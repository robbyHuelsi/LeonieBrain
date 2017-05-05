package org.yakindu.scr.openchallenge;
import org.yakindu.scr.ITimer;

public class OpenChallengeStatemachine implements IOpenChallengeStatemachine {

	protected class SCIBGFImpl implements SCIBGF {
	
		private SCIBGFOperationCallback operationCallback;
		
		public void setSCIBGFOperationCallback(
				SCIBGFOperationCallback operationCallback) {
			this.operationCallback = operationCallback;
		}
		private long eventNum;
		
		public long getEventNum() {
			return eventNum;
		}
		
		public void setEventNum(long value) {
			this.eventNum = value;
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
	
	protected class SCIHBrainImpl implements SCIHBrain {
	
		private SCIHBrainOperationCallback operationCallback;
		
		public void setSCIHBrainOperationCallback(
				SCIHBrainOperationCallback operationCallback) {
			this.operationCallback = operationCallback;
		}
		private boolean tTSReady;
		
		public void raiseTTSReady() {
			tTSReady = true;
		}
		
		protected void clearEvents() {
			tTSReady = false;
		}
	}
	
	protected SCIHBrainImpl sCIHBrain;
	
	protected class SCIVBrainImpl implements SCIVBrain {
	
		private SCIVBrainOperationCallback operationCallback;
		
		public void setSCIVBrainOperationCallback(
				SCIVBrainOperationCallback operationCallback) {
			this.operationCallback = operationCallback;
		}
	}
	
	protected SCIVBrainImpl sCIVBrain;
	
	protected class SCIAttractivenessImpl implements SCIAttractiveness {
	
		private SCIAttractivenessOperationCallback operationCallback;
		
		public void setSCIAttractivenessOperationCallback(
				SCIAttractivenessOperationCallback operationCallback) {
			this.operationCallback = operationCallback;
		}
		private double old_attr;
		
		public double getOld_attr() {
			return old_attr;
		}
		
		public void setOld_attr(double value) {
			this.old_attr = value;
		}
		
	}
	
	protected SCIAttractivenessImpl sCIAttractiveness;
	
	protected class SCIKinect2Impl implements SCIKinect2 {
	
		private SCIKinect2OperationCallback operationCallback;
		
		public void setSCIKinect2OperationCallback(
				SCIKinect2OperationCallback operationCallback) {
			this.operationCallback = operationCallback;
		}
		private boolean personDetected;
		
		public void raisePersonDetected() {
			personDetected = true;
		}
		
		private boolean noiseDeviatinWithoutBoneDetected;
		
		public void raiseNoiseDeviatinWithoutBoneDetected() {
			noiseDeviatinWithoutBoneDetected = true;
		}
		
		private boolean noiseWithBoneDetected;
		
		public void raiseNoiseWithBoneDetected() {
			noiseWithBoneDetected = true;
		}
		
		private boolean wavingDetected;
		
		public void raiseWavingDetected() {
			wavingDetected = true;
		}
		
		protected void clearEvents() {
			personDetected = false;
			noiseDeviatinWithoutBoneDetected = false;
			noiseWithBoneDetected = false;
			wavingDetected = false;
		}
	}
	
	protected SCIKinect2Impl sCIKinect2;
	
	protected class SCILeapMotionImpl implements SCILeapMotion {
	
		private SCILeapMotionOperationCallback operationCallback;
		
		public void setSCILeapMotionOperationCallback(
				SCILeapMotionOperationCallback operationCallback) {
			this.operationCallback = operationCallback;
		}
		private boolean gestureDetected;
		
		public void raiseGestureDetected() {
			gestureDetected = true;
		}
		
		private boolean stringFinished;
		
		public void raiseStringFinished() {
			stringFinished = true;
		}
		
		protected void clearEvents() {
			gestureDetected = false;
			stringFinished = false;
		}
	}
	
	protected SCILeapMotionImpl sCILeapMotion;
	
	protected class SCIMiraImpl implements SCIMira {
	
		private SCIMiraOperationCallback operationCallback;
		
		public void setSCIMiraOperationCallback(
				SCIMiraOperationCallback operationCallback) {
			this.operationCallback = operationCallback;
		}
		private boolean emergencyStop;
		
		public void raiseEmergencyStop() {
			emergencyStop = true;
		}
		
		private boolean bumpered;
		
		public void raiseBumpered() {
			bumpered = true;
		}
		
		private boolean blocked;
		
		public void raiseBlocked() {
			blocked = true;
		}
		
		private boolean arrivedWP;
		
		public void raiseArrivedWP() {
			arrivedWP = true;
		}
		
		protected void clearEvents() {
			emergencyStop = false;
			bumpered = false;
			blocked = false;
			arrivedWP = false;
		}
	}
	
	protected SCIMiraImpl sCIMira;
	
	protected class SCISTTImpl implements SCISTT {
	
		private SCISTTOperationCallback operationCallback;
		
		public void setSCISTTOperationCallback(
				SCISTTOperationCallback operationCallback) {
			this.operationCallback = operationCallback;
		}
		private boolean spokenTextReceived;
		
		public void raiseSpokenTextReceived() {
			spokenTextReceived = true;
		}
		
		private boolean incomprehensible;
		
		public void raiseIncomprehensible() {
			incomprehensible = true;
		}
		
		private boolean actionReceived;
		
		public void raiseActionReceived() {
			actionReceived = true;
		}
		
		private boolean answerReceived;
		
		public void raiseAnswerReceived() {
			answerReceived = true;
		}
		
		protected void clearEvents() {
			spokenTextReceived = false;
			incomprehensible = false;
			actionReceived = false;
			answerReceived = false;
		}
	}
	
	protected SCISTTImpl sCISTT;
	
	protected class SCICurrPersonImpl implements SCICurrPerson {
	
		private SCICurrPersonOperationCallback operationCallback;
		
		public void setSCICurrPersonOperationCallback(
				SCICurrPersonOperationCallback operationCallback) {
			this.operationCallback = operationCallback;
		}
	}
	
	protected SCICurrPersonImpl sCICurrPerson;
	
	private boolean initialized = false;
	
	public enum State {
		main_Init,
		main__final_,
		main_GreetingsToVisitors,
		main_GreetingsToVisitors_inner_region_GreetingsToVisitors,
		main_GreetingsToVisitors_inner_region_Head_Eyes,
		main_GreetingsToVisitors_inner_region_wait1,
		main_GreetingsToVisitors_inner_region_Greeting1,
		main_GreetingsToVisitors_inner_region_wait2,
		main_GreetingsToVisitors_inner_region_greeting3,
		main_GreetingsToVisitors_inner_region_wait3,
		main_GreetingsToVisitors_inner_region_greeting4,
		main_GreetingsToVisitors_inner_region_wait4,
		main_GreetingsToVisitors_inner_region_LeapMotion_Handgestures,
		main_GreetingsToVisitors_inner_region_Back_UTurn,
		main_GreetingsToVisitors_inner_region_InterruptionWave_wavingOf,
		main_GreetingsToVisitors_inner_region_Kinect_waveOn,
		main_GoToGWP0,
		main_GoToWavingPerson,
		main_AskForCommand,
		main_ListenForCommand,
		main_STTfinish,
		main_ResponseToAskForAttractiveness,
		main_Attractiveness,
		main_Attractiveness_openChallenge_attractiveness_AskForCommand,
		main_Attractiveness_openChallenge_attractiveness_ListenForCommand,
		main_Attractiveness_openChallenge_attractiveness_STTfinish,
		main_Attractiveness_openChallenge_attractiveness_ResponseToAskForAttractiveness,
		main_Attractiveness_openChallenge_attractiveness_DetectAttractiveness,
		main_PleaseRepeat,
		main_BackToPerson1,
		main_Joke,
		main_RecogniceSadness,
		main_RecogniceSmile,
		main_JokeFinished,
		main_LeapMotion,
		main_LeapMotion_LeapMotion_in_OpenChallenge_Text,
		main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_YesNo,
		main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_YesNo_inner_region_StartSTT,
		main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_YesNo_inner_region_Copy_1_STT3,
		main_LeapMotion_LeapMotion_in_OpenChallenge_yes,
		main_LeapMotion_LeapMotion_in_OpenChallenge_no,
		main_LeapMotion_LeapMotion_in_OpenChallenge_YESNO,
		main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight,
		main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight_Detect_LeftRight_StartSTT,
		main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight_Detect_LeftRight_Copy_1_STT3,
		main_LeapMotion_LeapMotion_in_OpenChallenge_Left,
		main_LeapMotion_LeapMotion_in_OpenChallenge_Right,
		main_LeapMotion_LeapMotion_in_OpenChallenge_ByeBye,
		main_ByeBye,
		leonie_Bupered_Or_Emergency_Stop_waitForEvent,
		leonie_Bupered_Or_Emergency_Stop_Bumpered,
		leonie_Bupered_Or_Emergency_Stop_resetFace,
		leonie_Bupered_Or_Emergency_Stop_EmergencyStop,
		leonie_Bupered_Or_Emergency_Stop_checkEmergency,
		$NullState$
	};
	
	private final State[] stateVector = new State[2];
	
	private int nextStateIndex;
	
	private ITimer timer;
	
	private final boolean[] timeEvents = new boolean[12];
	private long counter;
	
	protected void setCounter(long value) {
		counter = value;
	}
	
	protected long getCounter() {
		return counter;
	}
	
	private String nameBuffer;
	
	protected void setNameBuffer(String value) {
		nameBuffer = value;
	}
	
	protected String getNameBuffer() {
		return nameBuffer;
	}
	
	private long questionCounter;
	
	protected void setQuestionCounter(long value) {
		questionCounter = value;
	}
	
	protected long getQuestionCounter() {
		return questionCounter;
	}
	
	private long questionRepeat;
	
	protected void setQuestionRepeat(long value) {
		questionRepeat = value;
	}
	
	protected long getQuestionRepeat() {
		return questionRepeat;
	}
	
	private long startGWP;
	
	protected void setStartGWP(long value) {
		startGWP = value;
	}
	
	protected long getStartGWP() {
		return startGWP;
	}
	
	public OpenChallengeStatemachine() {
		sCIBGF = new SCIBGFImpl();
		sCIHBrain = new SCIHBrainImpl();
		sCIVBrain = new SCIVBrainImpl();
		sCIAttractiveness = new SCIAttractivenessImpl();
		sCIKinect2 = new SCIKinect2Impl();
		sCILeapMotion = new SCILeapMotionImpl();
		sCIMira = new SCIMiraImpl();
		sCISTT = new SCISTTImpl();
		sCICurrPerson = new SCICurrPersonImpl();
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
		sCIBGF.setEventNum(0);
		
		sCIBGF.setRandNum(0);
		
		sCIAttractiveness.setOld_attr(0.0);
		
		setCounter(0);
		
		setNameBuffer("");
		
		setQuestionCounter(0);
		
		setQuestionRepeat(0);
		
		setStartGWP(0);
	}
	
	public void enter() {
		if (!initialized) {
			throw new IllegalStateException(
					"The state machine needs to be initialized first by calling the init() function.");
		}
		if (timer == null) {
			throw new IllegalStateException("timer not set.");
		}
		enterSequence_main_default();
		enterSequence_Leonie_Bupered_Or_Emergency_Stop_default();
	}
	
	public void exit() {
		exitSequence_main();
		exitSequence_Leonie_Bupered_Or_Emergency_Stop();
	}
	
	/**
	 * @see IStatemachine#isActive()
	 */
	public boolean isActive() {
		return stateVector[0] != State.$NullState$||stateVector[1] != State.$NullState$;
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
		sCIHBrain.clearEvents();
		sCIKinect2.clearEvents();
		sCILeapMotion.clearEvents();
		sCIMira.clearEvents();
		sCISTT.clearEvents();
		for (int i=0; i<timeEvents.length; i++) {
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
		case main_Init:
			return stateVector[0] == State.main_Init;
		case main__final_:
			return stateVector[0] == State.main__final_;
		case main_GreetingsToVisitors:
			return stateVector[0].ordinal() >= State.
					main_GreetingsToVisitors.ordinal()&& stateVector[0].ordinal() <= State.main_GreetingsToVisitors_inner_region_Kinect_waveOn.ordinal();
		case main_GreetingsToVisitors_inner_region_GreetingsToVisitors:
			return stateVector[0] == State.main_GreetingsToVisitors_inner_region_GreetingsToVisitors;
		case main_GreetingsToVisitors_inner_region_Head_Eyes:
			return stateVector[0] == State.main_GreetingsToVisitors_inner_region_Head_Eyes;
		case main_GreetingsToVisitors_inner_region_wait1:
			return stateVector[0] == State.main_GreetingsToVisitors_inner_region_wait1;
		case main_GreetingsToVisitors_inner_region_Greeting1:
			return stateVector[0] == State.main_GreetingsToVisitors_inner_region_Greeting1;
		case main_GreetingsToVisitors_inner_region_wait2:
			return stateVector[0] == State.main_GreetingsToVisitors_inner_region_wait2;
		case main_GreetingsToVisitors_inner_region_greeting3:
			return stateVector[0] == State.main_GreetingsToVisitors_inner_region_greeting3;
		case main_GreetingsToVisitors_inner_region_wait3:
			return stateVector[0] == State.main_GreetingsToVisitors_inner_region_wait3;
		case main_GreetingsToVisitors_inner_region_greeting4:
			return stateVector[0] == State.main_GreetingsToVisitors_inner_region_greeting4;
		case main_GreetingsToVisitors_inner_region_wait4:
			return stateVector[0] == State.main_GreetingsToVisitors_inner_region_wait4;
		case main_GreetingsToVisitors_inner_region_LeapMotion_Handgestures:
			return stateVector[0] == State.main_GreetingsToVisitors_inner_region_LeapMotion_Handgestures;
		case main_GreetingsToVisitors_inner_region_Back_UTurn:
			return stateVector[0] == State.main_GreetingsToVisitors_inner_region_Back_UTurn;
		case main_GreetingsToVisitors_inner_region_InterruptionWave_wavingOf:
			return stateVector[0] == State.main_GreetingsToVisitors_inner_region_InterruptionWave_wavingOf;
		case main_GreetingsToVisitors_inner_region_Kinect_waveOn:
			return stateVector[0] == State.main_GreetingsToVisitors_inner_region_Kinect_waveOn;
		case main_GoToGWP0:
			return stateVector[0] == State.main_GoToGWP0;
		case main_GoToWavingPerson:
			return stateVector[0] == State.main_GoToWavingPerson;
		case main_AskForCommand:
			return stateVector[0] == State.main_AskForCommand;
		case main_ListenForCommand:
			return stateVector[0] == State.main_ListenForCommand;
		case main_STTfinish:
			return stateVector[0] == State.main_STTfinish;
		case main_ResponseToAskForAttractiveness:
			return stateVector[0] == State.main_ResponseToAskForAttractiveness;
		case main_Attractiveness:
			return stateVector[0].ordinal() >= State.
					main_Attractiveness.ordinal()&& stateVector[0].ordinal() <= State.main_Attractiveness_openChallenge_attractiveness_DetectAttractiveness.ordinal();
		case main_Attractiveness_openChallenge_attractiveness_AskForCommand:
			return stateVector[0] == State.main_Attractiveness_openChallenge_attractiveness_AskForCommand;
		case main_Attractiveness_openChallenge_attractiveness_ListenForCommand:
			return stateVector[0] == State.main_Attractiveness_openChallenge_attractiveness_ListenForCommand;
		case main_Attractiveness_openChallenge_attractiveness_STTfinish:
			return stateVector[0] == State.main_Attractiveness_openChallenge_attractiveness_STTfinish;
		case main_Attractiveness_openChallenge_attractiveness_ResponseToAskForAttractiveness:
			return stateVector[0] == State.main_Attractiveness_openChallenge_attractiveness_ResponseToAskForAttractiveness;
		case main_Attractiveness_openChallenge_attractiveness_DetectAttractiveness:
			return stateVector[0] == State.main_Attractiveness_openChallenge_attractiveness_DetectAttractiveness;
		case main_PleaseRepeat:
			return stateVector[0] == State.main_PleaseRepeat;
		case main_BackToPerson1:
			return stateVector[0] == State.main_BackToPerson1;
		case main_Joke:
			return stateVector[0] == State.main_Joke;
		case main_RecogniceSadness:
			return stateVector[0] == State.main_RecogniceSadness;
		case main_RecogniceSmile:
			return stateVector[0] == State.main_RecogniceSmile;
		case main_JokeFinished:
			return stateVector[0] == State.main_JokeFinished;
		case main_LeapMotion:
			return stateVector[0].ordinal() >= State.
					main_LeapMotion.ordinal()&& stateVector[0].ordinal() <= State.main_LeapMotion_LeapMotion_in_OpenChallenge_ByeBye.ordinal();
		case main_LeapMotion_LeapMotion_in_OpenChallenge_Text:
			return stateVector[0] == State.main_LeapMotion_LeapMotion_in_OpenChallenge_Text;
		case main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_YesNo:
			return stateVector[0].ordinal() >= State.
					main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_YesNo.ordinal()&& stateVector[0].ordinal() <= State.main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_YesNo_inner_region_Copy_1_STT3.ordinal();
		case main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_YesNo_inner_region_StartSTT:
			return stateVector[0] == State.main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_YesNo_inner_region_StartSTT;
		case main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_YesNo_inner_region_Copy_1_STT3:
			return stateVector[0] == State.main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_YesNo_inner_region_Copy_1_STT3;
		case main_LeapMotion_LeapMotion_in_OpenChallenge_yes:
			return stateVector[0] == State.main_LeapMotion_LeapMotion_in_OpenChallenge_yes;
		case main_LeapMotion_LeapMotion_in_OpenChallenge_no:
			return stateVector[0] == State.main_LeapMotion_LeapMotion_in_OpenChallenge_no;
		case main_LeapMotion_LeapMotion_in_OpenChallenge_YESNO:
			return stateVector[0] == State.main_LeapMotion_LeapMotion_in_OpenChallenge_YESNO;
		case main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight:
			return stateVector[0].ordinal() >= State.
					main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight.ordinal()&& stateVector[0].ordinal() <= State.main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight_Detect_LeftRight_Copy_1_STT3.ordinal();
		case main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight_Detect_LeftRight_StartSTT:
			return stateVector[0] == State.main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight_Detect_LeftRight_StartSTT;
		case main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight_Detect_LeftRight_Copy_1_STT3:
			return stateVector[0] == State.main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight_Detect_LeftRight_Copy_1_STT3;
		case main_LeapMotion_LeapMotion_in_OpenChallenge_Left:
			return stateVector[0] == State.main_LeapMotion_LeapMotion_in_OpenChallenge_Left;
		case main_LeapMotion_LeapMotion_in_OpenChallenge_Right:
			return stateVector[0] == State.main_LeapMotion_LeapMotion_in_OpenChallenge_Right;
		case main_LeapMotion_LeapMotion_in_OpenChallenge_ByeBye:
			return stateVector[0] == State.main_LeapMotion_LeapMotion_in_OpenChallenge_ByeBye;
		case main_ByeBye:
			return stateVector[0] == State.main_ByeBye;
		case leonie_Bupered_Or_Emergency_Stop_waitForEvent:
			return stateVector[1] == State.leonie_Bupered_Or_Emergency_Stop_waitForEvent;
		case leonie_Bupered_Or_Emergency_Stop_Bumpered:
			return stateVector[1] == State.leonie_Bupered_Or_Emergency_Stop_Bumpered;
		case leonie_Bupered_Or_Emergency_Stop_resetFace:
			return stateVector[1] == State.leonie_Bupered_Or_Emergency_Stop_resetFace;
		case leonie_Bupered_Or_Emergency_Stop_EmergencyStop:
			return stateVector[1] == State.leonie_Bupered_Or_Emergency_Stop_EmergencyStop;
		case leonie_Bupered_Or_Emergency_Stop_checkEmergency:
			return stateVector[1] == State.leonie_Bupered_Or_Emergency_Stop_checkEmergency;
		default:
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
	
	public SCIHBrain getSCIHBrain() {
		return sCIHBrain;
	}
	
	public SCIVBrain getSCIVBrain() {
		return sCIVBrain;
	}
	
	public SCIAttractiveness getSCIAttractiveness() {
		return sCIAttractiveness;
	}
	
	public SCIKinect2 getSCIKinect2() {
		return sCIKinect2;
	}
	
	public SCILeapMotion getSCILeapMotion() {
		return sCILeapMotion;
	}
	
	public SCIMira getSCIMira() {
		return sCIMira;
	}
	
	public SCISTT getSCISTT() {
		return sCISTT;
	}
	
	public SCICurrPerson getSCICurrPerson() {
		return sCICurrPerson;
	}
	
	private boolean check_main_Init_tr0_tr0() {
		return timeEvents[0];
	}
	
	private boolean check_main_GreetingsToVisitors_inner_region_GreetingsToVisitors_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_main_GreetingsToVisitors_inner_region_Head_Eyes_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_main_GreetingsToVisitors_inner_region_wait1_tr0_tr0() {
		return timeEvents[1];
	}
	
	private boolean check_main_GreetingsToVisitors_inner_region_Greeting1_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_main_GreetingsToVisitors_inner_region_wait2_tr0_tr0() {
		return timeEvents[2];
	}
	
	private boolean check_main_GreetingsToVisitors_inner_region_greeting3_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_main_GreetingsToVisitors_inner_region_wait3_tr0_tr0() {
		return timeEvents[3];
	}
	
	private boolean check_main_GreetingsToVisitors_inner_region_greeting4_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_main_GreetingsToVisitors_inner_region_wait4_tr0_tr0() {
		return timeEvents[4];
	}
	
	private boolean check_main_GreetingsToVisitors_inner_region_LeapMotion_Handgestures_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_main_GreetingsToVisitors_inner_region_Back_UTurn_tr0_tr0() {
		return timeEvents[5];
	}
	
	private boolean check_main_GreetingsToVisitors_inner_region_InterruptionWave_wavingOf_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_main_GreetingsToVisitors_inner_region_Kinect_waveOn_tr0_tr0() {
		return sCIKinect2.wavingDetected;
	}
	
	private boolean check_main_GoToGWP0_tr0_tr0() {
		return sCIMira.arrivedWP;
	}
	
	private boolean check_main_GoToWavingPerson_tr0_tr0() {
		return sCIMira.arrivedWP;
	}
	
	private boolean check_main_AskForCommand_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_main_ListenForCommand_tr0_tr0() {
		return timeEvents[6];
	}
	
	private boolean check_main_STTfinish_tr0_tr0() {
		return (sCISTT.operationCallback.getObject()== null?"attractivness" ==null :sCISTT.operationCallback.getObject().equals("attractivness"));
	}
	
	private boolean check_main_STTfinish_tr1_tr1() {
		return sCISTT.incomprehensible;
	}
	
	private boolean check_main_ResponseToAskForAttractiveness_tr0_tr0() {
		return true;
	}
	
	private boolean check_main_Attractiveness_openChallenge_attractiveness_AskForCommand_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_main_Attractiveness_openChallenge_attractiveness_ListenForCommand_tr0_tr0() {
		return timeEvents[7];
	}
	
	private boolean check_main_Attractiveness_openChallenge_attractiveness_STTfinish_tr0_tr0() {
		return (sCISTT.operationCallback.getObject()== null?"attractivness" ==null :sCISTT.operationCallback.getObject().equals("attractivness"));
	}
	
	private boolean check_main_Attractiveness_openChallenge_attractiveness_ResponseToAskForAttractiveness_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_main_PleaseRepeat_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_main_BackToPerson1_tr0_tr0() {
		return sCIMira.arrivedWP;
	}
	
	private boolean check_main_Joke_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_main_LeapMotion_tr0_tr0() {
		return true;
	}
	
	private boolean check_main_LeapMotion_LeapMotion_in_OpenChallenge_Text_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_YesNo_tr2_tr2() {
		return getCounter()==3;
	}
	
	private boolean check_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_YesNo_inner_region_StartSTT_tr0_tr0() {
		return 1==0;
	}
	
	private boolean check_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_YesNo_inner_region_StartSTT_tr1_tr1() {
		return 0==1;
	}
	
	private boolean check_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_YesNo_inner_region_StartSTT_tr2_tr2() {
		return 0==1;
	}
	
	private boolean check_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_YesNo_inner_region_StartSTT_tr3_tr3() {
		return (sCILeapMotion.operationCallback.getGesture()== null?"true" ==null :sCILeapMotion.operationCallback.getGesture().equals("true"));
	}
	
	private boolean check_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_YesNo_inner_region_StartSTT_tr4_tr4() {
		return (sCILeapMotion.operationCallback.getGesture()== null?"false" ==null :sCILeapMotion.operationCallback.getGesture().equals("false"));
	}
	
	private boolean check_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_YesNo_inner_region_Copy_1_STT3_tr0_tr0() {
		return sCISTT.spokenTextReceived;
	}
	
	private boolean check_main_LeapMotion_LeapMotion_in_OpenChallenge_yes_tr0_tr0() {
		return timeEvents[8];
	}
	
	private boolean check_main_LeapMotion_LeapMotion_in_OpenChallenge_no_tr0_tr0() {
		return timeEvents[9];
	}
	
	private boolean check_main_LeapMotion_LeapMotion_in_OpenChallenge_YESNO_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight_Detect_LeftRight_StartSTT_tr0_tr0() {
		return 1==0;
	}
	
	private boolean check_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight_Detect_LeftRight_StartSTT_tr1_tr1() {
		return 0==1;
	}
	
	private boolean check_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight_Detect_LeftRight_StartSTT_tr2_tr2() {
		return 0==1;
	}
	
	private boolean check_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight_Detect_LeftRight_StartSTT_tr3_tr3() {
		return (sCILeapMotion.operationCallback.getGesture()== null?"right" ==null :sCILeapMotion.operationCallback.getGesture().equals("right"));
	}
	
	private boolean check_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight_Detect_LeftRight_StartSTT_tr4_tr4() {
		return (sCILeapMotion.operationCallback.getGesture()== null?"left" ==null :sCILeapMotion.operationCallback.getGesture().equals("left"));
	}
	
	private boolean check_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight_Detect_LeftRight_Copy_1_STT3_tr0_tr0() {
		return sCISTT.spokenTextReceived;
	}
	
	private boolean check_main_LeapMotion_LeapMotion_in_OpenChallenge_ByeBye_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_main_ByeBye_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_Leonie_Bupered_Or_Emergency_Stop_waitForEvent_tr0_tr0() {
		return sCIMira.bumpered;
	}
	
	private boolean check_Leonie_Bupered_Or_Emergency_Stop_waitForEvent_tr1_tr1() {
		return sCIMira.emergencyStop;
	}
	
	private boolean check_Leonie_Bupered_Or_Emergency_Stop_Bumpered_tr0_tr0() {
		return timeEvents[10];
	}
	
	private boolean check_Leonie_Bupered_Or_Emergency_Stop_resetFace_tr0_tr0() {
		return true;
	}
	
	private boolean check_Leonie_Bupered_Or_Emergency_Stop_EmergencyStop_tr0_tr0() {
		return true;
	}
	
	private boolean check_Leonie_Bupered_Or_Emergency_Stop_checkEmergency_tr0_tr0() {
		return timeEvents[11];
	}
	
	private boolean check_Leonie_Bupered_Or_Emergency_Stop_checkEmergency_tr1_tr1() {
		return sCIMira.emergencyStop;
	}
	
	private boolean check_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_YesNo_inner_region__choice_0_tr0_tr0() {
		return (sCISTT.operationCallback.getSpokenText()== null?"yes" ==null :sCISTT.operationCallback.getSpokenText().equals("yes"));
	}
	
	private boolean check_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_YesNo_inner_region__choice_0_tr1_tr1() {
		return true;
	}
	
	private boolean check_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight_Detect_LeftRight__choice_0_tr0_tr0() {
		return (sCISTT.operationCallback.getSpokenText()== null?"yes" ==null :sCISTT.operationCallback.getSpokenText().equals("yes"));
	}
	
	private boolean check_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight_Detect_LeftRight__choice_0_tr1_tr1() {
		return true;
	}
	
	private void effect_main_Init_tr0() {
		exitSequence_main_Init();
		enterSequence_main_GoToGWP0_default();
	}
	
	private void effect_main_GreetingsToVisitors_tr0() {
		exitSequence_main_GreetingsToVisitors();
		enterSequence_main_GoToWavingPerson_default();
	}
	
	private void effect_main_GreetingsToVisitors_inner_region_GreetingsToVisitors_tr0() {
		exitSequence_main_GreetingsToVisitors_inner_region_GreetingsToVisitors();
		enterSequence_main_GreetingsToVisitors_inner_region_wait1_default();
	}
	
	private void effect_main_GreetingsToVisitors_inner_region_Head_Eyes_tr0() {
		exitSequence_main_GreetingsToVisitors_inner_region_Head_Eyes();
		enterSequence_main_GreetingsToVisitors_inner_region_wait2_default();
	}
	
	private void effect_main_GreetingsToVisitors_inner_region_wait1_tr0() {
		exitSequence_main_GreetingsToVisitors_inner_region_wait1();
		enterSequence_main_GreetingsToVisitors_inner_region_Head_Eyes_default();
	}
	
	private void effect_main_GreetingsToVisitors_inner_region_Greeting1_tr0() {
		exitSequence_main_GreetingsToVisitors_inner_region_Greeting1();
		enterSequence_main_GreetingsToVisitors_inner_region_GreetingsToVisitors_default();
	}
	
	private void effect_main_GreetingsToVisitors_inner_region_wait2_tr0() {
		exitSequence_main_GreetingsToVisitors_inner_region_wait2();
		enterSequence_main_GreetingsToVisitors_inner_region_greeting3_default();
	}
	
	private void effect_main_GreetingsToVisitors_inner_region_greeting3_tr0() {
		exitSequence_main_GreetingsToVisitors_inner_region_greeting3();
		enterSequence_main_GreetingsToVisitors_inner_region_wait3_default();
	}
	
	private void effect_main_GreetingsToVisitors_inner_region_wait3_tr0() {
		exitSequence_main_GreetingsToVisitors_inner_region_wait3();
		enterSequence_main_GreetingsToVisitors_inner_region_greeting4_default();
	}
	
	private void effect_main_GreetingsToVisitors_inner_region_greeting4_tr0() {
		exitSequence_main_GreetingsToVisitors_inner_region_greeting4();
		enterSequence_main_GreetingsToVisitors_inner_region_wait4_default();
	}
	
	private void effect_main_GreetingsToVisitors_inner_region_wait4_tr0() {
		exitSequence_main_GreetingsToVisitors_inner_region_wait4();
		enterSequence_main_GreetingsToVisitors_inner_region_LeapMotion_Handgestures_default();
	}
	
	private void effect_main_GreetingsToVisitors_inner_region_LeapMotion_Handgestures_tr0() {
		exitSequence_main_GreetingsToVisitors_inner_region_LeapMotion_Handgestures();
		enterSequence_main_GreetingsToVisitors_inner_region_Back_UTurn_default();
	}
	
	private void effect_main_GreetingsToVisitors_inner_region_Back_UTurn_tr0() {
		exitSequence_main_GreetingsToVisitors_inner_region_Back_UTurn();
		enterSequence_main_GreetingsToVisitors_inner_region_Kinect_waveOn_default();
	}
	
	private void effect_main_GreetingsToVisitors_inner_region_InterruptionWave_wavingOf_tr0() {
		exitSequence_main_GreetingsToVisitors_inner_region_InterruptionWave_wavingOf();
		react_main_GreetingsToVisitors_inner_region_exit_GreetingsToVisitors();
	}
	
	private void effect_main_GreetingsToVisitors_inner_region_Kinect_waveOn_tr0() {
		exitSequence_main_GreetingsToVisitors_inner_region_Kinect_waveOn();
		enterSequence_main_GreetingsToVisitors_inner_region_InterruptionWave_wavingOf_default();
	}
	
	private void effect_main_GoToGWP0_tr0() {
		exitSequence_main_GoToGWP0();
		enterSequence_main_GreetingsToVisitors_default();
	}
	
	private void effect_main_GoToWavingPerson_tr0() {
		exitSequence_main_GoToWavingPerson();
		enterSequence_main_AskForCommand_default();
	}
	
	private void effect_main_AskForCommand_tr0() {
		exitSequence_main_AskForCommand();
		enterSequence_main_ListenForCommand_default();
	}
	
	private void effect_main_ListenForCommand_tr0() {
		exitSequence_main_ListenForCommand();
		enterSequence_main_STTfinish_default();
	}
	
	private void effect_main_STTfinish_tr0() {
		exitSequence_main_STTfinish();
		enterSequence_main_ResponseToAskForAttractiveness_default();
	}
	
	private void effect_main_STTfinish_tr1() {
		exitSequence_main_STTfinish();
		enterSequence_main_PleaseRepeat_default();
	}
	
	private void effect_main_ResponseToAskForAttractiveness_tr0() {
		exitSequence_main_ResponseToAskForAttractiveness();
		enterSequence_main_Attractiveness_default();
	}
	
	private void effect_main_Attractiveness_tr0() {
		exitSequence_main_Attractiveness();
		enterSequence_main_BackToPerson1_default();
	}
	
	private void effect_main_Attractiveness_openChallenge_attractiveness_AskForCommand_tr0() {
		exitSequence_main_Attractiveness_openChallenge_attractiveness_AskForCommand();
		enterSequence_main_Attractiveness_openChallenge_attractiveness_ListenForCommand_default();
	}
	
	private void effect_main_Attractiveness_openChallenge_attractiveness_ListenForCommand_tr0() {
		exitSequence_main_Attractiveness_openChallenge_attractiveness_ListenForCommand();
		enterSequence_main_Attractiveness_openChallenge_attractiveness_STTfinish_default();
	}
	
	private void effect_main_Attractiveness_openChallenge_attractiveness_STTfinish_tr0() {
		exitSequence_main_Attractiveness_openChallenge_attractiveness_STTfinish();
		enterSequence_main_Attractiveness_openChallenge_attractiveness_ResponseToAskForAttractiveness_default();
	}
	
	private void effect_main_Attractiveness_openChallenge_attractiveness_ResponseToAskForAttractiveness_tr0() {
		exitSequence_main_Attractiveness_openChallenge_attractiveness_ResponseToAskForAttractiveness();
		enterSequence_main_Attractiveness_openChallenge_attractiveness_DetectAttractiveness_default();
	}
	
	private void effect_main_PleaseRepeat_tr0() {
		exitSequence_main_PleaseRepeat();
		enterSequence_main_ListenForCommand_default();
	}
	
	private void effect_main_BackToPerson1_tr0() {
		exitSequence_main_BackToPerson1();
		enterSequence_main_RecogniceSadness_default();
	}
	
	private void effect_main_Joke_tr0() {
		exitSequence_main_Joke();
		enterSequence_main_RecogniceSmile_default();
	}
	
	private void effect_main_LeapMotion_tr0() {
		exitSequence_main_LeapMotion();
		enterSequence_main_ByeBye_default();
	}
	
	private void effect_main_LeapMotion_LeapMotion_in_OpenChallenge_Text_tr0() {
		exitSequence_main_LeapMotion_LeapMotion_in_OpenChallenge_Text();
		enterSequence_main_LeapMotion_LeapMotion_in_OpenChallenge_YESNO_default();
	}
	
	private void effect_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_YesNo_tr0() {
		exitSequence_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_YesNo();
		enterSequence_main_LeapMotion_LeapMotion_in_OpenChallenge_no_default();
	}
	
	private void effect_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_YesNo_tr1() {
		exitSequence_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_YesNo();
		enterSequence_main_LeapMotion_LeapMotion_in_OpenChallenge_yes_default();
	}
	
	private void effect_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_YesNo_tr2() {
		exitSequence_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_YesNo();
		enterSequence_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight_default();
	}
	
	private void effect_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_YesNo_inner_region_StartSTT_tr0() {
		exitSequence_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_YesNo_inner_region_StartSTT();
		enterSequence_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_YesNo_inner_region_Copy_1_STT3_default();
	}
	
	private void effect_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_YesNo_inner_region_StartSTT_tr1() {
		exitSequence_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_YesNo_inner_region_StartSTT();
		react_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_YesNo_inner_region_exit_yes();
	}
	
	private void effect_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_YesNo_inner_region_StartSTT_tr2() {
		exitSequence_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_YesNo_inner_region_StartSTT();
		react_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_YesNo_inner_region_exit_no();
	}
	
	private void effect_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_YesNo_inner_region_StartSTT_tr3() {
		exitSequence_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_YesNo_inner_region_StartSTT();
		react_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_YesNo_inner_region_exit_yes();
	}
	
	private void effect_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_YesNo_inner_region_StartSTT_tr4() {
		exitSequence_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_YesNo_inner_region_StartSTT();
		react_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_YesNo_inner_region_exit_no();
	}
	
	private void effect_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_YesNo_inner_region_Copy_1_STT3_tr0() {
		exitSequence_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_YesNo_inner_region_Copy_1_STT3();
		react_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_YesNo_inner_region__choice_0();
	}
	
	private void effect_main_LeapMotion_LeapMotion_in_OpenChallenge_yes_tr0() {
		exitSequence_main_LeapMotion_LeapMotion_in_OpenChallenge_yes();
		enterSequence_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_YesNo_default();
	}
	
	private void effect_main_LeapMotion_LeapMotion_in_OpenChallenge_no_tr0() {
		exitSequence_main_LeapMotion_LeapMotion_in_OpenChallenge_no();
		enterSequence_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_YesNo_default();
	}
	
	private void effect_main_LeapMotion_LeapMotion_in_OpenChallenge_YESNO_tr0() {
		exitSequence_main_LeapMotion_LeapMotion_in_OpenChallenge_YESNO();
		enterSequence_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_YesNo_default();
	}
	
	private void effect_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight_tr0() {
		exitSequence_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight();
		enterSequence_main_LeapMotion_LeapMotion_in_OpenChallenge_Left_default();
	}
	
	private void effect_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight_tr1() {
		exitSequence_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight();
		enterSequence_main_LeapMotion_LeapMotion_in_OpenChallenge_Right_default();
	}
	
	private void effect_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight_Detect_LeftRight_StartSTT_tr0() {
		exitSequence_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight_Detect_LeftRight_StartSTT();
		enterSequence_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight_Detect_LeftRight_Copy_1_STT3_default();
	}
	
	private void effect_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight_Detect_LeftRight_StartSTT_tr1() {
		exitSequence_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight_Detect_LeftRight_StartSTT();
		react_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight_Detect_LeftRight_exit_right();
	}
	
	private void effect_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight_Detect_LeftRight_StartSTT_tr2() {
		exitSequence_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight_Detect_LeftRight_StartSTT();
		react_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight_Detect_LeftRight_exit_left();
	}
	
	private void effect_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight_Detect_LeftRight_StartSTT_tr3() {
		exitSequence_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight_Detect_LeftRight_StartSTT();
		react_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight_Detect_LeftRight_exit_right();
	}
	
	private void effect_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight_Detect_LeftRight_StartSTT_tr4() {
		exitSequence_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight_Detect_LeftRight_StartSTT();
		react_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight_Detect_LeftRight_exit_left();
	}
	
	private void effect_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight_Detect_LeftRight_Copy_1_STT3_tr0() {
		exitSequence_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight_Detect_LeftRight_Copy_1_STT3();
		react_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight_Detect_LeftRight__choice_0();
	}
	
	private void effect_main_LeapMotion_LeapMotion_in_OpenChallenge_ByeBye_tr0() {
		exitSequence_main_LeapMotion_LeapMotion_in_OpenChallenge_ByeBye();
	}
	
	private void effect_main_ByeBye_tr0() {
		exitSequence_main_ByeBye();
		enterSequence_main__final__default();
	}
	
	private void effect_Leonie_Bupered_Or_Emergency_Stop_waitForEvent_tr0() {
		exitSequence_Leonie_Bupered_Or_Emergency_Stop_waitForEvent();
		enterSequence_Leonie_Bupered_Or_Emergency_Stop_Bumpered_default();
	}
	
	private void effect_Leonie_Bupered_Or_Emergency_Stop_waitForEvent_tr1() {
		exitSequence_Leonie_Bupered_Or_Emergency_Stop_waitForEvent();
		enterSequence_Leonie_Bupered_Or_Emergency_Stop_EmergencyStop_default();
	}
	
	private void effect_Leonie_Bupered_Or_Emergency_Stop_Bumpered_tr0() {
		exitSequence_Leonie_Bupered_Or_Emergency_Stop_Bumpered();
		enterSequence_Leonie_Bupered_Or_Emergency_Stop_resetFace_default();
	}
	
	private void effect_Leonie_Bupered_Or_Emergency_Stop_resetFace_tr0() {
		exitSequence_Leonie_Bupered_Or_Emergency_Stop_resetFace();
		enterSequence_Leonie_Bupered_Or_Emergency_Stop_waitForEvent_default();
	}
	
	private void effect_Leonie_Bupered_Or_Emergency_Stop_EmergencyStop_tr0() {
		exitSequence_Leonie_Bupered_Or_Emergency_Stop_EmergencyStop();
		enterSequence_Leonie_Bupered_Or_Emergency_Stop_checkEmergency_default();
	}
	
	private void effect_Leonie_Bupered_Or_Emergency_Stop_checkEmergency_tr0() {
		exitSequence_Leonie_Bupered_Or_Emergency_Stop_checkEmergency();
		enterSequence_Leonie_Bupered_Or_Emergency_Stop_resetFace_default();
	}
	
	private void effect_Leonie_Bupered_Or_Emergency_Stop_checkEmergency_tr1() {
		exitSequence_Leonie_Bupered_Or_Emergency_Stop_checkEmergency();
		enterSequence_Leonie_Bupered_Or_Emergency_Stop_checkEmergency_default();
	}
	
	private void effect_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_YesNo_inner_region__choice_0_tr0() {
		react_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_YesNo_inner_region_exit_yes();
	}
	
	private void effect_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_YesNo_inner_region__choice_0_tr1() {
		react_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_YesNo_inner_region_exit_no();
	}
	
	private void effect_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight_Detect_LeftRight__choice_0_tr0() {
		react_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight_Detect_LeftRight_exit_right();
	}
	
	private void effect_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight_Detect_LeftRight__choice_0_tr1() {
		react_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight_Detect_LeftRight_exit_left();
	}
	
	/* Entry action for state 'Init'. */
	private void entryAction_main_Init() {
		timer.setTimer(this, 0, 500 * 1000, false);
		
		setStartGWP(0);
	}
	
	/* Entry action for state 'GreetingsToVisitors'. */
	private void entryAction_main_GreetingsToVisitors_inner_region_GreetingsToVisitors() {
		sCIHBrain.operationCallback.sendTTS("Okay, I have to introduce myself.[blush:true] but I’m so nervous [:-)]I’m a helpful Robot in your smart home. [blush:false]But the special thing is, that I try to interact like a real Person. Look at my breathing.");
	}
	
	/* Entry action for state 'Head_Eyes'. */
	private void entryAction_main_GreetingsToVisitors_inner_region_Head_Eyes() {
		sCIHBrain.operationCallback.sendTTS("[idle3:false] Or look at my eyes{60;0} when i move my head.{0;0} At first I look at the new position. After eye movement my head follows. {-60;0} While my head is moving, my eyes go back. {Person} [idle3:true]");
	}
	
	/* Entry action for state 'wait1'. */
	private void entryAction_main_GreetingsToVisitors_inner_region_wait1() {
		timer.setTimer(this, 1, 2 * 1000, false);
	}
	
	/* Entry action for state 'Greeting1'. */
	private void entryAction_main_GreetingsToVisitors_inner_region_Greeting1() {
		sCIHBrain.operationCallback.sendTTS("[:-O]wow! so many people![idle3:true]");
	}
	
	/* Entry action for state 'wait2'. */
	private void entryAction_main_GreetingsToVisitors_inner_region_wait2() {
		timer.setTimer(this, 2, 1 * 1000, false);
	}
	
	/* Entry action for state 'greeting3'. */
	private void entryAction_main_GreetingsToVisitors_inner_region_greeting3() {
		sCIHBrain.operationCallback.sendTTS("[:-|]Besides my animated head I also have several sensors. On the front and the back I have laser sensors to localize myself. plan my way when moving and dynamic objects around me.");
	}
	
	/* Entry action for state 'wait3'. */
	private void entryAction_main_GreetingsToVisitors_inner_region_wait3() {
		timer.setTimer(this, 3, 1 * 1000, false);
	}
	
	/* Entry action for state 'greeting4'. */
	private void entryAction_main_GreetingsToVisitors_inner_region_greeting4() {
		sCIHBrain.operationCallback.sendTTS("The most important sensor for me are my cameras. {-20;100}I have several cameras in order to see all humans around me {20;100} as well as to look very close at human faces and analyse them more precicely. {Person}[:-)]I can recognize people and analyse their faces. [:-/]{-30;-90}At least I try it. [:-]In addition I try to estimate the attractiveness and the emotion! [:-)] {Person}");
	}
	
	/* Entry action for state 'wait4'. */
	private void entryAction_main_GreetingsToVisitors_inner_region_wait4() {
		timer.setTimer(this, 4, 1 * 1000, false);
	}
	
	/* Entry action for state 'LeapMotion_Handgestures'. */
	private void entryAction_main_GreetingsToVisitors_inner_region_LeapMotion_Handgestures() {
		sCIHBrain.operationCallback.sendTTS("{0;-150} In front of me is a Leap motion. {Person}This allows people to answer my questions also by giving me hand gestures.");
	}
	
	/* Entry action for state 'Back_UTurn'. */
	private void entryAction_main_GreetingsToVisitors_inner_region_Back_UTurn() {
		timer.setTimer(this, 5, 3 * 1000, false);
		
		sCIHBrain.operationCallback.sendTTS("On the back");
		
		sCIMira.operationCallback.sendBodyUTurn();
	}
	
	/* Entry action for state 'InterruptionWave_wavingOf'. */
	private void entryAction_main_GreetingsToVisitors_inner_region_InterruptionWave_wavingOf() {
		sCIHBrain.operationCallback.sendTTS("Oh there is someone waving behind me! I will finish my presentation and look what I can do for this person. [:-)]");
		
		sCIKinect2.operationCallback.sendWavingDetectionOnOff(false);
	}
	
	/* Entry action for state 'Kinect_waveOn'. */
	private void entryAction_main_GreetingsToVisitors_inner_region_Kinect_waveOn() {
		sCIKinect2.operationCallback.sendWavingDetectionOnOff(true);
		
		sCIHBrain.operationCallback.sendTTS("{-180;100}I have a kinect that I use as my ears. I can react on loud sounds behind me.{Person}");
	}
	
	/* Entry action for state 'GoToGWP0'. */
	private void entryAction_main_GoToGWP0() {
		sCIMira.operationCallback.sendGoToGWP(getStartGWP());
	}
	
	/* Entry action for state 'GoToWavingPerson'. */
	private void entryAction_main_GoToWavingPerson() {
		sCIMira.operationCallback.sendGoToLC(sCIKinect2.operationCallback.getWavingX(), sCIKinect2.operationCallback.getWavingY());
	}
	
	/* Entry action for state 'AskForCommand'. */
	private void entryAction_main_AskForCommand() {
		sCIHBrain.operationCallback.sendTTS("Hello. What can I do for you?");
	}
	
	/* Entry action for state 'ListenForCommand'. */
	private void entryAction_main_ListenForCommand() {
		timer.setTimer(this, 6, 10 * 1000, false);
		
		sCISTT.operationCallback.sendSpeechDetectionSmalltalk();
	}
	
	/* Entry action for state 'STTfinish'. */
	private void entryAction_main_STTfinish() {
		sCISTT.operationCallback.sendSpeechDetectionOff();
	}
	
	/* Entry action for state 'ResponseToAskForAttractiveness'. */
	private void entryAction_main_ResponseToAskForAttractiveness() {
		sCISTT.operationCallback.sendSpeechDetectionOff();
		
		sCIHBrain.operationCallback.sendTTS("Okay, I will detect your attractiveness for you. Please hold on till I'm finished");
	}
	
	/* Entry action for state 'AskForCommand'. */
	private void entryAction_main_Attractiveness_openChallenge_attractiveness_AskForCommand() {
		sCIHBrain.operationCallback.sendTTS("Hello. What can I do for you?");
	}
	
	/* Entry action for state 'ListenForCommand'. */
	private void entryAction_main_Attractiveness_openChallenge_attractiveness_ListenForCommand() {
		timer.setTimer(this, 7, 10 * 1000, false);
	}
	
	/* Entry action for state 'STTfinish'. */
	private void entryAction_main_Attractiveness_openChallenge_attractiveness_STTfinish() {
		sCISTT.operationCallback.sendSpeechDetectionOff();
	}
	
	/* Entry action for state 'ResponseToAskForAttractiveness'. */
	private void entryAction_main_Attractiveness_openChallenge_attractiveness_ResponseToAskForAttractiveness() {
		sCIHBrain.operationCallback.sendTTS("Okay, I will detect your attractiveness for you. Please hold on till I'm finished");
	}
	
	/* Entry action for state 'DetectAttractiveness'. */
	private void entryAction_main_Attractiveness_openChallenge_attractiveness_DetectAttractiveness() {
		sCIAttractiveness.operationCallback.sendToAttr_estimate();
	}
	
	/* Entry action for state 'PleaseRepeat'. */
	private void entryAction_main_PleaseRepeat() {
		sCIHBrain.operationCallback.sendTTS("I'm sorry. I can't understand what you said. Can you repeat it please?");
	}
	
	/* Entry action for state 'BackToPerson1'. */
	private void entryAction_main_BackToPerson1() {
		sCIMira.operationCallback.sendGoToGWP(getStartGWP());
	}
	
	/* Entry action for state 'Joke'. */
	private void entryAction_main_Joke() {
		sCIHBrain.operationCallback.sendTTS("FUNNY JOKE HERE");
	}
	
	/* Entry action for state 'Text'. */
	private void entryAction_main_LeapMotion_LeapMotion_in_OpenChallenge_Text() {
		sCIHBrain.operationCallback.sendTTS("By the way, you can also controll me with Finger Gestures");
	}
	
	/* Entry action for state 'StartSTT'. */
	private void entryAction_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_YesNo_inner_region_StartSTT() {
		setCounter(getCounter() + 1);
		
		sCILeapMotion.operationCallback.sendGestureDetectionOnOff(3);
	}
	
	/* Entry action for state 'yes'. */
	private void entryAction_main_LeapMotion_LeapMotion_in_OpenChallenge_yes() {
		timer.setTimer(this, 8, 1 * 1000, false);
		
		sCIHBrain.operationCallback.sendTTS("Yes");
	}
	
	/* Entry action for state 'no'. */
	private void entryAction_main_LeapMotion_LeapMotion_in_OpenChallenge_no() {
		timer.setTimer(this, 9, 1 * 1000, false);
		
		sCIHBrain.operationCallback.sendTTS("No");
	}
	
	/* Entry action for state 'YESNO'. */
	private void entryAction_main_LeapMotion_LeapMotion_in_OpenChallenge_YESNO() {
		sCIHBrain.operationCallback.sendTTS("Show me the gesture for yes or no and I will tell you I you choose.");
	}
	
	/* Entry action for state 'StartSTT'. */
	private void entryAction_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight_Detect_LeftRight_StartSTT() {
		setCounter(getCounter() + 1);
		
		sCILeapMotion.operationCallback.sendGestureDetectionOnOff(3);
	}
	
	/* Entry action for state 'ByeBye'. */
	private void entryAction_main_LeapMotion_LeapMotion_in_OpenChallenge_ByeBye() {
		sCIHBrain.operationCallback.sendTTS("So this was my gesture detection.");
	}
	
	/* Entry action for state 'ByeBye'. */
	private void entryAction_main_ByeBye() {
		sCIHBrain.operationCallback.sendTTS("I will go now. Hope you enjoyed my presentation. Bye bye.");
	}
	
	/* Entry action for state 'Bumpered'. */
	private void entryAction_Leonie_Bupered_Or_Emergency_Stop_Bumpered() {
		timer.setTimer(this, 10, 3 * 1000, false);
		
		sCIHBrain.operationCallback.sendTTS("[:-(]ouch!");
	}
	
	/* Entry action for state 'resetFace'. */
	private void entryAction_Leonie_Bupered_Or_Emergency_Stop_resetFace() {
		sCIHBrain.operationCallback.sendTTS("[:-|] [blush:false]");
	}
	
	/* Entry action for state 'EmergencyStop'. */
	private void entryAction_Leonie_Bupered_Or_Emergency_Stop_EmergencyStop() {
		sCIHBrain.operationCallback.sendTTS("[blush:true] [:-O] What happend?");
	}
	
	/* Entry action for state 'checkEmergency'. */
	private void entryAction_Leonie_Bupered_Or_Emergency_Stop_checkEmergency() {
		timer.setTimer(this, 11, 3 * 1000, false);
	}
	
	/* Exit action for state 'Init'. */
	private void exitAction_main_Init() {
		timer.unsetTimer(this, 0);
	}
	
	/* Exit action for state 'wait1'. */
	private void exitAction_main_GreetingsToVisitors_inner_region_wait1() {
		timer.unsetTimer(this, 1);
	}
	
	/* Exit action for state 'wait2'. */
	private void exitAction_main_GreetingsToVisitors_inner_region_wait2() {
		timer.unsetTimer(this, 2);
	}
	
	/* Exit action for state 'wait3'. */
	private void exitAction_main_GreetingsToVisitors_inner_region_wait3() {
		timer.unsetTimer(this, 3);
	}
	
	/* Exit action for state 'wait4'. */
	private void exitAction_main_GreetingsToVisitors_inner_region_wait4() {
		timer.unsetTimer(this, 4);
	}
	
	/* Exit action for state 'Back_UTurn'. */
	private void exitAction_main_GreetingsToVisitors_inner_region_Back_UTurn() {
		timer.unsetTimer(this, 5);
	}
	
	/* Exit action for state 'ListenForCommand'. */
	private void exitAction_main_ListenForCommand() {
		timer.unsetTimer(this, 6);
	}
	
	/* Exit action for state 'ListenForCommand'. */
	private void exitAction_main_Attractiveness_openChallenge_attractiveness_ListenForCommand() {
		timer.unsetTimer(this, 7);
	}
	
	/* Exit action for state 'StartSTT'. */
	private void exitAction_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_YesNo_inner_region_StartSTT() {
		sCILeapMotion.operationCallback.sendGestureDetectionOnOff(0);
	}
	
	/* Exit action for state 'yes'. */
	private void exitAction_main_LeapMotion_LeapMotion_in_OpenChallenge_yes() {
		timer.unsetTimer(this, 8);
	}
	
	/* Exit action for state 'no'. */
	private void exitAction_main_LeapMotion_LeapMotion_in_OpenChallenge_no() {
		timer.unsetTimer(this, 9);
	}
	
	/* Exit action for state 'StartSTT'. */
	private void exitAction_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight_Detect_LeftRight_StartSTT() {
		sCILeapMotion.operationCallback.sendGestureDetectionOnOff(0);
	}
	
	/* Exit action for state 'Bumpered'. */
	private void exitAction_Leonie_Bupered_Or_Emergency_Stop_Bumpered() {
		timer.unsetTimer(this, 10);
	}
	
	/* Exit action for state 'checkEmergency'. */
	private void exitAction_Leonie_Bupered_Or_Emergency_Stop_checkEmergency() {
		timer.unsetTimer(this, 11);
	}
	
	/* 'default' enter sequence for state Init */
	private void enterSequence_main_Init_default() {
		entryAction_main_Init();
		nextStateIndex = 0;
		stateVector[0] = State.main_Init;
	}
	
	/* Default enter sequence for state null */
	private void enterSequence_main__final__default() {
		nextStateIndex = 0;
		stateVector[0] = State.main__final_;
	}
	
	/* 'default' enter sequence for state GreetingsToVisitors */
	private void enterSequence_main_GreetingsToVisitors_default() {
		enterSequence_main_GreetingsToVisitors_inner_region_default();
	}
	
	/* 'default' enter sequence for state GreetingsToVisitors */
	private void enterSequence_main_GreetingsToVisitors_inner_region_GreetingsToVisitors_default() {
		entryAction_main_GreetingsToVisitors_inner_region_GreetingsToVisitors();
		nextStateIndex = 0;
		stateVector[0] = State.main_GreetingsToVisitors_inner_region_GreetingsToVisitors;
	}
	
	/* 'default' enter sequence for state Head_Eyes */
	private void enterSequence_main_GreetingsToVisitors_inner_region_Head_Eyes_default() {
		entryAction_main_GreetingsToVisitors_inner_region_Head_Eyes();
		nextStateIndex = 0;
		stateVector[0] = State.main_GreetingsToVisitors_inner_region_Head_Eyes;
	}
	
	/* 'default' enter sequence for state wait1 */
	private void enterSequence_main_GreetingsToVisitors_inner_region_wait1_default() {
		entryAction_main_GreetingsToVisitors_inner_region_wait1();
		nextStateIndex = 0;
		stateVector[0] = State.main_GreetingsToVisitors_inner_region_wait1;
	}
	
	/* 'default' enter sequence for state Greeting1 */
	private void enterSequence_main_GreetingsToVisitors_inner_region_Greeting1_default() {
		entryAction_main_GreetingsToVisitors_inner_region_Greeting1();
		nextStateIndex = 0;
		stateVector[0] = State.main_GreetingsToVisitors_inner_region_Greeting1;
	}
	
	/* 'default' enter sequence for state wait2 */
	private void enterSequence_main_GreetingsToVisitors_inner_region_wait2_default() {
		entryAction_main_GreetingsToVisitors_inner_region_wait2();
		nextStateIndex = 0;
		stateVector[0] = State.main_GreetingsToVisitors_inner_region_wait2;
	}
	
	/* 'default' enter sequence for state greeting3 */
	private void enterSequence_main_GreetingsToVisitors_inner_region_greeting3_default() {
		entryAction_main_GreetingsToVisitors_inner_region_greeting3();
		nextStateIndex = 0;
		stateVector[0] = State.main_GreetingsToVisitors_inner_region_greeting3;
	}
	
	/* 'default' enter sequence for state wait3 */
	private void enterSequence_main_GreetingsToVisitors_inner_region_wait3_default() {
		entryAction_main_GreetingsToVisitors_inner_region_wait3();
		nextStateIndex = 0;
		stateVector[0] = State.main_GreetingsToVisitors_inner_region_wait3;
	}
	
	/* 'default' enter sequence for state greeting4 */
	private void enterSequence_main_GreetingsToVisitors_inner_region_greeting4_default() {
		entryAction_main_GreetingsToVisitors_inner_region_greeting4();
		nextStateIndex = 0;
		stateVector[0] = State.main_GreetingsToVisitors_inner_region_greeting4;
	}
	
	/* 'default' enter sequence for state wait4 */
	private void enterSequence_main_GreetingsToVisitors_inner_region_wait4_default() {
		entryAction_main_GreetingsToVisitors_inner_region_wait4();
		nextStateIndex = 0;
		stateVector[0] = State.main_GreetingsToVisitors_inner_region_wait4;
	}
	
	/* 'default' enter sequence for state LeapMotion_Handgestures */
	private void enterSequence_main_GreetingsToVisitors_inner_region_LeapMotion_Handgestures_default() {
		entryAction_main_GreetingsToVisitors_inner_region_LeapMotion_Handgestures();
		nextStateIndex = 0;
		stateVector[0] = State.main_GreetingsToVisitors_inner_region_LeapMotion_Handgestures;
	}
	
	/* 'default' enter sequence for state Back_UTurn */
	private void enterSequence_main_GreetingsToVisitors_inner_region_Back_UTurn_default() {
		entryAction_main_GreetingsToVisitors_inner_region_Back_UTurn();
		nextStateIndex = 0;
		stateVector[0] = State.main_GreetingsToVisitors_inner_region_Back_UTurn;
	}
	
	/* 'default' enter sequence for state InterruptionWave_wavingOf */
	private void enterSequence_main_GreetingsToVisitors_inner_region_InterruptionWave_wavingOf_default() {
		entryAction_main_GreetingsToVisitors_inner_region_InterruptionWave_wavingOf();
		nextStateIndex = 0;
		stateVector[0] = State.main_GreetingsToVisitors_inner_region_InterruptionWave_wavingOf;
	}
	
	/* 'default' enter sequence for state Kinect_waveOn */
	private void enterSequence_main_GreetingsToVisitors_inner_region_Kinect_waveOn_default() {
		entryAction_main_GreetingsToVisitors_inner_region_Kinect_waveOn();
		nextStateIndex = 0;
		stateVector[0] = State.main_GreetingsToVisitors_inner_region_Kinect_waveOn;
	}
	
	/* 'default' enter sequence for state GoToGWP0 */
	private void enterSequence_main_GoToGWP0_default() {
		entryAction_main_GoToGWP0();
		nextStateIndex = 0;
		stateVector[0] = State.main_GoToGWP0;
	}
	
	/* 'default' enter sequence for state GoToWavingPerson */
	private void enterSequence_main_GoToWavingPerson_default() {
		entryAction_main_GoToWavingPerson();
		nextStateIndex = 0;
		stateVector[0] = State.main_GoToWavingPerson;
	}
	
	/* 'default' enter sequence for state AskForCommand */
	private void enterSequence_main_AskForCommand_default() {
		entryAction_main_AskForCommand();
		nextStateIndex = 0;
		stateVector[0] = State.main_AskForCommand;
	}
	
	/* 'default' enter sequence for state ListenForCommand */
	private void enterSequence_main_ListenForCommand_default() {
		entryAction_main_ListenForCommand();
		nextStateIndex = 0;
		stateVector[0] = State.main_ListenForCommand;
	}
	
	/* 'default' enter sequence for state STTfinish */
	private void enterSequence_main_STTfinish_default() {
		entryAction_main_STTfinish();
		nextStateIndex = 0;
		stateVector[0] = State.main_STTfinish;
	}
	
	/* 'default' enter sequence for state ResponseToAskForAttractiveness */
	private void enterSequence_main_ResponseToAskForAttractiveness_default() {
		entryAction_main_ResponseToAskForAttractiveness();
		nextStateIndex = 0;
		stateVector[0] = State.main_ResponseToAskForAttractiveness;
	}
	
	/* 'default' enter sequence for state Attractiveness */
	private void enterSequence_main_Attractiveness_default() {
		enterSequence_main_Attractiveness_openChallenge_attractiveness_default();
	}
	
	/* 'default' enter sequence for state AskForCommand */
	private void enterSequence_main_Attractiveness_openChallenge_attractiveness_AskForCommand_default() {
		entryAction_main_Attractiveness_openChallenge_attractiveness_AskForCommand();
		nextStateIndex = 0;
		stateVector[0] = State.main_Attractiveness_openChallenge_attractiveness_AskForCommand;
	}
	
	/* 'default' enter sequence for state ListenForCommand */
	private void enterSequence_main_Attractiveness_openChallenge_attractiveness_ListenForCommand_default() {
		entryAction_main_Attractiveness_openChallenge_attractiveness_ListenForCommand();
		nextStateIndex = 0;
		stateVector[0] = State.main_Attractiveness_openChallenge_attractiveness_ListenForCommand;
	}
	
	/* 'default' enter sequence for state STTfinish */
	private void enterSequence_main_Attractiveness_openChallenge_attractiveness_STTfinish_default() {
		entryAction_main_Attractiveness_openChallenge_attractiveness_STTfinish();
		nextStateIndex = 0;
		stateVector[0] = State.main_Attractiveness_openChallenge_attractiveness_STTfinish;
	}
	
	/* 'default' enter sequence for state ResponseToAskForAttractiveness */
	private void enterSequence_main_Attractiveness_openChallenge_attractiveness_ResponseToAskForAttractiveness_default() {
		entryAction_main_Attractiveness_openChallenge_attractiveness_ResponseToAskForAttractiveness();
		nextStateIndex = 0;
		stateVector[0] = State.main_Attractiveness_openChallenge_attractiveness_ResponseToAskForAttractiveness;
	}
	
	/* 'default' enter sequence for state DetectAttractiveness */
	private void enterSequence_main_Attractiveness_openChallenge_attractiveness_DetectAttractiveness_default() {
		entryAction_main_Attractiveness_openChallenge_attractiveness_DetectAttractiveness();
		nextStateIndex = 0;
		stateVector[0] = State.main_Attractiveness_openChallenge_attractiveness_DetectAttractiveness;
	}
	
	/* 'default' enter sequence for state PleaseRepeat */
	private void enterSequence_main_PleaseRepeat_default() {
		entryAction_main_PleaseRepeat();
		nextStateIndex = 0;
		stateVector[0] = State.main_PleaseRepeat;
	}
	
	/* 'default' enter sequence for state BackToPerson1 */
	private void enterSequence_main_BackToPerson1_default() {
		entryAction_main_BackToPerson1();
		nextStateIndex = 0;
		stateVector[0] = State.main_BackToPerson1;
	}
	
	/* 'default' enter sequence for state Joke */
	private void enterSequence_main_Joke_default() {
		entryAction_main_Joke();
		nextStateIndex = 0;
		stateVector[0] = State.main_Joke;
	}
	
	/* 'default' enter sequence for state RecogniceSadness */
	private void enterSequence_main_RecogniceSadness_default() {
		nextStateIndex = 0;
		stateVector[0] = State.main_RecogniceSadness;
	}
	
	/* 'default' enter sequence for state RecogniceSmile */
	private void enterSequence_main_RecogniceSmile_default() {
		nextStateIndex = 0;
		stateVector[0] = State.main_RecogniceSmile;
	}
	
	/* 'default' enter sequence for state JokeFinished */
	private void enterSequence_main_JokeFinished_default() {
		nextStateIndex = 0;
		stateVector[0] = State.main_JokeFinished;
	}
	
	/* 'default' enter sequence for state LeapMotion */
	private void enterSequence_main_LeapMotion_default() {
		enterSequence_main_LeapMotion_LeapMotion_in_OpenChallenge_default();
	}
	
	/* 'default' enter sequence for state Text */
	private void enterSequence_main_LeapMotion_LeapMotion_in_OpenChallenge_Text_default() {
		entryAction_main_LeapMotion_LeapMotion_in_OpenChallenge_Text();
		nextStateIndex = 0;
		stateVector[0] = State.main_LeapMotion_LeapMotion_in_OpenChallenge_Text;
	}
	
	/* 'default' enter sequence for state Detect_YesNo */
	private void enterSequence_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_YesNo_default() {
		enterSequence_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_YesNo_inner_region_default();
	}
	
	/* 'default' enter sequence for state StartSTT */
	private void enterSequence_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_YesNo_inner_region_StartSTT_default() {
		entryAction_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_YesNo_inner_region_StartSTT();
		nextStateIndex = 0;
		stateVector[0] = State.main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_YesNo_inner_region_StartSTT;
	}
	
	/* 'default' enter sequence for state Copy_1_STT3 */
	private void enterSequence_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_YesNo_inner_region_Copy_1_STT3_default() {
		nextStateIndex = 0;
		stateVector[0] = State.main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_YesNo_inner_region_Copy_1_STT3;
	}
	
	/* 'default' enter sequence for state yes */
	private void enterSequence_main_LeapMotion_LeapMotion_in_OpenChallenge_yes_default() {
		entryAction_main_LeapMotion_LeapMotion_in_OpenChallenge_yes();
		nextStateIndex = 0;
		stateVector[0] = State.main_LeapMotion_LeapMotion_in_OpenChallenge_yes;
	}
	
	/* 'default' enter sequence for state no */
	private void enterSequence_main_LeapMotion_LeapMotion_in_OpenChallenge_no_default() {
		entryAction_main_LeapMotion_LeapMotion_in_OpenChallenge_no();
		nextStateIndex = 0;
		stateVector[0] = State.main_LeapMotion_LeapMotion_in_OpenChallenge_no;
	}
	
	/* 'default' enter sequence for state YESNO */
	private void enterSequence_main_LeapMotion_LeapMotion_in_OpenChallenge_YESNO_default() {
		entryAction_main_LeapMotion_LeapMotion_in_OpenChallenge_YESNO();
		nextStateIndex = 0;
		stateVector[0] = State.main_LeapMotion_LeapMotion_in_OpenChallenge_YESNO;
	}
	
	/* 'default' enter sequence for state Detect_LeftRight */
	private void enterSequence_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight_default() {
		enterSequence_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight_Detect_LeftRight_default();
	}
	
	/* 'default' enter sequence for state StartSTT */
	private void enterSequence_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight_Detect_LeftRight_StartSTT_default() {
		entryAction_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight_Detect_LeftRight_StartSTT();
		nextStateIndex = 0;
		stateVector[0] = State.main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight_Detect_LeftRight_StartSTT;
	}
	
	/* 'default' enter sequence for state Copy_1_STT3 */
	private void enterSequence_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight_Detect_LeftRight_Copy_1_STT3_default() {
		nextStateIndex = 0;
		stateVector[0] = State.main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight_Detect_LeftRight_Copy_1_STT3;
	}
	
	/* 'default' enter sequence for state Left */
	private void enterSequence_main_LeapMotion_LeapMotion_in_OpenChallenge_Left_default() {
		nextStateIndex = 0;
		stateVector[0] = State.main_LeapMotion_LeapMotion_in_OpenChallenge_Left;
	}
	
	/* 'default' enter sequence for state Right */
	private void enterSequence_main_LeapMotion_LeapMotion_in_OpenChallenge_Right_default() {
		nextStateIndex = 0;
		stateVector[0] = State.main_LeapMotion_LeapMotion_in_OpenChallenge_Right;
	}
	
	/* 'default' enter sequence for state ByeBye */
	private void enterSequence_main_LeapMotion_LeapMotion_in_OpenChallenge_ByeBye_default() {
		entryAction_main_LeapMotion_LeapMotion_in_OpenChallenge_ByeBye();
		nextStateIndex = 0;
		stateVector[0] = State.main_LeapMotion_LeapMotion_in_OpenChallenge_ByeBye;
	}
	
	/* 'default' enter sequence for state ByeBye */
	private void enterSequence_main_ByeBye_default() {
		entryAction_main_ByeBye();
		nextStateIndex = 0;
		stateVector[0] = State.main_ByeBye;
	}
	
	/* 'default' enter sequence for state waitForEvent */
	private void enterSequence_Leonie_Bupered_Or_Emergency_Stop_waitForEvent_default() {
		nextStateIndex = 1;
		stateVector[1] = State.leonie_Bupered_Or_Emergency_Stop_waitForEvent;
	}
	
	/* 'default' enter sequence for state Bumpered */
	private void enterSequence_Leonie_Bupered_Or_Emergency_Stop_Bumpered_default() {
		entryAction_Leonie_Bupered_Or_Emergency_Stop_Bumpered();
		nextStateIndex = 1;
		stateVector[1] = State.leonie_Bupered_Or_Emergency_Stop_Bumpered;
	}
	
	/* 'default' enter sequence for state resetFace */
	private void enterSequence_Leonie_Bupered_Or_Emergency_Stop_resetFace_default() {
		entryAction_Leonie_Bupered_Or_Emergency_Stop_resetFace();
		nextStateIndex = 1;
		stateVector[1] = State.leonie_Bupered_Or_Emergency_Stop_resetFace;
	}
	
	/* 'default' enter sequence for state EmergencyStop */
	private void enterSequence_Leonie_Bupered_Or_Emergency_Stop_EmergencyStop_default() {
		entryAction_Leonie_Bupered_Or_Emergency_Stop_EmergencyStop();
		nextStateIndex = 1;
		stateVector[1] = State.leonie_Bupered_Or_Emergency_Stop_EmergencyStop;
	}
	
	/* 'default' enter sequence for state checkEmergency */
	private void enterSequence_Leonie_Bupered_Or_Emergency_Stop_checkEmergency_default() {
		entryAction_Leonie_Bupered_Or_Emergency_Stop_checkEmergency();
		nextStateIndex = 1;
		stateVector[1] = State.leonie_Bupered_Or_Emergency_Stop_checkEmergency;
	}
	
	/* 'default' enter sequence for region main */
	private void enterSequence_main_default() {
		react_main__entry_Default();
	}
	
	/* 'default' enter sequence for region inner region */
	private void enterSequence_main_GreetingsToVisitors_inner_region_default() {
		react_main_GreetingsToVisitors_inner_region__entry_Default();
	}
	
	/* 'default' enter sequence for region openChallenge_attractiveness */
	private void enterSequence_main_Attractiveness_openChallenge_attractiveness_default() {
		react_main_Attractiveness_openChallenge_attractiveness__entry_Default();
	}
	
	/* 'default' enter sequence for region LeapMotion in OpenChallenge */
	private void enterSequence_main_LeapMotion_LeapMotion_in_OpenChallenge_default() {
		react_main_LeapMotion_LeapMotion_in_OpenChallenge__entry_Default();
	}
	
	/* 'default' enter sequence for region inner region */
	private void enterSequence_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_YesNo_inner_region_default() {
		react_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_YesNo_inner_region__entry_Default();
	}
	
	/* 'default' enter sequence for region Detect_LeftRight */
	private void enterSequence_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight_Detect_LeftRight_default() {
		react_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight_Detect_LeftRight__entry_Default();
	}
	
	/* 'default' enter sequence for region Leonie Bupered Or Emergency Stop */
	private void enterSequence_Leonie_Bupered_Or_Emergency_Stop_default() {
		react_Leonie_Bupered_Or_Emergency_Stop__entry_Default();
	}
	
	/* Default exit sequence for state Init */
	private void exitSequence_main_Init() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
		
		exitAction_main_Init();
	}
	
	/* Default exit sequence for final state. */
	private void exitSequence_main__final_() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state GreetingsToVisitors */
	private void exitSequence_main_GreetingsToVisitors() {
		exitSequence_main_GreetingsToVisitors_inner_region();
	}
	
	/* Default exit sequence for state GreetingsToVisitors */
	private void exitSequence_main_GreetingsToVisitors_inner_region_GreetingsToVisitors() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state Head_Eyes */
	private void exitSequence_main_GreetingsToVisitors_inner_region_Head_Eyes() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state wait1 */
	private void exitSequence_main_GreetingsToVisitors_inner_region_wait1() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
		
		exitAction_main_GreetingsToVisitors_inner_region_wait1();
	}
	
	/* Default exit sequence for state Greeting1 */
	private void exitSequence_main_GreetingsToVisitors_inner_region_Greeting1() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state wait2 */
	private void exitSequence_main_GreetingsToVisitors_inner_region_wait2() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
		
		exitAction_main_GreetingsToVisitors_inner_region_wait2();
	}
	
	/* Default exit sequence for state greeting3 */
	private void exitSequence_main_GreetingsToVisitors_inner_region_greeting3() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state wait3 */
	private void exitSequence_main_GreetingsToVisitors_inner_region_wait3() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
		
		exitAction_main_GreetingsToVisitors_inner_region_wait3();
	}
	
	/* Default exit sequence for state greeting4 */
	private void exitSequence_main_GreetingsToVisitors_inner_region_greeting4() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state wait4 */
	private void exitSequence_main_GreetingsToVisitors_inner_region_wait4() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
		
		exitAction_main_GreetingsToVisitors_inner_region_wait4();
	}
	
	/* Default exit sequence for state LeapMotion_Handgestures */
	private void exitSequence_main_GreetingsToVisitors_inner_region_LeapMotion_Handgestures() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state Back_UTurn */
	private void exitSequence_main_GreetingsToVisitors_inner_region_Back_UTurn() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
		
		exitAction_main_GreetingsToVisitors_inner_region_Back_UTurn();
	}
	
	/* Default exit sequence for state InterruptionWave_wavingOf */
	private void exitSequence_main_GreetingsToVisitors_inner_region_InterruptionWave_wavingOf() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state Kinect_waveOn */
	private void exitSequence_main_GreetingsToVisitors_inner_region_Kinect_waveOn() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state GoToGWP0 */
	private void exitSequence_main_GoToGWP0() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state GoToWavingPerson */
	private void exitSequence_main_GoToWavingPerson() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state AskForCommand */
	private void exitSequence_main_AskForCommand() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state ListenForCommand */
	private void exitSequence_main_ListenForCommand() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
		
		exitAction_main_ListenForCommand();
	}
	
	/* Default exit sequence for state STTfinish */
	private void exitSequence_main_STTfinish() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state ResponseToAskForAttractiveness */
	private void exitSequence_main_ResponseToAskForAttractiveness() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state Attractiveness */
	private void exitSequence_main_Attractiveness() {
		exitSequence_main_Attractiveness_openChallenge_attractiveness();
	}
	
	/* Default exit sequence for state AskForCommand */
	private void exitSequence_main_Attractiveness_openChallenge_attractiveness_AskForCommand() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state ListenForCommand */
	private void exitSequence_main_Attractiveness_openChallenge_attractiveness_ListenForCommand() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
		
		exitAction_main_Attractiveness_openChallenge_attractiveness_ListenForCommand();
	}
	
	/* Default exit sequence for state STTfinish */
	private void exitSequence_main_Attractiveness_openChallenge_attractiveness_STTfinish() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state ResponseToAskForAttractiveness */
	private void exitSequence_main_Attractiveness_openChallenge_attractiveness_ResponseToAskForAttractiveness() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state DetectAttractiveness */
	private void exitSequence_main_Attractiveness_openChallenge_attractiveness_DetectAttractiveness() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state PleaseRepeat */
	private void exitSequence_main_PleaseRepeat() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state BackToPerson1 */
	private void exitSequence_main_BackToPerson1() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state Joke */
	private void exitSequence_main_Joke() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state RecogniceSadness */
	private void exitSequence_main_RecogniceSadness() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state RecogniceSmile */
	private void exitSequence_main_RecogniceSmile() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state JokeFinished */
	private void exitSequence_main_JokeFinished() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state LeapMotion */
	private void exitSequence_main_LeapMotion() {
		exitSequence_main_LeapMotion_LeapMotion_in_OpenChallenge();
	}
	
	/* Default exit sequence for state Text */
	private void exitSequence_main_LeapMotion_LeapMotion_in_OpenChallenge_Text() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state Detect_YesNo */
	private void exitSequence_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_YesNo() {
		exitSequence_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_YesNo_inner_region();
	}
	
	/* Default exit sequence for state StartSTT */
	private void exitSequence_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_YesNo_inner_region_StartSTT() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
		
		exitAction_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_YesNo_inner_region_StartSTT();
	}
	
	/* Default exit sequence for state Copy_1_STT3 */
	private void exitSequence_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_YesNo_inner_region_Copy_1_STT3() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state yes */
	private void exitSequence_main_LeapMotion_LeapMotion_in_OpenChallenge_yes() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
		
		exitAction_main_LeapMotion_LeapMotion_in_OpenChallenge_yes();
	}
	
	/* Default exit sequence for state no */
	private void exitSequence_main_LeapMotion_LeapMotion_in_OpenChallenge_no() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
		
		exitAction_main_LeapMotion_LeapMotion_in_OpenChallenge_no();
	}
	
	/* Default exit sequence for state YESNO */
	private void exitSequence_main_LeapMotion_LeapMotion_in_OpenChallenge_YESNO() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state Detect_LeftRight */
	private void exitSequence_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight() {
		exitSequence_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight_Detect_LeftRight();
	}
	
	/* Default exit sequence for state StartSTT */
	private void exitSequence_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight_Detect_LeftRight_StartSTT() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
		
		exitAction_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight_Detect_LeftRight_StartSTT();
	}
	
	/* Default exit sequence for state Copy_1_STT3 */
	private void exitSequence_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight_Detect_LeftRight_Copy_1_STT3() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state Left */
	private void exitSequence_main_LeapMotion_LeapMotion_in_OpenChallenge_Left() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state Right */
	private void exitSequence_main_LeapMotion_LeapMotion_in_OpenChallenge_Right() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state ByeBye */
	private void exitSequence_main_LeapMotion_LeapMotion_in_OpenChallenge_ByeBye() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state ByeBye */
	private void exitSequence_main_ByeBye() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state waitForEvent */
	private void exitSequence_Leonie_Bupered_Or_Emergency_Stop_waitForEvent() {
		nextStateIndex = 1;
		stateVector[1] = State.$NullState$;
	}
	
	/* Default exit sequence for state Bumpered */
	private void exitSequence_Leonie_Bupered_Or_Emergency_Stop_Bumpered() {
		nextStateIndex = 1;
		stateVector[1] = State.$NullState$;
		
		exitAction_Leonie_Bupered_Or_Emergency_Stop_Bumpered();
	}
	
	/* Default exit sequence for state resetFace */
	private void exitSequence_Leonie_Bupered_Or_Emergency_Stop_resetFace() {
		nextStateIndex = 1;
		stateVector[1] = State.$NullState$;
	}
	
	/* Default exit sequence for state EmergencyStop */
	private void exitSequence_Leonie_Bupered_Or_Emergency_Stop_EmergencyStop() {
		nextStateIndex = 1;
		stateVector[1] = State.$NullState$;
	}
	
	/* Default exit sequence for state checkEmergency */
	private void exitSequence_Leonie_Bupered_Or_Emergency_Stop_checkEmergency() {
		nextStateIndex = 1;
		stateVector[1] = State.$NullState$;
		
		exitAction_Leonie_Bupered_Or_Emergency_Stop_checkEmergency();
	}
	
	/* Default exit sequence for region main */
	private void exitSequence_main() {
		switch (stateVector[0]) {
		case main_Init:
			exitSequence_main_Init();
			break;
		case main__final_:
			exitSequence_main__final_();
			break;
		case main_GreetingsToVisitors_inner_region_GreetingsToVisitors:
			exitSequence_main_GreetingsToVisitors_inner_region_GreetingsToVisitors();
			break;
		case main_GreetingsToVisitors_inner_region_Head_Eyes:
			exitSequence_main_GreetingsToVisitors_inner_region_Head_Eyes();
			break;
		case main_GreetingsToVisitors_inner_region_wait1:
			exitSequence_main_GreetingsToVisitors_inner_region_wait1();
			break;
		case main_GreetingsToVisitors_inner_region_Greeting1:
			exitSequence_main_GreetingsToVisitors_inner_region_Greeting1();
			break;
		case main_GreetingsToVisitors_inner_region_wait2:
			exitSequence_main_GreetingsToVisitors_inner_region_wait2();
			break;
		case main_GreetingsToVisitors_inner_region_greeting3:
			exitSequence_main_GreetingsToVisitors_inner_region_greeting3();
			break;
		case main_GreetingsToVisitors_inner_region_wait3:
			exitSequence_main_GreetingsToVisitors_inner_region_wait3();
			break;
		case main_GreetingsToVisitors_inner_region_greeting4:
			exitSequence_main_GreetingsToVisitors_inner_region_greeting4();
			break;
		case main_GreetingsToVisitors_inner_region_wait4:
			exitSequence_main_GreetingsToVisitors_inner_region_wait4();
			break;
		case main_GreetingsToVisitors_inner_region_LeapMotion_Handgestures:
			exitSequence_main_GreetingsToVisitors_inner_region_LeapMotion_Handgestures();
			break;
		case main_GreetingsToVisitors_inner_region_Back_UTurn:
			exitSequence_main_GreetingsToVisitors_inner_region_Back_UTurn();
			break;
		case main_GreetingsToVisitors_inner_region_InterruptionWave_wavingOf:
			exitSequence_main_GreetingsToVisitors_inner_region_InterruptionWave_wavingOf();
			break;
		case main_GreetingsToVisitors_inner_region_Kinect_waveOn:
			exitSequence_main_GreetingsToVisitors_inner_region_Kinect_waveOn();
			break;
		case main_GoToGWP0:
			exitSequence_main_GoToGWP0();
			break;
		case main_GoToWavingPerson:
			exitSequence_main_GoToWavingPerson();
			break;
		case main_AskForCommand:
			exitSequence_main_AskForCommand();
			break;
		case main_ListenForCommand:
			exitSequence_main_ListenForCommand();
			break;
		case main_STTfinish:
			exitSequence_main_STTfinish();
			break;
		case main_ResponseToAskForAttractiveness:
			exitSequence_main_ResponseToAskForAttractiveness();
			break;
		case main_Attractiveness_openChallenge_attractiveness_AskForCommand:
			exitSequence_main_Attractiveness_openChallenge_attractiveness_AskForCommand();
			break;
		case main_Attractiveness_openChallenge_attractiveness_ListenForCommand:
			exitSequence_main_Attractiveness_openChallenge_attractiveness_ListenForCommand();
			break;
		case main_Attractiveness_openChallenge_attractiveness_STTfinish:
			exitSequence_main_Attractiveness_openChallenge_attractiveness_STTfinish();
			break;
		case main_Attractiveness_openChallenge_attractiveness_ResponseToAskForAttractiveness:
			exitSequence_main_Attractiveness_openChallenge_attractiveness_ResponseToAskForAttractiveness();
			break;
		case main_Attractiveness_openChallenge_attractiveness_DetectAttractiveness:
			exitSequence_main_Attractiveness_openChallenge_attractiveness_DetectAttractiveness();
			break;
		case main_PleaseRepeat:
			exitSequence_main_PleaseRepeat();
			break;
		case main_BackToPerson1:
			exitSequence_main_BackToPerson1();
			break;
		case main_Joke:
			exitSequence_main_Joke();
			break;
		case main_RecogniceSadness:
			exitSequence_main_RecogniceSadness();
			break;
		case main_RecogniceSmile:
			exitSequence_main_RecogniceSmile();
			break;
		case main_JokeFinished:
			exitSequence_main_JokeFinished();
			break;
		case main_LeapMotion_LeapMotion_in_OpenChallenge_Text:
			exitSequence_main_LeapMotion_LeapMotion_in_OpenChallenge_Text();
			break;
		case main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_YesNo_inner_region_StartSTT:
			exitSequence_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_YesNo_inner_region_StartSTT();
			break;
		case main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_YesNo_inner_region_Copy_1_STT3:
			exitSequence_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_YesNo_inner_region_Copy_1_STT3();
			break;
		case main_LeapMotion_LeapMotion_in_OpenChallenge_yes:
			exitSequence_main_LeapMotion_LeapMotion_in_OpenChallenge_yes();
			break;
		case main_LeapMotion_LeapMotion_in_OpenChallenge_no:
			exitSequence_main_LeapMotion_LeapMotion_in_OpenChallenge_no();
			break;
		case main_LeapMotion_LeapMotion_in_OpenChallenge_YESNO:
			exitSequence_main_LeapMotion_LeapMotion_in_OpenChallenge_YESNO();
			break;
		case main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight_Detect_LeftRight_StartSTT:
			exitSequence_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight_Detect_LeftRight_StartSTT();
			break;
		case main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight_Detect_LeftRight_Copy_1_STT3:
			exitSequence_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight_Detect_LeftRight_Copy_1_STT3();
			break;
		case main_LeapMotion_LeapMotion_in_OpenChallenge_Left:
			exitSequence_main_LeapMotion_LeapMotion_in_OpenChallenge_Left();
			break;
		case main_LeapMotion_LeapMotion_in_OpenChallenge_Right:
			exitSequence_main_LeapMotion_LeapMotion_in_OpenChallenge_Right();
			break;
		case main_LeapMotion_LeapMotion_in_OpenChallenge_ByeBye:
			exitSequence_main_LeapMotion_LeapMotion_in_OpenChallenge_ByeBye();
			break;
		case main_ByeBye:
			exitSequence_main_ByeBye();
			break;
		default:
			break;
		}
	}
	
	/* Default exit sequence for region inner region */
	private void exitSequence_main_GreetingsToVisitors_inner_region() {
		switch (stateVector[0]) {
		case main_GreetingsToVisitors_inner_region_GreetingsToVisitors:
			exitSequence_main_GreetingsToVisitors_inner_region_GreetingsToVisitors();
			break;
		case main_GreetingsToVisitors_inner_region_Head_Eyes:
			exitSequence_main_GreetingsToVisitors_inner_region_Head_Eyes();
			break;
		case main_GreetingsToVisitors_inner_region_wait1:
			exitSequence_main_GreetingsToVisitors_inner_region_wait1();
			break;
		case main_GreetingsToVisitors_inner_region_Greeting1:
			exitSequence_main_GreetingsToVisitors_inner_region_Greeting1();
			break;
		case main_GreetingsToVisitors_inner_region_wait2:
			exitSequence_main_GreetingsToVisitors_inner_region_wait2();
			break;
		case main_GreetingsToVisitors_inner_region_greeting3:
			exitSequence_main_GreetingsToVisitors_inner_region_greeting3();
			break;
		case main_GreetingsToVisitors_inner_region_wait3:
			exitSequence_main_GreetingsToVisitors_inner_region_wait3();
			break;
		case main_GreetingsToVisitors_inner_region_greeting4:
			exitSequence_main_GreetingsToVisitors_inner_region_greeting4();
			break;
		case main_GreetingsToVisitors_inner_region_wait4:
			exitSequence_main_GreetingsToVisitors_inner_region_wait4();
			break;
		case main_GreetingsToVisitors_inner_region_LeapMotion_Handgestures:
			exitSequence_main_GreetingsToVisitors_inner_region_LeapMotion_Handgestures();
			break;
		case main_GreetingsToVisitors_inner_region_Back_UTurn:
			exitSequence_main_GreetingsToVisitors_inner_region_Back_UTurn();
			break;
		case main_GreetingsToVisitors_inner_region_InterruptionWave_wavingOf:
			exitSequence_main_GreetingsToVisitors_inner_region_InterruptionWave_wavingOf();
			break;
		case main_GreetingsToVisitors_inner_region_Kinect_waveOn:
			exitSequence_main_GreetingsToVisitors_inner_region_Kinect_waveOn();
			break;
		default:
			break;
		}
	}
	
	/* Default exit sequence for region openChallenge_attractiveness */
	private void exitSequence_main_Attractiveness_openChallenge_attractiveness() {
		switch (stateVector[0]) {
		case main_Attractiveness_openChallenge_attractiveness_AskForCommand:
			exitSequence_main_Attractiveness_openChallenge_attractiveness_AskForCommand();
			break;
		case main_Attractiveness_openChallenge_attractiveness_ListenForCommand:
			exitSequence_main_Attractiveness_openChallenge_attractiveness_ListenForCommand();
			break;
		case main_Attractiveness_openChallenge_attractiveness_STTfinish:
			exitSequence_main_Attractiveness_openChallenge_attractiveness_STTfinish();
			break;
		case main_Attractiveness_openChallenge_attractiveness_ResponseToAskForAttractiveness:
			exitSequence_main_Attractiveness_openChallenge_attractiveness_ResponseToAskForAttractiveness();
			break;
		case main_Attractiveness_openChallenge_attractiveness_DetectAttractiveness:
			exitSequence_main_Attractiveness_openChallenge_attractiveness_DetectAttractiveness();
			break;
		default:
			break;
		}
	}
	
	/* Default exit sequence for region LeapMotion in OpenChallenge */
	private void exitSequence_main_LeapMotion_LeapMotion_in_OpenChallenge() {
		switch (stateVector[0]) {
		case main_LeapMotion_LeapMotion_in_OpenChallenge_Text:
			exitSequence_main_LeapMotion_LeapMotion_in_OpenChallenge_Text();
			break;
		case main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_YesNo_inner_region_StartSTT:
			exitSequence_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_YesNo_inner_region_StartSTT();
			break;
		case main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_YesNo_inner_region_Copy_1_STT3:
			exitSequence_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_YesNo_inner_region_Copy_1_STT3();
			break;
		case main_LeapMotion_LeapMotion_in_OpenChallenge_yes:
			exitSequence_main_LeapMotion_LeapMotion_in_OpenChallenge_yes();
			break;
		case main_LeapMotion_LeapMotion_in_OpenChallenge_no:
			exitSequence_main_LeapMotion_LeapMotion_in_OpenChallenge_no();
			break;
		case main_LeapMotion_LeapMotion_in_OpenChallenge_YESNO:
			exitSequence_main_LeapMotion_LeapMotion_in_OpenChallenge_YESNO();
			break;
		case main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight_Detect_LeftRight_StartSTT:
			exitSequence_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight_Detect_LeftRight_StartSTT();
			break;
		case main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight_Detect_LeftRight_Copy_1_STT3:
			exitSequence_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight_Detect_LeftRight_Copy_1_STT3();
			break;
		case main_LeapMotion_LeapMotion_in_OpenChallenge_Left:
			exitSequence_main_LeapMotion_LeapMotion_in_OpenChallenge_Left();
			break;
		case main_LeapMotion_LeapMotion_in_OpenChallenge_Right:
			exitSequence_main_LeapMotion_LeapMotion_in_OpenChallenge_Right();
			break;
		case main_LeapMotion_LeapMotion_in_OpenChallenge_ByeBye:
			exitSequence_main_LeapMotion_LeapMotion_in_OpenChallenge_ByeBye();
			break;
		default:
			break;
		}
	}
	
	/* Default exit sequence for region inner region */
	private void exitSequence_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_YesNo_inner_region() {
		switch (stateVector[0]) {
		case main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_YesNo_inner_region_StartSTT:
			exitSequence_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_YesNo_inner_region_StartSTT();
			break;
		case main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_YesNo_inner_region_Copy_1_STT3:
			exitSequence_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_YesNo_inner_region_Copy_1_STT3();
			break;
		default:
			break;
		}
	}
	
	/* Default exit sequence for region Detect_LeftRight */
	private void exitSequence_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight_Detect_LeftRight() {
		switch (stateVector[0]) {
		case main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight_Detect_LeftRight_StartSTT:
			exitSequence_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight_Detect_LeftRight_StartSTT();
			break;
		case main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight_Detect_LeftRight_Copy_1_STT3:
			exitSequence_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight_Detect_LeftRight_Copy_1_STT3();
			break;
		default:
			break;
		}
	}
	
	/* Default exit sequence for region Leonie Bupered Or Emergency Stop */
	private void exitSequence_Leonie_Bupered_Or_Emergency_Stop() {
		switch (stateVector[1]) {
		case leonie_Bupered_Or_Emergency_Stop_waitForEvent:
			exitSequence_Leonie_Bupered_Or_Emergency_Stop_waitForEvent();
			break;
		case leonie_Bupered_Or_Emergency_Stop_Bumpered:
			exitSequence_Leonie_Bupered_Or_Emergency_Stop_Bumpered();
			break;
		case leonie_Bupered_Or_Emergency_Stop_resetFace:
			exitSequence_Leonie_Bupered_Or_Emergency_Stop_resetFace();
			break;
		case leonie_Bupered_Or_Emergency_Stop_EmergencyStop:
			exitSequence_Leonie_Bupered_Or_Emergency_Stop_EmergencyStop();
			break;
		case leonie_Bupered_Or_Emergency_Stop_checkEmergency:
			exitSequence_Leonie_Bupered_Or_Emergency_Stop_checkEmergency();
			break;
		default:
			break;
		}
	}
	
	/* The reactions of state Init. */
	private void react_main_Init() {
		if (check_main_Init_tr0_tr0()) {
			effect_main_Init_tr0();
		}
	}
	
	/* The reactions of state null. */
	private void react_main__final_() {
	}
	
	/* The reactions of state GreetingsToVisitors. */
	private void react_main_GreetingsToVisitors_inner_region_GreetingsToVisitors() {
		if (check_main_GreetingsToVisitors_inner_region_GreetingsToVisitors_tr0_tr0()) {
			effect_main_GreetingsToVisitors_inner_region_GreetingsToVisitors_tr0();
		}
	}
	
	/* The reactions of state Head_Eyes. */
	private void react_main_GreetingsToVisitors_inner_region_Head_Eyes() {
		if (check_main_GreetingsToVisitors_inner_region_Head_Eyes_tr0_tr0()) {
			effect_main_GreetingsToVisitors_inner_region_Head_Eyes_tr0();
		}
	}
	
	/* The reactions of state wait1. */
	private void react_main_GreetingsToVisitors_inner_region_wait1() {
		if (check_main_GreetingsToVisitors_inner_region_wait1_tr0_tr0()) {
			effect_main_GreetingsToVisitors_inner_region_wait1_tr0();
		}
	}
	
	/* The reactions of state Greeting1. */
	private void react_main_GreetingsToVisitors_inner_region_Greeting1() {
		if (check_main_GreetingsToVisitors_inner_region_Greeting1_tr0_tr0()) {
			effect_main_GreetingsToVisitors_inner_region_Greeting1_tr0();
		}
	}
	
	/* The reactions of state wait2. */
	private void react_main_GreetingsToVisitors_inner_region_wait2() {
		if (check_main_GreetingsToVisitors_inner_region_wait2_tr0_tr0()) {
			effect_main_GreetingsToVisitors_inner_region_wait2_tr0();
		}
	}
	
	/* The reactions of state greeting3. */
	private void react_main_GreetingsToVisitors_inner_region_greeting3() {
		if (check_main_GreetingsToVisitors_inner_region_greeting3_tr0_tr0()) {
			effect_main_GreetingsToVisitors_inner_region_greeting3_tr0();
		}
	}
	
	/* The reactions of state wait3. */
	private void react_main_GreetingsToVisitors_inner_region_wait3() {
		if (check_main_GreetingsToVisitors_inner_region_wait3_tr0_tr0()) {
			effect_main_GreetingsToVisitors_inner_region_wait3_tr0();
		}
	}
	
	/* The reactions of state greeting4. */
	private void react_main_GreetingsToVisitors_inner_region_greeting4() {
		if (check_main_GreetingsToVisitors_inner_region_greeting4_tr0_tr0()) {
			effect_main_GreetingsToVisitors_inner_region_greeting4_tr0();
		}
	}
	
	/* The reactions of state wait4. */
	private void react_main_GreetingsToVisitors_inner_region_wait4() {
		if (check_main_GreetingsToVisitors_inner_region_wait4_tr0_tr0()) {
			effect_main_GreetingsToVisitors_inner_region_wait4_tr0();
		}
	}
	
	/* The reactions of state LeapMotion_Handgestures. */
	private void react_main_GreetingsToVisitors_inner_region_LeapMotion_Handgestures() {
		if (check_main_GreetingsToVisitors_inner_region_LeapMotion_Handgestures_tr0_tr0()) {
			effect_main_GreetingsToVisitors_inner_region_LeapMotion_Handgestures_tr0();
		}
	}
	
	/* The reactions of state Back_UTurn. */
	private void react_main_GreetingsToVisitors_inner_region_Back_UTurn() {
		if (check_main_GreetingsToVisitors_inner_region_Back_UTurn_tr0_tr0()) {
			effect_main_GreetingsToVisitors_inner_region_Back_UTurn_tr0();
		}
	}
	
	/* The reactions of state InterruptionWave_wavingOf. */
	private void react_main_GreetingsToVisitors_inner_region_InterruptionWave_wavingOf() {
		if (check_main_GreetingsToVisitors_inner_region_InterruptionWave_wavingOf_tr0_tr0()) {
			effect_main_GreetingsToVisitors_inner_region_InterruptionWave_wavingOf_tr0();
		}
	}
	
	/* The reactions of state Kinect_waveOn. */
	private void react_main_GreetingsToVisitors_inner_region_Kinect_waveOn() {
		if (check_main_GreetingsToVisitors_inner_region_Kinect_waveOn_tr0_tr0()) {
			effect_main_GreetingsToVisitors_inner_region_Kinect_waveOn_tr0();
		}
	}
	
	/* The reactions of state GoToGWP0. */
	private void react_main_GoToGWP0() {
		if (check_main_GoToGWP0_tr0_tr0()) {
			effect_main_GoToGWP0_tr0();
		}
	}
	
	/* The reactions of state GoToWavingPerson. */
	private void react_main_GoToWavingPerson() {
		if (check_main_GoToWavingPerson_tr0_tr0()) {
			effect_main_GoToWavingPerson_tr0();
		}
	}
	
	/* The reactions of state AskForCommand. */
	private void react_main_AskForCommand() {
		if (check_main_AskForCommand_tr0_tr0()) {
			effect_main_AskForCommand_tr0();
		}
	}
	
	/* The reactions of state ListenForCommand. */
	private void react_main_ListenForCommand() {
		if (check_main_ListenForCommand_tr0_tr0()) {
			effect_main_ListenForCommand_tr0();
		}
	}
	
	/* The reactions of state STTfinish. */
	private void react_main_STTfinish() {
		if (check_main_STTfinish_tr0_tr0()) {
			effect_main_STTfinish_tr0();
		} else {
			if (check_main_STTfinish_tr1_tr1()) {
				effect_main_STTfinish_tr1();
			}
		}
	}
	
	/* The reactions of state ResponseToAskForAttractiveness. */
	private void react_main_ResponseToAskForAttractiveness() {
		effect_main_ResponseToAskForAttractiveness_tr0();
	}
	
	/* The reactions of state AskForCommand. */
	private void react_main_Attractiveness_openChallenge_attractiveness_AskForCommand() {
		if (check_main_Attractiveness_openChallenge_attractiveness_AskForCommand_tr0_tr0()) {
			effect_main_Attractiveness_openChallenge_attractiveness_AskForCommand_tr0();
		}
	}
	
	/* The reactions of state ListenForCommand. */
	private void react_main_Attractiveness_openChallenge_attractiveness_ListenForCommand() {
		if (check_main_Attractiveness_openChallenge_attractiveness_ListenForCommand_tr0_tr0()) {
			effect_main_Attractiveness_openChallenge_attractiveness_ListenForCommand_tr0();
		}
	}
	
	/* The reactions of state STTfinish. */
	private void react_main_Attractiveness_openChallenge_attractiveness_STTfinish() {
		if (check_main_Attractiveness_openChallenge_attractiveness_STTfinish_tr0_tr0()) {
			effect_main_Attractiveness_openChallenge_attractiveness_STTfinish_tr0();
		}
	}
	
	/* The reactions of state ResponseToAskForAttractiveness. */
	private void react_main_Attractiveness_openChallenge_attractiveness_ResponseToAskForAttractiveness() {
		if (check_main_Attractiveness_openChallenge_attractiveness_ResponseToAskForAttractiveness_tr0_tr0()) {
			effect_main_Attractiveness_openChallenge_attractiveness_ResponseToAskForAttractiveness_tr0();
		}
	}
	
	/* The reactions of state DetectAttractiveness. */
	private void react_main_Attractiveness_openChallenge_attractiveness_DetectAttractiveness() {
	}
	
	/* The reactions of state PleaseRepeat. */
	private void react_main_PleaseRepeat() {
		if (check_main_PleaseRepeat_tr0_tr0()) {
			effect_main_PleaseRepeat_tr0();
		}
	}
	
	/* The reactions of state BackToPerson1. */
	private void react_main_BackToPerson1() {
		if (check_main_BackToPerson1_tr0_tr0()) {
			effect_main_BackToPerson1_tr0();
		}
	}
	
	/* The reactions of state Joke. */
	private void react_main_Joke() {
		if (check_main_Joke_tr0_tr0()) {
			effect_main_Joke_tr0();
		}
	}
	
	/* The reactions of state RecogniceSadness. */
	private void react_main_RecogniceSadness() {
	}
	
	/* The reactions of state RecogniceSmile. */
	private void react_main_RecogniceSmile() {
	}
	
	/* The reactions of state JokeFinished. */
	private void react_main_JokeFinished() {
	}
	
	/* The reactions of state Text. */
	private void react_main_LeapMotion_LeapMotion_in_OpenChallenge_Text() {
		effect_main_LeapMotion_tr0();
	}
	
	/* The reactions of state StartSTT. */
	private void react_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_YesNo_inner_region_StartSTT() {
		effect_main_LeapMotion_tr0();
	}
	
	/* The reactions of state Copy_1_STT3. */
	private void react_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_YesNo_inner_region_Copy_1_STT3() {
		effect_main_LeapMotion_tr0();
	}
	
	/* The reactions of state yes. */
	private void react_main_LeapMotion_LeapMotion_in_OpenChallenge_yes() {
		effect_main_LeapMotion_tr0();
	}
	
	/* The reactions of state no. */
	private void react_main_LeapMotion_LeapMotion_in_OpenChallenge_no() {
		effect_main_LeapMotion_tr0();
	}
	
	/* The reactions of state YESNO. */
	private void react_main_LeapMotion_LeapMotion_in_OpenChallenge_YESNO() {
		effect_main_LeapMotion_tr0();
	}
	
	/* The reactions of state StartSTT. */
	private void react_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight_Detect_LeftRight_StartSTT() {
		effect_main_LeapMotion_tr0();
	}
	
	/* The reactions of state Copy_1_STT3. */
	private void react_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight_Detect_LeftRight_Copy_1_STT3() {
		effect_main_LeapMotion_tr0();
	}
	
	/* The reactions of state Left. */
	private void react_main_LeapMotion_LeapMotion_in_OpenChallenge_Left() {
		effect_main_LeapMotion_tr0();
	}
	
	/* The reactions of state Right. */
	private void react_main_LeapMotion_LeapMotion_in_OpenChallenge_Right() {
		effect_main_LeapMotion_tr0();
	}
	
	/* The reactions of state ByeBye. */
	private void react_main_LeapMotion_LeapMotion_in_OpenChallenge_ByeBye() {
		effect_main_LeapMotion_tr0();
	}
	
	/* The reactions of state ByeBye. */
	private void react_main_ByeBye() {
		if (check_main_ByeBye_tr0_tr0()) {
			effect_main_ByeBye_tr0();
		}
	}
	
	/* The reactions of state waitForEvent. */
	private void react_Leonie_Bupered_Or_Emergency_Stop_waitForEvent() {
		if (check_Leonie_Bupered_Or_Emergency_Stop_waitForEvent_tr0_tr0()) {
			effect_Leonie_Bupered_Or_Emergency_Stop_waitForEvent_tr0();
		} else {
			if (check_Leonie_Bupered_Or_Emergency_Stop_waitForEvent_tr1_tr1()) {
				effect_Leonie_Bupered_Or_Emergency_Stop_waitForEvent_tr1();
			}
		}
	}
	
	/* The reactions of state Bumpered. */
	private void react_Leonie_Bupered_Or_Emergency_Stop_Bumpered() {
		if (check_Leonie_Bupered_Or_Emergency_Stop_Bumpered_tr0_tr0()) {
			effect_Leonie_Bupered_Or_Emergency_Stop_Bumpered_tr0();
		}
	}
	
	/* The reactions of state resetFace. */
	private void react_Leonie_Bupered_Or_Emergency_Stop_resetFace() {
		effect_Leonie_Bupered_Or_Emergency_Stop_resetFace_tr0();
	}
	
	/* The reactions of state EmergencyStop. */
	private void react_Leonie_Bupered_Or_Emergency_Stop_EmergencyStop() {
		effect_Leonie_Bupered_Or_Emergency_Stop_EmergencyStop_tr0();
	}
	
	/* The reactions of state checkEmergency. */
	private void react_Leonie_Bupered_Or_Emergency_Stop_checkEmergency() {
		if (check_Leonie_Bupered_Or_Emergency_Stop_checkEmergency_tr0_tr0()) {
			effect_Leonie_Bupered_Or_Emergency_Stop_checkEmergency_tr0();
		} else {
			if (check_Leonie_Bupered_Or_Emergency_Stop_checkEmergency_tr1_tr1()) {
				effect_Leonie_Bupered_Or_Emergency_Stop_checkEmergency_tr1();
			}
		}
	}
	
	/* The reactions of state null. */
	private void react_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_YesNo_inner_region__choice_0() {
		if (check_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_YesNo_inner_region__choice_0_tr0_tr0()) {
			effect_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_YesNo_inner_region__choice_0_tr0();
		} else {
			effect_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_YesNo_inner_region__choice_0_tr1();
		}
	}
	
	/* The reactions of state null. */
	private void react_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight_Detect_LeftRight__choice_0() {
		if (check_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight_Detect_LeftRight__choice_0_tr0_tr0()) {
			effect_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight_Detect_LeftRight__choice_0_tr0();
		} else {
			effect_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight_Detect_LeftRight__choice_0_tr1();
		}
	}
	
	/* Default react sequence for initial entry  */
	private void react_main__entry_Default() {
		enterSequence_main_Init_default();
	}
	
	/* Default react sequence for initial entry  */
	private void react_main_GreetingsToVisitors_inner_region__entry_Default() {
		enterSequence_main_GreetingsToVisitors_inner_region_Greeting1_default();
	}
	
	/* Default react sequence for initial entry  */
	private void react_main_Attractiveness_openChallenge_attractiveness__entry_Default() {
		enterSequence_main_Attractiveness_openChallenge_attractiveness_AskForCommand_default();
	}
	
	/* Default react sequence for initial entry  */
	private void react_main_LeapMotion_LeapMotion_in_OpenChallenge__entry_Default() {
		enterSequence_main_LeapMotion_LeapMotion_in_OpenChallenge_Text_default();
	}
	
	/* Default react sequence for initial entry  */
	private void react_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_YesNo_inner_region__entry_Default() {
		enterSequence_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_YesNo_inner_region_StartSTT_default();
	}
	
	/* Default react sequence for initial entry  */
	private void react_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight_Detect_LeftRight__entry_Default() {
		enterSequence_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight_Detect_LeftRight_StartSTT_default();
	}
	
	/* Default react sequence for initial entry  */
	private void react_Leonie_Bupered_Or_Emergency_Stop__entry_Default() {
		enterSequence_Leonie_Bupered_Or_Emergency_Stop_waitForEvent_default();
	}
	
	/* The reactions of exit exit_GreetingsToVisitors. */
	private void react_main_GreetingsToVisitors_inner_region_exit_GreetingsToVisitors() {
		effect_main_GreetingsToVisitors_tr0();
	}
	
	/* The reactions of exit exit_attractiveness. */
	private void react_main_Attractiveness_openChallenge_attractiveness_exit_attractiveness() {
		effect_main_Attractiveness_tr0();
	}
	
	/* The reactions of exit exit_yes. */
	private void react_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_YesNo_inner_region_exit_yes() {
		effect_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_YesNo_tr1();
	}
	
	/* The reactions of exit exit_no. */
	private void react_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_YesNo_inner_region_exit_no() {
		effect_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_YesNo_tr0();
	}
	
	/* The reactions of exit exit_right. */
	private void react_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight_Detect_LeftRight_exit_right() {
		effect_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight_tr1();
	}
	
	/* The reactions of exit exit_left. */
	private void react_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight_Detect_LeftRight_exit_left() {
		effect_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight_tr0();
	}
	
	public void runCycle() {
		if (!initialized)
			throw new IllegalStateException(
					"The state machine needs to be initialized first by calling the init() function.");
		clearOutEvents();
		for (nextStateIndex = 0; nextStateIndex < stateVector.length; nextStateIndex++) {
			switch (stateVector[nextStateIndex]) {
			case main_Init:
				react_main_Init();
				break;
			case main__final_:
				react_main__final_();
				break;
			case main_GreetingsToVisitors_inner_region_GreetingsToVisitors:
				react_main_GreetingsToVisitors_inner_region_GreetingsToVisitors();
				break;
			case main_GreetingsToVisitors_inner_region_Head_Eyes:
				react_main_GreetingsToVisitors_inner_region_Head_Eyes();
				break;
			case main_GreetingsToVisitors_inner_region_wait1:
				react_main_GreetingsToVisitors_inner_region_wait1();
				break;
			case main_GreetingsToVisitors_inner_region_Greeting1:
				react_main_GreetingsToVisitors_inner_region_Greeting1();
				break;
			case main_GreetingsToVisitors_inner_region_wait2:
				react_main_GreetingsToVisitors_inner_region_wait2();
				break;
			case main_GreetingsToVisitors_inner_region_greeting3:
				react_main_GreetingsToVisitors_inner_region_greeting3();
				break;
			case main_GreetingsToVisitors_inner_region_wait3:
				react_main_GreetingsToVisitors_inner_region_wait3();
				break;
			case main_GreetingsToVisitors_inner_region_greeting4:
				react_main_GreetingsToVisitors_inner_region_greeting4();
				break;
			case main_GreetingsToVisitors_inner_region_wait4:
				react_main_GreetingsToVisitors_inner_region_wait4();
				break;
			case main_GreetingsToVisitors_inner_region_LeapMotion_Handgestures:
				react_main_GreetingsToVisitors_inner_region_LeapMotion_Handgestures();
				break;
			case main_GreetingsToVisitors_inner_region_Back_UTurn:
				react_main_GreetingsToVisitors_inner_region_Back_UTurn();
				break;
			case main_GreetingsToVisitors_inner_region_InterruptionWave_wavingOf:
				react_main_GreetingsToVisitors_inner_region_InterruptionWave_wavingOf();
				break;
			case main_GreetingsToVisitors_inner_region_Kinect_waveOn:
				react_main_GreetingsToVisitors_inner_region_Kinect_waveOn();
				break;
			case main_GoToGWP0:
				react_main_GoToGWP0();
				break;
			case main_GoToWavingPerson:
				react_main_GoToWavingPerson();
				break;
			case main_AskForCommand:
				react_main_AskForCommand();
				break;
			case main_ListenForCommand:
				react_main_ListenForCommand();
				break;
			case main_STTfinish:
				react_main_STTfinish();
				break;
			case main_ResponseToAskForAttractiveness:
				react_main_ResponseToAskForAttractiveness();
				break;
			case main_Attractiveness_openChallenge_attractiveness_AskForCommand:
				react_main_Attractiveness_openChallenge_attractiveness_AskForCommand();
				break;
			case main_Attractiveness_openChallenge_attractiveness_ListenForCommand:
				react_main_Attractiveness_openChallenge_attractiveness_ListenForCommand();
				break;
			case main_Attractiveness_openChallenge_attractiveness_STTfinish:
				react_main_Attractiveness_openChallenge_attractiveness_STTfinish();
				break;
			case main_Attractiveness_openChallenge_attractiveness_ResponseToAskForAttractiveness:
				react_main_Attractiveness_openChallenge_attractiveness_ResponseToAskForAttractiveness();
				break;
			case main_Attractiveness_openChallenge_attractiveness_DetectAttractiveness:
				react_main_Attractiveness_openChallenge_attractiveness_DetectAttractiveness();
				break;
			case main_PleaseRepeat:
				react_main_PleaseRepeat();
				break;
			case main_BackToPerson1:
				react_main_BackToPerson1();
				break;
			case main_Joke:
				react_main_Joke();
				break;
			case main_RecogniceSadness:
				react_main_RecogniceSadness();
				break;
			case main_RecogniceSmile:
				react_main_RecogniceSmile();
				break;
			case main_JokeFinished:
				react_main_JokeFinished();
				break;
			case main_LeapMotion_LeapMotion_in_OpenChallenge_Text:
				react_main_LeapMotion_LeapMotion_in_OpenChallenge_Text();
				break;
			case main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_YesNo_inner_region_StartSTT:
				react_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_YesNo_inner_region_StartSTT();
				break;
			case main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_YesNo_inner_region_Copy_1_STT3:
				react_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_YesNo_inner_region_Copy_1_STT3();
				break;
			case main_LeapMotion_LeapMotion_in_OpenChallenge_yes:
				react_main_LeapMotion_LeapMotion_in_OpenChallenge_yes();
				break;
			case main_LeapMotion_LeapMotion_in_OpenChallenge_no:
				react_main_LeapMotion_LeapMotion_in_OpenChallenge_no();
				break;
			case main_LeapMotion_LeapMotion_in_OpenChallenge_YESNO:
				react_main_LeapMotion_LeapMotion_in_OpenChallenge_YESNO();
				break;
			case main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight_Detect_LeftRight_StartSTT:
				react_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight_Detect_LeftRight_StartSTT();
				break;
			case main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight_Detect_LeftRight_Copy_1_STT3:
				react_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight_Detect_LeftRight_Copy_1_STT3();
				break;
			case main_LeapMotion_LeapMotion_in_OpenChallenge_Left:
				react_main_LeapMotion_LeapMotion_in_OpenChallenge_Left();
				break;
			case main_LeapMotion_LeapMotion_in_OpenChallenge_Right:
				react_main_LeapMotion_LeapMotion_in_OpenChallenge_Right();
				break;
			case main_LeapMotion_LeapMotion_in_OpenChallenge_ByeBye:
				react_main_LeapMotion_LeapMotion_in_OpenChallenge_ByeBye();
				break;
			case main_ByeBye:
				react_main_ByeBye();
				break;
			case leonie_Bupered_Or_Emergency_Stop_waitForEvent:
				react_Leonie_Bupered_Or_Emergency_Stop_waitForEvent();
				break;
			case leonie_Bupered_Or_Emergency_Stop_Bumpered:
				react_Leonie_Bupered_Or_Emergency_Stop_Bumpered();
				break;
			case leonie_Bupered_Or_Emergency_Stop_resetFace:
				react_Leonie_Bupered_Or_Emergency_Stop_resetFace();
				break;
			case leonie_Bupered_Or_Emergency_Stop_EmergencyStop:
				react_Leonie_Bupered_Or_Emergency_Stop_EmergencyStop();
				break;
			case leonie_Bupered_Or_Emergency_Stop_checkEmergency:
				react_Leonie_Bupered_Or_Emergency_Stop_checkEmergency();
				break;
			default:
				// $NullState$
			}
		}
		clearEvents();
	}
}
