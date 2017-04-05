package main;

import org.yakindu.scr.ITimer;
import org.yakindu.scr.TimerService;
import org.yakindu.scr.speechandpersonrecognition.SpeechAndPersonRecognitionStatemachine;

import callbacks.OpCallbackImpl;
import callbacks.OpCallbackImpl2;

public class StartSpeechAndPersonRecognition {

	SpeechAndPersonRecognitionStatemachine brain;
	
	// ---- Communication -----------------------------------------------------
	static private int portListen = 8888;
	// ------------------------------------------------------------------------
	
	
	
	private StartSpeechAndPersonRecognition(){
		brain = new SpeechAndPersonRecognitionStatemachine();
		brain.setTimer(new TimerService());
		
//		speechPersonRec.getSCIUdpInterface();
//		speechPersonRec.getSCISTT().getFilterBubble();
		//aktiviert die Tranisitonsbedingung 'in event ready' im UdpInterface in der SM.
		
	}
	
	public static void main(String[] args) {
		
		StartSpeechAndPersonRecognition start = new StartSpeechAndPersonRecognition();

		OpCallbackImpl2 opCallback = new OpCallbackImpl2();
//		start.brain.getSCIBGF().setSCIBGFOperationCallback(opCallback);
		start.brain.getSCIUdpInterface().setSCIUdpInterfaceOperationCallback(opCallback);
		start.brain.getSCIVBrain().setSCIVBrainOperationCallback(opCallback);
//		start.brain.getSCICurrPerson().setSCICurrPersonOperationCallback(opCallback);
//		start.brain.getSCIAtt().setSCIAttOperationCallback(opCallback);

		
		
		start.brain.getSCIUdpInterface().raiseReady();
		
		start.brain.init();
		start.brain.enter();
		
		
		while (true)
		{
//
			start.brain.runCycle();
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
}
