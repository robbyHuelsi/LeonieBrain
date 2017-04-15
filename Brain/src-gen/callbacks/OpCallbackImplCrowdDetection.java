package callbacks;

public class OpCallbackImplCrowdDetection implements
	org.yakindu.scr.braganca.IBragancaStatemachine.SCICrowdDetectionOperationCallback,
	org.yakindu.scr.speechandpersonrecognition.ISpeechAndPersonRecognitionStatemachine.SCICrowdDetectionOperationCallback
{

	@Override
	public void detectionOnOff(boolean onOff) {
		// TODO implement detectionOnOff(boolean onOff)
		System.err.println("detectionOnOff(boolean onOff) not implemented");
		
	}

}
