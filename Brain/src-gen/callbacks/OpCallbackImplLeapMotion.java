package callbacks;


import communication.Communication;
import main.Start;
import modules.Modules;
import modules.parser.LeapMotion;

public class OpCallbackImplLeapMotion implements IOpCallbackImpl,
	org.yakindu.scr.braganca.IBragancaStatemachine.SCILeapMotionOperationCallback,
	org.yakindu.scr.openchallenge.IOpenChallengeStatemachine.SCILeapMotionOperationCallback,
	org.yakindu.scr.test_leapmotion.ITest_LeapMotionStatemachine.SCILeapMotionOperationCallback
{
	
	private Modules modules = Start.instanceOf().getModules();
	
	public void sendGestureDetectionOnOff(long inOnOff){
		Communication.sendMessage("#LEAPMOTION#" + (int)inOnOff + "#", modules.get("LeapMotion"));
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

	@Override
	public void sendInit() {
		sendGestureDetectionOnOff(0);
	}
}
