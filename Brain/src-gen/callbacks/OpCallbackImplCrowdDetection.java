package callbacks;

public class OpCallbackImplCrowdDetection implements
	org.yakindu.scr.braganca.IBragancaStatemachine.SCICrowdDetectionOperationCallback,
	org.yakindu.scr.speechandpersonrecognition.ISpeechAndPersonRecognitionStatemachine.SCICrowdDetectionOperationCallback,
	org.yakindu.scr.generalpurposeservicerobot.IGeneralPurposeServiceRobotStatemachine.SCICrowdDetectionOperationCallback
{

	//TODO implement in event crowdDetected
	
	public void detectionOnOff(boolean onOff) {
		// TODO implement sendDetectionOnOff(boolean onOff)
		System.err.println("detectionOnOff(boolean onOff) not implemented");
		
	}
	
	//TODO implement getter functions for all information

}
