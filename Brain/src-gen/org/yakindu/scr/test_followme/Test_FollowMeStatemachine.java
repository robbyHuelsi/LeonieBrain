package org.yakindu.scr.test_followme;
import org.yakindu.scr.ITimer;

public class Test_FollowMeStatemachine implements ITest_FollowMeStatemachine {

	protected class SCIFollowMeImpl implements SCIFollowMe {
	
		private SCIFollowMeOperationCallback operationCallback;
		
		public void setSCIFollowMeOperationCallback(
				SCIFollowMeOperationCallback operationCallback) {
			this.operationCallback = operationCallback;
		}
		private boolean detectionPersonFound;
		
		public void raiseDetectionPersonFound() {
			detectionPersonFound = true;
		}
		
		private boolean trackingPersonLost;
		
		public void raiseTrackingPersonLost() {
			trackingPersonLost = true;
		}
		
		private boolean obstacleDetected;
		
		public void raiseObstacleDetected() {
			obstacleDetected = true;
		}
		
		protected void clearEvents() {
			detectionPersonFound = false;
			trackingPersonLost = false;
			obstacleDetected = false;
		}
	}
	
	protected SCIFollowMeImpl sCIFollowMe;
	
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
	
	private boolean initialized = false;
	
	public enum State {
		main_region_DetectionOn,
		main_region_TrackingOn,
		main_region_TurnAllOff,
		main_region__final_,
		main_region_RequestDetectionDetails,
		main_region_Welcome,
		$NullState$
	};
	
	private final State[] stateVector = new State[1];
	
	private int nextStateIndex;
	
	private ITimer timer;
	
	private final boolean[] timeEvents = new boolean[2];
	public Test_FollowMeStatemachine() {
		sCIFollowMe = new SCIFollowMeImpl();
		sCIHBrain = new SCIHBrainImpl();
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
	* @see IStatemachine#isFinal()
	*/
	public boolean isFinal() {
		return (stateVector[0] == State.main_region__final_);
	}
	/**
	* This method resets the incoming events (time events included).
	*/
	protected void clearEvents() {
		sCIFollowMe.clearEvents();
		sCIHBrain.clearEvents();
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
		case main_region_DetectionOn:
			return stateVector[0] == State.main_region_DetectionOn;
		case main_region_TrackingOn:
			return stateVector[0] == State.main_region_TrackingOn;
		case main_region_TurnAllOff:
			return stateVector[0] == State.main_region_TurnAllOff;
		case main_region__final_:
			return stateVector[0] == State.main_region__final_;
		case main_region_RequestDetectionDetails:
			return stateVector[0] == State.main_region_RequestDetectionDetails;
		case main_region_Welcome:
			return stateVector[0] == State.main_region_Welcome;
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
	
	public SCIFollowMe getSCIFollowMe() {
		return sCIFollowMe;
	}
	
	public SCIHBrain getSCIHBrain() {
		return sCIHBrain;
	}
	
	private boolean check_main_region_DetectionOn_tr0_tr0() {
		return true;
	}
	
	private boolean check_main_region_TrackingOn_tr0_tr0() {
		return sCIFollowMe.trackingPersonLost;
	}
	
	private boolean check_main_region_TurnAllOff_tr0_tr0() {
		return timeEvents[0];
	}
	
	private boolean check_main_region_RequestDetectionDetails_tr0_tr0() {
		return sCIFollowMe.detectionPersonFound;
	}
	
	private boolean check_main_region_RequestDetectionDetails_tr1_tr1() {
		return timeEvents[1];
	}
	
	private boolean check_main_region_Welcome_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private void effect_main_region_DetectionOn_tr0() {
		exitSequence_main_region_DetectionOn();
		enterSequence_main_region_RequestDetectionDetails_default();
	}
	
	private void effect_main_region_TrackingOn_tr0() {
		exitSequence_main_region_TrackingOn();
		enterSequence_main_region_TurnAllOff_default();
	}
	
	private void effect_main_region_TurnAllOff_tr0() {
		exitSequence_main_region_TurnAllOff();
		enterSequence_main_region__final__default();
	}
	
	private void effect_main_region_RequestDetectionDetails_tr0() {
		exitSequence_main_region_RequestDetectionDetails();
		enterSequence_main_region_TrackingOn_default();
	}
	
	private void effect_main_region_RequestDetectionDetails_tr1() {
		exitSequence_main_region_RequestDetectionDetails();
		enterSequence_main_region_RequestDetectionDetails_default();
	}
	
	private void effect_main_region_Welcome_tr0() {
		exitSequence_main_region_Welcome();
		enterSequence_main_region_DetectionOn_default();
	}
	
	/* Entry action for state 'DetectionOn'. */
	private void entryAction_main_region_DetectionOn() {
		sCIFollowMe.operationCallback.sendDetectionOn();
	}
	
	/* Entry action for state 'TrackingOn'. */
	private void entryAction_main_region_TrackingOn() {
		sCIHBrain.operationCallback.sendTTS("Hello! [:-)] I follow you in the name of love.");
		
		sCIFollowMe.operationCallback.sendTrackingOnAtNext();
	}
	
	/* Entry action for state 'TurnAllOff'. */
	private void entryAction_main_region_TurnAllOff() {
		timer.setTimer(this, 0, 1 * 1000, false);
		
		sCIHBrain.operationCallback.sendTTS("Ops. I lost you. Bye bye.");
		
		sCIFollowMe.operationCallback.sendDetectionOff();
		
		sCIFollowMe.operationCallback.sendTrackingOff();
	}
	
	/* Entry action for state 'RequestDetectionDetails'. */
	private void entryAction_main_region_RequestDetectionDetails() {
		timer.setTimer(this, 1, 1 * 1000, false);
		
		sCIFollowMe.operationCallback.sendRequestDetectionDetails();
	}
	
	/* Entry action for state 'Welcome'. */
	private void entryAction_main_region_Welcome() {
		sCIHBrain.operationCallback.sendTTS("I'm so lonely.[:-(] I want to follow somebody.");
	}
	
	/* Exit action for state 'TurnAllOff'. */
	private void exitAction_main_region_TurnAllOff() {
		timer.unsetTimer(this, 0);
	}
	
	/* Exit action for state 'RequestDetectionDetails'. */
	private void exitAction_main_region_RequestDetectionDetails() {
		timer.unsetTimer(this, 1);
	}
	
	/* 'default' enter sequence for state DetectionOn */
	private void enterSequence_main_region_DetectionOn_default() {
		entryAction_main_region_DetectionOn();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_DetectionOn;
	}
	
	/* 'default' enter sequence for state TrackingOn */
	private void enterSequence_main_region_TrackingOn_default() {
		entryAction_main_region_TrackingOn();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_TrackingOn;
	}
	
	/* 'default' enter sequence for state TurnAllOff */
	private void enterSequence_main_region_TurnAllOff_default() {
		entryAction_main_region_TurnAllOff();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_TurnAllOff;
	}
	
	/* Default enter sequence for state null */
	private void enterSequence_main_region__final__default() {
		nextStateIndex = 0;
		stateVector[0] = State.main_region__final_;
	}
	
	/* 'default' enter sequence for state RequestDetectionDetails */
	private void enterSequence_main_region_RequestDetectionDetails_default() {
		entryAction_main_region_RequestDetectionDetails();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_RequestDetectionDetails;
	}
	
	/* 'default' enter sequence for state Welcome */
	private void enterSequence_main_region_Welcome_default() {
		entryAction_main_region_Welcome();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_Welcome;
	}
	
	/* 'default' enter sequence for region main region */
	private void enterSequence_main_region_default() {
		react_main_region__entry_Default();
	}
	
	/* Default exit sequence for state DetectionOn */
	private void exitSequence_main_region_DetectionOn() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state TrackingOn */
	private void exitSequence_main_region_TrackingOn() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state TurnAllOff */
	private void exitSequence_main_region_TurnAllOff() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
		
		exitAction_main_region_TurnAllOff();
	}
	
	/* Default exit sequence for final state. */
	private void exitSequence_main_region__final_() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state RequestDetectionDetails */
	private void exitSequence_main_region_RequestDetectionDetails() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
		
		exitAction_main_region_RequestDetectionDetails();
	}
	
	/* Default exit sequence for state Welcome */
	private void exitSequence_main_region_Welcome() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for region main region */
	private void exitSequence_main_region() {
		switch (stateVector[0]) {
		case main_region_DetectionOn:
			exitSequence_main_region_DetectionOn();
			break;
		case main_region_TrackingOn:
			exitSequence_main_region_TrackingOn();
			break;
		case main_region_TurnAllOff:
			exitSequence_main_region_TurnAllOff();
			break;
		case main_region__final_:
			exitSequence_main_region__final_();
			break;
		case main_region_RequestDetectionDetails:
			exitSequence_main_region_RequestDetectionDetails();
			break;
		case main_region_Welcome:
			exitSequence_main_region_Welcome();
			break;
		default:
			break;
		}
	}
	
	/* The reactions of state DetectionOn. */
	private void react_main_region_DetectionOn() {
		effect_main_region_DetectionOn_tr0();
	}
	
	/* The reactions of state TrackingOn. */
	private void react_main_region_TrackingOn() {
		if (check_main_region_TrackingOn_tr0_tr0()) {
			effect_main_region_TrackingOn_tr0();
		}
	}
	
	/* The reactions of state TurnAllOff. */
	private void react_main_region_TurnAllOff() {
		if (check_main_region_TurnAllOff_tr0_tr0()) {
			effect_main_region_TurnAllOff_tr0();
		}
	}
	
	/* The reactions of state null. */
	private void react_main_region__final_() {
	}
	
	/* The reactions of state RequestDetectionDetails. */
	private void react_main_region_RequestDetectionDetails() {
		if (check_main_region_RequestDetectionDetails_tr0_tr0()) {
			effect_main_region_RequestDetectionDetails_tr0();
		} else {
			if (check_main_region_RequestDetectionDetails_tr1_tr1()) {
				effect_main_region_RequestDetectionDetails_tr1();
			}
		}
	}
	
	/* The reactions of state Welcome. */
	private void react_main_region_Welcome() {
		if (check_main_region_Welcome_tr0_tr0()) {
			effect_main_region_Welcome_tr0();
		}
	}
	
	/* Default react sequence for initial entry  */
	private void react_main_region__entry_Default() {
		enterSequence_main_region_Welcome_default();
	}
	
	public void runCycle() {
		if (!initialized)
			throw new IllegalStateException(
					"The state machine needs to be initialized first by calling the init() function.");
		clearOutEvents();
		for (nextStateIndex = 0; nextStateIndex < stateVector.length; nextStateIndex++) {
			switch (stateVector[nextStateIndex]) {
			case main_region_DetectionOn:
				react_main_region_DetectionOn();
				break;
			case main_region_TrackingOn:
				react_main_region_TrackingOn();
				break;
			case main_region_TurnAllOff:
				react_main_region_TurnAllOff();
				break;
			case main_region__final_:
				react_main_region__final_();
				break;
			case main_region_RequestDetectionDetails:
				react_main_region_RequestDetectionDetails();
				break;
			case main_region_Welcome:
				react_main_region_Welcome();
				break;
			default:
				// $NullState$
			}
		}
		clearEvents();
	}
}
