package callbacks;


import communication.Communication;
import main.Start;
import modules.Modules;
import modules.parser.STT;

public class OpCallbackImplSTT implements
	org.yakindu.scr.braganca.IBragancaStatemachine.SCISTTOperationCallback,
	org.yakindu.scr.speechandpersonrecognition.ISpeechAndPersonRecognitionStatemachine.SCISTTOperationCallback,
	org.yakindu.scr.test_stt_hbrain.ITest_STT_HBrainStatemachine.SCISTTOperationCallback
{
	
	private Modules modules = Start.instanceOf().getModules();
	
	public String getText() {
		return ((STT)modules.getParser("STT")).getText();
	}

	public String getInstruction() {
		return ((STT)modules.getParser("STT")).getInstruction();
	}

	public String getObject() {
		return ((STT)modules.getParser("STT")).getObject();
	}

	public void sendSpeechDetectionOff() {
		Communication.sendMessage("#STT#0#", modules.get("STT"));
	}

	public void sendSpeechDetectionSmalltalk() {
		Communication.sendMessage("#STT#1#", modules.get("STT"));
		
		STT stt = (STT)Start.getModules().getParser("STT");
		stt.setText("");
		stt.setInstruction("");
		stt.setObject("");
		stt.setTextReceived(false);
		stt.setIncomprehensible(false);
		stt.setActionReceived(false);
	}

	@Override
	public void sendSpeechDetectionYesNo() {
		Communication.sendMessage("#STT#2#", modules.get("STT"));
		
		STT stt = (STT)Start.getModules().getParser("STT");
		stt.setText("");
		stt.setInstruction("");
		stt.setObject("");
		stt.setTextReceived(false);
		stt.setIncomprehensible(false);
		stt.setActionReceived(false);
	}

	@Override
	public void sendSpeechDetectionName() {
		Communication.sendMessage("#STT#3#", modules.get("STT"));
		
		STT stt = (STT)Start.getModules().getParser("STT");
		stt.setText("");
		stt.setInstruction("");
		stt.setObject("");
		stt.setTextReceived(false);
		stt.setIncomprehensible(false);
		stt.setActionReceived(false);
	}

	@Override
	public String getSpokenText() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getAnswer() {
		// TODO Auto-generated method stub
		return null;
	}


}
