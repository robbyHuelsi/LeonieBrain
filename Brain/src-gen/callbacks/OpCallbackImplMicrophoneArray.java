package callbacks;

import main.Log;
import main.Start;

public class OpCallbackImplMicrophoneArray implements IOpCallbackImpl,
	org.yakindu.scr.speechandpersonrecognition.ISpeechAndPersonRecognitionStatemachine.SCIMicrophoneArrayOperationCallback,
	org.yakindu.scr.generalpurposeservicerobot.IGeneralPurposeServiceRobotStatemachine.SCIMicrophoneArrayOperationCallback,
	org.yakindu.scr.test_blindmansbluff.ITest_BlindMansBluffStatemachine.SCIMicrophoneArrayOperationCallback
{

	private Log log = Start.instanceOf().getLog();
	//TODO impement in events for noiseDetected and noiseEndDetected
	
	public long getNoiseAngle() {
		// TODO implement getNoiseAngle()
		log.error("getNoiseAngle() not implemented");
		return 0;
	}

	public void detectionOnOff(boolean onOff) {
		// TODO implement sendDetectionOnOff(boolean onOff)
		log.error("detectionOnOff(boolean onOff) not implemented");
	}

	@Override
	public void sendInit() {
		// TODO implement sendInit
	}

}
