package org.yakindu.scr.defaultsm;
import org.yakindu.scr.ITimer;

public class DefaultSMStatemachine implements IDefaultSMStatemachine {

	protected class SCInterfaceImpl implements SCInterface {

		private SCInterfaceOperationCallback operationCallback;

		public void setSCInterfaceOperationCallback(SCInterfaceOperationCallback operationCallback) {
			this.operationCallback = operationCallback;
		}

	}

	protected SCInterfaceImpl sCInterface;

	private boolean initialized = false;

	public enum State {
		main_region_StateA, main_region_StateB, $NullState$
	};

	private final State[] stateVector = new State[1];

	private int nextStateIndex;

	private ITimer timer;

	private final boolean[] timeEvents = new boolean[1];

	public DefaultSMStatemachine() {

		sCInterface = new SCInterfaceImpl();
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
		if (!initialized)
			throw new IllegalStateException(
					"The state machine needs to be initialized first by calling the init() function.");

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

		for (int i = 0; i < timeEvents.length; i++) {
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
			case main_region_StateA :
				return stateVector[0] == State.main_region_StateA;
			case main_region_StateB :
				return stateVector[0] == State.main_region_StateB;
			default :
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

	public SCInterface getSCInterface() {
		return sCInterface;
	}

	private boolean check_main_region_StateA_tr0_tr0() {
		return timeEvents[0];
	}

	private void effect_main_region_StateA_tr0() {
		exitSequence_main_region_StateA();

		enterSequence_main_region_StateB_default();
	}

	/* Entry action for state 'StateA'. */
	private void entryAction_main_region_StateA() {

		timer.setTimer(this, 0, 3 * 1000, false);
	}

	/* Exit action for state 'StateA'. */
	private void exitAction_main_region_StateA() {
		timer.unsetTimer(this, 0);
	}

	/* 'default' enter sequence for state StateA */
	private void enterSequence_main_region_StateA_default() {
		entryAction_main_region_StateA();

		nextStateIndex = 0;
		stateVector[0] = State.main_region_StateA;
	}

	/* 'default' enter sequence for state StateB */
	private void enterSequence_main_region_StateB_default() {
		nextStateIndex = 0;
		stateVector[0] = State.main_region_StateB;
	}

	/* 'default' enter sequence for region main region */
	private void enterSequence_main_region_default() {
		react_main_region__entry_Default();
	}

	/* Default exit sequence for state StateA */
	private void exitSequence_main_region_StateA() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;

		exitAction_main_region_StateA();
	}

	/* Default exit sequence for state StateB */
	private void exitSequence_main_region_StateB() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for region main region */
	private void exitSequence_main_region() {
		switch (stateVector[0]) {
			case main_region_StateA :
				exitSequence_main_region_StateA();
				break;

			case main_region_StateB :
				exitSequence_main_region_StateB();
				break;

			default :
				break;
		}
	}

	/* The reactions of state StateA. */
	private void react_main_region_StateA() {
		if (check_main_region_StateA_tr0_tr0()) {
			effect_main_region_StateA_tr0();
		}
	}

	/* The reactions of state StateB. */
	private void react_main_region_StateB() {
	}

	/* Default react sequence for initial entry  */
	private void react_main_region__entry_Default() {
		enterSequence_main_region_StateA_default();
	}

	public void runCycle() {
		if (!initialized)
			throw new IllegalStateException(
					"The state machine needs to be initialized first by calling the init() function.");

		clearOutEvents();

		for (nextStateIndex = 0; nextStateIndex < stateVector.length; nextStateIndex++) {

			switch (stateVector[nextStateIndex]) {
				case main_region_StateA :
					react_main_region_StateA();
					break;
				case main_region_StateB :
					react_main_region_StateB();
					break;
				default :
					// $NullState$
			}
		}

		clearEvents();
	}
}
