package org.yakindu.scr.test_stt_names;
import org.yakindu.scr.ITimer;

public class Test_STT_NamesStatemachine implements ITest_STT_NamesStatemachine {

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
	
	private boolean initialized = false;
	
	public enum State {
		main_region_StateA,
		main_region_StartSTT,
		main_region_TellSpokenText,
		main_region_StopSTT,
		main_region_Copy_1_StopSTT,
		$NullState$
	};
	
	private final State[] stateVector = new State[1];
	
	private int nextStateIndex;
	
	private ITimer timer;
	
	private final boolean[] timeEvents = new boolean[1];
	public Test_STT_NamesStatemachine() {
		sCIHBrain = new SCIHBrainImpl();
		sCISTT = new SCISTTImpl();
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
		sCIHBrain.clearEvents();
		sCISTT.clearEvents();
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
		case main_region_StateA:
			return stateVector[0] == State.main_region_StateA;
		case main_region_StartSTT:
			return stateVector[0] == State.main_region_StartSTT;
		case main_region_TellSpokenText:
			return stateVector[0] == State.main_region_TellSpokenText;
		case main_region_StopSTT:
			return stateVector[0] == State.main_region_StopSTT;
		case main_region_Copy_1_StopSTT:
			return stateVector[0] == State.main_region_Copy_1_StopSTT;
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
	
	public SCISTT getSCISTT() {
		return sCISTT;
	}
	
	private boolean check_main_region_StateA_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_main_region_StartSTT_tr0_tr0() {
		return timeEvents[0];
	}
	
	private boolean check_main_region_TellSpokenText_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_main_region_StopSTT_tr0_tr0() {
		return true;
	}
	
	private boolean check_main_region_Copy_1_StopSTT_tr0_tr0() {
		return sCISTT.spokenTextReceived;
	}
	
	private void effect_main_region_StateA_tr0() {
		exitSequence_main_region_StateA();
		enterSequence_main_region_StartSTT_default();
	}
	
	private void effect_main_region_StartSTT_tr0() {
		exitSequence_main_region_StartSTT();
		enterSequence_main_region_Copy_1_StopSTT_default();
	}
	
	private void effect_main_region_TellSpokenText_tr0() {
		exitSequence_main_region_TellSpokenText();
		enterSequence_main_region_StopSTT_default();
	}
	
	private void effect_main_region_StopSTT_tr0() {
		exitSequence_main_region_StopSTT();
		enterSequence_main_region_StateA_default();
	}
	
	private void effect_main_region_Copy_1_StopSTT_tr0() {
		exitSequence_main_region_Copy_1_StopSTT();
		enterSequence_main_region_TellSpokenText_default();
	}
	
	/* Entry action for state 'StateA'. */
	private void entryAction_main_region_StateA() {
		sCIHBrain.operationCallback.sendTTS("What is your name?");
	}
	
	/* Entry action for state 'StartSTT'. */
	private void entryAction_main_region_StartSTT() {
		timer.setTimer(this, 0, 2 * 1000, false);
		
		sCISTT.operationCallback.sendSpeechDetectionName();
	}
	
	/* Entry action for state 'TellSpokenText'. */
	private void entryAction_main_region_TellSpokenText() {
		sCIHBrain.operationCallback.sendTTS2("I unterstood: ", sCISTT.operationCallback.getSpokenText());
	}
	
	/* Entry action for state 'StopSTT'. */
	private void entryAction_main_region_StopSTT() {
		sCISTT.operationCallback.sendSpeechDetectionOff();
	}
	
	/* Entry action for state 'Copy_1_StopSTT'. */
	private void entryAction_main_region_Copy_1_StopSTT() {
		sCISTT.operationCallback.sendSpeechDetectionOff();
	}
	
	/* Exit action for state 'StartSTT'. */
	private void exitAction_main_region_StartSTT() {
		timer.unsetTimer(this, 0);
	}
	
	/* 'default' enter sequence for state StateA */
	private void enterSequence_main_region_StateA_default() {
		entryAction_main_region_StateA();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_StateA;
	}
	
	/* 'default' enter sequence for state StartSTT */
	private void enterSequence_main_region_StartSTT_default() {
		entryAction_main_region_StartSTT();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_StartSTT;
	}
	
	/* 'default' enter sequence for state TellSpokenText */
	private void enterSequence_main_region_TellSpokenText_default() {
		entryAction_main_region_TellSpokenText();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_TellSpokenText;
	}
	
	/* 'default' enter sequence for state StopSTT */
	private void enterSequence_main_region_StopSTT_default() {
		entryAction_main_region_StopSTT();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_StopSTT;
	}
	
	/* 'default' enter sequence for state Copy_1_StopSTT */
	private void enterSequence_main_region_Copy_1_StopSTT_default() {
		entryAction_main_region_Copy_1_StopSTT();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_Copy_1_StopSTT;
	}
	
	/* 'default' enter sequence for region main region */
	private void enterSequence_main_region_default() {
		react_main_region__entry_Default();
	}
	
	/* Default exit sequence for state StateA */
	private void exitSequence_main_region_StateA() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state StartSTT */
	private void exitSequence_main_region_StartSTT() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
		
		exitAction_main_region_StartSTT();
	}
	
	/* Default exit sequence for state TellSpokenText */
	private void exitSequence_main_region_TellSpokenText() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state StopSTT */
	private void exitSequence_main_region_StopSTT() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state Copy_1_StopSTT */
	private void exitSequence_main_region_Copy_1_StopSTT() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for region main region */
	private void exitSequence_main_region() {
		switch (stateVector[0]) {
		case main_region_StateA:
			exitSequence_main_region_StateA();
			break;
		case main_region_StartSTT:
			exitSequence_main_region_StartSTT();
			break;
		case main_region_TellSpokenText:
			exitSequence_main_region_TellSpokenText();
			break;
		case main_region_StopSTT:
			exitSequence_main_region_StopSTT();
			break;
		case main_region_Copy_1_StopSTT:
			exitSequence_main_region_Copy_1_StopSTT();
			break;
		default:
			break;
		}
	}
	
	/* The reactions of state StateA. */
	private void react_main_region_StateA() {
		if (check_main_region_StateA_tr0_tr0()) {
			effect_main_region_StateA_tr0();
		}
	}
	
	/* The reactions of state StartSTT. */
	private void react_main_region_StartSTT() {
		if (check_main_region_StartSTT_tr0_tr0()) {
			effect_main_region_StartSTT_tr0();
		}
	}
	
	/* The reactions of state TellSpokenText. */
	private void react_main_region_TellSpokenText() {
		if (check_main_region_TellSpokenText_tr0_tr0()) {
			effect_main_region_TellSpokenText_tr0();
		}
	}
	
	/* The reactions of state StopSTT. */
	private void react_main_region_StopSTT() {
		effect_main_region_StopSTT_tr0();
	}
	
	/* The reactions of state Copy_1_StopSTT. */
	private void react_main_region_Copy_1_StopSTT() {
		if (check_main_region_Copy_1_StopSTT_tr0_tr0()) {
			effect_main_region_Copy_1_StopSTT_tr0();
		}
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
			case main_region_StateA:
				react_main_region_StateA();
				break;
			case main_region_StartSTT:
				react_main_region_StartSTT();
				break;
			case main_region_TellSpokenText:
				react_main_region_TellSpokenText();
				break;
			case main_region_StopSTT:
				react_main_region_StopSTT();
				break;
			case main_region_Copy_1_StopSTT:
				react_main_region_Copy_1_StopSTT();
				break;
			default:
				// $NullState$
			}
		}
		clearEvents();
	}
}
