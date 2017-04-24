package callbacks;

import communication.Communication;
import main.Start;
import modules.Modules;
import modules.parser.Mira;

public class OpCallbackImplMira implements
	org.yakindu.scr.braganca.IBragancaStatemachine.SCIMiraOperationCallback,
	org.yakindu.scr.storinggroceries.IStoringGroceriesStatemachine.SCIMiraOperationCallback,
	org.yakindu.scr.speechandpersonrecognition.ISpeechAndPersonRecognitionStatemachine.SCIMiraOperationCallback,
	org.yakindu.scr.helpmecarry.IHelpMeCarryStatemachine.SCIMiraOperationCallback,
	org.yakindu.scr.generalpurposeservicerobot.IGeneralPurposeServiceRobotStatemachine.SCIMiraOperationCallback
{
	
	private Modules modules = Start.instanceOf().getModules();
	
	public void sendGoToGWP(long inWayPoint){
		System.out.println("Go to global way point " + inWayPoint);
		Communication.sendMessage("#MIRA#GWP#" + inWayPoint + "#", modules.get("Mira"));
	}
	
	public void sendGoToNextGWPForConf() {
		Mira mira = (Mira)Start.instanceOf().getModules().getParser("Mira");
		long eventnum = (long)Start.instanceOf().getStatemachine().getVaribaleOfSCI("BGF", "eventNum");
		
		if(eventnum == 0){
			this.sendGoToGWP(0);
		}else if(eventnum <= 3){
			this.sendGoToGWP(eventnum);
		}else if(eventnum <= 6){
			this.sendGoToGWP(eventnum - 3); //Braganca: Nachdem Leonie WP 1 bis 3 angefahren hat, nochmal zu 1 bis 3, danach gehe zu 0
		}else{
			this.sendGoToGWP(0);
		}
	}
	
	public void sendGoToLC(String inX, String inY){
		System.out.println("Go to local coordinates: x=" + inX + ", y=" + inY);
		Communication.sendMessage("#MIRA#LC#" + inX + ";" + inY + ";#", modules.get("Mira"));
	}
	
	public void sendTurnBody(String inAngle){  //#MIRA#ROTBODY#360#
		System.out.println("Turn Body: angle=" + inAngle);
		Communication.sendMessage("#MIRA#ROTBODY#" + inAngle + "#", modules.get("Mira"));
	}
	
	public void sendBodyUTurn(){  //#MIRA#ROTBODY#360#
		
		Communication.sendMessage("#MIRA#ROTBODY#90#", modules.get("Mira"));
		try {
			Thread.sleep(820);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Communication.sendMessage("#MIRA#ROTBODY#90#", modules.get("Mira"));
	}
	
	public void sendTurnHead(String inAngle){  //#MIRA#ROTBODY#360#
		  System.out.println("Turn Body: angle=" + inAngle);
		  Communication.sendMessage("#MIRA#ROTHEAD#" + inAngle + "#", modules.get("Mira"));
		 }

	
	public void sendSearchOnOff(boolean inOnOff){
		System.out.println(inOnOff?"Moving from WP to WP":"Standing");
		Communication.sendMessage("#MIRA#RUN#" + (inOnOff?"1":"0") + "#", modules.get("Mira"));
//		this.sendToHBrain_TTS("[idle2:" + (inOnOff?"true":"false") + "]");
	}

	public void sendTurnBody(long inAngle) {
		// TODO implement sendTurnBody(long inAngle)
		System.err.println("sendTurnBody() not implemented");
	}

	public void sendTurnHead(long inAngle) {
		// TODO implement sendTurnHead(long inAngle)
		System.err.println("sendTurnHead() not implemented");
	}

	public void sendGoToLC(long inX, long inY) {
		// TODO implement sendGoToLC(long inX, long inY)
		System.err.println("sendGoToLC() not implemented");
	}
	
	//TODO implement sendTurnPTU()

}
