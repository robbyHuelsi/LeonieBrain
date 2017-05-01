package org.yakindu.scr.helpmecarry;
import org.yakindu.scr.ITimer;

public class HelpMeCarryStatemachine implements IHelpMeCarryStatemachine {

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
		
		private boolean wavingDetected;
		
		public void raiseWavingDetected() {
			wavingDetected = true;
		}
		
		protected void clearEvents() {
			noiseDetected = false;
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
	
	private boolean initialized = false;
	
	public enum State {
		main_region_Detection,
		main_region_NotFound,
		main_region_Found,
		main_region_StartTracking,
		main_region_StartTracking_WaitingForStopCommand_STToff,
		main_region_StartTracking_WaitingForStopCommand_STTstart,
		main_region_Wave,
		main_region_Wave__region0_TrackingOffAndTurn,
		main_region_Wave__region0_WaveFound,
		main_region_Wave__region0_Turn,
		main_region_Wave__region0_DetectionOn,
		main_region_Wave__region0_PersonFound,
		main_region_HowCanIHelpYou,
		main_region_HowCanIHelpYou_main_region_StateA,
		main_region_HowCanIHelpYou_main_region_StartSTT,
		main_region_HowCanIHelpYou_main_region_TellAnswer,
		main_region_HowCanIHelpYou_main_region_StopSTT,
		main_region_HowCanIHelpYou_main_region_TellIncomprehensible,
		main_region_ArrivedWaypoint,
		main_region__final_,
		main_region_StartSTT,
		main_region_StopSTT,
		main_region_FollowYes,
		main_region_FollowNo,
		main_region_GoTo,
		main_region_GoTo_goto_kitchen,
		main_region_GoTo_goto_livingroom,
		main_region_GoTo_goto_room3,
		main_region_LocationNotFound,
		main_region_DetectionOn,
		main_region_LockingForNextOperator,
		main_region_Wait,
		main_region_MoveBodyRight,
		main_region_PersonFound,
		main_region_MoveBodyLeft,
		main_region_GuideMe,
		$NullState$
	};
	
	private final State[] stateVector = new State[1];
	
	private int nextStateIndex;
	
	private ITimer timer;
	
	private final boolean[] timeEvents = new boolean[8];
	private long counter;
	
	protected void setCounter(long value) {
		counter = value;
	}
	
	protected long getCounter() {
		return counter;
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
	
	public HelpMeCarryStatemachine() {
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
		for (int i = 0; i < 1; i++) {
			stateVector[i] = State.$NullState$;
		}
		clearEvents();
		clearOutEvents();
		setCounter(0);
		
		setNameBuffer("");
		
		setQuestionCounter(0);
		
		setBodyMoved(false);
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
					main_region_StartTracking.ordinal()&& stateVector[0].ordinal() <= State.main_region_StartTracking_WaitingForStopCommand_STTstart.ordinal();
		case main_region_StartTracking_WaitingForStopCommand_STToff:
			return stateVector[0] == State.main_region_StartTracking_WaitingForStopCommand_STToff;
		case main_region_StartTracking_WaitingForStopCommand_STTstart:
			return stateVector[0] == State.main_region_StartTracking_WaitingForStopCommand_STTstart;
		case main_region_Wave:
			return stateVector[0].ordinal() >= State.
					main_region_Wave.ordinal()&& stateVector[0].ordinal() <= State.main_region_Wave__region0_PersonFound.ordinal();
		case main_region_Wave__region0_TrackingOffAndTurn:
			return stateVector[0] == State.main_region_Wave__region0_TrackingOffAndTurn;
		case main_region_Wave__region0_WaveFound:
			return stateVector[0] == State.main_region_Wave__region0_WaveFound;
		case main_region_Wave__region0_Turn:
			return stateVector[0] == State.main_region_Wave__region0_Turn;
		case main_region_Wave__region0_DetectionOn:
			return stateVector[0] == State.main_region_Wave__region0_DetectionOn;
		case main_region_Wave__region0_PersonFound:
			return stateVector[0] == State.main_region_Wave__region0_PersonFound;
		case main_region_HowCanIHelpYou:
			return stateVector[0].ordinal() >= State.
					main_region_HowCanIHelpYou.ordinal()&& stateVector[0].ordinal() <= State.main_region_HowCanIHelpYou_main_region_TellIncomprehensible.ordinal();
		case main_region_HowCanIHelpYou_main_region_StateA:
			return stateVector[0] == State.main_region_HowCanIHelpYou_main_region_StateA;
		case main_region_HowCanIHelpYou_main_region_StartSTT:
			return stateVector[0] == State.main_region_HowCanIHelpYou_main_region_StartSTT;
		case main_region_HowCanIHelpYou_main_region_TellAnswer:
			return stateVector[0] == State.main_region_HowCanIHelpYou_main_region_TellAnswer;
		case main_region_HowCanIHelpYou_main_region_StopSTT:
			return stateVector[0] == State.main_region_HowCanIHelpYou_main_region_StopSTT;
		case main_region_HowCanIHelpYou_main_region_TellIncomprehensible:
			return stateVector[0] == State.main_region_HowCanIHelpYou_main_region_TellIncomprehensible;
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
					main_region_GoTo.ordinal()&& stateVector[0].ordinal() <= State.main_region_GoTo_goto_room3.ordinal();
		case main_region_GoTo_goto_kitchen:
			return stateVector[0] == State.main_region_GoTo_goto_kitchen;
		case main_region_GoTo_goto_livingroom:
			return stateVector[0] == State.main_region_GoTo_goto_livingroom;
		case main_region_GoTo_goto_room3:
			return stateVector[0] == State.main_region_GoTo_goto_room3;
		case main_region_LocationNotFound:
			return stateVector[0] == State.main_region_LocationNotFound;
		case main_region_DetectionOn:
			return stateVector[0] == State.main_region_DetectionOn;
		case main_region_LockingForNextOperator:
			return stateVector[0] == State.main_region_LockingForNextOperator;
		case main_region_Wait:
			return stateVector[0] == State.main_region_Wait;
		case main_region_MoveBodyRight:
			return stateVector[0] == State.main_region_MoveBodyRight;
		case main_region_PersonFound:
			return stateVector[0] == State.main_region_PersonFound;
		case main_region_MoveBodyLeft:
			return stateVector[0] == State.main_region_MoveBodyLeft;
		case main_region_GuideMe:
			return stateVector[0] == State.main_region_GuideMe;
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
	
	private boolean check_main_region_StartTracking_tr0_tr0() {
		return sCIFollowMe.trackingPersonLost;
	}
	
	private boolean check_main_region_StartTracking_WaitingForStopCommand_STToff_tr0_tr0() {
		return sCISTT.actionReceived;
	}
	
	private boolean check_main_region_StartTracking_WaitingForStopCommand_STToff_tr1_tr1() {
		return timeEvents[1];
	}
	
	private boolean check_main_region_StartTracking_WaitingForStopCommand_STTstart_tr0_tr0() {
		return timeEvents[2];
	}
	
	private boolean check_main_region_StartTracking_WaitingForStopCommand_STTstart_tr1_tr1() {
		return sCISTT.actionReceived;
	}
	
	private boolean check_main_region_Wave__region0_TrackingOffAndTurn_tr0_tr0() {
		return timeEvents[3];
	}
	
	private boolean check_main_region_Wave__region0_WaveFound_tr0_tr0() {
		return timeEvents[4];
	}
	
	private boolean check_main_region_Wave__region0_Turn_tr0_tr0() {
		return sCIKinect2.wavingDetected;
	}
	
	private boolean check_main_region_Wave__region0_DetectionOn_tr0_tr0() {
		return sCIFollowMe.detectionPersonFound;
	}
	
	private boolean check_main_region_Wave__region0_PersonFound_tr0_tr0() {
		return true;
	}
	
	private boolean check_main_region_HowCanIHelpYou_main_region_StateA_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_main_region_HowCanIHelpYou_main_region_StartSTT_tr0_tr0() {
		return sCISTT.answerReceived;
	}
	
	private boolean check_main_region_HowCanIHelpYou_main_region_StartSTT_tr1_tr1() {
		return sCISTT.incomprehensible;
	}
	
	private boolean check_main_region_HowCanIHelpYou_main_region_StartSTT_tr2_tr2() {
		return sCISTT.actionReceived;
	}
	
	private boolean check_main_region_HowCanIHelpYou_main_region_TellAnswer_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_main_region_HowCanIHelpYou_main_region_StopSTT_tr0_tr0() {
		return true;
	}
	
	private boolean check_main_region_HowCanIHelpYou_main_region_TellIncomprehensible_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_main_region_ArrivedWaypoint_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_main_region_StartSTT_tr0_tr0() {
		return timeEvents[5];
	}
	
	private boolean check_main_region_StopSTT_tr0_tr0() {
		return sCISTT.spokenTextReceived;
	}
	
	private boolean check_main_region_FollowYes_tr0_tr0() {
		return true;
	}
	
	private boolean check_main_region_FollowNo_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_main_region_GoTo_tr0_tr0() {
		return sCIMira.arrivedWP;
	}
	
	private boolean check_main_region_LocationNotFound_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_main_region_DetectionOn_tr0_tr0() {
		return true;
	}
	
	private boolean check_main_region_LockingForNextOperator_tr0_tr0() {
		return timeEvents[6];
	}
	
	private boolean check_main_region_MoveBodyRight_tr0_tr0() {
		return true;
	}
	
	private boolean check_main_region_PersonFound_tr0_tr0() {
		return timeEvents[7];
	}
	
	private boolean check_main_region_MoveBodyLeft_tr0_tr0() {
		return true;
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
	
	private boolean check_main_region__choice_0_tr0_tr0() {
		return (sCISTT.operationCallback.getSpokenText()== null?"yes" ==null :sCISTT.operationCallback.getSpokenText().equals("yes"));
	}
	
	private boolean check_main_region__choice_0_tr1_tr1() {
		return true;
	}
	
	private boolean check_main_region_GoTo_goto__choice_0_tr0_tr0() {
		return (sCISTT.operationCallback.getObject()== null?"kitchen" ==null :sCISTT.operationCallback.getObject().equals("kitchen"));
	}
	
	private boolean check_main_region_GoTo_goto__choice_0_tr1_tr1() {
		return (sCISTT.operationCallback.getObject()== null?"room3" ==null :sCISTT.operationCallback.getObject().equals("room3"));
	}
	
	private boolean check_main_region_GoTo_goto__choice_0_tr2_tr2() {
		return (sCISTT.operationCallback.getObject()== null?"liningroom" ==null :sCISTT.operationCallback.getObject().equals("liningroom"));
	}
	
	private boolean check_main_region_GoTo_goto__choice_0_tr3_tr3() {
		return true;
	}
	
	private boolean check_main_region__choice_1_tr0_tr0() {
		return getBodyMoved()==false;
	}
	
	private boolean check_main_region__choice_1_tr1_tr1() {
		return sCIFollowMe.detectionPersonFound;
	}
	
	private boolean check_main_region__choice_1_tr2_tr2() {
		return getBodyMoved();
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
	
	private void effect_main_region_StartTracking_tr0() {
		exitSequence_main_region_StartTracking();
		enterSequence_main_region_Wave_default();
	}
	
	private void effect_main_region_StartTracking_tr1() {
		exitSequence_main_region_StartTracking();
		enterSequence_main_region_HowCanIHelpYou_default();
	}
	
	private void effect_main_region_StartTracking_WaitingForStopCommand_STToff_tr0() {
		exitSequence_main_region_StartTracking_WaitingForStopCommand_STToff();
		react_main_region_StartTracking_WaitingForStopCommand__choice_0();
	}
	
	private void effect_main_region_StartTracking_WaitingForStopCommand_STToff_tr1() {
		exitSequence_main_region_StartTracking_WaitingForStopCommand_STToff();
		enterSequence_main_region_StartTracking_WaitingForStopCommand_STTstart_default();
	}
	
	private void effect_main_region_StartTracking_WaitingForStopCommand_STTstart_tr0() {
		exitSequence_main_region_StartTracking_WaitingForStopCommand_STTstart();
		enterSequence_main_region_StartTracking_WaitingForStopCommand_STToff_default();
	}
	
	private void effect_main_region_StartTracking_WaitingForStopCommand_STTstart_tr1() {
		exitSequence_main_region_StartTracking_WaitingForStopCommand_STTstart();
		react_main_region_StartTracking_WaitingForStopCommand__choice_0();
	}
	
	private void effect_main_region_Wave_tr0() {
		exitSequence_main_region_Wave();
		enterSequence_main_region_StartTracking_default();
	}
	
	private void effect_main_region_Wave__region0_TrackingOffAndTurn_tr0() {
		exitSequence_main_region_Wave__region0_TrackingOffAndTurn();
		enterSequence_main_region_Wave__region0_Turn_default();
	}
	
	private void effect_main_region_Wave__region0_WaveFound_tr0() {
		exitSequence_main_region_Wave__region0_WaveFound();
		enterSequence_main_region_Wave__region0_DetectionOn_default();
	}
	
	private void effect_main_region_Wave__region0_Turn_tr0() {
		exitSequence_main_region_Wave__region0_Turn();
		enterSequence_main_region_Wave__region0_WaveFound_default();
	}
	
	private void effect_main_region_Wave__region0_DetectionOn_tr0() {
		exitSequence_main_region_Wave__region0_DetectionOn();
		enterSequence_main_region_Wave__region0_PersonFound_default();
	}
	
	private void effect_main_region_Wave__region0_PersonFound_tr0() {
		exitSequence_main_region_Wave__region0_PersonFound();
		react_main_region_Wave__region0_exit_done();
	}
	
	private void effect_main_region_HowCanIHelpYou_tr0() {
		exitSequence_main_region_HowCanIHelpYou();
		enterSequence_main_region_GoTo_default();
	}
	
	private void effect_main_region_HowCanIHelpYou_main_region_StateA_tr0() {
		exitSequence_main_region_HowCanIHelpYou_main_region_StateA();
		enterSequence_main_region_HowCanIHelpYou_main_region_StartSTT_default();
	}
	
	private void effect_main_region_HowCanIHelpYou_main_region_StartSTT_tr0() {
		exitSequence_main_region_HowCanIHelpYou_main_region_StartSTT();
		enterSequence_main_region_HowCanIHelpYou_main_region_TellAnswer_default();
	}
	
	private void effect_main_region_HowCanIHelpYou_main_region_StartSTT_tr1() {
		exitSequence_main_region_HowCanIHelpYou_main_region_StartSTT();
		enterSequence_main_region_HowCanIHelpYou_main_region_TellIncomprehensible_default();
	}
	
	private void effect_main_region_HowCanIHelpYou_main_region_StartSTT_tr2() {
		exitSequence_main_region_HowCanIHelpYou_main_region_StartSTT();
		react_main_region_HowCanIHelpYou_main_region__choice_0();
	}
	
	private void effect_main_region_HowCanIHelpYou_main_region_TellAnswer_tr0() {
		exitSequence_main_region_HowCanIHelpYou_main_region_TellAnswer();
		enterSequence_main_region_HowCanIHelpYou_main_region_StopSTT_default();
	}
	
	private void effect_main_region_HowCanIHelpYou_main_region_StopSTT_tr0() {
		exitSequence_main_region_HowCanIHelpYou_main_region_StopSTT();
		enterSequence_main_region_HowCanIHelpYou_main_region_StateA_default();
	}
	
	private void effect_main_region_HowCanIHelpYou_main_region_TellIncomprehensible_tr0() {
		exitSequence_main_region_HowCanIHelpYou_main_region_TellIncomprehensible();
		enterSequence_main_region_HowCanIHelpYou_main_region_StopSTT_default();
	}
	
	private void effect_main_region_ArrivedWaypoint_tr0() {
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
	
	private void effect_main_region_FollowYes_tr0() {
		exitSequence_main_region_FollowYes();
		enterSequence_main_region_StartTracking_default();
	}
	
	private void effect_main_region_FollowNo_tr0() {
		exitSequence_main_region_FollowNo();
		enterSequence_main_region_Detection_default();
	}
	
	private void effect_main_region_GoTo_tr0() {
		exitSequence_main_region_GoTo();
		enterSequence_main_region_ArrivedWaypoint_default();
	}
	
	private void effect_main_region_GoTo_tr1() {
		exitSequence_main_region_GoTo();
		enterSequence_main_region_LocationNotFound_default();
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
		enterSequence_main_region_Wait_default();
	}
	
	private void effect_main_region_MoveBodyRight_tr0() {
		exitSequence_main_region_MoveBodyRight();
		enterSequence_main_region_LockingForNextOperator_default();
	}
	
	private void effect_main_region_PersonFound_tr0() {
		exitSequence_main_region_PersonFound();
		enterSequence_main_region_GuideMe_default();
	}
	
	private void effect_main_region_MoveBodyLeft_tr0() {
		exitSequence_main_region_MoveBodyLeft();
		enterSequence_main_region_LockingForNextOperator_default();
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
		enterSequence_main_region_HowCanIHelpYou_main_region_StopSTT_default();
	}
	
	private void effect_main_region__choice_0_tr0() {
		enterSequence_main_region_FollowYes_default();
	}
	
	private void effect_main_region__choice_0_tr1() {
		enterSequence_main_region_FollowNo_default();
	}
	
	private void effect_main_region_GoTo_goto__choice_0_tr0() {
		enterSequence_main_region_GoTo_goto_kitchen_default();
	}
	
	private void effect_main_region_GoTo_goto__choice_0_tr1() {
		enterSequence_main_region_GoTo_goto_room3_default();
	}
	
	private void effect_main_region_GoTo_goto__choice_0_tr2() {
		enterSequence_main_region_GoTo_goto_livingroom_default();
	}
	
	private void effect_main_region_GoTo_goto__choice_0_tr3() {
		react_main_region_GoTo_goto_exit_notFound();
	}
	
	private void effect_main_region__choice_1_tr0() {
		enterSequence_main_region_MoveBodyRight_default();
	}
	
	private void effect_main_region__choice_1_tr1() {
		enterSequence_main_region_PersonFound_default();
	}
	
	private void effect_main_region__choice_1_tr2() {
		enterSequence_main_region_MoveBodyLeft_default();
	}
	
	/* Entry action for state 'Detection'. */
	private void entryAction_main_region_Detection() {
		timer.setTimer(this, 0, 1 * 1000, false);
		
		sCIFollowMe.operationCallback.sendRequestDetectionDetails();
		
		setCounter(counter + 1);
	}
	
	/* Entry action for state 'NotFound'. */
	private void entryAction_main_region_NotFound() {
		sCIHBrain.operationCallback.sendTTS("[:-(] I want to follow somebody, but nobody is here!");
		
		setCounter(0);
	}
	
	/* Entry action for state 'Found'. */
	private void entryAction_main_region_Found() {
		sCIHBrain.operationCallback.sendTTS("[:-)] Hello! Should I follow?");
	}
	
	/* Entry action for state 'StartTracking'. */
	private void entryAction_main_region_StartTracking() {
		sCIFollowMe.operationCallback.sendTrackingOnAtNext();
	}
	
	/* Entry action for state 'STToff'. */
	private void entryAction_main_region_StartTracking_WaitingForStopCommand_STToff() {
		timer.setTimer(this, 1, 5 * 1000, false);
		
		sCISTT.operationCallback.sendSpeechDetectionOff();
	}
	
	/* Entry action for state 'STTstart'. */
	private void entryAction_main_region_StartTracking_WaitingForStopCommand_STTstart() {
		timer.setTimer(this, 2, 5 * 1000, false);
		
		sCISTT.operationCallback.sendSpeechDetectionSmalltalk();
	}
	
	/* Entry action for state 'TrackingOffAndTurn'. */
	private void entryAction_main_region_Wave__region0_TrackingOffAndTurn() {
		timer.setTimer(this, 3, 1 * 1000, false);
		
		sCIFollowMe.operationCallback.sendTrackingOff();
		
		sCIHBrain.operationCallback.sendTTS("[-.-] I lost you!{-180;0}");
		
		sCIMira.operationCallback.sendBodyUTurn();
	}
	
	/* Entry action for state 'WaveFound'. */
	private void entryAction_main_region_Wave__region0_WaveFound() {
		timer.setTimer(this, 4, 1 * 1000, false);
		
		sCIHBrain.operationCallback.sendTTS("{Person}Thank you! Please hold on.");
		
		sCIMira.operationCallback.sendBodyUTurn();
	}
	
	/* Entry action for state 'Turn'. */
	private void entryAction_main_region_Wave__region0_Turn() {
		sCIKinect2.operationCallback.sendWavingDetectionOnOff(true);
		
		sCIHBrain.operationCallback.sendTTS("[:-|] Please wave for me.");
	}
	
	/* Entry action for state 'DetectionOn'. */
	private void entryAction_main_region_Wave__region0_DetectionOn() {
		sCIFollowMe.operationCallback.sendDetectionOn();
	}
	
	/* Entry action for state 'PersonFound'. */
	private void entryAction_main_region_Wave__region0_PersonFound() {
		sCIHBrain.operationCallback.sendTTS("[:-)] Okay, let's go on!");
	}
	
	/* Entry action for state 'HowCanIHelpYou'. */
	private void entryAction_main_region_HowCanIHelpYou() {
		sCIFollowMe.operationCallback.sendTrackingOff();
		
		sCIFollowMe.operationCallback.sendDetectionOff();
	}
	
	/* Entry action for state 'StateA'. */
	private void entryAction_main_region_HowCanIHelpYou_main_region_StateA() {
		sCIHBrain.operationCallback.sendTTS("[:-)] How can I help you?");
	}
	
	/* Entry action for state 'StartSTT'. */
	private void entryAction_main_region_HowCanIHelpYou_main_region_StartSTT() {
		sCISTT.operationCallback.sendSpeechDetectionSmalltalk();
	}
	
	/* Entry action for state 'TellAnswer'. */
	private void entryAction_main_region_HowCanIHelpYou_main_region_TellAnswer() {
		sCIHBrain.operationCallback.sendTTS(sCISTT.operationCallback.getAnswer());
	}
	
	/* Entry action for state 'StopSTT'. */
	private void entryAction_main_region_HowCanIHelpYou_main_region_StopSTT() {
		sCISTT.operationCallback.sendSpeechDetectionOff();
	}
	
	/* Entry action for state 'TellIncomprehensible'. */
	private void entryAction_main_region_HowCanIHelpYou_main_region_TellIncomprehensible() {
		sCIHBrain.operationCallback.sendTTS(sCISTT.operationCallback.getAnswer());
	}
	
	/* Entry action for state 'ArrivedWaypoint'. */
	private void entryAction_main_region_ArrivedWaypoint() {
		sCIHBrain.operationCallback.sendTTS("I'm there. Please take the groceries.");
	}
	
	/* Entry action for state 'StartSTT'. */
	private void entryAction_main_region_StartSTT() {
		timer.setTimer(this, 5, 3 * 1000, false);
		
		sCISTT.operationCallback.sendSpeechDetectionYesNo();
	}
	
	/* Entry action for state 'StopSTT'. */
	private void entryAction_main_region_StopSTT() {
		sCISTT.operationCallback.sendSpeechDetectionOff();
	}
	
	/* Entry action for state 'FollowYes'. */
	private void entryAction_main_region_FollowYes() {
		sCIHBrain.operationCallback.sendTTS("[attentive] Okay. I come with you.");
	}
	
	/* Entry action for state 'FollowNo'. */
	private void entryAction_main_region_FollowNo() {
		sCIHBrain.operationCallback.sendTTS("[:-(] Okay. I'm looking for another person.");
	}
	
	/* Entry action for state 'kitchen'. */
	private void entryAction_main_region_GoTo_goto_kitchen() {
		sCIMira.operationCallback.sendGoToGWP(2);
	}
	
	/* Entry action for state 'livingroom'. */
	private void entryAction_main_region_GoTo_goto_livingroom() {
		sCIMira.operationCallback.sendGoToGWP(0);
	}
	
	/* Entry action for state 'room3'. */
	private void entryAction_main_region_GoTo_goto_room3() {
		sCIMira.operationCallback.sendGoToGWP(0);
	}
	
	/* Entry action for state 'LocationNotFound'. */
	private void entryAction_main_region_LocationNotFound() {
		sCIHBrain.operationCallback.sendTTS3("[:-(] Sorry, I don't know a location like ", sCISTT.operationCallback.getObject(), ".");
	}
	
	/* Entry action for state 'DetectionOn'. */
	private void entryAction_main_region_DetectionOn() {
		sCIFollowMe.operationCallback.sendDetectionOn();
		
		sCIHBrain.operationCallback.sendTTS("[:-|]");
		
		setCounter(0);
	}
	
	/* Entry action for state 'LockingForNextOperator'. */
	private void entryAction_main_region_LockingForNextOperator() {
		timer.setTimer(this, 6, 3 * 1000, false);
		
		sCIFollowMe.operationCallback.sendDetectionOn();
	}
	
	/* Entry action for state 'MoveBodyRight'. */
	private void entryAction_main_region_MoveBodyRight() {
		sCIMira.operationCallback.sendPanCamera(20);
	}
	
	/* Entry action for state 'PersonFound'. */
	private void entryAction_main_region_PersonFound() {
		timer.setTimer(this, 7, 5 * 1000, false);
		
		sCIHBrain.operationCallback.sendTTS("Hello. Can you take the groceries please? I want you to follow me to the car.");
	}
	
	/* Entry action for state 'MoveBodyLeft'. */
	private void entryAction_main_region_MoveBodyLeft() {
		sCIMira.operationCallback.sendPanCamera(-20);
	}
	
	/* Entry action for state 'GuideMe'. */
	private void entryAction_main_region_GuideMe() {
		sCIHBrain.operationCallback.sendTTS("Guide me...");
	}
	
	/* Exit action for state 'Detection'. */
	private void exitAction_main_region_Detection() {
		timer.unsetTimer(this, 0);
	}
	
	/* Exit action for state 'STToff'. */
	private void exitAction_main_region_StartTracking_WaitingForStopCommand_STToff() {
		timer.unsetTimer(this, 1);
	}
	
	/* Exit action for state 'STTstart'. */
	private void exitAction_main_region_StartTracking_WaitingForStopCommand_STTstart() {
		timer.unsetTimer(this, 2);
	}
	
	/* Exit action for state 'TrackingOffAndTurn'. */
	private void exitAction_main_region_Wave__region0_TrackingOffAndTurn() {
		timer.unsetTimer(this, 3);
	}
	
	/* Exit action for state 'WaveFound'. */
	private void exitAction_main_region_Wave__region0_WaveFound() {
		timer.unsetTimer(this, 4);
	}
	
	/* Exit action for state 'StartSTT'. */
	private void exitAction_main_region_StartSTT() {
		timer.unsetTimer(this, 5);
	}
	
	/* Exit action for state 'LockingForNextOperator'. */
	private void exitAction_main_region_LockingForNextOperator() {
		timer.unsetTimer(this, 6);
	}
	
	/* Exit action for state 'PersonFound'. */
	private void exitAction_main_region_PersonFound() {
		timer.unsetTimer(this, 7);
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
	
	/* 'default' enter sequence for state Wave */
	private void enterSequence_main_region_Wave_default() {
		enterSequence_main_region_Wave__region0_default();
	}
	
	/* 'default' enter sequence for state TrackingOffAndTurn */
	private void enterSequence_main_region_Wave__region0_TrackingOffAndTurn_default() {
		entryAction_main_region_Wave__region0_TrackingOffAndTurn();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_Wave__region0_TrackingOffAndTurn;
	}
	
	/* 'default' enter sequence for state WaveFound */
	private void enterSequence_main_region_Wave__region0_WaveFound_default() {
		entryAction_main_region_Wave__region0_WaveFound();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_Wave__region0_WaveFound;
	}
	
	/* 'default' enter sequence for state Turn */
	private void enterSequence_main_region_Wave__region0_Turn_default() {
		entryAction_main_region_Wave__region0_Turn();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_Wave__region0_Turn;
	}
	
	/* 'default' enter sequence for state DetectionOn */
	private void enterSequence_main_region_Wave__region0_DetectionOn_default() {
		entryAction_main_region_Wave__region0_DetectionOn();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_Wave__region0_DetectionOn;
	}
	
	/* 'default' enter sequence for state PersonFound */
	private void enterSequence_main_region_Wave__region0_PersonFound_default() {
		entryAction_main_region_Wave__region0_PersonFound();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_Wave__region0_PersonFound;
	}
	
	/* 'default' enter sequence for state HowCanIHelpYou */
	private void enterSequence_main_region_HowCanIHelpYou_default() {
		entryAction_main_region_HowCanIHelpYou();
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
	
	/* 'default' enter sequence for state StopSTT */
	private void enterSequence_main_region_HowCanIHelpYou_main_region_StopSTT_default() {
		entryAction_main_region_HowCanIHelpYou_main_region_StopSTT();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_HowCanIHelpYou_main_region_StopSTT;
	}
	
	/* 'default' enter sequence for state TellIncomprehensible */
	private void enterSequence_main_region_HowCanIHelpYou_main_region_TellIncomprehensible_default() {
		entryAction_main_region_HowCanIHelpYou_main_region_TellIncomprehensible();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_HowCanIHelpYou_main_region_TellIncomprehensible;
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
	
	/* 'default' enter sequence for state kitchen */
	private void enterSequence_main_region_GoTo_goto_kitchen_default() {
		entryAction_main_region_GoTo_goto_kitchen();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_GoTo_goto_kitchen;
	}
	
	/* 'default' enter sequence for state livingroom */
	private void enterSequence_main_region_GoTo_goto_livingroom_default() {
		entryAction_main_region_GoTo_goto_livingroom();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_GoTo_goto_livingroom;
	}
	
	/* 'default' enter sequence for state room3 */
	private void enterSequence_main_region_GoTo_goto_room3_default() {
		entryAction_main_region_GoTo_goto_room3();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_GoTo_goto_room3;
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
	
	/* 'default' enter sequence for state Wait */
	private void enterSequence_main_region_Wait_default() {
		nextStateIndex = 0;
		stateVector[0] = State.main_region_Wait;
	}
	
	/* 'default' enter sequence for state MoveBodyRight */
	private void enterSequence_main_region_MoveBodyRight_default() {
		entryAction_main_region_MoveBodyRight();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_MoveBodyRight;
	}
	
	/* 'default' enter sequence for state PersonFound */
	private void enterSequence_main_region_PersonFound_default() {
		entryAction_main_region_PersonFound();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_PersonFound;
	}
	
	/* 'default' enter sequence for state MoveBodyLeft */
	private void enterSequence_main_region_MoveBodyLeft_default() {
		entryAction_main_region_MoveBodyLeft();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_MoveBodyLeft;
	}
	
	/* 'default' enter sequence for state GuideMe */
	private void enterSequence_main_region_GuideMe_default() {
		entryAction_main_region_GuideMe();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_GuideMe;
	}
	
	/* 'default' enter sequence for region main region */
	private void enterSequence_main_region_default() {
		react_main_region__entry_Default();
	}
	
	/* 'default' enter sequence for region WaitingForStopCommand */
	private void enterSequence_main_region_StartTracking_WaitingForStopCommand_default() {
		react_main_region_StartTracking_WaitingForStopCommand__entry_Default();
	}
	
	/* 'default' enter sequence for region null */
	private void enterSequence_main_region_Wave__region0_default() {
		react_main_region_Wave__region0__entry_Default();
	}
	
	/* 'default' enter sequence for region main region */
	private void enterSequence_main_region_HowCanIHelpYou_main_region_default() {
		react_main_region_HowCanIHelpYou_main_region__entry_Default();
	}
	
	/* 'default' enter sequence for region goto */
	private void enterSequence_main_region_GoTo_goto_default() {
		react_main_region_GoTo_goto__entry_Default();
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
	
	/* Default exit sequence for state Wave */
	private void exitSequence_main_region_Wave() {
		exitSequence_main_region_Wave__region0();
	}
	
	/* Default exit sequence for state TrackingOffAndTurn */
	private void exitSequence_main_region_Wave__region0_TrackingOffAndTurn() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
		
		exitAction_main_region_Wave__region0_TrackingOffAndTurn();
	}
	
	/* Default exit sequence for state WaveFound */
	private void exitSequence_main_region_Wave__region0_WaveFound() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
		
		exitAction_main_region_Wave__region0_WaveFound();
	}
	
	/* Default exit sequence for state Turn */
	private void exitSequence_main_region_Wave__region0_Turn() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state DetectionOn */
	private void exitSequence_main_region_Wave__region0_DetectionOn() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state PersonFound */
	private void exitSequence_main_region_Wave__region0_PersonFound() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state HowCanIHelpYou */
	private void exitSequence_main_region_HowCanIHelpYou() {
		exitSequence_main_region_HowCanIHelpYou_main_region();
	}
	
	/* Default exit sequence for state StateA */
	private void exitSequence_main_region_HowCanIHelpYou_main_region_StateA() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state StartSTT */
	private void exitSequence_main_region_HowCanIHelpYou_main_region_StartSTT() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state TellAnswer */
	private void exitSequence_main_region_HowCanIHelpYou_main_region_TellAnswer() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state StopSTT */
	private void exitSequence_main_region_HowCanIHelpYou_main_region_StopSTT() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state TellIncomprehensible */
	private void exitSequence_main_region_HowCanIHelpYou_main_region_TellIncomprehensible() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state ArrivedWaypoint */
	private void exitSequence_main_region_ArrivedWaypoint() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
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
	}
	
	/* Default exit sequence for state GoTo */
	private void exitSequence_main_region_GoTo() {
		exitSequence_main_region_GoTo_goto();
	}
	
	/* Default exit sequence for state kitchen */
	private void exitSequence_main_region_GoTo_goto_kitchen() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state livingroom */
	private void exitSequence_main_region_GoTo_goto_livingroom() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state room3 */
	private void exitSequence_main_region_GoTo_goto_room3() {
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
	
	/* Default exit sequence for state Wait */
	private void exitSequence_main_region_Wait() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state MoveBodyRight */
	private void exitSequence_main_region_MoveBodyRight() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state PersonFound */
	private void exitSequence_main_region_PersonFound() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
		
		exitAction_main_region_PersonFound();
	}
	
	/* Default exit sequence for state MoveBodyLeft */
	private void exitSequence_main_region_MoveBodyLeft() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state GuideMe */
	private void exitSequence_main_region_GuideMe() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
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
		case main_region_Wave__region0_TrackingOffAndTurn:
			exitSequence_main_region_Wave__region0_TrackingOffAndTurn();
			break;
		case main_region_Wave__region0_WaveFound:
			exitSequence_main_region_Wave__region0_WaveFound();
			break;
		case main_region_Wave__region0_Turn:
			exitSequence_main_region_Wave__region0_Turn();
			break;
		case main_region_Wave__region0_DetectionOn:
			exitSequence_main_region_Wave__region0_DetectionOn();
			break;
		case main_region_Wave__region0_PersonFound:
			exitSequence_main_region_Wave__region0_PersonFound();
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
		case main_region_HowCanIHelpYou_main_region_StopSTT:
			exitSequence_main_region_HowCanIHelpYou_main_region_StopSTT();
			break;
		case main_region_HowCanIHelpYou_main_region_TellIncomprehensible:
			exitSequence_main_region_HowCanIHelpYou_main_region_TellIncomprehensible();
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
		case main_region_GoTo_goto_kitchen:
			exitSequence_main_region_GoTo_goto_kitchen();
			break;
		case main_region_GoTo_goto_livingroom:
			exitSequence_main_region_GoTo_goto_livingroom();
			break;
		case main_region_GoTo_goto_room3:
			exitSequence_main_region_GoTo_goto_room3();
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
		case main_region_Wait:
			exitSequence_main_region_Wait();
			break;
		case main_region_MoveBodyRight:
			exitSequence_main_region_MoveBodyRight();
			break;
		case main_region_PersonFound:
			exitSequence_main_region_PersonFound();
			break;
		case main_region_MoveBodyLeft:
			exitSequence_main_region_MoveBodyLeft();
			break;
		case main_region_GuideMe:
			exitSequence_main_region_GuideMe();
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
		default:
			break;
		}
	}
	
	/* Default exit sequence for region null */
	private void exitSequence_main_region_Wave__region0() {
		switch (stateVector[0]) {
		case main_region_Wave__region0_TrackingOffAndTurn:
			exitSequence_main_region_Wave__region0_TrackingOffAndTurn();
			break;
		case main_region_Wave__region0_WaveFound:
			exitSequence_main_region_Wave__region0_WaveFound();
			break;
		case main_region_Wave__region0_Turn:
			exitSequence_main_region_Wave__region0_Turn();
			break;
		case main_region_Wave__region0_DetectionOn:
			exitSequence_main_region_Wave__region0_DetectionOn();
			break;
		case main_region_Wave__region0_PersonFound:
			exitSequence_main_region_Wave__region0_PersonFound();
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
		case main_region_HowCanIHelpYou_main_region_StopSTT:
			exitSequence_main_region_HowCanIHelpYou_main_region_StopSTT();
			break;
		case main_region_HowCanIHelpYou_main_region_TellIncomprehensible:
			exitSequence_main_region_HowCanIHelpYou_main_region_TellIncomprehensible();
			break;
		default:
			break;
		}
	}
	
	/* Default exit sequence for region goto */
	private void exitSequence_main_region_GoTo_goto() {
		switch (stateVector[0]) {
		case main_region_GoTo_goto_kitchen:
			exitSequence_main_region_GoTo_goto_kitchen();
			break;
		case main_region_GoTo_goto_livingroom:
			exitSequence_main_region_GoTo_goto_livingroom();
			break;
		case main_region_GoTo_goto_room3:
			exitSequence_main_region_GoTo_goto_room3();
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
		}
	}
	
	/* The reactions of state STToff. */
	private void react_main_region_StartTracking_WaitingForStopCommand_STToff() {
		if (check_main_region_StartTracking_tr0_tr0()) {
			effect_main_region_StartTracking_tr0();
		} else {
			if (check_main_region_StartTracking_WaitingForStopCommand_STToff_tr0_tr0()) {
				effect_main_region_StartTracking_WaitingForStopCommand_STToff_tr0();
			} else {
				if (check_main_region_StartTracking_WaitingForStopCommand_STToff_tr1_tr1()) {
					effect_main_region_StartTracking_WaitingForStopCommand_STToff_tr1();
				}
			}
		}
	}
	
	/* The reactions of state STTstart. */
	private void react_main_region_StartTracking_WaitingForStopCommand_STTstart() {
		if (check_main_region_StartTracking_tr0_tr0()) {
			effect_main_region_StartTracking_tr0();
		} else {
			if (check_main_region_StartTracking_WaitingForStopCommand_STTstart_tr0_tr0()) {
				effect_main_region_StartTracking_WaitingForStopCommand_STTstart_tr0();
			} else {
				if (check_main_region_StartTracking_WaitingForStopCommand_STTstart_tr1_tr1()) {
					effect_main_region_StartTracking_WaitingForStopCommand_STTstart_tr1();
				}
			}
		}
	}
	
	/* The reactions of state TrackingOffAndTurn. */
	private void react_main_region_Wave__region0_TrackingOffAndTurn() {
		if (check_main_region_Wave__region0_TrackingOffAndTurn_tr0_tr0()) {
			effect_main_region_Wave__region0_TrackingOffAndTurn_tr0();
		}
	}
	
	/* The reactions of state WaveFound. */
	private void react_main_region_Wave__region0_WaveFound() {
		if (check_main_region_Wave__region0_WaveFound_tr0_tr0()) {
			effect_main_region_Wave__region0_WaveFound_tr0();
		}
	}
	
	/* The reactions of state Turn. */
	private void react_main_region_Wave__region0_Turn() {
		if (check_main_region_Wave__region0_Turn_tr0_tr0()) {
			effect_main_region_Wave__region0_Turn_tr0();
		}
	}
	
	/* The reactions of state DetectionOn. */
	private void react_main_region_Wave__region0_DetectionOn() {
		if (check_main_region_Wave__region0_DetectionOn_tr0_tr0()) {
			effect_main_region_Wave__region0_DetectionOn_tr0();
		}
	}
	
	/* The reactions of state PersonFound. */
	private void react_main_region_Wave__region0_PersonFound() {
		effect_main_region_Wave__region0_PersonFound_tr0();
	}
	
	/* The reactions of state StateA. */
	private void react_main_region_HowCanIHelpYou_main_region_StateA() {
		if (check_main_region_HowCanIHelpYou_main_region_StateA_tr0_tr0()) {
			effect_main_region_HowCanIHelpYou_main_region_StateA_tr0();
		}
	}
	
	/* The reactions of state StartSTT. */
	private void react_main_region_HowCanIHelpYou_main_region_StartSTT() {
		if (check_main_region_HowCanIHelpYou_main_region_StartSTT_tr0_tr0()) {
			effect_main_region_HowCanIHelpYou_main_region_StartSTT_tr0();
		} else {
			if (check_main_region_HowCanIHelpYou_main_region_StartSTT_tr1_tr1()) {
				effect_main_region_HowCanIHelpYou_main_region_StartSTT_tr1();
			} else {
				if (check_main_region_HowCanIHelpYou_main_region_StartSTT_tr2_tr2()) {
					effect_main_region_HowCanIHelpYou_main_region_StartSTT_tr2();
				}
			}
		}
	}
	
	/* The reactions of state TellAnswer. */
	private void react_main_region_HowCanIHelpYou_main_region_TellAnswer() {
		if (check_main_region_HowCanIHelpYou_main_region_TellAnswer_tr0_tr0()) {
			effect_main_region_HowCanIHelpYou_main_region_TellAnswer_tr0();
		}
	}
	
	/* The reactions of state StopSTT. */
	private void react_main_region_HowCanIHelpYou_main_region_StopSTT() {
		effect_main_region_HowCanIHelpYou_main_region_StopSTT_tr0();
	}
	
	/* The reactions of state TellIncomprehensible. */
	private void react_main_region_HowCanIHelpYou_main_region_TellIncomprehensible() {
		if (check_main_region_HowCanIHelpYou_main_region_TellIncomprehensible_tr0_tr0()) {
			effect_main_region_HowCanIHelpYou_main_region_TellIncomprehensible_tr0();
		}
	}
	
	/* The reactions of state ArrivedWaypoint. */
	private void react_main_region_ArrivedWaypoint() {
		if (check_main_region_ArrivedWaypoint_tr0_tr0()) {
			effect_main_region_ArrivedWaypoint_tr0();
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
		}
	}
	
	/* The reactions of state kitchen. */
	private void react_main_region_GoTo_goto_kitchen() {
		if (check_main_region_GoTo_tr0_tr0()) {
			effect_main_region_GoTo_tr0();
		} else {
		}
	}
	
	/* The reactions of state livingroom. */
	private void react_main_region_GoTo_goto_livingroom() {
		if (check_main_region_GoTo_tr0_tr0()) {
			effect_main_region_GoTo_tr0();
		} else {
		}
	}
	
	/* The reactions of state room3. */
	private void react_main_region_GoTo_goto_room3() {
		if (check_main_region_GoTo_tr0_tr0()) {
			effect_main_region_GoTo_tr0();
		} else {
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
		}
	}
	
	/* The reactions of state Wait. */
	private void react_main_region_Wait() {
	}
	
	/* The reactions of state MoveBodyRight. */
	private void react_main_region_MoveBodyRight() {
		effect_main_region_MoveBodyRight_tr0();
	}
	
	/* The reactions of state PersonFound. */
	private void react_main_region_PersonFound() {
		if (check_main_region_PersonFound_tr0_tr0()) {
			effect_main_region_PersonFound_tr0();
		}
	}
	
	/* The reactions of state MoveBodyLeft. */
	private void react_main_region_MoveBodyLeft() {
		effect_main_region_MoveBodyLeft_tr0();
	}
	
	/* The reactions of state GuideMe. */
	private void react_main_region_GuideMe() {
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
	private void react_main_region__choice_0() {
		if (check_main_region__choice_0_tr0_tr0()) {
			effect_main_region__choice_0_tr0();
		} else {
			effect_main_region__choice_0_tr1();
		}
	}
	
	/* The reactions of state null. */
	private void react_main_region_GoTo_goto__choice_0() {
		if (check_main_region_GoTo_goto__choice_0_tr0_tr0()) {
			effect_main_region_GoTo_goto__choice_0_tr0();
		} else {
			if (check_main_region_GoTo_goto__choice_0_tr1_tr1()) {
				effect_main_region_GoTo_goto__choice_0_tr1();
			} else {
				if (check_main_region_GoTo_goto__choice_0_tr2_tr2()) {
					effect_main_region_GoTo_goto__choice_0_tr2();
				} else {
					effect_main_region_GoTo_goto__choice_0_tr3();
				}
			}
		}
	}
	
	/* The reactions of state null. */
	private void react_main_region__choice_1() {
		if (check_main_region__choice_1_tr0_tr0()) {
			effect_main_region__choice_1_tr0();
		} else {
			if (check_main_region__choice_1_tr1_tr1()) {
				effect_main_region__choice_1_tr1();
			} else {
				if (check_main_region__choice_1_tr2_tr2()) {
					effect_main_region__choice_1_tr2();
				}
			}
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
	private void react_main_region_Wave__region0__entry_Default() {
		enterSequence_main_region_Wave__region0_TrackingOffAndTurn_default();
	}
	
	/* Default react sequence for initial entry  */
	private void react_main_region_HowCanIHelpYou_main_region__entry_Default() {
		enterSequence_main_region_HowCanIHelpYou_main_region_StateA_default();
	}
	
	/* Default react sequence for initial entry  */
	private void react_main_region_GoTo_goto__entry_Default() {
		react_main_region_GoTo_goto__choice_0();
	}
	
	/* The reactions of exit exit_arrived. */
	private void react_main_region_StartTracking_WaitingForStopCommand_exit_arrived() {
		effect_main_region_StartTracking_tr1();
	}
	
	/* The reactions of exit exit_done. */
	private void react_main_region_Wave__region0_exit_done() {
		effect_main_region_Wave_tr0();
	}
	
	/* The reactions of exit exit_goto. */
	private void react_main_region_HowCanIHelpYou_main_region_exit_goto() {
		effect_main_region_HowCanIHelpYou_tr0();
	}
	
	/* The reactions of exit exit_notFound. */
	private void react_main_region_GoTo_goto_exit_notFound() {
		effect_main_region_GoTo_tr1();
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
			case main_region_Wave__region0_TrackingOffAndTurn:
				react_main_region_Wave__region0_TrackingOffAndTurn();
				break;
			case main_region_Wave__region0_WaveFound:
				react_main_region_Wave__region0_WaveFound();
				break;
			case main_region_Wave__region0_Turn:
				react_main_region_Wave__region0_Turn();
				break;
			case main_region_Wave__region0_DetectionOn:
				react_main_region_Wave__region0_DetectionOn();
				break;
			case main_region_Wave__region0_PersonFound:
				react_main_region_Wave__region0_PersonFound();
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
			case main_region_HowCanIHelpYou_main_region_StopSTT:
				react_main_region_HowCanIHelpYou_main_region_StopSTT();
				break;
			case main_region_HowCanIHelpYou_main_region_TellIncomprehensible:
				react_main_region_HowCanIHelpYou_main_region_TellIncomprehensible();
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
			case main_region_GoTo_goto_kitchen:
				react_main_region_GoTo_goto_kitchen();
				break;
			case main_region_GoTo_goto_livingroom:
				react_main_region_GoTo_goto_livingroom();
				break;
			case main_region_GoTo_goto_room3:
				react_main_region_GoTo_goto_room3();
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
			case main_region_Wait:
				react_main_region_Wait();
				break;
			case main_region_MoveBodyRight:
				react_main_region_MoveBodyRight();
				break;
			case main_region_PersonFound:
				react_main_region_PersonFound();
				break;
			case main_region_MoveBodyLeft:
				react_main_region_MoveBodyLeft();
				break;
			case main_region_GuideMe:
				react_main_region_GuideMe();
				break;
			default:
				// $NullState$
			}
		}
		clearEvents();
	}
}
