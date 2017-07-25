package org.yakindu.scr.helpmecarry;
import org.yakindu.scr.ITimer;

public class HelpMeCarryStatemachine implements IHelpMeCarryStatemachine {

	protected class SCIBGFImpl implements SCIBGF {
	
		private SCIBGFOperationCallback operationCallback;
		
		public void setSCIBGFOperationCallback(
				SCIBGFOperationCallback operationCallback) {
			this.operationCallback = operationCallback;
		}
		private long eventNum;
		
		public long getEventNum() {
			return eventNum;
		}
		
		public void setEventNum(long value) {
			this.eventNum = value;
		}
		
		private long randNum;
		
		public long getRandNum() {
			return randNum;
		}
		
		public void setRandNum(long value) {
			this.randNum = value;
		}
		
	}
	
	protected SCIBGFImpl sCIBGF;
	
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
		
		private boolean answerReceived;
		
		public void raiseAnswerReceived() {
			answerReceived = true;
		}
		
		private boolean actionReceived;
		
		public void raiseActionReceived() {
			actionReceived = true;
		}
		
		private boolean actionsReceived;
		
		public void raiseActionsReceived() {
			actionsReceived = true;
		}
		
		protected void clearEvents() {
			spokenTextReceived = false;
			incomprehensible = false;
			answerReceived = false;
			actionReceived = false;
			actionsReceived = false;
		}
	}
	
	protected SCISTTImpl sCISTT;
	
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
		
		private boolean obstacleAvoidDone;
		
		public void raiseObstacleAvoidDone() {
			obstacleAvoidDone = true;
		}
		
		protected void clearEvents() {
			detectionPersonFound = false;
			trackingPersonLost = false;
			obstacleDetected = false;
			obstacleAvoidDone = false;
		}
	}
	
	protected SCIFollowMeImpl sCIFollowMe;
	
	private boolean initialized = false;
	
	public enum State {
		main_region_Detection,
		main_region_NotFound,
		main_region_Found,
		main_region_StartTracking,
		main_region_StartTracking_WaitingForStopCommand_STToff,
		main_region_StartTracking_WaitingForStopCommand_STTstart,
		main_region_StartTracking_WaitingForStopCommand_TextReceived,
		main_region_StartTracking_WaitingForStopCommand_TTS,
		main_region_Lost,
		main_region_Lost_WavingToFindPerson_UTurn1,
		main_region_Lost_WavingToFindPerson_WaveFound,
		main_region_Lost_WavingToFindPerson_Turn,
		main_region_Lost_WavingToFindPerson_DetectionOn,
		main_region_Lost_WavingToFindPerson_PersonFound,
		main_region_Lost_WavingToFindPerson_ILostYou,
		main_region_Lost_WavingToFindPerson_UTurn2,
		main_region_Lost_WavingToFindPerson_Detection,
		main_region_Lost_WavingToFindPerson_NotFound,
		main_region_Lost_WavingToFindPerson_ILostU,
		main_region_HowCanIHelpYou,
		main_region_HowCanIHelpYou_main_region_StateA,
		main_region_HowCanIHelpYou_main_region_StartSTT,
		main_region_HowCanIHelpYou_main_region_TellAnswer,
		main_region_HowCanIHelpYou_main_region_Repeat,
		main_region_HowCanIHelpYou_main_region_TellIncomprehensible,
		main_region_HowCanIHelpYou_main_region_StopSTT,
		main_region_HowCanIHelpYou_main_region_Stop2,
		main_region_HowCanIHelpYou_main_region_wait,
		main_region_HowCanIHelpYou_main_region_stateB,
		main_region_ArrivedWaypoint,
		main_region__final_,
		main_region_StartSTT,
		main_region_StopSTT,
		main_region_FollowYes,
		main_region_FollowNo,
		main_region_GoTo,
		main_region_GoTo_goto_goto,
		main_region_GoTo_goto_goto_fallback,
		main_region_GoTo_goto_gotoWP,
		main_region_LocationNotFound,
		main_region_DetectionOn,
		main_region_LockingForNextOperator,
		main_region_Turn,
		main_region_PersonFound,
		main_region_GuideMe,
		main_region_GuideMe_folllowMePleaseRepeat_TTS,
		main_region_wait,
		main_region_arrived,
		main_region_DetectionOff,
		main_region_TrackingOffAndSavePoint,
		main_region_PathBlocked,
		main_region_PathBlocked_Blocked_speak,
		main_region_PathBlocked_Blocked_gotoendp,
		main_region_blocked2ndTime,
		main_region_blocked,
		main_region_nextTry,
		main_region_arrived1,
		main_region_ObstacleFollow,
		main_region_ObstacleFollow_ObstacleAvoidingText_TTS,
		main_region_ObstacleFollow_ObstacleAvoidingText_WaitForAvoiding,
		main_region_ObstacleFollow_ObstacleAvoidingText_GoOn,
		main_region_ObstacleWayBack,
		main_region_ObstacleWayBack_ObstacleAvoidingText_TTS,
		leonie_Bupered_Or_Emergency_Stop_waitForEvent,
		leonie_Bupered_Or_Emergency_Stop_Bumpered,
		leonie_Bupered_Or_Emergency_Stop_resetFace,
		leonie_Bupered_Or_Emergency_Stop_EmergencyStop,
		leonie_Bupered_Or_Emergency_Stop_checkEmergency,
		$NullState$
	};
	
	private final State[] stateVector = new State[2];
	
	private int nextStateIndex;
	
	private ITimer timer;
	
	private final boolean[] timeEvents = new boolean[29];
	private long counter;
	
	protected void setCounter(long value) {
		counter = value;
	}
	
	protected long getCounter() {
		return counter;
	}
	
	private long counterTwo;
	
	protected void setCounterTwo(long value) {
		counterTwo = value;
	}
	
	protected long getCounterTwo() {
		return counterTwo;
	}
	
	private String nameBuffer;
	
	protected void setNameBuffer(String value) {
		nameBuffer = value;
	}
	
	protected String getNameBuffer() {
		return nameBuffer;
	}
	
	private long questionCounter;
	
	protected void setQuestionCounter(long value) {
		questionCounter = value;
	}
	
	protected long getQuestionCounter() {
		return questionCounter;
	}
	
	private boolean bodyMoved;
	
	protected void setBodyMoved(boolean value) {
		bodyMoved = value;
	}
	
	protected boolean getBodyMoved() {
		return bodyMoved;
	}
	
	private long gWPtemp;
	
	protected void setGWPtemp(long value) {
		gWPtemp = value;
	}
	
	protected long getGWPtemp() {
		return gWPtemp;
	}
	
	public HelpMeCarryStatemachine() {
		sCIBGF = new SCIBGFImpl();
		sCIHBrain = new SCIHBrainImpl();
		sCIKinect2 = new SCIKinect2Impl();
		sCIMira = new SCIMiraImpl();
		sCISTT = new SCISTTImpl();
		sCIFollowMe = new SCIFollowMeImpl();
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
		sCIBGF.setEventNum(0);
		
		sCIBGF.setRandNum(0);
		
		setCounter(0);
		
		setCounterTwo(0);
		
		setNameBuffer("");
		
		setQuestionCounter(0);
		
		setBodyMoved(false);
		
		setGWPtemp(0);
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
		enterSequence_Leonie_Bupered_Or_Emergency_Stop_default();
	}
	
	public void exit() {
		exitSequence_main_region();
		exitSequence_Leonie_Bupered_Or_Emergency_Stop();
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
		sCIFollowMe.clearEvents();
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
		case main_region_Detection:
			return stateVector[0] == State.main_region_Detection;
		case main_region_NotFound:
			return stateVector[0] == State.main_region_NotFound;
		case main_region_Found:
			return stateVector[0] == State.main_region_Found;
		case main_region_StartTracking:
			return stateVector[0].ordinal() >= State.
					main_region_StartTracking.ordinal()&& stateVector[0].ordinal() <= State.main_region_StartTracking_WaitingForStopCommand_TTS.ordinal();
		case main_region_StartTracking_WaitingForStopCommand_STToff:
			return stateVector[0] == State.main_region_StartTracking_WaitingForStopCommand_STToff;
		case main_region_StartTracking_WaitingForStopCommand_STTstart:
			return stateVector[0] == State.main_region_StartTracking_WaitingForStopCommand_STTstart;
		case main_region_StartTracking_WaitingForStopCommand_TextReceived:
			return stateVector[0] == State.main_region_StartTracking_WaitingForStopCommand_TextReceived;
		case main_region_StartTracking_WaitingForStopCommand_TTS:
			return stateVector[0] == State.main_region_StartTracking_WaitingForStopCommand_TTS;
		case main_region_Lost:
			return stateVector[0].ordinal() >= State.
					main_region_Lost.ordinal()&& stateVector[0].ordinal() <= State.main_region_Lost_WavingToFindPerson_ILostU.ordinal();
		case main_region_Lost_WavingToFindPerson_UTurn1:
			return stateVector[0] == State.main_region_Lost_WavingToFindPerson_UTurn1;
		case main_region_Lost_WavingToFindPerson_WaveFound:
			return stateVector[0] == State.main_region_Lost_WavingToFindPerson_WaveFound;
		case main_region_Lost_WavingToFindPerson_Turn:
			return stateVector[0] == State.main_region_Lost_WavingToFindPerson_Turn;
		case main_region_Lost_WavingToFindPerson_DetectionOn:
			return stateVector[0] == State.main_region_Lost_WavingToFindPerson_DetectionOn;
		case main_region_Lost_WavingToFindPerson_PersonFound:
			return stateVector[0] == State.main_region_Lost_WavingToFindPerson_PersonFound;
		case main_region_Lost_WavingToFindPerson_ILostYou:
			return stateVector[0] == State.main_region_Lost_WavingToFindPerson_ILostYou;
		case main_region_Lost_WavingToFindPerson_UTurn2:
			return stateVector[0] == State.main_region_Lost_WavingToFindPerson_UTurn2;
		case main_region_Lost_WavingToFindPerson_Detection:
			return stateVector[0] == State.main_region_Lost_WavingToFindPerson_Detection;
		case main_region_Lost_WavingToFindPerson_NotFound:
			return stateVector[0] == State.main_region_Lost_WavingToFindPerson_NotFound;
		case main_region_Lost_WavingToFindPerson_ILostU:
			return stateVector[0] == State.main_region_Lost_WavingToFindPerson_ILostU;
		case main_region_HowCanIHelpYou:
			return stateVector[0].ordinal() >= State.
					main_region_HowCanIHelpYou.ordinal()&& stateVector[0].ordinal() <= State.main_region_HowCanIHelpYou_main_region_stateB.ordinal();
		case main_region_HowCanIHelpYou_main_region_StateA:
			return stateVector[0] == State.main_region_HowCanIHelpYou_main_region_StateA;
		case main_region_HowCanIHelpYou_main_region_StartSTT:
			return stateVector[0] == State.main_region_HowCanIHelpYou_main_region_StartSTT;
		case main_region_HowCanIHelpYou_main_region_TellAnswer:
			return stateVector[0] == State.main_region_HowCanIHelpYou_main_region_TellAnswer;
		case main_region_HowCanIHelpYou_main_region_Repeat:
			return stateVector[0] == State.main_region_HowCanIHelpYou_main_region_Repeat;
		case main_region_HowCanIHelpYou_main_region_TellIncomprehensible:
			return stateVector[0] == State.main_region_HowCanIHelpYou_main_region_TellIncomprehensible;
		case main_region_HowCanIHelpYou_main_region_StopSTT:
			return stateVector[0] == State.main_region_HowCanIHelpYou_main_region_StopSTT;
		case main_region_HowCanIHelpYou_main_region_Stop2:
			return stateVector[0] == State.main_region_HowCanIHelpYou_main_region_Stop2;
		case main_region_HowCanIHelpYou_main_region_wait:
			return stateVector[0] == State.main_region_HowCanIHelpYou_main_region_wait;
		case main_region_HowCanIHelpYou_main_region_stateB:
			return stateVector[0] == State.main_region_HowCanIHelpYou_main_region_stateB;
		case main_region_ArrivedWaypoint:
			return stateVector[0] == State.main_region_ArrivedWaypoint;
		case main_region__final_:
			return stateVector[0] == State.main_region__final_;
		case main_region_StartSTT:
			return stateVector[0] == State.main_region_StartSTT;
		case main_region_StopSTT:
			return stateVector[0] == State.main_region_StopSTT;
		case main_region_FollowYes:
			return stateVector[0] == State.main_region_FollowYes;
		case main_region_FollowNo:
			return stateVector[0] == State.main_region_FollowNo;
		case main_region_GoTo:
			return stateVector[0].ordinal() >= State.
					main_region_GoTo.ordinal()&& stateVector[0].ordinal() <= State.main_region_GoTo_goto_gotoWP.ordinal();
		case main_region_GoTo_goto_goto:
			return stateVector[0] == State.main_region_GoTo_goto_goto;
		case main_region_GoTo_goto_goto_fallback:
			return stateVector[0] == State.main_region_GoTo_goto_goto_fallback;
		case main_region_GoTo_goto_gotoWP:
			return stateVector[0] == State.main_region_GoTo_goto_gotoWP;
		case main_region_LocationNotFound:
			return stateVector[0] == State.main_region_LocationNotFound;
		case main_region_DetectionOn:
			return stateVector[0] == State.main_region_DetectionOn;
		case main_region_LockingForNextOperator:
			return stateVector[0] == State.main_region_LockingForNextOperator;
		case main_region_Turn:
			return stateVector[0] == State.main_region_Turn;
		case main_region_PersonFound:
			return stateVector[0] == State.main_region_PersonFound;
		case main_region_GuideMe:
			return stateVector[0].ordinal() >= State.
					main_region_GuideMe.ordinal()&& stateVector[0].ordinal() <= State.main_region_GuideMe_folllowMePleaseRepeat_TTS.ordinal();
		case main_region_GuideMe_folllowMePleaseRepeat_TTS:
			return stateVector[0] == State.main_region_GuideMe_folllowMePleaseRepeat_TTS;
		case main_region_wait:
			return stateVector[0] == State.main_region_wait;
		case main_region_arrived:
			return stateVector[0] == State.main_region_arrived;
		case main_region_DetectionOff:
			return stateVector[0] == State.main_region_DetectionOff;
		case main_region_TrackingOffAndSavePoint:
			return stateVector[0] == State.main_region_TrackingOffAndSavePoint;
		case main_region_PathBlocked:
			return stateVector[0].ordinal() >= State.
					main_region_PathBlocked.ordinal()&& stateVector[0].ordinal() <= State.main_region_PathBlocked_Blocked_gotoendp.ordinal();
		case main_region_PathBlocked_Blocked_speak:
			return stateVector[0] == State.main_region_PathBlocked_Blocked_speak;
		case main_region_PathBlocked_Blocked_gotoendp:
			return stateVector[0] == State.main_region_PathBlocked_Blocked_gotoendp;
		case main_region_blocked2ndTime:
			return stateVector[0] == State.main_region_blocked2ndTime;
		case main_region_blocked:
			return stateVector[0] == State.main_region_blocked;
		case main_region_nextTry:
			return stateVector[0] == State.main_region_nextTry;
		case main_region_arrived1:
			return stateVector[0] == State.main_region_arrived1;
		case main_region_ObstacleFollow:
			return stateVector[0].ordinal() >= State.
					main_region_ObstacleFollow.ordinal()&& stateVector[0].ordinal() <= State.main_region_ObstacleFollow_ObstacleAvoidingText_GoOn.ordinal();
		case main_region_ObstacleFollow_ObstacleAvoidingText_TTS:
			return stateVector[0] == State.main_region_ObstacleFollow_ObstacleAvoidingText_TTS;
		case main_region_ObstacleFollow_ObstacleAvoidingText_WaitForAvoiding:
			return stateVector[0] == State.main_region_ObstacleFollow_ObstacleAvoidingText_WaitForAvoiding;
		case main_region_ObstacleFollow_ObstacleAvoidingText_GoOn:
			return stateVector[0] == State.main_region_ObstacleFollow_ObstacleAvoidingText_GoOn;
		case main_region_ObstacleWayBack:
			return stateVector[0].ordinal() >= State.
					main_region_ObstacleWayBack.ordinal()&& stateVector[0].ordinal() <= State.main_region_ObstacleWayBack_ObstacleAvoidingText_TTS.ordinal();
		case main_region_ObstacleWayBack_ObstacleAvoidingText_TTS:
			return stateVector[0] == State.main_region_ObstacleWayBack_ObstacleAvoidingText_TTS;
		case leonie_Bupered_Or_Emergency_Stop_waitForEvent:
			return stateVector[1] == State.leonie_Bupered_Or_Emergency_Stop_waitForEvent;
		case leonie_Bupered_Or_Emergency_Stop_Bumpered:
			return stateVector[1] == State.leonie_Bupered_Or_Emergency_Stop_Bumpered;
		case leonie_Bupered_Or_Emergency_Stop_resetFace:
			return stateVector[1] == State.leonie_Bupered_Or_Emergency_Stop_resetFace;
		case leonie_Bupered_Or_Emergency_Stop_EmergencyStop:
			return stateVector[1] == State.leonie_Bupered_Or_Emergency_Stop_EmergencyStop;
		case leonie_Bupered_Or_Emergency_Stop_checkEmergency:
			return stateVector[1] == State.leonie_Bupered_Or_Emergency_Stop_checkEmergency;
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
	
	public SCIBGF getSCIBGF() {
		return sCIBGF;
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
	
	public SCIFollowMe getSCIFollowMe() {
		return sCIFollowMe;
	}
	
	private boolean check_main_region_Detection_tr0_tr0() {
		return sCIFollowMe.detectionPersonFound;
	}
	
	private boolean check_main_region_Detection_tr1_tr1() {
		return getCounter()>10;
	}
	
	private boolean check_main_region_Detection_tr2_tr2() {
		return timeEvents[0];
	}
	
	private boolean check_main_region_NotFound_tr0_tr0() {
		return true;
	}
	
	private boolean check_main_region_NotFound_tr1_tr1() {
		return sCIFollowMe.detectionPersonFound;
	}
	
	private boolean check_main_region_Found_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_main_region_Found_tr1_tr1() {
		return timeEvents[1];
	}
	
	private boolean check_main_region_StartTracking_tr0_tr0() {
		return sCIFollowMe.trackingPersonLost;
	}
	
	private boolean check_main_region_StartTracking_tr2_tr2() {
		return sCIFollowMe.obstacleDetected;
	}
	
	private boolean check_main_region_StartTracking_WaitingForStopCommand_STToff_tr0_tr0() {
		return sCISTT.actionReceived;
	}
	
	private boolean check_main_region_StartTracking_WaitingForStopCommand_STToff_tr1_tr1() {
		return timeEvents[2];
	}
	
	private boolean check_main_region_StartTracking_WaitingForStopCommand_STToff_tr2_tr2() {
		return sCISTT.spokenTextReceived;
	}
	
	private boolean check_main_region_StartTracking_WaitingForStopCommand_STTstart_tr0_tr0() {
		return timeEvents[3];
	}
	
	private boolean check_main_region_StartTracking_WaitingForStopCommand_STTstart_tr1_tr1() {
		return sCISTT.actionReceived;
	}
	
	private boolean check_main_region_StartTracking_WaitingForStopCommand_STTstart_tr2_tr2() {
		return sCISTT.spokenTextReceived;
	}
	
	private boolean check_main_region_StartTracking_WaitingForStopCommand_TextReceived_tr0_tr0() {
		return sCISTT.actionReceived;
	}
	
	private boolean check_main_region_StartTracking_WaitingForStopCommand_TextReceived_tr1_tr1() {
		return timeEvents[4];
	}
	
	private boolean check_main_region_StartTracking_WaitingForStopCommand_TextReceived_tr2_tr2() {
		return sCIBGF.operationCallback.containsString(sCISTT.operationCallback.getSpokenText(), "stop")==true;
	}
	
	private boolean check_main_region_StartTracking_WaitingForStopCommand_TextReceived_tr3_tr3() {
		return sCIBGF.operationCallback.containsString(sCISTT.operationCallback.getSpokenText(), "car")==true;
	}
	
	private boolean check_main_region_StartTracking_WaitingForStopCommand_TextReceived_tr4_tr4() {
		return sCIBGF.operationCallback.containsString(sCISTT.operationCallback.getSpokenText(), "arrive")==true;
	}
	
	private boolean check_main_region_StartTracking_WaitingForStopCommand_TTS_tr0_tr0() {
		return true;
	}
	
	private boolean check_main_region_Lost_WavingToFindPerson_UTurn1_tr0_tr0() {
		return timeEvents[5];
	}
	
	private boolean check_main_region_Lost_WavingToFindPerson_WaveFound_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_main_region_Lost_WavingToFindPerson_Turn_tr0_tr0() {
		return sCIKinect2.wavingDetected;
	}
	
	private boolean check_main_region_Lost_WavingToFindPerson_Turn_tr1_tr1() {
		return timeEvents[6];
	}
	
	private boolean check_main_region_Lost_WavingToFindPerson_DetectionOn_tr0_tr0() {
		return timeEvents[7];
	}
	
	private boolean check_main_region_Lost_WavingToFindPerson_PersonFound_tr0_tr0() {
		return true;
	}
	
	private boolean check_main_region_Lost_WavingToFindPerson_ILostYou_tr0_tr0() {
		return 1==0;
	}
	
	private boolean check_main_region_Lost_WavingToFindPerson_ILostYou_tr1_tr1() {
		return true;
	}
	
	private boolean check_main_region_Lost_WavingToFindPerson_UTurn2_tr0_tr0() {
		return timeEvents[8];
	}
	
	private boolean check_main_region_Lost_WavingToFindPerson_Detection_tr0_tr0() {
		return timeEvents[9];
	}
	
	private boolean check_main_region_Lost_WavingToFindPerson_Detection_tr1_tr1() {
		return sCIFollowMe.detectionPersonFound;
	}
	
	private boolean check_main_region_Lost_WavingToFindPerson_Detection_tr2_tr2() {
		return getCounter()>10;
	}
	
	private boolean check_main_region_Lost_WavingToFindPerson_NotFound_tr0_tr0() {
		return true;
	}
	
	private boolean check_main_region_Lost_WavingToFindPerson_ILostU_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_main_region_Lost_WavingToFindPerson_ILostU_tr1_tr1() {
		return timeEvents[10];
	}
	
	private boolean check_main_region_HowCanIHelpYou_main_region_StateA_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_main_region_HowCanIHelpYou_main_region_StateA_tr1_tr1() {
		return timeEvents[11];
	}
	
	private boolean check_main_region_HowCanIHelpYou_main_region_StartSTT_tr0_tr0() {
		return timeEvents[12];
	}
	
	private boolean check_main_region_HowCanIHelpYou_main_region_StartSTT_tr1_tr1() {
		return getCounter()>3;
	}
	
	private boolean check_main_region_HowCanIHelpYou_main_region_TellAnswer_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_main_region_HowCanIHelpYou_main_region_TellAnswer_tr1_tr1() {
		return timeEvents[13];
	}
	
	private boolean check_main_region_HowCanIHelpYou_main_region_Repeat_tr0_tr0() {
		return true;
	}
	
	private boolean check_main_region_HowCanIHelpYou_main_region_TellIncomprehensible_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_main_region_HowCanIHelpYou_main_region_StopSTT_tr0_tr0() {
		return sCISTT.answerReceived;
	}
	
	private boolean check_main_region_HowCanIHelpYou_main_region_StopSTT_tr1_tr1() {
		return sCISTT.actionReceived;
	}
	
	private boolean check_main_region_HowCanIHelpYou_main_region_StopSTT_tr2_tr2() {
		return sCISTT.incomprehensible;
	}
	
	private boolean check_main_region_HowCanIHelpYou_main_region_StopSTT_tr3_tr3() {
		return timeEvents[14];
	}
	
	private boolean check_main_region_HowCanIHelpYou_main_region_Stop2_tr0_tr0() {
		return true;
	}
	
	private boolean check_main_region_HowCanIHelpYou_main_region_wait_tr0_tr0() {
		return timeEvents[15];
	}
	
	private boolean check_main_region_HowCanIHelpYou_main_region_stateB_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_main_region_HowCanIHelpYou_main_region_stateB_tr1_tr1() {
		return timeEvents[16];
	}
	
	private boolean check_main_region_ArrivedWaypoint_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_main_region_ArrivedWaypoint_tr1_tr1() {
		return timeEvents[17];
	}
	
	private boolean check_main_region_StartSTT_tr0_tr0() {
		return timeEvents[18];
	}
	
	private boolean check_main_region_StopSTT_tr0_tr0() {
		return sCISTT.answerReceived;
	}
	
	private boolean check_main_region_StopSTT_tr1_tr1() {
		return sCISTT.incomprehensible;
	}
	
	private boolean check_main_region_StopSTT_tr2_tr2() {
		return timeEvents[19];
	}
	
	private boolean check_main_region_FollowYes_tr0_tr0() {
		return true;
	}
	
	private boolean check_main_region_FollowNo_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_main_region_FollowNo_tr1_tr1() {
		return timeEvents[20];
	}
	
	private boolean check_main_region_GoTo_tr2_tr2() {
		return sCIMira.blocked;
	}
	
	private boolean check_main_region_GoTo_tr3_tr3() {
		return sCIFollowMe.obstacleDetected;
	}
	
	private boolean check_main_region_GoTo_goto_goto_tr0_tr0() {
		return sCIMira.arrivedWP;
	}
	
	private boolean check_main_region_GoTo_goto_goto_fallback_tr0_tr0() {
		return sCIMira.arrivedWP;
	}
	
	private boolean check_main_region_GoTo_goto_gotoWP_tr0_tr0() {
		return sCIMira.arrivedWP;
	}
	
	private boolean check_main_region_LocationNotFound_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_main_region_DetectionOn_tr0_tr0() {
		return true;
	}
	
	private boolean check_main_region_LockingForNextOperator_tr0_tr0() {
		return getCounter()>5;
	}
	
	private boolean check_main_region_LockingForNextOperator_tr1_tr1() {
		return timeEvents[21];
	}
	
	private boolean check_main_region_LockingForNextOperator_tr2_tr2() {
		return sCIFollowMe.detectionPersonFound;
	}
	
	private boolean check_main_region_Turn_tr0_tr0() {
		return true;
	}
	
	private boolean check_main_region_PersonFound_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_main_region_PersonFound_tr1_tr1() {
		return timeEvents[22];
	}
	
	private boolean check_main_region_GuideMe_tr0_tr0() {
		return sCIMira.arrivedWP;
	}
	
	private boolean check_main_region_GuideMe_tr1_tr1() {
		return sCIMira.blocked;
	}
	
	private boolean check_main_region_GuideMe_folllowMePleaseRepeat_TTS_tr0_tr0() {
		return timeEvents[23];
	}
	
	private boolean check_main_region_wait_tr0_tr0() {
		return timeEvents[24];
	}
	
	private boolean check_main_region_arrived_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_main_region_DetectionOff_tr0_tr0() {
		return timeEvents[25];
	}
	
	private boolean check_main_region_TrackingOffAndSavePoint_tr0_tr0() {
		return true;
	}
	
	private boolean check_main_region_PathBlocked_Blocked_speak_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_main_region_PathBlocked_Blocked_gotoendp_tr0_tr0() {
		return sCIMira.arrivedWP;
	}
	
	private boolean check_main_region_PathBlocked_Blocked_gotoendp_tr1_tr1() {
		return sCIMira.blocked;
	}
	
	private boolean check_main_region_blocked2ndTime_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_main_region_blocked_tr0_tr0() {
		return timeEvents[26];
	}
	
	private boolean check_main_region_nextTry_tr0_tr0() {
		return sCIMira.arrivedWP;
	}
	
	private boolean check_main_region_arrived1_tr0_tr0() {
		return sCIMira.arrivedWP;
	}
	
	private boolean check_main_region_ObstacleFollow_ObstacleAvoidingText_TTS_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_main_region_ObstacleFollow_ObstacleAvoidingText_WaitForAvoiding_tr0_tr0() {
		return sCIFollowMe.obstacleAvoidDone;
	}
	
	private boolean check_main_region_ObstacleFollow_ObstacleAvoidingText_GoOn_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_main_region_ObstacleWayBack_ObstacleAvoidingText_TTS_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_Leonie_Bupered_Or_Emergency_Stop_waitForEvent_tr0_tr0() {
		return sCIMira.bumpered;
	}
	
	private boolean check_Leonie_Bupered_Or_Emergency_Stop_waitForEvent_tr1_tr1() {
		return sCIMira.emergencyStop;
	}
	
	private boolean check_Leonie_Bupered_Or_Emergency_Stop_Bumpered_tr0_tr0() {
		return timeEvents[27];
	}
	
	private boolean check_Leonie_Bupered_Or_Emergency_Stop_resetFace_tr0_tr0() {
		return true;
	}
	
	private boolean check_Leonie_Bupered_Or_Emergency_Stop_EmergencyStop_tr0_tr0() {
		return true;
	}
	
	private boolean check_Leonie_Bupered_Or_Emergency_Stop_checkEmergency_tr0_tr0() {
		return timeEvents[28];
	}
	
	private boolean check_Leonie_Bupered_Or_Emergency_Stop_checkEmergency_tr1_tr1() {
		return sCIMira.emergencyStop;
	}
	
	private boolean check_main_region_StartTracking_WaitingForStopCommand__choice_0_tr0_tr0() {
		return (sCISTT.operationCallback.getInstruction()== null?"followme" ==null :sCISTT.operationCallback.getInstruction().equals("followme")) && (sCISTT.operationCallback.getObject()== null?"stop" ==null :sCISTT.operationCallback.getObject().equals("stop"));
	}
	
	private boolean check_main_region_StartTracking_WaitingForStopCommand__choice_0_tr1_tr1() {
		return true;
	}
	
	private boolean check_main_region_HowCanIHelpYou_main_region__choice_0_tr1_tr1() {
		return (sCISTT.operationCallback.getInstruction()== null?"goto" ==null :sCISTT.operationCallback.getInstruction().equals("goto"));
	}
	
	private boolean check_main_region_HowCanIHelpYou_main_region__choice_0_tr0_tr0() {
		return true;
	}
	
	private boolean check_main_region_HowCanIHelpYou_main_region__choice_1_tr1_tr1() {
		return getCounter()>3;
	}
	
	private boolean check_main_region_HowCanIHelpYou_main_region__choice_1_tr0_tr0() {
		return true;
	}
	
	private boolean check_main_region_HowCanIHelpYou_main_region__choice_2_tr0_tr0() {
		return sCIBGF.operationCallback.getGWPByName(sCISTT.operationCallback.getAnswer())!=-1;
	}
	
	private boolean check_main_region_HowCanIHelpYou_main_region__choice_2_tr1_tr1() {
		return true;
	}
	
	private boolean check_main_region__choice_0_tr0_tr0() {
		return (sCISTT.operationCallback.getAnswer()== null?"yes" ==null :sCISTT.operationCallback.getAnswer().equals("yes"));
	}
	
	private boolean check_main_region__choice_0_tr1_tr1() {
		return true;
	}
	
	private boolean check_main_region_GoTo_goto__choice_0_tr1_tr1() {
		return sCIBGF.operationCallback.getGWPByName(sCISTT.operationCallback.getObject())==-1;
	}
	
	private boolean check_main_region_GoTo_goto__choice_0_tr0_tr0() {
		return true;
	}
	
	private boolean check_main_region_GoTo_goto__choice_1_tr0_tr0() {
		return (sCISTT.operationCallback.getObject()== null?"" ==null :sCISTT.operationCallback.getObject().equals(""));
	}
	
	private boolean check_main_region_GoTo_goto__choice_1_tr1_tr1() {
		return true;
	}
	
	private boolean check_main_region__choice_1_tr0() {
		return true;
	}
	
	private boolean check_main_region__choice_2_tr0_tr0() {
		return getCounterTwo()<3;
	}
	
	private boolean check_main_region__choice_2_tr1_tr1() {
		return true;
	}
	
	private void effect_main_region_Detection_tr0() {
		exitSequence_main_region_Detection();
		enterSequence_main_region_Found_default();
	}
	
	private void effect_main_region_Detection_tr1() {
		exitSequence_main_region_Detection();
		enterSequence_main_region_NotFound_default();
	}
	
	private void effect_main_region_Detection_tr2() {
		exitSequence_main_region_Detection();
		enterSequence_main_region_Detection_default();
	}
	
	private void effect_main_region_NotFound_tr0() {
		exitSequence_main_region_NotFound();
		enterSequence_main_region_Detection_default();
	}
	
	private void effect_main_region_NotFound_tr1() {
		exitSequence_main_region_NotFound();
		enterSequence_main_region_Found_default();
	}
	
	private void effect_main_region_Found_tr0() {
		exitSequence_main_region_Found();
		enterSequence_main_region_StartSTT_default();
	}
	
	private void effect_main_region_Found_tr1() {
		exitSequence_main_region_Found();
		enterSequence_main_region_StopSTT_default();
	}
	
	private void effect_main_region_StartTracking_tr0() {
		exitSequence_main_region_StartTracking();
		enterSequence_main_region_Lost_default();
	}
	
	private void effect_main_region_StartTracking_tr1() {
		exitSequence_main_region_StartTracking();
		enterSequence_main_region_DetectionOff_default();
	}
	
	private void effect_main_region_StartTracking_tr2() {
		exitSequence_main_region_StartTracking();
		enterSequence_main_region_ObstacleFollow_default();
	}
	
	private void effect_main_region_StartTracking_WaitingForStopCommand_STToff_tr0() {
		exitSequence_main_region_StartTracking_WaitingForStopCommand_STToff();
		react_main_region_StartTracking_WaitingForStopCommand__choice_0();
	}
	
	private void effect_main_region_StartTracking_WaitingForStopCommand_STToff_tr1() {
		exitSequence_main_region_StartTracking_WaitingForStopCommand_STToff();
		enterSequence_main_region_StartTracking_WaitingForStopCommand_STTstart_default();
	}
	
	private void effect_main_region_StartTracking_WaitingForStopCommand_STToff_tr2() {
		exitSequence_main_region_StartTracking_WaitingForStopCommand_STToff();
		enterSequence_main_region_StartTracking_WaitingForStopCommand_TextReceived_default();
	}
	
	private void effect_main_region_StartTracking_WaitingForStopCommand_STTstart_tr0() {
		exitSequence_main_region_StartTracking_WaitingForStopCommand_STTstart();
		enterSequence_main_region_StartTracking_WaitingForStopCommand_STToff_default();
	}
	
	private void effect_main_region_StartTracking_WaitingForStopCommand_STTstart_tr1() {
		exitSequence_main_region_StartTracking_WaitingForStopCommand_STTstart();
		react_main_region_StartTracking_WaitingForStopCommand__choice_0();
	}
	
	private void effect_main_region_StartTracking_WaitingForStopCommand_STTstart_tr2() {
		exitSequence_main_region_StartTracking_WaitingForStopCommand_STTstart();
		enterSequence_main_region_StartTracking_WaitingForStopCommand_TextReceived_default();
	}
	
	private void effect_main_region_StartTracking_WaitingForStopCommand_TextReceived_tr0() {
		exitSequence_main_region_StartTracking_WaitingForStopCommand_TextReceived();
		react_main_region_StartTracking_WaitingForStopCommand__choice_0();
	}
	
	private void effect_main_region_StartTracking_WaitingForStopCommand_TextReceived_tr1() {
		exitSequence_main_region_StartTracking_WaitingForStopCommand_TextReceived();
		react_main_region_StartTracking_WaitingForStopCommand__choice_0();
	}
	
	private void effect_main_region_StartTracking_WaitingForStopCommand_TextReceived_tr2() {
		exitSequence_main_region_StartTracking_WaitingForStopCommand_TextReceived();
		enterSequence_main_region_StartTracking_WaitingForStopCommand_TTS_default();
	}
	
	private void effect_main_region_StartTracking_WaitingForStopCommand_TextReceived_tr3() {
		exitSequence_main_region_StartTracking_WaitingForStopCommand_TextReceived();
		enterSequence_main_region_StartTracking_WaitingForStopCommand_TTS_default();
	}
	
	private void effect_main_region_StartTracking_WaitingForStopCommand_TextReceived_tr4() {
		exitSequence_main_region_StartTracking_WaitingForStopCommand_TextReceived();
		enterSequence_main_region_StartTracking_WaitingForStopCommand_TTS_default();
	}
	
	private void effect_main_region_StartTracking_WaitingForStopCommand_TTS_tr0() {
		exitSequence_main_region_StartTracking_WaitingForStopCommand_TTS();
		react_main_region_StartTracking_WaitingForStopCommand_exit_arrived();
	}
	
	private void effect_main_region_Lost_tr0() {
		exitSequence_main_region_Lost();
		enterSequence_main_region_StartTracking_default();
	}
	
	private void effect_main_region_Lost_WavingToFindPerson_UTurn1_tr0() {
		exitSequence_main_region_Lost_WavingToFindPerson_UTurn1();
		enterSequence_main_region_Lost_WavingToFindPerson_Turn_default();
	}
	
	private void effect_main_region_Lost_WavingToFindPerson_WaveFound_tr0() {
		exitSequence_main_region_Lost_WavingToFindPerson_WaveFound();
		enterSequence_main_region_Lost_WavingToFindPerson_UTurn2_default();
	}
	
	private void effect_main_region_Lost_WavingToFindPerson_Turn_tr0() {
		exitSequence_main_region_Lost_WavingToFindPerson_Turn();
		enterSequence_main_region_Lost_WavingToFindPerson_WaveFound_default();
	}
	
	private void effect_main_region_Lost_WavingToFindPerson_Turn_tr1() {
		exitSequence_main_region_Lost_WavingToFindPerson_Turn();
		enterSequence_main_region_Lost_WavingToFindPerson_Turn_default();
	}
	
	private void effect_main_region_Lost_WavingToFindPerson_DetectionOn_tr0() {
		exitSequence_main_region_Lost_WavingToFindPerson_DetectionOn();
		enterSequence_main_region_Lost_WavingToFindPerson_Detection_default();
	}
	
	private void effect_main_region_Lost_WavingToFindPerson_PersonFound_tr0() {
		exitSequence_main_region_Lost_WavingToFindPerson_PersonFound();
		react_main_region_Lost_WavingToFindPerson_exit_done();
	}
	
	private void effect_main_region_Lost_WavingToFindPerson_ILostYou_tr0() {
		exitSequence_main_region_Lost_WavingToFindPerson_ILostYou();
		enterSequence_main_region_Lost_WavingToFindPerson_UTurn1_default();
	}
	
	private void effect_main_region_Lost_WavingToFindPerson_ILostYou_tr1() {
		exitSequence_main_region_Lost_WavingToFindPerson_ILostYou();
		enterSequence_main_region_Lost_WavingToFindPerson_ILostU_default();
	}
	
	private void effect_main_region_Lost_WavingToFindPerson_UTurn2_tr0() {
		exitSequence_main_region_Lost_WavingToFindPerson_UTurn2();
		enterSequence_main_region_Lost_WavingToFindPerson_DetectionOn_default();
	}
	
	private void effect_main_region_Lost_WavingToFindPerson_Detection_tr0() {
		exitSequence_main_region_Lost_WavingToFindPerson_Detection();
		enterSequence_main_region_Lost_WavingToFindPerson_Detection_default();
	}
	
	private void effect_main_region_Lost_WavingToFindPerson_Detection_tr1() {
		exitSequence_main_region_Lost_WavingToFindPerson_Detection();
		enterSequence_main_region_Lost_WavingToFindPerson_PersonFound_default();
	}
	
	private void effect_main_region_Lost_WavingToFindPerson_Detection_tr2() {
		exitSequence_main_region_Lost_WavingToFindPerson_Detection();
		enterSequence_main_region_Lost_WavingToFindPerson_NotFound_default();
	}
	
	private void effect_main_region_Lost_WavingToFindPerson_NotFound_tr0() {
		exitSequence_main_region_Lost_WavingToFindPerson_NotFound();
		enterSequence_main_region_Lost_WavingToFindPerson_Detection_default();
	}
	
	private void effect_main_region_Lost_WavingToFindPerson_ILostU_tr0() {
		exitSequence_main_region_Lost_WavingToFindPerson_ILostU();
		enterSequence_main_region_Lost_WavingToFindPerson_DetectionOn_default();
	}
	
	private void effect_main_region_Lost_WavingToFindPerson_ILostU_tr1() {
		exitSequence_main_region_Lost_WavingToFindPerson_ILostU();
		enterSequence_main_region_Lost_WavingToFindPerson_DetectionOn_default();
	}
	
	private void effect_main_region_HowCanIHelpYou_tr0() {
		exitSequence_main_region_HowCanIHelpYou();
		enterSequence_main_region_GoTo_default();
	}
	
	private void effect_main_region_HowCanIHelpYou_main_region_StateA_tr0() {
		exitSequence_main_region_HowCanIHelpYou_main_region_StateA();
		enterSequence_main_region_HowCanIHelpYou_main_region_wait_default();
	}
	
	private void effect_main_region_HowCanIHelpYou_main_region_StateA_tr1() {
		exitSequence_main_region_HowCanIHelpYou_main_region_StateA();
		enterSequence_main_region_HowCanIHelpYou_main_region_wait_default();
	}
	
	private void effect_main_region_HowCanIHelpYou_main_region_StartSTT_tr0() {
		exitSequence_main_region_HowCanIHelpYou_main_region_StartSTT();
		enterSequence_main_region_HowCanIHelpYou_main_region_StopSTT_default();
	}
	
	private void effect_main_region_HowCanIHelpYou_main_region_StartSTT_tr1() {
		exitSequence_main_region_HowCanIHelpYou_main_region_StartSTT();
		enterSequence_main_region_HowCanIHelpYou_main_region_Stop2_default();
	}
	
	private void effect_main_region_HowCanIHelpYou_main_region_TellAnswer_tr0() {
		exitSequence_main_region_HowCanIHelpYou_main_region_TellAnswer();
		react_main_region_HowCanIHelpYou_main_region__choice_1();
	}
	
	private void effect_main_region_HowCanIHelpYou_main_region_TellAnswer_tr1() {
		exitSequence_main_region_HowCanIHelpYou_main_region_TellAnswer();
		react_main_region_HowCanIHelpYou_main_region__choice_1();
	}
	
	private void effect_main_region_HowCanIHelpYou_main_region_Repeat_tr0() {
		exitSequence_main_region_HowCanIHelpYou_main_region_Repeat();
		enterSequence_main_region_HowCanIHelpYou_main_region_StartSTT_default();
	}
	
	private void effect_main_region_HowCanIHelpYou_main_region_TellIncomprehensible_tr0() {
		exitSequence_main_region_HowCanIHelpYou_main_region_TellIncomprehensible();
		react_main_region_HowCanIHelpYou_main_region__choice_1();
	}
	
	private void effect_main_region_HowCanIHelpYou_main_region_StopSTT_tr0() {
		exitSequence_main_region_HowCanIHelpYou_main_region_StopSTT();
		react_main_region_HowCanIHelpYou_main_region__choice_2();
	}
	
	private void effect_main_region_HowCanIHelpYou_main_region_StopSTT_tr1() {
		exitSequence_main_region_HowCanIHelpYou_main_region_StopSTT();
		react_main_region_HowCanIHelpYou_main_region__choice_0();
	}
	
	private void effect_main_region_HowCanIHelpYou_main_region_StopSTT_tr2() {
		exitSequence_main_region_HowCanIHelpYou_main_region_StopSTT();
		enterSequence_main_region_HowCanIHelpYou_main_region_TellIncomprehensible_default();
	}
	
	private void effect_main_region_HowCanIHelpYou_main_region_StopSTT_tr3() {
		exitSequence_main_region_HowCanIHelpYou_main_region_StopSTT();
		react_main_region_HowCanIHelpYou_main_region_exit_goto();
	}
	
	private void effect_main_region_HowCanIHelpYou_main_region_Stop2_tr0() {
		exitSequence_main_region_HowCanIHelpYou_main_region_Stop2();
		react_main_region_HowCanIHelpYou_main_region_exit_goto();
	}
	
	private void effect_main_region_HowCanIHelpYou_main_region_wait_tr0() {
		exitSequence_main_region_HowCanIHelpYou_main_region_wait();
		enterSequence_main_region_HowCanIHelpYou_main_region_stateB_default();
	}
	
	private void effect_main_region_HowCanIHelpYou_main_region_stateB_tr0() {
		exitSequence_main_region_HowCanIHelpYou_main_region_stateB();
		enterSequence_main_region_HowCanIHelpYou_main_region_StartSTT_default();
	}
	
	private void effect_main_region_HowCanIHelpYou_main_region_stateB_tr1() {
		exitSequence_main_region_HowCanIHelpYou_main_region_stateB();
		enterSequence_main_region_HowCanIHelpYou_main_region_StartSTT_default();
	}
	
	private void effect_main_region_ArrivedWaypoint_tr0() {
		exitSequence_main_region_ArrivedWaypoint();
		enterSequence_main_region_LockingForNextOperator_default();
	}
	
	private void effect_main_region_ArrivedWaypoint_tr1() {
		exitSequence_main_region_ArrivedWaypoint();
		enterSequence_main_region_LockingForNextOperator_default();
	}
	
	private void effect_main_region_StartSTT_tr0() {
		exitSequence_main_region_StartSTT();
		enterSequence_main_region_StopSTT_default();
	}
	
	private void effect_main_region_StopSTT_tr0() {
		exitSequence_main_region_StopSTT();
		react_main_region__choice_0();
	}
	
	private void effect_main_region_StopSTT_tr1() {
		exitSequence_main_region_StopSTT();
		react_main_region__choice_2();
	}
	
	private void effect_main_region_StopSTT_tr2() {
		exitSequence_main_region_StopSTT();
		enterSequence_main_region_FollowYes_default();
	}
	
	private void effect_main_region_FollowYes_tr0() {
		exitSequence_main_region_FollowYes();
		enterSequence_main_region_StartTracking_default();
	}
	
	private void effect_main_region_FollowNo_tr0() {
		exitSequence_main_region_FollowNo();
		react_main_region__choice_1();
	}
	
	private void effect_main_region_FollowNo_tr1() {
		exitSequence_main_region_FollowNo();
		react_main_region__choice_1();
	}
	
	private void effect_main_region_GoTo_tr0() {
		exitSequence_main_region_GoTo();
		enterSequence_main_region_ArrivedWaypoint_default();
	}
	
	private void effect_main_region_GoTo_tr1() {
		exitSequence_main_region_GoTo();
		enterSequence_main_region_LocationNotFound_default();
	}
	
	private void effect_main_region_GoTo_tr2() {
		exitSequence_main_region_GoTo();
		enterSequence_main_region_blocked_default();
	}
	
	private void effect_main_region_GoTo_tr3() {
		exitSequence_main_region_GoTo();
		enterSequence_main_region_ObstacleWayBack_default();
	}
	
	private void effect_main_region_GoTo_goto_goto_tr0() {
		exitSequence_main_region_GoTo_goto_goto();
		enterSequence_main_region_GoTo_goto_gotoWP_default();
	}
	
	private void effect_main_region_GoTo_goto_goto_fallback_tr0() {
		exitSequence_main_region_GoTo_goto_goto_fallback();
		enterSequence_main_region_GoTo_goto_gotoWP_default();
	}
	
	private void effect_main_region_GoTo_goto_gotoWP_tr0() {
		exitSequence_main_region_GoTo_goto_gotoWP();
		react_main_region_GoTo_goto_exit_arrived();
	}
	
	private void effect_main_region_LocationNotFound_tr0() {
		exitSequence_main_region_LocationNotFound();
		enterSequence_main_region_HowCanIHelpYou_default();
	}
	
	private void effect_main_region_DetectionOn_tr0() {
		exitSequence_main_region_DetectionOn();
		enterSequence_main_region_Detection_default();
	}
	
	private void effect_main_region_LockingForNextOperator_tr0() {
		exitSequence_main_region_LockingForNextOperator();
		enterSequence_main_region_Turn_default();
	}
	
	private void effect_main_region_LockingForNextOperator_tr1() {
		exitSequence_main_region_LockingForNextOperator();
		enterSequence_main_region_LockingForNextOperator_default();
	}
	
	private void effect_main_region_LockingForNextOperator_tr2() {
		exitSequence_main_region_LockingForNextOperator();
		enterSequence_main_region_PersonFound_default();
	}
	
	private void effect_main_region_Turn_tr0() {
		exitSequence_main_region_Turn();
		enterSequence_main_region_LockingForNextOperator_default();
	}
	
	private void effect_main_region_PersonFound_tr0() {
		exitSequence_main_region_PersonFound();
		enterSequence_main_region_wait_default();
	}
	
	private void effect_main_region_PersonFound_tr1() {
		exitSequence_main_region_PersonFound();
		enterSequence_main_region_wait_default();
	}
	
	private void effect_main_region_GuideMe_tr0() {
		exitSequence_main_region_GuideMe();
		enterSequence_main_region_arrived_default();
	}
	
	private void effect_main_region_GuideMe_tr1() {
		exitSequence_main_region_GuideMe();
		enterSequence_main_region_PathBlocked_default();
	}
	
	private void effect_main_region_GuideMe_folllowMePleaseRepeat_TTS_tr0() {
		exitSequence_main_region_GuideMe_folllowMePleaseRepeat_TTS();
		enterSequence_main_region_GuideMe_folllowMePleaseRepeat_TTS_default();
	}
	
	private void effect_main_region_wait_tr0() {
		exitSequence_main_region_wait();
		enterSequence_main_region_GuideMe_default();
	}
	
	private void effect_main_region_arrived_tr0() {
		exitSequence_main_region_arrived();
		enterSequence_main_region__final__default();
	}
	
	private void effect_main_region_DetectionOff_tr0() {
		exitSequence_main_region_DetectionOff();
		enterSequence_main_region_TrackingOffAndSavePoint_default();
	}
	
	private void effect_main_region_TrackingOffAndSavePoint_tr0() {
		exitSequence_main_region_TrackingOffAndSavePoint();
		enterSequence_main_region_HowCanIHelpYou_default();
	}
	
	private void effect_main_region_PathBlocked_tr0() {
		exitSequence_main_region_PathBlocked();
		enterSequence_main_region_arrived_default();
	}
	
	private void effect_main_region_PathBlocked_tr1() {
		exitSequence_main_region_PathBlocked();
		enterSequence_main_region_blocked2ndTime_default();
	}
	
	private void effect_main_region_PathBlocked_Blocked_speak_tr0() {
		exitSequence_main_region_PathBlocked_Blocked_speak();
		enterSequence_main_region_PathBlocked_Blocked_gotoendp_default();
	}
	
	private void effect_main_region_PathBlocked_Blocked_gotoendp_tr0() {
		exitSequence_main_region_PathBlocked_Blocked_gotoendp();
		react_main_region_PathBlocked_Blocked_exit_done();
	}
	
	private void effect_main_region_PathBlocked_Blocked_gotoendp_tr1() {
		exitSequence_main_region_PathBlocked_Blocked_gotoendp();
		react_main_region_PathBlocked_Blocked_exit_failed();
	}
	
	private void effect_main_region_blocked2ndTime_tr0() {
		exitSequence_main_region_blocked2ndTime();
		enterSequence_main_region__final__default();
	}
	
	private void effect_main_region_blocked_tr0() {
		exitSequence_main_region_blocked();
		enterSequence_main_region_nextTry_default();
	}
	
	private void effect_main_region_nextTry_tr0() {
		exitSequence_main_region_nextTry();
		enterSequence_main_region_arrived1_default();
	}
	
	private void effect_main_region_arrived1_tr0() {
		exitSequence_main_region_arrived1();
		enterSequence_main_region_ArrivedWaypoint_default();
	}
	
	private void effect_main_region_ObstacleFollow_tr0() {
		exitSequence_main_region_ObstacleFollow();
		enterSequence_main_region_StartTracking_default();
	}
	
	private void effect_main_region_ObstacleFollow_ObstacleAvoidingText_TTS_tr0() {
		exitSequence_main_region_ObstacleFollow_ObstacleAvoidingText_TTS();
		enterSequence_main_region_ObstacleFollow_ObstacleAvoidingText_WaitForAvoiding_default();
	}
	
	private void effect_main_region_ObstacleFollow_ObstacleAvoidingText_WaitForAvoiding_tr0() {
		exitSequence_main_region_ObstacleFollow_ObstacleAvoidingText_WaitForAvoiding();
		enterSequence_main_region_ObstacleFollow_ObstacleAvoidingText_GoOn_default();
	}
	
	private void effect_main_region_ObstacleFollow_ObstacleAvoidingText_GoOn_tr0() {
		exitSequence_main_region_ObstacleFollow_ObstacleAvoidingText_GoOn();
		react_main_region_ObstacleFollow_ObstacleAvoidingText_exit_done();
	}
	
	private void effect_main_region_ObstacleWayBack_tr0() {
		exitSequence_main_region_ObstacleWayBack();
		enterSequence_main_region_GoTo_default();
	}
	
	private void effect_main_region_ObstacleWayBack_ObstacleAvoidingText_TTS_tr0() {
		exitSequence_main_region_ObstacleWayBack_ObstacleAvoidingText_TTS();
		react_main_region_ObstacleWayBack_ObstacleAvoidingText_exit_done();
	}
	
	private void effect_Leonie_Bupered_Or_Emergency_Stop_waitForEvent_tr0() {
		exitSequence_Leonie_Bupered_Or_Emergency_Stop_waitForEvent();
		enterSequence_Leonie_Bupered_Or_Emergency_Stop_Bumpered_default();
	}
	
	private void effect_Leonie_Bupered_Or_Emergency_Stop_waitForEvent_tr1() {
		exitSequence_Leonie_Bupered_Or_Emergency_Stop_waitForEvent();
		enterSequence_Leonie_Bupered_Or_Emergency_Stop_EmergencyStop_default();
	}
	
	private void effect_Leonie_Bupered_Or_Emergency_Stop_Bumpered_tr0() {
		exitSequence_Leonie_Bupered_Or_Emergency_Stop_Bumpered();
		enterSequence_Leonie_Bupered_Or_Emergency_Stop_resetFace_default();
	}
	
	private void effect_Leonie_Bupered_Or_Emergency_Stop_resetFace_tr0() {
		exitSequence_Leonie_Bupered_Or_Emergency_Stop_resetFace();
		enterSequence_Leonie_Bupered_Or_Emergency_Stop_waitForEvent_default();
	}
	
	private void effect_Leonie_Bupered_Or_Emergency_Stop_EmergencyStop_tr0() {
		exitSequence_Leonie_Bupered_Or_Emergency_Stop_EmergencyStop();
		enterSequence_Leonie_Bupered_Or_Emergency_Stop_checkEmergency_default();
	}
	
	private void effect_Leonie_Bupered_Or_Emergency_Stop_checkEmergency_tr0() {
		exitSequence_Leonie_Bupered_Or_Emergency_Stop_checkEmergency();
		enterSequence_Leonie_Bupered_Or_Emergency_Stop_resetFace_default();
	}
	
	private void effect_Leonie_Bupered_Or_Emergency_Stop_checkEmergency_tr1() {
		exitSequence_Leonie_Bupered_Or_Emergency_Stop_checkEmergency();
		enterSequence_Leonie_Bupered_Or_Emergency_Stop_checkEmergency_default();
	}
	
	private void effect_main_region_StartTracking_WaitingForStopCommand__choice_0_tr0() {
		react_main_region_StartTracking_WaitingForStopCommand_exit_arrived();
	}
	
	private void effect_main_region_StartTracking_WaitingForStopCommand__choice_0_tr1() {
		enterSequence_main_region_StartTracking_WaitingForStopCommand_STTstart_default();
	}
	
	private void effect_main_region_HowCanIHelpYou_main_region__choice_0_tr1() {
		react_main_region_HowCanIHelpYou_main_region_exit_goto();
	}
	
	private void effect_main_region_HowCanIHelpYou_main_region__choice_0_tr0() {
		react_main_region_HowCanIHelpYou_main_region__choice_1();
	}
	
	private void effect_main_region_HowCanIHelpYou_main_region__choice_1_tr1() {
		react_main_region_HowCanIHelpYou_main_region_exit_goto();
	}
	
	private void effect_main_region_HowCanIHelpYou_main_region__choice_1_tr0() {
		enterSequence_main_region_HowCanIHelpYou_main_region_Repeat_default();
	}
	
	private void effect_main_region_HowCanIHelpYou_main_region__choice_2_tr0() {
		react_main_region_HowCanIHelpYou_main_region__choice_0();
	}
	
	private void effect_main_region_HowCanIHelpYou_main_region__choice_2_tr1() {
		enterSequence_main_region_HowCanIHelpYou_main_region_TellAnswer_default();
	}
	
	private void effect_main_region__choice_0_tr0() {
		enterSequence_main_region_FollowYes_default();
	}
	
	private void effect_main_region__choice_0_tr1() {
		react_main_region__choice_2();
	}
	
	private void effect_main_region_GoTo_goto__choice_0_tr1() {
		react_main_region_GoTo_goto__choice_1();
	}
	
	private void effect_main_region_GoTo_goto__choice_0_tr0() {
		enterSequence_main_region_GoTo_goto_goto_default();
	}
	
	private void effect_main_region_GoTo_goto__choice_1_tr0() {
		enterSequence_main_region_GoTo_goto_goto_fallback_default();
	}
	
	private void effect_main_region_GoTo_goto__choice_1_tr1() {
		react_main_region_GoTo_goto_exit_notFound();
	}
	
	private void effect_main_region__choice_1_tr0() {
		enterSequence_main_region_Detection_default();
	}
	
	private void effect_main_region__choice_2_tr0() {
		enterSequence_main_region_FollowNo_default();
	}
	
	private void effect_main_region__choice_2_tr1() {
		enterSequence_main_region_FollowYes_default();
	}
	
	/* Entry action for state 'Detection'. */
	private void entryAction_main_region_Detection() {
		timer.setTimer(this, 0, 1*1000, false);
		
		sCIFollowMe.operationCallback.sendRequestDetectionDetails();
		
		setCounter(getCounter() + 1);
	}
	
	/* Entry action for state 'NotFound'. */
	private void entryAction_main_region_NotFound() {
		sCIHBrain.operationCallback.sendTTS("[:-(] I want to follow somebody, but nobody is here!");
		
		setCounter(0);
	}
	
	/* Entry action for state 'Found'. */
	private void entryAction_main_region_Found() {
		timer.setTimer(this, 1, 10*1000, false);
		
		sCIHBrain.operationCallback.sendTTS("[:-)] Hello! Should I follow you? [attentive]");
	}
	
	/* Entry action for state 'StartTracking'. */
	private void entryAction_main_region_StartTracking() {
		sCIFollowMe.operationCallback.sendTrackingOnAtNext();
	}
	
	/* Entry action for state 'STToff'. */
	private void entryAction_main_region_StartTracking_WaitingForStopCommand_STToff() {
		timer.setTimer(this, 2, 2*1000, false);
		
		sCIHBrain.operationCallback.sendTTS("[:-)]");
	}
	
	/* Entry action for state 'STTstart'. */
	private void entryAction_main_region_StartTracking_WaitingForStopCommand_STTstart() {
		timer.setTimer(this, 3, 5*1000, false);
		
		sCISTT.operationCallback.sendSpeechDetectionSmalltalk(10);
		
		sCIHBrain.operationCallback.sendTTS("[attentive]");
	}
	
	/* Entry action for state 'TextReceived'. */
	private void entryAction_main_region_StartTracking_WaitingForStopCommand_TextReceived() {
		timer.setTimer(this, 4, 3*1000, false);
	}
	
	/* Entry action for state 'TTS'. */
	private void entryAction_main_region_StartTracking_WaitingForStopCommand_TTS() {
		sCIHBrain.operationCallback.sendTTS3("I understood: ", sCISTT.operationCallback.getSpokenText(), ". So, I think we arrived.");
	}
	
	/* Entry action for state 'UTurn1'. */
	private void entryAction_main_region_Lost_WavingToFindPerson_UTurn1() {
		timer.setTimer(this, 5, 1*1000, false);
		
		sCIMira.operationCallback.sendBodyUTurn();
	}
	
	/* Entry action for state 'WaveFound'. */
	private void entryAction_main_region_Lost_WavingToFindPerson_WaveFound() {
		sCIHBrain.operationCallback.sendTTS("{Person}Thank you! Please hold on.");
		
		sCIKinect2.operationCallback.sendWavingDetectionOnOff(false);
	}
	
	/* Entry action for state 'Turn'. */
	private void entryAction_main_region_Lost_WavingToFindPerson_Turn() {
		timer.setTimer(this, 6, 5*1000, false);
		
		sCIKinect2.operationCallback.sendWavingDetectionOnOff(true);
		
		sCIHBrain.operationCallback.sendTTS("[:-|] Please wave for me.");
	}
	
	/* Entry action for state 'DetectionOn'. */
	private void entryAction_main_region_Lost_WavingToFindPerson_DetectionOn() {
		timer.setTimer(this, 7, 1*1000, false);
		
		sCIFollowMe.operationCallback.sendDetectionOn();
		
		setCounter(0);
	}
	
	/* Entry action for state 'PersonFound'. */
	private void entryAction_main_region_Lost_WavingToFindPerson_PersonFound() {
		sCIHBrain.operationCallback.sendTTS("[:-)] Okay, let's go on!");
	}
	
	/* Entry action for state 'ILostYou'. */
	private void entryAction_main_region_Lost_WavingToFindPerson_ILostYou() {
		sCIFollowMe.operationCallback.sendTrackingOff();
	}
	
	/* Entry action for state 'UTurn2'. */
	private void entryAction_main_region_Lost_WavingToFindPerson_UTurn2() {
		timer.setTimer(this, 8, 3*1000, false);
		
		sCIMira.operationCallback.sendBodyUTurn();
	}
	
	/* Entry action for state 'Detection'. */
	private void entryAction_main_region_Lost_WavingToFindPerson_Detection() {
		timer.setTimer(this, 9, 1*1000, false);
		
		sCIFollowMe.operationCallback.sendRequestDetectionDetails();
		
		setCounter(counter+1);
	}
	
	/* Entry action for state 'NotFound'. */
	private void entryAction_main_region_Lost_WavingToFindPerson_NotFound() {
		sCIHBrain.operationCallback.sendTTS("[:-(] Please get into my view!");
		
		setCounter(0);
	}
	
	/* Entry action for state 'ILostU'. */
	private void entryAction_main_region_Lost_WavingToFindPerson_ILostU() {
		timer.setTimer(this, 10, 10*1000, false);
		
		sCIHBrain.operationCallback.sendTTS("[:-(] I lost you! Please come back.");
	}
	
	/* Entry action for state 'StateA'. */
	private void entryAction_main_region_HowCanIHelpYou_main_region_StateA() {
		timer.setTimer(this, 11, 10*1000, false);
		
		sCIMira.operationCallback.sendTurnBody(90);
		
		sCIHBrain.operationCallback.sendTTS("[:-)] Please hang your grocery on the hook next to my display.");
		
		setCounter(0);
	}
	
	/* Entry action for state 'StartSTT'. */
	private void entryAction_main_region_HowCanIHelpYou_main_region_StartSTT() {
		timer.setTimer(this, 12, 5*1000, false);
		
		sCISTT.operationCallback.sendSpeechDetectionSmalltalk(10);
		
		sCIHBrain.operationCallback.sendTTS("[attentive]");
		
		setCounter(getCounter() + 1);
	}
	
	/* Entry action for state 'TellAnswer'. */
	private void entryAction_main_region_HowCanIHelpYou_main_region_TellAnswer() {
		timer.setTimer(this, 13, 15*1000, false);
		
		sCIHBrain.operationCallback.sendTTS2(sCISTT.operationCallback.getAnswer(), ". That is interesting, but I think, I should send the grocery first!");
	}
	
	/* Entry action for state 'Repeat'. */
	private void entryAction_main_region_HowCanIHelpYou_main_region_Repeat() {
		sCIHBrain.operationCallback.sendTTS("Where shall I go to?");
	}
	
	/* Entry action for state 'TellIncomprehensible'. */
	private void entryAction_main_region_HowCanIHelpYou_main_region_TellIncomprehensible() {
		sCIHBrain.operationCallback.sendTTS(sCISTT.operationCallback.getAnswer());
	}
	
	/* Entry action for state 'StopSTT'. */
	private void entryAction_main_region_HowCanIHelpYou_main_region_StopSTT() {
		timer.setTimer(this, 14, 10*1000, false);
		
		sCIHBrain.operationCallback.sendTTS("[:-)]");
	}
	
	/* Entry action for state 'Stop2'. */
	private void entryAction_main_region_HowCanIHelpYou_main_region_Stop2() {
		sCIHBrain.operationCallback.sendTTS("[:-)]");
	}
	
	/* Entry action for state 'wait'. */
	private void entryAction_main_region_HowCanIHelpYou_main_region_wait() {
		timer.setTimer(this, 15, 3*1000, false);
	}
	
	/* Entry action for state 'stateB'. */
	private void entryAction_main_region_HowCanIHelpYou_main_region_stateB() {
		timer.setTimer(this, 16, 10*1000, false);
		
		sCIMira.operationCallback.sendTurnBody(-90);
		
		sCIHBrain.operationCallback.sendTTS("Tell me please, where shall I go?");
	}
	
	/* Entry action for state 'ArrivedWaypoint'. */
	private void entryAction_main_region_ArrivedWaypoint() {
		timer.setTimer(this, 17, 10*1000, false);
		
		sCIHBrain.operationCallback.sendTTS("I'm here. Is anyone here to help me? [:-)]");
		
		sCIFollowMe.operationCallback.sendDetectionOn();
		
		setCounter(0);
	}
	
	/* Entry action for state 'StartSTT'. */
	private void entryAction_main_region_StartSTT() {
		timer.setTimer(this, 18, 1*1000, false);
		
		sCISTT.operationCallback.sendSpeechDetectionYesNo(5);
	}
	
	/* Entry action for state 'StopSTT'. */
	private void entryAction_main_region_StopSTT() {
		timer.setTimer(this, 19, 5*1000, false);
		
		sCIHBrain.operationCallback.sendTTS("[:-)]");
	}
	
	/* Entry action for state 'FollowYes'. */
	private void entryAction_main_region_FollowYes() {
		sCIHBrain.operationCallback.sendTTS("[:-)] Okay. I come with you. Tell me, if I should stop.");
		
		sCIMira.operationCallback.sendSaveRuntimeStartPoint();
	}
	
	/* Entry action for state 'FollowNo'. */
	private void entryAction_main_region_FollowNo() {
		timer.setTimer(this, 20, 7*1000, false);
		
		sCIHBrain.operationCallback.sendTTS("No? [:-(] Okay. I'm looking for another person.");
	}
	
	/* Entry action for state 'goto'. */
	private void entryAction_main_region_GoTo_goto_goto() {
		setGWPtemp(sCIBGF.operationCallback.getGWPByName(sCISTT.operationCallback.getObject()));
		
		sCIMira.operationCallback.sendGoToGWP(getGWPtemp());
		
		sCIHBrain.operationCallback.sendTTS3("Your wish is my command. I will go to ", sCISTT.operationCallback.getObject(), ". But first, I have to localize myself.");
	}
	
	/* Entry action for state 'goto_fallback'. */
	private void entryAction_main_region_GoTo_goto_goto_fallback() {
		setGWPtemp(sCIBGF.operationCallback.getGWPByName("kitchen"));
		
		sCIMira.operationCallback.sendGoToGWP(getGWPtemp());
		
		sCIHBrain.operationCallback.sendTTS("Okay, I think, I should go to kitchen. But first, I have to localize myself.");
	}
	
	/* Entry action for state 'LocationNotFound'. */
	private void entryAction_main_region_LocationNotFound() {
		sCIHBrain.operationCallback.sendTTS3("[:-(] Sorry, I don't know a location like ", sCISTT.operationCallback.getObject(), ".");
	}
	
	/* Entry action for state 'DetectionOn'. */
	private void entryAction_main_region_DetectionOn() {
		sCIFollowMe.operationCallback.sendDetectionOn();
		
		setCounter(0);
		
		setCounterTwo(0);
	}
	
	/* Entry action for state 'LockingForNextOperator'. */
	private void entryAction_main_region_LockingForNextOperator() {
		timer.setTimer(this, 21, 1*1000, false);
		
		sCIFollowMe.operationCallback.sendRequestDetectionDetails();
		
		setCounter(getCounter() + 1);
	}
	
	/* Entry action for state 'Turn'. */
	private void entryAction_main_region_Turn() {
		sCIMira.operationCallback.sendTurnBody(20);
		
		setCounter(0);
	}
	
	/* Entry action for state 'PersonFound'. */
	private void entryAction_main_region_PersonFound() {
		timer.setTimer(this, 22, 10*1000, false);
		
		sCIFollowMe.operationCallback.sendDetectionOff();
		
		sCIMira.operationCallback.sendTurnBody(90);
		
		sCIHBrain.operationCallback.sendTTS("Hello. Can you take the groceries please? And I want you to follow me to the car.");
	}
	
	/* Entry action for state 'GuideMe'. */
	private void entryAction_main_region_GuideMe() {
		sCIMira.operationCallback.sendGoToRuntimeEndPoint();
	}
	
	/* Entry action for state 'TTS'. */
	private void entryAction_main_region_GuideMe_folllowMePleaseRepeat_TTS() {
		timer.setTimer(this, 23, 10*1000, false);
		
		sCIHBrain.operationCallback.sendTTS("Follow me please!");
	}
	
	/* Entry action for state 'wait'. */
	private void entryAction_main_region_wait() {
		timer.setTimer(this, 24, 10*1000, false);
	}
	
	/* Entry action for state 'arrived'. */
	private void entryAction_main_region_arrived() {
		sCIHBrain.operationCallback.sendTTS("Arrived. Thanks for your attention! I have done my job. [:-O]");
	}
	
	/* Entry action for state 'DetectionOff'. */
	private void entryAction_main_region_DetectionOff() {
		timer.setTimer(this, 25, 400, false);
		
		sCIFollowMe.operationCallback.sendTrackingOff();
	}
	
	/* Entry action for state 'TrackingOffAndSavePoint'. */
	private void entryAction_main_region_TrackingOffAndSavePoint() {
		sCIFollowMe.operationCallback.sendDetectionOff();
		
		sCIMira.operationCallback.sendSaveRuntimeEndPoint();
	}
	
	/* Entry action for state 'speak'. */
	private void entryAction_main_region_PathBlocked_Blocked_speak() {
		sCIHBrain.operationCallback.sendTTS("Oh no. [:-(] There is an obstacle that I can't avoid. Can you take it away for me and I try it again. [:-|] ");
	}
	
	/* Entry action for state 'gotoendp'. */
	private void entryAction_main_region_PathBlocked_Blocked_gotoendp() {
		sCIMira.operationCallback.sendGoToRuntimeEndPoint();
	}
	
	/* Entry action for state 'blocked2ndTime'. */
	private void entryAction_main_region_blocked2ndTime() {
		sCIHBrain.operationCallback.sendTTS("I tried my best, but I'm not able to reach the destination. I'm sorry.");
	}
	
	/* Entry action for state 'blocked'. */
	private void entryAction_main_region_blocked() {
		timer.setTimer(this, 26, 2*1000, false);
		
		sCIMira.operationCallback.sendInterrupt();
		
		sCIHBrain.operationCallback.sendTTS("[:-(] It seems to be hard to find the way back. But I will try it again. [:-|]");
	}
	
	/* Entry action for state 'nextTry'. */
	private void entryAction_main_region_nextTry() {
		sCIMira.operationCallback.sendGoToGWP(getGWPtemp());
	}
	
	/* Entry action for state 'TTS'. */
	private void entryAction_main_region_ObstacleFollow_ObstacleAvoidingText_TTS() {
		sCIHBrain.operationCallback.sendTTS("There is an obstacle in front of me. I'm trying to avoid it. Please wait for me or slow down.");
	}
	
	/* Entry action for state 'GoOn'. */
	private void entryAction_main_region_ObstacleFollow_ObstacleAvoidingText_GoOn() {
		sCIHBrain.operationCallback.sendTTS("Okay we can go on. [:-)]");
	}
	
	/* Entry action for state 'TTS'. */
	private void entryAction_main_region_ObstacleWayBack_ObstacleAvoidingText_TTS() {
		sCIHBrain.operationCallback.sendTTS("There is an obstacle in front of me. I'm trying to avoid it. Please wait for me or slow down.");
	}
	
	/* Entry action for state 'Bumpered'. */
	private void entryAction_Leonie_Bupered_Or_Emergency_Stop_Bumpered() {
		timer.setTimer(this, 27, 3*1000, false);
		
		sCIHBrain.operationCallback.sendTTS("[:-(]ouch!");
	}
	
	/* Entry action for state 'resetFace'. */
	private void entryAction_Leonie_Bupered_Or_Emergency_Stop_resetFace() {
		sCIHBrain.operationCallback.sendTTS("[:-|] [blush:false]");
	}
	
	/* Entry action for state 'EmergencyStop'. */
	private void entryAction_Leonie_Bupered_Or_Emergency_Stop_EmergencyStop() {
		sCIHBrain.operationCallback.sendTTS("[blush:true] [:-O] What happend?");
	}
	
	/* Entry action for state 'checkEmergency'. */
	private void entryAction_Leonie_Bupered_Or_Emergency_Stop_checkEmergency() {
		timer.setTimer(this, 28, 3*1000, false);
	}
	
	/* Exit action for state 'Detection'. */
	private void exitAction_main_region_Detection() {
		timer.unsetTimer(this, 0);
	}
	
	/* Exit action for state 'Found'. */
	private void exitAction_main_region_Found() {
		timer.unsetTimer(this, 1);
	}
	
	/* Exit action for state 'STToff'. */
	private void exitAction_main_region_StartTracking_WaitingForStopCommand_STToff() {
		timer.unsetTimer(this, 2);
	}
	
	/* Exit action for state 'STTstart'. */
	private void exitAction_main_region_StartTracking_WaitingForStopCommand_STTstart() {
		timer.unsetTimer(this, 3);
	}
	
	/* Exit action for state 'TextReceived'. */
	private void exitAction_main_region_StartTracking_WaitingForStopCommand_TextReceived() {
		timer.unsetTimer(this, 4);
	}
	
	/* Exit action for state 'UTurn1'. */
	private void exitAction_main_region_Lost_WavingToFindPerson_UTurn1() {
		timer.unsetTimer(this, 5);
	}
	
	/* Exit action for state 'Turn'. */
	private void exitAction_main_region_Lost_WavingToFindPerson_Turn() {
		timer.unsetTimer(this, 6);
	}
	
	/* Exit action for state 'DetectionOn'. */
	private void exitAction_main_region_Lost_WavingToFindPerson_DetectionOn() {
		timer.unsetTimer(this, 7);
	}
	
	/* Exit action for state 'UTurn2'. */
	private void exitAction_main_region_Lost_WavingToFindPerson_UTurn2() {
		timer.unsetTimer(this, 8);
	}
	
	/* Exit action for state 'Detection'. */
	private void exitAction_main_region_Lost_WavingToFindPerson_Detection() {
		timer.unsetTimer(this, 9);
	}
	
	/* Exit action for state 'ILostU'. */
	private void exitAction_main_region_Lost_WavingToFindPerson_ILostU() {
		timer.unsetTimer(this, 10);
	}
	
	/* Exit action for state 'StateA'. */
	private void exitAction_main_region_HowCanIHelpYou_main_region_StateA() {
		timer.unsetTimer(this, 11);
	}
	
	/* Exit action for state 'StartSTT'. */
	private void exitAction_main_region_HowCanIHelpYou_main_region_StartSTT() {
		timer.unsetTimer(this, 12);
	}
	
	/* Exit action for state 'TellAnswer'. */
	private void exitAction_main_region_HowCanIHelpYou_main_region_TellAnswer() {
		timer.unsetTimer(this, 13);
	}
	
	/* Exit action for state 'StopSTT'. */
	private void exitAction_main_region_HowCanIHelpYou_main_region_StopSTT() {
		timer.unsetTimer(this, 14);
	}
	
	/* Exit action for state 'wait'. */
	private void exitAction_main_region_HowCanIHelpYou_main_region_wait() {
		timer.unsetTimer(this, 15);
	}
	
	/* Exit action for state 'stateB'. */
	private void exitAction_main_region_HowCanIHelpYou_main_region_stateB() {
		timer.unsetTimer(this, 16);
	}
	
	/* Exit action for state 'ArrivedWaypoint'. */
	private void exitAction_main_region_ArrivedWaypoint() {
		timer.unsetTimer(this, 17);
	}
	
	/* Exit action for state 'StartSTT'. */
	private void exitAction_main_region_StartSTT() {
		timer.unsetTimer(this, 18);
	}
	
	/* Exit action for state 'StopSTT'. */
	private void exitAction_main_region_StopSTT() {
		timer.unsetTimer(this, 19);
	}
	
	/* Exit action for state 'FollowNo'. */
	private void exitAction_main_region_FollowNo() {
		timer.unsetTimer(this, 20);
	}
	
	/* Exit action for state 'LockingForNextOperator'. */
	private void exitAction_main_region_LockingForNextOperator() {
		timer.unsetTimer(this, 21);
	}
	
	/* Exit action for state 'PersonFound'. */
	private void exitAction_main_region_PersonFound() {
		timer.unsetTimer(this, 22);
	}
	
	/* Exit action for state 'TTS'. */
	private void exitAction_main_region_GuideMe_folllowMePleaseRepeat_TTS() {
		timer.unsetTimer(this, 23);
	}
	
	/* Exit action for state 'wait'. */
	private void exitAction_main_region_wait() {
		timer.unsetTimer(this, 24);
	}
	
	/* Exit action for state 'DetectionOff'. */
	private void exitAction_main_region_DetectionOff() {
		timer.unsetTimer(this, 25);
	}
	
	/* Exit action for state 'blocked'. */
	private void exitAction_main_region_blocked() {
		timer.unsetTimer(this, 26);
	}
	
	/* Exit action for state 'Bumpered'. */
	private void exitAction_Leonie_Bupered_Or_Emergency_Stop_Bumpered() {
		timer.unsetTimer(this, 27);
	}
	
	/* Exit action for state 'checkEmergency'. */
	private void exitAction_Leonie_Bupered_Or_Emergency_Stop_checkEmergency() {
		timer.unsetTimer(this, 28);
	}
	
	/* 'default' enter sequence for state Detection */
	private void enterSequence_main_region_Detection_default() {
		entryAction_main_region_Detection();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_Detection;
	}
	
	/* 'default' enter sequence for state NotFound */
	private void enterSequence_main_region_NotFound_default() {
		entryAction_main_region_NotFound();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_NotFound;
	}
	
	/* 'default' enter sequence for state Found */
	private void enterSequence_main_region_Found_default() {
		entryAction_main_region_Found();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_Found;
	}
	
	/* 'default' enter sequence for state StartTracking */
	private void enterSequence_main_region_StartTracking_default() {
		entryAction_main_region_StartTracking();
		enterSequence_main_region_StartTracking_WaitingForStopCommand_default();
	}
	
	/* 'default' enter sequence for state STToff */
	private void enterSequence_main_region_StartTracking_WaitingForStopCommand_STToff_default() {
		entryAction_main_region_StartTracking_WaitingForStopCommand_STToff();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_StartTracking_WaitingForStopCommand_STToff;
	}
	
	/* 'default' enter sequence for state STTstart */
	private void enterSequence_main_region_StartTracking_WaitingForStopCommand_STTstart_default() {
		entryAction_main_region_StartTracking_WaitingForStopCommand_STTstart();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_StartTracking_WaitingForStopCommand_STTstart;
	}
	
	/* 'default' enter sequence for state TextReceived */
	private void enterSequence_main_region_StartTracking_WaitingForStopCommand_TextReceived_default() {
		entryAction_main_region_StartTracking_WaitingForStopCommand_TextReceived();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_StartTracking_WaitingForStopCommand_TextReceived;
	}
	
	/* 'default' enter sequence for state TTS */
	private void enterSequence_main_region_StartTracking_WaitingForStopCommand_TTS_default() {
		entryAction_main_region_StartTracking_WaitingForStopCommand_TTS();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_StartTracking_WaitingForStopCommand_TTS;
	}
	
	/* 'default' enter sequence for state Lost */
	private void enterSequence_main_region_Lost_default() {
		enterSequence_main_region_Lost_WavingToFindPerson_default();
	}
	
	/* 'default' enter sequence for state UTurn1 */
	private void enterSequence_main_region_Lost_WavingToFindPerson_UTurn1_default() {
		entryAction_main_region_Lost_WavingToFindPerson_UTurn1();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_Lost_WavingToFindPerson_UTurn1;
	}
	
	/* 'default' enter sequence for state WaveFound */
	private void enterSequence_main_region_Lost_WavingToFindPerson_WaveFound_default() {
		entryAction_main_region_Lost_WavingToFindPerson_WaveFound();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_Lost_WavingToFindPerson_WaveFound;
	}
	
	/* 'default' enter sequence for state Turn */
	private void enterSequence_main_region_Lost_WavingToFindPerson_Turn_default() {
		entryAction_main_region_Lost_WavingToFindPerson_Turn();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_Lost_WavingToFindPerson_Turn;
	}
	
	/* 'default' enter sequence for state DetectionOn */
	private void enterSequence_main_region_Lost_WavingToFindPerson_DetectionOn_default() {
		entryAction_main_region_Lost_WavingToFindPerson_DetectionOn();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_Lost_WavingToFindPerson_DetectionOn;
	}
	
	/* 'default' enter sequence for state PersonFound */
	private void enterSequence_main_region_Lost_WavingToFindPerson_PersonFound_default() {
		entryAction_main_region_Lost_WavingToFindPerson_PersonFound();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_Lost_WavingToFindPerson_PersonFound;
	}
	
	/* 'default' enter sequence for state ILostYou */
	private void enterSequence_main_region_Lost_WavingToFindPerson_ILostYou_default() {
		entryAction_main_region_Lost_WavingToFindPerson_ILostYou();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_Lost_WavingToFindPerson_ILostYou;
	}
	
	/* 'default' enter sequence for state UTurn2 */
	private void enterSequence_main_region_Lost_WavingToFindPerson_UTurn2_default() {
		entryAction_main_region_Lost_WavingToFindPerson_UTurn2();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_Lost_WavingToFindPerson_UTurn2;
	}
	
	/* 'default' enter sequence for state Detection */
	private void enterSequence_main_region_Lost_WavingToFindPerson_Detection_default() {
		entryAction_main_region_Lost_WavingToFindPerson_Detection();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_Lost_WavingToFindPerson_Detection;
	}
	
	/* 'default' enter sequence for state NotFound */
	private void enterSequence_main_region_Lost_WavingToFindPerson_NotFound_default() {
		entryAction_main_region_Lost_WavingToFindPerson_NotFound();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_Lost_WavingToFindPerson_NotFound;
	}
	
	/* 'default' enter sequence for state ILostU */
	private void enterSequence_main_region_Lost_WavingToFindPerson_ILostU_default() {
		entryAction_main_region_Lost_WavingToFindPerson_ILostU();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_Lost_WavingToFindPerson_ILostU;
	}
	
	/* 'default' enter sequence for state HowCanIHelpYou */
	private void enterSequence_main_region_HowCanIHelpYou_default() {
		enterSequence_main_region_HowCanIHelpYou_main_region_default();
	}
	
	/* 'default' enter sequence for state StateA */
	private void enterSequence_main_region_HowCanIHelpYou_main_region_StateA_default() {
		entryAction_main_region_HowCanIHelpYou_main_region_StateA();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_HowCanIHelpYou_main_region_StateA;
	}
	
	/* 'default' enter sequence for state StartSTT */
	private void enterSequence_main_region_HowCanIHelpYou_main_region_StartSTT_default() {
		entryAction_main_region_HowCanIHelpYou_main_region_StartSTT();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_HowCanIHelpYou_main_region_StartSTT;
	}
	
	/* 'default' enter sequence for state TellAnswer */
	private void enterSequence_main_region_HowCanIHelpYou_main_region_TellAnswer_default() {
		entryAction_main_region_HowCanIHelpYou_main_region_TellAnswer();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_HowCanIHelpYou_main_region_TellAnswer;
	}
	
	/* 'default' enter sequence for state Repeat */
	private void enterSequence_main_region_HowCanIHelpYou_main_region_Repeat_default() {
		entryAction_main_region_HowCanIHelpYou_main_region_Repeat();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_HowCanIHelpYou_main_region_Repeat;
	}
	
	/* 'default' enter sequence for state TellIncomprehensible */
	private void enterSequence_main_region_HowCanIHelpYou_main_region_TellIncomprehensible_default() {
		entryAction_main_region_HowCanIHelpYou_main_region_TellIncomprehensible();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_HowCanIHelpYou_main_region_TellIncomprehensible;
	}
	
	/* 'default' enter sequence for state StopSTT */
	private void enterSequence_main_region_HowCanIHelpYou_main_region_StopSTT_default() {
		entryAction_main_region_HowCanIHelpYou_main_region_StopSTT();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_HowCanIHelpYou_main_region_StopSTT;
	}
	
	/* 'default' enter sequence for state Stop2 */
	private void enterSequence_main_region_HowCanIHelpYou_main_region_Stop2_default() {
		entryAction_main_region_HowCanIHelpYou_main_region_Stop2();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_HowCanIHelpYou_main_region_Stop2;
	}
	
	/* 'default' enter sequence for state wait */
	private void enterSequence_main_region_HowCanIHelpYou_main_region_wait_default() {
		entryAction_main_region_HowCanIHelpYou_main_region_wait();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_HowCanIHelpYou_main_region_wait;
	}
	
	/* 'default' enter sequence for state stateB */
	private void enterSequence_main_region_HowCanIHelpYou_main_region_stateB_default() {
		entryAction_main_region_HowCanIHelpYou_main_region_stateB();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_HowCanIHelpYou_main_region_stateB;
	}
	
	/* 'default' enter sequence for state ArrivedWaypoint */
	private void enterSequence_main_region_ArrivedWaypoint_default() {
		entryAction_main_region_ArrivedWaypoint();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_ArrivedWaypoint;
	}
	
	/* Default enter sequence for state null */
	private void enterSequence_main_region__final__default() {
		nextStateIndex = 0;
		stateVector[0] = State.main_region__final_;
	}
	
	/* 'default' enter sequence for state StartSTT */
	private void enterSequence_main_region_StartSTT_default() {
		entryAction_main_region_StartSTT();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_StartSTT;
	}
	
	/* 'default' enter sequence for state StopSTT */
	private void enterSequence_main_region_StopSTT_default() {
		entryAction_main_region_StopSTT();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_StopSTT;
	}
	
	/* 'default' enter sequence for state FollowYes */
	private void enterSequence_main_region_FollowYes_default() {
		entryAction_main_region_FollowYes();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_FollowYes;
	}
	
	/* 'default' enter sequence for state FollowNo */
	private void enterSequence_main_region_FollowNo_default() {
		entryAction_main_region_FollowNo();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_FollowNo;
	}
	
	/* 'default' enter sequence for state GoTo */
	private void enterSequence_main_region_GoTo_default() {
		enterSequence_main_region_GoTo_goto_default();
	}
	
	/* 'default' enter sequence for state goto */
	private void enterSequence_main_region_GoTo_goto_goto_default() {
		entryAction_main_region_GoTo_goto_goto();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_GoTo_goto_goto;
	}
	
	/* 'default' enter sequence for state goto_fallback */
	private void enterSequence_main_region_GoTo_goto_goto_fallback_default() {
		entryAction_main_region_GoTo_goto_goto_fallback();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_GoTo_goto_goto_fallback;
	}
	
	/* 'default' enter sequence for state gotoWP */
	private void enterSequence_main_region_GoTo_goto_gotoWP_default() {
		nextStateIndex = 0;
		stateVector[0] = State.main_region_GoTo_goto_gotoWP;
	}
	
	/* 'default' enter sequence for state LocationNotFound */
	private void enterSequence_main_region_LocationNotFound_default() {
		entryAction_main_region_LocationNotFound();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_LocationNotFound;
	}
	
	/* 'default' enter sequence for state DetectionOn */
	private void enterSequence_main_region_DetectionOn_default() {
		entryAction_main_region_DetectionOn();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_DetectionOn;
	}
	
	/* 'default' enter sequence for state LockingForNextOperator */
	private void enterSequence_main_region_LockingForNextOperator_default() {
		entryAction_main_region_LockingForNextOperator();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_LockingForNextOperator;
	}
	
	/* 'default' enter sequence for state Turn */
	private void enterSequence_main_region_Turn_default() {
		entryAction_main_region_Turn();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_Turn;
	}
	
	/* 'default' enter sequence for state PersonFound */
	private void enterSequence_main_region_PersonFound_default() {
		entryAction_main_region_PersonFound();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_PersonFound;
	}
	
	/* 'default' enter sequence for state GuideMe */
	private void enterSequence_main_region_GuideMe_default() {
		entryAction_main_region_GuideMe();
		enterSequence_main_region_GuideMe_folllowMePleaseRepeat_default();
	}
	
	/* 'default' enter sequence for state TTS */
	private void enterSequence_main_region_GuideMe_folllowMePleaseRepeat_TTS_default() {
		entryAction_main_region_GuideMe_folllowMePleaseRepeat_TTS();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_GuideMe_folllowMePleaseRepeat_TTS;
	}
	
	/* 'default' enter sequence for state wait */
	private void enterSequence_main_region_wait_default() {
		entryAction_main_region_wait();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_wait;
	}
	
	/* 'default' enter sequence for state arrived */
	private void enterSequence_main_region_arrived_default() {
		entryAction_main_region_arrived();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_arrived;
	}
	
	/* 'default' enter sequence for state DetectionOff */
	private void enterSequence_main_region_DetectionOff_default() {
		entryAction_main_region_DetectionOff();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_DetectionOff;
	}
	
	/* 'default' enter sequence for state TrackingOffAndSavePoint */
	private void enterSequence_main_region_TrackingOffAndSavePoint_default() {
		entryAction_main_region_TrackingOffAndSavePoint();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_TrackingOffAndSavePoint;
	}
	
	/* 'default' enter sequence for state PathBlocked */
	private void enterSequence_main_region_PathBlocked_default() {
		enterSequence_main_region_PathBlocked_Blocked_default();
	}
	
	/* 'default' enter sequence for state speak */
	private void enterSequence_main_region_PathBlocked_Blocked_speak_default() {
		entryAction_main_region_PathBlocked_Blocked_speak();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_PathBlocked_Blocked_speak;
	}
	
	/* 'default' enter sequence for state gotoendp */
	private void enterSequence_main_region_PathBlocked_Blocked_gotoendp_default() {
		entryAction_main_region_PathBlocked_Blocked_gotoendp();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_PathBlocked_Blocked_gotoendp;
	}
	
	/* 'default' enter sequence for state blocked2ndTime */
	private void enterSequence_main_region_blocked2ndTime_default() {
		entryAction_main_region_blocked2ndTime();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_blocked2ndTime;
	}
	
	/* 'default' enter sequence for state blocked */
	private void enterSequence_main_region_blocked_default() {
		entryAction_main_region_blocked();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_blocked;
	}
	
	/* 'default' enter sequence for state nextTry */
	private void enterSequence_main_region_nextTry_default() {
		entryAction_main_region_nextTry();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_nextTry;
	}
	
	/* 'default' enter sequence for state arrived1 */
	private void enterSequence_main_region_arrived1_default() {
		nextStateIndex = 0;
		stateVector[0] = State.main_region_arrived1;
	}
	
	/* 'default' enter sequence for state ObstacleFollow */
	private void enterSequence_main_region_ObstacleFollow_default() {
		enterSequence_main_region_ObstacleFollow_ObstacleAvoidingText_default();
	}
	
	/* 'default' enter sequence for state TTS */
	private void enterSequence_main_region_ObstacleFollow_ObstacleAvoidingText_TTS_default() {
		entryAction_main_region_ObstacleFollow_ObstacleAvoidingText_TTS();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_ObstacleFollow_ObstacleAvoidingText_TTS;
	}
	
	/* 'default' enter sequence for state WaitForAvoiding */
	private void enterSequence_main_region_ObstacleFollow_ObstacleAvoidingText_WaitForAvoiding_default() {
		nextStateIndex = 0;
		stateVector[0] = State.main_region_ObstacleFollow_ObstacleAvoidingText_WaitForAvoiding;
	}
	
	/* 'default' enter sequence for state GoOn */
	private void enterSequence_main_region_ObstacleFollow_ObstacleAvoidingText_GoOn_default() {
		entryAction_main_region_ObstacleFollow_ObstacleAvoidingText_GoOn();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_ObstacleFollow_ObstacleAvoidingText_GoOn;
	}
	
	/* 'default' enter sequence for state ObstacleWayBack */
	private void enterSequence_main_region_ObstacleWayBack_default() {
		enterSequence_main_region_ObstacleWayBack_ObstacleAvoidingText_default();
	}
	
	/* 'default' enter sequence for state TTS */
	private void enterSequence_main_region_ObstacleWayBack_ObstacleAvoidingText_TTS_default() {
		entryAction_main_region_ObstacleWayBack_ObstacleAvoidingText_TTS();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_ObstacleWayBack_ObstacleAvoidingText_TTS;
	}
	
	/* 'default' enter sequence for state waitForEvent */
	private void enterSequence_Leonie_Bupered_Or_Emergency_Stop_waitForEvent_default() {
		nextStateIndex = 1;
		stateVector[1] = State.leonie_Bupered_Or_Emergency_Stop_waitForEvent;
	}
	
	/* 'default' enter sequence for state Bumpered */
	private void enterSequence_Leonie_Bupered_Or_Emergency_Stop_Bumpered_default() {
		entryAction_Leonie_Bupered_Or_Emergency_Stop_Bumpered();
		nextStateIndex = 1;
		stateVector[1] = State.leonie_Bupered_Or_Emergency_Stop_Bumpered;
	}
	
	/* 'default' enter sequence for state resetFace */
	private void enterSequence_Leonie_Bupered_Or_Emergency_Stop_resetFace_default() {
		entryAction_Leonie_Bupered_Or_Emergency_Stop_resetFace();
		nextStateIndex = 1;
		stateVector[1] = State.leonie_Bupered_Or_Emergency_Stop_resetFace;
	}
	
	/* 'default' enter sequence for state EmergencyStop */
	private void enterSequence_Leonie_Bupered_Or_Emergency_Stop_EmergencyStop_default() {
		entryAction_Leonie_Bupered_Or_Emergency_Stop_EmergencyStop();
		nextStateIndex = 1;
		stateVector[1] = State.leonie_Bupered_Or_Emergency_Stop_EmergencyStop;
	}
	
	/* 'default' enter sequence for state checkEmergency */
	private void enterSequence_Leonie_Bupered_Or_Emergency_Stop_checkEmergency_default() {
		entryAction_Leonie_Bupered_Or_Emergency_Stop_checkEmergency();
		nextStateIndex = 1;
		stateVector[1] = State.leonie_Bupered_Or_Emergency_Stop_checkEmergency;
	}
	
	/* 'default' enter sequence for region main region */
	private void enterSequence_main_region_default() {
		react_main_region__entry_Default();
	}
	
	/* 'default' enter sequence for region WaitingForStopCommand */
	private void enterSequence_main_region_StartTracking_WaitingForStopCommand_default() {
		react_main_region_StartTracking_WaitingForStopCommand__entry_Default();
	}
	
	/* 'default' enter sequence for region WavingToFindPerson */
	private void enterSequence_main_region_Lost_WavingToFindPerson_default() {
		react_main_region_Lost_WavingToFindPerson__entry_Default();
	}
	
	/* 'default' enter sequence for region main region */
	private void enterSequence_main_region_HowCanIHelpYou_main_region_default() {
		react_main_region_HowCanIHelpYou_main_region__entry_Default();
	}
	
	/* 'default' enter sequence for region goto */
	private void enterSequence_main_region_GoTo_goto_default() {
		react_main_region_GoTo_goto__entry_Default();
	}
	
	/* 'default' enter sequence for region folllowMePleaseRepeat */
	private void enterSequence_main_region_GuideMe_folllowMePleaseRepeat_default() {
		react_main_region_GuideMe_folllowMePleaseRepeat__entry_Default();
	}
	
	/* 'default' enter sequence for region Blocked */
	private void enterSequence_main_region_PathBlocked_Blocked_default() {
		react_main_region_PathBlocked_Blocked__entry_Default();
	}
	
	/* 'default' enter sequence for region ObstacleAvoidingText */
	private void enterSequence_main_region_ObstacleFollow_ObstacleAvoidingText_default() {
		react_main_region_ObstacleFollow_ObstacleAvoidingText__entry_Default();
	}
	
	/* 'default' enter sequence for region ObstacleAvoidingText */
	private void enterSequence_main_region_ObstacleWayBack_ObstacleAvoidingText_default() {
		react_main_region_ObstacleWayBack_ObstacleAvoidingText__entry_Default();
	}
	
	/* 'default' enter sequence for region Leonie Bupered Or Emergency Stop */
	private void enterSequence_Leonie_Bupered_Or_Emergency_Stop_default() {
		react_Leonie_Bupered_Or_Emergency_Stop__entry_Default();
	}
	
	/* Default exit sequence for state Detection */
	private void exitSequence_main_region_Detection() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
		
		exitAction_main_region_Detection();
	}
	
	/* Default exit sequence for state NotFound */
	private void exitSequence_main_region_NotFound() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state Found */
	private void exitSequence_main_region_Found() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
		
		exitAction_main_region_Found();
	}
	
	/* Default exit sequence for state StartTracking */
	private void exitSequence_main_region_StartTracking() {
		exitSequence_main_region_StartTracking_WaitingForStopCommand();
	}
	
	/* Default exit sequence for state STToff */
	private void exitSequence_main_region_StartTracking_WaitingForStopCommand_STToff() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
		
		exitAction_main_region_StartTracking_WaitingForStopCommand_STToff();
	}
	
	/* Default exit sequence for state STTstart */
	private void exitSequence_main_region_StartTracking_WaitingForStopCommand_STTstart() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
		
		exitAction_main_region_StartTracking_WaitingForStopCommand_STTstart();
	}
	
	/* Default exit sequence for state TextReceived */
	private void exitSequence_main_region_StartTracking_WaitingForStopCommand_TextReceived() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
		
		exitAction_main_region_StartTracking_WaitingForStopCommand_TextReceived();
	}
	
	/* Default exit sequence for state TTS */
	private void exitSequence_main_region_StartTracking_WaitingForStopCommand_TTS() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state Lost */
	private void exitSequence_main_region_Lost() {
		exitSequence_main_region_Lost_WavingToFindPerson();
	}
	
	/* Default exit sequence for state UTurn1 */
	private void exitSequence_main_region_Lost_WavingToFindPerson_UTurn1() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
		
		exitAction_main_region_Lost_WavingToFindPerson_UTurn1();
	}
	
	/* Default exit sequence for state WaveFound */
	private void exitSequence_main_region_Lost_WavingToFindPerson_WaveFound() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state Turn */
	private void exitSequence_main_region_Lost_WavingToFindPerson_Turn() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
		
		exitAction_main_region_Lost_WavingToFindPerson_Turn();
	}
	
	/* Default exit sequence for state DetectionOn */
	private void exitSequence_main_region_Lost_WavingToFindPerson_DetectionOn() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
		
		exitAction_main_region_Lost_WavingToFindPerson_DetectionOn();
	}
	
	/* Default exit sequence for state PersonFound */
	private void exitSequence_main_region_Lost_WavingToFindPerson_PersonFound() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state ILostYou */
	private void exitSequence_main_region_Lost_WavingToFindPerson_ILostYou() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state UTurn2 */
	private void exitSequence_main_region_Lost_WavingToFindPerson_UTurn2() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
		
		exitAction_main_region_Lost_WavingToFindPerson_UTurn2();
	}
	
	/* Default exit sequence for state Detection */
	private void exitSequence_main_region_Lost_WavingToFindPerson_Detection() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
		
		exitAction_main_region_Lost_WavingToFindPerson_Detection();
	}
	
	/* Default exit sequence for state NotFound */
	private void exitSequence_main_region_Lost_WavingToFindPerson_NotFound() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state ILostU */
	private void exitSequence_main_region_Lost_WavingToFindPerson_ILostU() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
		
		exitAction_main_region_Lost_WavingToFindPerson_ILostU();
	}
	
	/* Default exit sequence for state HowCanIHelpYou */
	private void exitSequence_main_region_HowCanIHelpYou() {
		exitSequence_main_region_HowCanIHelpYou_main_region();
	}
	
	/* Default exit sequence for state StateA */
	private void exitSequence_main_region_HowCanIHelpYou_main_region_StateA() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
		
		exitAction_main_region_HowCanIHelpYou_main_region_StateA();
	}
	
	/* Default exit sequence for state StartSTT */
	private void exitSequence_main_region_HowCanIHelpYou_main_region_StartSTT() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
		
		exitAction_main_region_HowCanIHelpYou_main_region_StartSTT();
	}
	
	/* Default exit sequence for state TellAnswer */
	private void exitSequence_main_region_HowCanIHelpYou_main_region_TellAnswer() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
		
		exitAction_main_region_HowCanIHelpYou_main_region_TellAnswer();
	}
	
	/* Default exit sequence for state Repeat */
	private void exitSequence_main_region_HowCanIHelpYou_main_region_Repeat() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state TellIncomprehensible */
	private void exitSequence_main_region_HowCanIHelpYou_main_region_TellIncomprehensible() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state StopSTT */
	private void exitSequence_main_region_HowCanIHelpYou_main_region_StopSTT() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
		
		exitAction_main_region_HowCanIHelpYou_main_region_StopSTT();
	}
	
	/* Default exit sequence for state Stop2 */
	private void exitSequence_main_region_HowCanIHelpYou_main_region_Stop2() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state wait */
	private void exitSequence_main_region_HowCanIHelpYou_main_region_wait() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
		
		exitAction_main_region_HowCanIHelpYou_main_region_wait();
	}
	
	/* Default exit sequence for state stateB */
	private void exitSequence_main_region_HowCanIHelpYou_main_region_stateB() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
		
		exitAction_main_region_HowCanIHelpYou_main_region_stateB();
	}
	
	/* Default exit sequence for state ArrivedWaypoint */
	private void exitSequence_main_region_ArrivedWaypoint() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
		
		exitAction_main_region_ArrivedWaypoint();
	}
	
	/* Default exit sequence for final state. */
	private void exitSequence_main_region__final_() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state StartSTT */
	private void exitSequence_main_region_StartSTT() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
		
		exitAction_main_region_StartSTT();
	}
	
	/* Default exit sequence for state StopSTT */
	private void exitSequence_main_region_StopSTT() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
		
		exitAction_main_region_StopSTT();
	}
	
	/* Default exit sequence for state FollowYes */
	private void exitSequence_main_region_FollowYes() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state FollowNo */
	private void exitSequence_main_region_FollowNo() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
		
		exitAction_main_region_FollowNo();
	}
	
	/* Default exit sequence for state GoTo */
	private void exitSequence_main_region_GoTo() {
		exitSequence_main_region_GoTo_goto();
	}
	
	/* Default exit sequence for state goto */
	private void exitSequence_main_region_GoTo_goto_goto() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state goto_fallback */
	private void exitSequence_main_region_GoTo_goto_goto_fallback() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state gotoWP */
	private void exitSequence_main_region_GoTo_goto_gotoWP() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state LocationNotFound */
	private void exitSequence_main_region_LocationNotFound() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state DetectionOn */
	private void exitSequence_main_region_DetectionOn() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state LockingForNextOperator */
	private void exitSequence_main_region_LockingForNextOperator() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
		
		exitAction_main_region_LockingForNextOperator();
	}
	
	/* Default exit sequence for state Turn */
	private void exitSequence_main_region_Turn() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state PersonFound */
	private void exitSequence_main_region_PersonFound() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
		
		exitAction_main_region_PersonFound();
	}
	
	/* Default exit sequence for state GuideMe */
	private void exitSequence_main_region_GuideMe() {
		exitSequence_main_region_GuideMe_folllowMePleaseRepeat();
	}
	
	/* Default exit sequence for state TTS */
	private void exitSequence_main_region_GuideMe_folllowMePleaseRepeat_TTS() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
		
		exitAction_main_region_GuideMe_folllowMePleaseRepeat_TTS();
	}
	
	/* Default exit sequence for state wait */
	private void exitSequence_main_region_wait() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
		
		exitAction_main_region_wait();
	}
	
	/* Default exit sequence for state arrived */
	private void exitSequence_main_region_arrived() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state DetectionOff */
	private void exitSequence_main_region_DetectionOff() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
		
		exitAction_main_region_DetectionOff();
	}
	
	/* Default exit sequence for state TrackingOffAndSavePoint */
	private void exitSequence_main_region_TrackingOffAndSavePoint() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state PathBlocked */
	private void exitSequence_main_region_PathBlocked() {
		exitSequence_main_region_PathBlocked_Blocked();
	}
	
	/* Default exit sequence for state speak */
	private void exitSequence_main_region_PathBlocked_Blocked_speak() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state gotoendp */
	private void exitSequence_main_region_PathBlocked_Blocked_gotoendp() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state blocked2ndTime */
	private void exitSequence_main_region_blocked2ndTime() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state blocked */
	private void exitSequence_main_region_blocked() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
		
		exitAction_main_region_blocked();
	}
	
	/* Default exit sequence for state nextTry */
	private void exitSequence_main_region_nextTry() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state arrived1 */
	private void exitSequence_main_region_arrived1() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state ObstacleFollow */
	private void exitSequence_main_region_ObstacleFollow() {
		exitSequence_main_region_ObstacleFollow_ObstacleAvoidingText();
	}
	
	/* Default exit sequence for state TTS */
	private void exitSequence_main_region_ObstacleFollow_ObstacleAvoidingText_TTS() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state WaitForAvoiding */
	private void exitSequence_main_region_ObstacleFollow_ObstacleAvoidingText_WaitForAvoiding() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state GoOn */
	private void exitSequence_main_region_ObstacleFollow_ObstacleAvoidingText_GoOn() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state ObstacleWayBack */
	private void exitSequence_main_region_ObstacleWayBack() {
		exitSequence_main_region_ObstacleWayBack_ObstacleAvoidingText();
	}
	
	/* Default exit sequence for state TTS */
	private void exitSequence_main_region_ObstacleWayBack_ObstacleAvoidingText_TTS() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state waitForEvent */
	private void exitSequence_Leonie_Bupered_Or_Emergency_Stop_waitForEvent() {
		nextStateIndex = 1;
		stateVector[1] = State.$NullState$;
	}
	
	/* Default exit sequence for state Bumpered */
	private void exitSequence_Leonie_Bupered_Or_Emergency_Stop_Bumpered() {
		nextStateIndex = 1;
		stateVector[1] = State.$NullState$;
		
		exitAction_Leonie_Bupered_Or_Emergency_Stop_Bumpered();
	}
	
	/* Default exit sequence for state resetFace */
	private void exitSequence_Leonie_Bupered_Or_Emergency_Stop_resetFace() {
		nextStateIndex = 1;
		stateVector[1] = State.$NullState$;
	}
	
	/* Default exit sequence for state EmergencyStop */
	private void exitSequence_Leonie_Bupered_Or_Emergency_Stop_EmergencyStop() {
		nextStateIndex = 1;
		stateVector[1] = State.$NullState$;
	}
	
	/* Default exit sequence for state checkEmergency */
	private void exitSequence_Leonie_Bupered_Or_Emergency_Stop_checkEmergency() {
		nextStateIndex = 1;
		stateVector[1] = State.$NullState$;
		
		exitAction_Leonie_Bupered_Or_Emergency_Stop_checkEmergency();
	}
	
	/* Default exit sequence for region main region */
	private void exitSequence_main_region() {
		switch (stateVector[0]) {
		case main_region_Detection:
			exitSequence_main_region_Detection();
			break;
		case main_region_NotFound:
			exitSequence_main_region_NotFound();
			break;
		case main_region_Found:
			exitSequence_main_region_Found();
			break;
		case main_region_StartTracking_WaitingForStopCommand_STToff:
			exitSequence_main_region_StartTracking_WaitingForStopCommand_STToff();
			break;
		case main_region_StartTracking_WaitingForStopCommand_STTstart:
			exitSequence_main_region_StartTracking_WaitingForStopCommand_STTstart();
			break;
		case main_region_StartTracking_WaitingForStopCommand_TextReceived:
			exitSequence_main_region_StartTracking_WaitingForStopCommand_TextReceived();
			break;
		case main_region_StartTracking_WaitingForStopCommand_TTS:
			exitSequence_main_region_StartTracking_WaitingForStopCommand_TTS();
			break;
		case main_region_Lost_WavingToFindPerson_UTurn1:
			exitSequence_main_region_Lost_WavingToFindPerson_UTurn1();
			break;
		case main_region_Lost_WavingToFindPerson_WaveFound:
			exitSequence_main_region_Lost_WavingToFindPerson_WaveFound();
			break;
		case main_region_Lost_WavingToFindPerson_Turn:
			exitSequence_main_region_Lost_WavingToFindPerson_Turn();
			break;
		case main_region_Lost_WavingToFindPerson_DetectionOn:
			exitSequence_main_region_Lost_WavingToFindPerson_DetectionOn();
			break;
		case main_region_Lost_WavingToFindPerson_PersonFound:
			exitSequence_main_region_Lost_WavingToFindPerson_PersonFound();
			break;
		case main_region_Lost_WavingToFindPerson_ILostYou:
			exitSequence_main_region_Lost_WavingToFindPerson_ILostYou();
			break;
		case main_region_Lost_WavingToFindPerson_UTurn2:
			exitSequence_main_region_Lost_WavingToFindPerson_UTurn2();
			break;
		case main_region_Lost_WavingToFindPerson_Detection:
			exitSequence_main_region_Lost_WavingToFindPerson_Detection();
			break;
		case main_region_Lost_WavingToFindPerson_NotFound:
			exitSequence_main_region_Lost_WavingToFindPerson_NotFound();
			break;
		case main_region_Lost_WavingToFindPerson_ILostU:
			exitSequence_main_region_Lost_WavingToFindPerson_ILostU();
			break;
		case main_region_HowCanIHelpYou_main_region_StateA:
			exitSequence_main_region_HowCanIHelpYou_main_region_StateA();
			break;
		case main_region_HowCanIHelpYou_main_region_StartSTT:
			exitSequence_main_region_HowCanIHelpYou_main_region_StartSTT();
			break;
		case main_region_HowCanIHelpYou_main_region_TellAnswer:
			exitSequence_main_region_HowCanIHelpYou_main_region_TellAnswer();
			break;
		case main_region_HowCanIHelpYou_main_region_Repeat:
			exitSequence_main_region_HowCanIHelpYou_main_region_Repeat();
			break;
		case main_region_HowCanIHelpYou_main_region_TellIncomprehensible:
			exitSequence_main_region_HowCanIHelpYou_main_region_TellIncomprehensible();
			break;
		case main_region_HowCanIHelpYou_main_region_StopSTT:
			exitSequence_main_region_HowCanIHelpYou_main_region_StopSTT();
			break;
		case main_region_HowCanIHelpYou_main_region_Stop2:
			exitSequence_main_region_HowCanIHelpYou_main_region_Stop2();
			break;
		case main_region_HowCanIHelpYou_main_region_wait:
			exitSequence_main_region_HowCanIHelpYou_main_region_wait();
			break;
		case main_region_HowCanIHelpYou_main_region_stateB:
			exitSequence_main_region_HowCanIHelpYou_main_region_stateB();
			break;
		case main_region_ArrivedWaypoint:
			exitSequence_main_region_ArrivedWaypoint();
			break;
		case main_region__final_:
			exitSequence_main_region__final_();
			break;
		case main_region_StartSTT:
			exitSequence_main_region_StartSTT();
			break;
		case main_region_StopSTT:
			exitSequence_main_region_StopSTT();
			break;
		case main_region_FollowYes:
			exitSequence_main_region_FollowYes();
			break;
		case main_region_FollowNo:
			exitSequence_main_region_FollowNo();
			break;
		case main_region_GoTo_goto_goto:
			exitSequence_main_region_GoTo_goto_goto();
			break;
		case main_region_GoTo_goto_goto_fallback:
			exitSequence_main_region_GoTo_goto_goto_fallback();
			break;
		case main_region_GoTo_goto_gotoWP:
			exitSequence_main_region_GoTo_goto_gotoWP();
			break;
		case main_region_LocationNotFound:
			exitSequence_main_region_LocationNotFound();
			break;
		case main_region_DetectionOn:
			exitSequence_main_region_DetectionOn();
			break;
		case main_region_LockingForNextOperator:
			exitSequence_main_region_LockingForNextOperator();
			break;
		case main_region_Turn:
			exitSequence_main_region_Turn();
			break;
		case main_region_PersonFound:
			exitSequence_main_region_PersonFound();
			break;
		case main_region_GuideMe_folllowMePleaseRepeat_TTS:
			exitSequence_main_region_GuideMe_folllowMePleaseRepeat_TTS();
			break;
		case main_region_wait:
			exitSequence_main_region_wait();
			break;
		case main_region_arrived:
			exitSequence_main_region_arrived();
			break;
		case main_region_DetectionOff:
			exitSequence_main_region_DetectionOff();
			break;
		case main_region_TrackingOffAndSavePoint:
			exitSequence_main_region_TrackingOffAndSavePoint();
			break;
		case main_region_PathBlocked_Blocked_speak:
			exitSequence_main_region_PathBlocked_Blocked_speak();
			break;
		case main_region_PathBlocked_Blocked_gotoendp:
			exitSequence_main_region_PathBlocked_Blocked_gotoendp();
			break;
		case main_region_blocked2ndTime:
			exitSequence_main_region_blocked2ndTime();
			break;
		case main_region_blocked:
			exitSequence_main_region_blocked();
			break;
		case main_region_nextTry:
			exitSequence_main_region_nextTry();
			break;
		case main_region_arrived1:
			exitSequence_main_region_arrived1();
			break;
		case main_region_ObstacleFollow_ObstacleAvoidingText_TTS:
			exitSequence_main_region_ObstacleFollow_ObstacleAvoidingText_TTS();
			break;
		case main_region_ObstacleFollow_ObstacleAvoidingText_WaitForAvoiding:
			exitSequence_main_region_ObstacleFollow_ObstacleAvoidingText_WaitForAvoiding();
			break;
		case main_region_ObstacleFollow_ObstacleAvoidingText_GoOn:
			exitSequence_main_region_ObstacleFollow_ObstacleAvoidingText_GoOn();
			break;
		case main_region_ObstacleWayBack_ObstacleAvoidingText_TTS:
			exitSequence_main_region_ObstacleWayBack_ObstacleAvoidingText_TTS();
			break;
		default:
			break;
		}
	}
	
	/* Default exit sequence for region WaitingForStopCommand */
	private void exitSequence_main_region_StartTracking_WaitingForStopCommand() {
		switch (stateVector[0]) {
		case main_region_StartTracking_WaitingForStopCommand_STToff:
			exitSequence_main_region_StartTracking_WaitingForStopCommand_STToff();
			break;
		case main_region_StartTracking_WaitingForStopCommand_STTstart:
			exitSequence_main_region_StartTracking_WaitingForStopCommand_STTstart();
			break;
		case main_region_StartTracking_WaitingForStopCommand_TextReceived:
			exitSequence_main_region_StartTracking_WaitingForStopCommand_TextReceived();
			break;
		case main_region_StartTracking_WaitingForStopCommand_TTS:
			exitSequence_main_region_StartTracking_WaitingForStopCommand_TTS();
			break;
		default:
			break;
		}
	}
	
	/* Default exit sequence for region WavingToFindPerson */
	private void exitSequence_main_region_Lost_WavingToFindPerson() {
		switch (stateVector[0]) {
		case main_region_Lost_WavingToFindPerson_UTurn1:
			exitSequence_main_region_Lost_WavingToFindPerson_UTurn1();
			break;
		case main_region_Lost_WavingToFindPerson_WaveFound:
			exitSequence_main_region_Lost_WavingToFindPerson_WaveFound();
			break;
		case main_region_Lost_WavingToFindPerson_Turn:
			exitSequence_main_region_Lost_WavingToFindPerson_Turn();
			break;
		case main_region_Lost_WavingToFindPerson_DetectionOn:
			exitSequence_main_region_Lost_WavingToFindPerson_DetectionOn();
			break;
		case main_region_Lost_WavingToFindPerson_PersonFound:
			exitSequence_main_region_Lost_WavingToFindPerson_PersonFound();
			break;
		case main_region_Lost_WavingToFindPerson_ILostYou:
			exitSequence_main_region_Lost_WavingToFindPerson_ILostYou();
			break;
		case main_region_Lost_WavingToFindPerson_UTurn2:
			exitSequence_main_region_Lost_WavingToFindPerson_UTurn2();
			break;
		case main_region_Lost_WavingToFindPerson_Detection:
			exitSequence_main_region_Lost_WavingToFindPerson_Detection();
			break;
		case main_region_Lost_WavingToFindPerson_NotFound:
			exitSequence_main_region_Lost_WavingToFindPerson_NotFound();
			break;
		case main_region_Lost_WavingToFindPerson_ILostU:
			exitSequence_main_region_Lost_WavingToFindPerson_ILostU();
			break;
		default:
			break;
		}
	}
	
	/* Default exit sequence for region main region */
	private void exitSequence_main_region_HowCanIHelpYou_main_region() {
		switch (stateVector[0]) {
		case main_region_HowCanIHelpYou_main_region_StateA:
			exitSequence_main_region_HowCanIHelpYou_main_region_StateA();
			break;
		case main_region_HowCanIHelpYou_main_region_StartSTT:
			exitSequence_main_region_HowCanIHelpYou_main_region_StartSTT();
			break;
		case main_region_HowCanIHelpYou_main_region_TellAnswer:
			exitSequence_main_region_HowCanIHelpYou_main_region_TellAnswer();
			break;
		case main_region_HowCanIHelpYou_main_region_Repeat:
			exitSequence_main_region_HowCanIHelpYou_main_region_Repeat();
			break;
		case main_region_HowCanIHelpYou_main_region_TellIncomprehensible:
			exitSequence_main_region_HowCanIHelpYou_main_region_TellIncomprehensible();
			break;
		case main_region_HowCanIHelpYou_main_region_StopSTT:
			exitSequence_main_region_HowCanIHelpYou_main_region_StopSTT();
			break;
		case main_region_HowCanIHelpYou_main_region_Stop2:
			exitSequence_main_region_HowCanIHelpYou_main_region_Stop2();
			break;
		case main_region_HowCanIHelpYou_main_region_wait:
			exitSequence_main_region_HowCanIHelpYou_main_region_wait();
			break;
		case main_region_HowCanIHelpYou_main_region_stateB:
			exitSequence_main_region_HowCanIHelpYou_main_region_stateB();
			break;
		default:
			break;
		}
	}
	
	/* Default exit sequence for region goto */
	private void exitSequence_main_region_GoTo_goto() {
		switch (stateVector[0]) {
		case main_region_GoTo_goto_goto:
			exitSequence_main_region_GoTo_goto_goto();
			break;
		case main_region_GoTo_goto_goto_fallback:
			exitSequence_main_region_GoTo_goto_goto_fallback();
			break;
		case main_region_GoTo_goto_gotoWP:
			exitSequence_main_region_GoTo_goto_gotoWP();
			break;
		default:
			break;
		}
	}
	
	/* Default exit sequence for region folllowMePleaseRepeat */
	private void exitSequence_main_region_GuideMe_folllowMePleaseRepeat() {
		switch (stateVector[0]) {
		case main_region_GuideMe_folllowMePleaseRepeat_TTS:
			exitSequence_main_region_GuideMe_folllowMePleaseRepeat_TTS();
			break;
		default:
			break;
		}
	}
	
	/* Default exit sequence for region Blocked */
	private void exitSequence_main_region_PathBlocked_Blocked() {
		switch (stateVector[0]) {
		case main_region_PathBlocked_Blocked_speak:
			exitSequence_main_region_PathBlocked_Blocked_speak();
			break;
		case main_region_PathBlocked_Blocked_gotoendp:
			exitSequence_main_region_PathBlocked_Blocked_gotoendp();
			break;
		default:
			break;
		}
	}
	
	/* Default exit sequence for region ObstacleAvoidingText */
	private void exitSequence_main_region_ObstacleFollow_ObstacleAvoidingText() {
		switch (stateVector[0]) {
		case main_region_ObstacleFollow_ObstacleAvoidingText_TTS:
			exitSequence_main_region_ObstacleFollow_ObstacleAvoidingText_TTS();
			break;
		case main_region_ObstacleFollow_ObstacleAvoidingText_WaitForAvoiding:
			exitSequence_main_region_ObstacleFollow_ObstacleAvoidingText_WaitForAvoiding();
			break;
		case main_region_ObstacleFollow_ObstacleAvoidingText_GoOn:
			exitSequence_main_region_ObstacleFollow_ObstacleAvoidingText_GoOn();
			break;
		default:
			break;
		}
	}
	
	/* Default exit sequence for region ObstacleAvoidingText */
	private void exitSequence_main_region_ObstacleWayBack_ObstacleAvoidingText() {
		switch (stateVector[0]) {
		case main_region_ObstacleWayBack_ObstacleAvoidingText_TTS:
			exitSequence_main_region_ObstacleWayBack_ObstacleAvoidingText_TTS();
			break;
		default:
			break;
		}
	}
	
	/* Default exit sequence for region Leonie Bupered Or Emergency Stop */
	private void exitSequence_Leonie_Bupered_Or_Emergency_Stop() {
		switch (stateVector[1]) {
		case leonie_Bupered_Or_Emergency_Stop_waitForEvent:
			exitSequence_Leonie_Bupered_Or_Emergency_Stop_waitForEvent();
			break;
		case leonie_Bupered_Or_Emergency_Stop_Bumpered:
			exitSequence_Leonie_Bupered_Or_Emergency_Stop_Bumpered();
			break;
		case leonie_Bupered_Or_Emergency_Stop_resetFace:
			exitSequence_Leonie_Bupered_Or_Emergency_Stop_resetFace();
			break;
		case leonie_Bupered_Or_Emergency_Stop_EmergencyStop:
			exitSequence_Leonie_Bupered_Or_Emergency_Stop_EmergencyStop();
			break;
		case leonie_Bupered_Or_Emergency_Stop_checkEmergency:
			exitSequence_Leonie_Bupered_Or_Emergency_Stop_checkEmergency();
			break;
		default:
			break;
		}
	}
	
	/* The reactions of state Detection. */
	private void react_main_region_Detection() {
		if (check_main_region_Detection_tr0_tr0()) {
			effect_main_region_Detection_tr0();
		} else {
			if (check_main_region_Detection_tr1_tr1()) {
				effect_main_region_Detection_tr1();
			} else {
				if (check_main_region_Detection_tr2_tr2()) {
					effect_main_region_Detection_tr2();
				}
			}
		}
	}
	
	/* The reactions of state NotFound. */
	private void react_main_region_NotFound() {
		effect_main_region_NotFound_tr0();
	}
	
	/* The reactions of state Found. */
	private void react_main_region_Found() {
		if (check_main_region_Found_tr0_tr0()) {
			effect_main_region_Found_tr0();
		} else {
			if (check_main_region_Found_tr1_tr1()) {
				effect_main_region_Found_tr1();
			}
		}
	}
	
	/* The reactions of state STToff. */
	private void react_main_region_StartTracking_WaitingForStopCommand_STToff() {
		if (check_main_region_StartTracking_tr0_tr0()) {
			effect_main_region_StartTracking_tr0();
		} else {
			if (check_main_region_StartTracking_tr2_tr2()) {
				effect_main_region_StartTracking_tr2();
			} else {
				if (check_main_region_StartTracking_WaitingForStopCommand_STToff_tr0_tr0()) {
					effect_main_region_StartTracking_WaitingForStopCommand_STToff_tr0();
				} else {
					if (check_main_region_StartTracking_WaitingForStopCommand_STToff_tr1_tr1()) {
						effect_main_region_StartTracking_WaitingForStopCommand_STToff_tr1();
					} else {
						if (check_main_region_StartTracking_WaitingForStopCommand_STToff_tr2_tr2()) {
							effect_main_region_StartTracking_WaitingForStopCommand_STToff_tr2();
						}
					}
				}
			}
		}
	}
	
	/* The reactions of state STTstart. */
	private void react_main_region_StartTracking_WaitingForStopCommand_STTstart() {
		if (check_main_region_StartTracking_tr0_tr0()) {
			effect_main_region_StartTracking_tr0();
		} else {
			if (check_main_region_StartTracking_tr2_tr2()) {
				effect_main_region_StartTracking_tr2();
			} else {
				if (check_main_region_StartTracking_WaitingForStopCommand_STTstart_tr0_tr0()) {
					effect_main_region_StartTracking_WaitingForStopCommand_STTstart_tr0();
				} else {
					if (check_main_region_StartTracking_WaitingForStopCommand_STTstart_tr1_tr1()) {
						effect_main_region_StartTracking_WaitingForStopCommand_STTstart_tr1();
					} else {
						if (check_main_region_StartTracking_WaitingForStopCommand_STTstart_tr2_tr2()) {
							effect_main_region_StartTracking_WaitingForStopCommand_STTstart_tr2();
						}
					}
				}
			}
		}
	}
	
	/* The reactions of state TextReceived. */
	private void react_main_region_StartTracking_WaitingForStopCommand_TextReceived() {
		if (check_main_region_StartTracking_tr0_tr0()) {
			effect_main_region_StartTracking_tr0();
		} else {
			if (check_main_region_StartTracking_tr2_tr2()) {
				effect_main_region_StartTracking_tr2();
			} else {
				if (check_main_region_StartTracking_WaitingForStopCommand_TextReceived_tr0_tr0()) {
					effect_main_region_StartTracking_WaitingForStopCommand_TextReceived_tr0();
				} else {
					if (check_main_region_StartTracking_WaitingForStopCommand_TextReceived_tr1_tr1()) {
						effect_main_region_StartTracking_WaitingForStopCommand_TextReceived_tr1();
					} else {
						if (check_main_region_StartTracking_WaitingForStopCommand_TextReceived_tr2_tr2()) {
							effect_main_region_StartTracking_WaitingForStopCommand_TextReceived_tr2();
						} else {
							if (check_main_region_StartTracking_WaitingForStopCommand_TextReceived_tr3_tr3()) {
								effect_main_region_StartTracking_WaitingForStopCommand_TextReceived_tr3();
							} else {
								if (check_main_region_StartTracking_WaitingForStopCommand_TextReceived_tr4_tr4()) {
									effect_main_region_StartTracking_WaitingForStopCommand_TextReceived_tr4();
								}
							}
						}
					}
				}
			}
		}
	}
	
	/* The reactions of state TTS. */
	private void react_main_region_StartTracking_WaitingForStopCommand_TTS() {
		if (check_main_region_StartTracking_tr0_tr0()) {
			effect_main_region_StartTracking_tr0();
		} else {
			if (check_main_region_StartTracking_tr2_tr2()) {
				effect_main_region_StartTracking_tr2();
			} else {
				effect_main_region_StartTracking_WaitingForStopCommand_TTS_tr0();
			}
		}
	}
	
	/* The reactions of state UTurn1. */
	private void react_main_region_Lost_WavingToFindPerson_UTurn1() {
		if (check_main_region_Lost_WavingToFindPerson_UTurn1_tr0_tr0()) {
			effect_main_region_Lost_WavingToFindPerson_UTurn1_tr0();
		}
	}
	
	/* The reactions of state WaveFound. */
	private void react_main_region_Lost_WavingToFindPerson_WaveFound() {
		if (check_main_region_Lost_WavingToFindPerson_WaveFound_tr0_tr0()) {
			effect_main_region_Lost_WavingToFindPerson_WaveFound_tr0();
		}
	}
	
	/* The reactions of state Turn. */
	private void react_main_region_Lost_WavingToFindPerson_Turn() {
		if (check_main_region_Lost_WavingToFindPerson_Turn_tr0_tr0()) {
			effect_main_region_Lost_WavingToFindPerson_Turn_tr0();
		} else {
			if (check_main_region_Lost_WavingToFindPerson_Turn_tr1_tr1()) {
				effect_main_region_Lost_WavingToFindPerson_Turn_tr1();
			}
		}
	}
	
	/* The reactions of state DetectionOn. */
	private void react_main_region_Lost_WavingToFindPerson_DetectionOn() {
		if (check_main_region_Lost_WavingToFindPerson_DetectionOn_tr0_tr0()) {
			effect_main_region_Lost_WavingToFindPerson_DetectionOn_tr0();
		}
	}
	
	/* The reactions of state PersonFound. */
	private void react_main_region_Lost_WavingToFindPerson_PersonFound() {
		effect_main_region_Lost_WavingToFindPerson_PersonFound_tr0();
	}
	
	/* The reactions of state ILostYou. */
	private void react_main_region_Lost_WavingToFindPerson_ILostYou() {
		if (check_main_region_Lost_WavingToFindPerson_ILostYou_tr0_tr0()) {
			effect_main_region_Lost_WavingToFindPerson_ILostYou_tr0();
		} else {
			effect_main_region_Lost_WavingToFindPerson_ILostYou_tr1();
		}
	}
	
	/* The reactions of state UTurn2. */
	private void react_main_region_Lost_WavingToFindPerson_UTurn2() {
		if (check_main_region_Lost_WavingToFindPerson_UTurn2_tr0_tr0()) {
			effect_main_region_Lost_WavingToFindPerson_UTurn2_tr0();
		}
	}
	
	/* The reactions of state Detection. */
	private void react_main_region_Lost_WavingToFindPerson_Detection() {
		if (check_main_region_Lost_WavingToFindPerson_Detection_tr0_tr0()) {
			effect_main_region_Lost_WavingToFindPerson_Detection_tr0();
		} else {
			if (check_main_region_Lost_WavingToFindPerson_Detection_tr1_tr1()) {
				effect_main_region_Lost_WavingToFindPerson_Detection_tr1();
			} else {
				if (check_main_region_Lost_WavingToFindPerson_Detection_tr2_tr2()) {
					effect_main_region_Lost_WavingToFindPerson_Detection_tr2();
				}
			}
		}
	}
	
	/* The reactions of state NotFound. */
	private void react_main_region_Lost_WavingToFindPerson_NotFound() {
		effect_main_region_Lost_WavingToFindPerson_NotFound_tr0();
	}
	
	/* The reactions of state ILostU. */
	private void react_main_region_Lost_WavingToFindPerson_ILostU() {
		if (check_main_region_Lost_WavingToFindPerson_ILostU_tr0_tr0()) {
			effect_main_region_Lost_WavingToFindPerson_ILostU_tr0();
		} else {
			if (check_main_region_Lost_WavingToFindPerson_ILostU_tr1_tr1()) {
				effect_main_region_Lost_WavingToFindPerson_ILostU_tr1();
			}
		}
	}
	
	/* The reactions of state StateA. */
	private void react_main_region_HowCanIHelpYou_main_region_StateA() {
		if (check_main_region_HowCanIHelpYou_main_region_StateA_tr0_tr0()) {
			effect_main_region_HowCanIHelpYou_main_region_StateA_tr0();
		} else {
			if (check_main_region_HowCanIHelpYou_main_region_StateA_tr1_tr1()) {
				effect_main_region_HowCanIHelpYou_main_region_StateA_tr1();
			}
		}
	}
	
	/* The reactions of state StartSTT. */
	private void react_main_region_HowCanIHelpYou_main_region_StartSTT() {
		if (check_main_region_HowCanIHelpYou_main_region_StartSTT_tr0_tr0()) {
			effect_main_region_HowCanIHelpYou_main_region_StartSTT_tr0();
		} else {
			if (check_main_region_HowCanIHelpYou_main_region_StartSTT_tr1_tr1()) {
				effect_main_region_HowCanIHelpYou_main_region_StartSTT_tr1();
			}
		}
	}
	
	/* The reactions of state TellAnswer. */
	private void react_main_region_HowCanIHelpYou_main_region_TellAnswer() {
		if (check_main_region_HowCanIHelpYou_main_region_TellAnswer_tr0_tr0()) {
			effect_main_region_HowCanIHelpYou_main_region_TellAnswer_tr0();
		} else {
			if (check_main_region_HowCanIHelpYou_main_region_TellAnswer_tr1_tr1()) {
				effect_main_region_HowCanIHelpYou_main_region_TellAnswer_tr1();
			}
		}
	}
	
	/* The reactions of state Repeat. */
	private void react_main_region_HowCanIHelpYou_main_region_Repeat() {
		effect_main_region_HowCanIHelpYou_main_region_Repeat_tr0();
	}
	
	/* The reactions of state TellIncomprehensible. */
	private void react_main_region_HowCanIHelpYou_main_region_TellIncomprehensible() {
		if (check_main_region_HowCanIHelpYou_main_region_TellIncomprehensible_tr0_tr0()) {
			effect_main_region_HowCanIHelpYou_main_region_TellIncomprehensible_tr0();
		}
	}
	
	/* The reactions of state StopSTT. */
	private void react_main_region_HowCanIHelpYou_main_region_StopSTT() {
		if (check_main_region_HowCanIHelpYou_main_region_StopSTT_tr0_tr0()) {
			effect_main_region_HowCanIHelpYou_main_region_StopSTT_tr0();
		} else {
			if (check_main_region_HowCanIHelpYou_main_region_StopSTT_tr1_tr1()) {
				effect_main_region_HowCanIHelpYou_main_region_StopSTT_tr1();
			} else {
				if (check_main_region_HowCanIHelpYou_main_region_StopSTT_tr2_tr2()) {
					effect_main_region_HowCanIHelpYou_main_region_StopSTT_tr2();
				} else {
					if (check_main_region_HowCanIHelpYou_main_region_StopSTT_tr3_tr3()) {
						effect_main_region_HowCanIHelpYou_main_region_StopSTT_tr3();
					}
				}
			}
		}
	}
	
	/* The reactions of state Stop2. */
	private void react_main_region_HowCanIHelpYou_main_region_Stop2() {
		effect_main_region_HowCanIHelpYou_main_region_Stop2_tr0();
	}
	
	/* The reactions of state wait. */
	private void react_main_region_HowCanIHelpYou_main_region_wait() {
		if (check_main_region_HowCanIHelpYou_main_region_wait_tr0_tr0()) {
			effect_main_region_HowCanIHelpYou_main_region_wait_tr0();
		}
	}
	
	/* The reactions of state stateB. */
	private void react_main_region_HowCanIHelpYou_main_region_stateB() {
		if (check_main_region_HowCanIHelpYou_main_region_stateB_tr0_tr0()) {
			effect_main_region_HowCanIHelpYou_main_region_stateB_tr0();
		} else {
			if (check_main_region_HowCanIHelpYou_main_region_stateB_tr1_tr1()) {
				effect_main_region_HowCanIHelpYou_main_region_stateB_tr1();
			}
		}
	}
	
	/* The reactions of state ArrivedWaypoint. */
	private void react_main_region_ArrivedWaypoint() {
		if (check_main_region_ArrivedWaypoint_tr0_tr0()) {
			effect_main_region_ArrivedWaypoint_tr0();
		} else {
			if (check_main_region_ArrivedWaypoint_tr1_tr1()) {
				effect_main_region_ArrivedWaypoint_tr1();
			}
		}
	}
	
	/* The reactions of state null. */
	private void react_main_region__final_() {
	}
	
	/* The reactions of state StartSTT. */
	private void react_main_region_StartSTT() {
		if (check_main_region_StartSTT_tr0_tr0()) {
			effect_main_region_StartSTT_tr0();
		}
	}
	
	/* The reactions of state StopSTT. */
	private void react_main_region_StopSTT() {
		if (check_main_region_StopSTT_tr0_tr0()) {
			effect_main_region_StopSTT_tr0();
		} else {
			if (check_main_region_StopSTT_tr1_tr1()) {
				effect_main_region_StopSTT_tr1();
			} else {
				if (check_main_region_StopSTT_tr2_tr2()) {
					effect_main_region_StopSTT_tr2();
				}
			}
		}
	}
	
	/* The reactions of state FollowYes. */
	private void react_main_region_FollowYes() {
		effect_main_region_FollowYes_tr0();
	}
	
	/* The reactions of state FollowNo. */
	private void react_main_region_FollowNo() {
		if (check_main_region_FollowNo_tr0_tr0()) {
			effect_main_region_FollowNo_tr0();
		} else {
			if (check_main_region_FollowNo_tr1_tr1()) {
				effect_main_region_FollowNo_tr1();
			}
		}
	}
	
	/* The reactions of state goto. */
	private void react_main_region_GoTo_goto_goto() {
		if (check_main_region_GoTo_tr2_tr2()) {
			effect_main_region_GoTo_tr2();
		} else {
			if (check_main_region_GoTo_tr3_tr3()) {
				effect_main_region_GoTo_tr3();
			} else {
				if (check_main_region_GoTo_goto_goto_tr0_tr0()) {
					effect_main_region_GoTo_goto_goto_tr0();
				}
			}
		}
	}
	
	/* The reactions of state goto_fallback. */
	private void react_main_region_GoTo_goto_goto_fallback() {
		if (check_main_region_GoTo_tr2_tr2()) {
			effect_main_region_GoTo_tr2();
		} else {
			if (check_main_region_GoTo_tr3_tr3()) {
				effect_main_region_GoTo_tr3();
			} else {
				if (check_main_region_GoTo_goto_goto_fallback_tr0_tr0()) {
					effect_main_region_GoTo_goto_goto_fallback_tr0();
				}
			}
		}
	}
	
	/* The reactions of state gotoWP. */
	private void react_main_region_GoTo_goto_gotoWP() {
		if (check_main_region_GoTo_tr2_tr2()) {
			effect_main_region_GoTo_tr2();
		} else {
			if (check_main_region_GoTo_tr3_tr3()) {
				effect_main_region_GoTo_tr3();
			} else {
				if (check_main_region_GoTo_goto_gotoWP_tr0_tr0()) {
					effect_main_region_GoTo_goto_gotoWP_tr0();
				}
			}
		}
	}
	
	/* The reactions of state LocationNotFound. */
	private void react_main_region_LocationNotFound() {
		if (check_main_region_LocationNotFound_tr0_tr0()) {
			effect_main_region_LocationNotFound_tr0();
		}
	}
	
	/* The reactions of state DetectionOn. */
	private void react_main_region_DetectionOn() {
		effect_main_region_DetectionOn_tr0();
	}
	
	/* The reactions of state LockingForNextOperator. */
	private void react_main_region_LockingForNextOperator() {
		if (check_main_region_LockingForNextOperator_tr0_tr0()) {
			effect_main_region_LockingForNextOperator_tr0();
		} else {
			if (check_main_region_LockingForNextOperator_tr1_tr1()) {
				effect_main_region_LockingForNextOperator_tr1();
			} else {
				if (check_main_region_LockingForNextOperator_tr2_tr2()) {
					effect_main_region_LockingForNextOperator_tr2();
				}
			}
		}
	}
	
	/* The reactions of state Turn. */
	private void react_main_region_Turn() {
		effect_main_region_Turn_tr0();
	}
	
	/* The reactions of state PersonFound. */
	private void react_main_region_PersonFound() {
		if (check_main_region_PersonFound_tr0_tr0()) {
			effect_main_region_PersonFound_tr0();
		} else {
			if (check_main_region_PersonFound_tr1_tr1()) {
				effect_main_region_PersonFound_tr1();
			}
		}
	}
	
	/* The reactions of state TTS. */
	private void react_main_region_GuideMe_folllowMePleaseRepeat_TTS() {
		if (check_main_region_GuideMe_tr0_tr0()) {
			effect_main_region_GuideMe_tr0();
		} else {
			if (check_main_region_GuideMe_tr1_tr1()) {
				effect_main_region_GuideMe_tr1();
			} else {
				if (check_main_region_GuideMe_folllowMePleaseRepeat_TTS_tr0_tr0()) {
					effect_main_region_GuideMe_folllowMePleaseRepeat_TTS_tr0();
				}
			}
		}
	}
	
	/* The reactions of state wait. */
	private void react_main_region_wait() {
		if (check_main_region_wait_tr0_tr0()) {
			effect_main_region_wait_tr0();
		}
	}
	
	/* The reactions of state arrived. */
	private void react_main_region_arrived() {
		if (check_main_region_arrived_tr0_tr0()) {
			effect_main_region_arrived_tr0();
		}
	}
	
	/* The reactions of state DetectionOff. */
	private void react_main_region_DetectionOff() {
		if (check_main_region_DetectionOff_tr0_tr0()) {
			effect_main_region_DetectionOff_tr0();
		}
	}
	
	/* The reactions of state TrackingOffAndSavePoint. */
	private void react_main_region_TrackingOffAndSavePoint() {
		effect_main_region_TrackingOffAndSavePoint_tr0();
	}
	
	/* The reactions of state speak. */
	private void react_main_region_PathBlocked_Blocked_speak() {
		if (check_main_region_PathBlocked_Blocked_speak_tr0_tr0()) {
			effect_main_region_PathBlocked_Blocked_speak_tr0();
		}
	}
	
	/* The reactions of state gotoendp. */
	private void react_main_region_PathBlocked_Blocked_gotoendp() {
		if (check_main_region_PathBlocked_Blocked_gotoendp_tr0_tr0()) {
			effect_main_region_PathBlocked_Blocked_gotoendp_tr0();
		} else {
			if (check_main_region_PathBlocked_Blocked_gotoendp_tr1_tr1()) {
				effect_main_region_PathBlocked_Blocked_gotoendp_tr1();
			}
		}
	}
	
	/* The reactions of state blocked2ndTime. */
	private void react_main_region_blocked2ndTime() {
		if (check_main_region_blocked2ndTime_tr0_tr0()) {
			effect_main_region_blocked2ndTime_tr0();
		}
	}
	
	/* The reactions of state blocked. */
	private void react_main_region_blocked() {
		if (check_main_region_blocked_tr0_tr0()) {
			effect_main_region_blocked_tr0();
		}
	}
	
	/* The reactions of state nextTry. */
	private void react_main_region_nextTry() {
		if (check_main_region_nextTry_tr0_tr0()) {
			effect_main_region_nextTry_tr0();
		}
	}
	
	/* The reactions of state arrived1. */
	private void react_main_region_arrived1() {
		if (check_main_region_arrived1_tr0_tr0()) {
			effect_main_region_arrived1_tr0();
		}
	}
	
	/* The reactions of state TTS. */
	private void react_main_region_ObstacleFollow_ObstacleAvoidingText_TTS() {
		if (check_main_region_ObstacleFollow_ObstacleAvoidingText_TTS_tr0_tr0()) {
			effect_main_region_ObstacleFollow_ObstacleAvoidingText_TTS_tr0();
		}
	}
	
	/* The reactions of state WaitForAvoiding. */
	private void react_main_region_ObstacleFollow_ObstacleAvoidingText_WaitForAvoiding() {
		if (check_main_region_ObstacleFollow_ObstacleAvoidingText_WaitForAvoiding_tr0_tr0()) {
			effect_main_region_ObstacleFollow_ObstacleAvoidingText_WaitForAvoiding_tr0();
		}
	}
	
	/* The reactions of state GoOn. */
	private void react_main_region_ObstacleFollow_ObstacleAvoidingText_GoOn() {
		if (check_main_region_ObstacleFollow_ObstacleAvoidingText_GoOn_tr0_tr0()) {
			effect_main_region_ObstacleFollow_ObstacleAvoidingText_GoOn_tr0();
		}
	}
	
	/* The reactions of state TTS. */
	private void react_main_region_ObstacleWayBack_ObstacleAvoidingText_TTS() {
		if (check_main_region_ObstacleWayBack_ObstacleAvoidingText_TTS_tr0_tr0()) {
			effect_main_region_ObstacleWayBack_ObstacleAvoidingText_TTS_tr0();
		}
	}
	
	/* The reactions of state waitForEvent. */
	private void react_Leonie_Bupered_Or_Emergency_Stop_waitForEvent() {
		if (check_Leonie_Bupered_Or_Emergency_Stop_waitForEvent_tr0_tr0()) {
			effect_Leonie_Bupered_Or_Emergency_Stop_waitForEvent_tr0();
		} else {
			if (check_Leonie_Bupered_Or_Emergency_Stop_waitForEvent_tr1_tr1()) {
				effect_Leonie_Bupered_Or_Emergency_Stop_waitForEvent_tr1();
			}
		}
	}
	
	/* The reactions of state Bumpered. */
	private void react_Leonie_Bupered_Or_Emergency_Stop_Bumpered() {
		if (check_Leonie_Bupered_Or_Emergency_Stop_Bumpered_tr0_tr0()) {
			effect_Leonie_Bupered_Or_Emergency_Stop_Bumpered_tr0();
		}
	}
	
	/* The reactions of state resetFace. */
	private void react_Leonie_Bupered_Or_Emergency_Stop_resetFace() {
		effect_Leonie_Bupered_Or_Emergency_Stop_resetFace_tr0();
	}
	
	/* The reactions of state EmergencyStop. */
	private void react_Leonie_Bupered_Or_Emergency_Stop_EmergencyStop() {
		effect_Leonie_Bupered_Or_Emergency_Stop_EmergencyStop_tr0();
	}
	
	/* The reactions of state checkEmergency. */
	private void react_Leonie_Bupered_Or_Emergency_Stop_checkEmergency() {
		if (check_Leonie_Bupered_Or_Emergency_Stop_checkEmergency_tr0_tr0()) {
			effect_Leonie_Bupered_Or_Emergency_Stop_checkEmergency_tr0();
		} else {
			if (check_Leonie_Bupered_Or_Emergency_Stop_checkEmergency_tr1_tr1()) {
				effect_Leonie_Bupered_Or_Emergency_Stop_checkEmergency_tr1();
			}
		}
	}
	
	/* The reactions of state null. */
	private void react_main_region_StartTracking_WaitingForStopCommand__choice_0() {
		if (check_main_region_StartTracking_WaitingForStopCommand__choice_0_tr0_tr0()) {
			effect_main_region_StartTracking_WaitingForStopCommand__choice_0_tr0();
		} else {
			effect_main_region_StartTracking_WaitingForStopCommand__choice_0_tr1();
		}
	}
	
	/* The reactions of state null. */
	private void react_main_region_HowCanIHelpYou_main_region__choice_0() {
		if (check_main_region_HowCanIHelpYou_main_region__choice_0_tr1_tr1()) {
			effect_main_region_HowCanIHelpYou_main_region__choice_0_tr1();
		} else {
			effect_main_region_HowCanIHelpYou_main_region__choice_0_tr0();
		}
	}
	
	/* The reactions of state null. */
	private void react_main_region_HowCanIHelpYou_main_region__choice_1() {
		if (check_main_region_HowCanIHelpYou_main_region__choice_1_tr1_tr1()) {
			effect_main_region_HowCanIHelpYou_main_region__choice_1_tr1();
		} else {
			effect_main_region_HowCanIHelpYou_main_region__choice_1_tr0();
		}
	}
	
	/* The reactions of state null. */
	private void react_main_region_HowCanIHelpYou_main_region__choice_2() {
		if (check_main_region_HowCanIHelpYou_main_region__choice_2_tr0_tr0()) {
			effect_main_region_HowCanIHelpYou_main_region__choice_2_tr0();
		} else {
			effect_main_region_HowCanIHelpYou_main_region__choice_2_tr1();
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
	
	/* The reactions of state null. */
	private void react_main_region_GoTo_goto__choice_0() {
		if (check_main_region_GoTo_goto__choice_0_tr1_tr1()) {
			effect_main_region_GoTo_goto__choice_0_tr1();
		} else {
			effect_main_region_GoTo_goto__choice_0_tr0();
		}
	}
	
	/* The reactions of state null. */
	private void react_main_region_GoTo_goto__choice_1() {
		if (check_main_region_GoTo_goto__choice_1_tr0_tr0()) {
			effect_main_region_GoTo_goto__choice_1_tr0();
		} else {
			effect_main_region_GoTo_goto__choice_1_tr1();
		}
	}
	
	/* The reactions of state null. */
	private void react_main_region__choice_1() {
		effect_main_region__choice_1_tr0();
	}
	
	/* The reactions of state null. */
	private void react_main_region__choice_2() {
		if (check_main_region__choice_2_tr0_tr0()) {
			effect_main_region__choice_2_tr0();
		} else {
			effect_main_region__choice_2_tr1();
		}
	}
	
	/* Default react sequence for initial entry  */
	private void react_main_region__entry_Default() {
		enterSequence_main_region_DetectionOn_default();
	}
	
	/* Default react sequence for initial entry  */
	private void react_main_region_StartTracking_WaitingForStopCommand__entry_Default() {
		enterSequence_main_region_StartTracking_WaitingForStopCommand_STTstart_default();
	}
	
	/* Default react sequence for initial entry  */
	private void react_main_region_Lost_WavingToFindPerson__entry_Default() {
		enterSequence_main_region_Lost_WavingToFindPerson_ILostYou_default();
	}
	
	/* Default react sequence for initial entry  */
	private void react_main_region_HowCanIHelpYou_main_region__entry_Default() {
		enterSequence_main_region_HowCanIHelpYou_main_region_StateA_default();
	}
	
	/* Default react sequence for initial entry  */
	private void react_main_region_GoTo_goto__entry_Default() {
		react_main_region_GoTo_goto__choice_0();
	}
	
	/* Default react sequence for initial entry  */
	private void react_main_region_GuideMe_folllowMePleaseRepeat__entry_Default() {
		enterSequence_main_region_GuideMe_folllowMePleaseRepeat_TTS_default();
	}
	
	/* Default react sequence for initial entry  */
	private void react_main_region_PathBlocked_Blocked__entry_Default() {
		enterSequence_main_region_PathBlocked_Blocked_speak_default();
	}
	
	/* Default react sequence for initial entry  */
	private void react_main_region_ObstacleFollow_ObstacleAvoidingText__entry_Default() {
		enterSequence_main_region_ObstacleFollow_ObstacleAvoidingText_TTS_default();
	}
	
	/* Default react sequence for initial entry  */
	private void react_main_region_ObstacleWayBack_ObstacleAvoidingText__entry_Default() {
		enterSequence_main_region_ObstacleWayBack_ObstacleAvoidingText_TTS_default();
	}
	
	/* Default react sequence for initial entry  */
	private void react_Leonie_Bupered_Or_Emergency_Stop__entry_Default() {
		enterSequence_Leonie_Bupered_Or_Emergency_Stop_waitForEvent_default();
	}
	
	/* The reactions of exit exit_arrived. */
	private void react_main_region_StartTracking_WaitingForStopCommand_exit_arrived() {
		effect_main_region_StartTracking_tr1();
	}
	
	/* The reactions of exit exit_done. */
	private void react_main_region_Lost_WavingToFindPerson_exit_done() {
		effect_main_region_Lost_tr0();
	}
	
	/* The reactions of exit exit_goto. */
	private void react_main_region_HowCanIHelpYou_main_region_exit_goto() {
		effect_main_region_HowCanIHelpYou_tr0();
	}
	
	/* The reactions of exit exit_notFound. */
	private void react_main_region_GoTo_goto_exit_notFound() {
		effect_main_region_GoTo_tr1();
	}
	
	/* The reactions of exit exit_arrived. */
	private void react_main_region_GoTo_goto_exit_arrived() {
		effect_main_region_GoTo_tr0();
	}
	
	/* The reactions of exit exit_done. */
	private void react_main_region_PathBlocked_Blocked_exit_done() {
		effect_main_region_PathBlocked_tr0();
	}
	
	/* The reactions of exit exit_failed. */
	private void react_main_region_PathBlocked_Blocked_exit_failed() {
		effect_main_region_PathBlocked_tr1();
	}
	
	/* The reactions of exit exit_done. */
	private void react_main_region_ObstacleFollow_ObstacleAvoidingText_exit_done() {
		effect_main_region_ObstacleFollow_tr0();
	}
	
	/* The reactions of exit exit_done. */
	private void react_main_region_ObstacleWayBack_ObstacleAvoidingText_exit_done() {
		effect_main_region_ObstacleWayBack_tr0();
	}
	
	public void runCycle() {
		if (!initialized)
			throw new IllegalStateException(
					"The state machine needs to be initialized first by calling the init() function.");
		clearOutEvents();
		for (nextStateIndex = 0; nextStateIndex < stateVector.length; nextStateIndex++) {
			switch (stateVector[nextStateIndex]) {
			case main_region_Detection:
				react_main_region_Detection();
				break;
			case main_region_NotFound:
				react_main_region_NotFound();
				break;
			case main_region_Found:
				react_main_region_Found();
				break;
			case main_region_StartTracking_WaitingForStopCommand_STToff:
				react_main_region_StartTracking_WaitingForStopCommand_STToff();
				break;
			case main_region_StartTracking_WaitingForStopCommand_STTstart:
				react_main_region_StartTracking_WaitingForStopCommand_STTstart();
				break;
			case main_region_StartTracking_WaitingForStopCommand_TextReceived:
				react_main_region_StartTracking_WaitingForStopCommand_TextReceived();
				break;
			case main_region_StartTracking_WaitingForStopCommand_TTS:
				react_main_region_StartTracking_WaitingForStopCommand_TTS();
				break;
			case main_region_Lost_WavingToFindPerson_UTurn1:
				react_main_region_Lost_WavingToFindPerson_UTurn1();
				break;
			case main_region_Lost_WavingToFindPerson_WaveFound:
				react_main_region_Lost_WavingToFindPerson_WaveFound();
				break;
			case main_region_Lost_WavingToFindPerson_Turn:
				react_main_region_Lost_WavingToFindPerson_Turn();
				break;
			case main_region_Lost_WavingToFindPerson_DetectionOn:
				react_main_region_Lost_WavingToFindPerson_DetectionOn();
				break;
			case main_region_Lost_WavingToFindPerson_PersonFound:
				react_main_region_Lost_WavingToFindPerson_PersonFound();
				break;
			case main_region_Lost_WavingToFindPerson_ILostYou:
				react_main_region_Lost_WavingToFindPerson_ILostYou();
				break;
			case main_region_Lost_WavingToFindPerson_UTurn2:
				react_main_region_Lost_WavingToFindPerson_UTurn2();
				break;
			case main_region_Lost_WavingToFindPerson_Detection:
				react_main_region_Lost_WavingToFindPerson_Detection();
				break;
			case main_region_Lost_WavingToFindPerson_NotFound:
				react_main_region_Lost_WavingToFindPerson_NotFound();
				break;
			case main_region_Lost_WavingToFindPerson_ILostU:
				react_main_region_Lost_WavingToFindPerson_ILostU();
				break;
			case main_region_HowCanIHelpYou_main_region_StateA:
				react_main_region_HowCanIHelpYou_main_region_StateA();
				break;
			case main_region_HowCanIHelpYou_main_region_StartSTT:
				react_main_region_HowCanIHelpYou_main_region_StartSTT();
				break;
			case main_region_HowCanIHelpYou_main_region_TellAnswer:
				react_main_region_HowCanIHelpYou_main_region_TellAnswer();
				break;
			case main_region_HowCanIHelpYou_main_region_Repeat:
				react_main_region_HowCanIHelpYou_main_region_Repeat();
				break;
			case main_region_HowCanIHelpYou_main_region_TellIncomprehensible:
				react_main_region_HowCanIHelpYou_main_region_TellIncomprehensible();
				break;
			case main_region_HowCanIHelpYou_main_region_StopSTT:
				react_main_region_HowCanIHelpYou_main_region_StopSTT();
				break;
			case main_region_HowCanIHelpYou_main_region_Stop2:
				react_main_region_HowCanIHelpYou_main_region_Stop2();
				break;
			case main_region_HowCanIHelpYou_main_region_wait:
				react_main_region_HowCanIHelpYou_main_region_wait();
				break;
			case main_region_HowCanIHelpYou_main_region_stateB:
				react_main_region_HowCanIHelpYou_main_region_stateB();
				break;
			case main_region_ArrivedWaypoint:
				react_main_region_ArrivedWaypoint();
				break;
			case main_region__final_:
				react_main_region__final_();
				break;
			case main_region_StartSTT:
				react_main_region_StartSTT();
				break;
			case main_region_StopSTT:
				react_main_region_StopSTT();
				break;
			case main_region_FollowYes:
				react_main_region_FollowYes();
				break;
			case main_region_FollowNo:
				react_main_region_FollowNo();
				break;
			case main_region_GoTo_goto_goto:
				react_main_region_GoTo_goto_goto();
				break;
			case main_region_GoTo_goto_goto_fallback:
				react_main_region_GoTo_goto_goto_fallback();
				break;
			case main_region_GoTo_goto_gotoWP:
				react_main_region_GoTo_goto_gotoWP();
				break;
			case main_region_LocationNotFound:
				react_main_region_LocationNotFound();
				break;
			case main_region_DetectionOn:
				react_main_region_DetectionOn();
				break;
			case main_region_LockingForNextOperator:
				react_main_region_LockingForNextOperator();
				break;
			case main_region_Turn:
				react_main_region_Turn();
				break;
			case main_region_PersonFound:
				react_main_region_PersonFound();
				break;
			case main_region_GuideMe_folllowMePleaseRepeat_TTS:
				react_main_region_GuideMe_folllowMePleaseRepeat_TTS();
				break;
			case main_region_wait:
				react_main_region_wait();
				break;
			case main_region_arrived:
				react_main_region_arrived();
				break;
			case main_region_DetectionOff:
				react_main_region_DetectionOff();
				break;
			case main_region_TrackingOffAndSavePoint:
				react_main_region_TrackingOffAndSavePoint();
				break;
			case main_region_PathBlocked_Blocked_speak:
				react_main_region_PathBlocked_Blocked_speak();
				break;
			case main_region_PathBlocked_Blocked_gotoendp:
				react_main_region_PathBlocked_Blocked_gotoendp();
				break;
			case main_region_blocked2ndTime:
				react_main_region_blocked2ndTime();
				break;
			case main_region_blocked:
				react_main_region_blocked();
				break;
			case main_region_nextTry:
				react_main_region_nextTry();
				break;
			case main_region_arrived1:
				react_main_region_arrived1();
				break;
			case main_region_ObstacleFollow_ObstacleAvoidingText_TTS:
				react_main_region_ObstacleFollow_ObstacleAvoidingText_TTS();
				break;
			case main_region_ObstacleFollow_ObstacleAvoidingText_WaitForAvoiding:
				react_main_region_ObstacleFollow_ObstacleAvoidingText_WaitForAvoiding();
				break;
			case main_region_ObstacleFollow_ObstacleAvoidingText_GoOn:
				react_main_region_ObstacleFollow_ObstacleAvoidingText_GoOn();
				break;
			case main_region_ObstacleWayBack_ObstacleAvoidingText_TTS:
				react_main_region_ObstacleWayBack_ObstacleAvoidingText_TTS();
				break;
			case leonie_Bupered_Or_Emergency_Stop_waitForEvent:
				react_Leonie_Bupered_Or_Emergency_Stop_waitForEvent();
				break;
			case leonie_Bupered_Or_Emergency_Stop_Bumpered:
				react_Leonie_Bupered_Or_Emergency_Stop_Bumpered();
				break;
			case leonie_Bupered_Or_Emergency_Stop_resetFace:
				react_Leonie_Bupered_Or_Emergency_Stop_resetFace();
				break;
			case leonie_Bupered_Or_Emergency_Stop_EmergencyStop:
				react_Leonie_Bupered_Or_Emergency_Stop_EmergencyStop();
				break;
			case leonie_Bupered_Or_Emergency_Stop_checkEmergency:
				react_Leonie_Bupered_Or_Emergency_Stop_checkEmergency();
				break;
			default:
				// $NullState$
			}
		}
		clearEvents();
	}
}
