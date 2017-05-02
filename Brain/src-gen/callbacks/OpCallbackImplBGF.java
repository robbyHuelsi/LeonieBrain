package callbacks;

import java.util.Random;

import Persons.PersonList;
import main.Start;
import modules.Modules;

public class OpCallbackImplBGF implements IOpCallbackImpl,
	org.yakindu.scr.braganca.IBragancaStatemachine.SCIBGFOperationCallback,
	org.yakindu.scr.speechandpersonrecognition.ISpeechAndPersonRecognitionStatemachine.SCIBGFOperationCallback,
	org.yakindu.scr.helpmecarry.IHelpMeCarryStatemachine.SCIBGFOperationCallback,
	org.yakindu.scr.generalpurposeservicerobot.IGeneralPurposeServiceRobotStatemachine.SCIBGFOperationCallback,
	org.yakindu.scr.test_blindmansbluff.ITest_BlindMansBluffStatemachine.SCIBGFOperationCallback
{
	
	private PersonList personList = Start.instanceOf().getPersonList();
	private Modules modules = Start.instanceOf().getModules();
	
	
	// ---- Brain General Functions Interface ---- //
	public void printToConsole(String msg){
		System.out.println(msg);
		System.out.println(personList.toString());
		System.out.println(Start.instanceOf().getPersonList().getCurrPerson().isKnown());
	}
	
	public long getRandNum(long max) {
		Random randGen = new Random();
		long randNum = randGen.nextInt((int)max);
		System.out.println("New random number: " + randNum);
		return randNum;
	}

	public void sendInit() {
		// Nothing to do
	}

	public String intToString(long inInt) {
		return "" + inInt;
	}

	public long getGWPByName(String inName) {
		switch (inName) {
		case "kitchen":
			return 0;
			
		case "frontdoor":
			return 1;
			
		case "living room":
			return 2;

		default:
			return -1;
		}
	}
}
