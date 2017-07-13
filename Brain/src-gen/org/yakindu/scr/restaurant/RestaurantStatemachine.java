package org.yakindu.scr.restaurant;
import org.yakindu.scr.ITimer;

public class RestaurantStatemachine implements IRestaurantStatemachine {

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
		main_region_Init,
		main_region_Ready,
		main_region_Turn,
		main_region_SearchWave,
		main_region_AnnounceGetWaving,
		main_region_WaitForOperator,
		main_region_LeonieChoosen,
		main_region_Wait,
		main_region_GoToWavingPerson,
		main_region_TakeTheOrder,
		main_region_GetOrder,
		main_region_DriveToKitchen,
		main_region_ArrivedKitchen,
		main_region_WaitForTray,
		main_region_GoToBar,
		main_region_AnnounceReady,
		main_region_Answer,
		main_region_Stop,
		main_region_Serve,
		main_region__final_,
		main_region_SearchingBarman,
		main_region_SearchingBarman_SearchingBarman_SearchingForBarman,
		main_region_SearchingBarman_SearchingBarman_SearchingRight,
		main_region_SearchingBarman_SearchingBarman_FoundRight,
		main_region_SearchingBarman_SearchingBarman_NoBarmanFound,
		main_region_SearchingBarman_SearchingBarman_TiltCamera,
		main_region_SearchingBarman_SearchingBarman_SearchingLeft,
		main_region_SearchingBarman_SearchingBarman_FoundLeft,
		main_region_SearchingBarman_SearchingBarman_Default,
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
	
	private final boolean[] timeEvents = new boolean[8];
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
	
	private long gWPkitchen;
	
	protected void setGWPkitchen(long value) {
		gWPkitchen = value;
	}
	
	protected long getGWPkitchen() {
		return gWPkitchen;
	}
	
	public RestaurantStatemachine() {
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
		
		setGWPout(0);
		
		setGWPstart(0);
		
		setGWPkitchen(0);
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
		case main_region_Init:
			return stateVector[0] == State.main_region_Init;
		case main_region_Ready:
			return stateVector[0] == State.main_region_Ready;
		case main_region_Turn:
			return stateVector[0] == State.main_region_Turn;
		case main_region_SearchWave:
			return stateVector[0] == State.main_region_SearchWave;
		case main_region_AnnounceGetWaving:
			return stateVector[0] == State.main_region_AnnounceGetWaving;
		case main_region_WaitForOperator:
			return stateVector[0] == State.main_region_WaitForOperator;
		case main_region_LeonieChoosen:
			return stateVector[0] == State.main_region_LeonieChoosen;
		case main_region_Wait:
			return stateVector[0] == State.main_region_Wait;
		case main_region_GoToWavingPerson:
			return stateVector[0] == State.main_region_GoToWavingPerson;
		case main_region_TakeTheOrder:
			return stateVector[0] == State.main_region_TakeTheOrder;
		case main_region_GetOrder:
			return stateVector[0] == State.main_region_GetOrder;
		case main_region_DriveToKitchen:
			return stateVector[0] == State.main_region_DriveToKitchen;
		case main_region_ArrivedKitchen:
			return stateVector[0] == State.main_region_ArrivedKitchen;
		case main_region_WaitForTray:
			return stateVector[0] == State.main_region_WaitForTray;
		case main_region_GoToBar:
			return stateVector[0] == State.main_region_GoToBar;
		case main_region_AnnounceReady:
			return stateVector[0] == State.main_region_AnnounceReady;
		case main_region_Answer:
			return stateVector[0] == State.main_region_Answer;
		case main_region_Stop:
			return stateVector[0] == State.main_region_Stop;
		case main_region_Serve:
			return stateVector[0] == State.main_region_Serve;
		case main_region__final_:
			return stateVector[0] == State.main_region__final_;
		case main_region_SearchingBarman:
			return stateVector[0].ordinal() >= State.
					main_region_SearchingBarman.ordinal()&& stateVector[0].ordinal() <= State.main_region_SearchingBarman_SearchingBarman_Default.ordinal();
		case main_region_SearchingBarman_SearchingBarman_SearchingForBarman:
			return stateVector[0] == State.main_region_SearchingBarman_SearchingBarman_SearchingForBarman;
		case main_region_SearchingBarman_SearchingBarman_SearchingRight:
			return stateVector[0] == State.main_region_SearchingBarman_SearchingBarman_SearchingRight;
		case main_region_SearchingBarman_SearchingBarman_FoundRight:
			return stateVector[0] == State.main_region_SearchingBarman_SearchingBarman_FoundRight;
		case main_region_SearchingBarman_SearchingBarman_NoBarmanFound:
			return stateVector[0] == State.main_region_SearchingBarman_SearchingBarman_NoBarmanFound;
		case main_region_SearchingBarman_SearchingBarman_TiltCamera:
			return stateVector[0] == State.main_region_SearchingBarman_SearchingBarman_TiltCamera;
		case main_region_SearchingBarman_SearchingBarman_SearchingLeft:
			return stateVector[0] == State.main_region_SearchingBarman_SearchingBarman_SearchingLeft;
		case main_region_SearchingBarman_SearchingBarman_FoundLeft:
			return stateVector[0] == State.main_region_SearchingBarman_SearchingBarman_FoundLeft;
		case main_region_SearchingBarman_SearchingBarman_Default:
			return stateVector[0] == State.main_region_SearchingBarman_SearchingBarman_Default;
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
	
	private boolean check_main_region_Init_tr0_tr0() {
		return sCIMira.arrivedWP;
	}
	
	private boolean check_main_region_Ready_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_main_region_Ready_tr1_tr1() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_main_region_Turn_tr0_tr0() {
		return timeEvents[0];
	}
	
	private boolean check_main_region_SearchWave_tr0_tr0() {
		return sCICrowdDetection.detected;
	}
	
	private boolean check_main_region_AnnounceGetWaving_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_main_region_WaitForOperator_tr0_tr0() {
		return sCISTT.actionReceived;
	}
	
	private boolean check_main_region_LeonieChoosen_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_main_region_GoToWavingPerson_tr0_tr0() {
		return sCIMira.arrivedWP;
	}
	
	private boolean check_main_region_TakeTheOrder_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_main_region_GetOrder_tr0_tr0() {
		return timeEvents[1];
	}
	
	private boolean check_main_region_DriveToKitchen_tr0_tr0() {
		return sCIMira.arrivedWP;
	}
	
	private boolean check_main_region_ArrivedKitchen_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_main_region_WaitForTray_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_main_region_GoToBar_tr0_tr0() {
		return sCIMira.arrivedWP;
	}
	
	private boolean check_main_region_AnnounceReady_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_main_region_Answer_tr0_tr0() {
		return sCISTT.actionReceived;
	}
	
	private boolean check_main_region_Stop_tr0_tr0() {
		return sCIMira.arrivedWP;
	}
	
	private boolean check_main_region_SearchingBarman_SearchingBarman_SearchingForBarman_tr0_tr0() {
		return timeEvents[2];
	}
	
	private boolean check_main_region_SearchingBarman_SearchingBarman_SearchingRight_tr0_tr0() {
		return sCICrowdDetection.detected && sCICrowdDetection.operationCallback.getMinDistance()<=2;
	}
	
	private boolean check_main_region_SearchingBarman_SearchingBarman_SearchingRight_tr1_tr1() {
		return timeEvents[3];
	}
	
	private boolean check_main_region_SearchingBarman_SearchingBarman_FoundRight_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_main_region_SearchingBarman_SearchingBarman_TiltCamera_tr0_tr0() {
		return timeEvents[4];
	}
	
	private boolean check_main_region_SearchingBarman_SearchingBarman_SearchingLeft_tr0_tr0() {
		return sCICrowdDetection.detected && sCICrowdDetection.operationCallback.getMinDistance()<=2;
	}
	
	private boolean check_main_region_SearchingBarman_SearchingBarman_SearchingLeft_tr1_tr1() {
		return timeEvents[5];
	}
	
	private boolean check_main_region_SearchingBarman_SearchingBarman_FoundLeft_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_main_region_SearchingBarman_SearchingBarman_Default_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_Leonie_Bupered_Or_Emergency_Stop_waitForEvent_tr0_tr0() {
		return sCIMira.bumpered;
	}
	
	private boolean check_Leonie_Bupered_Or_Emergency_Stop_waitForEvent_tr1_tr1() {
		return sCIMira.emergencyStop;
	}
	
	private boolean check_Leonie_Bupered_Or_Emergency_Stop_Bumpered_tr0_tr0() {
		return timeEvents[6];
	}
	
	private boolean check_Leonie_Bupered_Or_Emergency_Stop_resetFace_tr0_tr0() {
		return true;
	}
	
	private boolean check_Leonie_Bupered_Or_Emergency_Stop_EmergencyStop_tr0_tr0() {
		return true;
	}
	
	private boolean check_Leonie_Bupered_Or_Emergency_Stop_checkEmergency_tr0_tr0() {
		return timeEvents[7];
	}
	
	private boolean check_Leonie_Bupered_Or_Emergency_Stop_checkEmergency_tr1_tr1() {
		return sCIMira.emergencyStop;
	}
	
	private boolean check_main_region__choice_0_tr0_tr0() {
		return (sCISTT.operationCallback.getInstruction()== null?"Leonie" ==null :sCISTT.operationCallback.getInstruction().equals("Leonie"));
	}
	
	private boolean check_main_region__choice_0_tr1_tr1() {
		return true;
	}
	
	private boolean check_main_region__choice_1_tr1() {
		return true;
	}
	
	private boolean check_main_region__choice_1_tr2() {
		return true;
	}
	
	private boolean check_main_region__choice_1_tr0() {
		return true;
	}
	
	private void effect_main_region_Init_tr0() {
		exitSequence_main_region_Init();
		enterSequence_main_region_Ready_default();
	}
	
	private void effect_main_region_Ready_tr0() {
		exitSequence_main_region_Ready();
		enterSequence_main_region_Turn_default();
	}
	
	private void effect_main_region_Ready_tr1() {
		exitSequence_main_region_Ready();
		enterSequence_main_region_SearchingBarman_default();
	}
	
	private void effect_main_region_Turn_tr0() {
		exitSequence_main_region_Turn();
		enterSequence_main_region_SearchWave_default();
	}
	
	private void effect_main_region_SearchWave_tr0() {
		exitSequence_main_region_SearchWave();
		enterSequence_main_region_AnnounceGetWaving_default();
	}
	
	private void effect_main_region_AnnounceGetWaving_tr0() {
		exitSequence_main_region_AnnounceGetWaving();
		enterSequence_main_region_WaitForOperator_default();
	}
	
	private void effect_main_region_WaitForOperator_tr0() {
		exitSequence_main_region_WaitForOperator();
		react_main_region__choice_0();
	}
	
	private void effect_main_region_LeonieChoosen_tr0() {
		exitSequence_main_region_LeonieChoosen();
		enterSequence_main_region_GoToWavingPerson_default();
	}
	
	private void effect_main_region_GoToWavingPerson_tr0() {
		exitSequence_main_region_GoToWavingPerson();
		enterSequence_main_region_TakeTheOrder_default();
	}
	
	private void effect_main_region_TakeTheOrder_tr0() {
		exitSequence_main_region_TakeTheOrder();
		enterSequence_main_region_GetOrder_default();
	}
	
	private void effect_main_region_GetOrder_tr0() {
		exitSequence_main_region_GetOrder();
		enterSequence_main_region_DriveToKitchen_default();
	}
	
	private void effect_main_region_DriveToKitchen_tr0() {
		exitSequence_main_region_DriveToKitchen();
		enterSequence_main_region_ArrivedKitchen_default();
	}
	
	private void effect_main_region_ArrivedKitchen_tr0() {
		exitSequence_main_region_ArrivedKitchen();
		enterSequence_main_region_WaitForTray_default();
	}
	
	private void effect_main_region_WaitForTray_tr0() {
		exitSequence_main_region_WaitForTray();
		enterSequence_main_region_AnnounceReady_default();
	}
	
	private void effect_main_region_GoToBar_tr0() {
		exitSequence_main_region_GoToBar();
		enterSequence_main_region_Turn_default();
	}
	
	private void effect_main_region_AnnounceReady_tr0() {
		exitSequence_main_region_AnnounceReady();
		enterSequence_main_region_Answer_default();
	}
	
	private void effect_main_region_Answer_tr0() {
		exitSequence_main_region_Answer();
		react_main_region__choice_1();
	}
	
	private void effect_main_region_Stop_tr0() {
		exitSequence_main_region_Stop();
		enterSequence_main_region__final__default();
	}
	
	private void effect_main_region_SearchingBarman_tr0() {
		exitSequence_main_region_SearchingBarman();
		enterSequence_main_region_Turn_default();
	}
	
	private void effect_main_region_SearchingBarman_SearchingBarman_SearchingForBarman_tr0() {
		exitSequence_main_region_SearchingBarman_SearchingBarman_SearchingForBarman();
		enterSequence_main_region_SearchingBarman_SearchingBarman_SearchingRight_default();
	}
	
	private void effect_main_region_SearchingBarman_SearchingBarman_SearchingRight_tr0() {
		exitSequence_main_region_SearchingBarman_SearchingBarman_SearchingRight();
		enterSequence_main_region_SearchingBarman_SearchingBarman_FoundRight_default();
	}
	
	private void effect_main_region_SearchingBarman_SearchingBarman_SearchingRight_tr1() {
		exitSequence_main_region_SearchingBarman_SearchingBarman_SearchingRight();
		enterSequence_main_region_SearchingBarman_SearchingBarman_NoBarmanFound_default();
	}
	
	private void effect_main_region_SearchingBarman_SearchingBarman_FoundRight_tr0() {
		exitSequence_main_region_SearchingBarman_SearchingBarman_FoundRight();
		react_main_region_SearchingBarman_SearchingBarman_exit_done();
	}
	
	private void effect_main_region_SearchingBarman_SearchingBarman_TiltCamera_tr0() {
		exitSequence_main_region_SearchingBarman_SearchingBarman_TiltCamera();
		enterSequence_main_region_SearchingBarman_SearchingBarman_SearchingLeft_default();
	}
	
	private void effect_main_region_SearchingBarman_SearchingBarman_SearchingLeft_tr0() {
		exitSequence_main_region_SearchingBarman_SearchingBarman_SearchingLeft();
		enterSequence_main_region_SearchingBarman_SearchingBarman_FoundLeft_default();
	}
	
	private void effect_main_region_SearchingBarman_SearchingBarman_SearchingLeft_tr1() {
		exitSequence_main_region_SearchingBarman_SearchingBarman_SearchingLeft();
		enterSequence_main_region_SearchingBarman_SearchingBarman_Default_default();
	}
	
	private void effect_main_region_SearchingBarman_SearchingBarman_FoundLeft_tr0() {
		exitSequence_main_region_SearchingBarman_SearchingBarman_FoundLeft();
		react_main_region_SearchingBarman_SearchingBarman_exit_done();
	}
	
	private void effect_main_region_SearchingBarman_SearchingBarman_Default_tr0() {
		exitSequence_main_region_SearchingBarman_SearchingBarman_Default();
		react_main_region_SearchingBarman_SearchingBarman_exit_done();
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
	
	private void effect_main_region__choice_0_tr0() {
		enterSequence_main_region_LeonieChoosen_default();
	}
	
	private void effect_main_region__choice_0_tr1() {
		enterSequence_main_region_Wait_default();
	}
	
	private void effect_main_region__choice_1_tr1() {
		enterSequence_main_region_Serve_default();
	}
	
	private void effect_main_region__choice_1_tr2() {
		enterSequence_main_region_Wait_default();
	}
	
	private void effect_main_region__choice_1_tr0() {
		enterSequence_main_region_Stop_default();
	}
	
	/* Entry action for state 'Init'. */
	private void entryAction_main_region_Init() {
		setGWPstart(0);
		
		setGWPkitchen(0);
		
		setGWPout(0);
	}
	
	/* Entry action for state 'Ready'. */
	private void entryAction_main_region_Ready() {
		sCIHBrain.operationCallback.sendTTS("I am ready! But first I'm looking for the barman.");
	}
	
	/* Entry action for state 'Turn'. */
	private void entryAction_main_region_Turn() {
		timer.setTimer(this, 0, 3 * 1000, false);
		
		sCIMira.operationCallback.sendTiltCamera(45);
	}
	
	/* Entry action for state 'SearchWave'. */
	private void entryAction_main_region_SearchWave() {
		sCICrowdDetection.operationCallback.sendWaveDetectionOn();
	}
	
	/* Entry action for state 'AnnounceGetWaving'. */
	private void entryAction_main_region_AnnounceGetWaving() {
		sCICrowdDetection.operationCallback.sendDetectionOff();
		
		sCIHBrain.operationCallback.sendTTS("There is someone waving to order. If you want me to get the order, please let me know by saying my name.");
	}
	
	/* Entry action for state 'WaitForOperator'. */
	private void entryAction_main_region_WaitForOperator() {
		sCISTT.operationCallback.sendSpeechDetectionSmalltalk(10);
	}
	
	/* Entry action for state 'LeonieChoosen'. */
	private void entryAction_main_region_LeonieChoosen() {
		sCIHBrain.operationCallback.sendTTS("Okay, I will take the order.");
	}
	
	/* Entry action for state 'GoToWavingPerson'. */
	private void entryAction_main_region_GoToWavingPerson() {
		sCIMira.operationCallback.sendGoToPhi(sCICrowdDetection.operationCallback.getWavingAngle());
	}
	
	/* Entry action for state 'TakeTheOrder'. */
	private void entryAction_main_region_TakeTheOrder() {
		sCIHBrain.operationCallback.sendTTS("Hello, what do you want to order?");
	}
	
	/* Entry action for state 'GetOrder'. */
	private void entryAction_main_region_GetOrder() {
		timer.setTimer(this, 1, 8 * 1000, false);
		
		sCISTT.operationCallback.sendSpeechDetectionSmalltalk(10);
	}
	
	/* Entry action for state 'DriveToKitchen'. */
	private void entryAction_main_region_DriveToKitchen() {
		sCIMira.operationCallback.sendGoToGWP(getGWPkitchen());
	}
	
	/* Entry action for state 'ArrivedKitchen'. */
	private void entryAction_main_region_ArrivedKitchen() {
		sCIHBrain.operationCallback.sendTTS2("I have an order.", sCISTT.operationCallback.getAnswer());
	}
	
	/* Entry action for state 'WaitForTray'. */
	private void entryAction_main_region_WaitForTray() {
		sCIHBrain.operationCallback.sendTTS("I have no manipulator so I can't take the order to the client. But I can get another order. I will go to the bar to wait for people calling me.");
	}
	
	/* Entry action for state 'GoToBar'. */
	private void entryAction_main_region_GoToBar() {
		sCIMira.operationCallback.sendGoToGWP(getGWPstart());
	}
	
	/* Entry action for state 'AnnounceReady'. */
	private void entryAction_main_region_AnnounceReady() {
		sCIHBrain.operationCallback.sendTTS("Should I take the next order?");
	}
	
	/* Entry action for state 'Answer'. */
	private void entryAction_main_region_Answer() {
		sCISTT.operationCallback.sendSpeechDetectionSmalltalk(10);
	}
	
	/* Entry action for state 'Stop'. */
	private void entryAction_main_region_Stop() {
		sCIMira.operationCallback.sendGoToGWP(getGWPout());
	}
	
	/* Entry action for state 'SearchingForBarman'. */
	private void entryAction_main_region_SearchingBarman_SearchingBarman_SearchingForBarman() {
		timer.setTimer(this, 2, 3 * 1000, false);
		
		sCIMira.operationCallback.sendPanTiltCamera(-10, 45);
	}
	
	/* Entry action for state 'SearchingRight'. */
	private void entryAction_main_region_SearchingBarman_SearchingBarman_SearchingRight() {
		timer.setTimer(this, 3, 15 * 1000, false);
		
		sCICrowdDetection.operationCallback.sendDetectionOn();
	}
	
	/* Entry action for state 'FoundRight'. */
	private void entryAction_main_region_SearchingBarman_SearchingBarman_FoundRight() {
		sCIHBrain.operationCallback.sendTTS("There is a person in front of me. I think this is the barman so I'm standing on the left site of the bar.");
	}
	
	/* Entry action for state 'NoBarmanFound'. */
	private void entryAction_main_region_SearchingBarman_SearchingBarman_NoBarmanFound() {
		sCICrowdDetection.operationCallback.sendDetectionOff();
	}
	
	/* Entry action for state 'TiltCamera'. */
	private void entryAction_main_region_SearchingBarman_SearchingBarman_TiltCamera() {
		timer.setTimer(this, 4, 4 * 1000, false);
		
		sCIMira.operationCallback.sendTiltCamera(-90);
	}
	
	/* Entry action for state 'SearchingLeft'. */
	private void entryAction_main_region_SearchingBarman_SearchingBarman_SearchingLeft() {
		timer.setTimer(this, 5, 15 * 1000, false);
		
		sCICrowdDetection.operationCallback.sendDetectionOn();
	}
	
	/* Entry action for state 'FoundLeft'. */
	private void entryAction_main_region_SearchingBarman_SearchingBarman_FoundLeft() {
		sCIHBrain.operationCallback.sendTTS("There is a person in front of me. I think this is the barman so I'm standing on the right site of the bar.");
	}
	
	/* Entry action for state 'Default'. */
	private void entryAction_main_region_SearchingBarman_SearchingBarman_Default() {
		sCIHBrain.operationCallback.sendTTS("There is a person in front of me. I think this is the barman so I'm standing on the right site of the bar.");
	}
	
	/* Entry action for state 'Bumpered'. */
	private void entryAction_Leonie_Bupered_Or_Emergency_Stop_Bumpered() {
		timer.setTimer(this, 6, 3 * 1000, false);
		
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
		timer.setTimer(this, 7, 3 * 1000, false);
	}
	
	/* Exit action for state 'Turn'. */
	private void exitAction_main_region_Turn() {
		timer.unsetTimer(this, 0);
	}
	
	/* Exit action for state 'GetOrder'. */
	private void exitAction_main_region_GetOrder() {
		timer.unsetTimer(this, 1);
	}
	
	/* Exit action for state 'SearchingForBarman'. */
	private void exitAction_main_region_SearchingBarman_SearchingBarman_SearchingForBarman() {
		timer.unsetTimer(this, 2);
	}
	
	/* Exit action for state 'SearchingRight'. */
	private void exitAction_main_region_SearchingBarman_SearchingBarman_SearchingRight() {
		timer.unsetTimer(this, 3);
	}
	
	/* Exit action for state 'TiltCamera'. */
	private void exitAction_main_region_SearchingBarman_SearchingBarman_TiltCamera() {
		timer.unsetTimer(this, 4);
	}
	
	/* Exit action for state 'SearchingLeft'. */
	private void exitAction_main_region_SearchingBarman_SearchingBarman_SearchingLeft() {
		timer.unsetTimer(this, 5);
	}
	
	/* Exit action for state 'Bumpered'. */
	private void exitAction_Leonie_Bupered_Or_Emergency_Stop_Bumpered() {
		timer.unsetTimer(this, 6);
	}
	
	/* Exit action for state 'checkEmergency'. */
	private void exitAction_Leonie_Bupered_Or_Emergency_Stop_checkEmergency() {
		timer.unsetTimer(this, 7);
	}
	
	/* 'default' enter sequence for state Init */
	private void enterSequence_main_region_Init_default() {
		entryAction_main_region_Init();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_Init;
	}
	
	/* 'default' enter sequence for state Ready */
	private void enterSequence_main_region_Ready_default() {
		entryAction_main_region_Ready();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_Ready;
	}
	
	/* 'default' enter sequence for state Turn */
	private void enterSequence_main_region_Turn_default() {
		entryAction_main_region_Turn();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_Turn;
	}
	
	/* 'default' enter sequence for state SearchWave */
	private void enterSequence_main_region_SearchWave_default() {
		entryAction_main_region_SearchWave();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_SearchWave;
	}
	
	/* 'default' enter sequence for state AnnounceGetWaving */
	private void enterSequence_main_region_AnnounceGetWaving_default() {
		entryAction_main_region_AnnounceGetWaving();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_AnnounceGetWaving;
	}
	
	/* 'default' enter sequence for state WaitForOperator */
	private void enterSequence_main_region_WaitForOperator_default() {
		entryAction_main_region_WaitForOperator();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_WaitForOperator;
	}
	
	/* 'default' enter sequence for state LeonieChoosen */
	private void enterSequence_main_region_LeonieChoosen_default() {
		entryAction_main_region_LeonieChoosen();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_LeonieChoosen;
	}
	
	/* 'default' enter sequence for state Wait */
	private void enterSequence_main_region_Wait_default() {
		nextStateIndex = 0;
		stateVector[0] = State.main_region_Wait;
	}
	
	/* 'default' enter sequence for state GoToWavingPerson */
	private void enterSequence_main_region_GoToWavingPerson_default() {
		entryAction_main_region_GoToWavingPerson();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_GoToWavingPerson;
	}
	
	/* 'default' enter sequence for state TakeTheOrder */
	private void enterSequence_main_region_TakeTheOrder_default() {
		entryAction_main_region_TakeTheOrder();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_TakeTheOrder;
	}
	
	/* 'default' enter sequence for state GetOrder */
	private void enterSequence_main_region_GetOrder_default() {
		entryAction_main_region_GetOrder();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_GetOrder;
	}
	
	/* 'default' enter sequence for state DriveToKitchen */
	private void enterSequence_main_region_DriveToKitchen_default() {
		entryAction_main_region_DriveToKitchen();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_DriveToKitchen;
	}
	
	/* 'default' enter sequence for state ArrivedKitchen */
	private void enterSequence_main_region_ArrivedKitchen_default() {
		entryAction_main_region_ArrivedKitchen();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_ArrivedKitchen;
	}
	
	/* 'default' enter sequence for state WaitForTray */
	private void enterSequence_main_region_WaitForTray_default() {
		entryAction_main_region_WaitForTray();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_WaitForTray;
	}
	
	/* 'default' enter sequence for state GoToBar */
	private void enterSequence_main_region_GoToBar_default() {
		entryAction_main_region_GoToBar();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_GoToBar;
	}
	
	/* 'default' enter sequence for state AnnounceReady */
	private void enterSequence_main_region_AnnounceReady_default() {
		entryAction_main_region_AnnounceReady();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_AnnounceReady;
	}
	
	/* 'default' enter sequence for state Answer */
	private void enterSequence_main_region_Answer_default() {
		entryAction_main_region_Answer();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_Answer;
	}
	
	/* 'default' enter sequence for state Stop */
	private void enterSequence_main_region_Stop_default() {
		entryAction_main_region_Stop();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_Stop;
	}
	
	/* 'default' enter sequence for state Serve */
	private void enterSequence_main_region_Serve_default() {
		nextStateIndex = 0;
		stateVector[0] = State.main_region_Serve;
	}
	
	/* Default enter sequence for state null */
	private void enterSequence_main_region__final__default() {
		nextStateIndex = 0;
		stateVector[0] = State.main_region__final_;
	}
	
	/* 'default' enter sequence for state SearchingBarman */
	private void enterSequence_main_region_SearchingBarman_default() {
		enterSequence_main_region_SearchingBarman_SearchingBarman_default();
	}
	
	/* 'default' enter sequence for state SearchingForBarman */
	private void enterSequence_main_region_SearchingBarman_SearchingBarman_SearchingForBarman_default() {
		entryAction_main_region_SearchingBarman_SearchingBarman_SearchingForBarman();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_SearchingBarman_SearchingBarman_SearchingForBarman;
	}
	
	/* 'default' enter sequence for state SearchingRight */
	private void enterSequence_main_region_SearchingBarman_SearchingBarman_SearchingRight_default() {
		entryAction_main_region_SearchingBarman_SearchingBarman_SearchingRight();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_SearchingBarman_SearchingBarman_SearchingRight;
	}
	
	/* 'default' enter sequence for state FoundRight */
	private void enterSequence_main_region_SearchingBarman_SearchingBarman_FoundRight_default() {
		entryAction_main_region_SearchingBarman_SearchingBarman_FoundRight();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_SearchingBarman_SearchingBarman_FoundRight;
	}
	
	/* 'default' enter sequence for state NoBarmanFound */
	private void enterSequence_main_region_SearchingBarman_SearchingBarman_NoBarmanFound_default() {
		entryAction_main_region_SearchingBarman_SearchingBarman_NoBarmanFound();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_SearchingBarman_SearchingBarman_NoBarmanFound;
	}
	
	/* 'default' enter sequence for state TiltCamera */
	private void enterSequence_main_region_SearchingBarman_SearchingBarman_TiltCamera_default() {
		entryAction_main_region_SearchingBarman_SearchingBarman_TiltCamera();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_SearchingBarman_SearchingBarman_TiltCamera;
	}
	
	/* 'default' enter sequence for state SearchingLeft */
	private void enterSequence_main_region_SearchingBarman_SearchingBarman_SearchingLeft_default() {
		entryAction_main_region_SearchingBarman_SearchingBarman_SearchingLeft();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_SearchingBarman_SearchingBarman_SearchingLeft;
	}
	
	/* 'default' enter sequence for state FoundLeft */
	private void enterSequence_main_region_SearchingBarman_SearchingBarman_FoundLeft_default() {
		entryAction_main_region_SearchingBarman_SearchingBarman_FoundLeft();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_SearchingBarman_SearchingBarman_FoundLeft;
	}
	
	/* 'default' enter sequence for state Default */
	private void enterSequence_main_region_SearchingBarman_SearchingBarman_Default_default() {
		entryAction_main_region_SearchingBarman_SearchingBarman_Default();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_SearchingBarman_SearchingBarman_Default;
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
	
	/* 'default' enter sequence for region SearchingBarman */
	private void enterSequence_main_region_SearchingBarman_SearchingBarman_default() {
		react_main_region_SearchingBarman_SearchingBarman__entry_Default();
	}
	
	/* 'default' enter sequence for region Leonie Bupered Or Emergency Stop */
	private void enterSequence_Leonie_Bupered_Or_Emergency_Stop_default() {
		react_Leonie_Bupered_Or_Emergency_Stop__entry_Default();
	}
	
	/* Default exit sequence for state Init */
	private void exitSequence_main_region_Init() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state Ready */
	private void exitSequence_main_region_Ready() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state Turn */
	private void exitSequence_main_region_Turn() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
		
		exitAction_main_region_Turn();
	}
	
	/* Default exit sequence for state SearchWave */
	private void exitSequence_main_region_SearchWave() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state AnnounceGetWaving */
	private void exitSequence_main_region_AnnounceGetWaving() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state WaitForOperator */
	private void exitSequence_main_region_WaitForOperator() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state LeonieChoosen */
	private void exitSequence_main_region_LeonieChoosen() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state Wait */
	private void exitSequence_main_region_Wait() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state GoToWavingPerson */
	private void exitSequence_main_region_GoToWavingPerson() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state TakeTheOrder */
	private void exitSequence_main_region_TakeTheOrder() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state GetOrder */
	private void exitSequence_main_region_GetOrder() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
		
		exitAction_main_region_GetOrder();
	}
	
	/* Default exit sequence for state DriveToKitchen */
	private void exitSequence_main_region_DriveToKitchen() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state ArrivedKitchen */
	private void exitSequence_main_region_ArrivedKitchen() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state WaitForTray */
	private void exitSequence_main_region_WaitForTray() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state GoToBar */
	private void exitSequence_main_region_GoToBar() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state AnnounceReady */
	private void exitSequence_main_region_AnnounceReady() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state Answer */
	private void exitSequence_main_region_Answer() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state Stop */
	private void exitSequence_main_region_Stop() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state Serve */
	private void exitSequence_main_region_Serve() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for final state. */
	private void exitSequence_main_region__final_() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state SearchingBarman */
	private void exitSequence_main_region_SearchingBarman() {
		exitSequence_main_region_SearchingBarman_SearchingBarman();
	}
	
	/* Default exit sequence for state SearchingForBarman */
	private void exitSequence_main_region_SearchingBarman_SearchingBarman_SearchingForBarman() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
		
		exitAction_main_region_SearchingBarman_SearchingBarman_SearchingForBarman();
	}
	
	/* Default exit sequence for state SearchingRight */
	private void exitSequence_main_region_SearchingBarman_SearchingBarman_SearchingRight() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
		
		exitAction_main_region_SearchingBarman_SearchingBarman_SearchingRight();
	}
	
	/* Default exit sequence for state FoundRight */
	private void exitSequence_main_region_SearchingBarman_SearchingBarman_FoundRight() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state NoBarmanFound */
	private void exitSequence_main_region_SearchingBarman_SearchingBarman_NoBarmanFound() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state TiltCamera */
	private void exitSequence_main_region_SearchingBarman_SearchingBarman_TiltCamera() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
		
		exitAction_main_region_SearchingBarman_SearchingBarman_TiltCamera();
	}
	
	/* Default exit sequence for state SearchingLeft */
	private void exitSequence_main_region_SearchingBarman_SearchingBarman_SearchingLeft() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
		
		exitAction_main_region_SearchingBarman_SearchingBarman_SearchingLeft();
	}
	
	/* Default exit sequence for state FoundLeft */
	private void exitSequence_main_region_SearchingBarman_SearchingBarman_FoundLeft() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state Default */
	private void exitSequence_main_region_SearchingBarman_SearchingBarman_Default() {
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
		case main_region_Init:
			exitSequence_main_region_Init();
			break;
		case main_region_Ready:
			exitSequence_main_region_Ready();
			break;
		case main_region_Turn:
			exitSequence_main_region_Turn();
			break;
		case main_region_SearchWave:
			exitSequence_main_region_SearchWave();
			break;
		case main_region_AnnounceGetWaving:
			exitSequence_main_region_AnnounceGetWaving();
			break;
		case main_region_WaitForOperator:
			exitSequence_main_region_WaitForOperator();
			break;
		case main_region_LeonieChoosen:
			exitSequence_main_region_LeonieChoosen();
			break;
		case main_region_Wait:
			exitSequence_main_region_Wait();
			break;
		case main_region_GoToWavingPerson:
			exitSequence_main_region_GoToWavingPerson();
			break;
		case main_region_TakeTheOrder:
			exitSequence_main_region_TakeTheOrder();
			break;
		case main_region_GetOrder:
			exitSequence_main_region_GetOrder();
			break;
		case main_region_DriveToKitchen:
			exitSequence_main_region_DriveToKitchen();
			break;
		case main_region_ArrivedKitchen:
			exitSequence_main_region_ArrivedKitchen();
			break;
		case main_region_WaitForTray:
			exitSequence_main_region_WaitForTray();
			break;
		case main_region_GoToBar:
			exitSequence_main_region_GoToBar();
			break;
		case main_region_AnnounceReady:
			exitSequence_main_region_AnnounceReady();
			break;
		case main_region_Answer:
			exitSequence_main_region_Answer();
			break;
		case main_region_Stop:
			exitSequence_main_region_Stop();
			break;
		case main_region_Serve:
			exitSequence_main_region_Serve();
			break;
		case main_region__final_:
			exitSequence_main_region__final_();
			break;
		case main_region_SearchingBarman_SearchingBarman_SearchingForBarman:
			exitSequence_main_region_SearchingBarman_SearchingBarman_SearchingForBarman();
			break;
		case main_region_SearchingBarman_SearchingBarman_SearchingRight:
			exitSequence_main_region_SearchingBarman_SearchingBarman_SearchingRight();
			break;
		case main_region_SearchingBarman_SearchingBarman_FoundRight:
			exitSequence_main_region_SearchingBarman_SearchingBarman_FoundRight();
			break;
		case main_region_SearchingBarman_SearchingBarman_NoBarmanFound:
			exitSequence_main_region_SearchingBarman_SearchingBarman_NoBarmanFound();
			break;
		case main_region_SearchingBarman_SearchingBarman_TiltCamera:
			exitSequence_main_region_SearchingBarman_SearchingBarman_TiltCamera();
			break;
		case main_region_SearchingBarman_SearchingBarman_SearchingLeft:
			exitSequence_main_region_SearchingBarman_SearchingBarman_SearchingLeft();
			break;
		case main_region_SearchingBarman_SearchingBarman_FoundLeft:
			exitSequence_main_region_SearchingBarman_SearchingBarman_FoundLeft();
			break;
		case main_region_SearchingBarman_SearchingBarman_Default:
			exitSequence_main_region_SearchingBarman_SearchingBarman_Default();
			break;
		default:
			break;
		}
	}
	
	/* Default exit sequence for region SearchingBarman */
	private void exitSequence_main_region_SearchingBarman_SearchingBarman() {
		switch (stateVector[0]) {
		case main_region_SearchingBarman_SearchingBarman_SearchingForBarman:
			exitSequence_main_region_SearchingBarman_SearchingBarman_SearchingForBarman();
			break;
		case main_region_SearchingBarman_SearchingBarman_SearchingRight:
			exitSequence_main_region_SearchingBarman_SearchingBarman_SearchingRight();
			break;
		case main_region_SearchingBarman_SearchingBarman_FoundRight:
			exitSequence_main_region_SearchingBarman_SearchingBarman_FoundRight();
			break;
		case main_region_SearchingBarman_SearchingBarman_NoBarmanFound:
			exitSequence_main_region_SearchingBarman_SearchingBarman_NoBarmanFound();
			break;
		case main_region_SearchingBarman_SearchingBarman_TiltCamera:
			exitSequence_main_region_SearchingBarman_SearchingBarman_TiltCamera();
			break;
		case main_region_SearchingBarman_SearchingBarman_SearchingLeft:
			exitSequence_main_region_SearchingBarman_SearchingBarman_SearchingLeft();
			break;
		case main_region_SearchingBarman_SearchingBarman_FoundLeft:
			exitSequence_main_region_SearchingBarman_SearchingBarman_FoundLeft();
			break;
		case main_region_SearchingBarman_SearchingBarman_Default:
			exitSequence_main_region_SearchingBarman_SearchingBarman_Default();
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
	
	/* The reactions of state Init. */
	private void react_main_region_Init() {
		if (check_main_region_Init_tr0_tr0()) {
			effect_main_region_Init_tr0();
		}
	}
	
	/* The reactions of state Ready. */
	private void react_main_region_Ready() {
		if (check_main_region_Ready_tr0_tr0()) {
			effect_main_region_Ready_tr0();
		} else {
			if (check_main_region_Ready_tr1_tr1()) {
				effect_main_region_Ready_tr1();
			}
		}
	}
	
	/* The reactions of state Turn. */
	private void react_main_region_Turn() {
		if (check_main_region_Turn_tr0_tr0()) {
			effect_main_region_Turn_tr0();
		}
	}
	
	/* The reactions of state SearchWave. */
	private void react_main_region_SearchWave() {
		if (check_main_region_SearchWave_tr0_tr0()) {
			effect_main_region_SearchWave_tr0();
		}
	}
	
	/* The reactions of state AnnounceGetWaving. */
	private void react_main_region_AnnounceGetWaving() {
		if (check_main_region_AnnounceGetWaving_tr0_tr0()) {
			effect_main_region_AnnounceGetWaving_tr0();
		}
	}
	
	/* The reactions of state WaitForOperator. */
	private void react_main_region_WaitForOperator() {
		if (check_main_region_WaitForOperator_tr0_tr0()) {
			effect_main_region_WaitForOperator_tr0();
		}
	}
	
	/* The reactions of state LeonieChoosen. */
	private void react_main_region_LeonieChoosen() {
		if (check_main_region_LeonieChoosen_tr0_tr0()) {
			effect_main_region_LeonieChoosen_tr0();
		}
	}
	
	/* The reactions of state Wait. */
	private void react_main_region_Wait() {
	}
	
	/* The reactions of state GoToWavingPerson. */
	private void react_main_region_GoToWavingPerson() {
		if (check_main_region_GoToWavingPerson_tr0_tr0()) {
			effect_main_region_GoToWavingPerson_tr0();
		}
	}
	
	/* The reactions of state TakeTheOrder. */
	private void react_main_region_TakeTheOrder() {
		if (check_main_region_TakeTheOrder_tr0_tr0()) {
			effect_main_region_TakeTheOrder_tr0();
		}
	}
	
	/* The reactions of state GetOrder. */
	private void react_main_region_GetOrder() {
		if (check_main_region_GetOrder_tr0_tr0()) {
			effect_main_region_GetOrder_tr0();
		}
	}
	
	/* The reactions of state DriveToKitchen. */
	private void react_main_region_DriveToKitchen() {
		if (check_main_region_DriveToKitchen_tr0_tr0()) {
			effect_main_region_DriveToKitchen_tr0();
		}
	}
	
	/* The reactions of state ArrivedKitchen. */
	private void react_main_region_ArrivedKitchen() {
		if (check_main_region_ArrivedKitchen_tr0_tr0()) {
			effect_main_region_ArrivedKitchen_tr0();
		}
	}
	
	/* The reactions of state WaitForTray. */
	private void react_main_region_WaitForTray() {
		if (check_main_region_WaitForTray_tr0_tr0()) {
			effect_main_region_WaitForTray_tr0();
		}
	}
	
	/* The reactions of state GoToBar. */
	private void react_main_region_GoToBar() {
		if (check_main_region_GoToBar_tr0_tr0()) {
			effect_main_region_GoToBar_tr0();
		}
	}
	
	/* The reactions of state AnnounceReady. */
	private void react_main_region_AnnounceReady() {
		if (check_main_region_AnnounceReady_tr0_tr0()) {
			effect_main_region_AnnounceReady_tr0();
		}
	}
	
	/* The reactions of state Answer. */
	private void react_main_region_Answer() {
		if (check_main_region_Answer_tr0_tr0()) {
			effect_main_region_Answer_tr0();
		}
	}
	
	/* The reactions of state Stop. */
	private void react_main_region_Stop() {
		if (check_main_region_Stop_tr0_tr0()) {
			effect_main_region_Stop_tr0();
		}
	}
	
	/* The reactions of state Serve. */
	private void react_main_region_Serve() {
	}
	
	/* The reactions of state null. */
	private void react_main_region__final_() {
	}
	
	/* The reactions of state SearchingForBarman. */
	private void react_main_region_SearchingBarman_SearchingBarman_SearchingForBarman() {
		if (check_main_region_SearchingBarman_SearchingBarman_SearchingForBarman_tr0_tr0()) {
			effect_main_region_SearchingBarman_SearchingBarman_SearchingForBarman_tr0();
		}
	}
	
	/* The reactions of state SearchingRight. */
	private void react_main_region_SearchingBarman_SearchingBarman_SearchingRight() {
		if (check_main_region_SearchingBarman_SearchingBarman_SearchingRight_tr0_tr0()) {
			effect_main_region_SearchingBarman_SearchingBarman_SearchingRight_tr0();
		} else {
			if (check_main_region_SearchingBarman_SearchingBarman_SearchingRight_tr1_tr1()) {
				effect_main_region_SearchingBarman_SearchingBarman_SearchingRight_tr1();
			}
		}
	}
	
	/* The reactions of state FoundRight. */
	private void react_main_region_SearchingBarman_SearchingBarman_FoundRight() {
		if (check_main_region_SearchingBarman_SearchingBarman_FoundRight_tr0_tr0()) {
			effect_main_region_SearchingBarman_SearchingBarman_FoundRight_tr0();
		}
	}
	
	/* The reactions of state NoBarmanFound. */
	private void react_main_region_SearchingBarman_SearchingBarman_NoBarmanFound() {
	}
	
	/* The reactions of state TiltCamera. */
	private void react_main_region_SearchingBarman_SearchingBarman_TiltCamera() {
		if (check_main_region_SearchingBarman_SearchingBarman_TiltCamera_tr0_tr0()) {
			effect_main_region_SearchingBarman_SearchingBarman_TiltCamera_tr0();
		}
	}
	
	/* The reactions of state SearchingLeft. */
	private void react_main_region_SearchingBarman_SearchingBarman_SearchingLeft() {
		if (check_main_region_SearchingBarman_SearchingBarman_SearchingLeft_tr0_tr0()) {
			effect_main_region_SearchingBarman_SearchingBarman_SearchingLeft_tr0();
		} else {
			if (check_main_region_SearchingBarman_SearchingBarman_SearchingLeft_tr1_tr1()) {
				effect_main_region_SearchingBarman_SearchingBarman_SearchingLeft_tr1();
			}
		}
	}
	
	/* The reactions of state FoundLeft. */
	private void react_main_region_SearchingBarman_SearchingBarman_FoundLeft() {
		if (check_main_region_SearchingBarman_SearchingBarman_FoundLeft_tr0_tr0()) {
			effect_main_region_SearchingBarman_SearchingBarman_FoundLeft_tr0();
		}
	}
	
	/* The reactions of state Default. */
	private void react_main_region_SearchingBarman_SearchingBarman_Default() {
		if (check_main_region_SearchingBarman_SearchingBarman_Default_tr0_tr0()) {
			effect_main_region_SearchingBarman_SearchingBarman_Default_tr0();
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
	private void react_main_region__choice_0() {
		if (check_main_region__choice_0_tr0_tr0()) {
			effect_main_region__choice_0_tr0();
		} else {
			effect_main_region__choice_0_tr1();
		}
	}
	
	/* The reactions of state null. */
	private void react_main_region__choice_1() {
		effect_main_region__choice_1_tr1();
	}
	
	/* Default react sequence for initial entry  */
	private void react_main_region__entry_Default() {
		enterSequence_main_region_Init_default();
	}
	
	/* Default react sequence for initial entry  */
	private void react_main_region_SearchingBarman_SearchingBarman__entry_Default() {
		enterSequence_main_region_SearchingBarman_SearchingBarman_SearchingForBarman_default();
	}
	
	/* Default react sequence for initial entry  */
	private void react_Leonie_Bupered_Or_Emergency_Stop__entry_Default() {
		enterSequence_Leonie_Bupered_Or_Emergency_Stop_waitForEvent_default();
	}
	
	/* The reactions of exit exit_done. */
	private void react_main_region_SearchingBarman_SearchingBarman_exit_done() {
		effect_main_region_SearchingBarman_tr0();
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
			case main_region_Ready:
				react_main_region_Ready();
				break;
			case main_region_Turn:
				react_main_region_Turn();
				break;
			case main_region_SearchWave:
				react_main_region_SearchWave();
				break;
			case main_region_AnnounceGetWaving:
				react_main_region_AnnounceGetWaving();
				break;
			case main_region_WaitForOperator:
				react_main_region_WaitForOperator();
				break;
			case main_region_LeonieChoosen:
				react_main_region_LeonieChoosen();
				break;
			case main_region_Wait:
				react_main_region_Wait();
				break;
			case main_region_GoToWavingPerson:
				react_main_region_GoToWavingPerson();
				break;
			case main_region_TakeTheOrder:
				react_main_region_TakeTheOrder();
				break;
			case main_region_GetOrder:
				react_main_region_GetOrder();
				break;
			case main_region_DriveToKitchen:
				react_main_region_DriveToKitchen();
				break;
			case main_region_ArrivedKitchen:
				react_main_region_ArrivedKitchen();
				break;
			case main_region_WaitForTray:
				react_main_region_WaitForTray();
				break;
			case main_region_GoToBar:
				react_main_region_GoToBar();
				break;
			case main_region_AnnounceReady:
				react_main_region_AnnounceReady();
				break;
			case main_region_Answer:
				react_main_region_Answer();
				break;
			case main_region_Stop:
				react_main_region_Stop();
				break;
			case main_region_Serve:
				react_main_region_Serve();
				break;
			case main_region__final_:
				react_main_region__final_();
				break;
			case main_region_SearchingBarman_SearchingBarman_SearchingForBarman:
				react_main_region_SearchingBarman_SearchingBarman_SearchingForBarman();
				break;
			case main_region_SearchingBarman_SearchingBarman_SearchingRight:
				react_main_region_SearchingBarman_SearchingBarman_SearchingRight();
				break;
			case main_region_SearchingBarman_SearchingBarman_FoundRight:
				react_main_region_SearchingBarman_SearchingBarman_FoundRight();
				break;
			case main_region_SearchingBarman_SearchingBarman_NoBarmanFound:
				react_main_region_SearchingBarman_SearchingBarman_NoBarmanFound();
				break;
			case main_region_SearchingBarman_SearchingBarman_TiltCamera:
				react_main_region_SearchingBarman_SearchingBarman_TiltCamera();
				break;
			case main_region_SearchingBarman_SearchingBarman_SearchingLeft:
				react_main_region_SearchingBarman_SearchingBarman_SearchingLeft();
				break;
			case main_region_SearchingBarman_SearchingBarman_FoundLeft:
				react_main_region_SearchingBarman_SearchingBarman_FoundLeft();
				break;
			case main_region_SearchingBarman_SearchingBarman_Default:
				react_main_region_SearchingBarman_SearchingBarman_Default();
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
