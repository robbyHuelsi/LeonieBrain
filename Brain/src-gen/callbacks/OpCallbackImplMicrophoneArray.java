package callbacks;

public class OpCallbackImplMicrophoneArray implements IOpCallbackImpl,
	org.yakindu.scr.speechandpersonrecognition.ISpeechAndPersonRecognitionStatemachine.SCIMicrophoneArrayOperationCallback,
	org.yakindu.scr.generalpurposeservicerobot.IGeneralPurposeServiceRobotStatemachine.SCIMicrophoneArrayOperationCallback
{

	//TODO impement in events for noiseDetected and noiseEndDetected
	
	public long getNoiseAngle() {
		// TODO implement getNoiseAngle()
		System.err.println("getNoiseAngle() not implemented");
		return 0;
	}

	public void detectionOnOff(boolean onOff) {
		// TODO implement sendDetectionOnOff(boolean onOff)
		System.err.println("detectionOnOff(boolean onOff) not implemented");
	}

	@Override
	public void sendInit() {
		// TODO implement sendInit
	}

}
