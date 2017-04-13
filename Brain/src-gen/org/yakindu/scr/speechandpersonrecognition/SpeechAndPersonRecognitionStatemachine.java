package org.yakindu.scr.speechandpersonrecognition;
import org.yakindu.scr.ITimer;

public class SpeechAndPersonRecognitionStatemachine implements ISpeechAndPersonRecognitionStatemachine {

	protected class SCInterfaceImpl implements SCInterface {
	
	}
	
	protected SCInterfaceImpl sCInterface;
	
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
		
		public boolean getTTSReady() {
			return tTSReady;
		}
		
		public void setTTSReady(boolean value) {
			this.tTSReady = value;
		}
		
	}
	
	protected SCIHBrainImpl sCIHBrain;
	
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
	
	protected class SCIAttractivenessImpl implements SCIAttractiveness {
	
		private SCIAttractivenessOperationCallback operationCallback;
		
		public void setSCIAttractivenessOperationCallback(
				SCIAttractivenessOperationCallback operationCallback) {
			this.operationCallback = operationCallback;
		}
		private double old_attr;
		
		public double getOld_attr() {
			return old_attr;
		}
		
		public void setOld_attr(double value) {
			this.old_attr = value;
		}
		
	}
	
	protected SCIAttractivenessImpl sCIAttractiveness;
	
	protected class SCIKinect2Impl implements SCIKinect2 {
	
		private SCIKinect2OperationCallback operationCallback;
		
		public void setSCIKinect2OperationCallback(
				SCIKinect2OperationCallback operationCallback) {
			this.operationCallback = operationCallback;
		}
		private String gesture;
		
		public String getGesture() {
			return gesture;
		}
		
		public void setGesture(String value) {
			this.gesture = value;
		}
		
		private boolean noiseDetected;
		
		public boolean getNoiseDetected() {
			return noiseDetected;
		}
		
		public void setNoiseDetected(boolean value) {
			this.noiseDetected = value;
		}
		
		private long noiseAngle;
		
		public long getNoiseAngle() {
			return noiseAngle;
		}
		
		public void setNoiseAngle(long value) {
			this.noiseAngle = value;
		}
		
	}
	
	protected SCIKinect2Impl sCIKinect2;
	
	protected class SCILeapMotionImpl implements SCILeapMotion {
	
		private SCILeapMotionOperationCallback operationCallback;
		
		public void setSCILeapMotionOperationCallback(
				SCILeapMotionOperationCallback operationCallback) {
			this.operationCallback = operationCallback;
		}
		private boolean gestureDetected;
		
		public boolean getGestureDetected() {
			return gestureDetected;
		}
		
		public void setGestureDetected(boolean value) {
			this.gestureDetected = value;
		}
		
		private String gesture;
		
		public String getGesture() {
			return gesture;
		}
		
		public void setGesture(String value) {
			this.gesture = value;
		}
		
		private boolean stringFinished;
		
		public boolean getStringFinished() {
			return stringFinished;
		}
		
		public void setStringFinished(boolean value) {
			this.stringFinished = value;
		}
		
		private String detectedString;
		
		public String getDetectedString() {
			return detectedString;
		}
		
		public void setDetectedString(String value) {
			this.detectedString = value;
		}
		
	}
	
	protected SCILeapMotionImpl sCILeapMotion;
	
	protected class SCIMiraImpl implements SCIMira {
	
		private SCIMiraOperationCallback operationCallback;
		
		public void setSCIMiraOperationCallback(
				SCIMiraOperationCallback operationCallback) {
			this.operationCallback = operationCallback;
		}
		private boolean emergencyStop;
		
		public boolean getEmergencyStop() {
			return emergencyStop;
		}
		
		public void setEmergencyStop(boolean value) {
			this.emergencyStop = value;
		}
		
		private boolean bumpered;
		
		public boolean getBumpered() {
			return bumpered;
		}
		
		public void setBumpered(boolean value) {
			this.bumpered = value;
		}
		
		private boolean blocked;
		
		public boolean getBlocked() {
			return blocked;
		}
		
		public void setBlocked(boolean value) {
			this.blocked = value;
		}
		
		private boolean arrivedWP;
		
		public boolean getArrivedWP() {
			return arrivedWP;
		}
		
		public void setArrivedWP(boolean value) {
			this.arrivedWP = value;
		}
		
	}
	
	protected SCIMiraImpl sCIMira;
	
	protected class SCISTTImpl implements SCISTT {
	
		private SCISTTOperationCallback operationCallback;
		
		public void setSCISTTOperationCallback(
				SCISTTOperationCallback operationCallback) {
			this.operationCallback = operationCallback;
		}
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
	
	protected class SCICurrPersonImpl implements SCICurrPerson {
	
		private SCICurrPersonOperationCallback operationCallback;
		
		public void setSCICurrPersonOperationCallback(
				SCICurrPersonOperationCallback operationCallback) {
			this.operationCallback = operationCallback;
		}
		private long personID;
		
		public long getPersonID() {
			return personID;
		}
		
		public void setPersonID(long value) {
			this.personID = value;
		}
		
		private boolean known;
		
		public boolean getKnown() {
			return known;
		}
		
		public void setKnown(boolean value) {
			this.known = value;
		}
		
		private String firstname;
		
		public String getFirstname() {
			return firstname;
		}
		
		public void setFirstname(String value) {
			this.firstname = value;
		}
		
		private String lastname;
		
		public String getLastname() {
			return lastname;
		}
		
		public void setLastname(String value) {
			this.lastname = value;
		}
		
		private long estimatedAge;
		
		public long getEstimatedAge() {
			return estimatedAge;
		}
		
		public void setEstimatedAge(long value) {
			this.estimatedAge = value;
		}
		
		private long bdYear;
		
		public long getBdYear() {
			return bdYear;
		}
		
		public void setBdYear(long value) {
			this.bdYear = value;
		}
		
		private long bdMounth;
		
		public long getBdMounth() {
			return bdMounth;
		}
		
		public void setBdMounth(long value) {
			this.bdMounth = value;
		}
		
		private long bdDay;
		
		public long getBdDay() {
			return bdDay;
		}
		
		public void setBdDay(long value) {
			this.bdDay = value;
		}
		
		private boolean gender;
		
		public boolean getGender() {
			return gender;
		}
		
		public void setGender(boolean value) {
			this.gender = value;
		}
		
		private long ethnicity;
		
		public long getEthnicity() {
			return ethnicity;
		}
		
		public void setEthnicity(long value) {
			this.ethnicity = value;
		}
		
		private boolean glasses;
		
		public boolean getGlasses() {
			return glasses;
		}
		
		public void setGlasses(boolean value) {
			this.glasses = value;
		}
		
		private double attractiveness;
		
		public double getAttractiveness() {
			return attractiveness;
		}
		
		public void setAttractiveness(double value) {
			this.attractiveness = value;
		}
		
		private long currHeadgestures;
		
		public long getCurrHeadgestures() {
			return currHeadgestures;
		}
		
		public void setCurrHeadgestures(long value) {
			this.currHeadgestures = value;
		}
		
		private boolean currSpeaking;
		
		public boolean getCurrSpeaking() {
			return currSpeaking;
		}
		
		public void setCurrSpeaking(boolean value) {
			this.currSpeaking = value;
		}
		
		private long currEmotion;
		
		public long getCurrEmotion() {
			return currEmotion;
		}
		
		public void setCurrEmotion(long value) {
			this.currEmotion = value;
		}
		
		private double currDistance;
		
		public double getCurrDistance() {
			return currDistance;
		}
		
		public void setCurrDistance(double value) {
			this.currDistance = value;
		}
		
	}
	
	protected SCICurrPersonImpl sCICurrPerson;
	
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
	
	private final boolean[] timeEvents = new boolean[4];
	private long questionCounter;
	
	protected void setQuestionCounter(long value) {
		questionCounter = value;
	}
	
	protected long getQuestionCounter() {
		return questionCounter;
	}
	
	public SpeechAndPersonRecognitionStatemachine() {
		sCInterface = new SCInterfaceImpl();
		sCIBGF = new SCIBGFImpl();
		sCIHBrain = new SCIHBrainImpl();
		sCIVBrain = new SCIVBrainImpl();
		sCIAttractiveness = new SCIAttractivenessImpl();
		sCIKinect2 = new SCIKinect2Impl();
		sCILeapMotion = new SCILeapMotionImpl();
		sCIMira = new SCIMiraImpl();
		sCISTT = new SCISTTImpl();
		sCICurrPerson = new SCICurrPersonImpl();
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
		sCIBGF.setEventNum(0);
		
		sCIBGF.setRandNum(0);
		
		sCIHBrain.setTTSReady(false);
		
		sCIVBrain.setCountFoundFaces(0);
		
		sCIVBrain.setNessesaryToSavePersonList(false);
		
		sCIAttractiveness.setOld_attr(0.0);
		
		sCIKinect2.setGesture("");
		
		sCIKinect2.setNoiseDetected(false);
		
		sCIKinect2.setNoiseAngle(0);
		
		sCILeapMotion.setGestureDetected(false);
		
		sCILeapMotion.setGesture("");
		
		sCILeapMotion.setStringFinished(false);
		
		sCILeapMotion.setDetectedString("");
		
		sCIMira.setEmergencyStop(false);
		
		sCIMira.setBumpered(false);
		
		sCIMira.setBlocked(false);
		
		sCIMira.setArrivedWP(false);
		
		sCISTT.setSTTReady(false);
		
		sCISTT.setSpeakerMsg("");
		
		sCISTT.setFilteredMsg("");
		
		sCISTT.setFilterBubble("");
		
		sCICurrPerson.setPersonID(0);
		
		sCICurrPerson.setKnown(false);
		
		sCICurrPerson.setFirstname("");
		
		sCICurrPerson.setLastname("");
		
		sCICurrPerson.setEstimatedAge(0);
		
		sCICurrPerson.setBdYear(0);
		
		sCICurrPerson.setBdMounth(0);
		
		sCICurrPerson.setBdDay(0);
		
		sCICurrPerson.setGender(false);
		
		sCICurrPerson.setEthnicity(0);
		
		sCICurrPerson.setGlasses(false);
		
		sCICurrPerson.setAttractiveness(0.0);
		
		sCICurrPerson.setCurrHeadgestures(0);
		
		sCICurrPerson.setCurrSpeaking(false);
		
		sCICurrPerson.setCurrEmotion(0);
		
		sCICurrPerson.setCurrDistance(0.0);
		
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
	
	public SCIBGF getSCIBGF() {
		return sCIBGF;
	}
	
	public SCIHBrain getSCIHBrain() {
		return sCIHBrain;
	}
	
	public SCIVBrain getSCIVBrain() {
		return sCIVBrain;
	}
	
	public SCIAttractiveness getSCIAttractiveness() {
		return sCIAttractiveness;
	}
	
	public SCIKinect2 getSCIKinect2() {
		return sCIKinect2;
	}
	
	public SCILeapMotion getSCILeapMotion() {
		return sCILeapMotion;
	}
	
	public SCIMira getSCIMira() {
		return sCIMira;
	}
	
	public SCISTT getSCISTT() {
		return sCISTT;
	}
	
	public SCICurrPerson getSCICurrPerson() {
		return sCICurrPerson;
	}
	
	private boolean check_main_region_Init_tr0_tr0() {
		return true;
	}
	
	private boolean check_main_region_Announcement_tr0_tr0() {
		return sCIHBrain.tTSReady==true;
	}
	
	private boolean check_main_region_Wait_tr0_tr0() {
		return timeEvents[0];
	}
	
	private boolean check_main_region_TurnAround_tr0_tr0() {
		return timeEvents[1];
	}
	
	private boolean check_main_region_RiddleGame1_r1_RequestForOpertator_tr0_tr0() {
		return timeEvents[2];
	}
	
	private boolean check_main_region_RiddleGame1_r1_Answer_tr0_tr0() {
		return getQuestionCounter()<7;
	}
	
	private boolean check_main_region_RiddleGame1_r1_Answer_tr1_tr1() {
		return getQuestionCounter()==7;
	}
	
	private boolean check_main_region_BlindMan_sBluGame_r1_ListenForQuestion_tr0_tr0() {
		return timeEvents[3];
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
		sCIKinect2.operationCallback.sendNoiseDetectionOnOff(false);
	}
	
	/* Entry action for state 'Announcement'. */
	private void entryAction_main_region_Announcement() {
		sCIHBrain.operationCallback.sendTTS("I want to play the riddle game!");
	}
	
	/* Entry action for state 'Wait'. */
	private void entryAction_main_region_Wait() {
		timer.setTimer(this, 0, 10*1000, false);
	}
	
	/* Entry action for state 'TurnAround'. */
	private void entryAction_main_region_TurnAround() {
		timer.setTimer(this, 1, 2*1000, false);
		
		sCIMira.operationCallback.sendBodyUTurn();
	}
	
	/* Entry action for state 'CrowdScanningAndCounting'. */
	private void entryAction_main_region_CrowdScanningAndCounting() {
		sCIHBrain.operationCallback.sendTTS("");
	}
	
	/* Entry action for state 'StartGame'. */
	private void entryAction_main_region_RiddleGame1_r1_StartGame() {
		setQuestionCounter(0);
	}
	
	/* Entry action for state 'RequestForOpertator'. */
	private void entryAction_main_region_RiddleGame1_r1_RequestForOpertator() {
		timer.setTimer(this, 2, 5*1000, false);
		
		sCIHBrain.operationCallback.sendTTS("who want to play riddles with me?");
	}
	
	/* Entry action for state 'WaitForQuestion'. */
	private void entryAction_main_region_RiddleGame1_r1_WaitForQuestion() {
		sCISTT.setSTTReady(true);
		
		sCISTT.operationCallback.sendSpeechDetectionOnOff(0);
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
		timer.setTimer(this, 3, 5*1000, false);
		
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
	
	/* Exit action for state 'TurnAround'. */
	private void exitAction_main_region_TurnAround() {
		timer.unsetTimer(this, 1);
	}
	
	/* Exit action for state 'RequestForOpertator'. */
	private void exitAction_main_region_RiddleGame1_r1_RequestForOpertator() {
		timer.unsetTimer(this, 2);
	}
	
	/* Exit action for state 'ListenForQuestion'. */
	private void exitAction_main_region_BlindMan_sBluGame_r1_ListenForQuestion() {
		timer.unsetTimer(this, 3);
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
		
		exitAction_main_region_TurnAround();
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
		effect_main_region_Init_tr0();
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
