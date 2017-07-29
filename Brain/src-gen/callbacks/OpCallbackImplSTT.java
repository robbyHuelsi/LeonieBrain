package callbacks;


import communication.Communication;
import main.Log;
import main.Start;
import modules.Module;
import modules.Modules;
import modules.parser.STT;

public class OpCallbackImplSTT implements IOpCallbackImpl,
	org.yakindu.scr.braganca.IBragancaStatemachine.SCISTTOperationCallback,
	org.yakindu.scr.speechandpersonrecognition.ISpeechAndPersonRecognitionStatemachine.SCISTTOperationCallback,
	org.yakindu.scr.helpmecarry.IHelpMeCarryStatemachine.SCISTTOperationCallback,
	org.yakindu.scr.generalpurposeservicerobotv1.IGeneralPurposeServiceRobotV1Statemachine.SCISTTOperationCallback,
	org.yakindu.scr.generalpurposeservicerobotv2.IGeneralPurposeServiceRobotV2Statemachine.SCISTTOperationCallback,
	org.yakindu.scr.test_stt_smalltalk.ITest_STT_SmalltalkStatemachine.SCISTTOperationCallback,
	org.yakindu.scr.test_stt_yesno.ITest_STT_YesNoStatemachine.SCISTTOperationCallback,
	org.yakindu.scr.test_stt_names.ITest_STT_NamesStatemachine.SCISTTOperationCallback,
	org.yakindu.scr.test_blindmansbluff.ITest_BlindMansBluffStatemachine.SCISTTOperationCallback,
	org.yakindu.scr.openchallengemagdeburg.IOpenChallengeMagdeburgStatemachine.SCISTTOperationCallback,
	org.yakindu.scr.extendedgeneralpurposeservicerobot.IExtendedGeneralPurposeServiceRobotStatemachine.SCISTTOperationCallback,
	org.yakindu.scr.finale.IFinaleStatemachine.SCISTTOperationCallback,
	org.yakindu.scr.restaurant.IRestaurantStatemachine.SCISTTOperationCallback
{
	private Log log = Start.instanceOf().getLog();
	private Module module = Start.instanceOf().getModules().get("STT");
	
	
	public void send(String command){
		if (module.isInternal()) {
			// for internal Modules
		}else{
			Communication.sendMessage(command, module, log);
		}
	}
	
	public void sendInit() {
//		sendSpeechDetectionOff();
	}
	
	public void sendPing() {
		send("#STT#REQUEST#READY#");
	}
	
	/* ---------------------------------------------------------------- */
	
	public String getSpokenText() {
		return ((STT)module.getParser()).getSpokenText();
	}
	
	public String getAnswer() {
		return ((STT)module.getParser()).getAnswer();
	}

	public String getInstruction() {
		return ((STT)module.getParser()).getInstruction();
	}

	public String getObject() {
		return ((STT)module.getParser()).getObject();
	}
	
	public long getActionListLength() {
		return ((STT)module.getParser()).getActionListLength();
	}

	public String getInstructionFromActionListAt(long i) {
		return ((STT)module.getParser()).getInstructionFromActionListAt(i);
	}

	public String getObjectFromActionListAt(long i) {
		return ((STT)module.getParser()).getObjectFromActionListAt(i);
	}

	public String getLocationFromActionListAt(long i) {
		return ((STT)module.getParser()).getLocationFromActionListAt(i);
	}
	
	public String getAllActionCommandsSentence() {
		return ((STT)module.getParser()).getAllActionCommandsSentence();
	}
	
	public String getSingleActionCommandSentence(long i) {
		return ((STT)module.getParser()).getSingleActionCommandSentence(i);
	}


	@Override
	public void sendSpeechDetectionSmalltalk(long timeout) {
		// TODO Auto-generated method stub
		send("#STT#1#" + timeout + "#");
		
		STT stt = (STT)Start.getModules().getParser("STT");
		stt.setSpokenText("");
		stt.setInstruction("");
		stt.setObject("");
		//stt.resetActionList(); //Für General Purpose muss ActionList weiterhin verfügbar bleiben!
		stt.setSpokenTextReceived(false);
		stt.setIncomprehensible(false);
		stt.setActionReceived(false);
		stt.setActionsReceived(false);
		
	}

	@Override
	public void sendSpeechDetectionYesNo(long timeout) {
		// TODO Auto-generated method stub
		send("#STT#2#"+ timeout + "#");
		
		STT stt = (STT)Start.getModules().getParser("STT");
		stt.setSpokenText("");
		stt.setInstruction("");
		stt.setObject("");
		//stt.resetActionList(); //Für General Purpose muss ActionList weiterhin verfügbar bleiben!
		stt.setSpokenTextReceived(false);
		stt.setIncomprehensible(false);
		stt.setActionReceived(false);
		stt.setActionsReceived(false);
	}

	@Override
	public void sendSpeechDetectionName(long timeout) {
		// TODO Auto-generated method stub
		send("#STT#3#"+ timeout + "#");
		
		STT stt = (STT)Start.getModules().getParser("STT");
		stt.setSpokenText("");
		stt.setInstruction("");
		stt.setObject("");
		//stt.resetActionList(); //Für General Purpose muss ActionList weiterhin verfügbar bleiben!
		stt.setSpokenTextReceived(false);
		stt.setIncomprehensible(false);
		stt.setActionReceived(false);
		stt.setActionsReceived(false);
		
	}

	@Override
	public void sendSpeechDetectionActions(long timeout) {
		// TODO Auto-generated method stub
	send("#STT#4#"+ timeout + "#");
		
		STT stt = (STT)Start.getModules().getParser("STT");
		stt.setSpokenText("");
		stt.setInstruction("");
		stt.setObject("");
		stt.resetActionList();
		stt.setSpokenTextReceived(false);
		stt.setIncomprehensible(false);
		stt.setActionReceived(false);
		stt.setActionsReceived(false);
		
	}
	
	@Override
	public void sendSpeechDetectionOrder(long timeout) {
		send("#STT#5#"+ timeout + "#");
	}

	@Override
	public String getOrderSentenceForBarkeeper() {
		return ((STT)module.getParser()).getOrderSentence();
	}

	@Override
	public void sendSpeechDetectionOrder(long timeout) {
		send("#STT#5#"+ timeout + "#");
	}

	@Override
	public String getOrderSentenceForBarkeeper() {
		return ((STT)module.getParser()).getOrderSentence();
	}



}
