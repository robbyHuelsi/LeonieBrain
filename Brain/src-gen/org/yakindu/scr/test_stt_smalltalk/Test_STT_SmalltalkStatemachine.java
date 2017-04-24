package org.yakindu.scr.test_stt_smalltalk;

public class Test_STT_SmalltalkStatemachine implements ITest_STT_SmalltalkStatemachine {

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
		main_region_TellAnswer,
		main_region_TellAction,
		main_region_StopSTT,
		main_region_TellIncomprehensible,
		$NullState$
	};
	
	private final State[] stateVector = new State[1];
	
	private int nextStateIndex;
	
	public Test_STT_SmalltalkStatemachine() {
		sCIHBrain = new SCIHBrainImpl();
		sCISTT = new SCISTTImpl();
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
		sCIHBrain.clearEvents();
		sCISTT.clearEvents();
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
		case main_region_TellAnswer:
			return stateVector[0] == State.main_region_TellAnswer;
		case main_region_TellAction:
			return stateVector[0] == State.main_region_TellAction;
		case main_region_StopSTT:
			return stateVector[0] == State.main_region_StopSTT;
		case main_region_TellIncomprehensible:
			return stateVector[0] == State.main_region_TellIncomprehensible;
		default:
			return false;
		}
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
		return sCISTT.spokenTextReceived;
	}
	
	private boolean check_main_region_TellSpokenText_tr0_tr0() {
		return sCISTT.answerReceived;
	}
	
	private boolean check_main_region_TellSpokenText_tr1_tr1() {
		return sCISTT.actionReceived;
	}
	
	private boolean check_main_region_TellSpokenText_tr2_tr2() {
		return sCISTT.incomprehensible;
	}
	
	private boolean check_main_region_TellAnswer_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_main_region_TellAction_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_main_region_StopSTT_tr0_tr0() {
		return true;
	}
	
	private boolean check_main_region_TellIncomprehensible_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private void effect_main_region_StateA_tr0() {
		exitSequence_main_region_StateA();
		enterSequence_main_region_StartSTT_default();
	}
	
	private void effect_main_region_StartSTT_tr0() {
		exitSequence_main_region_StartSTT();
		enterSequence_main_region_TellSpokenText_default();
	}
	
	private void effect_main_region_TellSpokenText_tr0() {
		exitSequence_main_region_TellSpokenText();
		enterSequence_main_region_TellAnswer_default();
	}
	
	private void effect_main_region_TellSpokenText_tr1() {
		exitSequence_main_region_TellSpokenText();
		enterSequence_main_region_TellAction_default();
	}
	
	private void effect_main_region_TellSpokenText_tr2() {
		exitSequence_main_region_TellSpokenText();
		enterSequence_main_region_TellIncomprehensible_default();
	}
	
	private void effect_main_region_TellAnswer_tr0() {
		exitSequence_main_region_TellAnswer();
		enterSequence_main_region_StopSTT_default();
	}
	
	private void effect_main_region_TellAction_tr0() {
		exitSequence_main_region_TellAction();
		enterSequence_main_region_StopSTT_default();
	}
	
	private void effect_main_region_StopSTT_tr0() {
		exitSequence_main_region_StopSTT();
		enterSequence_main_region_StateA_default();
	}
	
	private void effect_main_region_TellIncomprehensible_tr0() {
		exitSequence_main_region_TellIncomprehensible();
		enterSequence_main_region_StopSTT_default();
	}
	
	/* Entry action for state 'StateA'. */
	private void entryAction_main_region_StateA() {
		sCIHBrain.operationCallback.sendTTS("I know everything! Ask me a question.");
	}
	
	/* Entry action for state 'StartSTT'. */
	private void entryAction_main_region_StartSTT() {
		sCISTT.operationCallback.sendSpeechDetectionSmalltalk();
	}
	
	/* Entry action for state 'TellSpokenText'. */
	private void entryAction_main_region_TellSpokenText() {
		sCIHBrain.operationCallback.sendTTS2("I unterstood: ", sCISTT.operationCallback.getSpokenText());
	}
	
	/* Entry action for state 'TellAnswer'. */
	private void entryAction_main_region_TellAnswer() {
		sCIHBrain.operationCallback.sendTTS(sCISTT.operationCallback.getAnswer());
	}
	
	/* Entry action for state 'TellAction'. */
	private void entryAction_main_region_TellAction() {
		sCIHBrain.operationCallback.sendTTS3("The instruction is: ", sCISTT.operationCallback.getInstruction(), ".");
		
		sCIHBrain.operationCallback.sendTTS3("The object is: ", sCISTT.operationCallback.getObject(), ".");
	}
	
	/* Entry action for state 'StopSTT'. */
	private void entryAction_main_region_StopSTT() {
		sCISTT.operationCallback.sendSpeechDetectionOff();
	}
	
	/* Entry action for state 'TellIncomprehensible'. */
	private void entryAction_main_region_TellIncomprehensible() {
		sCIHBrain.operationCallback.sendTTS(sCISTT.operationCallback.getAnswer());
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
	
	/* 'default' enter sequence for state TellAnswer */
	private void enterSequence_main_region_TellAnswer_default() {
		entryAction_main_region_TellAnswer();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_TellAnswer;
	}
	
	/* 'default' enter sequence for state TellAction */
	private void enterSequence_main_region_TellAction_default() {
		entryAction_main_region_TellAction();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_TellAction;
	}
	
	/* 'default' enter sequence for state StopSTT */
	private void enterSequence_main_region_StopSTT_default() {
		entryAction_main_region_StopSTT();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_StopSTT;
	}
	
	/* 'default' enter sequence for state TellIncomprehensible */
	private void enterSequence_main_region_TellIncomprehensible_default() {
		entryAction_main_region_TellIncomprehensible();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_TellIncomprehensible;
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
	}
	
	/* Default exit sequence for state TellSpokenText */
	private void exitSequence_main_region_TellSpokenText() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state TellAnswer */
	private void exitSequence_main_region_TellAnswer() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state TellAction */
	private void exitSequence_main_region_TellAction() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state StopSTT */
	private void exitSequence_main_region_StopSTT() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state TellIncomprehensible */
	private void exitSequence_main_region_TellIncomprehensible() {
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
		case main_region_TellAnswer:
			exitSequence_main_region_TellAnswer();
			break;
		case main_region_TellAction:
			exitSequence_main_region_TellAction();
			break;
		case main_region_StopSTT:
			exitSequence_main_region_StopSTT();
			break;
		case main_region_TellIncomprehensible:
			exitSequence_main_region_TellIncomprehensible();
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
		} else {
			if (check_main_region_TellSpokenText_tr1_tr1()) {
				effect_main_region_TellSpokenText_tr1();
			} else {
				if (check_main_region_TellSpokenText_tr2_tr2()) {
					effect_main_region_TellSpokenText_tr2();
				}
			}
		}
	}
	
	/* The reactions of state TellAnswer. */
	private void react_main_region_TellAnswer() {
		if (check_main_region_TellAnswer_tr0_tr0()) {
			effect_main_region_TellAnswer_tr0();
		}
	}
	
	/* The reactions of state TellAction. */
	private void react_main_region_TellAction() {
		if (check_main_region_TellAction_tr0_tr0()) {
			effect_main_region_TellAction_tr0();
		}
	}
	
	/* The reactions of state StopSTT. */
	private void react_main_region_StopSTT() {
		effect_main_region_StopSTT_tr0();
	}
	
	/* The reactions of state TellIncomprehensible. */
	private void react_main_region_TellIncomprehensible() {
		if (check_main_region_TellIncomprehensible_tr0_tr0()) {
			effect_main_region_TellIncomprehensible_tr0();
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
			case main_region_TellAnswer:
				react_main_region_TellAnswer();
				break;
			case main_region_TellAction:
				react_main_region_TellAction();
				break;
			case main_region_StopSTT:
				react_main_region_StopSTT();
				break;
			case main_region_TellIncomprehensible:
				react_main_region_TellIncomprehensible();
				break;
			default:
				// $NullState$
			}
		}
		clearEvents();
	}
}
