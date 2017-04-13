package callbacks;


import communication.Communication;
import main.Start;
import modules.Modules;

public class OpCallbackImplLeapMotion implements
	org.yakindu.scr.braganca.IBragancaStatemachine.SCILeapMotionOperationCallback,
	org.yakindu.scr.speechandpersonrecognition.ISpeechAndPersonRecognitionStatemachine.SCILeapMotionOperationCallback
{
	
	private Modules modules = Start.getModules();
	
	public void sendGestureDetectionOnOff(long inOnOff){
		Communication.sendMessage("#HANDGESTURES#" + (int)inOnOff + "#", modules.get("HandGestures"));
	}
}
