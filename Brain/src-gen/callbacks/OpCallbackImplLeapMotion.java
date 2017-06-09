package callbacks;


import communication.Communication;
import main.Log;
import main.Start;
import modules.Module;
import modules.Modules;
import modules.parser.LeapMotion;
import modules.parser.STT;

public class OpCallbackImplLeapMotion implements IOpCallbackImpl,
	org.yakindu.scr.braganca.IBragancaStatemachine.SCILeapMotionOperationCallback,
	org.yakindu.scr.openchallenge.IOpenChallengeStatemachine.SCILeapMotionOperationCallback,
	org.yakindu.scr.test_leapmotion.ITest_LeapMotionStatemachine.SCILeapMotionOperationCallback,
	org.yakindu.scr.finale.IFinaleStatemachine.SCILeapMotionOperationCallback
{
	private Log log = Start.instanceOf().getLog();
	private Module module = Start.instanceOf().getModules().get("LeapMotion");
	
	public void send(String command){
		if (module.isInternal()) {
			// for internal Modules
		}else{
			Communication.sendMessage(command, module, log);
		}
	}
	
	public void sendInit() {
		sendGestureDetectionOnOff(0);
	}
	
	public void sendPing() {
		send("#LEAPMOTION#REQUEST#READY#");
	}
	
	/* ---------------------------------------------------------------- */
	
	
	public void sendGestureDetectionOnOff(long inOnOff){
		send("#LEAPMOTION#" + (int)inOnOff + "#");
		
		if (inOnOff != 0) {
			LeapMotion lm = (LeapMotion)Start.getModules().getParser("LeapMotion");		
			lm.setGestureDetected(false);
			lm.setStringFinished(false);
			lm.setGesture("");
			lm.setGesturedString("");
		}
		
	}

	public String getGesture() {
		return ((LeapMotion)module.getParser()).getGesture();
	}

	public void resetGesture() {
		((LeapMotion)module.getParser()).setGesture("");
	}

	public String getDetectedString() {
		return ((LeapMotion)module.getParser()).getGesturedString();
	}

	public void resetDetectedString() {
		((LeapMotion)module.getParser()).setGesturedString("");
	}
}
