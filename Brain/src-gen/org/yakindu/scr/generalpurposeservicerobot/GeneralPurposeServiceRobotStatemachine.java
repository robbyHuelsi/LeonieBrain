package org.yakindu.scr.generalpurposeservicerobot;

public class GeneralPurposeServiceRobotStatemachine implements IGeneralPurposeServiceRobotStatemachine {

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
	
	protected class SCIObjectDetectionImpl implements SCIObjectDetection {
	
		private SCIObjectDetectionOperationCallback operationCallback;
		
		public void setSCIObjectDetectionOperationCallback(
				SCIObjectDetectionOperationCallback operationCallback) {
			this.operationCallback = operationCallback;
		}
		private boolean detectionDone;
		
		public void raiseDetectionDone() {
			detectionDone = true;
		}
		
		private long tableAngle;
		
		public long getTableAngle() {
			return tableAngle;
		}
		
		public void setTableAngle(long value) {
			this.tableAngle = value;
		}
		
		private String answerMatches;
		
		public String getAnswerMatches() {
			return answerMatches;
		}
		
		public void setAnswerMatches(String value) {
			this.answerMatches = value;
		}
		
		protected void clearEvents() {
			detectionDone = false;
		}
	}
	
	protected SCIObjectDetectionImpl sCIObjectDetection;
	
	private boolean initialized = false;
	
	public enum State {
		main_region_Init,
		main_region_Hello,
		main_region_Listening,
		main_region_Back_to_operator,
		main_region_do_the_task,
		main_region_Leave_the_arena,
		main_region__final_,
		main_region_SearchOperator,
		$NullState$
	};
	
	private final State[] stateVector = new State[1];
	
	private int nextStateIndex;
	
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
	
	public GeneralPurposeServiceRobotStatemachine() {
		sCIHBrain = new SCIHBrainImpl();
		sCIMira = new SCIMiraImpl();
		sCISTT = new SCISTTImpl();
		sCICrowdDetection = new SCICrowdDetectionImpl();
		sCIMicrophoneArray = new SCIMicrophoneArrayImpl();
		sCIObjectDetection = new SCIObjectDetectionImpl();
	}
	
	public void init() {
		this.initialized = true;
		for (int i = 0; i < 1; i++) {
			stateVector[i] = State.$NullState$;
		}
		clearEvents();
		clearOutEvents();
		sCIObjectDetection.setTableAngle(0);
		
		sCIObjectDetection.setAnswerMatches("");
		
		setCounter(0);
		
		setNameBuffer("");
		
		setQuestionCounter(0);
	}
	
	public void enter() {
		if (!initialized) {
			throw new IllegalStateException(
					"The state machine needs to be initialized first by calling the init() function.");
		}
		enterSequence_main_region_default();
	}
	
	public void exit() {
		exitSequence_main_region();
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
		return (stateVector[0] == State.main_region__final_);
	}
	/**
	* This method resets the incoming events (time events included).
	*/
	protected void clearEvents() {
		sCIHBrain.clearEvents();
		sCIMira.clearEvents();
		sCISTT.clearEvents();
		sCICrowdDetection.clearEvents();
		sCIObjectDetection.clearEvents();
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
		case main_region_Hello:
			return stateVector[0] == State.main_region_Hello;
		case main_region_Listening:
			return stateVector[0] == State.main_region_Listening;
		case main_region_Back_to_operator:
			return stateVector[0] == State.main_region_Back_to_operator;
		case main_region_do_the_task:
			return stateVector[0] == State.main_region_do_the_task;
		case main_region_Leave_the_arena:
			return stateVector[0] == State.main_region_Leave_the_arena;
		case main_region__final_:
			return stateVector[0] == State.main_region__final_;
		case main_region_SearchOperator:
			return stateVector[0] == State.main_region_SearchOperator;
		default:
			return false;
		}
	}
	
	public SCIHBrain getSCIHBrain() {
		return sCIHBrain;
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
	
	public SCIObjectDetection getSCIObjectDetection() {
		return sCIObjectDetection;
	}
	
	private boolean check_main_region_Listening_tr0_tr0() {
		return sCISTT.actionReceived;
	}
	
	private void effect_main_region_Listening_tr0() {
		exitSequence_main_region_Listening();
		enterSequence_main_region_do_the_task_default();
	}
	
	/* Entry action for state 'Hello'. */
	private void entryAction_main_region_Hello() {
		sCIHBrain.operationCallback.sendTTS("Hello! What can I do for you?");
	}
	
	/* Entry action for state 'Listening'. */
	private void entryAction_main_region_Listening() {
		sCISTT.operationCallback.sendSpeechDetectionSmalltalk();
	}
	
	/* Entry action for state 'do the task'. */
	private void entryAction_main_region_do_the_task() {
		sCISTT.operationCallback.getInstruction();
	}
	
	/* 'default' enter sequence for state Init */
	private void enterSequence_main_region_Init_default() {
		nextStateIndex = 0;
		stateVector[0] = State.main_region_Init;
	}
	
	/* 'default' enter sequence for state Hello */
	private void enterSequence_main_region_Hello_default() {
		entryAction_main_region_Hello();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_Hello;
	}
	
	/* 'default' enter sequence for state Listening */
	private void enterSequence_main_region_Listening_default() {
		entryAction_main_region_Listening();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_Listening;
	}
	
	/* 'default' enter sequence for state Back to operator */
	private void enterSequence_main_region_Back_to_operator_default() {
		nextStateIndex = 0;
		stateVector[0] = State.main_region_Back_to_operator;
	}
	
	/* 'default' enter sequence for state do the task */
	private void enterSequence_main_region_do_the_task_default() {
		entryAction_main_region_do_the_task();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_do_the_task;
	}
	
	/* 'default' enter sequence for state Leave the arena */
	private void enterSequence_main_region_Leave_the_arena_default() {
		nextStateIndex = 0;
		stateVector[0] = State.main_region_Leave_the_arena;
	}
	
	/* Default enter sequence for state null */
	private void enterSequence_main_region__final__default() {
		nextStateIndex = 0;
		stateVector[0] = State.main_region__final_;
	}
	
	/* 'default' enter sequence for state SearchOperator */
	private void enterSequence_main_region_SearchOperator_default() {
		nextStateIndex = 0;
		stateVector[0] = State.main_region_SearchOperator;
	}
	
	/* 'default' enter sequence for region main region */
	private void enterSequence_main_region_default() {
		react_main_region__entry_Default();
	}
	
	/* Default exit sequence for state Init */
	private void exitSequence_main_region_Init() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state Hello */
	private void exitSequence_main_region_Hello() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state Listening */
	private void exitSequence_main_region_Listening() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state Back to operator */
	private void exitSequence_main_region_Back_to_operator() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state do the task */
	private void exitSequence_main_region_do_the_task() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state Leave the arena */
	private void exitSequence_main_region_Leave_the_arena() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for final state. */
	private void exitSequence_main_region__final_() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state SearchOperator */
	private void exitSequence_main_region_SearchOperator() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for region main region */
	private void exitSequence_main_region() {
		switch (stateVector[0]) {
		case main_region_Init:
			exitSequence_main_region_Init();
			break;
		case main_region_Hello:
			exitSequence_main_region_Hello();
			break;
		case main_region_Listening:
			exitSequence_main_region_Listening();
			break;
		case main_region_Back_to_operator:
			exitSequence_main_region_Back_to_operator();
			break;
		case main_region_do_the_task:
			exitSequence_main_region_do_the_task();
			break;
		case main_region_Leave_the_arena:
			exitSequence_main_region_Leave_the_arena();
			break;
		case main_region__final_:
			exitSequence_main_region__final_();
			break;
		case main_region_SearchOperator:
			exitSequence_main_region_SearchOperator();
			break;
		default:
			break;
		}
	}
	
	/* The reactions of state Init. */
	private void react_main_region_Init() {
	}
	
	/* The reactions of state Hello. */
	private void react_main_region_Hello() {
	}
	
	/* The reactions of state Listening. */
	private void react_main_region_Listening() {
		if (check_main_region_Listening_tr0_tr0()) {
			effect_main_region_Listening_tr0();
		}
	}
	
	/* The reactions of state Back to operator. */
	private void react_main_region_Back_to_operator() {
	}
	
	/* The reactions of state do the task. */
	private void react_main_region_do_the_task() {
	}
	
	/* The reactions of state Leave the arena. */
	private void react_main_region_Leave_the_arena() {
	}
	
	/* The reactions of state null. */
	private void react_main_region__final_() {
	}
	
	/* The reactions of state SearchOperator. */
	private void react_main_region_SearchOperator() {
	}
	
	/* Default react sequence for initial entry  */
	private void react_main_region__entry_Default() {
		enterSequence_main_region_Init_default();
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
			case main_region_Hello:
				react_main_region_Hello();
				break;
			case main_region_Listening:
				react_main_region_Listening();
				break;
			case main_region_Back_to_operator:
				react_main_region_Back_to_operator();
				break;
			case main_region_do_the_task:
				react_main_region_do_the_task();
				break;
			case main_region_Leave_the_arena:
				react_main_region_Leave_the_arena();
				break;
			case main_region__final_:
				react_main_region__final_();
				break;
			case main_region_SearchOperator:
				react_main_region_SearchOperator();
				break;
			default:
				// $NullState$
			}
		}
		clearEvents();
	}
}
