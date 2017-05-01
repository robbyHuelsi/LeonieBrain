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
		main_region_movePTU,
		main_region_wait,
		leonie_Bupered_Or_Emergency_Stop_waitForEvent,
		leonie_Bupered_Or_Emergency_Stop_Bumpered,
		leonie_Bupered_Or_Emergency_Stop_resetFace,
		leonie_Bupered_Or_Emergency_Stop_EmergencyStop,
		$NullState$
	};
	
	private final State[] stateVector = new State[2];
	
	private int nextStateIndex;
	
	private ITimer timer;
	
	private final boolean[] timeEvents = new boolean[5];
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
		for (int i = 0; i < 2; i++) {
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
		case main_region_movePTU:
			return stateVector[0] == State.main_region_movePTU;
		case main_region_wait:
			return stateVector[0] == State.main_region_wait;
		case leonie_Bupered_Or_Emergency_Stop_waitForEvent:
			return stateVector[1] == State.leonie_Bupered_Or_Emergency_Stop_waitForEvent;
		case leonie_Bupered_Or_Emergency_Stop_Bumpered:
			return stateVector[1] == State.leonie_Bupered_Or_Emergency_Stop_Bumpered;
		case leonie_Bupered_Or_Emergency_Stop_resetFace:
			return stateVector[1] == State.leonie_Bupered_Or_Emergency_Stop_resetFace;
		case leonie_Bupered_Or_Emergency_Stop_EmergencyStop:
			return stateVector[1] == State.leonie_Bupered_Or_Emergency_Stop_EmergencyStop;
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
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_main_region_ObjectDetection_tr0_tr0() {
		return sCIObjectDetection.analyseDone;
	}
	
	private boolean check_main_region_TurnToTable_tr0_tr0() {
		return timeEvents[0];
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
	
	private boolean check_main_region_movePTU_tr0_tr0() {
		return timeEvents[1];
	}
	
	private boolean check_main_region_wait_tr0_tr0() {
		return timeEvents[2];
	}
	
	private boolean check_Leonie_Bupered_Or_Emergency_Stop_waitForEvent_tr0_tr0() {
		return sCIMira.bumpered;
	}
	
	private boolean check_Leonie_Bupered_Or_Emergency_Stop_waitForEvent_tr1_tr1() {
		return sCIMira.emergencyStop;
	}
	
	private boolean check_Leonie_Bupered_Or_Emergency_Stop_Bumpered_tr0_tr0() {
		return timeEvents[3];
	}
	
	private boolean check_Leonie_Bupered_Or_Emergency_Stop_resetFace_tr0_tr0() {
		return true;
	}
	
	private boolean check_Leonie_Bupered_Or_Emergency_Stop_EmergencyStop_tr0_tr0() {
		return timeEvents[4];
	}
	
	private void effect_main_region_doors_tr0() {
		exitSequence_main_region_doors();
		enterSequence_main_region_wait_default();
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
		enterSequence_main_region_movePTU_default();
	}
	
	private void effect_main_region_AdditionalInfo_tr0() {
		exitSequence_main_region_AdditionalInfo();
		enterSequence_main_region__final__default();
	}
	
	private void effect_main_region_movePTU_tr0() {
		exitSequence_main_region_movePTU();
		enterSequence_main_region_doors_default();
	}
	
	private void effect_main_region_wait_tr0() {
		exitSequence_main_region_wait();
		enterSequence_main_region_ObjectDetection_default();
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
	
	/* Entry action for state 'doors'. */
	private void entryAction_main_region_doors() {
		sCIHBrain.operationCallback.sendTTS("I want to see the objects in the cupboard. [-.-] But I don't have a manipulator to open the doors. [:-)] Can somebody help me please.");
	}
	
	/* Entry action for state 'ObjectDetection'. */
	private void entryAction_main_region_ObjectDetection() {
		sCIObjectDetection.operationCallback.sendAnalyseCupboard();
	}
	
	/* Entry action for state 'TurnToTable'. */
	private void entryAction_main_region_TurnToTable() {
		timer.setTimer(this, 0, 50*1000, false);
		
		sCIMira.operationCallback.sendPanCamera(-100);
		
		sCIMira.operationCallback.sendTiltCamera(-50);
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
	
	/* Entry action for state 'movePTU'. */
	private void entryAction_main_region_movePTU() {
		timer.setTimer(this, 1, 3*1000, false);
		
		sCIMira.operationCallback.sendPanTiltCamera(100, -10);
	}
	
	/* Entry action for state 'wait'. */
	private void entryAction_main_region_wait() {
		timer.setTimer(this, 2, 10*1000, false);
	}
	
	/* Entry action for state 'Bumpered'. */
	private void entryAction_Leonie_Bupered_Or_Emergency_Stop_Bumpered() {
		timer.setTimer(this, 3, 3*1000, false);
		
		sCIHBrain.operationCallback.sendTTS("[:-(]ouch!");
	}
	
	/* Entry action for state 'resetFace'. */
	private void entryAction_Leonie_Bupered_Or_Emergency_Stop_resetFace() {
		sCIHBrain.operationCallback.sendTTS("[:-|]");
	}
	
	/* Entry action for state 'EmergencyStop'. */
	private void entryAction_Leonie_Bupered_Or_Emergency_Stop_EmergencyStop() {
		timer.setTimer(this, 4, 3*1000, false);
		
		sCIHBrain.operationCallback.sendTTS("[:-O] Emergancy Stop!");
	}
	
	/* Exit action for state 'TurnToTable'. */
	private void exitAction_main_region_TurnToTable() {
		timer.unsetTimer(this, 0);
	}
	
	/* Exit action for state 'movePTU'. */
	private void exitAction_main_region_movePTU() {
		timer.unsetTimer(this, 1);
	}
	
	/* Exit action for state 'wait'. */
	private void exitAction_main_region_wait() {
		timer.unsetTimer(this, 2);
	}
	
	/* Exit action for state 'Bumpered'. */
	private void exitAction_Leonie_Bupered_Or_Emergency_Stop_Bumpered() {
		timer.unsetTimer(this, 3);
	}
	
	/* Exit action for state 'EmergencyStop'. */
	private void exitAction_Leonie_Bupered_Or_Emergency_Stop_EmergencyStop() {
		timer.unsetTimer(this, 4);
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
	
	/* 'default' enter sequence for state movePTU */
	private void enterSequence_main_region_movePTU_default() {
		entryAction_main_region_movePTU();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_movePTU;
	}
	
	/* 'default' enter sequence for state wait */
	private void enterSequence_main_region_wait_default() {
		entryAction_main_region_wait();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_wait;
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
	
	/* 'default' enter sequence for region main region */
	private void enterSequence_main_region_default() {
		react_main_region__entry_Default();
	}
	
	/* 'default' enter sequence for region Leonie Bupered Or Emergency Stop */
	private void enterSequence_Leonie_Bupered_Or_Emergency_Stop_default() {
		react_Leonie_Bupered_Or_Emergency_Stop__entry_Default();
	}
	
	/* Default exit sequence for state doors */
	private void exitSequence_main_region_doors() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
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
	
	/* Default exit sequence for state movePTU */
	private void exitSequence_main_region_movePTU() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
		
		exitAction_main_region_movePTU();
	}
	
	/* Default exit sequence for state wait */
	private void exitSequence_main_region_wait() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
		
		exitAction_main_region_wait();
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
		
		exitAction_Leonie_Bupered_Or_Emergency_Stop_EmergencyStop();
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
		case main_region_movePTU:
			exitSequence_main_region_movePTU();
			break;
		case main_region_wait:
			exitSequence_main_region_wait();
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
	
	/* The reactions of state movePTU. */
	private void react_main_region_movePTU() {
		if (check_main_region_movePTU_tr0_tr0()) {
			effect_main_region_movePTU_tr0();
		}
	}
	
	/* The reactions of state wait. */
	private void react_main_region_wait() {
		if (check_main_region_wait_tr0_tr0()) {
			effect_main_region_wait_tr0();
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
	
	/* Default react sequence for initial entry  */
	private void react_main_region__entry_Default() {
		enterSequence_main_region_requestReady_default();
	}
	
	/* Default react sequence for initial entry  */
	private void react_Leonie_Bupered_Or_Emergency_Stop__entry_Default() {
		enterSequence_Leonie_Bupered_Or_Emergency_Stop_waitForEvent_default();
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
			case main_region_movePTU:
				react_main_region_movePTU();
				break;
			case main_region_wait:
				react_main_region_wait();
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
