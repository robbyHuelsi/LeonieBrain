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
		
		private boolean noiseDetected;
		
		public void raiseNoiseDetected() {
			noiseDetected = true;
		}
		
		private boolean wavingDetected;
		
		public void raiseWavingDetected() {
			wavingDetected = true;
		}
		
		protected void clearEvents() {
			personDetected = false;
			noiseDetected = false;
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
		main_region_RiddleGame_r1_StartGame,
		main_region_RiddleGame_r1_WaitForOperator,
		main_region_RiddleGame_r1_Hello,
		main_region_RiddleGame_r1_Leave_the_arena,
		main_region_RiddleGame_r1_StartSTT,
		main_region_RiddleGame_r1_TellAnswer,
		main_region_RiddleGame_r1_PrepareForNextQuestion,
		main_region_RiddleGame_r1_TellIncomprehensible,
		main_region_RiddleGame_r1_NextQuestion,
		main_region_RiddleGame_r1_TellAction,
		main_region_RiddleGame_r1_TellAction_Instructions_GoTo,
		main_region_RiddleGame_r1_TellAction_Instructions_crowd,
		main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_countAll,
		main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_countMale,
		main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_countFemale,
		main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_countSitting,
		main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_countLaying,
		main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_countStanding,
		main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_countHandSign,
		main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_countYoung,
		main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_countOld,
		main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_else,
		main_region_RiddleGame_r1_TellAction_Instructions_surrounding,
		main_region_RiddleGame_r1_TellAction_Instructions_bring,
		main_region_RiddleGame_r1_TellAction_Instructions_open,
		main_region_RiddleGame_r1_TellAction_Instructions_followme,
		main_region_RiddleGame_r1_TellAction_Instructions_unknown,
		main_region_RiddleGame_r1_StopSTT,
		main_region_BlindMansBluGame,
		main_region_BlindMansBluGame_z_StartGame,
		main_region_BlindMansBluGame_z_StartSTT,
		main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2,
		main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_waitForSTT,
		main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAnswer,
		main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAction,
		main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_GoTo,
		main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_crowd,
		main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_surrounding,
		main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_bring,
		main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_open,
		main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_followme,
		main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_unknown,
		main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellIncomprehensible,
		main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_StopSTT2,
		main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_StopSTT,
		main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_Kinect2_WaitForNoise,
		main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_Kinect2_Turn,
		main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_Kinect2_endNoise,
		main_region_BlindMansBluGame_z_allQuestionsDone,
		main_region_BlindMansBluGame_z_NoRepeat,
		main_region_BlindMansBluGame_z_Repeat,
		main_region_BlindMansBluGame_z_NextQuestion,
		main_region_LeaveTheRoom,
		main_region__final_,
		main_region_DetectionOn,
		leonie_Bupered_Or_Emergency_Stop_waitForEvent,
		leonie_Bupered_Or_Emergency_Stop_Bumpered,
		leonie_Bupered_Or_Emergency_Stop_resetFace,
		leonie_Bupered_Or_Emergency_Stop_EmergencyStop,
		$NullState$
	};
	
	private final State[] stateVector = new State[3];
	
	private int nextStateIndex;
	
	private ITimer timer;
	
	private final boolean[] timeEvents = new boolean[7];
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
					main_region_RiddleGame.ordinal()&& stateVector[0].ordinal() <= State.main_region_RiddleGame_r1_StopSTT.ordinal();
		case main_region_RiddleGame_r1_StartGame:
			return stateVector[0] == State.main_region_RiddleGame_r1_StartGame;
		case main_region_RiddleGame_r1_WaitForOperator:
			return stateVector[0] == State.main_region_RiddleGame_r1_WaitForOperator;
		case main_region_RiddleGame_r1_Hello:
			return stateVector[0] == State.main_region_RiddleGame_r1_Hello;
		case main_region_RiddleGame_r1_Leave_the_arena:
			return stateVector[0] == State.main_region_RiddleGame_r1_Leave_the_arena;
		case main_region_RiddleGame_r1_StartSTT:
			return stateVector[0] == State.main_region_RiddleGame_r1_StartSTT;
		case main_region_RiddleGame_r1_TellAnswer:
			return stateVector[0] == State.main_region_RiddleGame_r1_TellAnswer;
		case main_region_RiddleGame_r1_PrepareForNextQuestion:
			return stateVector[0] == State.main_region_RiddleGame_r1_PrepareForNextQuestion;
		case main_region_RiddleGame_r1_TellIncomprehensible:
			return stateVector[0] == State.main_region_RiddleGame_r1_TellIncomprehensible;
		case main_region_RiddleGame_r1_NextQuestion:
			return stateVector[0] == State.main_region_RiddleGame_r1_NextQuestion;
		case main_region_RiddleGame_r1_TellAction:
			return stateVector[0].ordinal() >= State.
					main_region_RiddleGame_r1_TellAction.ordinal()&& stateVector[0].ordinal() <= State.main_region_RiddleGame_r1_TellAction_Instructions_unknown.ordinal();
		case main_region_RiddleGame_r1_TellAction_Instructions_GoTo:
			return stateVector[0] == State.main_region_RiddleGame_r1_TellAction_Instructions_GoTo;
		case main_region_RiddleGame_r1_TellAction_Instructions_crowd:
			return stateVector[0].ordinal() >= State.
					main_region_RiddleGame_r1_TellAction_Instructions_crowd.ordinal()&& stateVector[0].ordinal() <= State.main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_else.ordinal();
		case main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_countAll:
			return stateVector[0] == State.main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_countAll;
		case main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_countMale:
			return stateVector[0] == State.main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_countMale;
		case main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_countFemale:
			return stateVector[0] == State.main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_countFemale;
		case main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_countSitting:
			return stateVector[0] == State.main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_countSitting;
		case main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_countLaying:
			return stateVector[0] == State.main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_countLaying;
		case main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_countStanding:
			return stateVector[0] == State.main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_countStanding;
		case main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_countHandSign:
			return stateVector[0] == State.main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_countHandSign;
		case main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_countYoung:
			return stateVector[0] == State.main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_countYoung;
		case main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_countOld:
			return stateVector[0] == State.main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_countOld;
		case main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_else:
			return stateVector[0] == State.main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_else;
		case main_region_RiddleGame_r1_TellAction_Instructions_surrounding:
			return stateVector[0] == State.main_region_RiddleGame_r1_TellAction_Instructions_surrounding;
		case main_region_RiddleGame_r1_TellAction_Instructions_bring:
			return stateVector[0] == State.main_region_RiddleGame_r1_TellAction_Instructions_bring;
		case main_region_RiddleGame_r1_TellAction_Instructions_open:
			return stateVector[0] == State.main_region_RiddleGame_r1_TellAction_Instructions_open;
		case main_region_RiddleGame_r1_TellAction_Instructions_followme:
			return stateVector[0] == State.main_region_RiddleGame_r1_TellAction_Instructions_followme;
		case main_region_RiddleGame_r1_TellAction_Instructions_unknown:
			return stateVector[0] == State.main_region_RiddleGame_r1_TellAction_Instructions_unknown;
		case main_region_RiddleGame_r1_StopSTT:
			return stateVector[0] == State.main_region_RiddleGame_r1_StopSTT;
		case main_region_BlindMansBluGame:
			return stateVector[0].ordinal() >= State.
					main_region_BlindMansBluGame.ordinal()&& stateVector[0].ordinal() <= State.main_region_BlindMansBluGame_z_NextQuestion.ordinal();
		case main_region_BlindMansBluGame_z_StartGame:
			return stateVector[0] == State.main_region_BlindMansBluGame_z_StartGame;
		case main_region_BlindMansBluGame_z_StartSTT:
			return stateVector[0] == State.main_region_BlindMansBluGame_z_StartSTT;
		case main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2:
			return stateVector[0].ordinal() >= State.
					main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2.ordinal()&& stateVector[0].ordinal() <= State.main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_Kinect2_endNoise.ordinal();
		case main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_waitForSTT:
			return stateVector[0] == State.main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_waitForSTT;
		case main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAnswer:
			return stateVector[0] == State.main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAnswer;
		case main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAction:
			return stateVector[0].ordinal() >= State.
					main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAction.ordinal()&& stateVector[0].ordinal() <= State.main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_unknown.ordinal();
		case main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_GoTo:
			return stateVector[0] == State.main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_GoTo;
		case main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_crowd:
			return stateVector[0] == State.main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_crowd;
		case main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_surrounding:
			return stateVector[0] == State.main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_surrounding;
		case main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_bring:
			return stateVector[0] == State.main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_bring;
		case main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_open:
			return stateVector[0] == State.main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_open;
		case main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_followme:
			return stateVector[0] == State.main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_followme;
		case main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_unknown:
			return stateVector[0] == State.main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_unknown;
		case main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellIncomprehensible:
			return stateVector[0] == State.main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellIncomprehensible;
		case main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_StopSTT2:
			return stateVector[0] == State.main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_StopSTT2;
		case main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_StopSTT:
			return stateVector[0] == State.main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_StopSTT;
		case main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_Kinect2_WaitForNoise:
			return stateVector[1] == State.main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_Kinect2_WaitForNoise;
		case main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_Kinect2_Turn:
			return stateVector[1] == State.main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_Kinect2_Turn;
		case main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_Kinect2_endNoise:
			return stateVector[1] == State.main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_Kinect2_endNoise;
		case main_region_BlindMansBluGame_z_allQuestionsDone:
			return stateVector[0] == State.main_region_BlindMansBluGame_z_allQuestionsDone;
		case main_region_BlindMansBluGame_z_NoRepeat:
			return stateVector[0] == State.main_region_BlindMansBluGame_z_NoRepeat;
		case main_region_BlindMansBluGame_z_Repeat:
			return stateVector[0] == State.main_region_BlindMansBluGame_z_Repeat;
		case main_region_BlindMansBluGame_z_NextQuestion:
			return stateVector[0] == State.main_region_BlindMansBluGame_z_NextQuestion;
		case main_region_LeaveTheRoom:
			return stateVector[0] == State.main_region_LeaveTheRoom;
		case main_region__final_:
			return stateVector[0] == State.main_region__final_;
		case main_region_DetectionOn:
			return stateVector[0] == State.main_region_DetectionOn;
		case leonie_Bupered_Or_Emergency_Stop_waitForEvent:
			return stateVector[2] == State.leonie_Bupered_Or_Emergency_Stop_waitForEvent;
		case leonie_Bupered_Or_Emergency_Stop_Bumpered:
			return stateVector[2] == State.leonie_Bupered_Or_Emergency_Stop_Bumpered;
		case leonie_Bupered_Or_Emergency_Stop_resetFace:
			return stateVector[2] == State.leonie_Bupered_Or_Emergency_Stop_resetFace;
		case leonie_Bupered_Or_Emergency_Stop_EmergencyStop:
			return stateVector[2] == State.leonie_Bupered_Or_Emergency_Stop_EmergencyStop;
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
	
	private boolean check_main_region_Wait_tr0_tr0() {
		return timeEvents[0];
	}
	
	private boolean check_main_region_TurnAround_tr0_tr0() {
		return timeEvents[1];
	}
	
	private boolean check_main_region_CrowdScanningAndCounting_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_main_region_RiddleGame_r1_StartGame_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_main_region_RiddleGame_r1_WaitForOperator_tr0_tr0() {
		return timeEvents[2];
	}
	
	private boolean check_main_region_RiddleGame_r1_Hello_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_main_region_RiddleGame_r1_Leave_the_arena_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_main_region_RiddleGame_r1_StartSTT_tr0_tr0() {
		return timeEvents[3];
	}
	
	private boolean check_main_region_RiddleGame_r1_TellAnswer_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_main_region_RiddleGame_r1_PrepareForNextQuestion_tr0_tr0() {
		return true;
	}
	
	private boolean check_main_region_RiddleGame_r1_TellIncomprehensible_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_main_region_RiddleGame_r1_NextQuestion_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_main_region_RiddleGame_r1_TellAction_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_main_region_RiddleGame_r1_TellAction_Instructions_GoTo_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_countAll_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_countMale_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_countSitting_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_countLaying_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_countStanding_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_countHandSign_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_countYoung_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_countOld_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_else_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_main_region_RiddleGame_r1_TellAction_Instructions_bring_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_main_region_RiddleGame_r1_TellAction_Instructions_open_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_main_region_RiddleGame_r1_TellAction_Instructions_followme_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_main_region_RiddleGame_r1_TellAction_Instructions_unknown_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_main_region_RiddleGame_r1_StopSTT_tr0_tr0() {
		return sCISTT.answerReceived;
	}
	
	private boolean check_main_region_RiddleGame_r1_StopSTT_tr1_tr1() {
		return sCISTT.actionReceived;
	}
	
	private boolean check_main_region_RiddleGame_r1_StopSTT_tr2_tr2() {
		return sCISTT.incomprehensible;
	}
	
	private boolean check_main_region_BlindMansBluGame_z_StartGame_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_main_region_BlindMansBluGame_z_StartSTT_tr0_tr0() {
		return true;
	}
	
	private boolean check_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_waitForSTT_tr0_tr0() {
		return timeEvents[4];
	}
	
	private boolean check_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAnswer_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAction_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_GoTo_tr0_tr0() {
		return true;
	}
	
	private boolean check_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_crowd_tr0_tr0() {
		return true;
	}
	
	private boolean check_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_surrounding_tr0_tr0() {
		return true;
	}
	
	private boolean check_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_bring_tr0_tr0() {
		return true;
	}
	
	private boolean check_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_open_tr0_tr0() {
		return true;
	}
	
	private boolean check_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_followme_tr0_tr0() {
		return true;
	}
	
	private boolean check_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_unknown_tr0_tr0() {
		return true;
	}
	
	private boolean check_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellIncomprehensible_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_StopSTT2_tr0_tr0() {
		return true && isStateActive(State.main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_Kinect2_endNoise) && true;
	}
	
	private boolean check_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_StopSTT_tr0_tr0() {
		return sCISTT.actionReceived;
	}
	
	private boolean check_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_StopSTT_tr1_tr1() {
		return sCISTT.answerReceived;
	}
	
	private boolean check_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_StopSTT_tr2_tr2() {
		return sCISTT.incomprehensible;
	}
	
	private boolean check_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_Kinect2_WaitForNoise_tr0_tr0() {
		return sCIKinect2.noiseDetected;
	}
	
	private boolean check_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_Kinect2_WaitForNoise_tr1_tr1() {
		return sCISTT.spokenTextReceived;
	}
	
	private boolean check_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_Kinect2_Turn_tr0_tr0() {
		return true;
	}
	
	private boolean check_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_Kinect2_endNoise_tr0_tr0() {
		return true && isStateActive(State.main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_StopSTT2) && true;
	}
	
	private boolean check_main_region_BlindMansBluGame_z_allQuestionsDone_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_main_region_BlindMansBluGame_z_NoRepeat_tr0_tr0() {
		return getQuestionCounter()>=6;
	}
	
	private boolean check_main_region_BlindMansBluGame_z_Repeat_tr0_tr0() {
		return true;
	}
	
	private boolean check_main_region_BlindMansBluGame_z_NextQuestion_tr0_tr0() {
		return true;
	}
	
	private boolean check_main_region_DetectionOn_tr0_tr0() {
		return sCICrowdDetection.detected;
	}
	
	private boolean check_Leonie_Bupered_Or_Emergency_Stop_waitForEvent_tr0_tr0() {
		return sCIMira.bumpered;
	}
	
	private boolean check_Leonie_Bupered_Or_Emergency_Stop_waitForEvent_tr1_tr1() {
		return sCIMira.emergencyStop;
	}
	
	private boolean check_Leonie_Bupered_Or_Emergency_Stop_Bumpered_tr0_tr0() {
		return timeEvents[5];
	}
	
	private boolean check_Leonie_Bupered_Or_Emergency_Stop_resetFace_tr0_tr0() {
		return true;
	}
	
	private boolean check_Leonie_Bupered_Or_Emergency_Stop_EmergencyStop_tr0_tr0() {
		return timeEvents[6];
	}
	
	private boolean check_main_region_RiddleGame_r1__choice_0_tr1_tr1() {
		return getCounter()>=5;
	}
	
	private boolean check_main_region_RiddleGame_r1__choice_0_tr0_tr0() {
		return true;
	}
	
	private boolean check_main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd__choice_0_tr0_tr0() {
		return (sCISTT.operationCallback.getObject()== null?"countAll" ==null :sCISTT.operationCallback.getObject().equals("countAll"));
	}
	
	private boolean check_main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd__choice_0_tr1_tr1() {
		return (sCISTT.operationCallback.getObject()== null?"countMale" ==null :sCISTT.operationCallback.getObject().equals("countMale"));
	}
	
	private boolean check_main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd__choice_0_tr2_tr2() {
		return (sCISTT.operationCallback.getObject()== null?"countFemale" ==null :sCISTT.operationCallback.getObject().equals("countFemale"));
	}
	
	private boolean check_main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd__choice_0_tr3_tr3() {
		return (sCISTT.operationCallback.getObject()== null?"countStanding" ==null :sCISTT.operationCallback.getObject().equals("countStanding"));
	}
	
	private boolean check_main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd__choice_0_tr4_tr4() {
		return (sCISTT.operationCallback.getObject()== null?"countSitting" ==null :sCISTT.operationCallback.getObject().equals("countSitting"));
	}
	
	private boolean check_main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd__choice_0_tr5_tr5() {
		return (sCISTT.operationCallback.getObject()== null?"countLaying" ==null :sCISTT.operationCallback.getObject().equals("countLaying"));
	}
	
	private boolean check_main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd__choice_0_tr6_tr6() {
		return (sCISTT.operationCallback.getObject()== null?"countHandSign" ==null :sCISTT.operationCallback.getObject().equals("countHandSign"));
	}
	
	private boolean check_main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd__choice_0_tr7_tr7() {
		return (sCISTT.operationCallback.getObject()== null?"countYoung" ==null :sCISTT.operationCallback.getObject().equals("countYoung"));
	}
	
	private boolean check_main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd__choice_0_tr8_tr8() {
		return (sCISTT.operationCallback.getObject()== null?"countOld" ==null :sCISTT.operationCallback.getObject().equals("countOld"));
	}
	
	private boolean check_main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd__choice_0_tr9_tr9() {
		return true;
	}
	
	private boolean check_main_region_RiddleGame_r1_TellAction_Instructions__choice_0_tr0_tr0() {
		return (sCISTT.operationCallback.getInstruction()== null?"goto" ==null :sCISTT.operationCallback.getInstruction().equals("goto"));
	}
	
	private boolean check_main_region_RiddleGame_r1_TellAction_Instructions__choice_0_tr1_tr1() {
		return (sCISTT.operationCallback.getInstruction()== null?"crowd" ==null :sCISTT.operationCallback.getInstruction().equals("crowd"));
	}
	
	private boolean check_main_region_RiddleGame_r1_TellAction_Instructions__choice_0_tr2_tr2() {
		return (sCISTT.operationCallback.getInstruction()== null?"surrounding" ==null :sCISTT.operationCallback.getInstruction().equals("surrounding"));
	}
	
	private boolean check_main_region_RiddleGame_r1_TellAction_Instructions__choice_0_tr3_tr3() {
		return (sCISTT.operationCallback.getInstruction()== null?"bring" ==null :sCISTT.operationCallback.getInstruction().equals("bring"));
	}
	
	private boolean check_main_region_RiddleGame_r1_TellAction_Instructions__choice_0_tr4_tr4() {
		return (sCISTT.operationCallback.getInstruction()== null?"open" ==null :sCISTT.operationCallback.getInstruction().equals("open"));
	}
	
	private boolean check_main_region_RiddleGame_r1_TellAction_Instructions__choice_0_tr5_tr5() {
		return (sCISTT.operationCallback.getInstruction()== null?"followme" ==null :sCISTT.operationCallback.getInstruction().equals("followme"));
	}
	
	private boolean check_main_region_RiddleGame_r1_TellAction_Instructions__choice_0_tr6_tr6() {
		return true;
	}
	
	private boolean check_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAction_Instructions__choice_0_tr0_tr0() {
		return (sCISTT.operationCallback.getInstruction()== null?"goto" ==null :sCISTT.operationCallback.getInstruction().equals("goto"));
	}
	
	private boolean check_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAction_Instructions__choice_0_tr1_tr1() {
		return (sCISTT.operationCallback.getInstruction()== null?"crowd" ==null :sCISTT.operationCallback.getInstruction().equals("crowd"));
	}
	
	private boolean check_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAction_Instructions__choice_0_tr2_tr2() {
		return (sCISTT.operationCallback.getInstruction()== null?"surrounding" ==null :sCISTT.operationCallback.getInstruction().equals("surrounding"));
	}
	
	private boolean check_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAction_Instructions__choice_0_tr3_tr3() {
		return (sCISTT.operationCallback.getInstruction()== null?"bring" ==null :sCISTT.operationCallback.getInstruction().equals("bring"));
	}
	
	private boolean check_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAction_Instructions__choice_0_tr4_tr4() {
		return (sCISTT.operationCallback.getInstruction()== null?"open" ==null :sCISTT.operationCallback.getInstruction().equals("open"));
	}
	
	private boolean check_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAction_Instructions__choice_0_tr5_tr5() {
		return (sCISTT.operationCallback.getInstruction()== null?"followme" ==null :sCISTT.operationCallback.getInstruction().equals("followme"));
	}
	
	private boolean check_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAction_Instructions__choice_0_tr6_tr6() {
		return true;
	}
	
	private boolean check_main_region_BlindMansBluGame_z__choice_0_tr0_tr0() {
		return getQuestionCounter()>=6;
	}
	
	private boolean check_main_region_BlindMansBluGame_z__choice_0_tr1_tr1() {
		return true;
	}
	
	private boolean check_main_region_BlindMansBluGame_z__choice_1_tr0_tr0() {
		return getQuestionRepeat()>=1;
	}
	
	private boolean check_main_region_BlindMansBluGame_z__choice_1_tr1_tr1() {
		return getQuestionRepeat()==0;
	}
	
	private boolean check_main_region_BlindMansBluGame_z__choice_1_tr2_tr2() {
		return true;
	}
	
	private boolean check_main_region_BlindMansBluGame_z__choice_2_tr0() {
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
	
	private void effect_main_region_RiddleGame_tr0() {
		exitSequence_main_region_RiddleGame();
		enterSequence_main_region_BlindMansBluGame_exit_done();
	}
	
	private void effect_main_region_RiddleGame_r1_StartGame_tr0() {
		exitSequence_main_region_RiddleGame_r1_StartGame();
		enterSequence_main_region_RiddleGame_r1_WaitForOperator_default();
	}
	
	private void effect_main_region_RiddleGame_r1_WaitForOperator_tr0() {
		exitSequence_main_region_RiddleGame_r1_WaitForOperator();
		enterSequence_main_region_RiddleGame_r1_Hello_default();
	}
	
	private void effect_main_region_RiddleGame_r1_Hello_tr0() {
		exitSequence_main_region_RiddleGame_r1_Hello();
		enterSequence_main_region_RiddleGame_r1_StartSTT_default();
	}
	
	private void effect_main_region_RiddleGame_r1_Leave_the_arena_tr0() {
		exitSequence_main_region_RiddleGame_r1_Leave_the_arena();
		react_main_region_RiddleGame_r1_exit_done();
	}
	
	private void effect_main_region_RiddleGame_r1_StartSTT_tr0() {
		exitSequence_main_region_RiddleGame_r1_StartSTT();
		enterSequence_main_region_RiddleGame_r1_StopSTT_default();
	}
	
	private void effect_main_region_RiddleGame_r1_TellAnswer_tr0() {
		exitSequence_main_region_RiddleGame_r1_TellAnswer();
		enterSequence_main_region_RiddleGame_r1_PrepareForNextQuestion_default();
	}
	
	private void effect_main_region_RiddleGame_r1_PrepareForNextQuestion_tr0() {
		exitSequence_main_region_RiddleGame_r1_PrepareForNextQuestion();
		react_main_region_RiddleGame_r1__choice_0();
	}
	
	private void effect_main_region_RiddleGame_r1_TellIncomprehensible_tr0() {
		exitSequence_main_region_RiddleGame_r1_TellIncomprehensible();
		enterSequence_main_region_RiddleGame_r1_PrepareForNextQuestion_default();
	}
	
	private void effect_main_region_RiddleGame_r1_NextQuestion_tr0() {
		exitSequence_main_region_RiddleGame_r1_NextQuestion();
		enterSequence_main_region_RiddleGame_r1_StartSTT_default();
	}
	
	private void effect_main_region_RiddleGame_r1_TellAction_tr0() {
		exitSequence_main_region_RiddleGame_r1_TellAction();
		enterSequence_main_region_RiddleGame_r1_PrepareForNextQuestion_default();
	}
	
	private void effect_main_region_RiddleGame_r1_TellAction_Instructions_GoTo_tr0() {
		exitSequence_main_region_RiddleGame_r1_TellAction_Instructions_GoTo();
	}
	
	private void effect_main_region_RiddleGame_r1_TellAction_Instructions_crowd_tr0() {
		exitSequence_main_region_RiddleGame_r1_TellAction_Instructions_crowd();
	}
	
	private void effect_main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_countAll_tr0() {
		exitSequence_main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_countAll();
		react_main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_exit_done();
	}
	
	private void effect_main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_countMale_tr0() {
		exitSequence_main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_countMale();
		react_main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_exit_done();
	}
	
	private void effect_main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_countSitting_tr0() {
		exitSequence_main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_countSitting();
		react_main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_exit_done();
	}
	
	private void effect_main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_countLaying_tr0() {
		exitSequence_main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_countLaying();
		react_main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_exit_done();
	}
	
	private void effect_main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_countStanding_tr0() {
		exitSequence_main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_countStanding();
		react_main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_exit_done();
	}
	
	private void effect_main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_countHandSign_tr0() {
		exitSequence_main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_countHandSign();
		react_main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_exit_done();
	}
	
	private void effect_main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_countYoung_tr0() {
		exitSequence_main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_countYoung();
		react_main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_exit_done();
	}
	
	private void effect_main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_countOld_tr0() {
		exitSequence_main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_countOld();
		react_main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_exit_done();
	}
	
	private void effect_main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_else_tr0() {
		exitSequence_main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_else();
		react_main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_exit_done();
	}
	
	private void effect_main_region_RiddleGame_r1_TellAction_Instructions_surrounding_tr0() {
		exitSequence_main_region_RiddleGame_r1_TellAction_Instructions_surrounding();
	}
	
	private void effect_main_region_RiddleGame_r1_TellAction_Instructions_bring_tr0() {
		exitSequence_main_region_RiddleGame_r1_TellAction_Instructions_bring();
	}
	
	private void effect_main_region_RiddleGame_r1_TellAction_Instructions_open_tr0() {
		exitSequence_main_region_RiddleGame_r1_TellAction_Instructions_open();
	}
	
	private void effect_main_region_RiddleGame_r1_TellAction_Instructions_followme_tr0() {
		exitSequence_main_region_RiddleGame_r1_TellAction_Instructions_followme();
	}
	
	private void effect_main_region_RiddleGame_r1_TellAction_Instructions_unknown_tr0() {
		exitSequence_main_region_RiddleGame_r1_TellAction_Instructions_unknown();
	}
	
	private void effect_main_region_RiddleGame_r1_StopSTT_tr0() {
		exitSequence_main_region_RiddleGame_r1_StopSTT();
		enterSequence_main_region_RiddleGame_r1_TellAnswer_default();
	}
	
	private void effect_main_region_RiddleGame_r1_StopSTT_tr1() {
		exitSequence_main_region_RiddleGame_r1_StopSTT();
		enterSequence_main_region_RiddleGame_r1_TellAction_default();
	}
	
	private void effect_main_region_RiddleGame_r1_StopSTT_tr2() {
		exitSequence_main_region_RiddleGame_r1_StopSTT();
		enterSequence_main_region_RiddleGame_r1_TellIncomprehensible_default();
	}
	
	private void effect_main_region_BlindMansBluGame_tr0() {
		exitSequence_main_region_BlindMansBluGame();
		enterSequence_main_region_LeaveTheRoom_default();
	}
	
	private void effect_main_region_BlindMansBluGame_z_StartGame_tr0() {
		exitSequence_main_region_BlindMansBluGame_z_StartGame();
		enterSequence_main_region_BlindMansBluGame_z_StartSTT_default();
	}
	
	private void effect_main_region_BlindMansBluGame_z_StartSTT_tr0() {
		exitSequence_main_region_BlindMansBluGame_z_StartSTT();
		react_main_region_BlindMansBluGame_z__sync0();
	}
	
	private void effect_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_waitForSTT_tr0() {
		exitSequence_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_waitForSTT();
		enterSequence_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_StopSTT_default();
	}
	
	private void effect_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAnswer_tr0() {
		exitSequence_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAnswer();
		enterSequence_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_StopSTT2_default();
	}
	
	private void effect_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAction_tr0() {
		exitSequence_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAction();
		enterSequence_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_StopSTT2_default();
	}
	
	private void effect_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_GoTo_tr0() {
		exitSequence_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_GoTo();
	}
	
	private void effect_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_crowd_tr0() {
		exitSequence_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_crowd();
	}
	
	private void effect_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_surrounding_tr0() {
		exitSequence_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_surrounding();
	}
	
	private void effect_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_bring_tr0() {
		exitSequence_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_bring();
	}
	
	private void effect_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_open_tr0() {
		exitSequence_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_open();
	}
	
	private void effect_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_followme_tr0() {
		exitSequence_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_followme();
	}
	
	private void effect_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_unknown_tr0() {
		exitSequence_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_unknown();
	}
	
	private void effect_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellIncomprehensible_tr0() {
		exitSequence_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellIncomprehensible();
		enterSequence_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_StopSTT2_default();
	}
	
	private void effect_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_StopSTT2_tr0() {
		exitSequence_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2();
		react_main_region_BlindMansBluGame_z__sync1();
	}
	
	private void effect_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_StopSTT_tr0() {
		exitSequence_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_StopSTT();
		enterSequence_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAction_default();
	}
	
	private void effect_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_StopSTT_tr1() {
		exitSequence_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_StopSTT();
		enterSequence_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAnswer_default();
	}
	
	private void effect_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_StopSTT_tr2() {
		exitSequence_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_StopSTT();
		enterSequence_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellIncomprehensible_default();
	}
	
	private void effect_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_Kinect2_WaitForNoise_tr0() {
		exitSequence_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_Kinect2_WaitForNoise();
		enterSequence_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_Kinect2_Turn_default();
	}
	
	private void effect_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_Kinect2_WaitForNoise_tr1() {
		exitSequence_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_Kinect2_WaitForNoise();
		enterSequence_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_Kinect2_endNoise_default();
	}
	
	private void effect_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_Kinect2_Turn_tr0() {
		exitSequence_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_Kinect2_Turn();
		enterSequence_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_Kinect2_endNoise_default();
	}
	
	private void effect_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_Kinect2_endNoise_tr0() {
		exitSequence_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2();
		react_main_region_BlindMansBluGame_z__sync1();
	}
	
	private void effect_main_region_BlindMansBluGame_z_allQuestionsDone_tr0() {
		exitSequence_main_region_BlindMansBluGame_z_allQuestionsDone();
		react_main_region_BlindMansBluGame_z_exit_done();
	}
	
	private void effect_main_region_BlindMansBluGame_z_NoRepeat_tr0() {
		exitSequence_main_region_BlindMansBluGame_z_NoRepeat();
		enterSequence_main_region_BlindMansBluGame_z_allQuestionsDone_default();
	}
	
	private void effect_main_region_BlindMansBluGame_z_Repeat_tr0() {
		exitSequence_main_region_BlindMansBluGame_z_Repeat();
		react_main_region_BlindMansBluGame_z__choice_2();
	}
	
	private void effect_main_region_BlindMansBluGame_z_NextQuestion_tr0() {
		exitSequence_main_region_BlindMansBluGame_z_NextQuestion();
		react_main_region_BlindMansBluGame_z__choice_2();
	}
	
	private void effect_main_region_DetectionOn_tr0() {
		exitSequence_main_region_DetectionOn();
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
		enterSequence_Leonie_Bupered_Or_Emergency_Stop_resetFace_default();
	}
	
	private void effect_main_region_RiddleGame_r1__choice_0_tr1() {
		enterSequence_main_region_RiddleGame_r1_Leave_the_arena_default();
	}
	
	private void effect_main_region_RiddleGame_r1__choice_0_tr0() {
		enterSequence_main_region_RiddleGame_r1_NextQuestion_default();
	}
	
	private void effect_main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd__choice_0_tr0() {
		enterSequence_main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_countAll_default();
	}
	
	private void effect_main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd__choice_0_tr1() {
		enterSequence_main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_countMale_default();
	}
	
	private void effect_main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd__choice_0_tr2() {
		enterSequence_main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_countFemale_default();
	}
	
	private void effect_main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd__choice_0_tr3() {
		enterSequence_main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_countStanding_default();
	}
	
	private void effect_main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd__choice_0_tr4() {
		enterSequence_main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_countSitting_default();
	}
	
	private void effect_main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd__choice_0_tr5() {
		enterSequence_main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_countLaying_default();
	}
	
	private void effect_main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd__choice_0_tr6() {
		enterSequence_main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_countHandSign_default();
	}
	
	private void effect_main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd__choice_0_tr7() {
		enterSequence_main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_countYoung_default();
	}
	
	private void effect_main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd__choice_0_tr8() {
		enterSequence_main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_countOld_default();
	}
	
	private void effect_main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd__choice_0_tr9() {
		enterSequence_main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_else_default();
	}
	
	private void effect_main_region_RiddleGame_r1_TellAction_Instructions__choice_0_tr0() {
		enterSequence_main_region_RiddleGame_r1_TellAction_Instructions_GoTo_default();
	}
	
	private void effect_main_region_RiddleGame_r1_TellAction_Instructions__choice_0_tr1() {
		enterSequence_main_region_RiddleGame_r1_TellAction_Instructions_crowd_default();
	}
	
	private void effect_main_region_RiddleGame_r1_TellAction_Instructions__choice_0_tr2() {
		enterSequence_main_region_RiddleGame_r1_TellAction_Instructions_surrounding_default();
	}
	
	private void effect_main_region_RiddleGame_r1_TellAction_Instructions__choice_0_tr3() {
		enterSequence_main_region_RiddleGame_r1_TellAction_Instructions_bring_default();
	}
	
	private void effect_main_region_RiddleGame_r1_TellAction_Instructions__choice_0_tr4() {
		enterSequence_main_region_RiddleGame_r1_TellAction_Instructions_open_default();
	}
	
	private void effect_main_region_RiddleGame_r1_TellAction_Instructions__choice_0_tr5() {
		enterSequence_main_region_RiddleGame_r1_TellAction_Instructions_followme_default();
	}
	
	private void effect_main_region_RiddleGame_r1_TellAction_Instructions__choice_0_tr6() {
		enterSequence_main_region_RiddleGame_r1_TellAction_Instructions_unknown_default();
	}
	
	private void effect_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAction_Instructions__choice_0_tr0() {
		enterSequence_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_GoTo_default();
	}
	
	private void effect_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAction_Instructions__choice_0_tr1() {
		enterSequence_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_crowd_default();
	}
	
	private void effect_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAction_Instructions__choice_0_tr2() {
		enterSequence_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_surrounding_default();
	}
	
	private void effect_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAction_Instructions__choice_0_tr3() {
		enterSequence_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_bring_default();
	}
	
	private void effect_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAction_Instructions__choice_0_tr4() {
		enterSequence_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_open_default();
	}
	
	private void effect_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAction_Instructions__choice_0_tr5() {
		enterSequence_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_followme_default();
	}
	
	private void effect_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAction_Instructions__choice_0_tr6() {
		enterSequence_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_unknown_default();
	}
	
	private void effect_main_region_BlindMansBluGame_z__choice_0_tr0() {
		enterSequence_main_region_BlindMansBluGame_z_allQuestionsDone_default();
	}
	
	private void effect_main_region_BlindMansBluGame_z__choice_0_tr1() {
		react_main_region_BlindMansBluGame_z__choice_1();
	}
	
	private void effect_main_region_BlindMansBluGame_z__choice_1_tr0() {
		enterSequence_main_region_BlindMansBluGame_z_NoRepeat_default();
	}
	
	private void effect_main_region_BlindMansBluGame_z__choice_1_tr1() {
		enterSequence_main_region_BlindMansBluGame_z_Repeat_default();
	}
	
	private void effect_main_region_BlindMansBluGame_z__choice_1_tr2() {
		enterSequence_main_region_BlindMansBluGame_z_NextQuestion_default();
	}
	
	private void effect_main_region_BlindMansBluGame_z__choice_2_tr0() {
		enterSequence_main_region_BlindMansBluGame_z_StartSTT_default();
	}
	
	/* Entry action for state 'Announcement'. */
	private void entryAction_main_region_Announcement() {
		sCIHBrain.operationCallback.sendTTS("[:-)] I want to play the riddle game in 10 seconds!");
	}
	
	/* Entry action for state 'Wait'. */
	private void entryAction_main_region_Wait() {
		timer.setTimer(this, 0, 10*1000, false);
	}
	
	/* Entry action for state 'TurnAround'. */
	private void entryAction_main_region_TurnAround() {
		timer.setTimer(this, 1, 3*1000, false);
		
		sCIMira.operationCallback.sendBodyUTurn();
	}
	
	/* Entry action for state 'CrowdScanningAndCounting'. */
	private void entryAction_main_region_CrowdScanningAndCounting() {
		sCICrowdDetection.operationCallback.sendDetectionOff();
		
		sCIHBrain.operationCallback.sendTTS("[:-)]");
		
		sCIHBrain.operationCallback.sendTTS(sCICrowdDetection.operationCallback.getSummaryText());
	}
	
	/* Entry action for state 'StartGame'. */
	private void entryAction_main_region_RiddleGame_r1_StartGame() {
		setQuestionCounter(0);
		
		setQuestionRepeat(0);
		
		sCIHBrain.operationCallback.sendTTS("Who want to play riddles with me?");
	}
	
	/* Entry action for state 'WaitForOperator'. */
	private void entryAction_main_region_RiddleGame_r1_WaitForOperator() {
		timer.setTimer(this, 2, 3*1000, false);
	}
	
	/* Entry action for state 'Hello'. */
	private void entryAction_main_region_RiddleGame_r1_Hello() {
		sCIHBrain.operationCallback.sendTTS("[:-)] Ask me a question! [attentive]");
		
		setCounter(0);
	}
	
	/* Entry action for state 'Leave the arena'. */
	private void entryAction_main_region_RiddleGame_r1_Leave_the_arena() {
		sCIHBrain.operationCallback.sendTTS("Okay, that's enough for now.");
	}
	
	/* Entry action for state 'StartSTT'. */
	private void entryAction_main_region_RiddleGame_r1_StartSTT() {
		timer.setTimer(this, 3, 5*1000, false);
		
		sCISTT.operationCallback.sendSpeechDetectionSmalltalk();
	}
	
	/* Entry action for state 'TellAnswer'. */
	private void entryAction_main_region_RiddleGame_r1_TellAnswer() {
		sCIHBrain.operationCallback.sendTTS2(sCISTT.operationCallback.getAnswer(), " [:-)]");
	}
	
	/* Entry action for state 'PrepareForNextQuestion'. */
	private void entryAction_main_region_RiddleGame_r1_PrepareForNextQuestion() {
		sCISTT.operationCallback.sendSpeechDetectionOff();
		
		setCounter(getCounter() + 1);
	}
	
	/* Entry action for state 'TellIncomprehensible'. */
	private void entryAction_main_region_RiddleGame_r1_TellIncomprehensible() {
		sCIHBrain.operationCallback.sendTTS3("[:-(]", sCISTT.operationCallback.getAnswer(), "[:-|]");
	}
	
	/* Entry action for state 'NextQuestion'. */
	private void entryAction_main_region_RiddleGame_r1_NextQuestion() {
		sCIHBrain.operationCallback.sendTTS("Please ask me the next a question. [attentive]");
	}
	
	/* Entry action for state 'GoTo'. */
	private void entryAction_main_region_RiddleGame_r1_TellAction_Instructions_GoTo() {
		sCIHBrain.operationCallback.sendTTS("[:-(] Sorry. I'm can't go to somewhere now.");
	}
	
	/* Entry action for state 'countAll'. */
	private void entryAction_main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_countAll() {
		setCountString(sCIBGF.operationCallback.intToString(sCICrowdDetection.operationCallback.getTotalCount()));
		
		sCIHBrain.operationCallback.sendTTS3("I found ", getCountString(), " people");
	}
	
	/* Entry action for state 'countMale'. */
	private void entryAction_main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_countMale() {
		setCountString(sCIBGF.operationCallback.intToString(sCICrowdDetection.operationCallback.getSpecificCount(0, -1, -1, -1)));
		
		sCIHBrain.operationCallback.sendTTS3("I found ", getCountString(), " gentlemen");
	}
	
	/* Entry action for state 'countFemale'. */
	private void entryAction_main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_countFemale() {
		setCountString(sCIBGF.operationCallback.intToString(sCICrowdDetection.operationCallback.getSpecificCount(1, -1, -1, -1)));
		
		sCIHBrain.operationCallback.sendTTS3("I found ", getCountString(), " ladies");
	}
	
	/* Entry action for state 'countSitting'. */
	private void entryAction_main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_countSitting() {
		setCountString(sCIBGF.operationCallback.intToString(sCICrowdDetection.operationCallback.getSpecificCount(-1, -1, -1, 1)));
		
		sCIHBrain.operationCallback.sendTTS3("I found ", getCountString(), " sitting people");
	}
	
	/* Entry action for state 'countLaying'. */
	private void entryAction_main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_countLaying() {
		setCountString(sCIBGF.operationCallback.intToString(sCICrowdDetection.operationCallback.getSpecificCount(-1, -1, -1, 2)));
		
		sCIHBrain.operationCallback.sendTTS3("I found ", getCountString(), " laying people");
	}
	
	/* Entry action for state 'countStanding'. */
	private void entryAction_main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_countStanding() {
		setCountString(sCIBGF.operationCallback.intToString(sCICrowdDetection.operationCallback.getSpecificCount(-1, -1, -1, 0)));
		
		sCIHBrain.operationCallback.sendTTS3("I found ", getCountString(), " standing people");
	}
	
	/* Entry action for state 'countHandSign'. */
	private void entryAction_main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_countHandSign() {
		sCIHBrain.operationCallback.sendTTS("[:-(] I'm sorry, I can't detect hand signs");
	}
	
	/* Entry action for state 'countYoung'. */
	private void entryAction_main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_countYoung() {
		setCountString(sCIBGF.operationCallback.intToString(sCICrowdDetection.operationCallback.getSpecificCount(-1, -1, 26, -1)));
		
		sCIHBrain.operationCallback.sendTTS3("I found ", getCountString(), " young people");
	}
	
	/* Entry action for state 'countOld'. */
	private void entryAction_main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_countOld() {
		setCountString(sCIBGF.operationCallback.intToString(sCICrowdDetection.operationCallback.getSpecificCount(-1, 54, -1, 1)));
		
		sCIHBrain.operationCallback.sendTTS3("I found ", getCountString(), " sitting people");
	}
	
	/* Entry action for state 'else'. */
	private void entryAction_main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_else() {
		sCIHBrain.operationCallback.sendTTS3("I don't know, what you mean with ", sCISTT.operationCallback.getObject(), ".");
	}
	
	/* Entry action for state 'bring'. */
	private void entryAction_main_region_RiddleGame_r1_TellAction_Instructions_bring() {
		sCIHBrain.operationCallback.sendTTS("[:-(] Sorry. I'm can't bring something at the moment.");
	}
	
	/* Entry action for state 'open'. */
	private void entryAction_main_region_RiddleGame_r1_TellAction_Instructions_open() {
		sCIHBrain.operationCallback.sendTTS("[:-(] Sorry. I'm can't open something at the moment.");
	}
	
	/* Entry action for state 'followme'. */
	private void entryAction_main_region_RiddleGame_r1_TellAction_Instructions_followme() {
		sCIHBrain.operationCallback.sendTTS("[:-(] Sorry. I'm can't follow you now.");
	}
	
	/* Entry action for state 'unknown'. */
	private void entryAction_main_region_RiddleGame_r1_TellAction_Instructions_unknown() {
		sCIHBrain.operationCallback.sendTTS("[:-(] Sorry. I didn't get what I should do.");
	}
	
	/* Entry action for state 'StopSTT'. */
	private void entryAction_main_region_RiddleGame_r1_StopSTT() {
		sCISTT.operationCallback.sendSpeechDetectionOff();
		
		sCIHBrain.operationCallback.sendTTS("[:-)]");
	}
	
	/* Entry action for state 'StartGame'. */
	private void entryAction_main_region_BlindMansBluGame_z_StartGame() {
		setQuestionCounter(0);
		
		setQuestionRepeat(0);
		
		sCIHBrain.operationCallback.sendTTS("I'm ready for the next game. [:-)] Ask me the first question. [attentive]");
	}
	
	/* Entry action for state 'StartSTT'. */
	private void entryAction_main_region_BlindMansBluGame_z_StartSTT() {
		sCISTT.operationCallback.sendSpeechDetectionSmalltalk();
		
		sCIKinect2.operationCallback.sendNoiseDetectionOnOff(true);
	}
	
	/* Entry action for state 'waitForSTT'. */
	private void entryAction_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_waitForSTT() {
		timer.setTimer(this, 4, 5*1000, false);
		
		sCIHBrain.operationCallback.sendTTS("[attentive]");
	}
	
	/* Entry action for state 'TellAnswer'. */
	private void entryAction_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAnswer() {
		sCIHBrain.operationCallback.sendTTS2(sCISTT.operationCallback.getAnswer(), " [:-)]");
		
		setQuestionCounter(getQuestionCounter() + 1);
	}
	
	/* Entry action for state 'TellAction'. */
	private void entryAction_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAction() {
		sCIHBrain.operationCallback.sendTTS("Sorry, I can't do this at the moment.");
	}
	
	/* Entry action for state 'TellIncomprehensible'. */
	private void entryAction_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellIncomprehensible() {
		sCIHBrain.operationCallback.sendTTS3("[:-(]", sCISTT.operationCallback.getAnswer(), "[:-|]");
	}
	
	/* Entry action for state 'StopSTT2'. */
	private void entryAction_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_StopSTT2() {
		sCISTT.operationCallback.sendSpeechDetectionOff();
	}
	
	/* Entry action for state 'StopSTT'. */
	private void entryAction_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_StopSTT() {
		sCISTT.operationCallback.sendSpeechDetectionOff();
		
		sCIHBrain.operationCallback.sendTTS("[:-)]");
	}
	
	/* Entry action for state 'Turn'. */
	private void entryAction_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_Kinect2_Turn() {
		sCIMira.operationCallback.sendTurnBody(sCIKinect2.operationCallback.getNoiseAngle());
	}
	
	/* Entry action for state 'endNoise'. */
	private void entryAction_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_Kinect2_endNoise() {
		sCIKinect2.operationCallback.sendNoiseDetectionOnOff(false);
	}
	
	/* Entry action for state 'allQuestionsDone'. */
	private void entryAction_main_region_BlindMansBluGame_z_allQuestionsDone() {
		sCIHBrain.operationCallback.sendTTS("Okay. Thats all.");
	}
	
	/* Entry action for state 'NoRepeat'. */
	private void entryAction_main_region_BlindMansBluGame_z_NoRepeat() {
		sCIHBrain.operationCallback.sendTTS("I'm so sorry! I have no answer for you [:-(]");
		
		setQuestionCounter(getQuestionCounter() + 1);
		
		setQuestionRepeat(0);
	}
	
	/* Entry action for state 'Repeat'. */
	private void entryAction_main_region_BlindMansBluGame_z_Repeat() {
		sCIHBrain.operationCallback.sendTTS("Please repeat the question. [attentive]");
		
		setQuestionRepeat(getQuestionRepeat() + 1);
	}
	
	/* Entry action for state 'NextQuestion'. */
	private void entryAction_main_region_BlindMansBluGame_z_NextQuestion() {
		sCIHBrain.operationCallback.sendTTS("Please ask me the next question. [attentive]");
	}
	
	/* Entry action for state 'LeaveTheRoom'. */
	private void entryAction_main_region_LeaveTheRoom() {
		sCIMira.operationCallback.sendGoToGWP(0);
	}
	
	/* Entry action for state 'DetectionOn'. */
	private void entryAction_main_region_DetectionOn() {
		sCICrowdDetection.operationCallback.sendDetectionOn();
		
		sCIHBrain.operationCallback.sendTTS("[:-O]");
	}
	
	/* Entry action for state 'Bumpered'. */
	private void entryAction_Leonie_Bupered_Or_Emergency_Stop_Bumpered() {
		timer.setTimer(this, 5, 3*1000, false);
		
		sCIHBrain.operationCallback.sendTTS("[:-(]ouch!");
	}
	
	/* Entry action for state 'resetFace'. */
	private void entryAction_Leonie_Bupered_Or_Emergency_Stop_resetFace() {
		sCIHBrain.operationCallback.sendTTS("[:-|]");
	}
	
	/* Entry action for state 'EmergencyStop'. */
	private void entryAction_Leonie_Bupered_Or_Emergency_Stop_EmergencyStop() {
		timer.setTimer(this, 6, 3*1000, false);
		
		sCIHBrain.operationCallback.sendTTS("[:-O] Emergancy Stop!");
	}
	
	/* Exit action for state 'Wait'. */
	private void exitAction_main_region_Wait() {
		timer.unsetTimer(this, 0);
	}
	
	/* Exit action for state 'TurnAround'. */
	private void exitAction_main_region_TurnAround() {
		timer.unsetTimer(this, 1);
	}
	
	/* Exit action for state 'WaitForOperator'. */
	private void exitAction_main_region_RiddleGame_r1_WaitForOperator() {
		timer.unsetTimer(this, 2);
	}
	
	/* Exit action for state 'StartSTT'. */
	private void exitAction_main_region_RiddleGame_r1_StartSTT() {
		timer.unsetTimer(this, 3);
	}
	
	/* Exit action for state 'waitForSTT'. */
	private void exitAction_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_waitForSTT() {
		timer.unsetTimer(this, 4);
	}
	
	/* Exit action for state 'Bumpered'. */
	private void exitAction_Leonie_Bupered_Or_Emergency_Stop_Bumpered() {
		timer.unsetTimer(this, 5);
	}
	
	/* Exit action for state 'EmergencyStop'. */
	private void exitAction_Leonie_Bupered_Or_Emergency_Stop_EmergencyStop() {
		timer.unsetTimer(this, 6);
	}
	
	/* 'default' enter sequence for state Init */
	private void enterSequence_main_region_Init_default() {
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
		enterSequence_main_region_RiddleGame_r1_default();
	}
	
	/* 'default' enter sequence for state StartGame */
	private void enterSequence_main_region_RiddleGame_r1_StartGame_default() {
		entryAction_main_region_RiddleGame_r1_StartGame();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_RiddleGame_r1_StartGame;
	}
	
	/* 'default' enter sequence for state WaitForOperator */
	private void enterSequence_main_region_RiddleGame_r1_WaitForOperator_default() {
		entryAction_main_region_RiddleGame_r1_WaitForOperator();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_RiddleGame_r1_WaitForOperator;
	}
	
	/* 'default' enter sequence for state Hello */
	private void enterSequence_main_region_RiddleGame_r1_Hello_default() {
		entryAction_main_region_RiddleGame_r1_Hello();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_RiddleGame_r1_Hello;
	}
	
	/* 'default' enter sequence for state Leave the arena */
	private void enterSequence_main_region_RiddleGame_r1_Leave_the_arena_default() {
		entryAction_main_region_RiddleGame_r1_Leave_the_arena();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_RiddleGame_r1_Leave_the_arena;
	}
	
	/* 'default' enter sequence for state StartSTT */
	private void enterSequence_main_region_RiddleGame_r1_StartSTT_default() {
		entryAction_main_region_RiddleGame_r1_StartSTT();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_RiddleGame_r1_StartSTT;
	}
	
	/* 'default' enter sequence for state TellAnswer */
	private void enterSequence_main_region_RiddleGame_r1_TellAnswer_default() {
		entryAction_main_region_RiddleGame_r1_TellAnswer();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_RiddleGame_r1_TellAnswer;
	}
	
	/* 'default' enter sequence for state PrepareForNextQuestion */
	private void enterSequence_main_region_RiddleGame_r1_PrepareForNextQuestion_default() {
		entryAction_main_region_RiddleGame_r1_PrepareForNextQuestion();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_RiddleGame_r1_PrepareForNextQuestion;
	}
	
	/* 'default' enter sequence for state TellIncomprehensible */
	private void enterSequence_main_region_RiddleGame_r1_TellIncomprehensible_default() {
		entryAction_main_region_RiddleGame_r1_TellIncomprehensible();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_RiddleGame_r1_TellIncomprehensible;
	}
	
	/* 'default' enter sequence for state NextQuestion */
	private void enterSequence_main_region_RiddleGame_r1_NextQuestion_default() {
		entryAction_main_region_RiddleGame_r1_NextQuestion();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_RiddleGame_r1_NextQuestion;
	}
	
	/* 'default' enter sequence for state TellAction */
	private void enterSequence_main_region_RiddleGame_r1_TellAction_default() {
		enterSequence_main_region_RiddleGame_r1_TellAction_Instructions_default();
	}
	
	/* 'default' enter sequence for state GoTo */
	private void enterSequence_main_region_RiddleGame_r1_TellAction_Instructions_GoTo_default() {
		entryAction_main_region_RiddleGame_r1_TellAction_Instructions_GoTo();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_RiddleGame_r1_TellAction_Instructions_GoTo;
	}
	
	/* 'default' enter sequence for state crowd */
	private void enterSequence_main_region_RiddleGame_r1_TellAction_Instructions_crowd_default() {
		enterSequence_main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_default();
	}
	
	/* 'default' enter sequence for state countAll */
	private void enterSequence_main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_countAll_default() {
		entryAction_main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_countAll();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_countAll;
	}
	
	/* 'default' enter sequence for state countMale */
	private void enterSequence_main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_countMale_default() {
		entryAction_main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_countMale();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_countMale;
	}
	
	/* 'default' enter sequence for state countFemale */
	private void enterSequence_main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_countFemale_default() {
		entryAction_main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_countFemale();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_countFemale;
	}
	
	/* 'default' enter sequence for state countSitting */
	private void enterSequence_main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_countSitting_default() {
		entryAction_main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_countSitting();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_countSitting;
	}
	
	/* 'default' enter sequence for state countLaying */
	private void enterSequence_main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_countLaying_default() {
		entryAction_main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_countLaying();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_countLaying;
	}
	
	/* 'default' enter sequence for state countStanding */
	private void enterSequence_main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_countStanding_default() {
		entryAction_main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_countStanding();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_countStanding;
	}
	
	/* 'default' enter sequence for state countHandSign */
	private void enterSequence_main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_countHandSign_default() {
		entryAction_main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_countHandSign();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_countHandSign;
	}
	
	/* 'default' enter sequence for state countYoung */
	private void enterSequence_main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_countYoung_default() {
		entryAction_main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_countYoung();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_countYoung;
	}
	
	/* 'default' enter sequence for state countOld */
	private void enterSequence_main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_countOld_default() {
		entryAction_main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_countOld();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_countOld;
	}
	
	/* 'default' enter sequence for state else */
	private void enterSequence_main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_else_default() {
		entryAction_main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_else();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_else;
	}
	
	/* 'default' enter sequence for state surrounding */
	private void enterSequence_main_region_RiddleGame_r1_TellAction_Instructions_surrounding_default() {
		nextStateIndex = 0;
		stateVector[0] = State.main_region_RiddleGame_r1_TellAction_Instructions_surrounding;
	}
	
	/* 'default' enter sequence for state bring */
	private void enterSequence_main_region_RiddleGame_r1_TellAction_Instructions_bring_default() {
		entryAction_main_region_RiddleGame_r1_TellAction_Instructions_bring();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_RiddleGame_r1_TellAction_Instructions_bring;
	}
	
	/* 'default' enter sequence for state open */
	private void enterSequence_main_region_RiddleGame_r1_TellAction_Instructions_open_default() {
		entryAction_main_region_RiddleGame_r1_TellAction_Instructions_open();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_RiddleGame_r1_TellAction_Instructions_open;
	}
	
	/* 'default' enter sequence for state followme */
	private void enterSequence_main_region_RiddleGame_r1_TellAction_Instructions_followme_default() {
		entryAction_main_region_RiddleGame_r1_TellAction_Instructions_followme();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_RiddleGame_r1_TellAction_Instructions_followme;
	}
	
	/* 'default' enter sequence for state unknown */
	private void enterSequence_main_region_RiddleGame_r1_TellAction_Instructions_unknown_default() {
		entryAction_main_region_RiddleGame_r1_TellAction_Instructions_unknown();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_RiddleGame_r1_TellAction_Instructions_unknown;
	}
	
	/* 'default' enter sequence for state StopSTT */
	private void enterSequence_main_region_RiddleGame_r1_StopSTT_default() {
		entryAction_main_region_RiddleGame_r1_StopSTT();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_RiddleGame_r1_StopSTT;
	}
	
	/* 'exit_done' enter sequence for state BlindMansBluGame */
	private void enterSequence_main_region_BlindMansBluGame_exit_done() {
		enterSequence_main_region_BlindMansBluGame_z_default();
	}
	
	/* 'default' enter sequence for state StartGame */
	private void enterSequence_main_region_BlindMansBluGame_z_StartGame_default() {
		entryAction_main_region_BlindMansBluGame_z_StartGame();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_BlindMansBluGame_z_StartGame;
	}
	
	/* 'default' enter sequence for state StartSTT */
	private void enterSequence_main_region_BlindMansBluGame_z_StartSTT_default() {
		entryAction_main_region_BlindMansBluGame_z_StartSTT();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_BlindMansBluGame_z_StartSTT;
	}
	
	/* 'default' enter sequence for state waitForSTT */
	private void enterSequence_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_waitForSTT_default() {
		entryAction_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_waitForSTT();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_waitForSTT;
	}
	
	/* 'default' enter sequence for state TellAnswer */
	private void enterSequence_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAnswer_default() {
		entryAction_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAnswer();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAnswer;
	}
	
	/* 'default' enter sequence for state TellAction */
	private void enterSequence_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAction_default() {
		entryAction_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAction();
		enterSequence_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_default();
	}
	
	/* 'default' enter sequence for state GoTo */
	private void enterSequence_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_GoTo_default() {
		nextStateIndex = 0;
		stateVector[0] = State.main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_GoTo;
	}
	
	/* 'default' enter sequence for state crowd */
	private void enterSequence_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_crowd_default() {
		nextStateIndex = 0;
		stateVector[0] = State.main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_crowd;
	}
	
	/* 'default' enter sequence for state surrounding */
	private void enterSequence_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_surrounding_default() {
		nextStateIndex = 0;
		stateVector[0] = State.main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_surrounding;
	}
	
	/* 'default' enter sequence for state bring */
	private void enterSequence_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_bring_default() {
		nextStateIndex = 0;
		stateVector[0] = State.main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_bring;
	}
	
	/* 'default' enter sequence for state open */
	private void enterSequence_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_open_default() {
		nextStateIndex = 0;
		stateVector[0] = State.main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_open;
	}
	
	/* 'default' enter sequence for state followme */
	private void enterSequence_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_followme_default() {
		nextStateIndex = 0;
		stateVector[0] = State.main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_followme;
	}
	
	/* 'default' enter sequence for state unknown */
	private void enterSequence_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_unknown_default() {
		nextStateIndex = 0;
		stateVector[0] = State.main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_unknown;
	}
	
	/* 'default' enter sequence for state TellIncomprehensible */
	private void enterSequence_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellIncomprehensible_default() {
		entryAction_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellIncomprehensible();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellIncomprehensible;
	}
	
	/* 'default' enter sequence for state StopSTT2 */
	private void enterSequence_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_StopSTT2_default() {
		entryAction_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_StopSTT2();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_StopSTT2;
	}
	
	/* 'default' enter sequence for state StopSTT */
	private void enterSequence_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_StopSTT_default() {
		entryAction_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_StopSTT();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_StopSTT;
	}
	
	/* 'default' enter sequence for state WaitForNoise */
	private void enterSequence_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_Kinect2_WaitForNoise_default() {
		nextStateIndex = 1;
		stateVector[1] = State.main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_Kinect2_WaitForNoise;
	}
	
	/* 'default' enter sequence for state Turn */
	private void enterSequence_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_Kinect2_Turn_default() {
		entryAction_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_Kinect2_Turn();
		nextStateIndex = 1;
		stateVector[1] = State.main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_Kinect2_Turn;
	}
	
	/* 'default' enter sequence for state endNoise */
	private void enterSequence_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_Kinect2_endNoise_default() {
		entryAction_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_Kinect2_endNoise();
		nextStateIndex = 1;
		stateVector[1] = State.main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_Kinect2_endNoise;
	}
	
	/* 'default' enter sequence for state allQuestionsDone */
	private void enterSequence_main_region_BlindMansBluGame_z_allQuestionsDone_default() {
		entryAction_main_region_BlindMansBluGame_z_allQuestionsDone();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_BlindMansBluGame_z_allQuestionsDone;
	}
	
	/* 'default' enter sequence for state NoRepeat */
	private void enterSequence_main_region_BlindMansBluGame_z_NoRepeat_default() {
		entryAction_main_region_BlindMansBluGame_z_NoRepeat();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_BlindMansBluGame_z_NoRepeat;
	}
	
	/* 'default' enter sequence for state Repeat */
	private void enterSequence_main_region_BlindMansBluGame_z_Repeat_default() {
		entryAction_main_region_BlindMansBluGame_z_Repeat();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_BlindMansBluGame_z_Repeat;
	}
	
	/* 'default' enter sequence for state NextQuestion */
	private void enterSequence_main_region_BlindMansBluGame_z_NextQuestion_default() {
		entryAction_main_region_BlindMansBluGame_z_NextQuestion();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_BlindMansBluGame_z_NextQuestion;
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
	
	/* 'default' enter sequence for region main region */
	private void enterSequence_main_region_default() {
		react_main_region__entry_Default();
	}
	
	/* 'default' enter sequence for region r1 */
	private void enterSequence_main_region_RiddleGame_r1_default() {
		react_main_region_RiddleGame_r1__entry_Default();
	}
	
	/* 'default' enter sequence for region Instructions */
	private void enterSequence_main_region_RiddleGame_r1_TellAction_Instructions_default() {
		react_main_region_RiddleGame_r1_TellAction_Instructions__entry_Default();
	}
	
	/* 'default' enter sequence for region crowd */
	private void enterSequence_main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_default() {
		react_main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd__entry_Default();
	}
	
	/* 'default' enter sequence for region z */
	private void enterSequence_main_region_BlindMansBluGame_z_default() {
		react_main_region_BlindMansBluGame_z__entry_Default();
	}
	
	/* 'default' enter sequence for region Instructions */
	private void enterSequence_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_default() {
		react_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAction_Instructions__entry_Default();
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
	}
	
	/* Default exit sequence for state RiddleGame */
	private void exitSequence_main_region_RiddleGame() {
		exitSequence_main_region_RiddleGame_r1();
	}
	
	/* Default exit sequence for state StartGame */
	private void exitSequence_main_region_RiddleGame_r1_StartGame() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state WaitForOperator */
	private void exitSequence_main_region_RiddleGame_r1_WaitForOperator() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
		
		exitAction_main_region_RiddleGame_r1_WaitForOperator();
	}
	
	/* Default exit sequence for state Hello */
	private void exitSequence_main_region_RiddleGame_r1_Hello() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state Leave the arena */
	private void exitSequence_main_region_RiddleGame_r1_Leave_the_arena() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state StartSTT */
	private void exitSequence_main_region_RiddleGame_r1_StartSTT() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
		
		exitAction_main_region_RiddleGame_r1_StartSTT();
	}
	
	/* Default exit sequence for state TellAnswer */
	private void exitSequence_main_region_RiddleGame_r1_TellAnswer() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state PrepareForNextQuestion */
	private void exitSequence_main_region_RiddleGame_r1_PrepareForNextQuestion() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state TellIncomprehensible */
	private void exitSequence_main_region_RiddleGame_r1_TellIncomprehensible() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state NextQuestion */
	private void exitSequence_main_region_RiddleGame_r1_NextQuestion() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state TellAction */
	private void exitSequence_main_region_RiddleGame_r1_TellAction() {
		exitSequence_main_region_RiddleGame_r1_TellAction_Instructions();
	}
	
	/* Default exit sequence for state GoTo */
	private void exitSequence_main_region_RiddleGame_r1_TellAction_Instructions_GoTo() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state crowd */
	private void exitSequence_main_region_RiddleGame_r1_TellAction_Instructions_crowd() {
		exitSequence_main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd();
	}
	
	/* Default exit sequence for state countAll */
	private void exitSequence_main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_countAll() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state countMale */
	private void exitSequence_main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_countMale() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state countFemale */
	private void exitSequence_main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_countFemale() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state countSitting */
	private void exitSequence_main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_countSitting() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state countLaying */
	private void exitSequence_main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_countLaying() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state countStanding */
	private void exitSequence_main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_countStanding() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state countHandSign */
	private void exitSequence_main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_countHandSign() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state countYoung */
	private void exitSequence_main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_countYoung() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state countOld */
	private void exitSequence_main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_countOld() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state else */
	private void exitSequence_main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_else() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state surrounding */
	private void exitSequence_main_region_RiddleGame_r1_TellAction_Instructions_surrounding() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state bring */
	private void exitSequence_main_region_RiddleGame_r1_TellAction_Instructions_bring() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state open */
	private void exitSequence_main_region_RiddleGame_r1_TellAction_Instructions_open() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state followme */
	private void exitSequence_main_region_RiddleGame_r1_TellAction_Instructions_followme() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state unknown */
	private void exitSequence_main_region_RiddleGame_r1_TellAction_Instructions_unknown() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state StopSTT */
	private void exitSequence_main_region_RiddleGame_r1_StopSTT() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state BlindMansBluGame */
	private void exitSequence_main_region_BlindMansBluGame() {
		exitSequence_main_region_BlindMansBluGame_z();
	}
	
	/* Default exit sequence for state StartGame */
	private void exitSequence_main_region_BlindMansBluGame_z_StartGame() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state StartSTT */
	private void exitSequence_main_region_BlindMansBluGame_z_StartSTT() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state ParallelOfSTTAndKinect2 */
	private void exitSequence_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2() {
		exitSequence_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT();
		exitSequence_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_Kinect2();
	}
	
	/* Default exit sequence for state waitForSTT */
	private void exitSequence_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_waitForSTT() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
		
		exitAction_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_waitForSTT();
	}
	
	/* Default exit sequence for state TellAnswer */
	private void exitSequence_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAnswer() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state TellAction */
	private void exitSequence_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAction() {
		exitSequence_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAction_Instructions();
	}
	
	/* Default exit sequence for state GoTo */
	private void exitSequence_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_GoTo() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state crowd */
	private void exitSequence_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_crowd() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state surrounding */
	private void exitSequence_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_surrounding() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state bring */
	private void exitSequence_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_bring() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state open */
	private void exitSequence_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_open() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state followme */
	private void exitSequence_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_followme() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state unknown */
	private void exitSequence_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_unknown() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state TellIncomprehensible */
	private void exitSequence_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellIncomprehensible() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state StopSTT2 */
	private void exitSequence_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_StopSTT2() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state StopSTT */
	private void exitSequence_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_StopSTT() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state WaitForNoise */
	private void exitSequence_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_Kinect2_WaitForNoise() {
		nextStateIndex = 1;
		stateVector[1] = State.$NullState$;
	}
	
	/* Default exit sequence for state Turn */
	private void exitSequence_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_Kinect2_Turn() {
		nextStateIndex = 1;
		stateVector[1] = State.$NullState$;
	}
	
	/* Default exit sequence for state endNoise */
	private void exitSequence_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_Kinect2_endNoise() {
		nextStateIndex = 1;
		stateVector[1] = State.$NullState$;
	}
	
	/* Default exit sequence for state allQuestionsDone */
	private void exitSequence_main_region_BlindMansBluGame_z_allQuestionsDone() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state NoRepeat */
	private void exitSequence_main_region_BlindMansBluGame_z_NoRepeat() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state Repeat */
	private void exitSequence_main_region_BlindMansBluGame_z_Repeat() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state NextQuestion */
	private void exitSequence_main_region_BlindMansBluGame_z_NextQuestion() {
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
		
		exitAction_Leonie_Bupered_Or_Emergency_Stop_EmergencyStop();
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
		case main_region_RiddleGame_r1_StartGame:
			exitSequence_main_region_RiddleGame_r1_StartGame();
			break;
		case main_region_RiddleGame_r1_WaitForOperator:
			exitSequence_main_region_RiddleGame_r1_WaitForOperator();
			break;
		case main_region_RiddleGame_r1_Hello:
			exitSequence_main_region_RiddleGame_r1_Hello();
			break;
		case main_region_RiddleGame_r1_Leave_the_arena:
			exitSequence_main_region_RiddleGame_r1_Leave_the_arena();
			break;
		case main_region_RiddleGame_r1_StartSTT:
			exitSequence_main_region_RiddleGame_r1_StartSTT();
			break;
		case main_region_RiddleGame_r1_TellAnswer:
			exitSequence_main_region_RiddleGame_r1_TellAnswer();
			break;
		case main_region_RiddleGame_r1_PrepareForNextQuestion:
			exitSequence_main_region_RiddleGame_r1_PrepareForNextQuestion();
			break;
		case main_region_RiddleGame_r1_TellIncomprehensible:
			exitSequence_main_region_RiddleGame_r1_TellIncomprehensible();
			break;
		case main_region_RiddleGame_r1_NextQuestion:
			exitSequence_main_region_RiddleGame_r1_NextQuestion();
			break;
		case main_region_RiddleGame_r1_TellAction_Instructions_GoTo:
			exitSequence_main_region_RiddleGame_r1_TellAction_Instructions_GoTo();
			break;
		case main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_countAll:
			exitSequence_main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_countAll();
			break;
		case main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_countMale:
			exitSequence_main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_countMale();
			break;
		case main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_countFemale:
			exitSequence_main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_countFemale();
			break;
		case main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_countSitting:
			exitSequence_main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_countSitting();
			break;
		case main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_countLaying:
			exitSequence_main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_countLaying();
			break;
		case main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_countStanding:
			exitSequence_main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_countStanding();
			break;
		case main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_countHandSign:
			exitSequence_main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_countHandSign();
			break;
		case main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_countYoung:
			exitSequence_main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_countYoung();
			break;
		case main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_countOld:
			exitSequence_main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_countOld();
			break;
		case main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_else:
			exitSequence_main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_else();
			break;
		case main_region_RiddleGame_r1_TellAction_Instructions_surrounding:
			exitSequence_main_region_RiddleGame_r1_TellAction_Instructions_surrounding();
			break;
		case main_region_RiddleGame_r1_TellAction_Instructions_bring:
			exitSequence_main_region_RiddleGame_r1_TellAction_Instructions_bring();
			break;
		case main_region_RiddleGame_r1_TellAction_Instructions_open:
			exitSequence_main_region_RiddleGame_r1_TellAction_Instructions_open();
			break;
		case main_region_RiddleGame_r1_TellAction_Instructions_followme:
			exitSequence_main_region_RiddleGame_r1_TellAction_Instructions_followme();
			break;
		case main_region_RiddleGame_r1_TellAction_Instructions_unknown:
			exitSequence_main_region_RiddleGame_r1_TellAction_Instructions_unknown();
			break;
		case main_region_RiddleGame_r1_StopSTT:
			exitSequence_main_region_RiddleGame_r1_StopSTT();
			break;
		case main_region_BlindMansBluGame_z_StartGame:
			exitSequence_main_region_BlindMansBluGame_z_StartGame();
			break;
		case main_region_BlindMansBluGame_z_StartSTT:
			exitSequence_main_region_BlindMansBluGame_z_StartSTT();
			break;
		case main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_waitForSTT:
			exitSequence_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_waitForSTT();
			break;
		case main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAnswer:
			exitSequence_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAnswer();
			break;
		case main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_GoTo:
			exitSequence_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_GoTo();
			break;
		case main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_crowd:
			exitSequence_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_crowd();
			break;
		case main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_surrounding:
			exitSequence_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_surrounding();
			break;
		case main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_bring:
			exitSequence_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_bring();
			break;
		case main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_open:
			exitSequence_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_open();
			break;
		case main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_followme:
			exitSequence_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_followme();
			break;
		case main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_unknown:
			exitSequence_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_unknown();
			break;
		case main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellIncomprehensible:
			exitSequence_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellIncomprehensible();
			break;
		case main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_StopSTT2:
			exitSequence_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_StopSTT2();
			break;
		case main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_StopSTT:
			exitSequence_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_StopSTT();
			break;
		case main_region_BlindMansBluGame_z_allQuestionsDone:
			exitSequence_main_region_BlindMansBluGame_z_allQuestionsDone();
			break;
		case main_region_BlindMansBluGame_z_NoRepeat:
			exitSequence_main_region_BlindMansBluGame_z_NoRepeat();
			break;
		case main_region_BlindMansBluGame_z_Repeat:
			exitSequence_main_region_BlindMansBluGame_z_Repeat();
			break;
		case main_region_BlindMansBluGame_z_NextQuestion:
			exitSequence_main_region_BlindMansBluGame_z_NextQuestion();
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
		default:
			break;
		}
		
		switch (stateVector[1]) {
		case main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_Kinect2_WaitForNoise:
			exitSequence_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_Kinect2_WaitForNoise();
			break;
		case main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_Kinect2_Turn:
			exitSequence_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_Kinect2_Turn();
			break;
		case main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_Kinect2_endNoise:
			exitSequence_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_Kinect2_endNoise();
			break;
		default:
			break;
		}
	}
	
	/* Default exit sequence for region r1 */
	private void exitSequence_main_region_RiddleGame_r1() {
		switch (stateVector[0]) {
		case main_region_RiddleGame_r1_StartGame:
			exitSequence_main_region_RiddleGame_r1_StartGame();
			break;
		case main_region_RiddleGame_r1_WaitForOperator:
			exitSequence_main_region_RiddleGame_r1_WaitForOperator();
			break;
		case main_region_RiddleGame_r1_Hello:
			exitSequence_main_region_RiddleGame_r1_Hello();
			break;
		case main_region_RiddleGame_r1_Leave_the_arena:
			exitSequence_main_region_RiddleGame_r1_Leave_the_arena();
			break;
		case main_region_RiddleGame_r1_StartSTT:
			exitSequence_main_region_RiddleGame_r1_StartSTT();
			break;
		case main_region_RiddleGame_r1_TellAnswer:
			exitSequence_main_region_RiddleGame_r1_TellAnswer();
			break;
		case main_region_RiddleGame_r1_PrepareForNextQuestion:
			exitSequence_main_region_RiddleGame_r1_PrepareForNextQuestion();
			break;
		case main_region_RiddleGame_r1_TellIncomprehensible:
			exitSequence_main_region_RiddleGame_r1_TellIncomprehensible();
			break;
		case main_region_RiddleGame_r1_NextQuestion:
			exitSequence_main_region_RiddleGame_r1_NextQuestion();
			break;
		case main_region_RiddleGame_r1_TellAction_Instructions_GoTo:
			exitSequence_main_region_RiddleGame_r1_TellAction_Instructions_GoTo();
			break;
		case main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_countAll:
			exitSequence_main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_countAll();
			break;
		case main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_countMale:
			exitSequence_main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_countMale();
			break;
		case main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_countFemale:
			exitSequence_main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_countFemale();
			break;
		case main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_countSitting:
			exitSequence_main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_countSitting();
			break;
		case main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_countLaying:
			exitSequence_main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_countLaying();
			break;
		case main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_countStanding:
			exitSequence_main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_countStanding();
			break;
		case main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_countHandSign:
			exitSequence_main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_countHandSign();
			break;
		case main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_countYoung:
			exitSequence_main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_countYoung();
			break;
		case main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_countOld:
			exitSequence_main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_countOld();
			break;
		case main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_else:
			exitSequence_main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_else();
			break;
		case main_region_RiddleGame_r1_TellAction_Instructions_surrounding:
			exitSequence_main_region_RiddleGame_r1_TellAction_Instructions_surrounding();
			break;
		case main_region_RiddleGame_r1_TellAction_Instructions_bring:
			exitSequence_main_region_RiddleGame_r1_TellAction_Instructions_bring();
			break;
		case main_region_RiddleGame_r1_TellAction_Instructions_open:
			exitSequence_main_region_RiddleGame_r1_TellAction_Instructions_open();
			break;
		case main_region_RiddleGame_r1_TellAction_Instructions_followme:
			exitSequence_main_region_RiddleGame_r1_TellAction_Instructions_followme();
			break;
		case main_region_RiddleGame_r1_TellAction_Instructions_unknown:
			exitSequence_main_region_RiddleGame_r1_TellAction_Instructions_unknown();
			break;
		case main_region_RiddleGame_r1_StopSTT:
			exitSequence_main_region_RiddleGame_r1_StopSTT();
			break;
		default:
			break;
		}
	}
	
	/* Default exit sequence for region Instructions */
	private void exitSequence_main_region_RiddleGame_r1_TellAction_Instructions() {
		switch (stateVector[0]) {
		case main_region_RiddleGame_r1_TellAction_Instructions_GoTo:
			exitSequence_main_region_RiddleGame_r1_TellAction_Instructions_GoTo();
			break;
		case main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_countAll:
			exitSequence_main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_countAll();
			break;
		case main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_countMale:
			exitSequence_main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_countMale();
			break;
		case main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_countFemale:
			exitSequence_main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_countFemale();
			break;
		case main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_countSitting:
			exitSequence_main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_countSitting();
			break;
		case main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_countLaying:
			exitSequence_main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_countLaying();
			break;
		case main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_countStanding:
			exitSequence_main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_countStanding();
			break;
		case main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_countHandSign:
			exitSequence_main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_countHandSign();
			break;
		case main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_countYoung:
			exitSequence_main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_countYoung();
			break;
		case main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_countOld:
			exitSequence_main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_countOld();
			break;
		case main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_else:
			exitSequence_main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_else();
			break;
		case main_region_RiddleGame_r1_TellAction_Instructions_surrounding:
			exitSequence_main_region_RiddleGame_r1_TellAction_Instructions_surrounding();
			break;
		case main_region_RiddleGame_r1_TellAction_Instructions_bring:
			exitSequence_main_region_RiddleGame_r1_TellAction_Instructions_bring();
			break;
		case main_region_RiddleGame_r1_TellAction_Instructions_open:
			exitSequence_main_region_RiddleGame_r1_TellAction_Instructions_open();
			break;
		case main_region_RiddleGame_r1_TellAction_Instructions_followme:
			exitSequence_main_region_RiddleGame_r1_TellAction_Instructions_followme();
			break;
		case main_region_RiddleGame_r1_TellAction_Instructions_unknown:
			exitSequence_main_region_RiddleGame_r1_TellAction_Instructions_unknown();
			break;
		default:
			break;
		}
	}
	
	/* Default exit sequence for region crowd */
	private void exitSequence_main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd() {
		switch (stateVector[0]) {
		case main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_countAll:
			exitSequence_main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_countAll();
			break;
		case main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_countMale:
			exitSequence_main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_countMale();
			break;
		case main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_countFemale:
			exitSequence_main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_countFemale();
			break;
		case main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_countSitting:
			exitSequence_main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_countSitting();
			break;
		case main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_countLaying:
			exitSequence_main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_countLaying();
			break;
		case main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_countStanding:
			exitSequence_main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_countStanding();
			break;
		case main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_countHandSign:
			exitSequence_main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_countHandSign();
			break;
		case main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_countYoung:
			exitSequence_main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_countYoung();
			break;
		case main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_countOld:
			exitSequence_main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_countOld();
			break;
		case main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_else:
			exitSequence_main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_else();
			break;
		default:
			break;
		}
	}
	
	/* Default exit sequence for region z */
	private void exitSequence_main_region_BlindMansBluGame_z() {
		switch (stateVector[0]) {
		case main_region_BlindMansBluGame_z_StartGame:
			exitSequence_main_region_BlindMansBluGame_z_StartGame();
			break;
		case main_region_BlindMansBluGame_z_StartSTT:
			exitSequence_main_region_BlindMansBluGame_z_StartSTT();
			break;
		case main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_waitForSTT:
			exitSequence_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_waitForSTT();
			break;
		case main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAnswer:
			exitSequence_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAnswer();
			break;
		case main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_GoTo:
			exitSequence_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_GoTo();
			break;
		case main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_crowd:
			exitSequence_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_crowd();
			break;
		case main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_surrounding:
			exitSequence_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_surrounding();
			break;
		case main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_bring:
			exitSequence_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_bring();
			break;
		case main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_open:
			exitSequence_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_open();
			break;
		case main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_followme:
			exitSequence_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_followme();
			break;
		case main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_unknown:
			exitSequence_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_unknown();
			break;
		case main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellIncomprehensible:
			exitSequence_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellIncomprehensible();
			break;
		case main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_StopSTT2:
			exitSequence_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_StopSTT2();
			break;
		case main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_StopSTT:
			exitSequence_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_StopSTT();
			break;
		case main_region_BlindMansBluGame_z_allQuestionsDone:
			exitSequence_main_region_BlindMansBluGame_z_allQuestionsDone();
			break;
		case main_region_BlindMansBluGame_z_NoRepeat:
			exitSequence_main_region_BlindMansBluGame_z_NoRepeat();
			break;
		case main_region_BlindMansBluGame_z_Repeat:
			exitSequence_main_region_BlindMansBluGame_z_Repeat();
			break;
		case main_region_BlindMansBluGame_z_NextQuestion:
			exitSequence_main_region_BlindMansBluGame_z_NextQuestion();
			break;
		default:
			break;
		}
		
		switch (stateVector[1]) {
		case main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_Kinect2_WaitForNoise:
			exitSequence_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_Kinect2_WaitForNoise();
			break;
		case main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_Kinect2_Turn:
			exitSequence_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_Kinect2_Turn();
			break;
		case main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_Kinect2_endNoise:
			exitSequence_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_Kinect2_endNoise();
			break;
		default:
			break;
		}
	}
	
	/* Default exit sequence for region STT */
	private void exitSequence_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT() {
		switch (stateVector[0]) {
		case main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_waitForSTT:
			exitSequence_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_waitForSTT();
			break;
		case main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAnswer:
			exitSequence_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAnswer();
			break;
		case main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_GoTo:
			exitSequence_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_GoTo();
			break;
		case main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_crowd:
			exitSequence_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_crowd();
			break;
		case main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_surrounding:
			exitSequence_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_surrounding();
			break;
		case main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_bring:
			exitSequence_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_bring();
			break;
		case main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_open:
			exitSequence_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_open();
			break;
		case main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_followme:
			exitSequence_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_followme();
			break;
		case main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_unknown:
			exitSequence_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_unknown();
			break;
		case main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellIncomprehensible:
			exitSequence_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellIncomprehensible();
			break;
		case main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_StopSTT2:
			exitSequence_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_StopSTT2();
			break;
		case main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_StopSTT:
			exitSequence_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_StopSTT();
			break;
		default:
			break;
		}
	}
	
	/* Default exit sequence for region Instructions */
	private void exitSequence_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAction_Instructions() {
		switch (stateVector[0]) {
		case main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_GoTo:
			exitSequence_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_GoTo();
			break;
		case main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_crowd:
			exitSequence_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_crowd();
			break;
		case main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_surrounding:
			exitSequence_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_surrounding();
			break;
		case main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_bring:
			exitSequence_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_bring();
			break;
		case main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_open:
			exitSequence_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_open();
			break;
		case main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_followme:
			exitSequence_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_followme();
			break;
		case main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_unknown:
			exitSequence_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_unknown();
			break;
		default:
			break;
		}
	}
	
	/* Default exit sequence for region Kinect2 */
	private void exitSequence_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_Kinect2() {
		switch (stateVector[1]) {
		case main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_Kinect2_WaitForNoise:
			exitSequence_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_Kinect2_WaitForNoise();
			break;
		case main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_Kinect2_Turn:
			exitSequence_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_Kinect2_Turn();
			break;
		case main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_Kinect2_endNoise:
			exitSequence_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_Kinect2_endNoise();
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
		}
	}
	
	/* The reactions of state StartGame. */
	private void react_main_region_RiddleGame_r1_StartGame() {
		if (check_main_region_RiddleGame_r1_StartGame_tr0_tr0()) {
			effect_main_region_RiddleGame_r1_StartGame_tr0();
		}
	}
	
	/* The reactions of state WaitForOperator. */
	private void react_main_region_RiddleGame_r1_WaitForOperator() {
		if (check_main_region_RiddleGame_r1_WaitForOperator_tr0_tr0()) {
			effect_main_region_RiddleGame_r1_WaitForOperator_tr0();
		}
	}
	
	/* The reactions of state Hello. */
	private void react_main_region_RiddleGame_r1_Hello() {
		if (check_main_region_RiddleGame_r1_Hello_tr0_tr0()) {
			effect_main_region_RiddleGame_r1_Hello_tr0();
		}
	}
	
	/* The reactions of state Leave the arena. */
	private void react_main_region_RiddleGame_r1_Leave_the_arena() {
		if (check_main_region_RiddleGame_r1_Leave_the_arena_tr0_tr0()) {
			effect_main_region_RiddleGame_r1_Leave_the_arena_tr0();
		}
	}
	
	/* The reactions of state StartSTT. */
	private void react_main_region_RiddleGame_r1_StartSTT() {
		if (check_main_region_RiddleGame_r1_StartSTT_tr0_tr0()) {
			effect_main_region_RiddleGame_r1_StartSTT_tr0();
		}
	}
	
	/* The reactions of state TellAnswer. */
	private void react_main_region_RiddleGame_r1_TellAnswer() {
		if (check_main_region_RiddleGame_r1_TellAnswer_tr0_tr0()) {
			effect_main_region_RiddleGame_r1_TellAnswer_tr0();
		}
	}
	
	/* The reactions of state PrepareForNextQuestion. */
	private void react_main_region_RiddleGame_r1_PrepareForNextQuestion() {
		effect_main_region_RiddleGame_r1_PrepareForNextQuestion_tr0();
	}
	
	/* The reactions of state TellIncomprehensible. */
	private void react_main_region_RiddleGame_r1_TellIncomprehensible() {
		if (check_main_region_RiddleGame_r1_TellIncomprehensible_tr0_tr0()) {
			effect_main_region_RiddleGame_r1_TellIncomprehensible_tr0();
		}
	}
	
	/* The reactions of state NextQuestion. */
	private void react_main_region_RiddleGame_r1_NextQuestion() {
		if (check_main_region_RiddleGame_r1_NextQuestion_tr0_tr0()) {
			effect_main_region_RiddleGame_r1_NextQuestion_tr0();
		}
	}
	
	/* The reactions of state GoTo. */
	private void react_main_region_RiddleGame_r1_TellAction_Instructions_GoTo() {
		if (check_main_region_RiddleGame_r1_TellAction_tr0_tr0()) {
			effect_main_region_RiddleGame_r1_TellAction_tr0();
		} else {
			if (check_main_region_RiddleGame_r1_TellAction_Instructions_GoTo_tr0_tr0()) {
				effect_main_region_RiddleGame_r1_TellAction_Instructions_GoTo_tr0();
			}
		}
	}
	
	/* The reactions of state countAll. */
	private void react_main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_countAll() {
		if (check_main_region_RiddleGame_r1_TellAction_tr0_tr0()) {
			effect_main_region_RiddleGame_r1_TellAction_tr0();
		} else {
			if (check_main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_countAll_tr0_tr0()) {
				effect_main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_countAll_tr0();
			}
		}
	}
	
	/* The reactions of state countMale. */
	private void react_main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_countMale() {
		if (check_main_region_RiddleGame_r1_TellAction_tr0_tr0()) {
			effect_main_region_RiddleGame_r1_TellAction_tr0();
		} else {
			if (check_main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_countMale_tr0_tr0()) {
				effect_main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_countMale_tr0();
			}
		}
	}
	
	/* The reactions of state countFemale. */
	private void react_main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_countFemale() {
		if (check_main_region_RiddleGame_r1_TellAction_tr0_tr0()) {
			effect_main_region_RiddleGame_r1_TellAction_tr0();
		} else {
		}
	}
	
	/* The reactions of state countSitting. */
	private void react_main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_countSitting() {
		if (check_main_region_RiddleGame_r1_TellAction_tr0_tr0()) {
			effect_main_region_RiddleGame_r1_TellAction_tr0();
		} else {
			if (check_main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_countSitting_tr0_tr0()) {
				effect_main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_countSitting_tr0();
			}
		}
	}
	
	/* The reactions of state countLaying. */
	private void react_main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_countLaying() {
		if (check_main_region_RiddleGame_r1_TellAction_tr0_tr0()) {
			effect_main_region_RiddleGame_r1_TellAction_tr0();
		} else {
			if (check_main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_countLaying_tr0_tr0()) {
				effect_main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_countLaying_tr0();
			}
		}
	}
	
	/* The reactions of state countStanding. */
	private void react_main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_countStanding() {
		if (check_main_region_RiddleGame_r1_TellAction_tr0_tr0()) {
			effect_main_region_RiddleGame_r1_TellAction_tr0();
		} else {
			if (check_main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_countStanding_tr0_tr0()) {
				effect_main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_countStanding_tr0();
			}
		}
	}
	
	/* The reactions of state countHandSign. */
	private void react_main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_countHandSign() {
		if (check_main_region_RiddleGame_r1_TellAction_tr0_tr0()) {
			effect_main_region_RiddleGame_r1_TellAction_tr0();
		} else {
			if (check_main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_countHandSign_tr0_tr0()) {
				effect_main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_countHandSign_tr0();
			}
		}
	}
	
	/* The reactions of state countYoung. */
	private void react_main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_countYoung() {
		if (check_main_region_RiddleGame_r1_TellAction_tr0_tr0()) {
			effect_main_region_RiddleGame_r1_TellAction_tr0();
		} else {
			if (check_main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_countYoung_tr0_tr0()) {
				effect_main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_countYoung_tr0();
			}
		}
	}
	
	/* The reactions of state countOld. */
	private void react_main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_countOld() {
		if (check_main_region_RiddleGame_r1_TellAction_tr0_tr0()) {
			effect_main_region_RiddleGame_r1_TellAction_tr0();
		} else {
			if (check_main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_countOld_tr0_tr0()) {
				effect_main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_countOld_tr0();
			}
		}
	}
	
	/* The reactions of state else. */
	private void react_main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_else() {
		if (check_main_region_RiddleGame_r1_TellAction_tr0_tr0()) {
			effect_main_region_RiddleGame_r1_TellAction_tr0();
		} else {
			if (check_main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_else_tr0_tr0()) {
				effect_main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_else_tr0();
			}
		}
	}
	
	/* The reactions of state surrounding. */
	private void react_main_region_RiddleGame_r1_TellAction_Instructions_surrounding() {
		if (check_main_region_RiddleGame_r1_TellAction_tr0_tr0()) {
			effect_main_region_RiddleGame_r1_TellAction_tr0();
		} else {
		}
	}
	
	/* The reactions of state bring. */
	private void react_main_region_RiddleGame_r1_TellAction_Instructions_bring() {
		if (check_main_region_RiddleGame_r1_TellAction_tr0_tr0()) {
			effect_main_region_RiddleGame_r1_TellAction_tr0();
		} else {
			if (check_main_region_RiddleGame_r1_TellAction_Instructions_bring_tr0_tr0()) {
				effect_main_region_RiddleGame_r1_TellAction_Instructions_bring_tr0();
			}
		}
	}
	
	/* The reactions of state open. */
	private void react_main_region_RiddleGame_r1_TellAction_Instructions_open() {
		if (check_main_region_RiddleGame_r1_TellAction_tr0_tr0()) {
			effect_main_region_RiddleGame_r1_TellAction_tr0();
		} else {
			if (check_main_region_RiddleGame_r1_TellAction_Instructions_open_tr0_tr0()) {
				effect_main_region_RiddleGame_r1_TellAction_Instructions_open_tr0();
			}
		}
	}
	
	/* The reactions of state followme. */
	private void react_main_region_RiddleGame_r1_TellAction_Instructions_followme() {
		if (check_main_region_RiddleGame_r1_TellAction_tr0_tr0()) {
			effect_main_region_RiddleGame_r1_TellAction_tr0();
		} else {
			if (check_main_region_RiddleGame_r1_TellAction_Instructions_followme_tr0_tr0()) {
				effect_main_region_RiddleGame_r1_TellAction_Instructions_followme_tr0();
			}
		}
	}
	
	/* The reactions of state unknown. */
	private void react_main_region_RiddleGame_r1_TellAction_Instructions_unknown() {
		if (check_main_region_RiddleGame_r1_TellAction_tr0_tr0()) {
			effect_main_region_RiddleGame_r1_TellAction_tr0();
		} else {
			if (check_main_region_RiddleGame_r1_TellAction_Instructions_unknown_tr0_tr0()) {
				effect_main_region_RiddleGame_r1_TellAction_Instructions_unknown_tr0();
			}
		}
	}
	
	/* The reactions of state StopSTT. */
	private void react_main_region_RiddleGame_r1_StopSTT() {
		if (check_main_region_RiddleGame_r1_StopSTT_tr0_tr0()) {
			effect_main_region_RiddleGame_r1_StopSTT_tr0();
		} else {
			if (check_main_region_RiddleGame_r1_StopSTT_tr1_tr1()) {
				effect_main_region_RiddleGame_r1_StopSTT_tr1();
			} else {
				if (check_main_region_RiddleGame_r1_StopSTT_tr2_tr2()) {
					effect_main_region_RiddleGame_r1_StopSTT_tr2();
				}
			}
		}
	}
	
	/* The reactions of state StartGame. */
	private void react_main_region_BlindMansBluGame_z_StartGame() {
		if (check_main_region_BlindMansBluGame_z_StartGame_tr0_tr0()) {
			effect_main_region_BlindMansBluGame_z_StartGame_tr0();
		}
	}
	
	/* The reactions of state StartSTT. */
	private void react_main_region_BlindMansBluGame_z_StartSTT() {
		effect_main_region_BlindMansBluGame_z_StartSTT_tr0();
	}
	
	/* The reactions of state waitForSTT. */
	private void react_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_waitForSTT() {
		if (check_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_waitForSTT_tr0_tr0()) {
			effect_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_waitForSTT_tr0();
		}
	}
	
	/* The reactions of state TellAnswer. */
	private void react_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAnswer() {
		if (check_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAnswer_tr0_tr0()) {
			effect_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAnswer_tr0();
		}
	}
	
	/* The reactions of state GoTo. */
	private void react_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_GoTo() {
		if (check_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAction_tr0_tr0()) {
			effect_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAction_tr0();
		} else {
			effect_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_GoTo_tr0();
		}
	}
	
	/* The reactions of state crowd. */
	private void react_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_crowd() {
		if (check_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAction_tr0_tr0()) {
			effect_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAction_tr0();
		} else {
			effect_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_crowd_tr0();
		}
	}
	
	/* The reactions of state surrounding. */
	private void react_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_surrounding() {
		if (check_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAction_tr0_tr0()) {
			effect_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAction_tr0();
		} else {
			effect_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_surrounding_tr0();
		}
	}
	
	/* The reactions of state bring. */
	private void react_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_bring() {
		if (check_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAction_tr0_tr0()) {
			effect_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAction_tr0();
		} else {
			effect_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_bring_tr0();
		}
	}
	
	/* The reactions of state open. */
	private void react_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_open() {
		if (check_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAction_tr0_tr0()) {
			effect_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAction_tr0();
		} else {
			effect_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_open_tr0();
		}
	}
	
	/* The reactions of state followme. */
	private void react_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_followme() {
		if (check_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAction_tr0_tr0()) {
			effect_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAction_tr0();
		} else {
			effect_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_followme_tr0();
		}
	}
	
	/* The reactions of state unknown. */
	private void react_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_unknown() {
		if (check_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAction_tr0_tr0()) {
			effect_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAction_tr0();
		} else {
			effect_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_unknown_tr0();
		}
	}
	
	/* The reactions of state TellIncomprehensible. */
	private void react_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellIncomprehensible() {
		if (check_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellIncomprehensible_tr0_tr0()) {
			effect_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellIncomprehensible_tr0();
		}
	}
	
	/* The reactions of state StopSTT2. */
	private void react_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_StopSTT2() {
		if (check_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_StopSTT2_tr0_tr0()) {
			effect_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_StopSTT2_tr0();
		}
	}
	
	/* The reactions of state StopSTT. */
	private void react_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_StopSTT() {
		if (check_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_StopSTT_tr0_tr0()) {
			effect_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_StopSTT_tr0();
		} else {
			if (check_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_StopSTT_tr1_tr1()) {
				effect_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_StopSTT_tr1();
			} else {
				if (check_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_StopSTT_tr2_tr2()) {
					effect_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_StopSTT_tr2();
				}
			}
		}
	}
	
	/* The reactions of state WaitForNoise. */
	private void react_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_Kinect2_WaitForNoise() {
		if (check_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_Kinect2_WaitForNoise_tr0_tr0()) {
			effect_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_Kinect2_WaitForNoise_tr0();
		} else {
			if (check_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_Kinect2_WaitForNoise_tr1_tr1()) {
				effect_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_Kinect2_WaitForNoise_tr1();
			}
		}
	}
	
	/* The reactions of state Turn. */
	private void react_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_Kinect2_Turn() {
		effect_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_Kinect2_Turn_tr0();
	}
	
	/* The reactions of state endNoise. */
	private void react_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_Kinect2_endNoise() {
		if (check_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_Kinect2_endNoise_tr0_tr0()) {
			effect_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_Kinect2_endNoise_tr0();
		}
	}
	
	/* The reactions of state allQuestionsDone. */
	private void react_main_region_BlindMansBluGame_z_allQuestionsDone() {
		if (check_main_region_BlindMansBluGame_z_allQuestionsDone_tr0_tr0()) {
			effect_main_region_BlindMansBluGame_z_allQuestionsDone_tr0();
		}
	}
	
	/* The reactions of state NoRepeat. */
	private void react_main_region_BlindMansBluGame_z_NoRepeat() {
		if (check_main_region_BlindMansBluGame_z_NoRepeat_tr0_tr0()) {
			effect_main_region_BlindMansBluGame_z_NoRepeat_tr0();
		}
	}
	
	/* The reactions of state Repeat. */
	private void react_main_region_BlindMansBluGame_z_Repeat() {
		effect_main_region_BlindMansBluGame_z_Repeat_tr0();
	}
	
	/* The reactions of state NextQuestion. */
	private void react_main_region_BlindMansBluGame_z_NextQuestion() {
		effect_main_region_BlindMansBluGame_z_NextQuestion_tr0();
	}
	
	/* The reactions of state LeaveTheRoom. */
	private void react_main_region_LeaveTheRoom() {
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
		if (check_Leonie_Bupered_Or_Emergency_Stop_EmergencyStop_tr0_tr0()) {
			effect_Leonie_Bupered_Or_Emergency_Stop_EmergencyStop_tr0();
		}
	}
	
	/* The reactions of state null. */
	private void react_main_region_RiddleGame_r1__choice_0() {
		if (check_main_region_RiddleGame_r1__choice_0_tr1_tr1()) {
			effect_main_region_RiddleGame_r1__choice_0_tr1();
		} else {
			effect_main_region_RiddleGame_r1__choice_0_tr0();
		}
	}
	
	/* The reactions of state null. */
	private void react_main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd__choice_0() {
		if (check_main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd__choice_0_tr0_tr0()) {
			effect_main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd__choice_0_tr0();
		} else {
			if (check_main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd__choice_0_tr1_tr1()) {
				effect_main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd__choice_0_tr1();
			} else {
				if (check_main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd__choice_0_tr2_tr2()) {
					effect_main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd__choice_0_tr2();
				} else {
					if (check_main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd__choice_0_tr3_tr3()) {
						effect_main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd__choice_0_tr3();
					} else {
						if (check_main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd__choice_0_tr4_tr4()) {
							effect_main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd__choice_0_tr4();
						} else {
							if (check_main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd__choice_0_tr5_tr5()) {
								effect_main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd__choice_0_tr5();
							} else {
								if (check_main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd__choice_0_tr6_tr6()) {
									effect_main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd__choice_0_tr6();
								} else {
									if (check_main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd__choice_0_tr7_tr7()) {
										effect_main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd__choice_0_tr7();
									} else {
										if (check_main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd__choice_0_tr8_tr8()) {
											effect_main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd__choice_0_tr8();
										} else {
											effect_main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd__choice_0_tr9();
										}
									}
								}
							}
						}
					}
				}
			}
		}
	}
	
	/* The reactions of state null. */
	private void react_main_region_RiddleGame_r1_TellAction_Instructions__choice_0() {
		if (check_main_region_RiddleGame_r1_TellAction_Instructions__choice_0_tr0_tr0()) {
			effect_main_region_RiddleGame_r1_TellAction_Instructions__choice_0_tr0();
		} else {
			if (check_main_region_RiddleGame_r1_TellAction_Instructions__choice_0_tr1_tr1()) {
				effect_main_region_RiddleGame_r1_TellAction_Instructions__choice_0_tr1();
			} else {
				if (check_main_region_RiddleGame_r1_TellAction_Instructions__choice_0_tr2_tr2()) {
					effect_main_region_RiddleGame_r1_TellAction_Instructions__choice_0_tr2();
				} else {
					if (check_main_region_RiddleGame_r1_TellAction_Instructions__choice_0_tr3_tr3()) {
						effect_main_region_RiddleGame_r1_TellAction_Instructions__choice_0_tr3();
					} else {
						if (check_main_region_RiddleGame_r1_TellAction_Instructions__choice_0_tr4_tr4()) {
							effect_main_region_RiddleGame_r1_TellAction_Instructions__choice_0_tr4();
						} else {
							if (check_main_region_RiddleGame_r1_TellAction_Instructions__choice_0_tr5_tr5()) {
								effect_main_region_RiddleGame_r1_TellAction_Instructions__choice_0_tr5();
							} else {
								effect_main_region_RiddleGame_r1_TellAction_Instructions__choice_0_tr6();
							}
						}
					}
				}
			}
		}
	}
	
	/* The reactions of state null. */
	private void react_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAction_Instructions__choice_0() {
		if (check_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAction_Instructions__choice_0_tr0_tr0()) {
			effect_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAction_Instructions__choice_0_tr0();
		} else {
			if (check_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAction_Instructions__choice_0_tr1_tr1()) {
				effect_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAction_Instructions__choice_0_tr1();
			} else {
				if (check_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAction_Instructions__choice_0_tr2_tr2()) {
					effect_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAction_Instructions__choice_0_tr2();
				} else {
					if (check_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAction_Instructions__choice_0_tr3_tr3()) {
						effect_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAction_Instructions__choice_0_tr3();
					} else {
						if (check_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAction_Instructions__choice_0_tr4_tr4()) {
							effect_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAction_Instructions__choice_0_tr4();
						} else {
							if (check_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAction_Instructions__choice_0_tr5_tr5()) {
								effect_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAction_Instructions__choice_0_tr5();
							} else {
								effect_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAction_Instructions__choice_0_tr6();
							}
						}
					}
				}
			}
		}
	}
	
	/* The reactions of state null. */
	private void react_main_region_BlindMansBluGame_z__choice_0() {
		if (check_main_region_BlindMansBluGame_z__choice_0_tr0_tr0()) {
			effect_main_region_BlindMansBluGame_z__choice_0_tr0();
		} else {
			effect_main_region_BlindMansBluGame_z__choice_0_tr1();
		}
	}
	
	/* The reactions of state null. */
	private void react_main_region_BlindMansBluGame_z__choice_1() {
		if (check_main_region_BlindMansBluGame_z__choice_1_tr0_tr0()) {
			effect_main_region_BlindMansBluGame_z__choice_1_tr0();
		} else {
			if (check_main_region_BlindMansBluGame_z__choice_1_tr1_tr1()) {
				effect_main_region_BlindMansBluGame_z__choice_1_tr1();
			} else {
				effect_main_region_BlindMansBluGame_z__choice_1_tr2();
			}
		}
	}
	
	/* The reactions of state null. */
	private void react_main_region_BlindMansBluGame_z__choice_2() {
		effect_main_region_BlindMansBluGame_z__choice_2_tr0();
	}
	
	/* Default react sequence for initial entry  */
	private void react_main_region__entry_Default() {
		enterSequence_main_region_Init_default();
	}
	
	/* Default react sequence for initial entry  */
	private void react_main_region_RiddleGame_r1__entry_Default() {
		enterSequence_main_region_RiddleGame_r1_StartGame_default();
	}
	
	/* Default react sequence for initial entry  */
	private void react_main_region_RiddleGame_r1_TellAction_Instructions__entry_Default() {
		react_main_region_RiddleGame_r1_TellAction_Instructions__choice_0();
	}
	
	/* Default react sequence for initial entry  */
	private void react_main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd__entry_Default() {
		react_main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd__choice_0();
	}
	
	/* Default react sequence for initial entry  */
	private void react_main_region_RiddleGame_r1_TellAction_Instructions_surrounding_surrounding__entry_Default() {
		react_main_region_RiddleGame_r1_TellAction_Instructions_surrounding_surrounding_exit_done();
	}
	
	/* Default react sequence for initial entry  */
	private void react_main_region_BlindMansBluGame_z__entry_Default() {
		enterSequence_main_region_BlindMansBluGame_z_StartGame_default();
	}
	
	/* Default react sequence for initial entry  */
	private void react_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAction_Instructions__entry_Default() {
		react_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAction_Instructions__choice_0();
	}
	
	/* Default react sequence for initial entry  */
	private void react_Leonie_Bupered_Or_Emergency_Stop__entry_Default() {
		enterSequence_Leonie_Bupered_Or_Emergency_Stop_waitForEvent_default();
	}
	
	/* The reactions of exit exit_done. */
	private void react_main_region_RiddleGame_r1_exit_done() {
		effect_main_region_RiddleGame_tr0();
	}
	
	/* The reactions of exit exit_done. */
	private void react_main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_exit_done() {
		effect_main_region_RiddleGame_r1_TellAction_Instructions_crowd_tr0();
	}
	
	/* The reactions of exit exit_done. */
	private void react_main_region_RiddleGame_r1_TellAction_Instructions_surrounding_surrounding_exit_done() {
		effect_main_region_RiddleGame_r1_TellAction_Instructions_surrounding_tr0();
	}
	
	/* The reactions of exit exit_done. */
	private void react_main_region_BlindMansBluGame_z_exit_done() {
		effect_main_region_BlindMansBluGame_tr0();
	}
	
	/* The reactions of state null. */
	private void react_main_region_BlindMansBluGame_z__sync0() {
		enterSequence_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_waitForSTT_default();
		enterSequence_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_Kinect2_WaitForNoise_default();
	}
	
	/* The reactions of state null. */
	private void react_main_region_BlindMansBluGame_z__sync1() {
		react_main_region_BlindMansBluGame_z__choice_0();
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
			case main_region_RiddleGame_r1_StartGame:
				react_main_region_RiddleGame_r1_StartGame();
				break;
			case main_region_RiddleGame_r1_WaitForOperator:
				react_main_region_RiddleGame_r1_WaitForOperator();
				break;
			case main_region_RiddleGame_r1_Hello:
				react_main_region_RiddleGame_r1_Hello();
				break;
			case main_region_RiddleGame_r1_Leave_the_arena:
				react_main_region_RiddleGame_r1_Leave_the_arena();
				break;
			case main_region_RiddleGame_r1_StartSTT:
				react_main_region_RiddleGame_r1_StartSTT();
				break;
			case main_region_RiddleGame_r1_TellAnswer:
				react_main_region_RiddleGame_r1_TellAnswer();
				break;
			case main_region_RiddleGame_r1_PrepareForNextQuestion:
				react_main_region_RiddleGame_r1_PrepareForNextQuestion();
				break;
			case main_region_RiddleGame_r1_TellIncomprehensible:
				react_main_region_RiddleGame_r1_TellIncomprehensible();
				break;
			case main_region_RiddleGame_r1_NextQuestion:
				react_main_region_RiddleGame_r1_NextQuestion();
				break;
			case main_region_RiddleGame_r1_TellAction_Instructions_GoTo:
				react_main_region_RiddleGame_r1_TellAction_Instructions_GoTo();
				break;
			case main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_countAll:
				react_main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_countAll();
				break;
			case main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_countMale:
				react_main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_countMale();
				break;
			case main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_countFemale:
				react_main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_countFemale();
				break;
			case main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_countSitting:
				react_main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_countSitting();
				break;
			case main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_countLaying:
				react_main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_countLaying();
				break;
			case main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_countStanding:
				react_main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_countStanding();
				break;
			case main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_countHandSign:
				react_main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_countHandSign();
				break;
			case main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_countYoung:
				react_main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_countYoung();
				break;
			case main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_countOld:
				react_main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_countOld();
				break;
			case main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_else:
				react_main_region_RiddleGame_r1_TellAction_Instructions_crowd_crowd_else();
				break;
			case main_region_RiddleGame_r1_TellAction_Instructions_surrounding:
				react_main_region_RiddleGame_r1_TellAction_Instructions_surrounding();
				break;
			case main_region_RiddleGame_r1_TellAction_Instructions_bring:
				react_main_region_RiddleGame_r1_TellAction_Instructions_bring();
				break;
			case main_region_RiddleGame_r1_TellAction_Instructions_open:
				react_main_region_RiddleGame_r1_TellAction_Instructions_open();
				break;
			case main_region_RiddleGame_r1_TellAction_Instructions_followme:
				react_main_region_RiddleGame_r1_TellAction_Instructions_followme();
				break;
			case main_region_RiddleGame_r1_TellAction_Instructions_unknown:
				react_main_region_RiddleGame_r1_TellAction_Instructions_unknown();
				break;
			case main_region_RiddleGame_r1_StopSTT:
				react_main_region_RiddleGame_r1_StopSTT();
				break;
			case main_region_BlindMansBluGame_z_StartGame:
				react_main_region_BlindMansBluGame_z_StartGame();
				break;
			case main_region_BlindMansBluGame_z_StartSTT:
				react_main_region_BlindMansBluGame_z_StartSTT();
				break;
			case main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_waitForSTT:
				react_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_waitForSTT();
				break;
			case main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAnswer:
				react_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAnswer();
				break;
			case main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_GoTo:
				react_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_GoTo();
				break;
			case main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_crowd:
				react_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_crowd();
				break;
			case main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_surrounding:
				react_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_surrounding();
				break;
			case main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_bring:
				react_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_bring();
				break;
			case main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_open:
				react_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_open();
				break;
			case main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_followme:
				react_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_followme();
				break;
			case main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_unknown:
				react_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_unknown();
				break;
			case main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellIncomprehensible:
				react_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_TellIncomprehensible();
				break;
			case main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_StopSTT2:
				react_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_StopSTT2();
				break;
			case main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_StopSTT:
				react_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_STT_StopSTT();
				break;
			case main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_Kinect2_WaitForNoise:
				react_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_Kinect2_WaitForNoise();
				break;
			case main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_Kinect2_Turn:
				react_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_Kinect2_Turn();
				break;
			case main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_Kinect2_endNoise:
				react_main_region_BlindMansBluGame_z_ParallelOfSTTAndKinect2_Kinect2_endNoise();
				break;
			case main_region_BlindMansBluGame_z_allQuestionsDone:
				react_main_region_BlindMansBluGame_z_allQuestionsDone();
				break;
			case main_region_BlindMansBluGame_z_NoRepeat:
				react_main_region_BlindMansBluGame_z_NoRepeat();
				break;
			case main_region_BlindMansBluGame_z_Repeat:
				react_main_region_BlindMansBluGame_z_Repeat();
				break;
			case main_region_BlindMansBluGame_z_NextQuestion:
				react_main_region_BlindMansBluGame_z_NextQuestion();
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
			default:
				// $NullState$
			}
		}
		clearEvents();
	}
}
