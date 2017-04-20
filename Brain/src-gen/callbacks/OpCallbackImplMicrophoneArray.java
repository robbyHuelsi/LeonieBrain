package callbacks;

public class OpCallbackImplMicrophoneArray implements
	org.yakindu.scr.braganca.IBragancaStatemachine.SCIMicrophoneArrayOperationCallback,
	org.yakindu.scr.speechandpersonrecognition.ISpeechAndPersonRecognitionStatemachine.SCIMicrophoneArrayOperationCallback
{

	@Override
	public long getNoiseAngle() {
		// TODO implement getNoiseAngle()
		System.err.println("getNoiseAngle() not implemented");
		return 0;
	}

	@Override
	public void detectionOnOff(boolean onOff) {
		// TODO implement detectionOnOff(boolean onOff)
		System.err.println("detectionOnOff(boolean onOff) not implemented");
	}

}
