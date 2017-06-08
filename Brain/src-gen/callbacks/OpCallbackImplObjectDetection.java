package callbacks;

import communication.Communication;
import main.Log;
import main.Start;
import modules.Module;
import modules.Modules;
import modules.parser.ObjectDet;

public class OpCallbackImplObjectDetection implements IOpCallbackImpl,
	org.yakindu.scr.storinggroceries.IStoringGroceriesStatemachine.SCIObjectDetectionOperationCallback
{
	private Log log = Start.instanceOf().getLog();
	private Module module = Start.instanceOf().getModules().get("ObjectDet");
	
	public void send(String command){
		if (module.isInternal()) {
			// for internal Modules
		}else{
			Communication.sendMessage(command, module, log);
		}
	}
	
	public void sendPing() {
		send("#OBJECTDET#REQUEST#READY#");
	}
	
	public void sendInit() {
		// Nothing to do
	}
	
	/* ---------------------------------------------------------------- */



	public void sendAnalyseCupboard() {
		send("#OBJECTDET#REQUEST#CUPBOARD#");
		
	}

	public void sendAnalyseTable() {
		send("#OBJECTDET#REQUEST#TABLE#");
		
	}

	public void sendPrintPDF() {
		send("#OBJECTDET#REQUEST#PDF#");
		
	}

	public String getSummaryText() {
		return ((ObjectDet)module.getParser()).getSummaryText();
	}


	public String getNewesObject() {
		return ((ObjectDet)module.getParser()).getNewesObject();
	}
		
}
