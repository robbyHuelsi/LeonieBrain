package org.yakindu.scr.test_leapmotion;

public class Test_LeapMotionStatemachine implements ITest_LeapMotionStatemachine {

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
		
		private boolean noiseDeviatinWithoutBoneDetected;
		
		public void raiseNoiseDeviatinWithoutBoneDetected() {
			noiseDeviatinWithoutBoneDetected = true;
		}
		
		private boolean noiseWithBoneDetected;
		
		public void raiseNoiseWithBoneDetected() {
			noiseWithBoneDetected = true;
		}
		
		private boolean wavingDetected;
		
		public void raiseWavingDetected() {
			wavingDetected = true;
		}
		
		protected void clearEvents() {
			personDetected = false;
			noiseDeviatinWithoutBoneDetected = false;
			noiseWithBoneDetected = false;
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
		main_region_WaitForNoise,
		main_region_Turn,
		$NullState$
	};
	
	private final State[] stateVector = new State[1];
	
	private int nextStateIndex;
	
	public Test_LeapMotionStatemachine() {
		sCIKinect2 = new SCIKinect2Impl();
		sCIHBrain = new SCIHBrainImpl();
		sCIMira = new SCIMiraImpl();
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
		sCIMira.clearEvents();
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
		case main_region_WaitForNoise:
			return stateVector[0] == State.main_region_WaitForNoise;
		case main_region_Turn:
			return stateVector[0] == State.main_region_Turn;
		default:
			return false;
		}
	}
	
	public SCIKinect2 getSCIKinect2() {
		return sCIKinect2;
	}
	
	public SCIHBrain getSCIHBrain() {
		return sCIHBrain;
	}
	
	public SCIMira getSCIMira() {
		return sCIMira;
	}
	
	private boolean check_main_region_WaitForNoise_tr0_tr0() {
		return sCIKinect2.noiseDeviatinWithoutBoneDetected;
	}
	
	private boolean check_main_region_WaitForNoise_tr1_tr1() {
		return sCIKinect2.noiseWithBoneDetected;
	}
	
	private boolean check_main_region_Turn_tr0_tr0() {
		return true;
	}
	
	private void effect_main_region_WaitForNoise_tr0() {
		exitSequence_main_region_WaitForNoise();
		enterSequence_main_region_Turn_default();
	}
	
	private void effect_main_region_WaitForNoise_tr1() {
		exitSequence_main_region_WaitForNoise();
		enterSequence_main_region_Turn_default();
	}
	
	private void effect_main_region_Turn_tr0() {
		exitSequence_main_region_Turn();
		enterSequence_main_region_WaitForNoise_default();
	}
	
	/* Entry action for state 'WaitForNoise'. */
	private void entryAction_main_region_WaitForNoise() {
		sCIKinect2.operationCallback.sendNoiseDetectionOnOff(true);
	}
	
	/* Entry action for state 'Turn'. */
	private void entryAction_main_region_Turn() {
		sCIMira.operationCallback.sendTurnBody(sCIKinect2.operationCallback.getNoiseAngle());
	}
	
	/* 'default' enter sequence for state WaitForNoise */
	private void enterSequence_main_region_WaitForNoise_default() {
		entryAction_main_region_WaitForNoise();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_WaitForNoise;
	}
	
	/* 'default' enter sequence for state Turn */
	private void enterSequence_main_region_Turn_default() {
		entryAction_main_region_Turn();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_Turn;
	}
	
	/* 'default' enter sequence for region main region */
	private void enterSequence_main_region_default() {
		react_main_region__entry_Default();
	}
	
	/* Default exit sequence for state WaitForNoise */
	private void exitSequence_main_region_WaitForNoise() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state Turn */
	private void exitSequence_main_region_Turn() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for region main region */
	private void exitSequence_main_region() {
		switch (stateVector[0]) {
		case main_region_WaitForNoise:
			exitSequence_main_region_WaitForNoise();
			break;
		case main_region_Turn:
			exitSequence_main_region_Turn();
			break;
		default:
			break;
		}
	}
	
	/* The reactions of state WaitForNoise. */
	private void react_main_region_WaitForNoise() {
		if (check_main_region_WaitForNoise_tr0_tr0()) {
			effect_main_region_WaitForNoise_tr0();
		} else {
			if (check_main_region_WaitForNoise_tr1_tr1()) {
				effect_main_region_WaitForNoise_tr1();
			}
		}
	}
	
	/* The reactions of state Turn. */
	private void react_main_region_Turn() {
		effect_main_region_Turn_tr0();
	}
	
	/* Default react sequence for initial entry  */
	private void react_main_region__entry_Default() {
		enterSequence_main_region_WaitForNoise_default();
	}
	
	public void runCycle() {
		if (!initialized)
			throw new IllegalStateException(
					"The state machine needs to be initialized first by calling the init() function.");
		clearOutEvents();
		for (nextStateIndex = 0; nextStateIndex < stateVector.length; nextStateIndex++) {
			switch (stateVector[nextStateIndex]) {
			case main_region_WaitForNoise:
				react_main_region_WaitForNoise();
				break;
			case main_region_Turn:
				react_main_region_Turn();
				break;
			default:
				// $NullState$
			}
		}
		clearEvents();
	}
}
