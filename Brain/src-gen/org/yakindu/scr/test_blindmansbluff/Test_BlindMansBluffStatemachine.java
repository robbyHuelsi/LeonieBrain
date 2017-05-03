package org.yakindu.scr.test_blindmansbluff;
import org.yakindu.scr.ITimer;

public class Test_BlindMansBluffStatemachine implements ITest_BlindMansBluffStatemachine {

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
		blindMansBlufGame_StartGame,
		blindMansBlufGame_StartSTT,
		blindMansBlufGame_ParallelOfSTTAndKinect2,
		blindMansBlufGame_ParallelOfSTTAndKinect2_STT_waitForSTT,
		blindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAnswer,
		blindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction,
		blindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_GoTo,
		blindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_surrounding,
		blindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_bring,
		blindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_open,
		blindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_followme,
		blindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_unknown,
		blindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_Copy_1_crowd,
		blindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellIncomprehensible,
		blindMansBlufGame_ParallelOfSTTAndKinect2_STT_StopSTT2,
		blindMansBlufGame_ParallelOfSTTAndKinect2_STT_StopSTT,
		blindMansBlufGame_ParallelOfSTTAndKinect2_Kinect2_WaitForNoise,
		blindMansBlufGame_ParallelOfSTTAndKinect2_Kinect2_Turn,
		blindMansBlufGame_ParallelOfSTTAndKinect2_Kinect2_endNoise,
		blindMansBlufGame_allQuestionsDone,
		blindMansBlufGame_NoRepeat,
		blindMansBlufGame_Turn,
		blindMansBlufGame_NextQuestion,
		blindMansBlufGame_firstQ,
		blindMansBlufGame_wait,
		blindMansBlufGame__final_,
		blindMansBlufGame_Repeat,
		$NullState$
	};
	
	private final State[] stateVector = new State[2];
	
	private int nextStateIndex;
	
	private ITimer timer;
	
	private final boolean[] timeEvents = new boolean[4];
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
	
	public Test_BlindMansBluffStatemachine() {
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
		for (int i = 0; i < 2; i++) {
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
		enterSequence_BlindMansBlufGame_default();
	}
	
	public void exit() {
		exitSequence_BlindMansBlufGame();
	}
	
	/**
	 * @see IStatemachine#isActive()
	 */
	public boolean isActive() {
		return stateVector[0] != State.$NullState$||stateVector[1] != State.$NullState$;
	}
	
	/** 
	* @see IStatemachine#isFinal()
	*/
	public boolean isFinal() {
		return (stateVector[0] == State.blindMansBlufGame__final_) && (stateVector[1] == State.$NullState$);
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
		case blindMansBlufGame_StartGame:
			return stateVector[0] == State.blindMansBlufGame_StartGame;
		case blindMansBlufGame_StartSTT:
			return stateVector[0] == State.blindMansBlufGame_StartSTT;
		case blindMansBlufGame_ParallelOfSTTAndKinect2:
			return stateVector[0].ordinal() >= State.
					blindMansBlufGame_ParallelOfSTTAndKinect2.ordinal()&& stateVector[0].ordinal() <= State.blindMansBlufGame_ParallelOfSTTAndKinect2_Kinect2_endNoise.ordinal();
		case blindMansBlufGame_ParallelOfSTTAndKinect2_STT_waitForSTT:
			return stateVector[0] == State.blindMansBlufGame_ParallelOfSTTAndKinect2_STT_waitForSTT;
		case blindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAnswer:
			return stateVector[0] == State.blindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAnswer;
		case blindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction:
			return stateVector[0].ordinal() >= State.
					blindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction.ordinal()&& stateVector[0].ordinal() <= State.blindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_Copy_1_crowd.ordinal();
		case blindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_GoTo:
			return stateVector[0] == State.blindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_GoTo;
		case blindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_surrounding:
			return stateVector[0] == State.blindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_surrounding;
		case blindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_bring:
			return stateVector[0] == State.blindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_bring;
		case blindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_open:
			return stateVector[0] == State.blindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_open;
		case blindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_followme:
			return stateVector[0] == State.blindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_followme;
		case blindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_unknown:
			return stateVector[0] == State.blindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_unknown;
		case blindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_Copy_1_crowd:
			return stateVector[0] == State.blindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_Copy_1_crowd;
		case blindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellIncomprehensible:
			return stateVector[0] == State.blindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellIncomprehensible;
		case blindMansBlufGame_ParallelOfSTTAndKinect2_STT_StopSTT2:
			return stateVector[0] == State.blindMansBlufGame_ParallelOfSTTAndKinect2_STT_StopSTT2;
		case blindMansBlufGame_ParallelOfSTTAndKinect2_STT_StopSTT:
			return stateVector[0] == State.blindMansBlufGame_ParallelOfSTTAndKinect2_STT_StopSTT;
		case blindMansBlufGame_ParallelOfSTTAndKinect2_Kinect2_WaitForNoise:
			return stateVector[1] == State.blindMansBlufGame_ParallelOfSTTAndKinect2_Kinect2_WaitForNoise;
		case blindMansBlufGame_ParallelOfSTTAndKinect2_Kinect2_Turn:
			return stateVector[1] == State.blindMansBlufGame_ParallelOfSTTAndKinect2_Kinect2_Turn;
		case blindMansBlufGame_ParallelOfSTTAndKinect2_Kinect2_endNoise:
			return stateVector[1] == State.blindMansBlufGame_ParallelOfSTTAndKinect2_Kinect2_endNoise;
		case blindMansBlufGame_allQuestionsDone:
			return stateVector[0] == State.blindMansBlufGame_allQuestionsDone;
		case blindMansBlufGame_NoRepeat:
			return stateVector[0] == State.blindMansBlufGame_NoRepeat;
		case blindMansBlufGame_Turn:
			return stateVector[0] == State.blindMansBlufGame_Turn;
		case blindMansBlufGame_NextQuestion:
			return stateVector[0] == State.blindMansBlufGame_NextQuestion;
		case blindMansBlufGame_firstQ:
			return stateVector[0] == State.blindMansBlufGame_firstQ;
		case blindMansBlufGame_wait:
			return stateVector[0] == State.blindMansBlufGame_wait;
		case blindMansBlufGame__final_:
			return stateVector[0] == State.blindMansBlufGame__final_;
		case blindMansBlufGame_Repeat:
			return stateVector[0] == State.blindMansBlufGame_Repeat;
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
	
	private boolean check_BlindMansBlufGame_StartGame_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_BlindMansBlufGame_StartSTT_tr0_tr0() {
		return true;
	}
	
	private boolean check_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_waitForSTT_tr0_tr0() {
		return timeEvents[0];
	}
	
	private boolean check_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAnswer_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_GoTo_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_bring_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_open_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_followme_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_unknown_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_Copy_1_crowd_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellIncomprehensible_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_StopSTT2_tr0_Test_BlindMansBluff_BlindMansBlufGame__sync1join_check() {
		return isStateActive(State.blindMansBlufGame_ParallelOfSTTAndKinect2_Kinect2_endNoise);
	}
	
	private boolean check_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_StopSTT_tr0_tr0() {
		return sCISTT.actionReceived;
	}
	
	private boolean check_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_StopSTT_tr1_tr1() {
		return sCISTT.answerReceived;
	}
	
	private boolean check_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_StopSTT_tr2_tr2() {
		return sCISTT.incomprehensible;
	}
	
	private boolean check_BlindMansBlufGame_ParallelOfSTTAndKinect2_Kinect2_WaitForNoise_tr0_tr0() {
		return sCIKinect2.noiseDeviatinWithoutBoneDetected;
	}
	
	private boolean check_BlindMansBlufGame_ParallelOfSTTAndKinect2_Kinect2_WaitForNoise_tr1_tr1() {
		return sCISTT.spokenTextReceived;
	}
	
	private boolean check_BlindMansBlufGame_ParallelOfSTTAndKinect2_Kinect2_WaitForNoise_tr2_tr2() {
		return sCIKinect2.noiseWithBoneDetected;
	}
	
	private boolean check_BlindMansBlufGame_ParallelOfSTTAndKinect2_Kinect2_Turn_tr0_tr0() {
		return sCISTT.spokenTextReceived;
	}
	
	private boolean check_BlindMansBlufGame_ParallelOfSTTAndKinect2_Kinect2_Turn_tr1_tr1() {
		return timeEvents[1];
	}
	
	private boolean check_BlindMansBlufGame_ParallelOfSTTAndKinect2_Kinect2_endNoise_tr0_Test_BlindMansBluff_BlindMansBlufGame__sync1join_check() {
		return isStateActive(State.blindMansBlufGame_ParallelOfSTTAndKinect2_STT_StopSTT2);
	}
	
	private boolean check_BlindMansBlufGame_allQuestionsDone_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_BlindMansBlufGame_NoRepeat_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_BlindMansBlufGame_Turn_tr0_tr0() {
		return timeEvents[2];
	}
	
	private boolean check_BlindMansBlufGame_NextQuestion_tr0_tr0() {
		return true;
	}
	
	private boolean check_BlindMansBlufGame_firstQ_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_BlindMansBlufGame_wait_tr0_tr0() {
		return timeEvents[3];
	}
	
	private boolean check_BlindMansBlufGame_Repeat_tr0_tr0() {
		return true;
	}
	
	private boolean check_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame__choice_0_tr0_tr0() {
		return (sCISTT.operationCallback.getInstruction()== null?"goto" ==null :sCISTT.operationCallback.getInstruction().equals("goto"));
	}
	
	private boolean check_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame__choice_0_tr1_tr1() {
		return (sCISTT.operationCallback.getInstruction()== null?"crowd" ==null :sCISTT.operationCallback.getInstruction().equals("crowd"));
	}
	
	private boolean check_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame__choice_0_tr2_tr2() {
		return (sCISTT.operationCallback.getInstruction()== null?"surrounding" ==null :sCISTT.operationCallback.getInstruction().equals("surrounding"));
	}
	
	private boolean check_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame__choice_0_tr3_tr3() {
		return (sCISTT.operationCallback.getInstruction()== null?"bring" ==null :sCISTT.operationCallback.getInstruction().equals("bring"));
	}
	
	private boolean check_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame__choice_0_tr4_tr4() {
		return (sCISTT.operationCallback.getInstruction()== null?"open" ==null :sCISTT.operationCallback.getInstruction().equals("open"));
	}
	
	private boolean check_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame__choice_0_tr5_tr5() {
		return (sCISTT.operationCallback.getInstruction()== null?"followme" ==null :sCISTT.operationCallback.getInstruction().equals("followme"));
	}
	
	private boolean check_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame__choice_0_tr6_tr6() {
		return true;
	}
	
	private boolean check_BlindMansBlufGame__choice_0_tr0_tr0() {
		return getQuestionCounter()>=6;
	}
	
	private boolean check_BlindMansBlufGame__choice_0_tr1_tr1() {
		return true;
	}
	
	private boolean check_BlindMansBlufGame__choice_1_tr0_tr0() {
		return getQuestionRepeat()>1;
	}
	
	private boolean check_BlindMansBlufGame__choice_1_tr1_tr1() {
		return getQuestionRepeat()==1;
	}
	
	private boolean check_BlindMansBlufGame__choice_1_tr2_tr2() {
		return true;
	}
	
	private boolean check_BlindMansBlufGame__choice_2_tr0() {
		return true;
	}
	
	private void effect_BlindMansBlufGame_StartGame_tr0() {
		exitSequence_BlindMansBlufGame_StartGame();
		enterSequence_BlindMansBlufGame_wait_default();
	}
	
	private void effect_BlindMansBlufGame_StartSTT_tr0() {
		exitSequence_BlindMansBlufGame_StartSTT();
		react_BlindMansBlufGame__sync0();
	}
	
	private void effect_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_waitForSTT_tr0() {
		exitSequence_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_waitForSTT();
		enterSequence_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_StopSTT_default();
	}
	
	private void effect_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAnswer_tr0() {
		exitSequence_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAnswer();
		enterSequence_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_StopSTT2_default();
	}
	
	private void effect_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_tr0() {
		exitSequence_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction();
		enterSequence_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_StopSTT2_default();
	}
	
	private void effect_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_GoTo_tr0() {
		exitSequence_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_GoTo();
	}
	
	private void effect_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_surrounding_tr0() {
		exitSequence_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_surrounding();
	}
	
	private void effect_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_bring_tr0() {
		exitSequence_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_bring();
	}
	
	private void effect_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_open_tr0() {
		exitSequence_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_open();
	}
	
	private void effect_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_followme_tr0() {
		exitSequence_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_followme();
	}
	
	private void effect_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_unknown_tr0() {
		exitSequence_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_unknown();
	}
	
	private void effect_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_Copy_1_crowd_tr0() {
		exitSequence_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_Copy_1_crowd();
	}
	
	private void effect_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellIncomprehensible_tr0() {
		exitSequence_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellIncomprehensible();
		enterSequence_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_StopSTT2_default();
	}
	
	private void effect_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_StopSTT2_tr0() {
		exitSequence_BlindMansBlufGame_ParallelOfSTTAndKinect2();
		react_BlindMansBlufGame__sync1();
	}
	
	private void effect_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_StopSTT_tr0() {
		exitSequence_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_StopSTT();
		enterSequence_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_default();
	}
	
	private void effect_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_StopSTT_tr1() {
		exitSequence_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_StopSTT();
		enterSequence_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAnswer_default();
	}
	
	private void effect_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_StopSTT_tr2() {
		exitSequence_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_StopSTT();
		enterSequence_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellIncomprehensible_default();
	}
	
	private void effect_BlindMansBlufGame_ParallelOfSTTAndKinect2_Kinect2_WaitForNoise_tr0() {
		exitSequence_BlindMansBlufGame_ParallelOfSTTAndKinect2_Kinect2_WaitForNoise();
		enterSequence_BlindMansBlufGame_ParallelOfSTTAndKinect2_Kinect2_Turn_default();
	}
	
	private void effect_BlindMansBlufGame_ParallelOfSTTAndKinect2_Kinect2_WaitForNoise_tr1() {
		exitSequence_BlindMansBlufGame_ParallelOfSTTAndKinect2_Kinect2_WaitForNoise();
		enterSequence_BlindMansBlufGame_ParallelOfSTTAndKinect2_Kinect2_endNoise_default();
	}
	
	private void effect_BlindMansBlufGame_ParallelOfSTTAndKinect2_Kinect2_WaitForNoise_tr2() {
		exitSequence_BlindMansBlufGame_ParallelOfSTTAndKinect2_Kinect2_WaitForNoise();
		enterSequence_BlindMansBlufGame_ParallelOfSTTAndKinect2_Kinect2_Turn_default();
	}
	
	private void effect_BlindMansBlufGame_ParallelOfSTTAndKinect2_Kinect2_Turn_tr0() {
		exitSequence_BlindMansBlufGame_ParallelOfSTTAndKinect2_Kinect2_Turn();
		enterSequence_BlindMansBlufGame_ParallelOfSTTAndKinect2_Kinect2_endNoise_default();
	}
	
	private void effect_BlindMansBlufGame_ParallelOfSTTAndKinect2_Kinect2_Turn_tr1() {
		exitSequence_BlindMansBlufGame_ParallelOfSTTAndKinect2_Kinect2_Turn();
		enterSequence_BlindMansBlufGame_ParallelOfSTTAndKinect2_Kinect2_WaitForNoise_default();
	}
	
	private void effect_BlindMansBlufGame_ParallelOfSTTAndKinect2_Kinect2_endNoise_tr0() {
		exitSequence_BlindMansBlufGame_ParallelOfSTTAndKinect2();
		react_BlindMansBlufGame__sync1();
	}
	
	private void effect_BlindMansBlufGame_allQuestionsDone_tr0() {
		exitSequence_BlindMansBlufGame_allQuestionsDone();
		enterSequence_BlindMansBlufGame__final__default();
	}
	
	private void effect_BlindMansBlufGame_NoRepeat_tr0() {
		exitSequence_BlindMansBlufGame_NoRepeat();
		react_BlindMansBlufGame__choice_0();
	}
	
	private void effect_BlindMansBlufGame_Turn_tr0() {
		exitSequence_BlindMansBlufGame_Turn();
		enterSequence_BlindMansBlufGame_Repeat_default();
	}
	
	private void effect_BlindMansBlufGame_NextQuestion_tr0() {
		exitSequence_BlindMansBlufGame_NextQuestion();
		react_BlindMansBlufGame__choice_2();
	}
	
	private void effect_BlindMansBlufGame_firstQ_tr0() {
		exitSequence_BlindMansBlufGame_firstQ();
		enterSequence_BlindMansBlufGame_StartSTT_default();
	}
	
	private void effect_BlindMansBlufGame_wait_tr0() {
		exitSequence_BlindMansBlufGame_wait();
		enterSequence_BlindMansBlufGame_firstQ_default();
	}
	
	private void effect_BlindMansBlufGame_Repeat_tr0() {
		exitSequence_BlindMansBlufGame_Repeat();
		react_BlindMansBlufGame__choice_2();
	}
	
	private void effect_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame__choice_0_tr0() {
		enterSequence_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_GoTo_default();
	}
	
	private void effect_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame__choice_0_tr1() {
		enterSequence_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_Copy_1_crowd_default();
	}
	
	private void effect_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame__choice_0_tr2() {
		enterSequence_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_surrounding_default();
	}
	
	private void effect_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame__choice_0_tr3() {
		enterSequence_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_bring_default();
	}
	
	private void effect_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame__choice_0_tr4() {
		enterSequence_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_open_default();
	}
	
	private void effect_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame__choice_0_tr5() {
		enterSequence_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_followme_default();
	}
	
	private void effect_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame__choice_0_tr6() {
		enterSequence_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_unknown_default();
	}
	
	private void effect_BlindMansBlufGame__choice_0_tr0() {
		enterSequence_BlindMansBlufGame_allQuestionsDone_default();
	}
	
	private void effect_BlindMansBlufGame__choice_0_tr1() {
		react_BlindMansBlufGame__choice_1();
	}
	
	private void effect_BlindMansBlufGame__choice_1_tr0() {
		enterSequence_BlindMansBlufGame_NoRepeat_default();
	}
	
	private void effect_BlindMansBlufGame__choice_1_tr1() {
		enterSequence_BlindMansBlufGame_Turn_default();
	}
	
	private void effect_BlindMansBlufGame__choice_1_tr2() {
		enterSequence_BlindMansBlufGame_NextQuestion_default();
	}
	
	private void effect_BlindMansBlufGame__choice_2_tr0() {
		enterSequence_BlindMansBlufGame_StartSTT_default();
	}
	
	/* Entry action for state 'StartGame'. */
	private void entryAction_BlindMansBlufGame_StartGame() {
		setQuestionCounter(0);
		
		setQuestionRepeat(0);
		
		sCIHBrain.operationCallback.sendTTS("I'm ready for the blind mans bluff game. [:-)] Please stand in a circle close to me. I will start in 5 seconds.");
	}
	
	/* Entry action for state 'StartSTT'. */
	private void entryAction_BlindMansBlufGame_StartSTT() {
		sCISTT.operationCallback.sendSpeechDetectionSmalltalk();
		
		sCIKinect2.operationCallback.sendNoiseDetectionOnOff(true);
	}
	
	/* Entry action for state 'waitForSTT'. */
	private void entryAction_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_waitForSTT() {
		timer.setTimer(this, 0, 5*1000, false);
		
		sCIHBrain.operationCallback.sendTTS("[attentive]");
	}
	
	/* Entry action for state 'TellAnswer'. */
	private void entryAction_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAnswer() {
		sCIHBrain.operationCallback.sendTTS2(sCISTT.operationCallback.getAnswer(), " [:-)]");
		
		setQuestionCounter(getQuestionCounter() + 1);
		
		setQuestionRepeat(0);
	}
	
	/* Entry action for state 'TellAction'. */
	private void entryAction_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction() {
		setQuestionCounter(getQuestionCounter() + 1);
		
		setQuestionRepeat(0);
	}
	
	/* Entry action for state 'GoTo'. */
	private void entryAction_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_GoTo() {
		sCIHBrain.operationCallback.sendTTS("[:-(] Sorry. I'm can't go to somewhere now.");
	}
	
	/* Entry action for state 'bring'. */
	private void entryAction_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_bring() {
		sCIHBrain.operationCallback.sendTTS("[:-(] Sorry. I'm can't bring something at the moment.");
	}
	
	/* Entry action for state 'open'. */
	private void entryAction_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_open() {
		sCIHBrain.operationCallback.sendTTS("[:-(] Sorry. I'm can't open something at the moment.");
	}
	
	/* Entry action for state 'followme'. */
	private void entryAction_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_followme() {
		sCIHBrain.operationCallback.sendTTS("[:-(] Sorry. I'm can't follow you now.");
	}
	
	/* Entry action for state 'unknown'. */
	private void entryAction_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_unknown() {
		sCIHBrain.operationCallback.sendTTS("[:-(] Sorry. I didn't get what I should do.");
	}
	
	/* Entry action for state 'Copy_1_crowd'. */
	private void entryAction_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_Copy_1_crowd() {
		sCIHBrain.operationCallback.sendTTS(sCICrowdDetection.operationCallback.getAnswerForSecificCrowdDetails(sCISTT.operationCallback.getObject()));
	}
	
	/* Entry action for state 'TellIncomprehensible'. */
	private void entryAction_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellIncomprehensible() {
		sCIHBrain.operationCallback.sendTTS3("[:-(]", sCISTT.operationCallback.getAnswer(), "[:-|]");
		
		setQuestionRepeat(getQuestionRepeat() + 1);
	}
	
	/* Entry action for state 'StopSTT2'. */
	private void entryAction_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_StopSTT2() {
		sCISTT.operationCallback.sendSpeechDetectionOff();
	}
	
	/* Entry action for state 'StopSTT'. */
	private void entryAction_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_StopSTT() {
		sCISTT.operationCallback.sendSpeechDetectionOff();
		
		sCIHBrain.operationCallback.sendTTS("[:-)]");
	}
	
	/* Entry action for state 'Turn'. */
	private void entryAction_BlindMansBlufGame_ParallelOfSTTAndKinect2_Kinect2_Turn() {
		timer.setTimer(this, 1, 500, false);
		
		sCIMira.operationCallback.sendTurnBody(sCIKinect2.operationCallback.getNoiseAngle());
	}
	
	/* Entry action for state 'endNoise'. */
	private void entryAction_BlindMansBlufGame_ParallelOfSTTAndKinect2_Kinect2_endNoise() {
		sCIKinect2.operationCallback.sendNoiseDetectionOnOff(false);
	}
	
	/* Entry action for state 'allQuestionsDone'. */
	private void entryAction_BlindMansBlufGame_allQuestionsDone() {
		sCIHBrain.operationCallback.sendTTS("Okay. Thats all.");
	}
	
	/* Entry action for state 'NoRepeat'. */
	private void entryAction_BlindMansBlufGame_NoRepeat() {
		sCIHBrain.operationCallback.sendTTS("I'm so sorry! I have no answer for you [:-(]");
		
		setQuestionCounter(getQuestionCounter() + 1);
		
		setQuestionRepeat(0);
	}
	
	/* Entry action for state 'Turn'. */
	private void entryAction_BlindMansBlufGame_Turn() {
		timer.setTimer(this, 2, 2*1000, false);
		
		sCIMira.operationCallback.sendBodyUTurn();
	}
	
	/* Entry action for state 'NextQuestion'. */
	private void entryAction_BlindMansBlufGame_NextQuestion() {
		sCIHBrain.operationCallback.sendTTS("Please ask me the next question. [attentive]");
	}
	
	/* Entry action for state 'firstQ'. */
	private void entryAction_BlindMansBlufGame_firstQ() {
		sCIHBrain.operationCallback.sendTTS("I'm ready for the blind mans bluff game. [:-)] Ask me the first question. [attentive]");
	}
	
	/* Entry action for state 'wait'. */
	private void entryAction_BlindMansBlufGame_wait() {
		timer.setTimer(this, 3, 5*1000, false);
	}
	
	/* Entry action for state 'Repeat'. */
	private void entryAction_BlindMansBlufGame_Repeat() {
		sCIHBrain.operationCallback.sendTTS("Please repeat the question. [attentive]");
	}
	
	/* Exit action for state 'waitForSTT'. */
	private void exitAction_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_waitForSTT() {
		timer.unsetTimer(this, 0);
	}
	
	/* Exit action for state 'Turn'. */
	private void exitAction_BlindMansBlufGame_ParallelOfSTTAndKinect2_Kinect2_Turn() {
		timer.unsetTimer(this, 1);
	}
	
	/* Exit action for state 'Turn'. */
	private void exitAction_BlindMansBlufGame_Turn() {
		timer.unsetTimer(this, 2);
	}
	
	/* Exit action for state 'wait'. */
	private void exitAction_BlindMansBlufGame_wait() {
		timer.unsetTimer(this, 3);
	}
	
	/* 'default' enter sequence for state StartGame */
	private void enterSequence_BlindMansBlufGame_StartGame_default() {
		entryAction_BlindMansBlufGame_StartGame();
		nextStateIndex = 0;
		stateVector[0] = State.blindMansBlufGame_StartGame;
	}
	
	/* 'default' enter sequence for state StartSTT */
	private void enterSequence_BlindMansBlufGame_StartSTT_default() {
		entryAction_BlindMansBlufGame_StartSTT();
		nextStateIndex = 0;
		stateVector[0] = State.blindMansBlufGame_StartSTT;
	}
	
	/* 'default' enter sequence for state waitForSTT */
	private void enterSequence_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_waitForSTT_default() {
		entryAction_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_waitForSTT();
		nextStateIndex = 0;
		stateVector[0] = State.blindMansBlufGame_ParallelOfSTTAndKinect2_STT_waitForSTT;
	}
	
	/* 'default' enter sequence for state TellAnswer */
	private void enterSequence_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAnswer_default() {
		entryAction_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAnswer();
		nextStateIndex = 0;
		stateVector[0] = State.blindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAnswer;
	}
	
	/* 'default' enter sequence for state TellAction */
	private void enterSequence_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_default() {
		entryAction_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction();
		enterSequence_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_default();
	}
	
	/* 'default' enter sequence for state GoTo */
	private void enterSequence_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_GoTo_default() {
		entryAction_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_GoTo();
		nextStateIndex = 0;
		stateVector[0] = State.blindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_GoTo;
	}
	
	/* 'default' enter sequence for state surrounding */
	private void enterSequence_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_surrounding_default() {
		nextStateIndex = 0;
		stateVector[0] = State.blindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_surrounding;
	}
	
	/* 'default' enter sequence for state bring */
	private void enterSequence_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_bring_default() {
		entryAction_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_bring();
		nextStateIndex = 0;
		stateVector[0] = State.blindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_bring;
	}
	
	/* 'default' enter sequence for state open */
	private void enterSequence_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_open_default() {
		entryAction_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_open();
		nextStateIndex = 0;
		stateVector[0] = State.blindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_open;
	}
	
	/* 'default' enter sequence for state followme */
	private void enterSequence_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_followme_default() {
		entryAction_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_followme();
		nextStateIndex = 0;
		stateVector[0] = State.blindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_followme;
	}
	
	/* 'default' enter sequence for state unknown */
	private void enterSequence_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_unknown_default() {
		entryAction_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_unknown();
		nextStateIndex = 0;
		stateVector[0] = State.blindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_unknown;
	}
	
	/* 'default' enter sequence for state Copy_1_crowd */
	private void enterSequence_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_Copy_1_crowd_default() {
		entryAction_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_Copy_1_crowd();
		nextStateIndex = 0;
		stateVector[0] = State.blindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_Copy_1_crowd;
	}
	
	/* 'default' enter sequence for state TellIncomprehensible */
	private void enterSequence_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellIncomprehensible_default() {
		entryAction_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellIncomprehensible();
		nextStateIndex = 0;
		stateVector[0] = State.blindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellIncomprehensible;
	}
	
	/* 'default' enter sequence for state StopSTT2 */
	private void enterSequence_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_StopSTT2_default() {
		entryAction_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_StopSTT2();
		nextStateIndex = 0;
		stateVector[0] = State.blindMansBlufGame_ParallelOfSTTAndKinect2_STT_StopSTT2;
	}
	
	/* 'default' enter sequence for state StopSTT */
	private void enterSequence_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_StopSTT_default() {
		entryAction_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_StopSTT();
		nextStateIndex = 0;
		stateVector[0] = State.blindMansBlufGame_ParallelOfSTTAndKinect2_STT_StopSTT;
	}
	
	/* 'default' enter sequence for state WaitForNoise */
	private void enterSequence_BlindMansBlufGame_ParallelOfSTTAndKinect2_Kinect2_WaitForNoise_default() {
		nextStateIndex = 1;
		stateVector[1] = State.blindMansBlufGame_ParallelOfSTTAndKinect2_Kinect2_WaitForNoise;
	}
	
	/* 'default' enter sequence for state Turn */
	private void enterSequence_BlindMansBlufGame_ParallelOfSTTAndKinect2_Kinect2_Turn_default() {
		entryAction_BlindMansBlufGame_ParallelOfSTTAndKinect2_Kinect2_Turn();
		nextStateIndex = 1;
		stateVector[1] = State.blindMansBlufGame_ParallelOfSTTAndKinect2_Kinect2_Turn;
	}
	
	/* 'default' enter sequence for state endNoise */
	private void enterSequence_BlindMansBlufGame_ParallelOfSTTAndKinect2_Kinect2_endNoise_default() {
		entryAction_BlindMansBlufGame_ParallelOfSTTAndKinect2_Kinect2_endNoise();
		nextStateIndex = 1;
		stateVector[1] = State.blindMansBlufGame_ParallelOfSTTAndKinect2_Kinect2_endNoise;
	}
	
	/* 'default' enter sequence for state allQuestionsDone */
	private void enterSequence_BlindMansBlufGame_allQuestionsDone_default() {
		entryAction_BlindMansBlufGame_allQuestionsDone();
		nextStateIndex = 0;
		stateVector[0] = State.blindMansBlufGame_allQuestionsDone;
	}
	
	/* 'default' enter sequence for state NoRepeat */
	private void enterSequence_BlindMansBlufGame_NoRepeat_default() {
		entryAction_BlindMansBlufGame_NoRepeat();
		nextStateIndex = 0;
		stateVector[0] = State.blindMansBlufGame_NoRepeat;
	}
	
	/* 'default' enter sequence for state Turn */
	private void enterSequence_BlindMansBlufGame_Turn_default() {
		entryAction_BlindMansBlufGame_Turn();
		nextStateIndex = 0;
		stateVector[0] = State.blindMansBlufGame_Turn;
	}
	
	/* 'default' enter sequence for state NextQuestion */
	private void enterSequence_BlindMansBlufGame_NextQuestion_default() {
		entryAction_BlindMansBlufGame_NextQuestion();
		nextStateIndex = 0;
		stateVector[0] = State.blindMansBlufGame_NextQuestion;
	}
	
	/* 'default' enter sequence for state firstQ */
	private void enterSequence_BlindMansBlufGame_firstQ_default() {
		entryAction_BlindMansBlufGame_firstQ();
		nextStateIndex = 0;
		stateVector[0] = State.blindMansBlufGame_firstQ;
	}
	
	/* 'default' enter sequence for state wait */
	private void enterSequence_BlindMansBlufGame_wait_default() {
		entryAction_BlindMansBlufGame_wait();
		nextStateIndex = 0;
		stateVector[0] = State.blindMansBlufGame_wait;
	}
	
	/* Default enter sequence for state null */
	private void enterSequence_BlindMansBlufGame__final__default() {
		nextStateIndex = 0;
		stateVector[0] = State.blindMansBlufGame__final_;
	}
	
	/* 'default' enter sequence for state Repeat */
	private void enterSequence_BlindMansBlufGame_Repeat_default() {
		entryAction_BlindMansBlufGame_Repeat();
		nextStateIndex = 0;
		stateVector[0] = State.blindMansBlufGame_Repeat;
	}
	
	/* 'default' enter sequence for region BlindMansBlufGame */
	private void enterSequence_BlindMansBlufGame_default() {
		react_BlindMansBlufGame__entry_Default();
	}
	
	/* 'default' enter sequence for region Instructions BlindMansBlufGame */
	private void enterSequence_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_default() {
		react_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame__entry_Default();
	}
	
	/* Default exit sequence for state StartGame */
	private void exitSequence_BlindMansBlufGame_StartGame() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state StartSTT */
	private void exitSequence_BlindMansBlufGame_StartSTT() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state ParallelOfSTTAndKinect2 */
	private void exitSequence_BlindMansBlufGame_ParallelOfSTTAndKinect2() {
		exitSequence_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT();
		exitSequence_BlindMansBlufGame_ParallelOfSTTAndKinect2_Kinect2();
	}
	
	/* Default exit sequence for state waitForSTT */
	private void exitSequence_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_waitForSTT() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
		
		exitAction_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_waitForSTT();
	}
	
	/* Default exit sequence for state TellAnswer */
	private void exitSequence_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAnswer() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state TellAction */
	private void exitSequence_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction() {
		exitSequence_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame();
	}
	
	/* Default exit sequence for state GoTo */
	private void exitSequence_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_GoTo() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state surrounding */
	private void exitSequence_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_surrounding() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state bring */
	private void exitSequence_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_bring() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state open */
	private void exitSequence_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_open() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state followme */
	private void exitSequence_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_followme() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state unknown */
	private void exitSequence_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_unknown() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state Copy_1_crowd */
	private void exitSequence_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_Copy_1_crowd() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state TellIncomprehensible */
	private void exitSequence_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellIncomprehensible() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state StopSTT2 */
	private void exitSequence_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_StopSTT2() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state StopSTT */
	private void exitSequence_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_StopSTT() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state WaitForNoise */
	private void exitSequence_BlindMansBlufGame_ParallelOfSTTAndKinect2_Kinect2_WaitForNoise() {
		nextStateIndex = 1;
		stateVector[1] = State.$NullState$;
	}
	
	/* Default exit sequence for state Turn */
	private void exitSequence_BlindMansBlufGame_ParallelOfSTTAndKinect2_Kinect2_Turn() {
		nextStateIndex = 1;
		stateVector[1] = State.$NullState$;
		
		exitAction_BlindMansBlufGame_ParallelOfSTTAndKinect2_Kinect2_Turn();
	}
	
	/* Default exit sequence for state endNoise */
	private void exitSequence_BlindMansBlufGame_ParallelOfSTTAndKinect2_Kinect2_endNoise() {
		nextStateIndex = 1;
		stateVector[1] = State.$NullState$;
	}
	
	/* Default exit sequence for state allQuestionsDone */
	private void exitSequence_BlindMansBlufGame_allQuestionsDone() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state NoRepeat */
	private void exitSequence_BlindMansBlufGame_NoRepeat() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state Turn */
	private void exitSequence_BlindMansBlufGame_Turn() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
		
		exitAction_BlindMansBlufGame_Turn();
	}
	
	/* Default exit sequence for state NextQuestion */
	private void exitSequence_BlindMansBlufGame_NextQuestion() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state firstQ */
	private void exitSequence_BlindMansBlufGame_firstQ() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state wait */
	private void exitSequence_BlindMansBlufGame_wait() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
		
		exitAction_BlindMansBlufGame_wait();
	}
	
	/* Default exit sequence for final state. */
	private void exitSequence_BlindMansBlufGame__final_() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state Repeat */
	private void exitSequence_BlindMansBlufGame_Repeat() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for region BlindMansBlufGame */
	private void exitSequence_BlindMansBlufGame() {
		switch (stateVector[0]) {
		case blindMansBlufGame_StartGame:
			exitSequence_BlindMansBlufGame_StartGame();
			break;
		case blindMansBlufGame_StartSTT:
			exitSequence_BlindMansBlufGame_StartSTT();
			break;
		case blindMansBlufGame_ParallelOfSTTAndKinect2_STT_waitForSTT:
			exitSequence_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_waitForSTT();
			break;
		case blindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAnswer:
			exitSequence_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAnswer();
			break;
		case blindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_GoTo:
			exitSequence_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_GoTo();
			break;
		case blindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_surrounding:
			exitSequence_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_surrounding();
			break;
		case blindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_bring:
			exitSequence_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_bring();
			break;
		case blindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_open:
			exitSequence_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_open();
			break;
		case blindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_followme:
			exitSequence_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_followme();
			break;
		case blindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_unknown:
			exitSequence_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_unknown();
			break;
		case blindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_Copy_1_crowd:
			exitSequence_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_Copy_1_crowd();
			break;
		case blindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellIncomprehensible:
			exitSequence_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellIncomprehensible();
			break;
		case blindMansBlufGame_ParallelOfSTTAndKinect2_STT_StopSTT2:
			exitSequence_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_StopSTT2();
			break;
		case blindMansBlufGame_ParallelOfSTTAndKinect2_STT_StopSTT:
			exitSequence_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_StopSTT();
			break;
		case blindMansBlufGame_allQuestionsDone:
			exitSequence_BlindMansBlufGame_allQuestionsDone();
			break;
		case blindMansBlufGame_NoRepeat:
			exitSequence_BlindMansBlufGame_NoRepeat();
			break;
		case blindMansBlufGame_Turn:
			exitSequence_BlindMansBlufGame_Turn();
			break;
		case blindMansBlufGame_NextQuestion:
			exitSequence_BlindMansBlufGame_NextQuestion();
			break;
		case blindMansBlufGame_firstQ:
			exitSequence_BlindMansBlufGame_firstQ();
			break;
		case blindMansBlufGame_wait:
			exitSequence_BlindMansBlufGame_wait();
			break;
		case blindMansBlufGame__final_:
			exitSequence_BlindMansBlufGame__final_();
			break;
		case blindMansBlufGame_Repeat:
			exitSequence_BlindMansBlufGame_Repeat();
			break;
		default:
			break;
		}
		
		switch (stateVector[1]) {
		case blindMansBlufGame_ParallelOfSTTAndKinect2_Kinect2_WaitForNoise:
			exitSequence_BlindMansBlufGame_ParallelOfSTTAndKinect2_Kinect2_WaitForNoise();
			break;
		case blindMansBlufGame_ParallelOfSTTAndKinect2_Kinect2_Turn:
			exitSequence_BlindMansBlufGame_ParallelOfSTTAndKinect2_Kinect2_Turn();
			break;
		case blindMansBlufGame_ParallelOfSTTAndKinect2_Kinect2_endNoise:
			exitSequence_BlindMansBlufGame_ParallelOfSTTAndKinect2_Kinect2_endNoise();
			break;
		default:
			break;
		}
	}
	
	/* Default exit sequence for region STT */
	private void exitSequence_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT() {
		switch (stateVector[0]) {
		case blindMansBlufGame_ParallelOfSTTAndKinect2_STT_waitForSTT:
			exitSequence_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_waitForSTT();
			break;
		case blindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAnswer:
			exitSequence_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAnswer();
			break;
		case blindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_GoTo:
			exitSequence_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_GoTo();
			break;
		case blindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_surrounding:
			exitSequence_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_surrounding();
			break;
		case blindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_bring:
			exitSequence_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_bring();
			break;
		case blindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_open:
			exitSequence_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_open();
			break;
		case blindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_followme:
			exitSequence_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_followme();
			break;
		case blindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_unknown:
			exitSequence_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_unknown();
			break;
		case blindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_Copy_1_crowd:
			exitSequence_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_Copy_1_crowd();
			break;
		case blindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellIncomprehensible:
			exitSequence_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellIncomprehensible();
			break;
		case blindMansBlufGame_ParallelOfSTTAndKinect2_STT_StopSTT2:
			exitSequence_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_StopSTT2();
			break;
		case blindMansBlufGame_ParallelOfSTTAndKinect2_STT_StopSTT:
			exitSequence_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_StopSTT();
			break;
		default:
			break;
		}
	}
	
	/* Default exit sequence for region Instructions BlindMansBlufGame */
	private void exitSequence_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame() {
		switch (stateVector[0]) {
		case blindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_GoTo:
			exitSequence_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_GoTo();
			break;
		case blindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_surrounding:
			exitSequence_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_surrounding();
			break;
		case blindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_bring:
			exitSequence_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_bring();
			break;
		case blindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_open:
			exitSequence_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_open();
			break;
		case blindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_followme:
			exitSequence_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_followme();
			break;
		case blindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_unknown:
			exitSequence_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_unknown();
			break;
		case blindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_Copy_1_crowd:
			exitSequence_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_Copy_1_crowd();
			break;
		default:
			break;
		}
	}
	
	/* Default exit sequence for region Kinect2 */
	private void exitSequence_BlindMansBlufGame_ParallelOfSTTAndKinect2_Kinect2() {
		switch (stateVector[1]) {
		case blindMansBlufGame_ParallelOfSTTAndKinect2_Kinect2_WaitForNoise:
			exitSequence_BlindMansBlufGame_ParallelOfSTTAndKinect2_Kinect2_WaitForNoise();
			break;
		case blindMansBlufGame_ParallelOfSTTAndKinect2_Kinect2_Turn:
			exitSequence_BlindMansBlufGame_ParallelOfSTTAndKinect2_Kinect2_Turn();
			break;
		case blindMansBlufGame_ParallelOfSTTAndKinect2_Kinect2_endNoise:
			exitSequence_BlindMansBlufGame_ParallelOfSTTAndKinect2_Kinect2_endNoise();
			break;
		default:
			break;
		}
	}
	
	/* The reactions of state StartGame. */
	private void react_BlindMansBlufGame_StartGame() {
		if (check_BlindMansBlufGame_StartGame_tr0_tr0()) {
			effect_BlindMansBlufGame_StartGame_tr0();
		}
	}
	
	/* The reactions of state StartSTT. */
	private void react_BlindMansBlufGame_StartSTT() {
		effect_BlindMansBlufGame_StartSTT_tr0();
	}
	
	/* The reactions of state waitForSTT. */
	private void react_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_waitForSTT() {
		if (check_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_waitForSTT_tr0_tr0()) {
			effect_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_waitForSTT_tr0();
		}
	}
	
	/* The reactions of state TellAnswer. */
	private void react_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAnswer() {
		if (check_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAnswer_tr0_tr0()) {
			effect_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAnswer_tr0();
		}
	}
	
	/* The reactions of state GoTo. */
	private void react_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_GoTo() {
		if (check_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_tr0_tr0()) {
			effect_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_tr0();
		} else {
			if (check_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_GoTo_tr0_tr0()) {
				effect_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_GoTo_tr0();
			}
		}
	}
	
	/* The reactions of state surrounding. */
	private void react_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_surrounding() {
		if (check_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_tr0_tr0()) {
			effect_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_tr0();
		} else {
		}
	}
	
	/* The reactions of state bring. */
	private void react_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_bring() {
		if (check_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_tr0_tr0()) {
			effect_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_tr0();
		} else {
			if (check_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_bring_tr0_tr0()) {
				effect_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_bring_tr0();
			}
		}
	}
	
	/* The reactions of state open. */
	private void react_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_open() {
		if (check_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_tr0_tr0()) {
			effect_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_tr0();
		} else {
			if (check_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_open_tr0_tr0()) {
				effect_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_open_tr0();
			}
		}
	}
	
	/* The reactions of state followme. */
	private void react_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_followme() {
		if (check_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_tr0_tr0()) {
			effect_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_tr0();
		} else {
			if (check_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_followme_tr0_tr0()) {
				effect_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_followme_tr0();
			}
		}
	}
	
	/* The reactions of state unknown. */
	private void react_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_unknown() {
		if (check_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_tr0_tr0()) {
			effect_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_tr0();
		} else {
			if (check_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_unknown_tr0_tr0()) {
				effect_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_unknown_tr0();
			}
		}
	}
	
	/* The reactions of state Copy_1_crowd. */
	private void react_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_Copy_1_crowd() {
		if (check_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_tr0_tr0()) {
			effect_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_tr0();
		} else {
			if (check_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_Copy_1_crowd_tr0_tr0()) {
				effect_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_Copy_1_crowd_tr0();
			}
		}
	}
	
	/* The reactions of state TellIncomprehensible. */
	private void react_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellIncomprehensible() {
		if (check_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellIncomprehensible_tr0_tr0()) {
			effect_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellIncomprehensible_tr0();
		}
	}
	
	/* The reactions of state StopSTT2. */
	private void react_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_StopSTT2() {
		if (check_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_StopSTT2_tr0_Test_BlindMansBluff_BlindMansBlufGame__sync1join_check()) {
			effect_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_StopSTT2_tr0();
		}
	}
	
	/* The reactions of state StopSTT. */
	private void react_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_StopSTT() {
		if (check_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_StopSTT_tr0_tr0()) {
			effect_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_StopSTT_tr0();
		} else {
			if (check_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_StopSTT_tr1_tr1()) {
				effect_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_StopSTT_tr1();
			} else {
				if (check_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_StopSTT_tr2_tr2()) {
					effect_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_StopSTT_tr2();
				}
			}
		}
	}
	
	/* The reactions of state WaitForNoise. */
	private void react_BlindMansBlufGame_ParallelOfSTTAndKinect2_Kinect2_WaitForNoise() {
		if (check_BlindMansBlufGame_ParallelOfSTTAndKinect2_Kinect2_WaitForNoise_tr0_tr0()) {
			effect_BlindMansBlufGame_ParallelOfSTTAndKinect2_Kinect2_WaitForNoise_tr0();
		} else {
			if (check_BlindMansBlufGame_ParallelOfSTTAndKinect2_Kinect2_WaitForNoise_tr1_tr1()) {
				effect_BlindMansBlufGame_ParallelOfSTTAndKinect2_Kinect2_WaitForNoise_tr1();
			} else {
				if (check_BlindMansBlufGame_ParallelOfSTTAndKinect2_Kinect2_WaitForNoise_tr2_tr2()) {
					effect_BlindMansBlufGame_ParallelOfSTTAndKinect2_Kinect2_WaitForNoise_tr2();
				}
			}
		}
	}
	
	/* The reactions of state Turn. */
	private void react_BlindMansBlufGame_ParallelOfSTTAndKinect2_Kinect2_Turn() {
		if (check_BlindMansBlufGame_ParallelOfSTTAndKinect2_Kinect2_Turn_tr0_tr0()) {
			effect_BlindMansBlufGame_ParallelOfSTTAndKinect2_Kinect2_Turn_tr0();
		} else {
			if (check_BlindMansBlufGame_ParallelOfSTTAndKinect2_Kinect2_Turn_tr1_tr1()) {
				effect_BlindMansBlufGame_ParallelOfSTTAndKinect2_Kinect2_Turn_tr1();
			}
		}
	}
	
	/* The reactions of state endNoise. */
	private void react_BlindMansBlufGame_ParallelOfSTTAndKinect2_Kinect2_endNoise() {
		if (check_BlindMansBlufGame_ParallelOfSTTAndKinect2_Kinect2_endNoise_tr0_Test_BlindMansBluff_BlindMansBlufGame__sync1join_check()) {
			effect_BlindMansBlufGame_ParallelOfSTTAndKinect2_Kinect2_endNoise_tr0();
		}
	}
	
	/* The reactions of state allQuestionsDone. */
	private void react_BlindMansBlufGame_allQuestionsDone() {
		if (check_BlindMansBlufGame_allQuestionsDone_tr0_tr0()) {
			effect_BlindMansBlufGame_allQuestionsDone_tr0();
		}
	}
	
	/* The reactions of state NoRepeat. */
	private void react_BlindMansBlufGame_NoRepeat() {
		if (check_BlindMansBlufGame_NoRepeat_tr0_tr0()) {
			effect_BlindMansBlufGame_NoRepeat_tr0();
		}
	}
	
	/* The reactions of state Turn. */
	private void react_BlindMansBlufGame_Turn() {
		if (check_BlindMansBlufGame_Turn_tr0_tr0()) {
			effect_BlindMansBlufGame_Turn_tr0();
		}
	}
	
	/* The reactions of state NextQuestion. */
	private void react_BlindMansBlufGame_NextQuestion() {
		effect_BlindMansBlufGame_NextQuestion_tr0();
	}
	
	/* The reactions of state firstQ. */
	private void react_BlindMansBlufGame_firstQ() {
		if (check_BlindMansBlufGame_firstQ_tr0_tr0()) {
			effect_BlindMansBlufGame_firstQ_tr0();
		}
	}
	
	/* The reactions of state wait. */
	private void react_BlindMansBlufGame_wait() {
		if (check_BlindMansBlufGame_wait_tr0_tr0()) {
			effect_BlindMansBlufGame_wait_tr0();
		}
	}
	
	/* The reactions of state null. */
	private void react_BlindMansBlufGame__final_() {
	}
	
	/* The reactions of state Repeat. */
	private void react_BlindMansBlufGame_Repeat() {
		effect_BlindMansBlufGame_Repeat_tr0();
	}
	
	/* The reactions of state null. */
	private void react_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame__choice_0() {
		if (check_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame__choice_0_tr0_tr0()) {
			effect_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame__choice_0_tr0();
		} else {
			if (check_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame__choice_0_tr1_tr1()) {
				effect_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame__choice_0_tr1();
			} else {
				if (check_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame__choice_0_tr2_tr2()) {
					effect_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame__choice_0_tr2();
				} else {
					if (check_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame__choice_0_tr3_tr3()) {
						effect_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame__choice_0_tr3();
					} else {
						if (check_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame__choice_0_tr4_tr4()) {
							effect_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame__choice_0_tr4();
						} else {
							if (check_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame__choice_0_tr5_tr5()) {
								effect_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame__choice_0_tr5();
							} else {
								effect_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame__choice_0_tr6();
							}
						}
					}
				}
			}
		}
	}
	
	/* The reactions of state null. */
	private void react_BlindMansBlufGame__choice_0() {
		if (check_BlindMansBlufGame__choice_0_tr0_tr0()) {
			effect_BlindMansBlufGame__choice_0_tr0();
		} else {
			effect_BlindMansBlufGame__choice_0_tr1();
		}
	}
	
	/* The reactions of state null. */
	private void react_BlindMansBlufGame__choice_1() {
		if (check_BlindMansBlufGame__choice_1_tr0_tr0()) {
			effect_BlindMansBlufGame__choice_1_tr0();
		} else {
			if (check_BlindMansBlufGame__choice_1_tr1_tr1()) {
				effect_BlindMansBlufGame__choice_1_tr1();
			} else {
				effect_BlindMansBlufGame__choice_1_tr2();
			}
		}
	}
	
	/* The reactions of state null. */
	private void react_BlindMansBlufGame__choice_2() {
		effect_BlindMansBlufGame__choice_2_tr0();
	}
	
	/* Default react sequence for initial entry  */
	private void react_BlindMansBlufGame__entry_Default() {
		enterSequence_BlindMansBlufGame_firstQ_default();
	}
	
	/* Default react sequence for initial entry  */
	private void react_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame__entry_Default() {
		react_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame__choice_0();
	}
	
	/* Default react sequence for initial entry  */
	private void react_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_surrounding_surrounding_BlindMansBlufGame__entry_Default() {
		react_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_surrounding_surrounding_BlindMansBlufGame_exit_done();
	}
	
	/* The reactions of exit exit_done. */
	private void react_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_surrounding_surrounding_BlindMansBlufGame_exit_done() {
		effect_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_surrounding_tr0();
	}
	
	/* The reactions of state null. */
	private void react_BlindMansBlufGame__sync0() {
		enterSequence_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_waitForSTT_default();
		enterSequence_BlindMansBlufGame_ParallelOfSTTAndKinect2_Kinect2_WaitForNoise_default();
	}
	
	/* The reactions of state null. */
	private void react_BlindMansBlufGame__sync1() {
		react_BlindMansBlufGame__choice_0();
	}
	
	public void runCycle() {
		if (!initialized)
			throw new IllegalStateException(
					"The state machine needs to be initialized first by calling the init() function.");
		clearOutEvents();
		for (nextStateIndex = 0; nextStateIndex < stateVector.length; nextStateIndex++) {
			switch (stateVector[nextStateIndex]) {
			case blindMansBlufGame_StartGame:
				react_BlindMansBlufGame_StartGame();
				break;
			case blindMansBlufGame_StartSTT:
				react_BlindMansBlufGame_StartSTT();
				break;
			case blindMansBlufGame_ParallelOfSTTAndKinect2_STT_waitForSTT:
				react_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_waitForSTT();
				break;
			case blindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAnswer:
				react_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAnswer();
				break;
			case blindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_GoTo:
				react_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_GoTo();
				break;
			case blindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_surrounding:
				react_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_surrounding();
				break;
			case blindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_bring:
				react_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_bring();
				break;
			case blindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_open:
				react_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_open();
				break;
			case blindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_followme:
				react_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_followme();
				break;
			case blindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_unknown:
				react_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_unknown();
				break;
			case blindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_Copy_1_crowd:
				react_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellAction_Instructions_BlindMansBlufGame_Copy_1_crowd();
				break;
			case blindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellIncomprehensible:
				react_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_TellIncomprehensible();
				break;
			case blindMansBlufGame_ParallelOfSTTAndKinect2_STT_StopSTT2:
				react_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_StopSTT2();
				break;
			case blindMansBlufGame_ParallelOfSTTAndKinect2_STT_StopSTT:
				react_BlindMansBlufGame_ParallelOfSTTAndKinect2_STT_StopSTT();
				break;
			case blindMansBlufGame_ParallelOfSTTAndKinect2_Kinect2_WaitForNoise:
				react_BlindMansBlufGame_ParallelOfSTTAndKinect2_Kinect2_WaitForNoise();
				break;
			case blindMansBlufGame_ParallelOfSTTAndKinect2_Kinect2_Turn:
				react_BlindMansBlufGame_ParallelOfSTTAndKinect2_Kinect2_Turn();
				break;
			case blindMansBlufGame_ParallelOfSTTAndKinect2_Kinect2_endNoise:
				react_BlindMansBlufGame_ParallelOfSTTAndKinect2_Kinect2_endNoise();
				break;
			case blindMansBlufGame_allQuestionsDone:
				react_BlindMansBlufGame_allQuestionsDone();
				break;
			case blindMansBlufGame_NoRepeat:
				react_BlindMansBlufGame_NoRepeat();
				break;
			case blindMansBlufGame_Turn:
				react_BlindMansBlufGame_Turn();
				break;
			case blindMansBlufGame_NextQuestion:
				react_BlindMansBlufGame_NextQuestion();
				break;
			case blindMansBlufGame_firstQ:
				react_BlindMansBlufGame_firstQ();
				break;
			case blindMansBlufGame_wait:
				react_BlindMansBlufGame_wait();
				break;
			case blindMansBlufGame__final_:
				react_BlindMansBlufGame__final_();
				break;
			case blindMansBlufGame_Repeat:
				react_BlindMansBlufGame_Repeat();
				break;
			default:
				// $NullState$
			}
		}
		clearEvents();
	}
}
