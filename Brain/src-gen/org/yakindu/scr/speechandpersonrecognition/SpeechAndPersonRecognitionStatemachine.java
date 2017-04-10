package org.yakindu.scr.speechandpersonrecognition;
import org.yakindu.scr.ITimer;

public class SpeechAndPersonRecognitionStatemachine implements ISpeechAndPersonRecognitionStatemachine {

	protected class SCInterfaceImpl implements SCInterface {
	
	}
	
	protected SCInterfaceImpl sCInterface;
	
	protected class SCIHBrainImpl implements SCIHBrain {
	
		private boolean tTSReady;
		
		public boolean getTTSReady() {
			return tTSReady;
		}
		
		public void setTTSReady(boolean value) {
			this.tTSReady = value;
		}
		
		private boolean tTSFinished;
		
		public boolean getTTSFinished() {
			return tTSFinished;
		}
		
		public void setTTSFinished(boolean value) {
			this.tTSFinished = value;
		}
		
	}
	
	protected SCIHBrainImpl sCIHBrain;
	
	protected class SCIUdpInterfaceImpl implements SCIUdpInterface {
	
		private SCIUdpInterfaceOperationCallback operationCallback;
		
		public void setSCIUdpInterfaceOperationCallback(
				SCIUdpInterfaceOperationCallback operationCallback) {
			this.operationCallback = operationCallback;
		}
		private boolean ready;
		
		public void raiseReady() {
			ready = true;
		}
		
		private boolean turnAroundFinished;
		
		public void raiseTurnAroundFinished() {
			turnAroundFinished = true;
		}
		
		protected void clearEvents() {
			ready = false;
			turnAroundFinished = false;
		}
	}
	
	protected SCIUdpInterfaceImpl sCIUdpInterface;
	
	protected class SCIVBrainImpl implements SCIVBrain {
	
		private SCIVBrainOperationCallback operationCallback;
		
		public void setSCIVBrainOperationCallback(
				SCIVBrainOperationCallback operationCallback) {
			this.operationCallback = operationCallback;
		}
		private long countFoundFaces;
		
		public long getCountFoundFaces() {
			return countFoundFaces;
		}
		
		public void setCountFoundFaces(long value) {
			this.countFoundFaces = value;
		}
		
		private boolean nessesaryToSavePersonList;
		
		public boolean getNessesaryToSavePersonList() {
			return nessesaryToSavePersonList;
		}
		
		public void setNessesaryToSavePersonList(boolean value) {
			this.nessesaryToSavePersonList = value;
		}
		
	}
	
	protected SCIVBrainImpl sCIVBrain;
	
	protected class SCISTTImpl implements SCISTT {
	
		private boolean sTTReady;
		
		public boolean getSTTReady() {
			return sTTReady;
		}
		
		public void setSTTReady(boolean value) {
			this.sTTReady = value;
		}
		
		private String speakerMsg;
		
		public String getSpeakerMsg() {
			return speakerMsg;
		}
		
		public void setSpeakerMsg(String value) {
			this.speakerMsg = value;
		}
		
		private String filteredMsg;
		
		public String getFilteredMsg() {
			return filteredMsg;
		}
		
		public void setFilteredMsg(String value) {
			this.filteredMsg = value;
		}
		
		private String filterBubble;
		
		public String getFilterBubble() {
			return filterBubble;
		}
		
		public void setFilterBubble(String value) {
			this.filterBubble = value;
		}
		
	}
	
	protected SCISTTImpl sCISTT;
	
	private boolean initialized = false;
	
	public enum State {
		main_region_Init,
		main_region_Announcement,
		main_region_Wait,
		main_region_TurnAround,
		main_region_CrowdScanningAndCounting,
		main_region_RiddleGame1,
		main_region_RiddleGame1_r1_StartGame,
		main_region_RiddleGame1_r1_RequestForOpertator,
		main_region_RiddleGame1_r1_WaitForQuestion,
		main_region_RiddleGame1_r1_Answer,
		main_region_BlindMan_sBluGame,
		main_region_BlindMan_sBluGame_r1_StartGame,
		main_region_BlindMan_sBluGame_r1_ListenForQuestion,
		main_region_BlindMan_sBluGame_r1_WaitForQuestion,
		main_region_BlindMan_sBluGame_r1_Answer,
		main_region_LeaveTheRoom,
		main_region__final_,
		$NullState$
	};
	
	private final State[] stateVector = new State[1];
	
	private int nextStateIndex;
	
	private ITimer timer;
	
	private final boolean[] timeEvents = new boolean[3];
	private long questionCounter;
	
	protected void setQuestionCounter(long value) {
		questionCounter = value;
	}
	
	protected long getQuestionCounter() {
		return questionCounter;
	}
	
	public SpeechAndPersonRecognitionStatemachine() {
		sCInterface = new SCInterfaceImpl();
		sCIHBrain = new SCIHBrainImpl();
		sCIUdpInterface = new SCIUdpInterfaceImpl();
		sCIVBrain = new SCIVBrainImpl();
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
		sCIHBrain.setTTSReady(false);
		
		sCIHBrain.setTTSFinished(false);
		
		sCIVBrain.setCountFoundFaces(0);
		
		sCIVBrain.setNessesaryToSavePersonList(false);
		
		sCISTT.setSTTReady(false);
		
		sCISTT.setSpeakerMsg("");
		
		sCISTT.setFilteredMsg("");
		
		sCISTT.setFilterBubble("");
		
		setQuestionCounter(0);
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
		sCIUdpInterface.clearEvents();
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
		case main_region_Init:
			return stateVector[0] == State.main_region_Init;
		case main_region_Announcement:
			return stateVector[0] == State.main_region_Announcement;
		case main_region_Wait:
			return stateVector[0] == State.main_region_Wait;
		case main_region_TurnAround:
			return stateVector[0] == State.main_region_TurnAround;
		case main_region_CrowdScanningAndCounting:
			return stateVector[0] == State.main_region_CrowdScanningAndCounting;
		case main_region_RiddleGame1:
			return stateVector[0].ordinal() >= State.
					main_region_RiddleGame1.ordinal()&& stateVector[0].ordinal() <= State.main_region_RiddleGame1_r1_Answer.ordinal();
		case main_region_RiddleGame1_r1_StartGame:
			return stateVector[0] == State.main_region_RiddleGame1_r1_StartGame;
		case main_region_RiddleGame1_r1_RequestForOpertator:
			return stateVector[0] == State.main_region_RiddleGame1_r1_RequestForOpertator;
		case main_region_RiddleGame1_r1_WaitForQuestion:
			return stateVector[0] == State.main_region_RiddleGame1_r1_WaitForQuestion;
		case main_region_RiddleGame1_r1_Answer:
			return stateVector[0] == State.main_region_RiddleGame1_r1_Answer;
		case main_region_BlindMan_sBluGame:
			return stateVector[0].ordinal() >= State.
					main_region_BlindMan_sBluGame.ordinal()&& stateVector[0].ordinal() <= State.main_region_BlindMan_sBluGame_r1_Answer.ordinal();
		case main_region_BlindMan_sBluGame_r1_StartGame:
			return stateVector[0] == State.main_region_BlindMan_sBluGame_r1_StartGame;
		case main_region_BlindMan_sBluGame_r1_ListenForQuestion:
			return stateVector[0] == State.main_region_BlindMan_sBluGame_r1_ListenForQuestion;
		case main_region_BlindMan_sBluGame_r1_WaitForQuestion:
			return stateVector[0] == State.main_region_BlindMan_sBluGame_r1_WaitForQuestion;
		case main_region_BlindMan_sBluGame_r1_Answer:
			return stateVector[0] == State.main_region_BlindMan_sBluGame_r1_Answer;
		case main_region_LeaveTheRoom:
			return stateVector[0] == State.main_region_LeaveTheRoom;
		case main_region__final_:
			return stateVector[0] == State.main_region__final_;
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
	
	public SCInterface getSCInterface() {
		return sCInterface;
	}
	
	public SCIHBrain getSCIHBrain() {
		return sCIHBrain;
	}
	
	public SCIUdpInterface getSCIUdpInterface() {
		return sCIUdpInterface;
	}
	
	public SCIVBrain getSCIVBrain() {
		return sCIVBrain;
	}
	
	public SCISTT getSCISTT() {
		return sCISTT;
	}
	
	private boolean check_main_region_Init_tr0_tr0() {
		return sCIUdpInterface.ready;
	}
	
	private boolean check_main_region_Announcement_tr0_tr0() {
		return sCIHBrain.tTSFinished==true;
	}
	
	private boolean check_main_region_Wait_tr0_tr0() {
		return timeEvents[0];
	}
	
	private boolean check_main_region_TurnAround_tr0_tr0() {
		return sCIUdpInterface.turnAroundFinished;
	}
	
	private boolean check_main_region_RiddleGame1_r1_RequestForOpertator_tr0_tr0() {
		return timeEvents[1];
	}
	
	private boolean check_main_region_RiddleGame1_r1_Answer_tr0_tr0() {
		return getQuestionCounter()<7;
	}
	
	private boolean check_main_region_RiddleGame1_r1_Answer_tr1_tr1() {
		return getQuestionCounter()==7;
	}
	
	private boolean check_main_region_BlindMan_sBluGame_r1_ListenForQuestion_tr0_tr0() {
		return timeEvents[2];
	}
	
	private boolean check_main_region_BlindMan_sBluGame_r1_Answer_tr0_tr0() {
		return getQuestionCounter()<7;
	}
	
	private boolean check_main_region_BlindMan_sBluGame_r1_Answer_tr1_tr1() {
		return getQuestionCounter()==7;
	}
	
	private void effect_main_region_Init_tr0() {
		exitSequence_main_region_Init();
		enterSequence_main_region_Announcement_default();
	}
	
	private void effect_main_region_Announcement_tr0() {
		exitSequence_main_region_Announcement();
		enterSequence_main_region_Wait_default();
	}
	
	private void effect_main_region_Wait_tr0() {
		exitSequence_main_region_Wait();
		enterSequence_main_region_TurnAround_default();
	}
	
	private void effect_main_region_TurnAround_tr0() {
		exitSequence_main_region_TurnAround();
		enterSequence_main_region_CrowdScanningAndCounting_default();
	}
	
	private void effect_main_region_RiddleGame1_r1_RequestForOpertator_tr0() {
		exitSequence_main_region_RiddleGame1_r1_RequestForOpertator();
		enterSequence_main_region_RiddleGame1_r1_WaitForQuestion_default();
	}
	
	private void effect_main_region_RiddleGame1_r1_Answer_tr0() {
		exitSequence_main_region_RiddleGame1_r1_Answer();
		enterSequence_main_region_RiddleGame1_r1_WaitForQuestion_default();
	}
	
	private void effect_main_region_RiddleGame1_r1_Answer_tr1() {
		exitSequence_main_region_RiddleGame1();
		enterSequence_main_region_BlindMan_sBluGame_r1_StartGame_default();
	}
	
	private void effect_main_region_BlindMan_sBluGame_r1_ListenForQuestion_tr0() {
		exitSequence_main_region_BlindMan_sBluGame_r1_ListenForQuestion();
		enterSequence_main_region_BlindMan_sBluGame_r1_WaitForQuestion_default();
	}
	
	private void effect_main_region_BlindMan_sBluGame_r1_Answer_tr0() {
		exitSequence_main_region_BlindMan_sBluGame_r1_Answer();
		enterSequence_main_region_BlindMan_sBluGame_r1_WaitForQuestion_default();
	}
	
	private void effect_main_region_BlindMan_sBluGame_r1_Answer_tr1() {
		exitSequence_main_region_BlindMan_sBluGame();
		enterSequence_main_region_LeaveTheRoom_default();
	}
	
	/* Entry action for state 'Init'. */
	private void entryAction_main_region_Init() {
		sCIUdpInterface.operationCallback.receive(0);
		
		sCISTT.setSTTReady(false);
		
		sCIUdpInterface.operationCallback.sendToKinect2_detectionOnOff(false);
	}
	
	/* Entry action for state 'Announcement'. */
	private void entryAction_main_region_Announcement() {
		sCIUdpInterface.operationCallback.sendToHBrain_TTS("I want to play the riddle game!");
	}
	
	/* Entry action for state 'Wait'. */
	private void entryAction_main_region_Wait() {
		timer.setTimer(this, 0, 10*1000, false);
	}
	
	/* Entry action for state 'TurnAround'. */
	private void entryAction_main_region_TurnAround() {
		sCIUdpInterface.operationCallback.sendToNav_bodyUTurn();
	}
	
	/* Entry action for state 'CrowdScanningAndCounting'. */
	private void entryAction_main_region_CrowdScanningAndCounting() {
		sCIUdpInterface.operationCallback.sendToHBrain_TTS("");
	}
	
	/* Entry action for state 'StartGame'. */
	private void entryAction_main_region_RiddleGame1_r1_StartGame() {
		setQuestionCounter(0);
	}
	
	/* Entry action for state 'RequestForOpertator'. */
	private void entryAction_main_region_RiddleGame1_r1_RequestForOpertator() {
		timer.setTimer(this, 1, 5*1000, false);
		
		sCIUdpInterface.operationCallback.sendToHBrain_TTS("who want to play riddles with me?");
	}
	
	/* Entry action for state 'WaitForQuestion'. */
	private void entryAction_main_region_RiddleGame1_r1_WaitForQuestion() {
		sCISTT.setSTTReady(true);
		
		sCIUdpInterface.operationCallback.sendToSTT_detectionOnOff(0);
	}
	
	/* Entry action for state 'Answer'. */
	private void entryAction_main_region_RiddleGame1_r1_Answer() {
		setQuestionCounter(getQuestionCounter() + 1);
	}
	
	/* Entry action for state 'StartGame'. */
	private void entryAction_main_region_BlindMan_sBluGame_r1_StartGame() {
		setQuestionCounter(0);
	}
	
	/* Entry action for state 'ListenForQuestion'. */
	private void entryAction_main_region_BlindMan_sBluGame_r1_ListenForQuestion() {
		timer.setTimer(this, 2, 5*1000, false);
		
		sCISTT.setSTTReady(true);
	}
	
	/* Entry action for state 'WaitForQuestion'. */
	private void entryAction_main_region_BlindMan_sBluGame_r1_WaitForQuestion() {
		sCISTT.setSTTReady(true);
	}
	
	/* Entry action for state 'Answer'. */
	private void entryAction_main_region_BlindMan_sBluGame_r1_Answer() {
		setQuestionCounter(getQuestionCounter() + 1);
	}
	
	/* Exit action for state 'Wait'. */
	private void exitAction_main_region_Wait() {
		timer.unsetTimer(this, 0);
	}
	
	/* Exit action for state 'RequestForOpertator'. */
	private void exitAction_main_region_RiddleGame1_r1_RequestForOpertator() {
		timer.unsetTimer(this, 1);
	}
	
	/* Exit action for state 'ListenForQuestion'. */
	private void exitAction_main_region_BlindMan_sBluGame_r1_ListenForQuestion() {
		timer.unsetTimer(this, 2);
	}
	
	/* 'default' enter sequence for state Init */
	private void enterSequence_main_region_Init_default() {
		entryAction_main_region_Init();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_Init;
	}
	
	/* 'default' enter sequence for state Announcement */
	private void enterSequence_main_region_Announcement_default() {
		entryAction_main_region_Announcement();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_Announcement;
	}
	
	/* 'default' enter sequence for state Wait */
	private void enterSequence_main_region_Wait_default() {
		entryAction_main_region_Wait();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_Wait;
	}
	
	/* 'default' enter sequence for state TurnAround */
	private void enterSequence_main_region_TurnAround_default() {
		entryAction_main_region_TurnAround();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_TurnAround;
	}
	
	/* 'default' enter sequence for state CrowdScanningAndCounting */
	private void enterSequence_main_region_CrowdScanningAndCounting_default() {
		entryAction_main_region_CrowdScanningAndCounting();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_CrowdScanningAndCounting;
	}
	
	/* 'default' enter sequence for state StartGame */
	private void enterSequence_main_region_RiddleGame1_r1_StartGame_default() {
		entryAction_main_region_RiddleGame1_r1_StartGame();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_RiddleGame1_r1_StartGame;
	}
	
	/* 'default' enter sequence for state RequestForOpertator */
	private void enterSequence_main_region_RiddleGame1_r1_RequestForOpertator_default() {
		entryAction_main_region_RiddleGame1_r1_RequestForOpertator();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_RiddleGame1_r1_RequestForOpertator;
	}
	
	/* 'default' enter sequence for state WaitForQuestion */
	private void enterSequence_main_region_RiddleGame1_r1_WaitForQuestion_default() {
		entryAction_main_region_RiddleGame1_r1_WaitForQuestion();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_RiddleGame1_r1_WaitForQuestion;
	}
	
	/* 'default' enter sequence for state Answer */
	private void enterSequence_main_region_RiddleGame1_r1_Answer_default() {
		entryAction_main_region_RiddleGame1_r1_Answer();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_RiddleGame1_r1_Answer;
	}
	
	/* 'default' enter sequence for state StartGame */
	private void enterSequence_main_region_BlindMan_sBluGame_r1_StartGame_default() {
		entryAction_main_region_BlindMan_sBluGame_r1_StartGame();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_BlindMan_sBluGame_r1_StartGame;
	}
	
	/* 'default' enter sequence for state ListenForQuestion */
	private void enterSequence_main_region_BlindMan_sBluGame_r1_ListenForQuestion_default() {
		entryAction_main_region_BlindMan_sBluGame_r1_ListenForQuestion();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_BlindMan_sBluGame_r1_ListenForQuestion;
	}
	
	/* 'default' enter sequence for state WaitForQuestion */
	private void enterSequence_main_region_BlindMan_sBluGame_r1_WaitForQuestion_default() {
		entryAction_main_region_BlindMan_sBluGame_r1_WaitForQuestion();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_BlindMan_sBluGame_r1_WaitForQuestion;
	}
	
	/* 'default' enter sequence for state Answer */
	private void enterSequence_main_region_BlindMan_sBluGame_r1_Answer_default() {
		entryAction_main_region_BlindMan_sBluGame_r1_Answer();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_BlindMan_sBluGame_r1_Answer;
	}
	
	/* 'default' enter sequence for state LeaveTheRoom */
	private void enterSequence_main_region_LeaveTheRoom_default() {
		nextStateIndex = 0;
		stateVector[0] = State.main_region_LeaveTheRoom;
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
	
	/* Default exit sequence for state Announcement */
	private void exitSequence_main_region_Announcement() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state Wait */
	private void exitSequence_main_region_Wait() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
		
		exitAction_main_region_Wait();
	}
	
	/* Default exit sequence for state TurnAround */
	private void exitSequence_main_region_TurnAround() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state CrowdScanningAndCounting */
	private void exitSequence_main_region_CrowdScanningAndCounting() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state RiddleGame1 */
	private void exitSequence_main_region_RiddleGame1() {
		exitSequence_main_region_RiddleGame1_r1();
	}
	
	/* Default exit sequence for state StartGame */
	private void exitSequence_main_region_RiddleGame1_r1_StartGame() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state RequestForOpertator */
	private void exitSequence_main_region_RiddleGame1_r1_RequestForOpertator() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
		
		exitAction_main_region_RiddleGame1_r1_RequestForOpertator();
	}
	
	/* Default exit sequence for state WaitForQuestion */
	private void exitSequence_main_region_RiddleGame1_r1_WaitForQuestion() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state Answer */
	private void exitSequence_main_region_RiddleGame1_r1_Answer() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state BlindMan'sBluGame */
	private void exitSequence_main_region_BlindMan_sBluGame() {
		exitSequence_main_region_BlindMan_sBluGame_r1();
	}
	
	/* Default exit sequence for state StartGame */
	private void exitSequence_main_region_BlindMan_sBluGame_r1_StartGame() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state ListenForQuestion */
	private void exitSequence_main_region_BlindMan_sBluGame_r1_ListenForQuestion() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
		
		exitAction_main_region_BlindMan_sBluGame_r1_ListenForQuestion();
	}
	
	/* Default exit sequence for state WaitForQuestion */
	private void exitSequence_main_region_BlindMan_sBluGame_r1_WaitForQuestion() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state Answer */
	private void exitSequence_main_region_BlindMan_sBluGame_r1_Answer() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state LeaveTheRoom */
	private void exitSequence_main_region_LeaveTheRoom() {
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
		case main_region_Announcement:
			exitSequence_main_region_Announcement();
			break;
		case main_region_Wait:
			exitSequence_main_region_Wait();
			break;
		case main_region_TurnAround:
			exitSequence_main_region_TurnAround();
			break;
		case main_region_CrowdScanningAndCounting:
			exitSequence_main_region_CrowdScanningAndCounting();
			break;
		case main_region_RiddleGame1_r1_StartGame:
			exitSequence_main_region_RiddleGame1_r1_StartGame();
			break;
		case main_region_RiddleGame1_r1_RequestForOpertator:
			exitSequence_main_region_RiddleGame1_r1_RequestForOpertator();
			break;
		case main_region_RiddleGame1_r1_WaitForQuestion:
			exitSequence_main_region_RiddleGame1_r1_WaitForQuestion();
			break;
		case main_region_RiddleGame1_r1_Answer:
			exitSequence_main_region_RiddleGame1_r1_Answer();
			break;
		case main_region_BlindMan_sBluGame_r1_StartGame:
			exitSequence_main_region_BlindMan_sBluGame_r1_StartGame();
			break;
		case main_region_BlindMan_sBluGame_r1_ListenForQuestion:
			exitSequence_main_region_BlindMan_sBluGame_r1_ListenForQuestion();
			break;
		case main_region_BlindMan_sBluGame_r1_WaitForQuestion:
			exitSequence_main_region_BlindMan_sBluGame_r1_WaitForQuestion();
			break;
		case main_region_BlindMan_sBluGame_r1_Answer:
			exitSequence_main_region_BlindMan_sBluGame_r1_Answer();
			break;
		case main_region_LeaveTheRoom:
			exitSequence_main_region_LeaveTheRoom();
			break;
		case main_region__final_:
			exitSequence_main_region__final_();
			break;
		default:
			break;
		}
	}
	
	/* Default exit sequence for region r1 */
	private void exitSequence_main_region_RiddleGame1_r1() {
		switch (stateVector[0]) {
		case main_region_RiddleGame1_r1_StartGame:
			exitSequence_main_region_RiddleGame1_r1_StartGame();
			break;
		case main_region_RiddleGame1_r1_RequestForOpertator:
			exitSequence_main_region_RiddleGame1_r1_RequestForOpertator();
			break;
		case main_region_RiddleGame1_r1_WaitForQuestion:
			exitSequence_main_region_RiddleGame1_r1_WaitForQuestion();
			break;
		case main_region_RiddleGame1_r1_Answer:
			exitSequence_main_region_RiddleGame1_r1_Answer();
			break;
		default:
			break;
		}
	}
	
	/* Default exit sequence for region r1 */
	private void exitSequence_main_region_BlindMan_sBluGame_r1() {
		switch (stateVector[0]) {
		case main_region_BlindMan_sBluGame_r1_StartGame:
			exitSequence_main_region_BlindMan_sBluGame_r1_StartGame();
			break;
		case main_region_BlindMan_sBluGame_r1_ListenForQuestion:
			exitSequence_main_region_BlindMan_sBluGame_r1_ListenForQuestion();
			break;
		case main_region_BlindMan_sBluGame_r1_WaitForQuestion:
			exitSequence_main_region_BlindMan_sBluGame_r1_WaitForQuestion();
			break;
		case main_region_BlindMan_sBluGame_r1_Answer:
			exitSequence_main_region_BlindMan_sBluGame_r1_Answer();
			break;
		default:
			break;
		}
	}
	
	/* The reactions of state Init. */
	private void react_main_region_Init() {
		if (check_main_region_Init_tr0_tr0()) {
			effect_main_region_Init_tr0();
		}
	}
	
	/* The reactions of state Announcement. */
	private void react_main_region_Announcement() {
		if (check_main_region_Announcement_tr0_tr0()) {
			effect_main_region_Announcement_tr0();
		}
	}
	
	/* The reactions of state Wait. */
	private void react_main_region_Wait() {
		if (check_main_region_Wait_tr0_tr0()) {
			effect_main_region_Wait_tr0();
		}
	}
	
	/* The reactions of state TurnAround. */
	private void react_main_region_TurnAround() {
		if (check_main_region_TurnAround_tr0_tr0()) {
			effect_main_region_TurnAround_tr0();
		}
	}
	
	/* The reactions of state CrowdScanningAndCounting. */
	private void react_main_region_CrowdScanningAndCounting() {
	}
	
	/* The reactions of state StartGame. */
	private void react_main_region_RiddleGame1_r1_StartGame() {
	}
	
	/* The reactions of state RequestForOpertator. */
	private void react_main_region_RiddleGame1_r1_RequestForOpertator() {
		if (check_main_region_RiddleGame1_r1_RequestForOpertator_tr0_tr0()) {
			effect_main_region_RiddleGame1_r1_RequestForOpertator_tr0();
		}
	}
	
	/* The reactions of state WaitForQuestion. */
	private void react_main_region_RiddleGame1_r1_WaitForQuestion() {
	}
	
	/* The reactions of state Answer. */
	private void react_main_region_RiddleGame1_r1_Answer() {
		if (check_main_region_RiddleGame1_r1_Answer_tr0_tr0()) {
			effect_main_region_RiddleGame1_r1_Answer_tr0();
		} else {
			if (check_main_region_RiddleGame1_r1_Answer_tr1_tr1()) {
				effect_main_region_RiddleGame1_r1_Answer_tr1();
			}
		}
	}
	
	/* The reactions of state StartGame. */
	private void react_main_region_BlindMan_sBluGame_r1_StartGame() {
	}
	
	/* The reactions of state ListenForQuestion. */
	private void react_main_region_BlindMan_sBluGame_r1_ListenForQuestion() {
		if (check_main_region_BlindMan_sBluGame_r1_ListenForQuestion_tr0_tr0()) {
			effect_main_region_BlindMan_sBluGame_r1_ListenForQuestion_tr0();
		}
	}
	
	/* The reactions of state WaitForQuestion. */
	private void react_main_region_BlindMan_sBluGame_r1_WaitForQuestion() {
	}
	
	/* The reactions of state Answer. */
	private void react_main_region_BlindMan_sBluGame_r1_Answer() {
		if (check_main_region_BlindMan_sBluGame_r1_Answer_tr0_tr0()) {
			effect_main_region_BlindMan_sBluGame_r1_Answer_tr0();
		} else {
			if (check_main_region_BlindMan_sBluGame_r1_Answer_tr1_tr1()) {
				effect_main_region_BlindMan_sBluGame_r1_Answer_tr1();
			}
		}
	}
	
	/* The reactions of state LeaveTheRoom. */
	private void react_main_region_LeaveTheRoom() {
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
			case main_region_Announcement:
				react_main_region_Announcement();
				break;
			case main_region_Wait:
				react_main_region_Wait();
				break;
			case main_region_TurnAround:
				react_main_region_TurnAround();
				break;
			case main_region_CrowdScanningAndCounting:
				react_main_region_CrowdScanningAndCounting();
				break;
			case main_region_RiddleGame1_r1_StartGame:
				react_main_region_RiddleGame1_r1_StartGame();
				break;
			case main_region_RiddleGame1_r1_RequestForOpertator:
				react_main_region_RiddleGame1_r1_RequestForOpertator();
				break;
			case main_region_RiddleGame1_r1_WaitForQuestion:
				react_main_region_RiddleGame1_r1_WaitForQuestion();
				break;
			case main_region_RiddleGame1_r1_Answer:
				react_main_region_RiddleGame1_r1_Answer();
				break;
			case main_region_BlindMan_sBluGame_r1_StartGame:
				react_main_region_BlindMan_sBluGame_r1_StartGame();
				break;
			case main_region_BlindMan_sBluGame_r1_ListenForQuestion:
				react_main_region_BlindMan_sBluGame_r1_ListenForQuestion();
				break;
			case main_region_BlindMan_sBluGame_r1_WaitForQuestion:
				react_main_region_BlindMan_sBluGame_r1_WaitForQuestion();
				break;
			case main_region_BlindMan_sBluGame_r1_Answer:
				react_main_region_BlindMan_sBluGame_r1_Answer();
				break;
			case main_region_LeaveTheRoom:
				react_main_region_LeaveTheRoom();
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
