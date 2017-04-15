package callbacks;

import communication.Communication;
import main.Start;
import modules.Modules;

public class OpCallbackImplAttractiveness implements
	org.yakindu.scr.braganca.IBragancaStatemachine.SCIAttractivenessOperationCallback,
	org.yakindu.scr.speechandpersonrecognition.ISpeechAndPersonRecognitionStatemachine.SCIAttractivenessOperationCallback
{

	private Modules modules = Start.getModules();

	 public void sendToAttr_estimate() {
		 Communication.sendMessage("/home/leonie/ACI/org.png", modules.get("Attractiveness"));
	 }

}
