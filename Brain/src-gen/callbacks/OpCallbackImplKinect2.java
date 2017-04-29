package callbacks;

import communication.Communication;
import main.Start;
import modules.Modules;
import modules.parser.Kinect2;

public class OpCallbackImplKinect2 implements
	org.yakindu.scr.braganca.IBragancaStatemachine.SCIKinect2OperationCallback,
	org.yakindu.scr.speechandpersonrecognition.ISpeechAndPersonRecognitionStatemachine.SCIKinect2OperationCallback,
	org.yakindu.scr.helpmecarry.IHelpMeCarryStatemachine.SCIKinect2OperationCallback,
	org.yakindu.scr.test_waving.ITest_WavingStatemachine.SCIKinect2OperationCallback
{
	
	private Modules modules = Start.instanceOf().getModules();
	
	public void sendNoiseDetectionOnOff(boolean inOnOff){
		Communication.sendMessage("#KINECT2#NOISE#" + (inOnOff?"1":"0") + "#", modules.get("Kinect2"));
		
		if (!inOnOff) {
			Kinect2 k2 = ((Kinect2)modules.getParser("Kinect2"));
			k2.setNoiseAngle(-1);
			k2.setNoiseDetected(false);
		}
	}
	
	public void sendWavingDetectionOnOff(boolean inOnOff){
		Communication.sendMessage("#KINECT2#WAVE#" + (inOnOff?"1":"0") + "#", modules.get("Kinect2"));
		
		if (!inOnOff) {
			Kinect2 k2 = ((Kinect2)modules.getParser("Kinect2"));
			k2.setWavingX(-1);
			k2.setWavingY(-1);
			k2.setWavingDetected(false);
		}
	}

	public long getNoiseAngle() {
		return ((Kinect2)modules.getParser("Kinect2")).getNoiseAngle();
	}

	public double getWavingX() {
		return ((Kinect2)modules.getParser("Kinect2")).getWavingX();
	}

	public double getWavingY() {
		return ((Kinect2)modules.getParser("Kinect2")).getWavingY();
	}

}