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
			return 0;
			
		case "dinnertable":
		case "dinner table":
		case "diningroom":
		case "dining room":
		case "candle":			//MAYBE
			return 1;
			
		case "cabinet":
		case "spoon":
		case "knife":
			return 2;
			
		case "bookshelf":
		case "water": 				//MAYBE	
		case "apple": 				//Bei Carsten on the desk
		case "lemon": 				//Bei Carsten on the desk
		case "pepper": 				//MAYBE
		case "chocolate egg": 		//MAYBE
		case "peas": 				//MAYBE
		case "milk": 				//MAYBE
		case "party cracker":		//MAYBE
		case "cracker":				//MAYBE
		case "orange juice":		//MAYBE
		case "cup soup":			//MAYBE
		case "soup":				//MAYBE
		case "pear":				//MAYBE
		case "sandwich":			//MAYBE
		case "noodles":				//MAYBE
		case "corridor":
			return 3;
			
		case "kitchencounter": 
		case "coke":				//MAYBE
		case "towel":				//MAYBE
		case "plate":				//MAYBE
		case "coffee cup":			//MAYBE
		case "coffee":				//MAYBE
		case "potato": 				//MAYBE
		case "cup":					//MAYBE
		case "bowl":				//MAYBE
		case "salt":				//MAYBE
		case "tissue":				//MAYBE
		case "glass pot":			//MAYBE
		case "glass":				//MAYBE
		case "candlestick":			//MAYBE
		case "candle holder":		//MAYBE
		case "picture": 			//MAYBE
			return 4;
			
		case "sofa":
		case "couch":
			return 5;
			
		case "livingroom":
		case "plant":
		case "couchtable":
		case "crisps":				//MAYBE
		case "chips": 				//MAYBE
			return 6;
			
		case "sidetable":
			return 7;
			
		case "stove":
		case "pot":
		case "egg":
		case "cutlery holder":
		case "pan":
			return 8;
			
		case "bed":
		case "bedroom":
		case "pillow":
			return 9;
			
		case "closet": 
		case "sponge": 
		case "cleaning tissue": 
		case "beach lounger": 
		case "palm": 
		case "book": 				//MAYBE
		case "basket": 				//MAYBE
		case "lamp":	
		case "kelloggs smacks":		//MAYBE
		case "kelloggs cornflakes":	//MAYBE
		case "kelloggs":			//MAYBE
			return 10;
			
		case "desk":
		case "chair":	
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


	public boolean containsString(String main, String check) {
		return main.contains(check);
	}
}
