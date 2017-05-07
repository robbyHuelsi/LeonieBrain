package callbacks;


import communication.Communication;
import main.Start;
import modules.Modules;
import modules.parser.STT;

public class OpCallbackImplSTT implements IOpCallbackImpl,
	org.yakindu.scr.braganca.IBragancaStatemachine.SCISTTOperationCallback,
	org.yakindu.scr.speechandpersonrecognition.ISpeechAndPersonRecognitionStatemachine.SCISTTOperationCallback,
	org.yakindu.scr.helpmecarry.IHelpMeCarryStatemachine.SCISTTOperationCallback,
	org.yakindu.scr.generalpurposeservicerobot.IGeneralPurposeServiceRobotStatemachine.SCISTTOperationCallback,
	org.yakindu.scr.test_stt_smalltalk.ITest_STT_SmalltalkStatemachine.SCISTTOperationCallback,
	org.yakindu.scr.test_stt_yesno.ITest_STT_YesNoStatemachine.SCISTTOperationCallback,
	org.yakindu.scr.test_stt_names.ITest_STT_NamesStatemachine.SCISTTOperationCallback,
	org.yakindu.scr.test_blindmansbluff.ITest_BlindMansBluffStatemachine.SCISTTOperationCallback,
	org.yakindu.scr.openchallenge.IOpenChallengeStatemachine.SCISTTOperationCallback,
	org.yakindu.scr.eegpsr.IEEGPSRStatemachine.SCISTTOperationCallback,
	org.yakindu.scr.finale.IFinaleStatemachine.SCISTTOperationCallback
{
	
	private Modules modules = Start.instanceOf().getModules();
	
	public String getSpokenText() {
		return ((STT)modules.getParser("STT")).getSpokenText();
	}
	
	public String getAnswer() {
		return ((STT)modules.getParser("STT")).getAnswer();
	}

	public String getInstruction() {
		return ((STT)modules.getParser("STT")).getInstruction();
	}

	public String getObject() {
		return ((STT)modules.getParser("STT")).getObject();
	}
	
	public long getActionListLength() {
		return ((STT)modules.getParser("STT")).getActionListLength();
	}

	public String getInstructionFromActionListAt(long i) {
		return ((STT)modules.getParser("STT")).getInstructionFromActionListAt(i);
	}

	public String getObjectFromActionListAt(long i) {
		return ((STT)modules.getParser("STT")).getObjectFromActionListAt(i);
	}

	public String getLocationFromActionListAt(long i) {
		return ((STT)modules.getParser("STT")).getLocationFromActionListAt(i);
	}
	
	public String getActionCommandSentence() {
		return ((STT)modules.getParser("STT")).getActionCommandSentence();
	}

	public void sendSpeechDetectionOff() {
		Communication.sendMessage("#STT#0#", modules.get("STT"));
	}

	public void sendSpeechDetectionSmalltalk() {
		Communication.sendMessage("#STT#1#", modules.get("STT"));
		
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

	public void sendSpeechDetectionYesNo() {
		Communication.sendMessage("#STT#2#", modules.get("STT"));
		
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

	public void sendSpeechDetectionName() {
		Communication.sendMessage("#STT#3#", modules.get("STT"));
		
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

	public void sendSpeechDetectionActions() {
	Communication.sendMessage("#STT#4#", modules.get("STT"));
		
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
	

	public void sendInit() {
		sendSpeechDetectionOff();
	}


}
