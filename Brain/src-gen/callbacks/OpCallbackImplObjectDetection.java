package callbacks;

import communication.Communication;
import main.Log;
import main.Start;
import modules.Modules;
import modules.parser.ObjectDet;

public class OpCallbackImplObjectDetection implements IOpCallbackImpl,
	org.yakindu.scr.storinggroceries.IStoringGroceriesStatemachine.SCIObjectDetectionOperationCallback
{
	private Log log = Start.instanceOf().getLog();
	private Modules modules = Start.instanceOf().getModules();

	public void sendReadyRequest() {
		Communication.sendMessage("#OBJECTDET#REQUEST#READY#" , modules.get("ObjectDet"), log);
	}

	public void sendAnalyseCupboard() {
		Communication.sendMessage("#OBJECTDET#REQUEST#CUPBOARD#" , modules.get("ObjectDet"), log);
		
	}

	public void sendAnalyseTable() {
		Communication.sendMessage("#OBJECTDET#REQUEST#TABLE#" , modules.get("ObjectDet"), log);
		
	}

	public void sendPrintPDF() {
		Communication.sendMessage("#OBJECTDET#REQUEST#PDF#" , modules.get("ObjectDet"), log);
		
	}

	public String getSummaryText() {
		return ((ObjectDet)modules.getParser("ObjectDet")).getSummaryText();
	}

	@Override
	public void sendInit() {
		// Nothing to do
	}

	@Override
	public String getNewesObject() {
		return ((ObjectDet)modules.getParser("ObjectDet")).getNewesObject();
	}
		
}
