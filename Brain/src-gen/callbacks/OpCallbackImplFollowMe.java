package callbacks;

import communication.Communication;
import main.Start;
import modules.Modules;
import modules.parser.FollowMe;
import modules.parser.STT;

public class OpCallbackImplFollowMe implements IOpCallbackImpl,
	org.yakindu.scr.helpmecarry.IHelpMeCarryStatemachine.SCIFollowMeOperationCallback,
	org.yakindu.scr.test_followme.ITest_FollowMeStatemachine.SCIFollowMeOperationCallback,
	org.yakindu.scr.generalpurposeservicerobot.IGeneralPurposeServiceRobotStatemachine.SCIFollowMeOperationCallback
{
	private Modules modules = Start.instanceOf().getModules();

	public void sendDetectionOff() {
		System.out.println("FollowMe: sendDetectionOff()");
		Communication.sendMessage("#FOLLOWME#DETECTION#false#", modules.get("FollowMe"));
	}

	public void sendDetectionOn() {
		System.out.println("FollowMe: sendDetectionOn()");
		Communication.sendMessage("#FOLLOWME#DETECTION#true#", modules.get("FollowMe"));
	}

	public void sendRequestDetectionDetails() {
		System.out.println("FollowMe: sendRequestDetectionDetails()");
		Communication.sendMessage("#FOLLOWME#DETAILS#REQUEST#", modules.get("FollowMe"));
	}

	public void sendTrackingOff() {
		System.out.println("FollowMe: sendTrackingOff()");
		Communication.sendMessage("#FOLLOWME#TRACKING#false#", modules.get("FollowMe"));
	}

	public void sendTrackingOnAtPos(long x, long y) {
		System.out.println("FollowMe: sendTrackingOnAtPos(long x, long y)");
		Communication.sendMessage("#FOLLOWME#TRACKING#POSITION#" + x + ";" + y + "#", modules.get("FollowMe"));
	}

	public void sendTrackingOnAtNext() {
		System.out.println("FollowMe: sendTrackingOnAtNext()");
		//Communication.sendMessage("#FOLLOWME#TRACKING#true#", modules.get("FollowMe"));
		
		/*FollowMe fm = (FollowMe)Start.getModules().getParser("FollowMe");
		int x = fm.getNextPersonXPos();
		int y = fm.getNextPersonYPos();
		sendTrackingOnAtPos(x,y);*/
		
		Communication.sendMessage("#FOLLOWME#TRACKING#POSITION#320;240#", modules.get("FollowMe"));
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
	
	
	//TODO implement getterfunction for details
}
