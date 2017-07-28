package callbacks;

import java.util.Random;

import Persons.PersonList;
import communication.Communication;
import main.Log;
import main.Start;
import modules.Modules;

public class OpCallbackImplBGF implements IOpCallbackImpl,
	org.yakindu.scr.braganca.IBragancaStatemachine.SCIBGFOperationCallback,
	org.yakindu.scr.speechandpersonrecognition.ISpeechAndPersonRecognitionStatemachine.SCIBGFOperationCallback,
	org.yakindu.scr.helpmecarry.IHelpMeCarryStatemachine.SCIBGFOperationCallback,
	org.yakindu.scr.generalpurposeservicerobotv1.IGeneralPurposeServiceRobotV1Statemachine.SCIBGFOperationCallback,
	org.yakindu.scr.generalpurposeservicerobotv2.IGeneralPurposeServiceRobotV2Statemachine.SCIBGFOperationCallback,
	org.yakindu.scr.test_blindmansbluff.ITest_BlindMansBluffStatemachine.SCIBGFOperationCallback,
	org.yakindu.scr.openchallenge.IOpenChallengeStatemachine.SCIBGFOperationCallback,
	org.yakindu.scr.extendedgeneralpurposeservicerobot.IExtendedGeneralPurposeServiceRobotStatemachine.SCIBGFOperationCallback,
	org.yakindu.scr.finale.IFinaleStatemachine.SCIBGFOperationCallback,
	org.yakindu.scr.restaurant.IRestaurantStatemachine.SCIBGFOperationCallback
{
	private Log log = Start.instanceOf().getLog();
	private PersonList personList = Start.instanceOf().getPersonList();
	//private Modules modules = Start.instanceOf().getModules();
	
	
	// ---- Brain General Functions Interface ---- //
	
	public void send(String command){
		/*if (module.isInternal()) {
			// for internal Modules
		}else{
			Communication.sendMessage(command, module, log);
		}*/
	}
	
	public void sendInit() {
		// Nothing to do
	}
	
	public void sendPing() {
		// Nothing to do
	}
	
	/* ---------------------------------------------------------------- */
	
	public void printToConsole(String msg){
		log.log(msg);
		log.log(personList.toString());
		log.log(Start.instanceOf().getPersonList().getCurrPerson().isKnown());
	}
	
	public long getRandNum(long max) {
		Random randGen = new Random();
		long randNum = randGen.nextInt((int)max);
		log.log("New random number: " + randNum);
		return randNum;
	}

	

	public String intToString(long inInt) {
		return "" + inInt;
	}

	/*NEW OBJECTS
	 * Shampoo
	 * Green Tea
	 * Tea
	 * Chewing Gum
	 * Gum
	 * Chopstick(s)
	 * Soup Container
	 * Aquarius
	 * Fries
	 * Candy
	 * Asience
	 * Fork
	 * Hair Spray
	 * Spray
	 * Radish
	 * Cold Brew
	 * Brew
	 * Onion
	 * Corn
	 * Jelly
	 * Bread
	 * Cup Star
	 * Orange
	 * Moisturizer
	 */
	public long getGWPByName(String inName) {
		
		try {
			if (inName == null || inName.equals("")) {
				return -1;
			}
			
			switch (inName.toLowerCase()) {
				
			case "leftplanks":		//NO WAYPOINT!!!!!!!
			case "left planks":
				return 0; //16
				
			case "kitchentable":
			case "kitchen table":
				return 1; //5
				
			case "kitchenshelf":
			case "kitchen shelf":			
				return 2; //10
				
			case "kitchenrack": 	//NO WAYPOINT!!!!	
			case "kitchen rack":
				return 2; //21
				
			case "rightrack": 		//NO WAYPOINT!!!!	
			case "right rack":
				return 2; //3
	
			case "balconyshelf":
			case "balcony shelf":
				return 3; //18
				
			case "fridge": 			//NO WAYPOINT!!!! 
				return 4; //20
				
			case "coffee table": 	//NO WAYPOINT!!!!
				return 5; //13
				
			case "sideboard": 		//NO WAYPOINT!!!!		
				return 5; //4
				
			case "tv":				//NO WAYPOINT!!!!
				return 5; //14
				
			case "sofa":
				return 6; //12
				
			case "entranceshelf":	
			case "entrance shelf":
				return 7; //9
				
			case "kitchencounter":
			case "kitchen counter":
				return 8; //19
				
			case "bed":
				return 9; //8
				
			case "teepee":			//NO WAYPOINT!!!!
				return 9; //7
		
			case "desk":				
				return 11; //1
				
			case "rightplanks":		//NO WAYPOINT!!!!	
			case "right planks":
				return 12; //17
				
			case "bistrotable":
			case "bistro table":
			case "balcony":
				return 12; //15
	
			case "littledesk": 		//NO WAYPOINT!!!!	
			case "little desk": 		
				return 15; //6
				
			case "entrance":		//NO WAYPOINT!!!!	
				return 7; //11
				
			case "bedroom":	
				return 19; 
				
			case "corridor":		
				return 24; 
				
			case "kitchen":	
				return 4; 
				
			case "bookcase":		//NO WAYPOINT!!!!	
				return 24; //11
				
			case "livingroom":	
			case "living room":		
				return 27; 
				
			default:
				return -1;
			}
		} catch (Exception e) {
			Start.getLog().error("exeption in getGWPByName(String inName)");
			return -1;
		}
	}
	
	
	
//	public long getGWPByName(String inName) {
//		switch (inName.toLowerCase()) {
//		case "kitchen":
//			return 0;
//			
//		case "dinnertable":
//		case "dinner table":
//		case "table":
//		case "dinner":
//		case "diningroom":
//		case "dining room":
//		case "candle":			//MAYBE
//			return 1;
//			
//		case "cabinet":
//		case "spoon":
//		case "knife":
//			return 2;
//			
//		case "bookshelf":
//		case "water": 				//MAYBE	
//		case "apple": 				//Bei Carsten on the desk
//		case "lemon": 				//Bei Carsten on the desk
//		case "pepper": 				//MAYBE
//		case "chocolate egg": 		//MAYBE
//		case "peas": 				//MAYBE
//		case "milk": 				//MAYBE
//		case "party cracker":		//MAYBE
//		case "cracker":				//MAYBE
//		case "orange juice":		//MAYBE
//		case "cup soup":			//MAYBE	.--------
//		case "soup":				//MAYBE
//		case "pear":				//MAYBE
//		case "sandwich":			//MAYBE
//		case "noodles":				//MAYBE
//		case "corridor":
//			return 3;
//			
//		case "kitchencounter":
//		case "kitchen counter":
//		case "coke":				//MAYBE
//		case "towel":				//MAYBE
//		case "plate":				//MAYBE		---------
//		case "coffee cup":			//MAYBE
//		case "coffee":				//MAYBE
//		case "potato": 				//MAYBE
//		case "cup":					//MAYBE
//		case "bowl":				//MAYBE
//		case "salt":				//MAYBE
//		case "tissue":				//MAYBE
//		case "glass pot":			//MAYBE
//		case "glass":				//MAYBE
//		case "candlestick":			//MAYBE
//		case "candle stick":		//MAYBE
//		case "candleholder":		//MAYBE
//		case "candle holder":		//MAYBE
//		case "picture": 			//MAYBE
//			return 4;
//			
//		case "sofa":
//		case "couch":
//			return 5;
//			
//		case "livingroom":
//		case "living room":
//		case "plant":
//		case "couch table":
//		case "couchtable":
//		case "crisps":				//MAYBE
//		case "chips": 				//MAYBE
//			return 6;
//			
//		case "sidetable":
//		case "side table":
//			return 7;
//			
//		case "stove":
//		case "pot":
//		case "egg":
//		case "cutlery holder":
//		case "pan":
//			return 8;
//			
//		case "bed":
//		case "bedroom":
//		case "pillow":
//			return 9;
//			
//		case "closet": 
//		case "sponge": 
//		case "cleaning tissue": 
//		case "beach lounger": 
//		case "palm": 
//		case "book": 				//MAYBE
//		case "basket": 				//MAYBE
//		case "lamp":	
//		case "kelloggs smacks":		//MAYBE
//		case "kelloggs cornflakes":	//MAYBE
//		case "kelloggs":			//MAYBE
//			return 10;
//			
//		case "desk":
//		case "chair":	
//			return 11;
//			
//		case "bar":
//			return 12;
//			
//		case "out":
//		case "outside":
//		case "exit":
//		case "frontdoorout":
//		case "frontdoor out":
//			return 13;
//			
//		case "frontdoor":
//		case "front door":
//			return 14;
//			
//		case "middledoorin":
//			return 15;
//			
//		case "middledoorout":
//			return 16;
//			
//		case "backdoorout":
//			return 17;
//			
//		case "backdoorin":
//			return 18;
//			
//		case "start":
//			return 19;
//			
//		case "tv":
//		case "television":
//		case "monitor":
//			return 24;
//
//		default:
//			return -1;
//		}
//	}


	public boolean containsString(String main, String check) {
		return main.contains(check);
	}

	@Override
	public String floatToPercent(double i) {
		try {
			return Math.round(i * 100) + " Percent";
		} catch (Exception e) {
			return "";
		}
	}
}
