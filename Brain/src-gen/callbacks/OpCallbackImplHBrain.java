package callbacks;

import communication.Communication;
import main.Log;
import main.Start;
import modules.Module;
import modules.Modules;

public class OpCallbackImplHBrain implements IOpCallbackImpl,
	org.yakindu.scr.braganca.IBragancaStatemachine.SCIHBrainOperationCallback,
	org.yakindu.scr.speechandpersonrecognition.ISpeechAndPersonRecognitionStatemachine.SCIHBrainOperationCallback,
	org.yakindu.scr.storinggroceries.IStoringGroceriesStatemachine.SCIHBrainOperationCallback,
	org.yakindu.scr.helpmecarry.IHelpMeCarryStatemachine.SCIHBrainOperationCallback,
	org.yakindu.scr.generalpurposeservicerobot.IGeneralPurposeServiceRobotStatemachine.SCIHBrainOperationCallback,
	org.yakindu.scr.test_stt_smalltalk.ITest_STT_SmalltalkStatemachine.SCIHBrainOperationCallback,
	org.yakindu.scr.test_stt_yesno.ITest_STT_YesNoStatemachine.SCIHBrainOperationCallback,
	org.yakindu.scr.test_stt_names.ITest_STT_NamesStatemachine.SCIHBrainOperationCallback,
	org.yakindu.scr.test_followme.ITest_FollowMeStatemachine.SCIHBrainOperationCallback,
	org.yakindu.scr.test_waving.ITest_WavingStatemachine.SCIHBrainOperationCallback,
	org.yakindu.scr.test_mira.ITest_MiraStatemachine.SCIHBrainOperationCallback,
	org.yakindu.scr.test_blindmansbluff.ITest_BlindMansBluffStatemachine.SCIHBrainOperationCallback,
	org.yakindu.scr.robotinspection.IRobotInspectionStatemachine.SCIHBrainOperationCallback,
	org.yakindu.scr.poster.IPosterStatemachine.SCIHBrainOperationCallback,
	org.yakindu.scr.openchallenge.IOpenChallengeStatemachine.SCIHBrainOperationCallback,
	org.yakindu.scr.eegpsr.IEEGPSRStatemachine.SCIHBrainOperationCallback,
	org.yakindu.scr.test_leapmotionleftright.ITest_LeapMotionLeftRightStatemachine.SCIHBrainOperationCallback,
<<<<<<< HEAD
=======
	org.yakindu.scr.test_leapmotionyesno.ITest_LeapMotionYesNoStatemachine.SCIHBrainOperationCallback,
>>>>>>> 82af10348ed4e6500500d0fa1e45e5060096b256
	org.yakindu.scr.finale.IFinaleStatemachine.SCIHBrainOperationCallback,
	org.yakindu.scr.restaurant.IRestaurantStatemachine.SCIHBrainOperationCallback
{
	private Start start = Start.instanceOf();
	private Log log = start.getLog();
	private Module module = start.getModules().get("HBrain");
	
	public void send(String command){
		if (module.isInternal() && start.getHbrain() != null) {
			start.getHbrain().addInput(command);
		}else{
			Communication.sendMessage(command, module, log);
		}
	}
	
	public void sendInit() {
		sendTTS("[:-|] {person} [blush:false] [idle:false] [idle2:false] [idle3:false]");
	}
	
	public void sendPing() {
		send("#HBRAIN#REQUEST#READY#");
	}
	
	/* ---------------------------------------------------------------- */
	
	public void sendTTS(String inText){
		//log.log(inText);
		send("#BRAIN##TEXT#" + inText); // # removed cause Leonie reads out the hash too
	}
	
	public void sendTTS_num(long inNum){
		//log.log(inText);
		send("#BRAIN##TEXT#" + inNum); // # removed cause Leonie reads out the hash too
	}
	
	public void sendTTS2(String inT1, String inT2){
		this.sendTTS(inT1 + inT2);
	}
	
	public void sendTTS3(String inT1, String inT2, String inT3){
		this.sendTTS(inT1 + inT2 + inT3);
	}
	
	public void sendTTSWithPos(String inPos, String inText){
		//log.log(inText);
		sendTTS("{0;" + inPos + "}" + inText);
	}
	
	public void sendPersonPosition(){
		
	}

	
	
}
