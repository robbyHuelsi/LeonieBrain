package org.yakindu.scr.test_mira;
import org.yakindu.scr.ITimer;

public class Test_MiraStatemachine implements ITest_MiraStatemachine {

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
	
	private boolean initialized = false;
	
	public enum State {
		main_region_PTU,
		main_region_Copy_1_PTU,
		main_region_Copy_2_PTU,
		main_region_Copy_3_PTU,
		$NullState$
	};
	
	private final State[] stateVector = new State[1];
	
	private int nextStateIndex;
	
	private ITimer timer;
	
	private final boolean[] timeEvents = new boolean[4];
	public Test_MiraStatemachine() {
		sCIMira = new SCIMiraImpl();
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
		sCIMira.clearEvents();
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
		case main_region_PTU:
			return stateVector[0] == State.main_region_PTU;
		case main_region_Copy_1_PTU:
			return stateVector[0] == State.main_region_Copy_1_PTU;
		case main_region_Copy_2_PTU:
			return stateVector[0] == State.main_region_Copy_2_PTU;
		case main_region_Copy_3_PTU:
			return stateVector[0] == State.main_region_Copy_3_PTU;
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
	
	public SCIMira getSCIMira() {
		return sCIMira;
	}
	
	private boolean check_main_region_PTU_tr0_tr0() {
		return timeEvents[0];
	}
	
	private boolean check_main_region_Copy_1_PTU_tr0_tr0() {
		return timeEvents[1];
	}
	
	private boolean check_main_region_Copy_2_PTU_tr0_tr0() {
		return timeEvents[2];
	}
	
	private boolean check_main_region_Copy_3_PTU_tr0_tr0() {
		return timeEvents[3];
	}
	
	private void effect_main_region_PTU_tr0() {
		exitSequence_main_region_PTU();
		enterSequence_main_region_Copy_1_PTU_default();
	}
	
	private void effect_main_region_Copy_1_PTU_tr0() {
		exitSequence_main_region_Copy_1_PTU();
		enterSequence_main_region_Copy_3_PTU_default();
	}
	
	private void effect_main_region_Copy_2_PTU_tr0() {
		exitSequence_main_region_Copy_2_PTU();
		enterSequence_main_region_PTU_default();
	}
	
	private void effect_main_region_Copy_3_PTU_tr0() {
		exitSequence_main_region_Copy_3_PTU();
		enterSequence_main_region_Copy_2_PTU_default();
	}
	
	/* Entry action for state 'PTU'. */
	private void entryAction_main_region_PTU() {
		timer.setTimer(this, 0, 5*1000, false);
		
		sCIMira.operationCallback.sendPanCamera(100);
	}
	
	/* Entry action for state 'Copy_1_PTU'. */
	private void entryAction_main_region_Copy_1_PTU() {
		timer.setTimer(this, 1, 5*1000, false);
		
		sCIMira.operationCallback.sendTiltCamera(100);
	}
	
	/* Entry action for state 'Copy_2_PTU'. */
	private void entryAction_main_region_Copy_2_PTU() {
		timer.setTimer(this, 2, 5*1000, false);
		
		sCIMira.operationCallback.sendTiltCamera(-100);
	}
	
	/* Entry action for state 'Copy_3_PTU'. */
	private void entryAction_main_region_Copy_3_PTU() {
		timer.setTimer(this, 3, 5*1000, false);
		
		sCIMira.operationCallback.sendPanCamera(-100);
	}
	
	/* Exit action for state 'PTU'. */
	private void exitAction_main_region_PTU() {
		timer.unsetTimer(this, 0);
	}
	
	/* Exit action for state 'Copy_1_PTU'. */
	private void exitAction_main_region_Copy_1_PTU() {
		timer.unsetTimer(this, 1);
	}
	
	/* Exit action for state 'Copy_2_PTU'. */
	private void exitAction_main_region_Copy_2_PTU() {
		timer.unsetTimer(this, 2);
	}
	
	/* Exit action for state 'Copy_3_PTU'. */
	private void exitAction_main_region_Copy_3_PTU() {
		timer.unsetTimer(this, 3);
	}
	
	/* 'default' enter sequence for state PTU */
	private void enterSequence_main_region_PTU_default() {
		entryAction_main_region_PTU();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_PTU;
	}
	
	/* 'default' enter sequence for state Copy_1_PTU */
	private void enterSequence_main_region_Copy_1_PTU_default() {
		entryAction_main_region_Copy_1_PTU();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_Copy_1_PTU;
	}
	
	/* 'default' enter sequence for state Copy_2_PTU */
	private void enterSequence_main_region_Copy_2_PTU_default() {
		entryAction_main_region_Copy_2_PTU();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_Copy_2_PTU;
	}
	
	/* 'default' enter sequence for state Copy_3_PTU */
	private void enterSequence_main_region_Copy_3_PTU_default() {
		entryAction_main_region_Copy_3_PTU();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_Copy_3_PTU;
	}
	
	/* 'default' enter sequence for region main region */
	private void enterSequence_main_region_default() {
		react_main_region__entry_Default();
	}
	
	/* Default exit sequence for state PTU */
	private void exitSequence_main_region_PTU() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
		
		exitAction_main_region_PTU();
	}
	
	/* Default exit sequence for state Copy_1_PTU */
	private void exitSequence_main_region_Copy_1_PTU() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
		
		exitAction_main_region_Copy_1_PTU();
	}
	
	/* Default exit sequence for state Copy_2_PTU */
	private void exitSequence_main_region_Copy_2_PTU() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
		
		exitAction_main_region_Copy_2_PTU();
	}
	
	/* Default exit sequence for state Copy_3_PTU */
	private void exitSequence_main_region_Copy_3_PTU() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
		
		exitAction_main_region_Copy_3_PTU();
	}
	
	/* Default exit sequence for region main region */
	private void exitSequence_main_region() {
		switch (stateVector[0]) {
		case main_region_PTU:
			exitSequence_main_region_PTU();
			break;
		case main_region_Copy_1_PTU:
			exitSequence_main_region_Copy_1_PTU();
			break;
		case main_region_Copy_2_PTU:
			exitSequence_main_region_Copy_2_PTU();
			break;
		case main_region_Copy_3_PTU:
			exitSequence_main_region_Copy_3_PTU();
			break;
		default:
			break;
		}
	}
	
	/* The reactions of state PTU. */
	private void react_main_region_PTU() {
		if (check_main_region_PTU_tr0_tr0()) {
			effect_main_region_PTU_tr0();
		}
	}
	
	/* The reactions of state Copy_1_PTU. */
	private void react_main_region_Copy_1_PTU() {
		if (check_main_region_Copy_1_PTU_tr0_tr0()) {
			effect_main_region_Copy_1_PTU_tr0();
		}
	}
	
	/* The reactions of state Copy_2_PTU. */
	private void react_main_region_Copy_2_PTU() {
		if (check_main_region_Copy_2_PTU_tr0_tr0()) {
			effect_main_region_Copy_2_PTU_tr0();
		}
	}
	
	/* The reactions of state Copy_3_PTU. */
	private void react_main_region_Copy_3_PTU() {
		if (check_main_region_Copy_3_PTU_tr0_tr0()) {
			effect_main_region_Copy_3_PTU_tr0();
		}
	}
	
	/* Default react sequence for initial entry  */
	private void react_main_region__entry_Default() {
		enterSequence_main_region_PTU_default();
	}
	
	public void runCycle() {
		if (!initialized)
			throw new IllegalStateException(
					"The state machine needs to be initialized first by calling the init() function.");
		clearOutEvents();
		for (nextStateIndex = 0; nextStateIndex < stateVector.length; nextStateIndex++) {
			switch (stateVector[nextStateIndex]) {
			case main_region_PTU:
				react_main_region_PTU();
				break;
			case main_region_Copy_1_PTU:
				react_main_region_Copy_1_PTU();
				break;
			case main_region_Copy_2_PTU:
				react_main_region_Copy_2_PTU();
				break;
			case main_region_Copy_3_PTU:
				react_main_region_Copy_3_PTU();
				break;
			default:
				// $NullState$
			}
		}
		clearEvents();
	}
}
