package org.yakindu.scr.storinggroceries;
import org.yakindu.scr.ITimer;

public class StoringGroceriesStatemachine implements IStoringGroceriesStatemachine {

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
		main_region_doors,
		main_region_ObjectDetection,
		main_region_TurnToTable,
		main_region_inspectTable,
		main_region_getDetails,
		main_region_PDF,
		main_region__final_,
		$NullState$
	};
	
	private final State[] stateVector = new State[1];
	
	private int nextStateIndex;
	
	private ITimer timer;
	
	private final boolean[] timeEvents = new boolean[2];
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
	
	public StoringGroceriesStatemachine() {
		sCIHBrain = new SCIHBrainImpl();
		sCIMira = new SCIMiraImpl();
		sCIObjectDetection = new SCIObjectDetectionImpl();
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
		if (timer == null) {
			throw new IllegalStateException("timer not set.");
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
		sCIObjectDetection.clearEvents();
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
		case main_region_doors:
			return stateVector[0] == State.main_region_doors;
		case main_region_ObjectDetection:
			return stateVector[0] == State.main_region_ObjectDetection;
		case main_region_TurnToTable:
			return stateVector[0] == State.main_region_TurnToTable;
		case main_region_inspectTable:
			return stateVector[0] == State.main_region_inspectTable;
		case main_region_getDetails:
			return stateVector[0] == State.main_region_getDetails;
		case main_region_PDF:
			return stateVector[0] == State.main_region_PDF;
		case main_region__final_:
			return stateVector[0] == State.main_region__final_;
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
	
	public SCIHBrain getSCIHBrain() {
		return sCIHBrain;
	}
	
	public SCIMira getSCIMira() {
		return sCIMira;
	}
	
	public SCIObjectDetection getSCIObjectDetection() {
		return sCIObjectDetection;
	}
	
	private boolean check_main_region_doors_tr0_tr0() {
		return timeEvents[0];
	}
	
	private boolean check_main_region_ObjectDetection_tr0_tr0() {
		return sCIObjectDetection.detectionDone;
	}
	
	private boolean check_main_region_TurnToTable_tr0_tr0() {
		return timeEvents[1];
	}
	
	private boolean check_main_region_inspectTable_tr0_tr0() {
		return sCIObjectDetection.detectionDone;
	}
	
	private void effect_main_region_doors_tr0() {
		exitSequence_main_region_doors();
		enterSequence_main_region_ObjectDetection_default();
	}
	
	private void effect_main_region_ObjectDetection_tr0() {
		exitSequence_main_region_ObjectDetection();
		enterSequence_main_region_TurnToTable_default();
	}
	
	private void effect_main_region_TurnToTable_tr0() {
		exitSequence_main_region_TurnToTable();
		enterSequence_main_region_inspectTable_default();
	}
	
	private void effect_main_region_inspectTable_tr0() {
		exitSequence_main_region_inspectTable();
		enterSequence_main_region_PDF_default();
	}
	
	/* Entry action for state 'doors'. */
	private void entryAction_main_region_doors() {
		timer.setTimer(this, 0, 10*1000, false);
		
		sCIHBrain.operationCallback.sendTTS("Please open the doors.");
	}
	
	/* Entry action for state 'ObjectDetection'. */
	private void entryAction_main_region_ObjectDetection() {
		sCIObjectDetection.operationCallback.startStopDetection(true);
	}
	
	/* Entry action for state 'TurnToTable'. */
	private void entryAction_main_region_TurnToTable() {
		timer.setTimer(this, 1, 5*1000, false);
		
		sCIObjectDetection.operationCallback.startStopDetection(false);
		
		sCIMira.operationCallback.sendTurnBody(sCIObjectDetection.tableAngle);
	}
	
	/* Entry action for state 'inspectTable'. */
	private void entryAction_main_region_inspectTable() {
		sCIObjectDetection.operationCallback.snapshot();
	}
	
	/* Entry action for state 'getDetails'. */
	private void entryAction_main_region_getDetails() {
		sCIHBrain.operationCallback.sendTTS(sCIObjectDetection.answerMatches);
	}
	
	/* Entry action for state 'PDF'. */
	private void entryAction_main_region_PDF() {
		sCIObjectDetection.operationCallback.printPDF();
	}
	
	/* Exit action for state 'doors'. */
	private void exitAction_main_region_doors() {
		timer.unsetTimer(this, 0);
	}
	
	/* Exit action for state 'TurnToTable'. */
	private void exitAction_main_region_TurnToTable() {
		timer.unsetTimer(this, 1);
	}
	
	/* 'default' enter sequence for state Init */
	private void enterSequence_main_region_Init_default() {
		nextStateIndex = 0;
		stateVector[0] = State.main_region_Init;
	}
	
	/* 'default' enter sequence for state doors */
	private void enterSequence_main_region_doors_default() {
		entryAction_main_region_doors();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_doors;
	}
	
	/* 'default' enter sequence for state ObjectDetection */
	private void enterSequence_main_region_ObjectDetection_default() {
		entryAction_main_region_ObjectDetection();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_ObjectDetection;
	}
	
	/* 'default' enter sequence for state TurnToTable */
	private void enterSequence_main_region_TurnToTable_default() {
		entryAction_main_region_TurnToTable();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_TurnToTable;
	}
	
	/* 'default' enter sequence for state inspectTable */
	private void enterSequence_main_region_inspectTable_default() {
		entryAction_main_region_inspectTable();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_inspectTable;
	}
	
	/* 'default' enter sequence for state getDetails */
	private void enterSequence_main_region_getDetails_default() {
		entryAction_main_region_getDetails();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_getDetails;
	}
	
	/* 'default' enter sequence for state PDF */
	private void enterSequence_main_region_PDF_default() {
		entryAction_main_region_PDF();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_PDF;
	}
	
	/* Default enter sequence for state null */
	private void enterSequence_main_region__final__default() {
		nextStateIndex = 0;
		stateVector[0] = State.main_region__final_;
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
	
	/* Default exit sequence for state doors */
	private void exitSequence_main_region_doors() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
		
		exitAction_main_region_doors();
	}
	
	/* Default exit sequence for state ObjectDetection */
	private void exitSequence_main_region_ObjectDetection() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state TurnToTable */
	private void exitSequence_main_region_TurnToTable() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
		
		exitAction_main_region_TurnToTable();
	}
	
	/* Default exit sequence for state inspectTable */
	private void exitSequence_main_region_inspectTable() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state getDetails */
	private void exitSequence_main_region_getDetails() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state PDF */
	private void exitSequence_main_region_PDF() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for final state. */
	private void exitSequence_main_region__final_() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for region main region */
	private void exitSequence_main_region() {
		switch (stateVector[0]) {
		case main_region_Init:
			exitSequence_main_region_Init();
			break;
		case main_region_doors:
			exitSequence_main_region_doors();
			break;
		case main_region_ObjectDetection:
			exitSequence_main_region_ObjectDetection();
			break;
		case main_region_TurnToTable:
			exitSequence_main_region_TurnToTable();
			break;
		case main_region_inspectTable:
			exitSequence_main_region_inspectTable();
			break;
		case main_region_getDetails:
			exitSequence_main_region_getDetails();
			break;
		case main_region_PDF:
			exitSequence_main_region_PDF();
			break;
		case main_region__final_:
			exitSequence_main_region__final_();
			break;
		default:
			break;
		}
	}
	
	/* The reactions of state Init. */
	private void react_main_region_Init() {
	}
	
	/* The reactions of state doors. */
	private void react_main_region_doors() {
		if (check_main_region_doors_tr0_tr0()) {
			effect_main_region_doors_tr0();
		}
	}
	
	/* The reactions of state ObjectDetection. */
	private void react_main_region_ObjectDetection() {
		if (check_main_region_ObjectDetection_tr0_tr0()) {
			effect_main_region_ObjectDetection_tr0();
		}
	}
	
	/* The reactions of state TurnToTable. */
	private void react_main_region_TurnToTable() {
		if (check_main_region_TurnToTable_tr0_tr0()) {
			effect_main_region_TurnToTable_tr0();
		}
	}
	
	/* The reactions of state inspectTable. */
	private void react_main_region_inspectTable() {
		if (check_main_region_inspectTable_tr0_tr0()) {
			effect_main_region_inspectTable_tr0();
		}
	}
	
	/* The reactions of state getDetails. */
	private void react_main_region_getDetails() {
	}
	
	/* The reactions of state PDF. */
	private void react_main_region_PDF() {
	}
	
	/* The reactions of state null. */
	private void react_main_region__final_() {
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
			case main_region_doors:
				react_main_region_doors();
				break;
			case main_region_ObjectDetection:
				react_main_region_ObjectDetection();
				break;
			case main_region_TurnToTable:
				react_main_region_TurnToTable();
				break;
			case main_region_inspectTable:
				react_main_region_inspectTable();
				break;
			case main_region_getDetails:
				react_main_region_getDetails();
				break;
			case main_region_PDF:
				react_main_region_PDF();
				break;
			case main_region__final_:
				react_main_region__final_();
				break;
			default:
				// $NullState$
			}
		}
		clearEvents();
	}
}
