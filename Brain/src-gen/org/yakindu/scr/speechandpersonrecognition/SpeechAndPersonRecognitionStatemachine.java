package org.yakindu.scr.speechandpersonrecognition;
import org.yakindu.scr.ITimer;

public class SpeechAndPersonRecognitionStatemachine implements ISpeechAndPersonRecognitionStatemachine {

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
	
	protected class SCICrowdDetectionImpl implements SCICrowdDetection {
	
		private SCICrowdDetectionOperationCallback operationCallback;
		
		public void setSCICrowdDetectionOperationCallback(
				SCICrowdDetectionOperationCallback operationCallback) {
			this.operationCallback = operationCallback;
		}
		private boolean detected;
		
		public void raiseDetected() {
			detected = true;
		}
		
		protected void clearEvents() {
			detected = false;
		}
	}
	
	protected SCICrowdDetectionImpl sCICrowdDetection;
	
	protected class SCIMicrophoneArrayImpl implements SCIMicrophoneArray {
	
		private SCIMicrophoneArrayOperationCallback operationCallback;
		
		public void setSCIMicrophoneArrayOperationCallback(
				SCIMicrophoneArrayOperationCallback operationCallback) {
			this.operationCallback = operationCallback;
		}
	}
	
	protected SCIMicrophoneArrayImpl sCIMicrophoneArray;
	
	private boolean initialized = false;
	
	public enum State {
		main_region_Init,
		main_region_Announcement,
		main_region_Wait,
		main_region_TurnAround,
		main_region_CrowdScanningAndCounting,
		main_region_RiddleGame,
		main_region_RiddleGame_RiddleGame_StartGame,
		main_region_RiddleGame_RiddleGame_WaitForOperator,
		main_region_RiddleGame_RiddleGame_Hello,
		main_region_RiddleGame_RiddleGame_Leave_the_arena,
		main_region_RiddleGame_RiddleGame_TellAnswer,
		main_region_RiddleGame_RiddleGame_PrepareForNextQuestion,
		main_region_RiddleGame_RiddleGame_TellIncomprehensible,
		main_region_RiddleGame_RiddleGame_NextQuestion,
		main_region_RiddleGame_RiddleGame_TellAction,
		main_region_RiddleGame_RiddleGame_TellAction_Instructions_RiddleGame_GoTo,
		main_region_RiddleGame_RiddleGame_TellAction_Instructions_RiddleGame_surrounding,
		main_region_RiddleGame_RiddleGame_TellAction_Instructions_RiddleGame_bring,
		main_region_RiddleGame_RiddleGame_TellAction_Instructions_RiddleGame_open,
		main_region_RiddleGame_RiddleGame_TellAction_Instructions_RiddleGame_followme,
		main_region_RiddleGame_RiddleGame_TellAction_Instructions_RiddleGame_unknown,
		main_region_RiddleGame_RiddleGame_TellAction_Instructions_RiddleGame_crowd,
		main_region_RiddleGame_RiddleGame_Scit0s,
		main_region_RiddleGame_RiddleGame_Scit0s_STT_RiddleGame_StartSTT,
		main_region_RiddleGame_RiddleGame_Scit0s_STT_RiddleGame_TellSpokenText,
		main_region_BlindMansBlufGame,
		main_region_BlindMansBlufGame_BlindMansBlufGame_StartGame,
		main_region_BlindMansBlufGame_BlindMansBlufGame_StartSTT,
		main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2,
		main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_waitForSTT,
		main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAnswer,
		main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction,
		main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_GoTo,
		main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_surrounding,
		main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_bring,
		main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_open,
		main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_followme,
		main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_unknown,
		main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_Copy_1_crowd,
		main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellIncomprehensible,
		main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_StopSTT2,
		main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_getSpokenText,
		main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_Kinect2_WaitForNoise,
		main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_Kinect2_Turn,
		main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_Kinect2_endNoise,
		main_region_BlindMansBlufGame_BlindMansBlufGame_allQuestionsDone,
		main_region_BlindMansBlufGame_BlindMansBlufGame_NoRepeat,
		main_region_BlindMansBlufGame_BlindMansBlufGame_Turn,
		main_region_BlindMansBlufGame_BlindMansBlufGame_NextQuestion,
		main_region_BlindMansBlufGame_BlindMansBlufGame_firstQ,
		main_region_BlindMansBlufGame_BlindMansBlufGame_wait,
		main_region_BlindMansBlufGame_BlindMansBlufGame_Repeat,
		main_region_LeaveTheRoom,
		main_region__final_,
		main_region_DetectionOn,
		main_region_waitForMarc,
		leonie_Bupered_Or_Emergency_Stop_waitForEvent,
		leonie_Bupered_Or_Emergency_Stop_Bumpered,
		leonie_Bupered_Or_Emergency_Stop_resetFace,
		leonie_Bupered_Or_Emergency_Stop_EmergencyStop,
		leonie_Bupered_Or_Emergency_Stop_checkEmergency,
		$NullState$
	};
	
	private final State[] stateVector = new State[3];
	
	private int nextStateIndex;
	
	private ITimer timer;
	
	private final boolean[] timeEvents = new boolean[22];
	private long counter;
	
	protected void setCounter(long value) {
		counter = value;
	}
	
	protected long getCounter() {
		return counter;
	}
	
	private String countString;
	
	protected void setCountString(String value) {
		countString = value;
	}
	
	protected String getCountString() {
		return countString;
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
	
	private long gWPout;
	
	protected void setGWPout(long value) {
		gWPout = value;
	}
	
	protected long getGWPout() {
		return gWPout;
	}
	
	public SpeechAndPersonRecognitionStatemachine() {
		sCIBGF = new SCIBGFImpl();
		sCIHBrain = new SCIHBrainImpl();
		sCIKinect2 = new SCIKinect2Impl();
		sCIMira = new SCIMiraImpl();
		sCISTT = new SCISTTImpl();
		sCICrowdDetection = new SCICrowdDetectionImpl();
		sCIMicrophoneArray = new SCIMicrophoneArrayImpl();
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
		sCIBGF.setEventNum(0);
		
		sCIBGF.setRandNum(0);
		
		setCounter(0);
		
		setCountString("");
		
		setQuestionCounter(0);
		
		setQuestionRepeat(0);
		
		setGWPout(0);
	}
	
	public void enter() {
		if (!initialized) {
			throw new IllegalStateException(
					"The state machine needs to be initialized first by calling the init() function.");
		}
		if (timer == null) {
			throw new IllegalStateException("timer not set.");
		}
		enterSequence_main_region_default();
		enterSequence_Leonie_Bupered_Or_Emergency_Stop_default();
	}
	
	public void exit() {
		exitSequence_main_region();
		exitSequence_Leonie_Bupered_Or_Emergency_Stop();
	}
	
	/**
	 * @see IStatemachine#isActive()
	 */
	public boolean isActive() {
		return stateVector[0] != State.$NullState$||stateVector[1] != State.$NullState$||stateVector[2] != State.$NullState$;
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
		sCIMira.clearEvents();
		sCISTT.clearEvents();
		sCICrowdDetection.clearEvents();
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
		case main_region_Init:
			return stateVector[0] == State.main_region_Init;
		case main_region_Announcement:
			return stateVector[0] == State.main_region_Announcement;
		case main_region_Wait:
			return stateVector[0] == State.main_region_Wait;
		case main_region_TurnAround:
			return stateVector[0] == State.main_region_TurnAround;
		case main_region_CrowdScanningAndCounting:
			return stateVector[0] == State.main_region_CrowdScanningAndCounting;
		case main_region_RiddleGame:
			return stateVector[0].ordinal() >= State.
					main_region_RiddleGame.ordinal()&& stateVector[0].ordinal() <= State.main_region_RiddleGame_RiddleGame_Scit0s_STT_RiddleGame_TellSpokenText.ordinal();
		case main_region_RiddleGame_RiddleGame_StartGame:
			return stateVector[0] == State.main_region_RiddleGame_RiddleGame_StartGame;
		case main_region_RiddleGame_RiddleGame_WaitForOperator:
			return stateVector[0] == State.main_region_RiddleGame_RiddleGame_WaitForOperator;
		case main_region_RiddleGame_RiddleGame_Hello:
			return stateVector[0] == State.main_region_RiddleGame_RiddleGame_Hello;
		case main_region_RiddleGame_RiddleGame_Leave_the_arena:
			return stateVector[0] == State.main_region_RiddleGame_RiddleGame_Leave_the_arena;
		case main_region_RiddleGame_RiddleGame_TellAnswer:
			return stateVector[0] == State.main_region_RiddleGame_RiddleGame_TellAnswer;
		case main_region_RiddleGame_RiddleGame_PrepareForNextQuestion:
			return stateVector[0] == State.main_region_RiddleGame_RiddleGame_PrepareForNextQuestion;
		case main_region_RiddleGame_RiddleGame_TellIncomprehensible:
			return stateVector[0] == State.main_region_RiddleGame_RiddleGame_TellIncomprehensible;
		case main_region_RiddleGame_RiddleGame_NextQuestion:
			return stateVector[0] == State.main_region_RiddleGame_RiddleGame_NextQuestion;
		case main_region_RiddleGame_RiddleGame_TellAction:
			return stateVector[0].ordinal() >= State.
					main_region_RiddleGame_RiddleGame_TellAction.ordinal()&& stateVector[0].ordinal() <= State.main_region_RiddleGame_RiddleGame_TellAction_Instructions_RiddleGame_crowd.ordinal();
		case main_region_RiddleGame_RiddleGame_TellAction_Instructions_RiddleGame_GoTo:
			return stateVector[0] == State.main_region_RiddleGame_RiddleGame_TellAction_Instructions_RiddleGame_GoTo;
		case main_region_RiddleGame_RiddleGame_TellAction_Instructions_RiddleGame_surrounding:
			return stateVector[0] == State.main_region_RiddleGame_RiddleGame_TellAction_Instructions_RiddleGame_surrounding;
		case main_region_RiddleGame_RiddleGame_TellAction_Instructions_RiddleGame_bring:
			return stateVector[0] == State.main_region_RiddleGame_RiddleGame_TellAction_Instructions_RiddleGame_bring;
		case main_region_RiddleGame_RiddleGame_TellAction_Instructions_RiddleGame_open:
			return stateVector[0] == State.main_region_RiddleGame_RiddleGame_TellAction_Instructions_RiddleGame_open;
		case main_region_RiddleGame_RiddleGame_TellAction_Instructions_RiddleGame_followme:
			return stateVector[0] == State.main_region_RiddleGame_RiddleGame_TellAction_Instructions_RiddleGame_followme;
		case main_region_RiddleGame_RiddleGame_TellAction_Instructions_RiddleGame_unknown:
			return stateVector[0] == State.main_region_RiddleGame_RiddleGame_TellAction_Instructions_RiddleGame_unknown;
		case main_region_RiddleGame_RiddleGame_TellAction_Instructions_RiddleGame_crowd:
			return stateVector[0] == State.main_region_RiddleGame_RiddleGame_TellAction_Instructions_RiddleGame_crowd;
		case main_region_RiddleGame_RiddleGame_Scit0s:
			return stateVector[0].ordinal() >= State.
					main_region_RiddleGame_RiddleGame_Scit0s.ordinal()&& stateVector[0].ordinal() <= State.main_region_RiddleGame_RiddleGame_Scit0s_STT_RiddleGame_TellSpokenText.ordinal();
		case main_region_RiddleGame_RiddleGame_Scit0s_STT_RiddleGame_StartSTT:
			return stateVector[0] == State.main_region_RiddleGame_RiddleGame_Scit0s_STT_RiddleGame_StartSTT;
		case main_region_RiddleGame_RiddleGame_Scit0s_STT_RiddleGame_TellSpokenText:
			return stateVector[0] == State.main_region_RiddleGame_RiddleGame_Scit0s_STT_RiddleGame_TellSpokenText;
		case main_region_BlindMansBlufGame:
			return stateVector[0].ordinal() >= State.
					main_region_BlindMansBlufGame.ordinal()&& stateVector[0].ordinal() <= State.main_region_BlindMansBlufGame_BlindMansBlufGame_Repeat.ordinal();
		case main_region_BlindMansBlufGame_BlindMansBlufGame_StartGame:
			return stateVector[0] == State.main_region_BlindMansBlufGame_BlindMansBlufGame_StartGame;
		case main_region_BlindMansBlufGame_BlindMansBlufGame_StartSTT:
			return stateVector[0] == State.main_region_BlindMansBlufGame_BlindMansBlufGame_StartSTT;
		case main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2:
			return stateVector[0].ordinal() >= State.
					main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2.ordinal()&& stateVector[0].ordinal() <= State.main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_Kinect2_endNoise.ordinal();
		case main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_waitForSTT:
			return stateVector[0] == State.main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_waitForSTT;
		case main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAnswer:
			return stateVector[0] == State.main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAnswer;
		case main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction:
			return stateVector[0].ordinal() >= State.
					main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction.ordinal()&& stateVector[0].ordinal() <= State.main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_Copy_1_crowd.ordinal();
		case main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_GoTo:
			return stateVector[0] == State.main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_GoTo;
		case main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_surrounding:
			return stateVector[0] == State.main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_surrounding;
		case main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_bring:
			return stateVector[0] == State.main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_bring;
		case main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_open:
			return stateVector[0] == State.main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_open;
		case main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_followme:
			return stateVector[0] == State.main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_followme;
		case main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_unknown:
			return stateVector[0] == State.main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_unknown;
		case main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_Copy_1_crowd:
			return stateVector[0] == State.main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_Copy_1_crowd;
		case main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellIncomprehensible:
			return stateVector[0] == State.main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellIncomprehensible;
		case main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_StopSTT2:
			return stateVector[0] == State.main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_StopSTT2;
		case main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_getSpokenText:
			return stateVector[0] == State.main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_getSpokenText;
		case main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_Kinect2_WaitForNoise:
			return stateVector[1] == State.main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_Kinect2_WaitForNoise;
		case main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_Kinect2_Turn:
			return stateVector[1] == State.main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_Kinect2_Turn;
		case main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_Kinect2_endNoise:
			return stateVector[1] == State.main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_Kinect2_endNoise;
		case main_region_BlindMansBlufGame_BlindMansBlufGame_allQuestionsDone:
			return stateVector[0] == State.main_region_BlindMansBlufGame_BlindMansBlufGame_allQuestionsDone;
		case main_region_BlindMansBlufGame_BlindMansBlufGame_NoRepeat:
			return stateVector[0] == State.main_region_BlindMansBlufGame_BlindMansBlufGame_NoRepeat;
		case main_region_BlindMansBlufGame_BlindMansBlufGame_Turn:
			return stateVector[0] == State.main_region_BlindMansBlufGame_BlindMansBlufGame_Turn;
		case main_region_BlindMansBlufGame_BlindMansBlufGame_NextQuestion:
			return stateVector[0] == State.main_region_BlindMansBlufGame_BlindMansBlufGame_NextQuestion;
		case main_region_BlindMansBlufGame_BlindMansBlufGame_firstQ:
			return stateVector[0] == State.main_region_BlindMansBlufGame_BlindMansBlufGame_firstQ;
		case main_region_BlindMansBlufGame_BlindMansBlufGame_wait:
			return stateVector[0] == State.main_region_BlindMansBlufGame_BlindMansBlufGame_wait;
		case main_region_BlindMansBlufGame_BlindMansBlufGame_Repeat:
			return stateVector[0] == State.main_region_BlindMansBlufGame_BlindMansBlufGame_Repeat;
		case main_region_LeaveTheRoom:
			return stateVector[0] == State.main_region_LeaveTheRoom;
		case main_region__final_:
			return stateVector[0] == State.main_region__final_;
		case main_region_DetectionOn:
			return stateVector[0] == State.main_region_DetectionOn;
		case main_region_waitForMarc:
			return stateVector[0] == State.main_region_waitForMarc;
		case leonie_Bupered_Or_Emergency_Stop_waitForEvent:
			return stateVector[2] == State.leonie_Bupered_Or_Emergency_Stop_waitForEvent;
		case leonie_Bupered_Or_Emergency_Stop_Bumpered:
			return stateVector[2] == State.leonie_Bupered_Or_Emergency_Stop_Bumpered;
		case leonie_Bupered_Or_Emergency_Stop_resetFace:
			return stateVector[2] == State.leonie_Bupered_Or_Emergency_Stop_resetFace;
		case leonie_Bupered_Or_Emergency_Stop_EmergencyStop:
			return stateVector[2] == State.leonie_Bupered_Or_Emergency_Stop_EmergencyStop;
		case leonie_Bupered_Or_Emergency_Stop_checkEmergency:
			return stateVector[2] == State.leonie_Bupered_Or_Emergency_Stop_checkEmergency;
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
	
	public SCIKinect2 getSCIKinect2() {
		return sCIKinect2;
	}
	
	public SCIMira getSCIMira() {
		return sCIMira;
	}
	
	public SCISTT getSCISTT() {
		return sCISTT;
	}
	
	public SCICrowdDetection getSCICrowdDetection() {
		return sCICrowdDetection;
	}
	
	public SCIMicrophoneArray getSCIMicrophoneArray() {
		return sCIMicrophoneArray;
	}
	
	private boolean check_main_region_Init_tr0_tr0() {
		return true;
	}
	
	private boolean check_main_region_Announcement_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_main_region_Announcement_tr1_tr1() {
		return timeEvents[0];
	}
	
	private boolean check_main_region_Wait_tr0_tr0() {
		return timeEvents[1];
	}
	
	private boolean check_main_region_TurnAround_tr0_tr0() {
		return timeEvents[2];
	}
	
	private boolean check_main_region_CrowdScanningAndCounting_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_main_region_CrowdScanningAndCounting_tr1_tr1() {
		return timeEvents[3];
	}
	
	private boolean check_main_region_RiddleGame_RiddleGame_StartGame_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_main_region_RiddleGame_RiddleGame_StartGame_tr1_tr1() {
		return timeEvents[4];
	}
	
	private boolean check_main_region_RiddleGame_RiddleGame_WaitForOperator_tr0_tr0() {
		return timeEvents[5];
	}
	
	private boolean check_main_region_RiddleGame_RiddleGame_Hello_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_main_region_RiddleGame_RiddleGame_Hello_tr1_tr1() {
		return timeEvents[6];
	}
	
	private boolean check_main_region_RiddleGame_RiddleGame_Leave_the_arena_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_main_region_RiddleGame_RiddleGame_Leave_the_arena_tr1_tr1() {
		return timeEvents[7];
	}
	
	private boolean check_main_region_RiddleGame_RiddleGame_TellAnswer_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_main_region_RiddleGame_RiddleGame_TellAnswer_tr1_tr1() {
		return timeEvents[8];
	}
	
	private boolean check_main_region_RiddleGame_RiddleGame_PrepareForNextQuestion_tr0_tr0() {
		return true;
	}
	
	private boolean check_main_region_RiddleGame_RiddleGame_TellIncomprehensible_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_main_region_RiddleGame_RiddleGame_TellIncomprehensible_tr1_tr1() {
		return timeEvents[9];
	}
	
	private boolean check_main_region_RiddleGame_RiddleGame_NextQuestion_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_main_region_RiddleGame_RiddleGame_NextQuestion_tr1_tr1() {
		return timeEvents[10];
	}
	
	private boolean check_main_region_RiddleGame_RiddleGame_TellAction_tr1_tr1() {
		return timeEvents[11];
	}
	
	private boolean check_main_region_RiddleGame_RiddleGame_TellAction_Instructions_RiddleGame_GoTo_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_main_region_RiddleGame_RiddleGame_TellAction_Instructions_RiddleGame_bring_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_main_region_RiddleGame_RiddleGame_TellAction_Instructions_RiddleGame_open_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_main_region_RiddleGame_RiddleGame_TellAction_Instructions_RiddleGame_followme_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_main_region_RiddleGame_RiddleGame_TellAction_Instructions_RiddleGame_unknown_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_main_region_RiddleGame_RiddleGame_TellAction_Instructions_RiddleGame_crowd_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_main_region_RiddleGame_RiddleGame_Scit0s_STT_RiddleGame_StartSTT_tr0_tr0() {
		return sCISTT.spokenTextReceived;
	}
	
	private boolean check_main_region_RiddleGame_RiddleGame_Scit0s_STT_RiddleGame_StartSTT_tr1_tr1() {
		return timeEvents[12];
	}
	
	private boolean check_main_region_RiddleGame_RiddleGame_Scit0s_STT_RiddleGame_TellSpokenText_tr0_tr0() {
		return sCISTT.answerReceived;
	}
	
	private boolean check_main_region_RiddleGame_RiddleGame_Scit0s_STT_RiddleGame_TellSpokenText_tr1_tr1() {
		return sCISTT.actionReceived;
	}
	
	private boolean check_main_region_RiddleGame_RiddleGame_Scit0s_STT_RiddleGame_TellSpokenText_tr2_tr2() {
		return sCISTT.incomprehensible;
	}
	
	private boolean check_main_region_RiddleGame_RiddleGame_Scit0s_STT_RiddleGame_TellSpokenText_tr3_tr3() {
		return timeEvents[13];
	}
	
	private boolean check_main_region_BlindMansBlufGame_BlindMansBlufGame_StartGame_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_main_region_BlindMansBlufGame_BlindMansBlufGame_StartGame_tr1_tr1() {
		return timeEvents[14];
	}
	
	private boolean check_main_region_BlindMansBlufGame_BlindMansBlufGame_StartSTT_tr0_tr0() {
		return true;
	}
	
	private boolean check_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_waitForSTT_tr0_tr0() {
		return sCISTT.spokenTextReceived;
	}
	
	private boolean check_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAnswer_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_GoTo_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_bring_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_open_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_followme_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_unknown_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_Copy_1_crowd_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellIncomprehensible_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_StopSTT2_tr0_SpeechAndPersonRecognition_main_region_BlindMansBlufGame_BlindMansBlufGame__sync1join_check() {
		return isStateActive(State.main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_Kinect2_endNoise);
	}
	
	private boolean check_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_getSpokenText_tr0_tr0() {
		return sCISTT.answerReceived;
	}
	
	private boolean check_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_getSpokenText_tr1_tr1() {
		return sCISTT.incomprehensible;
	}
	
	private boolean check_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_getSpokenText_tr2_tr2() {
		return sCISTT.actionReceived;
	}
	
	private boolean check_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_Kinect2_WaitForNoise_tr0_tr0() {
		return sCIKinect2.noiseDeviatinWithoutBoneDetected;
	}
	
	private boolean check_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_Kinect2_WaitForNoise_tr1_tr1() {
		return sCISTT.spokenTextReceived;
	}
	
	private boolean check_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_Kinect2_WaitForNoise_tr2_tr2() {
		return sCIKinect2.noiseWithBoneDetected;
	}
	
	private boolean check_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_Kinect2_Turn_tr0_tr0() {
		return sCISTT.spokenTextReceived;
	}
	
	private boolean check_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_Kinect2_Turn_tr1_tr1() {
		return timeEvents[15];
	}
	
	private boolean check_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_Kinect2_endNoise_tr0_SpeechAndPersonRecognition_main_region_BlindMansBlufGame_BlindMansBlufGame__sync1join_check() {
		return isStateActive(State.main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_StopSTT2);
	}
	
	private boolean check_main_region_BlindMansBlufGame_BlindMansBlufGame_allQuestionsDone_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_main_region_BlindMansBlufGame_BlindMansBlufGame_NoRepeat_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_main_region_BlindMansBlufGame_BlindMansBlufGame_Turn_tr0_tr0() {
		return timeEvents[16];
	}
	
	private boolean check_main_region_BlindMansBlufGame_BlindMansBlufGame_NextQuestion_tr0_tr0() {
		return true;
	}
	
	private boolean check_main_region_BlindMansBlufGame_BlindMansBlufGame_firstQ_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_main_region_BlindMansBlufGame_BlindMansBlufGame_firstQ_tr1_tr1() {
		return timeEvents[17];
	}
	
	private boolean check_main_region_BlindMansBlufGame_BlindMansBlufGame_wait_tr0_tr0() {
		return timeEvents[18];
	}
	
	private boolean check_main_region_BlindMansBlufGame_BlindMansBlufGame_Repeat_tr0_tr0() {
		return true;
	}
	
	private boolean check_main_region_LeaveTheRoom_tr0_tr0() {
		return sCIMira.arrivedWP;
	}
	
	private boolean check_main_region_DetectionOn_tr0_tr0() {
		return timeEvents[19];
	}
	
	private boolean check_main_region_waitForMarc_tr0_tr0() {
		return sCICrowdDetection.detected;
	}
	
	private boolean check_Leonie_Bupered_Or_Emergency_Stop_waitForEvent_tr0_tr0() {
		return sCIMira.bumpered;
	}
	
	private boolean check_Leonie_Bupered_Or_Emergency_Stop_waitForEvent_tr1_tr1() {
		return sCIMira.emergencyStop;
	}
	
	private boolean check_Leonie_Bupered_Or_Emergency_Stop_Bumpered_tr0_tr0() {
		return timeEvents[20];
	}
	
	private boolean check_Leonie_Bupered_Or_Emergency_Stop_resetFace_tr0_tr0() {
		return true;
	}
	
	private boolean check_Leonie_Bupered_Or_Emergency_Stop_EmergencyStop_tr0_tr0() {
		return true;
	}
	
	private boolean check_Leonie_Bupered_Or_Emergency_Stop_checkEmergency_tr0_tr0() {
		return timeEvents[21];
	}
	
	private boolean check_Leonie_Bupered_Or_Emergency_Stop_checkEmergency_tr1_tr1() {
		return sCIMira.emergencyStop;
	}
	
	private boolean check_main_region_RiddleGame_RiddleGame__choice_0_tr1_tr1() {
		return getCounter()>=5;
	}
	
	private boolean check_main_region_RiddleGame_RiddleGame__choice_0_tr0_tr0() {
		return true;
	}
	
	private boolean check_main_region_RiddleGame_RiddleGame_TellAction_Instructions_RiddleGame__choice_0_tr0_tr0() {
		return (sCISTT.operationCallback.getInstruction()== null?"goto" ==null :sCISTT.operationCallback.getInstruction().equals("goto"));
	}
	
	private boolean check_main_region_RiddleGame_RiddleGame_TellAction_Instructions_RiddleGame__choice_0_tr1_tr1() {
		return (sCISTT.operationCallback.getInstruction()== null?"crowd" ==null :sCISTT.operationCallback.getInstruction().equals("crowd"));
	}
	
	private boolean check_main_region_RiddleGame_RiddleGame_TellAction_Instructions_RiddleGame__choice_0_tr2_tr2() {
		return (sCISTT.operationCallback.getInstruction()== null?"surrounding" ==null :sCISTT.operationCallback.getInstruction().equals("surrounding"));
	}
	
	private boolean check_main_region_RiddleGame_RiddleGame_TellAction_Instructions_RiddleGame__choice_0_tr3_tr3() {
		return (sCISTT.operationCallback.getInstruction()== null?"bring" ==null :sCISTT.operationCallback.getInstruction().equals("bring"));
	}
	
	private boolean check_main_region_RiddleGame_RiddleGame_TellAction_Instructions_RiddleGame__choice_0_tr4_tr4() {
		return (sCISTT.operationCallback.getInstruction()== null?"open" ==null :sCISTT.operationCallback.getInstruction().equals("open"));
	}
	
	private boolean check_main_region_RiddleGame_RiddleGame_TellAction_Instructions_RiddleGame__choice_0_tr5_tr5() {
		return (sCISTT.operationCallback.getInstruction()== null?"followme" ==null :sCISTT.operationCallback.getInstruction().equals("followme"));
	}
	
	private boolean check_main_region_RiddleGame_RiddleGame_TellAction_Instructions_RiddleGame__choice_0_tr6_tr6() {
		return true;
	}
	
	private boolean check_main_region_RiddleGame_RiddleGame_Scit0s_STT_RiddleGame__choice_0_tr1_tr1() {
		return (sCISTT.operationCallback.getSpokenText()== null?"" !=null : !sCISTT.operationCallback.getSpokenText().equals(""));
	}
	
	private boolean check_main_region_RiddleGame_RiddleGame_Scit0s_STT_RiddleGame__choice_0_tr0_tr0() {
		return true;
	}
	
	private boolean check_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame__choice_0_tr0_tr0() {
		return (sCISTT.operationCallback.getInstruction()== null?"goto" ==null :sCISTT.operationCallback.getInstruction().equals("goto"));
	}
	
	private boolean check_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame__choice_0_tr1_tr1() {
		return (sCISTT.operationCallback.getInstruction()== null?"crowd" ==null :sCISTT.operationCallback.getInstruction().equals("crowd"));
	}
	
	private boolean check_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame__choice_0_tr2_tr2() {
		return (sCISTT.operationCallback.getInstruction()== null?"surrounding" ==null :sCISTT.operationCallback.getInstruction().equals("surrounding"));
	}
	
	private boolean check_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame__choice_0_tr3_tr3() {
		return (sCISTT.operationCallback.getInstruction()== null?"bring" ==null :sCISTT.operationCallback.getInstruction().equals("bring"));
	}
	
	private boolean check_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame__choice_0_tr4_tr4() {
		return (sCISTT.operationCallback.getInstruction()== null?"open" ==null :sCISTT.operationCallback.getInstruction().equals("open"));
	}
	
	private boolean check_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame__choice_0_tr5_tr5() {
		return (sCISTT.operationCallback.getInstruction()== null?"followme" ==null :sCISTT.operationCallback.getInstruction().equals("followme"));
	}
	
	private boolean check_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame__choice_0_tr6_tr6() {
		return true;
	}
	
	private boolean check_main_region_BlindMansBlufGame_BlindMansBlufGame__choice_0_tr0_tr0() {
		return getQuestionCounter()>=6;
	}
	
	private boolean check_main_region_BlindMansBlufGame_BlindMansBlufGame__choice_0_tr1_tr1() {
		return true;
	}
	
	private boolean check_main_region_BlindMansBlufGame_BlindMansBlufGame__choice_1_tr0_tr0() {
		return getQuestionRepeat()>1;
	}
	
	private boolean check_main_region_BlindMansBlufGame_BlindMansBlufGame__choice_1_tr1_tr1() {
		return getQuestionRepeat()==1;
	}
	
	private boolean check_main_region_BlindMansBlufGame_BlindMansBlufGame__choice_1_tr2_tr2() {
		return true;
	}
	
	private boolean check_main_region_BlindMansBlufGame_BlindMansBlufGame__choice_2_tr0() {
		return true;
	}
	
	private void effect_main_region_Init_tr0() {
		exitSequence_main_region_Init();
		enterSequence_main_region_Announcement_default();
	}
	
	private void effect_main_region_Announcement_tr0() {
		exitSequence_main_region_Announcement();
		enterSequence_main_region_Wait_default();
	}
	
	private void effect_main_region_Announcement_tr1() {
		exitSequence_main_region_Announcement();
		enterSequence_main_region_Wait_default();
	}
	
	private void effect_main_region_Wait_tr0() {
		exitSequence_main_region_Wait();
		enterSequence_main_region_TurnAround_default();
	}
	
	private void effect_main_region_TurnAround_tr0() {
		exitSequence_main_region_TurnAround();
		enterSequence_main_region_DetectionOn_default();
	}
	
	private void effect_main_region_CrowdScanningAndCounting_tr0() {
		exitSequence_main_region_CrowdScanningAndCounting();
		enterSequence_main_region_RiddleGame_default();
	}
	
	private void effect_main_region_CrowdScanningAndCounting_tr1() {
		exitSequence_main_region_CrowdScanningAndCounting();
		enterSequence_main_region_RiddleGame_default();
	}
	
	private void effect_main_region_RiddleGame_tr0() {
		exitSequence_main_region_RiddleGame();
		enterSequence_main_region_BlindMansBlufGame_exit_done();
	}
	
	private void effect_main_region_RiddleGame_RiddleGame_StartGame_tr0() {
		exitSequence_main_region_RiddleGame_RiddleGame_StartGame();
		enterSequence_main_region_RiddleGame_RiddleGame_WaitForOperator_default();
	}
	
	private void effect_main_region_RiddleGame_RiddleGame_StartGame_tr1() {
		exitSequence_main_region_RiddleGame_RiddleGame_StartGame();
		enterSequence_main_region_RiddleGame_RiddleGame_WaitForOperator_default();
	}
	
	private void effect_main_region_RiddleGame_RiddleGame_WaitForOperator_tr0() {
		exitSequence_main_region_RiddleGame_RiddleGame_WaitForOperator();
		enterSequence_main_region_RiddleGame_RiddleGame_Hello_default();
	}
	
	private void effect_main_region_RiddleGame_RiddleGame_Hello_tr0() {
		exitSequence_main_region_RiddleGame_RiddleGame_Hello();
		enterSequence_main_region_RiddleGame_RiddleGame_Scit0s_default();
	}
	
	private void effect_main_region_RiddleGame_RiddleGame_Hello_tr1() {
		exitSequence_main_region_RiddleGame_RiddleGame_Hello();
		enterSequence_main_region_RiddleGame_RiddleGame_Scit0s_default();
	}
	
	private void effect_main_region_RiddleGame_RiddleGame_Leave_the_arena_tr0() {
		exitSequence_main_region_RiddleGame_RiddleGame_Leave_the_arena();
		react_main_region_RiddleGame_RiddleGame_exit_done();
	}
	
	private void effect_main_region_RiddleGame_RiddleGame_Leave_the_arena_tr1() {
		exitSequence_main_region_RiddleGame_RiddleGame_Leave_the_arena();
		react_main_region_RiddleGame_RiddleGame_exit_done();
	}
	
	private void effect_main_region_RiddleGame_RiddleGame_TellAnswer_tr0() {
		exitSequence_main_region_RiddleGame_RiddleGame_TellAnswer();
		enterSequence_main_region_RiddleGame_RiddleGame_PrepareForNextQuestion_default();
	}
	
	private void effect_main_region_RiddleGame_RiddleGame_TellAnswer_tr1() {
		exitSequence_main_region_RiddleGame_RiddleGame_TellAnswer();
		enterSequence_main_region_RiddleGame_RiddleGame_PrepareForNextQuestion_default();
	}
	
	private void effect_main_region_RiddleGame_RiddleGame_PrepareForNextQuestion_tr0() {
		exitSequence_main_region_RiddleGame_RiddleGame_PrepareForNextQuestion();
		react_main_region_RiddleGame_RiddleGame__choice_0();
	}
	
	private void effect_main_region_RiddleGame_RiddleGame_TellIncomprehensible_tr0() {
		exitSequence_main_region_RiddleGame_RiddleGame_TellIncomprehensible();
		enterSequence_main_region_RiddleGame_RiddleGame_PrepareForNextQuestion_default();
	}
	
	private void effect_main_region_RiddleGame_RiddleGame_TellIncomprehensible_tr1() {
		exitSequence_main_region_RiddleGame_RiddleGame_TellIncomprehensible();
		enterSequence_main_region_RiddleGame_RiddleGame_PrepareForNextQuestion_default();
	}
	
	private void effect_main_region_RiddleGame_RiddleGame_NextQuestion_tr0() {
		exitSequence_main_region_RiddleGame_RiddleGame_NextQuestion();
		enterSequence_main_region_RiddleGame_RiddleGame_Scit0s_default();
	}
	
	private void effect_main_region_RiddleGame_RiddleGame_NextQuestion_tr1() {
		exitSequence_main_region_RiddleGame_RiddleGame_NextQuestion();
		enterSequence_main_region_RiddleGame_RiddleGame_Scit0s_default();
	}
	
	private void effect_main_region_RiddleGame_RiddleGame_TellAction_tr0() {
		exitSequence_main_region_RiddleGame_RiddleGame_TellAction();
		enterSequence_main_region_RiddleGame_RiddleGame_PrepareForNextQuestion_default();
	}
	
	private void effect_main_region_RiddleGame_RiddleGame_TellAction_tr1() {
		exitSequence_main_region_RiddleGame_RiddleGame_TellAction();
		enterSequence_main_region_RiddleGame_RiddleGame_PrepareForNextQuestion_default();
	}
	
	private void effect_main_region_RiddleGame_RiddleGame_TellAction_Instructions_RiddleGame_GoTo_tr0() {
		exitSequence_main_region_RiddleGame_RiddleGame_TellAction_Instructions_RiddleGame_GoTo();
		react_main_region_RiddleGame_RiddleGame_TellAction_Instructions_RiddleGame_exit_done();
	}
	
	private void effect_main_region_RiddleGame_RiddleGame_TellAction_Instructions_RiddleGame_surrounding_tr0() {
		exitSequence_main_region_RiddleGame_RiddleGame_TellAction_Instructions_RiddleGame_surrounding();
		react_main_region_RiddleGame_RiddleGame_TellAction_Instructions_RiddleGame_exit_done();
	}
	
	private void effect_main_region_RiddleGame_RiddleGame_TellAction_Instructions_RiddleGame_bring_tr0() {
		exitSequence_main_region_RiddleGame_RiddleGame_TellAction_Instructions_RiddleGame_bring();
		react_main_region_RiddleGame_RiddleGame_TellAction_Instructions_RiddleGame_exit_done();
	}
	
	private void effect_main_region_RiddleGame_RiddleGame_TellAction_Instructions_RiddleGame_open_tr0() {
		exitSequence_main_region_RiddleGame_RiddleGame_TellAction_Instructions_RiddleGame_open();
		react_main_region_RiddleGame_RiddleGame_TellAction_Instructions_RiddleGame_exit_done();
	}
	
	private void effect_main_region_RiddleGame_RiddleGame_TellAction_Instructions_RiddleGame_followme_tr0() {
		exitSequence_main_region_RiddleGame_RiddleGame_TellAction_Instructions_RiddleGame_followme();
		react_main_region_RiddleGame_RiddleGame_TellAction_Instructions_RiddleGame_exit_done();
	}
	
	private void effect_main_region_RiddleGame_RiddleGame_TellAction_Instructions_RiddleGame_unknown_tr0() {
		exitSequence_main_region_RiddleGame_RiddleGame_TellAction_Instructions_RiddleGame_unknown();
		react_main_region_RiddleGame_RiddleGame_TellAction_Instructions_RiddleGame_exit_done();
	}
	
	private void effect_main_region_RiddleGame_RiddleGame_TellAction_Instructions_RiddleGame_crowd_tr0() {
		exitSequence_main_region_RiddleGame_RiddleGame_TellAction_Instructions_RiddleGame_crowd();
		react_main_region_RiddleGame_RiddleGame_TellAction_Instructions_RiddleGame_exit_done();
	}
	
	private void effect_main_region_RiddleGame_RiddleGame_Scit0s_tr0() {
		exitSequence_main_region_RiddleGame_RiddleGame_Scit0s();
		enterSequence_main_region_RiddleGame_RiddleGame_TellAnswer_default();
	}
	
	private void effect_main_region_RiddleGame_RiddleGame_Scit0s_tr1() {
		exitSequence_main_region_RiddleGame_RiddleGame_Scit0s();
		enterSequence_main_region_RiddleGame_RiddleGame_TellAction_default();
	}
	
	private void effect_main_region_RiddleGame_RiddleGame_Scit0s_tr2() {
		exitSequence_main_region_RiddleGame_RiddleGame_Scit0s();
		enterSequence_main_region_RiddleGame_RiddleGame_TellIncomprehensible_default();
	}
	
	private void effect_main_region_RiddleGame_RiddleGame_Scit0s_STT_RiddleGame_StartSTT_tr0() {
		exitSequence_main_region_RiddleGame_RiddleGame_Scit0s_STT_RiddleGame_StartSTT();
		react_main_region_RiddleGame_RiddleGame_Scit0s_STT_RiddleGame__choice_0();
	}
	
	private void effect_main_region_RiddleGame_RiddleGame_Scit0s_STT_RiddleGame_StartSTT_tr1() {
		exitSequence_main_region_RiddleGame_RiddleGame_Scit0s_STT_RiddleGame_StartSTT();
		react_main_region_RiddleGame_RiddleGame_Scit0s_STT_RiddleGame_exit_incomprehensible();
	}
	
	private void effect_main_region_RiddleGame_RiddleGame_Scit0s_STT_RiddleGame_TellSpokenText_tr0() {
		exitSequence_main_region_RiddleGame_RiddleGame_Scit0s_STT_RiddleGame_TellSpokenText();
		react_main_region_RiddleGame_RiddleGame_Scit0s_STT_RiddleGame_exit_answer();
	}
	
	private void effect_main_region_RiddleGame_RiddleGame_Scit0s_STT_RiddleGame_TellSpokenText_tr1() {
		exitSequence_main_region_RiddleGame_RiddleGame_Scit0s_STT_RiddleGame_TellSpokenText();
		react_main_region_RiddleGame_RiddleGame_Scit0s_STT_RiddleGame_exit_action();
	}
	
	private void effect_main_region_RiddleGame_RiddleGame_Scit0s_STT_RiddleGame_TellSpokenText_tr2() {
		exitSequence_main_region_RiddleGame_RiddleGame_Scit0s_STT_RiddleGame_TellSpokenText();
		react_main_region_RiddleGame_RiddleGame_Scit0s_STT_RiddleGame_exit_incomprehensible();
	}
	
	private void effect_main_region_RiddleGame_RiddleGame_Scit0s_STT_RiddleGame_TellSpokenText_tr3() {
		exitSequence_main_region_RiddleGame_RiddleGame_Scit0s_STT_RiddleGame_TellSpokenText();
		react_main_region_RiddleGame_RiddleGame_Scit0s_STT_RiddleGame_exit_incomprehensible();
	}
	
	private void effect_main_region_BlindMansBlufGame_tr0() {
		exitSequence_main_region_BlindMansBlufGame();
		enterSequence_main_region_LeaveTheRoom_default();
	}
	
	private void effect_main_region_BlindMansBlufGame_BlindMansBlufGame_StartGame_tr0() {
		exitSequence_main_region_BlindMansBlufGame_BlindMansBlufGame_StartGame();
		enterSequence_main_region_BlindMansBlufGame_BlindMansBlufGame_wait_default();
	}
	
	private void effect_main_region_BlindMansBlufGame_BlindMansBlufGame_StartGame_tr1() {
		exitSequence_main_region_BlindMansBlufGame_BlindMansBlufGame_StartGame();
		enterSequence_main_region_BlindMansBlufGame_BlindMansBlufGame_wait_default();
	}
	
	private void effect_main_region_BlindMansBlufGame_BlindMansBlufGame_StartSTT_tr0() {
		exitSequence_main_region_BlindMansBlufGame_BlindMansBlufGame_StartSTT();
		react_main_region_BlindMansBlufGame_BlindMansBlufGame__sync0();
	}
	
	private void effect_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_waitForSTT_tr0() {
		exitSequence_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_waitForSTT();
		enterSequence_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_getSpokenText_default();
	}
	
	private void effect_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAnswer_tr0() {
		exitSequence_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAnswer();
		enterSequence_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_StopSTT2_default();
	}
	
	private void effect_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_tr0() {
		exitSequence_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction();
		enterSequence_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_StopSTT2_default();
	}
	
	private void effect_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_GoTo_tr0() {
		exitSequence_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_GoTo();
	}
	
	private void effect_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_surrounding_tr0() {
		exitSequence_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_surrounding();
	}
	
	private void effect_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_bring_tr0() {
		exitSequence_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_bring();
	}
	
	private void effect_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_open_tr0() {
		exitSequence_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_open();
	}
	
	private void effect_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_followme_tr0() {
		exitSequence_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_followme();
	}
	
	private void effect_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_unknown_tr0() {
		exitSequence_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_unknown();
	}
	
	private void effect_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_Copy_1_crowd_tr0() {
		exitSequence_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_Copy_1_crowd();
	}
	
	private void effect_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellIncomprehensible_tr0() {
		exitSequence_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellIncomprehensible();
		enterSequence_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_StopSTT2_default();
	}
	
	private void effect_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_StopSTT2_tr0() {
		exitSequence_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2();
		react_main_region_BlindMansBlufGame_BlindMansBlufGame__sync1();
	}
	
	private void effect_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_getSpokenText_tr0() {
		exitSequence_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_getSpokenText();
		enterSequence_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAnswer_default();
	}
	
	private void effect_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_getSpokenText_tr1() {
		exitSequence_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_getSpokenText();
		enterSequence_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellIncomprehensible_default();
	}
	
	private void effect_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_getSpokenText_tr2() {
		exitSequence_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_getSpokenText();
		enterSequence_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_default();
	}
	
	private void effect_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_Kinect2_WaitForNoise_tr0() {
		exitSequence_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_Kinect2_WaitForNoise();
		enterSequence_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_Kinect2_Turn_default();
	}
	
	private void effect_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_Kinect2_WaitForNoise_tr1() {
		exitSequence_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_Kinect2_WaitForNoise();
		enterSequence_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_Kinect2_endNoise_default();
	}
	
	private void effect_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_Kinect2_WaitForNoise_tr2() {
		exitSequence_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_Kinect2_WaitForNoise();
		enterSequence_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_Kinect2_Turn_default();
	}
	
	private void effect_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_Kinect2_Turn_tr0() {
		exitSequence_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_Kinect2_Turn();
		enterSequence_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_Kinect2_endNoise_default();
	}
	
	private void effect_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_Kinect2_Turn_tr1() {
		exitSequence_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_Kinect2_Turn();
		enterSequence_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_Kinect2_WaitForNoise_default();
	}
	
	private void effect_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_Kinect2_endNoise_tr0() {
		exitSequence_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2();
		react_main_region_BlindMansBlufGame_BlindMansBlufGame__sync1();
	}
	
	private void effect_main_region_BlindMansBlufGame_BlindMansBlufGame_allQuestionsDone_tr0() {
		exitSequence_main_region_BlindMansBlufGame_BlindMansBlufGame_allQuestionsDone();
		react_main_region_BlindMansBlufGame_BlindMansBlufGame_exit_done();
	}
	
	private void effect_main_region_BlindMansBlufGame_BlindMansBlufGame_NoRepeat_tr0() {
		exitSequence_main_region_BlindMansBlufGame_BlindMansBlufGame_NoRepeat();
		react_main_region_BlindMansBlufGame_BlindMansBlufGame__choice_0();
	}
	
	private void effect_main_region_BlindMansBlufGame_BlindMansBlufGame_Turn_tr0() {
		exitSequence_main_region_BlindMansBlufGame_BlindMansBlufGame_Turn();
		enterSequence_main_region_BlindMansBlufGame_BlindMansBlufGame_Repeat_default();
	}
	
	private void effect_main_region_BlindMansBlufGame_BlindMansBlufGame_NextQuestion_tr0() {
		exitSequence_main_region_BlindMansBlufGame_BlindMansBlufGame_NextQuestion();
		react_main_region_BlindMansBlufGame_BlindMansBlufGame__choice_2();
	}
	
	private void effect_main_region_BlindMansBlufGame_BlindMansBlufGame_firstQ_tr0() {
		exitSequence_main_region_BlindMansBlufGame_BlindMansBlufGame_firstQ();
		enterSequence_main_region_BlindMansBlufGame_BlindMansBlufGame_StartSTT_default();
	}
	
	private void effect_main_region_BlindMansBlufGame_BlindMansBlufGame_firstQ_tr1() {
		exitSequence_main_region_BlindMansBlufGame_BlindMansBlufGame_firstQ();
		enterSequence_main_region_BlindMansBlufGame_BlindMansBlufGame_StartSTT_default();
	}
	
	private void effect_main_region_BlindMansBlufGame_BlindMansBlufGame_wait_tr0() {
		exitSequence_main_region_BlindMansBlufGame_BlindMansBlufGame_wait();
		enterSequence_main_region_BlindMansBlufGame_BlindMansBlufGame_firstQ_default();
	}
	
	private void effect_main_region_BlindMansBlufGame_BlindMansBlufGame_Repeat_tr0() {
		exitSequence_main_region_BlindMansBlufGame_BlindMansBlufGame_Repeat();
		react_main_region_BlindMansBlufGame_BlindMansBlufGame__choice_2();
	}
	
	private void effect_main_region_LeaveTheRoom_tr0() {
		exitSequence_main_region_LeaveTheRoom();
		enterSequence_main_region__final__default();
	}
	
	private void effect_main_region_DetectionOn_tr0() {
		exitSequence_main_region_DetectionOn();
		enterSequence_main_region_waitForMarc_default();
	}
	
	private void effect_main_region_waitForMarc_tr0() {
		exitSequence_main_region_waitForMarc();
		enterSequence_main_region_CrowdScanningAndCounting_default();
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
	
	private void effect_main_region_RiddleGame_RiddleGame__choice_0_tr1() {
		enterSequence_main_region_RiddleGame_RiddleGame_Leave_the_arena_default();
	}
	
	private void effect_main_region_RiddleGame_RiddleGame__choice_0_tr0() {
		enterSequence_main_region_RiddleGame_RiddleGame_NextQuestion_default();
	}
	
	private void effect_main_region_RiddleGame_RiddleGame_TellAction_Instructions_RiddleGame__choice_0_tr0() {
		enterSequence_main_region_RiddleGame_RiddleGame_TellAction_Instructions_RiddleGame_GoTo_default();
	}
	
	private void effect_main_region_RiddleGame_RiddleGame_TellAction_Instructions_RiddleGame__choice_0_tr1() {
		enterSequence_main_region_RiddleGame_RiddleGame_TellAction_Instructions_RiddleGame_crowd_default();
	}
	
	private void effect_main_region_RiddleGame_RiddleGame_TellAction_Instructions_RiddleGame__choice_0_tr2() {
		enterSequence_main_region_RiddleGame_RiddleGame_TellAction_Instructions_RiddleGame_surrounding_default();
	}
	
	private void effect_main_region_RiddleGame_RiddleGame_TellAction_Instructions_RiddleGame__choice_0_tr3() {
		enterSequence_main_region_RiddleGame_RiddleGame_TellAction_Instructions_RiddleGame_bring_default();
	}
	
	private void effect_main_region_RiddleGame_RiddleGame_TellAction_Instructions_RiddleGame__choice_0_tr4() {
		enterSequence_main_region_RiddleGame_RiddleGame_TellAction_Instructions_RiddleGame_open_default();
	}
	
	private void effect_main_region_RiddleGame_RiddleGame_TellAction_Instructions_RiddleGame__choice_0_tr5() {
		enterSequence_main_region_RiddleGame_RiddleGame_TellAction_Instructions_RiddleGame_followme_default();
	}
	
	private void effect_main_region_RiddleGame_RiddleGame_TellAction_Instructions_RiddleGame__choice_0_tr6() {
		enterSequence_main_region_RiddleGame_RiddleGame_TellAction_Instructions_RiddleGame_unknown_default();
	}
	
	private void effect_main_region_RiddleGame_RiddleGame_Scit0s_STT_RiddleGame__choice_0_tr1() {
		enterSequence_main_region_RiddleGame_RiddleGame_Scit0s_STT_RiddleGame_TellSpokenText_default();
	}
	
	private void effect_main_region_RiddleGame_RiddleGame_Scit0s_STT_RiddleGame__choice_0_tr0() {
		react_main_region_RiddleGame_RiddleGame_Scit0s_STT_RiddleGame_exit_incomprehensible();
	}
	
	private void effect_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame__choice_0_tr0() {
		enterSequence_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_GoTo_default();
	}
	
	private void effect_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame__choice_0_tr1() {
		enterSequence_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_Copy_1_crowd_default();
	}
	
	private void effect_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame__choice_0_tr2() {
		enterSequence_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_surrounding_default();
	}
	
	private void effect_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame__choice_0_tr3() {
		enterSequence_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_bring_default();
	}
	
	private void effect_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame__choice_0_tr4() {
		enterSequence_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_open_default();
	}
	
	private void effect_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame__choice_0_tr5() {
		enterSequence_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_followme_default();
	}
	
	private void effect_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame__choice_0_tr6() {
		enterSequence_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_unknown_default();
	}
	
	private void effect_main_region_BlindMansBlufGame_BlindMansBlufGame__choice_0_tr0() {
		enterSequence_main_region_BlindMansBlufGame_BlindMansBlufGame_allQuestionsDone_default();
	}
	
	private void effect_main_region_BlindMansBlufGame_BlindMansBlufGame__choice_0_tr1() {
		react_main_region_BlindMansBlufGame_BlindMansBlufGame__choice_1();
	}
	
	private void effect_main_region_BlindMansBlufGame_BlindMansBlufGame__choice_1_tr0() {
		enterSequence_main_region_BlindMansBlufGame_BlindMansBlufGame_NoRepeat_default();
	}
	
	private void effect_main_region_BlindMansBlufGame_BlindMansBlufGame__choice_1_tr1() {
		enterSequence_main_region_BlindMansBlufGame_BlindMansBlufGame_Turn_default();
	}
	
	private void effect_main_region_BlindMansBlufGame_BlindMansBlufGame__choice_1_tr2() {
		enterSequence_main_region_BlindMansBlufGame_BlindMansBlufGame_NextQuestion_default();
	}
	
	private void effect_main_region_BlindMansBlufGame_BlindMansBlufGame__choice_2_tr0() {
		enterSequence_main_region_BlindMansBlufGame_BlindMansBlufGame_StartSTT_default();
	}
	
	/* Entry action for state 'Init'. */
	private void entryAction_main_region_Init() {
		setGWPout(13);
	}
	
	/* Entry action for state 'Announcement'. */
	private void entryAction_main_region_Announcement() {
		timer.setTimer(this, 0, 10*1000, false);
		
		sCIHBrain.operationCallback.sendTTS("[:-)] I want to play the riddle game in 10 seconds.");
	}
	
	/* Entry action for state 'Wait'. */
	private void entryAction_main_region_Wait() {
		timer.setTimer(this, 1, 10*1000, false);
	}
	
	/* Entry action for state 'TurnAround'. */
	private void entryAction_main_region_TurnAround() {
		timer.setTimer(this, 2, 7*1000, false);
		
		sCIHBrain.operationCallback.sendTTS("Lets go!");
		
		sCIMira.operationCallback.sendBodyUTurn();
	}
	
	/* Entry action for state 'CrowdScanningAndCounting'. */
	private void entryAction_main_region_CrowdScanningAndCounting() {
		timer.setTimer(this, 3, 50*1000, false);
		
		sCICrowdDetection.operationCallback.sendDetectionOff();
		
		sCIHBrain.operationCallback.sendTTS("[:-)]");
		
		sCIHBrain.operationCallback.sendTTS(sCICrowdDetection.operationCallback.getSummaryText());
	}
	
	/* Entry action for state 'StartGame'. */
	private void entryAction_main_region_RiddleGame_RiddleGame_StartGame() {
		timer.setTimer(this, 4, 15*1000, false);
		
		setQuestionCounter(0);
		
		setQuestionRepeat(0);
		
		sCIHBrain.operationCallback.sendTTS("Who want to play riddles with me? Please step in front of me!");
	}
	
	/* Entry action for state 'WaitForOperator'. */
	private void entryAction_main_region_RiddleGame_RiddleGame_WaitForOperator() {
		timer.setTimer(this, 5, 7*1000, false);
	}
	
	/* Entry action for state 'Hello'. */
	private void entryAction_main_region_RiddleGame_RiddleGame_Hello() {
		timer.setTimer(this, 6, 10*1000, false);
		
		sCIHBrain.operationCallback.sendTTS("[:-)] Ask me a question! [attentive]");
		
		setCounter(0);
	}
	
	/* Entry action for state 'Leave the arena'. */
	private void entryAction_main_region_RiddleGame_RiddleGame_Leave_the_arena() {
		timer.setTimer(this, 7, 10*1000, false);
		
		sCIHBrain.operationCallback.sendTTS("Okay, that's enough for now.");
	}
	
	/* Entry action for state 'TellAnswer'. */
	private void entryAction_main_region_RiddleGame_RiddleGame_TellAnswer() {
		timer.setTimer(this, 8, 40*1000, false);
		
		sCIHBrain.operationCallback.sendTTS2(sCISTT.operationCallback.getAnswer(), " [:-)]");
	}
	
	/* Entry action for state 'PrepareForNextQuestion'. */
	private void entryAction_main_region_RiddleGame_RiddleGame_PrepareForNextQuestion() {
		setCounter(getCounter() + 1);
	}
	
	/* Entry action for state 'TellIncomprehensible'. */
	private void entryAction_main_region_RiddleGame_RiddleGame_TellIncomprehensible() {
		timer.setTimer(this, 9, 40*1000, false);
		
		sCIHBrain.operationCallback.sendTTS3("[:-(]", sCISTT.operationCallback.getAnswer(), "[:-|]");
	}
	
	/* Entry action for state 'NextQuestion'. */
	private void entryAction_main_region_RiddleGame_RiddleGame_NextQuestion() {
		timer.setTimer(this, 10, 10*1000, false);
		
		sCIHBrain.operationCallback.sendTTS("Please ask me the next question. [attentive]");
	}
	
	/* Entry action for state 'TellAction'. */
	private void entryAction_main_region_RiddleGame_RiddleGame_TellAction() {
		timer.setTimer(this, 11, 40*1000, false);
	}
	
	/* Entry action for state 'GoTo'. */
	private void entryAction_main_region_RiddleGame_RiddleGame_TellAction_Instructions_RiddleGame_GoTo() {
		sCIHBrain.operationCallback.sendTTS("[:-(] Sorry. I'm can't go to somewhere now.");
	}
	
	/* Entry action for state 'bring'. */
	private void entryAction_main_region_RiddleGame_RiddleGame_TellAction_Instructions_RiddleGame_bring() {
		sCIHBrain.operationCallback.sendTTS("[:-(] Sorry. I'm can't bring something at the moment.");
	}
	
	/* Entry action for state 'open'. */
	private void entryAction_main_region_RiddleGame_RiddleGame_TellAction_Instructions_RiddleGame_open() {
		sCIHBrain.operationCallback.sendTTS("[:-(] Sorry. I'm can't open something at the moment.");
	}
	
	/* Entry action for state 'followme'. */
	private void entryAction_main_region_RiddleGame_RiddleGame_TellAction_Instructions_RiddleGame_followme() {
		sCIHBrain.operationCallback.sendTTS("[:-(] Sorry. I'm can't follow you now.");
	}
	
	/* Entry action for state 'unknown'. */
	private void entryAction_main_region_RiddleGame_RiddleGame_TellAction_Instructions_RiddleGame_unknown() {
		sCIHBrain.operationCallback.sendTTS("[:-(] Sorry. I didn't get what I should do.");
	}
	
	/* Entry action for state 'crowd'. */
	private void entryAction_main_region_RiddleGame_RiddleGame_TellAction_Instructions_RiddleGame_crowd() {
		sCIHBrain.operationCallback.sendTTS(sCICrowdDetection.operationCallback.getAnswerForSecificCrowdDetails(sCISTT.operationCallback.getObject()));
	}
	
	/* Entry action for state 'StartSTT'. */
	private void entryAction_main_region_RiddleGame_RiddleGame_Scit0s_STT_RiddleGame_StartSTT() {
		timer.setTimer(this, 12, 30*1000, false);
		
		sCISTT.operationCallback.sendSpeechDetectionSmalltalk(10);
		
		sCIHBrain.operationCallback.sendTTS("[attentive]");
	}
	
	/* Entry action for state 'TellSpokenText'. */
	private void entryAction_main_region_RiddleGame_RiddleGame_Scit0s_STT_RiddleGame_TellSpokenText() {
		timer.setTimer(this, 13, 30*1000, false);
		
		sCIHBrain.operationCallback.sendTTS2("[:-|] I understood: ", sCISTT.operationCallback.getSpokenText());
	}
	
	/* Entry action for state 'StartGame'. */
	private void entryAction_main_region_BlindMansBlufGame_BlindMansBlufGame_StartGame() {
		timer.setTimer(this, 14, 3*1000, false);
		
		setQuestionCounter(0);
		
		setQuestionRepeat(0);
		
		sCIHBrain.operationCallback.sendTTS("I'm ready for the blind mans bluff game. [:-)] Please stand in a circle close to me. I will start in 5 seconds.");
	}
	
	/* Entry action for state 'StartSTT'. */
	private void entryAction_main_region_BlindMansBlufGame_BlindMansBlufGame_StartSTT() {
		sCIKinect2.operationCallback.sendNoiseDetectionOnOff(true);
		
		sCISTT.operationCallback.sendSpeechDetectionSmalltalk(10);
	}
	
	/* Entry action for state 'waitForSTT'. */
	private void entryAction_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_waitForSTT() {
		sCIHBrain.operationCallback.sendTTS("[attentive]");
	}
	
	/* Entry action for state 'TellAnswer'. */
	private void entryAction_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAnswer() {
		sCIHBrain.operationCallback.sendTTS2(sCISTT.operationCallback.getAnswer(), " [:-)]");
		
		setQuestionCounter(getQuestionCounter() + 1);
		
		setQuestionRepeat(0);
	}
	
	/* Entry action for state 'TellAction'. */
	private void entryAction_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction() {
		setQuestionCounter(getQuestionCounter() + 1);
		
		setQuestionRepeat(0);
	}
	
	/* Entry action for state 'GoTo'. */
	private void entryAction_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_GoTo() {
		sCIHBrain.operationCallback.sendTTS("[:-(] Sorry. I'm can't go to somewhere now.");
	}
	
	/* Entry action for state 'bring'. */
	private void entryAction_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_bring() {
		sCIHBrain.operationCallback.sendTTS("[:-(] Sorry. I'm can't bring something at the moment.");
	}
	
	/* Entry action for state 'open'. */
	private void entryAction_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_open() {
		sCIHBrain.operationCallback.sendTTS("[:-(] Sorry. I'm can't open something at the moment.");
	}
	
	/* Entry action for state 'followme'. */
	private void entryAction_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_followme() {
		sCIHBrain.operationCallback.sendTTS("[:-(] Sorry. I'm can't follow you now.");
	}
	
	/* Entry action for state 'unknown'. */
	private void entryAction_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_unknown() {
		sCIHBrain.operationCallback.sendTTS("[:-(] Sorry. I didn't get what I should do.");
	}
	
	/* Entry action for state 'Copy_1_crowd'. */
	private void entryAction_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_Copy_1_crowd() {
		sCIHBrain.operationCallback.sendTTS(sCICrowdDetection.operationCallback.getAnswerForSecificCrowdDetails(sCISTT.operationCallback.getObject()));
	}
	
	/* Entry action for state 'TellIncomprehensible'. */
	private void entryAction_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellIncomprehensible() {
		sCIHBrain.operationCallback.sendTTS3("[:-(]", sCISTT.operationCallback.getAnswer(), "[:-|]");
		
		setQuestionRepeat(getQuestionRepeat() + 1);
	}
	
	/* Entry action for state 'getSpokenText'. */
	private void entryAction_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_getSpokenText() {
		sCIHBrain.operationCallback.sendTTS2("I understood: ", sCISTT.operationCallback.getSpokenText());
	}
	
	/* Entry action for state 'Turn'. */
	private void entryAction_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_Kinect2_Turn() {
		timer.setTimer(this, 15, 500, false);
		
		sCIMira.operationCallback.sendTurnBody(sCIKinect2.operationCallback.getNoiseAngle());
	}
	
	/* Entry action for state 'endNoise'. */
	private void entryAction_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_Kinect2_endNoise() {
		sCIKinect2.operationCallback.sendNoiseDetectionOnOff(false);
	}
	
	/* Entry action for state 'allQuestionsDone'. */
	private void entryAction_main_region_BlindMansBlufGame_BlindMansBlufGame_allQuestionsDone() {
		sCIHBrain.operationCallback.sendTTS("Okay. Thats all.");
	}
	
	/* Entry action for state 'NoRepeat'. */
	private void entryAction_main_region_BlindMansBlufGame_BlindMansBlufGame_NoRepeat() {
		sCIHBrain.operationCallback.sendTTS("I'm so sorry! I have no answer for you [:-(]");
		
		setQuestionCounter(getQuestionCounter() + 1);
		
		setQuestionRepeat(0);
	}
	
	/* Entry action for state 'Turn'. */
	private void entryAction_main_region_BlindMansBlufGame_BlindMansBlufGame_Turn() {
		timer.setTimer(this, 16, 2*1000, false);
		
		sCIMira.operationCallback.sendBodyUTurn();
	}
	
	/* Entry action for state 'NextQuestion'. */
	private void entryAction_main_region_BlindMansBlufGame_BlindMansBlufGame_NextQuestion() {
		sCIHBrain.operationCallback.sendTTS("Please ask me the next question. [attentive]");
	}
	
	/* Entry action for state 'firstQ'. */
	private void entryAction_main_region_BlindMansBlufGame_BlindMansBlufGame_firstQ() {
		timer.setTimer(this, 17, 7*1000, false);
		
		sCIHBrain.operationCallback.sendTTS("I'm ready for the blind mans bluff game. [:-)] Ask me the first question. [attentive]");
	}
	
	/* Entry action for state 'wait'. */
	private void entryAction_main_region_BlindMansBlufGame_BlindMansBlufGame_wait() {
		timer.setTimer(this, 18, 5*1000, false);
	}
	
	/* Entry action for state 'Repeat'. */
	private void entryAction_main_region_BlindMansBlufGame_BlindMansBlufGame_Repeat() {
		sCIHBrain.operationCallback.sendTTS("Please repeat the question. [attentive]");
	}
	
	/* Entry action for state 'LeaveTheRoom'. */
	private void entryAction_main_region_LeaveTheRoom() {
		sCIMira.operationCallback.sendGoToGWP(13);
	}
	
	/* Entry action for state 'DetectionOn'. */
	private void entryAction_main_region_DetectionOn() {
		timer.setTimer(this, 19, 5*1000, false);
		
		sCICrowdDetection.operationCallback.sendDetectionOn();
		
		sCIHBrain.operationCallback.sendTTS("[:-O] Please hold on for analysing.");
	}
	
	/* Entry action for state 'Bumpered'. */
	private void entryAction_Leonie_Bupered_Or_Emergency_Stop_Bumpered() {
		timer.setTimer(this, 20, 3*1000, false);
		
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
		timer.setTimer(this, 21, 3*1000, false);
	}
	
	/* Exit action for state 'Announcement'. */
	private void exitAction_main_region_Announcement() {
		timer.unsetTimer(this, 0);
	}
	
	/* Exit action for state 'Wait'. */
	private void exitAction_main_region_Wait() {
		timer.unsetTimer(this, 1);
	}
	
	/* Exit action for state 'TurnAround'. */
	private void exitAction_main_region_TurnAround() {
		timer.unsetTimer(this, 2);
	}
	
	/* Exit action for state 'CrowdScanningAndCounting'. */
	private void exitAction_main_region_CrowdScanningAndCounting() {
		timer.unsetTimer(this, 3);
	}
	
	/* Exit action for state 'StartGame'. */
	private void exitAction_main_region_RiddleGame_RiddleGame_StartGame() {
		timer.unsetTimer(this, 4);
	}
	
	/* Exit action for state 'WaitForOperator'. */
	private void exitAction_main_region_RiddleGame_RiddleGame_WaitForOperator() {
		timer.unsetTimer(this, 5);
	}
	
	/* Exit action for state 'Hello'. */
	private void exitAction_main_region_RiddleGame_RiddleGame_Hello() {
		timer.unsetTimer(this, 6);
	}
	
	/* Exit action for state 'Leave the arena'. */
	private void exitAction_main_region_RiddleGame_RiddleGame_Leave_the_arena() {
		timer.unsetTimer(this, 7);
	}
	
	/* Exit action for state 'TellAnswer'. */
	private void exitAction_main_region_RiddleGame_RiddleGame_TellAnswer() {
		timer.unsetTimer(this, 8);
	}
	
	/* Exit action for state 'TellIncomprehensible'. */
	private void exitAction_main_region_RiddleGame_RiddleGame_TellIncomprehensible() {
		timer.unsetTimer(this, 9);
	}
	
	/* Exit action for state 'NextQuestion'. */
	private void exitAction_main_region_RiddleGame_RiddleGame_NextQuestion() {
		timer.unsetTimer(this, 10);
	}
	
	/* Exit action for state 'TellAction'. */
	private void exitAction_main_region_RiddleGame_RiddleGame_TellAction() {
		timer.unsetTimer(this, 11);
	}
	
	/* Exit action for state 'StartSTT'. */
	private void exitAction_main_region_RiddleGame_RiddleGame_Scit0s_STT_RiddleGame_StartSTT() {
		timer.unsetTimer(this, 12);
	}
	
	/* Exit action for state 'TellSpokenText'. */
	private void exitAction_main_region_RiddleGame_RiddleGame_Scit0s_STT_RiddleGame_TellSpokenText() {
		timer.unsetTimer(this, 13);
	}
	
	/* Exit action for state 'StartGame'. */
	private void exitAction_main_region_BlindMansBlufGame_BlindMansBlufGame_StartGame() {
		timer.unsetTimer(this, 14);
	}
	
	/* Exit action for state 'Turn'. */
	private void exitAction_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_Kinect2_Turn() {
		timer.unsetTimer(this, 15);
	}
	
	/* Exit action for state 'Turn'. */
	private void exitAction_main_region_BlindMansBlufGame_BlindMansBlufGame_Turn() {
		timer.unsetTimer(this, 16);
	}
	
	/* Exit action for state 'firstQ'. */
	private void exitAction_main_region_BlindMansBlufGame_BlindMansBlufGame_firstQ() {
		timer.unsetTimer(this, 17);
	}
	
	/* Exit action for state 'wait'. */
	private void exitAction_main_region_BlindMansBlufGame_BlindMansBlufGame_wait() {
		timer.unsetTimer(this, 18);
	}
	
	/* Exit action for state 'DetectionOn'. */
	private void exitAction_main_region_DetectionOn() {
		timer.unsetTimer(this, 19);
	}
	
	/* Exit action for state 'Bumpered'. */
	private void exitAction_Leonie_Bupered_Or_Emergency_Stop_Bumpered() {
		timer.unsetTimer(this, 20);
	}
	
	/* Exit action for state 'checkEmergency'. */
	private void exitAction_Leonie_Bupered_Or_Emergency_Stop_checkEmergency() {
		timer.unsetTimer(this, 21);
	}
	
	/* 'default' enter sequence for state Init */
	private void enterSequence_main_region_Init_default() {
		entryAction_main_region_Init();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_Init;
	}
	
	/* 'default' enter sequence for state Announcement */
	private void enterSequence_main_region_Announcement_default() {
		entryAction_main_region_Announcement();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_Announcement;
	}
	
	/* 'default' enter sequence for state Wait */
	private void enterSequence_main_region_Wait_default() {
		entryAction_main_region_Wait();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_Wait;
	}
	
	/* 'default' enter sequence for state TurnAround */
	private void enterSequence_main_region_TurnAround_default() {
		entryAction_main_region_TurnAround();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_TurnAround;
	}
	
	/* 'default' enter sequence for state CrowdScanningAndCounting */
	private void enterSequence_main_region_CrowdScanningAndCounting_default() {
		entryAction_main_region_CrowdScanningAndCounting();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_CrowdScanningAndCounting;
	}
	
	/* 'default' enter sequence for state RiddleGame */
	private void enterSequence_main_region_RiddleGame_default() {
		enterSequence_main_region_RiddleGame_RiddleGame_default();
	}
	
	/* 'default' enter sequence for state StartGame */
	private void enterSequence_main_region_RiddleGame_RiddleGame_StartGame_default() {
		entryAction_main_region_RiddleGame_RiddleGame_StartGame();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_RiddleGame_RiddleGame_StartGame;
	}
	
	/* 'default' enter sequence for state WaitForOperator */
	private void enterSequence_main_region_RiddleGame_RiddleGame_WaitForOperator_default() {
		entryAction_main_region_RiddleGame_RiddleGame_WaitForOperator();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_RiddleGame_RiddleGame_WaitForOperator;
	}
	
	/* 'default' enter sequence for state Hello */
	private void enterSequence_main_region_RiddleGame_RiddleGame_Hello_default() {
		entryAction_main_region_RiddleGame_RiddleGame_Hello();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_RiddleGame_RiddleGame_Hello;
	}
	
	/* 'default' enter sequence for state Leave the arena */
	private void enterSequence_main_region_RiddleGame_RiddleGame_Leave_the_arena_default() {
		entryAction_main_region_RiddleGame_RiddleGame_Leave_the_arena();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_RiddleGame_RiddleGame_Leave_the_arena;
	}
	
	/* 'default' enter sequence for state TellAnswer */
	private void enterSequence_main_region_RiddleGame_RiddleGame_TellAnswer_default() {
		entryAction_main_region_RiddleGame_RiddleGame_TellAnswer();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_RiddleGame_RiddleGame_TellAnswer;
	}
	
	/* 'default' enter sequence for state PrepareForNextQuestion */
	private void enterSequence_main_region_RiddleGame_RiddleGame_PrepareForNextQuestion_default() {
		entryAction_main_region_RiddleGame_RiddleGame_PrepareForNextQuestion();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_RiddleGame_RiddleGame_PrepareForNextQuestion;
	}
	
	/* 'default' enter sequence for state TellIncomprehensible */
	private void enterSequence_main_region_RiddleGame_RiddleGame_TellIncomprehensible_default() {
		entryAction_main_region_RiddleGame_RiddleGame_TellIncomprehensible();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_RiddleGame_RiddleGame_TellIncomprehensible;
	}
	
	/* 'default' enter sequence for state NextQuestion */
	private void enterSequence_main_region_RiddleGame_RiddleGame_NextQuestion_default() {
		entryAction_main_region_RiddleGame_RiddleGame_NextQuestion();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_RiddleGame_RiddleGame_NextQuestion;
	}
	
	/* 'default' enter sequence for state TellAction */
	private void enterSequence_main_region_RiddleGame_RiddleGame_TellAction_default() {
		entryAction_main_region_RiddleGame_RiddleGame_TellAction();
		enterSequence_main_region_RiddleGame_RiddleGame_TellAction_Instructions_RiddleGame_default();
	}
	
	/* 'default' enter sequence for state GoTo */
	private void enterSequence_main_region_RiddleGame_RiddleGame_TellAction_Instructions_RiddleGame_GoTo_default() {
		entryAction_main_region_RiddleGame_RiddleGame_TellAction_Instructions_RiddleGame_GoTo();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_RiddleGame_RiddleGame_TellAction_Instructions_RiddleGame_GoTo;
	}
	
	/* 'default' enter sequence for state surrounding */
	private void enterSequence_main_region_RiddleGame_RiddleGame_TellAction_Instructions_RiddleGame_surrounding_default() {
		nextStateIndex = 0;
		stateVector[0] = State.main_region_RiddleGame_RiddleGame_TellAction_Instructions_RiddleGame_surrounding;
	}
	
	/* 'default' enter sequence for state bring */
	private void enterSequence_main_region_RiddleGame_RiddleGame_TellAction_Instructions_RiddleGame_bring_default() {
		entryAction_main_region_RiddleGame_RiddleGame_TellAction_Instructions_RiddleGame_bring();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_RiddleGame_RiddleGame_TellAction_Instructions_RiddleGame_bring;
	}
	
	/* 'default' enter sequence for state open */
	private void enterSequence_main_region_RiddleGame_RiddleGame_TellAction_Instructions_RiddleGame_open_default() {
		entryAction_main_region_RiddleGame_RiddleGame_TellAction_Instructions_RiddleGame_open();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_RiddleGame_RiddleGame_TellAction_Instructions_RiddleGame_open;
	}
	
	/* 'default' enter sequence for state followme */
	private void enterSequence_main_region_RiddleGame_RiddleGame_TellAction_Instructions_RiddleGame_followme_default() {
		entryAction_main_region_RiddleGame_RiddleGame_TellAction_Instructions_RiddleGame_followme();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_RiddleGame_RiddleGame_TellAction_Instructions_RiddleGame_followme;
	}
	
	/* 'default' enter sequence for state unknown */
	private void enterSequence_main_region_RiddleGame_RiddleGame_TellAction_Instructions_RiddleGame_unknown_default() {
		entryAction_main_region_RiddleGame_RiddleGame_TellAction_Instructions_RiddleGame_unknown();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_RiddleGame_RiddleGame_TellAction_Instructions_RiddleGame_unknown;
	}
	
	/* 'default' enter sequence for state crowd */
	private void enterSequence_main_region_RiddleGame_RiddleGame_TellAction_Instructions_RiddleGame_crowd_default() {
		entryAction_main_region_RiddleGame_RiddleGame_TellAction_Instructions_RiddleGame_crowd();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_RiddleGame_RiddleGame_TellAction_Instructions_RiddleGame_crowd;
	}
	
	/* 'default' enter sequence for state Scit0s */
	private void enterSequence_main_region_RiddleGame_RiddleGame_Scit0s_default() {
		enterSequence_main_region_RiddleGame_RiddleGame_Scit0s_STT_RiddleGame_default();
	}
	
	/* 'default' enter sequence for state StartSTT */
	private void enterSequence_main_region_RiddleGame_RiddleGame_Scit0s_STT_RiddleGame_StartSTT_default() {
		entryAction_main_region_RiddleGame_RiddleGame_Scit0s_STT_RiddleGame_StartSTT();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_RiddleGame_RiddleGame_Scit0s_STT_RiddleGame_StartSTT;
	}
	
	/* 'default' enter sequence for state TellSpokenText */
	private void enterSequence_main_region_RiddleGame_RiddleGame_Scit0s_STT_RiddleGame_TellSpokenText_default() {
		entryAction_main_region_RiddleGame_RiddleGame_Scit0s_STT_RiddleGame_TellSpokenText();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_RiddleGame_RiddleGame_Scit0s_STT_RiddleGame_TellSpokenText;
	}
	
	/* 'exit_done' enter sequence for state BlindMansBlufGame */
	private void enterSequence_main_region_BlindMansBlufGame_exit_done() {
		enterSequence_main_region_BlindMansBlufGame_BlindMansBlufGame_default();
	}
	
	/* 'default' enter sequence for state StartGame */
	private void enterSequence_main_region_BlindMansBlufGame_BlindMansBlufGame_StartGame_default() {
		entryAction_main_region_BlindMansBlufGame_BlindMansBlufGame_StartGame();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_BlindMansBlufGame_BlindMansBlufGame_StartGame;
	}
	
	/* 'default' enter sequence for state StartSTT */
	private void enterSequence_main_region_BlindMansBlufGame_BlindMansBlufGame_StartSTT_default() {
		entryAction_main_region_BlindMansBlufGame_BlindMansBlufGame_StartSTT();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_BlindMansBlufGame_BlindMansBlufGame_StartSTT;
	}
	
	/* 'default' enter sequence for state waitForSTT */
	private void enterSequence_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_waitForSTT_default() {
		entryAction_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_waitForSTT();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_waitForSTT;
	}
	
	/* 'default' enter sequence for state TellAnswer */
	private void enterSequence_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAnswer_default() {
		entryAction_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAnswer();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAnswer;
	}
	
	/* 'default' enter sequence for state TellAction */
	private void enterSequence_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_default() {
		entryAction_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction();
		enterSequence_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_default();
	}
	
	/* 'default' enter sequence for state GoTo */
	private void enterSequence_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_GoTo_default() {
		entryAction_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_GoTo();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_GoTo;
	}
	
	/* 'default' enter sequence for state surrounding */
	private void enterSequence_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_surrounding_default() {
		nextStateIndex = 0;
		stateVector[0] = State.main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_surrounding;
	}
	
	/* 'default' enter sequence for state bring */
	private void enterSequence_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_bring_default() {
		entryAction_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_bring();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_bring;
	}
	
	/* 'default' enter sequence for state open */
	private void enterSequence_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_open_default() {
		entryAction_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_open();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_open;
	}
	
	/* 'default' enter sequence for state followme */
	private void enterSequence_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_followme_default() {
		entryAction_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_followme();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_followme;
	}
	
	/* 'default' enter sequence for state unknown */
	private void enterSequence_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_unknown_default() {
		entryAction_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_unknown();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_unknown;
	}
	
	/* 'default' enter sequence for state Copy_1_crowd */
	private void enterSequence_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_Copy_1_crowd_default() {
		entryAction_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_Copy_1_crowd();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_Copy_1_crowd;
	}
	
	/* 'default' enter sequence for state TellIncomprehensible */
	private void enterSequence_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellIncomprehensible_default() {
		entryAction_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellIncomprehensible();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellIncomprehensible;
	}
	
	/* 'default' enter sequence for state StopSTT2 */
	private void enterSequence_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_StopSTT2_default() {
		nextStateIndex = 0;
		stateVector[0] = State.main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_StopSTT2;
	}
	
	/* 'default' enter sequence for state getSpokenText */
	private void enterSequence_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_getSpokenText_default() {
		entryAction_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_getSpokenText();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_getSpokenText;
	}
	
	/* 'default' enter sequence for state WaitForNoise */
	private void enterSequence_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_Kinect2_WaitForNoise_default() {
		nextStateIndex = 1;
		stateVector[1] = State.main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_Kinect2_WaitForNoise;
	}
	
	/* 'default' enter sequence for state Turn */
	private void enterSequence_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_Kinect2_Turn_default() {
		entryAction_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_Kinect2_Turn();
		nextStateIndex = 1;
		stateVector[1] = State.main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_Kinect2_Turn;
	}
	
	/* 'default' enter sequence for state endNoise */
	private void enterSequence_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_Kinect2_endNoise_default() {
		entryAction_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_Kinect2_endNoise();
		nextStateIndex = 1;
		stateVector[1] = State.main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_Kinect2_endNoise;
	}
	
	/* 'default' enter sequence for state allQuestionsDone */
	private void enterSequence_main_region_BlindMansBlufGame_BlindMansBlufGame_allQuestionsDone_default() {
		entryAction_main_region_BlindMansBlufGame_BlindMansBlufGame_allQuestionsDone();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_BlindMansBlufGame_BlindMansBlufGame_allQuestionsDone;
	}
	
	/* 'default' enter sequence for state NoRepeat */
	private void enterSequence_main_region_BlindMansBlufGame_BlindMansBlufGame_NoRepeat_default() {
		entryAction_main_region_BlindMansBlufGame_BlindMansBlufGame_NoRepeat();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_BlindMansBlufGame_BlindMansBlufGame_NoRepeat;
	}
	
	/* 'default' enter sequence for state Turn */
	private void enterSequence_main_region_BlindMansBlufGame_BlindMansBlufGame_Turn_default() {
		entryAction_main_region_BlindMansBlufGame_BlindMansBlufGame_Turn();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_BlindMansBlufGame_BlindMansBlufGame_Turn;
	}
	
	/* 'default' enter sequence for state NextQuestion */
	private void enterSequence_main_region_BlindMansBlufGame_BlindMansBlufGame_NextQuestion_default() {
		entryAction_main_region_BlindMansBlufGame_BlindMansBlufGame_NextQuestion();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_BlindMansBlufGame_BlindMansBlufGame_NextQuestion;
	}
	
	/* 'default' enter sequence for state firstQ */
	private void enterSequence_main_region_BlindMansBlufGame_BlindMansBlufGame_firstQ_default() {
		entryAction_main_region_BlindMansBlufGame_BlindMansBlufGame_firstQ();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_BlindMansBlufGame_BlindMansBlufGame_firstQ;
	}
	
	/* 'default' enter sequence for state wait */
	private void enterSequence_main_region_BlindMansBlufGame_BlindMansBlufGame_wait_default() {
		entryAction_main_region_BlindMansBlufGame_BlindMansBlufGame_wait();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_BlindMansBlufGame_BlindMansBlufGame_wait;
	}
	
	/* 'default' enter sequence for state Repeat */
	private void enterSequence_main_region_BlindMansBlufGame_BlindMansBlufGame_Repeat_default() {
		entryAction_main_region_BlindMansBlufGame_BlindMansBlufGame_Repeat();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_BlindMansBlufGame_BlindMansBlufGame_Repeat;
	}
	
	/* 'default' enter sequence for state LeaveTheRoom */
	private void enterSequence_main_region_LeaveTheRoom_default() {
		entryAction_main_region_LeaveTheRoom();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_LeaveTheRoom;
	}
	
	/* Default enter sequence for state null */
	private void enterSequence_main_region__final__default() {
		nextStateIndex = 0;
		stateVector[0] = State.main_region__final_;
	}
	
	/* 'default' enter sequence for state DetectionOn */
	private void enterSequence_main_region_DetectionOn_default() {
		entryAction_main_region_DetectionOn();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_DetectionOn;
	}
	
	/* 'default' enter sequence for state waitForMarc */
	private void enterSequence_main_region_waitForMarc_default() {
		nextStateIndex = 0;
		stateVector[0] = State.main_region_waitForMarc;
	}
	
	/* 'default' enter sequence for state waitForEvent */
	private void enterSequence_Leonie_Bupered_Or_Emergency_Stop_waitForEvent_default() {
		nextStateIndex = 2;
		stateVector[2] = State.leonie_Bupered_Or_Emergency_Stop_waitForEvent;
	}
	
	/* 'default' enter sequence for state Bumpered */
	private void enterSequence_Leonie_Bupered_Or_Emergency_Stop_Bumpered_default() {
		entryAction_Leonie_Bupered_Or_Emergency_Stop_Bumpered();
		nextStateIndex = 2;
		stateVector[2] = State.leonie_Bupered_Or_Emergency_Stop_Bumpered;
	}
	
	/* 'default' enter sequence for state resetFace */
	private void enterSequence_Leonie_Bupered_Or_Emergency_Stop_resetFace_default() {
		entryAction_Leonie_Bupered_Or_Emergency_Stop_resetFace();
		nextStateIndex = 2;
		stateVector[2] = State.leonie_Bupered_Or_Emergency_Stop_resetFace;
	}
	
	/* 'default' enter sequence for state EmergencyStop */
	private void enterSequence_Leonie_Bupered_Or_Emergency_Stop_EmergencyStop_default() {
		entryAction_Leonie_Bupered_Or_Emergency_Stop_EmergencyStop();
		nextStateIndex = 2;
		stateVector[2] = State.leonie_Bupered_Or_Emergency_Stop_EmergencyStop;
	}
	
	/* 'default' enter sequence for state checkEmergency */
	private void enterSequence_Leonie_Bupered_Or_Emergency_Stop_checkEmergency_default() {
		entryAction_Leonie_Bupered_Or_Emergency_Stop_checkEmergency();
		nextStateIndex = 2;
		stateVector[2] = State.leonie_Bupered_Or_Emergency_Stop_checkEmergency;
	}
	
	/* 'default' enter sequence for region main region */
	private void enterSequence_main_region_default() {
		react_main_region__entry_Default();
	}
	
	/* 'default' enter sequence for region RiddleGame */
	private void enterSequence_main_region_RiddleGame_RiddleGame_default() {
		react_main_region_RiddleGame_RiddleGame__entry_Default();
	}
	
	/* 'default' enter sequence for region Instructions RiddleGame */
	private void enterSequence_main_region_RiddleGame_RiddleGame_TellAction_Instructions_RiddleGame_default() {
		react_main_region_RiddleGame_RiddleGame_TellAction_Instructions_RiddleGame__entry_Default();
	}
	
	/* 'default' enter sequence for region STT RiddleGame */
	private void enterSequence_main_region_RiddleGame_RiddleGame_Scit0s_STT_RiddleGame_default() {
		react_main_region_RiddleGame_RiddleGame_Scit0s_STT_RiddleGame__entry_Default();
	}
	
	/* 'default' enter sequence for region BlindMansBlufGame */
	private void enterSequence_main_region_BlindMansBlufGame_BlindMansBlufGame_default() {
		react_main_region_BlindMansBlufGame_BlindMansBlufGame__entry_Default();
	}
	
	/* 'default' enter sequence for region Instructions BlindMansBlufGame */
	private void enterSequence_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_default() {
		react_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame__entry_Default();
	}
	
	/* 'default' enter sequence for region Leonie Bupered Or Emergency Stop */
	private void enterSequence_Leonie_Bupered_Or_Emergency_Stop_default() {
		react_Leonie_Bupered_Or_Emergency_Stop__entry_Default();
	}
	
	/* Default exit sequence for state Init */
	private void exitSequence_main_region_Init() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state Announcement */
	private void exitSequence_main_region_Announcement() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
		
		exitAction_main_region_Announcement();
	}
	
	/* Default exit sequence for state Wait */
	private void exitSequence_main_region_Wait() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
		
		exitAction_main_region_Wait();
	}
	
	/* Default exit sequence for state TurnAround */
	private void exitSequence_main_region_TurnAround() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
		
		exitAction_main_region_TurnAround();
	}
	
	/* Default exit sequence for state CrowdScanningAndCounting */
	private void exitSequence_main_region_CrowdScanningAndCounting() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
		
		exitAction_main_region_CrowdScanningAndCounting();
	}
	
	/* Default exit sequence for state RiddleGame */
	private void exitSequence_main_region_RiddleGame() {
		exitSequence_main_region_RiddleGame_RiddleGame();
	}
	
	/* Default exit sequence for state StartGame */
	private void exitSequence_main_region_RiddleGame_RiddleGame_StartGame() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
		
		exitAction_main_region_RiddleGame_RiddleGame_StartGame();
	}
	
	/* Default exit sequence for state WaitForOperator */
	private void exitSequence_main_region_RiddleGame_RiddleGame_WaitForOperator() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
		
		exitAction_main_region_RiddleGame_RiddleGame_WaitForOperator();
	}
	
	/* Default exit sequence for state Hello */
	private void exitSequence_main_region_RiddleGame_RiddleGame_Hello() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
		
		exitAction_main_region_RiddleGame_RiddleGame_Hello();
	}
	
	/* Default exit sequence for state Leave the arena */
	private void exitSequence_main_region_RiddleGame_RiddleGame_Leave_the_arena() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
		
		exitAction_main_region_RiddleGame_RiddleGame_Leave_the_arena();
	}
	
	/* Default exit sequence for state TellAnswer */
	private void exitSequence_main_region_RiddleGame_RiddleGame_TellAnswer() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
		
		exitAction_main_region_RiddleGame_RiddleGame_TellAnswer();
	}
	
	/* Default exit sequence for state PrepareForNextQuestion */
	private void exitSequence_main_region_RiddleGame_RiddleGame_PrepareForNextQuestion() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state TellIncomprehensible */
	private void exitSequence_main_region_RiddleGame_RiddleGame_TellIncomprehensible() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
		
		exitAction_main_region_RiddleGame_RiddleGame_TellIncomprehensible();
	}
	
	/* Default exit sequence for state NextQuestion */
	private void exitSequence_main_region_RiddleGame_RiddleGame_NextQuestion() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
		
		exitAction_main_region_RiddleGame_RiddleGame_NextQuestion();
	}
	
	/* Default exit sequence for state TellAction */
	private void exitSequence_main_region_RiddleGame_RiddleGame_TellAction() {
		exitSequence_main_region_RiddleGame_RiddleGame_TellAction_Instructions_RiddleGame();
		exitAction_main_region_RiddleGame_RiddleGame_TellAction();
	}
	
	/* Default exit sequence for state GoTo */
	private void exitSequence_main_region_RiddleGame_RiddleGame_TellAction_Instructions_RiddleGame_GoTo() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state surrounding */
	private void exitSequence_main_region_RiddleGame_RiddleGame_TellAction_Instructions_RiddleGame_surrounding() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state bring */
	private void exitSequence_main_region_RiddleGame_RiddleGame_TellAction_Instructions_RiddleGame_bring() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state open */
	private void exitSequence_main_region_RiddleGame_RiddleGame_TellAction_Instructions_RiddleGame_open() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state followme */
	private void exitSequence_main_region_RiddleGame_RiddleGame_TellAction_Instructions_RiddleGame_followme() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state unknown */
	private void exitSequence_main_region_RiddleGame_RiddleGame_TellAction_Instructions_RiddleGame_unknown() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state crowd */
	private void exitSequence_main_region_RiddleGame_RiddleGame_TellAction_Instructions_RiddleGame_crowd() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state Scit0s */
	private void exitSequence_main_region_RiddleGame_RiddleGame_Scit0s() {
		exitSequence_main_region_RiddleGame_RiddleGame_Scit0s_STT_RiddleGame();
	}
	
	/* Default exit sequence for state StartSTT */
	private void exitSequence_main_region_RiddleGame_RiddleGame_Scit0s_STT_RiddleGame_StartSTT() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
		
		exitAction_main_region_RiddleGame_RiddleGame_Scit0s_STT_RiddleGame_StartSTT();
	}
	
	/* Default exit sequence for state TellSpokenText */
	private void exitSequence_main_region_RiddleGame_RiddleGame_Scit0s_STT_RiddleGame_TellSpokenText() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
		
		exitAction_main_region_RiddleGame_RiddleGame_Scit0s_STT_RiddleGame_TellSpokenText();
	}
	
	/* Default exit sequence for state BlindMansBlufGame */
	private void exitSequence_main_region_BlindMansBlufGame() {
		exitSequence_main_region_BlindMansBlufGame_BlindMansBlufGame();
	}
	
	/* Default exit sequence for state StartGame */
	private void exitSequence_main_region_BlindMansBlufGame_BlindMansBlufGame_StartGame() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
		
		exitAction_main_region_BlindMansBlufGame_BlindMansBlufGame_StartGame();
	}
	
	/* Default exit sequence for state StartSTT */
	private void exitSequence_main_region_BlindMansBlufGame_BlindMansBlufGame_StartSTT() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state ParallelOfSTTAndKinect2 */
	private void exitSequence_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2() {
		exitSequence_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT();
		exitSequence_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_Kinect2();
	}
	
	/* Default exit sequence for state waitForSTT */
	private void exitSequence_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_waitForSTT() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state TellAnswer */
	private void exitSequence_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAnswer() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state TellAction */
	private void exitSequence_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction() {
		exitSequence_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame();
	}
	
	/* Default exit sequence for state GoTo */
	private void exitSequence_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_GoTo() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state surrounding */
	private void exitSequence_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_surrounding() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state bring */
	private void exitSequence_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_bring() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state open */
	private void exitSequence_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_open() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state followme */
	private void exitSequence_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_followme() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state unknown */
	private void exitSequence_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_unknown() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state Copy_1_crowd */
	private void exitSequence_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_Copy_1_crowd() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state TellIncomprehensible */
	private void exitSequence_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellIncomprehensible() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state StopSTT2 */
	private void exitSequence_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_StopSTT2() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state getSpokenText */
	private void exitSequence_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_getSpokenText() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state WaitForNoise */
	private void exitSequence_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_Kinect2_WaitForNoise() {
		nextStateIndex = 1;
		stateVector[1] = State.$NullState$;
	}
	
	/* Default exit sequence for state Turn */
	private void exitSequence_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_Kinect2_Turn() {
		nextStateIndex = 1;
		stateVector[1] = State.$NullState$;
		
		exitAction_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_Kinect2_Turn();
	}
	
	/* Default exit sequence for state endNoise */
	private void exitSequence_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_Kinect2_endNoise() {
		nextStateIndex = 1;
		stateVector[1] = State.$NullState$;
	}
	
	/* Default exit sequence for state allQuestionsDone */
	private void exitSequence_main_region_BlindMansBlufGame_BlindMansBlufGame_allQuestionsDone() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state NoRepeat */
	private void exitSequence_main_region_BlindMansBlufGame_BlindMansBlufGame_NoRepeat() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state Turn */
	private void exitSequence_main_region_BlindMansBlufGame_BlindMansBlufGame_Turn() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
		
		exitAction_main_region_BlindMansBlufGame_BlindMansBlufGame_Turn();
	}
	
	/* Default exit sequence for state NextQuestion */
	private void exitSequence_main_region_BlindMansBlufGame_BlindMansBlufGame_NextQuestion() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state firstQ */
	private void exitSequence_main_region_BlindMansBlufGame_BlindMansBlufGame_firstQ() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
		
		exitAction_main_region_BlindMansBlufGame_BlindMansBlufGame_firstQ();
	}
	
	/* Default exit sequence for state wait */
	private void exitSequence_main_region_BlindMansBlufGame_BlindMansBlufGame_wait() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
		
		exitAction_main_region_BlindMansBlufGame_BlindMansBlufGame_wait();
	}
	
	/* Default exit sequence for state Repeat */
	private void exitSequence_main_region_BlindMansBlufGame_BlindMansBlufGame_Repeat() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state LeaveTheRoom */
	private void exitSequence_main_region_LeaveTheRoom() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for final state. */
	private void exitSequence_main_region__final_() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state DetectionOn */
	private void exitSequence_main_region_DetectionOn() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
		
		exitAction_main_region_DetectionOn();
	}
	
	/* Default exit sequence for state waitForMarc */
	private void exitSequence_main_region_waitForMarc() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state waitForEvent */
	private void exitSequence_Leonie_Bupered_Or_Emergency_Stop_waitForEvent() {
		nextStateIndex = 2;
		stateVector[2] = State.$NullState$;
	}
	
	/* Default exit sequence for state Bumpered */
	private void exitSequence_Leonie_Bupered_Or_Emergency_Stop_Bumpered() {
		nextStateIndex = 2;
		stateVector[2] = State.$NullState$;
		
		exitAction_Leonie_Bupered_Or_Emergency_Stop_Bumpered();
	}
	
	/* Default exit sequence for state resetFace */
	private void exitSequence_Leonie_Bupered_Or_Emergency_Stop_resetFace() {
		nextStateIndex = 2;
		stateVector[2] = State.$NullState$;
	}
	
	/* Default exit sequence for state EmergencyStop */
	private void exitSequence_Leonie_Bupered_Or_Emergency_Stop_EmergencyStop() {
		nextStateIndex = 2;
		stateVector[2] = State.$NullState$;
	}
	
	/* Default exit sequence for state checkEmergency */
	private void exitSequence_Leonie_Bupered_Or_Emergency_Stop_checkEmergency() {
		nextStateIndex = 2;
		stateVector[2] = State.$NullState$;
		
		exitAction_Leonie_Bupered_Or_Emergency_Stop_checkEmergency();
	}
	
	/* Default exit sequence for region main region */
	private void exitSequence_main_region() {
		switch (stateVector[0]) {
		case main_region_Init:
			exitSequence_main_region_Init();
			break;
		case main_region_Announcement:
			exitSequence_main_region_Announcement();
			break;
		case main_region_Wait:
			exitSequence_main_region_Wait();
			break;
		case main_region_TurnAround:
			exitSequence_main_region_TurnAround();
			break;
		case main_region_CrowdScanningAndCounting:
			exitSequence_main_region_CrowdScanningAndCounting();
			break;
		case main_region_RiddleGame_RiddleGame_StartGame:
			exitSequence_main_region_RiddleGame_RiddleGame_StartGame();
			break;
		case main_region_RiddleGame_RiddleGame_WaitForOperator:
			exitSequence_main_region_RiddleGame_RiddleGame_WaitForOperator();
			break;
		case main_region_RiddleGame_RiddleGame_Hello:
			exitSequence_main_region_RiddleGame_RiddleGame_Hello();
			break;
		case main_region_RiddleGame_RiddleGame_Leave_the_arena:
			exitSequence_main_region_RiddleGame_RiddleGame_Leave_the_arena();
			break;
		case main_region_RiddleGame_RiddleGame_TellAnswer:
			exitSequence_main_region_RiddleGame_RiddleGame_TellAnswer();
			break;
		case main_region_RiddleGame_RiddleGame_PrepareForNextQuestion:
			exitSequence_main_region_RiddleGame_RiddleGame_PrepareForNextQuestion();
			break;
		case main_region_RiddleGame_RiddleGame_TellIncomprehensible:
			exitSequence_main_region_RiddleGame_RiddleGame_TellIncomprehensible();
			break;
		case main_region_RiddleGame_RiddleGame_NextQuestion:
			exitSequence_main_region_RiddleGame_RiddleGame_NextQuestion();
			break;
		case main_region_RiddleGame_RiddleGame_TellAction_Instructions_RiddleGame_GoTo:
			exitSequence_main_region_RiddleGame_RiddleGame_TellAction_Instructions_RiddleGame_GoTo();
			exitAction_main_region_RiddleGame_RiddleGame_TellAction();
			break;
		case main_region_RiddleGame_RiddleGame_TellAction_Instructions_RiddleGame_surrounding:
			exitSequence_main_region_RiddleGame_RiddleGame_TellAction_Instructions_RiddleGame_surrounding();
			exitAction_main_region_RiddleGame_RiddleGame_TellAction();
			break;
		case main_region_RiddleGame_RiddleGame_TellAction_Instructions_RiddleGame_bring:
			exitSequence_main_region_RiddleGame_RiddleGame_TellAction_Instructions_RiddleGame_bring();
			exitAction_main_region_RiddleGame_RiddleGame_TellAction();
			break;
		case main_region_RiddleGame_RiddleGame_TellAction_Instructions_RiddleGame_open:
			exitSequence_main_region_RiddleGame_RiddleGame_TellAction_Instructions_RiddleGame_open();
			exitAction_main_region_RiddleGame_RiddleGame_TellAction();
			break;
		case main_region_RiddleGame_RiddleGame_TellAction_Instructions_RiddleGame_followme:
			exitSequence_main_region_RiddleGame_RiddleGame_TellAction_Instructions_RiddleGame_followme();
			exitAction_main_region_RiddleGame_RiddleGame_TellAction();
			break;
		case main_region_RiddleGame_RiddleGame_TellAction_Instructions_RiddleGame_unknown:
			exitSequence_main_region_RiddleGame_RiddleGame_TellAction_Instructions_RiddleGame_unknown();
			exitAction_main_region_RiddleGame_RiddleGame_TellAction();
			break;
		case main_region_RiddleGame_RiddleGame_TellAction_Instructions_RiddleGame_crowd:
			exitSequence_main_region_RiddleGame_RiddleGame_TellAction_Instructions_RiddleGame_crowd();
			exitAction_main_region_RiddleGame_RiddleGame_TellAction();
			break;
		case main_region_RiddleGame_RiddleGame_Scit0s_STT_RiddleGame_StartSTT:
			exitSequence_main_region_RiddleGame_RiddleGame_Scit0s_STT_RiddleGame_StartSTT();
			break;
		case main_region_RiddleGame_RiddleGame_Scit0s_STT_RiddleGame_TellSpokenText:
			exitSequence_main_region_RiddleGame_RiddleGame_Scit0s_STT_RiddleGame_TellSpokenText();
			break;
		case main_region_BlindMansBlufGame_BlindMansBlufGame_StartGame:
			exitSequence_main_region_BlindMansBlufGame_BlindMansBlufGame_StartGame();
			break;
		case main_region_BlindMansBlufGame_BlindMansBlufGame_StartSTT:
			exitSequence_main_region_BlindMansBlufGame_BlindMansBlufGame_StartSTT();
			break;
		case main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_waitForSTT:
			exitSequence_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_waitForSTT();
			break;
		case main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAnswer:
			exitSequence_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAnswer();
			break;
		case main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_GoTo:
			exitSequence_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_GoTo();
			break;
		case main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_surrounding:
			exitSequence_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_surrounding();
			break;
		case main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_bring:
			exitSequence_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_bring();
			break;
		case main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_open:
			exitSequence_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_open();
			break;
		case main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_followme:
			exitSequence_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_followme();
			break;
		case main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_unknown:
			exitSequence_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_unknown();
			break;
		case main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_Copy_1_crowd:
			exitSequence_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_Copy_1_crowd();
			break;
		case main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellIncomprehensible:
			exitSequence_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellIncomprehensible();
			break;
		case main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_StopSTT2:
			exitSequence_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_StopSTT2();
			break;
		case main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_getSpokenText:
			exitSequence_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_getSpokenText();
			break;
		case main_region_BlindMansBlufGame_BlindMansBlufGame_allQuestionsDone:
			exitSequence_main_region_BlindMansBlufGame_BlindMansBlufGame_allQuestionsDone();
			break;
		case main_region_BlindMansBlufGame_BlindMansBlufGame_NoRepeat:
			exitSequence_main_region_BlindMansBlufGame_BlindMansBlufGame_NoRepeat();
			break;
		case main_region_BlindMansBlufGame_BlindMansBlufGame_Turn:
			exitSequence_main_region_BlindMansBlufGame_BlindMansBlufGame_Turn();
			break;
		case main_region_BlindMansBlufGame_BlindMansBlufGame_NextQuestion:
			exitSequence_main_region_BlindMansBlufGame_BlindMansBlufGame_NextQuestion();
			break;
		case main_region_BlindMansBlufGame_BlindMansBlufGame_firstQ:
			exitSequence_main_region_BlindMansBlufGame_BlindMansBlufGame_firstQ();
			break;
		case main_region_BlindMansBlufGame_BlindMansBlufGame_wait:
			exitSequence_main_region_BlindMansBlufGame_BlindMansBlufGame_wait();
			break;
		case main_region_BlindMansBlufGame_BlindMansBlufGame_Repeat:
			exitSequence_main_region_BlindMansBlufGame_BlindMansBlufGame_Repeat();
			break;
		case main_region_LeaveTheRoom:
			exitSequence_main_region_LeaveTheRoom();
			break;
		case main_region__final_:
			exitSequence_main_region__final_();
			break;
		case main_region_DetectionOn:
			exitSequence_main_region_DetectionOn();
			break;
		case main_region_waitForMarc:
			exitSequence_main_region_waitForMarc();
			break;
		default:
			break;
		}
		
		switch (stateVector[1]) {
		case main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_Kinect2_WaitForNoise:
			exitSequence_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_Kinect2_WaitForNoise();
			break;
		case main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_Kinect2_Turn:
			exitSequence_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_Kinect2_Turn();
			break;
		case main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_Kinect2_endNoise:
			exitSequence_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_Kinect2_endNoise();
			break;
		default:
			break;
		}
	}
	
	/* Default exit sequence for region RiddleGame */
	private void exitSequence_main_region_RiddleGame_RiddleGame() {
		switch (stateVector[0]) {
		case main_region_RiddleGame_RiddleGame_StartGame:
			exitSequence_main_region_RiddleGame_RiddleGame_StartGame();
			break;
		case main_region_RiddleGame_RiddleGame_WaitForOperator:
			exitSequence_main_region_RiddleGame_RiddleGame_WaitForOperator();
			break;
		case main_region_RiddleGame_RiddleGame_Hello:
			exitSequence_main_region_RiddleGame_RiddleGame_Hello();
			break;
		case main_region_RiddleGame_RiddleGame_Leave_the_arena:
			exitSequence_main_region_RiddleGame_RiddleGame_Leave_the_arena();
			break;
		case main_region_RiddleGame_RiddleGame_TellAnswer:
			exitSequence_main_region_RiddleGame_RiddleGame_TellAnswer();
			break;
		case main_region_RiddleGame_RiddleGame_PrepareForNextQuestion:
			exitSequence_main_region_RiddleGame_RiddleGame_PrepareForNextQuestion();
			break;
		case main_region_RiddleGame_RiddleGame_TellIncomprehensible:
			exitSequence_main_region_RiddleGame_RiddleGame_TellIncomprehensible();
			break;
		case main_region_RiddleGame_RiddleGame_NextQuestion:
			exitSequence_main_region_RiddleGame_RiddleGame_NextQuestion();
			break;
		case main_region_RiddleGame_RiddleGame_TellAction_Instructions_RiddleGame_GoTo:
			exitSequence_main_region_RiddleGame_RiddleGame_TellAction_Instructions_RiddleGame_GoTo();
			exitAction_main_region_RiddleGame_RiddleGame_TellAction();
			break;
		case main_region_RiddleGame_RiddleGame_TellAction_Instructions_RiddleGame_surrounding:
			exitSequence_main_region_RiddleGame_RiddleGame_TellAction_Instructions_RiddleGame_surrounding();
			exitAction_main_region_RiddleGame_RiddleGame_TellAction();
			break;
		case main_region_RiddleGame_RiddleGame_TellAction_Instructions_RiddleGame_bring:
			exitSequence_main_region_RiddleGame_RiddleGame_TellAction_Instructions_RiddleGame_bring();
			exitAction_main_region_RiddleGame_RiddleGame_TellAction();
			break;
		case main_region_RiddleGame_RiddleGame_TellAction_Instructions_RiddleGame_open:
			exitSequence_main_region_RiddleGame_RiddleGame_TellAction_Instructions_RiddleGame_open();
			exitAction_main_region_RiddleGame_RiddleGame_TellAction();
			break;
		case main_region_RiddleGame_RiddleGame_TellAction_Instructions_RiddleGame_followme:
			exitSequence_main_region_RiddleGame_RiddleGame_TellAction_Instructions_RiddleGame_followme();
			exitAction_main_region_RiddleGame_RiddleGame_TellAction();
			break;
		case main_region_RiddleGame_RiddleGame_TellAction_Instructions_RiddleGame_unknown:
			exitSequence_main_region_RiddleGame_RiddleGame_TellAction_Instructions_RiddleGame_unknown();
			exitAction_main_region_RiddleGame_RiddleGame_TellAction();
			break;
		case main_region_RiddleGame_RiddleGame_TellAction_Instructions_RiddleGame_crowd:
			exitSequence_main_region_RiddleGame_RiddleGame_TellAction_Instructions_RiddleGame_crowd();
			exitAction_main_region_RiddleGame_RiddleGame_TellAction();
			break;
		case main_region_RiddleGame_RiddleGame_Scit0s_STT_RiddleGame_StartSTT:
			exitSequence_main_region_RiddleGame_RiddleGame_Scit0s_STT_RiddleGame_StartSTT();
			break;
		case main_region_RiddleGame_RiddleGame_Scit0s_STT_RiddleGame_TellSpokenText:
			exitSequence_main_region_RiddleGame_RiddleGame_Scit0s_STT_RiddleGame_TellSpokenText();
			break;
		default:
			break;
		}
	}
	
	/* Default exit sequence for region Instructions RiddleGame */
	private void exitSequence_main_region_RiddleGame_RiddleGame_TellAction_Instructions_RiddleGame() {
		switch (stateVector[0]) {
		case main_region_RiddleGame_RiddleGame_TellAction_Instructions_RiddleGame_GoTo:
			exitSequence_main_region_RiddleGame_RiddleGame_TellAction_Instructions_RiddleGame_GoTo();
			break;
		case main_region_RiddleGame_RiddleGame_TellAction_Instructions_RiddleGame_surrounding:
			exitSequence_main_region_RiddleGame_RiddleGame_TellAction_Instructions_RiddleGame_surrounding();
			break;
		case main_region_RiddleGame_RiddleGame_TellAction_Instructions_RiddleGame_bring:
			exitSequence_main_region_RiddleGame_RiddleGame_TellAction_Instructions_RiddleGame_bring();
			break;
		case main_region_RiddleGame_RiddleGame_TellAction_Instructions_RiddleGame_open:
			exitSequence_main_region_RiddleGame_RiddleGame_TellAction_Instructions_RiddleGame_open();
			break;
		case main_region_RiddleGame_RiddleGame_TellAction_Instructions_RiddleGame_followme:
			exitSequence_main_region_RiddleGame_RiddleGame_TellAction_Instructions_RiddleGame_followme();
			break;
		case main_region_RiddleGame_RiddleGame_TellAction_Instructions_RiddleGame_unknown:
			exitSequence_main_region_RiddleGame_RiddleGame_TellAction_Instructions_RiddleGame_unknown();
			break;
		case main_region_RiddleGame_RiddleGame_TellAction_Instructions_RiddleGame_crowd:
			exitSequence_main_region_RiddleGame_RiddleGame_TellAction_Instructions_RiddleGame_crowd();
			break;
		default:
			break;
		}
	}
	
	/* Default exit sequence for region STT RiddleGame */
	private void exitSequence_main_region_RiddleGame_RiddleGame_Scit0s_STT_RiddleGame() {
		switch (stateVector[0]) {
		case main_region_RiddleGame_RiddleGame_Scit0s_STT_RiddleGame_StartSTT:
			exitSequence_main_region_RiddleGame_RiddleGame_Scit0s_STT_RiddleGame_StartSTT();
			break;
		case main_region_RiddleGame_RiddleGame_Scit0s_STT_RiddleGame_TellSpokenText:
			exitSequence_main_region_RiddleGame_RiddleGame_Scit0s_STT_RiddleGame_TellSpokenText();
			break;
		default:
			break;
		}
	}
	
	/* Default exit sequence for region BlindMansBlufGame */
	private void exitSequence_main_region_BlindMansBlufGame_BlindMansBlufGame() {
		switch (stateVector[0]) {
		case main_region_BlindMansBlufGame_BlindMansBlufGame_StartGame:
			exitSequence_main_region_BlindMansBlufGame_BlindMansBlufGame_StartGame();
			break;
		case main_region_BlindMansBlufGame_BlindMansBlufGame_StartSTT:
			exitSequence_main_region_BlindMansBlufGame_BlindMansBlufGame_StartSTT();
			break;
		case main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_waitForSTT:
			exitSequence_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_waitForSTT();
			break;
		case main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAnswer:
			exitSequence_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAnswer();
			break;
		case main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_GoTo:
			exitSequence_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_GoTo();
			break;
		case main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_surrounding:
			exitSequence_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_surrounding();
			break;
		case main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_bring:
			exitSequence_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_bring();
			break;
		case main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_open:
			exitSequence_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_open();
			break;
		case main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_followme:
			exitSequence_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_followme();
			break;
		case main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_unknown:
			exitSequence_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_unknown();
			break;
		case main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_Copy_1_crowd:
			exitSequence_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_Copy_1_crowd();
			break;
		case main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellIncomprehensible:
			exitSequence_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellIncomprehensible();
			break;
		case main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_StopSTT2:
			exitSequence_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_StopSTT2();
			break;
		case main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_getSpokenText:
			exitSequence_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_getSpokenText();
			break;
		case main_region_BlindMansBlufGame_BlindMansBlufGame_allQuestionsDone:
			exitSequence_main_region_BlindMansBlufGame_BlindMansBlufGame_allQuestionsDone();
			break;
		case main_region_BlindMansBlufGame_BlindMansBlufGame_NoRepeat:
			exitSequence_main_region_BlindMansBlufGame_BlindMansBlufGame_NoRepeat();
			break;
		case main_region_BlindMansBlufGame_BlindMansBlufGame_Turn:
			exitSequence_main_region_BlindMansBlufGame_BlindMansBlufGame_Turn();
			break;
		case main_region_BlindMansBlufGame_BlindMansBlufGame_NextQuestion:
			exitSequence_main_region_BlindMansBlufGame_BlindMansBlufGame_NextQuestion();
			break;
		case main_region_BlindMansBlufGame_BlindMansBlufGame_firstQ:
			exitSequence_main_region_BlindMansBlufGame_BlindMansBlufGame_firstQ();
			break;
		case main_region_BlindMansBlufGame_BlindMansBlufGame_wait:
			exitSequence_main_region_BlindMansBlufGame_BlindMansBlufGame_wait();
			break;
		case main_region_BlindMansBlufGame_BlindMansBlufGame_Repeat:
			exitSequence_main_region_BlindMansBlufGame_BlindMansBlufGame_Repeat();
			break;
		default:
			break;
		}
		
		switch (stateVector[1]) {
		case main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_Kinect2_WaitForNoise:
			exitSequence_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_Kinect2_WaitForNoise();
			break;
		case main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_Kinect2_Turn:
			exitSequence_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_Kinect2_Turn();
			break;
		case main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_Kinect2_endNoise:
			exitSequence_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_Kinect2_endNoise();
			break;
		default:
			break;
		}
	}
	
	/* Default exit sequence for region STT */
	private void exitSequence_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT() {
		switch (stateVector[0]) {
		case main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_waitForSTT:
			exitSequence_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_waitForSTT();
			break;
		case main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAnswer:
			exitSequence_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAnswer();
			break;
		case main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_GoTo:
			exitSequence_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_GoTo();
			break;
		case main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_surrounding:
			exitSequence_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_surrounding();
			break;
		case main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_bring:
			exitSequence_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_bring();
			break;
		case main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_open:
			exitSequence_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_open();
			break;
		case main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_followme:
			exitSequence_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_followme();
			break;
		case main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_unknown:
			exitSequence_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_unknown();
			break;
		case main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_Copy_1_crowd:
			exitSequence_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_Copy_1_crowd();
			break;
		case main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellIncomprehensible:
			exitSequence_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellIncomprehensible();
			break;
		case main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_StopSTT2:
			exitSequence_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_StopSTT2();
			break;
		case main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_getSpokenText:
			exitSequence_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_getSpokenText();
			break;
		default:
			break;
		}
	}
	
	/* Default exit sequence for region Instructions BlindMansBlufGame */
	private void exitSequence_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame() {
		switch (stateVector[0]) {
		case main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_GoTo:
			exitSequence_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_GoTo();
			break;
		case main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_surrounding:
			exitSequence_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_surrounding();
			break;
		case main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_bring:
			exitSequence_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_bring();
			break;
		case main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_open:
			exitSequence_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_open();
			break;
		case main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_followme:
			exitSequence_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_followme();
			break;
		case main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_unknown:
			exitSequence_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_unknown();
			break;
		case main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_Copy_1_crowd:
			exitSequence_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_Copy_1_crowd();
			break;
		default:
			break;
		}
	}
	
	/* Default exit sequence for region Kinect2 */
	private void exitSequence_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_Kinect2() {
		switch (stateVector[1]) {
		case main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_Kinect2_WaitForNoise:
			exitSequence_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_Kinect2_WaitForNoise();
			break;
		case main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_Kinect2_Turn:
			exitSequence_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_Kinect2_Turn();
			break;
		case main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_Kinect2_endNoise:
			exitSequence_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_Kinect2_endNoise();
			break;
		default:
			break;
		}
	}
	
	/* Default exit sequence for region Leonie Bupered Or Emergency Stop */
	private void exitSequence_Leonie_Bupered_Or_Emergency_Stop() {
		switch (stateVector[2]) {
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
	private void react_main_region_Init() {
		effect_main_region_Init_tr0();
	}
	
	/* The reactions of state Announcement. */
	private void react_main_region_Announcement() {
		if (check_main_region_Announcement_tr0_tr0()) {
			effect_main_region_Announcement_tr0();
		} else {
			if (check_main_region_Announcement_tr1_tr1()) {
				effect_main_region_Announcement_tr1();
			}
		}
	}
	
	/* The reactions of state Wait. */
	private void react_main_region_Wait() {
		if (check_main_region_Wait_tr0_tr0()) {
			effect_main_region_Wait_tr0();
		}
	}
	
	/* The reactions of state TurnAround. */
	private void react_main_region_TurnAround() {
		if (check_main_region_TurnAround_tr0_tr0()) {
			effect_main_region_TurnAround_tr0();
		}
	}
	
	/* The reactions of state CrowdScanningAndCounting. */
	private void react_main_region_CrowdScanningAndCounting() {
		if (check_main_region_CrowdScanningAndCounting_tr0_tr0()) {
			effect_main_region_CrowdScanningAndCounting_tr0();
		} else {
			if (check_main_region_CrowdScanningAndCounting_tr1_tr1()) {
				effect_main_region_CrowdScanningAndCounting_tr1();
			}
		}
	}
	
	/* The reactions of state StartGame. */
	private void react_main_region_RiddleGame_RiddleGame_StartGame() {
		if (check_main_region_RiddleGame_RiddleGame_StartGame_tr0_tr0()) {
			effect_main_region_RiddleGame_RiddleGame_StartGame_tr0();
		} else {
			if (check_main_region_RiddleGame_RiddleGame_StartGame_tr1_tr1()) {
				effect_main_region_RiddleGame_RiddleGame_StartGame_tr1();
			}
		}
	}
	
	/* The reactions of state WaitForOperator. */
	private void react_main_region_RiddleGame_RiddleGame_WaitForOperator() {
		if (check_main_region_RiddleGame_RiddleGame_WaitForOperator_tr0_tr0()) {
			effect_main_region_RiddleGame_RiddleGame_WaitForOperator_tr0();
		}
	}
	
	/* The reactions of state Hello. */
	private void react_main_region_RiddleGame_RiddleGame_Hello() {
		if (check_main_region_RiddleGame_RiddleGame_Hello_tr0_tr0()) {
			effect_main_region_RiddleGame_RiddleGame_Hello_tr0();
		} else {
			if (check_main_region_RiddleGame_RiddleGame_Hello_tr1_tr1()) {
				effect_main_region_RiddleGame_RiddleGame_Hello_tr1();
			}
		}
	}
	
	/* The reactions of state Leave the arena. */
	private void react_main_region_RiddleGame_RiddleGame_Leave_the_arena() {
		if (check_main_region_RiddleGame_RiddleGame_Leave_the_arena_tr0_tr0()) {
			effect_main_region_RiddleGame_RiddleGame_Leave_the_arena_tr0();
		} else {
			if (check_main_region_RiddleGame_RiddleGame_Leave_the_arena_tr1_tr1()) {
				effect_main_region_RiddleGame_RiddleGame_Leave_the_arena_tr1();
			}
		}
	}
	
	/* The reactions of state TellAnswer. */
	private void react_main_region_RiddleGame_RiddleGame_TellAnswer() {
		if (check_main_region_RiddleGame_RiddleGame_TellAnswer_tr0_tr0()) {
			effect_main_region_RiddleGame_RiddleGame_TellAnswer_tr0();
		} else {
			if (check_main_region_RiddleGame_RiddleGame_TellAnswer_tr1_tr1()) {
				effect_main_region_RiddleGame_RiddleGame_TellAnswer_tr1();
			}
		}
	}
	
	/* The reactions of state PrepareForNextQuestion. */
	private void react_main_region_RiddleGame_RiddleGame_PrepareForNextQuestion() {
		effect_main_region_RiddleGame_RiddleGame_PrepareForNextQuestion_tr0();
	}
	
	/* The reactions of state TellIncomprehensible. */
	private void react_main_region_RiddleGame_RiddleGame_TellIncomprehensible() {
		if (check_main_region_RiddleGame_RiddleGame_TellIncomprehensible_tr0_tr0()) {
			effect_main_region_RiddleGame_RiddleGame_TellIncomprehensible_tr0();
		} else {
			if (check_main_region_RiddleGame_RiddleGame_TellIncomprehensible_tr1_tr1()) {
				effect_main_region_RiddleGame_RiddleGame_TellIncomprehensible_tr1();
			}
		}
	}
	
	/* The reactions of state NextQuestion. */
	private void react_main_region_RiddleGame_RiddleGame_NextQuestion() {
		if (check_main_region_RiddleGame_RiddleGame_NextQuestion_tr0_tr0()) {
			effect_main_region_RiddleGame_RiddleGame_NextQuestion_tr0();
		} else {
			if (check_main_region_RiddleGame_RiddleGame_NextQuestion_tr1_tr1()) {
				effect_main_region_RiddleGame_RiddleGame_NextQuestion_tr1();
			}
		}
	}
	
	/* The reactions of state GoTo. */
	private void react_main_region_RiddleGame_RiddleGame_TellAction_Instructions_RiddleGame_GoTo() {
		if (check_main_region_RiddleGame_RiddleGame_TellAction_tr1_tr1()) {
			effect_main_region_RiddleGame_RiddleGame_TellAction_tr1();
		} else {
			if (check_main_region_RiddleGame_RiddleGame_TellAction_Instructions_RiddleGame_GoTo_tr0_tr0()) {
				effect_main_region_RiddleGame_RiddleGame_TellAction_Instructions_RiddleGame_GoTo_tr0();
			}
		}
	}
	
	/* The reactions of state surrounding. */
	private void react_main_region_RiddleGame_RiddleGame_TellAction_Instructions_RiddleGame_surrounding() {
		if (check_main_region_RiddleGame_RiddleGame_TellAction_tr1_tr1()) {
			effect_main_region_RiddleGame_RiddleGame_TellAction_tr1();
		} else {
		}
	}
	
	/* The reactions of state bring. */
	private void react_main_region_RiddleGame_RiddleGame_TellAction_Instructions_RiddleGame_bring() {
		if (check_main_region_RiddleGame_RiddleGame_TellAction_tr1_tr1()) {
			effect_main_region_RiddleGame_RiddleGame_TellAction_tr1();
		} else {
			if (check_main_region_RiddleGame_RiddleGame_TellAction_Instructions_RiddleGame_bring_tr0_tr0()) {
				effect_main_region_RiddleGame_RiddleGame_TellAction_Instructions_RiddleGame_bring_tr0();
			}
		}
	}
	
	/* The reactions of state open. */
	private void react_main_region_RiddleGame_RiddleGame_TellAction_Instructions_RiddleGame_open() {
		if (check_main_region_RiddleGame_RiddleGame_TellAction_tr1_tr1()) {
			effect_main_region_RiddleGame_RiddleGame_TellAction_tr1();
		} else {
			if (check_main_region_RiddleGame_RiddleGame_TellAction_Instructions_RiddleGame_open_tr0_tr0()) {
				effect_main_region_RiddleGame_RiddleGame_TellAction_Instructions_RiddleGame_open_tr0();
			}
		}
	}
	
	/* The reactions of state followme. */
	private void react_main_region_RiddleGame_RiddleGame_TellAction_Instructions_RiddleGame_followme() {
		if (check_main_region_RiddleGame_RiddleGame_TellAction_tr1_tr1()) {
			effect_main_region_RiddleGame_RiddleGame_TellAction_tr1();
		} else {
			if (check_main_region_RiddleGame_RiddleGame_TellAction_Instructions_RiddleGame_followme_tr0_tr0()) {
				effect_main_region_RiddleGame_RiddleGame_TellAction_Instructions_RiddleGame_followme_tr0();
			}
		}
	}
	
	/* The reactions of state unknown. */
	private void react_main_region_RiddleGame_RiddleGame_TellAction_Instructions_RiddleGame_unknown() {
		if (check_main_region_RiddleGame_RiddleGame_TellAction_tr1_tr1()) {
			effect_main_region_RiddleGame_RiddleGame_TellAction_tr1();
		} else {
			if (check_main_region_RiddleGame_RiddleGame_TellAction_Instructions_RiddleGame_unknown_tr0_tr0()) {
				effect_main_region_RiddleGame_RiddleGame_TellAction_Instructions_RiddleGame_unknown_tr0();
			}
		}
	}
	
	/* The reactions of state crowd. */
	private void react_main_region_RiddleGame_RiddleGame_TellAction_Instructions_RiddleGame_crowd() {
		if (check_main_region_RiddleGame_RiddleGame_TellAction_tr1_tr1()) {
			effect_main_region_RiddleGame_RiddleGame_TellAction_tr1();
		} else {
			if (check_main_region_RiddleGame_RiddleGame_TellAction_Instructions_RiddleGame_crowd_tr0_tr0()) {
				effect_main_region_RiddleGame_RiddleGame_TellAction_Instructions_RiddleGame_crowd_tr0();
			}
		}
	}
	
	/* The reactions of state StartSTT. */
	private void react_main_region_RiddleGame_RiddleGame_Scit0s_STT_RiddleGame_StartSTT() {
		if (check_main_region_RiddleGame_RiddleGame_Scit0s_STT_RiddleGame_StartSTT_tr0_tr0()) {
			effect_main_region_RiddleGame_RiddleGame_Scit0s_STT_RiddleGame_StartSTT_tr0();
		} else {
			if (check_main_region_RiddleGame_RiddleGame_Scit0s_STT_RiddleGame_StartSTT_tr1_tr1()) {
				effect_main_region_RiddleGame_RiddleGame_Scit0s_STT_RiddleGame_StartSTT_tr1();
			}
		}
	}
	
	/* The reactions of state TellSpokenText. */
	private void react_main_region_RiddleGame_RiddleGame_Scit0s_STT_RiddleGame_TellSpokenText() {
		if (check_main_region_RiddleGame_RiddleGame_Scit0s_STT_RiddleGame_TellSpokenText_tr0_tr0()) {
			effect_main_region_RiddleGame_RiddleGame_Scit0s_STT_RiddleGame_TellSpokenText_tr0();
		} else {
			if (check_main_region_RiddleGame_RiddleGame_Scit0s_STT_RiddleGame_TellSpokenText_tr1_tr1()) {
				effect_main_region_RiddleGame_RiddleGame_Scit0s_STT_RiddleGame_TellSpokenText_tr1();
			} else {
				if (check_main_region_RiddleGame_RiddleGame_Scit0s_STT_RiddleGame_TellSpokenText_tr2_tr2()) {
					effect_main_region_RiddleGame_RiddleGame_Scit0s_STT_RiddleGame_TellSpokenText_tr2();
				} else {
					if (check_main_region_RiddleGame_RiddleGame_Scit0s_STT_RiddleGame_TellSpokenText_tr3_tr3()) {
						effect_main_region_RiddleGame_RiddleGame_Scit0s_STT_RiddleGame_TellSpokenText_tr3();
					}
				}
			}
		}
	}
	
	/* The reactions of state StartGame. */
	private void react_main_region_BlindMansBlufGame_BlindMansBlufGame_StartGame() {
		if (check_main_region_BlindMansBlufGame_BlindMansBlufGame_StartGame_tr0_tr0()) {
			effect_main_region_BlindMansBlufGame_BlindMansBlufGame_StartGame_tr0();
		} else {
			if (check_main_region_BlindMansBlufGame_BlindMansBlufGame_StartGame_tr1_tr1()) {
				effect_main_region_BlindMansBlufGame_BlindMansBlufGame_StartGame_tr1();
			}
		}
	}
	
	/* The reactions of state StartSTT. */
	private void react_main_region_BlindMansBlufGame_BlindMansBlufGame_StartSTT() {
		effect_main_region_BlindMansBlufGame_BlindMansBlufGame_StartSTT_tr0();
	}
	
	/* The reactions of state waitForSTT. */
	private void react_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_waitForSTT() {
		if (check_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_waitForSTT_tr0_tr0()) {
			effect_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_waitForSTT_tr0();
		}
	}
	
	/* The reactions of state TellAnswer. */
	private void react_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAnswer() {
		if (check_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAnswer_tr0_tr0()) {
			effect_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAnswer_tr0();
		}
	}
	
	/* The reactions of state GoTo. */
	private void react_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_GoTo() {
		if (check_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_tr0_tr0()) {
			effect_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_tr0();
		} else {
			if (check_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_GoTo_tr0_tr0()) {
				effect_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_GoTo_tr0();
			}
		}
	}
	
	/* The reactions of state surrounding. */
	private void react_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_surrounding() {
		if (check_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_tr0_tr0()) {
			effect_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_tr0();
		} else {
		}
	}
	
	/* The reactions of state bring. */
	private void react_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_bring() {
		if (check_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_tr0_tr0()) {
			effect_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_tr0();
		} else {
			if (check_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_bring_tr0_tr0()) {
				effect_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_bring_tr0();
			}
		}
	}
	
	/* The reactions of state open. */
	private void react_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_open() {
		if (check_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_tr0_tr0()) {
			effect_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_tr0();
		} else {
			if (check_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_open_tr0_tr0()) {
				effect_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_open_tr0();
			}
		}
	}
	
	/* The reactions of state followme. */
	private void react_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_followme() {
		if (check_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_tr0_tr0()) {
			effect_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_tr0();
		} else {
			if (check_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_followme_tr0_tr0()) {
				effect_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_followme_tr0();
			}
		}
	}
	
	/* The reactions of state unknown. */
	private void react_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_unknown() {
		if (check_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_tr0_tr0()) {
			effect_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_tr0();
		} else {
			if (check_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_unknown_tr0_tr0()) {
				effect_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_unknown_tr0();
			}
		}
	}
	
	/* The reactions of state Copy_1_crowd. */
	private void react_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_Copy_1_crowd() {
		if (check_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_tr0_tr0()) {
			effect_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_tr0();
		} else {
			if (check_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_Copy_1_crowd_tr0_tr0()) {
				effect_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_Copy_1_crowd_tr0();
			}
		}
	}
	
	/* The reactions of state TellIncomprehensible. */
	private void react_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellIncomprehensible() {
		if (check_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellIncomprehensible_tr0_tr0()) {
			effect_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellIncomprehensible_tr0();
		}
	}
	
	/* The reactions of state StopSTT2. */
	private void react_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_StopSTT2() {
		if (check_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_StopSTT2_tr0_SpeechAndPersonRecognition_main_region_BlindMansBlufGame_BlindMansBlufGame__sync1join_check()) {
			effect_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_StopSTT2_tr0();
		}
	}
	
	/* The reactions of state getSpokenText. */
	private void react_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_getSpokenText() {
		if (check_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_getSpokenText_tr0_tr0()) {
			effect_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_getSpokenText_tr0();
		} else {
			if (check_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_getSpokenText_tr1_tr1()) {
				effect_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_getSpokenText_tr1();
			} else {
				if (check_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_getSpokenText_tr2_tr2()) {
					effect_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_getSpokenText_tr2();
				}
			}
		}
	}
	
	/* The reactions of state WaitForNoise. */
	private void react_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_Kinect2_WaitForNoise() {
		if (check_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_Kinect2_WaitForNoise_tr0_tr0()) {
			effect_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_Kinect2_WaitForNoise_tr0();
		} else {
			if (check_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_Kinect2_WaitForNoise_tr1_tr1()) {
				effect_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_Kinect2_WaitForNoise_tr1();
			} else {
				if (check_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_Kinect2_WaitForNoise_tr2_tr2()) {
					effect_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_Kinect2_WaitForNoise_tr2();
				}
			}
		}
	}
	
	/* The reactions of state Turn. */
	private void react_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_Kinect2_Turn() {
		if (check_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_Kinect2_Turn_tr0_tr0()) {
			effect_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_Kinect2_Turn_tr0();
		} else {
			if (check_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_Kinect2_Turn_tr1_tr1()) {
				effect_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_Kinect2_Turn_tr1();
			}
		}
	}
	
	/* The reactions of state endNoise. */
	private void react_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_Kinect2_endNoise() {
		if (check_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_Kinect2_endNoise_tr0_SpeechAndPersonRecognition_main_region_BlindMansBlufGame_BlindMansBlufGame__sync1join_check()) {
			effect_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_Kinect2_endNoise_tr0();
		}
	}
	
	/* The reactions of state allQuestionsDone. */
	private void react_main_region_BlindMansBlufGame_BlindMansBlufGame_allQuestionsDone() {
		if (check_main_region_BlindMansBlufGame_BlindMansBlufGame_allQuestionsDone_tr0_tr0()) {
			effect_main_region_BlindMansBlufGame_BlindMansBlufGame_allQuestionsDone_tr0();
		}
	}
	
	/* The reactions of state NoRepeat. */
	private void react_main_region_BlindMansBlufGame_BlindMansBlufGame_NoRepeat() {
		if (check_main_region_BlindMansBlufGame_BlindMansBlufGame_NoRepeat_tr0_tr0()) {
			effect_main_region_BlindMansBlufGame_BlindMansBlufGame_NoRepeat_tr0();
		}
	}
	
	/* The reactions of state Turn. */
	private void react_main_region_BlindMansBlufGame_BlindMansBlufGame_Turn() {
		if (check_main_region_BlindMansBlufGame_BlindMansBlufGame_Turn_tr0_tr0()) {
			effect_main_region_BlindMansBlufGame_BlindMansBlufGame_Turn_tr0();
		}
	}
	
	/* The reactions of state NextQuestion. */
	private void react_main_region_BlindMansBlufGame_BlindMansBlufGame_NextQuestion() {
		effect_main_region_BlindMansBlufGame_BlindMansBlufGame_NextQuestion_tr0();
	}
	
	/* The reactions of state firstQ. */
	private void react_main_region_BlindMansBlufGame_BlindMansBlufGame_firstQ() {
		if (check_main_region_BlindMansBlufGame_BlindMansBlufGame_firstQ_tr0_tr0()) {
			effect_main_region_BlindMansBlufGame_BlindMansBlufGame_firstQ_tr0();
		} else {
			if (check_main_region_BlindMansBlufGame_BlindMansBlufGame_firstQ_tr1_tr1()) {
				effect_main_region_BlindMansBlufGame_BlindMansBlufGame_firstQ_tr1();
			}
		}
	}
	
	/* The reactions of state wait. */
	private void react_main_region_BlindMansBlufGame_BlindMansBlufGame_wait() {
		if (check_main_region_BlindMansBlufGame_BlindMansBlufGame_wait_tr0_tr0()) {
			effect_main_region_BlindMansBlufGame_BlindMansBlufGame_wait_tr0();
		}
	}
	
	/* The reactions of state Repeat. */
	private void react_main_region_BlindMansBlufGame_BlindMansBlufGame_Repeat() {
		effect_main_region_BlindMansBlufGame_BlindMansBlufGame_Repeat_tr0();
	}
	
	/* The reactions of state LeaveTheRoom. */
	private void react_main_region_LeaveTheRoom() {
		if (check_main_region_LeaveTheRoom_tr0_tr0()) {
			effect_main_region_LeaveTheRoom_tr0();
		}
	}
	
	/* The reactions of state null. */
	private void react_main_region__final_() {
	}
	
	/* The reactions of state DetectionOn. */
	private void react_main_region_DetectionOn() {
		if (check_main_region_DetectionOn_tr0_tr0()) {
			effect_main_region_DetectionOn_tr0();
		}
	}
	
	/* The reactions of state waitForMarc. */
	private void react_main_region_waitForMarc() {
		if (check_main_region_waitForMarc_tr0_tr0()) {
			effect_main_region_waitForMarc_tr0();
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
	private void react_main_region_RiddleGame_RiddleGame__choice_0() {
		if (check_main_region_RiddleGame_RiddleGame__choice_0_tr1_tr1()) {
			effect_main_region_RiddleGame_RiddleGame__choice_0_tr1();
		} else {
			effect_main_region_RiddleGame_RiddleGame__choice_0_tr0();
		}
	}
	
	/* The reactions of state null. */
	private void react_main_region_RiddleGame_RiddleGame_TellAction_Instructions_RiddleGame__choice_0() {
		if (check_main_region_RiddleGame_RiddleGame_TellAction_Instructions_RiddleGame__choice_0_tr0_tr0()) {
			effect_main_region_RiddleGame_RiddleGame_TellAction_Instructions_RiddleGame__choice_0_tr0();
		} else {
			if (check_main_region_RiddleGame_RiddleGame_TellAction_Instructions_RiddleGame__choice_0_tr1_tr1()) {
				effect_main_region_RiddleGame_RiddleGame_TellAction_Instructions_RiddleGame__choice_0_tr1();
			} else {
				if (check_main_region_RiddleGame_RiddleGame_TellAction_Instructions_RiddleGame__choice_0_tr2_tr2()) {
					effect_main_region_RiddleGame_RiddleGame_TellAction_Instructions_RiddleGame__choice_0_tr2();
				} else {
					if (check_main_region_RiddleGame_RiddleGame_TellAction_Instructions_RiddleGame__choice_0_tr3_tr3()) {
						effect_main_region_RiddleGame_RiddleGame_TellAction_Instructions_RiddleGame__choice_0_tr3();
					} else {
						if (check_main_region_RiddleGame_RiddleGame_TellAction_Instructions_RiddleGame__choice_0_tr4_tr4()) {
							effect_main_region_RiddleGame_RiddleGame_TellAction_Instructions_RiddleGame__choice_0_tr4();
						} else {
							if (check_main_region_RiddleGame_RiddleGame_TellAction_Instructions_RiddleGame__choice_0_tr5_tr5()) {
								effect_main_region_RiddleGame_RiddleGame_TellAction_Instructions_RiddleGame__choice_0_tr5();
							} else {
								effect_main_region_RiddleGame_RiddleGame_TellAction_Instructions_RiddleGame__choice_0_tr6();
							}
						}
					}
				}
			}
		}
	}
	
	/* The reactions of state null. */
	private void react_main_region_RiddleGame_RiddleGame_Scit0s_STT_RiddleGame__choice_0() {
		if (check_main_region_RiddleGame_RiddleGame_Scit0s_STT_RiddleGame__choice_0_tr1_tr1()) {
			effect_main_region_RiddleGame_RiddleGame_Scit0s_STT_RiddleGame__choice_0_tr1();
		} else {
			effect_main_region_RiddleGame_RiddleGame_Scit0s_STT_RiddleGame__choice_0_tr0();
		}
	}
	
	/* The reactions of state null. */
	private void react_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame__choice_0() {
		if (check_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame__choice_0_tr0_tr0()) {
			effect_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame__choice_0_tr0();
		} else {
			if (check_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame__choice_0_tr1_tr1()) {
				effect_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame__choice_0_tr1();
			} else {
				if (check_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame__choice_0_tr2_tr2()) {
					effect_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame__choice_0_tr2();
				} else {
					if (check_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame__choice_0_tr3_tr3()) {
						effect_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame__choice_0_tr3();
					} else {
						if (check_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame__choice_0_tr4_tr4()) {
							effect_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame__choice_0_tr4();
						} else {
							if (check_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame__choice_0_tr5_tr5()) {
								effect_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame__choice_0_tr5();
							} else {
								effect_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame__choice_0_tr6();
							}
						}
					}
				}
			}
		}
	}
	
	/* The reactions of state null. */
	private void react_main_region_BlindMansBlufGame_BlindMansBlufGame__choice_0() {
		if (check_main_region_BlindMansBlufGame_BlindMansBlufGame__choice_0_tr0_tr0()) {
			effect_main_region_BlindMansBlufGame_BlindMansBlufGame__choice_0_tr0();
		} else {
			effect_main_region_BlindMansBlufGame_BlindMansBlufGame__choice_0_tr1();
		}
	}
	
	/* The reactions of state null. */
	private void react_main_region_BlindMansBlufGame_BlindMansBlufGame__choice_1() {
		if (check_main_region_BlindMansBlufGame_BlindMansBlufGame__choice_1_tr0_tr0()) {
			effect_main_region_BlindMansBlufGame_BlindMansBlufGame__choice_1_tr0();
		} else {
			if (check_main_region_BlindMansBlufGame_BlindMansBlufGame__choice_1_tr1_tr1()) {
				effect_main_region_BlindMansBlufGame_BlindMansBlufGame__choice_1_tr1();
			} else {
				effect_main_region_BlindMansBlufGame_BlindMansBlufGame__choice_1_tr2();
			}
		}
	}
	
	/* The reactions of state null. */
	private void react_main_region_BlindMansBlufGame_BlindMansBlufGame__choice_2() {
		effect_main_region_BlindMansBlufGame_BlindMansBlufGame__choice_2_tr0();
	}
	
	/* Default react sequence for initial entry  */
	private void react_main_region__entry_Default() {
		enterSequence_main_region_Init_default();
	}
	
	/* Default react sequence for initial entry  */
	private void react_main_region_RiddleGame_RiddleGame__entry_Default() {
		enterSequence_main_region_RiddleGame_RiddleGame_StartGame_default();
	}
	
	/* Default react sequence for initial entry  */
	private void react_main_region_RiddleGame_RiddleGame_TellAction_Instructions_RiddleGame__entry_Default() {
		react_main_region_RiddleGame_RiddleGame_TellAction_Instructions_RiddleGame__choice_0();
	}
	
	/* Default react sequence for initial entry  */
	private void react_main_region_RiddleGame_RiddleGame_TellAction_Instructions_RiddleGame_surrounding_surrounding_RiddleGame__entry_Default() {
		react_main_region_RiddleGame_RiddleGame_TellAction_Instructions_RiddleGame_surrounding_surrounding_RiddleGame_exit_done();
	}
	
	/* Default react sequence for initial entry  */
	private void react_main_region_RiddleGame_RiddleGame_Scit0s_STT_RiddleGame__entry_Default() {
		enterSequence_main_region_RiddleGame_RiddleGame_Scit0s_STT_RiddleGame_StartSTT_default();
	}
	
	/* Default react sequence for initial entry  */
	private void react_main_region_BlindMansBlufGame_BlindMansBlufGame__entry_Default() {
		enterSequence_main_region_BlindMansBlufGame_BlindMansBlufGame_StartGame_default();
	}
	
	/* Default react sequence for initial entry  */
	private void react_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame__entry_Default() {
		react_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame__choice_0();
	}
	
	/* Default react sequence for initial entry  */
	private void react_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_surrounding_surrounding_BlindMansBlufGame__entry_Default() {
		react_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_surrounding_surrounding_BlindMansBlufGame_exit_done();
	}
	
	/* Default react sequence for initial entry  */
	private void react_Leonie_Bupered_Or_Emergency_Stop__entry_Default() {
		enterSequence_Leonie_Bupered_Or_Emergency_Stop_waitForEvent_default();
	}
	
	/* The reactions of exit exit_done. */
	private void react_main_region_RiddleGame_RiddleGame_exit_done() {
		effect_main_region_RiddleGame_tr0();
	}
	
	/* The reactions of exit exit_done. */
	private void react_main_region_RiddleGame_RiddleGame_TellAction_Instructions_RiddleGame_exit_done() {
		effect_main_region_RiddleGame_RiddleGame_TellAction_tr0();
	}
	
	/* The reactions of exit exit_done. */
	private void react_main_region_RiddleGame_RiddleGame_TellAction_Instructions_RiddleGame_surrounding_surrounding_RiddleGame_exit_done() {
		effect_main_region_RiddleGame_RiddleGame_TellAction_Instructions_RiddleGame_surrounding_tr0();
	}
	
	/* The reactions of exit exit_answer. */
	private void react_main_region_RiddleGame_RiddleGame_Scit0s_STT_RiddleGame_exit_answer() {
		effect_main_region_RiddleGame_RiddleGame_Scit0s_tr0();
	}
	
	/* The reactions of exit exit_action. */
	private void react_main_region_RiddleGame_RiddleGame_Scit0s_STT_RiddleGame_exit_action() {
		effect_main_region_RiddleGame_RiddleGame_Scit0s_tr1();
	}
	
	/* The reactions of exit exit_incomprehensible. */
	private void react_main_region_RiddleGame_RiddleGame_Scit0s_STT_RiddleGame_exit_incomprehensible() {
		effect_main_region_RiddleGame_RiddleGame_Scit0s_tr2();
	}
	
	/* The reactions of exit exit_done. */
	private void react_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_surrounding_surrounding_BlindMansBlufGame_exit_done() {
		effect_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_surrounding_tr0();
	}
	
	/* The reactions of exit exit_done. */
	private void react_main_region_BlindMansBlufGame_BlindMansBlufGame_exit_done() {
		effect_main_region_BlindMansBlufGame_tr0();
	}
	
	/* The reactions of state null. */
	private void react_main_region_BlindMansBlufGame_BlindMansBlufGame__sync0() {
		enterSequence_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_waitForSTT_default();
		enterSequence_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_Kinect2_WaitForNoise_default();
	}
	
	/* The reactions of state null. */
	private void react_main_region_BlindMansBlufGame_BlindMansBlufGame__sync1() {
		react_main_region_BlindMansBlufGame_BlindMansBlufGame__choice_0();
	}
	
	public void runCycle() {
		if (!initialized)
			throw new IllegalStateException(
					"The state machine needs to be initialized first by calling the init() function.");
		clearOutEvents();
		for (nextStateIndex = 0; nextStateIndex < stateVector.length; nextStateIndex++) {
			switch (stateVector[nextStateIndex]) {
			case main_region_Init:
				react_main_region_Init();
				break;
			case main_region_Announcement:
				react_main_region_Announcement();
				break;
			case main_region_Wait:
				react_main_region_Wait();
				break;
			case main_region_TurnAround:
				react_main_region_TurnAround();
				break;
			case main_region_CrowdScanningAndCounting:
				react_main_region_CrowdScanningAndCounting();
				break;
			case main_region_RiddleGame_RiddleGame_StartGame:
				react_main_region_RiddleGame_RiddleGame_StartGame();
				break;
			case main_region_RiddleGame_RiddleGame_WaitForOperator:
				react_main_region_RiddleGame_RiddleGame_WaitForOperator();
				break;
			case main_region_RiddleGame_RiddleGame_Hello:
				react_main_region_RiddleGame_RiddleGame_Hello();
				break;
			case main_region_RiddleGame_RiddleGame_Leave_the_arena:
				react_main_region_RiddleGame_RiddleGame_Leave_the_arena();
				break;
			case main_region_RiddleGame_RiddleGame_TellAnswer:
				react_main_region_RiddleGame_RiddleGame_TellAnswer();
				break;
			case main_region_RiddleGame_RiddleGame_PrepareForNextQuestion:
				react_main_region_RiddleGame_RiddleGame_PrepareForNextQuestion();
				break;
			case main_region_RiddleGame_RiddleGame_TellIncomprehensible:
				react_main_region_RiddleGame_RiddleGame_TellIncomprehensible();
				break;
			case main_region_RiddleGame_RiddleGame_NextQuestion:
				react_main_region_RiddleGame_RiddleGame_NextQuestion();
				break;
			case main_region_RiddleGame_RiddleGame_TellAction_Instructions_RiddleGame_GoTo:
				react_main_region_RiddleGame_RiddleGame_TellAction_Instructions_RiddleGame_GoTo();
				break;
			case main_region_RiddleGame_RiddleGame_TellAction_Instructions_RiddleGame_surrounding:
				react_main_region_RiddleGame_RiddleGame_TellAction_Instructions_RiddleGame_surrounding();
				break;
			case main_region_RiddleGame_RiddleGame_TellAction_Instructions_RiddleGame_bring:
				react_main_region_RiddleGame_RiddleGame_TellAction_Instructions_RiddleGame_bring();
				break;
			case main_region_RiddleGame_RiddleGame_TellAction_Instructions_RiddleGame_open:
				react_main_region_RiddleGame_RiddleGame_TellAction_Instructions_RiddleGame_open();
				break;
			case main_region_RiddleGame_RiddleGame_TellAction_Instructions_RiddleGame_followme:
				react_main_region_RiddleGame_RiddleGame_TellAction_Instructions_RiddleGame_followme();
				break;
			case main_region_RiddleGame_RiddleGame_TellAction_Instructions_RiddleGame_unknown:
				react_main_region_RiddleGame_RiddleGame_TellAction_Instructions_RiddleGame_unknown();
				break;
			case main_region_RiddleGame_RiddleGame_TellAction_Instructions_RiddleGame_crowd:
				react_main_region_RiddleGame_RiddleGame_TellAction_Instructions_RiddleGame_crowd();
				break;
			case main_region_RiddleGame_RiddleGame_Scit0s_STT_RiddleGame_StartSTT:
				react_main_region_RiddleGame_RiddleGame_Scit0s_STT_RiddleGame_StartSTT();
				break;
			case main_region_RiddleGame_RiddleGame_Scit0s_STT_RiddleGame_TellSpokenText:
				react_main_region_RiddleGame_RiddleGame_Scit0s_STT_RiddleGame_TellSpokenText();
				break;
			case main_region_BlindMansBlufGame_BlindMansBlufGame_StartGame:
				react_main_region_BlindMansBlufGame_BlindMansBlufGame_StartGame();
				break;
			case main_region_BlindMansBlufGame_BlindMansBlufGame_StartSTT:
				react_main_region_BlindMansBlufGame_BlindMansBlufGame_StartSTT();
				break;
			case main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_waitForSTT:
				react_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_waitForSTT();
				break;
			case main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAnswer:
				react_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAnswer();
				break;
			case main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_GoTo:
				react_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_GoTo();
				break;
			case main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_surrounding:
				react_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_surrounding();
				break;
			case main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_bring:
				react_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_bring();
				break;
			case main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_open:
				react_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_open();
				break;
			case main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_followme:
				react_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_followme();
				break;
			case main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_unknown:
				react_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_unknown();
				break;
			case main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_Copy_1_crowd:
				react_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_Copy_1_crowd();
				break;
			case main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellIncomprehensible:
				react_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellIncomprehensible();
				break;
			case main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_StopSTT2:
				react_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_StopSTT2();
				break;
			case main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_getSpokenText:
				react_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_getSpokenText();
				break;
			case main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_Kinect2_WaitForNoise:
				react_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_Kinect2_WaitForNoise();
				break;
			case main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_Kinect2_Turn:
				react_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_Kinect2_Turn();
				break;
			case main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_Kinect2_endNoise:
				react_main_region_BlindMansBlufGame_BlindMansBlufGame_ParallelOfSTTAndKinect2_Kinect2_endNoise();
				break;
			case main_region_BlindMansBlufGame_BlindMansBlufGame_allQuestionsDone:
				react_main_region_BlindMansBlufGame_BlindMansBlufGame_allQuestionsDone();
				break;
			case main_region_BlindMansBlufGame_BlindMansBlufGame_NoRepeat:
				react_main_region_BlindMansBlufGame_BlindMansBlufGame_NoRepeat();
				break;
			case main_region_BlindMansBlufGame_BlindMansBlufGame_Turn:
				react_main_region_BlindMansBlufGame_BlindMansBlufGame_Turn();
				break;
			case main_region_BlindMansBlufGame_BlindMansBlufGame_NextQuestion:
				react_main_region_BlindMansBlufGame_BlindMansBlufGame_NextQuestion();
				break;
			case main_region_BlindMansBlufGame_BlindMansBlufGame_firstQ:
				react_main_region_BlindMansBlufGame_BlindMansBlufGame_firstQ();
				break;
			case main_region_BlindMansBlufGame_BlindMansBlufGame_wait:
				react_main_region_BlindMansBlufGame_BlindMansBlufGame_wait();
				break;
			case main_region_BlindMansBlufGame_BlindMansBlufGame_Repeat:
				react_main_region_BlindMansBlufGame_BlindMansBlufGame_Repeat();
				break;
			case main_region_LeaveTheRoom:
				react_main_region_LeaveTheRoom();
				break;
			case main_region__final_:
				react_main_region__final_();
				break;
			case main_region_DetectionOn:
				react_main_region_DetectionOn();
				break;
			case main_region_waitForMarc:
				react_main_region_waitForMarc();
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
