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
		private boolean ready;
		
		public void raiseReady() {
			ready = true;
		}
		
		private boolean analyseDone;
		
		public void raiseAnalyseDone() {
			analyseDone = true;
		}
		
		protected void clearEvents() {
			ready = false;
			analyseDone = false;
		}
	}
	
	protected SCIObjectDetectionImpl sCIObjectDetection;
	
	private boolean initialized = false;
	
	public enum State {
		main_region_doors,
		main_region_ObjectDetection,
		main_region_TurnToTable,
		main_region_inspectTable,
		main_region_PDFAndSummary,
		main_region__final_,
		main_region_requestReady,
		main_region_AdditionalInfo,
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
		case main_region_doors:
			return stateVector[0] == State.main_region_doors;
		case main_region_ObjectDetection:
			return stateVector[0] == State.main_region_ObjectDetection;
		case main_region_TurnToTable:
			return stateVector[0] == State.main_region_TurnToTable;
		case main_region_inspectTable:
			return stateVector[0] == State.main_region_inspectTable;
		case main_region_PDFAndSummary:
			return stateVector[0] == State.main_region_PDFAndSummary;
		case main_region__final_:
			return stateVector[0] == State.main_region__final_;
		case main_region_requestReady:
			return stateVector[0] == State.main_region_requestReady;
		case main_region_AdditionalInfo:
			return stateVector[0] == State.main_region_AdditionalInfo;
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
		return sCIObjectDetection.analyseDone;
	}
	
	private boolean check_main_region_TurnToTable_tr0_tr0() {
		return timeEvents[1];
	}
	
	private boolean check_main_region_inspectTable_tr0_tr0() {
		return sCIObjectDetection.analyseDone;
	}
	
	private boolean check_main_region_PDFAndSummary_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_main_region_requestReady_tr0_tr0() {
		return sCIObjectDetection.ready;
	}
	
	private boolean check_main_region_AdditionalInfo_tr0_tr0() {
		return sCIHBrain.tTSReady;
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
		enterSequence_main_region_PDFAndSummary_default();
	}
	
	private void effect_main_region_PDFAndSummary_tr0() {
		exitSequence_main_region_PDFAndSummary();
		enterSequence_main_region_AdditionalInfo_default();
	}
	
	private void effect_main_region_requestReady_tr0() {
		exitSequence_main_region_requestReady();
		enterSequence_main_region_doors_default();
	}
	
	private void effect_main_region_AdditionalInfo_tr0() {
		exitSequence_main_region_AdditionalInfo();
		enterSequence_main_region__final__default();
	}
	
	/* Entry action for state 'doors'. */
	private void entryAction_main_region_doors() {
		timer.setTimer(this, 0, 10*1000, false);
		
		sCIHBrain.operationCallback.sendTTS("[:-|] I want to see the objects in the cupboard. [-.-] But I don't have a manipulator to open the doors. [:-)] Can somebody help me please.");
	}
	
	/* Entry action for state 'ObjectDetection'. */
	private void entryAction_main_region_ObjectDetection() {
		sCIObjectDetection.operationCallback.sendAnalyseCupboard();
	}
	
	/* Entry action for state 'TurnToTable'. */
	private void entryAction_main_region_TurnToTable() {
		timer.setTimer(this, 1, 5*1000, false);
		
		sCIMira.operationCallback.sendTurnBody(180);
	}
	
	/* Entry action for state 'inspectTable'. */
	private void entryAction_main_region_inspectTable() {
		sCIObjectDetection.operationCallback.sendAnalyseTable();
	}
	
	/* Entry action for state 'PDFAndSummary'. */
	private void entryAction_main_region_PDFAndSummary() {
		sCIObjectDetection.operationCallback.sendPrintPDF();
		
		sCIHBrain.operationCallback.sendTTS(sCIObjectDetection.operationCallback.getSummaryText());
	}
	
	/* Entry action for state 'requestReady'. */
	private void entryAction_main_region_requestReady() {
		sCIObjectDetection.operationCallback.sendReadyRequest();
	}
	
	/* Entry action for state 'AdditionalInfo'. */
	private void entryAction_main_region_AdditionalInfo() {
		sCIHBrain.operationCallback.sendTTS("[:-|] You can find more detailed information about the found objects in the PDF document. Therefore ask another RT-Lion. [sleepy]");
	}
	
	/* Exit action for state 'doors'. */
	private void exitAction_main_region_doors() {
		timer.unsetTimer(this, 0);
	}
	
	/* Exit action for state 'TurnToTable'. */
	private void exitAction_main_region_TurnToTable() {
		timer.unsetTimer(this, 1);
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
	
	/* 'default' enter sequence for state PDFAndSummary */
	private void enterSequence_main_region_PDFAndSummary_default() {
		entryAction_main_region_PDFAndSummary();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_PDFAndSummary;
	}
	
	/* Default enter sequence for state null */
	private void enterSequence_main_region__final__default() {
		nextStateIndex = 0;
		stateVector[0] = State.main_region__final_;
	}
	
	/* 'default' enter sequence for state requestReady */
	private void enterSequence_main_region_requestReady_default() {
		entryAction_main_region_requestReady();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_requestReady;
	}
	
	/* 'default' enter sequence for state AdditionalInfo */
	private void enterSequence_main_region_AdditionalInfo_default() {
		entryAction_main_region_AdditionalInfo();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_AdditionalInfo;
	}
	
	/* 'default' enter sequence for region main region */
	private void enterSequence_main_region_default() {
		react_main_region__entry_Default();
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
	
	/* Default exit sequence for state PDFAndSummary */
	private void exitSequence_main_region_PDFAndSummary() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for final state. */
	private void exitSequence_main_region__final_() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state requestReady */
	private void exitSequence_main_region_requestReady() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state AdditionalInfo */
	private void exitSequence_main_region_AdditionalInfo() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for region main region */
	private void exitSequence_main_region() {
		switch (stateVector[0]) {
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
		case main_region_PDFAndSummary:
			exitSequence_main_region_PDFAndSummary();
			break;
		case main_region__final_:
			exitSequence_main_region__final_();
			break;
		case main_region_requestReady:
			exitSequence_main_region_requestReady();
			break;
		case main_region_AdditionalInfo:
			exitSequence_main_region_AdditionalInfo();
			break;
		default:
			break;
		}
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
	
	/* The reactions of state PDFAndSummary. */
	private void react_main_region_PDFAndSummary() {
		if (check_main_region_PDFAndSummary_tr0_tr0()) {
			effect_main_region_PDFAndSummary_tr0();
		}
	}
	
	/* The reactions of state null. */
	private void react_main_region__final_() {
	}
	
	/* The reactions of state requestReady. */
	private void react_main_region_requestReady() {
		if (check_main_region_requestReady_tr0_tr0()) {
			effect_main_region_requestReady_tr0();
		}
	}
	
	/* The reactions of state AdditionalInfo. */
	private void react_main_region_AdditionalInfo() {
		if (check_main_region_AdditionalInfo_tr0_tr0()) {
			effect_main_region_AdditionalInfo_tr0();
		}
	}
	
	/* Default react sequence for initial entry  */
	private void react_main_region__entry_Default() {
		enterSequence_main_region_requestReady_default();
	}
	
	public void runCycle() {
		if (!initialized)
			throw new IllegalStateException(
					"The state machine needs to be initialized first by calling the init() function.");
		clearOutEvents();
		for (nextStateIndex = 0; nextStateIndex < stateVector.length; nextStateIndex++) {
			switch (stateVector[nextStateIndex]) {
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
			case main_region_PDFAndSummary:
				react_main_region_PDFAndSummary();
				break;
			case main_region__final_:
				react_main_region__final_();
				break;
			case main_region_requestReady:
				react_main_region_requestReady();
				break;
			case main_region_AdditionalInfo:
				react_main_region_AdditionalInfo();
				break;
			default:
				// $NullState$
			}
		}
		clearEvents();
	}
}
