package callbacks;

import communication.Communication;
import main.Start;
import modules.Modules;
import modules.parser.Mira;

public class OpCallbackImplMira implements
	org.yakindu.scr.braganca.IBragancaStatemachine.SCIMiraOperationCallback,
	org.yakindu.scr.speechandpersonrecognition.ISpeechAndPersonRecognitionStatemachine.SCIMiraOperationCallback
{
	
	private Modules modules = Start.getModules();
	
	public void sendGoToGWP(long inWayPoint){
		System.out.println("Go to global way point " + inWayPoint);
		Communication.sendMessage("#NAV##GWP#" + inWayPoint + "#", modules.get("Mira"));
	}
	
	public void sendGoToNextGWPForConf() {
		Mira mira = (Mira)Start.instanceOf().getModules().getParser("MIRA");
		
		
		if(mira.getEventNumber() == 0){
			this.sendGoToGWP(0);
		}else if(mira.getEventNumber() <= 3){
			this.sendGoToGWP(mira.getEventNumber());
		}else if(mira.getEventNumber() <= 6){
			this.sendGoToGWP(mira.getEventNumber() - 3); //Braganca: Nachdem Leonie WP 1 bis 3 angefahren hat, nochmal zu 1 bis 3, danach gehe zu 0
		}else{
			this.sendGoToGWP(0);
		}
	}
	
	public void sendGoToLC(String inX, String inY){
		System.out.println("Go to local coordinates: x=" + inX + ", y=" + inY);
		Communication.sendMessage("#NAV##LC#" + inX + ";" + inY + ";#", modules.get("Mira"));
	}
	
	public void sendTurnBody(String inAngle){  //#NAV##ROTBODY#360#
		System.out.println("Turn Body: angle=" + inAngle);
		Communication.sendMessage("#NAV##ROTBODY#" + inAngle + "#", modules.get("Mira"));
	}
	
	public void sendBodyUTurn(){  //#NAV##ROTBODY#360#
		
		Communication.sendMessage("#NAV##ROTBODY#90#", modules.get("Mira"));
		try {
			Thread.sleep(820);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Communication.sendMessage("#NAV##ROTBODY#90#", modules.get("Mira"));
	}
	
	public void sendTurnHead(String inAngle){  //#NAV##ROTBODY#360#
		  System.out.println("Turn Body: angle=" + inAngle);
		  Communication.sendMessage("#NAV##ROTHEAD#" + inAngle + "#", modules.get("Mira"));
		 }

	
	public void sendSearchOnOff(boolean inOnOff){
		System.out.println(inOnOff?"Moving from WP to WP":"Standing");
		Communication.sendMessage("#NAV##RUN#" + (inOnOff?"1":"0") + "#", modules.get("Mira"));
//		this.sendToHBrain_TTS("[idle2:" + (inOnOff?"true":"false") + "]");
	}

	@Override
	public void sendTurnBody(long inAngle) {
		// TODO Auto-generated method stub
		System.err.println("sendTurnBody() not implemented");
	}

	@Override
	public void sendTurnHead(long inAngle) {
		// TODO Auto-generated method stub
		System.err.println("sendTurnHead() not implemented");
	}

	@Override
	public void sendGoToLC(long inX, long inY) {
		// TODO Auto-generated method stub
		System.err.println("sendGoToLC() not implemented");
	}

}
