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
		$NullState$
	};
	
	private final State[] stateVector = new State[1];
	
	private int nextStateIndex;
	
	private ITimer timer;
	
	private final boolean[] timeEvents = new boolean[2];
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
		return sCILeapMotion.gestureDetected;
	}
	
	private boolean check_main_region_Left_tr0_tr0() {
		return timeEvents[0];
	}
	
	private boolean check_main_region_Right_tr0_tr0() {
		return timeEvents[1];
	}
	
	private boolean check_main_region__choice_0_tr0_tr0() {
		return (sCILeapMotion.operationCallback.getGesture()== null?"right" ==null :sCILeapMotion.operationCallback.getGesture().equals("right"));
	}
	
	private boolean check_main_region__choice_0_tr1_tr1() {
		return (sCILeapMotion.operationCallback.getGesture()== null?"left" ==null :sCILeapMotion.operationCallback.getGesture().equals("left"));
	}
	
	private boolean check_main_region__choice_0_tr2_tr2() {
		return true;
	}
	
	private void effect_main_region_StartSTT_tr0() {
		exitSequence_main_region_StartSTT();
		react_main_region__choice_0();
	}
	
	private void effect_main_region_Left_tr0() {
		exitSequence_main_region_Left();
		enterSequence_main_region_StartSTT_default();
	}
	
	private void effect_main_region_Right_tr0() {
		exitSequence_main_region_Right();
		enterSequence_main_region_StartSTT_default();
	}
	
	private void effect_main_region__choice_0_tr0() {
		enterSequence_main_region_Left_default();
	}
	
	private void effect_main_region__choice_0_tr1() {
		enterSequence_main_region_Right_default();
	}
	
	private void effect_main_region__choice_0_tr2() {
		enterSequence_main_region_StartSTT_default();
	}
	
	/* Entry action for state 'StartSTT'. */
	private void entryAction_main_region_StartSTT() {
		sCILeapMotion.operationCallback.sendGestureDetectionOnOff(4);
	}
	
	/* Entry action for state 'Left'. */
	private void entryAction_main_region_Left() {
		timer.setTimer(this, 0, 1 * 1000, false);
		
		sCIMira.operationCallback.sendTurnBody(-30);
		
		sCIHBrain.operationCallback.sendTTS("Right.");
	}
	
	/* Entry action for state 'Right'. */
	private void entryAction_main_region_Right() {
		timer.setTimer(this, 1, 1 * 1000, false);
		
		sCIMira.operationCallback.sendTurnBody(30);
		
		sCIHBrain.operationCallback.sendTTS("Left");
	}
	
	/* Exit action for state 'StartSTT'. */
	private void exitAction_main_region_StartSTT() {
		sCILeapMotion.operationCallback.sendGestureDetectionOnOff(0);
	}
	
	/* Exit action for state 'Left'. */
	private void exitAction_main_region_Left() {
		timer.unsetTimer(this, 0);
	}
	
	/* Exit action for state 'Right'. */
	private void exitAction_main_region_Right() {
		timer.unsetTimer(this, 1);
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
		default:
			break;
		}
	}
	
	/* The reactions of state StartSTT. */
	private void react_main_region_StartSTT() {
		if (check_main_region_StartSTT_tr0_tr0()) {
			effect_main_region_StartSTT_tr0();
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
	
	/* The reactions of state null. */
	private void react_main_region__choice_0() {
		if (check_main_region__choice_0_tr0_tr0()) {
			effect_main_region__choice_0_tr0();
		} else {
			if (check_main_region__choice_0_tr1_tr1()) {
				effect_main_region__choice_0_tr1();
			} else {
				effect_main_region__choice_0_tr2();
			}
		}
	}
	
	/* Default react sequence for initial entry  */
	private void react_main_region__entry_Default() {
		enterSequence_main_region_StartSTT_default();
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
			default:
				// $NullState$
			}
		}
		clearEvents();
	}
}
