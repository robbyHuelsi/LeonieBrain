package callbacks;

import communication.Communication;
import main.Log;
import main.Start;
import modules.Module;
import modules.Modules;
import modules.parser.FollowMe;
import modules.parser.STT;

public class OpCallbackImplFollowMe implements IOpCallbackImpl,
	org.yakindu.scr.helpmecarry.IHelpMeCarryStatemachine.SCIFollowMeOperationCallback,
	org.yakindu.scr.test_followme.ITest_FollowMeStatemachine.SCIFollowMeOperationCallback,
	org.yakindu.scr.generalpurposeservicerobotv1.IGeneralPurposeServiceRobotV1Statemachine.SCIFollowMeOperationCallback,
	org.yakindu.scr.generalpurposeservicerobotv2.IGeneralPurposeServiceRobotV2Statemachine.SCIFollowMeOperationCallback,
	org.yakindu.scr.extendedgeneralpurposeservicerobot.IExtendedGeneralPurposeServiceRobotStatemachine.SCIFollowMeOperationCallback,
	org.yakindu.scr.restaurant.IRestaurantStatemachine.SCIFollowMeOperationCallback,
	org.yakindu.scr.openchallengenagoya.IOpenChallengeNagoyaStatemachine.SCIFollowMeOperationCallback
{
	private Log log = Start.instanceOf().getLog();
	private Module module = Start.instanceOf().getModules().get("FollowMe");
	
	public void send(String command){
		if (module.isInternal()) {
			// for internal Modules
		}else{
			Communication.sendMessage(command, module, log);
		}
	}
	
	public void sendInit() {
		sendTrackingOff();
		sendDetectionOff();
	}
	
	public void sendPing() {
		send("#FOLLOWME#REQUEST#READY#");
	}
	
	/* ---------------------------------------------------------------- */
	
	

	public void sendDetectionOff() {
		log.log("FollowMe: sendDetectionOff()");
		send("#FOLLOWME#DETECTION#false#");
	}

	public void sendDetectionOn() {
		log.log("FollowMe: sendDetectionOn()");
		send("#FOLLOWME#DETECTION#true#");
	}

	public void sendRequestDetectionDetails() {
		log.log("FollowMe: sendRequestDetectionDetails()");
		send("#FOLLOWME#DETAILS#REQUEST#");
	}

	public void sendTrackingOff() {
		log.log("FollowMe: sendTrackingOff()");
		send("#FOLLOWME#TRACKING#false#");
	}

	public void sendTrackingOnAtPos(long x, long y) {
		log.log("FollowMe: sendTrackingOnAtPos(long x, long y)");
		send("#FOLLOWME#TRACKING#POSITION#" + x + ";" + y + "#");
	}

	public void sendTrackingOnAtNext() {
		log.log("FollowMe: sendTrackingOnAtNext()");
		//Communication.sendMessage("#FOLLOWME#TRACKING#true#", modules.get("FollowMe"));
		
		/*FollowMe fm = (FollowMe)Start.getModules().getParser("FollowMe");
		int x = fm.getNextPersonXPos();
		int y = fm.getNextPersonYPos();
		sendTrackingOnAtPos(x,y);*/
		
		send("#FOLLOWME#TRACKING#POSITION#320;240#");
	}

	public long getNextPersonXPos() {
		FollowMe fm = (FollowMe)Start.getModules().getParser("FollowMe");
		return fm.getNextPersonXPos();
	}

	public long getNextpersonYPos() {
		FollowMe fm = (FollowMe)Start.getModules().getParser("FollowMe");
		return fm.getNextPersonYPos();
	}
	
	
	//TODO implement getterfunction for details
}
