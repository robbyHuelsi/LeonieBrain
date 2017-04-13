package callbacks;

import java.util.Random;
import main.Start;
import modules.Modules;
import vBrain.PersonList;

public class OpCallbackImplBGF implements
	org.yakindu.scr.braganca.IBragancaStatemachine.SCIBGFOperationCallback,
	org.yakindu.scr.speechandpersonrecognition.ISpeechAndPersonRecognitionStatemachine.SCIBGFOperationCallback
{
	
	private PersonList personList = Start.getPersonList();
	private Modules modules = Start.getModules();
	
	
	// ---- Brain General Functions Interface ---- //
	public void printToConsole(String msg){
		System.out.println(msg);
		System.out.println(personList.toString());
		System.out.println(Start.instanceOf().getPersonList().getCurrPerson().isKnown());
	}
	
	public void newRandNum(long max){
		Random randGen = new Random();
		//TODO: Start.instanceOf().getBrain().getSCIBGF().setRandNum(randGen.nextInt((int)max));
		//TODO: System.out.println("New Random Numer: " + Start.instanceOf().getBrain().getSCIBGF().getRandNum());
	}
}
