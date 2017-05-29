package callbacks;

import communication.Communication;
import main.Log;
import main.Start;
import modules.Modules;
import modules.parser.FollowMe;
import modules.parser.STT;

public class OpCallbackImplFollowMe implements IOpCallbackImpl,
	org.yakindu.scr.helpmecarry.IHelpMeCarryStatemachine.SCIFollowMeOperationCallback,
	org.yakindu.scr.test_followme.ITest_FollowMeStatemachine.SCIFollowMeOperationCallback,
	org.yakindu.scr.generalpurposeservicerobot.IGeneralPurposeServiceRobotStatemachine.SCIFollowMeOperationCallback,
	org.yakindu.scr.eegpsr.IEEGPSRStatemachine.SCIFollowMeOperationCallback,
	org.yakindu.scr.restaurant.IRestaurantStatemachine.SCIFollowMeOperationCallback
{
	private Log log = Start.instanceOf().getLog();
	private Modules modules = Start.instanceOf().getModules();

	public void sendDetectionOff() {
		log.log("FollowMe: sendDetectionOff()");
		Communication.sendMessage("#FOLLOWME#DETECTION#false#", modules.get("FollowMe"), log);
	}

	public void sendDetectionOn() {
		log.log("FollowMe: sendDetectionOn()");
		Communication.sendMessage("#FOLLOWME#DETECTION#true#", modules.get("FollowMe"), log);
	}

	public void sendRequestDetectionDetails() {
		log.log("FollowMe: sendRequestDetectionDetails()");
		Communication.sendMessage("#FOLLOWME#DETAILS#REQUEST#", modules.get("FollowMe"), log);
	}

	public void sendTrackingOff() {
		log.log("FollowMe: sendTrackingOff()");
		Communication.sendMessage("#FOLLOWME#TRACKING#false#", modules.get("FollowMe"), log);
	}

	public void sendTrackingOnAtPos(long x, long y) {
		log.log("FollowMe: sendTrackingOnAtPos(long x, long y)");
		Communication.sendMessage("#FOLLOWME#TRACKING#POSITION#" + x + ";" + y + "#", modules.get("FollowMe"), log);
	}

	public void sendTrackingOnAtNext() {
		log.log("FollowMe: sendTrackingOnAtNext()");
		//Communication.sendMessage("#FOLLOWME#TRACKING#true#", modules.get("FollowMe"));
		
		/*FollowMe fm = (FollowMe)Start.getModules().getParser("FollowMe");
		int x = fm.getNextPersonXPos();
		int y = fm.getNextPersonYPos();
		sendTrackingOnAtPos(x,y);*/
		
		Communication.sendMessage("#FOLLOWME#TRACKING#POSITION#320;240#", modules.get("FollowMe"), log);
	}

	public long getNextPersonXPos() {
		FollowMe fm = (FollowMe)Start.getModules().getParser("FollowMe");
		return fm.getNextPersonXPos();
	}

	public long getNextpersonYPos() {
		FollowMe fm = (FollowMe)Start.getModules().getParser("FollowMe");
		return fm.getNextPersonYPos();
	}

	@Override
	public void sendInit() {
		sendTrackingOff();
		sendDetectionOff();
	}
	
	public void sendPing() {
		Communication.sendMessage("#FOLLOWME#REQUEST#READY#", modules.get("FollowMe"), log);
	}
	
	
	//TODO implement getterfunction for details
}
