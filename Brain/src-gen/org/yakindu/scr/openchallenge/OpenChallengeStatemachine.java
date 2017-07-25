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
	
	protected class SCIAttractivenessImpl implements SCIAttractiveness {
	
		private SCIAttractivenessOperationCallback operationCallback;
		
		public void setSCIAttractivenessOperationCallback(
				SCIAttractivenessOperationCallback operationCallback) {
			this.operationCallback = operationCallback;
		}
		private boolean attractivenessDetected;
		
		public void raiseAttractivenessDetected() {
			attractivenessDetected = true;
		}
		
		private boolean noFaceFound;
		
		public void raiseNoFaceFound() {
			noFaceFound = true;
		}
		
		private double attTemp;
		
		public double getAttTemp() {
			return attTemp;
		}
		
		public void setAttTemp(double value) {
			this.attTemp = value;
		}
		
		protected void clearEvents() {
			attractivenessDetected = false;
			noFaceFound = false;
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
		
		private boolean fail;
		
		public void raiseFail() {
			fail = true;
		}
		
		private boolean stringFinished;
		
		public void raiseStringFinished() {
			stringFinished = true;
		}
		
		protected void clearEvents() {
			gestureDetected = false;
			fail = false;
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
		
		private boolean answerReceived;
		
		public void raiseAnswerReceived() {
			answerReceived = true;
		}
		
		private boolean actionReceived;
		
		public void raiseActionReceived() {
			actionReceived = true;
		}
		
		private boolean actionsReceived;
		
		public void raiseActionsReceived() {
			actionsReceived = true;
		}
		
		protected void clearEvents() {
			spokenTextReceived = false;
			incomprehensible = false;
			answerReceived = false;
			actionReceived = false;
			actionsReceived = false;
		}
	}
	
	protected SCISTTImpl sCISTT;
	
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
		main_GreetingsToVisitors_inner_region_Kinect_waveOn,
		main_GreetingsToVisitors_inner_region_wait5,
		main_GreetingsToVisitors_inner_region_STTIntro,
		main_GreetingsToVisitors_inner_region_wait6,
		main_GreetingsToVisitors_inner_region_realPerson,
		main_waitAfterGreeting,
		main_Attractiveness,
		main_Attractiveness_openChallenge_attractiveness_DetectAttractiveness,
		main_Attractiveness_openChallenge_attractiveness_Copy_1_ResponseToAskForAttractiveness,
		main_Attractiveness_openChallenge_attractiveness_saveAttr,
		main_Attractiveness_openChallenge_attractiveness_waitForGlasses,
		main_Attractiveness_openChallenge_attractiveness_DetAt2,
		main_Attractiveness_openChallenge_attractiveness_MitBrilleHuebscher,
		main_Attractiveness_openChallenge_attractiveness_OhneBrilleHuebscher,
		main_Attractiveness_openChallenge_attractiveness_failed1,
		main_BackToPerson1,
		main_LeapMotion,
		main_LeapMotion_LeapMotion_in_OpenChallenge_Text,
		main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight,
		main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight_main_region_StartSTT,
		main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight_main_region_Left,
		main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight_main_region_Right,
		main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight_main_region_count,
		main_LeapMotion_LeapMotion_in_OpenChallenge_ByeBye,
		main_ByeBye,
		main_InterruptionWave_wavingOf,
		main_WolframAlphaTest,
		main_WolframAlphaTest_main_region_StateA,
		main_WolframAlphaTest_main_region_STT,
		main_WolframAlphaTest_main_region_STT_STT_StartSTT,
		main_WolframAlphaTest_main_region_STT_STT_TellSpokenText,
		main_WolframAlphaTest_main_region_STT_STT_StropSTT,
		main_WolframAlphaTest_main_region_TellAnswer,
		main_WolframAlphaTest_main_region_TellAction,
		main_WolframAlphaTest_main_region_TellIncomprehensible,
		main_WolframAlphaTest_main_region_StopSTT,
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
	
	private final boolean[] timeEvents = new boolean[41];
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
	
	private long outGWP;
	
	protected void setOutGWP(long value) {
		outGWP = value;
	}
	
	protected long getOutGWP() {
		return outGWP;
	}
	
	public OpenChallengeStatemachine() {
		sCIBGF = new SCIBGFImpl();
		sCIHBrain = new SCIHBrainImpl();
		sCIAttractiveness = new SCIAttractivenessImpl();
		sCIKinect2 = new SCIKinect2Impl();
		sCILeapMotion = new SCILeapMotionImpl();
		sCIMira = new SCIMiraImpl();
		sCISTT = new SCISTTImpl();
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
		
		sCIAttractiveness.setAttTemp(0.0);
		
		setCounter(0);
		
		setNameBuffer("");
		
		setQuestionCounter(0);
		
		setQuestionRepeat(0);
		
		setStartGWP(0);
		
		setOutGWP(0);
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
		sCIAttractiveness.clearEvents();
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
					main_GreetingsToVisitors.ordinal()&& stateVector[0].ordinal() <= State.main_GreetingsToVisitors_inner_region_realPerson.ordinal();
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
		case main_GreetingsToVisitors_inner_region_Kinect_waveOn:
			return stateVector[0] == State.main_GreetingsToVisitors_inner_region_Kinect_waveOn;
		case main_GreetingsToVisitors_inner_region_wait5:
			return stateVector[0] == State.main_GreetingsToVisitors_inner_region_wait5;
		case main_GreetingsToVisitors_inner_region_STTIntro:
			return stateVector[0] == State.main_GreetingsToVisitors_inner_region_STTIntro;
		case main_GreetingsToVisitors_inner_region_wait6:
			return stateVector[0] == State.main_GreetingsToVisitors_inner_region_wait6;
		case main_GreetingsToVisitors_inner_region_realPerson:
			return stateVector[0] == State.main_GreetingsToVisitors_inner_region_realPerson;
		case main_waitAfterGreeting:
			return stateVector[0] == State.main_waitAfterGreeting;
		case main_Attractiveness:
			return stateVector[0].ordinal() >= State.
					main_Attractiveness.ordinal()&& stateVector[0].ordinal() <= State.main_Attractiveness_openChallenge_attractiveness_failed1.ordinal();
		case main_Attractiveness_openChallenge_attractiveness_DetectAttractiveness:
			return stateVector[0] == State.main_Attractiveness_openChallenge_attractiveness_DetectAttractiveness;
		case main_Attractiveness_openChallenge_attractiveness_Copy_1_ResponseToAskForAttractiveness:
			return stateVector[0] == State.main_Attractiveness_openChallenge_attractiveness_Copy_1_ResponseToAskForAttractiveness;
		case main_Attractiveness_openChallenge_attractiveness_saveAttr:
			return stateVector[0] == State.main_Attractiveness_openChallenge_attractiveness_saveAttr;
		case main_Attractiveness_openChallenge_attractiveness_waitForGlasses:
			return stateVector[0] == State.main_Attractiveness_openChallenge_attractiveness_waitForGlasses;
		case main_Attractiveness_openChallenge_attractiveness_DetAt2:
			return stateVector[0] == State.main_Attractiveness_openChallenge_attractiveness_DetAt2;
		case main_Attractiveness_openChallenge_attractiveness_MitBrilleHuebscher:
			return stateVector[0] == State.main_Attractiveness_openChallenge_attractiveness_MitBrilleHuebscher;
		case main_Attractiveness_openChallenge_attractiveness_OhneBrilleHuebscher:
			return stateVector[0] == State.main_Attractiveness_openChallenge_attractiveness_OhneBrilleHuebscher;
		case main_Attractiveness_openChallenge_attractiveness_failed1:
			return stateVector[0] == State.main_Attractiveness_openChallenge_attractiveness_failed1;
		case main_BackToPerson1:
			return stateVector[0] == State.main_BackToPerson1;
		case main_LeapMotion:
			return stateVector[0].ordinal() >= State.
					main_LeapMotion.ordinal()&& stateVector[0].ordinal() <= State.main_LeapMotion_LeapMotion_in_OpenChallenge_ByeBye.ordinal();
		case main_LeapMotion_LeapMotion_in_OpenChallenge_Text:
			return stateVector[0] == State.main_LeapMotion_LeapMotion_in_OpenChallenge_Text;
		case main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight:
			return stateVector[0].ordinal() >= State.
					main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight.ordinal()&& stateVector[0].ordinal() <= State.main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight_main_region_count.ordinal();
		case main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight_main_region_StartSTT:
			return stateVector[0] == State.main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight_main_region_StartSTT;
		case main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight_main_region_Left:
			return stateVector[0] == State.main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight_main_region_Left;
		case main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight_main_region_Right:
			return stateVector[0] == State.main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight_main_region_Right;
		case main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight_main_region_count:
			return stateVector[0] == State.main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight_main_region_count;
		case main_LeapMotion_LeapMotion_in_OpenChallenge_ByeBye:
			return stateVector[0] == State.main_LeapMotion_LeapMotion_in_OpenChallenge_ByeBye;
		case main_ByeBye:
			return stateVector[0] == State.main_ByeBye;
		case main_InterruptionWave_wavingOf:
			return stateVector[0] == State.main_InterruptionWave_wavingOf;
		case main_WolframAlphaTest:
			return stateVector[0].ordinal() >= State.
					main_WolframAlphaTest.ordinal()&& stateVector[0].ordinal() <= State.main_WolframAlphaTest_main_region_StopSTT.ordinal();
		case main_WolframAlphaTest_main_region_StateA:
			return stateVector[0] == State.main_WolframAlphaTest_main_region_StateA;
		case main_WolframAlphaTest_main_region_STT:
			return stateVector[0].ordinal() >= State.
					main_WolframAlphaTest_main_region_STT.ordinal()&& stateVector[0].ordinal() <= State.main_WolframAlphaTest_main_region_STT_STT_StropSTT.ordinal();
		case main_WolframAlphaTest_main_region_STT_STT_StartSTT:
			return stateVector[0] == State.main_WolframAlphaTest_main_region_STT_STT_StartSTT;
		case main_WolframAlphaTest_main_region_STT_STT_TellSpokenText:
			return stateVector[0] == State.main_WolframAlphaTest_main_region_STT_STT_TellSpokenText;
		case main_WolframAlphaTest_main_region_STT_STT_StropSTT:
			return stateVector[0] == State.main_WolframAlphaTest_main_region_STT_STT_StropSTT;
		case main_WolframAlphaTest_main_region_TellAnswer:
			return stateVector[0] == State.main_WolframAlphaTest_main_region_TellAnswer;
		case main_WolframAlphaTest_main_region_TellAction:
			return stateVector[0] == State.main_WolframAlphaTest_main_region_TellAction;
		case main_WolframAlphaTest_main_region_TellIncomprehensible:
			return stateVector[0] == State.main_WolframAlphaTest_main_region_TellIncomprehensible;
		case main_WolframAlphaTest_main_region_StopSTT:
			return stateVector[0] == State.main_WolframAlphaTest_main_region_StopSTT;
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
	
	private boolean check_main_Init_tr0_tr0() {
		return true;
	}
	
	private boolean check_main_GreetingsToVisitors_inner_region_GreetingsToVisitors_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_main_GreetingsToVisitors_inner_region_GreetingsToVisitors_tr1_tr1() {
		return timeEvents[0];
	}
	
	private boolean check_main_GreetingsToVisitors_inner_region_Head_Eyes_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_main_GreetingsToVisitors_inner_region_Head_Eyes_tr1_tr1() {
		return timeEvents[1];
	}
	
	private boolean check_main_GreetingsToVisitors_inner_region_wait1_tr0_tr0() {
		return timeEvents[2];
	}
	
	private boolean check_main_GreetingsToVisitors_inner_region_Greeting1_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_main_GreetingsToVisitors_inner_region_Greeting1_tr1_tr1() {
		return timeEvents[3];
	}
	
	private boolean check_main_GreetingsToVisitors_inner_region_wait2_tr0_tr0() {
		return timeEvents[4];
	}
	
	private boolean check_main_GreetingsToVisitors_inner_region_greeting3_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_main_GreetingsToVisitors_inner_region_greeting3_tr1_tr1() {
		return timeEvents[5];
	}
	
	private boolean check_main_GreetingsToVisitors_inner_region_wait3_tr0_tr0() {
		return timeEvents[6];
	}
	
	private boolean check_main_GreetingsToVisitors_inner_region_greeting4_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_main_GreetingsToVisitors_inner_region_greeting4_tr1_tr1() {
		return timeEvents[7];
	}
	
	private boolean check_main_GreetingsToVisitors_inner_region_wait4_tr0_tr0() {
		return timeEvents[8];
	}
	
	private boolean check_main_GreetingsToVisitors_inner_region_LeapMotion_Handgestures_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_main_GreetingsToVisitors_inner_region_LeapMotion_Handgestures_tr1_tr1() {
		return timeEvents[9];
	}
	
	private boolean check_main_GreetingsToVisitors_inner_region_Back_UTurn_tr0_tr0() {
		return timeEvents[10];
	}
	
	private boolean check_main_GreetingsToVisitors_inner_region_Kinect_waveOn_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_main_GreetingsToVisitors_inner_region_Kinect_waveOn_tr1_tr1() {
		return timeEvents[11];
	}
	
	private boolean check_main_GreetingsToVisitors_inner_region_wait5_tr0_tr0() {
		return timeEvents[12];
	}
	
	private boolean check_main_GreetingsToVisitors_inner_region_STTIntro_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_main_GreetingsToVisitors_inner_region_STTIntro_tr1_tr1() {
		return timeEvents[13];
	}
	
	private boolean check_main_GreetingsToVisitors_inner_region_wait6_tr0_tr0() {
		return timeEvents[14];
	}
	
	private boolean check_main_GreetingsToVisitors_inner_region_realPerson_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_main_GreetingsToVisitors_inner_region_realPerson_tr1_tr1() {
		return timeEvents[15];
	}
	
	private boolean check_main_waitAfterGreeting_tr0_tr0() {
		return timeEvents[16];
	}
	
	private boolean check_main_Attractiveness_openChallenge_attractiveness_DetectAttractiveness_tr0_tr0() {
		return sCIAttractiveness.attractivenessDetected;
	}
	
	private boolean check_main_Attractiveness_openChallenge_attractiveness_DetectAttractiveness_tr1_tr1() {
		return timeEvents[17];
	}
	
	private boolean check_main_Attractiveness_openChallenge_attractiveness_Copy_1_ResponseToAskForAttractiveness_tr0_tr0() {
		return timeEvents[18];
	}
	
	private boolean check_main_Attractiveness_openChallenge_attractiveness_Copy_1_ResponseToAskForAttractiveness_tr1_tr1() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_main_Attractiveness_openChallenge_attractiveness_saveAttr_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_main_Attractiveness_openChallenge_attractiveness_saveAttr_tr1_tr1() {
		return timeEvents[19];
	}
	
	private boolean check_main_Attractiveness_openChallenge_attractiveness_waitForGlasses_tr0_tr0() {
		return timeEvents[20];
	}
	
	private boolean check_main_Attractiveness_openChallenge_attractiveness_DetAt2_tr0_tr0() {
		return sCIAttractiveness.attractivenessDetected;
	}
	
	private boolean check_main_Attractiveness_openChallenge_attractiveness_DetAt2_tr1_tr1() {
		return timeEvents[21];
	}
	
	private boolean check_main_Attractiveness_openChallenge_attractiveness_MitBrilleHuebscher_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_main_Attractiveness_openChallenge_attractiveness_MitBrilleHuebscher_tr1_tr1() {
		return timeEvents[22];
	}
	
	private boolean check_main_Attractiveness_openChallenge_attractiveness_OhneBrilleHuebscher_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_main_Attractiveness_openChallenge_attractiveness_OhneBrilleHuebscher_tr1_tr1() {
		return timeEvents[23];
	}
	
	private boolean check_main_Attractiveness_openChallenge_attractiveness_failed1_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_main_Attractiveness_openChallenge_attractiveness_failed1_tr1_tr1() {
		return timeEvents[24];
	}
	
	private boolean check_main_BackToPerson1_tr0_tr0() {
		return timeEvents[25];
	}
	
	private boolean check_main_LeapMotion_tr0_tr0() {
		return true;
	}
	
	private boolean check_main_LeapMotion_LeapMotion_in_OpenChallenge_Text_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_main_LeapMotion_LeapMotion_in_OpenChallenge_Text_tr1_tr1() {
		return timeEvents[26];
	}
	
	private boolean check_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight_main_region_StartSTT_tr0_tr0() {
		return sCILeapMotion.gestureDetected;
	}
	
	private boolean check_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight_main_region_StartSTT_tr1_tr1() {
		return timeEvents[27];
	}
	
	private boolean check_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight_main_region_Left_tr0_tr0() {
		return timeEvents[28];
	}
	
	private boolean check_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight_main_region_Right_tr0_tr0() {
		return timeEvents[29];
	}
	
	private boolean check_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight_main_region_count_tr0_tr0() {
		return true;
	}
	
	private boolean check_main_LeapMotion_LeapMotion_in_OpenChallenge_ByeBye_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_main_LeapMotion_LeapMotion_in_OpenChallenge_ByeBye_tr1_tr1() {
		return timeEvents[30];
	}
	
	private boolean check_main_ByeBye_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_main_InterruptionWave_wavingOf_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_main_InterruptionWave_wavingOf_tr1_tr1() {
		return timeEvents[31];
	}
	
	private boolean check_main_WolframAlphaTest_tr0_tr0() {
		return sCIKinect2.wavingDetected;
	}
	
	private boolean check_main_WolframAlphaTest_main_region_StateA_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_main_WolframAlphaTest_main_region_StateA_tr1_tr1() {
		return timeEvents[32];
	}
	
	private boolean check_main_WolframAlphaTest_main_region_STT_STT_StartSTT_tr0_tr0() {
		return timeEvents[33];
	}
	
	private boolean check_main_WolframAlphaTest_main_region_STT_STT_TellSpokenText_tr0_tr0() {
		return sCISTT.answerReceived;
	}
	
	private boolean check_main_WolframAlphaTest_main_region_STT_STT_TellSpokenText_tr1_tr1() {
		return sCISTT.actionReceived;
	}
	
	private boolean check_main_WolframAlphaTest_main_region_STT_STT_TellSpokenText_tr2_tr2() {
		return sCISTT.incomprehensible;
	}
	
	private boolean check_main_WolframAlphaTest_main_region_STT_STT_TellSpokenText_tr3_tr3() {
		return timeEvents[34];
	}
	
	private boolean check_main_WolframAlphaTest_main_region_STT_STT_StropSTT_tr0_tr0() {
		return sCISTT.spokenTextReceived;
	}
	
	private boolean check_main_WolframAlphaTest_main_region_STT_STT_StropSTT_tr1_tr1() {
		return timeEvents[35];
	}
	
	private boolean check_main_WolframAlphaTest_main_region_TellAnswer_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_main_WolframAlphaTest_main_region_TellAnswer_tr1_tr1() {
		return timeEvents[36];
	}
	
	private boolean check_main_WolframAlphaTest_main_region_TellAction_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_main_WolframAlphaTest_main_region_TellAction_tr1_tr1() {
		return timeEvents[37];
	}
	
	private boolean check_main_WolframAlphaTest_main_region_TellIncomprehensible_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_main_WolframAlphaTest_main_region_TellIncomprehensible_tr1_tr1() {
		return timeEvents[38];
	}
	
	private boolean check_main_WolframAlphaTest_main_region_StopSTT_tr0_tr0() {
		return true;
	}
	
	private boolean check_Leonie_Bupered_Or_Emergency_Stop_waitForEvent_tr0_tr0() {
		return sCIMira.bumpered;
	}
	
	private boolean check_Leonie_Bupered_Or_Emergency_Stop_waitForEvent_tr1_tr1() {
		return sCIMira.emergencyStop;
	}
	
	private boolean check_Leonie_Bupered_Or_Emergency_Stop_Bumpered_tr0_tr0() {
		return timeEvents[39];
	}
	
	private boolean check_Leonie_Bupered_Or_Emergency_Stop_resetFace_tr0_tr0() {
		return true;
	}
	
	private boolean check_Leonie_Bupered_Or_Emergency_Stop_EmergencyStop_tr0_tr0() {
		return true;
	}
	
	private boolean check_Leonie_Bupered_Or_Emergency_Stop_checkEmergency_tr0_tr0() {
		return timeEvents[40];
	}
	
	private boolean check_Leonie_Bupered_Or_Emergency_Stop_checkEmergency_tr1_tr1() {
		return sCIMira.emergencyStop;
	}
	
	private boolean check_main_Attractiveness_openChallenge_attractiveness__choice_0_tr0_tr0() {
		return sCIAttractiveness.getAttTemp()>sCIAttractiveness.operationCallback.getAttractiveness();
	}
	
	private boolean check_main_Attractiveness_openChallenge_attractiveness__choice_0_tr1_tr1() {
		return true;
	}
	
	private boolean check_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight_main_region__choice_0_tr0_tr0() {
		return (sCILeapMotion.operationCallback.getGesture()== null?"yes" ==null :sCILeapMotion.operationCallback.getGesture().equals("yes"));
	}
	
	private boolean check_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight_main_region__choice_0_tr1_tr1() {
		return (sCILeapMotion.operationCallback.getGesture()== null?"no" ==null :sCILeapMotion.operationCallback.getGesture().equals("no"));
	}
	
	private boolean check_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight_main_region__choice_0_tr2_tr2() {
		return true;
	}
	
	private boolean check_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight_main_region__choice_1_tr0_tr0() {
		return getCounter()<2;
	}
	
	private boolean check_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight_main_region__choice_1_tr1_tr1() {
		return true;
	}
	
	private boolean check_main_WolframAlphaTest_main_region_STT_STT__choice_0_tr1_tr1() {
		return (sCISTT.operationCallback.getSpokenText()== null?"" !=null : !sCISTT.operationCallback.getSpokenText().equals(""));
	}
	
	private boolean check_main_WolframAlphaTest_main_region_STT_STT__choice_0_tr0_tr0() {
		return true;
	}
	
	private void effect_main_Init_tr0() {
		exitSequence_main_Init();
		enterSequence_main_GreetingsToVisitors_default();
	}
	
	private void effect_main_GreetingsToVisitors_tr0() {
		exitSequence_main_GreetingsToVisitors();
		enterSequence_main_waitAfterGreeting_default();
	}
	
	private void effect_main_GreetingsToVisitors_inner_region_GreetingsToVisitors_tr0() {
		exitSequence_main_GreetingsToVisitors_inner_region_GreetingsToVisitors();
		enterSequence_main_GreetingsToVisitors_inner_region_wait1_default();
	}
	
	private void effect_main_GreetingsToVisitors_inner_region_GreetingsToVisitors_tr1() {
		exitSequence_main_GreetingsToVisitors_inner_region_GreetingsToVisitors();
		enterSequence_main_GreetingsToVisitors_inner_region_wait1_default();
	}
	
	private void effect_main_GreetingsToVisitors_inner_region_Head_Eyes_tr0() {
		exitSequence_main_GreetingsToVisitors_inner_region_Head_Eyes();
		enterSequence_main_GreetingsToVisitors_inner_region_wait2_default();
	}
	
	private void effect_main_GreetingsToVisitors_inner_region_Head_Eyes_tr1() {
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
	
	private void effect_main_GreetingsToVisitors_inner_region_Greeting1_tr1() {
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
	
	private void effect_main_GreetingsToVisitors_inner_region_greeting3_tr1() {
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
	
	private void effect_main_GreetingsToVisitors_inner_region_greeting4_tr1() {
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
	
	private void effect_main_GreetingsToVisitors_inner_region_LeapMotion_Handgestures_tr1() {
		exitSequence_main_GreetingsToVisitors_inner_region_LeapMotion_Handgestures();
		enterSequence_main_GreetingsToVisitors_inner_region_Back_UTurn_default();
	}
	
	private void effect_main_GreetingsToVisitors_inner_region_Back_UTurn_tr0() {
		exitSequence_main_GreetingsToVisitors_inner_region_Back_UTurn();
		enterSequence_main_GreetingsToVisitors_inner_region_Kinect_waveOn_default();
	}
	
	private void effect_main_GreetingsToVisitors_inner_region_Kinect_waveOn_tr0() {
		exitSequence_main_GreetingsToVisitors_inner_region_Kinect_waveOn();
		enterSequence_main_GreetingsToVisitors_inner_region_wait5_default();
	}
	
	private void effect_main_GreetingsToVisitors_inner_region_Kinect_waveOn_tr1() {
		exitSequence_main_GreetingsToVisitors_inner_region_Kinect_waveOn();
		enterSequence_main_GreetingsToVisitors_inner_region_wait5_default();
	}
	
	private void effect_main_GreetingsToVisitors_inner_region_wait5_tr0() {
		exitSequence_main_GreetingsToVisitors_inner_region_wait5();
		enterSequence_main_GreetingsToVisitors_inner_region_STTIntro_default();
	}
	
	private void effect_main_GreetingsToVisitors_inner_region_STTIntro_tr0() {
		exitSequence_main_GreetingsToVisitors_inner_region_STTIntro();
		enterSequence_main_GreetingsToVisitors_inner_region_wait6_default();
	}
	
	private void effect_main_GreetingsToVisitors_inner_region_STTIntro_tr1() {
		exitSequence_main_GreetingsToVisitors_inner_region_STTIntro();
		enterSequence_main_GreetingsToVisitors_inner_region_wait6_default();
	}
	
	private void effect_main_GreetingsToVisitors_inner_region_wait6_tr0() {
		exitSequence_main_GreetingsToVisitors_inner_region_wait6();
		enterSequence_main_GreetingsToVisitors_inner_region_realPerson_default();
	}
	
	private void effect_main_GreetingsToVisitors_inner_region_realPerson_tr0() {
		exitSequence_main_GreetingsToVisitors_inner_region_realPerson();
		react_main_GreetingsToVisitors_inner_region_exit_GreetingsToVisitors();
	}
	
	private void effect_main_GreetingsToVisitors_inner_region_realPerson_tr1() {
		exitSequence_main_GreetingsToVisitors_inner_region_realPerson();
		react_main_GreetingsToVisitors_inner_region_exit_GreetingsToVisitors();
	}
	
	private void effect_main_waitAfterGreeting_tr0() {
		exitSequence_main_waitAfterGreeting();
		enterSequence_main_WolframAlphaTest_default();
	}
	
	private void effect_main_Attractiveness_tr0() {
		exitSequence_main_Attractiveness();
		enterSequence_main_BackToPerson1_default();
	}
	
	private void effect_main_Attractiveness_openChallenge_attractiveness_DetectAttractiveness_tr0() {
		exitSequence_main_Attractiveness_openChallenge_attractiveness_DetectAttractiveness();
		enterSequence_main_Attractiveness_openChallenge_attractiveness_saveAttr_default();
	}
	
	private void effect_main_Attractiveness_openChallenge_attractiveness_DetectAttractiveness_tr1() {
		exitSequence_main_Attractiveness_openChallenge_attractiveness_DetectAttractiveness();
		enterSequence_main_Attractiveness_openChallenge_attractiveness_failed1_default();
	}
	
	private void effect_main_Attractiveness_openChallenge_attractiveness_Copy_1_ResponseToAskForAttractiveness_tr0() {
		exitSequence_main_Attractiveness_openChallenge_attractiveness_Copy_1_ResponseToAskForAttractiveness();
		enterSequence_main_Attractiveness_openChallenge_attractiveness_DetectAttractiveness_default();
	}
	
	private void effect_main_Attractiveness_openChallenge_attractiveness_Copy_1_ResponseToAskForAttractiveness_tr1() {
		exitSequence_main_Attractiveness_openChallenge_attractiveness_Copy_1_ResponseToAskForAttractiveness();
		enterSequence_main_Attractiveness_openChallenge_attractiveness_DetectAttractiveness_default();
	}
	
	private void effect_main_Attractiveness_openChallenge_attractiveness_saveAttr_tr0() {
		exitSequence_main_Attractiveness_openChallenge_attractiveness_saveAttr();
		enterSequence_main_Attractiveness_openChallenge_attractiveness_waitForGlasses_default();
	}
	
	private void effect_main_Attractiveness_openChallenge_attractiveness_saveAttr_tr1() {
		exitSequence_main_Attractiveness_openChallenge_attractiveness_saveAttr();
		enterSequence_main_Attractiveness_openChallenge_attractiveness_waitForGlasses_default();
	}
	
	private void effect_main_Attractiveness_openChallenge_attractiveness_waitForGlasses_tr0() {
		exitSequence_main_Attractiveness_openChallenge_attractiveness_waitForGlasses();
		enterSequence_main_Attractiveness_openChallenge_attractiveness_DetAt2_default();
	}
	
	private void effect_main_Attractiveness_openChallenge_attractiveness_DetAt2_tr0() {
		exitSequence_main_Attractiveness_openChallenge_attractiveness_DetAt2();
		react_main_Attractiveness_openChallenge_attractiveness__choice_0();
	}
	
	private void effect_main_Attractiveness_openChallenge_attractiveness_DetAt2_tr1() {
		exitSequence_main_Attractiveness_openChallenge_attractiveness_DetAt2();
		enterSequence_main_Attractiveness_openChallenge_attractiveness_failed1_default();
	}
	
	private void effect_main_Attractiveness_openChallenge_attractiveness_MitBrilleHuebscher_tr0() {
		exitSequence_main_Attractiveness_openChallenge_attractiveness_MitBrilleHuebscher();
		react_main_Attractiveness_openChallenge_attractiveness_exit_attractiveness();
	}
	
	private void effect_main_Attractiveness_openChallenge_attractiveness_MitBrilleHuebscher_tr1() {
		exitSequence_main_Attractiveness_openChallenge_attractiveness_MitBrilleHuebscher();
		react_main_Attractiveness_openChallenge_attractiveness_exit_attractiveness();
	}
	
	private void effect_main_Attractiveness_openChallenge_attractiveness_OhneBrilleHuebscher_tr0() {
		exitSequence_main_Attractiveness_openChallenge_attractiveness_OhneBrilleHuebscher();
		react_main_Attractiveness_openChallenge_attractiveness_exit_attractiveness();
	}
	
	private void effect_main_Attractiveness_openChallenge_attractiveness_OhneBrilleHuebscher_tr1() {
		exitSequence_main_Attractiveness_openChallenge_attractiveness_OhneBrilleHuebscher();
		react_main_Attractiveness_openChallenge_attractiveness_exit_attractiveness();
	}
	
	private void effect_main_Attractiveness_openChallenge_attractiveness_failed1_tr0() {
		exitSequence_main_Attractiveness_openChallenge_attractiveness_failed1();
		react_main_Attractiveness_openChallenge_attractiveness_exit_attractiveness();
	}
	
	private void effect_main_Attractiveness_openChallenge_attractiveness_failed1_tr1() {
		exitSequence_main_Attractiveness_openChallenge_attractiveness_failed1();
		react_main_Attractiveness_openChallenge_attractiveness_exit_attractiveness();
	}
	
	private void effect_main_BackToPerson1_tr0() {
		exitSequence_main_BackToPerson1();
		enterSequence_main_LeapMotion_default();
	}
	
	private void effect_main_LeapMotion_tr0() {
		exitSequence_main_LeapMotion();
		enterSequence_main_ByeBye_default();
	}
	
	private void effect_main_LeapMotion_LeapMotion_in_OpenChallenge_Text_tr0() {
		exitSequence_main_LeapMotion_LeapMotion_in_OpenChallenge_Text();
		enterSequence_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight_default();
	}
	
	private void effect_main_LeapMotion_LeapMotion_in_OpenChallenge_Text_tr1() {
		exitSequence_main_LeapMotion_LeapMotion_in_OpenChallenge_Text();
		enterSequence_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight_default();
	}
	
	private void effect_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight_tr0() {
		exitSequence_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight();
		enterSequence_main_LeapMotion_LeapMotion_in_OpenChallenge_ByeBye_default();
	}
	
	private void effect_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight_main_region_StartSTT_tr0() {
		exitSequence_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight_main_region_StartSTT();
		react_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight_main_region__choice_0();
	}
	
	private void effect_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight_main_region_StartSTT_tr1() {
		exitSequence_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight_main_region_StartSTT();
		react_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight_main_region_exit_end();
	}
	
	private void effect_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight_main_region_Left_tr0() {
		exitSequence_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight_main_region_Left();
		react_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight_main_region__choice_1();
	}
	
	private void effect_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight_main_region_Right_tr0() {
		exitSequence_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight_main_region_Right();
		react_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight_main_region__choice_1();
	}
	
	private void effect_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight_main_region_count_tr0() {
		exitSequence_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight_main_region_count();
		enterSequence_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight_main_region_StartSTT_default();
	}
	
	private void effect_main_LeapMotion_LeapMotion_in_OpenChallenge_ByeBye_tr0() {
		exitSequence_main_LeapMotion_LeapMotion_in_OpenChallenge_ByeBye();
	}
	
	private void effect_main_LeapMotion_LeapMotion_in_OpenChallenge_ByeBye_tr1() {
		exitSequence_main_LeapMotion_LeapMotion_in_OpenChallenge_ByeBye();
	}
	
	private void effect_main_ByeBye_tr0() {
		exitSequence_main_ByeBye();
		enterSequence_main__final__default();
	}
	
	private void effect_main_InterruptionWave_wavingOf_tr0() {
		exitSequence_main_InterruptionWave_wavingOf();
		enterSequence_main_Attractiveness_default();
	}
	
	private void effect_main_InterruptionWave_wavingOf_tr1() {
		exitSequence_main_InterruptionWave_wavingOf();
		enterSequence_main_Attractiveness_default();
	}
	
	private void effect_main_WolframAlphaTest_tr0() {
		exitSequence_main_WolframAlphaTest();
		enterSequence_main_InterruptionWave_wavingOf_default();
	}
	
	private void effect_main_WolframAlphaTest_main_region_StateA_tr0() {
		exitSequence_main_WolframAlphaTest_main_region_StateA();
		enterSequence_main_WolframAlphaTest_main_region_STT_default();
	}
	
	private void effect_main_WolframAlphaTest_main_region_StateA_tr1() {
		exitSequence_main_WolframAlphaTest_main_region_StateA();
		enterSequence_main_WolframAlphaTest_main_region_STT_default();
	}
	
	private void effect_main_WolframAlphaTest_main_region_STT_tr0() {
		exitSequence_main_WolframAlphaTest_main_region_STT();
		enterSequence_main_WolframAlphaTest_main_region_TellAnswer_default();
	}
	
	private void effect_main_WolframAlphaTest_main_region_STT_tr1() {
		exitSequence_main_WolframAlphaTest_main_region_STT();
		enterSequence_main_WolframAlphaTest_main_region_TellAction_default();
	}
	
	private void effect_main_WolframAlphaTest_main_region_STT_tr2() {
		exitSequence_main_WolframAlphaTest_main_region_STT();
		enterSequence_main_WolframAlphaTest_main_region_TellIncomprehensible_default();
	}
	
	private void effect_main_WolframAlphaTest_main_region_STT_STT_StartSTT_tr0() {
		exitSequence_main_WolframAlphaTest_main_region_STT_STT_StartSTT();
		enterSequence_main_WolframAlphaTest_main_region_STT_STT_StropSTT_default();
	}
	
	private void effect_main_WolframAlphaTest_main_region_STT_STT_TellSpokenText_tr0() {
		exitSequence_main_WolframAlphaTest_main_region_STT_STT_TellSpokenText();
		react_main_WolframAlphaTest_main_region_STT_STT_exit_answer();
	}
	
	private void effect_main_WolframAlphaTest_main_region_STT_STT_TellSpokenText_tr1() {
		exitSequence_main_WolframAlphaTest_main_region_STT_STT_TellSpokenText();
		react_main_WolframAlphaTest_main_region_STT_STT_exit_action();
	}
	
	private void effect_main_WolframAlphaTest_main_region_STT_STT_TellSpokenText_tr2() {
		exitSequence_main_WolframAlphaTest_main_region_STT_STT_TellSpokenText();
		react_main_WolframAlphaTest_main_region_STT_STT_exit_incomprehensible();
	}
	
	private void effect_main_WolframAlphaTest_main_region_STT_STT_TellSpokenText_tr3() {
		exitSequence_main_WolframAlphaTest_main_region_STT_STT_TellSpokenText();
		react_main_WolframAlphaTest_main_region_STT_STT_exit_incomprehensible();
	}
	
	private void effect_main_WolframAlphaTest_main_region_STT_STT_StropSTT_tr0() {
		exitSequence_main_WolframAlphaTest_main_region_STT_STT_StropSTT();
		react_main_WolframAlphaTest_main_region_STT_STT__choice_0();
	}
	
	private void effect_main_WolframAlphaTest_main_region_STT_STT_StropSTT_tr1() {
		exitSequence_main_WolframAlphaTest_main_region_STT_STT_StropSTT();
		react_main_WolframAlphaTest_main_region_STT_STT_exit_incomprehensible();
	}
	
	private void effect_main_WolframAlphaTest_main_region_TellAnswer_tr0() {
		exitSequence_main_WolframAlphaTest_main_region_TellAnswer();
		enterSequence_main_WolframAlphaTest_main_region_StopSTT_default();
	}
	
	private void effect_main_WolframAlphaTest_main_region_TellAnswer_tr1() {
		exitSequence_main_WolframAlphaTest_main_region_TellAnswer();
		enterSequence_main_WolframAlphaTest_main_region_StopSTT_default();
	}
	
	private void effect_main_WolframAlphaTest_main_region_TellAction_tr0() {
		exitSequence_main_WolframAlphaTest_main_region_TellAction();
		enterSequence_main_WolframAlphaTest_main_region_StopSTT_default();
	}
	
	private void effect_main_WolframAlphaTest_main_region_TellAction_tr1() {
		exitSequence_main_WolframAlphaTest_main_region_TellAction();
		enterSequence_main_WolframAlphaTest_main_region_StopSTT_default();
	}
	
	private void effect_main_WolframAlphaTest_main_region_TellIncomprehensible_tr0() {
		exitSequence_main_WolframAlphaTest_main_region_TellIncomprehensible();
		enterSequence_main_WolframAlphaTest_main_region_StopSTT_default();
	}
	
	private void effect_main_WolframAlphaTest_main_region_TellIncomprehensible_tr1() {
		exitSequence_main_WolframAlphaTest_main_region_TellIncomprehensible();
		enterSequence_main_WolframAlphaTest_main_region_StopSTT_default();
	}
	
	private void effect_main_WolframAlphaTest_main_region_StopSTT_tr0() {
		exitSequence_main_WolframAlphaTest_main_region_StopSTT();
		enterSequence_main_WolframAlphaTest_main_region_StateA_default();
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
	
	private void effect_main_Attractiveness_openChallenge_attractiveness__choice_0_tr0() {
		enterSequence_main_Attractiveness_openChallenge_attractiveness_MitBrilleHuebscher_default();
	}
	
	private void effect_main_Attractiveness_openChallenge_attractiveness__choice_0_tr1() {
		enterSequence_main_Attractiveness_openChallenge_attractiveness_OhneBrilleHuebscher_default();
	}
	
	private void effect_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight_main_region__choice_0_tr0() {
		enterSequence_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight_main_region_Left_default();
	}
	
	private void effect_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight_main_region__choice_0_tr1() {
		enterSequence_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight_main_region_Right_default();
	}
	
	private void effect_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight_main_region__choice_0_tr2() {
		enterSequence_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight_main_region_StartSTT_default();
	}
	
	private void effect_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight_main_region__choice_1_tr0() {
		enterSequence_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight_main_region_StartSTT_default();
	}
	
	private void effect_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight_main_region__choice_1_tr1() {
		react_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight_main_region_exit_end();
	}
	
	private void effect_main_WolframAlphaTest_main_region_STT_STT__choice_0_tr1() {
		enterSequence_main_WolframAlphaTest_main_region_STT_STT_TellSpokenText_default();
	}
	
	private void effect_main_WolframAlphaTest_main_region_STT_STT__choice_0_tr0() {
		react_main_WolframAlphaTest_main_region_STT_STT_exit_incomprehensible();
	}
	
	/* Entry action for state 'GreetingsToVisitors'. */
	private void entryAction_main_GreetingsToVisitors_inner_region_GreetingsToVisitors() {
		timer.setTimer(this, 0, 20 * 1000, false);
		
		sCIHBrain.operationCallback.sendTTS("Okay, I have to introduce myself. [blush:true] But i am so nervous. [:-)] I am a helpful Robot in your smart home. [blush:false] But the special thing is, that I try to interact like a real Person. Look at my breathing.");
	}
	
	/* Entry action for state 'Head_Eyes'. */
	private void entryAction_main_GreetingsToVisitors_inner_region_Head_Eyes() {
		timer.setTimer(this, 1, 30 * 1000, false);
		
		sCIHBrain.operationCallback.sendTTS("[idle3:false] Or look at my eyes{60;0} when i move my head.{0;0} At first I look at the new position. After eye movement my head follows. {-60;0} While my head is moving, my eyes go back. {Person} [idle3:true]");
	}
	
	/* Entry action for state 'wait1'. */
	private void entryAction_main_GreetingsToVisitors_inner_region_wait1() {
		timer.setTimer(this, 2, 2 * 1000, false);
	}
	
	/* Entry action for state 'Greeting1'. */
	private void entryAction_main_GreetingsToVisitors_inner_region_Greeting1() {
		timer.setTimer(this, 3, 5 * 1000, false);
		
		sCIHBrain.operationCallback.sendTTS("[:-O]wow! so many people![idle3:true]");
	}
	
	/* Entry action for state 'wait2'. */
	private void entryAction_main_GreetingsToVisitors_inner_region_wait2() {
		timer.setTimer(this, 4, 1 * 1000, false);
	}
	
	/* Entry action for state 'greeting3'. */
	private void entryAction_main_GreetingsToVisitors_inner_region_greeting3() {
		timer.setTimer(this, 5, 20 * 1000, false);
		
		sCIHBrain.operationCallback.sendTTS("[:-|]Besides my animated head I also have several sensors. On the front and the back I have laser sensors to localize myself. plan my way when moving and dynamic objects around me.");
	}
	
	/* Entry action for state 'wait3'. */
	private void entryAction_main_GreetingsToVisitors_inner_region_wait3() {
		timer.setTimer(this, 6, 1 * 1000, false);
	}
	
	/* Entry action for state 'greeting4'. */
	private void entryAction_main_GreetingsToVisitors_inner_region_greeting4() {
		timer.setTimer(this, 7, 50 * 1000, false);
		
		sCIHBrain.operationCallback.sendTTS("The most important sensor for me are my cameras. {-20;100}I have several cameras in order to see all humans around me {20;100} as well as to look very close at human faces and analyse them more precicely. {Person}[:-)]I can recognize people and analyse their faces. [:-/]{-30;-90}At least I try it. [:-]In addition I try to estimate the attractiveness and the emotion! [:-)] {Person}");
	}
	
	/* Entry action for state 'wait4'. */
	private void entryAction_main_GreetingsToVisitors_inner_region_wait4() {
		timer.setTimer(this, 8, 1 * 1000, false);
	}
	
	/* Entry action for state 'LeapMotion_Handgestures'. */
	private void entryAction_main_GreetingsToVisitors_inner_region_LeapMotion_Handgestures() {
		timer.setTimer(this, 9, 10 * 1000, false);
		
		sCIHBrain.operationCallback.sendTTS("{0;-150} In front of me is a Leap motion. {Person}This allows people to answer my questions also by giving me hand gestures.");
	}
	
	/* Entry action for state 'Back_UTurn'. */
	private void entryAction_main_GreetingsToVisitors_inner_region_Back_UTurn() {
		timer.setTimer(this, 10, 3 * 1000, false);
		
		sCIHBrain.operationCallback.sendTTS("On the back");
		
		sCIMira.operationCallback.sendBodyUTurn();
	}
	
	/* Entry action for state 'Kinect_waveOn'. */
	private void entryAction_main_GreetingsToVisitors_inner_region_Kinect_waveOn() {
		timer.setTimer(this, 11, 20 * 1000, false);
		
		sCIHBrain.operationCallback.sendTTS("{-180;100}I have a kinect that I use as my ears. I can react on loud sounds behind me.{Person} In addition, I can detect if a person is waving.");
	}
	
	/* Entry action for state 'wait5'. */
	private void entryAction_main_GreetingsToVisitors_inner_region_wait5() {
		timer.setTimer(this, 12, 1 * 1000, false);
	}
	
	/* Entry action for state 'STTIntro'. */
	private void entryAction_main_GreetingsToVisitors_inner_region_STTIntro() {
		timer.setTimer(this, 13, 30 * 1000, false);
		
		sCIMira.operationCallback.sendBodyUTurn();
		
		sCIHBrain.operationCallback.sendTTS("To understand humans I have a tough Speech to Text and Natural Language Processing System. However, if I don't know the answer of a question, I can ask web services like Wolfram Alpha.");
	}
	
	/* Entry action for state 'wait6'. */
	private void entryAction_main_GreetingsToVisitors_inner_region_wait6() {
		timer.setTimer(this, 14, 1 * 1000, false);
	}
	
	/* Entry action for state 'realPerson'. */
	private void entryAction_main_GreetingsToVisitors_inner_region_realPerson() {
		timer.setTimer(this, 15, 7 * 1000, false);
		
		sCIHBrain.operationCallback.sendTTS("Now, I want to talk with a real person.");
	}
	
	/* Entry action for state 'waitAfterGreeting'. */
	private void entryAction_main_waitAfterGreeting() {
		timer.setTimer(this, 16, 5 * 1000, false);
	}
	
	/* Entry action for state 'DetectAttractiveness'. */
	private void entryAction_main_Attractiveness_openChallenge_attractiveness_DetectAttractiveness() {
		timer.setTimer(this, 17, 20 * 1000, false);
		
		sCIAttractiveness.operationCallback.sendToAttr_estimate();
	}
	
	/* Entry action for state 'Copy_1_ResponseToAskForAttractiveness'. */
	private void entryAction_main_Attractiveness_openChallenge_attractiveness_Copy_1_ResponseToAskForAttractiveness() {
		timer.setTimer(this, 18, 30 * 1000, false);
		
		sCIHBrain.operationCallback.sendTTS("I'm also helpful to find the best look for the day. I can analyse the attractiveness of a person and I want to demonstrate this now. Please hold on till I'm finished.");
	}
	
	/* Entry action for state 'saveAttr'. */
	private void entryAction_main_Attractiveness_openChallenge_attractiveness_saveAttr() {
		timer.setTimer(this, 19, 10 * 1000, false);
		
		sCIAttractiveness.setAttTemp(sCIAttractiveness.operationCallback.getAttractiveness());
		
		sCIHBrain.operationCallback.sendTTS("I know, you are wearing glasses. Please take it off and I will chek it again.");
	}
	
	/* Entry action for state 'waitForGlasses'. */
	private void entryAction_main_Attractiveness_openChallenge_attractiveness_waitForGlasses() {
		timer.setTimer(this, 20, 3 * 1000, false);
	}
	
	/* Entry action for state 'DetAt2'. */
	private void entryAction_main_Attractiveness_openChallenge_attractiveness_DetAt2() {
		timer.setTimer(this, 21, 20 * 1000, false);
		
		sCIAttractiveness.operationCallback.sendToAttr_estimate();
	}
	
	/* Entry action for state 'MitBrilleHuebscher'. */
	private void entryAction_main_Attractiveness_openChallenge_attractiveness_MitBrilleHuebscher() {
		timer.setTimer(this, 22, 10 * 1000, false);
		
		sCIHBrain.operationCallback.sendTTS("Your glasses are very nice. Put them back on!");
	}
	
	/* Entry action for state 'OhneBrilleHuebscher'. */
	private void entryAction_main_Attractiveness_openChallenge_attractiveness_OhneBrilleHuebscher() {
		timer.setTimer(this, 23, 10 * 1000, false);
		
		sCIHBrain.operationCallback.sendTTS("Wow! you are so much more pretty without glasses!");
	}
	
	/* Entry action for state 'failed1'. */
	private void entryAction_main_Attractiveness_openChallenge_attractiveness_failed1() {
		timer.setTimer(this, 24, 15 * 1000, false);
		
		sCIHBrain.operationCallback.sendTTS("[:-(] I have problems with my attractiveness estimator. I will go on with the next show.");
	}
	
	/* Entry action for state 'BackToPerson1'. */
	private void entryAction_main_BackToPerson1() {
		timer.setTimer(this, 25, 5 * 1000, false);
		
		sCIMira.operationCallback.sendBodyUTurn();
	}
	
	/* Entry action for state 'Text'. */
	private void entryAction_main_LeapMotion_LeapMotion_in_OpenChallenge_Text() {
		timer.setTimer(this, 26, 10 * 1000, false);
		
		sCIHBrain.operationCallback.sendTTS("[:-|] By the way, you can also control me with Finger Gestures. For example you can show me, in witch direction I should turn.");
	}
	
	/* Entry action for state 'StartSTT'. */
	private void entryAction_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight_main_region_StartSTT() {
		timer.setTimer(this, 27, 15 * 1000, false);
		
		sCILeapMotion.operationCallback.sendGestureDetectionOnOff(3);
		
		setCounter(getCounter() + 1);
	}
	
	/* Entry action for state 'Left'. */
	private void entryAction_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight_main_region_Left() {
		timer.setTimer(this, 28, 1 * 1000, false);
		
		sCIMira.operationCallback.sendTurnBody(-30);
		
		sCIHBrain.operationCallback.sendTTS("Right.");
	}
	
	/* Entry action for state 'Right'. */
	private void entryAction_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight_main_region_Right() {
		timer.setTimer(this, 29, 1 * 1000, false);
		
		sCIMira.operationCallback.sendTurnBody(30);
		
		sCIHBrain.operationCallback.sendTTS("Left");
	}
	
	/* Entry action for state 'count'. */
	private void entryAction_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight_main_region_count() {
		setCounter(0);
	}
	
	/* Entry action for state 'ByeBye'. */
	private void entryAction_main_LeapMotion_LeapMotion_in_OpenChallenge_ByeBye() {
		timer.setTimer(this, 30, 10 * 1000, false);
		
		sCIHBrain.operationCallback.sendTTS("So this was my gesture detection.");
	}
	
	/* Entry action for state 'ByeBye'. */
	private void entryAction_main_ByeBye() {
		sCIHBrain.operationCallback.sendTTS("That was my small presentation. Hope you enjoyed that. Bye bye.");
	}
	
	/* Entry action for state 'InterruptionWave_wavingOf'. */
	private void entryAction_main_InterruptionWave_wavingOf() {
		timer.setTimer(this, 31, 10 * 1000, false);
		
		sCIMira.operationCallback.sendBodyUTurn();
		
		sCIHBrain.operationCallback.sendTTS("Oh there is someone waving behind me! I want to know how I could possibly help this person. [:-)]");
		
		sCIKinect2.operationCallback.sendWavingDetectionOnOff(false);
	}
	
	/* Entry action for state 'WolframAlphaTest'. */
	private void entryAction_main_WolframAlphaTest() {
		sCIKinect2.operationCallback.sendWavingDetectionOnOff(true);
	}
	
	/* Entry action for state 'StateA'. */
	private void entryAction_main_WolframAlphaTest_main_region_StateA() {
		timer.setTimer(this, 32, 5 * 1000, false);
		
		sCIHBrain.operationCallback.sendTTS("Ask me a question.");
	}
	
	/* Entry action for state 'StartSTT'. */
	private void entryAction_main_WolframAlphaTest_main_region_STT_STT_StartSTT() {
		timer.setTimer(this, 33, 5 * 1000, false);
		
		sCISTT.operationCallback.sendSpeechDetectionSmalltalk(10);
		
		sCIHBrain.operationCallback.sendTTS("[attentive]");
	}
	
	/* Entry action for state 'TellSpokenText'. */
	private void entryAction_main_WolframAlphaTest_main_region_STT_STT_TellSpokenText() {
		timer.setTimer(this, 34, 10 * 1000, false);
		
		sCIHBrain.operationCallback.sendTTS2("[:-|] I unterstood: ", sCISTT.operationCallback.getSpokenText());
	}
	
	/* Entry action for state 'StropSTT'. */
	private void entryAction_main_WolframAlphaTest_main_region_STT_STT_StropSTT() {
		timer.setTimer(this, 35, 10 * 1000, false);
		
		sCIHBrain.operationCallback.sendTTS("[:-|]");
	}
	
	/* Entry action for state 'TellAnswer'. */
	private void entryAction_main_WolframAlphaTest_main_region_TellAnswer() {
		timer.setTimer(this, 36, 20 * 1000, false);
		
		sCIHBrain.operationCallback.sendTTS(sCISTT.operationCallback.getAnswer());
	}
	
	/* Entry action for state 'TellAction'. */
	private void entryAction_main_WolframAlphaTest_main_region_TellAction() {
		timer.setTimer(this, 37, 20 * 1000, false);
		
		sCIHBrain.operationCallback.sendTTS("I think, that was a instruction to do something. Now, I just want to answer questions.");
	}
	
	/* Entry action for state 'TellIncomprehensible'. */
	private void entryAction_main_WolframAlphaTest_main_region_TellIncomprehensible() {
		timer.setTimer(this, 38, 20 * 1000, false);
		
		sCIHBrain.operationCallback.sendTTS(sCISTT.operationCallback.getAnswer());
	}
	
	/* Entry action for state 'Bumpered'. */
	private void entryAction_Leonie_Bupered_Or_Emergency_Stop_Bumpered() {
		timer.setTimer(this, 39, 3 * 1000, false);
		
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
		timer.setTimer(this, 40, 3 * 1000, false);
	}
	
	/* Exit action for state 'GreetingsToVisitors'. */
	private void exitAction_main_GreetingsToVisitors_inner_region_GreetingsToVisitors() {
		timer.unsetTimer(this, 0);
	}
	
	/* Exit action for state 'Head_Eyes'. */
	private void exitAction_main_GreetingsToVisitors_inner_region_Head_Eyes() {
		timer.unsetTimer(this, 1);
	}
	
	/* Exit action for state 'wait1'. */
	private void exitAction_main_GreetingsToVisitors_inner_region_wait1() {
		timer.unsetTimer(this, 2);
	}
	
	/* Exit action for state 'Greeting1'. */
	private void exitAction_main_GreetingsToVisitors_inner_region_Greeting1() {
		timer.unsetTimer(this, 3);
	}
	
	/* Exit action for state 'wait2'. */
	private void exitAction_main_GreetingsToVisitors_inner_region_wait2() {
		timer.unsetTimer(this, 4);
	}
	
	/* Exit action for state 'greeting3'. */
	private void exitAction_main_GreetingsToVisitors_inner_region_greeting3() {
		timer.unsetTimer(this, 5);
	}
	
	/* Exit action for state 'wait3'. */
	private void exitAction_main_GreetingsToVisitors_inner_region_wait3() {
		timer.unsetTimer(this, 6);
	}
	
	/* Exit action for state 'greeting4'. */
	private void exitAction_main_GreetingsToVisitors_inner_region_greeting4() {
		timer.unsetTimer(this, 7);
	}
	
	/* Exit action for state 'wait4'. */
	private void exitAction_main_GreetingsToVisitors_inner_region_wait4() {
		timer.unsetTimer(this, 8);
	}
	
	/* Exit action for state 'LeapMotion_Handgestures'. */
	private void exitAction_main_GreetingsToVisitors_inner_region_LeapMotion_Handgestures() {
		timer.unsetTimer(this, 9);
	}
	
	/* Exit action for state 'Back_UTurn'. */
	private void exitAction_main_GreetingsToVisitors_inner_region_Back_UTurn() {
		timer.unsetTimer(this, 10);
	}
	
	/* Exit action for state 'Kinect_waveOn'. */
	private void exitAction_main_GreetingsToVisitors_inner_region_Kinect_waveOn() {
		timer.unsetTimer(this, 11);
	}
	
	/* Exit action for state 'wait5'. */
	private void exitAction_main_GreetingsToVisitors_inner_region_wait5() {
		timer.unsetTimer(this, 12);
	}
	
	/* Exit action for state 'STTIntro'. */
	private void exitAction_main_GreetingsToVisitors_inner_region_STTIntro() {
		timer.unsetTimer(this, 13);
	}
	
	/* Exit action for state 'wait6'. */
	private void exitAction_main_GreetingsToVisitors_inner_region_wait6() {
		timer.unsetTimer(this, 14);
	}
	
	/* Exit action for state 'realPerson'. */
	private void exitAction_main_GreetingsToVisitors_inner_region_realPerson() {
		timer.unsetTimer(this, 15);
	}
	
	/* Exit action for state 'waitAfterGreeting'. */
	private void exitAction_main_waitAfterGreeting() {
		timer.unsetTimer(this, 16);
	}
	
	/* Exit action for state 'DetectAttractiveness'. */
	private void exitAction_main_Attractiveness_openChallenge_attractiveness_DetectAttractiveness() {
		timer.unsetTimer(this, 17);
	}
	
	/* Exit action for state 'Copy_1_ResponseToAskForAttractiveness'. */
	private void exitAction_main_Attractiveness_openChallenge_attractiveness_Copy_1_ResponseToAskForAttractiveness() {
		timer.unsetTimer(this, 18);
	}
	
	/* Exit action for state 'saveAttr'. */
	private void exitAction_main_Attractiveness_openChallenge_attractiveness_saveAttr() {
		timer.unsetTimer(this, 19);
	}
	
	/* Exit action for state 'waitForGlasses'. */
	private void exitAction_main_Attractiveness_openChallenge_attractiveness_waitForGlasses() {
		timer.unsetTimer(this, 20);
	}
	
	/* Exit action for state 'DetAt2'. */
	private void exitAction_main_Attractiveness_openChallenge_attractiveness_DetAt2() {
		timer.unsetTimer(this, 21);
	}
	
	/* Exit action for state 'MitBrilleHuebscher'. */
	private void exitAction_main_Attractiveness_openChallenge_attractiveness_MitBrilleHuebscher() {
		timer.unsetTimer(this, 22);
	}
	
	/* Exit action for state 'OhneBrilleHuebscher'. */
	private void exitAction_main_Attractiveness_openChallenge_attractiveness_OhneBrilleHuebscher() {
		timer.unsetTimer(this, 23);
	}
	
	/* Exit action for state 'failed1'. */
	private void exitAction_main_Attractiveness_openChallenge_attractiveness_failed1() {
		timer.unsetTimer(this, 24);
	}
	
	/* Exit action for state 'BackToPerson1'. */
	private void exitAction_main_BackToPerson1() {
		timer.unsetTimer(this, 25);
	}
	
	/* Exit action for state 'Text'. */
	private void exitAction_main_LeapMotion_LeapMotion_in_OpenChallenge_Text() {
		timer.unsetTimer(this, 26);
	}
	
	/* Exit action for state 'StartSTT'. */
	private void exitAction_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight_main_region_StartSTT() {
		timer.unsetTimer(this, 27);
		
		sCILeapMotion.operationCallback.sendGestureDetectionOnOff(0);
	}
	
	/* Exit action for state 'Left'. */
	private void exitAction_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight_main_region_Left() {
		timer.unsetTimer(this, 28);
	}
	
	/* Exit action for state 'Right'. */
	private void exitAction_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight_main_region_Right() {
		timer.unsetTimer(this, 29);
	}
	
	/* Exit action for state 'ByeBye'. */
	private void exitAction_main_LeapMotion_LeapMotion_in_OpenChallenge_ByeBye() {
		timer.unsetTimer(this, 30);
	}
	
	/* Exit action for state 'InterruptionWave_wavingOf'. */
	private void exitAction_main_InterruptionWave_wavingOf() {
		timer.unsetTimer(this, 31);
	}
	
	/* Exit action for state 'StateA'. */
	private void exitAction_main_WolframAlphaTest_main_region_StateA() {
		timer.unsetTimer(this, 32);
	}
	
	/* Exit action for state 'StartSTT'. */
	private void exitAction_main_WolframAlphaTest_main_region_STT_STT_StartSTT() {
		timer.unsetTimer(this, 33);
	}
	
	/* Exit action for state 'TellSpokenText'. */
	private void exitAction_main_WolframAlphaTest_main_region_STT_STT_TellSpokenText() {
		timer.unsetTimer(this, 34);
	}
	
	/* Exit action for state 'StropSTT'. */
	private void exitAction_main_WolframAlphaTest_main_region_STT_STT_StropSTT() {
		timer.unsetTimer(this, 35);
	}
	
	/* Exit action for state 'TellAnswer'. */
	private void exitAction_main_WolframAlphaTest_main_region_TellAnswer() {
		timer.unsetTimer(this, 36);
	}
	
	/* Exit action for state 'TellAction'. */
	private void exitAction_main_WolframAlphaTest_main_region_TellAction() {
		timer.unsetTimer(this, 37);
	}
	
	/* Exit action for state 'TellIncomprehensible'. */
	private void exitAction_main_WolframAlphaTest_main_region_TellIncomprehensible() {
		timer.unsetTimer(this, 38);
	}
	
	/* Exit action for state 'Bumpered'. */
	private void exitAction_Leonie_Bupered_Or_Emergency_Stop_Bumpered() {
		timer.unsetTimer(this, 39);
	}
	
	/* Exit action for state 'checkEmergency'. */
	private void exitAction_Leonie_Bupered_Or_Emergency_Stop_checkEmergency() {
		timer.unsetTimer(this, 40);
	}
	
	/* 'default' enter sequence for state Init */
	private void enterSequence_main_Init_default() {
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
	
	/* 'default' enter sequence for state Kinect_waveOn */
	private void enterSequence_main_GreetingsToVisitors_inner_region_Kinect_waveOn_default() {
		entryAction_main_GreetingsToVisitors_inner_region_Kinect_waveOn();
		nextStateIndex = 0;
		stateVector[0] = State.main_GreetingsToVisitors_inner_region_Kinect_waveOn;
	}
	
	/* 'default' enter sequence for state wait5 */
	private void enterSequence_main_GreetingsToVisitors_inner_region_wait5_default() {
		entryAction_main_GreetingsToVisitors_inner_region_wait5();
		nextStateIndex = 0;
		stateVector[0] = State.main_GreetingsToVisitors_inner_region_wait5;
	}
	
	/* 'default' enter sequence for state STTIntro */
	private void enterSequence_main_GreetingsToVisitors_inner_region_STTIntro_default() {
		entryAction_main_GreetingsToVisitors_inner_region_STTIntro();
		nextStateIndex = 0;
		stateVector[0] = State.main_GreetingsToVisitors_inner_region_STTIntro;
	}
	
	/* 'default' enter sequence for state wait6 */
	private void enterSequence_main_GreetingsToVisitors_inner_region_wait6_default() {
		entryAction_main_GreetingsToVisitors_inner_region_wait6();
		nextStateIndex = 0;
		stateVector[0] = State.main_GreetingsToVisitors_inner_region_wait6;
	}
	
	/* 'default' enter sequence for state realPerson */
	private void enterSequence_main_GreetingsToVisitors_inner_region_realPerson_default() {
		entryAction_main_GreetingsToVisitors_inner_region_realPerson();
		nextStateIndex = 0;
		stateVector[0] = State.main_GreetingsToVisitors_inner_region_realPerson;
	}
	
	/* 'default' enter sequence for state waitAfterGreeting */
	private void enterSequence_main_waitAfterGreeting_default() {
		entryAction_main_waitAfterGreeting();
		nextStateIndex = 0;
		stateVector[0] = State.main_waitAfterGreeting;
	}
	
	/* 'default' enter sequence for state Attractiveness */
	private void enterSequence_main_Attractiveness_default() {
		enterSequence_main_Attractiveness_openChallenge_attractiveness_default();
	}
	
	/* 'default' enter sequence for state DetectAttractiveness */
	private void enterSequence_main_Attractiveness_openChallenge_attractiveness_DetectAttractiveness_default() {
		entryAction_main_Attractiveness_openChallenge_attractiveness_DetectAttractiveness();
		nextStateIndex = 0;
		stateVector[0] = State.main_Attractiveness_openChallenge_attractiveness_DetectAttractiveness;
	}
	
	/* 'default' enter sequence for state Copy_1_ResponseToAskForAttractiveness */
	private void enterSequence_main_Attractiveness_openChallenge_attractiveness_Copy_1_ResponseToAskForAttractiveness_default() {
		entryAction_main_Attractiveness_openChallenge_attractiveness_Copy_1_ResponseToAskForAttractiveness();
		nextStateIndex = 0;
		stateVector[0] = State.main_Attractiveness_openChallenge_attractiveness_Copy_1_ResponseToAskForAttractiveness;
	}
	
	/* 'default' enter sequence for state saveAttr */
	private void enterSequence_main_Attractiveness_openChallenge_attractiveness_saveAttr_default() {
		entryAction_main_Attractiveness_openChallenge_attractiveness_saveAttr();
		nextStateIndex = 0;
		stateVector[0] = State.main_Attractiveness_openChallenge_attractiveness_saveAttr;
	}
	
	/* 'default' enter sequence for state waitForGlasses */
	private void enterSequence_main_Attractiveness_openChallenge_attractiveness_waitForGlasses_default() {
		entryAction_main_Attractiveness_openChallenge_attractiveness_waitForGlasses();
		nextStateIndex = 0;
		stateVector[0] = State.main_Attractiveness_openChallenge_attractiveness_waitForGlasses;
	}
	
	/* 'default' enter sequence for state DetAt2 */
	private void enterSequence_main_Attractiveness_openChallenge_attractiveness_DetAt2_default() {
		entryAction_main_Attractiveness_openChallenge_attractiveness_DetAt2();
		nextStateIndex = 0;
		stateVector[0] = State.main_Attractiveness_openChallenge_attractiveness_DetAt2;
	}
	
	/* 'default' enter sequence for state MitBrilleHuebscher */
	private void enterSequence_main_Attractiveness_openChallenge_attractiveness_MitBrilleHuebscher_default() {
		entryAction_main_Attractiveness_openChallenge_attractiveness_MitBrilleHuebscher();
		nextStateIndex = 0;
		stateVector[0] = State.main_Attractiveness_openChallenge_attractiveness_MitBrilleHuebscher;
	}
	
	/* 'default' enter sequence for state OhneBrilleHuebscher */
	private void enterSequence_main_Attractiveness_openChallenge_attractiveness_OhneBrilleHuebscher_default() {
		entryAction_main_Attractiveness_openChallenge_attractiveness_OhneBrilleHuebscher();
		nextStateIndex = 0;
		stateVector[0] = State.main_Attractiveness_openChallenge_attractiveness_OhneBrilleHuebscher;
	}
	
	/* 'default' enter sequence for state failed1 */
	private void enterSequence_main_Attractiveness_openChallenge_attractiveness_failed1_default() {
		entryAction_main_Attractiveness_openChallenge_attractiveness_failed1();
		nextStateIndex = 0;
		stateVector[0] = State.main_Attractiveness_openChallenge_attractiveness_failed1;
	}
	
	/* 'default' enter sequence for state BackToPerson1 */
	private void enterSequence_main_BackToPerson1_default() {
		entryAction_main_BackToPerson1();
		nextStateIndex = 0;
		stateVector[0] = State.main_BackToPerson1;
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
	
	/* 'default' enter sequence for state Detect_LeftRight */
	private void enterSequence_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight_default() {
		enterSequence_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight_main_region_default();
	}
	
	/* 'default' enter sequence for state StartSTT */
	private void enterSequence_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight_main_region_StartSTT_default() {
		entryAction_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight_main_region_StartSTT();
		nextStateIndex = 0;
		stateVector[0] = State.main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight_main_region_StartSTT;
	}
	
	/* 'default' enter sequence for state Left */
	private void enterSequence_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight_main_region_Left_default() {
		entryAction_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight_main_region_Left();
		nextStateIndex = 0;
		stateVector[0] = State.main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight_main_region_Left;
	}
	
	/* 'default' enter sequence for state Right */
	private void enterSequence_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight_main_region_Right_default() {
		entryAction_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight_main_region_Right();
		nextStateIndex = 0;
		stateVector[0] = State.main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight_main_region_Right;
	}
	
	/* 'default' enter sequence for state count */
	private void enterSequence_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight_main_region_count_default() {
		entryAction_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight_main_region_count();
		nextStateIndex = 0;
		stateVector[0] = State.main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight_main_region_count;
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
	
	/* 'default' enter sequence for state InterruptionWave_wavingOf */
	private void enterSequence_main_InterruptionWave_wavingOf_default() {
		entryAction_main_InterruptionWave_wavingOf();
		nextStateIndex = 0;
		stateVector[0] = State.main_InterruptionWave_wavingOf;
	}
	
	/* 'default' enter sequence for state WolframAlphaTest */
	private void enterSequence_main_WolframAlphaTest_default() {
		entryAction_main_WolframAlphaTest();
		enterSequence_main_WolframAlphaTest_main_region_default();
	}
	
	/* 'default' enter sequence for state StateA */
	private void enterSequence_main_WolframAlphaTest_main_region_StateA_default() {
		entryAction_main_WolframAlphaTest_main_region_StateA();
		nextStateIndex = 0;
		stateVector[0] = State.main_WolframAlphaTest_main_region_StateA;
	}
	
	/* 'default' enter sequence for state STT */
	private void enterSequence_main_WolframAlphaTest_main_region_STT_default() {
		enterSequence_main_WolframAlphaTest_main_region_STT_STT_default();
	}
	
	/* 'default' enter sequence for state StartSTT */
	private void enterSequence_main_WolframAlphaTest_main_region_STT_STT_StartSTT_default() {
		entryAction_main_WolframAlphaTest_main_region_STT_STT_StartSTT();
		nextStateIndex = 0;
		stateVector[0] = State.main_WolframAlphaTest_main_region_STT_STT_StartSTT;
	}
	
	/* 'default' enter sequence for state TellSpokenText */
	private void enterSequence_main_WolframAlphaTest_main_region_STT_STT_TellSpokenText_default() {
		entryAction_main_WolframAlphaTest_main_region_STT_STT_TellSpokenText();
		nextStateIndex = 0;
		stateVector[0] = State.main_WolframAlphaTest_main_region_STT_STT_TellSpokenText;
	}
	
	/* 'default' enter sequence for state StropSTT */
	private void enterSequence_main_WolframAlphaTest_main_region_STT_STT_StropSTT_default() {
		entryAction_main_WolframAlphaTest_main_region_STT_STT_StropSTT();
		nextStateIndex = 0;
		stateVector[0] = State.main_WolframAlphaTest_main_region_STT_STT_StropSTT;
	}
	
	/* 'default' enter sequence for state TellAnswer */
	private void enterSequence_main_WolframAlphaTest_main_region_TellAnswer_default() {
		entryAction_main_WolframAlphaTest_main_region_TellAnswer();
		nextStateIndex = 0;
		stateVector[0] = State.main_WolframAlphaTest_main_region_TellAnswer;
	}
	
	/* 'default' enter sequence for state TellAction */
	private void enterSequence_main_WolframAlphaTest_main_region_TellAction_default() {
		entryAction_main_WolframAlphaTest_main_region_TellAction();
		nextStateIndex = 0;
		stateVector[0] = State.main_WolframAlphaTest_main_region_TellAction;
	}
	
	/* 'default' enter sequence for state TellIncomprehensible */
	private void enterSequence_main_WolframAlphaTest_main_region_TellIncomprehensible_default() {
		entryAction_main_WolframAlphaTest_main_region_TellIncomprehensible();
		nextStateIndex = 0;
		stateVector[0] = State.main_WolframAlphaTest_main_region_TellIncomprehensible;
	}
	
	/* 'default' enter sequence for state StopSTT */
	private void enterSequence_main_WolframAlphaTest_main_region_StopSTT_default() {
		nextStateIndex = 0;
		stateVector[0] = State.main_WolframAlphaTest_main_region_StopSTT;
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
	
	/* 'default' enter sequence for region main region */
	private void enterSequence_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight_main_region_default() {
		react_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight_main_region__entry_Default();
	}
	
	/* 'default' enter sequence for region main region */
	private void enterSequence_main_WolframAlphaTest_main_region_default() {
		react_main_WolframAlphaTest_main_region__entry_Default();
	}
	
	/* 'default' enter sequence for region STT */
	private void enterSequence_main_WolframAlphaTest_main_region_STT_STT_default() {
		react_main_WolframAlphaTest_main_region_STT_STT__entry_Default();
	}
	
	/* 'default' enter sequence for region Leonie Bupered Or Emergency Stop */
	private void enterSequence_Leonie_Bupered_Or_Emergency_Stop_default() {
		react_Leonie_Bupered_Or_Emergency_Stop__entry_Default();
	}
	
	/* Default exit sequence for state Init */
	private void exitSequence_main_Init() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
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
		
		exitAction_main_GreetingsToVisitors_inner_region_GreetingsToVisitors();
	}
	
	/* Default exit sequence for state Head_Eyes */
	private void exitSequence_main_GreetingsToVisitors_inner_region_Head_Eyes() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
		
		exitAction_main_GreetingsToVisitors_inner_region_Head_Eyes();
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
		
		exitAction_main_GreetingsToVisitors_inner_region_Greeting1();
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
		
		exitAction_main_GreetingsToVisitors_inner_region_greeting3();
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
		
		exitAction_main_GreetingsToVisitors_inner_region_greeting4();
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
		
		exitAction_main_GreetingsToVisitors_inner_region_LeapMotion_Handgestures();
	}
	
	/* Default exit sequence for state Back_UTurn */
	private void exitSequence_main_GreetingsToVisitors_inner_region_Back_UTurn() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
		
		exitAction_main_GreetingsToVisitors_inner_region_Back_UTurn();
	}
	
	/* Default exit sequence for state Kinect_waveOn */
	private void exitSequence_main_GreetingsToVisitors_inner_region_Kinect_waveOn() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
		
		exitAction_main_GreetingsToVisitors_inner_region_Kinect_waveOn();
	}
	
	/* Default exit sequence for state wait5 */
	private void exitSequence_main_GreetingsToVisitors_inner_region_wait5() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
		
		exitAction_main_GreetingsToVisitors_inner_region_wait5();
	}
	
	/* Default exit sequence for state STTIntro */
	private void exitSequence_main_GreetingsToVisitors_inner_region_STTIntro() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
		
		exitAction_main_GreetingsToVisitors_inner_region_STTIntro();
	}
	
	/* Default exit sequence for state wait6 */
	private void exitSequence_main_GreetingsToVisitors_inner_region_wait6() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
		
		exitAction_main_GreetingsToVisitors_inner_region_wait6();
	}
	
	/* Default exit sequence for state realPerson */
	private void exitSequence_main_GreetingsToVisitors_inner_region_realPerson() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
		
		exitAction_main_GreetingsToVisitors_inner_region_realPerson();
	}
	
	/* Default exit sequence for state waitAfterGreeting */
	private void exitSequence_main_waitAfterGreeting() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
		
		exitAction_main_waitAfterGreeting();
	}
	
	/* Default exit sequence for state Attractiveness */
	private void exitSequence_main_Attractiveness() {
		exitSequence_main_Attractiveness_openChallenge_attractiveness();
	}
	
	/* Default exit sequence for state DetectAttractiveness */
	private void exitSequence_main_Attractiveness_openChallenge_attractiveness_DetectAttractiveness() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
		
		exitAction_main_Attractiveness_openChallenge_attractiveness_DetectAttractiveness();
	}
	
	/* Default exit sequence for state Copy_1_ResponseToAskForAttractiveness */
	private void exitSequence_main_Attractiveness_openChallenge_attractiveness_Copy_1_ResponseToAskForAttractiveness() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
		
		exitAction_main_Attractiveness_openChallenge_attractiveness_Copy_1_ResponseToAskForAttractiveness();
	}
	
	/* Default exit sequence for state saveAttr */
	private void exitSequence_main_Attractiveness_openChallenge_attractiveness_saveAttr() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
		
		exitAction_main_Attractiveness_openChallenge_attractiveness_saveAttr();
	}
	
	/* Default exit sequence for state waitForGlasses */
	private void exitSequence_main_Attractiveness_openChallenge_attractiveness_waitForGlasses() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
		
		exitAction_main_Attractiveness_openChallenge_attractiveness_waitForGlasses();
	}
	
	/* Default exit sequence for state DetAt2 */
	private void exitSequence_main_Attractiveness_openChallenge_attractiveness_DetAt2() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
		
		exitAction_main_Attractiveness_openChallenge_attractiveness_DetAt2();
	}
	
	/* Default exit sequence for state MitBrilleHuebscher */
	private void exitSequence_main_Attractiveness_openChallenge_attractiveness_MitBrilleHuebscher() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
		
		exitAction_main_Attractiveness_openChallenge_attractiveness_MitBrilleHuebscher();
	}
	
	/* Default exit sequence for state OhneBrilleHuebscher */
	private void exitSequence_main_Attractiveness_openChallenge_attractiveness_OhneBrilleHuebscher() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
		
		exitAction_main_Attractiveness_openChallenge_attractiveness_OhneBrilleHuebscher();
	}
	
	/* Default exit sequence for state failed1 */
	private void exitSequence_main_Attractiveness_openChallenge_attractiveness_failed1() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
		
		exitAction_main_Attractiveness_openChallenge_attractiveness_failed1();
	}
	
	/* Default exit sequence for state BackToPerson1 */
	private void exitSequence_main_BackToPerson1() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
		
		exitAction_main_BackToPerson1();
	}
	
	/* Default exit sequence for state LeapMotion */
	private void exitSequence_main_LeapMotion() {
		exitSequence_main_LeapMotion_LeapMotion_in_OpenChallenge();
	}
	
	/* Default exit sequence for state Text */
	private void exitSequence_main_LeapMotion_LeapMotion_in_OpenChallenge_Text() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
		
		exitAction_main_LeapMotion_LeapMotion_in_OpenChallenge_Text();
	}
	
	/* Default exit sequence for state Detect_LeftRight */
	private void exitSequence_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight() {
		exitSequence_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight_main_region();
	}
	
	/* Default exit sequence for state StartSTT */
	private void exitSequence_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight_main_region_StartSTT() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
		
		exitAction_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight_main_region_StartSTT();
	}
	
	/* Default exit sequence for state Left */
	private void exitSequence_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight_main_region_Left() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
		
		exitAction_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight_main_region_Left();
	}
	
	/* Default exit sequence for state Right */
	private void exitSequence_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight_main_region_Right() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
		
		exitAction_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight_main_region_Right();
	}
	
	/* Default exit sequence for state count */
	private void exitSequence_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight_main_region_count() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state ByeBye */
	private void exitSequence_main_LeapMotion_LeapMotion_in_OpenChallenge_ByeBye() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
		
		exitAction_main_LeapMotion_LeapMotion_in_OpenChallenge_ByeBye();
	}
	
	/* Default exit sequence for state ByeBye */
	private void exitSequence_main_ByeBye() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state InterruptionWave_wavingOf */
	private void exitSequence_main_InterruptionWave_wavingOf() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
		
		exitAction_main_InterruptionWave_wavingOf();
	}
	
	/* Default exit sequence for state WolframAlphaTest */
	private void exitSequence_main_WolframAlphaTest() {
		exitSequence_main_WolframAlphaTest_main_region();
	}
	
	/* Default exit sequence for state StateA */
	private void exitSequence_main_WolframAlphaTest_main_region_StateA() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
		
		exitAction_main_WolframAlphaTest_main_region_StateA();
	}
	
	/* Default exit sequence for state STT */
	private void exitSequence_main_WolframAlphaTest_main_region_STT() {
		exitSequence_main_WolframAlphaTest_main_region_STT_STT();
	}
	
	/* Default exit sequence for state StartSTT */
	private void exitSequence_main_WolframAlphaTest_main_region_STT_STT_StartSTT() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
		
		exitAction_main_WolframAlphaTest_main_region_STT_STT_StartSTT();
	}
	
	/* Default exit sequence for state TellSpokenText */
	private void exitSequence_main_WolframAlphaTest_main_region_STT_STT_TellSpokenText() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
		
		exitAction_main_WolframAlphaTest_main_region_STT_STT_TellSpokenText();
	}
	
	/* Default exit sequence for state StropSTT */
	private void exitSequence_main_WolframAlphaTest_main_region_STT_STT_StropSTT() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
		
		exitAction_main_WolframAlphaTest_main_region_STT_STT_StropSTT();
	}
	
	/* Default exit sequence for state TellAnswer */
	private void exitSequence_main_WolframAlphaTest_main_region_TellAnswer() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
		
		exitAction_main_WolframAlphaTest_main_region_TellAnswer();
	}
	
	/* Default exit sequence for state TellAction */
	private void exitSequence_main_WolframAlphaTest_main_region_TellAction() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
		
		exitAction_main_WolframAlphaTest_main_region_TellAction();
	}
	
	/* Default exit sequence for state TellIncomprehensible */
	private void exitSequence_main_WolframAlphaTest_main_region_TellIncomprehensible() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
		
		exitAction_main_WolframAlphaTest_main_region_TellIncomprehensible();
	}
	
	/* Default exit sequence for state StopSTT */
	private void exitSequence_main_WolframAlphaTest_main_region_StopSTT() {
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
		case main_GreetingsToVisitors_inner_region_Kinect_waveOn:
			exitSequence_main_GreetingsToVisitors_inner_region_Kinect_waveOn();
			break;
		case main_GreetingsToVisitors_inner_region_wait5:
			exitSequence_main_GreetingsToVisitors_inner_region_wait5();
			break;
		case main_GreetingsToVisitors_inner_region_STTIntro:
			exitSequence_main_GreetingsToVisitors_inner_region_STTIntro();
			break;
		case main_GreetingsToVisitors_inner_region_wait6:
			exitSequence_main_GreetingsToVisitors_inner_region_wait6();
			break;
		case main_GreetingsToVisitors_inner_region_realPerson:
			exitSequence_main_GreetingsToVisitors_inner_region_realPerson();
			break;
		case main_waitAfterGreeting:
			exitSequence_main_waitAfterGreeting();
			break;
		case main_Attractiveness_openChallenge_attractiveness_DetectAttractiveness:
			exitSequence_main_Attractiveness_openChallenge_attractiveness_DetectAttractiveness();
			break;
		case main_Attractiveness_openChallenge_attractiveness_Copy_1_ResponseToAskForAttractiveness:
			exitSequence_main_Attractiveness_openChallenge_attractiveness_Copy_1_ResponseToAskForAttractiveness();
			break;
		case main_Attractiveness_openChallenge_attractiveness_saveAttr:
			exitSequence_main_Attractiveness_openChallenge_attractiveness_saveAttr();
			break;
		case main_Attractiveness_openChallenge_attractiveness_waitForGlasses:
			exitSequence_main_Attractiveness_openChallenge_attractiveness_waitForGlasses();
			break;
		case main_Attractiveness_openChallenge_attractiveness_DetAt2:
			exitSequence_main_Attractiveness_openChallenge_attractiveness_DetAt2();
			break;
		case main_Attractiveness_openChallenge_attractiveness_MitBrilleHuebscher:
			exitSequence_main_Attractiveness_openChallenge_attractiveness_MitBrilleHuebscher();
			break;
		case main_Attractiveness_openChallenge_attractiveness_OhneBrilleHuebscher:
			exitSequence_main_Attractiveness_openChallenge_attractiveness_OhneBrilleHuebscher();
			break;
		case main_Attractiveness_openChallenge_attractiveness_failed1:
			exitSequence_main_Attractiveness_openChallenge_attractiveness_failed1();
			break;
		case main_BackToPerson1:
			exitSequence_main_BackToPerson1();
			break;
		case main_LeapMotion_LeapMotion_in_OpenChallenge_Text:
			exitSequence_main_LeapMotion_LeapMotion_in_OpenChallenge_Text();
			break;
		case main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight_main_region_StartSTT:
			exitSequence_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight_main_region_StartSTT();
			break;
		case main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight_main_region_Left:
			exitSequence_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight_main_region_Left();
			break;
		case main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight_main_region_Right:
			exitSequence_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight_main_region_Right();
			break;
		case main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight_main_region_count:
			exitSequence_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight_main_region_count();
			break;
		case main_LeapMotion_LeapMotion_in_OpenChallenge_ByeBye:
			exitSequence_main_LeapMotion_LeapMotion_in_OpenChallenge_ByeBye();
			break;
		case main_ByeBye:
			exitSequence_main_ByeBye();
			break;
		case main_InterruptionWave_wavingOf:
			exitSequence_main_InterruptionWave_wavingOf();
			break;
		case main_WolframAlphaTest_main_region_StateA:
			exitSequence_main_WolframAlphaTest_main_region_StateA();
			break;
		case main_WolframAlphaTest_main_region_STT_STT_StartSTT:
			exitSequence_main_WolframAlphaTest_main_region_STT_STT_StartSTT();
			break;
		case main_WolframAlphaTest_main_region_STT_STT_TellSpokenText:
			exitSequence_main_WolframAlphaTest_main_region_STT_STT_TellSpokenText();
			break;
		case main_WolframAlphaTest_main_region_STT_STT_StropSTT:
			exitSequence_main_WolframAlphaTest_main_region_STT_STT_StropSTT();
			break;
		case main_WolframAlphaTest_main_region_TellAnswer:
			exitSequence_main_WolframAlphaTest_main_region_TellAnswer();
			break;
		case main_WolframAlphaTest_main_region_TellAction:
			exitSequence_main_WolframAlphaTest_main_region_TellAction();
			break;
		case main_WolframAlphaTest_main_region_TellIncomprehensible:
			exitSequence_main_WolframAlphaTest_main_region_TellIncomprehensible();
			break;
		case main_WolframAlphaTest_main_region_StopSTT:
			exitSequence_main_WolframAlphaTest_main_region_StopSTT();
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
		case main_GreetingsToVisitors_inner_region_Kinect_waveOn:
			exitSequence_main_GreetingsToVisitors_inner_region_Kinect_waveOn();
			break;
		case main_GreetingsToVisitors_inner_region_wait5:
			exitSequence_main_GreetingsToVisitors_inner_region_wait5();
			break;
		case main_GreetingsToVisitors_inner_region_STTIntro:
			exitSequence_main_GreetingsToVisitors_inner_region_STTIntro();
			break;
		case main_GreetingsToVisitors_inner_region_wait6:
			exitSequence_main_GreetingsToVisitors_inner_region_wait6();
			break;
		case main_GreetingsToVisitors_inner_region_realPerson:
			exitSequence_main_GreetingsToVisitors_inner_region_realPerson();
			break;
		default:
			break;
		}
	}
	
	/* Default exit sequence for region openChallenge_attractiveness */
	private void exitSequence_main_Attractiveness_openChallenge_attractiveness() {
		switch (stateVector[0]) {
		case main_Attractiveness_openChallenge_attractiveness_DetectAttractiveness:
			exitSequence_main_Attractiveness_openChallenge_attractiveness_DetectAttractiveness();
			break;
		case main_Attractiveness_openChallenge_attractiveness_Copy_1_ResponseToAskForAttractiveness:
			exitSequence_main_Attractiveness_openChallenge_attractiveness_Copy_1_ResponseToAskForAttractiveness();
			break;
		case main_Attractiveness_openChallenge_attractiveness_saveAttr:
			exitSequence_main_Attractiveness_openChallenge_attractiveness_saveAttr();
			break;
		case main_Attractiveness_openChallenge_attractiveness_waitForGlasses:
			exitSequence_main_Attractiveness_openChallenge_attractiveness_waitForGlasses();
			break;
		case main_Attractiveness_openChallenge_attractiveness_DetAt2:
			exitSequence_main_Attractiveness_openChallenge_attractiveness_DetAt2();
			break;
		case main_Attractiveness_openChallenge_attractiveness_MitBrilleHuebscher:
			exitSequence_main_Attractiveness_openChallenge_attractiveness_MitBrilleHuebscher();
			break;
		case main_Attractiveness_openChallenge_attractiveness_OhneBrilleHuebscher:
			exitSequence_main_Attractiveness_openChallenge_attractiveness_OhneBrilleHuebscher();
			break;
		case main_Attractiveness_openChallenge_attractiveness_failed1:
			exitSequence_main_Attractiveness_openChallenge_attractiveness_failed1();
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
		case main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight_main_region_StartSTT:
			exitSequence_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight_main_region_StartSTT();
			break;
		case main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight_main_region_Left:
			exitSequence_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight_main_region_Left();
			break;
		case main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight_main_region_Right:
			exitSequence_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight_main_region_Right();
			break;
		case main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight_main_region_count:
			exitSequence_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight_main_region_count();
			break;
		case main_LeapMotion_LeapMotion_in_OpenChallenge_ByeBye:
			exitSequence_main_LeapMotion_LeapMotion_in_OpenChallenge_ByeBye();
			break;
		default:
			break;
		}
	}
	
	/* Default exit sequence for region main region */
	private void exitSequence_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight_main_region() {
		switch (stateVector[0]) {
		case main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight_main_region_StartSTT:
			exitSequence_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight_main_region_StartSTT();
			break;
		case main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight_main_region_Left:
			exitSequence_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight_main_region_Left();
			break;
		case main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight_main_region_Right:
			exitSequence_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight_main_region_Right();
			break;
		case main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight_main_region_count:
			exitSequence_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight_main_region_count();
			break;
		default:
			break;
		}
	}
	
	/* Default exit sequence for region main region */
	private void exitSequence_main_WolframAlphaTest_main_region() {
		switch (stateVector[0]) {
		case main_WolframAlphaTest_main_region_StateA:
			exitSequence_main_WolframAlphaTest_main_region_StateA();
			break;
		case main_WolframAlphaTest_main_region_STT_STT_StartSTT:
			exitSequence_main_WolframAlphaTest_main_region_STT_STT_StartSTT();
			break;
		case main_WolframAlphaTest_main_region_STT_STT_TellSpokenText:
			exitSequence_main_WolframAlphaTest_main_region_STT_STT_TellSpokenText();
			break;
		case main_WolframAlphaTest_main_region_STT_STT_StropSTT:
			exitSequence_main_WolframAlphaTest_main_region_STT_STT_StropSTT();
			break;
		case main_WolframAlphaTest_main_region_TellAnswer:
			exitSequence_main_WolframAlphaTest_main_region_TellAnswer();
			break;
		case main_WolframAlphaTest_main_region_TellAction:
			exitSequence_main_WolframAlphaTest_main_region_TellAction();
			break;
		case main_WolframAlphaTest_main_region_TellIncomprehensible:
			exitSequence_main_WolframAlphaTest_main_region_TellIncomprehensible();
			break;
		case main_WolframAlphaTest_main_region_StopSTT:
			exitSequence_main_WolframAlphaTest_main_region_StopSTT();
			break;
		default:
			break;
		}
	}
	
	/* Default exit sequence for region STT */
	private void exitSequence_main_WolframAlphaTest_main_region_STT_STT() {
		switch (stateVector[0]) {
		case main_WolframAlphaTest_main_region_STT_STT_StartSTT:
			exitSequence_main_WolframAlphaTest_main_region_STT_STT_StartSTT();
			break;
		case main_WolframAlphaTest_main_region_STT_STT_TellSpokenText:
			exitSequence_main_WolframAlphaTest_main_region_STT_STT_TellSpokenText();
			break;
		case main_WolframAlphaTest_main_region_STT_STT_StropSTT:
			exitSequence_main_WolframAlphaTest_main_region_STT_STT_StropSTT();
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
		effect_main_Init_tr0();
	}
	
	/* The reactions of state null. */
	private void react_main__final_() {
	}
	
	/* The reactions of state GreetingsToVisitors. */
	private void react_main_GreetingsToVisitors_inner_region_GreetingsToVisitors() {
		if (check_main_GreetingsToVisitors_inner_region_GreetingsToVisitors_tr0_tr0()) {
			effect_main_GreetingsToVisitors_inner_region_GreetingsToVisitors_tr0();
		} else {
			if (check_main_GreetingsToVisitors_inner_region_GreetingsToVisitors_tr1_tr1()) {
				effect_main_GreetingsToVisitors_inner_region_GreetingsToVisitors_tr1();
			}
		}
	}
	
	/* The reactions of state Head_Eyes. */
	private void react_main_GreetingsToVisitors_inner_region_Head_Eyes() {
		if (check_main_GreetingsToVisitors_inner_region_Head_Eyes_tr0_tr0()) {
			effect_main_GreetingsToVisitors_inner_region_Head_Eyes_tr0();
		} else {
			if (check_main_GreetingsToVisitors_inner_region_Head_Eyes_tr1_tr1()) {
				effect_main_GreetingsToVisitors_inner_region_Head_Eyes_tr1();
			}
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
		} else {
			if (check_main_GreetingsToVisitors_inner_region_Greeting1_tr1_tr1()) {
				effect_main_GreetingsToVisitors_inner_region_Greeting1_tr1();
			}
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
		} else {
			if (check_main_GreetingsToVisitors_inner_region_greeting3_tr1_tr1()) {
				effect_main_GreetingsToVisitors_inner_region_greeting3_tr1();
			}
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
		} else {
			if (check_main_GreetingsToVisitors_inner_region_greeting4_tr1_tr1()) {
				effect_main_GreetingsToVisitors_inner_region_greeting4_tr1();
			}
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
		} else {
			if (check_main_GreetingsToVisitors_inner_region_LeapMotion_Handgestures_tr1_tr1()) {
				effect_main_GreetingsToVisitors_inner_region_LeapMotion_Handgestures_tr1();
			}
		}
	}
	
	/* The reactions of state Back_UTurn. */
	private void react_main_GreetingsToVisitors_inner_region_Back_UTurn() {
		if (check_main_GreetingsToVisitors_inner_region_Back_UTurn_tr0_tr0()) {
			effect_main_GreetingsToVisitors_inner_region_Back_UTurn_tr0();
		}
	}
	
	/* The reactions of state Kinect_waveOn. */
	private void react_main_GreetingsToVisitors_inner_region_Kinect_waveOn() {
		if (check_main_GreetingsToVisitors_inner_region_Kinect_waveOn_tr0_tr0()) {
			effect_main_GreetingsToVisitors_inner_region_Kinect_waveOn_tr0();
		} else {
			if (check_main_GreetingsToVisitors_inner_region_Kinect_waveOn_tr1_tr1()) {
				effect_main_GreetingsToVisitors_inner_region_Kinect_waveOn_tr1();
			}
		}
	}
	
	/* The reactions of state wait5. */
	private void react_main_GreetingsToVisitors_inner_region_wait5() {
		if (check_main_GreetingsToVisitors_inner_region_wait5_tr0_tr0()) {
			effect_main_GreetingsToVisitors_inner_region_wait5_tr0();
		}
	}
	
	/* The reactions of state STTIntro. */
	private void react_main_GreetingsToVisitors_inner_region_STTIntro() {
		if (check_main_GreetingsToVisitors_inner_region_STTIntro_tr0_tr0()) {
			effect_main_GreetingsToVisitors_inner_region_STTIntro_tr0();
		} else {
			if (check_main_GreetingsToVisitors_inner_region_STTIntro_tr1_tr1()) {
				effect_main_GreetingsToVisitors_inner_region_STTIntro_tr1();
			}
		}
	}
	
	/* The reactions of state wait6. */
	private void react_main_GreetingsToVisitors_inner_region_wait6() {
		if (check_main_GreetingsToVisitors_inner_region_wait6_tr0_tr0()) {
			effect_main_GreetingsToVisitors_inner_region_wait6_tr0();
		}
	}
	
	/* The reactions of state realPerson. */
	private void react_main_GreetingsToVisitors_inner_region_realPerson() {
		if (check_main_GreetingsToVisitors_inner_region_realPerson_tr0_tr0()) {
			effect_main_GreetingsToVisitors_inner_region_realPerson_tr0();
		} else {
			if (check_main_GreetingsToVisitors_inner_region_realPerson_tr1_tr1()) {
				effect_main_GreetingsToVisitors_inner_region_realPerson_tr1();
			}
		}
	}
	
	/* The reactions of state waitAfterGreeting. */
	private void react_main_waitAfterGreeting() {
		if (check_main_waitAfterGreeting_tr0_tr0()) {
			effect_main_waitAfterGreeting_tr0();
		}
	}
	
	/* The reactions of state DetectAttractiveness. */
	private void react_main_Attractiveness_openChallenge_attractiveness_DetectAttractiveness() {
		if (check_main_Attractiveness_openChallenge_attractiveness_DetectAttractiveness_tr0_tr0()) {
			effect_main_Attractiveness_openChallenge_attractiveness_DetectAttractiveness_tr0();
		} else {
			if (check_main_Attractiveness_openChallenge_attractiveness_DetectAttractiveness_tr1_tr1()) {
				effect_main_Attractiveness_openChallenge_attractiveness_DetectAttractiveness_tr1();
			}
		}
	}
	
	/* The reactions of state Copy_1_ResponseToAskForAttractiveness. */
	private void react_main_Attractiveness_openChallenge_attractiveness_Copy_1_ResponseToAskForAttractiveness() {
		if (check_main_Attractiveness_openChallenge_attractiveness_Copy_1_ResponseToAskForAttractiveness_tr0_tr0()) {
			effect_main_Attractiveness_openChallenge_attractiveness_Copy_1_ResponseToAskForAttractiveness_tr0();
		} else {
			if (check_main_Attractiveness_openChallenge_attractiveness_Copy_1_ResponseToAskForAttractiveness_tr1_tr1()) {
				effect_main_Attractiveness_openChallenge_attractiveness_Copy_1_ResponseToAskForAttractiveness_tr1();
			}
		}
	}
	
	/* The reactions of state saveAttr. */
	private void react_main_Attractiveness_openChallenge_attractiveness_saveAttr() {
		if (check_main_Attractiveness_openChallenge_attractiveness_saveAttr_tr0_tr0()) {
			effect_main_Attractiveness_openChallenge_attractiveness_saveAttr_tr0();
		} else {
			if (check_main_Attractiveness_openChallenge_attractiveness_saveAttr_tr1_tr1()) {
				effect_main_Attractiveness_openChallenge_attractiveness_saveAttr_tr1();
			}
		}
	}
	
	/* The reactions of state waitForGlasses. */
	private void react_main_Attractiveness_openChallenge_attractiveness_waitForGlasses() {
		if (check_main_Attractiveness_openChallenge_attractiveness_waitForGlasses_tr0_tr0()) {
			effect_main_Attractiveness_openChallenge_attractiveness_waitForGlasses_tr0();
		}
	}
	
	/* The reactions of state DetAt2. */
	private void react_main_Attractiveness_openChallenge_attractiveness_DetAt2() {
		if (check_main_Attractiveness_openChallenge_attractiveness_DetAt2_tr0_tr0()) {
			effect_main_Attractiveness_openChallenge_attractiveness_DetAt2_tr0();
		} else {
			if (check_main_Attractiveness_openChallenge_attractiveness_DetAt2_tr1_tr1()) {
				effect_main_Attractiveness_openChallenge_attractiveness_DetAt2_tr1();
			}
		}
	}
	
	/* The reactions of state MitBrilleHuebscher. */
	private void react_main_Attractiveness_openChallenge_attractiveness_MitBrilleHuebscher() {
		if (check_main_Attractiveness_openChallenge_attractiveness_MitBrilleHuebscher_tr0_tr0()) {
			effect_main_Attractiveness_openChallenge_attractiveness_MitBrilleHuebscher_tr0();
		} else {
			if (check_main_Attractiveness_openChallenge_attractiveness_MitBrilleHuebscher_tr1_tr1()) {
				effect_main_Attractiveness_openChallenge_attractiveness_MitBrilleHuebscher_tr1();
			}
		}
	}
	
	/* The reactions of state OhneBrilleHuebscher. */
	private void react_main_Attractiveness_openChallenge_attractiveness_OhneBrilleHuebscher() {
		if (check_main_Attractiveness_openChallenge_attractiveness_OhneBrilleHuebscher_tr0_tr0()) {
			effect_main_Attractiveness_openChallenge_attractiveness_OhneBrilleHuebscher_tr0();
		} else {
			if (check_main_Attractiveness_openChallenge_attractiveness_OhneBrilleHuebscher_tr1_tr1()) {
				effect_main_Attractiveness_openChallenge_attractiveness_OhneBrilleHuebscher_tr1();
			}
		}
	}
	
	/* The reactions of state failed1. */
	private void react_main_Attractiveness_openChallenge_attractiveness_failed1() {
		if (check_main_Attractiveness_openChallenge_attractiveness_failed1_tr0_tr0()) {
			effect_main_Attractiveness_openChallenge_attractiveness_failed1_tr0();
		} else {
			if (check_main_Attractiveness_openChallenge_attractiveness_failed1_tr1_tr1()) {
				effect_main_Attractiveness_openChallenge_attractiveness_failed1_tr1();
			}
		}
	}
	
	/* The reactions of state BackToPerson1. */
	private void react_main_BackToPerson1() {
		if (check_main_BackToPerson1_tr0_tr0()) {
			effect_main_BackToPerson1_tr0();
		}
	}
	
	/* The reactions of state Text. */
	private void react_main_LeapMotion_LeapMotion_in_OpenChallenge_Text() {
		effect_main_LeapMotion_tr0();
	}
	
	/* The reactions of state StartSTT. */
	private void react_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight_main_region_StartSTT() {
		effect_main_LeapMotion_tr0();
	}
	
	/* The reactions of state Left. */
	private void react_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight_main_region_Left() {
		effect_main_LeapMotion_tr0();
	}
	
	/* The reactions of state Right. */
	private void react_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight_main_region_Right() {
		effect_main_LeapMotion_tr0();
	}
	
	/* The reactions of state count. */
	private void react_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight_main_region_count() {
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
	
	/* The reactions of state InterruptionWave_wavingOf. */
	private void react_main_InterruptionWave_wavingOf() {
		if (check_main_InterruptionWave_wavingOf_tr0_tr0()) {
			effect_main_InterruptionWave_wavingOf_tr0();
		} else {
			if (check_main_InterruptionWave_wavingOf_tr1_tr1()) {
				effect_main_InterruptionWave_wavingOf_tr1();
			}
		}
	}
	
	/* The reactions of state StateA. */
	private void react_main_WolframAlphaTest_main_region_StateA() {
		if (check_main_WolframAlphaTest_tr0_tr0()) {
			effect_main_WolframAlphaTest_tr0();
		} else {
			if (check_main_WolframAlphaTest_main_region_StateA_tr0_tr0()) {
				effect_main_WolframAlphaTest_main_region_StateA_tr0();
			} else {
				if (check_main_WolframAlphaTest_main_region_StateA_tr1_tr1()) {
					effect_main_WolframAlphaTest_main_region_StateA_tr1();
				}
			}
		}
	}
	
	/* The reactions of state StartSTT. */
	private void react_main_WolframAlphaTest_main_region_STT_STT_StartSTT() {
		if (check_main_WolframAlphaTest_tr0_tr0()) {
			effect_main_WolframAlphaTest_tr0();
		} else {
			if (check_main_WolframAlphaTest_main_region_STT_STT_StartSTT_tr0_tr0()) {
				effect_main_WolframAlphaTest_main_region_STT_STT_StartSTT_tr0();
			}
		}
	}
	
	/* The reactions of state TellSpokenText. */
	private void react_main_WolframAlphaTest_main_region_STT_STT_TellSpokenText() {
		if (check_main_WolframAlphaTest_tr0_tr0()) {
			effect_main_WolframAlphaTest_tr0();
		} else {
			if (check_main_WolframAlphaTest_main_region_STT_STT_TellSpokenText_tr0_tr0()) {
				effect_main_WolframAlphaTest_main_region_STT_STT_TellSpokenText_tr0();
			} else {
				if (check_main_WolframAlphaTest_main_region_STT_STT_TellSpokenText_tr1_tr1()) {
					effect_main_WolframAlphaTest_main_region_STT_STT_TellSpokenText_tr1();
				} else {
					if (check_main_WolframAlphaTest_main_region_STT_STT_TellSpokenText_tr2_tr2()) {
						effect_main_WolframAlphaTest_main_region_STT_STT_TellSpokenText_tr2();
					} else {
						if (check_main_WolframAlphaTest_main_region_STT_STT_TellSpokenText_tr3_tr3()) {
							effect_main_WolframAlphaTest_main_region_STT_STT_TellSpokenText_tr3();
						}
					}
				}
			}
		}
	}
	
	/* The reactions of state StropSTT. */
	private void react_main_WolframAlphaTest_main_region_STT_STT_StropSTT() {
		if (check_main_WolframAlphaTest_tr0_tr0()) {
			effect_main_WolframAlphaTest_tr0();
		} else {
			if (check_main_WolframAlphaTest_main_region_STT_STT_StropSTT_tr0_tr0()) {
				effect_main_WolframAlphaTest_main_region_STT_STT_StropSTT_tr0();
			} else {
				if (check_main_WolframAlphaTest_main_region_STT_STT_StropSTT_tr1_tr1()) {
					effect_main_WolframAlphaTest_main_region_STT_STT_StropSTT_tr1();
				}
			}
		}
	}
	
	/* The reactions of state TellAnswer. */
	private void react_main_WolframAlphaTest_main_region_TellAnswer() {
		if (check_main_WolframAlphaTest_tr0_tr0()) {
			effect_main_WolframAlphaTest_tr0();
		} else {
			if (check_main_WolframAlphaTest_main_region_TellAnswer_tr0_tr0()) {
				effect_main_WolframAlphaTest_main_region_TellAnswer_tr0();
			} else {
				if (check_main_WolframAlphaTest_main_region_TellAnswer_tr1_tr1()) {
					effect_main_WolframAlphaTest_main_region_TellAnswer_tr1();
				}
			}
		}
	}
	
	/* The reactions of state TellAction. */
	private void react_main_WolframAlphaTest_main_region_TellAction() {
		if (check_main_WolframAlphaTest_tr0_tr0()) {
			effect_main_WolframAlphaTest_tr0();
		} else {
			if (check_main_WolframAlphaTest_main_region_TellAction_tr0_tr0()) {
				effect_main_WolframAlphaTest_main_region_TellAction_tr0();
			} else {
				if (check_main_WolframAlphaTest_main_region_TellAction_tr1_tr1()) {
					effect_main_WolframAlphaTest_main_region_TellAction_tr1();
				}
			}
		}
	}
	
	/* The reactions of state TellIncomprehensible. */
	private void react_main_WolframAlphaTest_main_region_TellIncomprehensible() {
		if (check_main_WolframAlphaTest_tr0_tr0()) {
			effect_main_WolframAlphaTest_tr0();
		} else {
			if (check_main_WolframAlphaTest_main_region_TellIncomprehensible_tr0_tr0()) {
				effect_main_WolframAlphaTest_main_region_TellIncomprehensible_tr0();
			} else {
				if (check_main_WolframAlphaTest_main_region_TellIncomprehensible_tr1_tr1()) {
					effect_main_WolframAlphaTest_main_region_TellIncomprehensible_tr1();
				}
			}
		}
	}
	
	/* The reactions of state StopSTT. */
	private void react_main_WolframAlphaTest_main_region_StopSTT() {
		if (check_main_WolframAlphaTest_tr0_tr0()) {
			effect_main_WolframAlphaTest_tr0();
		} else {
			effect_main_WolframAlphaTest_main_region_StopSTT_tr0();
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
	private void react_main_Attractiveness_openChallenge_attractiveness__choice_0() {
		if (check_main_Attractiveness_openChallenge_attractiveness__choice_0_tr0_tr0()) {
			effect_main_Attractiveness_openChallenge_attractiveness__choice_0_tr0();
		} else {
			effect_main_Attractiveness_openChallenge_attractiveness__choice_0_tr1();
		}
	}
	
	/* The reactions of state null. */
	private void react_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight_main_region__choice_0() {
		if (check_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight_main_region__choice_0_tr0_tr0()) {
			effect_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight_main_region__choice_0_tr0();
		} else {
			if (check_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight_main_region__choice_0_tr1_tr1()) {
				effect_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight_main_region__choice_0_tr1();
			} else {
				effect_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight_main_region__choice_0_tr2();
			}
		}
	}
	
	/* The reactions of state null. */
	private void react_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight_main_region__choice_1() {
		if (check_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight_main_region__choice_1_tr0_tr0()) {
			effect_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight_main_region__choice_1_tr0();
		} else {
			effect_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight_main_region__choice_1_tr1();
		}
	}
	
	/* The reactions of state null. */
	private void react_main_WolframAlphaTest_main_region_STT_STT__choice_0() {
		if (check_main_WolframAlphaTest_main_region_STT_STT__choice_0_tr1_tr1()) {
			effect_main_WolframAlphaTest_main_region_STT_STT__choice_0_tr1();
		} else {
			effect_main_WolframAlphaTest_main_region_STT_STT__choice_0_tr0();
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
		enterSequence_main_Attractiveness_openChallenge_attractiveness_Copy_1_ResponseToAskForAttractiveness_default();
	}
	
	/* Default react sequence for initial entry  */
	private void react_main_LeapMotion_LeapMotion_in_OpenChallenge__entry_Default() {
		enterSequence_main_LeapMotion_LeapMotion_in_OpenChallenge_Text_default();
	}
	
	/* Default react sequence for initial entry  */
	private void react_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight_main_region__entry_Default() {
		enterSequence_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight_main_region_count_default();
	}
	
	/* Default react sequence for initial entry  */
	private void react_main_WolframAlphaTest_main_region__entry_Default() {
		enterSequence_main_WolframAlphaTest_main_region_StateA_default();
	}
	
	/* Default react sequence for initial entry  */
	private void react_main_WolframAlphaTest_main_region_STT_STT__entry_Default() {
		enterSequence_main_WolframAlphaTest_main_region_STT_STT_StartSTT_default();
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
	
	/* The reactions of exit exit_end. */
	private void react_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight_main_region_exit_end() {
		effect_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight_tr0();
	}
	
	/* The reactions of exit exit_answer. */
	private void react_main_WolframAlphaTest_main_region_STT_STT_exit_answer() {
		effect_main_WolframAlphaTest_main_region_STT_tr0();
	}
	
	/* The reactions of exit exit_action. */
	private void react_main_WolframAlphaTest_main_region_STT_STT_exit_action() {
		effect_main_WolframAlphaTest_main_region_STT_tr1();
	}
	
	/* The reactions of exit exit_incomprehensible. */
	private void react_main_WolframAlphaTest_main_region_STT_STT_exit_incomprehensible() {
		effect_main_WolframAlphaTest_main_region_STT_tr2();
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
			case main_GreetingsToVisitors_inner_region_Kinect_waveOn:
				react_main_GreetingsToVisitors_inner_region_Kinect_waveOn();
				break;
			case main_GreetingsToVisitors_inner_region_wait5:
				react_main_GreetingsToVisitors_inner_region_wait5();
				break;
			case main_GreetingsToVisitors_inner_region_STTIntro:
				react_main_GreetingsToVisitors_inner_region_STTIntro();
				break;
			case main_GreetingsToVisitors_inner_region_wait6:
				react_main_GreetingsToVisitors_inner_region_wait6();
				break;
			case main_GreetingsToVisitors_inner_region_realPerson:
				react_main_GreetingsToVisitors_inner_region_realPerson();
				break;
			case main_waitAfterGreeting:
				react_main_waitAfterGreeting();
				break;
			case main_Attractiveness_openChallenge_attractiveness_DetectAttractiveness:
				react_main_Attractiveness_openChallenge_attractiveness_DetectAttractiveness();
				break;
			case main_Attractiveness_openChallenge_attractiveness_Copy_1_ResponseToAskForAttractiveness:
				react_main_Attractiveness_openChallenge_attractiveness_Copy_1_ResponseToAskForAttractiveness();
				break;
			case main_Attractiveness_openChallenge_attractiveness_saveAttr:
				react_main_Attractiveness_openChallenge_attractiveness_saveAttr();
				break;
			case main_Attractiveness_openChallenge_attractiveness_waitForGlasses:
				react_main_Attractiveness_openChallenge_attractiveness_waitForGlasses();
				break;
			case main_Attractiveness_openChallenge_attractiveness_DetAt2:
				react_main_Attractiveness_openChallenge_attractiveness_DetAt2();
				break;
			case main_Attractiveness_openChallenge_attractiveness_MitBrilleHuebscher:
				react_main_Attractiveness_openChallenge_attractiveness_MitBrilleHuebscher();
				break;
			case main_Attractiveness_openChallenge_attractiveness_OhneBrilleHuebscher:
				react_main_Attractiveness_openChallenge_attractiveness_OhneBrilleHuebscher();
				break;
			case main_Attractiveness_openChallenge_attractiveness_failed1:
				react_main_Attractiveness_openChallenge_attractiveness_failed1();
				break;
			case main_BackToPerson1:
				react_main_BackToPerson1();
				break;
			case main_LeapMotion_LeapMotion_in_OpenChallenge_Text:
				react_main_LeapMotion_LeapMotion_in_OpenChallenge_Text();
				break;
			case main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight_main_region_StartSTT:
				react_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight_main_region_StartSTT();
				break;
			case main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight_main_region_Left:
				react_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight_main_region_Left();
				break;
			case main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight_main_region_Right:
				react_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight_main_region_Right();
				break;
			case main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight_main_region_count:
				react_main_LeapMotion_LeapMotion_in_OpenChallenge_Detect_LeftRight_main_region_count();
				break;
			case main_LeapMotion_LeapMotion_in_OpenChallenge_ByeBye:
				react_main_LeapMotion_LeapMotion_in_OpenChallenge_ByeBye();
				break;
			case main_ByeBye:
				react_main_ByeBye();
				break;
			case main_InterruptionWave_wavingOf:
				react_main_InterruptionWave_wavingOf();
				break;
			case main_WolframAlphaTest_main_region_StateA:
				react_main_WolframAlphaTest_main_region_StateA();
				break;
			case main_WolframAlphaTest_main_region_STT_STT_StartSTT:
				react_main_WolframAlphaTest_main_region_STT_STT_StartSTT();
				break;
			case main_WolframAlphaTest_main_region_STT_STT_TellSpokenText:
				react_main_WolframAlphaTest_main_region_STT_STT_TellSpokenText();
				break;
			case main_WolframAlphaTest_main_region_STT_STT_StropSTT:
				react_main_WolframAlphaTest_main_region_STT_STT_StropSTT();
				break;
			case main_WolframAlphaTest_main_region_TellAnswer:
				react_main_WolframAlphaTest_main_region_TellAnswer();
				break;
			case main_WolframAlphaTest_main_region_TellAction:
				react_main_WolframAlphaTest_main_region_TellAction();
				break;
			case main_WolframAlphaTest_main_region_TellIncomprehensible:
				react_main_WolframAlphaTest_main_region_TellIncomprehensible();
				break;
			case main_WolframAlphaTest_main_region_StopSTT:
				react_main_WolframAlphaTest_main_region_StopSTT();
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
