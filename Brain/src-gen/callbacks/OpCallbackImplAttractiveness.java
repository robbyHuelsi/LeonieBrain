package callbacks;

import communication.Communication;
import main.Start;
import modules.Modules;
import modules.parser.Attractiveness;
import modules.parser.STT;

public class OpCallbackImplAttractiveness implements IOpCallbackImpl,
	org.yakindu.scr.braganca.IBragancaStatemachine.SCIAttractivenessOperationCallback,
	org.yakindu.scr.openchallenge.IOpenChallengeStatemachine.SCIAttractivenessOperationCallback,
	org.yakindu.scr.finale.IFinaleStatemachine.SCIAttractivenessOperationCallback
{

	private Modules modules = Start.instanceOf().getModules();

	 public void sendToAttr_estimate() {
		 Communication.sendMessage("#ATTRACTIVENESS#START#", modules.get("Attractiveness"));
	 }

	public void sendInit() {
		// nothing to do
	}

	@Override
	public double getAttractiveness() {
		return ((Attractiveness)modules.getParser("Attractiveness")).getAttrativeness();
	}
	
	

}
