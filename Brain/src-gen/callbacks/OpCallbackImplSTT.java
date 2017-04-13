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
			//TODO: stt.setSpeakerMsg(""); //Brauchen wir das noch?
			//TODO: stt.setFilteredMsg(""); //Brauchen wir das noch?
		}
	}

}
