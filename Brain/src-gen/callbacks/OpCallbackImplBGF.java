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
		switch (inName.toLowerCase()) {
		case "kitchen":
		case "apple":
			return 0;
			
		case "dinnertable":
		case "diningroom":
			return 1;
			
		case "cabinet":
			return 2;
			
		case "bookshelf":
			return 3;
			
		case "kitchencounter":
			return 4;
			
		case "sofa":
		case "couch":
			return 5;
			
		case "couchtable":
			return 6;
			
		case "sidetable":
			return 7;
			
		case "stove":
			return 8;
			
		case "bed":
		case "bedroom":
			return 9;
			
		case "closet":
			return 10;
			
		case "desk":
			return 11;
			
		case "bar":
			return 12;
			
		case "out":
		case "outside":
		case "frontdoorout":
			return 13;
			
		case "frontdoor":
			return 14;
			
		case "middledoorin":
			return 15;
			
		case "middledoorout":
			return 16;
			
		case "backdoorout":
			return 17;
			
		case "backdoorin":
			return 18;
			
		case "start":
			return 19;
			

		default:
			return -1;
		}
	}
}
