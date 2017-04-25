package org.yakindu.scr.generalpurposeservicerobot;

public class GeneralPurposeServiceRobotStatemachine implements IGeneralPurposeServiceRobotStatemachine {

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
		
		protected void clearEvents() {
			detectionPersonFound = false;
			trackingPersonLost = false;
		}
	}
	
	protected SCIFollowMeImpl sCIFollowMe;
	
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
		main_region_Hello,
		main_region_Leave_the_arena,
		main_region__final_,
		main_region_DetectionsOn,
		main_region_Init,
		main_region_StartSTT,
		main_region_TellSpokenText,
		main_region_TellAnswer,
		main_region_TellAction,
		main_region_TellAction_Instructions_GoTo,
		main_region_TellAction_Instructions_crowd,
		main_region_TellAction_Instructions_surrounding,
		main_region_TellAction_Instructions_bring,
		main_region_TellAction_Instructions_open,
		main_region_TellAction_Instructions_followme,
		main_region_TellAction_Instructions_unknown,
		main_region_StopSTT,
		main_region_TellIncomprehensible,
		main_region_NextQuestion,
		$NullState$
	};
	
	private final State[] stateVector = new State[1];
	
	private int nextStateIndex;
	
	private long counter;
	
	protected void setCounter(long value) {
		counter = value;
	}
	
	protected long getCounter() {
		return counter;
	}
	
	private long gWPout;
	
	protected void setGWPout(long value) {
		gWPout = value;
	}
	
	protected long getGWPout() {
		return gWPout;
	}
	
	private long gWPstart;
	
	protected void setGWPstart(long value) {
		gWPstart = value;
	}
	
	protected long getGWPstart() {
		return gWPstart;
	}
	
	public GeneralPurposeServiceRobotStatemachine() {
		sCIHBrain = new SCIHBrainImpl();
		sCIMira = new SCIMiraImpl();
		sCISTT = new SCISTTImpl();
		sCICrowdDetection = new SCICrowdDetectionImpl();
		sCIFollowMe = new SCIFollowMeImpl();
		sCIMicrophoneArray = new SCIMicrophoneArrayImpl();
	}
	
	public void init() {
		this.initialized = true;
		for (int i = 0; i < 1; i++) {
			stateVector[i] = State.$NullState$;
		}
		clearEvents();
		clearOutEvents();
		setCounter(0);
		
		setGWPout(0);
		
		setGWPstart(0);
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
		sCIHBrain.clearEvents();
		sCIMira.clearEvents();
		sCISTT.clearEvents();
		sCICrowdDetection.clearEvents();
		sCIFollowMe.clearEvents();
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
		case main_region_Hello:
			return stateVector[0] == State.main_region_Hello;
		case main_region_Leave_the_arena:
			return stateVector[0] == State.main_region_Leave_the_arena;
		case main_region__final_:
			return stateVector[0] == State.main_region__final_;
		case main_region_DetectionsOn:
			return stateVector[0] == State.main_region_DetectionsOn;
		case main_region_Init:
			return stateVector[0] == State.main_region_Init;
		case main_region_StartSTT:
			return stateVector[0] == State.main_region_StartSTT;
		case main_region_TellSpokenText:
			return stateVector[0] == State.main_region_TellSpokenText;
		case main_region_TellAnswer:
			return stateVector[0] == State.main_region_TellAnswer;
		case main_region_TellAction:
			return stateVector[0].ordinal() >= State.
					main_region_TellAction.ordinal()&& stateVector[0].ordinal() <= State.main_region_TellAction_Instructions_unknown.ordinal();
		case main_region_TellAction_Instructions_GoTo:
			return stateVector[0] == State.main_region_TellAction_Instructions_GoTo;
		case main_region_TellAction_Instructions_crowd:
			return stateVector[0] == State.main_region_TellAction_Instructions_crowd;
		case main_region_TellAction_Instructions_surrounding:
			return stateVector[0] == State.main_region_TellAction_Instructions_surrounding;
		case main_region_TellAction_Instructions_bring:
			return stateVector[0] == State.main_region_TellAction_Instructions_bring;
		case main_region_TellAction_Instructions_open:
			return stateVector[0] == State.main_region_TellAction_Instructions_open;
		case main_region_TellAction_Instructions_followme:
			return stateVector[0] == State.main_region_TellAction_Instructions_followme;
		case main_region_TellAction_Instructions_unknown:
			return stateVector[0] == State.main_region_TellAction_Instructions_unknown;
		case main_region_StopSTT:
			return stateVector[0] == State.main_region_StopSTT;
		case main_region_TellIncomprehensible:
			return stateVector[0] == State.main_region_TellIncomprehensible;
		case main_region_NextQuestion:
			return stateVector[0] == State.main_region_NextQuestion;
		default:
			return false;
		}
	}
	
	public SCIHBrain getSCIHBrain() {
		return sCIHBrain;
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
	
	public SCIFollowMe getSCIFollowMe() {
		return sCIFollowMe;
	}
	
	public SCIMicrophoneArray getSCIMicrophoneArray() {
		return sCIMicrophoneArray;
	}
	
	private boolean check_main_region_Hello_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_main_region_Leave_the_arena_tr0_tr0() {
		return sCIMira.arrivedWP;
	}
	
	private boolean check_main_region_DetectionsOn_tr0_tr0() {
		return sCICrowdDetection.detected;
	}
	
	private boolean check_main_region_Init_tr0_tr0() {
		return sCIMira.arrivedWP;
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
	
	private boolean check_main_region_TellAction_Instructions_GoTo_tr0_tr0() {
		return true;
	}
	
	private boolean check_main_region_TellAction_Instructions_crowd_tr0_tr0() {
		return true;
	}
	
	private boolean check_main_region_TellAction_Instructions_surrounding_tr0_tr0() {
		return true;
	}
	
	private boolean check_main_region_TellAction_Instructions_bring_tr0_tr0() {
		return true;
	}
	
	private boolean check_main_region_TellAction_Instructions_open_tr0_tr0() {
		return true;
	}
	
	private boolean check_main_region_TellAction_Instructions_followme_tr0_tr0() {
		return true;
	}
	
	private boolean check_main_region_TellAction_Instructions_unknown_tr0_tr0() {
		return true;
	}
	
	private boolean check_main_region_StopSTT_tr0_tr0() {
		return true;
	}
	
	private boolean check_main_region_TellIncomprehensible_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_main_region_NextQuestion_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_main_region_TellAction_Instructions__choice_0_tr0_tr0() {
		return (sCISTT.operationCallback.getInstruction()== null?"goto" ==null :sCISTT.operationCallback.getInstruction().equals("goto"));
	}
	
	private boolean check_main_region_TellAction_Instructions__choice_0_tr1_tr1() {
		return (sCISTT.operationCallback.getInstruction()== null?"crowd" ==null :sCISTT.operationCallback.getInstruction().equals("crowd"));
	}
	
	private boolean check_main_region_TellAction_Instructions__choice_0_tr2_tr2() {
		return (sCISTT.operationCallback.getInstruction()== null?"surrounding" ==null :sCISTT.operationCallback.getInstruction().equals("surrounding"));
	}
	
	private boolean check_main_region_TellAction_Instructions__choice_0_tr3_tr3() {
		return (sCISTT.operationCallback.getInstruction()== null?"bring" ==null :sCISTT.operationCallback.getInstruction().equals("bring"));
	}
	
	private boolean check_main_region_TellAction_Instructions__choice_0_tr4_tr4() {
		return (sCISTT.operationCallback.getInstruction()== null?"open" ==null :sCISTT.operationCallback.getInstruction().equals("open"));
	}
	
	private boolean check_main_region_TellAction_Instructions__choice_0_tr5_tr5() {
		return (sCISTT.operationCallback.getInstruction()== null?"followme" ==null :sCISTT.operationCallback.getInstruction().equals("followme"));
	}
	
	private boolean check_main_region_TellAction_Instructions__choice_0_tr6_tr6() {
		return true;
	}
	
	private boolean check_main_region__choice_0_tr1_tr1() {
		return getCounter()>=3;
	}
	
	private boolean check_main_region__choice_0_tr0_tr0() {
		return true;
	}
	
	private void effect_main_region_Hello_tr0() {
		exitSequence_main_region_Hello();
		enterSequence_main_region_StartSTT_default();
	}
	
	private void effect_main_region_Leave_the_arena_tr0() {
		exitSequence_main_region_Leave_the_arena();
		enterSequence_main_region__final__default();
	}
	
	private void effect_main_region_DetectionsOn_tr0() {
		exitSequence_main_region_DetectionsOn();
		enterSequence_main_region_Hello_default();
	}
	
	private void effect_main_region_Init_tr0() {
		exitSequence_main_region_Init();
		enterSequence_main_region_DetectionsOn_default();
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
	
	private void effect_main_region_TellAction_Instructions_GoTo_tr0() {
		exitSequence_main_region_TellAction_Instructions_GoTo();
		react_main_region_TellAction_Instructions_exit_done();
	}
	
	private void effect_main_region_TellAction_Instructions_crowd_tr0() {
		exitSequence_main_region_TellAction_Instructions_crowd();
		react_main_region_TellAction_Instructions_exit_done();
	}
	
	private void effect_main_region_TellAction_Instructions_surrounding_tr0() {
		exitSequence_main_region_TellAction_Instructions_surrounding();
		react_main_region_TellAction_Instructions_exit_done();
	}
	
	private void effect_main_region_TellAction_Instructions_bring_tr0() {
		exitSequence_main_region_TellAction_Instructions_bring();
		react_main_region_TellAction_Instructions_exit_done();
	}
	
	private void effect_main_region_TellAction_Instructions_open_tr0() {
		exitSequence_main_region_TellAction_Instructions_open();
		react_main_region_TellAction_Instructions_exit_done();
	}
	
	private void effect_main_region_TellAction_Instructions_followme_tr0() {
		exitSequence_main_region_TellAction_Instructions_followme();
		react_main_region_TellAction_Instructions_exit_done();
	}
	
	private void effect_main_region_TellAction_Instructions_unknown_tr0() {
		exitSequence_main_region_TellAction_Instructions_unknown();
		react_main_region_TellAction_Instructions_exit_done();
	}
	
	private void effect_main_region_StopSTT_tr0() {
		exitSequence_main_region_StopSTT();
		react_main_region__choice_0();
	}
	
	private void effect_main_region_TellIncomprehensible_tr0() {
		exitSequence_main_region_TellIncomprehensible();
		enterSequence_main_region_StopSTT_default();
	}
	
	private void effect_main_region_NextQuestion_tr0() {
		exitSequence_main_region_NextQuestion();
		enterSequence_main_region_StartSTT_default();
	}
	
	private void effect_main_region_TellAction_Instructions__choice_0_tr0() {
		enterSequence_main_region_TellAction_Instructions_GoTo_default();
	}
	
	private void effect_main_region_TellAction_Instructions__choice_0_tr1() {
		enterSequence_main_region_TellAction_Instructions_crowd_default();
	}
	
	private void effect_main_region_TellAction_Instructions__choice_0_tr2() {
		enterSequence_main_region_TellAction_Instructions_surrounding_default();
	}
	
	private void effect_main_region_TellAction_Instructions__choice_0_tr3() {
		enterSequence_main_region_TellAction_Instructions_bring_default();
	}
	
	private void effect_main_region_TellAction_Instructions__choice_0_tr4() {
		enterSequence_main_region_TellAction_Instructions_open_default();
	}
	
	private void effect_main_region_TellAction_Instructions__choice_0_tr5() {
		enterSequence_main_region_TellAction_Instructions_followme_default();
	}
	
	private void effect_main_region_TellAction_Instructions__choice_0_tr6() {
		enterSequence_main_region_TellAction_Instructions_unknown_default();
	}
	
	private void effect_main_region__choice_0_tr1() {
		enterSequence_main_region_Leave_the_arena_default();
	}
	
	private void effect_main_region__choice_0_tr0() {
		enterSequence_main_region_NextQuestion_default();
	}
	
	/* Entry action for state 'Hello'. */
	private void entryAction_main_region_Hello() {
		sCICrowdDetection.operationCallback.sendDetectionOff();
		
		sCIHBrain.operationCallback.sendTTS("[:-)] Hello! What can I do for you? [attentive]");
		
		setCounter(0);
	}
	
	/* Entry action for state 'Leave the arena'. */
	private void entryAction_main_region_Leave_the_arena() {
		sCIHBrain.operationCallback.sendTTS("I hope, I was of any help! [:-)] Bye bye.");
		
		sCIMira.operationCallback.sendGoToGWP(getGWPout());
	}
	
	/* Entry action for state 'DetectionsOn'. */
	private void entryAction_main_region_DetectionsOn() {
		sCICrowdDetection.operationCallback.sendDetectionOn();
	}
	
	/* Entry action for state 'Init'. */
	private void entryAction_main_region_Init() {
		setGWPout(0);
		
		setGWPstart(1);
		
		sCIHBrain.operationCallback.sendTTS("[:-|]");
		
		sCIMira.operationCallback.sendGoToGWP(getGWPstart());
	}
	
	/* Entry action for state 'StartSTT'. */
	private void entryAction_main_region_StartSTT() {
		sCISTT.operationCallback.sendSpeechDetectionSmalltalk();
	}
	
	/* Entry action for state 'TellSpokenText'. */
	private void entryAction_main_region_TellSpokenText() {
		sCIHBrain.operationCallback.sendTTS3("[:-|] I unterstood: ", sCISTT.operationCallback.getSpokenText(), ".");
	}
	
	/* Entry action for state 'TellAnswer'. */
	private void entryAction_main_region_TellAnswer() {
		sCIHBrain.operationCallback.sendTTS2(sCISTT.operationCallback.getAnswer(), " [:-)]");
		
		setCounter(counter+1);
	}
	
	/* Entry action for state 'TellAction'. */
	private void entryAction_main_region_TellAction() {
		setCounter(counter+1);
	}
	
	/* Entry action for state 'StopSTT'. */
	private void entryAction_main_region_StopSTT() {
		sCISTT.operationCallback.sendSpeechDetectionOff();
	}
	
	/* Entry action for state 'TellIncomprehensible'. */
	private void entryAction_main_region_TellIncomprehensible() {
		sCIHBrain.operationCallback.sendTTS3("[:-(]", sCISTT.operationCallback.getAnswer(), "[:-|]");
	}
	
	/* Entry action for state 'NextQuestion'. */
	private void entryAction_main_region_NextQuestion() {
		sCIHBrain.operationCallback.sendTTS("Please give me the next command or ask me a question. [attentive]");
	}
	
	/* 'default' enter sequence for state Hello */
	private void enterSequence_main_region_Hello_default() {
		entryAction_main_region_Hello();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_Hello;
	}
	
	/* 'default' enter sequence for state Leave the arena */
	private void enterSequence_main_region_Leave_the_arena_default() {
		entryAction_main_region_Leave_the_arena();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_Leave_the_arena;
	}
	
	/* Default enter sequence for state null */
	private void enterSequence_main_region__final__default() {
		nextStateIndex = 0;
		stateVector[0] = State.main_region__final_;
	}
	
	/* 'default' enter sequence for state DetectionsOn */
	private void enterSequence_main_region_DetectionsOn_default() {
		entryAction_main_region_DetectionsOn();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_DetectionsOn;
	}
	
	/* 'default' enter sequence for state Init */
	private void enterSequence_main_region_Init_default() {
		entryAction_main_region_Init();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_Init;
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
		enterSequence_main_region_TellAction_Instructions_default();
	}
	
	/* 'default' enter sequence for state GoTo */
	private void enterSequence_main_region_TellAction_Instructions_GoTo_default() {
		nextStateIndex = 0;
		stateVector[0] = State.main_region_TellAction_Instructions_GoTo;
	}
	
	/* 'default' enter sequence for state crowd */
	private void enterSequence_main_region_TellAction_Instructions_crowd_default() {
		nextStateIndex = 0;
		stateVector[0] = State.main_region_TellAction_Instructions_crowd;
	}
	
	/* 'default' enter sequence for state surrounding */
	private void enterSequence_main_region_TellAction_Instructions_surrounding_default() {
		nextStateIndex = 0;
		stateVector[0] = State.main_region_TellAction_Instructions_surrounding;
	}
	
	/* 'default' enter sequence for state bring */
	private void enterSequence_main_region_TellAction_Instructions_bring_default() {
		nextStateIndex = 0;
		stateVector[0] = State.main_region_TellAction_Instructions_bring;
	}
	
	/* 'default' enter sequence for state open */
	private void enterSequence_main_region_TellAction_Instructions_open_default() {
		nextStateIndex = 0;
		stateVector[0] = State.main_region_TellAction_Instructions_open;
	}
	
	/* 'default' enter sequence for state followme */
	private void enterSequence_main_region_TellAction_Instructions_followme_default() {
		nextStateIndex = 0;
		stateVector[0] = State.main_region_TellAction_Instructions_followme;
	}
	
	/* 'default' enter sequence for state unknown */
	private void enterSequence_main_region_TellAction_Instructions_unknown_default() {
		nextStateIndex = 0;
		stateVector[0] = State.main_region_TellAction_Instructions_unknown;
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
	
	/* 'default' enter sequence for state NextQuestion */
	private void enterSequence_main_region_NextQuestion_default() {
		entryAction_main_region_NextQuestion();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_NextQuestion;
	}
	
	/* 'default' enter sequence for region main region */
	private void enterSequence_main_region_default() {
		react_main_region__entry_Default();
	}
	
	/* 'default' enter sequence for region Instructions */
	private void enterSequence_main_region_TellAction_Instructions_default() {
		react_main_region_TellAction_Instructions__entry_Default();
	}
	
	/* Default exit sequence for state Hello */
	private void exitSequence_main_region_Hello() {
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
	
	/* Default exit sequence for state DetectionsOn */
	private void exitSequence_main_region_DetectionsOn() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state Init */
	private void exitSequence_main_region_Init() {
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
		exitSequence_main_region_TellAction_Instructions();
	}
	
	/* Default exit sequence for state GoTo */
	private void exitSequence_main_region_TellAction_Instructions_GoTo() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state crowd */
	private void exitSequence_main_region_TellAction_Instructions_crowd() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state surrounding */
	private void exitSequence_main_region_TellAction_Instructions_surrounding() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state bring */
	private void exitSequence_main_region_TellAction_Instructions_bring() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state open */
	private void exitSequence_main_region_TellAction_Instructions_open() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state followme */
	private void exitSequence_main_region_TellAction_Instructions_followme() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state unknown */
	private void exitSequence_main_region_TellAction_Instructions_unknown() {
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
	
	/* Default exit sequence for state NextQuestion */
	private void exitSequence_main_region_NextQuestion() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for region main region */
	private void exitSequence_main_region() {
		switch (stateVector[0]) {
		case main_region_Hello:
			exitSequence_main_region_Hello();
			break;
		case main_region_Leave_the_arena:
			exitSequence_main_region_Leave_the_arena();
			break;
		case main_region__final_:
			exitSequence_main_region__final_();
			break;
		case main_region_DetectionsOn:
			exitSequence_main_region_DetectionsOn();
			break;
		case main_region_Init:
			exitSequence_main_region_Init();
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
		case main_region_TellAction_Instructions_GoTo:
			exitSequence_main_region_TellAction_Instructions_GoTo();
			break;
		case main_region_TellAction_Instructions_crowd:
			exitSequence_main_region_TellAction_Instructions_crowd();
			break;
		case main_region_TellAction_Instructions_surrounding:
			exitSequence_main_region_TellAction_Instructions_surrounding();
			break;
		case main_region_TellAction_Instructions_bring:
			exitSequence_main_region_TellAction_Instructions_bring();
			break;
		case main_region_TellAction_Instructions_open:
			exitSequence_main_region_TellAction_Instructions_open();
			break;
		case main_region_TellAction_Instructions_followme:
			exitSequence_main_region_TellAction_Instructions_followme();
			break;
		case main_region_TellAction_Instructions_unknown:
			exitSequence_main_region_TellAction_Instructions_unknown();
			break;
		case main_region_StopSTT:
			exitSequence_main_region_StopSTT();
			break;
		case main_region_TellIncomprehensible:
			exitSequence_main_region_TellIncomprehensible();
			break;
		case main_region_NextQuestion:
			exitSequence_main_region_NextQuestion();
			break;
		default:
			break;
		}
	}
	
	/* Default exit sequence for region Instructions */
	private void exitSequence_main_region_TellAction_Instructions() {
		switch (stateVector[0]) {
		case main_region_TellAction_Instructions_GoTo:
			exitSequence_main_region_TellAction_Instructions_GoTo();
			break;
		case main_region_TellAction_Instructions_crowd:
			exitSequence_main_region_TellAction_Instructions_crowd();
			break;
		case main_region_TellAction_Instructions_surrounding:
			exitSequence_main_region_TellAction_Instructions_surrounding();
			break;
		case main_region_TellAction_Instructions_bring:
			exitSequence_main_region_TellAction_Instructions_bring();
			break;
		case main_region_TellAction_Instructions_open:
			exitSequence_main_region_TellAction_Instructions_open();
			break;
		case main_region_TellAction_Instructions_followme:
			exitSequence_main_region_TellAction_Instructions_followme();
			break;
		case main_region_TellAction_Instructions_unknown:
			exitSequence_main_region_TellAction_Instructions_unknown();
			break;
		default:
			break;
		}
	}
	
	/* The reactions of state Hello. */
	private void react_main_region_Hello() {
		if (check_main_region_Hello_tr0_tr0()) {
			effect_main_region_Hello_tr0();
		}
	}
	
	/* The reactions of state Leave the arena. */
	private void react_main_region_Leave_the_arena() {
		if (check_main_region_Leave_the_arena_tr0_tr0()) {
			effect_main_region_Leave_the_arena_tr0();
		}
	}
	
	/* The reactions of state null. */
	private void react_main_region__final_() {
	}
	
	/* The reactions of state DetectionsOn. */
	private void react_main_region_DetectionsOn() {
		if (check_main_region_DetectionsOn_tr0_tr0()) {
			effect_main_region_DetectionsOn_tr0();
		}
	}
	
	/* The reactions of state Init. */
	private void react_main_region_Init() {
		if (check_main_region_Init_tr0_tr0()) {
			effect_main_region_Init_tr0();
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
	
	/* The reactions of state GoTo. */
	private void react_main_region_TellAction_Instructions_GoTo() {
		effect_main_region_TellAction_Instructions_GoTo_tr0();
	}
	
	/* The reactions of state crowd. */
	private void react_main_region_TellAction_Instructions_crowd() {
		effect_main_region_TellAction_Instructions_crowd_tr0();
	}
	
	/* The reactions of state surrounding. */
	private void react_main_region_TellAction_Instructions_surrounding() {
		effect_main_region_TellAction_Instructions_surrounding_tr0();
	}
	
	/* The reactions of state bring. */
	private void react_main_region_TellAction_Instructions_bring() {
		effect_main_region_TellAction_Instructions_bring_tr0();
	}
	
	/* The reactions of state open. */
	private void react_main_region_TellAction_Instructions_open() {
		effect_main_region_TellAction_Instructions_open_tr0();
	}
	
	/* The reactions of state followme. */
	private void react_main_region_TellAction_Instructions_followme() {
		effect_main_region_TellAction_Instructions_followme_tr0();
	}
	
	/* The reactions of state unknown. */
	private void react_main_region_TellAction_Instructions_unknown() {
		effect_main_region_TellAction_Instructions_unknown_tr0();
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
	
	/* The reactions of state NextQuestion. */
	private void react_main_region_NextQuestion() {
		if (check_main_region_NextQuestion_tr0_tr0()) {
			effect_main_region_NextQuestion_tr0();
		}
	}
	
	/* The reactions of state null. */
	private void react_main_region_TellAction_Instructions__choice_0() {
		if (check_main_region_TellAction_Instructions__choice_0_tr0_tr0()) {
			effect_main_region_TellAction_Instructions__choice_0_tr0();
		} else {
			if (check_main_region_TellAction_Instructions__choice_0_tr1_tr1()) {
				effect_main_region_TellAction_Instructions__choice_0_tr1();
			} else {
				if (check_main_region_TellAction_Instructions__choice_0_tr2_tr2()) {
					effect_main_region_TellAction_Instructions__choice_0_tr2();
				} else {
					if (check_main_region_TellAction_Instructions__choice_0_tr3_tr3()) {
						effect_main_region_TellAction_Instructions__choice_0_tr3();
					} else {
						if (check_main_region_TellAction_Instructions__choice_0_tr4_tr4()) {
							effect_main_region_TellAction_Instructions__choice_0_tr4();
						} else {
							if (check_main_region_TellAction_Instructions__choice_0_tr5_tr5()) {
								effect_main_region_TellAction_Instructions__choice_0_tr5();
							} else {
								effect_main_region_TellAction_Instructions__choice_0_tr6();
							}
						}
					}
				}
			}
		}
	}
	
	/* The reactions of state null. */
	private void react_main_region__choice_0() {
		if (check_main_region__choice_0_tr1_tr1()) {
			effect_main_region__choice_0_tr1();
		} else {
			effect_main_region__choice_0_tr0();
		}
	}
	
	/* Default react sequence for initial entry  */
	private void react_main_region__entry_Default() {
		enterSequence_main_region_Init_default();
	}
	
	/* Default react sequence for initial entry  */
	private void react_main_region_TellAction_Instructions__entry_Default() {
		react_main_region_TellAction_Instructions__choice_0();
	}
	
	/* The reactions of exit exit_done. */
	private void react_main_region_TellAction_Instructions_exit_done() {
		effect_main_region_TellAction_tr0();
	}
	
	public void runCycle() {
		if (!initialized)
			throw new IllegalStateException(
					"The state machine needs to be initialized first by calling the init() function.");
		clearOutEvents();
		for (nextStateIndex = 0; nextStateIndex < stateVector.length; nextStateIndex++) {
			switch (stateVector[nextStateIndex]) {
			case main_region_Hello:
				react_main_region_Hello();
				break;
			case main_region_Leave_the_arena:
				react_main_region_Leave_the_arena();
				break;
			case main_region__final_:
				react_main_region__final_();
				break;
			case main_region_DetectionsOn:
				react_main_region_DetectionsOn();
				break;
			case main_region_Init:
				react_main_region_Init();
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
			case main_region_TellAction_Instructions_GoTo:
				react_main_region_TellAction_Instructions_GoTo();
				break;
			case main_region_TellAction_Instructions_crowd:
				react_main_region_TellAction_Instructions_crowd();
				break;
			case main_region_TellAction_Instructions_surrounding:
				react_main_region_TellAction_Instructions_surrounding();
				break;
			case main_region_TellAction_Instructions_bring:
				react_main_region_TellAction_Instructions_bring();
				break;
			case main_region_TellAction_Instructions_open:
				react_main_region_TellAction_Instructions_open();
				break;
			case main_region_TellAction_Instructions_followme:
				react_main_region_TellAction_Instructions_followme();
				break;
			case main_region_TellAction_Instructions_unknown:
				react_main_region_TellAction_Instructions_unknown();
				break;
			case main_region_StopSTT:
				react_main_region_StopSTT();
				break;
			case main_region_TellIncomprehensible:
				react_main_region_TellIncomprehensible();
				break;
			case main_region_NextQuestion:
				react_main_region_NextQuestion();
				break;
			default:
				// $NullState$
			}
		}
		clearEvents();
	}
}
