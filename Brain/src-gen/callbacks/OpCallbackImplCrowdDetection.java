package callbacks;

import communication.Communication;
import main.Log;
import main.Start;
import modules.Modules;
import modules.parser.CrowdDet;
import modules.parser.STT;

public class OpCallbackImplCrowdDetection implements IOpCallbackImpl,
	org.yakindu.scr.speechandpersonrecognition.ISpeechAndPersonRecognitionStatemachine.SCICrowdDetectionOperationCallback,
	org.yakindu.scr.generalpurposeservicerobot.IGeneralPurposeServiceRobotStatemachine.SCICrowdDetectionOperationCallback,
	org.yakindu.scr.test_blindmansbluff.ITest_BlindMansBluffStatemachine.SCICrowdDetectionOperationCallback,
	org.yakindu.scr.eegpsr.IEEGPSRStatemachine.SCICrowdDetectionOperationCallback,
	org.yakindu.scr.finale.IFinaleStatemachine.SCICrowdDetectionOperationCallback,
	org.yakindu.scr.restaurant.IRestaurantStatemachine.SCICrowdDetectionOperationCallback
{
	private Log log = Start.instanceOf().getLog();
	private Modules modules = Start.instanceOf().getModules();
	
	public void sendDetectionOn() {
		Communication.sendMessage("#CROWDDET#ON#", modules.get("CrowdDet"), log);
		
	}

	public void sendDetectionOff() {
		Communication.sendMessage("#CROWDDET#OFF#", modules.get("CrowdDet"), log);
		
	}

	public long getTotalCount() {
		return ((CrowdDet) Start.getModules().getParser("CrowdDet")).getTotalCount();
	}

	public long getSpecificCount(long gender, long minAge, long maxAge, long position) {
		return ((CrowdDet) Start.getModules().getParser("CrowdDet")).getSpecificCount(gender, minAge, maxAge, position);
	}

	public boolean areAllGendersDetected() {
		return ((CrowdDet) Start.getModules().getParser("CrowdDet")).areAllGendersDetected();
	}

	public boolean areAllAgesDetected() {
		return ((CrowdDet) Start.getModules().getParser("CrowdDet")).areAllAgesDetected();
	}

	public String getSummaryText() {
		return ((CrowdDet) Start.getModules().getParser("CrowdDet")).getSummaryString();
	}

	@Override
	public void sendInit() {
		sendDetectionOff();
	}
	
	public void sendPing() {
		Communication.sendMessage("#CROWDDET#REQUEST#READY#", modules.get("CrowdDet"), log);
	}

	@Override
	public String getAnswerForSecificCrowdDetails(String inDetails) {
		return ((CrowdDet) Start.getModules().getParser("CrowdDet")).getAnswerForSecificCrowdDetails(inDetails);
	}	
	
}
