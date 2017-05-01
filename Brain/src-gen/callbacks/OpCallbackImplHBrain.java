package callbacks;

import communication.Communication;
import main.Start;
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
	org.yakindu.scr.test_mira.ITest_MiraStatemachine.SCIHBrainOperationCallback
{
	
	private Modules modules = Start.instanceOf().getModules();
	
	public void sendTTS(String inText){
		//System.out.println(inText);
		Communication.sendMessage("#BRAIN##TEXT#" + inText , modules.get("HBrain")); // # removed cause Leonie reads out the hash too
	}
	
	public void sendTTS_num(long inNum){
		//System.out.println(inText);
		Communication.sendMessage("#BRAIN##TEXT#" + inNum , modules.get("HBrain")); // # removed cause Leonie reads out the hash too
	}
	
	public void sendTTS2(String inT1, String inT2){
		this.sendTTS(inT1 + inT2);
	}
	
	public void sendTTS3(String inT1, String inT2, String inT3){
		this.sendTTS(inT1 + inT2 + inT3);
	}
	
	public void sendTTSWithPos(String inPos, String inText){
		//System.out.println(inText);
		sendTTS("{0;" + inPos + "}" + inText);
	}
	
	public void sendPersonPosition(){
		
	}

	@Override
	public void sendInit() {
		sendTTS("[:-|] {person} [blush:false] [idle:false] [idle2:false] [idle3:false]");
	}
	
}
