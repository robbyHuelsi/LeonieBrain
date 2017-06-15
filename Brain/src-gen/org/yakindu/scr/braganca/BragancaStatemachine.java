package org.yakindu.scr.braganca;
import org.yakindu.scr.ITimer;

public class BragancaStatemachine implements IBragancaStatemachine {

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
	
	protected class SCIVBrainImpl implements SCIVBrain {
	
		private SCIVBrainOperationCallback operationCallback;
		
		public void setSCIVBrainOperationCallback(
				SCIVBrainOperationCallback operationCallback) {
			this.operationCallback = operationCallback;
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
	
	protected class SCILeapMotionImpl implements SCILeapMotion {
	
		private SCILeapMotionOperationCallback operationCallback;
		
		public void setSCILeapMotionOperationCallback(
				SCILeapMotionOperationCallback operationCallback) {
			this.operationCallback = operationCallback;
		}
		private boolean gestureDetected;
		
		public void raiseGestureDetected() {
			gestureDetected = true;
		}
		
		private boolean stringFinished;
		
		public void raiseStringFinished() {
			stringFinished = true;
		}
		
		protected void clearEvents() {
			gestureDetected = false;
			stringFinished = false;
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
	
	protected class SCICurrPersonImpl implements SCICurrPerson {
	
		private SCICurrPersonOperationCallback operationCallback;
		
		public void setSCICurrPersonOperationCallback(
				SCICurrPersonOperationCallback operationCallback) {
			this.operationCallback = operationCallback;
		}
	}
	
	protected SCICurrPersonImpl sCICurrPerson;
	
	private boolean initialized = false;
	
	public enum State {
		main_Init,
		main__final_,
		main_AtWP01___ACI,
		main_wait_for_cleaning_VBrain_buffer,
		main_FaceDataInterpretation,
		main_FaceDataInterpretation_FaceDataInterpretation_PersonKnownWithName,
		main_FaceDataInterpretation_FaceDataInterpretation_UnknownGirl,
		main_FaceDataInterpretation_FaceDataInterpretation_PersonKnownWithoutName,
		main_FaceDataInterpretation_FaceDataInterpretation_UnknownFemaleTeen,
		main_FaceDataInterpretation_FaceDataInterpretation_UnknownWomen,
		main_FaceDataInterpretation_FaceDataInterpretation_UnknownBoy,
		main_FaceDataInterpretation_FaceDataInterpretation_UnknownMaleTeen,
		main_FaceDataInterpretation_FaceDataInterpretation_UnknownMen,
		main_FaceDataInterpretation_FaceDataInterpretation_wait_for_getting_datas,
		main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name,
		main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_STT_1,
		main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Answere_name__and_ask,
		main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_STT3,
		main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Save_Firstname,
		main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Ask_for_Repeat,
		main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Didnt_get_it,
		main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Bye_bye,
		main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Yes_No_Question,
		main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Yes_No_Question_inner_region_StartSTT,
		main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Yes_No_Question_inner_region_Copy_1_STT3,
		main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_asking_repeat_YesNo,
		main_FaceDataInterpretation_FaceDataInterpretation_AboutRobotica_1,
		main_FaceDataInterpretation_FaceDataInterpretation_AboutRobotica_2,
		main_FaceDataInterpretation_FaceDataInterpretation_RandomTopic_1,
		main_FaceDataInterpretation_FaceDataInterpretation_RandomTopic_2,
		main_FaceDataInterpretation_FaceDataInterpretation_Prompt_2,
		main_FaceDataInterpretation_FaceDataInterpretation_Prompt_1,
		main_FaceDataInterpretation_FaceDataInterpretation_Farewell_1,
		main_FaceDataInterpretation_FaceDataInterpretation_Farewell_2,
		main_FaceDataInterpretation_FaceDataInterpretation_Farewell_3,
		main_FaceDataInterpretation_FaceDataInterpretation_Farewell_4,
		main_FaceDataInterpretation_FaceDataInterpretation_Selection,
		main_FaceDataInterpretation_FaceDataInterpretation_newRandNum,
		main_FaceDataInterpretation_FaceDataInterpretation_RandomTopic_3,
		main_FaceDataInterpretation_FaceDataInterpretation_Selection_2,
		main_FaceDataInterpretation_FaceDataInterpretation_AlternativeConv_1,
		main_FaceDataInterpretation_FaceDataInterpretation_Selection_3,
		main_FaceDataInterpretation_FaceDataInterpretation_YesNo_MoreInfo,
		main_FaceDataInterpretation_FaceDataInterpretation_YesNo_MoreInfo_inner_region_StartSTT,
		main_FaceDataInterpretation_FaceDataInterpretation_YesNo_MoreInfo_inner_region_Copy_1_STT3,
		main_FaceDataInterpretation_FaceDataInterpretation_YesNo_MoreInfo_inner_region_asking_repeat_YesNo,
		main_FaceDataInterpretation_FaceDataInterpretation_YesNo_MoreInfo_inner_region_init,
		main_FaceDataInterpretation_FaceDataInterpretation_AboutRobotica_3,
		main_FaceDataInterpretation_FaceDataInterpretation_Closing,
		main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation,
		main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_neutral,
		main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_happy,
		main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_sad,
		main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_laughing,
		main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_surprised,
		main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_angry,
		main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_tell_joke_0,
		main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_joke_worked,
		main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_initialise_jokes,
		main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_joke_didnt_work,
		main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_tell_joke_1,
		main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_tell_joke_2,
		main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_tell_joke_3,
		main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_tell_joke_5,
		main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_tell_joke_6,
		main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_waitForNewEmo,
		main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_resetEmo,
		main_FaceDataInterpretation_FaceDataInterpretation_sadFace,
		main_FaceDataInterpretation_FaceDataInterpretation_init_face,
		main_FaceDataInterpretation_FaceDataInterpretation_yesNo_fun,
		main_FaceDataInterpretation_FaceDataInterpretation_yesNo_fun_inner_region_StartSTT,
		main_FaceDataInterpretation_FaceDataInterpretation_yesNo_fun_inner_region_Copy_1_STT3,
		main_FaceDataInterpretation_FaceDataInterpretation_yesNo_fun_inner_region_asking_repeat_YesNo,
		main_FaceDataInterpretation_FaceDataInterpretation_yesNo_fun_inner_region_init,
		main_FaceDataInterpretation_FaceDataInterpretation_attractiveness,
		main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_start_estimation,
		main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_ready,
		main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_pretty_with_glasses,
		main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_got_new_attr,
		main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_prettier,
		main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_not_prettier,
		main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_pretty,
		main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_not_pretty,
		main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_get_new_attractiveness,
		main_FaceDataInterpretation_FaceDataInterpretation_asking_unknown,
		main_FaceDataInterpretation_FaceDataInterpretation_yesNoCancelFunNo,
		main_FaceDataInterpretation_FaceDataInterpretation_exitCancelAnswer,
		main_FaceDataInterpretation_FaceDataInterpretation_waitingForSpeaking,
		main_FaceDataInterpretation_FaceDataInterpretation_AfterGettingName,
		main_FaceDataInterpretation_FaceDataInterpretation_AfterGettingName_inner_region_AfterGettingName,
		main_FaceDataInterpretation_FaceDataInterpretation_AfterGettingName_inner_region_newRandNum,
		main_FaceDataInterpretation_FaceDataInterpretation_randNumEnd,
		main_wait,
		main_exitSad,
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
	
	private final boolean[] timeEvents = new boolean[15];
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
	
	private long questionRepeat;
	
	protected void setQuestionRepeat(long value) {
		questionRepeat = value;
	}
	
	protected long getQuestionRepeat() {
		return questionRepeat;
	}
	
	public BragancaStatemachine() {
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
		for (int i = 0; i < 2; i++) {
			stateVector[i] = State.$NullState$;
		}
		clearEvents();
		clearOutEvents();
		sCIBGF.setEventNum(0);
		
		sCIBGF.setRandNum(0);
		
		sCIAttractiveness.setOld_attr(0.0);
		
		setCounter(0);
		
		setNameBuffer("");
		
		setQuestionCounter(0);
		
		setQuestionRepeat(0);
	}
	
	public void enter() {
		if (!initialized) {
			throw new IllegalStateException(
					"The state machine needs to be initialized first by calling the init() function.");
		}
		if (timer == null) {
			throw new IllegalStateException("timer not set.");
		}
		enterSequence_main_default();
		enterSequence_Leonie_Bupered_Or_Emergency_Stop_default();
	}
	
	public void exit() {
		exitSequence_main();
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
		sCILeapMotion.clearEvents();
		sCIMira.clearEvents();
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
		case main_Init:
			return stateVector[0] == State.main_Init;
		case main__final_:
			return stateVector[0] == State.main__final_;
		case main_AtWP01___ACI:
			return stateVector[0] == State.main_AtWP01___ACI;
		case main_wait_for_cleaning_VBrain_buffer:
			return stateVector[0] == State.main_wait_for_cleaning_VBrain_buffer;
		case main_FaceDataInterpretation:
			return stateVector[0].ordinal() >= State.
					main_FaceDataInterpretation.ordinal()&& stateVector[0].ordinal() <= State.main_FaceDataInterpretation_FaceDataInterpretation_randNumEnd.ordinal();
		case main_FaceDataInterpretation_FaceDataInterpretation_PersonKnownWithName:
			return stateVector[0] == State.main_FaceDataInterpretation_FaceDataInterpretation_PersonKnownWithName;
		case main_FaceDataInterpretation_FaceDataInterpretation_UnknownGirl:
			return stateVector[0] == State.main_FaceDataInterpretation_FaceDataInterpretation_UnknownGirl;
		case main_FaceDataInterpretation_FaceDataInterpretation_PersonKnownWithoutName:
			return stateVector[0] == State.main_FaceDataInterpretation_FaceDataInterpretation_PersonKnownWithoutName;
		case main_FaceDataInterpretation_FaceDataInterpretation_UnknownFemaleTeen:
			return stateVector[0] == State.main_FaceDataInterpretation_FaceDataInterpretation_UnknownFemaleTeen;
		case main_FaceDataInterpretation_FaceDataInterpretation_UnknownWomen:
			return stateVector[0] == State.main_FaceDataInterpretation_FaceDataInterpretation_UnknownWomen;
		case main_FaceDataInterpretation_FaceDataInterpretation_UnknownBoy:
			return stateVector[0] == State.main_FaceDataInterpretation_FaceDataInterpretation_UnknownBoy;
		case main_FaceDataInterpretation_FaceDataInterpretation_UnknownMaleTeen:
			return stateVector[0] == State.main_FaceDataInterpretation_FaceDataInterpretation_UnknownMaleTeen;
		case main_FaceDataInterpretation_FaceDataInterpretation_UnknownMen:
			return stateVector[0] == State.main_FaceDataInterpretation_FaceDataInterpretation_UnknownMen;
		case main_FaceDataInterpretation_FaceDataInterpretation_wait_for_getting_datas:
			return stateVector[0] == State.main_FaceDataInterpretation_FaceDataInterpretation_wait_for_getting_datas;
		case main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name:
			return stateVector[0].ordinal() >= State.
					main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name.ordinal()&& stateVector[0].ordinal() <= State.main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_asking_repeat_YesNo.ordinal();
		case main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_STT_1:
			return stateVector[0] == State.main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_STT_1;
		case main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Answere_name__and_ask:
			return stateVector[0] == State.main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Answere_name__and_ask;
		case main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_STT3:
			return stateVector[0] == State.main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_STT3;
		case main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Save_Firstname:
			return stateVector[0] == State.main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Save_Firstname;
		case main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Ask_for_Repeat:
			return stateVector[0] == State.main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Ask_for_Repeat;
		case main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Didnt_get_it:
			return stateVector[0] == State.main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Didnt_get_it;
		case main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Bye_bye:
			return stateVector[0] == State.main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Bye_bye;
		case main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Yes_No_Question:
			return stateVector[0].ordinal() >= State.
					main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Yes_No_Question.ordinal()&& stateVector[0].ordinal() <= State.main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Yes_No_Question_inner_region_Copy_1_STT3.ordinal();
		case main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Yes_No_Question_inner_region_StartSTT:
			return stateVector[0] == State.main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Yes_No_Question_inner_region_StartSTT;
		case main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Yes_No_Question_inner_region_Copy_1_STT3:
			return stateVector[0] == State.main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Yes_No_Question_inner_region_Copy_1_STT3;
		case main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_asking_repeat_YesNo:
			return stateVector[0] == State.main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_asking_repeat_YesNo;
		case main_FaceDataInterpretation_FaceDataInterpretation_AboutRobotica_1:
			return stateVector[0] == State.main_FaceDataInterpretation_FaceDataInterpretation_AboutRobotica_1;
		case main_FaceDataInterpretation_FaceDataInterpretation_AboutRobotica_2:
			return stateVector[0] == State.main_FaceDataInterpretation_FaceDataInterpretation_AboutRobotica_2;
		case main_FaceDataInterpretation_FaceDataInterpretation_RandomTopic_1:
			return stateVector[0] == State.main_FaceDataInterpretation_FaceDataInterpretation_RandomTopic_1;
		case main_FaceDataInterpretation_FaceDataInterpretation_RandomTopic_2:
			return stateVector[0] == State.main_FaceDataInterpretation_FaceDataInterpretation_RandomTopic_2;
		case main_FaceDataInterpretation_FaceDataInterpretation_Prompt_2:
			return stateVector[0] == State.main_FaceDataInterpretation_FaceDataInterpretation_Prompt_2;
		case main_FaceDataInterpretation_FaceDataInterpretation_Prompt_1:
			return stateVector[0] == State.main_FaceDataInterpretation_FaceDataInterpretation_Prompt_1;
		case main_FaceDataInterpretation_FaceDataInterpretation_Farewell_1:
			return stateVector[0] == State.main_FaceDataInterpretation_FaceDataInterpretation_Farewell_1;
		case main_FaceDataInterpretation_FaceDataInterpretation_Farewell_2:
			return stateVector[0] == State.main_FaceDataInterpretation_FaceDataInterpretation_Farewell_2;
		case main_FaceDataInterpretation_FaceDataInterpretation_Farewell_3:
			return stateVector[0] == State.main_FaceDataInterpretation_FaceDataInterpretation_Farewell_3;
		case main_FaceDataInterpretation_FaceDataInterpretation_Farewell_4:
			return stateVector[0] == State.main_FaceDataInterpretation_FaceDataInterpretation_Farewell_4;
		case main_FaceDataInterpretation_FaceDataInterpretation_Selection:
			return stateVector[0] == State.main_FaceDataInterpretation_FaceDataInterpretation_Selection;
		case main_FaceDataInterpretation_FaceDataInterpretation_newRandNum:
			return stateVector[0] == State.main_FaceDataInterpretation_FaceDataInterpretation_newRandNum;
		case main_FaceDataInterpretation_FaceDataInterpretation_RandomTopic_3:
			return stateVector[0] == State.main_FaceDataInterpretation_FaceDataInterpretation_RandomTopic_3;
		case main_FaceDataInterpretation_FaceDataInterpretation_Selection_2:
			return stateVector[0] == State.main_FaceDataInterpretation_FaceDataInterpretation_Selection_2;
		case main_FaceDataInterpretation_FaceDataInterpretation_AlternativeConv_1:
			return stateVector[0] == State.main_FaceDataInterpretation_FaceDataInterpretation_AlternativeConv_1;
		case main_FaceDataInterpretation_FaceDataInterpretation_Selection_3:
			return stateVector[0] == State.main_FaceDataInterpretation_FaceDataInterpretation_Selection_3;
		case main_FaceDataInterpretation_FaceDataInterpretation_YesNo_MoreInfo:
			return stateVector[0].ordinal() >= State.
					main_FaceDataInterpretation_FaceDataInterpretation_YesNo_MoreInfo.ordinal()&& stateVector[0].ordinal() <= State.main_FaceDataInterpretation_FaceDataInterpretation_YesNo_MoreInfo_inner_region_init.ordinal();
		case main_FaceDataInterpretation_FaceDataInterpretation_YesNo_MoreInfo_inner_region_StartSTT:
			return stateVector[0] == State.main_FaceDataInterpretation_FaceDataInterpretation_YesNo_MoreInfo_inner_region_StartSTT;
		case main_FaceDataInterpretation_FaceDataInterpretation_YesNo_MoreInfo_inner_region_Copy_1_STT3:
			return stateVector[0] == State.main_FaceDataInterpretation_FaceDataInterpretation_YesNo_MoreInfo_inner_region_Copy_1_STT3;
		case main_FaceDataInterpretation_FaceDataInterpretation_YesNo_MoreInfo_inner_region_asking_repeat_YesNo:
			return stateVector[0] == State.main_FaceDataInterpretation_FaceDataInterpretation_YesNo_MoreInfo_inner_region_asking_repeat_YesNo;
		case main_FaceDataInterpretation_FaceDataInterpretation_YesNo_MoreInfo_inner_region_init:
			return stateVector[0] == State.main_FaceDataInterpretation_FaceDataInterpretation_YesNo_MoreInfo_inner_region_init;
		case main_FaceDataInterpretation_FaceDataInterpretation_AboutRobotica_3:
			return stateVector[0] == State.main_FaceDataInterpretation_FaceDataInterpretation_AboutRobotica_3;
		case main_FaceDataInterpretation_FaceDataInterpretation_Closing:
			return stateVector[0] == State.main_FaceDataInterpretation_FaceDataInterpretation_Closing;
		case main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation:
			return stateVector[0].ordinal() >= State.
					main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation.ordinal()&& stateVector[0].ordinal() <= State.main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_resetEmo.ordinal();
		case main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_neutral:
			return stateVector[0] == State.main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_neutral;
		case main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_happy:
			return stateVector[0] == State.main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_happy;
		case main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_sad:
			return stateVector[0] == State.main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_sad;
		case main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_laughing:
			return stateVector[0] == State.main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_laughing;
		case main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_surprised:
			return stateVector[0] == State.main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_surprised;
		case main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_angry:
			return stateVector[0] == State.main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_angry;
		case main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_tell_joke_0:
			return stateVector[0] == State.main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_tell_joke_0;
		case main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_joke_worked:
			return stateVector[0] == State.main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_joke_worked;
		case main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_initialise_jokes:
			return stateVector[0] == State.main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_initialise_jokes;
		case main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_joke_didnt_work:
			return stateVector[0] == State.main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_joke_didnt_work;
		case main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_tell_joke_1:
			return stateVector[0] == State.main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_tell_joke_1;
		case main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_tell_joke_2:
			return stateVector[0] == State.main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_tell_joke_2;
		case main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_tell_joke_3:
			return stateVector[0] == State.main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_tell_joke_3;
		case main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_tell_joke_5:
			return stateVector[0] == State.main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_tell_joke_5;
		case main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_tell_joke_6:
			return stateVector[0] == State.main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_tell_joke_6;
		case main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_waitForNewEmo:
			return stateVector[0] == State.main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_waitForNewEmo;
		case main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_resetEmo:
			return stateVector[0] == State.main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_resetEmo;
		case main_FaceDataInterpretation_FaceDataInterpretation_sadFace:
			return stateVector[0] == State.main_FaceDataInterpretation_FaceDataInterpretation_sadFace;
		case main_FaceDataInterpretation_FaceDataInterpretation_init_face:
			return stateVector[0] == State.main_FaceDataInterpretation_FaceDataInterpretation_init_face;
		case main_FaceDataInterpretation_FaceDataInterpretation_yesNo_fun:
			return stateVector[0].ordinal() >= State.
					main_FaceDataInterpretation_FaceDataInterpretation_yesNo_fun.ordinal()&& stateVector[0].ordinal() <= State.main_FaceDataInterpretation_FaceDataInterpretation_yesNo_fun_inner_region_init.ordinal();
		case main_FaceDataInterpretation_FaceDataInterpretation_yesNo_fun_inner_region_StartSTT:
			return stateVector[0] == State.main_FaceDataInterpretation_FaceDataInterpretation_yesNo_fun_inner_region_StartSTT;
		case main_FaceDataInterpretation_FaceDataInterpretation_yesNo_fun_inner_region_Copy_1_STT3:
			return stateVector[0] == State.main_FaceDataInterpretation_FaceDataInterpretation_yesNo_fun_inner_region_Copy_1_STT3;
		case main_FaceDataInterpretation_FaceDataInterpretation_yesNo_fun_inner_region_asking_repeat_YesNo:
			return stateVector[0] == State.main_FaceDataInterpretation_FaceDataInterpretation_yesNo_fun_inner_region_asking_repeat_YesNo;
		case main_FaceDataInterpretation_FaceDataInterpretation_yesNo_fun_inner_region_init:
			return stateVector[0] == State.main_FaceDataInterpretation_FaceDataInterpretation_yesNo_fun_inner_region_init;
		case main_FaceDataInterpretation_FaceDataInterpretation_attractiveness:
			return stateVector[0].ordinal() >= State.
					main_FaceDataInterpretation_FaceDataInterpretation_attractiveness.ordinal()&& stateVector[0].ordinal() <= State.main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_get_new_attractiveness.ordinal();
		case main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_start_estimation:
			return stateVector[0] == State.main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_start_estimation;
		case main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_ready:
			return stateVector[0] == State.main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_ready;
		case main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_pretty_with_glasses:
			return stateVector[0] == State.main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_pretty_with_glasses;
		case main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_got_new_attr:
			return stateVector[0] == State.main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_got_new_attr;
		case main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_prettier:
			return stateVector[0] == State.main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_prettier;
		case main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_not_prettier:
			return stateVector[0] == State.main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_not_prettier;
		case main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_pretty:
			return stateVector[0] == State.main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_pretty;
		case main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_not_pretty:
			return stateVector[0] == State.main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_not_pretty;
		case main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_get_new_attractiveness:
			return stateVector[0] == State.main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_get_new_attractiveness;
		case main_FaceDataInterpretation_FaceDataInterpretation_asking_unknown:
			return stateVector[0] == State.main_FaceDataInterpretation_FaceDataInterpretation_asking_unknown;
		case main_FaceDataInterpretation_FaceDataInterpretation_yesNoCancelFunNo:
			return stateVector[0] == State.main_FaceDataInterpretation_FaceDataInterpretation_yesNoCancelFunNo;
		case main_FaceDataInterpretation_FaceDataInterpretation_exitCancelAnswer:
			return stateVector[0] == State.main_FaceDataInterpretation_FaceDataInterpretation_exitCancelAnswer;
		case main_FaceDataInterpretation_FaceDataInterpretation_waitingForSpeaking:
			return stateVector[0] == State.main_FaceDataInterpretation_FaceDataInterpretation_waitingForSpeaking;
		case main_FaceDataInterpretation_FaceDataInterpretation_AfterGettingName:
			return stateVector[0].ordinal() >= State.
					main_FaceDataInterpretation_FaceDataInterpretation_AfterGettingName.ordinal()&& stateVector[0].ordinal() <= State.main_FaceDataInterpretation_FaceDataInterpretation_AfterGettingName_inner_region_newRandNum.ordinal();
		case main_FaceDataInterpretation_FaceDataInterpretation_AfterGettingName_inner_region_AfterGettingName:
			return stateVector[0] == State.main_FaceDataInterpretation_FaceDataInterpretation_AfterGettingName_inner_region_AfterGettingName;
		case main_FaceDataInterpretation_FaceDataInterpretation_AfterGettingName_inner_region_newRandNum:
			return stateVector[0] == State.main_FaceDataInterpretation_FaceDataInterpretation_AfterGettingName_inner_region_newRandNum;
		case main_FaceDataInterpretation_FaceDataInterpretation_randNumEnd:
			return stateVector[0] == State.main_FaceDataInterpretation_FaceDataInterpretation_randNumEnd;
		case main_wait:
			return stateVector[0] == State.main_wait;
		case main_exitSad:
			return stateVector[0] == State.main_exitSad;
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
	
	private boolean check_main_Init_tr0_tr0() {
		return true;
	}
	
	private boolean check_main_AtWP01___ACI_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_main_wait_for_cleaning_VBrain_buffer_tr0_tr0() {
		return sCIVBrain.operationCallback.getCountFoundFaces()>0;
	}
	
	private boolean check_main_FaceDataInterpretation_FaceDataInterpretation_PersonKnownWithName_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_main_FaceDataInterpretation_FaceDataInterpretation_UnknownGirl_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_main_FaceDataInterpretation_FaceDataInterpretation_PersonKnownWithoutName_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_main_FaceDataInterpretation_FaceDataInterpretation_UnknownFemaleTeen_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_main_FaceDataInterpretation_FaceDataInterpretation_UnknownWomen_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_main_FaceDataInterpretation_FaceDataInterpretation_UnknownBoy_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_main_FaceDataInterpretation_FaceDataInterpretation_UnknownMaleTeen_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_main_FaceDataInterpretation_FaceDataInterpretation_UnknownMen_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_main_FaceDataInterpretation_FaceDataInterpretation_wait_for_getting_datas_tr0_tr0() {
		return timeEvents[0];
	}
	
	private boolean check_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_STT_1_tr0_tr0() {
		return timeEvents[1];
	}
	
	private boolean check_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Answere_name__and_ask_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_STT3_tr0_tr0() {
		return sCISTT.incomprehensible;
	}
	
	private boolean check_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_STT3_tr1_tr1() {
		return sCISTT.spokenTextReceived;
	}
	
	private boolean check_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Save_Firstname_tr0_tr0() {
		return true;
	}
	
	private boolean check_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Ask_for_Repeat_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Didnt_get_it_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Bye_bye_tr0_tr0() {
		return true;
	}
	
	private boolean check_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Yes_No_Question_inner_region_StartSTT_tr0_tr0() {
		return timeEvents[2];
	}
	
	private boolean check_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Yes_No_Question_inner_region_StartSTT_tr1_tr1() {
		return 0==1;
	}
	
	private boolean check_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Yes_No_Question_inner_region_StartSTT_tr2_tr2() {
		return 0==1;
	}
	
	private boolean check_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Yes_No_Question_inner_region_StartSTT_tr3_tr3() {
		return (sCILeapMotion.operationCallback.getGesture()== null?"true" ==null :sCILeapMotion.operationCallback.getGesture().equals("true"));
	}
	
	private boolean check_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Yes_No_Question_inner_region_StartSTT_tr4_tr4() {
		return (sCILeapMotion.operationCallback.getGesture()== null?"false" ==null :sCILeapMotion.operationCallback.getGesture().equals("false"));
	}
	
	private boolean check_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Yes_No_Question_inner_region_Copy_1_STT3_tr0_tr0() {
		return sCISTT.spokenTextReceived;
	}
	
	private boolean check_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_asking_repeat_YesNo_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_main_FaceDataInterpretation_FaceDataInterpretation_AboutRobotica_1_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_main_FaceDataInterpretation_FaceDataInterpretation_AboutRobotica_2_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_main_FaceDataInterpretation_FaceDataInterpretation_RandomTopic_1_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_main_FaceDataInterpretation_FaceDataInterpretation_RandomTopic_2_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_main_FaceDataInterpretation_FaceDataInterpretation_Prompt_2_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_main_FaceDataInterpretation_FaceDataInterpretation_Prompt_1_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_main_FaceDataInterpretation_FaceDataInterpretation_Farewell_1_tr0_tr0() {
		return timeEvents[3];
	}
	
	private boolean check_main_FaceDataInterpretation_FaceDataInterpretation_Farewell_2_tr0_tr0() {
		return timeEvents[4];
	}
	
	private boolean check_main_FaceDataInterpretation_FaceDataInterpretation_Farewell_3_tr0_tr0() {
		return timeEvents[5];
	}
	
	private boolean check_main_FaceDataInterpretation_FaceDataInterpretation_Farewell_4_tr0_tr0() {
		return timeEvents[6];
	}
	
	private boolean check_main_FaceDataInterpretation_FaceDataInterpretation_Selection_tr0_tr0() {
		return sCIBGF.getRandNum()>=20 && sCIBGF.getRandNum()<=29;
	}
	
	private boolean check_main_FaceDataInterpretation_FaceDataInterpretation_Selection_tr1_tr1() {
		return sCIBGF.getRandNum()>29;
	}
	
	private boolean check_main_FaceDataInterpretation_FaceDataInterpretation_Selection_tr2_tr2() {
		return sCIBGF.getRandNum()<10;
	}
	
	private boolean check_main_FaceDataInterpretation_FaceDataInterpretation_Selection_tr3_tr3() {
		return sCIBGF.getRandNum()>=10 && sCIBGF.getRandNum()<=19;
	}
	
	private boolean check_main_FaceDataInterpretation_FaceDataInterpretation_newRandNum_tr0_tr0() {
		return true;
	}
	
	private boolean check_main_FaceDataInterpretation_FaceDataInterpretation_RandomTopic_3_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_main_FaceDataInterpretation_FaceDataInterpretation_Selection_2_tr0_tr0() {
		return sCIBGF.getRandNum()<10;
	}
	
	private boolean check_main_FaceDataInterpretation_FaceDataInterpretation_Selection_2_tr1_tr1() {
		return sCIBGF.getRandNum()>=10 && sCIBGF.getRandNum()<=19;
	}
	
	private boolean check_main_FaceDataInterpretation_FaceDataInterpretation_Selection_2_tr2_tr2() {
		return sCIBGF.getRandNum()>19;
	}
	
	private boolean check_main_FaceDataInterpretation_FaceDataInterpretation_AlternativeConv_1_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_main_FaceDataInterpretation_FaceDataInterpretation_Selection_3_tr0_tr0() {
		return sCIBGF.getRandNum()>=10 && sCIBGF.getRandNum()<=19;
	}
	
	private boolean check_main_FaceDataInterpretation_FaceDataInterpretation_Selection_3_tr1_tr1() {
		return sCIBGF.getRandNum()>19;
	}
	
	private boolean check_main_FaceDataInterpretation_FaceDataInterpretation_Selection_3_tr2_tr2() {
		return sCIBGF.getRandNum()<10;
	}
	
	private boolean check_main_FaceDataInterpretation_FaceDataInterpretation_YesNo_MoreInfo_inner_region_StartSTT_tr0_tr0() {
		return timeEvents[7];
	}
	
	private boolean check_main_FaceDataInterpretation_FaceDataInterpretation_YesNo_MoreInfo_inner_region_StartSTT_tr1_tr1() {
		return 0==1;
	}
	
	private boolean check_main_FaceDataInterpretation_FaceDataInterpretation_YesNo_MoreInfo_inner_region_StartSTT_tr2_tr2() {
		return 0==1;
	}
	
	private boolean check_main_FaceDataInterpretation_FaceDataInterpretation_YesNo_MoreInfo_inner_region_StartSTT_tr3_tr3() {
		return (sCILeapMotion.operationCallback.getGesture()== null?"true" ==null :sCILeapMotion.operationCallback.getGesture().equals("true"));
	}
	
	private boolean check_main_FaceDataInterpretation_FaceDataInterpretation_YesNo_MoreInfo_inner_region_StartSTT_tr4_tr4() {
		return (sCILeapMotion.operationCallback.getGesture()== null?"false" ==null :sCILeapMotion.operationCallback.getGesture().equals("false"));
	}
	
	private boolean check_main_FaceDataInterpretation_FaceDataInterpretation_YesNo_MoreInfo_inner_region_Copy_1_STT3_tr0_tr0() {
		return sCISTT.spokenTextReceived;
	}
	
	private boolean check_main_FaceDataInterpretation_FaceDataInterpretation_YesNo_MoreInfo_inner_region_asking_repeat_YesNo_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_main_FaceDataInterpretation_FaceDataInterpretation_YesNo_MoreInfo_inner_region_init_tr0_tr0() {
		return true;
	}
	
	private boolean check_main_FaceDataInterpretation_FaceDataInterpretation_AboutRobotica_3_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_main_FaceDataInterpretation_FaceDataInterpretation_Closing_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_neutral_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_happy_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_sad_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_laughing_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_surprised_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_angry_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_tell_joke_0_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_joke_worked_tr0_tr0() {
		return sCIHBrain.tTSReady==true;
	}
	
	private boolean check_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_initialise_jokes_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_joke_didnt_work_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_tell_joke_1_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_tell_joke_2_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_tell_joke_3_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_tell_joke_5_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_tell_joke_6_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_waitForNewEmo_tr0_tr0() {
		return sCICurrPerson.operationCallback.getCurrEmotion()!=-1;
	}
	
	private boolean check_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_resetEmo_tr0_tr0() {
		return sCICurrPerson.operationCallback.getCurrEmotion()!=-1;
	}
	
	private boolean check_main_FaceDataInterpretation_FaceDataInterpretation_sadFace_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_main_FaceDataInterpretation_FaceDataInterpretation_init_face_tr0_tr0() {
		return true;
	}
	
	private boolean check_main_FaceDataInterpretation_FaceDataInterpretation_yesNo_fun_inner_region_StartSTT_tr0_tr0() {
		return timeEvents[8];
	}
	
	private boolean check_main_FaceDataInterpretation_FaceDataInterpretation_yesNo_fun_inner_region_StartSTT_tr1_tr1() {
		return 0==1;
	}
	
	private boolean check_main_FaceDataInterpretation_FaceDataInterpretation_yesNo_fun_inner_region_StartSTT_tr2_tr2() {
		return 0==1;
	}
	
	private boolean check_main_FaceDataInterpretation_FaceDataInterpretation_yesNo_fun_inner_region_StartSTT_tr3_tr3() {
		return (sCILeapMotion.operationCallback.getGesture()== null?"true" ==null :sCILeapMotion.operationCallback.getGesture().equals("true"));
	}
	
	private boolean check_main_FaceDataInterpretation_FaceDataInterpretation_yesNo_fun_inner_region_StartSTT_tr4_tr4() {
		return (sCILeapMotion.operationCallback.getGesture()== null?"false" ==null :sCILeapMotion.operationCallback.getGesture().equals("false"));
	}
	
	private boolean check_main_FaceDataInterpretation_FaceDataInterpretation_yesNo_fun_inner_region_Copy_1_STT3_tr0_tr0() {
		return sCISTT.spokenTextReceived;
	}
	
	private boolean check_main_FaceDataInterpretation_FaceDataInterpretation_yesNo_fun_inner_region_asking_repeat_YesNo_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_main_FaceDataInterpretation_FaceDataInterpretation_yesNo_fun_inner_region_init_tr0_tr0() {
		return true;
	}
	
	private boolean check_main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_start_estimation_tr0_tr0() {
		return sCICurrPerson.operationCallback.getAttractiveness()!=-1;
	}
	
	private boolean check_main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_start_estimation_tr1_tr1() {
		return timeEvents[9];
	}
	
	private boolean check_main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_ready_tr0_tr0() {
		return sCICurrPerson.operationCallback.getAttractiveness()>=0.1 && sCICurrPerson.operationCallback.getGender();
	}
	
	private boolean check_main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_ready_tr1_tr1() {
		return sCICurrPerson.operationCallback.getAttractiveness()>=0.1 && sCICurrPerson.operationCallback.hasGlasses()==false;
	}
	
	private boolean check_main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_ready_tr2_tr2() {
		return sCICurrPerson.operationCallback.getAttractiveness()<0.1;
	}
	
	private boolean check_main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_pretty_with_glasses_tr0_tr0() {
		return sCIHBrain.tTSReady==true && sCICurrPerson.operationCallback.getGender()==false;
	}
	
	private boolean check_main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_got_new_attr_tr0_tr0() {
		return sCIAttractiveness.getOld_attr()<sCICurrPerson.operationCallback.getAttractiveness();
	}
	
	private boolean check_main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_got_new_attr_tr1_tr1() {
		return sCIAttractiveness.getOld_attr()>=sCICurrPerson.operationCallback.getAttractiveness();
	}
	
	private boolean check_main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_prettier_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_not_prettier_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_pretty_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_not_pretty_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_get_new_attractiveness_tr0_tr0() {
		return sCICurrPerson.operationCallback.getAttractiveness()!=-1;
	}
	
	private boolean check_main_FaceDataInterpretation_FaceDataInterpretation_asking_unknown_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_main_FaceDataInterpretation_FaceDataInterpretation_yesNoCancelFunNo_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_main_FaceDataInterpretation_FaceDataInterpretation_exitCancelAnswer_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_main_FaceDataInterpretation_FaceDataInterpretation_waitingForSpeaking_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_main_FaceDataInterpretation_FaceDataInterpretation_AfterGettingName_inner_region_AfterGettingName_tr0_tr0() {
		return sCIHBrain.tTSReady;
	}
	
	private boolean check_main_FaceDataInterpretation_FaceDataInterpretation_AfterGettingName_inner_region_newRandNum_tr0_tr0() {
		return timeEvents[10];
	}
	
	private boolean check_main_FaceDataInterpretation_FaceDataInterpretation_randNumEnd_tr0_tr0() {
		return timeEvents[11];
	}
	
	private boolean check_main_exitSad_tr0_tr0() {
		return timeEvents[12];
	}
	
	private boolean check_Leonie_Bupered_Or_Emergency_Stop_waitForEvent_tr0_tr0() {
		return sCIMira.bumpered;
	}
	
	private boolean check_Leonie_Bupered_Or_Emergency_Stop_waitForEvent_tr1_tr1() {
		return sCIMira.emergencyStop;
	}
	
	private boolean check_Leonie_Bupered_Or_Emergency_Stop_Bumpered_tr0_tr0() {
		return timeEvents[13];
	}
	
	private boolean check_Leonie_Bupered_Or_Emergency_Stop_resetFace_tr0_tr0() {
		return true;
	}
	
	private boolean check_Leonie_Bupered_Or_Emergency_Stop_EmergencyStop_tr0_tr0() {
		return true;
	}
	
	private boolean check_Leonie_Bupered_Or_Emergency_Stop_checkEmergency_tr0_tr0() {
		return timeEvents[14];
	}
	
	private boolean check_Leonie_Bupered_Or_Emergency_Stop_checkEmergency_tr1_tr1() {
		return sCIMira.emergencyStop;
	}
	
	private boolean check_main_FaceDataInterpretation_FaceDataInterpretation__choice_0_tr1_tr1() {
		return sCICurrPerson.operationCallback.isKnown()==true;
	}
	
	private boolean check_main_FaceDataInterpretation_FaceDataInterpretation__choice_0_tr0_tr0() {
		return true;
	}
	
	private boolean check_main_FaceDataInterpretation_FaceDataInterpretation__choice_1_tr0_tr0() {
		return (sCICurrPerson.operationCallback.getFirstname()== null?"" !=null : !sCICurrPerson.operationCallback.getFirstname().equals("")) && (sCICurrPerson.operationCallback.getFirstname()== null?"null" !=null : !sCICurrPerson.operationCallback.getFirstname().equals("null"));
	}
	
	private boolean check_main_FaceDataInterpretation_FaceDataInterpretation__choice_1_tr1_tr1() {
		return true;
	}
	
	private boolean check_main_FaceDataInterpretation_FaceDataInterpretation__choice_2_tr0_tr0() {
		return sCICurrPerson.operationCallback.getGender()==true;
	}
	
	private boolean check_main_FaceDataInterpretation_FaceDataInterpretation__choice_2_tr1_tr1() {
		return true;
	}
	
	private boolean check_main_FaceDataInterpretation_FaceDataInterpretation__choice_3_tr0_tr0() {
		return sCICurrPerson.operationCallback.getEstimatedAge()<=18;
	}
	
	private boolean check_main_FaceDataInterpretation_FaceDataInterpretation__choice_3_tr2_tr2() {
		return sCICurrPerson.operationCallback.getEstimatedAge()>=30;
	}
	
	private boolean check_main_FaceDataInterpretation_FaceDataInterpretation__choice_3_tr1_tr1() {
		return true;
	}
	
	private boolean check_main_FaceDataInterpretation_FaceDataInterpretation__choice_4_tr0_tr0() {
		return sCICurrPerson.operationCallback.getEstimatedAge()<=18;
	}
	
	private boolean check_main_FaceDataInterpretation_FaceDataInterpretation__choice_4_tr1_tr1() {
		return sCICurrPerson.operationCallback.getEstimatedAge()>=30;
	}
	
	private boolean check_main_FaceDataInterpretation_FaceDataInterpretation__choice_4_tr2_tr2() {
		return true;
	}
	
	private boolean check_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Yes_No_Question_inner_region__choice_0_tr0_tr0() {
		return getCounter()<4;
	}
	
	private boolean check_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Yes_No_Question_inner_region__choice_0_tr1_tr1() {
		return true;
	}
	
	private boolean check_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Yes_No_Question_inner_region__choice_1_tr0_tr0() {
		return (sCISTT.operationCallback.getSpokenText()== null?"yes" ==null :sCISTT.operationCallback.getSpokenText().equals("yes"));
	}
	
	private boolean check_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Yes_No_Question_inner_region__choice_1_tr1_tr1() {
		return (sCISTT.operationCallback.getSpokenText()== null?"no" ==null :sCISTT.operationCallback.getSpokenText().equals("no"));
	}
	
	private boolean check_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Yes_No_Question_inner_region__choice_1_tr2_tr2() {
		return true;
	}
	
	private boolean check_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName__choice_0_tr0_tr0() {
		return getCounter()<6;
	}
	
	private boolean check_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName__choice_0_tr1_tr1() {
		return true;
	}
	
	private boolean check_main_FaceDataInterpretation_FaceDataInterpretation_YesNo_MoreInfo_inner_region__choice_0_tr0_tr0() {
		return getCounter()<3;
	}
	
	private boolean check_main_FaceDataInterpretation_FaceDataInterpretation_YesNo_MoreInfo_inner_region__choice_0_tr1_tr1() {
		return true;
	}
	
	private boolean check_main_FaceDataInterpretation_FaceDataInterpretation_YesNo_MoreInfo_inner_region__choice_1_tr0_tr0() {
		return (sCISTT.operationCallback.getSpokenText()== null?"yes" ==null :sCISTT.operationCallback.getSpokenText().equals("yes"));
	}
	
	private boolean check_main_FaceDataInterpretation_FaceDataInterpretation_YesNo_MoreInfo_inner_region__choice_1_tr1_tr1() {
		return (sCISTT.operationCallback.getSpokenText()== null?"no" ==null :sCISTT.operationCallback.getSpokenText().equals("no"));
	}
	
	private boolean check_main_FaceDataInterpretation_FaceDataInterpretation_YesNo_MoreInfo_inner_region__choice_1_tr2_tr2() {
		return true;
	}
	
	private boolean check_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region__choice_0_tr1_tr1() {
		return sCICurrPerson.operationCallback.getCurrEmotion()==1;
	}
	
	private boolean check_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region__choice_0_tr2_tr2() {
		return sCICurrPerson.operationCallback.getCurrEmotion()==2;
	}
	
	private boolean check_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region__choice_0_tr3_tr3() {
		return sCICurrPerson.operationCallback.getCurrEmotion()==3;
	}
	
	private boolean check_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region__choice_0_tr4_tr4() {
		return sCICurrPerson.operationCallback.getCurrEmotion()==4;
	}
	
	private boolean check_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region__choice_0_tr5_tr5() {
		return sCICurrPerson.operationCallback.getCurrEmotion()==5;
	}
	
	private boolean check_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region__choice_0_tr0_tr0() {
		return true;
	}
	
	private boolean check_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region__choice_1_tr1_tr1() {
		return sCICurrPerson.operationCallback.getCurrEmotion()==4 || sCICurrPerson.operationCallback.getCurrEmotion()==5;
	}
	
	private boolean check_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region__choice_1_tr0_tr0() {
		return true;
	}
	
	private boolean check_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region__choice_2_tr1_tr1() {
		return sCIBGF.getRandNum()==1;
	}
	
	private boolean check_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region__choice_2_tr2_tr2() {
		return sCIBGF.getRandNum()==2;
	}
	
	private boolean check_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region__choice_2_tr3_tr3() {
		return sCIBGF.getRandNum()==3;
	}
	
	private boolean check_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region__choice_2_tr4_tr4() {
		return sCIBGF.getRandNum()==4;
	}
	
	private boolean check_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region__choice_2_tr5_tr5() {
		return sCIBGF.getRandNum()==5;
	}
	
	private boolean check_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region__choice_2_tr0_tr0() {
		return true;
	}
	
	private boolean check_main_FaceDataInterpretation_FaceDataInterpretation__choice_5_tr1_tr1() {
		return sCIBGF.getRandNum()<10;
	}
	
	private boolean check_main_FaceDataInterpretation_FaceDataInterpretation__choice_5_tr0_tr0() {
		return true;
	}
	
	private boolean check_main_FaceDataInterpretation_FaceDataInterpretation_yesNo_fun_inner_region__choice_0_tr0_tr0() {
		return getCounter()<3;
	}
	
	private boolean check_main_FaceDataInterpretation_FaceDataInterpretation_yesNo_fun_inner_region__choice_0_tr1_tr1() {
		return true;
	}
	
	private boolean check_main_FaceDataInterpretation_FaceDataInterpretation_yesNo_fun_inner_region__choice_1_tr0_tr0() {
		return (sCISTT.operationCallback.getSpokenText()== null?"yes" ==null :sCISTT.operationCallback.getSpokenText().equals("yes"));
	}
	
	private boolean check_main_FaceDataInterpretation_FaceDataInterpretation_yesNo_fun_inner_region__choice_1_tr1_tr1() {
		return (sCISTT.operationCallback.getSpokenText()== null?"no" ==null :sCISTT.operationCallback.getSpokenText().equals("no"));
	}
	
	private boolean check_main_FaceDataInterpretation_FaceDataInterpretation_yesNo_fun_inner_region__choice_1_tr2_tr2() {
		return true;
	}
	
	private boolean check_main_FaceDataInterpretation_FaceDataInterpretation__choice_6_tr0_tr0() {
		return sCICurrPerson.operationCallback.getGender()==true;
	}
	
	private boolean check_main_FaceDataInterpretation_FaceDataInterpretation__choice_6_tr1_tr1() {
		return true;
	}
	
	private boolean check_main_FaceDataInterpretation_FaceDataInterpretation_AfterGettingName_inner_region__choice_0_tr0_tr0() {
		return sCIBGF.getRandNum()<10;
	}
	
	private boolean check_main_FaceDataInterpretation_FaceDataInterpretation_AfterGettingName_inner_region__choice_0_tr1_tr1() {
		return true;
	}
	
	private void effect_main_Init_tr0() {
		exitSequence_main_Init();
		enterSequence_main_AtWP01___ACI_default();
	}
	
	private void effect_main_AtWP01___ACI_tr0() {
		exitSequence_main_AtWP01___ACI();
		enterSequence_main_wait_for_cleaning_VBrain_buffer_default();
	}
	
	private void effect_main_wait_for_cleaning_VBrain_buffer_tr0() {
		exitSequence_main_wait_for_cleaning_VBrain_buffer();
		enterSequence_main_FaceDataInterpretation_default();
	}
	
	private void effect_main_FaceDataInterpretation_tr0() {
		exitSequence_main_FaceDataInterpretation();
		enterSequence_main_wait_default();
	}
	
	private void effect_main_FaceDataInterpretation_tr1() {
		exitSequence_main_FaceDataInterpretation();
		enterSequence_main_exitSad_default();
	}
	
	private void effect_main_FaceDataInterpretation_FaceDataInterpretation_PersonKnownWithName_tr0() {
		exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_PersonKnownWithName();
		enterSequence_main_FaceDataInterpretation_FaceDataInterpretation_wait_for_getting_datas_default();
	}
	
	private void effect_main_FaceDataInterpretation_FaceDataInterpretation_UnknownGirl_tr0() {
		exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_UnknownGirl();
		enterSequence_main_FaceDataInterpretation_FaceDataInterpretation_asking_unknown_default();
	}
	
	private void effect_main_FaceDataInterpretation_FaceDataInterpretation_PersonKnownWithoutName_tr0() {
		exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_PersonKnownWithoutName();
		enterSequence_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_default();
	}
	
	private void effect_main_FaceDataInterpretation_FaceDataInterpretation_UnknownFemaleTeen_tr0() {
		exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_UnknownFemaleTeen();
		enterSequence_main_FaceDataInterpretation_FaceDataInterpretation_asking_unknown_default();
	}
	
	private void effect_main_FaceDataInterpretation_FaceDataInterpretation_UnknownWomen_tr0() {
		exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_UnknownWomen();
		enterSequence_main_FaceDataInterpretation_FaceDataInterpretation_asking_unknown_default();
	}
	
	private void effect_main_FaceDataInterpretation_FaceDataInterpretation_UnknownBoy_tr0() {
		exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_UnknownBoy();
		enterSequence_main_FaceDataInterpretation_FaceDataInterpretation_asking_unknown_default();
	}
	
	private void effect_main_FaceDataInterpretation_FaceDataInterpretation_UnknownMaleTeen_tr0() {
		exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_UnknownMaleTeen();
		enterSequence_main_FaceDataInterpretation_FaceDataInterpretation_asking_unknown_default();
	}
	
	private void effect_main_FaceDataInterpretation_FaceDataInterpretation_UnknownMen_tr0() {
		exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_UnknownMen();
		enterSequence_main_FaceDataInterpretation_FaceDataInterpretation_asking_unknown_default();
	}
	
	private void effect_main_FaceDataInterpretation_FaceDataInterpretation_wait_for_getting_datas_tr0() {
		exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_wait_for_getting_datas();
		react_main_FaceDataInterpretation_FaceDataInterpretation__choice_6();
	}
	
	private void effect_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_tr0() {
		exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name();
		enterSequence_main_FaceDataInterpretation_FaceDataInterpretation_AfterGettingName_default();
	}
	
	private void effect_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_tr1() {
		exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name();
		enterSequence_main_FaceDataInterpretation_FaceDataInterpretation_newRandNum_default();
	}
	
	private void effect_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_STT_1_tr0() {
		exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_STT_1();
		enterSequence_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_STT3_default();
	}
	
	private void effect_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Answere_name__and_ask_tr0() {
		exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Answere_name__and_ask();
		enterSequence_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Yes_No_Question_default();
	}
	
	private void effect_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_STT3_tr0() {
		exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_STT3();
		enterSequence_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Didnt_get_it_default();
	}
	
	private void effect_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_STT3_tr1() {
		exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_STT3();
		enterSequence_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Answere_name__and_ask_default();
	}
	
	private void effect_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Save_Firstname_tr0() {
		exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Save_Firstname();
		react_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_exit_NameSaved();
	}
	
	private void effect_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Ask_for_Repeat_tr0() {
		exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Ask_for_Repeat();
		enterSequence_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_STT_1_default();
	}
	
	private void effect_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Didnt_get_it_tr0() {
		exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Didnt_get_it();
		react_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName__choice_0();
	}
	
	private void effect_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Bye_bye_tr0() {
		exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Bye_bye();
		react_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_exit_NameNotSaved();
	}
	
	private void effect_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Yes_No_Question_tr0() {
		exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Yes_No_Question();
		enterSequence_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Save_Firstname_default();
	}
	
	private void effect_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Yes_No_Question_tr1() {
		exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Yes_No_Question();
		enterSequence_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Bye_bye_default();
	}
	
	private void effect_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Yes_No_Question_tr2() {
		exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Yes_No_Question();
		enterSequence_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Ask_for_Repeat_default();
	}
	
	private void effect_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Yes_No_Question_tr3() {
		exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Yes_No_Question();
		enterSequence_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_asking_repeat_YesNo_default();
	}
	
	private void effect_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Yes_No_Question_inner_region_StartSTT_tr0() {
		exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Yes_No_Question_inner_region_StartSTT();
		enterSequence_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Yes_No_Question_inner_region_Copy_1_STT3_default();
	}
	
	private void effect_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Yes_No_Question_inner_region_StartSTT_tr1() {
		exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Yes_No_Question_inner_region_StartSTT();
		react_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Yes_No_Question_inner_region_exit_yes();
	}
	
	private void effect_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Yes_No_Question_inner_region_StartSTT_tr2() {
		exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Yes_No_Question_inner_region_StartSTT();
		react_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Yes_No_Question_inner_region_exit_no();
	}
	
	private void effect_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Yes_No_Question_inner_region_StartSTT_tr3() {
		exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Yes_No_Question_inner_region_StartSTT();
		react_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Yes_No_Question_inner_region_exit_yes();
	}
	
	private void effect_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Yes_No_Question_inner_region_StartSTT_tr4() {
		exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Yes_No_Question_inner_region_StartSTT();
		react_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Yes_No_Question_inner_region_exit_no();
	}
	
	private void effect_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Yes_No_Question_inner_region_Copy_1_STT3_tr0() {
		exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Yes_No_Question_inner_region_Copy_1_STT3();
		react_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Yes_No_Question_inner_region__choice_1();
	}
	
	private void effect_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_asking_repeat_YesNo_tr0() {
		exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_asking_repeat_YesNo();
		enterSequence_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Yes_No_Question_default();
	}
	
	private void effect_main_FaceDataInterpretation_FaceDataInterpretation_AboutRobotica_1_tr0() {
		exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_AboutRobotica_1();
		enterSequence_main_FaceDataInterpretation_FaceDataInterpretation_Closing_default();
	}
	
	private void effect_main_FaceDataInterpretation_FaceDataInterpretation_AboutRobotica_2_tr0() {
		exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_AboutRobotica_2();
		enterSequence_main_FaceDataInterpretation_FaceDataInterpretation_Closing_default();
	}
	
	private void effect_main_FaceDataInterpretation_FaceDataInterpretation_RandomTopic_1_tr0() {
		exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_RandomTopic_1();
		enterSequence_main_FaceDataInterpretation_FaceDataInterpretation_Closing_default();
	}
	
	private void effect_main_FaceDataInterpretation_FaceDataInterpretation_RandomTopic_2_tr0() {
		exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_RandomTopic_2();
		enterSequence_main_FaceDataInterpretation_FaceDataInterpretation_Closing_default();
	}
	
	private void effect_main_FaceDataInterpretation_FaceDataInterpretation_Prompt_2_tr0() {
		exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_Prompt_2();
		enterSequence_main_FaceDataInterpretation_FaceDataInterpretation_YesNo_MoreInfo_default();
	}
	
	private void effect_main_FaceDataInterpretation_FaceDataInterpretation_Prompt_1_tr0() {
		exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_Prompt_1();
		enterSequence_main_FaceDataInterpretation_FaceDataInterpretation_yesNo_fun_default();
	}
	
	private void effect_main_FaceDataInterpretation_FaceDataInterpretation_Farewell_1_tr0() {
		exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_Farewell_1();
		enterSequence_main_FaceDataInterpretation_FaceDataInterpretation_waitingForSpeaking_default();
	}
	
	private void effect_main_FaceDataInterpretation_FaceDataInterpretation_Farewell_2_tr0() {
		exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_Farewell_2();
		enterSequence_main_FaceDataInterpretation_FaceDataInterpretation_waitingForSpeaking_default();
	}
	
	private void effect_main_FaceDataInterpretation_FaceDataInterpretation_Farewell_3_tr0() {
		exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_Farewell_3();
		enterSequence_main_FaceDataInterpretation_FaceDataInterpretation_waitingForSpeaking_default();
	}
	
	private void effect_main_FaceDataInterpretation_FaceDataInterpretation_Farewell_4_tr0() {
		exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_Farewell_4();
		enterSequence_main_FaceDataInterpretation_FaceDataInterpretation_waitingForSpeaking_default();
	}
	
	private void effect_main_FaceDataInterpretation_FaceDataInterpretation_Selection_tr0() {
		exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_Selection();
		enterSequence_main_FaceDataInterpretation_FaceDataInterpretation_Farewell_1_default();
	}
	
	private void effect_main_FaceDataInterpretation_FaceDataInterpretation_Selection_tr1() {
		exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_Selection();
		enterSequence_main_FaceDataInterpretation_FaceDataInterpretation_Farewell_2_default();
	}
	
	private void effect_main_FaceDataInterpretation_FaceDataInterpretation_Selection_tr2() {
		exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_Selection();
		enterSequence_main_FaceDataInterpretation_FaceDataInterpretation_Farewell_3_default();
	}
	
	private void effect_main_FaceDataInterpretation_FaceDataInterpretation_Selection_tr3() {
		exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_Selection();
		enterSequence_main_FaceDataInterpretation_FaceDataInterpretation_Farewell_4_default();
	}
	
	private void effect_main_FaceDataInterpretation_FaceDataInterpretation_newRandNum_tr0() {
		exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_newRandNum();
		react_main_FaceDataInterpretation_FaceDataInterpretation__choice_5();
	}
	
	private void effect_main_FaceDataInterpretation_FaceDataInterpretation_RandomTopic_3_tr0() {
		exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_RandomTopic_3();
		enterSequence_main_FaceDataInterpretation_FaceDataInterpretation_Closing_default();
	}
	
	private void effect_main_FaceDataInterpretation_FaceDataInterpretation_Selection_2_tr0() {
		exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_Selection_2();
		enterSequence_main_FaceDataInterpretation_FaceDataInterpretation_AboutRobotica_1_default();
	}
	
	private void effect_main_FaceDataInterpretation_FaceDataInterpretation_Selection_2_tr1() {
		exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_Selection_2();
		enterSequence_main_FaceDataInterpretation_FaceDataInterpretation_AboutRobotica_2_default();
	}
	
	private void effect_main_FaceDataInterpretation_FaceDataInterpretation_Selection_2_tr2() {
		exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_Selection_2();
		enterSequence_main_FaceDataInterpretation_FaceDataInterpretation_AboutRobotica_3_default();
	}
	
	private void effect_main_FaceDataInterpretation_FaceDataInterpretation_AlternativeConv_1_tr0() {
		exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_AlternativeConv_1();
		enterSequence_main_FaceDataInterpretation_FaceDataInterpretation_Selection_2_default();
	}
	
	private void effect_main_FaceDataInterpretation_FaceDataInterpretation_Selection_3_tr0() {
		exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_Selection_3();
		enterSequence_main_FaceDataInterpretation_FaceDataInterpretation_RandomTopic_2_default();
	}
	
	private void effect_main_FaceDataInterpretation_FaceDataInterpretation_Selection_3_tr1() {
		exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_Selection_3();
		enterSequence_main_FaceDataInterpretation_FaceDataInterpretation_RandomTopic_3_default();
	}
	
	private void effect_main_FaceDataInterpretation_FaceDataInterpretation_Selection_3_tr2() {
		exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_Selection_3();
		enterSequence_main_FaceDataInterpretation_FaceDataInterpretation_RandomTopic_1_default();
	}
	
	private void effect_main_FaceDataInterpretation_FaceDataInterpretation_YesNo_MoreInfo_tr0() {
		exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_YesNo_MoreInfo();
		enterSequence_main_FaceDataInterpretation_FaceDataInterpretation_Selection_3_default();
	}
	
	private void effect_main_FaceDataInterpretation_FaceDataInterpretation_YesNo_MoreInfo_tr1() {
		exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_YesNo_MoreInfo();
		enterSequence_main_FaceDataInterpretation_FaceDataInterpretation_sadFace_default();
	}
	
	private void effect_main_FaceDataInterpretation_FaceDataInterpretation_YesNo_MoreInfo_tr2() {
		exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_YesNo_MoreInfo();
		enterSequence_main_FaceDataInterpretation_FaceDataInterpretation_exitCancelAnswer_default();
	}
	
	private void effect_main_FaceDataInterpretation_FaceDataInterpretation_YesNo_MoreInfo_inner_region_StartSTT_tr0() {
		exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_YesNo_MoreInfo_inner_region_StartSTT();
		enterSequence_main_FaceDataInterpretation_FaceDataInterpretation_YesNo_MoreInfo_inner_region_Copy_1_STT3_default();
	}
	
	private void effect_main_FaceDataInterpretation_FaceDataInterpretation_YesNo_MoreInfo_inner_region_StartSTT_tr1() {
		exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_YesNo_MoreInfo_inner_region_StartSTT();
		react_main_FaceDataInterpretation_FaceDataInterpretation_YesNo_MoreInfo_inner_region_exit_yes();
	}
	
	private void effect_main_FaceDataInterpretation_FaceDataInterpretation_YesNo_MoreInfo_inner_region_StartSTT_tr2() {
		exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_YesNo_MoreInfo_inner_region_StartSTT();
		react_main_FaceDataInterpretation_FaceDataInterpretation_YesNo_MoreInfo_inner_region_exit_no();
	}
	
	private void effect_main_FaceDataInterpretation_FaceDataInterpretation_YesNo_MoreInfo_inner_region_StartSTT_tr3() {
		exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_YesNo_MoreInfo_inner_region_StartSTT();
		react_main_FaceDataInterpretation_FaceDataInterpretation_YesNo_MoreInfo_inner_region_exit_yes();
	}
	
	private void effect_main_FaceDataInterpretation_FaceDataInterpretation_YesNo_MoreInfo_inner_region_StartSTT_tr4() {
		exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_YesNo_MoreInfo_inner_region_StartSTT();
		react_main_FaceDataInterpretation_FaceDataInterpretation_YesNo_MoreInfo_inner_region_exit_no();
	}
	
	private void effect_main_FaceDataInterpretation_FaceDataInterpretation_YesNo_MoreInfo_inner_region_Copy_1_STT3_tr0() {
		exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_YesNo_MoreInfo_inner_region_Copy_1_STT3();
		react_main_FaceDataInterpretation_FaceDataInterpretation_YesNo_MoreInfo_inner_region__choice_1();
	}
	
	private void effect_main_FaceDataInterpretation_FaceDataInterpretation_YesNo_MoreInfo_inner_region_asking_repeat_YesNo_tr0() {
		exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_YesNo_MoreInfo_inner_region_asking_repeat_YesNo();
		enterSequence_main_FaceDataInterpretation_FaceDataInterpretation_YesNo_MoreInfo_inner_region_StartSTT_default();
	}
	
	private void effect_main_FaceDataInterpretation_FaceDataInterpretation_YesNo_MoreInfo_inner_region_init_tr0() {
		exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_YesNo_MoreInfo_inner_region_init();
		enterSequence_main_FaceDataInterpretation_FaceDataInterpretation_YesNo_MoreInfo_inner_region_StartSTT_default();
	}
	
	private void effect_main_FaceDataInterpretation_FaceDataInterpretation_AboutRobotica_3_tr0() {
		exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_AboutRobotica_3();
		enterSequence_main_FaceDataInterpretation_FaceDataInterpretation_Closing_default();
	}
	
	private void effect_main_FaceDataInterpretation_FaceDataInterpretation_Closing_tr0() {
		exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_Closing();
		enterSequence_main_FaceDataInterpretation_FaceDataInterpretation_randNumEnd_default();
	}
	
	private void effect_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_tr0() {
		exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation();
		enterSequence_main_FaceDataInterpretation_FaceDataInterpretation_newRandNum_default();
	}
	
	private void effect_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_tr1() {
		exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation();
		enterSequence_main_FaceDataInterpretation_FaceDataInterpretation_randNumEnd_default();
	}
	
	private void effect_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_neutral_tr0() {
		exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_neutral();
		enterSequence_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_initialise_jokes_default();
	}
	
	private void effect_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_happy_tr0() {
		exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_happy();
		react_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_exit_Emotion_Interpretation0();
	}
	
	private void effect_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_sad_tr0() {
		exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_sad();
		enterSequence_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_initialise_jokes_default();
	}
	
	private void effect_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_laughing_tr0() {
		exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_laughing();
		react_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_exit_Emotion_Interpretation0();
	}
	
	private void effect_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_surprised_tr0() {
		exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_surprised();
		react_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_exit_Emotion_Interpretation0();
	}
	
	private void effect_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_angry_tr0() {
		exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_angry();
		enterSequence_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_initialise_jokes_default();
	}
	
	private void effect_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_tell_joke_0_tr0() {
		exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_tell_joke_0();
		enterSequence_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_waitForNewEmo_default();
	}
	
	private void effect_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_joke_worked_tr0() {
		exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_joke_worked();
		react_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_exit_endCon();
	}
	
	private void effect_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_initialise_jokes_tr0() {
		exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_initialise_jokes();
		react_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region__choice_2();
	}
	
	private void effect_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_joke_didnt_work_tr0() {
		exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_joke_didnt_work();
		react_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region__choice_2();
	}
	
	private void effect_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_tell_joke_1_tr0() {
		exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_tell_joke_1();
		enterSequence_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_waitForNewEmo_default();
	}
	
	private void effect_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_tell_joke_2_tr0() {
		exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_tell_joke_2();
		enterSequence_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_waitForNewEmo_default();
	}
	
	private void effect_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_tell_joke_3_tr0() {
		exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_tell_joke_3();
		enterSequence_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_waitForNewEmo_default();
	}
	
	private void effect_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_tell_joke_5_tr0() {
		exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_tell_joke_5();
		enterSequence_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_waitForNewEmo_default();
	}
	
	private void effect_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_tell_joke_6_tr0() {
		exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_tell_joke_6();
		enterSequence_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_waitForNewEmo_default();
	}
	
	private void effect_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_waitForNewEmo_tr0() {
		exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_waitForNewEmo();
		react_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region__choice_1();
	}
	
	private void effect_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_resetEmo_tr0() {
		exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_resetEmo();
		react_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region__choice_0();
	}
	
	private void effect_main_FaceDataInterpretation_FaceDataInterpretation_sadFace_tr0() {
		exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_sadFace();
		react_main_FaceDataInterpretation_FaceDataInterpretation_exit_FDI_sad();
	}
	
	private void effect_main_FaceDataInterpretation_FaceDataInterpretation_init_face_tr0() {
		exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_init_face();
		react_main_FaceDataInterpretation_FaceDataInterpretation__choice_0();
	}
	
	private void effect_main_FaceDataInterpretation_FaceDataInterpretation_yesNo_fun_tr0() {
		exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_yesNo_fun();
		enterSequence_main_FaceDataInterpretation_FaceDataInterpretation_AlternativeConv_1_default();
	}
	
	private void effect_main_FaceDataInterpretation_FaceDataInterpretation_yesNo_fun_tr1() {
		exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_yesNo_fun();
		enterSequence_main_FaceDataInterpretation_FaceDataInterpretation_Selection_2_default();
	}
	
	private void effect_main_FaceDataInterpretation_FaceDataInterpretation_yesNo_fun_tr2() {
		exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_yesNo_fun();
		enterSequence_main_FaceDataInterpretation_FaceDataInterpretation_yesNoCancelFunNo_default();
	}
	
	private void effect_main_FaceDataInterpretation_FaceDataInterpretation_yesNo_fun_inner_region_StartSTT_tr0() {
		exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_yesNo_fun_inner_region_StartSTT();
		enterSequence_main_FaceDataInterpretation_FaceDataInterpretation_yesNo_fun_inner_region_Copy_1_STT3_default();
	}
	
	private void effect_main_FaceDataInterpretation_FaceDataInterpretation_yesNo_fun_inner_region_StartSTT_tr1() {
		exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_yesNo_fun_inner_region_StartSTT();
		react_main_FaceDataInterpretation_FaceDataInterpretation_yesNo_fun_inner_region_exit_yes();
	}
	
	private void effect_main_FaceDataInterpretation_FaceDataInterpretation_yesNo_fun_inner_region_StartSTT_tr2() {
		exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_yesNo_fun_inner_region_StartSTT();
		react_main_FaceDataInterpretation_FaceDataInterpretation_yesNo_fun_inner_region_exit_no();
	}
	
	private void effect_main_FaceDataInterpretation_FaceDataInterpretation_yesNo_fun_inner_region_StartSTT_tr3() {
		exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_yesNo_fun_inner_region_StartSTT();
		react_main_FaceDataInterpretation_FaceDataInterpretation_yesNo_fun_inner_region_exit_yes();
	}
	
	private void effect_main_FaceDataInterpretation_FaceDataInterpretation_yesNo_fun_inner_region_StartSTT_tr4() {
		exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_yesNo_fun_inner_region_StartSTT();
		react_main_FaceDataInterpretation_FaceDataInterpretation_yesNo_fun_inner_region_exit_no();
	}
	
	private void effect_main_FaceDataInterpretation_FaceDataInterpretation_yesNo_fun_inner_region_Copy_1_STT3_tr0() {
		exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_yesNo_fun_inner_region_Copy_1_STT3();
		react_main_FaceDataInterpretation_FaceDataInterpretation_yesNo_fun_inner_region__choice_1();
	}
	
	private void effect_main_FaceDataInterpretation_FaceDataInterpretation_yesNo_fun_inner_region_asking_repeat_YesNo_tr0() {
		exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_yesNo_fun_inner_region_asking_repeat_YesNo();
		enterSequence_main_FaceDataInterpretation_FaceDataInterpretation_yesNo_fun_inner_region_StartSTT_default();
	}
	
	private void effect_main_FaceDataInterpretation_FaceDataInterpretation_yesNo_fun_inner_region_init_tr0() {
		exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_yesNo_fun_inner_region_init();
		enterSequence_main_FaceDataInterpretation_FaceDataInterpretation_yesNo_fun_inner_region_StartSTT_default();
	}
	
	private void effect_main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_tr0() {
		exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_attractiveness();
		enterSequence_main_FaceDataInterpretation_FaceDataInterpretation_randNumEnd_default();
	}
	
	private void effect_main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_tr1() {
		exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_attractiveness();
		enterSequence_main_FaceDataInterpretation_FaceDataInterpretation_newRandNum_default();
	}
	
	private void effect_main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_start_estimation_tr0() {
		exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_start_estimation();
		enterSequence_main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_ready_default();
	}
	
	private void effect_main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_start_estimation_tr1() {
		exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_start_estimation();
		react_main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_exit_endCon();
	}
	
	private void effect_main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_ready_tr0() {
		exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_ready();
		enterSequence_main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_pretty_with_glasses_default();
	}
	
	private void effect_main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_ready_tr1() {
		exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_ready();
		enterSequence_main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_pretty_default();
	}
	
	private void effect_main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_ready_tr2() {
		exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_ready();
		enterSequence_main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_not_pretty_default();
	}
	
	private void effect_main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_pretty_with_glasses_tr0() {
		exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_pretty_with_glasses();
		enterSequence_main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_get_new_attractiveness_default();
	}
	
	private void effect_main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_got_new_attr_tr0() {
		exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_got_new_attr();
		enterSequence_main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_prettier_default();
	}
	
	private void effect_main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_got_new_attr_tr1() {
		exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_got_new_attr();
		enterSequence_main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_not_prettier_default();
	}
	
	private void effect_main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_prettier_tr0() {
		exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_prettier();
		react_main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_exit_endCon();
	}
	
	private void effect_main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_not_prettier_tr0() {
		exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_not_prettier();
		react_main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_exit_endCon();
	}
	
	private void effect_main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_pretty_tr0() {
		exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_pretty();
		react_main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_exit_default();
	}
	
	private void effect_main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_not_pretty_tr0() {
		exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_not_pretty();
		react_main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_exit_endCon();
	}
	
	private void effect_main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_get_new_attractiveness_tr0() {
		exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_get_new_attractiveness();
		enterSequence_main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_got_new_attr_default();
	}
	
	private void effect_main_FaceDataInterpretation_FaceDataInterpretation_asking_unknown_tr0() {
		exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_asking_unknown();
		enterSequence_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_default();
	}
	
	private void effect_main_FaceDataInterpretation_FaceDataInterpretation_yesNoCancelFunNo_tr0() {
		exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_yesNoCancelFunNo();
		enterSequence_main_FaceDataInterpretation_FaceDataInterpretation_Selection_2_default();
	}
	
	private void effect_main_FaceDataInterpretation_FaceDataInterpretation_exitCancelAnswer_tr0() {
		exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_exitCancelAnswer();
		enterSequence_main_FaceDataInterpretation_FaceDataInterpretation_Selection_3_default();
	}
	
	private void effect_main_FaceDataInterpretation_FaceDataInterpretation_waitingForSpeaking_tr0() {
		exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_waitingForSpeaking();
		react_main_FaceDataInterpretation_FaceDataInterpretation_exit_FDI();
	}
	
	private void effect_main_FaceDataInterpretation_FaceDataInterpretation_AfterGettingName_tr0() {
		exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_AfterGettingName();
		enterSequence_main_FaceDataInterpretation_FaceDataInterpretation_newRandNum_default();
	}
	
	private void effect_main_FaceDataInterpretation_FaceDataInterpretation_AfterGettingName_inner_region_AfterGettingName_tr0() {
		exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_AfterGettingName_inner_region_AfterGettingName();
		react_main_FaceDataInterpretation_FaceDataInterpretation_AfterGettingName_inner_region_exit_AfterGettingName0();
	}
	
	private void effect_main_FaceDataInterpretation_FaceDataInterpretation_AfterGettingName_inner_region_newRandNum_tr0() {
		exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_AfterGettingName_inner_region_newRandNum();
		react_main_FaceDataInterpretation_FaceDataInterpretation_AfterGettingName_inner_region__choice_0();
	}
	
	private void effect_main_FaceDataInterpretation_FaceDataInterpretation_randNumEnd_tr0() {
		exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_randNumEnd();
		enterSequence_main_FaceDataInterpretation_FaceDataInterpretation_Selection_default();
	}
	
	private void effect_main_exitSad_tr0() {
		exitSequence_main_exitSad();
		enterSequence_main_wait_default();
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
	
	private void effect_main_FaceDataInterpretation_FaceDataInterpretation__choice_0_tr1() {
		react_main_FaceDataInterpretation_FaceDataInterpretation__choice_1();
	}
	
	private void effect_main_FaceDataInterpretation_FaceDataInterpretation__choice_0_tr0() {
		react_main_FaceDataInterpretation_FaceDataInterpretation__choice_2();
	}
	
	private void effect_main_FaceDataInterpretation_FaceDataInterpretation__choice_1_tr0() {
		enterSequence_main_FaceDataInterpretation_FaceDataInterpretation_PersonKnownWithName_default();
	}
	
	private void effect_main_FaceDataInterpretation_FaceDataInterpretation__choice_1_tr1() {
		enterSequence_main_FaceDataInterpretation_FaceDataInterpretation_PersonKnownWithoutName_default();
	}
	
	private void effect_main_FaceDataInterpretation_FaceDataInterpretation__choice_2_tr0() {
		react_main_FaceDataInterpretation_FaceDataInterpretation__choice_3();
	}
	
	private void effect_main_FaceDataInterpretation_FaceDataInterpretation__choice_2_tr1() {
		react_main_FaceDataInterpretation_FaceDataInterpretation__choice_4();
	}
	
	private void effect_main_FaceDataInterpretation_FaceDataInterpretation__choice_3_tr0() {
		enterSequence_main_FaceDataInterpretation_FaceDataInterpretation_UnknownGirl_default();
	}
	
	private void effect_main_FaceDataInterpretation_FaceDataInterpretation__choice_3_tr2() {
		enterSequence_main_FaceDataInterpretation_FaceDataInterpretation_UnknownWomen_default();
	}
	
	private void effect_main_FaceDataInterpretation_FaceDataInterpretation__choice_3_tr1() {
		enterSequence_main_FaceDataInterpretation_FaceDataInterpretation_UnknownFemaleTeen_default();
	}
	
	private void effect_main_FaceDataInterpretation_FaceDataInterpretation__choice_4_tr0() {
		enterSequence_main_FaceDataInterpretation_FaceDataInterpretation_UnknownBoy_default();
	}
	
	private void effect_main_FaceDataInterpretation_FaceDataInterpretation__choice_4_tr1() {
		enterSequence_main_FaceDataInterpretation_FaceDataInterpretation_UnknownMen_default();
	}
	
	private void effect_main_FaceDataInterpretation_FaceDataInterpretation__choice_4_tr2() {
		enterSequence_main_FaceDataInterpretation_FaceDataInterpretation_UnknownMaleTeen_default();
	}
	
	private void effect_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Yes_No_Question_inner_region__choice_0_tr0() {
		react_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Yes_No_Question_inner_region_exit_repeat();
	}
	
	private void effect_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Yes_No_Question_inner_region__choice_0_tr1() {
		react_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Yes_No_Question_inner_region_exit_interrupt();
	}
	
	private void effect_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Yes_No_Question_inner_region__choice_1_tr0() {
		react_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Yes_No_Question_inner_region_exit_yes();
	}
	
	private void effect_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Yes_No_Question_inner_region__choice_1_tr1() {
		react_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Yes_No_Question_inner_region_exit_no();
	}
	
	private void effect_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Yes_No_Question_inner_region__choice_1_tr2() {
		react_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Yes_No_Question_inner_region__choice_0();
	}
	
	private void effect_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName__choice_0_tr0() {
		enterSequence_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Ask_for_Repeat_default();
	}
	
	private void effect_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName__choice_0_tr1() {
		enterSequence_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Bye_bye_default();
	}
	
	private void effect_main_FaceDataInterpretation_FaceDataInterpretation_YesNo_MoreInfo_inner_region__choice_0_tr0() {
		enterSequence_main_FaceDataInterpretation_FaceDataInterpretation_YesNo_MoreInfo_inner_region_asking_repeat_YesNo_default();
	}
	
	private void effect_main_FaceDataInterpretation_FaceDataInterpretation_YesNo_MoreInfo_inner_region__choice_0_tr1() {
		react_main_FaceDataInterpretation_FaceDataInterpretation_YesNo_MoreInfo_inner_region_exit_cancel();
	}
	
	private void effect_main_FaceDataInterpretation_FaceDataInterpretation_YesNo_MoreInfo_inner_region__choice_1_tr0() {
		react_main_FaceDataInterpretation_FaceDataInterpretation_YesNo_MoreInfo_inner_region_exit_yes();
	}
	
	private void effect_main_FaceDataInterpretation_FaceDataInterpretation_YesNo_MoreInfo_inner_region__choice_1_tr1() {
		react_main_FaceDataInterpretation_FaceDataInterpretation_YesNo_MoreInfo_inner_region_exit_no();
	}
	
	private void effect_main_FaceDataInterpretation_FaceDataInterpretation_YesNo_MoreInfo_inner_region__choice_1_tr2() {
		react_main_FaceDataInterpretation_FaceDataInterpretation_YesNo_MoreInfo_inner_region__choice_0();
	}
	
	private void effect_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region__choice_0_tr1() {
		enterSequence_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_happy_default();
	}
	
	private void effect_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region__choice_0_tr2() {
		enterSequence_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_surprised_default();
	}
	
	private void effect_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region__choice_0_tr3() {
		enterSequence_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_laughing_default();
	}
	
	private void effect_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region__choice_0_tr4() {
		enterSequence_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_angry_default();
	}
	
	private void effect_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region__choice_0_tr5() {
		enterSequence_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_sad_default();
	}
	
	private void effect_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region__choice_0_tr0() {
		enterSequence_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_neutral_default();
	}
	
	private void effect_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region__choice_1_tr1() {
		enterSequence_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_joke_didnt_work_default();
	}
	
	private void effect_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region__choice_1_tr0() {
		enterSequence_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_joke_worked_default();
	}
	
	private void effect_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region__choice_2_tr1() {
		enterSequence_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_tell_joke_1_default();
	}
	
	private void effect_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region__choice_2_tr2() {
		enterSequence_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_tell_joke_2_default();
	}
	
	private void effect_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region__choice_2_tr3() {
		enterSequence_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_tell_joke_3_default();
	}
	
	private void effect_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region__choice_2_tr4() {
		enterSequence_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_tell_joke_5_default();
	}
	
	private void effect_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region__choice_2_tr5() {
		enterSequence_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_tell_joke_6_default();
	}
	
	private void effect_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region__choice_2_tr0() {
		enterSequence_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_tell_joke_0_default();
	}
	
	private void effect_main_FaceDataInterpretation_FaceDataInterpretation__choice_5_tr1() {
		enterSequence_main_FaceDataInterpretation_FaceDataInterpretation_Prompt_2_default();
	}
	
	private void effect_main_FaceDataInterpretation_FaceDataInterpretation__choice_5_tr0() {
		enterSequence_main_FaceDataInterpretation_FaceDataInterpretation_Prompt_1_default();
	}
	
	private void effect_main_FaceDataInterpretation_FaceDataInterpretation_yesNo_fun_inner_region__choice_0_tr0() {
		enterSequence_main_FaceDataInterpretation_FaceDataInterpretation_yesNo_fun_inner_region_asking_repeat_YesNo_default();
	}
	
	private void effect_main_FaceDataInterpretation_FaceDataInterpretation_yesNo_fun_inner_region__choice_0_tr1() {
		react_main_FaceDataInterpretation_FaceDataInterpretation_yesNo_fun_inner_region_exit_cancel();
	}
	
	private void effect_main_FaceDataInterpretation_FaceDataInterpretation_yesNo_fun_inner_region__choice_1_tr0() {
		react_main_FaceDataInterpretation_FaceDataInterpretation_yesNo_fun_inner_region_exit_yes();
	}
	
	private void effect_main_FaceDataInterpretation_FaceDataInterpretation_yesNo_fun_inner_region__choice_1_tr1() {
		react_main_FaceDataInterpretation_FaceDataInterpretation_yesNo_fun_inner_region_exit_no();
	}
	
	private void effect_main_FaceDataInterpretation_FaceDataInterpretation_yesNo_fun_inner_region__choice_1_tr2() {
		react_main_FaceDataInterpretation_FaceDataInterpretation_yesNo_fun_inner_region__choice_0();
	}
	
	private void effect_main_FaceDataInterpretation_FaceDataInterpretation__choice_6_tr0() {
		enterSequence_main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_default();
	}
	
	private void effect_main_FaceDataInterpretation_FaceDataInterpretation__choice_6_tr1() {
		enterSequence_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_default();
	}
	
	private void effect_main_FaceDataInterpretation_FaceDataInterpretation_AfterGettingName_inner_region__choice_0_tr0() {
		enterSequence_main_FaceDataInterpretation_FaceDataInterpretation_AfterGettingName_inner_region_AfterGettingName_default();
	}
	
	private void effect_main_FaceDataInterpretation_FaceDataInterpretation_AfterGettingName_inner_region__choice_0_tr1() {
		react_main_FaceDataInterpretation_FaceDataInterpretation_AfterGettingName_inner_region_exit_AfterGettingName0();
	}
	
	/* Entry action for state 'Init'. */
	private void entryAction_main_Init() {
		sCIBGF.setEventNum(0);
	}
	
	/* Entry action for state 'AtWP01 - ACI'. */
	private void entryAction_main_AtWP01___ACI() {
		sCICurrPerson.operationCallback.resetCurrPerson();
		
		sCIVBrain.operationCallback.resetCountFoundFaces();
		
		sCIHBrain.operationCallback.sendTTS("[:-|]Now, I am looking for a face in front of me.");
		
		sCIVBrain.operationCallback.sendACIOnOff(true);
		
		sCIKinect2.operationCallback.sendNoiseDetectionOnOff(true);
	}
	
	/* Entry action for state 'PersonKnownWithName'. */
	private void entryAction_main_FaceDataInterpretation_FaceDataInterpretation_PersonKnownWithName() {
		sCIHBrain.operationCallback.sendTTS3("Hey ", sCICurrPerson.operationCallback.getFirstname(), ". [:-)] Nice to see you again!");
	}
	
	/* Entry action for state 'UnknownGirl'. */
	private void entryAction_main_FaceDataInterpretation_FaceDataInterpretation_UnknownGirl() {
		sCIHBrain.operationCallback.sendTTS("Hi girl");
	}
	
	/* Entry action for state 'PersonKnownWithoutName'. */
	private void entryAction_main_FaceDataInterpretation_FaceDataInterpretation_PersonKnownWithoutName() {
		sCIHBrain.operationCallback.sendTTS("Hey there, You look familiar, but I did not get your name last time. [:-(] Please tell me your name [:-)]");
	}
	
	/* Entry action for state 'UnknownFemaleTeen'. */
	private void entryAction_main_FaceDataInterpretation_FaceDataInterpretation_UnknownFemaleTeen() {
		sCIHBrain.operationCallback.sendTTS("Hi lady");
	}
	
	/* Entry action for state 'UnknownWomen'. */
	private void entryAction_main_FaceDataInterpretation_FaceDataInterpretation_UnknownWomen() {
		sCIHBrain.operationCallback.sendTTS("Hi lady");
	}
	
	/* Entry action for state 'UnknownBoy'. */
	private void entryAction_main_FaceDataInterpretation_FaceDataInterpretation_UnknownBoy() {
		sCIHBrain.operationCallback.sendTTS("Hi Boy");
	}
	
	/* Entry action for state 'UnknownMaleTeen'. */
	private void entryAction_main_FaceDataInterpretation_FaceDataInterpretation_UnknownMaleTeen() {
		sCIHBrain.operationCallback.sendTTS("Hey Guy");
	}
	
	/* Entry action for state 'UnknownMen'. */
	private void entryAction_main_FaceDataInterpretation_FaceDataInterpretation_UnknownMen() {
		sCIHBrain.operationCallback.sendTTS("Hello Sir");
	}
	
	/* Entry action for state 'wait for getting datas'. */
	private void entryAction_main_FaceDataInterpretation_FaceDataInterpretation_wait_for_getting_datas() {
		timer.setTimer(this, 0, 3 * 1000, false);
	}
	
	/* Entry action for state 'STT_1'. */
	private void entryAction_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_STT_1() {
		timer.setTimer(this, 1, 5 * 1000, false);
		
		setCounter(0);
		
		sCICurrPerson.operationCallback.setKnown(true);
		
		sCIVBrain.operationCallback.savePersonList();
		
		sCISTT.operationCallback.sendSpeechDetectionName();
		
		setNameBuffer("");
	}
	
	/* Entry action for state 'Answere_name _and_ask'. */
	private void entryAction_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Answere_name__and_ask() {
		setNameBuffer(sCISTT.operationCallback.getSpokenText());
		
		sCIHBrain.operationCallback.sendTTS3("If think your name is ", getNameBuffer(), ". Is that right?");
	}
	
	/* Entry action for state 'STT3'. */
	private void entryAction_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_STT3() {
		sCISTT.operationCallback.sendSpeechDetectionOff();
		
		setCounter(counter + 1);
	}
	
	/* Entry action for state 'Save_Firstname'. */
	private void entryAction_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Save_Firstname() {
		sCICurrPerson.operationCallback.setFirstname(getNameBuffer());
		
		sCIVBrain.operationCallback.savePersonList();
		
		sCIHBrain.operationCallback.sendTTS3("[:-)]Ok, ", sCICurrPerson.operationCallback.getFirstname(), ", I will remember you!");
	}
	
	/* Entry action for state 'Ask_for_Repeat'. */
	private void entryAction_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Ask_for_Repeat() {
		sCIHBrain.operationCallback.sendTTS("[:-(]Please repeat your name.");
	}
	
	/* Entry action for state 'Didnt_get_it'. */
	private void entryAction_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Didnt_get_it() {
		sCIHBrain.operationCallback.sendTTS("[:-(]I didn't get it.");
	}
	
	/* Entry action for state 'Bye_bye'. */
	private void entryAction_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Bye_bye() {
		sCIHBrain.operationCallback.sendTTS("[:-|]It's too hard to get your name. But I will remember your face.");
	}
	
	/* Entry action for state 'StartSTT'. */
	private void entryAction_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Yes_No_Question_inner_region_StartSTT() {
		timer.setTimer(this, 2, 5 * 1000, false);
		
		setCounter(counter + 1);
		
		sCISTT.operationCallback.sendSpeechDetectionYesNo();
		
		sCILeapMotion.operationCallback.sendGestureDetectionOnOff(3);
	}
	
	/* Entry action for state 'asking_repeat_YesNo'. */
	private void entryAction_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_asking_repeat_YesNo() {
		sCIHBrain.operationCallback.sendTTS("What did you say?");
	}
	
	/* Entry action for state 'AboutRobotica_1'. */
	private void entryAction_main_FaceDataInterpretation_FaceDataInterpretation_AboutRobotica_1() {
		sCIHBrain.operationCallback.sendTTS("[:-)]I am so excited to be here. Because I get to make new friends");
	}
	
	/* Entry action for state 'AboutRobotica_2'. */
	private void entryAction_main_FaceDataInterpretation_FaceDataInterpretation_AboutRobotica_2() {
		sCIHBrain.operationCallback.sendTTS("[:-)]Oh I saw a handsome robot just now. If only I can talk to him");
	}
	
	/* Entry action for state 'RandomTopic_1'. */
	private void entryAction_main_FaceDataInterpretation_FaceDataInterpretation_RandomTopic_1() {
		sCIHBrain.operationCallback.sendTTS("[:-)]My university is located in the south of Germany. ");
	}
	
	/* Entry action for state 'RandomTopic_2'. */
	private void entryAction_main_FaceDataInterpretation_FaceDataInterpretation_RandomTopic_2() {
		sCIHBrain.operationCallback.sendTTS("[:-)]I am 3 years old. I was born in the east of Germany.");
	}
	
	/* Entry action for state 'Prompt_2'. */
	private void entryAction_main_FaceDataInterpretation_FaceDataInterpretation_Prompt_2() {
		sCIHBrain.operationCallback.sendTTS("[:-|]Do you want to know more about me?");
		
		sCIBGF.setRandNum(sCIBGF.operationCallback.getRandNum(30));
	}
	
	/* Entry action for state 'Prompt_1'. */
	private void entryAction_main_FaceDataInterpretation_FaceDataInterpretation_Prompt_1() {
		sCIHBrain.operationCallback.sendTTS("[:-|]Are you having fun here?");
	}
	
	/* Entry action for state 'Farewell_1'. */
	private void entryAction_main_FaceDataInterpretation_FaceDataInterpretation_Farewell_1() {
		timer.setTimer(this, 3, 1 * 1000, false);
		
		sCIHBrain.operationCallback.sendTTS("It is nice meeting you. Till next time take care.");
	}
	
	/* Entry action for state 'Farewell_2'. */
	private void entryAction_main_FaceDataInterpretation_FaceDataInterpretation_Farewell_2() {
		timer.setTimer(this, 4, 1 * 1000, false);
		
		sCIHBrain.operationCallback.sendTTS("We might not see each other again. which is sad. I like you human. I wish you all the best in your future undertakings. ");
	}
	
	/* Entry action for state 'Farewell_3'. */
	private void entryAction_main_FaceDataInterpretation_FaceDataInterpretation_Farewell_3() {
		timer.setTimer(this, 5, 1 * 1000, false);
		
		sCIHBrain.operationCallback.sendTTS("Happy to meet you dear human. But now, let me look for other one.");
	}
	
	/* Entry action for state 'Farewell_4'. */
	private void entryAction_main_FaceDataInterpretation_FaceDataInterpretation_Farewell_4() {
		timer.setTimer(this, 6, 1 * 1000, false);
		
		sCIHBrain.operationCallback.sendTTS("Hope to see you again.");
	}
	
	/* Entry action for state 'newRandNum'. */
	private void entryAction_main_FaceDataInterpretation_FaceDataInterpretation_newRandNum() {
		sCIBGF.setRandNum(sCIBGF.operationCallback.getRandNum(20));
	}
	
	/* Entry action for state 'RandomTopic_3'. */
	private void entryAction_main_FaceDataInterpretation_FaceDataInterpretation_RandomTopic_3() {
		sCIHBrain.operationCallback.sendTTS("[:-)]My family is called the RT Lions. They are wonderful humans. and I love them very much");
	}
	
	/* Entry action for state 'Selection_2'. */
	private void entryAction_main_FaceDataInterpretation_FaceDataInterpretation_Selection_2() {
		sCIBGF.setRandNum(sCIBGF.operationCallback.getRandNum(30));
	}
	
	/* Entry action for state 'AlternativeConv_1'. */
	private void entryAction_main_FaceDataInterpretation_FaceDataInterpretation_AlternativeConv_1() {
		sCIHBrain.operationCallback.sendTTS("[:-(]What a Pity!");
	}
	
	/* Entry action for state 'StartSTT'. */
	private void entryAction_main_FaceDataInterpretation_FaceDataInterpretation_YesNo_MoreInfo_inner_region_StartSTT() {
		timer.setTimer(this, 7, 5 * 1000, false);
		
		setCounter(counter + 1);
		
		sCISTT.operationCallback.sendSpeechDetectionYesNo();
		
		sCILeapMotion.operationCallback.sendGestureDetectionOnOff(3);
	}
	
	/* Entry action for state 'asking_repeat_YesNo'. */
	private void entryAction_main_FaceDataInterpretation_FaceDataInterpretation_YesNo_MoreInfo_inner_region_asking_repeat_YesNo() {
		sCIHBrain.operationCallback.sendTTS("What did you say?");
	}
	
	/* Entry action for state 'init'. */
	private void entryAction_main_FaceDataInterpretation_FaceDataInterpretation_YesNo_MoreInfo_inner_region_init() {
		setCounter(0);
	}
	
	/* Entry action for state 'AboutRobotica_3'. */
	private void entryAction_main_FaceDataInterpretation_FaceDataInterpretation_AboutRobotica_3() {
		sCIHBrain.operationCallback.sendTTS("It is my first time here in Portugal.");
	}
	
	/* Entry action for state 'Closing'. */
	private void entryAction_main_FaceDataInterpretation_FaceDataInterpretation_Closing() {
		sCIHBrain.operationCallback.sendTTS("Would love to chat with you more. but so many people to meet. so little time.");
	}
	
	/* Entry action for state 'neutral'. */
	private void entryAction_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_neutral() {
		sCIHBrain.operationCallback.sendTTS("You look bored");
	}
	
	/* Entry action for state 'happy'. */
	private void entryAction_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_happy() {
		sCIHBrain.operationCallback.sendTTS("You seem to be happy. I'm also glad to be here. It is so much fun to be among so many other robots");
	}
	
	/* Entry action for state 'sad'. */
	private void entryAction_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_sad() {
		sCIHBrain.operationCallback.sendTTS("[:-(] Oh, you seem to be sad");
	}
	
	/* Entry action for state 'laughing'. */
	private void entryAction_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_laughing() {
		sCIHBrain.operationCallback.sendTTS("Whats so funny?");
	}
	
	/* Entry action for state 'surprised'. */
	private void entryAction_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_surprised() {
		sCIHBrain.operationCallback.sendTTS("You look surprised!");
	}
	
	/* Entry action for state 'angry'. */
	private void entryAction_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_angry() {
		sCIHBrain.operationCallback.sendTTS("You look angry!");
	}
	
	/* Entry action for state 'tell_joke_0'. */
	private void entryAction_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_tell_joke_0() {
		sCIHBrain.operationCallback.sendTTS("Why is six afraid of seven? [attentive] Because seven ate nine! [:-)] ");
	}
	
	/* Entry action for state 'joke_worked'. */
	private void entryAction_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_joke_worked() {
		sCIHBrain.operationCallback.sendTTS("I'm glad you have a better mood now.");
	}
	
	/* Entry action for state 'initialise_jokes'. */
	private void entryAction_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_initialise_jokes() {
		sCIHBrain.operationCallback.sendTTS("Let me tell you a joke");
		
		sCIBGF.setRandNum(sCIBGF.operationCallback.getRandNum(5));
	}
	
	/* Entry action for state 'joke_didnt_work'. */
	private void entryAction_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_joke_didnt_work() {
		sCIHBrain.operationCallback.sendTTS("Oh that joke didnt work. [-.-]I will try an other one.[:-)]");
		
		sCIBGF.setRandNum(sCIBGF.operationCallback.getRandNum(5));
	}
	
	/* Entry action for state 'tell_joke_1'. */
	private void entryAction_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_tell_joke_1() {
		sCIHBrain.operationCallback.sendTTS("Make love, not war. Or if you want to do both  get married!  [:-)] ");
	}
	
	/* Entry action for state 'tell_joke_2'. */
	private void entryAction_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_tell_joke_2() {
		sCIHBrain.operationCallback.sendTTS("A guy is sitting at home when he hears a knock at the door. He opens the door and sees a snail on the porch. He picks up the snail and throws it as far as he can. Three years later there is a knock on the door. He opens it and sees the same snail. The snail says: What the hell was that all about? [:-)]");
	}
	
	/* Entry action for state 'tell_joke_3'. */
	private void entryAction_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_tell_joke_3() {
		sCIHBrain.operationCallback.sendTTS("A guy shows up late for work. The boss yells, You should ve been here at eight thirty! He replies. Why? What happened at eight thirty?[:-)]");
	}
	
	/* Entry action for state 'tell_joke_5'. */
	private void entryAction_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_tell_joke_5() {
		sCIHBrain.operationCallback.sendTTS("I wanted to grow my own food but I couldnt get bacon seeds anywhere. [:-)]");
	}
	
	/* Entry action for state 'tell_joke_6'. */
	private void entryAction_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_tell_joke_6() {
		sCIHBrain.operationCallback.sendTTS("What is the difference between USA and USB? One connects to all your devices and access your data, and the other is a hardware standard.  [:-)] ");
	}
	
	/* Entry action for state 'waitForNewEmo'. */
	private void entryAction_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_waitForNewEmo() {
		sCICurrPerson.operationCallback.resetCurrEmotion();
	}
	
	/* Entry action for state 'resetEmo'. */
	private void entryAction_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_resetEmo() {
		sCICurrPerson.operationCallback.resetCurrEmotion();
	}
	
	/* Entry action for state 'sadFace'. */
	private void entryAction_main_FaceDataInterpretation_FaceDataInterpretation_sadFace() {
		sCIHBrain.operationCallback.sendTTS("[:-(] It seems that I'm not interesting enough for you.");
	}
	
	/* Entry action for state 'init_face'. */
	private void entryAction_main_FaceDataInterpretation_FaceDataInterpretation_init_face() {
		sCIHBrain.operationCallback.sendTTS("[:-|]");
	}
	
	/* Entry action for state 'StartSTT'. */
	private void entryAction_main_FaceDataInterpretation_FaceDataInterpretation_yesNo_fun_inner_region_StartSTT() {
		timer.setTimer(this, 8, 5 * 1000, false);
		
		setCounter(counter + 1);
		
		sCISTT.operationCallback.sendSpeechDetectionYesNo();
		
		sCILeapMotion.operationCallback.sendGestureDetectionOnOff(3);
	}
	
	/* Entry action for state 'asking_repeat_YesNo'. */
	private void entryAction_main_FaceDataInterpretation_FaceDataInterpretation_yesNo_fun_inner_region_asking_repeat_YesNo() {
		sCIHBrain.operationCallback.sendTTS("What did you say?");
	}
	
	/* Entry action for state 'init'. */
	private void entryAction_main_FaceDataInterpretation_FaceDataInterpretation_yesNo_fun_inner_region_init() {
		setCounter(0);
	}
	
	/* Entry action for state 'start_estimation'. */
	private void entryAction_main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_start_estimation() {
		timer.setTimer(this, 9, 10 * 1000, false);
		
		sCICurrPerson.operationCallback.setAttractiveness(-1);
		
		sCIAttractiveness.operationCallback.sendToAttr_estimate();
	}
	
	/* Entry action for state 'pretty_with_glasses'. */
	private void entryAction_main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_pretty_with_glasses() {
		sCIHBrain.operationCallback.sendTTS("You are pretty! I see you wear glasses. Let us see how pretty you are without glasses");
		
		sCIAttractiveness.setOld_attr(sCICurrPerson.operationCallback.getAttractiveness());
	}
	
	/* Entry action for state 'prettier'. */
	private void entryAction_main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_prettier() {
		sCIHBrain.operationCallback.sendTTS("Wow! you are so much more pretty without glasses!");
	}
	
	/* Entry action for state 'not_prettier'. */
	private void entryAction_main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_not_prettier() {
		sCIHBrain.operationCallback.sendTTS("Your glasses are very nice. Put them back on!");
	}
	
	/* Entry action for state 'pretty'. */
	private void entryAction_main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_pretty() {
		sCIHBrain.operationCallback.sendTTS("You look nice!");
	}
	
	/* Entry action for state 'not_pretty'. */
	private void entryAction_main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_not_pretty() {
		sCIHBrain.operationCallback.sendTTS("Also robots have different tasts. I saw prettier people than you");
	}
	
	/* Entry action for state 'get new attractiveness'. */
	private void entryAction_main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_get_new_attractiveness() {
		sCIHBrain.operationCallback.sendTTS("Thanks");
		
		sCICurrPerson.operationCallback.setAttractiveness(-1);
		
		sCIAttractiveness.operationCallback.sendToAttr_estimate();
	}
	
	/* Entry action for state 'asking_unknown'. */
	private void entryAction_main_FaceDataInterpretation_FaceDataInterpretation_asking_unknown() {
		sCIHBrain.operationCallback.sendTTS("I have never seen you before. What is your name?");
	}
	
	/* Entry action for state 'yesNoCancelFunNo'. */
	private void entryAction_main_FaceDataInterpretation_FaceDataInterpretation_yesNoCancelFunNo() {
		sCIHBrain.operationCallback.sendTTS("I see, it's a difficult question.");
	}
	
	/* Entry action for state 'exitCancelAnswer'. */
	private void entryAction_main_FaceDataInterpretation_FaceDataInterpretation_exitCancelAnswer() {
		sCIHBrain.operationCallback.sendTTS("[:-)]I didn't get your answer, but nevermind. I am going to tell you anyway.");
	}
	
	/* Entry action for state 'AfterGettingName'. */
	private void entryAction_main_FaceDataInterpretation_FaceDataInterpretation_AfterGettingName_inner_region_AfterGettingName() {
		sCIHBrain.operationCallback.sendTTS("[:-)]You have a nice name.");
	}
	
	/* Entry action for state 'newRandNum'. */
	private void entryAction_main_FaceDataInterpretation_FaceDataInterpretation_AfterGettingName_inner_region_newRandNum() {
		timer.setTimer(this, 10, 1 * 1000, false);
		
		sCIBGF.setRandNum(sCIBGF.operationCallback.getRandNum(20));
	}
	
	/* Entry action for state 'randNumEnd'. */
	private void entryAction_main_FaceDataInterpretation_FaceDataInterpretation_randNumEnd() {
		timer.setTimer(this, 11, 1 * 1000, false);
		
		sCIBGF.setRandNum(sCIBGF.operationCallback.getRandNum(40));
	}
	
	/* Entry action for state 'exitSad'. */
	private void entryAction_main_exitSad() {
		timer.setTimer(this, 12, 2 * 1000, false);
		
		sCIMira.operationCallback.sendBodyUTurn();
		
		sCIHBrain.operationCallback.sendTTS("I think, on the next way point I find a more interesting partner.");
	}
	
	/* Entry action for state 'Bumpered'. */
	private void entryAction_Leonie_Bupered_Or_Emergency_Stop_Bumpered() {
		timer.setTimer(this, 13, 3 * 1000, false);
		
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
		timer.setTimer(this, 14, 3 * 1000, false);
	}
	
	/* Exit action for state 'FaceDataInterpretation'. */
	private void exitAction_main_FaceDataInterpretation() {
		sCIVBrain.operationCallback.sendACIOnOff(false);
		
		sCIKinect2.operationCallback.sendNoiseDetectionOnOff(false);
		
		sCILeapMotion.operationCallback.sendGestureDetectionOnOff(0);
		
		sCISTT.operationCallback.sendSpeechDetectionOff();
		
		sCICurrPerson.operationCallback.resetCurrPerson();
		
		sCIVBrain.operationCallback.resetCountFoundFaces();
		
		sCIAttractiveness.setOld_attr(0);
	}
	
	/* Exit action for state 'wait for getting datas'. */
	private void exitAction_main_FaceDataInterpretation_FaceDataInterpretation_wait_for_getting_datas() {
		timer.unsetTimer(this, 0);
	}
	
	/* Exit action for state 'Getting Name'. */
	private void exitAction_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name() {
		sCISTT.operationCallback.sendSpeechDetectionOff();
	}
	
	/* Exit action for state 'STT_1'. */
	private void exitAction_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_STT_1() {
		timer.unsetTimer(this, 1);
	}
	
	/* Exit action for state 'StartSTT'. */
	private void exitAction_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Yes_No_Question_inner_region_StartSTT() {
		timer.unsetTimer(this, 2);
		
		sCILeapMotion.operationCallback.sendGestureDetectionOnOff(0);
		
		sCISTT.operationCallback.sendSpeechDetectionOff();
	}
	
	/* Exit action for state 'Farewell_1'. */
	private void exitAction_main_FaceDataInterpretation_FaceDataInterpretation_Farewell_1() {
		timer.unsetTimer(this, 3);
	}
	
	/* Exit action for state 'Farewell_2'. */
	private void exitAction_main_FaceDataInterpretation_FaceDataInterpretation_Farewell_2() {
		timer.unsetTimer(this, 4);
	}
	
	/* Exit action for state 'Farewell_3'. */
	private void exitAction_main_FaceDataInterpretation_FaceDataInterpretation_Farewell_3() {
		timer.unsetTimer(this, 5);
	}
	
	/* Exit action for state 'Farewell_4'. */
	private void exitAction_main_FaceDataInterpretation_FaceDataInterpretation_Farewell_4() {
		timer.unsetTimer(this, 6);
	}
	
	/* Exit action for state 'StartSTT'. */
	private void exitAction_main_FaceDataInterpretation_FaceDataInterpretation_YesNo_MoreInfo_inner_region_StartSTT() {
		timer.unsetTimer(this, 7);
		
		sCILeapMotion.operationCallback.sendGestureDetectionOnOff(0);
		
		sCISTT.operationCallback.sendSpeechDetectionOff();
	}
	
	/* Exit action for state 'StartSTT'. */
	private void exitAction_main_FaceDataInterpretation_FaceDataInterpretation_yesNo_fun_inner_region_StartSTT() {
		timer.unsetTimer(this, 8);
		
		sCILeapMotion.operationCallback.sendGestureDetectionOnOff(0);
		
		sCISTT.operationCallback.sendSpeechDetectionOff();
	}
	
	/* Exit action for state 'start_estimation'. */
	private void exitAction_main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_start_estimation() {
		timer.unsetTimer(this, 9);
	}
	
	/* Exit action for state 'newRandNum'. */
	private void exitAction_main_FaceDataInterpretation_FaceDataInterpretation_AfterGettingName_inner_region_newRandNum() {
		timer.unsetTimer(this, 10);
	}
	
	/* Exit action for state 'randNumEnd'. */
	private void exitAction_main_FaceDataInterpretation_FaceDataInterpretation_randNumEnd() {
		timer.unsetTimer(this, 11);
	}
	
	/* Exit action for state 'exitSad'. */
	private void exitAction_main_exitSad() {
		timer.unsetTimer(this, 12);
	}
	
	/* Exit action for state 'Bumpered'. */
	private void exitAction_Leonie_Bupered_Or_Emergency_Stop_Bumpered() {
		timer.unsetTimer(this, 13);
	}
	
	/* Exit action for state 'checkEmergency'. */
	private void exitAction_Leonie_Bupered_Or_Emergency_Stop_checkEmergency() {
		timer.unsetTimer(this, 14);
	}
	
	/* 'default' enter sequence for state Init */
	private void enterSequence_main_Init_default() {
		entryAction_main_Init();
		nextStateIndex = 0;
		stateVector[0] = State.main_Init;
	}
	
	/* Default enter sequence for state null */
	private void enterSequence_main__final__default() {
		nextStateIndex = 0;
		stateVector[0] = State.main__final_;
	}
	
	/* 'default' enter sequence for state AtWP01 - ACI */
	private void enterSequence_main_AtWP01___ACI_default() {
		entryAction_main_AtWP01___ACI();
		nextStateIndex = 0;
		stateVector[0] = State.main_AtWP01___ACI;
	}
	
	/* 'default' enter sequence for state wait for cleaning VBrain buffer */
	private void enterSequence_main_wait_for_cleaning_VBrain_buffer_default() {
		nextStateIndex = 0;
		stateVector[0] = State.main_wait_for_cleaning_VBrain_buffer;
	}
	
	/* 'default' enter sequence for state FaceDataInterpretation */
	private void enterSequence_main_FaceDataInterpretation_default() {
		enterSequence_main_FaceDataInterpretation_FaceDataInterpretation_default();
	}
	
	/* 'default' enter sequence for state PersonKnownWithName */
	private void enterSequence_main_FaceDataInterpretation_FaceDataInterpretation_PersonKnownWithName_default() {
		entryAction_main_FaceDataInterpretation_FaceDataInterpretation_PersonKnownWithName();
		nextStateIndex = 0;
		stateVector[0] = State.main_FaceDataInterpretation_FaceDataInterpretation_PersonKnownWithName;
	}
	
	/* 'default' enter sequence for state UnknownGirl */
	private void enterSequence_main_FaceDataInterpretation_FaceDataInterpretation_UnknownGirl_default() {
		entryAction_main_FaceDataInterpretation_FaceDataInterpretation_UnknownGirl();
		nextStateIndex = 0;
		stateVector[0] = State.main_FaceDataInterpretation_FaceDataInterpretation_UnknownGirl;
	}
	
	/* 'default' enter sequence for state PersonKnownWithoutName */
	private void enterSequence_main_FaceDataInterpretation_FaceDataInterpretation_PersonKnownWithoutName_default() {
		entryAction_main_FaceDataInterpretation_FaceDataInterpretation_PersonKnownWithoutName();
		nextStateIndex = 0;
		stateVector[0] = State.main_FaceDataInterpretation_FaceDataInterpretation_PersonKnownWithoutName;
	}
	
	/* 'default' enter sequence for state UnknownFemaleTeen */
	private void enterSequence_main_FaceDataInterpretation_FaceDataInterpretation_UnknownFemaleTeen_default() {
		entryAction_main_FaceDataInterpretation_FaceDataInterpretation_UnknownFemaleTeen();
		nextStateIndex = 0;
		stateVector[0] = State.main_FaceDataInterpretation_FaceDataInterpretation_UnknownFemaleTeen;
	}
	
	/* 'default' enter sequence for state UnknownWomen */
	private void enterSequence_main_FaceDataInterpretation_FaceDataInterpretation_UnknownWomen_default() {
		entryAction_main_FaceDataInterpretation_FaceDataInterpretation_UnknownWomen();
		nextStateIndex = 0;
		stateVector[0] = State.main_FaceDataInterpretation_FaceDataInterpretation_UnknownWomen;
	}
	
	/* 'default' enter sequence for state UnknownBoy */
	private void enterSequence_main_FaceDataInterpretation_FaceDataInterpretation_UnknownBoy_default() {
		entryAction_main_FaceDataInterpretation_FaceDataInterpretation_UnknownBoy();
		nextStateIndex = 0;
		stateVector[0] = State.main_FaceDataInterpretation_FaceDataInterpretation_UnknownBoy;
	}
	
	/* 'default' enter sequence for state UnknownMaleTeen */
	private void enterSequence_main_FaceDataInterpretation_FaceDataInterpretation_UnknownMaleTeen_default() {
		entryAction_main_FaceDataInterpretation_FaceDataInterpretation_UnknownMaleTeen();
		nextStateIndex = 0;
		stateVector[0] = State.main_FaceDataInterpretation_FaceDataInterpretation_UnknownMaleTeen;
	}
	
	/* 'default' enter sequence for state UnknownMen */
	private void enterSequence_main_FaceDataInterpretation_FaceDataInterpretation_UnknownMen_default() {
		entryAction_main_FaceDataInterpretation_FaceDataInterpretation_UnknownMen();
		nextStateIndex = 0;
		stateVector[0] = State.main_FaceDataInterpretation_FaceDataInterpretation_UnknownMen;
	}
	
	/* 'default' enter sequence for state wait for getting datas */
	private void enterSequence_main_FaceDataInterpretation_FaceDataInterpretation_wait_for_getting_datas_default() {
		entryAction_main_FaceDataInterpretation_FaceDataInterpretation_wait_for_getting_datas();
		nextStateIndex = 0;
		stateVector[0] = State.main_FaceDataInterpretation_FaceDataInterpretation_wait_for_getting_datas;
	}
	
	/* 'default' enter sequence for state Getting Name */
	private void enterSequence_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_default() {
		enterSequence_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_default();
	}
	
	/* 'default' enter sequence for state STT_1 */
	private void enterSequence_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_STT_1_default() {
		entryAction_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_STT_1();
		nextStateIndex = 0;
		stateVector[0] = State.main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_STT_1;
	}
	
	/* 'default' enter sequence for state Answere_name _and_ask */
	private void enterSequence_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Answere_name__and_ask_default() {
		entryAction_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Answere_name__and_ask();
		nextStateIndex = 0;
		stateVector[0] = State.main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Answere_name__and_ask;
	}
	
	/* 'default' enter sequence for state STT3 */
	private void enterSequence_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_STT3_default() {
		entryAction_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_STT3();
		nextStateIndex = 0;
		stateVector[0] = State.main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_STT3;
	}
	
	/* 'default' enter sequence for state Save_Firstname */
	private void enterSequence_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Save_Firstname_default() {
		entryAction_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Save_Firstname();
		nextStateIndex = 0;
		stateVector[0] = State.main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Save_Firstname;
	}
	
	/* 'default' enter sequence for state Ask_for_Repeat */
	private void enterSequence_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Ask_for_Repeat_default() {
		entryAction_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Ask_for_Repeat();
		nextStateIndex = 0;
		stateVector[0] = State.main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Ask_for_Repeat;
	}
	
	/* 'default' enter sequence for state Didnt_get_it */
	private void enterSequence_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Didnt_get_it_default() {
		entryAction_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Didnt_get_it();
		nextStateIndex = 0;
		stateVector[0] = State.main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Didnt_get_it;
	}
	
	/* 'default' enter sequence for state Bye_bye */
	private void enterSequence_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Bye_bye_default() {
		entryAction_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Bye_bye();
		nextStateIndex = 0;
		stateVector[0] = State.main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Bye_bye;
	}
	
	/* 'default' enter sequence for state Yes_No_Question */
	private void enterSequence_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Yes_No_Question_default() {
		enterSequence_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Yes_No_Question_inner_region_default();
	}
	
	/* 'default' enter sequence for state StartSTT */
	private void enterSequence_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Yes_No_Question_inner_region_StartSTT_default() {
		entryAction_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Yes_No_Question_inner_region_StartSTT();
		nextStateIndex = 0;
		stateVector[0] = State.main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Yes_No_Question_inner_region_StartSTT;
	}
	
	/* 'default' enter sequence for state Copy_1_STT3 */
	private void enterSequence_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Yes_No_Question_inner_region_Copy_1_STT3_default() {
		nextStateIndex = 0;
		stateVector[0] = State.main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Yes_No_Question_inner_region_Copy_1_STT3;
	}
	
	/* 'default' enter sequence for state asking_repeat_YesNo */
	private void enterSequence_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_asking_repeat_YesNo_default() {
		entryAction_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_asking_repeat_YesNo();
		nextStateIndex = 0;
		stateVector[0] = State.main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_asking_repeat_YesNo;
	}
	
	/* 'default' enter sequence for state AboutRobotica_1 */
	private void enterSequence_main_FaceDataInterpretation_FaceDataInterpretation_AboutRobotica_1_default() {
		entryAction_main_FaceDataInterpretation_FaceDataInterpretation_AboutRobotica_1();
		nextStateIndex = 0;
		stateVector[0] = State.main_FaceDataInterpretation_FaceDataInterpretation_AboutRobotica_1;
	}
	
	/* 'default' enter sequence for state AboutRobotica_2 */
	private void enterSequence_main_FaceDataInterpretation_FaceDataInterpretation_AboutRobotica_2_default() {
		entryAction_main_FaceDataInterpretation_FaceDataInterpretation_AboutRobotica_2();
		nextStateIndex = 0;
		stateVector[0] = State.main_FaceDataInterpretation_FaceDataInterpretation_AboutRobotica_2;
	}
	
	/* 'default' enter sequence for state RandomTopic_1 */
	private void enterSequence_main_FaceDataInterpretation_FaceDataInterpretation_RandomTopic_1_default() {
		entryAction_main_FaceDataInterpretation_FaceDataInterpretation_RandomTopic_1();
		nextStateIndex = 0;
		stateVector[0] = State.main_FaceDataInterpretation_FaceDataInterpretation_RandomTopic_1;
	}
	
	/* 'default' enter sequence for state RandomTopic_2 */
	private void enterSequence_main_FaceDataInterpretation_FaceDataInterpretation_RandomTopic_2_default() {
		entryAction_main_FaceDataInterpretation_FaceDataInterpretation_RandomTopic_2();
		nextStateIndex = 0;
		stateVector[0] = State.main_FaceDataInterpretation_FaceDataInterpretation_RandomTopic_2;
	}
	
	/* 'default' enter sequence for state Prompt_2 */
	private void enterSequence_main_FaceDataInterpretation_FaceDataInterpretation_Prompt_2_default() {
		entryAction_main_FaceDataInterpretation_FaceDataInterpretation_Prompt_2();
		nextStateIndex = 0;
		stateVector[0] = State.main_FaceDataInterpretation_FaceDataInterpretation_Prompt_2;
	}
	
	/* 'default' enter sequence for state Prompt_1 */
	private void enterSequence_main_FaceDataInterpretation_FaceDataInterpretation_Prompt_1_default() {
		entryAction_main_FaceDataInterpretation_FaceDataInterpretation_Prompt_1();
		nextStateIndex = 0;
		stateVector[0] = State.main_FaceDataInterpretation_FaceDataInterpretation_Prompt_1;
	}
	
	/* 'default' enter sequence for state Farewell_1 */
	private void enterSequence_main_FaceDataInterpretation_FaceDataInterpretation_Farewell_1_default() {
		entryAction_main_FaceDataInterpretation_FaceDataInterpretation_Farewell_1();
		nextStateIndex = 0;
		stateVector[0] = State.main_FaceDataInterpretation_FaceDataInterpretation_Farewell_1;
	}
	
	/* 'default' enter sequence for state Farewell_2 */
	private void enterSequence_main_FaceDataInterpretation_FaceDataInterpretation_Farewell_2_default() {
		entryAction_main_FaceDataInterpretation_FaceDataInterpretation_Farewell_2();
		nextStateIndex = 0;
		stateVector[0] = State.main_FaceDataInterpretation_FaceDataInterpretation_Farewell_2;
	}
	
	/* 'default' enter sequence for state Farewell_3 */
	private void enterSequence_main_FaceDataInterpretation_FaceDataInterpretation_Farewell_3_default() {
		entryAction_main_FaceDataInterpretation_FaceDataInterpretation_Farewell_3();
		nextStateIndex = 0;
		stateVector[0] = State.main_FaceDataInterpretation_FaceDataInterpretation_Farewell_3;
	}
	
	/* 'default' enter sequence for state Farewell_4 */
	private void enterSequence_main_FaceDataInterpretation_FaceDataInterpretation_Farewell_4_default() {
		entryAction_main_FaceDataInterpretation_FaceDataInterpretation_Farewell_4();
		nextStateIndex = 0;
		stateVector[0] = State.main_FaceDataInterpretation_FaceDataInterpretation_Farewell_4;
	}
	
	/* 'default' enter sequence for state Selection */
	private void enterSequence_main_FaceDataInterpretation_FaceDataInterpretation_Selection_default() {
		nextStateIndex = 0;
		stateVector[0] = State.main_FaceDataInterpretation_FaceDataInterpretation_Selection;
	}
	
	/* 'default' enter sequence for state newRandNum */
	private void enterSequence_main_FaceDataInterpretation_FaceDataInterpretation_newRandNum_default() {
		entryAction_main_FaceDataInterpretation_FaceDataInterpretation_newRandNum();
		nextStateIndex = 0;
		stateVector[0] = State.main_FaceDataInterpretation_FaceDataInterpretation_newRandNum;
	}
	
	/* 'default' enter sequence for state RandomTopic_3 */
	private void enterSequence_main_FaceDataInterpretation_FaceDataInterpretation_RandomTopic_3_default() {
		entryAction_main_FaceDataInterpretation_FaceDataInterpretation_RandomTopic_3();
		nextStateIndex = 0;
		stateVector[0] = State.main_FaceDataInterpretation_FaceDataInterpretation_RandomTopic_3;
	}
	
	/* 'default' enter sequence for state Selection_2 */
	private void enterSequence_main_FaceDataInterpretation_FaceDataInterpretation_Selection_2_default() {
		entryAction_main_FaceDataInterpretation_FaceDataInterpretation_Selection_2();
		nextStateIndex = 0;
		stateVector[0] = State.main_FaceDataInterpretation_FaceDataInterpretation_Selection_2;
	}
	
	/* 'default' enter sequence for state AlternativeConv_1 */
	private void enterSequence_main_FaceDataInterpretation_FaceDataInterpretation_AlternativeConv_1_default() {
		entryAction_main_FaceDataInterpretation_FaceDataInterpretation_AlternativeConv_1();
		nextStateIndex = 0;
		stateVector[0] = State.main_FaceDataInterpretation_FaceDataInterpretation_AlternativeConv_1;
	}
	
	/* 'default' enter sequence for state Selection_3 */
	private void enterSequence_main_FaceDataInterpretation_FaceDataInterpretation_Selection_3_default() {
		nextStateIndex = 0;
		stateVector[0] = State.main_FaceDataInterpretation_FaceDataInterpretation_Selection_3;
	}
	
	/* 'default' enter sequence for state YesNo_MoreInfo */
	private void enterSequence_main_FaceDataInterpretation_FaceDataInterpretation_YesNo_MoreInfo_default() {
		enterSequence_main_FaceDataInterpretation_FaceDataInterpretation_YesNo_MoreInfo_inner_region_default();
	}
	
	/* 'default' enter sequence for state StartSTT */
	private void enterSequence_main_FaceDataInterpretation_FaceDataInterpretation_YesNo_MoreInfo_inner_region_StartSTT_default() {
		entryAction_main_FaceDataInterpretation_FaceDataInterpretation_YesNo_MoreInfo_inner_region_StartSTT();
		nextStateIndex = 0;
		stateVector[0] = State.main_FaceDataInterpretation_FaceDataInterpretation_YesNo_MoreInfo_inner_region_StartSTT;
	}
	
	/* 'default' enter sequence for state Copy_1_STT3 */
	private void enterSequence_main_FaceDataInterpretation_FaceDataInterpretation_YesNo_MoreInfo_inner_region_Copy_1_STT3_default() {
		nextStateIndex = 0;
		stateVector[0] = State.main_FaceDataInterpretation_FaceDataInterpretation_YesNo_MoreInfo_inner_region_Copy_1_STT3;
	}
	
	/* 'default' enter sequence for state asking_repeat_YesNo */
	private void enterSequence_main_FaceDataInterpretation_FaceDataInterpretation_YesNo_MoreInfo_inner_region_asking_repeat_YesNo_default() {
		entryAction_main_FaceDataInterpretation_FaceDataInterpretation_YesNo_MoreInfo_inner_region_asking_repeat_YesNo();
		nextStateIndex = 0;
		stateVector[0] = State.main_FaceDataInterpretation_FaceDataInterpretation_YesNo_MoreInfo_inner_region_asking_repeat_YesNo;
	}
	
	/* 'default' enter sequence for state init */
	private void enterSequence_main_FaceDataInterpretation_FaceDataInterpretation_YesNo_MoreInfo_inner_region_init_default() {
		entryAction_main_FaceDataInterpretation_FaceDataInterpretation_YesNo_MoreInfo_inner_region_init();
		nextStateIndex = 0;
		stateVector[0] = State.main_FaceDataInterpretation_FaceDataInterpretation_YesNo_MoreInfo_inner_region_init;
	}
	
	/* 'default' enter sequence for state AboutRobotica_3 */
	private void enterSequence_main_FaceDataInterpretation_FaceDataInterpretation_AboutRobotica_3_default() {
		entryAction_main_FaceDataInterpretation_FaceDataInterpretation_AboutRobotica_3();
		nextStateIndex = 0;
		stateVector[0] = State.main_FaceDataInterpretation_FaceDataInterpretation_AboutRobotica_3;
	}
	
	/* 'default' enter sequence for state Closing */
	private void enterSequence_main_FaceDataInterpretation_FaceDataInterpretation_Closing_default() {
		entryAction_main_FaceDataInterpretation_FaceDataInterpretation_Closing();
		nextStateIndex = 0;
		stateVector[0] = State.main_FaceDataInterpretation_FaceDataInterpretation_Closing;
	}
	
	/* 'default' enter sequence for state Composite_Emotion_Interpretation */
	private void enterSequence_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_default() {
		enterSequence_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_default();
	}
	
	/* 'default' enter sequence for state neutral */
	private void enterSequence_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_neutral_default() {
		entryAction_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_neutral();
		nextStateIndex = 0;
		stateVector[0] = State.main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_neutral;
	}
	
	/* 'default' enter sequence for state happy */
	private void enterSequence_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_happy_default() {
		entryAction_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_happy();
		nextStateIndex = 0;
		stateVector[0] = State.main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_happy;
	}
	
	/* 'default' enter sequence for state sad */
	private void enterSequence_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_sad_default() {
		entryAction_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_sad();
		nextStateIndex = 0;
		stateVector[0] = State.main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_sad;
	}
	
	/* 'default' enter sequence for state laughing */
	private void enterSequence_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_laughing_default() {
		entryAction_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_laughing();
		nextStateIndex = 0;
		stateVector[0] = State.main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_laughing;
	}
	
	/* 'default' enter sequence for state surprised */
	private void enterSequence_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_surprised_default() {
		entryAction_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_surprised();
		nextStateIndex = 0;
		stateVector[0] = State.main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_surprised;
	}
	
	/* 'default' enter sequence for state angry */
	private void enterSequence_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_angry_default() {
		entryAction_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_angry();
		nextStateIndex = 0;
		stateVector[0] = State.main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_angry;
	}
	
	/* 'default' enter sequence for state tell_joke_0 */
	private void enterSequence_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_tell_joke_0_default() {
		entryAction_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_tell_joke_0();
		nextStateIndex = 0;
		stateVector[0] = State.main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_tell_joke_0;
	}
	
	/* 'default' enter sequence for state joke_worked */
	private void enterSequence_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_joke_worked_default() {
		entryAction_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_joke_worked();
		nextStateIndex = 0;
		stateVector[0] = State.main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_joke_worked;
	}
	
	/* 'default' enter sequence for state initialise_jokes */
	private void enterSequence_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_initialise_jokes_default() {
		entryAction_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_initialise_jokes();
		nextStateIndex = 0;
		stateVector[0] = State.main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_initialise_jokes;
	}
	
	/* 'default' enter sequence for state joke_didnt_work */
	private void enterSequence_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_joke_didnt_work_default() {
		entryAction_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_joke_didnt_work();
		nextStateIndex = 0;
		stateVector[0] = State.main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_joke_didnt_work;
	}
	
	/* 'default' enter sequence for state tell_joke_1 */
	private void enterSequence_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_tell_joke_1_default() {
		entryAction_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_tell_joke_1();
		nextStateIndex = 0;
		stateVector[0] = State.main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_tell_joke_1;
	}
	
	/* 'default' enter sequence for state tell_joke_2 */
	private void enterSequence_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_tell_joke_2_default() {
		entryAction_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_tell_joke_2();
		nextStateIndex = 0;
		stateVector[0] = State.main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_tell_joke_2;
	}
	
	/* 'default' enter sequence for state tell_joke_3 */
	private void enterSequence_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_tell_joke_3_default() {
		entryAction_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_tell_joke_3();
		nextStateIndex = 0;
		stateVector[0] = State.main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_tell_joke_3;
	}
	
	/* 'default' enter sequence for state tell_joke_5 */
	private void enterSequence_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_tell_joke_5_default() {
		entryAction_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_tell_joke_5();
		nextStateIndex = 0;
		stateVector[0] = State.main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_tell_joke_5;
	}
	
	/* 'default' enter sequence for state tell_joke_6 */
	private void enterSequence_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_tell_joke_6_default() {
		entryAction_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_tell_joke_6();
		nextStateIndex = 0;
		stateVector[0] = State.main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_tell_joke_6;
	}
	
	/* 'default' enter sequence for state waitForNewEmo */
	private void enterSequence_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_waitForNewEmo_default() {
		entryAction_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_waitForNewEmo();
		nextStateIndex = 0;
		stateVector[0] = State.main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_waitForNewEmo;
	}
	
	/* 'default' enter sequence for state resetEmo */
	private void enterSequence_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_resetEmo_default() {
		entryAction_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_resetEmo();
		nextStateIndex = 0;
		stateVector[0] = State.main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_resetEmo;
	}
	
	/* 'default' enter sequence for state sadFace */
	private void enterSequence_main_FaceDataInterpretation_FaceDataInterpretation_sadFace_default() {
		entryAction_main_FaceDataInterpretation_FaceDataInterpretation_sadFace();
		nextStateIndex = 0;
		stateVector[0] = State.main_FaceDataInterpretation_FaceDataInterpretation_sadFace;
	}
	
	/* 'default' enter sequence for state init_face */
	private void enterSequence_main_FaceDataInterpretation_FaceDataInterpretation_init_face_default() {
		entryAction_main_FaceDataInterpretation_FaceDataInterpretation_init_face();
		nextStateIndex = 0;
		stateVector[0] = State.main_FaceDataInterpretation_FaceDataInterpretation_init_face;
	}
	
	/* 'default' enter sequence for state yesNo_fun */
	private void enterSequence_main_FaceDataInterpretation_FaceDataInterpretation_yesNo_fun_default() {
		enterSequence_main_FaceDataInterpretation_FaceDataInterpretation_yesNo_fun_inner_region_default();
	}
	
	/* 'default' enter sequence for state StartSTT */
	private void enterSequence_main_FaceDataInterpretation_FaceDataInterpretation_yesNo_fun_inner_region_StartSTT_default() {
		entryAction_main_FaceDataInterpretation_FaceDataInterpretation_yesNo_fun_inner_region_StartSTT();
		nextStateIndex = 0;
		stateVector[0] = State.main_FaceDataInterpretation_FaceDataInterpretation_yesNo_fun_inner_region_StartSTT;
	}
	
	/* 'default' enter sequence for state Copy_1_STT3 */
	private void enterSequence_main_FaceDataInterpretation_FaceDataInterpretation_yesNo_fun_inner_region_Copy_1_STT3_default() {
		nextStateIndex = 0;
		stateVector[0] = State.main_FaceDataInterpretation_FaceDataInterpretation_yesNo_fun_inner_region_Copy_1_STT3;
	}
	
	/* 'default' enter sequence for state asking_repeat_YesNo */
	private void enterSequence_main_FaceDataInterpretation_FaceDataInterpretation_yesNo_fun_inner_region_asking_repeat_YesNo_default() {
		entryAction_main_FaceDataInterpretation_FaceDataInterpretation_yesNo_fun_inner_region_asking_repeat_YesNo();
		nextStateIndex = 0;
		stateVector[0] = State.main_FaceDataInterpretation_FaceDataInterpretation_yesNo_fun_inner_region_asking_repeat_YesNo;
	}
	
	/* 'default' enter sequence for state init */
	private void enterSequence_main_FaceDataInterpretation_FaceDataInterpretation_yesNo_fun_inner_region_init_default() {
		entryAction_main_FaceDataInterpretation_FaceDataInterpretation_yesNo_fun_inner_region_init();
		nextStateIndex = 0;
		stateVector[0] = State.main_FaceDataInterpretation_FaceDataInterpretation_yesNo_fun_inner_region_init;
	}
	
	/* 'default' enter sequence for state attractiveness */
	private void enterSequence_main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_default() {
		enterSequence_main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_default();
	}
	
	/* 'default' enter sequence for state start_estimation */
	private void enterSequence_main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_start_estimation_default() {
		entryAction_main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_start_estimation();
		nextStateIndex = 0;
		stateVector[0] = State.main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_start_estimation;
	}
	
	/* 'default' enter sequence for state ready */
	private void enterSequence_main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_ready_default() {
		nextStateIndex = 0;
		stateVector[0] = State.main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_ready;
	}
	
	/* 'default' enter sequence for state pretty_with_glasses */
	private void enterSequence_main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_pretty_with_glasses_default() {
		entryAction_main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_pretty_with_glasses();
		nextStateIndex = 0;
		stateVector[0] = State.main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_pretty_with_glasses;
	}
	
	/* 'default' enter sequence for state got_new_attr */
	private void enterSequence_main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_got_new_attr_default() {
		nextStateIndex = 0;
		stateVector[0] = State.main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_got_new_attr;
	}
	
	/* 'default' enter sequence for state prettier */
	private void enterSequence_main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_prettier_default() {
		entryAction_main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_prettier();
		nextStateIndex = 0;
		stateVector[0] = State.main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_prettier;
	}
	
	/* 'default' enter sequence for state not_prettier */
	private void enterSequence_main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_not_prettier_default() {
		entryAction_main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_not_prettier();
		nextStateIndex = 0;
		stateVector[0] = State.main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_not_prettier;
	}
	
	/* 'default' enter sequence for state pretty */
	private void enterSequence_main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_pretty_default() {
		entryAction_main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_pretty();
		nextStateIndex = 0;
		stateVector[0] = State.main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_pretty;
	}
	
	/* 'default' enter sequence for state not_pretty */
	private void enterSequence_main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_not_pretty_default() {
		entryAction_main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_not_pretty();
		nextStateIndex = 0;
		stateVector[0] = State.main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_not_pretty;
	}
	
	/* 'default' enter sequence for state get new attractiveness */
	private void enterSequence_main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_get_new_attractiveness_default() {
		entryAction_main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_get_new_attractiveness();
		nextStateIndex = 0;
		stateVector[0] = State.main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_get_new_attractiveness;
	}
	
	/* 'default' enter sequence for state asking_unknown */
	private void enterSequence_main_FaceDataInterpretation_FaceDataInterpretation_asking_unknown_default() {
		entryAction_main_FaceDataInterpretation_FaceDataInterpretation_asking_unknown();
		nextStateIndex = 0;
		stateVector[0] = State.main_FaceDataInterpretation_FaceDataInterpretation_asking_unknown;
	}
	
	/* 'default' enter sequence for state yesNoCancelFunNo */
	private void enterSequence_main_FaceDataInterpretation_FaceDataInterpretation_yesNoCancelFunNo_default() {
		entryAction_main_FaceDataInterpretation_FaceDataInterpretation_yesNoCancelFunNo();
		nextStateIndex = 0;
		stateVector[0] = State.main_FaceDataInterpretation_FaceDataInterpretation_yesNoCancelFunNo;
	}
	
	/* 'default' enter sequence for state exitCancelAnswer */
	private void enterSequence_main_FaceDataInterpretation_FaceDataInterpretation_exitCancelAnswer_default() {
		entryAction_main_FaceDataInterpretation_FaceDataInterpretation_exitCancelAnswer();
		nextStateIndex = 0;
		stateVector[0] = State.main_FaceDataInterpretation_FaceDataInterpretation_exitCancelAnswer;
	}
	
	/* 'default' enter sequence for state waitingForSpeaking */
	private void enterSequence_main_FaceDataInterpretation_FaceDataInterpretation_waitingForSpeaking_default() {
		nextStateIndex = 0;
		stateVector[0] = State.main_FaceDataInterpretation_FaceDataInterpretation_waitingForSpeaking;
	}
	
	/* 'default' enter sequence for state AfterGettingName */
	private void enterSequence_main_FaceDataInterpretation_FaceDataInterpretation_AfterGettingName_default() {
		enterSequence_main_FaceDataInterpretation_FaceDataInterpretation_AfterGettingName_inner_region_default();
	}
	
	/* 'default' enter sequence for state AfterGettingName */
	private void enterSequence_main_FaceDataInterpretation_FaceDataInterpretation_AfterGettingName_inner_region_AfterGettingName_default() {
		entryAction_main_FaceDataInterpretation_FaceDataInterpretation_AfterGettingName_inner_region_AfterGettingName();
		nextStateIndex = 0;
		stateVector[0] = State.main_FaceDataInterpretation_FaceDataInterpretation_AfterGettingName_inner_region_AfterGettingName;
	}
	
	/* 'default' enter sequence for state newRandNum */
	private void enterSequence_main_FaceDataInterpretation_FaceDataInterpretation_AfterGettingName_inner_region_newRandNum_default() {
		entryAction_main_FaceDataInterpretation_FaceDataInterpretation_AfterGettingName_inner_region_newRandNum();
		nextStateIndex = 0;
		stateVector[0] = State.main_FaceDataInterpretation_FaceDataInterpretation_AfterGettingName_inner_region_newRandNum;
	}
	
	/* 'default' enter sequence for state randNumEnd */
	private void enterSequence_main_FaceDataInterpretation_FaceDataInterpretation_randNumEnd_default() {
		entryAction_main_FaceDataInterpretation_FaceDataInterpretation_randNumEnd();
		nextStateIndex = 0;
		stateVector[0] = State.main_FaceDataInterpretation_FaceDataInterpretation_randNumEnd;
	}
	
	/* 'default' enter sequence for state wait */
	private void enterSequence_main_wait_default() {
		nextStateIndex = 0;
		stateVector[0] = State.main_wait;
	}
	
	/* 'default' enter sequence for state exitSad */
	private void enterSequence_main_exitSad_default() {
		entryAction_main_exitSad();
		nextStateIndex = 0;
		stateVector[0] = State.main_exitSad;
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
	
	/* 'default' enter sequence for region main */
	private void enterSequence_main_default() {
		react_main__entry_Default();
	}
	
	/* 'default' enter sequence for region FaceDataInterpretation */
	private void enterSequence_main_FaceDataInterpretation_FaceDataInterpretation_default() {
		react_main_FaceDataInterpretation_FaceDataInterpretation__entry_Default();
	}
	
	/* 'default' enter sequence for region AskForName */
	private void enterSequence_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_default() {
		react_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName__entry_Default();
	}
	
	/* 'default' enter sequence for region inner region */
	private void enterSequence_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Yes_No_Question_inner_region_default() {
		react_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Yes_No_Question_inner_region__entry_Default();
	}
	
	/* 'default' enter sequence for region inner region */
	private void enterSequence_main_FaceDataInterpretation_FaceDataInterpretation_YesNo_MoreInfo_inner_region_default() {
		react_main_FaceDataInterpretation_FaceDataInterpretation_YesNo_MoreInfo_inner_region__entry_Default();
	}
	
	/* 'default' enter sequence for region inner region */
	private void enterSequence_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_default() {
		react_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region__entry_Default();
	}
	
	/* 'default' enter sequence for region inner region */
	private void enterSequence_main_FaceDataInterpretation_FaceDataInterpretation_yesNo_fun_inner_region_default() {
		react_main_FaceDataInterpretation_FaceDataInterpretation_yesNo_fun_inner_region__entry_Default();
	}
	
	/* 'default' enter sequence for region Attractivity_Dialog */
	private void enterSequence_main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_default() {
		react_main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog__entry_Default();
	}
	
	/* 'default' enter sequence for region inner region */
	private void enterSequence_main_FaceDataInterpretation_FaceDataInterpretation_AfterGettingName_inner_region_default() {
		react_main_FaceDataInterpretation_FaceDataInterpretation_AfterGettingName_inner_region__entry_Default();
	}
	
	/* 'default' enter sequence for region Leonie Bupered Or Emergency Stop */
	private void enterSequence_Leonie_Bupered_Or_Emergency_Stop_default() {
		react_Leonie_Bupered_Or_Emergency_Stop__entry_Default();
	}
	
	/* Default exit sequence for state Init */
	private void exitSequence_main_Init() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for final state. */
	private void exitSequence_main__final_() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state AtWP01 - ACI */
	private void exitSequence_main_AtWP01___ACI() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state wait for cleaning VBrain buffer */
	private void exitSequence_main_wait_for_cleaning_VBrain_buffer() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state FaceDataInterpretation */
	private void exitSequence_main_FaceDataInterpretation() {
		exitSequence_main_FaceDataInterpretation_FaceDataInterpretation();
		exitAction_main_FaceDataInterpretation();
	}
	
	/* Default exit sequence for state PersonKnownWithName */
	private void exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_PersonKnownWithName() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state UnknownGirl */
	private void exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_UnknownGirl() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state PersonKnownWithoutName */
	private void exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_PersonKnownWithoutName() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state UnknownFemaleTeen */
	private void exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_UnknownFemaleTeen() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state UnknownWomen */
	private void exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_UnknownWomen() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state UnknownBoy */
	private void exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_UnknownBoy() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state UnknownMaleTeen */
	private void exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_UnknownMaleTeen() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state UnknownMen */
	private void exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_UnknownMen() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state wait for getting datas */
	private void exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_wait_for_getting_datas() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
		
		exitAction_main_FaceDataInterpretation_FaceDataInterpretation_wait_for_getting_datas();
	}
	
	/* Default exit sequence for state Getting Name */
	private void exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name() {
		exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName();
		exitAction_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name();
	}
	
	/* Default exit sequence for state STT_1 */
	private void exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_STT_1() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
		
		exitAction_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_STT_1();
	}
	
	/* Default exit sequence for state Answere_name _and_ask */
	private void exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Answere_name__and_ask() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state STT3 */
	private void exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_STT3() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state Save_Firstname */
	private void exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Save_Firstname() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state Ask_for_Repeat */
	private void exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Ask_for_Repeat() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state Didnt_get_it */
	private void exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Didnt_get_it() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state Bye_bye */
	private void exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Bye_bye() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state Yes_No_Question */
	private void exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Yes_No_Question() {
		exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Yes_No_Question_inner_region();
	}
	
	/* Default exit sequence for state StartSTT */
	private void exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Yes_No_Question_inner_region_StartSTT() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
		
		exitAction_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Yes_No_Question_inner_region_StartSTT();
	}
	
	/* Default exit sequence for state Copy_1_STT3 */
	private void exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Yes_No_Question_inner_region_Copy_1_STT3() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state asking_repeat_YesNo */
	private void exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_asking_repeat_YesNo() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state AboutRobotica_1 */
	private void exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_AboutRobotica_1() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state AboutRobotica_2 */
	private void exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_AboutRobotica_2() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state RandomTopic_1 */
	private void exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_RandomTopic_1() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state RandomTopic_2 */
	private void exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_RandomTopic_2() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state Prompt_2 */
	private void exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_Prompt_2() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state Prompt_1 */
	private void exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_Prompt_1() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state Farewell_1 */
	private void exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_Farewell_1() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
		
		exitAction_main_FaceDataInterpretation_FaceDataInterpretation_Farewell_1();
	}
	
	/* Default exit sequence for state Farewell_2 */
	private void exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_Farewell_2() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
		
		exitAction_main_FaceDataInterpretation_FaceDataInterpretation_Farewell_2();
	}
	
	/* Default exit sequence for state Farewell_3 */
	private void exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_Farewell_3() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
		
		exitAction_main_FaceDataInterpretation_FaceDataInterpretation_Farewell_3();
	}
	
	/* Default exit sequence for state Farewell_4 */
	private void exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_Farewell_4() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
		
		exitAction_main_FaceDataInterpretation_FaceDataInterpretation_Farewell_4();
	}
	
	/* Default exit sequence for state Selection */
	private void exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_Selection() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state newRandNum */
	private void exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_newRandNum() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state RandomTopic_3 */
	private void exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_RandomTopic_3() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state Selection_2 */
	private void exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_Selection_2() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state AlternativeConv_1 */
	private void exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_AlternativeConv_1() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state Selection_3 */
	private void exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_Selection_3() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state YesNo_MoreInfo */
	private void exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_YesNo_MoreInfo() {
		exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_YesNo_MoreInfo_inner_region();
	}
	
	/* Default exit sequence for state StartSTT */
	private void exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_YesNo_MoreInfo_inner_region_StartSTT() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
		
		exitAction_main_FaceDataInterpretation_FaceDataInterpretation_YesNo_MoreInfo_inner_region_StartSTT();
	}
	
	/* Default exit sequence for state Copy_1_STT3 */
	private void exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_YesNo_MoreInfo_inner_region_Copy_1_STT3() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state asking_repeat_YesNo */
	private void exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_YesNo_MoreInfo_inner_region_asking_repeat_YesNo() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state init */
	private void exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_YesNo_MoreInfo_inner_region_init() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state AboutRobotica_3 */
	private void exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_AboutRobotica_3() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state Closing */
	private void exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_Closing() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state Composite_Emotion_Interpretation */
	private void exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation() {
		exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region();
	}
	
	/* Default exit sequence for state neutral */
	private void exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_neutral() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state happy */
	private void exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_happy() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state sad */
	private void exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_sad() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state laughing */
	private void exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_laughing() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state surprised */
	private void exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_surprised() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state angry */
	private void exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_angry() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state tell_joke_0 */
	private void exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_tell_joke_0() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state joke_worked */
	private void exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_joke_worked() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state initialise_jokes */
	private void exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_initialise_jokes() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state joke_didnt_work */
	private void exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_joke_didnt_work() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state tell_joke_1 */
	private void exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_tell_joke_1() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state tell_joke_2 */
	private void exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_tell_joke_2() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state tell_joke_3 */
	private void exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_tell_joke_3() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state tell_joke_5 */
	private void exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_tell_joke_5() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state tell_joke_6 */
	private void exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_tell_joke_6() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state waitForNewEmo */
	private void exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_waitForNewEmo() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state resetEmo */
	private void exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_resetEmo() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state sadFace */
	private void exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_sadFace() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state init_face */
	private void exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_init_face() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state yesNo_fun */
	private void exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_yesNo_fun() {
		exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_yesNo_fun_inner_region();
	}
	
	/* Default exit sequence for state StartSTT */
	private void exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_yesNo_fun_inner_region_StartSTT() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
		
		exitAction_main_FaceDataInterpretation_FaceDataInterpretation_yesNo_fun_inner_region_StartSTT();
	}
	
	/* Default exit sequence for state Copy_1_STT3 */
	private void exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_yesNo_fun_inner_region_Copy_1_STT3() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state asking_repeat_YesNo */
	private void exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_yesNo_fun_inner_region_asking_repeat_YesNo() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state init */
	private void exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_yesNo_fun_inner_region_init() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state attractiveness */
	private void exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_attractiveness() {
		exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog();
	}
	
	/* Default exit sequence for state start_estimation */
	private void exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_start_estimation() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
		
		exitAction_main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_start_estimation();
	}
	
	/* Default exit sequence for state ready */
	private void exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_ready() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state pretty_with_glasses */
	private void exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_pretty_with_glasses() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state got_new_attr */
	private void exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_got_new_attr() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state prettier */
	private void exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_prettier() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state not_prettier */
	private void exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_not_prettier() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state pretty */
	private void exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_pretty() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state not_pretty */
	private void exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_not_pretty() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state get new attractiveness */
	private void exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_get_new_attractiveness() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state asking_unknown */
	private void exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_asking_unknown() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state yesNoCancelFunNo */
	private void exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_yesNoCancelFunNo() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state exitCancelAnswer */
	private void exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_exitCancelAnswer() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state waitingForSpeaking */
	private void exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_waitingForSpeaking() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state AfterGettingName */
	private void exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_AfterGettingName() {
		exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_AfterGettingName_inner_region();
	}
	
	/* Default exit sequence for state AfterGettingName */
	private void exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_AfterGettingName_inner_region_AfterGettingName() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state newRandNum */
	private void exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_AfterGettingName_inner_region_newRandNum() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
		
		exitAction_main_FaceDataInterpretation_FaceDataInterpretation_AfterGettingName_inner_region_newRandNum();
	}
	
	/* Default exit sequence for state randNumEnd */
	private void exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_randNumEnd() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
		
		exitAction_main_FaceDataInterpretation_FaceDataInterpretation_randNumEnd();
	}
	
	/* Default exit sequence for state wait */
	private void exitSequence_main_wait() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state exitSad */
	private void exitSequence_main_exitSad() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
		
		exitAction_main_exitSad();
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
	
	/* Default exit sequence for region main */
	private void exitSequence_main() {
		switch (stateVector[0]) {
		case main_Init:
			exitSequence_main_Init();
			break;
		case main__final_:
			exitSequence_main__final_();
			break;
		case main_AtWP01___ACI:
			exitSequence_main_AtWP01___ACI();
			break;
		case main_wait_for_cleaning_VBrain_buffer:
			exitSequence_main_wait_for_cleaning_VBrain_buffer();
			break;
		case main_FaceDataInterpretation_FaceDataInterpretation_PersonKnownWithName:
			exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_PersonKnownWithName();
			exitAction_main_FaceDataInterpretation();
			break;
		case main_FaceDataInterpretation_FaceDataInterpretation_UnknownGirl:
			exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_UnknownGirl();
			exitAction_main_FaceDataInterpretation();
			break;
		case main_FaceDataInterpretation_FaceDataInterpretation_PersonKnownWithoutName:
			exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_PersonKnownWithoutName();
			exitAction_main_FaceDataInterpretation();
			break;
		case main_FaceDataInterpretation_FaceDataInterpretation_UnknownFemaleTeen:
			exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_UnknownFemaleTeen();
			exitAction_main_FaceDataInterpretation();
			break;
		case main_FaceDataInterpretation_FaceDataInterpretation_UnknownWomen:
			exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_UnknownWomen();
			exitAction_main_FaceDataInterpretation();
			break;
		case main_FaceDataInterpretation_FaceDataInterpretation_UnknownBoy:
			exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_UnknownBoy();
			exitAction_main_FaceDataInterpretation();
			break;
		case main_FaceDataInterpretation_FaceDataInterpretation_UnknownMaleTeen:
			exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_UnknownMaleTeen();
			exitAction_main_FaceDataInterpretation();
			break;
		case main_FaceDataInterpretation_FaceDataInterpretation_UnknownMen:
			exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_UnknownMen();
			exitAction_main_FaceDataInterpretation();
			break;
		case main_FaceDataInterpretation_FaceDataInterpretation_wait_for_getting_datas:
			exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_wait_for_getting_datas();
			exitAction_main_FaceDataInterpretation();
			break;
		case main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_STT_1:
			exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_STT_1();
			exitAction_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name();
			exitAction_main_FaceDataInterpretation();
			break;
		case main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Answere_name__and_ask:
			exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Answere_name__and_ask();
			exitAction_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name();
			exitAction_main_FaceDataInterpretation();
			break;
		case main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_STT3:
			exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_STT3();
			exitAction_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name();
			exitAction_main_FaceDataInterpretation();
			break;
		case main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Save_Firstname:
			exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Save_Firstname();
			exitAction_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name();
			exitAction_main_FaceDataInterpretation();
			break;
		case main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Ask_for_Repeat:
			exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Ask_for_Repeat();
			exitAction_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name();
			exitAction_main_FaceDataInterpretation();
			break;
		case main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Didnt_get_it:
			exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Didnt_get_it();
			exitAction_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name();
			exitAction_main_FaceDataInterpretation();
			break;
		case main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Bye_bye:
			exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Bye_bye();
			exitAction_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name();
			exitAction_main_FaceDataInterpretation();
			break;
		case main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Yes_No_Question_inner_region_StartSTT:
			exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Yes_No_Question_inner_region_StartSTT();
			exitAction_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name();
			exitAction_main_FaceDataInterpretation();
			break;
		case main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Yes_No_Question_inner_region_Copy_1_STT3:
			exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Yes_No_Question_inner_region_Copy_1_STT3();
			exitAction_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name();
			exitAction_main_FaceDataInterpretation();
			break;
		case main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_asking_repeat_YesNo:
			exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_asking_repeat_YesNo();
			exitAction_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name();
			exitAction_main_FaceDataInterpretation();
			break;
		case main_FaceDataInterpretation_FaceDataInterpretation_AboutRobotica_1:
			exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_AboutRobotica_1();
			exitAction_main_FaceDataInterpretation();
			break;
		case main_FaceDataInterpretation_FaceDataInterpretation_AboutRobotica_2:
			exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_AboutRobotica_2();
			exitAction_main_FaceDataInterpretation();
			break;
		case main_FaceDataInterpretation_FaceDataInterpretation_RandomTopic_1:
			exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_RandomTopic_1();
			exitAction_main_FaceDataInterpretation();
			break;
		case main_FaceDataInterpretation_FaceDataInterpretation_RandomTopic_2:
			exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_RandomTopic_2();
			exitAction_main_FaceDataInterpretation();
			break;
		case main_FaceDataInterpretation_FaceDataInterpretation_Prompt_2:
			exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_Prompt_2();
			exitAction_main_FaceDataInterpretation();
			break;
		case main_FaceDataInterpretation_FaceDataInterpretation_Prompt_1:
			exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_Prompt_1();
			exitAction_main_FaceDataInterpretation();
			break;
		case main_FaceDataInterpretation_FaceDataInterpretation_Farewell_1:
			exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_Farewell_1();
			exitAction_main_FaceDataInterpretation();
			break;
		case main_FaceDataInterpretation_FaceDataInterpretation_Farewell_2:
			exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_Farewell_2();
			exitAction_main_FaceDataInterpretation();
			break;
		case main_FaceDataInterpretation_FaceDataInterpretation_Farewell_3:
			exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_Farewell_3();
			exitAction_main_FaceDataInterpretation();
			break;
		case main_FaceDataInterpretation_FaceDataInterpretation_Farewell_4:
			exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_Farewell_4();
			exitAction_main_FaceDataInterpretation();
			break;
		case main_FaceDataInterpretation_FaceDataInterpretation_Selection:
			exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_Selection();
			exitAction_main_FaceDataInterpretation();
			break;
		case main_FaceDataInterpretation_FaceDataInterpretation_newRandNum:
			exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_newRandNum();
			exitAction_main_FaceDataInterpretation();
			break;
		case main_FaceDataInterpretation_FaceDataInterpretation_RandomTopic_3:
			exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_RandomTopic_3();
			exitAction_main_FaceDataInterpretation();
			break;
		case main_FaceDataInterpretation_FaceDataInterpretation_Selection_2:
			exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_Selection_2();
			exitAction_main_FaceDataInterpretation();
			break;
		case main_FaceDataInterpretation_FaceDataInterpretation_AlternativeConv_1:
			exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_AlternativeConv_1();
			exitAction_main_FaceDataInterpretation();
			break;
		case main_FaceDataInterpretation_FaceDataInterpretation_Selection_3:
			exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_Selection_3();
			exitAction_main_FaceDataInterpretation();
			break;
		case main_FaceDataInterpretation_FaceDataInterpretation_YesNo_MoreInfo_inner_region_StartSTT:
			exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_YesNo_MoreInfo_inner_region_StartSTT();
			exitAction_main_FaceDataInterpretation();
			break;
		case main_FaceDataInterpretation_FaceDataInterpretation_YesNo_MoreInfo_inner_region_Copy_1_STT3:
			exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_YesNo_MoreInfo_inner_region_Copy_1_STT3();
			exitAction_main_FaceDataInterpretation();
			break;
		case main_FaceDataInterpretation_FaceDataInterpretation_YesNo_MoreInfo_inner_region_asking_repeat_YesNo:
			exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_YesNo_MoreInfo_inner_region_asking_repeat_YesNo();
			exitAction_main_FaceDataInterpretation();
			break;
		case main_FaceDataInterpretation_FaceDataInterpretation_YesNo_MoreInfo_inner_region_init:
			exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_YesNo_MoreInfo_inner_region_init();
			exitAction_main_FaceDataInterpretation();
			break;
		case main_FaceDataInterpretation_FaceDataInterpretation_AboutRobotica_3:
			exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_AboutRobotica_3();
			exitAction_main_FaceDataInterpretation();
			break;
		case main_FaceDataInterpretation_FaceDataInterpretation_Closing:
			exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_Closing();
			exitAction_main_FaceDataInterpretation();
			break;
		case main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_neutral:
			exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_neutral();
			exitAction_main_FaceDataInterpretation();
			break;
		case main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_happy:
			exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_happy();
			exitAction_main_FaceDataInterpretation();
			break;
		case main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_sad:
			exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_sad();
			exitAction_main_FaceDataInterpretation();
			break;
		case main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_laughing:
			exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_laughing();
			exitAction_main_FaceDataInterpretation();
			break;
		case main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_surprised:
			exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_surprised();
			exitAction_main_FaceDataInterpretation();
			break;
		case main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_angry:
			exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_angry();
			exitAction_main_FaceDataInterpretation();
			break;
		case main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_tell_joke_0:
			exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_tell_joke_0();
			exitAction_main_FaceDataInterpretation();
			break;
		case main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_joke_worked:
			exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_joke_worked();
			exitAction_main_FaceDataInterpretation();
			break;
		case main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_initialise_jokes:
			exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_initialise_jokes();
			exitAction_main_FaceDataInterpretation();
			break;
		case main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_joke_didnt_work:
			exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_joke_didnt_work();
			exitAction_main_FaceDataInterpretation();
			break;
		case main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_tell_joke_1:
			exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_tell_joke_1();
			exitAction_main_FaceDataInterpretation();
			break;
		case main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_tell_joke_2:
			exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_tell_joke_2();
			exitAction_main_FaceDataInterpretation();
			break;
		case main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_tell_joke_3:
			exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_tell_joke_3();
			exitAction_main_FaceDataInterpretation();
			break;
		case main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_tell_joke_5:
			exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_tell_joke_5();
			exitAction_main_FaceDataInterpretation();
			break;
		case main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_tell_joke_6:
			exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_tell_joke_6();
			exitAction_main_FaceDataInterpretation();
			break;
		case main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_waitForNewEmo:
			exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_waitForNewEmo();
			exitAction_main_FaceDataInterpretation();
			break;
		case main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_resetEmo:
			exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_resetEmo();
			exitAction_main_FaceDataInterpretation();
			break;
		case main_FaceDataInterpretation_FaceDataInterpretation_sadFace:
			exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_sadFace();
			exitAction_main_FaceDataInterpretation();
			break;
		case main_FaceDataInterpretation_FaceDataInterpretation_init_face:
			exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_init_face();
			exitAction_main_FaceDataInterpretation();
			break;
		case main_FaceDataInterpretation_FaceDataInterpretation_yesNo_fun_inner_region_StartSTT:
			exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_yesNo_fun_inner_region_StartSTT();
			exitAction_main_FaceDataInterpretation();
			break;
		case main_FaceDataInterpretation_FaceDataInterpretation_yesNo_fun_inner_region_Copy_1_STT3:
			exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_yesNo_fun_inner_region_Copy_1_STT3();
			exitAction_main_FaceDataInterpretation();
			break;
		case main_FaceDataInterpretation_FaceDataInterpretation_yesNo_fun_inner_region_asking_repeat_YesNo:
			exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_yesNo_fun_inner_region_asking_repeat_YesNo();
			exitAction_main_FaceDataInterpretation();
			break;
		case main_FaceDataInterpretation_FaceDataInterpretation_yesNo_fun_inner_region_init:
			exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_yesNo_fun_inner_region_init();
			exitAction_main_FaceDataInterpretation();
			break;
		case main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_start_estimation:
			exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_start_estimation();
			exitAction_main_FaceDataInterpretation();
			break;
		case main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_ready:
			exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_ready();
			exitAction_main_FaceDataInterpretation();
			break;
		case main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_pretty_with_glasses:
			exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_pretty_with_glasses();
			exitAction_main_FaceDataInterpretation();
			break;
		case main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_got_new_attr:
			exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_got_new_attr();
			exitAction_main_FaceDataInterpretation();
			break;
		case main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_prettier:
			exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_prettier();
			exitAction_main_FaceDataInterpretation();
			break;
		case main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_not_prettier:
			exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_not_prettier();
			exitAction_main_FaceDataInterpretation();
			break;
		case main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_pretty:
			exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_pretty();
			exitAction_main_FaceDataInterpretation();
			break;
		case main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_not_pretty:
			exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_not_pretty();
			exitAction_main_FaceDataInterpretation();
			break;
		case main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_get_new_attractiveness:
			exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_get_new_attractiveness();
			exitAction_main_FaceDataInterpretation();
			break;
		case main_FaceDataInterpretation_FaceDataInterpretation_asking_unknown:
			exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_asking_unknown();
			exitAction_main_FaceDataInterpretation();
			break;
		case main_FaceDataInterpretation_FaceDataInterpretation_yesNoCancelFunNo:
			exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_yesNoCancelFunNo();
			exitAction_main_FaceDataInterpretation();
			break;
		case main_FaceDataInterpretation_FaceDataInterpretation_exitCancelAnswer:
			exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_exitCancelAnswer();
			exitAction_main_FaceDataInterpretation();
			break;
		case main_FaceDataInterpretation_FaceDataInterpretation_waitingForSpeaking:
			exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_waitingForSpeaking();
			exitAction_main_FaceDataInterpretation();
			break;
		case main_FaceDataInterpretation_FaceDataInterpretation_AfterGettingName_inner_region_AfterGettingName:
			exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_AfterGettingName_inner_region_AfterGettingName();
			exitAction_main_FaceDataInterpretation();
			break;
		case main_FaceDataInterpretation_FaceDataInterpretation_AfterGettingName_inner_region_newRandNum:
			exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_AfterGettingName_inner_region_newRandNum();
			exitAction_main_FaceDataInterpretation();
			break;
		case main_FaceDataInterpretation_FaceDataInterpretation_randNumEnd:
			exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_randNumEnd();
			exitAction_main_FaceDataInterpretation();
			break;
		case main_wait:
			exitSequence_main_wait();
			break;
		case main_exitSad:
			exitSequence_main_exitSad();
			break;
		default:
			break;
		}
	}
	
	/* Default exit sequence for region FaceDataInterpretation */
	private void exitSequence_main_FaceDataInterpretation_FaceDataInterpretation() {
		switch (stateVector[0]) {
		case main_FaceDataInterpretation_FaceDataInterpretation_PersonKnownWithName:
			exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_PersonKnownWithName();
			break;
		case main_FaceDataInterpretation_FaceDataInterpretation_UnknownGirl:
			exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_UnknownGirl();
			break;
		case main_FaceDataInterpretation_FaceDataInterpretation_PersonKnownWithoutName:
			exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_PersonKnownWithoutName();
			break;
		case main_FaceDataInterpretation_FaceDataInterpretation_UnknownFemaleTeen:
			exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_UnknownFemaleTeen();
			break;
		case main_FaceDataInterpretation_FaceDataInterpretation_UnknownWomen:
			exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_UnknownWomen();
			break;
		case main_FaceDataInterpretation_FaceDataInterpretation_UnknownBoy:
			exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_UnknownBoy();
			break;
		case main_FaceDataInterpretation_FaceDataInterpretation_UnknownMaleTeen:
			exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_UnknownMaleTeen();
			break;
		case main_FaceDataInterpretation_FaceDataInterpretation_UnknownMen:
			exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_UnknownMen();
			break;
		case main_FaceDataInterpretation_FaceDataInterpretation_wait_for_getting_datas:
			exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_wait_for_getting_datas();
			break;
		case main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_STT_1:
			exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_STT_1();
			exitAction_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name();
			break;
		case main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Answere_name__and_ask:
			exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Answere_name__and_ask();
			exitAction_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name();
			break;
		case main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_STT3:
			exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_STT3();
			exitAction_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name();
			break;
		case main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Save_Firstname:
			exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Save_Firstname();
			exitAction_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name();
			break;
		case main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Ask_for_Repeat:
			exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Ask_for_Repeat();
			exitAction_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name();
			break;
		case main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Didnt_get_it:
			exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Didnt_get_it();
			exitAction_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name();
			break;
		case main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Bye_bye:
			exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Bye_bye();
			exitAction_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name();
			break;
		case main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Yes_No_Question_inner_region_StartSTT:
			exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Yes_No_Question_inner_region_StartSTT();
			exitAction_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name();
			break;
		case main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Yes_No_Question_inner_region_Copy_1_STT3:
			exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Yes_No_Question_inner_region_Copy_1_STT3();
			exitAction_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name();
			break;
		case main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_asking_repeat_YesNo:
			exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_asking_repeat_YesNo();
			exitAction_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name();
			break;
		case main_FaceDataInterpretation_FaceDataInterpretation_AboutRobotica_1:
			exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_AboutRobotica_1();
			break;
		case main_FaceDataInterpretation_FaceDataInterpretation_AboutRobotica_2:
			exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_AboutRobotica_2();
			break;
		case main_FaceDataInterpretation_FaceDataInterpretation_RandomTopic_1:
			exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_RandomTopic_1();
			break;
		case main_FaceDataInterpretation_FaceDataInterpretation_RandomTopic_2:
			exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_RandomTopic_2();
			break;
		case main_FaceDataInterpretation_FaceDataInterpretation_Prompt_2:
			exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_Prompt_2();
			break;
		case main_FaceDataInterpretation_FaceDataInterpretation_Prompt_1:
			exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_Prompt_1();
			break;
		case main_FaceDataInterpretation_FaceDataInterpretation_Farewell_1:
			exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_Farewell_1();
			break;
		case main_FaceDataInterpretation_FaceDataInterpretation_Farewell_2:
			exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_Farewell_2();
			break;
		case main_FaceDataInterpretation_FaceDataInterpretation_Farewell_3:
			exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_Farewell_3();
			break;
		case main_FaceDataInterpretation_FaceDataInterpretation_Farewell_4:
			exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_Farewell_4();
			break;
		case main_FaceDataInterpretation_FaceDataInterpretation_Selection:
			exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_Selection();
			break;
		case main_FaceDataInterpretation_FaceDataInterpretation_newRandNum:
			exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_newRandNum();
			break;
		case main_FaceDataInterpretation_FaceDataInterpretation_RandomTopic_3:
			exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_RandomTopic_3();
			break;
		case main_FaceDataInterpretation_FaceDataInterpretation_Selection_2:
			exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_Selection_2();
			break;
		case main_FaceDataInterpretation_FaceDataInterpretation_AlternativeConv_1:
			exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_AlternativeConv_1();
			break;
		case main_FaceDataInterpretation_FaceDataInterpretation_Selection_3:
			exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_Selection_3();
			break;
		case main_FaceDataInterpretation_FaceDataInterpretation_YesNo_MoreInfo_inner_region_StartSTT:
			exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_YesNo_MoreInfo_inner_region_StartSTT();
			break;
		case main_FaceDataInterpretation_FaceDataInterpretation_YesNo_MoreInfo_inner_region_Copy_1_STT3:
			exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_YesNo_MoreInfo_inner_region_Copy_1_STT3();
			break;
		case main_FaceDataInterpretation_FaceDataInterpretation_YesNo_MoreInfo_inner_region_asking_repeat_YesNo:
			exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_YesNo_MoreInfo_inner_region_asking_repeat_YesNo();
			break;
		case main_FaceDataInterpretation_FaceDataInterpretation_YesNo_MoreInfo_inner_region_init:
			exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_YesNo_MoreInfo_inner_region_init();
			break;
		case main_FaceDataInterpretation_FaceDataInterpretation_AboutRobotica_3:
			exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_AboutRobotica_3();
			break;
		case main_FaceDataInterpretation_FaceDataInterpretation_Closing:
			exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_Closing();
			break;
		case main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_neutral:
			exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_neutral();
			break;
		case main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_happy:
			exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_happy();
			break;
		case main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_sad:
			exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_sad();
			break;
		case main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_laughing:
			exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_laughing();
			break;
		case main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_surprised:
			exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_surprised();
			break;
		case main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_angry:
			exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_angry();
			break;
		case main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_tell_joke_0:
			exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_tell_joke_0();
			break;
		case main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_joke_worked:
			exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_joke_worked();
			break;
		case main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_initialise_jokes:
			exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_initialise_jokes();
			break;
		case main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_joke_didnt_work:
			exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_joke_didnt_work();
			break;
		case main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_tell_joke_1:
			exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_tell_joke_1();
			break;
		case main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_tell_joke_2:
			exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_tell_joke_2();
			break;
		case main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_tell_joke_3:
			exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_tell_joke_3();
			break;
		case main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_tell_joke_5:
			exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_tell_joke_5();
			break;
		case main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_tell_joke_6:
			exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_tell_joke_6();
			break;
		case main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_waitForNewEmo:
			exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_waitForNewEmo();
			break;
		case main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_resetEmo:
			exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_resetEmo();
			break;
		case main_FaceDataInterpretation_FaceDataInterpretation_sadFace:
			exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_sadFace();
			break;
		case main_FaceDataInterpretation_FaceDataInterpretation_init_face:
			exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_init_face();
			break;
		case main_FaceDataInterpretation_FaceDataInterpretation_yesNo_fun_inner_region_StartSTT:
			exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_yesNo_fun_inner_region_StartSTT();
			break;
		case main_FaceDataInterpretation_FaceDataInterpretation_yesNo_fun_inner_region_Copy_1_STT3:
			exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_yesNo_fun_inner_region_Copy_1_STT3();
			break;
		case main_FaceDataInterpretation_FaceDataInterpretation_yesNo_fun_inner_region_asking_repeat_YesNo:
			exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_yesNo_fun_inner_region_asking_repeat_YesNo();
			break;
		case main_FaceDataInterpretation_FaceDataInterpretation_yesNo_fun_inner_region_init:
			exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_yesNo_fun_inner_region_init();
			break;
		case main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_start_estimation:
			exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_start_estimation();
			break;
		case main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_ready:
			exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_ready();
			break;
		case main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_pretty_with_glasses:
			exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_pretty_with_glasses();
			break;
		case main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_got_new_attr:
			exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_got_new_attr();
			break;
		case main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_prettier:
			exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_prettier();
			break;
		case main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_not_prettier:
			exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_not_prettier();
			break;
		case main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_pretty:
			exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_pretty();
			break;
		case main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_not_pretty:
			exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_not_pretty();
			break;
		case main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_get_new_attractiveness:
			exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_get_new_attractiveness();
			break;
		case main_FaceDataInterpretation_FaceDataInterpretation_asking_unknown:
			exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_asking_unknown();
			break;
		case main_FaceDataInterpretation_FaceDataInterpretation_yesNoCancelFunNo:
			exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_yesNoCancelFunNo();
			break;
		case main_FaceDataInterpretation_FaceDataInterpretation_exitCancelAnswer:
			exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_exitCancelAnswer();
			break;
		case main_FaceDataInterpretation_FaceDataInterpretation_waitingForSpeaking:
			exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_waitingForSpeaking();
			break;
		case main_FaceDataInterpretation_FaceDataInterpretation_AfterGettingName_inner_region_AfterGettingName:
			exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_AfterGettingName_inner_region_AfterGettingName();
			break;
		case main_FaceDataInterpretation_FaceDataInterpretation_AfterGettingName_inner_region_newRandNum:
			exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_AfterGettingName_inner_region_newRandNum();
			break;
		case main_FaceDataInterpretation_FaceDataInterpretation_randNumEnd:
			exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_randNumEnd();
			break;
		default:
			break;
		}
	}
	
	/* Default exit sequence for region AskForName */
	private void exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName() {
		switch (stateVector[0]) {
		case main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_STT_1:
			exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_STT_1();
			break;
		case main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Answere_name__and_ask:
			exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Answere_name__and_ask();
			break;
		case main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_STT3:
			exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_STT3();
			break;
		case main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Save_Firstname:
			exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Save_Firstname();
			break;
		case main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Ask_for_Repeat:
			exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Ask_for_Repeat();
			break;
		case main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Didnt_get_it:
			exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Didnt_get_it();
			break;
		case main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Bye_bye:
			exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Bye_bye();
			break;
		case main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Yes_No_Question_inner_region_StartSTT:
			exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Yes_No_Question_inner_region_StartSTT();
			break;
		case main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Yes_No_Question_inner_region_Copy_1_STT3:
			exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Yes_No_Question_inner_region_Copy_1_STT3();
			break;
		case main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_asking_repeat_YesNo:
			exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_asking_repeat_YesNo();
			break;
		default:
			break;
		}
	}
	
	/* Default exit sequence for region inner region */
	private void exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Yes_No_Question_inner_region() {
		switch (stateVector[0]) {
		case main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Yes_No_Question_inner_region_StartSTT:
			exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Yes_No_Question_inner_region_StartSTT();
			break;
		case main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Yes_No_Question_inner_region_Copy_1_STT3:
			exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Yes_No_Question_inner_region_Copy_1_STT3();
			break;
		default:
			break;
		}
	}
	
	/* Default exit sequence for region inner region */
	private void exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_YesNo_MoreInfo_inner_region() {
		switch (stateVector[0]) {
		case main_FaceDataInterpretation_FaceDataInterpretation_YesNo_MoreInfo_inner_region_StartSTT:
			exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_YesNo_MoreInfo_inner_region_StartSTT();
			break;
		case main_FaceDataInterpretation_FaceDataInterpretation_YesNo_MoreInfo_inner_region_Copy_1_STT3:
			exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_YesNo_MoreInfo_inner_region_Copy_1_STT3();
			break;
		case main_FaceDataInterpretation_FaceDataInterpretation_YesNo_MoreInfo_inner_region_asking_repeat_YesNo:
			exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_YesNo_MoreInfo_inner_region_asking_repeat_YesNo();
			break;
		case main_FaceDataInterpretation_FaceDataInterpretation_YesNo_MoreInfo_inner_region_init:
			exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_YesNo_MoreInfo_inner_region_init();
			break;
		default:
			break;
		}
	}
	
	/* Default exit sequence for region inner region */
	private void exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region() {
		switch (stateVector[0]) {
		case main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_neutral:
			exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_neutral();
			break;
		case main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_happy:
			exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_happy();
			break;
		case main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_sad:
			exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_sad();
			break;
		case main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_laughing:
			exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_laughing();
			break;
		case main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_surprised:
			exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_surprised();
			break;
		case main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_angry:
			exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_angry();
			break;
		case main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_tell_joke_0:
			exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_tell_joke_0();
			break;
		case main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_joke_worked:
			exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_joke_worked();
			break;
		case main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_initialise_jokes:
			exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_initialise_jokes();
			break;
		case main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_joke_didnt_work:
			exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_joke_didnt_work();
			break;
		case main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_tell_joke_1:
			exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_tell_joke_1();
			break;
		case main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_tell_joke_2:
			exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_tell_joke_2();
			break;
		case main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_tell_joke_3:
			exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_tell_joke_3();
			break;
		case main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_tell_joke_5:
			exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_tell_joke_5();
			break;
		case main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_tell_joke_6:
			exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_tell_joke_6();
			break;
		case main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_waitForNewEmo:
			exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_waitForNewEmo();
			break;
		case main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_resetEmo:
			exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_resetEmo();
			break;
		default:
			break;
		}
	}
	
	/* Default exit sequence for region inner region */
	private void exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_yesNo_fun_inner_region() {
		switch (stateVector[0]) {
		case main_FaceDataInterpretation_FaceDataInterpretation_yesNo_fun_inner_region_StartSTT:
			exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_yesNo_fun_inner_region_StartSTT();
			break;
		case main_FaceDataInterpretation_FaceDataInterpretation_yesNo_fun_inner_region_Copy_1_STT3:
			exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_yesNo_fun_inner_region_Copy_1_STT3();
			break;
		case main_FaceDataInterpretation_FaceDataInterpretation_yesNo_fun_inner_region_asking_repeat_YesNo:
			exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_yesNo_fun_inner_region_asking_repeat_YesNo();
			break;
		case main_FaceDataInterpretation_FaceDataInterpretation_yesNo_fun_inner_region_init:
			exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_yesNo_fun_inner_region_init();
			break;
		default:
			break;
		}
	}
	
	/* Default exit sequence for region Attractivity_Dialog */
	private void exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog() {
		switch (stateVector[0]) {
		case main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_start_estimation:
			exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_start_estimation();
			break;
		case main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_ready:
			exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_ready();
			break;
		case main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_pretty_with_glasses:
			exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_pretty_with_glasses();
			break;
		case main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_got_new_attr:
			exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_got_new_attr();
			break;
		case main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_prettier:
			exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_prettier();
			break;
		case main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_not_prettier:
			exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_not_prettier();
			break;
		case main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_pretty:
			exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_pretty();
			break;
		case main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_not_pretty:
			exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_not_pretty();
			break;
		case main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_get_new_attractiveness:
			exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_get_new_attractiveness();
			break;
		default:
			break;
		}
	}
	
	/* Default exit sequence for region inner region */
	private void exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_AfterGettingName_inner_region() {
		switch (stateVector[0]) {
		case main_FaceDataInterpretation_FaceDataInterpretation_AfterGettingName_inner_region_AfterGettingName:
			exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_AfterGettingName_inner_region_AfterGettingName();
			break;
		case main_FaceDataInterpretation_FaceDataInterpretation_AfterGettingName_inner_region_newRandNum:
			exitSequence_main_FaceDataInterpretation_FaceDataInterpretation_AfterGettingName_inner_region_newRandNum();
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
	private void react_main_Init() {
		effect_main_Init_tr0();
	}
	
	/* The reactions of state null. */
	private void react_main__final_() {
	}
	
	/* The reactions of state AtWP01 - ACI. */
	private void react_main_AtWP01___ACI() {
		if (check_main_AtWP01___ACI_tr0_tr0()) {
			effect_main_AtWP01___ACI_tr0();
		}
	}
	
	/* The reactions of state wait for cleaning VBrain buffer. */
	private void react_main_wait_for_cleaning_VBrain_buffer() {
		if (check_main_wait_for_cleaning_VBrain_buffer_tr0_tr0()) {
			effect_main_wait_for_cleaning_VBrain_buffer_tr0();
		}
	}
	
	/* The reactions of state PersonKnownWithName. */
	private void react_main_FaceDataInterpretation_FaceDataInterpretation_PersonKnownWithName() {
		if (check_main_FaceDataInterpretation_FaceDataInterpretation_PersonKnownWithName_tr0_tr0()) {
			effect_main_FaceDataInterpretation_FaceDataInterpretation_PersonKnownWithName_tr0();
		}
	}
	
	/* The reactions of state UnknownGirl. */
	private void react_main_FaceDataInterpretation_FaceDataInterpretation_UnknownGirl() {
		if (check_main_FaceDataInterpretation_FaceDataInterpretation_UnknownGirl_tr0_tr0()) {
			effect_main_FaceDataInterpretation_FaceDataInterpretation_UnknownGirl_tr0();
		}
	}
	
	/* The reactions of state PersonKnownWithoutName. */
	private void react_main_FaceDataInterpretation_FaceDataInterpretation_PersonKnownWithoutName() {
		if (check_main_FaceDataInterpretation_FaceDataInterpretation_PersonKnownWithoutName_tr0_tr0()) {
			effect_main_FaceDataInterpretation_FaceDataInterpretation_PersonKnownWithoutName_tr0();
		}
	}
	
	/* The reactions of state UnknownFemaleTeen. */
	private void react_main_FaceDataInterpretation_FaceDataInterpretation_UnknownFemaleTeen() {
		if (check_main_FaceDataInterpretation_FaceDataInterpretation_UnknownFemaleTeen_tr0_tr0()) {
			effect_main_FaceDataInterpretation_FaceDataInterpretation_UnknownFemaleTeen_tr0();
		}
	}
	
	/* The reactions of state UnknownWomen. */
	private void react_main_FaceDataInterpretation_FaceDataInterpretation_UnknownWomen() {
		if (check_main_FaceDataInterpretation_FaceDataInterpretation_UnknownWomen_tr0_tr0()) {
			effect_main_FaceDataInterpretation_FaceDataInterpretation_UnknownWomen_tr0();
		}
	}
	
	/* The reactions of state UnknownBoy. */
	private void react_main_FaceDataInterpretation_FaceDataInterpretation_UnknownBoy() {
		if (check_main_FaceDataInterpretation_FaceDataInterpretation_UnknownBoy_tr0_tr0()) {
			effect_main_FaceDataInterpretation_FaceDataInterpretation_UnknownBoy_tr0();
		}
	}
	
	/* The reactions of state UnknownMaleTeen. */
	private void react_main_FaceDataInterpretation_FaceDataInterpretation_UnknownMaleTeen() {
		if (check_main_FaceDataInterpretation_FaceDataInterpretation_UnknownMaleTeen_tr0_tr0()) {
			effect_main_FaceDataInterpretation_FaceDataInterpretation_UnknownMaleTeen_tr0();
		}
	}
	
	/* The reactions of state UnknownMen. */
	private void react_main_FaceDataInterpretation_FaceDataInterpretation_UnknownMen() {
		if (check_main_FaceDataInterpretation_FaceDataInterpretation_UnknownMen_tr0_tr0()) {
			effect_main_FaceDataInterpretation_FaceDataInterpretation_UnknownMen_tr0();
		}
	}
	
	/* The reactions of state wait for getting datas. */
	private void react_main_FaceDataInterpretation_FaceDataInterpretation_wait_for_getting_datas() {
		if (check_main_FaceDataInterpretation_FaceDataInterpretation_wait_for_getting_datas_tr0_tr0()) {
			effect_main_FaceDataInterpretation_FaceDataInterpretation_wait_for_getting_datas_tr0();
		}
	}
	
	/* The reactions of state STT_1. */
	private void react_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_STT_1() {
		if (check_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_STT_1_tr0_tr0()) {
			effect_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_STT_1_tr0();
		}
	}
	
	/* The reactions of state Answere_name _and_ask. */
	private void react_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Answere_name__and_ask() {
		if (check_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Answere_name__and_ask_tr0_tr0()) {
			effect_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Answere_name__and_ask_tr0();
		}
	}
	
	/* The reactions of state STT3. */
	private void react_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_STT3() {
		if (check_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_STT3_tr0_tr0()) {
			effect_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_STT3_tr0();
		} else {
			if (check_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_STT3_tr1_tr1()) {
				effect_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_STT3_tr1();
			}
		}
	}
	
	/* The reactions of state Save_Firstname. */
	private void react_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Save_Firstname() {
		effect_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Save_Firstname_tr0();
	}
	
	/* The reactions of state Ask_for_Repeat. */
	private void react_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Ask_for_Repeat() {
		if (check_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Ask_for_Repeat_tr0_tr0()) {
			effect_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Ask_for_Repeat_tr0();
		}
	}
	
	/* The reactions of state Didnt_get_it. */
	private void react_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Didnt_get_it() {
		if (check_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Didnt_get_it_tr0_tr0()) {
			effect_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Didnt_get_it_tr0();
		}
	}
	
	/* The reactions of state Bye_bye. */
	private void react_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Bye_bye() {
		effect_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Bye_bye_tr0();
	}
	
	/* The reactions of state StartSTT. */
	private void react_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Yes_No_Question_inner_region_StartSTT() {
		if (check_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Yes_No_Question_inner_region_StartSTT_tr0_tr0()) {
			effect_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Yes_No_Question_inner_region_StartSTT_tr0();
		} else {
			if (check_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Yes_No_Question_inner_region_StartSTT_tr1_tr1()) {
				effect_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Yes_No_Question_inner_region_StartSTT_tr1();
			} else {
				if (check_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Yes_No_Question_inner_region_StartSTT_tr2_tr2()) {
					effect_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Yes_No_Question_inner_region_StartSTT_tr2();
				} else {
					if (check_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Yes_No_Question_inner_region_StartSTT_tr3_tr3()) {
						effect_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Yes_No_Question_inner_region_StartSTT_tr3();
					} else {
						if (check_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Yes_No_Question_inner_region_StartSTT_tr4_tr4()) {
							effect_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Yes_No_Question_inner_region_StartSTT_tr4();
						}
					}
				}
			}
		}
	}
	
	/* The reactions of state Copy_1_STT3. */
	private void react_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Yes_No_Question_inner_region_Copy_1_STT3() {
		if (check_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Yes_No_Question_inner_region_Copy_1_STT3_tr0_tr0()) {
			effect_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Yes_No_Question_inner_region_Copy_1_STT3_tr0();
		}
	}
	
	/* The reactions of state asking_repeat_YesNo. */
	private void react_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_asking_repeat_YesNo() {
		if (check_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_asking_repeat_YesNo_tr0_tr0()) {
			effect_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_asking_repeat_YesNo_tr0();
		}
	}
	
	/* The reactions of state AboutRobotica_1. */
	private void react_main_FaceDataInterpretation_FaceDataInterpretation_AboutRobotica_1() {
		if (check_main_FaceDataInterpretation_FaceDataInterpretation_AboutRobotica_1_tr0_tr0()) {
			effect_main_FaceDataInterpretation_FaceDataInterpretation_AboutRobotica_1_tr0();
		}
	}
	
	/* The reactions of state AboutRobotica_2. */
	private void react_main_FaceDataInterpretation_FaceDataInterpretation_AboutRobotica_2() {
		if (check_main_FaceDataInterpretation_FaceDataInterpretation_AboutRobotica_2_tr0_tr0()) {
			effect_main_FaceDataInterpretation_FaceDataInterpretation_AboutRobotica_2_tr0();
		}
	}
	
	/* The reactions of state RandomTopic_1. */
	private void react_main_FaceDataInterpretation_FaceDataInterpretation_RandomTopic_1() {
		if (check_main_FaceDataInterpretation_FaceDataInterpretation_RandomTopic_1_tr0_tr0()) {
			effect_main_FaceDataInterpretation_FaceDataInterpretation_RandomTopic_1_tr0();
		}
	}
	
	/* The reactions of state RandomTopic_2. */
	private void react_main_FaceDataInterpretation_FaceDataInterpretation_RandomTopic_2() {
		if (check_main_FaceDataInterpretation_FaceDataInterpretation_RandomTopic_2_tr0_tr0()) {
			effect_main_FaceDataInterpretation_FaceDataInterpretation_RandomTopic_2_tr0();
		}
	}
	
	/* The reactions of state Prompt_2. */
	private void react_main_FaceDataInterpretation_FaceDataInterpretation_Prompt_2() {
		if (check_main_FaceDataInterpretation_FaceDataInterpretation_Prompt_2_tr0_tr0()) {
			effect_main_FaceDataInterpretation_FaceDataInterpretation_Prompt_2_tr0();
		}
	}
	
	/* The reactions of state Prompt_1. */
	private void react_main_FaceDataInterpretation_FaceDataInterpretation_Prompt_1() {
		if (check_main_FaceDataInterpretation_FaceDataInterpretation_Prompt_1_tr0_tr0()) {
			effect_main_FaceDataInterpretation_FaceDataInterpretation_Prompt_1_tr0();
		}
	}
	
	/* The reactions of state Farewell_1. */
	private void react_main_FaceDataInterpretation_FaceDataInterpretation_Farewell_1() {
		if (check_main_FaceDataInterpretation_FaceDataInterpretation_Farewell_1_tr0_tr0()) {
			effect_main_FaceDataInterpretation_FaceDataInterpretation_Farewell_1_tr0();
		}
	}
	
	/* The reactions of state Farewell_2. */
	private void react_main_FaceDataInterpretation_FaceDataInterpretation_Farewell_2() {
		if (check_main_FaceDataInterpretation_FaceDataInterpretation_Farewell_2_tr0_tr0()) {
			effect_main_FaceDataInterpretation_FaceDataInterpretation_Farewell_2_tr0();
		}
	}
	
	/* The reactions of state Farewell_3. */
	private void react_main_FaceDataInterpretation_FaceDataInterpretation_Farewell_3() {
		if (check_main_FaceDataInterpretation_FaceDataInterpretation_Farewell_3_tr0_tr0()) {
			effect_main_FaceDataInterpretation_FaceDataInterpretation_Farewell_3_tr0();
		}
	}
	
	/* The reactions of state Farewell_4. */
	private void react_main_FaceDataInterpretation_FaceDataInterpretation_Farewell_4() {
		if (check_main_FaceDataInterpretation_FaceDataInterpretation_Farewell_4_tr0_tr0()) {
			effect_main_FaceDataInterpretation_FaceDataInterpretation_Farewell_4_tr0();
		}
	}
	
	/* The reactions of state Selection. */
	private void react_main_FaceDataInterpretation_FaceDataInterpretation_Selection() {
		if (check_main_FaceDataInterpretation_FaceDataInterpretation_Selection_tr0_tr0()) {
			effect_main_FaceDataInterpretation_FaceDataInterpretation_Selection_tr0();
		} else {
			if (check_main_FaceDataInterpretation_FaceDataInterpretation_Selection_tr1_tr1()) {
				effect_main_FaceDataInterpretation_FaceDataInterpretation_Selection_tr1();
			} else {
				if (check_main_FaceDataInterpretation_FaceDataInterpretation_Selection_tr2_tr2()) {
					effect_main_FaceDataInterpretation_FaceDataInterpretation_Selection_tr2();
				} else {
					if (check_main_FaceDataInterpretation_FaceDataInterpretation_Selection_tr3_tr3()) {
						effect_main_FaceDataInterpretation_FaceDataInterpretation_Selection_tr3();
					}
				}
			}
		}
	}
	
	/* The reactions of state newRandNum. */
	private void react_main_FaceDataInterpretation_FaceDataInterpretation_newRandNum() {
		effect_main_FaceDataInterpretation_FaceDataInterpretation_newRandNum_tr0();
	}
	
	/* The reactions of state RandomTopic_3. */
	private void react_main_FaceDataInterpretation_FaceDataInterpretation_RandomTopic_3() {
		if (check_main_FaceDataInterpretation_FaceDataInterpretation_RandomTopic_3_tr0_tr0()) {
			effect_main_FaceDataInterpretation_FaceDataInterpretation_RandomTopic_3_tr0();
		}
	}
	
	/* The reactions of state Selection_2. */
	private void react_main_FaceDataInterpretation_FaceDataInterpretation_Selection_2() {
		if (check_main_FaceDataInterpretation_FaceDataInterpretation_Selection_2_tr0_tr0()) {
			effect_main_FaceDataInterpretation_FaceDataInterpretation_Selection_2_tr0();
		} else {
			if (check_main_FaceDataInterpretation_FaceDataInterpretation_Selection_2_tr1_tr1()) {
				effect_main_FaceDataInterpretation_FaceDataInterpretation_Selection_2_tr1();
			} else {
				if (check_main_FaceDataInterpretation_FaceDataInterpretation_Selection_2_tr2_tr2()) {
					effect_main_FaceDataInterpretation_FaceDataInterpretation_Selection_2_tr2();
				}
			}
		}
	}
	
	/* The reactions of state AlternativeConv_1. */
	private void react_main_FaceDataInterpretation_FaceDataInterpretation_AlternativeConv_1() {
		if (check_main_FaceDataInterpretation_FaceDataInterpretation_AlternativeConv_1_tr0_tr0()) {
			effect_main_FaceDataInterpretation_FaceDataInterpretation_AlternativeConv_1_tr0();
		}
	}
	
	/* The reactions of state Selection_3. */
	private void react_main_FaceDataInterpretation_FaceDataInterpretation_Selection_3() {
		if (check_main_FaceDataInterpretation_FaceDataInterpretation_Selection_3_tr0_tr0()) {
			effect_main_FaceDataInterpretation_FaceDataInterpretation_Selection_3_tr0();
		} else {
			if (check_main_FaceDataInterpretation_FaceDataInterpretation_Selection_3_tr1_tr1()) {
				effect_main_FaceDataInterpretation_FaceDataInterpretation_Selection_3_tr1();
			} else {
				if (check_main_FaceDataInterpretation_FaceDataInterpretation_Selection_3_tr2_tr2()) {
					effect_main_FaceDataInterpretation_FaceDataInterpretation_Selection_3_tr2();
				}
			}
		}
	}
	
	/* The reactions of state StartSTT. */
	private void react_main_FaceDataInterpretation_FaceDataInterpretation_YesNo_MoreInfo_inner_region_StartSTT() {
		if (check_main_FaceDataInterpretation_FaceDataInterpretation_YesNo_MoreInfo_inner_region_StartSTT_tr0_tr0()) {
			effect_main_FaceDataInterpretation_FaceDataInterpretation_YesNo_MoreInfo_inner_region_StartSTT_tr0();
		} else {
			if (check_main_FaceDataInterpretation_FaceDataInterpretation_YesNo_MoreInfo_inner_region_StartSTT_tr1_tr1()) {
				effect_main_FaceDataInterpretation_FaceDataInterpretation_YesNo_MoreInfo_inner_region_StartSTT_tr1();
			} else {
				if (check_main_FaceDataInterpretation_FaceDataInterpretation_YesNo_MoreInfo_inner_region_StartSTT_tr2_tr2()) {
					effect_main_FaceDataInterpretation_FaceDataInterpretation_YesNo_MoreInfo_inner_region_StartSTT_tr2();
				} else {
					if (check_main_FaceDataInterpretation_FaceDataInterpretation_YesNo_MoreInfo_inner_region_StartSTT_tr3_tr3()) {
						effect_main_FaceDataInterpretation_FaceDataInterpretation_YesNo_MoreInfo_inner_region_StartSTT_tr3();
					} else {
						if (check_main_FaceDataInterpretation_FaceDataInterpretation_YesNo_MoreInfo_inner_region_StartSTT_tr4_tr4()) {
							effect_main_FaceDataInterpretation_FaceDataInterpretation_YesNo_MoreInfo_inner_region_StartSTT_tr4();
						}
					}
				}
			}
		}
	}
	
	/* The reactions of state Copy_1_STT3. */
	private void react_main_FaceDataInterpretation_FaceDataInterpretation_YesNo_MoreInfo_inner_region_Copy_1_STT3() {
		if (check_main_FaceDataInterpretation_FaceDataInterpretation_YesNo_MoreInfo_inner_region_Copy_1_STT3_tr0_tr0()) {
			effect_main_FaceDataInterpretation_FaceDataInterpretation_YesNo_MoreInfo_inner_region_Copy_1_STT3_tr0();
		}
	}
	
	/* The reactions of state asking_repeat_YesNo. */
	private void react_main_FaceDataInterpretation_FaceDataInterpretation_YesNo_MoreInfo_inner_region_asking_repeat_YesNo() {
		if (check_main_FaceDataInterpretation_FaceDataInterpretation_YesNo_MoreInfo_inner_region_asking_repeat_YesNo_tr0_tr0()) {
			effect_main_FaceDataInterpretation_FaceDataInterpretation_YesNo_MoreInfo_inner_region_asking_repeat_YesNo_tr0();
		}
	}
	
	/* The reactions of state init. */
	private void react_main_FaceDataInterpretation_FaceDataInterpretation_YesNo_MoreInfo_inner_region_init() {
		effect_main_FaceDataInterpretation_FaceDataInterpretation_YesNo_MoreInfo_inner_region_init_tr0();
	}
	
	/* The reactions of state AboutRobotica_3. */
	private void react_main_FaceDataInterpretation_FaceDataInterpretation_AboutRobotica_3() {
		if (check_main_FaceDataInterpretation_FaceDataInterpretation_AboutRobotica_3_tr0_tr0()) {
			effect_main_FaceDataInterpretation_FaceDataInterpretation_AboutRobotica_3_tr0();
		}
	}
	
	/* The reactions of state Closing. */
	private void react_main_FaceDataInterpretation_FaceDataInterpretation_Closing() {
		if (check_main_FaceDataInterpretation_FaceDataInterpretation_Closing_tr0_tr0()) {
			effect_main_FaceDataInterpretation_FaceDataInterpretation_Closing_tr0();
		}
	}
	
	/* The reactions of state neutral. */
	private void react_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_neutral() {
		if (check_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_neutral_tr0_tr0()) {
			effect_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_neutral_tr0();
		}
	}
	
	/* The reactions of state happy. */
	private void react_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_happy() {
		if (check_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_happy_tr0_tr0()) {
			effect_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_happy_tr0();
		}
	}
	
	/* The reactions of state sad. */
	private void react_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_sad() {
		if (check_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_sad_tr0_tr0()) {
			effect_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_sad_tr0();
		}
	}
	
	/* The reactions of state laughing. */
	private void react_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_laughing() {
		if (check_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_laughing_tr0_tr0()) {
			effect_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_laughing_tr0();
		}
	}
	
	/* The reactions of state surprised. */
	private void react_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_surprised() {
		if (check_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_surprised_tr0_tr0()) {
			effect_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_surprised_tr0();
		}
	}
	
	/* The reactions of state angry. */
	private void react_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_angry() {
		if (check_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_angry_tr0_tr0()) {
			effect_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_angry_tr0();
		}
	}
	
	/* The reactions of state tell_joke_0. */
	private void react_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_tell_joke_0() {
		if (check_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_tell_joke_0_tr0_tr0()) {
			effect_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_tell_joke_0_tr0();
		}
	}
	
	/* The reactions of state joke_worked. */
	private void react_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_joke_worked() {
		if (check_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_joke_worked_tr0_tr0()) {
			effect_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_joke_worked_tr0();
		}
	}
	
	/* The reactions of state initialise_jokes. */
	private void react_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_initialise_jokes() {
		if (check_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_initialise_jokes_tr0_tr0()) {
			effect_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_initialise_jokes_tr0();
		}
	}
	
	/* The reactions of state joke_didnt_work. */
	private void react_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_joke_didnt_work() {
		if (check_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_joke_didnt_work_tr0_tr0()) {
			effect_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_joke_didnt_work_tr0();
		}
	}
	
	/* The reactions of state tell_joke_1. */
	private void react_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_tell_joke_1() {
		if (check_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_tell_joke_1_tr0_tr0()) {
			effect_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_tell_joke_1_tr0();
		}
	}
	
	/* The reactions of state tell_joke_2. */
	private void react_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_tell_joke_2() {
		if (check_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_tell_joke_2_tr0_tr0()) {
			effect_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_tell_joke_2_tr0();
		}
	}
	
	/* The reactions of state tell_joke_3. */
	private void react_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_tell_joke_3() {
		if (check_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_tell_joke_3_tr0_tr0()) {
			effect_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_tell_joke_3_tr0();
		}
	}
	
	/* The reactions of state tell_joke_5. */
	private void react_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_tell_joke_5() {
		if (check_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_tell_joke_5_tr0_tr0()) {
			effect_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_tell_joke_5_tr0();
		}
	}
	
	/* The reactions of state tell_joke_6. */
	private void react_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_tell_joke_6() {
		if (check_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_tell_joke_6_tr0_tr0()) {
			effect_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_tell_joke_6_tr0();
		}
	}
	
	/* The reactions of state waitForNewEmo. */
	private void react_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_waitForNewEmo() {
		if (check_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_waitForNewEmo_tr0_tr0()) {
			effect_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_waitForNewEmo_tr0();
		}
	}
	
	/* The reactions of state resetEmo. */
	private void react_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_resetEmo() {
		if (check_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_resetEmo_tr0_tr0()) {
			effect_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_resetEmo_tr0();
		}
	}
	
	/* The reactions of state sadFace. */
	private void react_main_FaceDataInterpretation_FaceDataInterpretation_sadFace() {
		if (check_main_FaceDataInterpretation_FaceDataInterpretation_sadFace_tr0_tr0()) {
			effect_main_FaceDataInterpretation_FaceDataInterpretation_sadFace_tr0();
		}
	}
	
	/* The reactions of state init_face. */
	private void react_main_FaceDataInterpretation_FaceDataInterpretation_init_face() {
		effect_main_FaceDataInterpretation_FaceDataInterpretation_init_face_tr0();
	}
	
	/* The reactions of state StartSTT. */
	private void react_main_FaceDataInterpretation_FaceDataInterpretation_yesNo_fun_inner_region_StartSTT() {
		if (check_main_FaceDataInterpretation_FaceDataInterpretation_yesNo_fun_inner_region_StartSTT_tr0_tr0()) {
			effect_main_FaceDataInterpretation_FaceDataInterpretation_yesNo_fun_inner_region_StartSTT_tr0();
		} else {
			if (check_main_FaceDataInterpretation_FaceDataInterpretation_yesNo_fun_inner_region_StartSTT_tr1_tr1()) {
				effect_main_FaceDataInterpretation_FaceDataInterpretation_yesNo_fun_inner_region_StartSTT_tr1();
			} else {
				if (check_main_FaceDataInterpretation_FaceDataInterpretation_yesNo_fun_inner_region_StartSTT_tr2_tr2()) {
					effect_main_FaceDataInterpretation_FaceDataInterpretation_yesNo_fun_inner_region_StartSTT_tr2();
				} else {
					if (check_main_FaceDataInterpretation_FaceDataInterpretation_yesNo_fun_inner_region_StartSTT_tr3_tr3()) {
						effect_main_FaceDataInterpretation_FaceDataInterpretation_yesNo_fun_inner_region_StartSTT_tr3();
					} else {
						if (check_main_FaceDataInterpretation_FaceDataInterpretation_yesNo_fun_inner_region_StartSTT_tr4_tr4()) {
							effect_main_FaceDataInterpretation_FaceDataInterpretation_yesNo_fun_inner_region_StartSTT_tr4();
						}
					}
				}
			}
		}
	}
	
	/* The reactions of state Copy_1_STT3. */
	private void react_main_FaceDataInterpretation_FaceDataInterpretation_yesNo_fun_inner_region_Copy_1_STT3() {
		if (check_main_FaceDataInterpretation_FaceDataInterpretation_yesNo_fun_inner_region_Copy_1_STT3_tr0_tr0()) {
			effect_main_FaceDataInterpretation_FaceDataInterpretation_yesNo_fun_inner_region_Copy_1_STT3_tr0();
		}
	}
	
	/* The reactions of state asking_repeat_YesNo. */
	private void react_main_FaceDataInterpretation_FaceDataInterpretation_yesNo_fun_inner_region_asking_repeat_YesNo() {
		if (check_main_FaceDataInterpretation_FaceDataInterpretation_yesNo_fun_inner_region_asking_repeat_YesNo_tr0_tr0()) {
			effect_main_FaceDataInterpretation_FaceDataInterpretation_yesNo_fun_inner_region_asking_repeat_YesNo_tr0();
		}
	}
	
	/* The reactions of state init. */
	private void react_main_FaceDataInterpretation_FaceDataInterpretation_yesNo_fun_inner_region_init() {
		effect_main_FaceDataInterpretation_FaceDataInterpretation_yesNo_fun_inner_region_init_tr0();
	}
	
	/* The reactions of state start_estimation. */
	private void react_main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_start_estimation() {
		if (check_main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_start_estimation_tr0_tr0()) {
			effect_main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_start_estimation_tr0();
		} else {
			if (check_main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_start_estimation_tr1_tr1()) {
				effect_main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_start_estimation_tr1();
			}
		}
	}
	
	/* The reactions of state ready. */
	private void react_main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_ready() {
		if (check_main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_ready_tr0_tr0()) {
			effect_main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_ready_tr0();
		} else {
			if (check_main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_ready_tr1_tr1()) {
				effect_main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_ready_tr1();
			} else {
				if (check_main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_ready_tr2_tr2()) {
					effect_main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_ready_tr2();
				}
			}
		}
	}
	
	/* The reactions of state pretty_with_glasses. */
	private void react_main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_pretty_with_glasses() {
		if (check_main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_pretty_with_glasses_tr0_tr0()) {
			effect_main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_pretty_with_glasses_tr0();
		}
	}
	
	/* The reactions of state got_new_attr. */
	private void react_main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_got_new_attr() {
		if (check_main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_got_new_attr_tr0_tr0()) {
			effect_main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_got_new_attr_tr0();
		} else {
			if (check_main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_got_new_attr_tr1_tr1()) {
				effect_main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_got_new_attr_tr1();
			}
		}
	}
	
	/* The reactions of state prettier. */
	private void react_main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_prettier() {
		if (check_main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_prettier_tr0_tr0()) {
			effect_main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_prettier_tr0();
		}
	}
	
	/* The reactions of state not_prettier. */
	private void react_main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_not_prettier() {
		if (check_main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_not_prettier_tr0_tr0()) {
			effect_main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_not_prettier_tr0();
		}
	}
	
	/* The reactions of state pretty. */
	private void react_main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_pretty() {
		if (check_main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_pretty_tr0_tr0()) {
			effect_main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_pretty_tr0();
		}
	}
	
	/* The reactions of state not_pretty. */
	private void react_main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_not_pretty() {
		if (check_main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_not_pretty_tr0_tr0()) {
			effect_main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_not_pretty_tr0();
		}
	}
	
	/* The reactions of state get new attractiveness. */
	private void react_main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_get_new_attractiveness() {
		if (check_main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_get_new_attractiveness_tr0_tr0()) {
			effect_main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_get_new_attractiveness_tr0();
		}
	}
	
	/* The reactions of state asking_unknown. */
	private void react_main_FaceDataInterpretation_FaceDataInterpretation_asking_unknown() {
		if (check_main_FaceDataInterpretation_FaceDataInterpretation_asking_unknown_tr0_tr0()) {
			effect_main_FaceDataInterpretation_FaceDataInterpretation_asking_unknown_tr0();
		}
	}
	
	/* The reactions of state yesNoCancelFunNo. */
	private void react_main_FaceDataInterpretation_FaceDataInterpretation_yesNoCancelFunNo() {
		if (check_main_FaceDataInterpretation_FaceDataInterpretation_yesNoCancelFunNo_tr0_tr0()) {
			effect_main_FaceDataInterpretation_FaceDataInterpretation_yesNoCancelFunNo_tr0();
		}
	}
	
	/* The reactions of state exitCancelAnswer. */
	private void react_main_FaceDataInterpretation_FaceDataInterpretation_exitCancelAnswer() {
		if (check_main_FaceDataInterpretation_FaceDataInterpretation_exitCancelAnswer_tr0_tr0()) {
			effect_main_FaceDataInterpretation_FaceDataInterpretation_exitCancelAnswer_tr0();
		}
	}
	
	/* The reactions of state waitingForSpeaking. */
	private void react_main_FaceDataInterpretation_FaceDataInterpretation_waitingForSpeaking() {
		if (check_main_FaceDataInterpretation_FaceDataInterpretation_waitingForSpeaking_tr0_tr0()) {
			effect_main_FaceDataInterpretation_FaceDataInterpretation_waitingForSpeaking_tr0();
		}
	}
	
	/* The reactions of state AfterGettingName. */
	private void react_main_FaceDataInterpretation_FaceDataInterpretation_AfterGettingName_inner_region_AfterGettingName() {
		if (check_main_FaceDataInterpretation_FaceDataInterpretation_AfterGettingName_inner_region_AfterGettingName_tr0_tr0()) {
			effect_main_FaceDataInterpretation_FaceDataInterpretation_AfterGettingName_inner_region_AfterGettingName_tr0();
		}
	}
	
	/* The reactions of state newRandNum. */
	private void react_main_FaceDataInterpretation_FaceDataInterpretation_AfterGettingName_inner_region_newRandNum() {
		if (check_main_FaceDataInterpretation_FaceDataInterpretation_AfterGettingName_inner_region_newRandNum_tr0_tr0()) {
			effect_main_FaceDataInterpretation_FaceDataInterpretation_AfterGettingName_inner_region_newRandNum_tr0();
		}
	}
	
	/* The reactions of state randNumEnd. */
	private void react_main_FaceDataInterpretation_FaceDataInterpretation_randNumEnd() {
		if (check_main_FaceDataInterpretation_FaceDataInterpretation_randNumEnd_tr0_tr0()) {
			effect_main_FaceDataInterpretation_FaceDataInterpretation_randNumEnd_tr0();
		}
	}
	
	/* The reactions of state wait. */
	private void react_main_wait() {
	}
	
	/* The reactions of state exitSad. */
	private void react_main_exitSad() {
		if (check_main_exitSad_tr0_tr0()) {
			effect_main_exitSad_tr0();
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
	private void react_main_FaceDataInterpretation_FaceDataInterpretation__choice_0() {
		if (check_main_FaceDataInterpretation_FaceDataInterpretation__choice_0_tr1_tr1()) {
			effect_main_FaceDataInterpretation_FaceDataInterpretation__choice_0_tr1();
		} else {
			effect_main_FaceDataInterpretation_FaceDataInterpretation__choice_0_tr0();
		}
	}
	
	/* The reactions of state null. */
	private void react_main_FaceDataInterpretation_FaceDataInterpretation__choice_1() {
		if (check_main_FaceDataInterpretation_FaceDataInterpretation__choice_1_tr0_tr0()) {
			effect_main_FaceDataInterpretation_FaceDataInterpretation__choice_1_tr0();
		} else {
			effect_main_FaceDataInterpretation_FaceDataInterpretation__choice_1_tr1();
		}
	}
	
	/* The reactions of state null. */
	private void react_main_FaceDataInterpretation_FaceDataInterpretation__choice_2() {
		if (check_main_FaceDataInterpretation_FaceDataInterpretation__choice_2_tr0_tr0()) {
			effect_main_FaceDataInterpretation_FaceDataInterpretation__choice_2_tr0();
		} else {
			effect_main_FaceDataInterpretation_FaceDataInterpretation__choice_2_tr1();
		}
	}
	
	/* The reactions of state null. */
	private void react_main_FaceDataInterpretation_FaceDataInterpretation__choice_3() {
		if (check_main_FaceDataInterpretation_FaceDataInterpretation__choice_3_tr0_tr0()) {
			effect_main_FaceDataInterpretation_FaceDataInterpretation__choice_3_tr0();
		} else {
			if (check_main_FaceDataInterpretation_FaceDataInterpretation__choice_3_tr2_tr2()) {
				effect_main_FaceDataInterpretation_FaceDataInterpretation__choice_3_tr2();
			} else {
				effect_main_FaceDataInterpretation_FaceDataInterpretation__choice_3_tr1();
			}
		}
	}
	
	/* The reactions of state null. */
	private void react_main_FaceDataInterpretation_FaceDataInterpretation__choice_4() {
		if (check_main_FaceDataInterpretation_FaceDataInterpretation__choice_4_tr0_tr0()) {
			effect_main_FaceDataInterpretation_FaceDataInterpretation__choice_4_tr0();
		} else {
			if (check_main_FaceDataInterpretation_FaceDataInterpretation__choice_4_tr1_tr1()) {
				effect_main_FaceDataInterpretation_FaceDataInterpretation__choice_4_tr1();
			} else {
				effect_main_FaceDataInterpretation_FaceDataInterpretation__choice_4_tr2();
			}
		}
	}
	
	/* The reactions of state null. */
	private void react_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Yes_No_Question_inner_region__choice_0() {
		if (check_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Yes_No_Question_inner_region__choice_0_tr0_tr0()) {
			effect_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Yes_No_Question_inner_region__choice_0_tr0();
		} else {
			effect_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Yes_No_Question_inner_region__choice_0_tr1();
		}
	}
	
	/* The reactions of state null. */
	private void react_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Yes_No_Question_inner_region__choice_1() {
		if (check_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Yes_No_Question_inner_region__choice_1_tr0_tr0()) {
			effect_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Yes_No_Question_inner_region__choice_1_tr0();
		} else {
			if (check_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Yes_No_Question_inner_region__choice_1_tr1_tr1()) {
				effect_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Yes_No_Question_inner_region__choice_1_tr1();
			} else {
				effect_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Yes_No_Question_inner_region__choice_1_tr2();
			}
		}
	}
	
	/* The reactions of state null. */
	private void react_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName__choice_0() {
		if (check_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName__choice_0_tr0_tr0()) {
			effect_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName__choice_0_tr0();
		} else {
			effect_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName__choice_0_tr1();
		}
	}
	
	/* The reactions of state null. */
	private void react_main_FaceDataInterpretation_FaceDataInterpretation_YesNo_MoreInfo_inner_region__choice_0() {
		if (check_main_FaceDataInterpretation_FaceDataInterpretation_YesNo_MoreInfo_inner_region__choice_0_tr0_tr0()) {
			effect_main_FaceDataInterpretation_FaceDataInterpretation_YesNo_MoreInfo_inner_region__choice_0_tr0();
		} else {
			effect_main_FaceDataInterpretation_FaceDataInterpretation_YesNo_MoreInfo_inner_region__choice_0_tr1();
		}
	}
	
	/* The reactions of state null. */
	private void react_main_FaceDataInterpretation_FaceDataInterpretation_YesNo_MoreInfo_inner_region__choice_1() {
		if (check_main_FaceDataInterpretation_FaceDataInterpretation_YesNo_MoreInfo_inner_region__choice_1_tr0_tr0()) {
			effect_main_FaceDataInterpretation_FaceDataInterpretation_YesNo_MoreInfo_inner_region__choice_1_tr0();
		} else {
			if (check_main_FaceDataInterpretation_FaceDataInterpretation_YesNo_MoreInfo_inner_region__choice_1_tr1_tr1()) {
				effect_main_FaceDataInterpretation_FaceDataInterpretation_YesNo_MoreInfo_inner_region__choice_1_tr1();
			} else {
				effect_main_FaceDataInterpretation_FaceDataInterpretation_YesNo_MoreInfo_inner_region__choice_1_tr2();
			}
		}
	}
	
	/* The reactions of state null. */
	private void react_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region__choice_0() {
		if (check_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region__choice_0_tr1_tr1()) {
			effect_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region__choice_0_tr1();
		} else {
			if (check_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region__choice_0_tr2_tr2()) {
				effect_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region__choice_0_tr2();
			} else {
				if (check_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region__choice_0_tr3_tr3()) {
					effect_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region__choice_0_tr3();
				} else {
					if (check_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region__choice_0_tr4_tr4()) {
						effect_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region__choice_0_tr4();
					} else {
						if (check_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region__choice_0_tr5_tr5()) {
							effect_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region__choice_0_tr5();
						} else {
							effect_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region__choice_0_tr0();
						}
					}
				}
			}
		}
	}
	
	/* The reactions of state null. */
	private void react_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region__choice_1() {
		if (check_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region__choice_1_tr1_tr1()) {
			effect_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region__choice_1_tr1();
		} else {
			effect_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region__choice_1_tr0();
		}
	}
	
	/* The reactions of state null. */
	private void react_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region__choice_2() {
		if (check_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region__choice_2_tr1_tr1()) {
			effect_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region__choice_2_tr1();
		} else {
			if (check_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region__choice_2_tr2_tr2()) {
				effect_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region__choice_2_tr2();
			} else {
				if (check_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region__choice_2_tr3_tr3()) {
					effect_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region__choice_2_tr3();
				} else {
					if (check_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region__choice_2_tr4_tr4()) {
						effect_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region__choice_2_tr4();
					} else {
						if (check_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region__choice_2_tr5_tr5()) {
							effect_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region__choice_2_tr5();
						} else {
							effect_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region__choice_2_tr0();
						}
					}
				}
			}
		}
	}
	
	/* The reactions of state null. */
	private void react_main_FaceDataInterpretation_FaceDataInterpretation__choice_5() {
		if (check_main_FaceDataInterpretation_FaceDataInterpretation__choice_5_tr1_tr1()) {
			effect_main_FaceDataInterpretation_FaceDataInterpretation__choice_5_tr1();
		} else {
			effect_main_FaceDataInterpretation_FaceDataInterpretation__choice_5_tr0();
		}
	}
	
	/* The reactions of state null. */
	private void react_main_FaceDataInterpretation_FaceDataInterpretation_yesNo_fun_inner_region__choice_0() {
		if (check_main_FaceDataInterpretation_FaceDataInterpretation_yesNo_fun_inner_region__choice_0_tr0_tr0()) {
			effect_main_FaceDataInterpretation_FaceDataInterpretation_yesNo_fun_inner_region__choice_0_tr0();
		} else {
			effect_main_FaceDataInterpretation_FaceDataInterpretation_yesNo_fun_inner_region__choice_0_tr1();
		}
	}
	
	/* The reactions of state null. */
	private void react_main_FaceDataInterpretation_FaceDataInterpretation_yesNo_fun_inner_region__choice_1() {
		if (check_main_FaceDataInterpretation_FaceDataInterpretation_yesNo_fun_inner_region__choice_1_tr0_tr0()) {
			effect_main_FaceDataInterpretation_FaceDataInterpretation_yesNo_fun_inner_region__choice_1_tr0();
		} else {
			if (check_main_FaceDataInterpretation_FaceDataInterpretation_yesNo_fun_inner_region__choice_1_tr1_tr1()) {
				effect_main_FaceDataInterpretation_FaceDataInterpretation_yesNo_fun_inner_region__choice_1_tr1();
			} else {
				effect_main_FaceDataInterpretation_FaceDataInterpretation_yesNo_fun_inner_region__choice_1_tr2();
			}
		}
	}
	
	/* The reactions of state null. */
	private void react_main_FaceDataInterpretation_FaceDataInterpretation__choice_6() {
		if (check_main_FaceDataInterpretation_FaceDataInterpretation__choice_6_tr0_tr0()) {
			effect_main_FaceDataInterpretation_FaceDataInterpretation__choice_6_tr0();
		} else {
			effect_main_FaceDataInterpretation_FaceDataInterpretation__choice_6_tr1();
		}
	}
	
	/* The reactions of state null. */
	private void react_main_FaceDataInterpretation_FaceDataInterpretation_AfterGettingName_inner_region__choice_0() {
		if (check_main_FaceDataInterpretation_FaceDataInterpretation_AfterGettingName_inner_region__choice_0_tr0_tr0()) {
			effect_main_FaceDataInterpretation_FaceDataInterpretation_AfterGettingName_inner_region__choice_0_tr0();
		} else {
			effect_main_FaceDataInterpretation_FaceDataInterpretation_AfterGettingName_inner_region__choice_0_tr1();
		}
	}
	
	/* Default react sequence for initial entry  */
	private void react_main__entry_Default() {
		enterSequence_main_Init_default();
	}
	
	/* Default react sequence for initial entry  */
	private void react_main_FaceDataInterpretation_FaceDataInterpretation__entry_Default() {
		enterSequence_main_FaceDataInterpretation_FaceDataInterpretation_init_face_default();
	}
	
	/* Default react sequence for initial entry  */
	private void react_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Yes_No_Question_inner_region__entry_Default() {
		enterSequence_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Yes_No_Question_inner_region_StartSTT_default();
	}
	
	/* Default react sequence for initial entry  */
	private void react_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName__entry_Default() {
		enterSequence_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_STT_1_default();
	}
	
	/* Default react sequence for initial entry  */
	private void react_main_FaceDataInterpretation_FaceDataInterpretation_YesNo_MoreInfo_inner_region__entry_Default() {
		enterSequence_main_FaceDataInterpretation_FaceDataInterpretation_YesNo_MoreInfo_inner_region_init_default();
	}
	
	/* Default react sequence for initial entry  */
	private void react_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region__entry_Default() {
		enterSequence_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_resetEmo_default();
	}
	
	/* Default react sequence for initial entry  */
	private void react_main_FaceDataInterpretation_FaceDataInterpretation_yesNo_fun_inner_region__entry_Default() {
		enterSequence_main_FaceDataInterpretation_FaceDataInterpretation_yesNo_fun_inner_region_init_default();
	}
	
	/* Default react sequence for initial entry  */
	private void react_main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog__entry_Default() {
		enterSequence_main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_start_estimation_default();
	}
	
	/* Default react sequence for initial entry  */
	private void react_main_FaceDataInterpretation_FaceDataInterpretation_AfterGettingName_inner_region__entry_Default() {
		enterSequence_main_FaceDataInterpretation_FaceDataInterpretation_AfterGettingName_inner_region_newRandNum_default();
	}
	
	/* Default react sequence for initial entry  */
	private void react_Leonie_Bupered_Or_Emergency_Stop__entry_Default() {
		enterSequence_Leonie_Bupered_Or_Emergency_Stop_waitForEvent_default();
	}
	
	/* The reactions of exit exit_NameSaved. */
	private void react_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_exit_NameSaved() {
		effect_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_tr0();
	}
	
	/* The reactions of exit exit_NameNotSaved. */
	private void react_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_exit_NameNotSaved() {
		effect_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_tr1();
	}
	
	/* The reactions of exit exit_yes. */
	private void react_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Yes_No_Question_inner_region_exit_yes() {
		effect_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Yes_No_Question_tr0();
	}
	
	/* The reactions of exit exit_interrupt. */
	private void react_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Yes_No_Question_inner_region_exit_interrupt() {
		effect_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Yes_No_Question_tr1();
	}
	
	/* The reactions of exit exit_no. */
	private void react_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Yes_No_Question_inner_region_exit_no() {
		effect_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Yes_No_Question_tr2();
	}
	
	/* The reactions of exit exit_repeat. */
	private void react_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Yes_No_Question_inner_region_exit_repeat() {
		effect_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Yes_No_Question_tr3();
	}
	
	/* The reactions of exit exit_yes. */
	private void react_main_FaceDataInterpretation_FaceDataInterpretation_YesNo_MoreInfo_inner_region_exit_yes() {
		effect_main_FaceDataInterpretation_FaceDataInterpretation_YesNo_MoreInfo_tr0();
	}
	
	/* The reactions of exit exit_no. */
	private void react_main_FaceDataInterpretation_FaceDataInterpretation_YesNo_MoreInfo_inner_region_exit_no() {
		effect_main_FaceDataInterpretation_FaceDataInterpretation_YesNo_MoreInfo_tr1();
	}
	
	/* The reactions of exit exit_cancel. */
	private void react_main_FaceDataInterpretation_FaceDataInterpretation_YesNo_MoreInfo_inner_region_exit_cancel() {
		effect_main_FaceDataInterpretation_FaceDataInterpretation_YesNo_MoreInfo_tr2();
	}
	
	/* The reactions of exit exit_Emotion_Interpretation0. */
	private void react_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_exit_Emotion_Interpretation0() {
		effect_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_tr0();
	}
	
	/* The reactions of exit exit_endCon. */
	private void react_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_exit_endCon() {
		effect_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_tr1();
	}
	
	/* The reactions of exit exit_FDI. */
	private void react_main_FaceDataInterpretation_FaceDataInterpretation_exit_FDI() {
		effect_main_FaceDataInterpretation_tr0();
	}
	
	/* The reactions of exit exit_FDI_sad. */
	private void react_main_FaceDataInterpretation_FaceDataInterpretation_exit_FDI_sad() {
		effect_main_FaceDataInterpretation_tr1();
	}
	
	/* The reactions of exit exit_yes. */
	private void react_main_FaceDataInterpretation_FaceDataInterpretation_yesNo_fun_inner_region_exit_yes() {
		effect_main_FaceDataInterpretation_FaceDataInterpretation_yesNo_fun_tr1();
	}
	
	/* The reactions of exit exit_no. */
	private void react_main_FaceDataInterpretation_FaceDataInterpretation_yesNo_fun_inner_region_exit_no() {
		effect_main_FaceDataInterpretation_FaceDataInterpretation_yesNo_fun_tr0();
	}
	
	/* The reactions of exit exit_cancel. */
	private void react_main_FaceDataInterpretation_FaceDataInterpretation_yesNo_fun_inner_region_exit_cancel() {
		effect_main_FaceDataInterpretation_FaceDataInterpretation_yesNo_fun_tr2();
	}
	
	/* The reactions of exit exit_default. */
	private void react_main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_exit_default() {
		effect_main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_tr1();
	}
	
	/* The reactions of exit exit_endCon. */
	private void react_main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_exit_endCon() {
		effect_main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_tr0();
	}
	
	/* The reactions of exit exit_AfterGettingName0. */
	private void react_main_FaceDataInterpretation_FaceDataInterpretation_AfterGettingName_inner_region_exit_AfterGettingName0() {
		effect_main_FaceDataInterpretation_FaceDataInterpretation_AfterGettingName_tr0();
	}
	
	public void runCycle() {
		if (!initialized)
			throw new IllegalStateException(
					"The state machine needs to be initialized first by calling the init() function.");
		clearOutEvents();
		for (nextStateIndex = 0; nextStateIndex < stateVector.length; nextStateIndex++) {
			switch (stateVector[nextStateIndex]) {
			case main_Init:
				react_main_Init();
				break;
			case main__final_:
				react_main__final_();
				break;
			case main_AtWP01___ACI:
				react_main_AtWP01___ACI();
				break;
			case main_wait_for_cleaning_VBrain_buffer:
				react_main_wait_for_cleaning_VBrain_buffer();
				break;
			case main_FaceDataInterpretation_FaceDataInterpretation_PersonKnownWithName:
				react_main_FaceDataInterpretation_FaceDataInterpretation_PersonKnownWithName();
				break;
			case main_FaceDataInterpretation_FaceDataInterpretation_UnknownGirl:
				react_main_FaceDataInterpretation_FaceDataInterpretation_UnknownGirl();
				break;
			case main_FaceDataInterpretation_FaceDataInterpretation_PersonKnownWithoutName:
				react_main_FaceDataInterpretation_FaceDataInterpretation_PersonKnownWithoutName();
				break;
			case main_FaceDataInterpretation_FaceDataInterpretation_UnknownFemaleTeen:
				react_main_FaceDataInterpretation_FaceDataInterpretation_UnknownFemaleTeen();
				break;
			case main_FaceDataInterpretation_FaceDataInterpretation_UnknownWomen:
				react_main_FaceDataInterpretation_FaceDataInterpretation_UnknownWomen();
				break;
			case main_FaceDataInterpretation_FaceDataInterpretation_UnknownBoy:
				react_main_FaceDataInterpretation_FaceDataInterpretation_UnknownBoy();
				break;
			case main_FaceDataInterpretation_FaceDataInterpretation_UnknownMaleTeen:
				react_main_FaceDataInterpretation_FaceDataInterpretation_UnknownMaleTeen();
				break;
			case main_FaceDataInterpretation_FaceDataInterpretation_UnknownMen:
				react_main_FaceDataInterpretation_FaceDataInterpretation_UnknownMen();
				break;
			case main_FaceDataInterpretation_FaceDataInterpretation_wait_for_getting_datas:
				react_main_FaceDataInterpretation_FaceDataInterpretation_wait_for_getting_datas();
				break;
			case main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_STT_1:
				react_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_STT_1();
				break;
			case main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Answere_name__and_ask:
				react_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Answere_name__and_ask();
				break;
			case main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_STT3:
				react_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_STT3();
				break;
			case main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Save_Firstname:
				react_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Save_Firstname();
				break;
			case main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Ask_for_Repeat:
				react_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Ask_for_Repeat();
				break;
			case main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Didnt_get_it:
				react_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Didnt_get_it();
				break;
			case main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Bye_bye:
				react_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Bye_bye();
				break;
			case main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Yes_No_Question_inner_region_StartSTT:
				react_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Yes_No_Question_inner_region_StartSTT();
				break;
			case main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Yes_No_Question_inner_region_Copy_1_STT3:
				react_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_Yes_No_Question_inner_region_Copy_1_STT3();
				break;
			case main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_asking_repeat_YesNo:
				react_main_FaceDataInterpretation_FaceDataInterpretation_Getting_Name_AskForName_asking_repeat_YesNo();
				break;
			case main_FaceDataInterpretation_FaceDataInterpretation_AboutRobotica_1:
				react_main_FaceDataInterpretation_FaceDataInterpretation_AboutRobotica_1();
				break;
			case main_FaceDataInterpretation_FaceDataInterpretation_AboutRobotica_2:
				react_main_FaceDataInterpretation_FaceDataInterpretation_AboutRobotica_2();
				break;
			case main_FaceDataInterpretation_FaceDataInterpretation_RandomTopic_1:
				react_main_FaceDataInterpretation_FaceDataInterpretation_RandomTopic_1();
				break;
			case main_FaceDataInterpretation_FaceDataInterpretation_RandomTopic_2:
				react_main_FaceDataInterpretation_FaceDataInterpretation_RandomTopic_2();
				break;
			case main_FaceDataInterpretation_FaceDataInterpretation_Prompt_2:
				react_main_FaceDataInterpretation_FaceDataInterpretation_Prompt_2();
				break;
			case main_FaceDataInterpretation_FaceDataInterpretation_Prompt_1:
				react_main_FaceDataInterpretation_FaceDataInterpretation_Prompt_1();
				break;
			case main_FaceDataInterpretation_FaceDataInterpretation_Farewell_1:
				react_main_FaceDataInterpretation_FaceDataInterpretation_Farewell_1();
				break;
			case main_FaceDataInterpretation_FaceDataInterpretation_Farewell_2:
				react_main_FaceDataInterpretation_FaceDataInterpretation_Farewell_2();
				break;
			case main_FaceDataInterpretation_FaceDataInterpretation_Farewell_3:
				react_main_FaceDataInterpretation_FaceDataInterpretation_Farewell_3();
				break;
			case main_FaceDataInterpretation_FaceDataInterpretation_Farewell_4:
				react_main_FaceDataInterpretation_FaceDataInterpretation_Farewell_4();
				break;
			case main_FaceDataInterpretation_FaceDataInterpretation_Selection:
				react_main_FaceDataInterpretation_FaceDataInterpretation_Selection();
				break;
			case main_FaceDataInterpretation_FaceDataInterpretation_newRandNum:
				react_main_FaceDataInterpretation_FaceDataInterpretation_newRandNum();
				break;
			case main_FaceDataInterpretation_FaceDataInterpretation_RandomTopic_3:
				react_main_FaceDataInterpretation_FaceDataInterpretation_RandomTopic_3();
				break;
			case main_FaceDataInterpretation_FaceDataInterpretation_Selection_2:
				react_main_FaceDataInterpretation_FaceDataInterpretation_Selection_2();
				break;
			case main_FaceDataInterpretation_FaceDataInterpretation_AlternativeConv_1:
				react_main_FaceDataInterpretation_FaceDataInterpretation_AlternativeConv_1();
				break;
			case main_FaceDataInterpretation_FaceDataInterpretation_Selection_3:
				react_main_FaceDataInterpretation_FaceDataInterpretation_Selection_3();
				break;
			case main_FaceDataInterpretation_FaceDataInterpretation_YesNo_MoreInfo_inner_region_StartSTT:
				react_main_FaceDataInterpretation_FaceDataInterpretation_YesNo_MoreInfo_inner_region_StartSTT();
				break;
			case main_FaceDataInterpretation_FaceDataInterpretation_YesNo_MoreInfo_inner_region_Copy_1_STT3:
				react_main_FaceDataInterpretation_FaceDataInterpretation_YesNo_MoreInfo_inner_region_Copy_1_STT3();
				break;
			case main_FaceDataInterpretation_FaceDataInterpretation_YesNo_MoreInfo_inner_region_asking_repeat_YesNo:
				react_main_FaceDataInterpretation_FaceDataInterpretation_YesNo_MoreInfo_inner_region_asking_repeat_YesNo();
				break;
			case main_FaceDataInterpretation_FaceDataInterpretation_YesNo_MoreInfo_inner_region_init:
				react_main_FaceDataInterpretation_FaceDataInterpretation_YesNo_MoreInfo_inner_region_init();
				break;
			case main_FaceDataInterpretation_FaceDataInterpretation_AboutRobotica_3:
				react_main_FaceDataInterpretation_FaceDataInterpretation_AboutRobotica_3();
				break;
			case main_FaceDataInterpretation_FaceDataInterpretation_Closing:
				react_main_FaceDataInterpretation_FaceDataInterpretation_Closing();
				break;
			case main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_neutral:
				react_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_neutral();
				break;
			case main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_happy:
				react_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_happy();
				break;
			case main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_sad:
				react_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_sad();
				break;
			case main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_laughing:
				react_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_laughing();
				break;
			case main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_surprised:
				react_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_surprised();
				break;
			case main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_angry:
				react_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_angry();
				break;
			case main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_tell_joke_0:
				react_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_tell_joke_0();
				break;
			case main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_joke_worked:
				react_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_joke_worked();
				break;
			case main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_initialise_jokes:
				react_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_initialise_jokes();
				break;
			case main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_joke_didnt_work:
				react_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_joke_didnt_work();
				break;
			case main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_tell_joke_1:
				react_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_tell_joke_1();
				break;
			case main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_tell_joke_2:
				react_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_tell_joke_2();
				break;
			case main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_tell_joke_3:
				react_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_tell_joke_3();
				break;
			case main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_tell_joke_5:
				react_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_tell_joke_5();
				break;
			case main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_tell_joke_6:
				react_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_tell_joke_6();
				break;
			case main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_waitForNewEmo:
				react_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_waitForNewEmo();
				break;
			case main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_resetEmo:
				react_main_FaceDataInterpretation_FaceDataInterpretation_Composite_Emotion_Interpretation_inner_region_resetEmo();
				break;
			case main_FaceDataInterpretation_FaceDataInterpretation_sadFace:
				react_main_FaceDataInterpretation_FaceDataInterpretation_sadFace();
				break;
			case main_FaceDataInterpretation_FaceDataInterpretation_init_face:
				react_main_FaceDataInterpretation_FaceDataInterpretation_init_face();
				break;
			case main_FaceDataInterpretation_FaceDataInterpretation_yesNo_fun_inner_region_StartSTT:
				react_main_FaceDataInterpretation_FaceDataInterpretation_yesNo_fun_inner_region_StartSTT();
				break;
			case main_FaceDataInterpretation_FaceDataInterpretation_yesNo_fun_inner_region_Copy_1_STT3:
				react_main_FaceDataInterpretation_FaceDataInterpretation_yesNo_fun_inner_region_Copy_1_STT3();
				break;
			case main_FaceDataInterpretation_FaceDataInterpretation_yesNo_fun_inner_region_asking_repeat_YesNo:
				react_main_FaceDataInterpretation_FaceDataInterpretation_yesNo_fun_inner_region_asking_repeat_YesNo();
				break;
			case main_FaceDataInterpretation_FaceDataInterpretation_yesNo_fun_inner_region_init:
				react_main_FaceDataInterpretation_FaceDataInterpretation_yesNo_fun_inner_region_init();
				break;
			case main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_start_estimation:
				react_main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_start_estimation();
				break;
			case main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_ready:
				react_main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_ready();
				break;
			case main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_pretty_with_glasses:
				react_main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_pretty_with_glasses();
				break;
			case main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_got_new_attr:
				react_main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_got_new_attr();
				break;
			case main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_prettier:
				react_main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_prettier();
				break;
			case main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_not_prettier:
				react_main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_not_prettier();
				break;
			case main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_pretty:
				react_main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_pretty();
				break;
			case main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_not_pretty:
				react_main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_not_pretty();
				break;
			case main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_get_new_attractiveness:
				react_main_FaceDataInterpretation_FaceDataInterpretation_attractiveness_Attractivity_Dialog_get_new_attractiveness();
				break;
			case main_FaceDataInterpretation_FaceDataInterpretation_asking_unknown:
				react_main_FaceDataInterpretation_FaceDataInterpretation_asking_unknown();
				break;
			case main_FaceDataInterpretation_FaceDataInterpretation_yesNoCancelFunNo:
				react_main_FaceDataInterpretation_FaceDataInterpretation_yesNoCancelFunNo();
				break;
			case main_FaceDataInterpretation_FaceDataInterpretation_exitCancelAnswer:
				react_main_FaceDataInterpretation_FaceDataInterpretation_exitCancelAnswer();
				break;
			case main_FaceDataInterpretation_FaceDataInterpretation_waitingForSpeaking:
				react_main_FaceDataInterpretation_FaceDataInterpretation_waitingForSpeaking();
				break;
			case main_FaceDataInterpretation_FaceDataInterpretation_AfterGettingName_inner_region_AfterGettingName:
				react_main_FaceDataInterpretation_FaceDataInterpretation_AfterGettingName_inner_region_AfterGettingName();
				break;
			case main_FaceDataInterpretation_FaceDataInterpretation_AfterGettingName_inner_region_newRandNum:
				react_main_FaceDataInterpretation_FaceDataInterpretation_AfterGettingName_inner_region_newRandNum();
				break;
			case main_FaceDataInterpretation_FaceDataInterpretation_randNumEnd:
				react_main_FaceDataInterpretation_FaceDataInterpretation_randNumEnd();
				break;
			case main_wait:
				react_main_wait();
				break;
			case main_exitSad:
				react_main_exitSad();
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
