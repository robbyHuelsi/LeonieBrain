package callbacks;

public class OpCallbackImplMicrophoneArray implements
	org.yakindu.scr.braganca.IBragancaStatemachine.SCIMicrophoneArrayOperationCallback,
	org.yakindu.scr.speechandpersonrecognition.ISpeechAndPersonRecognitionStatemachine.SCIMicrophoneArrayOperationCallback
{

	@Override
	public long getNoiseAngle() {
		// TODO Auto-generated method stub
		System.err.println("getNoiseAngle() not implemented");
		return 0;
	}

	@Override
	public void detectionOnOff(boolean onOff) {
		// TODO Auto-generated method stub
		System.err.println("detectionOnOff(boolean onOff) not implemented");
	}

}
