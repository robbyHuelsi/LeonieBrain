package org.yakindu.scr.generalpurposeservicerobot;

public class GeneralPurposeServiceRobotStatemachine implements IGeneralPurposeServiceRobotStatemachine {

	private boolean initialized = false;
	
	public enum State {
		main_region_Init,
		main_region_Entering_arena,
		main_region_Wait_for_command,
		main_region_Repeat_command,
		main_region_Back_to_operator,
		main_region_do_the_task,
		main_region_Leave_the_arena,
		main_region__final_,
		$NullState$
	};
	
	private final State[] stateVector = new State[1];
	
	private int nextStateIndex;
	
	public GeneralPurposeServiceRobotStatemachine() {
	}
	
	public void init() {
		this.initialized = true;
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
		case main_region_Entering_arena:
			return stateVector[0] == State.main_region_Entering_arena;
		case main_region_Wait_for_command:
			return stateVector[0] == State.main_region_Wait_for_command;
		case main_region_Repeat_command:
			return stateVector[0] == State.main_region_Repeat_command;
		case main_region_Back_to_operator:
			return stateVector[0] == State.main_region_Back_to_operator;
		case main_region_do_the_task:
			return stateVector[0] == State.main_region_do_the_task;
		case main_region_Leave_the_arena:
			return stateVector[0] == State.main_region_Leave_the_arena;
		case main_region__final_:
			return stateVector[0] == State.main_region__final_;
		default:
			return false;
		}
	}
	
	/* 'default' enter sequence for state Init */
	private void enterSequence_main_region_Init_default() {
		nextStateIndex = 0;
		stateVector[0] = State.main_region_Init;
	}
	
	/* 'default' enter sequence for state Entering arena */
	private void enterSequence_main_region_Entering_arena_default() {
		nextStateIndex = 0;
		stateVector[0] = State.main_region_Entering_arena;
	}
	
	/* 'default' enter sequence for state Wait for command */
	private void enterSequence_main_region_Wait_for_command_default() {
		nextStateIndex = 0;
		stateVector[0] = State.main_region_Wait_for_command;
	}
	
	/* 'default' enter sequence for state Repeat command */
	private void enterSequence_main_region_Repeat_command_default() {
		nextStateIndex = 0;
		stateVector[0] = State.main_region_Repeat_command;
	}
	
	/* 'default' enter sequence for state Back to operator */
	private void enterSequence_main_region_Back_to_operator_default() {
		nextStateIndex = 0;
		stateVector[0] = State.main_region_Back_to_operator;
	}
	
	/* 'default' enter sequence for state do the task */
	private void enterSequence_main_region_do_the_task_default() {
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
	
	/* 'default' enter sequence for region main region */
	private void enterSequence_main_region_default() {
		react_main_region__entry_Default();
	}
	
	/* Default exit sequence for state Init */
	private void exitSequence_main_region_Init() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state Entering arena */
	private void exitSequence_main_region_Entering_arena() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state Wait for command */
	private void exitSequence_main_region_Wait_for_command() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state Repeat command */
	private void exitSequence_main_region_Repeat_command() {
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
	
	/* Default exit sequence for region main region */
	private void exitSequence_main_region() {
		switch (stateVector[0]) {
		case main_region_Init:
			exitSequence_main_region_Init();
			break;
		case main_region_Entering_arena:
			exitSequence_main_region_Entering_arena();
			break;
		case main_region_Wait_for_command:
			exitSequence_main_region_Wait_for_command();
			break;
		case main_region_Repeat_command:
			exitSequence_main_region_Repeat_command();
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
		default:
			break;
		}
	}
	
	/* The reactions of state Init. */
	private void react_main_region_Init() {
	}
	
	/* The reactions of state Entering arena. */
	private void react_main_region_Entering_arena() {
	}
	
	/* The reactions of state Wait for command. */
	private void react_main_region_Wait_for_command() {
	}
	
	/* The reactions of state Repeat command. */
	private void react_main_region_Repeat_command() {
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
			case main_region_Entering_arena:
				react_main_region_Entering_arena();
				break;
			case main_region_Wait_for_command:
				react_main_region_Wait_for_command();
				break;
			case main_region_Repeat_command:
				react_main_region_Repeat_command();
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
			default:
				// $NullState$
			}
		}
		clearEvents();
	}
}
