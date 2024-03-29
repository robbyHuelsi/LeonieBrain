package org.yakindu.scr.testbrain;

public class TestBrainStatemachine implements ITestBrainStatemachine {

	protected class SCIUdpInterfaceImpl implements SCIUdpInterface {

		private SCIUdpInterfaceOperationCallback operationCallback;

		public void setSCIUdpInterfaceOperationCallback(SCIUdpInterfaceOperationCallback operationCallback) {
			this.operationCallback = operationCallback;
		}

		private String data;

		public String getData() {
			return data;
		}

		public void setData(String value) {
			this.data = value;
		}

	}

	protected SCIUdpInterfaceImpl sCIUdpInterface;

	protected class SCIPrintDataInterfaceImpl implements SCIPrintDataInterface {

		private SCIPrintDataInterfaceOperationCallback operationCallback;

		public void setSCIPrintDataInterfaceOperationCallback(
				SCIPrintDataInterfaceOperationCallback operationCallback) {
			this.operationCallback = operationCallback;
		}

	}

	protected SCIPrintDataInterfaceImpl sCIPrintDataInterface;

	private boolean initialized = false;

	public enum State {
		main_region_ReceiveData, main_region_PrintData, $NullState$
	};

	private final State[] stateVector = new State[1];

	private int nextStateIndex;

	private boolean onReceivedData;

	public TestBrainStatemachine() {

		sCIUdpInterface = new SCIUdpInterfaceImpl();
		sCIPrintDataInterface = new SCIPrintDataInterfaceImpl();
	}

	public void init() {
		this.initialized = true;
		for (int i = 0; i < 1; i++) {
			stateVector[i] = State.$NullState$;
		}

		clearEvents();
		clearOutEvents();

		sCIUdpInterface.setData("");
	}

	public void enter() {
		if (!initialized)
			throw new IllegalStateException(
					"The statemachine needs to be initialized first by calling the init() function.");

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
		onReceivedData = false;

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
			case main_region_ReceiveData :
				return stateVector[0] == State.main_region_ReceiveData;
			case main_region_PrintData :
				return stateVector[0] == State.main_region_PrintData;
			default :
				return false;
		}
	}

	public SCIUdpInterface getSCIUdpInterface() {
		return sCIUdpInterface;
	}
	public SCIPrintDataInterface getSCIPrintDataInterface() {
		return sCIPrintDataInterface;
	}

	private void raiseOnReceivedData() {
		onReceivedData = true;
	}

	private boolean check_main_region_ReceiveData_tr0_tr0() {
		return true;
	}

	private boolean check_main_region_PrintData_tr0_tr0() {
		return true;
	}

	private void effect_main_region_ReceiveData_tr0() {
		exitSequence_main_region_ReceiveData();

		enterSequence_main_region_PrintData_default();
	}

	private void effect_main_region_PrintData_tr0() {
		exitSequence_main_region_PrintData();

		enterSequence_main_region_ReceiveData_default();
	}

	/* Entry action for state 'ReceiveData'. */
	private void entryAction_main_region_ReceiveData() {
		sCIUdpInterface.operationCallback.receive();
	}

	/* Entry action for state 'PrintData'. */
	private void entryAction_main_region_PrintData() {
		sCIPrintDataInterface.operationCallback.print();
	}

	/* 'default' enter sequence for state ReceiveData */
	private void enterSequence_main_region_ReceiveData_default() {
		entryAction_main_region_ReceiveData();

		nextStateIndex = 0;
		stateVector[0] = State.main_region_ReceiveData;
	}

	/* 'default' enter sequence for state PrintData */
	private void enterSequence_main_region_PrintData_default() {
		entryAction_main_region_PrintData();

		nextStateIndex = 0;
		stateVector[0] = State.main_region_PrintData;
	}

	/* 'default' enter sequence for region main region */
	private void enterSequence_main_region_default() {
		react_main_region__entry_Default();
	}

	/* Default exit sequence for state ReceiveData */
	private void exitSequence_main_region_ReceiveData() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for state PrintData */
	private void exitSequence_main_region_PrintData() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for region main region */
	private void exitSequence_main_region() {
		switch (stateVector[0]) {
			case main_region_ReceiveData :
				exitSequence_main_region_ReceiveData();
				break;

			case main_region_PrintData :
				exitSequence_main_region_PrintData();
				break;

			default :
				break;
		}
	}

	/* The reactions of state ReceiveData. */
	private void react_main_region_ReceiveData() {
		effect_main_region_ReceiveData_tr0();
	}

	/* The reactions of state PrintData. */
	private void react_main_region_PrintData() {
		effect_main_region_PrintData_tr0();
	}

	/* Default react sequence for initial entry  */
	private void react_main_region__entry_Default() {
		enterSequence_main_region_ReceiveData_default();
	}

	public void runCycle() {
		if (!initialized)
			throw new IllegalStateException(
					"The statemachine needs to be initialized first by calling the init() function.");

		clearOutEvents();

		for (nextStateIndex = 0; nextStateIndex < stateVector.length; nextStateIndex++) {

			switch (stateVector[nextStateIndex]) {
				case main_region_ReceiveData :
					react_main_region_ReceiveData();
					break;
				case main_region_PrintData :
					react_main_region_PrintData();
					break;
				default :
					// $NullState$
			}
		}

		clearEvents();
	}
}
