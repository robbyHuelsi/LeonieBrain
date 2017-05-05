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
		
		private boolean objectDetected;
		
		public void raiseObjectDetected() {
			objectDetected = true;
		}
		
		protected void clearEvents() {
			ready = false;
			analyseDone = false;
			objectDetected = false;
		}
	}
	
	protected SCIObjectDetectionImpl sCIObjectDetection;
	
	private boolean initialized = false;
	
	public enum State {
		main_region_ObjectDetection,
		main_region_ObjectDetection_cupboard_tellObj,
		main_region_ObjectDetection_cupboard_waitForNewObj,
		main_region__final_,
		main_region_requestReady,
		main_region_inspectTable,
		main_region_inspectTable_table_tellObj,
		main_region_inspectTable_table_waitForNewObj,
		main_region_Copy_1_Table,
		main_region_Copy_1_Table__region0_PDFAndSummary,
		main_region_Copy_1_Table__region0_AdditionalInfo,
		main_region_Copy_1_Table__region0_sync1,
		main_region_Copy_1_Table__region1_Copy_1_panCupboard,
		main_region_Copy_1_Table__region1_Copy_1_tiltCupboard,
		main_region_Copy_1_Table__region1_sync1,
		main_region_Copy_1_Table__region1_wait_for_Mira,
		main_region_move_to_wp,
		main_region_panCupboard,
		main_region_tiltCupboard,
		main_region_lookToFront,
		main_region_C1,
		main_region_C2,
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
	
	private final boolean[] timeEvents = new boolean[7];
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
	
	private long cupboard;
	
	protected void setCupboard(long value) {
		cupboard = value;
	}
	
	protected long getCupboard() {
		return cupboard;
	}
	
	private long cupboardGWP;
	
	protected void setCupboardGWP(long value) {
		cupboardGWP = value;
	}
	
	protected long getCupboardGWP() {
		return cupboardGWP;
	}
	
	private long panAngle;
	
	protected void setPanAngle(long value) {
		panAngle = value;
	}
	
	protected long getPanAngle() {
		return panAngle;
	}
	
	private long tiltAngle;
	
	protected void setTiltAngle(long value) {
		tiltAngle = value;
	}
	
	protected long getTiltAngle() {
		return tiltAngle;
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
		for (int i = 0; i < 3; i++) {
			stateVector[i] = State.$NullState$;
		}
		clearEvents();
		clearOutEvents();
		setCounter(0);
		
		setNameBuffer("");
		
		setQuestionCounter(0);
		
		setCupboard(0);
		
		setCupboardGWP(0);
		
		setPanAngle(0);
		
		setTiltAngle(0);
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
		case main_region_ObjectDetection:
			return stateVector[0].ordinal() >= State.
					main_region_ObjectDetection.ordinal()&& stateVector[0].ordinal() <= State.main_region_ObjectDetection_cupboard_waitForNewObj.ordinal();
		case main_region_ObjectDetection_cupboard_tellObj:
			return stateVector[0] == State.main_region_ObjectDetection_cupboard_tellObj;
		case main_region_ObjectDetection_cupboard_waitForNewObj:
			return stateVector[0] == State.main_region_ObjectDetection_cupboard_waitForNewObj;
		case main_region__final_:
			return stateVector[0] == State.main_region__final_;
		case main_region_requestReady:
			return stateVector[0] == State.main_region_requestReady;
		case main_region_inspectTable:
			return stateVector[0].ordinal() >= State.
					main_region_inspectTable.ordinal()&& stateVector[0].ordinal() <= State.main_region_inspectTable_table_waitForNewObj.ordinal();
		case main_region_inspectTable_table_tellObj:
			return stateVector[0] == State.main_region_inspectTable_table_tellObj;
		case main_region_inspectTable_table_waitForNewObj:
			return stateVector[0] == State.main_region_inspectTable_table_waitForNewObj;
		case main_region_Copy_1_Table:
			return stateVector[0].ordinal() >= State.
					main_region_Copy_1_Table.ordinal()&& stateVector[0].ordinal() <= State.main_region_Copy_1_Table__region1_wait_for_Mira.ordinal();
		case main_region_Copy_1_Table__region0_PDFAndSummary:
			return stateVector[0] == State.main_region_Copy_1_Table__region0_PDFAndSummary;
		case main_region_Copy_1_Table__region0_AdditionalInfo:
			return stateVector[0] == State.main_region_Copy_1_Table__region0_AdditionalInfo;
		case main_region_Copy_1_Table__region0_sync1:
			return stateVector[0] == State.main_region_Copy_1_Table__region0_sync1;
		case main_region_Copy_1_Table__region1_Copy_1_panCupboard:
			return stateVector[1] == State.main_region_Copy_1_Table__region1_Copy_1_panCupboard;
		case main_region_Copy_1_Table__region1_Copy_1_tiltCupboard:
			return stateVector[1] == State.main_region_Copy_1_Table__region1_Copy_1_tiltCupboard;
		case main_region_Copy_1_Table__region1_sync1:
			return stateVector[1] == State.main_region_Copy_1_Table__region1_sync1;
		case main_region_Copy_1_Table__region1_wait_for_Mira:
			return stateVector[1] == State.main_region_Copy_1_Table__region1_wait_for_Mira;
		case main_region_move_to_wp:
			return stateVector[0] == State.main_region_move_to_wp;
		case main_region_panCupboard:
			return stateVector[0] == State.main_region_panCupboard;
		case main_region_tiltCupboard:
			return stateVector[0] == State.main_region_tiltCupboard;
		case main_region_lookToFront:
			return stateVector[0] == State.main_region_lookToFront;
		case main_region_C1:
			return stateVector[0] == State.main_region_C1;
		case main_region_C2:
			return stateVector[0] == State.main_region_C2;
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
	
	public SCIHBrain getSCIHBrain() {
		return sCIHBrain;
	}
	
	public SCIMira getSCIMira() {
		return sCIMira;
	}
	
	public SCIObjectDetection getSCIObjectDetection() {
		return sCIObjectDetection;
	}
	
	private boolean check_main_region_ObjectDetection_tr0_tr0() {
		return sCIObjectDetection.analyseDone;
	}
	
	private boolean check_main_region_ObjectDetection_cupboard_tellObj_tr0_tr0() {
		return true;
	}
	
	private boolean check_main_region_ObjectDetection_cupboard_waitForNewObj_tr0_tr0() {
		return sCIObjectDetection.objectDetected;
	}
	
	private boolean check_main_region_requestReady_tr0_tr0() {
		return sCIObjectDetection.ready;
	}
	
	private boolean check_main_region_inspectTable_tr0_tr0() {
		return sCIObjectDetection.analyseDone;
	}
	
	private boolean check_main_region_inspectTable_table_tellObj_tr0_tr0() {
		return true;
	}
	
	private boolean check_main_region_inspectTable_table_waitForNewObj_tr0_tr0() {
		return sCIObjectDetection.objectDetected;
	}
	
	private boolean check_main_region_Copy_1_Table__region0_PDFAndSummary_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_main_region_Copy_1_Table__region0_AdditionalInfo_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_main_region_Copy_1_Table__region0_sync1_tr0_StoringGroceries_main_region__sync1join_check() {
		return isStateActive(State.main_region_Copy_1_Table__region1_sync1);
	}
	
	private boolean check_main_region_Copy_1_Table__region1_Copy_1_panCupboard_tr0_tr0() {
		return timeEvents[0];
	}
	
	private boolean check_main_region_Copy_1_Table__region1_Copy_1_tiltCupboard_tr0_tr0() {
		return timeEvents[1];
	}
	
	private boolean check_main_region_Copy_1_Table__region1_sync1_tr0_StoringGroceries_main_region__sync1join_check() {
		return isStateActive(State.main_region_Copy_1_Table__region0_sync1);
	}
	
	private boolean check_main_region_Copy_1_Table__region1_wait_for_Mira_tr0_tr0() {
		return timeEvents[2];
	}
	
	private boolean check_main_region_move_to_wp_tr0_tr0() {
		return sCIMira.arrivedWP;
	}
	
	private boolean check_main_region_panCupboard_tr0_tr0() {
		return timeEvents[3];
	}
	
	private boolean check_main_region_tiltCupboard_tr0_tr0() {
		return timeEvents[4];
	}
	
	private boolean check_main_region_lookToFront_tr0_tr0() {
		return true;
	}
	
	private boolean check_main_region_C1_tr0_tr0() {
		return true;
	}
	
	private boolean check_main_region_C2_tr0_tr0() {
		return true;
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
		return true;
	}
	
	private boolean check_Leonie_Bupered_Or_Emergency_Stop_checkEmergency_tr0_tr0() {
		return timeEvents[6];
	}
	
	private boolean check_Leonie_Bupered_Or_Emergency_Stop_checkEmergency_tr1_tr1() {
		return sCIMira.emergencyStop;
	}
	
	private boolean check_main_region__choice_0_tr0_tr0() {
		return getCupboard()==1;
	}
	
	private boolean check_main_region__choice_0_tr1_tr1() {
		return getCupboard()==2;
	}
	
	private void effect_main_region_ObjectDetection_tr0() {
		exitSequence_main_region_ObjectDetection();
		enterSequence_main_region_lookToFront_default();
	}
	
	private void effect_main_region_ObjectDetection_cupboard_tellObj_tr0() {
		exitSequence_main_region_ObjectDetection_cupboard_tellObj();
		enterSequence_main_region_ObjectDetection_cupboard_waitForNewObj_default();
	}
	
	private void effect_main_region_ObjectDetection_cupboard_waitForNewObj_tr0() {
		exitSequence_main_region_ObjectDetection_cupboard_waitForNewObj();
		enterSequence_main_region_ObjectDetection_cupboard_tellObj_default();
	}
	
	private void effect_main_region_requestReady_tr0() {
		exitSequence_main_region_requestReady();
		react_main_region__choice_0();
	}
	
	private void effect_main_region_inspectTable_tr0() {
		exitSequence_main_region_inspectTable();
		react_main_region__sync0();
	}
	
	private void effect_main_region_inspectTable_table_tellObj_tr0() {
		exitSequence_main_region_inspectTable_table_tellObj();
		enterSequence_main_region_inspectTable_table_waitForNewObj_default();
	}
	
	private void effect_main_region_inspectTable_table_waitForNewObj_tr0() {
		exitSequence_main_region_inspectTable_table_waitForNewObj();
		enterSequence_main_region_inspectTable_table_tellObj_default();
	}
	
	private void effect_main_region_Copy_1_Table__region0_PDFAndSummary_tr0() {
		exitSequence_main_region_Copy_1_Table__region0_PDFAndSummary();
		enterSequence_main_region_Copy_1_Table__region0_AdditionalInfo_default();
	}
	
	private void effect_main_region_Copy_1_Table__region0_AdditionalInfo_tr0() {
		exitSequence_main_region_Copy_1_Table__region0_AdditionalInfo();
		enterSequence_main_region_Copy_1_Table__region0_sync1_default();
	}
	
	private void effect_main_region_Copy_1_Table__region0_sync1_tr0() {
		exitSequence_main_region_Copy_1_Table();
		react_main_region__sync1();
	}
	
	private void effect_main_region_Copy_1_Table__region1_Copy_1_panCupboard_tr0() {
		exitSequence_main_region_Copy_1_Table__region1_Copy_1_panCupboard();
		enterSequence_main_region_Copy_1_Table__region1_Copy_1_tiltCupboard_default();
	}
	
	private void effect_main_region_Copy_1_Table__region1_Copy_1_tiltCupboard_tr0() {
		exitSequence_main_region_Copy_1_Table__region1_Copy_1_tiltCupboard();
		enterSequence_main_region_Copy_1_Table__region1_sync1_default();
	}
	
	private void effect_main_region_Copy_1_Table__region1_sync1_tr0() {
		exitSequence_main_region_Copy_1_Table();
		react_main_region__sync1();
	}
	
	private void effect_main_region_Copy_1_Table__region1_wait_for_Mira_tr0() {
		exitSequence_main_region_Copy_1_Table__region1_wait_for_Mira();
		enterSequence_main_region_Copy_1_Table__region1_Copy_1_panCupboard_default();
	}
	
	private void effect_main_region_move_to_wp_tr0() {
		exitSequence_main_region_move_to_wp();
		enterSequence_main_region_panCupboard_default();
	}
	
	private void effect_main_region_panCupboard_tr0() {
		exitSequence_main_region_panCupboard();
		enterSequence_main_region_tiltCupboard_default();
	}
	
	private void effect_main_region_tiltCupboard_tr0() {
		exitSequence_main_region_tiltCupboard();
		enterSequence_main_region_ObjectDetection_default();
	}
	
	private void effect_main_region_lookToFront_tr0() {
		exitSequence_main_region_lookToFront();
		enterSequence_main_region_inspectTable_default();
	}
	
	private void effect_main_region_C1_tr0() {
		exitSequence_main_region_C1();
		enterSequence_main_region_move_to_wp_default();
	}
	
	private void effect_main_region_C2_tr0() {
		exitSequence_main_region_C2();
		enterSequence_main_region_move_to_wp_default();
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
	
	private void effect_main_region__choice_0_tr0() {
		enterSequence_main_region_C1_default();
	}
	
	private void effect_main_region__choice_0_tr1() {
		enterSequence_main_region_C2_default();
	}
	
	/* Entry action for state 'ObjectDetection'. */
	private void entryAction_main_region_ObjectDetection() {
		sCIObjectDetection.operationCallback.sendAnalyseCupboard();
		
		sCIHBrain.operationCallback.sendTTS("[attentive] Okay. Now I am analysing the cupboard.");
	}
	
	/* Entry action for state 'tellObj'. */
	private void entryAction_main_region_ObjectDetection_cupboard_tellObj() {
		sCIHBrain.operationCallback.sendTTS(sCIObjectDetection.operationCallback.getNewesObject());
	}
	
	/* Entry action for state 'requestReady'. */
	private void entryAction_main_region_requestReady() {
		sCIObjectDetection.operationCallback.sendReadyRequest();
		
		setCupboard(2);
		
		setTiltAngle(-18);
	}
	
	/* Entry action for state 'inspectTable'. */
	private void entryAction_main_region_inspectTable() {
		sCIObjectDetection.operationCallback.sendAnalyseTable();
		
		sCIHBrain.operationCallback.sendTTS("[:-)]Okay. Now I am analysing the table. [attentive]");
	}
	
	/* Entry action for state 'tellObj'. */
	private void entryAction_main_region_inspectTable_table_tellObj() {
		sCIHBrain.operationCallback.sendTTS(sCIObjectDetection.operationCallback.getNewesObject());
	}
	
	/* Entry action for state 'PDFAndSummary'. */
	private void entryAction_main_region_Copy_1_Table__region0_PDFAndSummary() {
		sCIHBrain.operationCallback.sendTTS("{Person} [:-)]");
		
		sCIObjectDetection.operationCallback.sendPrintPDF();
		
		sCIHBrain.operationCallback.sendTTS(sCIObjectDetection.operationCallback.getSummaryText());
	}
	
	/* Entry action for state 'AdditionalInfo'. */
	private void entryAction_main_region_Copy_1_Table__region0_AdditionalInfo() {
		sCIHBrain.operationCallback.sendTTS("[:-|] You can find more detailed information about the found objects in the PDF document. Therefore ask another RT-Lion. [:-)]");
	}
	
	/* Entry action for state 'Copy_1_panCupboard'. */
	private void entryAction_main_region_Copy_1_Table__region1_Copy_1_panCupboard() {
		timer.setTimer(this, 0, 10*1000, false);
		
		sCIMira.operationCallback.sendPanCamera(0);
	}
	
	/* Entry action for state 'Copy_1_tiltCupboard'. */
	private void entryAction_main_region_Copy_1_Table__region1_Copy_1_tiltCupboard() {
		timer.setTimer(this, 1, 4*1000, false);
		
		sCIMira.operationCallback.sendTiltCamera(0);
	}
	
	/* Entry action for state 'wait for Mira'. */
	private void entryAction_main_region_Copy_1_Table__region1_wait_for_Mira() {
		timer.setTimer(this, 2, 1*1000, false);
	}
	
	/* Entry action for state 'move to wp'. */
	private void entryAction_main_region_move_to_wp() {
		sCIHBrain.operationCallback.sendTTS("Ready to start");
		
		sCIMira.operationCallback.sendGoToGWP(getCupboardGWP());
	}
	
	/* Entry action for state 'panCupboard'. */
	private void entryAction_main_region_panCupboard() {
		timer.setTimer(this, 3, 5*1000, false);
		
		sCIMira.operationCallback.sendPanCamera(getPanAngle());
	}
	
	/* Entry action for state 'tiltCupboard'. */
	private void entryAction_main_region_tiltCupboard() {
		timer.setTimer(this, 4, 4*1000, false);
		
		sCIMira.operationCallback.sendTiltCamera(getTiltAngle());
	}
	
	/* Entry action for state 'lookToFront'. */
	private void entryAction_main_region_lookToFront() {
		sCIHBrain.operationCallback.sendTTS("{0;-0} [:-)]");
	}
	
	/* Entry action for state 'C1'. */
	private void entryAction_main_region_C1() {
		setCupboardGWP(23);
		
		setPanAngle(45);
	}
	
	/* Entry action for state 'C2'. */
	private void entryAction_main_region_C2() {
		setCupboardGWP(22);
		
		setPanAngle(-47);
	}
	
	/* Entry action for state 'Bumpered'. */
	private void entryAction_Leonie_Bupered_Or_Emergency_Stop_Bumpered() {
		timer.setTimer(this, 5, 3*1000, false);
		
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
		timer.setTimer(this, 6, 3*1000, false);
	}
	
	/* Exit action for state 'Copy_1_panCupboard'. */
	private void exitAction_main_region_Copy_1_Table__region1_Copy_1_panCupboard() {
		timer.unsetTimer(this, 0);
	}
	
	/* Exit action for state 'Copy_1_tiltCupboard'. */
	private void exitAction_main_region_Copy_1_Table__region1_Copy_1_tiltCupboard() {
		timer.unsetTimer(this, 1);
	}
	
	/* Exit action for state 'wait for Mira'. */
	private void exitAction_main_region_Copy_1_Table__region1_wait_for_Mira() {
		timer.unsetTimer(this, 2);
	}
	
	/* Exit action for state 'panCupboard'. */
	private void exitAction_main_region_panCupboard() {
		timer.unsetTimer(this, 3);
	}
	
	/* Exit action for state 'tiltCupboard'. */
	private void exitAction_main_region_tiltCupboard() {
		timer.unsetTimer(this, 4);
	}
	
	/* Exit action for state 'Bumpered'. */
	private void exitAction_Leonie_Bupered_Or_Emergency_Stop_Bumpered() {
		timer.unsetTimer(this, 5);
	}
	
	/* Exit action for state 'checkEmergency'. */
	private void exitAction_Leonie_Bupered_Or_Emergency_Stop_checkEmergency() {
		timer.unsetTimer(this, 6);
	}
	
	/* 'default' enter sequence for state ObjectDetection */
	private void enterSequence_main_region_ObjectDetection_default() {
		entryAction_main_region_ObjectDetection();
		enterSequence_main_region_ObjectDetection_cupboard_default();
	}
	
	/* 'default' enter sequence for state tellObj */
	private void enterSequence_main_region_ObjectDetection_cupboard_tellObj_default() {
		entryAction_main_region_ObjectDetection_cupboard_tellObj();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_ObjectDetection_cupboard_tellObj;
	}
	
	/* 'default' enter sequence for state waitForNewObj */
	private void enterSequence_main_region_ObjectDetection_cupboard_waitForNewObj_default() {
		nextStateIndex = 0;
		stateVector[0] = State.main_region_ObjectDetection_cupboard_waitForNewObj;
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
	
	/* 'default' enter sequence for state inspectTable */
	private void enterSequence_main_region_inspectTable_default() {
		entryAction_main_region_inspectTable();
		enterSequence_main_region_inspectTable_table_default();
	}
	
	/* 'default' enter sequence for state tellObj */
	private void enterSequence_main_region_inspectTable_table_tellObj_default() {
		entryAction_main_region_inspectTable_table_tellObj();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_inspectTable_table_tellObj;
	}
	
	/* 'default' enter sequence for state waitForNewObj */
	private void enterSequence_main_region_inspectTable_table_waitForNewObj_default() {
		nextStateIndex = 0;
		stateVector[0] = State.main_region_inspectTable_table_waitForNewObj;
	}
	
	/* 'default' enter sequence for state PDFAndSummary */
	private void enterSequence_main_region_Copy_1_Table__region0_PDFAndSummary_default() {
		entryAction_main_region_Copy_1_Table__region0_PDFAndSummary();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_Copy_1_Table__region0_PDFAndSummary;
	}
	
	/* 'default' enter sequence for state AdditionalInfo */
	private void enterSequence_main_region_Copy_1_Table__region0_AdditionalInfo_default() {
		entryAction_main_region_Copy_1_Table__region0_AdditionalInfo();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_Copy_1_Table__region0_AdditionalInfo;
	}
	
	/* 'default' enter sequence for state sync1 */
	private void enterSequence_main_region_Copy_1_Table__region0_sync1_default() {
		nextStateIndex = 0;
		stateVector[0] = State.main_region_Copy_1_Table__region0_sync1;
	}
	
	/* 'default' enter sequence for state Copy_1_panCupboard */
	private void enterSequence_main_region_Copy_1_Table__region1_Copy_1_panCupboard_default() {
		entryAction_main_region_Copy_1_Table__region1_Copy_1_panCupboard();
		nextStateIndex = 1;
		stateVector[1] = State.main_region_Copy_1_Table__region1_Copy_1_panCupboard;
	}
	
	/* 'default' enter sequence for state Copy_1_tiltCupboard */
	private void enterSequence_main_region_Copy_1_Table__region1_Copy_1_tiltCupboard_default() {
		entryAction_main_region_Copy_1_Table__region1_Copy_1_tiltCupboard();
		nextStateIndex = 1;
		stateVector[1] = State.main_region_Copy_1_Table__region1_Copy_1_tiltCupboard;
	}
	
	/* 'default' enter sequence for state sync1 */
	private void enterSequence_main_region_Copy_1_Table__region1_sync1_default() {
		nextStateIndex = 1;
		stateVector[1] = State.main_region_Copy_1_Table__region1_sync1;
	}
	
	/* 'default' enter sequence for state wait for Mira */
	private void enterSequence_main_region_Copy_1_Table__region1_wait_for_Mira_default() {
		entryAction_main_region_Copy_1_Table__region1_wait_for_Mira();
		nextStateIndex = 1;
		stateVector[1] = State.main_region_Copy_1_Table__region1_wait_for_Mira;
	}
	
	/* 'default' enter sequence for state move to wp */
	private void enterSequence_main_region_move_to_wp_default() {
		entryAction_main_region_move_to_wp();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_move_to_wp;
	}
	
	/* 'default' enter sequence for state panCupboard */
	private void enterSequence_main_region_panCupboard_default() {
		entryAction_main_region_panCupboard();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_panCupboard;
	}
	
	/* 'default' enter sequence for state tiltCupboard */
	private void enterSequence_main_region_tiltCupboard_default() {
		entryAction_main_region_tiltCupboard();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_tiltCupboard;
	}
	
	/* 'default' enter sequence for state lookToFront */
	private void enterSequence_main_region_lookToFront_default() {
		entryAction_main_region_lookToFront();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_lookToFront;
	}
	
	/* 'default' enter sequence for state C1 */
	private void enterSequence_main_region_C1_default() {
		entryAction_main_region_C1();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_C1;
	}
	
	/* 'default' enter sequence for state C2 */
	private void enterSequence_main_region_C2_default() {
		entryAction_main_region_C2();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_C2;
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
	
	/* 'default' enter sequence for region cupboard */
	private void enterSequence_main_region_ObjectDetection_cupboard_default() {
		react_main_region_ObjectDetection_cupboard__entry_Default();
	}
	
	/* 'default' enter sequence for region table */
	private void enterSequence_main_region_inspectTable_table_default() {
		react_main_region_inspectTable_table__entry_Default();
	}
	
	/* 'default' enter sequence for region Leonie Bupered Or Emergency Stop */
	private void enterSequence_Leonie_Bupered_Or_Emergency_Stop_default() {
		react_Leonie_Bupered_Or_Emergency_Stop__entry_Default();
	}
	
	/* Default exit sequence for state ObjectDetection */
	private void exitSequence_main_region_ObjectDetection() {
		exitSequence_main_region_ObjectDetection_cupboard();
	}
	
	/* Default exit sequence for state tellObj */
	private void exitSequence_main_region_ObjectDetection_cupboard_tellObj() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state waitForNewObj */
	private void exitSequence_main_region_ObjectDetection_cupboard_waitForNewObj() {
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
	
	/* Default exit sequence for state inspectTable */
	private void exitSequence_main_region_inspectTable() {
		exitSequence_main_region_inspectTable_table();
	}
	
	/* Default exit sequence for state tellObj */
	private void exitSequence_main_region_inspectTable_table_tellObj() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state waitForNewObj */
	private void exitSequence_main_region_inspectTable_table_waitForNewObj() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state Copy_1_Table */
	private void exitSequence_main_region_Copy_1_Table() {
		exitSequence_main_region_Copy_1_Table__region0();
		exitSequence_main_region_Copy_1_Table__region1();
	}
	
	/* Default exit sequence for state PDFAndSummary */
	private void exitSequence_main_region_Copy_1_Table__region0_PDFAndSummary() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state AdditionalInfo */
	private void exitSequence_main_region_Copy_1_Table__region0_AdditionalInfo() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state sync1 */
	private void exitSequence_main_region_Copy_1_Table__region0_sync1() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state Copy_1_panCupboard */
	private void exitSequence_main_region_Copy_1_Table__region1_Copy_1_panCupboard() {
		nextStateIndex = 1;
		stateVector[1] = State.$NullState$;
		
		exitAction_main_region_Copy_1_Table__region1_Copy_1_panCupboard();
	}
	
	/* Default exit sequence for state Copy_1_tiltCupboard */
	private void exitSequence_main_region_Copy_1_Table__region1_Copy_1_tiltCupboard() {
		nextStateIndex = 1;
		stateVector[1] = State.$NullState$;
		
		exitAction_main_region_Copy_1_Table__region1_Copy_1_tiltCupboard();
	}
	
	/* Default exit sequence for state sync1 */
	private void exitSequence_main_region_Copy_1_Table__region1_sync1() {
		nextStateIndex = 1;
		stateVector[1] = State.$NullState$;
	}
	
	/* Default exit sequence for state wait for Mira */
	private void exitSequence_main_region_Copy_1_Table__region1_wait_for_Mira() {
		nextStateIndex = 1;
		stateVector[1] = State.$NullState$;
		
		exitAction_main_region_Copy_1_Table__region1_wait_for_Mira();
	}
	
	/* Default exit sequence for state move to wp */
	private void exitSequence_main_region_move_to_wp() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state panCupboard */
	private void exitSequence_main_region_panCupboard() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
		
		exitAction_main_region_panCupboard();
	}
	
	/* Default exit sequence for state tiltCupboard */
	private void exitSequence_main_region_tiltCupboard() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
		
		exitAction_main_region_tiltCupboard();
	}
	
	/* Default exit sequence for state lookToFront */
	private void exitSequence_main_region_lookToFront() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state C1 */
	private void exitSequence_main_region_C1() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state C2 */
	private void exitSequence_main_region_C2() {
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
		case main_region_ObjectDetection_cupboard_tellObj:
			exitSequence_main_region_ObjectDetection_cupboard_tellObj();
			break;
		case main_region_ObjectDetection_cupboard_waitForNewObj:
			exitSequence_main_region_ObjectDetection_cupboard_waitForNewObj();
			break;
		case main_region__final_:
			exitSequence_main_region__final_();
			break;
		case main_region_requestReady:
			exitSequence_main_region_requestReady();
			break;
		case main_region_inspectTable_table_tellObj:
			exitSequence_main_region_inspectTable_table_tellObj();
			break;
		case main_region_inspectTable_table_waitForNewObj:
			exitSequence_main_region_inspectTable_table_waitForNewObj();
			break;
		case main_region_Copy_1_Table__region0_PDFAndSummary:
			exitSequence_main_region_Copy_1_Table__region0_PDFAndSummary();
			break;
		case main_region_Copy_1_Table__region0_AdditionalInfo:
			exitSequence_main_region_Copy_1_Table__region0_AdditionalInfo();
			break;
		case main_region_Copy_1_Table__region0_sync1:
			exitSequence_main_region_Copy_1_Table__region0_sync1();
			break;
		case main_region_move_to_wp:
			exitSequence_main_region_move_to_wp();
			break;
		case main_region_panCupboard:
			exitSequence_main_region_panCupboard();
			break;
		case main_region_tiltCupboard:
			exitSequence_main_region_tiltCupboard();
			break;
		case main_region_lookToFront:
			exitSequence_main_region_lookToFront();
			break;
		case main_region_C1:
			exitSequence_main_region_C1();
			break;
		case main_region_C2:
			exitSequence_main_region_C2();
			break;
		default:
			break;
		}
		
		switch (stateVector[1]) {
		case main_region_Copy_1_Table__region1_Copy_1_panCupboard:
			exitSequence_main_region_Copy_1_Table__region1_Copy_1_panCupboard();
			break;
		case main_region_Copy_1_Table__region1_Copy_1_tiltCupboard:
			exitSequence_main_region_Copy_1_Table__region1_Copy_1_tiltCupboard();
			break;
		case main_region_Copy_1_Table__region1_sync1:
			exitSequence_main_region_Copy_1_Table__region1_sync1();
			break;
		case main_region_Copy_1_Table__region1_wait_for_Mira:
			exitSequence_main_region_Copy_1_Table__region1_wait_for_Mira();
			break;
		default:
			break;
		}
	}
	
	/* Default exit sequence for region cupboard */
	private void exitSequence_main_region_ObjectDetection_cupboard() {
		switch (stateVector[0]) {
		case main_region_ObjectDetection_cupboard_tellObj:
			exitSequence_main_region_ObjectDetection_cupboard_tellObj();
			break;
		case main_region_ObjectDetection_cupboard_waitForNewObj:
			exitSequence_main_region_ObjectDetection_cupboard_waitForNewObj();
			break;
		default:
			break;
		}
	}
	
	/* Default exit sequence for region table */
	private void exitSequence_main_region_inspectTable_table() {
		switch (stateVector[0]) {
		case main_region_inspectTable_table_tellObj:
			exitSequence_main_region_inspectTable_table_tellObj();
			break;
		case main_region_inspectTable_table_waitForNewObj:
			exitSequence_main_region_inspectTable_table_waitForNewObj();
			break;
		default:
			break;
		}
	}
	
	/* Default exit sequence for region null */
	private void exitSequence_main_region_Copy_1_Table__region0() {
		switch (stateVector[0]) {
		case main_region_Copy_1_Table__region0_PDFAndSummary:
			exitSequence_main_region_Copy_1_Table__region0_PDFAndSummary();
			break;
		case main_region_Copy_1_Table__region0_AdditionalInfo:
			exitSequence_main_region_Copy_1_Table__region0_AdditionalInfo();
			break;
		case main_region_Copy_1_Table__region0_sync1:
			exitSequence_main_region_Copy_1_Table__region0_sync1();
			break;
		default:
			break;
		}
	}
	
	/* Default exit sequence for region null */
	private void exitSequence_main_region_Copy_1_Table__region1() {
		switch (stateVector[1]) {
		case main_region_Copy_1_Table__region1_Copy_1_panCupboard:
			exitSequence_main_region_Copy_1_Table__region1_Copy_1_panCupboard();
			break;
		case main_region_Copy_1_Table__region1_Copy_1_tiltCupboard:
			exitSequence_main_region_Copy_1_Table__region1_Copy_1_tiltCupboard();
			break;
		case main_region_Copy_1_Table__region1_sync1:
			exitSequence_main_region_Copy_1_Table__region1_sync1();
			break;
		case main_region_Copy_1_Table__region1_wait_for_Mira:
			exitSequence_main_region_Copy_1_Table__region1_wait_for_Mira();
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
	
	/* The reactions of state tellObj. */
	private void react_main_region_ObjectDetection_cupboard_tellObj() {
		if (check_main_region_ObjectDetection_tr0_tr0()) {
			effect_main_region_ObjectDetection_tr0();
		} else {
			effect_main_region_ObjectDetection_cupboard_tellObj_tr0();
		}
	}
	
	/* The reactions of state waitForNewObj. */
	private void react_main_region_ObjectDetection_cupboard_waitForNewObj() {
		if (check_main_region_ObjectDetection_tr0_tr0()) {
			effect_main_region_ObjectDetection_tr0();
		} else {
			if (check_main_region_ObjectDetection_cupboard_waitForNewObj_tr0_tr0()) {
				effect_main_region_ObjectDetection_cupboard_waitForNewObj_tr0();
			}
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
	
	/* The reactions of state tellObj. */
	private void react_main_region_inspectTable_table_tellObj() {
		if (check_main_region_inspectTable_tr0_tr0()) {
			effect_main_region_inspectTable_tr0();
		} else {
			effect_main_region_inspectTable_table_tellObj_tr0();
		}
	}
	
	/* The reactions of state waitForNewObj. */
	private void react_main_region_inspectTable_table_waitForNewObj() {
		if (check_main_region_inspectTable_tr0_tr0()) {
			effect_main_region_inspectTable_tr0();
		} else {
			if (check_main_region_inspectTable_table_waitForNewObj_tr0_tr0()) {
				effect_main_region_inspectTable_table_waitForNewObj_tr0();
			}
		}
	}
	
	/* The reactions of state PDFAndSummary. */
	private void react_main_region_Copy_1_Table__region0_PDFAndSummary() {
		if (check_main_region_Copy_1_Table__region0_PDFAndSummary_tr0_tr0()) {
			effect_main_region_Copy_1_Table__region0_PDFAndSummary_tr0();
		}
	}
	
	/* The reactions of state AdditionalInfo. */
	private void react_main_region_Copy_1_Table__region0_AdditionalInfo() {
		if (check_main_region_Copy_1_Table__region0_AdditionalInfo_tr0_tr0()) {
			effect_main_region_Copy_1_Table__region0_AdditionalInfo_tr0();
		}
	}
	
	/* The reactions of state sync1. */
	private void react_main_region_Copy_1_Table__region0_sync1() {
		if (check_main_region_Copy_1_Table__region0_sync1_tr0_StoringGroceries_main_region__sync1join_check()) {
			effect_main_region_Copy_1_Table__region0_sync1_tr0();
		}
	}
	
	/* The reactions of state Copy_1_panCupboard. */
	private void react_main_region_Copy_1_Table__region1_Copy_1_panCupboard() {
		if (check_main_region_Copy_1_Table__region1_Copy_1_panCupboard_tr0_tr0()) {
			effect_main_region_Copy_1_Table__region1_Copy_1_panCupboard_tr0();
		}
	}
	
	/* The reactions of state Copy_1_tiltCupboard. */
	private void react_main_region_Copy_1_Table__region1_Copy_1_tiltCupboard() {
		if (check_main_region_Copy_1_Table__region1_Copy_1_tiltCupboard_tr0_tr0()) {
			effect_main_region_Copy_1_Table__region1_Copy_1_tiltCupboard_tr0();
		}
	}
	
	/* The reactions of state sync1. */
	private void react_main_region_Copy_1_Table__region1_sync1() {
		if (check_main_region_Copy_1_Table__region1_sync1_tr0_StoringGroceries_main_region__sync1join_check()) {
			effect_main_region_Copy_1_Table__region1_sync1_tr0();
		}
	}
	
	/* The reactions of state wait for Mira. */
	private void react_main_region_Copy_1_Table__region1_wait_for_Mira() {
		if (check_main_region_Copy_1_Table__region1_wait_for_Mira_tr0_tr0()) {
			effect_main_region_Copy_1_Table__region1_wait_for_Mira_tr0();
		}
	}
	
	/* The reactions of state move to wp. */
	private void react_main_region_move_to_wp() {
		if (check_main_region_move_to_wp_tr0_tr0()) {
			effect_main_region_move_to_wp_tr0();
		}
	}
	
	/* The reactions of state panCupboard. */
	private void react_main_region_panCupboard() {
		if (check_main_region_panCupboard_tr0_tr0()) {
			effect_main_region_panCupboard_tr0();
		}
	}
	
	/* The reactions of state tiltCupboard. */
	private void react_main_region_tiltCupboard() {
		if (check_main_region_tiltCupboard_tr0_tr0()) {
			effect_main_region_tiltCupboard_tr0();
		}
	}
	
	/* The reactions of state lookToFront. */
	private void react_main_region_lookToFront() {
		effect_main_region_lookToFront_tr0();
	}
	
	/* The reactions of state C1. */
	private void react_main_region_C1() {
		effect_main_region_C1_tr0();
	}
	
	/* The reactions of state C2. */
	private void react_main_region_C2() {
		effect_main_region_C2_tr0();
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
	private void react_main_region__choice_0() {
		if (check_main_region__choice_0_tr0_tr0()) {
			effect_main_region__choice_0_tr0();
		} else {
			if (check_main_region__choice_0_tr1_tr1()) {
				effect_main_region__choice_0_tr1();
			}
		}
	}
	
	/* Default react sequence for initial entry  */
	private void react_main_region__entry_Default() {
		enterSequence_main_region_requestReady_default();
	}
	
	/* Default react sequence for initial entry  */
	private void react_main_region_ObjectDetection_cupboard__entry_Default() {
		enterSequence_main_region_ObjectDetection_cupboard_waitForNewObj_default();
	}
	
	/* Default react sequence for initial entry  */
	private void react_main_region_inspectTable_table__entry_Default() {
		enterSequence_main_region_inspectTable_table_waitForNewObj_default();
	}
	
	/* Default react sequence for initial entry  */
	private void react_Leonie_Bupered_Or_Emergency_Stop__entry_Default() {
		enterSequence_Leonie_Bupered_Or_Emergency_Stop_waitForEvent_default();
	}
	
	/* The reactions of state null. */
	private void react_main_region__sync0() {
		enterSequence_main_region_Copy_1_Table__region0_PDFAndSummary_default();
		enterSequence_main_region_Copy_1_Table__region1_wait_for_Mira_default();
	}
	
	/* The reactions of state null. */
	private void react_main_region__sync1() {
		enterSequence_main_region__final__default();
	}
	
	public void runCycle() {
		if (!initialized)
			throw new IllegalStateException(
					"The state machine needs to be initialized first by calling the init() function.");
		clearOutEvents();
		for (nextStateIndex = 0; nextStateIndex < stateVector.length; nextStateIndex++) {
			switch (stateVector[nextStateIndex]) {
			case main_region_ObjectDetection_cupboard_tellObj:
				react_main_region_ObjectDetection_cupboard_tellObj();
				break;
			case main_region_ObjectDetection_cupboard_waitForNewObj:
				react_main_region_ObjectDetection_cupboard_waitForNewObj();
				break;
			case main_region__final_:
				react_main_region__final_();
				break;
			case main_region_requestReady:
				react_main_region_requestReady();
				break;
			case main_region_inspectTable_table_tellObj:
				react_main_region_inspectTable_table_tellObj();
				break;
			case main_region_inspectTable_table_waitForNewObj:
				react_main_region_inspectTable_table_waitForNewObj();
				break;
			case main_region_Copy_1_Table__region0_PDFAndSummary:
				react_main_region_Copy_1_Table__region0_PDFAndSummary();
				break;
			case main_region_Copy_1_Table__region0_AdditionalInfo:
				react_main_region_Copy_1_Table__region0_AdditionalInfo();
				break;
			case main_region_Copy_1_Table__region0_sync1:
				react_main_region_Copy_1_Table__region0_sync1();
				break;
			case main_region_Copy_1_Table__region1_Copy_1_panCupboard:
				react_main_region_Copy_1_Table__region1_Copy_1_panCupboard();
				break;
			case main_region_Copy_1_Table__region1_Copy_1_tiltCupboard:
				react_main_region_Copy_1_Table__region1_Copy_1_tiltCupboard();
				break;
			case main_region_Copy_1_Table__region1_sync1:
				react_main_region_Copy_1_Table__region1_sync1();
				break;
			case main_region_Copy_1_Table__region1_wait_for_Mira:
				react_main_region_Copy_1_Table__region1_wait_for_Mira();
				break;
			case main_region_move_to_wp:
				react_main_region_move_to_wp();
				break;
			case main_region_panCupboard:
				react_main_region_panCupboard();
				break;
			case main_region_tiltCupboard:
				react_main_region_tiltCupboard();
				break;
			case main_region_lookToFront:
				react_main_region_lookToFront();
				break;
			case main_region_C1:
				react_main_region_C1();
				break;
			case main_region_C2:
				react_main_region_C2();
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
