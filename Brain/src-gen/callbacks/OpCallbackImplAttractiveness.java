package callbacks;

import communication.Communication;
import main.Start;
import modules.Modules;

public class OpCallbackImplAttractiveness implements IOpCallbackImpl,
	org.yakindu.scr.braganca.IBragancaStatemachine.SCIAttractivenessOperationCallback
{

	private Modules modules = Start.instanceOf().getModules();

	 public void sendToAttr_estimate() {
		 Communication.sendMessage("/home/leonie/ACI/org.png", modules.get("Attractiveness"));
	 }

	public void sendInit() {
		// nothing to do
	}

}
