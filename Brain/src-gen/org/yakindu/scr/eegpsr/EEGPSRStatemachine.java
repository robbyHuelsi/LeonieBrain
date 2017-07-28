package org.yakindu.scr.eegpsr;
import org.yakindu.scr.ITimer;

public class EEGPSRStatemachine implements IEEGPSRStatemachine {

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
	
	private boolean initialized = false;
	
	public enum State {
		xs_Hello,
		xs_Leave_the_arena,
		xs__final_,
		xs_DetectionsOn,
		xs_Init,
		xs_TellAnswer,
		xs_StopSTT,
		xs_TellIncomprehensible,
		xs_STT_and_Tell_Actions,
		xs_STT_and_Tell_Actions_s_StartSTT,
		xs_STT_and_Tell_Actions_s_TellSpokenText,
		xs_STT_and_Tell_Actions_s_YesNo,
		xs_STT_and_Tell_Actions_s_GeneratedCommand,
		xs_leave2,
		xs_leave3,
		xs_DoAllActions,
		xs_DoAllActions__region0_DoAction,
		xs_DoAllActions__region0_DoAction_Instructions_GoTo,
		xs_DoAllActions__region0_DoAction_Instructions_GoTo_goto_GeneralP_extended_livingroom,
		xs_DoAllActions__region0_DoAction_Instructions_GoTo_goto_GeneralP_extended_notFound,
		xs_DoAllActions__region0_DoAction_Instructions_GoTo_goto_GeneralP_extended_arrived,
		xs_DoAllActions__region0_DoAction_Instructions_GoTo_goto_GeneralP_extended_backToTheOperator,
		xs_DoAllActions__region0_DoAction_Instructions_GoTo_goto_GeneralP_extended_notArrived,
		xs_DoAllActions__region0_DoAction_Instructions_surrounding,
		xs_DoAllActions__region0_DoAction_Instructions_bring,
		xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_livingroom,
		xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_notFound,
		xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_arrived,
		xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_backToTheOperator,
		xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_bringGehtnicht,
		xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_stattdessen_goto,
		xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_notArrived,
		xs_DoAllActions__region0_DoAction_Instructions_open,
		xs_DoAllActions__region0_DoAction_Instructions_followme,
		xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking,
		xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking_WaitingForStopCommand_STToff,
		xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking_WaitingForStopCommand_STTstart,
		xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave,
		xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_UTurn1,
		xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_WaveFound,
		xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_Turn,
		xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_DetectionOn,
		xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_PersonFound,
		xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_ILostYou,
		xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_UTurn2,
		xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_Detection,
		xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_NotFound,
		xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Detect,
		xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_no,
		xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_HowCanIHelpYou,
		xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wir_brauchen_das_gerade_nicht,
		xs_DoAllActions__region0_DoAction_Instructions_unknown,
		xs_DoAllActions__region0_DoAction_Instructions_crowd,
		xs_DoAllActions__region0_DoAction_Instructions_tell,
		xs_DoAllActions__region0_DoAction_Instructions_question,
		xs_GoToOp,
		xs_blocked,
		xs_time_out,
		xs_DontDoIt,
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
	
	private final boolean[] timeEvents = new boolean[40];
	private long actionCounter;
	
	protected void setActionCounter(long value) {
		actionCounter = value;
	}
	
	protected long getActionCounter() {
		return actionCounter;
	}
	
	private long roundCounter;
	
	protected void setRoundCounter(long value) {
		roundCounter = value;
	}
	
	protected long getRoundCounter() {
		return roundCounter;
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
	
	public EEGPSRStatemachine() {
		sCIBGF = new SCIBGFImpl();
		sCIHBrain = new SCIHBrainImpl();
		sCIMira = new SCIMiraImpl();
		sCISTT = new SCISTTImpl();
		sCICrowdDetection = new SCICrowdDetectionImpl();
		sCIFollowMe = new SCIFollowMeImpl();
		sCIKinect2 = new SCIKinect2Impl();
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
		
		setActionCounter(0);
		
		setRoundCounter(0);
		
		setGWPout(0);
		
		setGWPstart(0);
	}
	
	public void enter() {
		if (!initialized) {
			throw new IllegalStateException(
					"The state machine needs to be initialized first by calling the init() function.");
		}
		if (timer == null) {
			throw new IllegalStateException("timer not set.");
		}
		enterSequence_xs_default();
		enterSequence_Leonie_Bupered_Or_Emergency_Stop_default();
	}
	
	public void exit() {
		exitSequence_xs();
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
		sCIMira.clearEvents();
		sCISTT.clearEvents();
		sCICrowdDetection.clearEvents();
		sCIFollowMe.clearEvents();
		sCIKinect2.clearEvents();
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
		case xs_Hello:
			return stateVector[0] == State.xs_Hello;
		case xs_Leave_the_arena:
			return stateVector[0] == State.xs_Leave_the_arena;
		case xs__final_:
			return stateVector[0] == State.xs__final_;
		case xs_DetectionsOn:
			return stateVector[0] == State.xs_DetectionsOn;
		case xs_Init:
			return stateVector[0] == State.xs_Init;
		case xs_TellAnswer:
			return stateVector[0] == State.xs_TellAnswer;
		case xs_StopSTT:
			return stateVector[0] == State.xs_StopSTT;
		case xs_TellIncomprehensible:
			return stateVector[0] == State.xs_TellIncomprehensible;
		case xs_STT_and_Tell_Actions:
			return stateVector[0].ordinal() >= State.
					xs_STT_and_Tell_Actions.ordinal()&& stateVector[0].ordinal() <= State.xs_STT_and_Tell_Actions_s_GeneratedCommand.ordinal();
		case xs_STT_and_Tell_Actions_s_StartSTT:
			return stateVector[0] == State.xs_STT_and_Tell_Actions_s_StartSTT;
		case xs_STT_and_Tell_Actions_s_TellSpokenText:
			return stateVector[0] == State.xs_STT_and_Tell_Actions_s_TellSpokenText;
		case xs_STT_and_Tell_Actions_s_YesNo:
			return stateVector[0] == State.xs_STT_and_Tell_Actions_s_YesNo;
		case xs_STT_and_Tell_Actions_s_GeneratedCommand:
			return stateVector[0] == State.xs_STT_and_Tell_Actions_s_GeneratedCommand;
		case xs_leave2:
			return stateVector[0] == State.xs_leave2;
		case xs_leave3:
			return stateVector[0] == State.xs_leave3;
		case xs_DoAllActions:
			return stateVector[0].ordinal() >= State.
					xs_DoAllActions.ordinal()&& stateVector[0].ordinal() <= State.xs_DoAllActions__region0_DoAction_Instructions_question.ordinal();
		case xs_DoAllActions__region0_DoAction:
			return stateVector[0].ordinal() >= State.
					xs_DoAllActions__region0_DoAction.ordinal()&& stateVector[0].ordinal() <= State.xs_DoAllActions__region0_DoAction_Instructions_question.ordinal();
		case xs_DoAllActions__region0_DoAction_Instructions_GoTo:
			return stateVector[0].ordinal() >= State.
					xs_DoAllActions__region0_DoAction_Instructions_GoTo.ordinal()&& stateVector[0].ordinal() <= State.xs_DoAllActions__region0_DoAction_Instructions_GoTo_goto_GeneralP_extended_notArrived.ordinal();
		case xs_DoAllActions__region0_DoAction_Instructions_GoTo_goto_GeneralP_extended_livingroom:
			return stateVector[0] == State.xs_DoAllActions__region0_DoAction_Instructions_GoTo_goto_GeneralP_extended_livingroom;
		case xs_DoAllActions__region0_DoAction_Instructions_GoTo_goto_GeneralP_extended_notFound:
			return stateVector[0] == State.xs_DoAllActions__region0_DoAction_Instructions_GoTo_goto_GeneralP_extended_notFound;
		case xs_DoAllActions__region0_DoAction_Instructions_GoTo_goto_GeneralP_extended_arrived:
			return stateVector[0] == State.xs_DoAllActions__region0_DoAction_Instructions_GoTo_goto_GeneralP_extended_arrived;
		case xs_DoAllActions__region0_DoAction_Instructions_GoTo_goto_GeneralP_extended_backToTheOperator:
			return stateVector[0] == State.xs_DoAllActions__region0_DoAction_Instructions_GoTo_goto_GeneralP_extended_backToTheOperator;
		case xs_DoAllActions__region0_DoAction_Instructions_GoTo_goto_GeneralP_extended_notArrived:
			return stateVector[0] == State.xs_DoAllActions__region0_DoAction_Instructions_GoTo_goto_GeneralP_extended_notArrived;
		case xs_DoAllActions__region0_DoAction_Instructions_surrounding:
			return stateVector[0] == State.xs_DoAllActions__region0_DoAction_Instructions_surrounding;
		case xs_DoAllActions__region0_DoAction_Instructions_bring:
			return stateVector[0].ordinal() >= State.
					xs_DoAllActions__region0_DoAction_Instructions_bring.ordinal()&& stateVector[0].ordinal() <= State.xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_notArrived.ordinal();
		case xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_livingroom:
			return stateVector[0] == State.xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_livingroom;
		case xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_notFound:
			return stateVector[0] == State.xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_notFound;
		case xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_arrived:
			return stateVector[0] == State.xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_arrived;
		case xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_backToTheOperator:
			return stateVector[0] == State.xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_backToTheOperator;
		case xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_bringGehtnicht:
			return stateVector[0] == State.xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_bringGehtnicht;
		case xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_stattdessen_goto:
			return stateVector[0] == State.xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_stattdessen_goto;
		case xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_notArrived:
			return stateVector[0] == State.xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_notArrived;
		case xs_DoAllActions__region0_DoAction_Instructions_open:
			return stateVector[0] == State.xs_DoAllActions__region0_DoAction_Instructions_open;
		case xs_DoAllActions__region0_DoAction_Instructions_followme:
			return stateVector[0].ordinal() >= State.
					xs_DoAllActions__region0_DoAction_Instructions_followme.ordinal()&& stateVector[0].ordinal() <= State.xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wir_brauchen_das_gerade_nicht.ordinal();
		case xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking:
			return stateVector[0].ordinal() >= State.
					xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking.ordinal()&& stateVector[0].ordinal() <= State.xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking_WaitingForStopCommand_STTstart.ordinal();
		case xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking_WaitingForStopCommand_STToff:
			return stateVector[0] == State.xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking_WaitingForStopCommand_STToff;
		case xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking_WaitingForStopCommand_STTstart:
			return stateVector[0] == State.xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking_WaitingForStopCommand_STTstart;
		case xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave:
			return stateVector[0].ordinal() >= State.
					xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave.ordinal()&& stateVector[0].ordinal() <= State.xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_NotFound.ordinal();
		case xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_UTurn1:
			return stateVector[0] == State.xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_UTurn1;
		case xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_WaveFound:
			return stateVector[0] == State.xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_WaveFound;
		case xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_Turn:
			return stateVector[0] == State.xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_Turn;
		case xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_DetectionOn:
			return stateVector[0] == State.xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_DetectionOn;
		case xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_PersonFound:
			return stateVector[0] == State.xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_PersonFound;
		case xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_ILostYou:
			return stateVector[0] == State.xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_ILostYou;
		case xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_UTurn2:
			return stateVector[0] == State.xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_UTurn2;
		case xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_Detection:
			return stateVector[0] == State.xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_Detection;
		case xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_NotFound:
			return stateVector[0] == State.xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_NotFound;
		case xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Detect:
			return stateVector[0] == State.xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Detect;
		case xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_no:
			return stateVector[0] == State.xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_no;
		case xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_HowCanIHelpYou:
			return stateVector[0] == State.xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_HowCanIHelpYou;
		case xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wir_brauchen_das_gerade_nicht:
			return stateVector[0] == State.xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wir_brauchen_das_gerade_nicht;
		case xs_DoAllActions__region0_DoAction_Instructions_unknown:
			return stateVector[0] == State.xs_DoAllActions__region0_DoAction_Instructions_unknown;
		case xs_DoAllActions__region0_DoAction_Instructions_crowd:
			return stateVector[0] == State.xs_DoAllActions__region0_DoAction_Instructions_crowd;
		case xs_DoAllActions__region0_DoAction_Instructions_tell:
			return stateVector[0] == State.xs_DoAllActions__region0_DoAction_Instructions_tell;
		case xs_DoAllActions__region0_DoAction_Instructions_question:
			return stateVector[0] == State.xs_DoAllActions__region0_DoAction_Instructions_question;
		case xs_GoToOp:
			return stateVector[0] == State.xs_GoToOp;
		case xs_blocked:
			return stateVector[0] == State.xs_blocked;
		case xs_time_out:
			return stateVector[0] == State.xs_time_out;
		case xs_DontDoIt:
			return stateVector[0] == State.xs_DontDoIt;
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
	
	public SCIKinect2 getSCIKinect2() {
		return sCIKinect2;
	}
	
	private boolean check_xs_Hello_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_xs_Hello_tr1_tr1() {
		return timeEvents[0];
	}
	
	private boolean check_xs_Leave_the_arena_tr0_tr0() {
		return sCIMira.arrivedWP;
	}
	
	private boolean check_xs_DetectionsOn_tr0_tr0() {
		return sCICrowdDetection.detected;
	}
	
	private boolean check_xs_DetectionsOn_tr1_tr1() {
		return timeEvents[1];
	}
	
	private boolean check_xs_Init_tr0_tr0() {
		return sCIMira.arrivedWP;
	}
	
	private boolean check_xs_TellAnswer_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_xs_TellAnswer_tr1_tr1() {
		return timeEvents[2];
	}
	
	private boolean check_xs_StopSTT_tr0_tr0() {
		return true;
	}
	
	private boolean check_xs_TellIncomprehensible_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_xs_TellIncomprehensible_tr1_tr1() {
		return timeEvents[3];
	}
	
	private boolean check_xs_STT_and_Tell_Actions_s_StartSTT_tr0_tr0() {
		return sCISTT.spokenTextReceived;
	}
	
	private boolean check_xs_STT_and_Tell_Actions_s_StartSTT_tr1_tr1() {
		return timeEvents[4];
	}
	
	private boolean check_xs_STT_and_Tell_Actions_s_StartSTT_tr2_tr2() {
		return sCISTT.incomprehensible;
	}
	
	private boolean check_xs_STT_and_Tell_Actions_s_TellSpokenText_tr0_tr0() {
		return sCISTT.incomprehensible;
	}
	
	private boolean check_xs_STT_and_Tell_Actions_s_TellSpokenText_tr1_tr1() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_xs_STT_and_Tell_Actions_s_TellSpokenText_tr2_tr2() {
		return timeEvents[5];
	}
	
	private boolean check_xs_STT_and_Tell_Actions_s_YesNo_tr0_tr0() {
		return sCISTT.answerReceived;
	}
	
	private boolean check_xs_STT_and_Tell_Actions_s_YesNo_tr1_tr1() {
		return timeEvents[6];
	}
	
	private boolean check_xs_STT_and_Tell_Actions_s_GeneratedCommand_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_xs_STT_and_Tell_Actions_s_GeneratedCommand_tr1_tr1() {
		return timeEvents[7];
	}
	
	private boolean check_xs_leave2_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_xs_leave2_tr1_tr1() {
		return timeEvents[8];
	}
	
	private boolean check_xs_leave3_tr0_tr0() {
		return sCIMira.arrivedWP;
	}
	
	private boolean check_xs_DoAllActions_tr1_tr1() {
		return timeEvents[9];
	}
	
	private boolean check_xs_DoAllActions__region0_DoAction_Instructions_GoTo_goto_GeneralP_extended_livingroom_tr0_tr0() {
		return sCIMira.arrivedWP;
	}
	
	private boolean check_xs_DoAllActions__region0_DoAction_Instructions_GoTo_goto_GeneralP_extended_livingroom_tr1_tr1() {
		return timeEvents[10];
	}
	
	private boolean check_xs_DoAllActions__region0_DoAction_Instructions_GoTo_goto_GeneralP_extended_livingroom_tr2_tr2() {
		return sCIMira.blocked;
	}
	
	private boolean check_xs_DoAllActions__region0_DoAction_Instructions_GoTo_goto_GeneralP_extended_notFound_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_xs_DoAllActions__region0_DoAction_Instructions_GoTo_goto_GeneralP_extended_notFound_tr1_tr1() {
		return timeEvents[11];
	}
	
	private boolean check_xs_DoAllActions__region0_DoAction_Instructions_GoTo_goto_GeneralP_extended_arrived_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_xs_DoAllActions__region0_DoAction_Instructions_GoTo_goto_GeneralP_extended_arrived_tr1_tr1() {
		return timeEvents[12];
	}
	
	private boolean check_xs_DoAllActions__region0_DoAction_Instructions_GoTo_goto_GeneralP_extended_backToTheOperator_tr0_tr0() {
		return sCIMira.arrivedWP;
	}
	
	private boolean check_xs_DoAllActions__region0_DoAction_Instructions_GoTo_goto_GeneralP_extended_backToTheOperator_tr1_tr1() {
		return sCIMira.blocked;
	}
	
	private boolean check_xs_DoAllActions__region0_DoAction_Instructions_GoTo_goto_GeneralP_extended_backToTheOperator_tr2_tr2() {
		return timeEvents[13];
	}
	
	private boolean check_xs_DoAllActions__region0_DoAction_Instructions_GoTo_goto_GeneralP_extended_notArrived_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_xs_DoAllActions__region0_DoAction_Instructions_GoTo_goto_GeneralP_extended_notArrived_tr1_tr1() {
		return timeEvents[14];
	}
	
	private boolean check_xs_DoAllActions__region0_DoAction_Instructions_surrounding_tr0_tr0() {
		return true;
	}
	
	private boolean check_xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_livingroom_tr0_tr0() {
		return sCIMira.arrivedWP;
	}
	
	private boolean check_xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_livingroom_tr1_tr1() {
		return sCIMira.blocked;
	}
	
	private boolean check_xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_livingroom_tr2_tr2() {
		return timeEvents[15];
	}
	
	private boolean check_xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_notFound_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_notFound_tr1_tr1() {
		return timeEvents[16];
	}
	
	private boolean check_xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_arrived_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_arrived_tr1_tr1() {
		return timeEvents[17];
	}
	
	private boolean check_xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_backToTheOperator_tr0_tr0() {
		return sCIMira.arrivedWP;
	}
	
	private boolean check_xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_backToTheOperator_tr1_tr1() {
		return sCIMira.blocked;
	}
	
	private boolean check_xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_backToTheOperator_tr2_tr2() {
		return timeEvents[18];
	}
	
	private boolean check_xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_bringGehtnicht_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_bringGehtnicht_tr1_tr1() {
		return timeEvents[19];
	}
	
	private boolean check_xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_stattdessen_goto_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_notArrived_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_notArrived_tr1_tr1() {
		return timeEvents[20];
	}
	
	private boolean check_xs_DoAllActions__region0_DoAction_Instructions_open_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_xs_DoAllActions__region0_DoAction_Instructions_open_tr1_tr1() {
		return timeEvents[21];
	}
	
	private boolean check_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking_tr0_tr0() {
		return sCIFollowMe.trackingPersonLost;
	}
	
	private boolean check_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking_tr2_tr2() {
		return timeEvents[22];
	}
	
	private boolean check_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking_WaitingForStopCommand_STToff_tr0_tr0() {
		return sCISTT.actionReceived;
	}
	
	private boolean check_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking_WaitingForStopCommand_STToff_tr1_tr1() {
		return timeEvents[23];
	}
	
	private boolean check_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking_WaitingForStopCommand_STTstart_tr0_tr0() {
		return timeEvents[24];
	}
	
	private boolean check_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking_WaitingForStopCommand_STTstart_tr1_tr1() {
		return sCISTT.actionReceived;
	}
	
	private boolean check_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_tr1_tr1() {
		return timeEvents[25];
	}
	
	private boolean check_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_UTurn1_tr0_tr0() {
		return timeEvents[26];
	}
	
	private boolean check_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_WaveFound_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_Turn_tr0_tr0() {
		return sCIKinect2.wavingDetected;
	}
	
	private boolean check_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_Turn_tr1_tr1() {
		return timeEvents[27];
	}
	
	private boolean check_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_DetectionOn_tr0_tr0() {
		return true;
	}
	
	private boolean check_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_PersonFound_tr0_tr0() {
		return true;
	}
	
	private boolean check_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_ILostYou_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_ILostYou_tr1_tr1() {
		return timeEvents[28];
	}
	
	private boolean check_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_UTurn2_tr0_tr0() {
		return timeEvents[29];
	}
	
	private boolean check_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_Detection_tr0_tr0() {
		return timeEvents[30];
	}
	
	private boolean check_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_Detection_tr1_tr1() {
		return sCIFollowMe.detectionPersonFound;
	}
	
	private boolean check_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_Detection_tr2_tr2() {
		return getActionCounter()>10;
	}
	
	private boolean check_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_NotFound_tr0_tr0() {
		return true;
	}
	
	private boolean check_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Detect_tr0_tr0() {
		return sCIFollowMe.detectionPersonFound;
	}
	
	private boolean check_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Detect_tr1_tr1() {
		return timeEvents[31];
	}
	
	private boolean check_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_no_tr0_tr0() {
		return true;
	}
	
	private boolean check_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_HowCanIHelpYou_tr0_tr0() {
		return sCIMira.arrivedWP;
	}
	
	private boolean check_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wir_brauchen_das_gerade_nicht_tr0_tr0() {
		return 1==0;
	}
	
	private boolean check_xs_DoAllActions__region0_DoAction_Instructions_unknown_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_xs_DoAllActions__region0_DoAction_Instructions_unknown_tr1_tr1() {
		return timeEvents[32];
	}
	
	private boolean check_xs_DoAllActions__region0_DoAction_Instructions_crowd_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_xs_DoAllActions__region0_DoAction_Instructions_crowd_tr1_tr1() {
		return timeEvents[33];
	}
	
	private boolean check_xs_DoAllActions__region0_DoAction_Instructions_tell_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_xs_DoAllActions__region0_DoAction_Instructions_tell_tr1_tr1() {
		return timeEvents[34];
	}
	
	private boolean check_xs_GoToOp_tr0_tr0() {
		return sCIMira.arrivedWP;
	}
	
	private boolean check_xs_GoToOp_tr1_tr1() {
		return sCIMira.blocked;
	}
	
	private boolean check_xs_GoToOp_tr2_tr2() {
		return timeEvents[35];
	}
	
	private boolean check_xs_blocked_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_xs_blocked_tr1_tr1() {
		return timeEvents[36];
	}
	
	private boolean check_xs_time_out_tr0_tr0() {
		return true;
	}
	
	private boolean check_xs_DontDoIt_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_xs_DontDoIt_tr1_tr1() {
		return timeEvents[37];
	}
	
	private boolean check_Leonie_Bupered_Or_Emergency_Stop_waitForEvent_tr0_tr0() {
		return sCIMira.bumpered;
	}
	
	private boolean check_Leonie_Bupered_Or_Emergency_Stop_waitForEvent_tr1_tr1() {
		return sCIMira.emergencyStop;
	}
	
	private boolean check_Leonie_Bupered_Or_Emergency_Stop_Bumpered_tr0_tr0() {
		return timeEvents[38];
	}
	
	private boolean check_Leonie_Bupered_Or_Emergency_Stop_resetFace_tr0_tr0() {
		return true;
	}
	
	private boolean check_Leonie_Bupered_Or_Emergency_Stop_EmergencyStop_tr0_tr0() {
		return true;
	}
	
	private boolean check_Leonie_Bupered_Or_Emergency_Stop_checkEmergency_tr0_tr0() {
		return timeEvents[39];
	}
	
	private boolean check_Leonie_Bupered_Or_Emergency_Stop_checkEmergency_tr1_tr1() {
		return sCIMira.emergencyStop;
	}
	
	private boolean check_xs__choice_0_tr1_tr1() {
		return getRoundCounter()>=3;
	}
	
	private boolean check_xs__choice_0_tr0_tr0() {
		return true;
	}
	
	private boolean check_xs_STT_and_Tell_Actions_s__choice_0_tr1_tr1() {
		return (sCISTT.operationCallback.getSpokenText()== null?"" !=null : !sCISTT.operationCallback.getSpokenText().equals(""));
	}
	
	private boolean check_xs_STT_and_Tell_Actions_s__choice_0_tr0_tr0() {
		return true;
	}
	
	private boolean check_xs_STT_and_Tell_Actions_s__choice_1_tr0_tr0() {
		return (sCISTT.operationCallback.getAnswer()== null?"yes" ==null :sCISTT.operationCallback.getAnswer().equals("yes"));
	}
	
	private boolean check_xs_STT_and_Tell_Actions_s__choice_1_tr1_tr1() {
		return true;
	}
	
	private boolean check_xs_STT_and_Tell_Actions_s__choice_2_tr0_tr0() {
		return sCISTT.operationCallback.getActionListLength()>0;
	}
	
	private boolean check_xs_STT_and_Tell_Actions_s__choice_2_tr1() {
		return true;
	}
	
	private boolean check_xs_DoAllActions__region0_DoAction_Instructions_GoTo_goto_GeneralP_extended__choice_0_tr1_tr1() {
		return sCIBGF.operationCallback.getGWPByName(sCISTT.operationCallback.getObjectFromActionListAt(getActionCounter()))==-1;
	}
	
	private boolean check_xs_DoAllActions__region0_DoAction_Instructions_GoTo_goto_GeneralP_extended__choice_0_tr0_tr0() {
		return true;
	}
	
	private boolean check_xs_DoAllActions__region0_DoAction_Instructions__choice_0_tr0_tr0() {
		return (sCISTT.operationCallback.getInstructionFromActionListAt(getActionCounter())== null?"goto" ==null :sCISTT.operationCallback.getInstructionFromActionListAt(getActionCounter()).equals("goto"));
	}
	
	private boolean check_xs_DoAllActions__region0_DoAction_Instructions__choice_0_tr1_tr1() {
		return (sCISTT.operationCallback.getInstructionFromActionListAt(getActionCounter())== null?"crowd" ==null :sCISTT.operationCallback.getInstructionFromActionListAt(getActionCounter()).equals("crowd"));
	}
	
	private boolean check_xs_DoAllActions__region0_DoAction_Instructions__choice_0_tr2_tr2() {
		return (sCISTT.operationCallback.getInstructionFromActionListAt(getActionCounter())== null?"surrounding" ==null :sCISTT.operationCallback.getInstructionFromActionListAt(getActionCounter()).equals("surrounding"));
	}
	
	private boolean check_xs_DoAllActions__region0_DoAction_Instructions__choice_0_tr3_tr3() {
		return (sCISTT.operationCallback.getInstructionFromActionListAt(getActionCounter())== null?"bring" ==null :sCISTT.operationCallback.getInstructionFromActionListAt(getActionCounter()).equals("bring"));
	}
	
	private boolean check_xs_DoAllActions__region0_DoAction_Instructions__choice_0_tr4_tr4() {
		return (sCISTT.operationCallback.getInstructionFromActionListAt(getActionCounter())== null?"open" ==null :sCISTT.operationCallback.getInstructionFromActionListAt(getActionCounter()).equals("open"));
	}
	
	private boolean check_xs_DoAllActions__region0_DoAction_Instructions__choice_0_tr5_tr5() {
		return (sCISTT.operationCallback.getInstructionFromActionListAt(getActionCounter())== null?"followme" ==null :sCISTT.operationCallback.getInstructionFromActionListAt(getActionCounter()).equals("followme"));
	}
	
	private boolean check_xs_DoAllActions__region0_DoAction_Instructions__choice_0_tr7_tr7() {
		return (sCISTT.operationCallback.getInstructionFromActionListAt(getActionCounter())== null?"tell" ==null :sCISTT.operationCallback.getInstructionFromActionListAt(getActionCounter()).equals("tell"));
	}
	
	private boolean check_xs_DoAllActions__region0_DoAction_Instructions__choice_0_tr8_tr8() {
		return (sCISTT.operationCallback.getInstructionFromActionListAt(getActionCounter())== null?"question" ==null :sCISTT.operationCallback.getInstructionFromActionListAt(getActionCounter()).equals("question"));
	}
	
	private boolean check_xs_DoAllActions__region0_DoAction_Instructions__choice_0_tr6_tr6() {
		return true;
	}
	
	private boolean check_xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended__choice_0_tr1_tr1() {
		return sCIBGF.operationCallback.getGWPByName(sCISTT.operationCallback.getObjectFromActionListAt(getActionCounter()))==-1;
	}
	
	private boolean check_xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended__choice_0_tr0_tr0() {
		return true;
	}
	
	private boolean check_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking_WaitingForStopCommand__choice_0_tr0_tr0() {
		return (sCISTT.operationCallback.getInstruction()== null?"followme" ==null :sCISTT.operationCallback.getInstruction().equals("followme")) && (sCISTT.operationCallback.getObject()== null?"stop" ==null :sCISTT.operationCallback.getObject().equals("stop"));
	}
	
	private boolean check_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking_WaitingForStopCommand__choice_0_tr1_tr1() {
		return true;
	}
	
	private boolean check_xs_DoAllActions__region0__choice_0_tr1_tr1() {
		return getActionCounter()<sCISTT.operationCallback.getActionListLength();
	}
	
	private boolean check_xs_DoAllActions__region0__choice_0_tr0_tr0() {
		return true;
	}
	
	private boolean check_xs__choice_1_tr0_tr0() {
		return getRoundCounter()>=2;
	}
	
	private boolean check_xs__choice_1_tr1_tr1() {
		return true;
	}
	
	private void effect_xs_Hello_tr0() {
		exitSequence_xs_Hello();
		enterSequence_xs_STT_and_Tell_Actions_default();
	}
	
	private void effect_xs_Hello_tr1() {
		exitSequence_xs_Hello();
		enterSequence_xs_STT_and_Tell_Actions_default();
	}
	
	private void effect_xs_Leave_the_arena_tr0() {
		exitSequence_xs_Leave_the_arena();
		enterSequence_xs_leave2_default();
	}
	
	private void effect_xs_DetectionsOn_tr0() {
		exitSequence_xs_DetectionsOn();
		enterSequence_xs_Hello_default();
	}
	
	private void effect_xs_DetectionsOn_tr1() {
		exitSequence_xs_DetectionsOn();
		enterSequence_xs_Hello_default();
	}
	
	private void effect_xs_Init_tr0() {
		exitSequence_xs_Init();
		enterSequence_xs_DetectionsOn_default();
	}
	
	private void effect_xs_TellAnswer_tr0() {
		exitSequence_xs_TellAnswer();
		enterSequence_xs_StopSTT_default();
	}
	
	private void effect_xs_TellAnswer_tr1() {
		exitSequence_xs_TellAnswer();
		enterSequence_xs_StopSTT_default();
	}
	
	private void effect_xs_StopSTT_tr0() {
		exitSequence_xs_StopSTT();
		react_xs__choice_0();
	}
	
	private void effect_xs_TellIncomprehensible_tr0() {
		exitSequence_xs_TellIncomprehensible();
		enterSequence_xs_StopSTT_default();
	}
	
	private void effect_xs_TellIncomprehensible_tr1() {
		exitSequence_xs_TellIncomprehensible();
		enterSequence_xs_StopSTT_default();
	}
	
	private void effect_xs_STT_and_Tell_Actions_tr0() {
		exitSequence_xs_STT_and_Tell_Actions();
		enterSequence_xs_TellAnswer_default();
	}
	
	private void effect_xs_STT_and_Tell_Actions_tr1() {
		exitSequence_xs_STT_and_Tell_Actions();
		react_xs__choice_1();
	}
	
	private void effect_xs_STT_and_Tell_Actions_tr2() {
		exitSequence_xs_STT_and_Tell_Actions();
		enterSequence_xs_TellIncomprehensible_default();
	}
	
	private void effect_xs_STT_and_Tell_Actions_tr3() {
		exitSequence_xs_STT_and_Tell_Actions();
		enterSequence_xs_TellAnswer_default();
	}
	
	private void effect_xs_STT_and_Tell_Actions_s_StartSTT_tr0() {
		exitSequence_xs_STT_and_Tell_Actions_s_StartSTT();
		react_xs_STT_and_Tell_Actions_s__choice_0();
	}
	
	private void effect_xs_STT_and_Tell_Actions_s_StartSTT_tr1() {
		exitSequence_xs_STT_and_Tell_Actions_s_StartSTT();
		react_xs_STT_and_Tell_Actions_s_exit_incomprehensible();
	}
	
	private void effect_xs_STT_and_Tell_Actions_s_StartSTT_tr2() {
		exitSequence_xs_STT_and_Tell_Actions_s_StartSTT();
		react_xs_STT_and_Tell_Actions_s_exit_incomprehensible();
	}
	
	private void effect_xs_STT_and_Tell_Actions_s_TellSpokenText_tr0() {
		exitSequence_xs_STT_and_Tell_Actions_s_TellSpokenText();
		react_xs_STT_and_Tell_Actions_s_exit_incomprehensible();
	}
	
	private void effect_xs_STT_and_Tell_Actions_s_TellSpokenText_tr1() {
		exitSequence_xs_STT_and_Tell_Actions_s_TellSpokenText();
		enterSequence_xs_STT_and_Tell_Actions_s_YesNo_default();
	}
	
	private void effect_xs_STT_and_Tell_Actions_s_TellSpokenText_tr2() {
		exitSequence_xs_STT_and_Tell_Actions_s_TellSpokenText();
		enterSequence_xs_STT_and_Tell_Actions_s_GeneratedCommand_default();
	}
	
	private void effect_xs_STT_and_Tell_Actions_s_YesNo_tr0() {
		exitSequence_xs_STT_and_Tell_Actions_s_YesNo();
		react_xs_STT_and_Tell_Actions_s__choice_1();
	}
	
	private void effect_xs_STT_and_Tell_Actions_s_YesNo_tr1() {
		exitSequence_xs_STT_and_Tell_Actions_s_YesNo();
		react_xs_STT_and_Tell_Actions_s_exit_correct();
	}
	
	private void effect_xs_STT_and_Tell_Actions_s_GeneratedCommand_tr0() {
		exitSequence_xs_STT_and_Tell_Actions_s_GeneratedCommand();
		react_xs_STT_and_Tell_Actions_s__choice_2();
	}
	
	private void effect_xs_STT_and_Tell_Actions_s_GeneratedCommand_tr1() {
		exitSequence_xs_STT_and_Tell_Actions_s_GeneratedCommand();
		react_xs_STT_and_Tell_Actions_s__choice_2();
	}
	
	private void effect_xs_leave2_tr0() {
		exitSequence_xs_leave2();
		enterSequence_xs_leave3_default();
	}
	
	private void effect_xs_leave2_tr1() {
		exitSequence_xs_leave2();
		enterSequence_xs_leave3_default();
	}
	
	private void effect_xs_leave3_tr0() {
		exitSequence_xs_leave3();
		enterSequence_xs__final__default();
	}
	
	private void effect_xs_DoAllActions_tr0() {
		exitSequence_xs_DoAllActions();
		enterSequence_xs_GoToOp_default();
	}
	
	private void effect_xs_DoAllActions_tr1() {
		exitSequence_xs_DoAllActions();
		enterSequence_xs_time_out_default();
	}
	
	private void effect_xs_DoAllActions__region0_DoAction_tr0() {
		exitSequence_xs_DoAllActions__region0_DoAction();
		react_xs_DoAllActions__region0__choice_0();
	}
	
	private void effect_xs_DoAllActions__region0_DoAction_Instructions_GoTo_tr0() {
		exitSequence_xs_DoAllActions__region0_DoAction_Instructions_GoTo();
		react_xs_DoAllActions__region0_DoAction_Instructions_exit_done();
	}
	
	private void effect_xs_DoAllActions__region0_DoAction_Instructions_GoTo_goto_GeneralP_extended_livingroom_tr0() {
		exitSequence_xs_DoAllActions__region0_DoAction_Instructions_GoTo_goto_GeneralP_extended_livingroom();
		enterSequence_xs_DoAllActions__region0_DoAction_Instructions_GoTo_goto_GeneralP_extended_arrived_default();
	}
	
	private void effect_xs_DoAllActions__region0_DoAction_Instructions_GoTo_goto_GeneralP_extended_livingroom_tr1() {
		exitSequence_xs_DoAllActions__region0_DoAction_Instructions_GoTo_goto_GeneralP_extended_livingroom();
		enterSequence_xs_DoAllActions__region0_DoAction_Instructions_GoTo_goto_GeneralP_extended_notArrived_default();
	}
	
	private void effect_xs_DoAllActions__region0_DoAction_Instructions_GoTo_goto_GeneralP_extended_livingroom_tr2() {
		exitSequence_xs_DoAllActions__region0_DoAction_Instructions_GoTo_goto_GeneralP_extended_livingroom();
		enterSequence_xs_DoAllActions__region0_DoAction_Instructions_GoTo_goto_GeneralP_extended_notArrived_default();
	}
	
	private void effect_xs_DoAllActions__region0_DoAction_Instructions_GoTo_goto_GeneralP_extended_notFound_tr0() {
		exitSequence_xs_DoAllActions__region0_DoAction_Instructions_GoTo_goto_GeneralP_extended_notFound();
		react_xs_DoAllActions__region0_DoAction_Instructions_GoTo_goto_GeneralP_extended_exit_done();
	}
	
	private void effect_xs_DoAllActions__region0_DoAction_Instructions_GoTo_goto_GeneralP_extended_notFound_tr1() {
		exitSequence_xs_DoAllActions__region0_DoAction_Instructions_GoTo_goto_GeneralP_extended_notFound();
		react_xs_DoAllActions__region0_DoAction_Instructions_GoTo_goto_GeneralP_extended_exit_done();
	}
	
	private void effect_xs_DoAllActions__region0_DoAction_Instructions_GoTo_goto_GeneralP_extended_arrived_tr0() {
		exitSequence_xs_DoAllActions__region0_DoAction_Instructions_GoTo_goto_GeneralP_extended_arrived();
		react_xs_DoAllActions__region0_DoAction_Instructions_GoTo_goto_GeneralP_extended_exit_done();
	}
	
	private void effect_xs_DoAllActions__region0_DoAction_Instructions_GoTo_goto_GeneralP_extended_arrived_tr1() {
		exitSequence_xs_DoAllActions__region0_DoAction_Instructions_GoTo_goto_GeneralP_extended_arrived();
		react_xs_DoAllActions__region0_DoAction_Instructions_GoTo_goto_GeneralP_extended_exit_done();
	}
	
	private void effect_xs_DoAllActions__region0_DoAction_Instructions_GoTo_goto_GeneralP_extended_backToTheOperator_tr0() {
		exitSequence_xs_DoAllActions__region0_DoAction_Instructions_GoTo_goto_GeneralP_extended_backToTheOperator();
		react_xs_DoAllActions__region0_DoAction_Instructions_GoTo_goto_GeneralP_extended_exit_done();
	}
	
	private void effect_xs_DoAllActions__region0_DoAction_Instructions_GoTo_goto_GeneralP_extended_backToTheOperator_tr1() {
		exitSequence_xs_DoAllActions__region0_DoAction_Instructions_GoTo_goto_GeneralP_extended_backToTheOperator();
		react_xs_DoAllActions__region0_DoAction_Instructions_GoTo_goto_GeneralP_extended_exit_done();
	}
	
	private void effect_xs_DoAllActions__region0_DoAction_Instructions_GoTo_goto_GeneralP_extended_backToTheOperator_tr2() {
		exitSequence_xs_DoAllActions__region0_DoAction_Instructions_GoTo_goto_GeneralP_extended_backToTheOperator();
		react_xs_DoAllActions__region0_DoAction_Instructions_GoTo_goto_GeneralP_extended_exit_done();
	}
	
	private void effect_xs_DoAllActions__region0_DoAction_Instructions_GoTo_goto_GeneralP_extended_notArrived_tr0() {
		exitSequence_xs_DoAllActions__region0_DoAction_Instructions_GoTo_goto_GeneralP_extended_notArrived();
		enterSequence_xs_DoAllActions__region0_DoAction_Instructions_GoTo_goto_GeneralP_extended_backToTheOperator_default();
	}
	
	private void effect_xs_DoAllActions__region0_DoAction_Instructions_GoTo_goto_GeneralP_extended_notArrived_tr1() {
		exitSequence_xs_DoAllActions__region0_DoAction_Instructions_GoTo_goto_GeneralP_extended_notArrived();
		enterSequence_xs_DoAllActions__region0_DoAction_Instructions_GoTo_goto_GeneralP_extended_backToTheOperator_default();
	}
	
	private void effect_xs_DoAllActions__region0_DoAction_Instructions_surrounding_tr0() {
		exitSequence_xs_DoAllActions__region0_DoAction_Instructions_surrounding();
		react_xs_DoAllActions__region0_DoAction_Instructions_exit_done();
	}
	
	private void effect_xs_DoAllActions__region0_DoAction_Instructions_bring_tr0() {
		exitSequence_xs_DoAllActions__region0_DoAction_Instructions_bring();
		react_xs_DoAllActions__region0_DoAction_Instructions_exit_done();
	}
	
	private void effect_xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_livingroom_tr0() {
		exitSequence_xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_livingroom();
		enterSequence_xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_arrived_default();
	}
	
	private void effect_xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_livingroom_tr1() {
		exitSequence_xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_livingroom();
		enterSequence_xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_notArrived_default();
	}
	
	private void effect_xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_livingroom_tr2() {
		exitSequence_xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_livingroom();
		enterSequence_xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_notArrived_default();
	}
	
	private void effect_xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_notFound_tr0() {
		exitSequence_xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_notFound();
		react_xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_exit_done();
	}
	
	private void effect_xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_notFound_tr1() {
		exitSequence_xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_notFound();
		react_xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_exit_done();
	}
	
	private void effect_xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_arrived_tr0() {
		exitSequence_xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_arrived();
		react_xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_exit_done();
	}
	
	private void effect_xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_arrived_tr1() {
		exitSequence_xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_arrived();
		react_xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_exit_done();
	}
	
	private void effect_xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_backToTheOperator_tr0() {
		exitSequence_xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_backToTheOperator();
		react_xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_exit_done();
	}
	
	private void effect_xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_backToTheOperator_tr1() {
		exitSequence_xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_backToTheOperator();
		react_xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_exit_done();
	}
	
	private void effect_xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_backToTheOperator_tr2() {
		exitSequence_xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_backToTheOperator();
		react_xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_exit_done();
	}
	
	private void effect_xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_bringGehtnicht_tr0() {
		exitSequence_xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_bringGehtnicht();
		react_xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended__choice_0();
	}
	
	private void effect_xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_bringGehtnicht_tr1() {
		exitSequence_xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_bringGehtnicht();
		react_xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended__choice_0();
	}
	
	private void effect_xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_stattdessen_goto_tr0() {
		exitSequence_xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_stattdessen_goto();
		enterSequence_xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_livingroom_default();
	}
	
	private void effect_xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_notArrived_tr0() {
		exitSequence_xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_notArrived();
		enterSequence_xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_backToTheOperator_default();
	}
	
	private void effect_xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_notArrived_tr1() {
		exitSequence_xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_notArrived();
		enterSequence_xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_backToTheOperator_default();
	}
	
	private void effect_xs_DoAllActions__region0_DoAction_Instructions_open_tr0() {
		exitSequence_xs_DoAllActions__region0_DoAction_Instructions_open();
		react_xs_DoAllActions__region0_DoAction_Instructions_exit_done();
	}
	
	private void effect_xs_DoAllActions__region0_DoAction_Instructions_open_tr1() {
		exitSequence_xs_DoAllActions__region0_DoAction_Instructions_open();
		react_xs_DoAllActions__region0_DoAction_Instructions_exit_done();
	}
	
	private void effect_xs_DoAllActions__region0_DoAction_Instructions_followme_tr0() {
		exitSequence_xs_DoAllActions__region0_DoAction_Instructions_followme();
		react_xs_DoAllActions__region0_DoAction_Instructions_exit_done();
	}
	
	private void effect_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking_tr0() {
		exitSequence_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking();
		enterSequence_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_default();
	}
	
	private void effect_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking_tr1() {
		exitSequence_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking();
		enterSequence_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_HowCanIHelpYou_default();
	}
	
	private void effect_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking_tr2() {
		exitSequence_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking();
		enterSequence_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_HowCanIHelpYou_default();
	}
	
	private void effect_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking_WaitingForStopCommand_STToff_tr0() {
		exitSequence_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking_WaitingForStopCommand_STToff();
		react_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking_WaitingForStopCommand__choice_0();
	}
	
	private void effect_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking_WaitingForStopCommand_STToff_tr1() {
		exitSequence_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking_WaitingForStopCommand_STToff();
		enterSequence_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking_WaitingForStopCommand_STTstart_default();
	}
	
	private void effect_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking_WaitingForStopCommand_STTstart_tr0() {
		exitSequence_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking_WaitingForStopCommand_STTstart();
		enterSequence_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking_WaitingForStopCommand_STToff_default();
	}
	
	private void effect_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking_WaitingForStopCommand_STTstart_tr1() {
		exitSequence_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking_WaitingForStopCommand_STTstart();
		react_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking_WaitingForStopCommand__choice_0();
	}
	
	private void effect_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_tr0() {
		exitSequence_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave();
		enterSequence_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking_default();
	}
	
	private void effect_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_tr1() {
		exitSequence_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave();
		enterSequence_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_no_default();
	}
	
	private void effect_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_UTurn1_tr0() {
		exitSequence_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_UTurn1();
		enterSequence_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_Turn_default();
	}
	
	private void effect_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_WaveFound_tr0() {
		exitSequence_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_WaveFound();
		enterSequence_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_UTurn2_default();
	}
	
	private void effect_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_Turn_tr0() {
		exitSequence_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_Turn();
		enterSequence_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_WaveFound_default();
	}
	
	private void effect_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_Turn_tr1() {
		exitSequence_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_Turn();
		enterSequence_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_Turn_default();
	}
	
	private void effect_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_DetectionOn_tr0() {
		exitSequence_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_DetectionOn();
		enterSequence_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_Detection_default();
	}
	
	private void effect_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_PersonFound_tr0() {
		exitSequence_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_PersonFound();
		react_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_exit_done();
	}
	
	private void effect_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_ILostYou_tr0() {
		exitSequence_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_ILostYou();
		enterSequence_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_UTurn1_default();
	}
	
	private void effect_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_ILostYou_tr1() {
		exitSequence_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_ILostYou();
		enterSequence_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_UTurn1_default();
	}
	
	private void effect_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_UTurn2_tr0() {
		exitSequence_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_UTurn2();
		enterSequence_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_DetectionOn_default();
	}
	
	private void effect_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_Detection_tr0() {
		exitSequence_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_Detection();
		enterSequence_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_Detection_default();
	}
	
	private void effect_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_Detection_tr1() {
		exitSequence_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_Detection();
		enterSequence_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_PersonFound_default();
	}
	
	private void effect_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_Detection_tr2() {
		exitSequence_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_Detection();
		enterSequence_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_NotFound_default();
	}
	
	private void effect_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_NotFound_tr0() {
		exitSequence_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_NotFound();
		enterSequence_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_Detection_default();
	}
	
	private void effect_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Detect_tr0() {
		exitSequence_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Detect();
		enterSequence_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking_default();
	}
	
	private void effect_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Detect_tr1() {
		exitSequence_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Detect();
		enterSequence_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_no_default();
	}
	
	private void effect_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_no_tr0() {
		exitSequence_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_no();
		react_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_exit_done();
	}
	
	private void effect_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_HowCanIHelpYou_tr0() {
		exitSequence_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_HowCanIHelpYou();
		react_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_exit_done();
	}
	
	private void effect_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wir_brauchen_das_gerade_nicht_tr0() {
		exitSequence_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wir_brauchen_das_gerade_nicht();
		enterSequence_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Detect_default();
	}
	
	private void effect_xs_DoAllActions__region0_DoAction_Instructions_unknown_tr0() {
		exitSequence_xs_DoAllActions__region0_DoAction_Instructions_unknown();
		react_xs_DoAllActions__region0_DoAction_Instructions_exit_done();
	}
	
	private void effect_xs_DoAllActions__region0_DoAction_Instructions_unknown_tr1() {
		exitSequence_xs_DoAllActions__region0_DoAction_Instructions_unknown();
		react_xs_DoAllActions__region0_DoAction_Instructions_exit_done();
	}
	
	private void effect_xs_DoAllActions__region0_DoAction_Instructions_crowd_tr0() {
		exitSequence_xs_DoAllActions__region0_DoAction_Instructions_crowd();
		react_xs_DoAllActions__region0_DoAction_Instructions_exit_done();
	}
	
	private void effect_xs_DoAllActions__region0_DoAction_Instructions_crowd_tr1() {
		exitSequence_xs_DoAllActions__region0_DoAction_Instructions_crowd();
		react_xs_DoAllActions__region0_DoAction_Instructions_exit_done();
	}
	
	private void effect_xs_DoAllActions__region0_DoAction_Instructions_tell_tr0() {
		exitSequence_xs_DoAllActions__region0_DoAction_Instructions_tell();
		react_xs_DoAllActions__region0_DoAction_Instructions_exit_done();
	}
	
	private void effect_xs_DoAllActions__region0_DoAction_Instructions_tell_tr1() {
		exitSequence_xs_DoAllActions__region0_DoAction_Instructions_tell();
		react_xs_DoAllActions__region0_DoAction_Instructions_exit_done();
	}
	
	private void effect_xs_DoAllActions__region0_DoAction_Instructions_question_tr0() {
		exitSequence_xs_DoAllActions__region0_DoAction_Instructions_question();
		react_xs_DoAllActions__region0_DoAction_Instructions_exit_done();
	}
	
	private void effect_xs_GoToOp_tr0() {
		exitSequence_xs_GoToOp();
		enterSequence_xs_StopSTT_default();
	}
	
	private void effect_xs_GoToOp_tr1() {
		exitSequence_xs_GoToOp();
		enterSequence_xs_blocked_default();
	}
	
	private void effect_xs_GoToOp_tr2() {
		exitSequence_xs_GoToOp();
		enterSequence_xs_blocked_default();
	}
	
	private void effect_xs_blocked_tr0() {
		exitSequence_xs_blocked();
		enterSequence_xs_StopSTT_default();
	}
	
	private void effect_xs_blocked_tr1() {
		exitSequence_xs_blocked();
		enterSequence_xs_StopSTT_default();
	}
	
	private void effect_xs_time_out_tr0() {
		exitSequence_xs_time_out();
		enterSequence_xs_GoToOp_default();
	}
	
	private void effect_xs_DontDoIt_tr0() {
		exitSequence_xs_DontDoIt();
		enterSequence_xs_StopSTT_default();
	}
	
	private void effect_xs_DontDoIt_tr1() {
		exitSequence_xs_DontDoIt();
		enterSequence_xs_StopSTT_default();
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
	
	private void effect_xs__choice_0_tr1() {
		enterSequence_xs_Leave_the_arena_default();
	}
	
	private void effect_xs__choice_0_tr0() {
		enterSequence_xs_Hello_default();
	}
	
	private void effect_xs_STT_and_Tell_Actions_s__choice_0_tr1() {
		enterSequence_xs_STT_and_Tell_Actions_s_TellSpokenText_default();
	}
	
	private void effect_xs_STT_and_Tell_Actions_s__choice_0_tr0() {
		react_xs_STT_and_Tell_Actions_s_exit_incomprehensible();
	}
	
	private void effect_xs_STT_and_Tell_Actions_s__choice_1_tr0() {
		enterSequence_xs_STT_and_Tell_Actions_s_GeneratedCommand_default();
	}
	
	private void effect_xs_STT_and_Tell_Actions_s__choice_1_tr1() {
		react_xs_STT_and_Tell_Actions_s_exit_incorrect();
	}
	
	private void effect_xs_STT_and_Tell_Actions_s__choice_2_tr0() {
		react_xs_STT_and_Tell_Actions_s_exit_correct();
	}
	
	private void effect_xs_STT_and_Tell_Actions_s__choice_2_tr1() {
		react_xs_STT_and_Tell_Actions_s_exit_noActions();
	}
	
	private void effect_xs_DoAllActions__region0_DoAction_Instructions_GoTo_goto_GeneralP_extended__choice_0_tr1() {
		enterSequence_xs_DoAllActions__region0_DoAction_Instructions_GoTo_goto_GeneralP_extended_notFound_default();
	}
	
	private void effect_xs_DoAllActions__region0_DoAction_Instructions_GoTo_goto_GeneralP_extended__choice_0_tr0() {
		enterSequence_xs_DoAllActions__region0_DoAction_Instructions_GoTo_goto_GeneralP_extended_livingroom_default();
	}
	
	private void effect_xs_DoAllActions__region0_DoAction_Instructions__choice_0_tr0() {
		enterSequence_xs_DoAllActions__region0_DoAction_Instructions_GoTo_default();
	}
	
	private void effect_xs_DoAllActions__region0_DoAction_Instructions__choice_0_tr1() {
		enterSequence_xs_DoAllActions__region0_DoAction_Instructions_crowd_default();
	}
	
	private void effect_xs_DoAllActions__region0_DoAction_Instructions__choice_0_tr2() {
		enterSequence_xs_DoAllActions__region0_DoAction_Instructions_surrounding_default();
	}
	
	private void effect_xs_DoAllActions__region0_DoAction_Instructions__choice_0_tr3() {
		enterSequence_xs_DoAllActions__region0_DoAction_Instructions_bring_default();
	}
	
	private void effect_xs_DoAllActions__region0_DoAction_Instructions__choice_0_tr4() {
		enterSequence_xs_DoAllActions__region0_DoAction_Instructions_open_default();
	}
	
	private void effect_xs_DoAllActions__region0_DoAction_Instructions__choice_0_tr5() {
		enterSequence_xs_DoAllActions__region0_DoAction_Instructions_followme_default();
	}
	
	private void effect_xs_DoAllActions__region0_DoAction_Instructions__choice_0_tr7() {
		enterSequence_xs_DoAllActions__region0_DoAction_Instructions_tell_default();
	}
	
	private void effect_xs_DoAllActions__region0_DoAction_Instructions__choice_0_tr8() {
		enterSequence_xs_DoAllActions__region0_DoAction_Instructions_question_default();
	}
	
	private void effect_xs_DoAllActions__region0_DoAction_Instructions__choice_0_tr6() {
		enterSequence_xs_DoAllActions__region0_DoAction_Instructions_unknown_default();
	}
	
	private void effect_xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended__choice_0_tr1() {
		enterSequence_xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_notFound_default();
	}
	
	private void effect_xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended__choice_0_tr0() {
		enterSequence_xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_stattdessen_goto_default();
	}
	
	private void effect_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking_WaitingForStopCommand__choice_0_tr0() {
		react_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking_WaitingForStopCommand_exit_arrived();
	}
	
	private void effect_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking_WaitingForStopCommand__choice_0_tr1() {
		enterSequence_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking_WaitingForStopCommand_STTstart_default();
	}
	
	private void effect_xs_DoAllActions__region0__choice_0_tr1() {
		enterSequence_xs_DoAllActions__region0_DoAction_default();
	}
	
	private void effect_xs_DoAllActions__region0__choice_0_tr0() {
		react_xs_DoAllActions__region0_exit_done();
	}
	
	private void effect_xs__choice_1_tr0() {
		enterSequence_xs_DoAllActions_default();
	}
	
	private void effect_xs__choice_1_tr1() {
		enterSequence_xs_DontDoIt_default();
	}
	
	/* Entry action for state 'Hello'. */
	private void entryAction_xs_Hello() {
		timer.setTimer(this, 0, 10*1000, false);
		
		sCICrowdDetection.operationCallback.sendDetectionOff();
		
		sCIHBrain.operationCallback.sendTTS("[blush:false][:-)] What can I do for you? [attentive]");
		
		setActionCounter(0);
	}
	
	/* Entry action for state 'Leave the arena'. */
	private void entryAction_xs_Leave_the_arena() {
		sCIHBrain.operationCallback.sendTTS("[blush:false]I hope, I was of any help! [:-)] Bye bye.");
		
		sCIMira.operationCallback.sendGoToGWP(0);
	}
	
	/* Entry action for state 'DetectionsOn'. */
	private void entryAction_xs_DetectionsOn() {
		timer.setTimer(this, 1, 10*1000, false);
		
		sCICrowdDetection.operationCallback.sendDetectionOn();
	}
	
	/* Entry action for state 'Init'. */
	private void entryAction_xs_Init() {
		setGWPout(13);
		
		setGWPstart(12);
		
		setActionCounter(0);
		
		setRoundCounter(0);
		
		sCIMira.operationCallback.sendGoToGWP(getGWPstart());
	}
	
	/* Entry action for state 'TellAnswer'. */
	private void entryAction_xs_TellAnswer() {
		timer.setTimer(this, 2, 10*1000, false);
		
		sCIHBrain.operationCallback.sendTTS("[:-(] Can you please try it again?");
	}
	
	/* Entry action for state 'TellIncomprehensible'. */
	private void entryAction_xs_TellIncomprehensible() {
		timer.setTimer(this, 3, 10*1000, false);
		
		sCIHBrain.operationCallback.sendTTS3("[:-(]", sCISTT.operationCallback.getAnswer(), "[:-|]");
	}
	
	/* Entry action for state 'StartSTT'. */
	private void entryAction_xs_STT_and_Tell_Actions_s_StartSTT() {
		timer.setTimer(this, 4, 30*1000, false);
		
		sCISTT.operationCallback.sendSpeechDetectionActions(8);
		
		sCIHBrain.operationCallback.sendTTS("[attentive]");
	}
	
	/* Entry action for state 'TellSpokenText'. */
	private void entryAction_xs_STT_and_Tell_Actions_s_TellSpokenText() {
		timer.setTimer(this, 5, 60*1000, false);
		
		sCIHBrain.operationCallback.sendTTS3("I unterstood: ", sCISTT.operationCallback.getSpokenText(), ". Is that right?");
	}
	
	/* Entry action for state 'YesNo'. */
	private void entryAction_xs_STT_and_Tell_Actions_s_YesNo() {
		timer.setTimer(this, 6, 15*1000, false);
		
		sCISTT.operationCallback.sendSpeechDetectionYesNo(3);
	}
	
	/* Entry action for state 'GeneratedCommand'. */
	private void entryAction_xs_STT_and_Tell_Actions_s_GeneratedCommand() {
		timer.setTimer(this, 7, 60*1000, false);
		
		sCIHBrain.operationCallback.sendTTS2("Okay. ", sCISTT.operationCallback.getActionCommandSentence());
	}
	
	/* Entry action for state 'leave2'. */
	private void entryAction_xs_leave2() {
		timer.setTimer(this, 8, 10*1000, false);
		
		sCIHBrain.operationCallback.sendTTS("[:-0] Thanks for your attention. I wish you a nice day at the German Open. [:-)]");
	}
	
	/* Entry action for state 'leave3'. */
	private void entryAction_xs_leave3() {
		sCIMira.operationCallback.sendGoToGWP(getGWPout());
	}
	
	/* Entry action for state 'DoAllActions'. */
	private void entryAction_xs_DoAllActions() {
		timer.setTimer(this, 9, 150*1000, false);
	}
	
	/* Entry action for state 'GoTo'. */
	private void entryAction_xs_DoAllActions__region0_DoAction_Instructions_GoTo() {
		sCIHBrain.operationCallback.sendTTS3("[:-)] I go to ", sCISTT.operationCallback.getLocationFromActionListAt(getActionCounter()), ". [:-|]");
	}
	
	/* Entry action for state 'livingroom'. */
	private void entryAction_xs_DoAllActions__region0_DoAction_Instructions_GoTo_goto_GeneralP_extended_livingroom() {
		timer.setTimer(this, 10, 60*1000, false);
		
		sCIMira.operationCallback.sendGoToGWP(sCIBGF.operationCallback.getGWPByName(sCISTT.operationCallback.getObjectFromActionListAt(getActionCounter())));
	}
	
	/* Entry action for state 'notFound'. */
	private void entryAction_xs_DoAllActions__region0_DoAction_Instructions_GoTo_goto_GeneralP_extended_notFound() {
		timer.setTimer(this, 11, 10*1000, false);
		
		sCIHBrain.operationCallback.sendTTS3("I don't know a location called ", sCISTT.operationCallback.getObjectFromActionListAt(getActionCounter()), ".");
	}
	
	/* Entry action for state 'arrived'. */
	private void entryAction_xs_DoAllActions__region0_DoAction_Instructions_GoTo_goto_GeneralP_extended_arrived() {
		timer.setTimer(this, 12, 10*1000, false);
		
		sCIHBrain.operationCallback.sendTTS3("I arrived at ", sCISTT.operationCallback.getObjectFromActionListAt(getActionCounter()), ".");
	}
	
	/* Entry action for state 'backToTheOperator'. */
	private void entryAction_xs_DoAllActions__region0_DoAction_Instructions_GoTo_goto_GeneralP_extended_backToTheOperator() {
		timer.setTimer(this, 13, 100*1000, false);
		
		sCIMira.operationCallback.sendGoToGWP(getGWPstart());
		
		sCIHBrain.operationCallback.sendTTS("Now, I'm going back to my operator.");
	}
	
	/* Entry action for state 'notArrived'. */
	private void entryAction_xs_DoAllActions__region0_DoAction_Instructions_GoTo_goto_GeneralP_extended_notArrived() {
		timer.setTimer(this, 14, 10*1000, false);
		
		sCIHBrain.operationCallback.sendTTS("I am not able to reach my destination. I will go back to my operator.");
	}
	
	/* Entry action for state 'livingroom'. */
	private void entryAction_xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_livingroom() {
		timer.setTimer(this, 15, 60*1000, false);
		
		sCIMira.operationCallback.sendGoToGWP(sCIBGF.operationCallback.getGWPByName(sCISTT.operationCallback.getObjectFromActionListAt(getActionCounter())));
	}
	
	/* Entry action for state 'notFound'. */
	private void entryAction_xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_notFound() {
		timer.setTimer(this, 16, 10*1000, false);
		
		sCIHBrain.operationCallback.sendTTS3("Furthermore, I don't know a location for ", sCISTT.operationCallback.getObjectFromActionListAt(getActionCounter()), ".");
	}
	
	/* Entry action for state 'arrived'. */
	private void entryAction_xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_arrived() {
		timer.setTimer(this, 17, 10*1000, false);
		
		sCIHBrain.operationCallback.sendTTS3("Here can you find the ", sCISTT.operationCallback.getObjectFromActionListAt(getActionCounter()), ".");
	}
	
	/* Entry action for state 'backToTheOperator'. */
	private void entryAction_xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_backToTheOperator() {
		timer.setTimer(this, 18, 100*1000, false);
		
		sCIMira.operationCallback.sendGoToGWP(getGWPstart());
		
		sCIHBrain.operationCallback.sendTTS("Now, I'm going back.");
	}
	
	/* Entry action for state 'bringGehtnicht'. */
	private void entryAction_xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_bringGehtnicht() {
		timer.setTimer(this, 19, 10*1000, false);
		
		sCIHBrain.operationCallback.sendTTS("[:-(] I'm sorry. I can't bring you something, because I have no manipulator. [:-)]");
	}
	
	/* Entry action for state 'stattdessen goto'. */
	private void entryAction_xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_stattdessen_goto() {
		sCIHBrain.operationCallback.sendTTS("But I will show you, where it is. Come with me! [:-)]");
	}
	
	/* Entry action for state 'notArrived'. */
	private void entryAction_xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_notArrived() {
		timer.setTimer(this, 20, 10*1000, false);
		
		sCIHBrain.operationCallback.sendTTS("I am not able to reach my destination. I will go back to my operator.");
	}
	
	/* Entry action for state 'open'. */
	private void entryAction_xs_DoAllActions__region0_DoAction_Instructions_open() {
		timer.setTimer(this, 21, 10*1000, false);
		
		sCIHBrain.operationCallback.sendTTS("[:-(] I'm sorry. I can't open something because I have no manipulator.");
	}
	
	/* Entry action for state 'followme'. */
	private void entryAction_xs_DoAllActions__region0_DoAction_Instructions_followme() {
		sCIHBrain.operationCallback.sendTTS("[:-(] I'm sorry. I can't follow somebody at the moment.");
	}
	
	/* Entry action for state 'StartTracking'. */
	private void entryAction_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking() {
		timer.setTimer(this, 22, 30*1000, false);
		
		sCIFollowMe.operationCallback.sendTrackingOnAtNext();
		
		sCIHBrain.operationCallback.sendTTS("Okay, I follow you!");
	}
	
	/* Entry action for state 'STToff'. */
	private void entryAction_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking_WaitingForStopCommand_STToff() {
		timer.setTimer(this, 23, 2*1000, false);
		
		sCIHBrain.operationCallback.sendTTS("[:-)]");
	}
	
	/* Entry action for state 'STTstart'. */
	private void entryAction_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking_WaitingForStopCommand_STTstart() {
		timer.setTimer(this, 24, 5*1000, false);
		
		sCISTT.operationCallback.sendSpeechDetectionSmalltalk(10);
		
		sCIHBrain.operationCallback.sendTTS("[attentive]");
	}
	
	/* Entry action for state 'Wave'. */
	private void entryAction_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave() {
		timer.setTimer(this, 25, 10*1000, false);
	}
	
	/* Entry action for state 'UTurn1'. */
	private void entryAction_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_UTurn1() {
		timer.setTimer(this, 26, 1*1000, false);
		
		sCIMira.operationCallback.sendBodyUTurn();
	}
	
	/* Entry action for state 'WaveFound'. */
	private void entryAction_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_WaveFound() {
		sCIHBrain.operationCallback.sendTTS("{Person}Thank you! Please hold on.");
		
		sCIKinect2.operationCallback.sendWavingDetectionOnOff(false);
	}
	
	/* Entry action for state 'Turn'. */
	private void entryAction_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_Turn() {
		timer.setTimer(this, 27, 5*1000, false);
		
		sCIKinect2.operationCallback.sendWavingDetectionOnOff(true);
		
		sCIHBrain.operationCallback.sendTTS("[:-|] Please wave for me.");
	}
	
	/* Entry action for state 'DetectionOn'. */
	private void entryAction_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_DetectionOn() {
		sCIFollowMe.operationCallback.sendDetectionOn();
		
		setActionCounter(0);
	}
	
	/* Entry action for state 'PersonFound'. */
	private void entryAction_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_PersonFound() {
		sCIHBrain.operationCallback.sendTTS("[:-)] Okay, let's go on!");
	}
	
	/* Entry action for state 'ILostYou'. */
	private void entryAction_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_ILostYou() {
		timer.setTimer(this, 28, 5*1000, false);
		
		sCIFollowMe.operationCallback.sendTrackingOff();
		
		sCIHBrain.operationCallback.sendTTS("[-.-] I lost you!{180;0}");
	}
	
	/* Entry action for state 'UTurn2'. */
	private void entryAction_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_UTurn2() {
		timer.setTimer(this, 29, 3*1000, false);
		
		sCIMira.operationCallback.sendBodyUTurn();
	}
	
	/* Entry action for state 'Detection'. */
	private void entryAction_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_Detection() {
		timer.setTimer(this, 30, 1*1000, false);
		
		sCIFollowMe.operationCallback.sendRequestDetectionDetails();
		
		setActionCounter(actionCounter+1);
	}
	
	/* Entry action for state 'NotFound'. */
	private void entryAction_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_NotFound() {
		sCIHBrain.operationCallback.sendTTS("[:-(] Please get into my view!");
		
		setActionCounter(0);
	}
	
	/* Entry action for state 'Detect'. */
	private void entryAction_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Detect() {
		timer.setTimer(this, 31, 5*1000, false);
		
		sCIFollowMe.operationCallback.sendDetectionOff();
	}
	
	/* Entry action for state 'no'. */
	private void entryAction_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_no() {
		sCIHBrain.operationCallback.sendTTS("I found no Person for following.");
		
		sCIFollowMe.operationCallback.sendTrackingOff();
		
		sCIFollowMe.operationCallback.sendDetectionOff();
		
		sCIMira.operationCallback.sendGoToGWP(getGWPstart());
	}
	
	/* Entry action for state 'HowCanIHelpYou'. */
	private void entryAction_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_HowCanIHelpYou() {
		sCIFollowMe.operationCallback.sendTrackingOff();
		
		sCIFollowMe.operationCallback.sendDetectionOff();
		
		sCIHBrain.operationCallback.sendTTS("[:-)] Okay. Nice to be here. I will go back.");
		
		sCIMira.operationCallback.sendGoToGWP(getGWPstart());
	}
	
	/* Entry action for state 'unknown'. */
	private void entryAction_xs_DoAllActions__region0_DoAction_Instructions_unknown() {
		timer.setTimer(this, 32, 10*1000, false);
		
		sCIHBrain.operationCallback.sendTTS("[:-|] I'm sorry. This command is unknown.");
	}
	
	/* Entry action for state 'crowd'. */
	private void entryAction_xs_DoAllActions__region0_DoAction_Instructions_crowd() {
		timer.setTimer(this, 33, 10*1000, false);
		
		sCIHBrain.operationCallback.sendTTS("I cannot detect the crowd in this moment.");
	}
	
	/* Entry action for state 'tell'. */
	private void entryAction_xs_DoAllActions__region0_DoAction_Instructions_tell() {
		timer.setTimer(this, 34, 20*1000, false);
		
		sCIHBrain.operationCallback.sendTTS2(sCISTT.operationCallback.getObjectFromActionListAt(getActionCounter()), " [:-|]");
	}
	
	/* Entry action for state 'GoToOp'. */
	private void entryAction_xs_GoToOp() {
		timer.setTimer(this, 35, 100*1000, false);
		
		sCIMira.operationCallback.sendGoToGWP(getGWPstart());
	}
	
	/* Entry action for state 'blocked'. */
	private void entryAction_xs_blocked() {
		timer.setTimer(this, 36, 10*1000, false);
		
		sCIHBrain.operationCallback.sendTTS("I am not able to come back to the operator. Please tell me my next command here.");
	}
	
	/* Entry action for state 'time out'. */
	private void entryAction_xs_time_out() {
		sCIHBrain.operationCallback.sendTTS("Time out for this task. Lets go on with the next one.");
	}
	
	/* Entry action for state 'DontDoIt'. */
	private void entryAction_xs_DontDoIt() {
		timer.setTimer(this, 37, 10*1000, false);
		
		sCIHBrain.operationCallback.sendTTS("[blush:true]I feel too shy to do that.");
	}
	
	/* Entry action for state 'Bumpered'. */
	private void entryAction_Leonie_Bupered_Or_Emergency_Stop_Bumpered() {
		timer.setTimer(this, 38, 3*1000, false);
		
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
		timer.setTimer(this, 39, 3*1000, false);
	}
	
	/* Exit action for state 'Hello'. */
	private void exitAction_xs_Hello() {
		timer.unsetTimer(this, 0);
	}
	
	/* Exit action for state 'DetectionsOn'. */
	private void exitAction_xs_DetectionsOn() {
		timer.unsetTimer(this, 1);
	}
	
	/* Exit action for state 'TellAnswer'. */
	private void exitAction_xs_TellAnswer() {
		timer.unsetTimer(this, 2);
	}
	
	/* Exit action for state 'TellIncomprehensible'. */
	private void exitAction_xs_TellIncomprehensible() {
		timer.unsetTimer(this, 3);
	}
	
	/* Exit action for state 'StartSTT'. */
	private void exitAction_xs_STT_and_Tell_Actions_s_StartSTT() {
		timer.unsetTimer(this, 4);
	}
	
	/* Exit action for state 'TellSpokenText'. */
	private void exitAction_xs_STT_and_Tell_Actions_s_TellSpokenText() {
		timer.unsetTimer(this, 5);
	}
	
	/* Exit action for state 'YesNo'. */
	private void exitAction_xs_STT_and_Tell_Actions_s_YesNo() {
		timer.unsetTimer(this, 6);
	}
	
	/* Exit action for state 'GeneratedCommand'. */
	private void exitAction_xs_STT_and_Tell_Actions_s_GeneratedCommand() {
		timer.unsetTimer(this, 7);
	}
	
	/* Exit action for state 'leave2'. */
	private void exitAction_xs_leave2() {
		timer.unsetTimer(this, 8);
	}
	
	/* Exit action for state 'DoAllActions'. */
	private void exitAction_xs_DoAllActions() {
		timer.unsetTimer(this, 9);
		
		setRoundCounter(getRoundCounter() + 1);
	}
	
	/* Exit action for state 'DoAction'. */
	private void exitAction_xs_DoAllActions__region0_DoAction() {
		setActionCounter(actionCounter+1);
	}
	
	/* Exit action for state 'livingroom'. */
	private void exitAction_xs_DoAllActions__region0_DoAction_Instructions_GoTo_goto_GeneralP_extended_livingroom() {
		timer.unsetTimer(this, 10);
	}
	
	/* Exit action for state 'notFound'. */
	private void exitAction_xs_DoAllActions__region0_DoAction_Instructions_GoTo_goto_GeneralP_extended_notFound() {
		timer.unsetTimer(this, 11);
	}
	
	/* Exit action for state 'arrived'. */
	private void exitAction_xs_DoAllActions__region0_DoAction_Instructions_GoTo_goto_GeneralP_extended_arrived() {
		timer.unsetTimer(this, 12);
	}
	
	/* Exit action for state 'backToTheOperator'. */
	private void exitAction_xs_DoAllActions__region0_DoAction_Instructions_GoTo_goto_GeneralP_extended_backToTheOperator() {
		timer.unsetTimer(this, 13);
	}
	
	/* Exit action for state 'notArrived'. */
	private void exitAction_xs_DoAllActions__region0_DoAction_Instructions_GoTo_goto_GeneralP_extended_notArrived() {
		timer.unsetTimer(this, 14);
	}
	
	/* Exit action for state 'livingroom'. */
	private void exitAction_xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_livingroom() {
		timer.unsetTimer(this, 15);
	}
	
	/* Exit action for state 'notFound'. */
	private void exitAction_xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_notFound() {
		timer.unsetTimer(this, 16);
	}
	
	/* Exit action for state 'arrived'. */
	private void exitAction_xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_arrived() {
		timer.unsetTimer(this, 17);
	}
	
	/* Exit action for state 'backToTheOperator'. */
	private void exitAction_xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_backToTheOperator() {
		timer.unsetTimer(this, 18);
	}
	
	/* Exit action for state 'bringGehtnicht'. */
	private void exitAction_xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_bringGehtnicht() {
		timer.unsetTimer(this, 19);
	}
	
	/* Exit action for state 'notArrived'. */
	private void exitAction_xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_notArrived() {
		timer.unsetTimer(this, 20);
	}
	
	/* Exit action for state 'open'. */
	private void exitAction_xs_DoAllActions__region0_DoAction_Instructions_open() {
		timer.unsetTimer(this, 21);
	}
	
	/* Exit action for state 'StartTracking'. */
	private void exitAction_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking() {
		timer.unsetTimer(this, 22);
	}
	
	/* Exit action for state 'STToff'. */
	private void exitAction_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking_WaitingForStopCommand_STToff() {
		timer.unsetTimer(this, 23);
	}
	
	/* Exit action for state 'STTstart'. */
	private void exitAction_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking_WaitingForStopCommand_STTstart() {
		timer.unsetTimer(this, 24);
	}
	
	/* Exit action for state 'Wave'. */
	private void exitAction_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave() {
		timer.unsetTimer(this, 25);
	}
	
	/* Exit action for state 'UTurn1'. */
	private void exitAction_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_UTurn1() {
		timer.unsetTimer(this, 26);
	}
	
	/* Exit action for state 'Turn'. */
	private void exitAction_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_Turn() {
		timer.unsetTimer(this, 27);
	}
	
	/* Exit action for state 'ILostYou'. */
	private void exitAction_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_ILostYou() {
		timer.unsetTimer(this, 28);
	}
	
	/* Exit action for state 'UTurn2'. */
	private void exitAction_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_UTurn2() {
		timer.unsetTimer(this, 29);
	}
	
	/* Exit action for state 'Detection'. */
	private void exitAction_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_Detection() {
		timer.unsetTimer(this, 30);
	}
	
	/* Exit action for state 'Detect'. */
	private void exitAction_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Detect() {
		timer.unsetTimer(this, 31);
	}
	
	/* Exit action for state 'unknown'. */
	private void exitAction_xs_DoAllActions__region0_DoAction_Instructions_unknown() {
		timer.unsetTimer(this, 32);
	}
	
	/* Exit action for state 'crowd'. */
	private void exitAction_xs_DoAllActions__region0_DoAction_Instructions_crowd() {
		timer.unsetTimer(this, 33);
	}
	
	/* Exit action for state 'tell'. */
	private void exitAction_xs_DoAllActions__region0_DoAction_Instructions_tell() {
		timer.unsetTimer(this, 34);
	}
	
	/* Exit action for state 'GoToOp'. */
	private void exitAction_xs_GoToOp() {
		timer.unsetTimer(this, 35);
	}
	
	/* Exit action for state 'blocked'. */
	private void exitAction_xs_blocked() {
		timer.unsetTimer(this, 36);
	}
	
	/* Exit action for state 'DontDoIt'. */
	private void exitAction_xs_DontDoIt() {
		timer.unsetTimer(this, 37);
		
		setRoundCounter(getRoundCounter() + 1);
	}
	
	/* Exit action for state 'Bumpered'. */
	private void exitAction_Leonie_Bupered_Or_Emergency_Stop_Bumpered() {
		timer.unsetTimer(this, 38);
	}
	
	/* Exit action for state 'checkEmergency'. */
	private void exitAction_Leonie_Bupered_Or_Emergency_Stop_checkEmergency() {
		timer.unsetTimer(this, 39);
	}
	
	/* 'default' enter sequence for state Hello */
	private void enterSequence_xs_Hello_default() {
		entryAction_xs_Hello();
		nextStateIndex = 0;
		stateVector[0] = State.xs_Hello;
	}
	
	/* 'default' enter sequence for state Leave the arena */
	private void enterSequence_xs_Leave_the_arena_default() {
		entryAction_xs_Leave_the_arena();
		nextStateIndex = 0;
		stateVector[0] = State.xs_Leave_the_arena;
	}
	
	/* Default enter sequence for state null */
	private void enterSequence_xs__final__default() {
		nextStateIndex = 0;
		stateVector[0] = State.xs__final_;
	}
	
	/* 'default' enter sequence for state DetectionsOn */
	private void enterSequence_xs_DetectionsOn_default() {
		entryAction_xs_DetectionsOn();
		nextStateIndex = 0;
		stateVector[0] = State.xs_DetectionsOn;
	}
	
	/* 'default' enter sequence for state Init */
	private void enterSequence_xs_Init_default() {
		entryAction_xs_Init();
		nextStateIndex = 0;
		stateVector[0] = State.xs_Init;
	}
	
	/* 'default' enter sequence for state TellAnswer */
	private void enterSequence_xs_TellAnswer_default() {
		entryAction_xs_TellAnswer();
		nextStateIndex = 0;
		stateVector[0] = State.xs_TellAnswer;
	}
	
	/* 'default' enter sequence for state StopSTT */
	private void enterSequence_xs_StopSTT_default() {
		nextStateIndex = 0;
		stateVector[0] = State.xs_StopSTT;
	}
	
	/* 'default' enter sequence for state TellIncomprehensible */
	private void enterSequence_xs_TellIncomprehensible_default() {
		entryAction_xs_TellIncomprehensible();
		nextStateIndex = 0;
		stateVector[0] = State.xs_TellIncomprehensible;
	}
	
	/* 'default' enter sequence for state STT and Tell Actions */
	private void enterSequence_xs_STT_and_Tell_Actions_default() {
		enterSequence_xs_STT_and_Tell_Actions_s_default();
	}
	
	/* 'default' enter sequence for state StartSTT */
	private void enterSequence_xs_STT_and_Tell_Actions_s_StartSTT_default() {
		entryAction_xs_STT_and_Tell_Actions_s_StartSTT();
		nextStateIndex = 0;
		stateVector[0] = State.xs_STT_and_Tell_Actions_s_StartSTT;
	}
	
	/* 'default' enter sequence for state TellSpokenText */
	private void enterSequence_xs_STT_and_Tell_Actions_s_TellSpokenText_default() {
		entryAction_xs_STT_and_Tell_Actions_s_TellSpokenText();
		nextStateIndex = 0;
		stateVector[0] = State.xs_STT_and_Tell_Actions_s_TellSpokenText;
	}
	
	/* 'default' enter sequence for state YesNo */
	private void enterSequence_xs_STT_and_Tell_Actions_s_YesNo_default() {
		entryAction_xs_STT_and_Tell_Actions_s_YesNo();
		nextStateIndex = 0;
		stateVector[0] = State.xs_STT_and_Tell_Actions_s_YesNo;
	}
	
	/* 'default' enter sequence for state GeneratedCommand */
	private void enterSequence_xs_STT_and_Tell_Actions_s_GeneratedCommand_default() {
		entryAction_xs_STT_and_Tell_Actions_s_GeneratedCommand();
		nextStateIndex = 0;
		stateVector[0] = State.xs_STT_and_Tell_Actions_s_GeneratedCommand;
	}
	
	/* 'default' enter sequence for state leave2 */
	private void enterSequence_xs_leave2_default() {
		entryAction_xs_leave2();
		nextStateIndex = 0;
		stateVector[0] = State.xs_leave2;
	}
	
	/* 'default' enter sequence for state leave3 */
	private void enterSequence_xs_leave3_default() {
		entryAction_xs_leave3();
		nextStateIndex = 0;
		stateVector[0] = State.xs_leave3;
	}
	
	/* 'default' enter sequence for state DoAllActions */
	private void enterSequence_xs_DoAllActions_default() {
		entryAction_xs_DoAllActions();
		enterSequence_xs_DoAllActions__region0_default();
	}
	
	/* 'default' enter sequence for state DoAction */
	private void enterSequence_xs_DoAllActions__region0_DoAction_default() {
		enterSequence_xs_DoAllActions__region0_DoAction_Instructions_default();
	}
	
	/* 'default' enter sequence for state GoTo */
	private void enterSequence_xs_DoAllActions__region0_DoAction_Instructions_GoTo_default() {
		entryAction_xs_DoAllActions__region0_DoAction_Instructions_GoTo();
		enterSequence_xs_DoAllActions__region0_DoAction_Instructions_GoTo_goto_GeneralP_extended_default();
	}
	
	/* 'default' enter sequence for state livingroom */
	private void enterSequence_xs_DoAllActions__region0_DoAction_Instructions_GoTo_goto_GeneralP_extended_livingroom_default() {
		entryAction_xs_DoAllActions__region0_DoAction_Instructions_GoTo_goto_GeneralP_extended_livingroom();
		nextStateIndex = 0;
		stateVector[0] = State.xs_DoAllActions__region0_DoAction_Instructions_GoTo_goto_GeneralP_extended_livingroom;
	}
	
	/* 'default' enter sequence for state notFound */
	private void enterSequence_xs_DoAllActions__region0_DoAction_Instructions_GoTo_goto_GeneralP_extended_notFound_default() {
		entryAction_xs_DoAllActions__region0_DoAction_Instructions_GoTo_goto_GeneralP_extended_notFound();
		nextStateIndex = 0;
		stateVector[0] = State.xs_DoAllActions__region0_DoAction_Instructions_GoTo_goto_GeneralP_extended_notFound;
	}
	
	/* 'default' enter sequence for state arrived */
	private void enterSequence_xs_DoAllActions__region0_DoAction_Instructions_GoTo_goto_GeneralP_extended_arrived_default() {
		entryAction_xs_DoAllActions__region0_DoAction_Instructions_GoTo_goto_GeneralP_extended_arrived();
		nextStateIndex = 0;
		stateVector[0] = State.xs_DoAllActions__region0_DoAction_Instructions_GoTo_goto_GeneralP_extended_arrived;
	}
	
	/* 'default' enter sequence for state backToTheOperator */
	private void enterSequence_xs_DoAllActions__region0_DoAction_Instructions_GoTo_goto_GeneralP_extended_backToTheOperator_default() {
		entryAction_xs_DoAllActions__region0_DoAction_Instructions_GoTo_goto_GeneralP_extended_backToTheOperator();
		nextStateIndex = 0;
		stateVector[0] = State.xs_DoAllActions__region0_DoAction_Instructions_GoTo_goto_GeneralP_extended_backToTheOperator;
	}
	
	/* 'default' enter sequence for state notArrived */
	private void enterSequence_xs_DoAllActions__region0_DoAction_Instructions_GoTo_goto_GeneralP_extended_notArrived_default() {
		entryAction_xs_DoAllActions__region0_DoAction_Instructions_GoTo_goto_GeneralP_extended_notArrived();
		nextStateIndex = 0;
		stateVector[0] = State.xs_DoAllActions__region0_DoAction_Instructions_GoTo_goto_GeneralP_extended_notArrived;
	}
	
	/* 'default' enter sequence for state surrounding */
	private void enterSequence_xs_DoAllActions__region0_DoAction_Instructions_surrounding_default() {
		nextStateIndex = 0;
		stateVector[0] = State.xs_DoAllActions__region0_DoAction_Instructions_surrounding;
	}
	
	/* 'default' enter sequence for state bring */
	private void enterSequence_xs_DoAllActions__region0_DoAction_Instructions_bring_default() {
		enterSequence_xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_default();
	}
	
	/* 'default' enter sequence for state livingroom */
	private void enterSequence_xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_livingroom_default() {
		entryAction_xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_livingroom();
		nextStateIndex = 0;
		stateVector[0] = State.xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_livingroom;
	}
	
	/* 'default' enter sequence for state notFound */
	private void enterSequence_xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_notFound_default() {
		entryAction_xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_notFound();
		nextStateIndex = 0;
		stateVector[0] = State.xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_notFound;
	}
	
	/* 'default' enter sequence for state arrived */
	private void enterSequence_xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_arrived_default() {
		entryAction_xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_arrived();
		nextStateIndex = 0;
		stateVector[0] = State.xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_arrived;
	}
	
	/* 'default' enter sequence for state backToTheOperator */
	private void enterSequence_xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_backToTheOperator_default() {
		entryAction_xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_backToTheOperator();
		nextStateIndex = 0;
		stateVector[0] = State.xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_backToTheOperator;
	}
	
	/* 'default' enter sequence for state bringGehtnicht */
	private void enterSequence_xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_bringGehtnicht_default() {
		entryAction_xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_bringGehtnicht();
		nextStateIndex = 0;
		stateVector[0] = State.xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_bringGehtnicht;
	}
	
	/* 'default' enter sequence for state stattdessen goto */
	private void enterSequence_xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_stattdessen_goto_default() {
		entryAction_xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_stattdessen_goto();
		nextStateIndex = 0;
		stateVector[0] = State.xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_stattdessen_goto;
	}
	
	/* 'default' enter sequence for state notArrived */
	private void enterSequence_xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_notArrived_default() {
		entryAction_xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_notArrived();
		nextStateIndex = 0;
		stateVector[0] = State.xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_notArrived;
	}
	
	/* 'default' enter sequence for state open */
	private void enterSequence_xs_DoAllActions__region0_DoAction_Instructions_open_default() {
		entryAction_xs_DoAllActions__region0_DoAction_Instructions_open();
		nextStateIndex = 0;
		stateVector[0] = State.xs_DoAllActions__region0_DoAction_Instructions_open;
	}
	
	/* 'default' enter sequence for state followme */
	private void enterSequence_xs_DoAllActions__region0_DoAction_Instructions_followme_default() {
		entryAction_xs_DoAllActions__region0_DoAction_Instructions_followme();
		enterSequence_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_default();
	}
	
	/* 'default' enter sequence for state StartTracking */
	private void enterSequence_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking_default() {
		entryAction_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking();
		enterSequence_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking_WaitingForStopCommand_default();
	}
	
	/* 'default' enter sequence for state STToff */
	private void enterSequence_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking_WaitingForStopCommand_STToff_default() {
		entryAction_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking_WaitingForStopCommand_STToff();
		nextStateIndex = 0;
		stateVector[0] = State.xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking_WaitingForStopCommand_STToff;
	}
	
	/* 'default' enter sequence for state STTstart */
	private void enterSequence_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking_WaitingForStopCommand_STTstart_default() {
		entryAction_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking_WaitingForStopCommand_STTstart();
		nextStateIndex = 0;
		stateVector[0] = State.xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking_WaitingForStopCommand_STTstart;
	}
	
	/* 'default' enter sequence for state Wave */
	private void enterSequence_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_default() {
		entryAction_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave();
		enterSequence_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_default();
	}
	
	/* 'default' enter sequence for state UTurn1 */
	private void enterSequence_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_UTurn1_default() {
		entryAction_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_UTurn1();
		nextStateIndex = 0;
		stateVector[0] = State.xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_UTurn1;
	}
	
	/* 'default' enter sequence for state WaveFound */
	private void enterSequence_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_WaveFound_default() {
		entryAction_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_WaveFound();
		nextStateIndex = 0;
		stateVector[0] = State.xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_WaveFound;
	}
	
	/* 'default' enter sequence for state Turn */
	private void enterSequence_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_Turn_default() {
		entryAction_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_Turn();
		nextStateIndex = 0;
		stateVector[0] = State.xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_Turn;
	}
	
	/* 'default' enter sequence for state DetectionOn */
	private void enterSequence_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_DetectionOn_default() {
		entryAction_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_DetectionOn();
		nextStateIndex = 0;
		stateVector[0] = State.xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_DetectionOn;
	}
	
	/* 'default' enter sequence for state PersonFound */
	private void enterSequence_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_PersonFound_default() {
		entryAction_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_PersonFound();
		nextStateIndex = 0;
		stateVector[0] = State.xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_PersonFound;
	}
	
	/* 'default' enter sequence for state ILostYou */
	private void enterSequence_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_ILostYou_default() {
		entryAction_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_ILostYou();
		nextStateIndex = 0;
		stateVector[0] = State.xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_ILostYou;
	}
	
	/* 'default' enter sequence for state UTurn2 */
	private void enterSequence_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_UTurn2_default() {
		entryAction_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_UTurn2();
		nextStateIndex = 0;
		stateVector[0] = State.xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_UTurn2;
	}
	
	/* 'default' enter sequence for state Detection */
	private void enterSequence_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_Detection_default() {
		entryAction_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_Detection();
		nextStateIndex = 0;
		stateVector[0] = State.xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_Detection;
	}
	
	/* 'default' enter sequence for state NotFound */
	private void enterSequence_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_NotFound_default() {
		entryAction_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_NotFound();
		nextStateIndex = 0;
		stateVector[0] = State.xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_NotFound;
	}
	
	/* 'default' enter sequence for state Detect */
	private void enterSequence_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Detect_default() {
		entryAction_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Detect();
		nextStateIndex = 0;
		stateVector[0] = State.xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Detect;
	}
	
	/* 'default' enter sequence for state no */
	private void enterSequence_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_no_default() {
		entryAction_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_no();
		nextStateIndex = 0;
		stateVector[0] = State.xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_no;
	}
	
	/* 'default' enter sequence for state HowCanIHelpYou */
	private void enterSequence_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_HowCanIHelpYou_default() {
		entryAction_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_HowCanIHelpYou();
		nextStateIndex = 0;
		stateVector[0] = State.xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_HowCanIHelpYou;
	}
	
	/* 'default' enter sequence for state Wir brauchen das gerade nicht */
	private void enterSequence_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wir_brauchen_das_gerade_nicht_default() {
		nextStateIndex = 0;
		stateVector[0] = State.xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wir_brauchen_das_gerade_nicht;
	}
	
	/* 'default' enter sequence for state unknown */
	private void enterSequence_xs_DoAllActions__region0_DoAction_Instructions_unknown_default() {
		entryAction_xs_DoAllActions__region0_DoAction_Instructions_unknown();
		nextStateIndex = 0;
		stateVector[0] = State.xs_DoAllActions__region0_DoAction_Instructions_unknown;
	}
	
	/* 'default' enter sequence for state crowd */
	private void enterSequence_xs_DoAllActions__region0_DoAction_Instructions_crowd_default() {
		entryAction_xs_DoAllActions__region0_DoAction_Instructions_crowd();
		nextStateIndex = 0;
		stateVector[0] = State.xs_DoAllActions__region0_DoAction_Instructions_crowd;
	}
	
	/* 'default' enter sequence for state tell */
	private void enterSequence_xs_DoAllActions__region0_DoAction_Instructions_tell_default() {
		entryAction_xs_DoAllActions__region0_DoAction_Instructions_tell();
		nextStateIndex = 0;
		stateVector[0] = State.xs_DoAllActions__region0_DoAction_Instructions_tell;
	}
	
	/* 'default' enter sequence for state question */
	private void enterSequence_xs_DoAllActions__region0_DoAction_Instructions_question_default() {
		nextStateIndex = 0;
		stateVector[0] = State.xs_DoAllActions__region0_DoAction_Instructions_question;
	}
	
	/* 'default' enter sequence for state GoToOp */
	private void enterSequence_xs_GoToOp_default() {
		entryAction_xs_GoToOp();
		nextStateIndex = 0;
		stateVector[0] = State.xs_GoToOp;
	}
	
	/* 'default' enter sequence for state blocked */
	private void enterSequence_xs_blocked_default() {
		entryAction_xs_blocked();
		nextStateIndex = 0;
		stateVector[0] = State.xs_blocked;
	}
	
	/* 'default' enter sequence for state time out */
	private void enterSequence_xs_time_out_default() {
		entryAction_xs_time_out();
		nextStateIndex = 0;
		stateVector[0] = State.xs_time_out;
	}
	
	/* 'default' enter sequence for state DontDoIt */
	private void enterSequence_xs_DontDoIt_default() {
		entryAction_xs_DontDoIt();
		nextStateIndex = 0;
		stateVector[0] = State.xs_DontDoIt;
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
	
	/* 'default' enter sequence for region xs */
	private void enterSequence_xs_default() {
		react_xs__entry_Default();
	}
	
	/* 'default' enter sequence for region s */
	private void enterSequence_xs_STT_and_Tell_Actions_s_default() {
		react_xs_STT_and_Tell_Actions_s__entry_Default();
	}
	
	/* 'default' enter sequence for region null */
	private void enterSequence_xs_DoAllActions__region0_default() {
		react_xs_DoAllActions__region0__entry_Default();
	}
	
	/* 'default' enter sequence for region Instructions */
	private void enterSequence_xs_DoAllActions__region0_DoAction_Instructions_default() {
		react_xs_DoAllActions__region0_DoAction_Instructions__entry_Default();
	}
	
	/* 'default' enter sequence for region goto GeneralP_extended */
	private void enterSequence_xs_DoAllActions__region0_DoAction_Instructions_GoTo_goto_GeneralP_extended_default() {
		react_xs_DoAllActions__region0_DoAction_Instructions_GoTo_goto_GeneralP_extended__entry_Default();
	}
	
	/* 'default' enter sequence for region bring GeneralP_extended */
	private void enterSequence_xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_default() {
		react_xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended__entry_Default();
	}
	
	/* 'default' enter sequence for region FollowMe in GPSR */
	private void enterSequence_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_default() {
		react_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR__entry_Default();
	}
	
	/* 'default' enter sequence for region WaitingForStopCommand */
	private void enterSequence_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking_WaitingForStopCommand_default() {
		react_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking_WaitingForStopCommand__entry_Default();
	}
	
	/* 'default' enter sequence for region WavingToFindPerson */
	private void enterSequence_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_default() {
		react_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson__entry_Default();
	}
	
	/* 'default' enter sequence for region Leonie Bupered Or Emergency Stop */
	private void enterSequence_Leonie_Bupered_Or_Emergency_Stop_default() {
		react_Leonie_Bupered_Or_Emergency_Stop__entry_Default();
	}
	
	/* Default exit sequence for state Hello */
	private void exitSequence_xs_Hello() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
		
		exitAction_xs_Hello();
	}
	
	/* Default exit sequence for state Leave the arena */
	private void exitSequence_xs_Leave_the_arena() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for final state. */
	private void exitSequence_xs__final_() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state DetectionsOn */
	private void exitSequence_xs_DetectionsOn() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
		
		exitAction_xs_DetectionsOn();
	}
	
	/* Default exit sequence for state Init */
	private void exitSequence_xs_Init() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state TellAnswer */
	private void exitSequence_xs_TellAnswer() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
		
		exitAction_xs_TellAnswer();
	}
	
	/* Default exit sequence for state StopSTT */
	private void exitSequence_xs_StopSTT() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state TellIncomprehensible */
	private void exitSequence_xs_TellIncomprehensible() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
		
		exitAction_xs_TellIncomprehensible();
	}
	
	/* Default exit sequence for state STT and Tell Actions */
	private void exitSequence_xs_STT_and_Tell_Actions() {
		exitSequence_xs_STT_and_Tell_Actions_s();
	}
	
	/* Default exit sequence for state StartSTT */
	private void exitSequence_xs_STT_and_Tell_Actions_s_StartSTT() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
		
		exitAction_xs_STT_and_Tell_Actions_s_StartSTT();
	}
	
	/* Default exit sequence for state TellSpokenText */
	private void exitSequence_xs_STT_and_Tell_Actions_s_TellSpokenText() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
		
		exitAction_xs_STT_and_Tell_Actions_s_TellSpokenText();
	}
	
	/* Default exit sequence for state YesNo */
	private void exitSequence_xs_STT_and_Tell_Actions_s_YesNo() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
		
		exitAction_xs_STT_and_Tell_Actions_s_YesNo();
	}
	
	/* Default exit sequence for state GeneratedCommand */
	private void exitSequence_xs_STT_and_Tell_Actions_s_GeneratedCommand() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
		
		exitAction_xs_STT_and_Tell_Actions_s_GeneratedCommand();
	}
	
	/* Default exit sequence for state leave2 */
	private void exitSequence_xs_leave2() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
		
		exitAction_xs_leave2();
	}
	
	/* Default exit sequence for state leave3 */
	private void exitSequence_xs_leave3() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state DoAllActions */
	private void exitSequence_xs_DoAllActions() {
		exitSequence_xs_DoAllActions__region0();
		exitAction_xs_DoAllActions();
	}
	
	/* Default exit sequence for state DoAction */
	private void exitSequence_xs_DoAllActions__region0_DoAction() {
		exitSequence_xs_DoAllActions__region0_DoAction_Instructions();
		exitAction_xs_DoAllActions__region0_DoAction();
	}
	
	/* Default exit sequence for state GoTo */
	private void exitSequence_xs_DoAllActions__region0_DoAction_Instructions_GoTo() {
		exitSequence_xs_DoAllActions__region0_DoAction_Instructions_GoTo_goto_GeneralP_extended();
	}
	
	/* Default exit sequence for state livingroom */
	private void exitSequence_xs_DoAllActions__region0_DoAction_Instructions_GoTo_goto_GeneralP_extended_livingroom() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
		
		exitAction_xs_DoAllActions__region0_DoAction_Instructions_GoTo_goto_GeneralP_extended_livingroom();
	}
	
	/* Default exit sequence for state notFound */
	private void exitSequence_xs_DoAllActions__region0_DoAction_Instructions_GoTo_goto_GeneralP_extended_notFound() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
		
		exitAction_xs_DoAllActions__region0_DoAction_Instructions_GoTo_goto_GeneralP_extended_notFound();
	}
	
	/* Default exit sequence for state arrived */
	private void exitSequence_xs_DoAllActions__region0_DoAction_Instructions_GoTo_goto_GeneralP_extended_arrived() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
		
		exitAction_xs_DoAllActions__region0_DoAction_Instructions_GoTo_goto_GeneralP_extended_arrived();
	}
	
	/* Default exit sequence for state backToTheOperator */
	private void exitSequence_xs_DoAllActions__region0_DoAction_Instructions_GoTo_goto_GeneralP_extended_backToTheOperator() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
		
		exitAction_xs_DoAllActions__region0_DoAction_Instructions_GoTo_goto_GeneralP_extended_backToTheOperator();
	}
	
	/* Default exit sequence for state notArrived */
	private void exitSequence_xs_DoAllActions__region0_DoAction_Instructions_GoTo_goto_GeneralP_extended_notArrived() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
		
		exitAction_xs_DoAllActions__region0_DoAction_Instructions_GoTo_goto_GeneralP_extended_notArrived();
	}
	
	/* Default exit sequence for state surrounding */
	private void exitSequence_xs_DoAllActions__region0_DoAction_Instructions_surrounding() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state bring */
	private void exitSequence_xs_DoAllActions__region0_DoAction_Instructions_bring() {
		exitSequence_xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended();
	}
	
	/* Default exit sequence for state livingroom */
	private void exitSequence_xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_livingroom() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
		
		exitAction_xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_livingroom();
	}
	
	/* Default exit sequence for state notFound */
	private void exitSequence_xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_notFound() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
		
		exitAction_xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_notFound();
	}
	
	/* Default exit sequence for state arrived */
	private void exitSequence_xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_arrived() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
		
		exitAction_xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_arrived();
	}
	
	/* Default exit sequence for state backToTheOperator */
	private void exitSequence_xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_backToTheOperator() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
		
		exitAction_xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_backToTheOperator();
	}
	
	/* Default exit sequence for state bringGehtnicht */
	private void exitSequence_xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_bringGehtnicht() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
		
		exitAction_xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_bringGehtnicht();
	}
	
	/* Default exit sequence for state stattdessen goto */
	private void exitSequence_xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_stattdessen_goto() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state notArrived */
	private void exitSequence_xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_notArrived() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
		
		exitAction_xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_notArrived();
	}
	
	/* Default exit sequence for state open */
	private void exitSequence_xs_DoAllActions__region0_DoAction_Instructions_open() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
		
		exitAction_xs_DoAllActions__region0_DoAction_Instructions_open();
	}
	
	/* Default exit sequence for state followme */
	private void exitSequence_xs_DoAllActions__region0_DoAction_Instructions_followme() {
		exitSequence_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR();
	}
	
	/* Default exit sequence for state StartTracking */
	private void exitSequence_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking() {
		exitSequence_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking_WaitingForStopCommand();
		exitAction_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking();
	}
	
	/* Default exit sequence for state STToff */
	private void exitSequence_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking_WaitingForStopCommand_STToff() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
		
		exitAction_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking_WaitingForStopCommand_STToff();
	}
	
	/* Default exit sequence for state STTstart */
	private void exitSequence_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking_WaitingForStopCommand_STTstart() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
		
		exitAction_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking_WaitingForStopCommand_STTstart();
	}
	
	/* Default exit sequence for state Wave */
	private void exitSequence_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave() {
		exitSequence_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson();
		exitAction_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave();
	}
	
	/* Default exit sequence for state UTurn1 */
	private void exitSequence_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_UTurn1() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
		
		exitAction_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_UTurn1();
	}
	
	/* Default exit sequence for state WaveFound */
	private void exitSequence_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_WaveFound() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state Turn */
	private void exitSequence_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_Turn() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
		
		exitAction_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_Turn();
	}
	
	/* Default exit sequence for state DetectionOn */
	private void exitSequence_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_DetectionOn() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state PersonFound */
	private void exitSequence_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_PersonFound() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state ILostYou */
	private void exitSequence_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_ILostYou() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
		
		exitAction_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_ILostYou();
	}
	
	/* Default exit sequence for state UTurn2 */
	private void exitSequence_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_UTurn2() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
		
		exitAction_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_UTurn2();
	}
	
	/* Default exit sequence for state Detection */
	private void exitSequence_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_Detection() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
		
		exitAction_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_Detection();
	}
	
	/* Default exit sequence for state NotFound */
	private void exitSequence_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_NotFound() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state Detect */
	private void exitSequence_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Detect() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
		
		exitAction_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Detect();
	}
	
	/* Default exit sequence for state no */
	private void exitSequence_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_no() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state HowCanIHelpYou */
	private void exitSequence_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_HowCanIHelpYou() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state Wir brauchen das gerade nicht */
	private void exitSequence_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wir_brauchen_das_gerade_nicht() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state unknown */
	private void exitSequence_xs_DoAllActions__region0_DoAction_Instructions_unknown() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
		
		exitAction_xs_DoAllActions__region0_DoAction_Instructions_unknown();
	}
	
	/* Default exit sequence for state crowd */
	private void exitSequence_xs_DoAllActions__region0_DoAction_Instructions_crowd() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
		
		exitAction_xs_DoAllActions__region0_DoAction_Instructions_crowd();
	}
	
	/* Default exit sequence for state tell */
	private void exitSequence_xs_DoAllActions__region0_DoAction_Instructions_tell() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
		
		exitAction_xs_DoAllActions__region0_DoAction_Instructions_tell();
	}
	
	/* Default exit sequence for state question */
	private void exitSequence_xs_DoAllActions__region0_DoAction_Instructions_question() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state GoToOp */
	private void exitSequence_xs_GoToOp() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
		
		exitAction_xs_GoToOp();
	}
	
	/* Default exit sequence for state blocked */
	private void exitSequence_xs_blocked() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
		
		exitAction_xs_blocked();
	}
	
	/* Default exit sequence for state time out */
	private void exitSequence_xs_time_out() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state DontDoIt */
	private void exitSequence_xs_DontDoIt() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
		
		exitAction_xs_DontDoIt();
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
	
	/* Default exit sequence for region xs */
	private void exitSequence_xs() {
		switch (stateVector[0]) {
		case xs_Hello:
			exitSequence_xs_Hello();
			break;
		case xs_Leave_the_arena:
			exitSequence_xs_Leave_the_arena();
			break;
		case xs__final_:
			exitSequence_xs__final_();
			break;
		case xs_DetectionsOn:
			exitSequence_xs_DetectionsOn();
			break;
		case xs_Init:
			exitSequence_xs_Init();
			break;
		case xs_TellAnswer:
			exitSequence_xs_TellAnswer();
			break;
		case xs_StopSTT:
			exitSequence_xs_StopSTT();
			break;
		case xs_TellIncomprehensible:
			exitSequence_xs_TellIncomprehensible();
			break;
		case xs_STT_and_Tell_Actions_s_StartSTT:
			exitSequence_xs_STT_and_Tell_Actions_s_StartSTT();
			break;
		case xs_STT_and_Tell_Actions_s_TellSpokenText:
			exitSequence_xs_STT_and_Tell_Actions_s_TellSpokenText();
			break;
		case xs_STT_and_Tell_Actions_s_YesNo:
			exitSequence_xs_STT_and_Tell_Actions_s_YesNo();
			break;
		case xs_STT_and_Tell_Actions_s_GeneratedCommand:
			exitSequence_xs_STT_and_Tell_Actions_s_GeneratedCommand();
			break;
		case xs_leave2:
			exitSequence_xs_leave2();
			break;
		case xs_leave3:
			exitSequence_xs_leave3();
			break;
		case xs_DoAllActions__region0_DoAction_Instructions_GoTo_goto_GeneralP_extended_livingroom:
			exitSequence_xs_DoAllActions__region0_DoAction_Instructions_GoTo_goto_GeneralP_extended_livingroom();
			exitAction_xs_DoAllActions__region0_DoAction();
			exitAction_xs_DoAllActions();
			break;
		case xs_DoAllActions__region0_DoAction_Instructions_GoTo_goto_GeneralP_extended_notFound:
			exitSequence_xs_DoAllActions__region0_DoAction_Instructions_GoTo_goto_GeneralP_extended_notFound();
			exitAction_xs_DoAllActions__region0_DoAction();
			exitAction_xs_DoAllActions();
			break;
		case xs_DoAllActions__region0_DoAction_Instructions_GoTo_goto_GeneralP_extended_arrived:
			exitSequence_xs_DoAllActions__region0_DoAction_Instructions_GoTo_goto_GeneralP_extended_arrived();
			exitAction_xs_DoAllActions__region0_DoAction();
			exitAction_xs_DoAllActions();
			break;
		case xs_DoAllActions__region0_DoAction_Instructions_GoTo_goto_GeneralP_extended_backToTheOperator:
			exitSequence_xs_DoAllActions__region0_DoAction_Instructions_GoTo_goto_GeneralP_extended_backToTheOperator();
			exitAction_xs_DoAllActions__region0_DoAction();
			exitAction_xs_DoAllActions();
			break;
		case xs_DoAllActions__region0_DoAction_Instructions_GoTo_goto_GeneralP_extended_notArrived:
			exitSequence_xs_DoAllActions__region0_DoAction_Instructions_GoTo_goto_GeneralP_extended_notArrived();
			exitAction_xs_DoAllActions__region0_DoAction();
			exitAction_xs_DoAllActions();
			break;
		case xs_DoAllActions__region0_DoAction_Instructions_surrounding:
			exitSequence_xs_DoAllActions__region0_DoAction_Instructions_surrounding();
			exitAction_xs_DoAllActions__region0_DoAction();
			exitAction_xs_DoAllActions();
			break;
		case xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_livingroom:
			exitSequence_xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_livingroom();
			exitAction_xs_DoAllActions__region0_DoAction();
			exitAction_xs_DoAllActions();
			break;
		case xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_notFound:
			exitSequence_xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_notFound();
			exitAction_xs_DoAllActions__region0_DoAction();
			exitAction_xs_DoAllActions();
			break;
		case xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_arrived:
			exitSequence_xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_arrived();
			exitAction_xs_DoAllActions__region0_DoAction();
			exitAction_xs_DoAllActions();
			break;
		case xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_backToTheOperator:
			exitSequence_xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_backToTheOperator();
			exitAction_xs_DoAllActions__region0_DoAction();
			exitAction_xs_DoAllActions();
			break;
		case xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_bringGehtnicht:
			exitSequence_xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_bringGehtnicht();
			exitAction_xs_DoAllActions__region0_DoAction();
			exitAction_xs_DoAllActions();
			break;
		case xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_stattdessen_goto:
			exitSequence_xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_stattdessen_goto();
			exitAction_xs_DoAllActions__region0_DoAction();
			exitAction_xs_DoAllActions();
			break;
		case xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_notArrived:
			exitSequence_xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_notArrived();
			exitAction_xs_DoAllActions__region0_DoAction();
			exitAction_xs_DoAllActions();
			break;
		case xs_DoAllActions__region0_DoAction_Instructions_open:
			exitSequence_xs_DoAllActions__region0_DoAction_Instructions_open();
			exitAction_xs_DoAllActions__region0_DoAction();
			exitAction_xs_DoAllActions();
			break;
		case xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking_WaitingForStopCommand_STToff:
			exitSequence_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking_WaitingForStopCommand_STToff();
			exitAction_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking();
			exitAction_xs_DoAllActions__region0_DoAction();
			exitAction_xs_DoAllActions();
			break;
		case xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking_WaitingForStopCommand_STTstart:
			exitSequence_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking_WaitingForStopCommand_STTstart();
			exitAction_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking();
			exitAction_xs_DoAllActions__region0_DoAction();
			exitAction_xs_DoAllActions();
			break;
		case xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_UTurn1:
			exitSequence_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_UTurn1();
			exitAction_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave();
			exitAction_xs_DoAllActions__region0_DoAction();
			exitAction_xs_DoAllActions();
			break;
		case xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_WaveFound:
			exitSequence_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_WaveFound();
			exitAction_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave();
			exitAction_xs_DoAllActions__region0_DoAction();
			exitAction_xs_DoAllActions();
			break;
		case xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_Turn:
			exitSequence_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_Turn();
			exitAction_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave();
			exitAction_xs_DoAllActions__region0_DoAction();
			exitAction_xs_DoAllActions();
			break;
		case xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_DetectionOn:
			exitSequence_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_DetectionOn();
			exitAction_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave();
			exitAction_xs_DoAllActions__region0_DoAction();
			exitAction_xs_DoAllActions();
			break;
		case xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_PersonFound:
			exitSequence_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_PersonFound();
			exitAction_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave();
			exitAction_xs_DoAllActions__region0_DoAction();
			exitAction_xs_DoAllActions();
			break;
		case xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_ILostYou:
			exitSequence_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_ILostYou();
			exitAction_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave();
			exitAction_xs_DoAllActions__region0_DoAction();
			exitAction_xs_DoAllActions();
			break;
		case xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_UTurn2:
			exitSequence_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_UTurn2();
			exitAction_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave();
			exitAction_xs_DoAllActions__region0_DoAction();
			exitAction_xs_DoAllActions();
			break;
		case xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_Detection:
			exitSequence_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_Detection();
			exitAction_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave();
			exitAction_xs_DoAllActions__region0_DoAction();
			exitAction_xs_DoAllActions();
			break;
		case xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_NotFound:
			exitSequence_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_NotFound();
			exitAction_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave();
			exitAction_xs_DoAllActions__region0_DoAction();
			exitAction_xs_DoAllActions();
			break;
		case xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Detect:
			exitSequence_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Detect();
			exitAction_xs_DoAllActions__region0_DoAction();
			exitAction_xs_DoAllActions();
			break;
		case xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_no:
			exitSequence_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_no();
			exitAction_xs_DoAllActions__region0_DoAction();
			exitAction_xs_DoAllActions();
			break;
		case xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_HowCanIHelpYou:
			exitSequence_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_HowCanIHelpYou();
			exitAction_xs_DoAllActions__region0_DoAction();
			exitAction_xs_DoAllActions();
			break;
		case xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wir_brauchen_das_gerade_nicht:
			exitSequence_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wir_brauchen_das_gerade_nicht();
			exitAction_xs_DoAllActions__region0_DoAction();
			exitAction_xs_DoAllActions();
			break;
		case xs_DoAllActions__region0_DoAction_Instructions_unknown:
			exitSequence_xs_DoAllActions__region0_DoAction_Instructions_unknown();
			exitAction_xs_DoAllActions__region0_DoAction();
			exitAction_xs_DoAllActions();
			break;
		case xs_DoAllActions__region0_DoAction_Instructions_crowd:
			exitSequence_xs_DoAllActions__region0_DoAction_Instructions_crowd();
			exitAction_xs_DoAllActions__region0_DoAction();
			exitAction_xs_DoAllActions();
			break;
		case xs_DoAllActions__region0_DoAction_Instructions_tell:
			exitSequence_xs_DoAllActions__region0_DoAction_Instructions_tell();
			exitAction_xs_DoAllActions__region0_DoAction();
			exitAction_xs_DoAllActions();
			break;
		case xs_DoAllActions__region0_DoAction_Instructions_question:
			exitSequence_xs_DoAllActions__region0_DoAction_Instructions_question();
			exitAction_xs_DoAllActions__region0_DoAction();
			exitAction_xs_DoAllActions();
			break;
		case xs_GoToOp:
			exitSequence_xs_GoToOp();
			break;
		case xs_blocked:
			exitSequence_xs_blocked();
			break;
		case xs_time_out:
			exitSequence_xs_time_out();
			break;
		case xs_DontDoIt:
			exitSequence_xs_DontDoIt();
			break;
		default:
			break;
		}
	}
	
	/* Default exit sequence for region s */
	private void exitSequence_xs_STT_and_Tell_Actions_s() {
		switch (stateVector[0]) {
		case xs_STT_and_Tell_Actions_s_StartSTT:
			exitSequence_xs_STT_and_Tell_Actions_s_StartSTT();
			break;
		case xs_STT_and_Tell_Actions_s_TellSpokenText:
			exitSequence_xs_STT_and_Tell_Actions_s_TellSpokenText();
			break;
		case xs_STT_and_Tell_Actions_s_YesNo:
			exitSequence_xs_STT_and_Tell_Actions_s_YesNo();
			break;
		case xs_STT_and_Tell_Actions_s_GeneratedCommand:
			exitSequence_xs_STT_and_Tell_Actions_s_GeneratedCommand();
			break;
		default:
			break;
		}
	}
	
	/* Default exit sequence for region null */
	private void exitSequence_xs_DoAllActions__region0() {
		switch (stateVector[0]) {
		case xs_DoAllActions__region0_DoAction_Instructions_GoTo_goto_GeneralP_extended_livingroom:
			exitSequence_xs_DoAllActions__region0_DoAction_Instructions_GoTo_goto_GeneralP_extended_livingroom();
			exitAction_xs_DoAllActions__region0_DoAction();
			break;
		case xs_DoAllActions__region0_DoAction_Instructions_GoTo_goto_GeneralP_extended_notFound:
			exitSequence_xs_DoAllActions__region0_DoAction_Instructions_GoTo_goto_GeneralP_extended_notFound();
			exitAction_xs_DoAllActions__region0_DoAction();
			break;
		case xs_DoAllActions__region0_DoAction_Instructions_GoTo_goto_GeneralP_extended_arrived:
			exitSequence_xs_DoAllActions__region0_DoAction_Instructions_GoTo_goto_GeneralP_extended_arrived();
			exitAction_xs_DoAllActions__region0_DoAction();
			break;
		case xs_DoAllActions__region0_DoAction_Instructions_GoTo_goto_GeneralP_extended_backToTheOperator:
			exitSequence_xs_DoAllActions__region0_DoAction_Instructions_GoTo_goto_GeneralP_extended_backToTheOperator();
			exitAction_xs_DoAllActions__region0_DoAction();
			break;
		case xs_DoAllActions__region0_DoAction_Instructions_GoTo_goto_GeneralP_extended_notArrived:
			exitSequence_xs_DoAllActions__region0_DoAction_Instructions_GoTo_goto_GeneralP_extended_notArrived();
			exitAction_xs_DoAllActions__region0_DoAction();
			break;
		case xs_DoAllActions__region0_DoAction_Instructions_surrounding:
			exitSequence_xs_DoAllActions__region0_DoAction_Instructions_surrounding();
			exitAction_xs_DoAllActions__region0_DoAction();
			break;
		case xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_livingroom:
			exitSequence_xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_livingroom();
			exitAction_xs_DoAllActions__region0_DoAction();
			break;
		case xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_notFound:
			exitSequence_xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_notFound();
			exitAction_xs_DoAllActions__region0_DoAction();
			break;
		case xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_arrived:
			exitSequence_xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_arrived();
			exitAction_xs_DoAllActions__region0_DoAction();
			break;
		case xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_backToTheOperator:
			exitSequence_xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_backToTheOperator();
			exitAction_xs_DoAllActions__region0_DoAction();
			break;
		case xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_bringGehtnicht:
			exitSequence_xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_bringGehtnicht();
			exitAction_xs_DoAllActions__region0_DoAction();
			break;
		case xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_stattdessen_goto:
			exitSequence_xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_stattdessen_goto();
			exitAction_xs_DoAllActions__region0_DoAction();
			break;
		case xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_notArrived:
			exitSequence_xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_notArrived();
			exitAction_xs_DoAllActions__region0_DoAction();
			break;
		case xs_DoAllActions__region0_DoAction_Instructions_open:
			exitSequence_xs_DoAllActions__region0_DoAction_Instructions_open();
			exitAction_xs_DoAllActions__region0_DoAction();
			break;
		case xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking_WaitingForStopCommand_STToff:
			exitSequence_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking_WaitingForStopCommand_STToff();
			exitAction_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking();
			exitAction_xs_DoAllActions__region0_DoAction();
			break;
		case xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking_WaitingForStopCommand_STTstart:
			exitSequence_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking_WaitingForStopCommand_STTstart();
			exitAction_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking();
			exitAction_xs_DoAllActions__region0_DoAction();
			break;
		case xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_UTurn1:
			exitSequence_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_UTurn1();
			exitAction_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave();
			exitAction_xs_DoAllActions__region0_DoAction();
			break;
		case xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_WaveFound:
			exitSequence_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_WaveFound();
			exitAction_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave();
			exitAction_xs_DoAllActions__region0_DoAction();
			break;
		case xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_Turn:
			exitSequence_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_Turn();
			exitAction_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave();
			exitAction_xs_DoAllActions__region0_DoAction();
			break;
		case xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_DetectionOn:
			exitSequence_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_DetectionOn();
			exitAction_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave();
			exitAction_xs_DoAllActions__region0_DoAction();
			break;
		case xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_PersonFound:
			exitSequence_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_PersonFound();
			exitAction_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave();
			exitAction_xs_DoAllActions__region0_DoAction();
			break;
		case xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_ILostYou:
			exitSequence_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_ILostYou();
			exitAction_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave();
			exitAction_xs_DoAllActions__region0_DoAction();
			break;
		case xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_UTurn2:
			exitSequence_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_UTurn2();
			exitAction_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave();
			exitAction_xs_DoAllActions__region0_DoAction();
			break;
		case xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_Detection:
			exitSequence_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_Detection();
			exitAction_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave();
			exitAction_xs_DoAllActions__region0_DoAction();
			break;
		case xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_NotFound:
			exitSequence_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_NotFound();
			exitAction_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave();
			exitAction_xs_DoAllActions__region0_DoAction();
			break;
		case xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Detect:
			exitSequence_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Detect();
			exitAction_xs_DoAllActions__region0_DoAction();
			break;
		case xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_no:
			exitSequence_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_no();
			exitAction_xs_DoAllActions__region0_DoAction();
			break;
		case xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_HowCanIHelpYou:
			exitSequence_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_HowCanIHelpYou();
			exitAction_xs_DoAllActions__region0_DoAction();
			break;
		case xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wir_brauchen_das_gerade_nicht:
			exitSequence_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wir_brauchen_das_gerade_nicht();
			exitAction_xs_DoAllActions__region0_DoAction();
			break;
		case xs_DoAllActions__region0_DoAction_Instructions_unknown:
			exitSequence_xs_DoAllActions__region0_DoAction_Instructions_unknown();
			exitAction_xs_DoAllActions__region0_DoAction();
			break;
		case xs_DoAllActions__region0_DoAction_Instructions_crowd:
			exitSequence_xs_DoAllActions__region0_DoAction_Instructions_crowd();
			exitAction_xs_DoAllActions__region0_DoAction();
			break;
		case xs_DoAllActions__region0_DoAction_Instructions_tell:
			exitSequence_xs_DoAllActions__region0_DoAction_Instructions_tell();
			exitAction_xs_DoAllActions__region0_DoAction();
			break;
		case xs_DoAllActions__region0_DoAction_Instructions_question:
			exitSequence_xs_DoAllActions__region0_DoAction_Instructions_question();
			exitAction_xs_DoAllActions__region0_DoAction();
			break;
		default:
			break;
		}
	}
	
	/* Default exit sequence for region Instructions */
	private void exitSequence_xs_DoAllActions__region0_DoAction_Instructions() {
		switch (stateVector[0]) {
		case xs_DoAllActions__region0_DoAction_Instructions_GoTo_goto_GeneralP_extended_livingroom:
			exitSequence_xs_DoAllActions__region0_DoAction_Instructions_GoTo_goto_GeneralP_extended_livingroom();
			break;
		case xs_DoAllActions__region0_DoAction_Instructions_GoTo_goto_GeneralP_extended_notFound:
			exitSequence_xs_DoAllActions__region0_DoAction_Instructions_GoTo_goto_GeneralP_extended_notFound();
			break;
		case xs_DoAllActions__region0_DoAction_Instructions_GoTo_goto_GeneralP_extended_arrived:
			exitSequence_xs_DoAllActions__region0_DoAction_Instructions_GoTo_goto_GeneralP_extended_arrived();
			break;
		case xs_DoAllActions__region0_DoAction_Instructions_GoTo_goto_GeneralP_extended_backToTheOperator:
			exitSequence_xs_DoAllActions__region0_DoAction_Instructions_GoTo_goto_GeneralP_extended_backToTheOperator();
			break;
		case xs_DoAllActions__region0_DoAction_Instructions_GoTo_goto_GeneralP_extended_notArrived:
			exitSequence_xs_DoAllActions__region0_DoAction_Instructions_GoTo_goto_GeneralP_extended_notArrived();
			break;
		case xs_DoAllActions__region0_DoAction_Instructions_surrounding:
			exitSequence_xs_DoAllActions__region0_DoAction_Instructions_surrounding();
			break;
		case xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_livingroom:
			exitSequence_xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_livingroom();
			break;
		case xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_notFound:
			exitSequence_xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_notFound();
			break;
		case xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_arrived:
			exitSequence_xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_arrived();
			break;
		case xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_backToTheOperator:
			exitSequence_xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_backToTheOperator();
			break;
		case xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_bringGehtnicht:
			exitSequence_xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_bringGehtnicht();
			break;
		case xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_stattdessen_goto:
			exitSequence_xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_stattdessen_goto();
			break;
		case xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_notArrived:
			exitSequence_xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_notArrived();
			break;
		case xs_DoAllActions__region0_DoAction_Instructions_open:
			exitSequence_xs_DoAllActions__region0_DoAction_Instructions_open();
			break;
		case xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking_WaitingForStopCommand_STToff:
			exitSequence_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking_WaitingForStopCommand_STToff();
			exitAction_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking();
			break;
		case xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking_WaitingForStopCommand_STTstart:
			exitSequence_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking_WaitingForStopCommand_STTstart();
			exitAction_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking();
			break;
		case xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_UTurn1:
			exitSequence_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_UTurn1();
			exitAction_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave();
			break;
		case xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_WaveFound:
			exitSequence_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_WaveFound();
			exitAction_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave();
			break;
		case xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_Turn:
			exitSequence_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_Turn();
			exitAction_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave();
			break;
		case xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_DetectionOn:
			exitSequence_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_DetectionOn();
			exitAction_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave();
			break;
		case xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_PersonFound:
			exitSequence_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_PersonFound();
			exitAction_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave();
			break;
		case xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_ILostYou:
			exitSequence_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_ILostYou();
			exitAction_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave();
			break;
		case xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_UTurn2:
			exitSequence_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_UTurn2();
			exitAction_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave();
			break;
		case xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_Detection:
			exitSequence_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_Detection();
			exitAction_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave();
			break;
		case xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_NotFound:
			exitSequence_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_NotFound();
			exitAction_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave();
			break;
		case xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Detect:
			exitSequence_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Detect();
			break;
		case xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_no:
			exitSequence_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_no();
			break;
		case xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_HowCanIHelpYou:
			exitSequence_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_HowCanIHelpYou();
			break;
		case xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wir_brauchen_das_gerade_nicht:
			exitSequence_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wir_brauchen_das_gerade_nicht();
			break;
		case xs_DoAllActions__region0_DoAction_Instructions_unknown:
			exitSequence_xs_DoAllActions__region0_DoAction_Instructions_unknown();
			break;
		case xs_DoAllActions__region0_DoAction_Instructions_crowd:
			exitSequence_xs_DoAllActions__region0_DoAction_Instructions_crowd();
			break;
		case xs_DoAllActions__region0_DoAction_Instructions_tell:
			exitSequence_xs_DoAllActions__region0_DoAction_Instructions_tell();
			break;
		case xs_DoAllActions__region0_DoAction_Instructions_question:
			exitSequence_xs_DoAllActions__region0_DoAction_Instructions_question();
			break;
		default:
			break;
		}
	}
	
	/* Default exit sequence for region goto GeneralP_extended */
	private void exitSequence_xs_DoAllActions__region0_DoAction_Instructions_GoTo_goto_GeneralP_extended() {
		switch (stateVector[0]) {
		case xs_DoAllActions__region0_DoAction_Instructions_GoTo_goto_GeneralP_extended_livingroom:
			exitSequence_xs_DoAllActions__region0_DoAction_Instructions_GoTo_goto_GeneralP_extended_livingroom();
			break;
		case xs_DoAllActions__region0_DoAction_Instructions_GoTo_goto_GeneralP_extended_notFound:
			exitSequence_xs_DoAllActions__region0_DoAction_Instructions_GoTo_goto_GeneralP_extended_notFound();
			break;
		case xs_DoAllActions__region0_DoAction_Instructions_GoTo_goto_GeneralP_extended_arrived:
			exitSequence_xs_DoAllActions__region0_DoAction_Instructions_GoTo_goto_GeneralP_extended_arrived();
			break;
		case xs_DoAllActions__region0_DoAction_Instructions_GoTo_goto_GeneralP_extended_backToTheOperator:
			exitSequence_xs_DoAllActions__region0_DoAction_Instructions_GoTo_goto_GeneralP_extended_backToTheOperator();
			break;
		case xs_DoAllActions__region0_DoAction_Instructions_GoTo_goto_GeneralP_extended_notArrived:
			exitSequence_xs_DoAllActions__region0_DoAction_Instructions_GoTo_goto_GeneralP_extended_notArrived();
			break;
		default:
			break;
		}
	}
	
	/* Default exit sequence for region bring GeneralP_extended */
	private void exitSequence_xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended() {
		switch (stateVector[0]) {
		case xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_livingroom:
			exitSequence_xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_livingroom();
			break;
		case xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_notFound:
			exitSequence_xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_notFound();
			break;
		case xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_arrived:
			exitSequence_xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_arrived();
			break;
		case xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_backToTheOperator:
			exitSequence_xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_backToTheOperator();
			break;
		case xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_bringGehtnicht:
			exitSequence_xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_bringGehtnicht();
			break;
		case xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_stattdessen_goto:
			exitSequence_xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_stattdessen_goto();
			break;
		case xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_notArrived:
			exitSequence_xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_notArrived();
			break;
		default:
			break;
		}
	}
	
	/* Default exit sequence for region FollowMe in GPSR */
	private void exitSequence_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR() {
		switch (stateVector[0]) {
		case xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking_WaitingForStopCommand_STToff:
			exitSequence_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking_WaitingForStopCommand_STToff();
			exitAction_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking();
			break;
		case xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking_WaitingForStopCommand_STTstart:
			exitSequence_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking_WaitingForStopCommand_STTstart();
			exitAction_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking();
			break;
		case xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_UTurn1:
			exitSequence_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_UTurn1();
			exitAction_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave();
			break;
		case xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_WaveFound:
			exitSequence_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_WaveFound();
			exitAction_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave();
			break;
		case xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_Turn:
			exitSequence_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_Turn();
			exitAction_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave();
			break;
		case xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_DetectionOn:
			exitSequence_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_DetectionOn();
			exitAction_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave();
			break;
		case xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_PersonFound:
			exitSequence_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_PersonFound();
			exitAction_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave();
			break;
		case xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_ILostYou:
			exitSequence_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_ILostYou();
			exitAction_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave();
			break;
		case xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_UTurn2:
			exitSequence_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_UTurn2();
			exitAction_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave();
			break;
		case xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_Detection:
			exitSequence_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_Detection();
			exitAction_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave();
			break;
		case xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_NotFound:
			exitSequence_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_NotFound();
			exitAction_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave();
			break;
		case xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Detect:
			exitSequence_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Detect();
			break;
		case xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_no:
			exitSequence_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_no();
			break;
		case xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_HowCanIHelpYou:
			exitSequence_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_HowCanIHelpYou();
			break;
		case xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wir_brauchen_das_gerade_nicht:
			exitSequence_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wir_brauchen_das_gerade_nicht();
			break;
		default:
			break;
		}
	}
	
	/* Default exit sequence for region WaitingForStopCommand */
	private void exitSequence_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking_WaitingForStopCommand() {
		switch (stateVector[0]) {
		case xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking_WaitingForStopCommand_STToff:
			exitSequence_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking_WaitingForStopCommand_STToff();
			break;
		case xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking_WaitingForStopCommand_STTstart:
			exitSequence_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking_WaitingForStopCommand_STTstart();
			break;
		default:
			break;
		}
	}
	
	/* Default exit sequence for region WavingToFindPerson */
	private void exitSequence_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson() {
		switch (stateVector[0]) {
		case xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_UTurn1:
			exitSequence_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_UTurn1();
			break;
		case xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_WaveFound:
			exitSequence_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_WaveFound();
			break;
		case xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_Turn:
			exitSequence_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_Turn();
			break;
		case xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_DetectionOn:
			exitSequence_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_DetectionOn();
			break;
		case xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_PersonFound:
			exitSequence_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_PersonFound();
			break;
		case xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_ILostYou:
			exitSequence_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_ILostYou();
			break;
		case xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_UTurn2:
			exitSequence_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_UTurn2();
			break;
		case xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_Detection:
			exitSequence_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_Detection();
			break;
		case xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_NotFound:
			exitSequence_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_NotFound();
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
	
	/* The reactions of state Hello. */
	private void react_xs_Hello() {
		if (check_xs_Hello_tr0_tr0()) {
			effect_xs_Hello_tr0();
		} else {
			if (check_xs_Hello_tr1_tr1()) {
				effect_xs_Hello_tr1();
			}
		}
	}
	
	/* The reactions of state Leave the arena. */
	private void react_xs_Leave_the_arena() {
		if (check_xs_Leave_the_arena_tr0_tr0()) {
			effect_xs_Leave_the_arena_tr0();
		}
	}
	
	/* The reactions of state null. */
	private void react_xs__final_() {
	}
	
	/* The reactions of state DetectionsOn. */
	private void react_xs_DetectionsOn() {
		if (check_xs_DetectionsOn_tr0_tr0()) {
			effect_xs_DetectionsOn_tr0();
		} else {
			if (check_xs_DetectionsOn_tr1_tr1()) {
				effect_xs_DetectionsOn_tr1();
			}
		}
	}
	
	/* The reactions of state Init. */
	private void react_xs_Init() {
		if (check_xs_Init_tr0_tr0()) {
			effect_xs_Init_tr0();
		}
	}
	
	/* The reactions of state TellAnswer. */
	private void react_xs_TellAnswer() {
		if (check_xs_TellAnswer_tr0_tr0()) {
			effect_xs_TellAnswer_tr0();
		} else {
			if (check_xs_TellAnswer_tr1_tr1()) {
				effect_xs_TellAnswer_tr1();
			}
		}
	}
	
	/* The reactions of state StopSTT. */
	private void react_xs_StopSTT() {
		effect_xs_StopSTT_tr0();
	}
	
	/* The reactions of state TellIncomprehensible. */
	private void react_xs_TellIncomprehensible() {
		if (check_xs_TellIncomprehensible_tr0_tr0()) {
			effect_xs_TellIncomprehensible_tr0();
		} else {
			if (check_xs_TellIncomprehensible_tr1_tr1()) {
				effect_xs_TellIncomprehensible_tr1();
			}
		}
	}
	
	/* The reactions of state StartSTT. */
	private void react_xs_STT_and_Tell_Actions_s_StartSTT() {
		if (check_xs_STT_and_Tell_Actions_s_StartSTT_tr0_tr0()) {
			effect_xs_STT_and_Tell_Actions_s_StartSTT_tr0();
		} else {
			if (check_xs_STT_and_Tell_Actions_s_StartSTT_tr1_tr1()) {
				effect_xs_STT_and_Tell_Actions_s_StartSTT_tr1();
			} else {
				if (check_xs_STT_and_Tell_Actions_s_StartSTT_tr2_tr2()) {
					effect_xs_STT_and_Tell_Actions_s_StartSTT_tr2();
				}
			}
		}
	}
	
	/* The reactions of state TellSpokenText. */
	private void react_xs_STT_and_Tell_Actions_s_TellSpokenText() {
		if (check_xs_STT_and_Tell_Actions_s_TellSpokenText_tr0_tr0()) {
			effect_xs_STT_and_Tell_Actions_s_TellSpokenText_tr0();
		} else {
			if (check_xs_STT_and_Tell_Actions_s_TellSpokenText_tr1_tr1()) {
				effect_xs_STT_and_Tell_Actions_s_TellSpokenText_tr1();
			} else {
				if (check_xs_STT_and_Tell_Actions_s_TellSpokenText_tr2_tr2()) {
					effect_xs_STT_and_Tell_Actions_s_TellSpokenText_tr2();
				}
			}
		}
	}
	
	/* The reactions of state YesNo. */
	private void react_xs_STT_and_Tell_Actions_s_YesNo() {
		if (check_xs_STT_and_Tell_Actions_s_YesNo_tr0_tr0()) {
			effect_xs_STT_and_Tell_Actions_s_YesNo_tr0();
		} else {
			if (check_xs_STT_and_Tell_Actions_s_YesNo_tr1_tr1()) {
				effect_xs_STT_and_Tell_Actions_s_YesNo_tr1();
			}
		}
	}
	
	/* The reactions of state GeneratedCommand. */
	private void react_xs_STT_and_Tell_Actions_s_GeneratedCommand() {
		if (check_xs_STT_and_Tell_Actions_s_GeneratedCommand_tr0_tr0()) {
			effect_xs_STT_and_Tell_Actions_s_GeneratedCommand_tr0();
		} else {
			if (check_xs_STT_and_Tell_Actions_s_GeneratedCommand_tr1_tr1()) {
				effect_xs_STT_and_Tell_Actions_s_GeneratedCommand_tr1();
			}
		}
	}
	
	/* The reactions of state leave2. */
	private void react_xs_leave2() {
		if (check_xs_leave2_tr0_tr0()) {
			effect_xs_leave2_tr0();
		} else {
			if (check_xs_leave2_tr1_tr1()) {
				effect_xs_leave2_tr1();
			}
		}
	}
	
	/* The reactions of state leave3. */
	private void react_xs_leave3() {
		if (check_xs_leave3_tr0_tr0()) {
			effect_xs_leave3_tr0();
		}
	}
	
	/* The reactions of state livingroom. */
	private void react_xs_DoAllActions__region0_DoAction_Instructions_GoTo_goto_GeneralP_extended_livingroom() {
		if (check_xs_DoAllActions_tr1_tr1()) {
			effect_xs_DoAllActions_tr1();
		} else {
			if (check_xs_DoAllActions__region0_DoAction_Instructions_GoTo_goto_GeneralP_extended_livingroom_tr0_tr0()) {
				effect_xs_DoAllActions__region0_DoAction_Instructions_GoTo_goto_GeneralP_extended_livingroom_tr0();
			} else {
				if (check_xs_DoAllActions__region0_DoAction_Instructions_GoTo_goto_GeneralP_extended_livingroom_tr1_tr1()) {
					effect_xs_DoAllActions__region0_DoAction_Instructions_GoTo_goto_GeneralP_extended_livingroom_tr1();
				} else {
					if (check_xs_DoAllActions__region0_DoAction_Instructions_GoTo_goto_GeneralP_extended_livingroom_tr2_tr2()) {
						effect_xs_DoAllActions__region0_DoAction_Instructions_GoTo_goto_GeneralP_extended_livingroom_tr2();
					}
				}
			}
		}
	}
	
	/* The reactions of state notFound. */
	private void react_xs_DoAllActions__region0_DoAction_Instructions_GoTo_goto_GeneralP_extended_notFound() {
		if (check_xs_DoAllActions_tr1_tr1()) {
			effect_xs_DoAllActions_tr1();
		} else {
			if (check_xs_DoAllActions__region0_DoAction_Instructions_GoTo_goto_GeneralP_extended_notFound_tr0_tr0()) {
				effect_xs_DoAllActions__region0_DoAction_Instructions_GoTo_goto_GeneralP_extended_notFound_tr0();
			} else {
				if (check_xs_DoAllActions__region0_DoAction_Instructions_GoTo_goto_GeneralP_extended_notFound_tr1_tr1()) {
					effect_xs_DoAllActions__region0_DoAction_Instructions_GoTo_goto_GeneralP_extended_notFound_tr1();
				}
			}
		}
	}
	
	/* The reactions of state arrived. */
	private void react_xs_DoAllActions__region0_DoAction_Instructions_GoTo_goto_GeneralP_extended_arrived() {
		if (check_xs_DoAllActions_tr1_tr1()) {
			effect_xs_DoAllActions_tr1();
		} else {
			if (check_xs_DoAllActions__region0_DoAction_Instructions_GoTo_goto_GeneralP_extended_arrived_tr0_tr0()) {
				effect_xs_DoAllActions__region0_DoAction_Instructions_GoTo_goto_GeneralP_extended_arrived_tr0();
			} else {
				if (check_xs_DoAllActions__region0_DoAction_Instructions_GoTo_goto_GeneralP_extended_arrived_tr1_tr1()) {
					effect_xs_DoAllActions__region0_DoAction_Instructions_GoTo_goto_GeneralP_extended_arrived_tr1();
				}
			}
		}
	}
	
	/* The reactions of state backToTheOperator. */
	private void react_xs_DoAllActions__region0_DoAction_Instructions_GoTo_goto_GeneralP_extended_backToTheOperator() {
		if (check_xs_DoAllActions_tr1_tr1()) {
			effect_xs_DoAllActions_tr1();
		} else {
			if (check_xs_DoAllActions__region0_DoAction_Instructions_GoTo_goto_GeneralP_extended_backToTheOperator_tr0_tr0()) {
				effect_xs_DoAllActions__region0_DoAction_Instructions_GoTo_goto_GeneralP_extended_backToTheOperator_tr0();
			} else {
				if (check_xs_DoAllActions__region0_DoAction_Instructions_GoTo_goto_GeneralP_extended_backToTheOperator_tr1_tr1()) {
					effect_xs_DoAllActions__region0_DoAction_Instructions_GoTo_goto_GeneralP_extended_backToTheOperator_tr1();
				} else {
					if (check_xs_DoAllActions__region0_DoAction_Instructions_GoTo_goto_GeneralP_extended_backToTheOperator_tr2_tr2()) {
						effect_xs_DoAllActions__region0_DoAction_Instructions_GoTo_goto_GeneralP_extended_backToTheOperator_tr2();
					}
				}
			}
		}
	}
	
	/* The reactions of state notArrived. */
	private void react_xs_DoAllActions__region0_DoAction_Instructions_GoTo_goto_GeneralP_extended_notArrived() {
		if (check_xs_DoAllActions_tr1_tr1()) {
			effect_xs_DoAllActions_tr1();
		} else {
			if (check_xs_DoAllActions__region0_DoAction_Instructions_GoTo_goto_GeneralP_extended_notArrived_tr0_tr0()) {
				effect_xs_DoAllActions__region0_DoAction_Instructions_GoTo_goto_GeneralP_extended_notArrived_tr0();
			} else {
				if (check_xs_DoAllActions__region0_DoAction_Instructions_GoTo_goto_GeneralP_extended_notArrived_tr1_tr1()) {
					effect_xs_DoAllActions__region0_DoAction_Instructions_GoTo_goto_GeneralP_extended_notArrived_tr1();
				}
			}
		}
	}
	
	/* The reactions of state surrounding. */
	private void react_xs_DoAllActions__region0_DoAction_Instructions_surrounding() {
		if (check_xs_DoAllActions_tr1_tr1()) {
			effect_xs_DoAllActions_tr1();
		} else {
			effect_xs_DoAllActions__region0_DoAction_Instructions_surrounding_tr0();
		}
	}
	
	/* The reactions of state livingroom. */
	private void react_xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_livingroom() {
		if (check_xs_DoAllActions_tr1_tr1()) {
			effect_xs_DoAllActions_tr1();
		} else {
			if (check_xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_livingroom_tr0_tr0()) {
				effect_xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_livingroom_tr0();
			} else {
				if (check_xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_livingroom_tr1_tr1()) {
					effect_xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_livingroom_tr1();
				} else {
					if (check_xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_livingroom_tr2_tr2()) {
						effect_xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_livingroom_tr2();
					}
				}
			}
		}
	}
	
	/* The reactions of state notFound. */
	private void react_xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_notFound() {
		if (check_xs_DoAllActions_tr1_tr1()) {
			effect_xs_DoAllActions_tr1();
		} else {
			if (check_xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_notFound_tr0_tr0()) {
				effect_xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_notFound_tr0();
			} else {
				if (check_xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_notFound_tr1_tr1()) {
					effect_xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_notFound_tr1();
				}
			}
		}
	}
	
	/* The reactions of state arrived. */
	private void react_xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_arrived() {
		if (check_xs_DoAllActions_tr1_tr1()) {
			effect_xs_DoAllActions_tr1();
		} else {
			if (check_xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_arrived_tr0_tr0()) {
				effect_xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_arrived_tr0();
			} else {
				if (check_xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_arrived_tr1_tr1()) {
					effect_xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_arrived_tr1();
				}
			}
		}
	}
	
	/* The reactions of state backToTheOperator. */
	private void react_xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_backToTheOperator() {
		if (check_xs_DoAllActions_tr1_tr1()) {
			effect_xs_DoAllActions_tr1();
		} else {
			if (check_xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_backToTheOperator_tr0_tr0()) {
				effect_xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_backToTheOperator_tr0();
			} else {
				if (check_xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_backToTheOperator_tr1_tr1()) {
					effect_xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_backToTheOperator_tr1();
				} else {
					if (check_xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_backToTheOperator_tr2_tr2()) {
						effect_xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_backToTheOperator_tr2();
					}
				}
			}
		}
	}
	
	/* The reactions of state bringGehtnicht. */
	private void react_xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_bringGehtnicht() {
		if (check_xs_DoAllActions_tr1_tr1()) {
			effect_xs_DoAllActions_tr1();
		} else {
			if (check_xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_bringGehtnicht_tr0_tr0()) {
				effect_xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_bringGehtnicht_tr0();
			} else {
				if (check_xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_bringGehtnicht_tr1_tr1()) {
					effect_xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_bringGehtnicht_tr1();
				}
			}
		}
	}
	
	/* The reactions of state stattdessen goto. */
	private void react_xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_stattdessen_goto() {
		if (check_xs_DoAllActions_tr1_tr1()) {
			effect_xs_DoAllActions_tr1();
		} else {
			if (check_xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_stattdessen_goto_tr0_tr0()) {
				effect_xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_stattdessen_goto_tr0();
			}
		}
	}
	
	/* The reactions of state notArrived. */
	private void react_xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_notArrived() {
		if (check_xs_DoAllActions_tr1_tr1()) {
			effect_xs_DoAllActions_tr1();
		} else {
			if (check_xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_notArrived_tr0_tr0()) {
				effect_xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_notArrived_tr0();
			} else {
				if (check_xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_notArrived_tr1_tr1()) {
					effect_xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_notArrived_tr1();
				}
			}
		}
	}
	
	/* The reactions of state open. */
	private void react_xs_DoAllActions__region0_DoAction_Instructions_open() {
		if (check_xs_DoAllActions_tr1_tr1()) {
			effect_xs_DoAllActions_tr1();
		} else {
			if (check_xs_DoAllActions__region0_DoAction_Instructions_open_tr0_tr0()) {
				effect_xs_DoAllActions__region0_DoAction_Instructions_open_tr0();
			} else {
				if (check_xs_DoAllActions__region0_DoAction_Instructions_open_tr1_tr1()) {
					effect_xs_DoAllActions__region0_DoAction_Instructions_open_tr1();
				}
			}
		}
	}
	
	/* The reactions of state STToff. */
	private void react_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking_WaitingForStopCommand_STToff() {
		if (check_xs_DoAllActions_tr1_tr1()) {
			effect_xs_DoAllActions_tr1();
		} else {
			if (check_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking_tr0_tr0()) {
				effect_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking_tr0();
			} else {
				if (check_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking_tr2_tr2()) {
					effect_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking_tr2();
				} else {
					if (check_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking_WaitingForStopCommand_STToff_tr0_tr0()) {
						effect_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking_WaitingForStopCommand_STToff_tr0();
					} else {
						if (check_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking_WaitingForStopCommand_STToff_tr1_tr1()) {
							effect_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking_WaitingForStopCommand_STToff_tr1();
						}
					}
				}
			}
		}
	}
	
	/* The reactions of state STTstart. */
	private void react_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking_WaitingForStopCommand_STTstart() {
		if (check_xs_DoAllActions_tr1_tr1()) {
			effect_xs_DoAllActions_tr1();
		} else {
			if (check_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking_tr0_tr0()) {
				effect_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking_tr0();
			} else {
				if (check_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking_tr2_tr2()) {
					effect_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking_tr2();
				} else {
					if (check_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking_WaitingForStopCommand_STTstart_tr0_tr0()) {
						effect_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking_WaitingForStopCommand_STTstart_tr0();
					} else {
						if (check_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking_WaitingForStopCommand_STTstart_tr1_tr1()) {
							effect_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking_WaitingForStopCommand_STTstart_tr1();
						}
					}
				}
			}
		}
	}
	
	/* The reactions of state UTurn1. */
	private void react_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_UTurn1() {
		if (check_xs_DoAllActions_tr1_tr1()) {
			effect_xs_DoAllActions_tr1();
		} else {
			if (check_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_tr1_tr1()) {
				effect_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_tr1();
			} else {
				if (check_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_UTurn1_tr0_tr0()) {
					effect_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_UTurn1_tr0();
				}
			}
		}
	}
	
	/* The reactions of state WaveFound. */
	private void react_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_WaveFound() {
		if (check_xs_DoAllActions_tr1_tr1()) {
			effect_xs_DoAllActions_tr1();
		} else {
			if (check_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_tr1_tr1()) {
				effect_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_tr1();
			} else {
				if (check_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_WaveFound_tr0_tr0()) {
					effect_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_WaveFound_tr0();
				}
			}
		}
	}
	
	/* The reactions of state Turn. */
	private void react_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_Turn() {
		if (check_xs_DoAllActions_tr1_tr1()) {
			effect_xs_DoAllActions_tr1();
		} else {
			if (check_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_tr1_tr1()) {
				effect_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_tr1();
			} else {
				if (check_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_Turn_tr0_tr0()) {
					effect_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_Turn_tr0();
				} else {
					if (check_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_Turn_tr1_tr1()) {
						effect_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_Turn_tr1();
					}
				}
			}
		}
	}
	
	/* The reactions of state DetectionOn. */
	private void react_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_DetectionOn() {
		if (check_xs_DoAllActions_tr1_tr1()) {
			effect_xs_DoAllActions_tr1();
		} else {
			if (check_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_tr1_tr1()) {
				effect_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_tr1();
			} else {
				effect_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_DetectionOn_tr0();
			}
		}
	}
	
	/* The reactions of state PersonFound. */
	private void react_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_PersonFound() {
		if (check_xs_DoAllActions_tr1_tr1()) {
			effect_xs_DoAllActions_tr1();
		} else {
			if (check_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_tr1_tr1()) {
				effect_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_tr1();
			} else {
				effect_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_PersonFound_tr0();
			}
		}
	}
	
	/* The reactions of state ILostYou. */
	private void react_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_ILostYou() {
		if (check_xs_DoAllActions_tr1_tr1()) {
			effect_xs_DoAllActions_tr1();
		} else {
			if (check_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_tr1_tr1()) {
				effect_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_tr1();
			} else {
				if (check_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_ILostYou_tr0_tr0()) {
					effect_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_ILostYou_tr0();
				} else {
					if (check_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_ILostYou_tr1_tr1()) {
						effect_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_ILostYou_tr1();
					}
				}
			}
		}
	}
	
	/* The reactions of state UTurn2. */
	private void react_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_UTurn2() {
		if (check_xs_DoAllActions_tr1_tr1()) {
			effect_xs_DoAllActions_tr1();
		} else {
			if (check_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_tr1_tr1()) {
				effect_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_tr1();
			} else {
				if (check_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_UTurn2_tr0_tr0()) {
					effect_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_UTurn2_tr0();
				}
			}
		}
	}
	
	/* The reactions of state Detection. */
	private void react_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_Detection() {
		if (check_xs_DoAllActions_tr1_tr1()) {
			effect_xs_DoAllActions_tr1();
		} else {
			if (check_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_tr1_tr1()) {
				effect_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_tr1();
			} else {
				if (check_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_Detection_tr0_tr0()) {
					effect_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_Detection_tr0();
				} else {
					if (check_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_Detection_tr1_tr1()) {
						effect_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_Detection_tr1();
					} else {
						if (check_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_Detection_tr2_tr2()) {
							effect_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_Detection_tr2();
						}
					}
				}
			}
		}
	}
	
	/* The reactions of state NotFound. */
	private void react_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_NotFound() {
		if (check_xs_DoAllActions_tr1_tr1()) {
			effect_xs_DoAllActions_tr1();
		} else {
			if (check_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_tr1_tr1()) {
				effect_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_tr1();
			} else {
				effect_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_NotFound_tr0();
			}
		}
	}
	
	/* The reactions of state Detect. */
	private void react_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Detect() {
		if (check_xs_DoAllActions_tr1_tr1()) {
			effect_xs_DoAllActions_tr1();
		} else {
			if (check_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Detect_tr0_tr0()) {
				effect_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Detect_tr0();
			} else {
				if (check_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Detect_tr1_tr1()) {
					effect_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Detect_tr1();
				}
			}
		}
	}
	
	/* The reactions of state no. */
	private void react_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_no() {
		if (check_xs_DoAllActions_tr1_tr1()) {
			effect_xs_DoAllActions_tr1();
		} else {
			effect_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_no_tr0();
		}
	}
	
	/* The reactions of state HowCanIHelpYou. */
	private void react_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_HowCanIHelpYou() {
		if (check_xs_DoAllActions_tr1_tr1()) {
			effect_xs_DoAllActions_tr1();
		} else {
			if (check_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_HowCanIHelpYou_tr0_tr0()) {
				effect_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_HowCanIHelpYou_tr0();
			}
		}
	}
	
	/* The reactions of state Wir brauchen das gerade nicht. */
	private void react_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wir_brauchen_das_gerade_nicht() {
		if (check_xs_DoAllActions_tr1_tr1()) {
			effect_xs_DoAllActions_tr1();
		} else {
			if (check_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wir_brauchen_das_gerade_nicht_tr0_tr0()) {
				effect_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wir_brauchen_das_gerade_nicht_tr0();
			}
		}
	}
	
	/* The reactions of state unknown. */
	private void react_xs_DoAllActions__region0_DoAction_Instructions_unknown() {
		if (check_xs_DoAllActions_tr1_tr1()) {
			effect_xs_DoAllActions_tr1();
		} else {
			if (check_xs_DoAllActions__region0_DoAction_Instructions_unknown_tr0_tr0()) {
				effect_xs_DoAllActions__region0_DoAction_Instructions_unknown_tr0();
			} else {
				if (check_xs_DoAllActions__region0_DoAction_Instructions_unknown_tr1_tr1()) {
					effect_xs_DoAllActions__region0_DoAction_Instructions_unknown_tr1();
				}
			}
		}
	}
	
	/* The reactions of state crowd. */
	private void react_xs_DoAllActions__region0_DoAction_Instructions_crowd() {
		if (check_xs_DoAllActions_tr1_tr1()) {
			effect_xs_DoAllActions_tr1();
		} else {
			if (check_xs_DoAllActions__region0_DoAction_Instructions_crowd_tr0_tr0()) {
				effect_xs_DoAllActions__region0_DoAction_Instructions_crowd_tr0();
			} else {
				if (check_xs_DoAllActions__region0_DoAction_Instructions_crowd_tr1_tr1()) {
					effect_xs_DoAllActions__region0_DoAction_Instructions_crowd_tr1();
				}
			}
		}
	}
	
	/* The reactions of state tell. */
	private void react_xs_DoAllActions__region0_DoAction_Instructions_tell() {
		if (check_xs_DoAllActions_tr1_tr1()) {
			effect_xs_DoAllActions_tr1();
		} else {
			if (check_xs_DoAllActions__region0_DoAction_Instructions_tell_tr0_tr0()) {
				effect_xs_DoAllActions__region0_DoAction_Instructions_tell_tr0();
			} else {
				if (check_xs_DoAllActions__region0_DoAction_Instructions_tell_tr1_tr1()) {
					effect_xs_DoAllActions__region0_DoAction_Instructions_tell_tr1();
				}
			}
		}
	}
	
	/* The reactions of state question. */
	private void react_xs_DoAllActions__region0_DoAction_Instructions_question() {
		if (check_xs_DoAllActions_tr1_tr1()) {
			effect_xs_DoAllActions_tr1();
		} else {
		}
	}
	
	/* The reactions of state GoToOp. */
	private void react_xs_GoToOp() {
		if (check_xs_GoToOp_tr0_tr0()) {
			effect_xs_GoToOp_tr0();
		} else {
			if (check_xs_GoToOp_tr1_tr1()) {
				effect_xs_GoToOp_tr1();
			} else {
				if (check_xs_GoToOp_tr2_tr2()) {
					effect_xs_GoToOp_tr2();
				}
			}
		}
	}
	
	/* The reactions of state blocked. */
	private void react_xs_blocked() {
		if (check_xs_blocked_tr0_tr0()) {
			effect_xs_blocked_tr0();
		} else {
			if (check_xs_blocked_tr1_tr1()) {
				effect_xs_blocked_tr1();
			}
		}
	}
	
	/* The reactions of state time out. */
	private void react_xs_time_out() {
		effect_xs_time_out_tr0();
	}
	
	/* The reactions of state DontDoIt. */
	private void react_xs_DontDoIt() {
		if (check_xs_DontDoIt_tr0_tr0()) {
			effect_xs_DontDoIt_tr0();
		} else {
			if (check_xs_DontDoIt_tr1_tr1()) {
				effect_xs_DontDoIt_tr1();
			}
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
	private void react_xs__choice_0() {
		if (check_xs__choice_0_tr1_tr1()) {
			effect_xs__choice_0_tr1();
		} else {
			effect_xs__choice_0_tr0();
		}
	}
	
	/* The reactions of state null. */
	private void react_xs_STT_and_Tell_Actions_s__choice_0() {
		if (check_xs_STT_and_Tell_Actions_s__choice_0_tr1_tr1()) {
			effect_xs_STT_and_Tell_Actions_s__choice_0_tr1();
		} else {
			effect_xs_STT_and_Tell_Actions_s__choice_0_tr0();
		}
	}
	
	/* The reactions of state null. */
	private void react_xs_STT_and_Tell_Actions_s__choice_1() {
		if (check_xs_STT_and_Tell_Actions_s__choice_1_tr0_tr0()) {
			effect_xs_STT_and_Tell_Actions_s__choice_1_tr0();
		} else {
			effect_xs_STT_and_Tell_Actions_s__choice_1_tr1();
		}
	}
	
	/* The reactions of state null. */
	private void react_xs_STT_and_Tell_Actions_s__choice_2() {
		if (check_xs_STT_and_Tell_Actions_s__choice_2_tr0_tr0()) {
			effect_xs_STT_and_Tell_Actions_s__choice_2_tr0();
		} else {
			effect_xs_STT_and_Tell_Actions_s__choice_2_tr1();
		}
	}
	
	/* The reactions of state null. */
	private void react_xs_DoAllActions__region0_DoAction_Instructions_GoTo_goto_GeneralP_extended__choice_0() {
		if (check_xs_DoAllActions__region0_DoAction_Instructions_GoTo_goto_GeneralP_extended__choice_0_tr1_tr1()) {
			effect_xs_DoAllActions__region0_DoAction_Instructions_GoTo_goto_GeneralP_extended__choice_0_tr1();
		} else {
			effect_xs_DoAllActions__region0_DoAction_Instructions_GoTo_goto_GeneralP_extended__choice_0_tr0();
		}
	}
	
	/* The reactions of state null. */
	private void react_xs_DoAllActions__region0_DoAction_Instructions__choice_0() {
		if (check_xs_DoAllActions__region0_DoAction_Instructions__choice_0_tr0_tr0()) {
			effect_xs_DoAllActions__region0_DoAction_Instructions__choice_0_tr0();
		} else {
			if (check_xs_DoAllActions__region0_DoAction_Instructions__choice_0_tr1_tr1()) {
				effect_xs_DoAllActions__region0_DoAction_Instructions__choice_0_tr1();
			} else {
				if (check_xs_DoAllActions__region0_DoAction_Instructions__choice_0_tr2_tr2()) {
					effect_xs_DoAllActions__region0_DoAction_Instructions__choice_0_tr2();
				} else {
					if (check_xs_DoAllActions__region0_DoAction_Instructions__choice_0_tr3_tr3()) {
						effect_xs_DoAllActions__region0_DoAction_Instructions__choice_0_tr3();
					} else {
						if (check_xs_DoAllActions__region0_DoAction_Instructions__choice_0_tr4_tr4()) {
							effect_xs_DoAllActions__region0_DoAction_Instructions__choice_0_tr4();
						} else {
							if (check_xs_DoAllActions__region0_DoAction_Instructions__choice_0_tr5_tr5()) {
								effect_xs_DoAllActions__region0_DoAction_Instructions__choice_0_tr5();
							} else {
								if (check_xs_DoAllActions__region0_DoAction_Instructions__choice_0_tr7_tr7()) {
									effect_xs_DoAllActions__region0_DoAction_Instructions__choice_0_tr7();
								} else {
									if (check_xs_DoAllActions__region0_DoAction_Instructions__choice_0_tr8_tr8()) {
										effect_xs_DoAllActions__region0_DoAction_Instructions__choice_0_tr8();
									} else {
										effect_xs_DoAllActions__region0_DoAction_Instructions__choice_0_tr6();
									}
								}
							}
						}
					}
				}
			}
		}
	}
	
	/* The reactions of state null. */
	private void react_xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended__choice_0() {
		if (check_xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended__choice_0_tr1_tr1()) {
			effect_xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended__choice_0_tr1();
		} else {
			effect_xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended__choice_0_tr0();
		}
	}
	
	/* The reactions of state null. */
	private void react_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking_WaitingForStopCommand__choice_0() {
		if (check_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking_WaitingForStopCommand__choice_0_tr0_tr0()) {
			effect_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking_WaitingForStopCommand__choice_0_tr0();
		} else {
			effect_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking_WaitingForStopCommand__choice_0_tr1();
		}
	}
	
	/* The reactions of state null. */
	private void react_xs_DoAllActions__region0__choice_0() {
		if (check_xs_DoAllActions__region0__choice_0_tr1_tr1()) {
			effect_xs_DoAllActions__region0__choice_0_tr1();
		} else {
			effect_xs_DoAllActions__region0__choice_0_tr0();
		}
	}
	
	/* The reactions of state null. */
	private void react_xs__choice_1() {
		if (check_xs__choice_1_tr0_tr0()) {
			effect_xs__choice_1_tr0();
		} else {
			effect_xs__choice_1_tr1();
		}
	}
	
	/* Default react sequence for initial entry  */
	private void react_xs__entry_Default() {
		enterSequence_xs_Init_default();
	}
	
	/* Default react sequence for initial entry  */
	private void react_xs_STT_and_Tell_Actions_s__entry_Default() {
		enterSequence_xs_STT_and_Tell_Actions_s_StartSTT_default();
	}
	
	/* Default react sequence for initial entry  */
	private void react_xs_DoAllActions__region0_DoAction_Instructions__entry_Default() {
		react_xs_DoAllActions__region0_DoAction_Instructions__choice_0();
	}
	
	/* Default react sequence for initial entry  */
	private void react_xs_DoAllActions__region0_DoAction_Instructions_GoTo_goto_GeneralP_extended__entry_Default() {
		react_xs_DoAllActions__region0_DoAction_Instructions_GoTo_goto_GeneralP_extended__choice_0();
	}
	
	/* Default react sequence for initial entry  */
	private void react_xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended__entry_Default() {
		enterSequence_xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_bringGehtnicht_default();
	}
	
	/* Default react sequence for initial entry  */
	private void react_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking_WaitingForStopCommand__entry_Default() {
		enterSequence_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking_WaitingForStopCommand_STTstart_default();
	}
	
	/* Default react sequence for initial entry  */
	private void react_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson__entry_Default() {
		enterSequence_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_ILostYou_default();
	}
	
	/* Default react sequence for initial entry  */
	private void react_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR__entry_Default() {
		enterSequence_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wir_brauchen_das_gerade_nicht_default();
	}
	
	/* Default react sequence for initial entry  */
	private void react_xs_DoAllActions__region0_DoAction_Instructions_question_Ask_a_question__entry_Default() {
		react_xs_DoAllActions__region0_DoAction_Instructions_question_Ask_a_question_exit_done();
	}
	
	/* Default react sequence for initial entry  */
	private void react_xs_DoAllActions__region0__entry_Default() {
		enterSequence_xs_DoAllActions__region0_DoAction_default();
	}
	
	/* Default react sequence for initial entry  */
	private void react_Leonie_Bupered_Or_Emergency_Stop__entry_Default() {
		enterSequence_Leonie_Bupered_Or_Emergency_Stop_waitForEvent_default();
	}
	
	/* The reactions of exit exit_correct. */
	private void react_xs_STT_and_Tell_Actions_s_exit_correct() {
		effect_xs_STT_and_Tell_Actions_tr1();
	}
	
	/* The reactions of exit exit_incomprehensible. */
	private void react_xs_STT_and_Tell_Actions_s_exit_incomprehensible() {
		effect_xs_STT_and_Tell_Actions_tr2();
	}
	
	/* The reactions of exit exit_incorrect. */
	private void react_xs_STT_and_Tell_Actions_s_exit_incorrect() {
		effect_xs_STT_and_Tell_Actions_tr3();
	}
	
	/* The reactions of exit exit_noActions. */
	private void react_xs_STT_and_Tell_Actions_s_exit_noActions() {
		effect_xs_STT_and_Tell_Actions_tr0();
	}
	
	/* The reactions of exit exit_done. */
	private void react_xs_DoAllActions__region0_DoAction_Instructions_exit_done() {
		effect_xs_DoAllActions__region0_DoAction_tr0();
	}
	
	/* The reactions of exit exit_done. */
	private void react_xs_DoAllActions__region0_DoAction_Instructions_GoTo_goto_GeneralP_extended_exit_done() {
		effect_xs_DoAllActions__region0_DoAction_Instructions_GoTo_tr0();
	}
	
	/* The reactions of exit exit_done. */
	private void react_xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_exit_done() {
		effect_xs_DoAllActions__region0_DoAction_Instructions_bring_tr0();
	}
	
	/* The reactions of exit exit_arrived. */
	private void react_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking_WaitingForStopCommand_exit_arrived() {
		effect_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking_tr1();
	}
	
	/* The reactions of exit exit_done. */
	private void react_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_exit_done() {
		effect_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_tr0();
	}
	
	/* The reactions of exit exit_done. */
	private void react_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_exit_done() {
		effect_xs_DoAllActions__region0_DoAction_Instructions_followme_tr0();
	}
	
	/* The reactions of exit exit_done. */
	private void react_xs_DoAllActions__region0_DoAction_Instructions_question_Ask_a_question_exit_done() {
		effect_xs_DoAllActions__region0_DoAction_Instructions_question_tr0();
	}
	
	/* The reactions of exit exit_done. */
	private void react_xs_DoAllActions__region0_exit_done() {
		effect_xs_DoAllActions_tr0();
	}
	
	public void runCycle() {
		if (!initialized)
			throw new IllegalStateException(
					"The state machine needs to be initialized first by calling the init() function.");
		clearOutEvents();
		for (nextStateIndex = 0; nextStateIndex < stateVector.length; nextStateIndex++) {
			switch (stateVector[nextStateIndex]) {
			case xs_Hello:
				react_xs_Hello();
				break;
			case xs_Leave_the_arena:
				react_xs_Leave_the_arena();
				break;
			case xs__final_:
				react_xs__final_();
				break;
			case xs_DetectionsOn:
				react_xs_DetectionsOn();
				break;
			case xs_Init:
				react_xs_Init();
				break;
			case xs_TellAnswer:
				react_xs_TellAnswer();
				break;
			case xs_StopSTT:
				react_xs_StopSTT();
				break;
			case xs_TellIncomprehensible:
				react_xs_TellIncomprehensible();
				break;
			case xs_STT_and_Tell_Actions_s_StartSTT:
				react_xs_STT_and_Tell_Actions_s_StartSTT();
				break;
			case xs_STT_and_Tell_Actions_s_TellSpokenText:
				react_xs_STT_and_Tell_Actions_s_TellSpokenText();
				break;
			case xs_STT_and_Tell_Actions_s_YesNo:
				react_xs_STT_and_Tell_Actions_s_YesNo();
				break;
			case xs_STT_and_Tell_Actions_s_GeneratedCommand:
				react_xs_STT_and_Tell_Actions_s_GeneratedCommand();
				break;
			case xs_leave2:
				react_xs_leave2();
				break;
			case xs_leave3:
				react_xs_leave3();
				break;
			case xs_DoAllActions__region0_DoAction_Instructions_GoTo_goto_GeneralP_extended_livingroom:
				react_xs_DoAllActions__region0_DoAction_Instructions_GoTo_goto_GeneralP_extended_livingroom();
				break;
			case xs_DoAllActions__region0_DoAction_Instructions_GoTo_goto_GeneralP_extended_notFound:
				react_xs_DoAllActions__region0_DoAction_Instructions_GoTo_goto_GeneralP_extended_notFound();
				break;
			case xs_DoAllActions__region0_DoAction_Instructions_GoTo_goto_GeneralP_extended_arrived:
				react_xs_DoAllActions__region0_DoAction_Instructions_GoTo_goto_GeneralP_extended_arrived();
				break;
			case xs_DoAllActions__region0_DoAction_Instructions_GoTo_goto_GeneralP_extended_backToTheOperator:
				react_xs_DoAllActions__region0_DoAction_Instructions_GoTo_goto_GeneralP_extended_backToTheOperator();
				break;
			case xs_DoAllActions__region0_DoAction_Instructions_GoTo_goto_GeneralP_extended_notArrived:
				react_xs_DoAllActions__region0_DoAction_Instructions_GoTo_goto_GeneralP_extended_notArrived();
				break;
			case xs_DoAllActions__region0_DoAction_Instructions_surrounding:
				react_xs_DoAllActions__region0_DoAction_Instructions_surrounding();
				break;
			case xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_livingroom:
				react_xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_livingroom();
				break;
			case xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_notFound:
				react_xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_notFound();
				break;
			case xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_arrived:
				react_xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_arrived();
				break;
			case xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_backToTheOperator:
				react_xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_backToTheOperator();
				break;
			case xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_bringGehtnicht:
				react_xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_bringGehtnicht();
				break;
			case xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_stattdessen_goto:
				react_xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_stattdessen_goto();
				break;
			case xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_notArrived:
				react_xs_DoAllActions__region0_DoAction_Instructions_bring_bring_GeneralP_extended_notArrived();
				break;
			case xs_DoAllActions__region0_DoAction_Instructions_open:
				react_xs_DoAllActions__region0_DoAction_Instructions_open();
				break;
			case xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking_WaitingForStopCommand_STToff:
				react_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking_WaitingForStopCommand_STToff();
				break;
			case xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking_WaitingForStopCommand_STTstart:
				react_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking_WaitingForStopCommand_STTstart();
				break;
			case xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_UTurn1:
				react_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_UTurn1();
				break;
			case xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_WaveFound:
				react_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_WaveFound();
				break;
			case xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_Turn:
				react_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_Turn();
				break;
			case xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_DetectionOn:
				react_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_DetectionOn();
				break;
			case xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_PersonFound:
				react_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_PersonFound();
				break;
			case xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_ILostYou:
				react_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_ILostYou();
				break;
			case xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_UTurn2:
				react_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_UTurn2();
				break;
			case xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_Detection:
				react_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_Detection();
				break;
			case xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_NotFound:
				react_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_NotFound();
				break;
			case xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Detect:
				react_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Detect();
				break;
			case xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_no:
				react_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_no();
				break;
			case xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_HowCanIHelpYou:
				react_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_HowCanIHelpYou();
				break;
			case xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wir_brauchen_das_gerade_nicht:
				react_xs_DoAllActions__region0_DoAction_Instructions_followme_FollowMe_in_GPSR_Wir_brauchen_das_gerade_nicht();
				break;
			case xs_DoAllActions__region0_DoAction_Instructions_unknown:
				react_xs_DoAllActions__region0_DoAction_Instructions_unknown();
				break;
			case xs_DoAllActions__region0_DoAction_Instructions_crowd:
				react_xs_DoAllActions__region0_DoAction_Instructions_crowd();
				break;
			case xs_DoAllActions__region0_DoAction_Instructions_tell:
				react_xs_DoAllActions__region0_DoAction_Instructions_tell();
				break;
			case xs_DoAllActions__region0_DoAction_Instructions_question:
				react_xs_DoAllActions__region0_DoAction_Instructions_question();
				break;
			case xs_GoToOp:
				react_xs_GoToOp();
				break;
			case xs_blocked:
				react_xs_blocked();
				break;
			case xs_time_out:
				react_xs_time_out();
				break;
			case xs_DontDoIt:
				react_xs_DontDoIt();
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
