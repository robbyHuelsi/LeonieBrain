package callbacks;

import communication.Communication;
import main.Start;
import modules.Modules;

public class OpCallbackImplHBrain implements
	org.yakindu.scr.braganca.IBragancaStatemachine.SCIHBrainOperationCallback,
	org.yakindu.scr.speechandpersonrecognition.ISpeechAndPersonRecognitionStatemachine.SCIHBrainOperationCallback
{
	
	private Modules modules = Start.getModules();
	
	public void sendTTS(String inText){
		//System.out.println(inText);
		Communication.sendMessage("#HBRAIN##TEXT#" + inText , modules.get("HBrain")); // # removed cause Leonie reads out the hash too
	}
	
	public void sendTTS_num(long inNum){
		//System.out.println(inText);
		Communication.sendMessage("#HBRAIN##TEXT#" + inNum , modules.get("HBrain")); // # removed cause Leonie reads out the hash too
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
	
}
