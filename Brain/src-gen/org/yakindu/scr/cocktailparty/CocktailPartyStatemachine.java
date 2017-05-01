package org.yakindu.scr.cocktailparty;
import org.yakindu.scr.ITimer;

public class CocktailPartyStatemachine implements ICocktailPartyStatemachine {

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
	
	protected class SCIKinect2Impl implements SCIKinect2 {
	
		private SCIKinect2OperationCallback operationCallback;
		
		public void setSCIKinect2OperationCallback(
				SCIKinect2OperationCallback operationCallback) {
			this.operationCallback = operationCallback;
		}
		private boolean noiseDetected;
		
		public void raiseNoiseDetected() {
			noiseDetected = true;
		}
		
		protected void clearEvents() {
			noiseDetected = false;
		}
	}
	
	protected SCIKinect2Impl sCIKinect2;
	
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
	
	protected class SCISTTImpl implements SCISTT {
	
		private SCISTTOperationCallback operationCallback;
		
		public void setSCISTTOperationCallback(
				SCISTTOperationCallback operationCallback) {
			this.operationCallback = operationCallback;
		}
		private boolean spokenTextReceived;
		
		public void raiseSpokenTextReceived() {
			spokenTextReceived = true;
		}
		
		private boolean incomprehensible;
		
		public void raiseIncomprehensible() {
			incomprehensible = true;
		}
		
		private boolean actionReceived;
		
		public void raiseActionReceived() {
			actionReceived = true;
		}
		
		private boolean answerReceived;
		
		public void raiseAnswerReceived() {
			answerReceived = true;
		}
		
		protected void clearEvents() {
			spokenTextReceived = false;
			incomprehensible = false;
			actionReceived = false;
			answerReceived = false;
		}
	}
	
	protected SCISTTImpl sCISTT;
	
	protected class SCICrowdDetectionImpl implements SCICrowdDetection {
	
		private SCICrowdDetectionOperationCallback operationCallback;
		
		public void setSCICrowdDetectionOperationCallback(
				SCICrowdDetectionOperationCallback operationCallback) {
			this.operationCallback = operationCallback;
		}
		private boolean detected;
		
		public void raiseDetected() {
			detected = true;
		}
		
		protected void clearEvents() {
			detected = false;
		}
	}
	
	protected SCICrowdDetectionImpl sCICrowdDetection;
	
	protected class SCIMicrophoneArrayImpl implements SCIMicrophoneArray {
	
		private SCIMicrophoneArrayOperationCallback operationCallback;
		
		public void setSCIMicrophoneArrayOperationCallback(
				SCIMicrophoneArrayOperationCallback operationCallback) {
			this.operationCallback = operationCallback;
		}
	}
	
	protected SCIMicrophoneArrayImpl sCIMicrophoneArray;
	
	private boolean initialized = false;
	
	public enum State {
		leonie_Bupered_init,
		leonie_Bupered_sayAutsch,
		leonie_Bupered_resetFace,
		main_region_Init,
		main_region_Entering,
		main_region_WaitingForOrder,
		main_region_GoToPerson,
		main_region_Order,
		main_region_AskForOrder,
		main_region_Bar,
		main_region_AskForWave,
		main_region_DetectPerson,
		main_region_BringTheOrder,
		main_region_TellWaiterTheOrder,
		$NullState$
	};
	
	private final State[] stateVector = new State[2];
	
	private int nextStateIndex;
	
	private ITimer timer;
	
	private final boolean[] timeEvents = new boolean[1];
	public CocktailPartyStatemachine() {
		sCIHBrain = new SCIHBrainImpl();
		sCIKinect2 = new SCIKinect2Impl();
		sCIMira = new SCIMiraImpl();
		sCISTT = new SCISTTImpl();
		sCICrowdDetection = new SCICrowdDetectionImpl();
		sCIMicrophoneArray = new SCIMicrophoneArrayImpl();
	}
	
	public void init() {
		this.initialized = true;
		if (timer == null) {
			throw new IllegalStateException("timer not set.");
		}
		for (int i = 0; i < 2; i++) {
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
		enterSequence_Leonie_Bupered_default();
		enterSequence_main_region_default();
	}
	
	public void exit() {
		exitSequence_Leonie_Bupered();
		exitSequence_main_region();
	}
	
	/**
	 * @see IStatemachine#isActive()
	 */
	public boolean isActive() {
		return stateVector[0] != State.$NullState$||stateVector[1] != State.$NullState$;
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
		sCIKinect2.clearEvents();
		sCIMira.clearEvents();
		sCISTT.clearEvents();
		sCICrowdDetection.clearEvents();
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
		case leonie_Bupered_init:
			return stateVector[0] == State.leonie_Bupered_init;
		case leonie_Bupered_sayAutsch:
			return stateVector[0] == State.leonie_Bupered_sayAutsch;
		case leonie_Bupered_resetFace:
			return stateVector[0] == State.leonie_Bupered_resetFace;
		case main_region_Init:
			return stateVector[1] == State.main_region_Init;
		case main_region_Entering:
			return stateVector[1] == State.main_region_Entering;
		case main_region_WaitingForOrder:
			return stateVector[1] == State.main_region_WaitingForOrder;
		case main_region_GoToPerson:
			return stateVector[1] == State.main_region_GoToPerson;
		case main_region_Order:
			return stateVector[1] == State.main_region_Order;
		case main_region_AskForOrder:
			return stateVector[1] == State.main_region_AskForOrder;
		case main_region_Bar:
			return stateVector[1] == State.main_region_Bar;
		case main_region_AskForWave:
			return stateVector[1] == State.main_region_AskForWave;
		case main_region_DetectPerson:
			return stateVector[1] == State.main_region_DetectPerson;
		case main_region_BringTheOrder:
			return stateVector[1] == State.main_region_BringTheOrder;
		case main_region_TellWaiterTheOrder:
			return stateVector[1] == State.main_region_TellWaiterTheOrder;
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
	
	public SCIKinect2 getSCIKinect2() {
		return sCIKinect2;
	}
	
	public SCIMira getSCIMira() {
		return sCIMira;
	}
	
	public SCISTT getSCISTT() {
		return sCISTT;
	}
	
	public SCICrowdDetection getSCICrowdDetection() {
		return sCICrowdDetection;
	}
	
	public SCIMicrophoneArray getSCIMicrophoneArray() {
		return sCIMicrophoneArray;
	}
	
	private boolean check_Leonie_Bupered_init_tr0_tr0() {
		return sCIMira.bumpered;
	}
	
	private boolean check_Leonie_Bupered_sayAutsch_tr0_tr0() {
		return timeEvents[0];
	}
	
	private boolean check_Leonie_Bupered_resetFace_tr0_tr0() {
		return true;
	}
	
	private boolean check_main_region_GoToPerson_tr0_tr0() {
		return sCIMira.arrivedWP;
	}
	
	private boolean check_main_region_Bar_tr0_tr0() {
		return sCIMira.arrivedWP;
	}
	
	private void effect_Leonie_Bupered_init_tr0() {
		exitSequence_Leonie_Bupered_init();
		enterSequence_Leonie_Bupered_sayAutsch_default();
	}
	
	private void effect_Leonie_Bupered_sayAutsch_tr0() {
		exitSequence_Leonie_Bupered_sayAutsch();
		enterSequence_Leonie_Bupered_resetFace_default();
	}
	
	private void effect_Leonie_Bupered_resetFace_tr0() {
		exitSequence_Leonie_Bupered_resetFace();
		enterSequence_Leonie_Bupered_init_default();
	}
	
	private void effect_main_region_GoToPerson_tr0() {
		exitSequence_main_region_GoToPerson();
		enterSequence_main_region_Order_default();
	}
	
	private void effect_main_region_Bar_tr0() {
		exitSequence_main_region_Bar();
		enterSequence_main_region_TellWaiterTheOrder_default();
	}
	
	/* Entry action for state 'sayAutsch'. */
	private void entryAction_Leonie_Bupered_sayAutsch() {
		timer.setTimer(this, 0, 5 * 1000, false);
		
		sCIHBrain.operationCallback.sendTTS("[:-(]ouch!");
	}
	
	/* Entry action for state 'resetFace'. */
	private void entryAction_Leonie_Bupered_resetFace() {
		sCIHBrain.operationCallback.sendTTS("[:-|]");
	}
	
	/* Entry action for state 'Entering'. */
	private void entryAction_main_region_Entering() {
		sCIMira.operationCallback.sendGoToGWP(0);
	}
	
	/* Entry action for state 'WaitingForOrder'. */
	private void entryAction_main_region_WaitingForOrder() {
		sCIKinect2.operationCallback.sendNoiseDetectionOnOff(true);
		
		sCISTT.operationCallback.sendSpeechDetectionSmalltalk();
	}
	
	/* Entry action for state 'GoToPerson'. */
	private void entryAction_main_region_GoToPerson() {
		sCIMira.operationCallback.sendGoToLC(0, 0);
	}
	
	/* Entry action for state 'Order'. */
	private void entryAction_main_region_Order() {
		sCISTT.operationCallback.sendSpeechDetectionSmalltalk();
	}
	
	/* Entry action for state 'AskForOrder'. */
	private void entryAction_main_region_AskForOrder() {
		sCISTT.operationCallback.sendSpeechDetectionOff();
		
		sCIHBrain.operationCallback.sendTTS("Please step in front of me to place your order.");
	}
	
	/* Entry action for state 'Bar'. */
	private void entryAction_main_region_Bar() {
		sCIMira.operationCallback.sendGoToGWP(1);
	}
	
	/* Entry action for state 'AskForWave'. */
	private void entryAction_main_region_AskForWave() {
		sCIHBrain.operationCallback.sendTTS("Please lift your arm and wave if you want to order.");
	}
	
	/* Entry action for state 'TellWaiterTheOrder'. */
	private void entryAction_main_region_TellWaiterTheOrder() {
		sCIHBrain.operationCallback.sendTTS("STT.order");
	}
	
	/* Exit action for state 'sayAutsch'. */
	private void exitAction_Leonie_Bupered_sayAutsch() {
		timer.unsetTimer(this, 0);
	}
	
	/* 'default' enter sequence for state init */
	private void enterSequence_Leonie_Bupered_init_default() {
		nextStateIndex = 0;
		stateVector[0] = State.leonie_Bupered_init;
	}
	
	/* 'default' enter sequence for state sayAutsch */
	private void enterSequence_Leonie_Bupered_sayAutsch_default() {
		entryAction_Leonie_Bupered_sayAutsch();
		nextStateIndex = 0;
		stateVector[0] = State.leonie_Bupered_sayAutsch;
	}
	
	/* 'default' enter sequence for state resetFace */
	private void enterSequence_Leonie_Bupered_resetFace_default() {
		entryAction_Leonie_Bupered_resetFace();
		nextStateIndex = 0;
		stateVector[0] = State.leonie_Bupered_resetFace;
	}
	
	/* 'default' enter sequence for state Init */
	private void enterSequence_main_region_Init_default() {
		nextStateIndex = 1;
		stateVector[1] = State.main_region_Init;
	}
	
	/* 'default' enter sequence for state Entering */
	private void enterSequence_main_region_Entering_default() {
		entryAction_main_region_Entering();
		nextStateIndex = 1;
		stateVector[1] = State.main_region_Entering;
	}
	
	/* 'default' enter sequence for state WaitingForOrder */
	private void enterSequence_main_region_WaitingForOrder_default() {
		entryAction_main_region_WaitingForOrder();
		nextStateIndex = 1;
		stateVector[1] = State.main_region_WaitingForOrder;
	}
	
	/* 'default' enter sequence for state GoToPerson */
	private void enterSequence_main_region_GoToPerson_default() {
		entryAction_main_region_GoToPerson();
		nextStateIndex = 1;
		stateVector[1] = State.main_region_GoToPerson;
	}
	
	/* 'default' enter sequence for state Order */
	private void enterSequence_main_region_Order_default() {
		entryAction_main_region_Order();
		nextStateIndex = 1;
		stateVector[1] = State.main_region_Order;
	}
	
	/* 'default' enter sequence for state AskForOrder */
	private void enterSequence_main_region_AskForOrder_default() {
		entryAction_main_region_AskForOrder();
		nextStateIndex = 1;
		stateVector[1] = State.main_region_AskForOrder;
	}
	
	/* 'default' enter sequence for state Bar */
	private void enterSequence_main_region_Bar_default() {
		entryAction_main_region_Bar();
		nextStateIndex = 1;
		stateVector[1] = State.main_region_Bar;
	}
	
	/* 'default' enter sequence for state AskForWave */
	private void enterSequence_main_region_AskForWave_default() {
		entryAction_main_region_AskForWave();
		nextStateIndex = 1;
		stateVector[1] = State.main_region_AskForWave;
	}
	
	/* 'default' enter sequence for state DetectPerson */
	private void enterSequence_main_region_DetectPerson_default() {
		nextStateIndex = 1;
		stateVector[1] = State.main_region_DetectPerson;
	}
	
	/* 'default' enter sequence for state BringTheOrder */
	private void enterSequence_main_region_BringTheOrder_default() {
		nextStateIndex = 1;
		stateVector[1] = State.main_region_BringTheOrder;
	}
	
	/* 'default' enter sequence for state TellWaiterTheOrder */
	private void enterSequence_main_region_TellWaiterTheOrder_default() {
		entryAction_main_region_TellWaiterTheOrder();
		nextStateIndex = 1;
		stateVector[1] = State.main_region_TellWaiterTheOrder;
	}
	
	/* 'default' enter sequence for region Leonie Bupered */
	private void enterSequence_Leonie_Bupered_default() {
		react_Leonie_Bupered__entry_Default();
	}
	
	/* 'default' enter sequence for region main region */
	private void enterSequence_main_region_default() {
		react_main_region__entry_Default();
	}
	
	/* Default exit sequence for state init */
	private void exitSequence_Leonie_Bupered_init() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state sayAutsch */
	private void exitSequence_Leonie_Bupered_sayAutsch() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
		
		exitAction_Leonie_Bupered_sayAutsch();
	}
	
	/* Default exit sequence for state resetFace */
	private void exitSequence_Leonie_Bupered_resetFace() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state Init */
	private void exitSequence_main_region_Init() {
		nextStateIndex = 1;
		stateVector[1] = State.$NullState$;
	}
	
	/* Default exit sequence for state Entering */
	private void exitSequence_main_region_Entering() {
		nextStateIndex = 1;
		stateVector[1] = State.$NullState$;
	}
	
	/* Default exit sequence for state WaitingForOrder */
	private void exitSequence_main_region_WaitingForOrder() {
		nextStateIndex = 1;
		stateVector[1] = State.$NullState$;
	}
	
	/* Default exit sequence for state GoToPerson */
	private void exitSequence_main_region_GoToPerson() {
		nextStateIndex = 1;
		stateVector[1] = State.$NullState$;
	}
	
	/* Default exit sequence for state Order */
	private void exitSequence_main_region_Order() {
		nextStateIndex = 1;
		stateVector[1] = State.$NullState$;
	}
	
	/* Default exit sequence for state AskForOrder */
	private void exitSequence_main_region_AskForOrder() {
		nextStateIndex = 1;
		stateVector[1] = State.$NullState$;
	}
	
	/* Default exit sequence for state Bar */
	private void exitSequence_main_region_Bar() {
		nextStateIndex = 1;
		stateVector[1] = State.$NullState$;
	}
	
	/* Default exit sequence for state AskForWave */
	private void exitSequence_main_region_AskForWave() {
		nextStateIndex = 1;
		stateVector[1] = State.$NullState$;
	}
	
	/* Default exit sequence for state DetectPerson */
	private void exitSequence_main_region_DetectPerson() {
		nextStateIndex = 1;
		stateVector[1] = State.$NullState$;
	}
	
	/* Default exit sequence for state BringTheOrder */
	private void exitSequence_main_region_BringTheOrder() {
		nextStateIndex = 1;
		stateVector[1] = State.$NullState$;
	}
	
	/* Default exit sequence for state TellWaiterTheOrder */
	private void exitSequence_main_region_TellWaiterTheOrder() {
		nextStateIndex = 1;
		stateVector[1] = State.$NullState$;
	}
	
	/* Default exit sequence for region Leonie Bupered */
	private void exitSequence_Leonie_Bupered() {
		switch (stateVector[0]) {
		case leonie_Bupered_init:
			exitSequence_Leonie_Bupered_init();
			break;
		case leonie_Bupered_sayAutsch:
			exitSequence_Leonie_Bupered_sayAutsch();
			break;
		case leonie_Bupered_resetFace:
			exitSequence_Leonie_Bupered_resetFace();
			break;
		default:
			break;
		}
	}
	
	/* Default exit sequence for region main region */
	private void exitSequence_main_region() {
		switch (stateVector[1]) {
		case main_region_Init:
			exitSequence_main_region_Init();
			break;
		case main_region_Entering:
			exitSequence_main_region_Entering();
			break;
		case main_region_WaitingForOrder:
			exitSequence_main_region_WaitingForOrder();
			break;
		case main_region_GoToPerson:
			exitSequence_main_region_GoToPerson();
			break;
		case main_region_Order:
			exitSequence_main_region_Order();
			break;
		case main_region_AskForOrder:
			exitSequence_main_region_AskForOrder();
			break;
		case main_region_Bar:
			exitSequence_main_region_Bar();
			break;
		case main_region_AskForWave:
			exitSequence_main_region_AskForWave();
			break;
		case main_region_DetectPerson:
			exitSequence_main_region_DetectPerson();
			break;
		case main_region_BringTheOrder:
			exitSequence_main_region_BringTheOrder();
			break;
		case main_region_TellWaiterTheOrder:
			exitSequence_main_region_TellWaiterTheOrder();
			break;
		default:
			break;
		}
	}
	
	/* The reactions of state init. */
	private void react_Leonie_Bupered_init() {
		if (check_Leonie_Bupered_init_tr0_tr0()) {
			effect_Leonie_Bupered_init_tr0();
		}
	}
	
	/* The reactions of state sayAutsch. */
	private void react_Leonie_Bupered_sayAutsch() {
		if (check_Leonie_Bupered_sayAutsch_tr0_tr0()) {
			effect_Leonie_Bupered_sayAutsch_tr0();
		}
	}
	
	/* The reactions of state resetFace. */
	private void react_Leonie_Bupered_resetFace() {
		effect_Leonie_Bupered_resetFace_tr0();
	}
	
	/* The reactions of state Init. */
	private void react_main_region_Init() {
	}
	
	/* The reactions of state Entering. */
	private void react_main_region_Entering() {
	}
	
	/* The reactions of state WaitingForOrder. */
	private void react_main_region_WaitingForOrder() {
	}
	
	/* The reactions of state GoToPerson. */
	private void react_main_region_GoToPerson() {
		if (check_main_region_GoToPerson_tr0_tr0()) {
			effect_main_region_GoToPerson_tr0();
		}
	}
	
	/* The reactions of state Order. */
	private void react_main_region_Order() {
	}
	
	/* The reactions of state AskForOrder. */
	private void react_main_region_AskForOrder() {
	}
	
	/* The reactions of state Bar. */
	private void react_main_region_Bar() {
		if (check_main_region_Bar_tr0_tr0()) {
			effect_main_region_Bar_tr0();
		}
	}
	
	/* The reactions of state AskForWave. */
	private void react_main_region_AskForWave() {
	}
	
	/* The reactions of state DetectPerson. */
	private void react_main_region_DetectPerson() {
	}
	
	/* The reactions of state BringTheOrder. */
	private void react_main_region_BringTheOrder() {
	}
	
	/* The reactions of state TellWaiterTheOrder. */
	private void react_main_region_TellWaiterTheOrder() {
	}
	
	/* Default react sequence for initial entry  */
	private void react_Leonie_Bupered__entry_Default() {
		enterSequence_Leonie_Bupered_init_default();
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
			case leonie_Bupered_init:
				react_Leonie_Bupered_init();
				break;
			case leonie_Bupered_sayAutsch:
				react_Leonie_Bupered_sayAutsch();
				break;
			case leonie_Bupered_resetFace:
				react_Leonie_Bupered_resetFace();
				break;
			case main_region_Init:
				react_main_region_Init();
				break;
			case main_region_Entering:
				react_main_region_Entering();
				break;
			case main_region_WaitingForOrder:
				react_main_region_WaitingForOrder();
				break;
			case main_region_GoToPerson:
				react_main_region_GoToPerson();
				break;
			case main_region_Order:
				react_main_region_Order();
				break;
			case main_region_AskForOrder:
				react_main_region_AskForOrder();
				break;
			case main_region_Bar:
				react_main_region_Bar();
				break;
			case main_region_AskForWave:
				react_main_region_AskForWave();
				break;
			case main_region_DetectPerson:
				react_main_region_DetectPerson();
				break;
			case main_region_BringTheOrder:
				react_main_region_BringTheOrder();
				break;
			case main_region_TellWaiterTheOrder:
				react_main_region_TellWaiterTheOrder();
				break;
			default:
				// $NullState$
			}
		}
		clearEvents();
	}
}
