package callbacks;

import communication.Communication;
import main.Start;
import modules.Modules;
import modules.parser.Kinect2;

public class OpCallbackImplKinect2 implements
	org.yakindu.scr.braganca.IBragancaStatemachine.SCIKinect2OperationCallback,
	org.yakindu.scr.speechandpersonrecognition.ISpeechAndPersonRecognitionStatemachine.SCIKinect2OperationCallback,
	org.yakindu.scr.helpmecarry.IHelpMeCarryStatemachine.SCIKinect2OperationCallback
{
	
	private Modules modules = Start.instanceOf().getModules();
	
	public void sendNoiseDetectionOnOff(boolean inOnOff){
		Communication.sendMessage("#NOISEDETECTION#" + (inOnOff?"1":"0") + "#", modules.get("NoiseDetection"));
	}

	@Override
	public String getGesture() {
		return ((Kinect2)modules.getParser("Kinect2")).getGesture();
	}

	@Override
	public long getNoiseAngle() {
		return ((Kinect2)modules.getParser("Kinect2")).getNoiseAngle();
	}
}
