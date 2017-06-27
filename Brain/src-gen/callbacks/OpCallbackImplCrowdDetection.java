package callbacks;

import communication.Communication;
import main.Log;
import main.Start;
import modules.Module;
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
	private Module module = Start.instanceOf().getModules().get("CrowdDet");
	
	public void send(String command){
		if (module.isInternal()) {
			// for internal Modules
		}else{
			Communication.sendMessage(command, module, log);
		}
	}
	
	public void sendInit() {
		sendDetectionOff();
	}
	
	public void sendPing() {
		send("#CROWDDET#REQUEST#READY#");
	}
	
	/* ---------------------------------------------------------------- */
	
	public void sendDetectionOn() {
		send("#CROWDDET#ON#");
		
	}
	
	@Override
	public void sendWaveDetectionOn() {
		send("#CROWDDET#ON#WAVE#");
		
	}

	

	public void sendDetectionOff() {
		send("#CROWDDET#OFF#");
		
	}

	public long getTotalCount() {
		return ((CrowdDet) Start.getModules().getParser("CrowdDet")).getTotalCount();
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
	
	public long getWavingAngle() {
		return ((CrowdDet) Start.getModules().getParser("CrowdDet")).getWavingAngle();
	}

	
	@Override
	public String getAnswerForSecificCrowdDetails(String inDetails) {
		return ((CrowdDet) Start.getModules().getParser("CrowdDet")).getAnswerForSecificCrowdDetails(inDetails);
	}

	@Override
	public long getSpecificCount(long gender, long minAge, long maxAge, long position, long color, long waving, long angle, double distance) {
		//not necessary to count angle or distance at the moment
		return ((CrowdDet) Start.getModules().getParser("CrowdDet")).getSpecificCount(gender, minAge, maxAge, position, color, waving);
	}


}
