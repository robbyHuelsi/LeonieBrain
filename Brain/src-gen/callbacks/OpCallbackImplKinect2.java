package callbacks;

import communication.Communication;
import main.Log;
import main.Start;
import modules.Module;
import modules.Modules;
import modules.parser.Kinect2;

public class OpCallbackImplKinect2 implements IOpCallbackImpl,
	org.yakindu.scr.braganca.IBragancaStatemachine.SCIKinect2OperationCallback,
	org.yakindu.scr.speechandpersonrecognition.ISpeechAndPersonRecognitionStatemachine.SCIKinect2OperationCallback,
	org.yakindu.scr.helpmecarry.IHelpMeCarryStatemachine.SCIKinect2OperationCallback,
	org.yakindu.scr.generalpurposeservicerobotv1.IGeneralPurposeServiceRobotV1Statemachine.SCIKinect2OperationCallback,
	org.yakindu.scr.generalpurposeservicerobotv2.IGeneralPurposeServiceRobotV2Statemachine.SCIKinect2OperationCallback,
	org.yakindu.scr.test_waving.ITest_WavingStatemachine.SCIKinect2OperationCallback,
	org.yakindu.scr.test_noise.ITest_NoiseStatemachine.SCIKinect2OperationCallback,
	org.yakindu.scr.test_blindmansbluff.ITest_BlindMansBluffStatemachine.SCIKinect2OperationCallback,
	org.yakindu.scr.openchallengemagdeburg.IOpenChallengeMagdeburgStatemachine.SCIKinect2OperationCallback,
	org.yakindu.scr.extendedgeneralpurposeservicerobot.IExtendedGeneralPurposeServiceRobotStatemachine.SCIKinect2OperationCallback,
	org.yakindu.scr.finale.IFinaleStatemachine.SCIKinect2OperationCallback,
	org.yakindu.scr.restaurant.IRestaurantStatemachine.SCIKinect2OperationCallback
{
	private Log log = Start.instanceOf().getLog();
	private Module module = Start.instanceOf().getModules().get("Kinect2");
	
	public void send(String command){
		if (module.isInternal()) {
			// for internal Modules
		}else{
			Communication.sendMessage(command, module, log);
		}
	}
	
	public void sendInit() {
		sendNoiseDetectionOnOff(false);
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		sendWavingDetectionOnOff(false);
	}
	
	public void sendPing() {
		send("#KINECT2#REQUEST#READY#");
	}
	
	/* ---------------------------------------------------------------- */
	
	public void sendNoiseDetectionOnOff(boolean inOnOff){
		send("#KINECT2#NOISE#" + (inOnOff?"1":"0") + "#");
		
		if (!inOnOff) {
			Kinect2 k2 = ((Kinect2)module.getParser());
			k2.setNoiseAngle(-1);
			k2.setNoiseWithBoneDetected(false);
		}
	}
	
	public void sendWavingDetectionOnOff(boolean inOnOff){
		send("#KINECT2#PERSON#" + (inOnOff?"1":"0") + "#");
		
		if (!inOnOff) {
			Kinect2 k2 = ((Kinect2)module.getParser());
			k2.setWavingX(-1);
			k2.setWavingY(-1);
			k2.setWavingDetected(false);
		}
	}

	public long getNoiseAngle() {
		return ((Kinect2)module.getParser()).getNoiseAngle();
	}

	public double getWavingX() {
		return ((Kinect2)module.getParser()).getWavingX();
	}

	public double getWavingY() {
		return ((Kinect2)module.getParser()).getWavingY();
	}

}