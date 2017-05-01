package org.yakindu.scr.test_waving;
import org.yakindu.scr.ITimer;

public class Test_WavingStatemachine implements ITest_WavingStatemachine {

	protected class SCIKinect2Impl implements SCIKinect2 {
	
		private SCIKinect2OperationCallback operationCallback;
		
		public void setSCIKinect2OperationCallback(
				SCIKinect2OperationCallback operationCallback) {
			this.operationCallback = operationCallback;
		}
		private boolean personDetected;
		
		public void raisePersonDetected() {
			personDetected = true;
		}
		
		private boolean noiseDetected;
		
		public void raiseNoiseDetected() {
			noiseDetected = true;
		}
		
		private boolean wavingDetected;
		
		public void raiseWavingDetected() {
			wavingDetected = true;
		}
		
		protected void clearEvents() {
			personDetected = false;
			noiseDetected = false;
			wavingDetected = false;
		}
	}
	
	protected SCIKinect2Impl sCIKinect2;
	
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
		main_region_Welcome,
		$NullState$
	};
	
	private final State[] stateVector = new State[1];
	
	private int nextStateIndex;
	
	private ITimer timer;
	
	private final boolean[] timeEvents = new boolean[1];
	public Test_WavingStatemachine() {
		sCIKinect2 = new SCIKinect2Impl();
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
		sCIKinect2.clearEvents();
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
	
	public SCIKinect2 getSCIKinect2() {
		return sCIKinect2;
	}
	
	public SCIHBrain getSCIHBrain() {
		return sCIHBrain;
	}
	
	private boolean check_main_region_DetectionOn_tr0_tr0() {
		return sCIKinect2.wavingDetected;
	}
	
	private boolean check_main_region_TrackingOn_tr0_tr0() {
		return timeEvents[0];
	}
	
	private boolean check_main_region_Welcome_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private void effect_main_region_DetectionOn_tr0() {
		exitSequence_main_region_DetectionOn();
		enterSequence_main_region_TrackingOn_default();
	}
	
	private void effect_main_region_TrackingOn_tr0() {
		exitSequence_main_region_TrackingOn();
		enterSequence_main_region_Welcome_default();
	}
	
	private void effect_main_region_Welcome_tr0() {
		exitSequence_main_region_Welcome();
		enterSequence_main_region_DetectionOn_default();
	}
	
	/* Entry action for state 'DetectionOn'. */
	private void entryAction_main_region_DetectionOn() {
		sCIKinect2.operationCallback.sendWavingDetectionOnOff(true);
	}
	
	/* Entry action for state 'TrackingOn'. */
	private void entryAction_main_region_TrackingOn() {
		timer.setTimer(this, 0, 2*1000, false);
		
		sCIKinect2.operationCallback.sendWavingDetectionOnOff(false);
		
		sCIHBrain.operationCallback.sendTTS("[:-O] Thank you!");
	}
	
	/* Entry action for state 'Welcome'. */
	private void entryAction_main_region_Welcome() {
		sCIHBrain.operationCallback.sendTTS("[:-|] Can you please wave for me? [:-)]");
	}
	
	/* Exit action for state 'TrackingOn'. */
	private void exitAction_main_region_TrackingOn() {
		timer.unsetTimer(this, 0);
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
		
		exitAction_main_region_TrackingOn();
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
		case main_region_Welcome:
			exitSequence_main_region_Welcome();
			break;
		default:
			break;
		}
	}
	
	/* The reactions of state DetectionOn. */
	private void react_main_region_DetectionOn() {
		if (check_main_region_DetectionOn_tr0_tr0()) {
			effect_main_region_DetectionOn_tr0();
		}
	}
	
	/* The reactions of state TrackingOn. */
	private void react_main_region_TrackingOn() {
		if (check_main_region_TrackingOn_tr0_tr0()) {
			effect_main_region_TrackingOn_tr0();
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
