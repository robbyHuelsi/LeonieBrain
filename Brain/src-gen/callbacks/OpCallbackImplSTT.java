package callbacks;


import communication.Communication;
import main.Start;
import modules.Modules;
import modules.parser.STT;

public class OpCallbackImplSTT implements
	org.yakindu.scr.braganca.IBragancaStatemachine.SCISTTOperationCallback,
	org.yakindu.scr.speechandpersonrecognition.ISpeechAndPersonRecognitionStatemachine.SCISTTOperationCallback
{
	
	private Modules modules = Start.getModules();
	
	public void sendSpeechDetectionOnOff(long inOnOff){
		Communication.sendMessage("#STT#" + (inOnOff==0?"0":(inOnOff==1?"1":(inOnOff==2?"yesno":"name"))) + "#", modules.get("STT"));
		if(inOnOff != 0){
			STT stt = (STT)Start.getModules().getParser("STT");
			stt.setSTTReady(false);
			stt.setAnswerFound(false);
			stt.setAnswerToGive("");
			stt.setFilteredMsg("");
			stt.setSpeakerMsg("");
		}
	}

	@Override
	public String getAnswerToGive() {
		return ((STT)modules.getParser("STT")).getAnswerToGive();
	}

	@Override
	public String getSpeakerMsg() {
		return ((STT)modules.getParser("STT")).getSpeakerMsg();
	}

	@Override
	public String getFilteredMsg() {
		return ((STT)modules.getParser("STT")).getFilteredMsg();
	}

	@Override
	public String getFilterBubble() {
		return ((STT)modules.getParser("STT")).getFilterBubble();
	}

	@Override
	public void resetAnswerToGive() {
		((STT)modules.getParser("STT")).setAnswerToGive("");
	}

	@Override
	public void resetSpeakerMsg() {
		((STT)modules.getParser("STT")).setSpeakerMsg("");;
		
	}

	@Override
	public void resetFilteredMsg() {
		((STT)modules.getParser("STT")).setFilteredMsg("");
	}

	@Override
	public void resetFilterBubble() {
		((STT)modules.getParser("STT")).setFilterBubble("");
	}

}
