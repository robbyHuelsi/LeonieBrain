package callbacks;

import communication.Communication;
import main.Log;
import main.Start;
import modules.Module;
import modules.Modules;
import modules.parser.Attractiveness;
import modules.parser.STT;

public class OpCallbackImplAttractiveness implements IOpCallbackImpl,
	org.yakindu.scr.braganca.IBragancaStatemachine.SCIAttractivenessOperationCallback,
	//org.yakindu.scr.openchallenge.IOpenChallengeStatemachine.SCIAttractivenessOperationCallback,
	org.yakindu.scr.finale.IFinaleStatemachine.SCIAttractivenessOperationCallback
{
	private Log log = Start.instanceOf().getLog();
	private Module module = Start.instanceOf().getModules().get("Attractiveness");

	
	public void send(String command){
		if (module.isInternal()) {
			// for internal Modules
		}else{
			Communication.sendMessage(command, module, log);
		}
	}
	
	public void sendInit() {
		// nothing to do
	}

	public void sendPing() {
		send("#ATTRACTIVENESS#REQUEST#READY#");
	}
	
	/* ---------------------------------------------------------------- */
	
	 public void sendToAttr_estimate() {
		 send("#ATTRACTIVENESS#START#");
	 }

	public double getAttractiveness() {
		return ((Attractiveness)module.getParser()).getAttrativeness();
	}
	
	
	
	

}
