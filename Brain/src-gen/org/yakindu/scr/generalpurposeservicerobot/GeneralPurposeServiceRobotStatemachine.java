package org.yakindu.scr.generalpurposeservicerobot;
import org.yakindu.scr.ITimer;

public class GeneralPurposeServiceRobotStatemachine implements IGeneralPurposeServiceRobotStatemachine {

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
		main_region_TellAnswer,
		main_region_DoAction,
		main_region_DoAction_Instructions_GoTo,
		main_region_DoAction_Instructions_GoTo_goto_GeneralP_livingroom,
		main_region_DoAction_Instructions_GoTo_goto_GeneralP_notFound,
		main_region_DoAction_Instructions_GoTo_goto_GeneralP_arrived,
		main_region_DoAction_Instructions_GoTo_goto_GeneralP_backToTheOperator,
		main_region_DoAction_Instructions_surrounding,
		main_region_DoAction_Instructions_bring,
		main_region_DoAction_Instructions_bring_bring_GeneralP_livingroom,
		main_region_DoAction_Instructions_bring_bring_GeneralP_notFound,
		main_region_DoAction_Instructions_bring_bring_GeneralP_arrived,
		main_region_DoAction_Instructions_bring_bring_GeneralP_backToTheOperator,
		main_region_DoAction_Instructions_bring_bring_GeneralP_bringGehtnicht,
		main_region_DoAction_Instructions_bring_bring_GeneralP_stattdessen_goto,
		main_region_DoAction_Instructions_open,
		main_region_DoAction_Instructions_followme,
		main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking,
		main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking_WaitingForStopCommand_STToff,
		main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking_WaitingForStopCommand_STTstart,
		main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave,
		main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_UTurn1,
		main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_WaveFound,
		main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_Turn,
		main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_DetectionOn,
		main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_PersonFound,
		main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_ILostYou,
		main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_UTurn2,
		main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_Detection,
		main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_NotFound,
		main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Detect,
		main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_no,
		main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_HowCanIHelpYou,
		main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wir_brauchen_das_gerade_nicht,
		main_region_DoAction_Instructions_unknown,
		main_region_DoAction_Instructions_Copy_1_crowd,
		main_region_StopSTT,
		main_region_TellIncomprehensible,
		main_region_NextQuestion,
		main_region_Copy_1_STT,
		main_region_Copy_1_STT_STT_StartSTT,
		main_region_Copy_1_STT_STT_TellSpokenText,
		main_region_Copy_1_STT_STT_StropSTT,
		main_region_leave2,
		main_region_leave3,
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
		sCIBGF = new SCIBGFImpl();
		sCIHBrain = new SCIHBrainImpl();
		sCIMira = new SCIMiraImpl();
		sCISTT = new SCISTTImpl();
		sCICrowdDetection = new SCICrowdDetectionImpl();
		sCIFollowMe = new SCIFollowMeImpl();
		sCIKinect2 = new SCIKinect2Impl();
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
		sCIBGF.setEventNum(0);
		
		sCIBGF.setRandNum(0);
		
		setCounter(0);
		
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
		case main_region_TellAnswer:
			return stateVector[0] == State.main_region_TellAnswer;
		case main_region_DoAction:
			return stateVector[0].ordinal() >= State.
					main_region_DoAction.ordinal()&& stateVector[0].ordinal() <= State.main_region_DoAction_Instructions_Copy_1_crowd.ordinal();
		case main_region_DoAction_Instructions_GoTo:
			return stateVector[0].ordinal() >= State.
					main_region_DoAction_Instructions_GoTo.ordinal()&& stateVector[0].ordinal() <= State.main_region_DoAction_Instructions_GoTo_goto_GeneralP_backToTheOperator.ordinal();
		case main_region_DoAction_Instructions_GoTo_goto_GeneralP_livingroom:
			return stateVector[0] == State.main_region_DoAction_Instructions_GoTo_goto_GeneralP_livingroom;
		case main_region_DoAction_Instructions_GoTo_goto_GeneralP_notFound:
			return stateVector[0] == State.main_region_DoAction_Instructions_GoTo_goto_GeneralP_notFound;
		case main_region_DoAction_Instructions_GoTo_goto_GeneralP_arrived:
			return stateVector[0] == State.main_region_DoAction_Instructions_GoTo_goto_GeneralP_arrived;
		case main_region_DoAction_Instructions_GoTo_goto_GeneralP_backToTheOperator:
			return stateVector[0] == State.main_region_DoAction_Instructions_GoTo_goto_GeneralP_backToTheOperator;
		case main_region_DoAction_Instructions_surrounding:
			return stateVector[0] == State.main_region_DoAction_Instructions_surrounding;
		case main_region_DoAction_Instructions_bring:
			return stateVector[0].ordinal() >= State.
					main_region_DoAction_Instructions_bring.ordinal()&& stateVector[0].ordinal() <= State.main_region_DoAction_Instructions_bring_bring_GeneralP_stattdessen_goto.ordinal();
		case main_region_DoAction_Instructions_bring_bring_GeneralP_livingroom:
			return stateVector[0] == State.main_region_DoAction_Instructions_bring_bring_GeneralP_livingroom;
		case main_region_DoAction_Instructions_bring_bring_GeneralP_notFound:
			return stateVector[0] == State.main_region_DoAction_Instructions_bring_bring_GeneralP_notFound;
		case main_region_DoAction_Instructions_bring_bring_GeneralP_arrived:
			return stateVector[0] == State.main_region_DoAction_Instructions_bring_bring_GeneralP_arrived;
		case main_region_DoAction_Instructions_bring_bring_GeneralP_backToTheOperator:
			return stateVector[0] == State.main_region_DoAction_Instructions_bring_bring_GeneralP_backToTheOperator;
		case main_region_DoAction_Instructions_bring_bring_GeneralP_bringGehtnicht:
			return stateVector[0] == State.main_region_DoAction_Instructions_bring_bring_GeneralP_bringGehtnicht;
		case main_region_DoAction_Instructions_bring_bring_GeneralP_stattdessen_goto:
			return stateVector[0] == State.main_region_DoAction_Instructions_bring_bring_GeneralP_stattdessen_goto;
		case main_region_DoAction_Instructions_open:
			return stateVector[0] == State.main_region_DoAction_Instructions_open;
		case main_region_DoAction_Instructions_followme:
			return stateVector[0].ordinal() >= State.
					main_region_DoAction_Instructions_followme.ordinal()&& stateVector[0].ordinal() <= State.main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wir_brauchen_das_gerade_nicht.ordinal();
		case main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking:
			return stateVector[0].ordinal() >= State.
					main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking.ordinal()&& stateVector[0].ordinal() <= State.main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking_WaitingForStopCommand_STTstart.ordinal();
		case main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking_WaitingForStopCommand_STToff:
			return stateVector[0] == State.main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking_WaitingForStopCommand_STToff;
		case main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking_WaitingForStopCommand_STTstart:
			return stateVector[0] == State.main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking_WaitingForStopCommand_STTstart;
		case main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave:
			return stateVector[0].ordinal() >= State.
					main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave.ordinal()&& stateVector[0].ordinal() <= State.main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_NotFound.ordinal();
		case main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_UTurn1:
			return stateVector[0] == State.main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_UTurn1;
		case main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_WaveFound:
			return stateVector[0] == State.main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_WaveFound;
		case main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_Turn:
			return stateVector[0] == State.main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_Turn;
		case main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_DetectionOn:
			return stateVector[0] == State.main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_DetectionOn;
		case main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_PersonFound:
			return stateVector[0] == State.main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_PersonFound;
		case main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_ILostYou:
			return stateVector[0] == State.main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_ILostYou;
		case main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_UTurn2:
			return stateVector[0] == State.main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_UTurn2;
		case main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_Detection:
			return stateVector[0] == State.main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_Detection;
		case main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_NotFound:
			return stateVector[0] == State.main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_NotFound;
		case main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Detect:
			return stateVector[0] == State.main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Detect;
		case main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_no:
			return stateVector[0] == State.main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_no;
		case main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_HowCanIHelpYou:
			return stateVector[0] == State.main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_HowCanIHelpYou;
		case main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wir_brauchen_das_gerade_nicht:
			return stateVector[0] == State.main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wir_brauchen_das_gerade_nicht;
		case main_region_DoAction_Instructions_unknown:
			return stateVector[0] == State.main_region_DoAction_Instructions_unknown;
		case main_region_DoAction_Instructions_Copy_1_crowd:
			return stateVector[0] == State.main_region_DoAction_Instructions_Copy_1_crowd;
		case main_region_StopSTT:
			return stateVector[0] == State.main_region_StopSTT;
		case main_region_TellIncomprehensible:
			return stateVector[0] == State.main_region_TellIncomprehensible;
		case main_region_NextQuestion:
			return stateVector[0] == State.main_region_NextQuestion;
		case main_region_Copy_1_STT:
			return stateVector[0].ordinal() >= State.
					main_region_Copy_1_STT.ordinal()&& stateVector[0].ordinal() <= State.main_region_Copy_1_STT_STT_StropSTT.ordinal();
		case main_region_Copy_1_STT_STT_StartSTT:
			return stateVector[0] == State.main_region_Copy_1_STT_STT_StartSTT;
		case main_region_Copy_1_STT_STT_TellSpokenText:
			return stateVector[0] == State.main_region_Copy_1_STT_STT_TellSpokenText;
		case main_region_Copy_1_STT_STT_StropSTT:
			return stateVector[0] == State.main_region_Copy_1_STT_STT_StropSTT;
		case main_region_leave2:
			return stateVector[0] == State.main_region_leave2;
		case main_region_leave3:
			return stateVector[0] == State.main_region_leave3;
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
	
	public SCIMicrophoneArray getSCIMicrophoneArray() {
		return sCIMicrophoneArray;
	}
	
	private boolean check_main_region_Hello_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_main_region_Hello_tr1_tr1() {
		return timeEvents[0];
	}
	
	private boolean check_main_region_Leave_the_arena_tr0_tr0() {
		return sCIMira.arrivedWP;
	}
	
	private boolean check_main_region_DetectionsOn_tr0_tr0() {
		return sCICrowdDetection.detected;
	}
	
	private boolean check_main_region_DetectionsOn_tr1_tr1() {
		return timeEvents[1];
	}
	
	private boolean check_main_region_Init_tr0_tr0() {
		return sCIMira.arrivedWP;
	}
	
	private boolean check_main_region_TellAnswer_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_main_region_TellAnswer_tr1_tr1() {
		return timeEvents[2];
	}
	
	private boolean check_main_region_DoAction_Instructions_GoTo_goto_GeneralP_livingroom_tr0_tr0() {
		return sCIMira.arrivedWP;
	}
	
	private boolean check_main_region_DoAction_Instructions_GoTo_goto_GeneralP_livingroom_tr1_tr1() {
		return timeEvents[3];
	}
	
	private boolean check_main_region_DoAction_Instructions_GoTo_goto_GeneralP_notFound_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_main_region_DoAction_Instructions_GoTo_goto_GeneralP_notFound_tr1_tr1() {
		return timeEvents[4];
	}
	
	private boolean check_main_region_DoAction_Instructions_GoTo_goto_GeneralP_arrived_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_main_region_DoAction_Instructions_GoTo_goto_GeneralP_arrived_tr1_tr1() {
		return timeEvents[5];
	}
	
	private boolean check_main_region_DoAction_Instructions_GoTo_goto_GeneralP_backToTheOperator_tr0_tr0() {
		return sCIMira.arrivedWP;
	}
	
	private boolean check_main_region_DoAction_Instructions_surrounding_tr0_tr0() {
		return true;
	}
	
	private boolean check_main_region_DoAction_Instructions_bring_bring_GeneralP_livingroom_tr0_tr0() {
		return sCIMira.arrivedWP;
	}
	
	private boolean check_main_region_DoAction_Instructions_bring_bring_GeneralP_notFound_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_main_region_DoAction_Instructions_bring_bring_GeneralP_notFound_tr1_tr1() {
		return timeEvents[6];
	}
	
	private boolean check_main_region_DoAction_Instructions_bring_bring_GeneralP_arrived_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_main_region_DoAction_Instructions_bring_bring_GeneralP_backToTheOperator_tr0_tr0() {
		return sCIMira.arrivedWP;
	}
	
	private boolean check_main_region_DoAction_Instructions_bring_bring_GeneralP_bringGehtnicht_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_main_region_DoAction_Instructions_bring_bring_GeneralP_bringGehtnicht_tr1_tr1() {
		return timeEvents[7];
	}
	
	private boolean check_main_region_DoAction_Instructions_bring_bring_GeneralP_stattdessen_goto_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_main_region_DoAction_Instructions_open_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_main_region_DoAction_Instructions_open_tr1_tr1() {
		return timeEvents[8];
	}
	
	private boolean check_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking_tr0_tr0() {
		return sCIFollowMe.trackingPersonLost;
	}
	
	private boolean check_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking_tr2_tr2() {
		return timeEvents[9];
	}
	
	private boolean check_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking_WaitingForStopCommand_STToff_tr0_tr0() {
		return sCISTT.actionReceived;
	}
	
	private boolean check_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking_WaitingForStopCommand_STToff_tr1_tr1() {
		return timeEvents[10];
	}
	
	private boolean check_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking_WaitingForStopCommand_STTstart_tr0_tr0() {
		return timeEvents[11];
	}
	
	private boolean check_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking_WaitingForStopCommand_STTstart_tr1_tr1() {
		return sCISTT.actionReceived;
	}
	
	private boolean check_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_tr1_tr1() {
		return timeEvents[12];
	}
	
	private boolean check_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_UTurn1_tr0_tr0() {
		return timeEvents[13];
	}
	
	private boolean check_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_WaveFound_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_Turn_tr0_tr0() {
		return sCIKinect2.wavingDetected;
	}
	
	private boolean check_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_Turn_tr1_tr1() {
		return timeEvents[14];
	}
	
	private boolean check_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_DetectionOn_tr0_tr0() {
		return true;
	}
	
	private boolean check_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_PersonFound_tr0_tr0() {
		return true;
	}
	
	private boolean check_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_ILostYou_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_ILostYou_tr1_tr1() {
		return timeEvents[15];
	}
	
	private boolean check_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_UTurn2_tr0_tr0() {
		return timeEvents[16];
	}
	
	private boolean check_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_Detection_tr0_tr0() {
		return timeEvents[17];
	}
	
	private boolean check_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_Detection_tr1_tr1() {
		return sCIFollowMe.detectionPersonFound;
	}
	
	private boolean check_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_Detection_tr2_tr2() {
		return getCounter()>10;
	}
	
	private boolean check_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_NotFound_tr0_tr0() {
		return true;
	}
	
	private boolean check_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Detect_tr0_tr0() {
		return sCIFollowMe.detectionPersonFound;
	}
	
	private boolean check_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Detect_tr1_tr1() {
		return timeEvents[18];
	}
	
	private boolean check_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_no_tr0_tr0() {
		return true;
	}
	
	private boolean check_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_HowCanIHelpYou_tr0_tr0() {
		return sCIMira.arrivedWP;
	}
	
	private boolean check_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wir_brauchen_das_gerade_nicht_tr0_tr0() {
		return 1==0;
	}
	
	private boolean check_main_region_DoAction_Instructions_unknown_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_main_region_DoAction_Instructions_unknown_tr1_tr1() {
		return timeEvents[19];
	}
	
	private boolean check_main_region_DoAction_Instructions_Copy_1_crowd_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_main_region_DoAction_Instructions_Copy_1_crowd_tr1_tr1() {
		return timeEvents[20];
	}
	
	private boolean check_main_region_StopSTT_tr0_tr0() {
		return true;
	}
	
	private boolean check_main_region_TellIncomprehensible_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_main_region_TellIncomprehensible_tr1_tr1() {
		return timeEvents[21];
	}
	
	private boolean check_main_region_NextQuestion_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_main_region_NextQuestion_tr1_tr1() {
		return timeEvents[22];
	}
	
	private boolean check_main_region_Copy_1_STT_STT_StartSTT_tr0_tr0() {
		return timeEvents[23];
	}
	
	private boolean check_main_region_Copy_1_STT_STT_TellSpokenText_tr0_tr0() {
		return sCISTT.answerReceived;
	}
	
	private boolean check_main_region_Copy_1_STT_STT_TellSpokenText_tr1_tr1() {
		return sCISTT.actionReceived;
	}
	
	private boolean check_main_region_Copy_1_STT_STT_TellSpokenText_tr2_tr2() {
		return sCISTT.incomprehensible;
	}
	
	private boolean check_main_region_Copy_1_STT_STT_TellSpokenText_tr3_tr3() {
		return timeEvents[24];
	}
	
	private boolean check_main_region_Copy_1_STT_STT_StropSTT_tr0_tr0() {
		return sCISTT.spokenTextReceived;
	}
	
	private boolean check_main_region_Copy_1_STT_STT_StropSTT_tr1_tr1() {
		return timeEvents[25];
	}
	
	private boolean check_main_region_leave2_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_main_region_leave2_tr1_tr1() {
		return timeEvents[26];
	}
	
	private boolean check_main_region_leave3_tr0_tr0() {
		return sCIMira.arrivedWP;
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
	
	private boolean check_main_region_DoAction_Instructions_GoTo_goto_GeneralP__choice_0_tr1_tr1() {
		return sCIBGF.operationCallback.getGWPByName(sCISTT.operationCallback.getObject())==-1;
	}
	
	private boolean check_main_region_DoAction_Instructions_GoTo_goto_GeneralP__choice_0_tr0_tr0() {
		return true;
	}
	
	private boolean check_main_region_DoAction_Instructions__choice_0_tr0_tr0() {
		return (sCISTT.operationCallback.getInstruction()== null?"goto" ==null :sCISTT.operationCallback.getInstruction().equals("goto"));
	}
	
	private boolean check_main_region_DoAction_Instructions__choice_0_tr1_tr1() {
		return (sCISTT.operationCallback.getInstruction()== null?"crowd" ==null :sCISTT.operationCallback.getInstruction().equals("crowd"));
	}
	
	private boolean check_main_region_DoAction_Instructions__choice_0_tr2_tr2() {
		return (sCISTT.operationCallback.getInstruction()== null?"surrounding" ==null :sCISTT.operationCallback.getInstruction().equals("surrounding"));
	}
	
	private boolean check_main_region_DoAction_Instructions__choice_0_tr3_tr3() {
		return (sCISTT.operationCallback.getInstruction()== null?"bring" ==null :sCISTT.operationCallback.getInstruction().equals("bring"));
	}
	
	private boolean check_main_region_DoAction_Instructions__choice_0_tr4_tr4() {
		return (sCISTT.operationCallback.getInstruction()== null?"open" ==null :sCISTT.operationCallback.getInstruction().equals("open"));
	}
	
	private boolean check_main_region_DoAction_Instructions__choice_0_tr5_tr5() {
		return (sCISTT.operationCallback.getInstruction()== null?"followme" ==null :sCISTT.operationCallback.getInstruction().equals("followme"));
	}
	
	private boolean check_main_region_DoAction_Instructions__choice_0_tr6_tr6() {
		return true;
	}
	
	private boolean check_main_region_DoAction_Instructions_bring_bring_GeneralP__choice_0_tr1_tr1() {
		return sCIBGF.operationCallback.getGWPByName(sCISTT.operationCallback.getObject())==-1;
	}
	
	private boolean check_main_region_DoAction_Instructions_bring_bring_GeneralP__choice_0_tr0_tr0() {
		return true;
	}
	
	private boolean check_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking_WaitingForStopCommand__choice_0_tr0_tr0() {
		return (sCISTT.operationCallback.getInstruction()== null?"followme" ==null :sCISTT.operationCallback.getInstruction().equals("followme")) && (sCISTT.operationCallback.getObject()== null?"stop" ==null :sCISTT.operationCallback.getObject().equals("stop"));
	}
	
	private boolean check_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking_WaitingForStopCommand__choice_0_tr1_tr1() {
		return true;
	}
	
	private boolean check_main_region__choice_0_tr1_tr1() {
		return getCounter()>=3;
	}
	
	private boolean check_main_region__choice_0_tr0_tr0() {
		return true;
	}
	
	private boolean check_main_region_Copy_1_STT_STT__choice_0_tr1_tr1() {
		return (sCISTT.operationCallback.getSpokenText()== null?"" !=null : !sCISTT.operationCallback.getSpokenText().equals(""));
	}
	
	private boolean check_main_region_Copy_1_STT_STT__choice_0_tr0_tr0() {
		return true;
	}
	
	private void effect_main_region_Hello_tr0() {
		exitSequence_main_region_Hello();
		enterSequence_main_region_Copy_1_STT_default();
	}
	
	private void effect_main_region_Hello_tr1() {
		exitSequence_main_region_Hello();
		enterSequence_main_region_Copy_1_STT_default();
	}
	
	private void effect_main_region_Leave_the_arena_tr0() {
		exitSequence_main_region_Leave_the_arena();
		enterSequence_main_region_leave2_default();
	}
	
	private void effect_main_region_DetectionsOn_tr0() {
		exitSequence_main_region_DetectionsOn();
		enterSequence_main_region_Hello_default();
	}
	
	private void effect_main_region_DetectionsOn_tr1() {
		exitSequence_main_region_DetectionsOn();
		enterSequence_main_region_Hello_default();
	}
	
	private void effect_main_region_Init_tr0() {
		exitSequence_main_region_Init();
		enterSequence_main_region_DetectionsOn_default();
	}
	
	private void effect_main_region_TellAnswer_tr0() {
		exitSequence_main_region_TellAnswer();
		enterSequence_main_region_StopSTT_default();
	}
	
	private void effect_main_region_TellAnswer_tr1() {
		exitSequence_main_region_TellAnswer();
		enterSequence_main_region_StopSTT_default();
	}
	
	private void effect_main_region_DoAction_tr0() {
		exitSequence_main_region_DoAction();
		enterSequence_main_region_StopSTT_default();
	}
	
	private void effect_main_region_DoAction_Instructions_GoTo_tr0() {
		exitSequence_main_region_DoAction_Instructions_GoTo();
		react_main_region_DoAction_Instructions_exit_done();
	}
	
	private void effect_main_region_DoAction_Instructions_GoTo_goto_GeneralP_livingroom_tr0() {
		exitSequence_main_region_DoAction_Instructions_GoTo_goto_GeneralP_livingroom();
		enterSequence_main_region_DoAction_Instructions_GoTo_goto_GeneralP_arrived_default();
	}
	
	private void effect_main_region_DoAction_Instructions_GoTo_goto_GeneralP_livingroom_tr1() {
		exitSequence_main_region_DoAction_Instructions_GoTo_goto_GeneralP_livingroom();
		enterSequence_main_region_DoAction_Instructions_GoTo_goto_GeneralP_arrived_default();
	}
	
	private void effect_main_region_DoAction_Instructions_GoTo_goto_GeneralP_notFound_tr0() {
		exitSequence_main_region_DoAction_Instructions_GoTo_goto_GeneralP_notFound();
		react_main_region_DoAction_Instructions_GoTo_goto_GeneralP_exit_done();
	}
	
	private void effect_main_region_DoAction_Instructions_GoTo_goto_GeneralP_notFound_tr1() {
		exitSequence_main_region_DoAction_Instructions_GoTo_goto_GeneralP_notFound();
		react_main_region_DoAction_Instructions_GoTo_goto_GeneralP_exit_done();
	}
	
	private void effect_main_region_DoAction_Instructions_GoTo_goto_GeneralP_arrived_tr0() {
		exitSequence_main_region_DoAction_Instructions_GoTo_goto_GeneralP_arrived();
		enterSequence_main_region_DoAction_Instructions_GoTo_goto_GeneralP_backToTheOperator_default();
	}
	
	private void effect_main_region_DoAction_Instructions_GoTo_goto_GeneralP_arrived_tr1() {
		exitSequence_main_region_DoAction_Instructions_GoTo_goto_GeneralP_arrived();
		enterSequence_main_region_DoAction_Instructions_GoTo_goto_GeneralP_backToTheOperator_default();
	}
	
	private void effect_main_region_DoAction_Instructions_GoTo_goto_GeneralP_backToTheOperator_tr0() {
		exitSequence_main_region_DoAction_Instructions_GoTo_goto_GeneralP_backToTheOperator();
		react_main_region_DoAction_Instructions_GoTo_goto_GeneralP_exit_done();
	}
	
	private void effect_main_region_DoAction_Instructions_surrounding_tr0() {
		exitSequence_main_region_DoAction_Instructions_surrounding();
		react_main_region_DoAction_Instructions_exit_done();
	}
	
	private void effect_main_region_DoAction_Instructions_bring_tr0() {
		exitSequence_main_region_DoAction_Instructions_bring();
		react_main_region_DoAction_Instructions_exit_done();
	}
	
	private void effect_main_region_DoAction_Instructions_bring_bring_GeneralP_livingroom_tr0() {
		exitSequence_main_region_DoAction_Instructions_bring_bring_GeneralP_livingroom();
		enterSequence_main_region_DoAction_Instructions_bring_bring_GeneralP_arrived_default();
	}
	
	private void effect_main_region_DoAction_Instructions_bring_bring_GeneralP_notFound_tr0() {
		exitSequence_main_region_DoAction_Instructions_bring_bring_GeneralP_notFound();
		react_main_region_DoAction_Instructions_bring_bring_GeneralP_exit_done();
	}
	
	private void effect_main_region_DoAction_Instructions_bring_bring_GeneralP_notFound_tr1() {
		exitSequence_main_region_DoAction_Instructions_bring_bring_GeneralP_notFound();
		react_main_region_DoAction_Instructions_bring_bring_GeneralP_exit_done();
	}
	
	private void effect_main_region_DoAction_Instructions_bring_bring_GeneralP_arrived_tr0() {
		exitSequence_main_region_DoAction_Instructions_bring_bring_GeneralP_arrived();
		enterSequence_main_region_DoAction_Instructions_bring_bring_GeneralP_backToTheOperator_default();
	}
	
	private void effect_main_region_DoAction_Instructions_bring_bring_GeneralP_backToTheOperator_tr0() {
		exitSequence_main_region_DoAction_Instructions_bring_bring_GeneralP_backToTheOperator();
		react_main_region_DoAction_Instructions_bring_bring_GeneralP_exit_done();
	}
	
	private void effect_main_region_DoAction_Instructions_bring_bring_GeneralP_bringGehtnicht_tr0() {
		exitSequence_main_region_DoAction_Instructions_bring_bring_GeneralP_bringGehtnicht();
		react_main_region_DoAction_Instructions_bring_bring_GeneralP__choice_0();
	}
	
	private void effect_main_region_DoAction_Instructions_bring_bring_GeneralP_bringGehtnicht_tr1() {
		exitSequence_main_region_DoAction_Instructions_bring_bring_GeneralP_bringGehtnicht();
		react_main_region_DoAction_Instructions_bring_bring_GeneralP__choice_0();
	}
	
	private void effect_main_region_DoAction_Instructions_bring_bring_GeneralP_stattdessen_goto_tr0() {
		exitSequence_main_region_DoAction_Instructions_bring_bring_GeneralP_stattdessen_goto();
		enterSequence_main_region_DoAction_Instructions_bring_bring_GeneralP_livingroom_default();
	}
	
	private void effect_main_region_DoAction_Instructions_open_tr0() {
		exitSequence_main_region_DoAction_Instructions_open();
		react_main_region_DoAction_Instructions_exit_done();
	}
	
	private void effect_main_region_DoAction_Instructions_open_tr1() {
		exitSequence_main_region_DoAction_Instructions_open();
		react_main_region_DoAction_Instructions_exit_done();
	}
	
	private void effect_main_region_DoAction_Instructions_followme_tr0() {
		exitSequence_main_region_DoAction_Instructions_followme();
		react_main_region_DoAction_Instructions_exit_done();
	}
	
	private void effect_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking_tr0() {
		exitSequence_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking();
		enterSequence_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_default();
	}
	
	private void effect_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking_tr1() {
		exitSequence_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking();
		enterSequence_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_HowCanIHelpYou_default();
	}
	
	private void effect_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking_tr2() {
		exitSequence_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking();
		enterSequence_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_HowCanIHelpYou_default();
	}
	
	private void effect_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking_WaitingForStopCommand_STToff_tr0() {
		exitSequence_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking_WaitingForStopCommand_STToff();
		react_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking_WaitingForStopCommand__choice_0();
	}
	
	private void effect_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking_WaitingForStopCommand_STToff_tr1() {
		exitSequence_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking_WaitingForStopCommand_STToff();
		enterSequence_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking_WaitingForStopCommand_STTstart_default();
	}
	
	private void effect_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking_WaitingForStopCommand_STTstart_tr0() {
		exitSequence_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking_WaitingForStopCommand_STTstart();
		enterSequence_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking_WaitingForStopCommand_STToff_default();
	}
	
	private void effect_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking_WaitingForStopCommand_STTstart_tr1() {
		exitSequence_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking_WaitingForStopCommand_STTstart();
		react_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking_WaitingForStopCommand__choice_0();
	}
	
	private void effect_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_tr0() {
		exitSequence_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave();
		enterSequence_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking_default();
	}
	
	private void effect_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_tr1() {
		exitSequence_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave();
		enterSequence_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_no_default();
	}
	
	private void effect_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_UTurn1_tr0() {
		exitSequence_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_UTurn1();
		enterSequence_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_Turn_default();
	}
	
	private void effect_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_WaveFound_tr0() {
		exitSequence_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_WaveFound();
		enterSequence_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_UTurn2_default();
	}
	
	private void effect_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_Turn_tr0() {
		exitSequence_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_Turn();
		enterSequence_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_WaveFound_default();
	}
	
	private void effect_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_Turn_tr1() {
		exitSequence_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_Turn();
		enterSequence_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_Turn_default();
	}
	
	private void effect_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_DetectionOn_tr0() {
		exitSequence_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_DetectionOn();
		enterSequence_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_Detection_default();
	}
	
	private void effect_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_PersonFound_tr0() {
		exitSequence_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_PersonFound();
		react_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_exit_done();
	}
	
	private void effect_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_ILostYou_tr0() {
		exitSequence_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_ILostYou();
		enterSequence_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_UTurn1_default();
	}
	
	private void effect_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_ILostYou_tr1() {
		exitSequence_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_ILostYou();
		enterSequence_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_UTurn1_default();
	}
	
	private void effect_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_UTurn2_tr0() {
		exitSequence_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_UTurn2();
		enterSequence_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_DetectionOn_default();
	}
	
	private void effect_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_Detection_tr0() {
		exitSequence_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_Detection();
		enterSequence_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_Detection_default();
	}
	
	private void effect_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_Detection_tr1() {
		exitSequence_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_Detection();
		enterSequence_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_PersonFound_default();
	}
	
	private void effect_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_Detection_tr2() {
		exitSequence_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_Detection();
		enterSequence_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_NotFound_default();
	}
	
	private void effect_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_NotFound_tr0() {
		exitSequence_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_NotFound();
		enterSequence_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_Detection_default();
	}
	
	private void effect_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Detect_tr0() {
		exitSequence_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Detect();
		enterSequence_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking_default();
	}
	
	private void effect_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Detect_tr1() {
		exitSequence_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Detect();
		enterSequence_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_no_default();
	}
	
	private void effect_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_no_tr0() {
		exitSequence_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_no();
		react_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_exit_done();
	}
	
	private void effect_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_HowCanIHelpYou_tr0() {
		exitSequence_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_HowCanIHelpYou();
		react_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_exit_done();
	}
	
	private void effect_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wir_brauchen_das_gerade_nicht_tr0() {
		exitSequence_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wir_brauchen_das_gerade_nicht();
		enterSequence_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Detect_default();
	}
	
	private void effect_main_region_DoAction_Instructions_unknown_tr0() {
		exitSequence_main_region_DoAction_Instructions_unknown();
		react_main_region_DoAction_Instructions_exit_done();
	}
	
	private void effect_main_region_DoAction_Instructions_unknown_tr1() {
		exitSequence_main_region_DoAction_Instructions_unknown();
		react_main_region_DoAction_Instructions_exit_done();
	}
	
	private void effect_main_region_DoAction_Instructions_Copy_1_crowd_tr0() {
		exitSequence_main_region_DoAction_Instructions_Copy_1_crowd();
		react_main_region_DoAction_Instructions_exit_done();
	}
	
	private void effect_main_region_DoAction_Instructions_Copy_1_crowd_tr1() {
		exitSequence_main_region_DoAction_Instructions_Copy_1_crowd();
		react_main_region_DoAction_Instructions_exit_done();
	}
	
	private void effect_main_region_StopSTT_tr0() {
		exitSequence_main_region_StopSTT();
		react_main_region__choice_0();
	}
	
	private void effect_main_region_TellIncomprehensible_tr0() {
		exitSequence_main_region_TellIncomprehensible();
		enterSequence_main_region_StopSTT_default();
	}
	
	private void effect_main_region_TellIncomprehensible_tr1() {
		exitSequence_main_region_TellIncomprehensible();
		enterSequence_main_region_StopSTT_default();
	}
	
	private void effect_main_region_NextQuestion_tr0() {
		exitSequence_main_region_NextQuestion();
		enterSequence_main_region_Copy_1_STT_default();
	}
	
	private void effect_main_region_NextQuestion_tr1() {
		exitSequence_main_region_NextQuestion();
		enterSequence_main_region_Copy_1_STT_default();
	}
	
	private void effect_main_region_Copy_1_STT_tr0() {
		exitSequence_main_region_Copy_1_STT();
		enterSequence_main_region_TellAnswer_default();
	}
	
	private void effect_main_region_Copy_1_STT_tr1() {
		exitSequence_main_region_Copy_1_STT();
		enterSequence_main_region_DoAction_default();
	}
	
	private void effect_main_region_Copy_1_STT_tr2() {
		exitSequence_main_region_Copy_1_STT();
		enterSequence_main_region_TellIncomprehensible_default();
	}
	
	private void effect_main_region_Copy_1_STT_STT_StartSTT_tr0() {
		exitSequence_main_region_Copy_1_STT_STT_StartSTT();
		enterSequence_main_region_Copy_1_STT_STT_StropSTT_default();
	}
	
	private void effect_main_region_Copy_1_STT_STT_TellSpokenText_tr0() {
		exitSequence_main_region_Copy_1_STT_STT_TellSpokenText();
		react_main_region_Copy_1_STT_STT_exit_answer();
	}
	
	private void effect_main_region_Copy_1_STT_STT_TellSpokenText_tr1() {
		exitSequence_main_region_Copy_1_STT_STT_TellSpokenText();
		react_main_region_Copy_1_STT_STT_exit_action();
	}
	
	private void effect_main_region_Copy_1_STT_STT_TellSpokenText_tr2() {
		exitSequence_main_region_Copy_1_STT_STT_TellSpokenText();
		react_main_region_Copy_1_STT_STT_exit_incomprehensible();
	}
	
	private void effect_main_region_Copy_1_STT_STT_TellSpokenText_tr3() {
		exitSequence_main_region_Copy_1_STT_STT_TellSpokenText();
		react_main_region_Copy_1_STT_STT_exit_incomprehensible();
	}
	
	private void effect_main_region_Copy_1_STT_STT_StropSTT_tr0() {
		exitSequence_main_region_Copy_1_STT_STT_StropSTT();
		react_main_region_Copy_1_STT_STT__choice_0();
	}
	
	private void effect_main_region_Copy_1_STT_STT_StropSTT_tr1() {
		exitSequence_main_region_Copy_1_STT_STT_StropSTT();
		react_main_region_Copy_1_STT_STT_exit_incomprehensible();
	}
	
	private void effect_main_region_leave2_tr0() {
		exitSequence_main_region_leave2();
		enterSequence_main_region_leave3_default();
	}
	
	private void effect_main_region_leave2_tr1() {
		exitSequence_main_region_leave2();
		enterSequence_main_region_leave3_default();
	}
	
	private void effect_main_region_leave3_tr0() {
		exitSequence_main_region_leave3();
		enterSequence_main_region__final__default();
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
	
	private void effect_main_region_DoAction_Instructions_GoTo_goto_GeneralP__choice_0_tr1() {
		enterSequence_main_region_DoAction_Instructions_GoTo_goto_GeneralP_notFound_default();
	}
	
	private void effect_main_region_DoAction_Instructions_GoTo_goto_GeneralP__choice_0_tr0() {
		enterSequence_main_region_DoAction_Instructions_GoTo_goto_GeneralP_livingroom_default();
	}
	
	private void effect_main_region_DoAction_Instructions__choice_0_tr0() {
		enterSequence_main_region_DoAction_Instructions_GoTo_default();
	}
	
	private void effect_main_region_DoAction_Instructions__choice_0_tr1() {
		enterSequence_main_region_DoAction_Instructions_Copy_1_crowd_default();
	}
	
	private void effect_main_region_DoAction_Instructions__choice_0_tr2() {
		enterSequence_main_region_DoAction_Instructions_surrounding_default();
	}
	
	private void effect_main_region_DoAction_Instructions__choice_0_tr3() {
		enterSequence_main_region_DoAction_Instructions_bring_default();
	}
	
	private void effect_main_region_DoAction_Instructions__choice_0_tr4() {
		enterSequence_main_region_DoAction_Instructions_open_default();
	}
	
	private void effect_main_region_DoAction_Instructions__choice_0_tr5() {
		enterSequence_main_region_DoAction_Instructions_followme_default();
	}
	
	private void effect_main_region_DoAction_Instructions__choice_0_tr6() {
		enterSequence_main_region_DoAction_Instructions_unknown_default();
	}
	
	private void effect_main_region_DoAction_Instructions_bring_bring_GeneralP__choice_0_tr1() {
		enterSequence_main_region_DoAction_Instructions_bring_bring_GeneralP_notFound_default();
	}
	
	private void effect_main_region_DoAction_Instructions_bring_bring_GeneralP__choice_0_tr0() {
		enterSequence_main_region_DoAction_Instructions_bring_bring_GeneralP_stattdessen_goto_default();
	}
	
	private void effect_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking_WaitingForStopCommand__choice_0_tr0() {
		react_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking_WaitingForStopCommand_exit_arrived();
	}
	
	private void effect_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking_WaitingForStopCommand__choice_0_tr1() {
		enterSequence_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking_WaitingForStopCommand_STTstart_default();
	}
	
	private void effect_main_region__choice_0_tr1() {
		enterSequence_main_region_Leave_the_arena_default();
	}
	
	private void effect_main_region__choice_0_tr0() {
		enterSequence_main_region_NextQuestion_default();
	}
	
	private void effect_main_region_Copy_1_STT_STT__choice_0_tr1() {
		enterSequence_main_region_Copy_1_STT_STT_TellSpokenText_default();
	}
	
	private void effect_main_region_Copy_1_STT_STT__choice_0_tr0() {
		react_main_region_Copy_1_STT_STT_exit_incomprehensible();
	}
	
	/* Entry action for state 'Hello'. */
	private void entryAction_main_region_Hello() {
		timer.setTimer(this, 0, 10*1000, false);
		
		sCICrowdDetection.operationCallback.sendDetectionOff();
		
		sCIHBrain.operationCallback.sendTTS("[:-)] Hello! What can I do for you? [attentive]");
		
		setCounter(0);
	}
	
	/* Entry action for state 'Leave the arena'. */
	private void entryAction_main_region_Leave_the_arena() {
		sCIHBrain.operationCallback.sendTTS("I hope, I was of any help! [:-)] Bye bye.");
		
		sCIMira.operationCallback.sendGoToGWP(0);
	}
	
	/* Entry action for state 'DetectionsOn'. */
	private void entryAction_main_region_DetectionsOn() {
		timer.setTimer(this, 1, 10*1000, false);
		
		sCICrowdDetection.operationCallback.sendDetectionOn();
	}
	
	/* Entry action for state 'Init'. */
	private void entryAction_main_region_Init() {
		setGWPout(13);
		
		setGWPstart(6);
		
		sCIMira.operationCallback.sendGoToGWP(getGWPstart());
	}
	
	/* Entry action for state 'TellAnswer'. */
	private void entryAction_main_region_TellAnswer() {
		timer.setTimer(this, 2, 30*1000, false);
		
		sCIHBrain.operationCallback.sendTTS2(sCISTT.operationCallback.getAnswer(), " [:-)]");
		
		setCounter(counter+1);
	}
	
	/* Entry action for state 'DoAction'. */
	private void entryAction_main_region_DoAction() {
		setCounter(counter+1);
	}
	
	/* Entry action for state 'GoTo'. */
	private void entryAction_main_region_DoAction_Instructions_GoTo() {
		sCIHBrain.operationCallback.sendTTS3("[:-)] Okay, I go to ", sCISTT.operationCallback.getObject(), ". [:-|]");
	}
	
	/* Entry action for state 'livingroom'. */
	private void entryAction_main_region_DoAction_Instructions_GoTo_goto_GeneralP_livingroom() {
		timer.setTimer(this, 3, 180*1000, false);
		
		sCIMira.operationCallback.sendGoToGWP(sCIBGF.operationCallback.getGWPByName(sCISTT.operationCallback.getObject()));
	}
	
	/* Entry action for state 'notFound'. */
	private void entryAction_main_region_DoAction_Instructions_GoTo_goto_GeneralP_notFound() {
		timer.setTimer(this, 4, 10*1000, false);
		
		sCIHBrain.operationCallback.sendTTS3("I don't know a location called ", sCISTT.operationCallback.getObject(), ".");
	}
	
	/* Entry action for state 'arrived'. */
	private void entryAction_main_region_DoAction_Instructions_GoTo_goto_GeneralP_arrived() {
		timer.setTimer(this, 5, 10*1000, false);
		
		sCIHBrain.operationCallback.sendTTS3("I arrived at ", sCISTT.operationCallback.getObject(), ". That was my task.");
	}
	
	/* Entry action for state 'backToTheOperator'. */
	private void entryAction_main_region_DoAction_Instructions_GoTo_goto_GeneralP_backToTheOperator() {
		sCIMira.operationCallback.sendGoToGWP(getGWPstart());
		
		sCIHBrain.operationCallback.sendTTS("Now, I'm going back to my operator.");
	}
	
	/* Entry action for state 'livingroom'. */
	private void entryAction_main_region_DoAction_Instructions_bring_bring_GeneralP_livingroom() {
		sCIMira.operationCallback.sendGoToGWP(sCIBGF.operationCallback.getGWPByName(sCISTT.operationCallback.getObject()));
	}
	
	/* Entry action for state 'notFound'. */
	private void entryAction_main_region_DoAction_Instructions_bring_bring_GeneralP_notFound() {
		timer.setTimer(this, 6, 10*1000, false);
		
		sCIHBrain.operationCallback.sendTTS3("Furthermore, I don't know a location for ", sCISTT.operationCallback.getObject(), ".");
	}
	
	/* Entry action for state 'arrived'. */
	private void entryAction_main_region_DoAction_Instructions_bring_bring_GeneralP_arrived() {
		sCIHBrain.operationCallback.sendTTS3("Here can you find the ", sCISTT.operationCallback.getObject(), ".");
	}
	
	/* Entry action for state 'backToTheOperator'. */
	private void entryAction_main_region_DoAction_Instructions_bring_bring_GeneralP_backToTheOperator() {
		sCIMira.operationCallback.sendGoToGWP(getGWPstart());
		
		sCIHBrain.operationCallback.sendTTS("Now, I'm going back.");
	}
	
	/* Entry action for state 'bringGehtnicht'. */
	private void entryAction_main_region_DoAction_Instructions_bring_bring_GeneralP_bringGehtnicht() {
		timer.setTimer(this, 7, 10*1000, false);
		
		sCIHBrain.operationCallback.sendTTS("[:-(] I'm sorry. I can't bring you something, because I have no manipulator. [:-)]");
	}
	
	/* Entry action for state 'stattdessen goto'. */
	private void entryAction_main_region_DoAction_Instructions_bring_bring_GeneralP_stattdessen_goto() {
		sCIHBrain.operationCallback.sendTTS("But I will show you, where it is. Come with me! [:-)]");
	}
	
	/* Entry action for state 'open'. */
	private void entryAction_main_region_DoAction_Instructions_open() {
		timer.setTimer(this, 8, 10*1000, false);
		
		sCIHBrain.operationCallback.sendTTS("[:-(] I'm sorry. I can't open something because I have no manipulator.");
	}
	
	/* Entry action for state 'followme'. */
	private void entryAction_main_region_DoAction_Instructions_followme() {
		sCIHBrain.operationCallback.sendTTS("[:-(] I'm sorry. I can't follow somebody at the moment.");
	}
	
	/* Entry action for state 'StartTracking'. */
	private void entryAction_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking() {
		timer.setTimer(this, 9, 30*1000, false);
		
		sCIFollowMe.operationCallback.sendTrackingOnAtNext();
		
		sCIHBrain.operationCallback.sendTTS("Okay, I follow you!");
	}
	
	/* Entry action for state 'STToff'. */
	private void entryAction_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking_WaitingForStopCommand_STToff() {
		timer.setTimer(this, 10, 5*1000, false);
		
		sCISTT.operationCallback.sendSpeechDetectionOff();
		
		sCIHBrain.operationCallback.sendTTS("[:-)]");
	}
	
	/* Entry action for state 'STTstart'. */
	private void entryAction_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking_WaitingForStopCommand_STTstart() {
		timer.setTimer(this, 11, 5*1000, false);
		
		sCISTT.operationCallback.sendSpeechDetectionSmalltalk();
		
		sCIHBrain.operationCallback.sendTTS("[attentive]");
	}
	
	/* Entry action for state 'Wave'. */
	private void entryAction_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave() {
		timer.setTimer(this, 12, 10*1000, false);
	}
	
	/* Entry action for state 'UTurn1'. */
	private void entryAction_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_UTurn1() {
		timer.setTimer(this, 13, 1*1000, false);
		
		sCIMira.operationCallback.sendBodyUTurn();
	}
	
	/* Entry action for state 'WaveFound'. */
	private void entryAction_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_WaveFound() {
		sCIHBrain.operationCallback.sendTTS("{Person}Thank you! Please hold on.");
		
		sCIKinect2.operationCallback.sendWavingDetectionOnOff(false);
	}
	
	/* Entry action for state 'Turn'. */
	private void entryAction_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_Turn() {
		timer.setTimer(this, 14, 5*1000, false);
		
		sCIKinect2.operationCallback.sendWavingDetectionOnOff(true);
		
		sCIHBrain.operationCallback.sendTTS("[:-|] Please wave for me.");
	}
	
	/* Entry action for state 'DetectionOn'. */
	private void entryAction_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_DetectionOn() {
		sCIFollowMe.operationCallback.sendDetectionOn();
		
		setCounter(0);
	}
	
	/* Entry action for state 'PersonFound'. */
	private void entryAction_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_PersonFound() {
		sCIHBrain.operationCallback.sendTTS("[:-)] Okay, let's go on!");
	}
	
	/* Entry action for state 'ILostYou'. */
	private void entryAction_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_ILostYou() {
		timer.setTimer(this, 15, 5*1000, false);
		
		sCIFollowMe.operationCallback.sendTrackingOff();
		
		sCIHBrain.operationCallback.sendTTS("[-.-] I lost you!{180;0}");
	}
	
	/* Entry action for state 'UTurn2'. */
	private void entryAction_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_UTurn2() {
		timer.setTimer(this, 16, 3*1000, false);
		
		sCIMira.operationCallback.sendBodyUTurn();
	}
	
	/* Entry action for state 'Detection'. */
	private void entryAction_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_Detection() {
		timer.setTimer(this, 17, 1*1000, false);
		
		sCIFollowMe.operationCallback.sendRequestDetectionDetails();
		
		setCounter(counter+1);
	}
	
	/* Entry action for state 'NotFound'. */
	private void entryAction_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_NotFound() {
		sCIHBrain.operationCallback.sendTTS("[:-(] Please get into my view!");
		
		setCounter(0);
	}
	
	/* Entry action for state 'Detect'. */
	private void entryAction_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Detect() {
		timer.setTimer(this, 18, 5*1000, false);
		
		sCIFollowMe.operationCallback.sendDetectionOff();
	}
	
	/* Entry action for state 'no'. */
	private void entryAction_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_no() {
		sCIHBrain.operationCallback.sendTTS("I found no Person for following.");
		
		sCIFollowMe.operationCallback.sendTrackingOff();
		
		sCIFollowMe.operationCallback.sendDetectionOff();
		
		sCIMira.operationCallback.sendGoToGWP(getGWPstart());
	}
	
	/* Entry action for state 'HowCanIHelpYou'. */
	private void entryAction_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_HowCanIHelpYou() {
		sCIFollowMe.operationCallback.sendTrackingOff();
		
		sCIFollowMe.operationCallback.sendDetectionOff();
		
		sCIHBrain.operationCallback.sendTTS("[:-)] Okay. Nice to be here. I will go back.");
		
		sCIMira.operationCallback.sendGoToGWP(getGWPstart());
	}
	
	/* Entry action for state 'unknown'. */
	private void entryAction_main_region_DoAction_Instructions_unknown() {
		timer.setTimer(this, 19, 10*1000, false);
		
		sCIHBrain.operationCallback.sendTTS("[:-|] I'm sorry. This command is unknown.");
	}
	
	/* Entry action for state 'Copy_1_crowd'. */
	private void entryAction_main_region_DoAction_Instructions_Copy_1_crowd() {
		timer.setTimer(this, 20, 10*1000, false);
		
		sCIHBrain.operationCallback.sendTTS(sCICrowdDetection.operationCallback.getAnswerForSecificCrowdDetails(sCISTT.operationCallback.getObject()));
	}
	
	/* Entry action for state 'StopSTT'. */
	private void entryAction_main_region_StopSTT() {
		sCISTT.operationCallback.sendSpeechDetectionOff();
	}
	
	/* Entry action for state 'TellIncomprehensible'. */
	private void entryAction_main_region_TellIncomprehensible() {
		timer.setTimer(this, 21, 10*1000, false);
		
		sCIHBrain.operationCallback.sendTTS3("[:-(]", sCISTT.operationCallback.getAnswer(), "[:-|]");
	}
	
	/* Entry action for state 'NextQuestion'. */
	private void entryAction_main_region_NextQuestion() {
		timer.setTimer(this, 22, 10*1000, false);
		
		sCIHBrain.operationCallback.sendTTS("Please give me the next command or ask me a question. [attentive]");
	}
	
	/* Entry action for state 'StartSTT'. */
	private void entryAction_main_region_Copy_1_STT_STT_StartSTT() {
		timer.setTimer(this, 23, 8*1000, false);
		
		sCISTT.operationCallback.sendSpeechDetectionSmalltalk();
		
		sCIHBrain.operationCallback.sendTTS("[attentive]");
	}
	
	/* Entry action for state 'TellSpokenText'. */
	private void entryAction_main_region_Copy_1_STT_STT_TellSpokenText() {
		timer.setTimer(this, 24, 5*1000, false);
		
		sCIHBrain.operationCallback.sendTTS2("[:-|] I unterstood: ", sCISTT.operationCallback.getSpokenText());
	}
	
	/* Entry action for state 'StropSTT'. */
	private void entryAction_main_region_Copy_1_STT_STT_StropSTT() {
		timer.setTimer(this, 25, 5*1000, false);
		
		sCISTT.operationCallback.sendSpeechDetectionOff();
	}
	
	/* Entry action for state 'leave2'. */
	private void entryAction_main_region_leave2() {
		timer.setTimer(this, 26, 10*1000, false);
		
		sCIHBrain.operationCallback.sendTTS("[:-0] Thanks for your attention. I wish you a nice day at the German Open. [:-)]");
	}
	
	/* Entry action for state 'leave3'. */
	private void entryAction_main_region_leave3() {
		sCIMira.operationCallback.sendGoToGWP(getGWPout());
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
	
	/* Exit action for state 'Hello'. */
	private void exitAction_main_region_Hello() {
		timer.unsetTimer(this, 0);
	}
	
	/* Exit action for state 'DetectionsOn'. */
	private void exitAction_main_region_DetectionsOn() {
		timer.unsetTimer(this, 1);
	}
	
	/* Exit action for state 'TellAnswer'. */
	private void exitAction_main_region_TellAnswer() {
		timer.unsetTimer(this, 2);
	}
	
	/* Exit action for state 'livingroom'. */
	private void exitAction_main_region_DoAction_Instructions_GoTo_goto_GeneralP_livingroom() {
		timer.unsetTimer(this, 3);
	}
	
	/* Exit action for state 'notFound'. */
	private void exitAction_main_region_DoAction_Instructions_GoTo_goto_GeneralP_notFound() {
		timer.unsetTimer(this, 4);
	}
	
	/* Exit action for state 'arrived'. */
	private void exitAction_main_region_DoAction_Instructions_GoTo_goto_GeneralP_arrived() {
		timer.unsetTimer(this, 5);
	}
	
	/* Exit action for state 'notFound'. */
	private void exitAction_main_region_DoAction_Instructions_bring_bring_GeneralP_notFound() {
		timer.unsetTimer(this, 6);
	}
	
	/* Exit action for state 'bringGehtnicht'. */
	private void exitAction_main_region_DoAction_Instructions_bring_bring_GeneralP_bringGehtnicht() {
		timer.unsetTimer(this, 7);
	}
	
	/* Exit action for state 'open'. */
	private void exitAction_main_region_DoAction_Instructions_open() {
		timer.unsetTimer(this, 8);
	}
	
	/* Exit action for state 'StartTracking'. */
	private void exitAction_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking() {
		timer.unsetTimer(this, 9);
	}
	
	/* Exit action for state 'STToff'. */
	private void exitAction_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking_WaitingForStopCommand_STToff() {
		timer.unsetTimer(this, 10);
	}
	
	/* Exit action for state 'STTstart'. */
	private void exitAction_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking_WaitingForStopCommand_STTstart() {
		timer.unsetTimer(this, 11);
	}
	
	/* Exit action for state 'Wave'. */
	private void exitAction_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave() {
		timer.unsetTimer(this, 12);
	}
	
	/* Exit action for state 'UTurn1'. */
	private void exitAction_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_UTurn1() {
		timer.unsetTimer(this, 13);
	}
	
	/* Exit action for state 'Turn'. */
	private void exitAction_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_Turn() {
		timer.unsetTimer(this, 14);
	}
	
	/* Exit action for state 'ILostYou'. */
	private void exitAction_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_ILostYou() {
		timer.unsetTimer(this, 15);
	}
	
	/* Exit action for state 'UTurn2'. */
	private void exitAction_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_UTurn2() {
		timer.unsetTimer(this, 16);
	}
	
	/* Exit action for state 'Detection'. */
	private void exitAction_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_Detection() {
		timer.unsetTimer(this, 17);
	}
	
	/* Exit action for state 'Detect'. */
	private void exitAction_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Detect() {
		timer.unsetTimer(this, 18);
	}
	
	/* Exit action for state 'unknown'. */
	private void exitAction_main_region_DoAction_Instructions_unknown() {
		timer.unsetTimer(this, 19);
	}
	
	/* Exit action for state 'Copy_1_crowd'. */
	private void exitAction_main_region_DoAction_Instructions_Copy_1_crowd() {
		timer.unsetTimer(this, 20);
	}
	
	/* Exit action for state 'TellIncomprehensible'. */
	private void exitAction_main_region_TellIncomprehensible() {
		timer.unsetTimer(this, 21);
	}
	
	/* Exit action for state 'NextQuestion'. */
	private void exitAction_main_region_NextQuestion() {
		timer.unsetTimer(this, 22);
	}
	
	/* Exit action for state 'StartSTT'. */
	private void exitAction_main_region_Copy_1_STT_STT_StartSTT() {
		timer.unsetTimer(this, 23);
	}
	
	/* Exit action for state 'TellSpokenText'. */
	private void exitAction_main_region_Copy_1_STT_STT_TellSpokenText() {
		timer.unsetTimer(this, 24);
	}
	
	/* Exit action for state 'StropSTT'. */
	private void exitAction_main_region_Copy_1_STT_STT_StropSTT() {
		timer.unsetTimer(this, 25);
	}
	
	/* Exit action for state 'leave2'. */
	private void exitAction_main_region_leave2() {
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
	
	/* 'default' enter sequence for state TellAnswer */
	private void enterSequence_main_region_TellAnswer_default() {
		entryAction_main_region_TellAnswer();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_TellAnswer;
	}
	
	/* 'default' enter sequence for state DoAction */
	private void enterSequence_main_region_DoAction_default() {
		entryAction_main_region_DoAction();
		enterSequence_main_region_DoAction_Instructions_default();
	}
	
	/* 'default' enter sequence for state GoTo */
	private void enterSequence_main_region_DoAction_Instructions_GoTo_default() {
		entryAction_main_region_DoAction_Instructions_GoTo();
		enterSequence_main_region_DoAction_Instructions_GoTo_goto_GeneralP_default();
	}
	
	/* 'default' enter sequence for state livingroom */
	private void enterSequence_main_region_DoAction_Instructions_GoTo_goto_GeneralP_livingroom_default() {
		entryAction_main_region_DoAction_Instructions_GoTo_goto_GeneralP_livingroom();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_DoAction_Instructions_GoTo_goto_GeneralP_livingroom;
	}
	
	/* 'default' enter sequence for state notFound */
	private void enterSequence_main_region_DoAction_Instructions_GoTo_goto_GeneralP_notFound_default() {
		entryAction_main_region_DoAction_Instructions_GoTo_goto_GeneralP_notFound();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_DoAction_Instructions_GoTo_goto_GeneralP_notFound;
	}
	
	/* 'default' enter sequence for state arrived */
	private void enterSequence_main_region_DoAction_Instructions_GoTo_goto_GeneralP_arrived_default() {
		entryAction_main_region_DoAction_Instructions_GoTo_goto_GeneralP_arrived();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_DoAction_Instructions_GoTo_goto_GeneralP_arrived;
	}
	
	/* 'default' enter sequence for state backToTheOperator */
	private void enterSequence_main_region_DoAction_Instructions_GoTo_goto_GeneralP_backToTheOperator_default() {
		entryAction_main_region_DoAction_Instructions_GoTo_goto_GeneralP_backToTheOperator();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_DoAction_Instructions_GoTo_goto_GeneralP_backToTheOperator;
	}
	
	/* 'default' enter sequence for state surrounding */
	private void enterSequence_main_region_DoAction_Instructions_surrounding_default() {
		nextStateIndex = 0;
		stateVector[0] = State.main_region_DoAction_Instructions_surrounding;
	}
	
	/* 'default' enter sequence for state bring */
	private void enterSequence_main_region_DoAction_Instructions_bring_default() {
		enterSequence_main_region_DoAction_Instructions_bring_bring_GeneralP_default();
	}
	
	/* 'default' enter sequence for state livingroom */
	private void enterSequence_main_region_DoAction_Instructions_bring_bring_GeneralP_livingroom_default() {
		entryAction_main_region_DoAction_Instructions_bring_bring_GeneralP_livingroom();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_DoAction_Instructions_bring_bring_GeneralP_livingroom;
	}
	
	/* 'default' enter sequence for state notFound */
	private void enterSequence_main_region_DoAction_Instructions_bring_bring_GeneralP_notFound_default() {
		entryAction_main_region_DoAction_Instructions_bring_bring_GeneralP_notFound();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_DoAction_Instructions_bring_bring_GeneralP_notFound;
	}
	
	/* 'default' enter sequence for state arrived */
	private void enterSequence_main_region_DoAction_Instructions_bring_bring_GeneralP_arrived_default() {
		entryAction_main_region_DoAction_Instructions_bring_bring_GeneralP_arrived();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_DoAction_Instructions_bring_bring_GeneralP_arrived;
	}
	
	/* 'default' enter sequence for state backToTheOperator */
	private void enterSequence_main_region_DoAction_Instructions_bring_bring_GeneralP_backToTheOperator_default() {
		entryAction_main_region_DoAction_Instructions_bring_bring_GeneralP_backToTheOperator();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_DoAction_Instructions_bring_bring_GeneralP_backToTheOperator;
	}
	
	/* 'default' enter sequence for state bringGehtnicht */
	private void enterSequence_main_region_DoAction_Instructions_bring_bring_GeneralP_bringGehtnicht_default() {
		entryAction_main_region_DoAction_Instructions_bring_bring_GeneralP_bringGehtnicht();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_DoAction_Instructions_bring_bring_GeneralP_bringGehtnicht;
	}
	
	/* 'default' enter sequence for state stattdessen goto */
	private void enterSequence_main_region_DoAction_Instructions_bring_bring_GeneralP_stattdessen_goto_default() {
		entryAction_main_region_DoAction_Instructions_bring_bring_GeneralP_stattdessen_goto();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_DoAction_Instructions_bring_bring_GeneralP_stattdessen_goto;
	}
	
	/* 'default' enter sequence for state open */
	private void enterSequence_main_region_DoAction_Instructions_open_default() {
		entryAction_main_region_DoAction_Instructions_open();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_DoAction_Instructions_open;
	}
	
	/* 'default' enter sequence for state followme */
	private void enterSequence_main_region_DoAction_Instructions_followme_default() {
		entryAction_main_region_DoAction_Instructions_followme();
		enterSequence_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_default();
	}
	
	/* 'default' enter sequence for state StartTracking */
	private void enterSequence_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking_default() {
		entryAction_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking();
		enterSequence_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking_WaitingForStopCommand_default();
	}
	
	/* 'default' enter sequence for state STToff */
	private void enterSequence_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking_WaitingForStopCommand_STToff_default() {
		entryAction_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking_WaitingForStopCommand_STToff();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking_WaitingForStopCommand_STToff;
	}
	
	/* 'default' enter sequence for state STTstart */
	private void enterSequence_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking_WaitingForStopCommand_STTstart_default() {
		entryAction_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking_WaitingForStopCommand_STTstart();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking_WaitingForStopCommand_STTstart;
	}
	
	/* 'default' enter sequence for state Wave */
	private void enterSequence_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_default() {
		entryAction_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave();
		enterSequence_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_default();
	}
	
	/* 'default' enter sequence for state UTurn1 */
	private void enterSequence_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_UTurn1_default() {
		entryAction_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_UTurn1();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_UTurn1;
	}
	
	/* 'default' enter sequence for state WaveFound */
	private void enterSequence_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_WaveFound_default() {
		entryAction_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_WaveFound();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_WaveFound;
	}
	
	/* 'default' enter sequence for state Turn */
	private void enterSequence_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_Turn_default() {
		entryAction_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_Turn();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_Turn;
	}
	
	/* 'default' enter sequence for state DetectionOn */
	private void enterSequence_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_DetectionOn_default() {
		entryAction_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_DetectionOn();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_DetectionOn;
	}
	
	/* 'default' enter sequence for state PersonFound */
	private void enterSequence_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_PersonFound_default() {
		entryAction_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_PersonFound();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_PersonFound;
	}
	
	/* 'default' enter sequence for state ILostYou */
	private void enterSequence_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_ILostYou_default() {
		entryAction_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_ILostYou();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_ILostYou;
	}
	
	/* 'default' enter sequence for state UTurn2 */
	private void enterSequence_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_UTurn2_default() {
		entryAction_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_UTurn2();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_UTurn2;
	}
	
	/* 'default' enter sequence for state Detection */
	private void enterSequence_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_Detection_default() {
		entryAction_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_Detection();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_Detection;
	}
	
	/* 'default' enter sequence for state NotFound */
	private void enterSequence_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_NotFound_default() {
		entryAction_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_NotFound();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_NotFound;
	}
	
	/* 'default' enter sequence for state Detect */
	private void enterSequence_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Detect_default() {
		entryAction_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Detect();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Detect;
	}
	
	/* 'default' enter sequence for state no */
	private void enterSequence_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_no_default() {
		entryAction_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_no();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_no;
	}
	
	/* 'default' enter sequence for state HowCanIHelpYou */
	private void enterSequence_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_HowCanIHelpYou_default() {
		entryAction_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_HowCanIHelpYou();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_HowCanIHelpYou;
	}
	
	/* 'default' enter sequence for state Wir brauchen das gerade nicht */
	private void enterSequence_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wir_brauchen_das_gerade_nicht_default() {
		nextStateIndex = 0;
		stateVector[0] = State.main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wir_brauchen_das_gerade_nicht;
	}
	
	/* 'default' enter sequence for state unknown */
	private void enterSequence_main_region_DoAction_Instructions_unknown_default() {
		entryAction_main_region_DoAction_Instructions_unknown();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_DoAction_Instructions_unknown;
	}
	
	/* 'default' enter sequence for state Copy_1_crowd */
	private void enterSequence_main_region_DoAction_Instructions_Copy_1_crowd_default() {
		entryAction_main_region_DoAction_Instructions_Copy_1_crowd();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_DoAction_Instructions_Copy_1_crowd;
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
	
	/* 'default' enter sequence for state Copy_1_STT */
	private void enterSequence_main_region_Copy_1_STT_default() {
		enterSequence_main_region_Copy_1_STT_STT_default();
	}
	
	/* 'default' enter sequence for state StartSTT */
	private void enterSequence_main_region_Copy_1_STT_STT_StartSTT_default() {
		entryAction_main_region_Copy_1_STT_STT_StartSTT();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_Copy_1_STT_STT_StartSTT;
	}
	
	/* 'default' enter sequence for state TellSpokenText */
	private void enterSequence_main_region_Copy_1_STT_STT_TellSpokenText_default() {
		entryAction_main_region_Copy_1_STT_STT_TellSpokenText();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_Copy_1_STT_STT_TellSpokenText;
	}
	
	/* 'default' enter sequence for state StropSTT */
	private void enterSequence_main_region_Copy_1_STT_STT_StropSTT_default() {
		entryAction_main_region_Copy_1_STT_STT_StropSTT();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_Copy_1_STT_STT_StropSTT;
	}
	
	/* 'default' enter sequence for state leave2 */
	private void enterSequence_main_region_leave2_default() {
		entryAction_main_region_leave2();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_leave2;
	}
	
	/* 'default' enter sequence for state leave3 */
	private void enterSequence_main_region_leave3_default() {
		entryAction_main_region_leave3();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_leave3;
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
	
	/* 'default' enter sequence for region Instructions */
	private void enterSequence_main_region_DoAction_Instructions_default() {
		react_main_region_DoAction_Instructions__entry_Default();
	}
	
	/* 'default' enter sequence for region goto GeneralP */
	private void enterSequence_main_region_DoAction_Instructions_GoTo_goto_GeneralP_default() {
		react_main_region_DoAction_Instructions_GoTo_goto_GeneralP__entry_Default();
	}
	
	/* 'default' enter sequence for region bring GeneralP */
	private void enterSequence_main_region_DoAction_Instructions_bring_bring_GeneralP_default() {
		react_main_region_DoAction_Instructions_bring_bring_GeneralP__entry_Default();
	}
	
	/* 'default' enter sequence for region FollowMe in GPSR */
	private void enterSequence_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_default() {
		react_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR__entry_Default();
	}
	
	/* 'default' enter sequence for region WaitingForStopCommand */
	private void enterSequence_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking_WaitingForStopCommand_default() {
		react_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking_WaitingForStopCommand__entry_Default();
	}
	
	/* 'default' enter sequence for region WavingToFindPerson */
	private void enterSequence_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_default() {
		react_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson__entry_Default();
	}
	
	/* 'default' enter sequence for region STT */
	private void enterSequence_main_region_Copy_1_STT_STT_default() {
		react_main_region_Copy_1_STT_STT__entry_Default();
	}
	
	/* 'default' enter sequence for region Leonie Bupered Or Emergency Stop */
	private void enterSequence_Leonie_Bupered_Or_Emergency_Stop_default() {
		react_Leonie_Bupered_Or_Emergency_Stop__entry_Default();
	}
	
	/* Default exit sequence for state Hello */
	private void exitSequence_main_region_Hello() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
		
		exitAction_main_region_Hello();
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
		
		exitAction_main_region_DetectionsOn();
	}
	
	/* Default exit sequence for state Init */
	private void exitSequence_main_region_Init() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state TellAnswer */
	private void exitSequence_main_region_TellAnswer() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
		
		exitAction_main_region_TellAnswer();
	}
	
	/* Default exit sequence for state DoAction */
	private void exitSequence_main_region_DoAction() {
		exitSequence_main_region_DoAction_Instructions();
	}
	
	/* Default exit sequence for state GoTo */
	private void exitSequence_main_region_DoAction_Instructions_GoTo() {
		exitSequence_main_region_DoAction_Instructions_GoTo_goto_GeneralP();
	}
	
	/* Default exit sequence for state livingroom */
	private void exitSequence_main_region_DoAction_Instructions_GoTo_goto_GeneralP_livingroom() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
		
		exitAction_main_region_DoAction_Instructions_GoTo_goto_GeneralP_livingroom();
	}
	
	/* Default exit sequence for state notFound */
	private void exitSequence_main_region_DoAction_Instructions_GoTo_goto_GeneralP_notFound() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
		
		exitAction_main_region_DoAction_Instructions_GoTo_goto_GeneralP_notFound();
	}
	
	/* Default exit sequence for state arrived */
	private void exitSequence_main_region_DoAction_Instructions_GoTo_goto_GeneralP_arrived() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
		
		exitAction_main_region_DoAction_Instructions_GoTo_goto_GeneralP_arrived();
	}
	
	/* Default exit sequence for state backToTheOperator */
	private void exitSequence_main_region_DoAction_Instructions_GoTo_goto_GeneralP_backToTheOperator() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state surrounding */
	private void exitSequence_main_region_DoAction_Instructions_surrounding() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state bring */
	private void exitSequence_main_region_DoAction_Instructions_bring() {
		exitSequence_main_region_DoAction_Instructions_bring_bring_GeneralP();
	}
	
	/* Default exit sequence for state livingroom */
	private void exitSequence_main_region_DoAction_Instructions_bring_bring_GeneralP_livingroom() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state notFound */
	private void exitSequence_main_region_DoAction_Instructions_bring_bring_GeneralP_notFound() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
		
		exitAction_main_region_DoAction_Instructions_bring_bring_GeneralP_notFound();
	}
	
	/* Default exit sequence for state arrived */
	private void exitSequence_main_region_DoAction_Instructions_bring_bring_GeneralP_arrived() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state backToTheOperator */
	private void exitSequence_main_region_DoAction_Instructions_bring_bring_GeneralP_backToTheOperator() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state bringGehtnicht */
	private void exitSequence_main_region_DoAction_Instructions_bring_bring_GeneralP_bringGehtnicht() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
		
		exitAction_main_region_DoAction_Instructions_bring_bring_GeneralP_bringGehtnicht();
	}
	
	/* Default exit sequence for state stattdessen goto */
	private void exitSequence_main_region_DoAction_Instructions_bring_bring_GeneralP_stattdessen_goto() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state open */
	private void exitSequence_main_region_DoAction_Instructions_open() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
		
		exitAction_main_region_DoAction_Instructions_open();
	}
	
	/* Default exit sequence for state followme */
	private void exitSequence_main_region_DoAction_Instructions_followme() {
		exitSequence_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR();
	}
	
	/* Default exit sequence for state StartTracking */
	private void exitSequence_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking() {
		exitSequence_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking_WaitingForStopCommand();
		exitAction_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking();
	}
	
	/* Default exit sequence for state STToff */
	private void exitSequence_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking_WaitingForStopCommand_STToff() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
		
		exitAction_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking_WaitingForStopCommand_STToff();
	}
	
	/* Default exit sequence for state STTstart */
	private void exitSequence_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking_WaitingForStopCommand_STTstart() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
		
		exitAction_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking_WaitingForStopCommand_STTstart();
	}
	
	/* Default exit sequence for state Wave */
	private void exitSequence_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave() {
		exitSequence_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson();
		exitAction_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave();
	}
	
	/* Default exit sequence for state UTurn1 */
	private void exitSequence_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_UTurn1() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
		
		exitAction_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_UTurn1();
	}
	
	/* Default exit sequence for state WaveFound */
	private void exitSequence_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_WaveFound() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state Turn */
	private void exitSequence_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_Turn() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
		
		exitAction_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_Turn();
	}
	
	/* Default exit sequence for state DetectionOn */
	private void exitSequence_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_DetectionOn() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state PersonFound */
	private void exitSequence_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_PersonFound() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state ILostYou */
	private void exitSequence_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_ILostYou() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
		
		exitAction_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_ILostYou();
	}
	
	/* Default exit sequence for state UTurn2 */
	private void exitSequence_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_UTurn2() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
		
		exitAction_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_UTurn2();
	}
	
	/* Default exit sequence for state Detection */
	private void exitSequence_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_Detection() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
		
		exitAction_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_Detection();
	}
	
	/* Default exit sequence for state NotFound */
	private void exitSequence_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_NotFound() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state Detect */
	private void exitSequence_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Detect() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
		
		exitAction_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Detect();
	}
	
	/* Default exit sequence for state no */
	private void exitSequence_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_no() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state HowCanIHelpYou */
	private void exitSequence_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_HowCanIHelpYou() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state Wir brauchen das gerade nicht */
	private void exitSequence_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wir_brauchen_das_gerade_nicht() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state unknown */
	private void exitSequence_main_region_DoAction_Instructions_unknown() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
		
		exitAction_main_region_DoAction_Instructions_unknown();
	}
	
	/* Default exit sequence for state Copy_1_crowd */
	private void exitSequence_main_region_DoAction_Instructions_Copy_1_crowd() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
		
		exitAction_main_region_DoAction_Instructions_Copy_1_crowd();
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
		
		exitAction_main_region_TellIncomprehensible();
	}
	
	/* Default exit sequence for state NextQuestion */
	private void exitSequence_main_region_NextQuestion() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
		
		exitAction_main_region_NextQuestion();
	}
	
	/* Default exit sequence for state Copy_1_STT */
	private void exitSequence_main_region_Copy_1_STT() {
		exitSequence_main_region_Copy_1_STT_STT();
	}
	
	/* Default exit sequence for state StartSTT */
	private void exitSequence_main_region_Copy_1_STT_STT_StartSTT() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
		
		exitAction_main_region_Copy_1_STT_STT_StartSTT();
	}
	
	/* Default exit sequence for state TellSpokenText */
	private void exitSequence_main_region_Copy_1_STT_STT_TellSpokenText() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
		
		exitAction_main_region_Copy_1_STT_STT_TellSpokenText();
	}
	
	/* Default exit sequence for state StropSTT */
	private void exitSequence_main_region_Copy_1_STT_STT_StropSTT() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
		
		exitAction_main_region_Copy_1_STT_STT_StropSTT();
	}
	
	/* Default exit sequence for state leave2 */
	private void exitSequence_main_region_leave2() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
		
		exitAction_main_region_leave2();
	}
	
	/* Default exit sequence for state leave3 */
	private void exitSequence_main_region_leave3() {
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
		case main_region_TellAnswer:
			exitSequence_main_region_TellAnswer();
			break;
		case main_region_DoAction_Instructions_GoTo_goto_GeneralP_livingroom:
			exitSequence_main_region_DoAction_Instructions_GoTo_goto_GeneralP_livingroom();
			break;
		case main_region_DoAction_Instructions_GoTo_goto_GeneralP_notFound:
			exitSequence_main_region_DoAction_Instructions_GoTo_goto_GeneralP_notFound();
			break;
		case main_region_DoAction_Instructions_GoTo_goto_GeneralP_arrived:
			exitSequence_main_region_DoAction_Instructions_GoTo_goto_GeneralP_arrived();
			break;
		case main_region_DoAction_Instructions_GoTo_goto_GeneralP_backToTheOperator:
			exitSequence_main_region_DoAction_Instructions_GoTo_goto_GeneralP_backToTheOperator();
			break;
		case main_region_DoAction_Instructions_surrounding:
			exitSequence_main_region_DoAction_Instructions_surrounding();
			break;
		case main_region_DoAction_Instructions_bring_bring_GeneralP_livingroom:
			exitSequence_main_region_DoAction_Instructions_bring_bring_GeneralP_livingroom();
			break;
		case main_region_DoAction_Instructions_bring_bring_GeneralP_notFound:
			exitSequence_main_region_DoAction_Instructions_bring_bring_GeneralP_notFound();
			break;
		case main_region_DoAction_Instructions_bring_bring_GeneralP_arrived:
			exitSequence_main_region_DoAction_Instructions_bring_bring_GeneralP_arrived();
			break;
		case main_region_DoAction_Instructions_bring_bring_GeneralP_backToTheOperator:
			exitSequence_main_region_DoAction_Instructions_bring_bring_GeneralP_backToTheOperator();
			break;
		case main_region_DoAction_Instructions_bring_bring_GeneralP_bringGehtnicht:
			exitSequence_main_region_DoAction_Instructions_bring_bring_GeneralP_bringGehtnicht();
			break;
		case main_region_DoAction_Instructions_bring_bring_GeneralP_stattdessen_goto:
			exitSequence_main_region_DoAction_Instructions_bring_bring_GeneralP_stattdessen_goto();
			break;
		case main_region_DoAction_Instructions_open:
			exitSequence_main_region_DoAction_Instructions_open();
			break;
		case main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking_WaitingForStopCommand_STToff:
			exitSequence_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking_WaitingForStopCommand_STToff();
			exitAction_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking();
			break;
		case main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking_WaitingForStopCommand_STTstart:
			exitSequence_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking_WaitingForStopCommand_STTstart();
			exitAction_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking();
			break;
		case main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_UTurn1:
			exitSequence_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_UTurn1();
			exitAction_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave();
			break;
		case main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_WaveFound:
			exitSequence_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_WaveFound();
			exitAction_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave();
			break;
		case main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_Turn:
			exitSequence_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_Turn();
			exitAction_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave();
			break;
		case main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_DetectionOn:
			exitSequence_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_DetectionOn();
			exitAction_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave();
			break;
		case main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_PersonFound:
			exitSequence_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_PersonFound();
			exitAction_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave();
			break;
		case main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_ILostYou:
			exitSequence_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_ILostYou();
			exitAction_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave();
			break;
		case main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_UTurn2:
			exitSequence_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_UTurn2();
			exitAction_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave();
			break;
		case main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_Detection:
			exitSequence_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_Detection();
			exitAction_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave();
			break;
		case main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_NotFound:
			exitSequence_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_NotFound();
			exitAction_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave();
			break;
		case main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Detect:
			exitSequence_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Detect();
			break;
		case main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_no:
			exitSequence_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_no();
			break;
		case main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_HowCanIHelpYou:
			exitSequence_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_HowCanIHelpYou();
			break;
		case main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wir_brauchen_das_gerade_nicht:
			exitSequence_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wir_brauchen_das_gerade_nicht();
			break;
		case main_region_DoAction_Instructions_unknown:
			exitSequence_main_region_DoAction_Instructions_unknown();
			break;
		case main_region_DoAction_Instructions_Copy_1_crowd:
			exitSequence_main_region_DoAction_Instructions_Copy_1_crowd();
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
		case main_region_Copy_1_STT_STT_StartSTT:
			exitSequence_main_region_Copy_1_STT_STT_StartSTT();
			break;
		case main_region_Copy_1_STT_STT_TellSpokenText:
			exitSequence_main_region_Copy_1_STT_STT_TellSpokenText();
			break;
		case main_region_Copy_1_STT_STT_StropSTT:
			exitSequence_main_region_Copy_1_STT_STT_StropSTT();
			break;
		case main_region_leave2:
			exitSequence_main_region_leave2();
			break;
		case main_region_leave3:
			exitSequence_main_region_leave3();
			break;
		default:
			break;
		}
	}
	
	/* Default exit sequence for region Instructions */
	private void exitSequence_main_region_DoAction_Instructions() {
		switch (stateVector[0]) {
		case main_region_DoAction_Instructions_GoTo_goto_GeneralP_livingroom:
			exitSequence_main_region_DoAction_Instructions_GoTo_goto_GeneralP_livingroom();
			break;
		case main_region_DoAction_Instructions_GoTo_goto_GeneralP_notFound:
			exitSequence_main_region_DoAction_Instructions_GoTo_goto_GeneralP_notFound();
			break;
		case main_region_DoAction_Instructions_GoTo_goto_GeneralP_arrived:
			exitSequence_main_region_DoAction_Instructions_GoTo_goto_GeneralP_arrived();
			break;
		case main_region_DoAction_Instructions_GoTo_goto_GeneralP_backToTheOperator:
			exitSequence_main_region_DoAction_Instructions_GoTo_goto_GeneralP_backToTheOperator();
			break;
		case main_region_DoAction_Instructions_surrounding:
			exitSequence_main_region_DoAction_Instructions_surrounding();
			break;
		case main_region_DoAction_Instructions_bring_bring_GeneralP_livingroom:
			exitSequence_main_region_DoAction_Instructions_bring_bring_GeneralP_livingroom();
			break;
		case main_region_DoAction_Instructions_bring_bring_GeneralP_notFound:
			exitSequence_main_region_DoAction_Instructions_bring_bring_GeneralP_notFound();
			break;
		case main_region_DoAction_Instructions_bring_bring_GeneralP_arrived:
			exitSequence_main_region_DoAction_Instructions_bring_bring_GeneralP_arrived();
			break;
		case main_region_DoAction_Instructions_bring_bring_GeneralP_backToTheOperator:
			exitSequence_main_region_DoAction_Instructions_bring_bring_GeneralP_backToTheOperator();
			break;
		case main_region_DoAction_Instructions_bring_bring_GeneralP_bringGehtnicht:
			exitSequence_main_region_DoAction_Instructions_bring_bring_GeneralP_bringGehtnicht();
			break;
		case main_region_DoAction_Instructions_bring_bring_GeneralP_stattdessen_goto:
			exitSequence_main_region_DoAction_Instructions_bring_bring_GeneralP_stattdessen_goto();
			break;
		case main_region_DoAction_Instructions_open:
			exitSequence_main_region_DoAction_Instructions_open();
			break;
		case main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking_WaitingForStopCommand_STToff:
			exitSequence_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking_WaitingForStopCommand_STToff();
			exitAction_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking();
			break;
		case main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking_WaitingForStopCommand_STTstart:
			exitSequence_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking_WaitingForStopCommand_STTstart();
			exitAction_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking();
			break;
		case main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_UTurn1:
			exitSequence_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_UTurn1();
			exitAction_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave();
			break;
		case main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_WaveFound:
			exitSequence_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_WaveFound();
			exitAction_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave();
			break;
		case main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_Turn:
			exitSequence_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_Turn();
			exitAction_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave();
			break;
		case main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_DetectionOn:
			exitSequence_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_DetectionOn();
			exitAction_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave();
			break;
		case main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_PersonFound:
			exitSequence_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_PersonFound();
			exitAction_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave();
			break;
		case main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_ILostYou:
			exitSequence_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_ILostYou();
			exitAction_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave();
			break;
		case main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_UTurn2:
			exitSequence_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_UTurn2();
			exitAction_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave();
			break;
		case main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_Detection:
			exitSequence_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_Detection();
			exitAction_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave();
			break;
		case main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_NotFound:
			exitSequence_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_NotFound();
			exitAction_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave();
			break;
		case main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Detect:
			exitSequence_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Detect();
			break;
		case main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_no:
			exitSequence_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_no();
			break;
		case main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_HowCanIHelpYou:
			exitSequence_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_HowCanIHelpYou();
			break;
		case main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wir_brauchen_das_gerade_nicht:
			exitSequence_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wir_brauchen_das_gerade_nicht();
			break;
		case main_region_DoAction_Instructions_unknown:
			exitSequence_main_region_DoAction_Instructions_unknown();
			break;
		case main_region_DoAction_Instructions_Copy_1_crowd:
			exitSequence_main_region_DoAction_Instructions_Copy_1_crowd();
			break;
		default:
			break;
		}
	}
	
	/* Default exit sequence for region goto GeneralP */
	private void exitSequence_main_region_DoAction_Instructions_GoTo_goto_GeneralP() {
		switch (stateVector[0]) {
		case main_region_DoAction_Instructions_GoTo_goto_GeneralP_livingroom:
			exitSequence_main_region_DoAction_Instructions_GoTo_goto_GeneralP_livingroom();
			break;
		case main_region_DoAction_Instructions_GoTo_goto_GeneralP_notFound:
			exitSequence_main_region_DoAction_Instructions_GoTo_goto_GeneralP_notFound();
			break;
		case main_region_DoAction_Instructions_GoTo_goto_GeneralP_arrived:
			exitSequence_main_region_DoAction_Instructions_GoTo_goto_GeneralP_arrived();
			break;
		case main_region_DoAction_Instructions_GoTo_goto_GeneralP_backToTheOperator:
			exitSequence_main_region_DoAction_Instructions_GoTo_goto_GeneralP_backToTheOperator();
			break;
		default:
			break;
		}
	}
	
	/* Default exit sequence for region bring GeneralP */
	private void exitSequence_main_region_DoAction_Instructions_bring_bring_GeneralP() {
		switch (stateVector[0]) {
		case main_region_DoAction_Instructions_bring_bring_GeneralP_livingroom:
			exitSequence_main_region_DoAction_Instructions_bring_bring_GeneralP_livingroom();
			break;
		case main_region_DoAction_Instructions_bring_bring_GeneralP_notFound:
			exitSequence_main_region_DoAction_Instructions_bring_bring_GeneralP_notFound();
			break;
		case main_region_DoAction_Instructions_bring_bring_GeneralP_arrived:
			exitSequence_main_region_DoAction_Instructions_bring_bring_GeneralP_arrived();
			break;
		case main_region_DoAction_Instructions_bring_bring_GeneralP_backToTheOperator:
			exitSequence_main_region_DoAction_Instructions_bring_bring_GeneralP_backToTheOperator();
			break;
		case main_region_DoAction_Instructions_bring_bring_GeneralP_bringGehtnicht:
			exitSequence_main_region_DoAction_Instructions_bring_bring_GeneralP_bringGehtnicht();
			break;
		case main_region_DoAction_Instructions_bring_bring_GeneralP_stattdessen_goto:
			exitSequence_main_region_DoAction_Instructions_bring_bring_GeneralP_stattdessen_goto();
			break;
		default:
			break;
		}
	}
	
	/* Default exit sequence for region FollowMe in GPSR */
	private void exitSequence_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR() {
		switch (stateVector[0]) {
		case main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking_WaitingForStopCommand_STToff:
			exitSequence_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking_WaitingForStopCommand_STToff();
			exitAction_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking();
			break;
		case main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking_WaitingForStopCommand_STTstart:
			exitSequence_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking_WaitingForStopCommand_STTstart();
			exitAction_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking();
			break;
		case main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_UTurn1:
			exitSequence_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_UTurn1();
			exitAction_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave();
			break;
		case main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_WaveFound:
			exitSequence_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_WaveFound();
			exitAction_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave();
			break;
		case main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_Turn:
			exitSequence_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_Turn();
			exitAction_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave();
			break;
		case main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_DetectionOn:
			exitSequence_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_DetectionOn();
			exitAction_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave();
			break;
		case main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_PersonFound:
			exitSequence_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_PersonFound();
			exitAction_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave();
			break;
		case main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_ILostYou:
			exitSequence_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_ILostYou();
			exitAction_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave();
			break;
		case main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_UTurn2:
			exitSequence_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_UTurn2();
			exitAction_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave();
			break;
		case main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_Detection:
			exitSequence_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_Detection();
			exitAction_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave();
			break;
		case main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_NotFound:
			exitSequence_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_NotFound();
			exitAction_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave();
			break;
		case main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Detect:
			exitSequence_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Detect();
			break;
		case main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_no:
			exitSequence_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_no();
			break;
		case main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_HowCanIHelpYou:
			exitSequence_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_HowCanIHelpYou();
			break;
		case main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wir_brauchen_das_gerade_nicht:
			exitSequence_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wir_brauchen_das_gerade_nicht();
			break;
		default:
			break;
		}
	}
	
	/* Default exit sequence for region WaitingForStopCommand */
	private void exitSequence_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking_WaitingForStopCommand() {
		switch (stateVector[0]) {
		case main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking_WaitingForStopCommand_STToff:
			exitSequence_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking_WaitingForStopCommand_STToff();
			break;
		case main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking_WaitingForStopCommand_STTstart:
			exitSequence_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking_WaitingForStopCommand_STTstart();
			break;
		default:
			break;
		}
	}
	
	/* Default exit sequence for region WavingToFindPerson */
	private void exitSequence_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson() {
		switch (stateVector[0]) {
		case main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_UTurn1:
			exitSequence_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_UTurn1();
			break;
		case main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_WaveFound:
			exitSequence_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_WaveFound();
			break;
		case main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_Turn:
			exitSequence_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_Turn();
			break;
		case main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_DetectionOn:
			exitSequence_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_DetectionOn();
			break;
		case main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_PersonFound:
			exitSequence_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_PersonFound();
			break;
		case main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_ILostYou:
			exitSequence_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_ILostYou();
			break;
		case main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_UTurn2:
			exitSequence_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_UTurn2();
			break;
		case main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_Detection:
			exitSequence_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_Detection();
			break;
		case main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_NotFound:
			exitSequence_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_NotFound();
			break;
		default:
			break;
		}
	}
	
	/* Default exit sequence for region STT */
	private void exitSequence_main_region_Copy_1_STT_STT() {
		switch (stateVector[0]) {
		case main_region_Copy_1_STT_STT_StartSTT:
			exitSequence_main_region_Copy_1_STT_STT_StartSTT();
			break;
		case main_region_Copy_1_STT_STT_TellSpokenText:
			exitSequence_main_region_Copy_1_STT_STT_TellSpokenText();
			break;
		case main_region_Copy_1_STT_STT_StropSTT:
			exitSequence_main_region_Copy_1_STT_STT_StropSTT();
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
	private void react_main_region_Hello() {
		if (check_main_region_Hello_tr0_tr0()) {
			effect_main_region_Hello_tr0();
		} else {
			if (check_main_region_Hello_tr1_tr1()) {
				effect_main_region_Hello_tr1();
			}
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
		} else {
			if (check_main_region_DetectionsOn_tr1_tr1()) {
				effect_main_region_DetectionsOn_tr1();
			}
		}
	}
	
	/* The reactions of state Init. */
	private void react_main_region_Init() {
		if (check_main_region_Init_tr0_tr0()) {
			effect_main_region_Init_tr0();
		}
	}
	
	/* The reactions of state TellAnswer. */
	private void react_main_region_TellAnswer() {
		if (check_main_region_TellAnswer_tr0_tr0()) {
			effect_main_region_TellAnswer_tr0();
		} else {
			if (check_main_region_TellAnswer_tr1_tr1()) {
				effect_main_region_TellAnswer_tr1();
			}
		}
	}
	
	/* The reactions of state livingroom. */
	private void react_main_region_DoAction_Instructions_GoTo_goto_GeneralP_livingroom() {
		if (check_main_region_DoAction_Instructions_GoTo_goto_GeneralP_livingroom_tr0_tr0()) {
			effect_main_region_DoAction_Instructions_GoTo_goto_GeneralP_livingroom_tr0();
		} else {
			if (check_main_region_DoAction_Instructions_GoTo_goto_GeneralP_livingroom_tr1_tr1()) {
				effect_main_region_DoAction_Instructions_GoTo_goto_GeneralP_livingroom_tr1();
			}
		}
	}
	
	/* The reactions of state notFound. */
	private void react_main_region_DoAction_Instructions_GoTo_goto_GeneralP_notFound() {
		if (check_main_region_DoAction_Instructions_GoTo_goto_GeneralP_notFound_tr0_tr0()) {
			effect_main_region_DoAction_Instructions_GoTo_goto_GeneralP_notFound_tr0();
		} else {
			if (check_main_region_DoAction_Instructions_GoTo_goto_GeneralP_notFound_tr1_tr1()) {
				effect_main_region_DoAction_Instructions_GoTo_goto_GeneralP_notFound_tr1();
			}
		}
	}
	
	/* The reactions of state arrived. */
	private void react_main_region_DoAction_Instructions_GoTo_goto_GeneralP_arrived() {
		if (check_main_region_DoAction_Instructions_GoTo_goto_GeneralP_arrived_tr0_tr0()) {
			effect_main_region_DoAction_Instructions_GoTo_goto_GeneralP_arrived_tr0();
		} else {
			if (check_main_region_DoAction_Instructions_GoTo_goto_GeneralP_arrived_tr1_tr1()) {
				effect_main_region_DoAction_Instructions_GoTo_goto_GeneralP_arrived_tr1();
			}
		}
	}
	
	/* The reactions of state backToTheOperator. */
	private void react_main_region_DoAction_Instructions_GoTo_goto_GeneralP_backToTheOperator() {
		if (check_main_region_DoAction_Instructions_GoTo_goto_GeneralP_backToTheOperator_tr0_tr0()) {
			effect_main_region_DoAction_Instructions_GoTo_goto_GeneralP_backToTheOperator_tr0();
		}
	}
	
	/* The reactions of state surrounding. */
	private void react_main_region_DoAction_Instructions_surrounding() {
		effect_main_region_DoAction_Instructions_surrounding_tr0();
	}
	
	/* The reactions of state livingroom. */
	private void react_main_region_DoAction_Instructions_bring_bring_GeneralP_livingroom() {
		if (check_main_region_DoAction_Instructions_bring_bring_GeneralP_livingroom_tr0_tr0()) {
			effect_main_region_DoAction_Instructions_bring_bring_GeneralP_livingroom_tr0();
		}
	}
	
	/* The reactions of state notFound. */
	private void react_main_region_DoAction_Instructions_bring_bring_GeneralP_notFound() {
		if (check_main_region_DoAction_Instructions_bring_bring_GeneralP_notFound_tr0_tr0()) {
			effect_main_region_DoAction_Instructions_bring_bring_GeneralP_notFound_tr0();
		} else {
			if (check_main_region_DoAction_Instructions_bring_bring_GeneralP_notFound_tr1_tr1()) {
				effect_main_region_DoAction_Instructions_bring_bring_GeneralP_notFound_tr1();
			}
		}
	}
	
	/* The reactions of state arrived. */
	private void react_main_region_DoAction_Instructions_bring_bring_GeneralP_arrived() {
		if (check_main_region_DoAction_Instructions_bring_bring_GeneralP_arrived_tr0_tr0()) {
			effect_main_region_DoAction_Instructions_bring_bring_GeneralP_arrived_tr0();
		}
	}
	
	/* The reactions of state backToTheOperator. */
	private void react_main_region_DoAction_Instructions_bring_bring_GeneralP_backToTheOperator() {
		if (check_main_region_DoAction_Instructions_bring_bring_GeneralP_backToTheOperator_tr0_tr0()) {
			effect_main_region_DoAction_Instructions_bring_bring_GeneralP_backToTheOperator_tr0();
		}
	}
	
	/* The reactions of state bringGehtnicht. */
	private void react_main_region_DoAction_Instructions_bring_bring_GeneralP_bringGehtnicht() {
		if (check_main_region_DoAction_Instructions_bring_bring_GeneralP_bringGehtnicht_tr0_tr0()) {
			effect_main_region_DoAction_Instructions_bring_bring_GeneralP_bringGehtnicht_tr0();
		} else {
			if (check_main_region_DoAction_Instructions_bring_bring_GeneralP_bringGehtnicht_tr1_tr1()) {
				effect_main_region_DoAction_Instructions_bring_bring_GeneralP_bringGehtnicht_tr1();
			}
		}
	}
	
	/* The reactions of state stattdessen goto. */
	private void react_main_region_DoAction_Instructions_bring_bring_GeneralP_stattdessen_goto() {
		if (check_main_region_DoAction_Instructions_bring_bring_GeneralP_stattdessen_goto_tr0_tr0()) {
			effect_main_region_DoAction_Instructions_bring_bring_GeneralP_stattdessen_goto_tr0();
		}
	}
	
	/* The reactions of state open. */
	private void react_main_region_DoAction_Instructions_open() {
		if (check_main_region_DoAction_Instructions_open_tr0_tr0()) {
			effect_main_region_DoAction_Instructions_open_tr0();
		} else {
			if (check_main_region_DoAction_Instructions_open_tr1_tr1()) {
				effect_main_region_DoAction_Instructions_open_tr1();
			}
		}
	}
	
	/* The reactions of state STToff. */
	private void react_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking_WaitingForStopCommand_STToff() {
		if (check_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking_tr0_tr0()) {
			effect_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking_tr0();
		} else {
			if (check_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking_tr2_tr2()) {
				effect_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking_tr2();
			} else {
				if (check_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking_WaitingForStopCommand_STToff_tr0_tr0()) {
					effect_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking_WaitingForStopCommand_STToff_tr0();
				} else {
					if (check_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking_WaitingForStopCommand_STToff_tr1_tr1()) {
						effect_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking_WaitingForStopCommand_STToff_tr1();
					}
				}
			}
		}
	}
	
	/* The reactions of state STTstart. */
	private void react_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking_WaitingForStopCommand_STTstart() {
		if (check_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking_tr0_tr0()) {
			effect_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking_tr0();
		} else {
			if (check_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking_tr2_tr2()) {
				effect_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking_tr2();
			} else {
				if (check_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking_WaitingForStopCommand_STTstart_tr0_tr0()) {
					effect_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking_WaitingForStopCommand_STTstart_tr0();
				} else {
					if (check_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking_WaitingForStopCommand_STTstart_tr1_tr1()) {
						effect_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking_WaitingForStopCommand_STTstart_tr1();
					}
				}
			}
		}
	}
	
	/* The reactions of state UTurn1. */
	private void react_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_UTurn1() {
		if (check_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_tr1_tr1()) {
			effect_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_tr1();
		} else {
			if (check_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_UTurn1_tr0_tr0()) {
				effect_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_UTurn1_tr0();
			}
		}
	}
	
	/* The reactions of state WaveFound. */
	private void react_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_WaveFound() {
		if (check_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_tr1_tr1()) {
			effect_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_tr1();
		} else {
			if (check_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_WaveFound_tr0_tr0()) {
				effect_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_WaveFound_tr0();
			}
		}
	}
	
	/* The reactions of state Turn. */
	private void react_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_Turn() {
		if (check_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_tr1_tr1()) {
			effect_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_tr1();
		} else {
			if (check_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_Turn_tr0_tr0()) {
				effect_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_Turn_tr0();
			} else {
				if (check_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_Turn_tr1_tr1()) {
					effect_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_Turn_tr1();
				}
			}
		}
	}
	
	/* The reactions of state DetectionOn. */
	private void react_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_DetectionOn() {
		if (check_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_tr1_tr1()) {
			effect_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_tr1();
		} else {
			effect_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_DetectionOn_tr0();
		}
	}
	
	/* The reactions of state PersonFound. */
	private void react_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_PersonFound() {
		if (check_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_tr1_tr1()) {
			effect_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_tr1();
		} else {
			effect_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_PersonFound_tr0();
		}
	}
	
	/* The reactions of state ILostYou. */
	private void react_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_ILostYou() {
		if (check_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_tr1_tr1()) {
			effect_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_tr1();
		} else {
			if (check_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_ILostYou_tr0_tr0()) {
				effect_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_ILostYou_tr0();
			} else {
				if (check_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_ILostYou_tr1_tr1()) {
					effect_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_ILostYou_tr1();
				}
			}
		}
	}
	
	/* The reactions of state UTurn2. */
	private void react_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_UTurn2() {
		if (check_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_tr1_tr1()) {
			effect_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_tr1();
		} else {
			if (check_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_UTurn2_tr0_tr0()) {
				effect_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_UTurn2_tr0();
			}
		}
	}
	
	/* The reactions of state Detection. */
	private void react_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_Detection() {
		if (check_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_tr1_tr1()) {
			effect_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_tr1();
		} else {
			if (check_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_Detection_tr0_tr0()) {
				effect_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_Detection_tr0();
			} else {
				if (check_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_Detection_tr1_tr1()) {
					effect_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_Detection_tr1();
				} else {
					if (check_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_Detection_tr2_tr2()) {
						effect_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_Detection_tr2();
					}
				}
			}
		}
	}
	
	/* The reactions of state NotFound. */
	private void react_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_NotFound() {
		if (check_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_tr1_tr1()) {
			effect_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_tr1();
		} else {
			effect_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_NotFound_tr0();
		}
	}
	
	/* The reactions of state Detect. */
	private void react_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Detect() {
		if (check_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Detect_tr0_tr0()) {
			effect_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Detect_tr0();
		} else {
			if (check_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Detect_tr1_tr1()) {
				effect_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Detect_tr1();
			}
		}
	}
	
	/* The reactions of state no. */
	private void react_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_no() {
		effect_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_no_tr0();
	}
	
	/* The reactions of state HowCanIHelpYou. */
	private void react_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_HowCanIHelpYou() {
		if (check_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_HowCanIHelpYou_tr0_tr0()) {
			effect_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_HowCanIHelpYou_tr0();
		}
	}
	
	/* The reactions of state Wir brauchen das gerade nicht. */
	private void react_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wir_brauchen_das_gerade_nicht() {
		if (check_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wir_brauchen_das_gerade_nicht_tr0_tr0()) {
			effect_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wir_brauchen_das_gerade_nicht_tr0();
		}
	}
	
	/* The reactions of state unknown. */
	private void react_main_region_DoAction_Instructions_unknown() {
		if (check_main_region_DoAction_Instructions_unknown_tr0_tr0()) {
			effect_main_region_DoAction_Instructions_unknown_tr0();
		} else {
			if (check_main_region_DoAction_Instructions_unknown_tr1_tr1()) {
				effect_main_region_DoAction_Instructions_unknown_tr1();
			}
		}
	}
	
	/* The reactions of state Copy_1_crowd. */
	private void react_main_region_DoAction_Instructions_Copy_1_crowd() {
		if (check_main_region_DoAction_Instructions_Copy_1_crowd_tr0_tr0()) {
			effect_main_region_DoAction_Instructions_Copy_1_crowd_tr0();
		} else {
			if (check_main_region_DoAction_Instructions_Copy_1_crowd_tr1_tr1()) {
				effect_main_region_DoAction_Instructions_Copy_1_crowd_tr1();
			}
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
		} else {
			if (check_main_region_TellIncomprehensible_tr1_tr1()) {
				effect_main_region_TellIncomprehensible_tr1();
			}
		}
	}
	
	/* The reactions of state NextQuestion. */
	private void react_main_region_NextQuestion() {
		if (check_main_region_NextQuestion_tr0_tr0()) {
			effect_main_region_NextQuestion_tr0();
		} else {
			if (check_main_region_NextQuestion_tr1_tr1()) {
				effect_main_region_NextQuestion_tr1();
			}
		}
	}
	
	/* The reactions of state StartSTT. */
	private void react_main_region_Copy_1_STT_STT_StartSTT() {
		if (check_main_region_Copy_1_STT_STT_StartSTT_tr0_tr0()) {
			effect_main_region_Copy_1_STT_STT_StartSTT_tr0();
		}
	}
	
	/* The reactions of state TellSpokenText. */
	private void react_main_region_Copy_1_STT_STT_TellSpokenText() {
		if (check_main_region_Copy_1_STT_STT_TellSpokenText_tr0_tr0()) {
			effect_main_region_Copy_1_STT_STT_TellSpokenText_tr0();
		} else {
			if (check_main_region_Copy_1_STT_STT_TellSpokenText_tr1_tr1()) {
				effect_main_region_Copy_1_STT_STT_TellSpokenText_tr1();
			} else {
				if (check_main_region_Copy_1_STT_STT_TellSpokenText_tr2_tr2()) {
					effect_main_region_Copy_1_STT_STT_TellSpokenText_tr2();
				} else {
					if (check_main_region_Copy_1_STT_STT_TellSpokenText_tr3_tr3()) {
						effect_main_region_Copy_1_STT_STT_TellSpokenText_tr3();
					}
				}
			}
		}
	}
	
	/* The reactions of state StropSTT. */
	private void react_main_region_Copy_1_STT_STT_StropSTT() {
		if (check_main_region_Copy_1_STT_STT_StropSTT_tr0_tr0()) {
			effect_main_region_Copy_1_STT_STT_StropSTT_tr0();
		} else {
			if (check_main_region_Copy_1_STT_STT_StropSTT_tr1_tr1()) {
				effect_main_region_Copy_1_STT_STT_StropSTT_tr1();
			}
		}
	}
	
	/* The reactions of state leave2. */
	private void react_main_region_leave2() {
		if (check_main_region_leave2_tr0_tr0()) {
			effect_main_region_leave2_tr0();
		} else {
			if (check_main_region_leave2_tr1_tr1()) {
				effect_main_region_leave2_tr1();
			}
		}
	}
	
	/* The reactions of state leave3. */
	private void react_main_region_leave3() {
		if (check_main_region_leave3_tr0_tr0()) {
			effect_main_region_leave3_tr0();
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
	private void react_main_region_DoAction_Instructions_GoTo_goto_GeneralP__choice_0() {
		if (check_main_region_DoAction_Instructions_GoTo_goto_GeneralP__choice_0_tr1_tr1()) {
			effect_main_region_DoAction_Instructions_GoTo_goto_GeneralP__choice_0_tr1();
		} else {
			effect_main_region_DoAction_Instructions_GoTo_goto_GeneralP__choice_0_tr0();
		}
	}
	
	/* The reactions of state null. */
	private void react_main_region_DoAction_Instructions__choice_0() {
		if (check_main_region_DoAction_Instructions__choice_0_tr0_tr0()) {
			effect_main_region_DoAction_Instructions__choice_0_tr0();
		} else {
			if (check_main_region_DoAction_Instructions__choice_0_tr1_tr1()) {
				effect_main_region_DoAction_Instructions__choice_0_tr1();
			} else {
				if (check_main_region_DoAction_Instructions__choice_0_tr2_tr2()) {
					effect_main_region_DoAction_Instructions__choice_0_tr2();
				} else {
					if (check_main_region_DoAction_Instructions__choice_0_tr3_tr3()) {
						effect_main_region_DoAction_Instructions__choice_0_tr3();
					} else {
						if (check_main_region_DoAction_Instructions__choice_0_tr4_tr4()) {
							effect_main_region_DoAction_Instructions__choice_0_tr4();
						} else {
							if (check_main_region_DoAction_Instructions__choice_0_tr5_tr5()) {
								effect_main_region_DoAction_Instructions__choice_0_tr5();
							} else {
								effect_main_region_DoAction_Instructions__choice_0_tr6();
							}
						}
					}
				}
			}
		}
	}
	
	/* The reactions of state null. */
	private void react_main_region_DoAction_Instructions_bring_bring_GeneralP__choice_0() {
		if (check_main_region_DoAction_Instructions_bring_bring_GeneralP__choice_0_tr1_tr1()) {
			effect_main_region_DoAction_Instructions_bring_bring_GeneralP__choice_0_tr1();
		} else {
			effect_main_region_DoAction_Instructions_bring_bring_GeneralP__choice_0_tr0();
		}
	}
	
	/* The reactions of state null. */
	private void react_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking_WaitingForStopCommand__choice_0() {
		if (check_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking_WaitingForStopCommand__choice_0_tr0_tr0()) {
			effect_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking_WaitingForStopCommand__choice_0_tr0();
		} else {
			effect_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking_WaitingForStopCommand__choice_0_tr1();
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
	
	/* The reactions of state null. */
	private void react_main_region_Copy_1_STT_STT__choice_0() {
		if (check_main_region_Copy_1_STT_STT__choice_0_tr1_tr1()) {
			effect_main_region_Copy_1_STT_STT__choice_0_tr1();
		} else {
			effect_main_region_Copy_1_STT_STT__choice_0_tr0();
		}
	}
	
	/* Default react sequence for initial entry  */
	private void react_main_region__entry_Default() {
		enterSequence_main_region_Init_default();
	}
	
	/* Default react sequence for initial entry  */
	private void react_main_region_DoAction_Instructions__entry_Default() {
		react_main_region_DoAction_Instructions__choice_0();
	}
	
	/* Default react sequence for initial entry  */
	private void react_main_region_DoAction_Instructions_GoTo_goto_GeneralP__entry_Default() {
		react_main_region_DoAction_Instructions_GoTo_goto_GeneralP__choice_0();
	}
	
	/* Default react sequence for initial entry  */
	private void react_main_region_DoAction_Instructions_bring_bring_GeneralP__entry_Default() {
		enterSequence_main_region_DoAction_Instructions_bring_bring_GeneralP_bringGehtnicht_default();
	}
	
	/* Default react sequence for initial entry  */
	private void react_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking_WaitingForStopCommand__entry_Default() {
		enterSequence_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking_WaitingForStopCommand_STTstart_default();
	}
	
	/* Default react sequence for initial entry  */
	private void react_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson__entry_Default() {
		enterSequence_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_ILostYou_default();
	}
	
	/* Default react sequence for initial entry  */
	private void react_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR__entry_Default() {
		enterSequence_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wir_brauchen_das_gerade_nicht_default();
	}
	
	/* Default react sequence for initial entry  */
	private void react_main_region_Copy_1_STT_STT__entry_Default() {
		enterSequence_main_region_Copy_1_STT_STT_StartSTT_default();
	}
	
	/* Default react sequence for initial entry  */
	private void react_Leonie_Bupered_Or_Emergency_Stop__entry_Default() {
		enterSequence_Leonie_Bupered_Or_Emergency_Stop_waitForEvent_default();
	}
	
	/* The reactions of exit exit_done. */
	private void react_main_region_DoAction_Instructions_exit_done() {
		effect_main_region_DoAction_tr0();
	}
	
	/* The reactions of exit exit_done. */
	private void react_main_region_DoAction_Instructions_GoTo_goto_GeneralP_exit_done() {
		effect_main_region_DoAction_Instructions_GoTo_tr0();
	}
	
	/* The reactions of exit exit_done. */
	private void react_main_region_DoAction_Instructions_bring_bring_GeneralP_exit_done() {
		effect_main_region_DoAction_Instructions_bring_tr0();
	}
	
	/* The reactions of exit exit_arrived. */
	private void react_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking_WaitingForStopCommand_exit_arrived() {
		effect_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking_tr1();
	}
	
	/* The reactions of exit exit_done. */
	private void react_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_exit_done() {
		effect_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_tr0();
	}
	
	/* The reactions of exit exit_done. */
	private void react_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_exit_done() {
		effect_main_region_DoAction_Instructions_followme_tr0();
	}
	
	/* The reactions of exit exit_answer. */
	private void react_main_region_Copy_1_STT_STT_exit_answer() {
		effect_main_region_Copy_1_STT_tr0();
	}
	
	/* The reactions of exit exit_action. */
	private void react_main_region_Copy_1_STT_STT_exit_action() {
		effect_main_region_Copy_1_STT_tr1();
	}
	
	/* The reactions of exit exit_incomprehensible. */
	private void react_main_region_Copy_1_STT_STT_exit_incomprehensible() {
		effect_main_region_Copy_1_STT_tr2();
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
			case main_region_TellAnswer:
				react_main_region_TellAnswer();
				break;
			case main_region_DoAction_Instructions_GoTo_goto_GeneralP_livingroom:
				react_main_region_DoAction_Instructions_GoTo_goto_GeneralP_livingroom();
				break;
			case main_region_DoAction_Instructions_GoTo_goto_GeneralP_notFound:
				react_main_region_DoAction_Instructions_GoTo_goto_GeneralP_notFound();
				break;
			case main_region_DoAction_Instructions_GoTo_goto_GeneralP_arrived:
				react_main_region_DoAction_Instructions_GoTo_goto_GeneralP_arrived();
				break;
			case main_region_DoAction_Instructions_GoTo_goto_GeneralP_backToTheOperator:
				react_main_region_DoAction_Instructions_GoTo_goto_GeneralP_backToTheOperator();
				break;
			case main_region_DoAction_Instructions_surrounding:
				react_main_region_DoAction_Instructions_surrounding();
				break;
			case main_region_DoAction_Instructions_bring_bring_GeneralP_livingroom:
				react_main_region_DoAction_Instructions_bring_bring_GeneralP_livingroom();
				break;
			case main_region_DoAction_Instructions_bring_bring_GeneralP_notFound:
				react_main_region_DoAction_Instructions_bring_bring_GeneralP_notFound();
				break;
			case main_region_DoAction_Instructions_bring_bring_GeneralP_arrived:
				react_main_region_DoAction_Instructions_bring_bring_GeneralP_arrived();
				break;
			case main_region_DoAction_Instructions_bring_bring_GeneralP_backToTheOperator:
				react_main_region_DoAction_Instructions_bring_bring_GeneralP_backToTheOperator();
				break;
			case main_region_DoAction_Instructions_bring_bring_GeneralP_bringGehtnicht:
				react_main_region_DoAction_Instructions_bring_bring_GeneralP_bringGehtnicht();
				break;
			case main_region_DoAction_Instructions_bring_bring_GeneralP_stattdessen_goto:
				react_main_region_DoAction_Instructions_bring_bring_GeneralP_stattdessen_goto();
				break;
			case main_region_DoAction_Instructions_open:
				react_main_region_DoAction_Instructions_open();
				break;
			case main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking_WaitingForStopCommand_STToff:
				react_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking_WaitingForStopCommand_STToff();
				break;
			case main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking_WaitingForStopCommand_STTstart:
				react_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_StartTracking_WaitingForStopCommand_STTstart();
				break;
			case main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_UTurn1:
				react_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_UTurn1();
				break;
			case main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_WaveFound:
				react_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_WaveFound();
				break;
			case main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_Turn:
				react_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_Turn();
				break;
			case main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_DetectionOn:
				react_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_DetectionOn();
				break;
			case main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_PersonFound:
				react_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_PersonFound();
				break;
			case main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_ILostYou:
				react_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_ILostYou();
				break;
			case main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_UTurn2:
				react_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_UTurn2();
				break;
			case main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_Detection:
				react_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_Detection();
				break;
			case main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_NotFound:
				react_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wave_WavingToFindPerson_NotFound();
				break;
			case main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Detect:
				react_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Detect();
				break;
			case main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_no:
				react_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_no();
				break;
			case main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_HowCanIHelpYou:
				react_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_HowCanIHelpYou();
				break;
			case main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wir_brauchen_das_gerade_nicht:
				react_main_region_DoAction_Instructions_followme_FollowMe_in_GPSR_Wir_brauchen_das_gerade_nicht();
				break;
			case main_region_DoAction_Instructions_unknown:
				react_main_region_DoAction_Instructions_unknown();
				break;
			case main_region_DoAction_Instructions_Copy_1_crowd:
				react_main_region_DoAction_Instructions_Copy_1_crowd();
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
			case main_region_Copy_1_STT_STT_StartSTT:
				react_main_region_Copy_1_STT_STT_StartSTT();
				break;
			case main_region_Copy_1_STT_STT_TellSpokenText:
				react_main_region_Copy_1_STT_STT_TellSpokenText();
				break;
			case main_region_Copy_1_STT_STT_StropSTT:
				react_main_region_Copy_1_STT_STT_StropSTT();
				break;
			case main_region_leave2:
				react_main_region_leave2();
				break;
			case main_region_leave3:
				react_main_region_leave3();
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
