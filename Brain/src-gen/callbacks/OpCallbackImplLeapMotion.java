package callbacks;


import communication.Communication;
import main.Start;
import modules.Modules;
import modules.parser.LeapMotion;

public class OpCallbackImplLeapMotion implements
	org.yakindu.scr.braganca.IBragancaStatemachine.SCILeapMotionOperationCallback,
	org.yakindu.scr.speechandpersonrecognition.ISpeechAndPersonRecognitionStatemachine.SCILeapMotionOperationCallback
{
	
	private Modules modules = Start.instanceOf().getModules();
	
	public void sendGestureDetectionOnOff(long inOnOff){
		Communication.sendMessage("#HANDGESTURES#" + (int)inOnOff + "#", modules.get("HandGestures"));
	}

	@Override
	public String getGesture() {
		return ((LeapMotion)modules.getParser("LeapMotion")).getGesture();
	}

	@Override
	public void resetGesture() {
		((LeapMotion)modules.getParser("LeapMotion")).setGesture("");
	}

	@Override
	public String getDetectedString() {
		return ((LeapMotion)modules.getParser("LeapMotion")).getGesturedString();
	}

	@Override
	public void resetDetectedString() {
		((LeapMotion)modules.getParser("LeapMotion")).setGesturedString("");
	}
}
