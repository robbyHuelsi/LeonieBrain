package org.yakindu.scr.test_leapmotion;
import org.yakindu.scr.ITimer;

public class Test_LeapMotionStatemachine implements ITest_LeapMotionStatemachine {

	protected class SCILeapMotionImpl implements SCILeapMotion {
	
		private SCILeapMotionOperationCallback operationCallback;
		
		public void setSCILeapMotionOperationCallback(
				SCILeapMotionOperationCallback operationCallback) {
			this.operationCallback = operationCallback;
		}
		private boolean gestureDetected;
		
		public void raiseGestureDetected() {
			gestureDetected = true;
		}
		
		private boolean stringFinished;
		
		public void raiseStringFinished() {
			stringFinished = true;
		}
		
		protected void clearEvents() {
			gestureDetected = false;
			stringFinished = false;
		}
	}
	
	protected SCILeapMotionImpl sCILeapMotion;
	
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
	
	private boolean initialized = false;
	
	public enum State {
		main_region_StartSTT,
		main_region_Left,
		main_region_Right,
		main_region_count,
		main_region__final_,
		main_region_end,
		main_region_timeOut,
		$NullState$
	};
	
	private final State[] stateVector = new State[1];
	
	private int nextStateIndex;
	
	private ITimer timer;
	
	private final boolean[] timeEvents = new boolean[3];
	private long counter;
	
	protected void setCounter(long value) {
		counter = value;
	}
	
	protected long getCounter() {
		return counter;
	}
	
	public Test_LeapMotionStatemachine() {
		sCILeapMotion = new SCILeapMotionImpl();
		sCIHBrain = new SCIHBrainImpl();
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
		setCounter(0);
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
		sCILeapMotion.clearEvents();
		sCIHBrain.clearEvents();
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
		case main_region_StartSTT:
			return stateVector[0] == State.main_region_StartSTT;
		case main_region_Left:
			return stateVector[0] == State.main_region_Left;
		case main_region_Right:
			return stateVector[0] == State.main_region_Right;
		case main_region_count:
			return stateVector[0] == State.main_region_count;
		case main_region__final_:
			return stateVector[0] == State.main_region__final_;
		case main_region_end:
			return stateVector[0] == State.main_region_end;
		case main_region_timeOut:
			return stateVector[0] == State.main_region_timeOut;
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
	
	public SCILeapMotion getSCILeapMotion() {
		return sCILeapMotion;
	}
	
	public SCIHBrain getSCIHBrain() {
		return sCIHBrain;
	}
	
	public SCIMira getSCIMira() {
		return sCIMira;
	}
	
	private boolean check_main_region_StartSTT_tr0_tr0() {
		return timeEvents[0];
	}
	
	private boolean check_main_region_StartSTT_tr1_tr1() {
		return (sCILeapMotion.operationCallback.getGesture()== null?"false" ==null :sCILeapMotion.operationCallback.getGesture().equals("false"));
	}
	
	private boolean check_main_region_StartSTT_tr2_tr2() {
		return (sCILeapMotion.operationCallback.getGesture()== null?"true" ==null :sCILeapMotion.operationCallback.getGesture().equals("true"));
	}
	
	private boolean check_main_region_Left_tr0_tr0() {
		return timeEvents[1];
	}
	
	private boolean check_main_region_Right_tr0_tr0() {
		return timeEvents[2];
	}
	
	private boolean check_main_region_count_tr0_tr0() {
		return true;
	}
	
	private boolean check_main_region_end_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_main_region_timeOut_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_main_region__choice_0_tr0_tr0() {
		return getCounter()<2;
	}
	
	private boolean check_main_region__choice_0_tr1_tr1() {
		return true;
	}
	
	private void effect_main_region_StartSTT_tr0() {
		exitSequence_main_region_StartSTT();
		enterSequence_main_region_timeOut_default();
	}
	
	private void effect_main_region_StartSTT_tr1() {
		exitSequence_main_region_StartSTT();
		enterSequence_main_region_Right_default();
	}
	
	private void effect_main_region_StartSTT_tr2() {
		exitSequence_main_region_StartSTT();
		enterSequence_main_region_Left_default();
	}
	
	private void effect_main_region_Left_tr0() {
		exitSequence_main_region_Left();
		react_main_region__choice_0();
	}
	
	private void effect_main_region_Right_tr0() {
		exitSequence_main_region_Right();
		react_main_region__choice_0();
	}
	
	private void effect_main_region_count_tr0() {
		exitSequence_main_region_count();
		enterSequence_main_region_StartSTT_default();
	}
	
	private void effect_main_region_end_tr0() {
		exitSequence_main_region_end();
		enterSequence_main_region__final__default();
	}
	
	private void effect_main_region_timeOut_tr0() {
		exitSequence_main_region_timeOut();
		enterSequence_main_region__final__default();
	}
	
	private void effect_main_region__choice_0_tr0() {
		enterSequence_main_region_StartSTT_default();
	}
	
	private void effect_main_region__choice_0_tr1() {
		enterSequence_main_region_end_default();
	}
	
	/* Entry action for state 'StartSTT'. */
	private void entryAction_main_region_StartSTT() {
		timer.setTimer(this, 0, 150 * 1000, false);
		
		sCILeapMotion.operationCallback.sendGestureDetectionOnOff(3);
		
		setCounter(getCounter() + 1);
	}
	
	/* Entry action for state 'Left'. */
	private void entryAction_main_region_Left() {
		timer.setTimer(this, 1, 1 * 1000, false);
		
		sCIMira.operationCallback.sendTurnBody(-30);
		
		sCIHBrain.operationCallback.sendTTS("Right.");
	}
	
	/* Entry action for state 'Right'. */
	private void entryAction_main_region_Right() {
		timer.setTimer(this, 2, 1 * 1000, false);
		
		sCIMira.operationCallback.sendTurnBody(30);
		
		sCIHBrain.operationCallback.sendTTS("Left");
	}
	
	/* Entry action for state 'count'. */
	private void entryAction_main_region_count() {
		setCounter(0);
	}
	
	/* Entry action for state 'end'. */
	private void entryAction_main_region_end() {
		sCIHBrain.operationCallback.sendTTS("Done. I go to sleep.");
	}
	
	/* Entry action for state 'timeOut'. */
	private void entryAction_main_region_timeOut() {
		sCIHBrain.operationCallback.sendTTS("Time out.");
	}
	
	/* Exit action for state 'StartSTT'. */
	private void exitAction_main_region_StartSTT() {
		timer.unsetTimer(this, 0);
		
		sCILeapMotion.operationCallback.sendGestureDetectionOnOff(0);
	}
	
	/* Exit action for state 'Left'. */
	private void exitAction_main_region_Left() {
		timer.unsetTimer(this, 1);
	}
	
	/* Exit action for state 'Right'. */
	private void exitAction_main_region_Right() {
		timer.unsetTimer(this, 2);
	}
	
	/* 'default' enter sequence for state StartSTT */
	private void enterSequence_main_region_StartSTT_default() {
		entryAction_main_region_StartSTT();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_StartSTT;
	}
	
	/* 'default' enter sequence for state Left */
	private void enterSequence_main_region_Left_default() {
		entryAction_main_region_Left();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_Left;
	}
	
	/* 'default' enter sequence for state Right */
	private void enterSequence_main_region_Right_default() {
		entryAction_main_region_Right();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_Right;
	}
	
	/* 'default' enter sequence for state count */
	private void enterSequence_main_region_count_default() {
		entryAction_main_region_count();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_count;
	}
	
	/* Default enter sequence for state null */
	private void enterSequence_main_region__final__default() {
		nextStateIndex = 0;
		stateVector[0] = State.main_region__final_;
	}
	
	/* 'default' enter sequence for state end */
	private void enterSequence_main_region_end_default() {
		entryAction_main_region_end();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_end;
	}
	
	/* 'default' enter sequence for state timeOut */
	private void enterSequence_main_region_timeOut_default() {
		entryAction_main_region_timeOut();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_timeOut;
	}
	
	/* 'default' enter sequence for region main region */
	private void enterSequence_main_region_default() {
		react_main_region__entry_Default();
	}
	
	/* Default exit sequence for state StartSTT */
	private void exitSequence_main_region_StartSTT() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
		
		exitAction_main_region_StartSTT();
	}
	
	/* Default exit sequence for state Left */
	private void exitSequence_main_region_Left() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
		
		exitAction_main_region_Left();
	}
	
	/* Default exit sequence for state Right */
	private void exitSequence_main_region_Right() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
		
		exitAction_main_region_Right();
	}
	
	/* Default exit sequence for state count */
	private void exitSequence_main_region_count() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for final state. */
	private void exitSequence_main_region__final_() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state end */
	private void exitSequence_main_region_end() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state timeOut */
	private void exitSequence_main_region_timeOut() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for region main region */
	private void exitSequence_main_region() {
		switch (stateVector[0]) {
		case main_region_StartSTT:
			exitSequence_main_region_StartSTT();
			break;
		case main_region_Left:
			exitSequence_main_region_Left();
			break;
		case main_region_Right:
			exitSequence_main_region_Right();
			break;
		case main_region_count:
			exitSequence_main_region_count();
			break;
		case main_region__final_:
			exitSequence_main_region__final_();
			break;
		case main_region_end:
			exitSequence_main_region_end();
			break;
		case main_region_timeOut:
			exitSequence_main_region_timeOut();
			break;
		default:
			break;
		}
	}
	
	/* The reactions of state StartSTT. */
	private void react_main_region_StartSTT() {
		if (check_main_region_StartSTT_tr0_tr0()) {
			effect_main_region_StartSTT_tr0();
		} else {
			if (check_main_region_StartSTT_tr1_tr1()) {
				effect_main_region_StartSTT_tr1();
			} else {
				if (check_main_region_StartSTT_tr2_tr2()) {
					effect_main_region_StartSTT_tr2();
				}
			}
		}
	}
	
	/* The reactions of state Left. */
	private void react_main_region_Left() {
		if (check_main_region_Left_tr0_tr0()) {
			effect_main_region_Left_tr0();
		}
	}
	
	/* The reactions of state Right. */
	private void react_main_region_Right() {
		if (check_main_region_Right_tr0_tr0()) {
			effect_main_region_Right_tr0();
		}
	}
	
	/* The reactions of state count. */
	private void react_main_region_count() {
		effect_main_region_count_tr0();
	}
	
	/* The reactions of state null. */
	private void react_main_region__final_() {
	}
	
	/* The reactions of state end. */
	private void react_main_region_end() {
		if (check_main_region_end_tr0_tr0()) {
			effect_main_region_end_tr0();
		}
	}
	
	/* The reactions of state timeOut. */
	private void react_main_region_timeOut() {
		if (check_main_region_timeOut_tr0_tr0()) {
			effect_main_region_timeOut_tr0();
		}
	}
	
	/* The reactions of state null. */
	private void react_main_region__choice_0() {
		if (check_main_region__choice_0_tr0_tr0()) {
			effect_main_region__choice_0_tr0();
		} else {
			effect_main_region__choice_0_tr1();
		}
	}
	
	/* Default react sequence for initial entry  */
	private void react_main_region__entry_Default() {
		enterSequence_main_region_count_default();
	}
	
	public void runCycle() {
		if (!initialized)
			throw new IllegalStateException(
					"The state machine needs to be initialized first by calling the init() function.");
		clearOutEvents();
		for (nextStateIndex = 0; nextStateIndex < stateVector.length; nextStateIndex++) {
			switch (stateVector[nextStateIndex]) {
			case main_region_StartSTT:
				react_main_region_StartSTT();
				break;
			case main_region_Left:
				react_main_region_Left();
				break;
			case main_region_Right:
				react_main_region_Right();
				break;
			case main_region_count:
				react_main_region_count();
				break;
			case main_region__final_:
				react_main_region__final_();
				break;
			case main_region_end:
				react_main_region_end();
				break;
			case main_region_timeOut:
				react_main_region_timeOut();
				break;
			default:
				// $NullState$
			}
		}
		clearEvents();
	}
}
