package callbacks;

import communication.Communication;
import main.Start;
import modules.Modules;
import modules.parser.ObjectDet;

public class OpCallbackImplObjectDetection implements IOpCallbackImpl,
	org.yakindu.scr.storinggroceries.IStoringGroceriesStatemachine.SCIObjectDetectionOperationCallback
{
	private Modules modules = Start.instanceOf().getModules();

	public void sendReadyRequest() {
		Communication.sendMessage("#OBJECTDET#REQUEST#READY#" , modules.get("ObjectDet"));
	}

	public void sendAnalyseCupboard() {
		Communication.sendMessage("#OBJECTDET#REQUEST#CUPBOARD#" , modules.get("ObjectDet"));
		
	}

	public void sendAnalyseTable() {
		Communication.sendMessage("#OBJECTDET#REQUEST#TABLE#" , modules.get("ObjectDet"));
		
	}

	public void sendPrintPDF() {
		Communication.sendMessage("#OBJECTDET#REQUEST#PDF#" , modules.get("ObjectDet"));
		
	}

	public String getSummaryText() {
		return ((ObjectDet)modules.getParser("ObjectDet")).getSummaryText();
	}

	@Override
	public void sendInit() {
		// Nothing to do
	}
		
}
