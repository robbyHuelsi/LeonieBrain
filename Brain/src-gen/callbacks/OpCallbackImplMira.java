package callbacks;

import communication.Communication;
import main.Log;
import main.Start;
import modules.Modules;
import modules.parser.Mira;

public class OpCallbackImplMira implements IOpCallbackImpl,
	org.yakindu.scr.braganca.IBragancaStatemachine.SCIMiraOperationCallback,
	org.yakindu.scr.storinggroceries.IStoringGroceriesStatemachine.SCIMiraOperationCallback,
	org.yakindu.scr.speechandpersonrecognition.ISpeechAndPersonRecognitionStatemachine.SCIMiraOperationCallback,
	org.yakindu.scr.helpmecarry.IHelpMeCarryStatemachine.SCIMiraOperationCallback,
	org.yakindu.scr.generalpurposeservicerobot.IGeneralPurposeServiceRobotStatemachine.SCIMiraOperationCallback,
	org.yakindu.scr.test_mira.ITest_MiraStatemachine.SCIMiraOperationCallback,
	org.yakindu.scr.test_noise.ITest_NoiseStatemachine.SCIMiraOperationCallback,
	org.yakindu.scr.test_blindmansbluff.ITest_BlindMansBluffStatemachine.SCIMiraOperationCallback,
	org.yakindu.scr.robotinspection.IRobotInspectionStatemachine.SCIMiraOperationCallback,
	org.yakindu.scr.openchallenge.IOpenChallengeStatemachine.SCIMiraOperationCallback,
	org.yakindu.scr.eegpsr.IEEGPSRStatemachine.SCIMiraOperationCallback,
	org.yakindu.scr.test_leapmotion.ITest_LeapMotionStatemachine.SCIMiraOperationCallback,
	org.yakindu.scr.finale.IFinaleStatemachine.SCIMiraOperationCallback,
	org.yakindu.scr.restaurant.IRestaurantStatemachine.SCIMiraOperationCallback
{
	private Log log = Start.instanceOf().getLog();
	private Modules modules = Start.instanceOf().getModules();
	
	public void sendGoToGWP(long inWayPoint){
		log.log("Go to global way point " + inWayPoint);
		Communication.sendMessage("#MIRA#GWP#" + inWayPoint + "#", modules.get("Mira"), log);
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

	
	public void sendBodyUTurn(){  //#MIRA#ROTBODY#360#
		
		/*Communication.sendMessage("#MIRA#ROTBODY#90#", modules.get("Mira"));
		try {
			Thread.sleep(820);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Communication.sendMessage("#MIRA#ROTBODY#90#", modules.get("Mira"));*/
		
		//sendTurnBody(180);
		sendTurnBody(200); // FÜR TEPPICHBODEN
	}

	
	public void sendSearchOnOff(boolean inOnOff){
		log.log(inOnOff?"Moving from WP to WP":"Standing");
		Communication.sendMessage("#MIRA#RUN#" + (inOnOff?"1":"0") + "#", modules.get("Mira"), log);
//		this.sendToHBrain_TTS("[idle2:" + (inOnOff?"true":"false") + "]");
	}

	public void sendTurnBody(long inAngle) {
		log.log("Mira: Turn Body: angle=" + inAngle);
		Communication.sendMessage("#MIRA#ROTBODY#" + inAngle + "#", modules.get("Mira"), log);
	}

	public void sendTurnHead(long inAngle) {
		log.log("Mira: Turn Body: angle=" + inAngle);
		Communication.sendMessage("#MIRA#ROTHEAD#" + inAngle + "#", modules.get("Mira"), log);
	}
	
	public void sendPanCamera(long inPan){
		log.log("Mira: Pan Camera:" + inPan);
		Communication.sendMessage("#MIRA#PTU#setPanVelocity#20#", modules.get("Mira"), log);
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Communication.sendMessage("#MIRA#PTU#pan#" + inPan + "#", modules.get("Mira"), log);
	}
	
	public void sendTiltCamera(long inTilt){
		log.log("Mira: Pan Camera:" + inTilt);
		Communication.sendMessage("#MIRA#PTU#setTiltVelocity#20#", modules.get("Mira"), log);
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Communication.sendMessage("#MIRA#PTU#tilt#" + inTilt + "#", modules.get("Mira"), log);
	}
	
	public void sendPanTiltCamera(long inPan, long inTilt) {
		log.log("Mira: Pan Camera:" + inPan);
		sendPanCamera(inPan);
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		sendTiltCamera(inTilt);
		
	}

	public void sendGoToLC(long inX, long inY) {
		log.log("Mira: Go to local coordinates: x=" + inX + ", y=" + inY);
		Communication.sendMessage("#MIRA#LC#" + inX + ";" + inY + ";#", modules.get("Mira"), log);
	}

	public void sendSaveRuntimeStartPoint() {
		log.log("Mira: sendSaveRuntimeStartPoint");
		Communication.sendMessage("#MIRA#ADDRUNTIMESTARTPOINT#", modules.get("Mira"), log);
	}

	public void sendSaveRuntimeEndPoint() {
		log.log("Mira: sendSaveRuntimeEndPoint");
		Communication.sendMessage("#MIRA#ADDRUNTIMEENDPOINT#", modules.get("Mira"), log);
	}

	public void sendGoToRuntimeEndPoint() {
		log.log("Mira: sendGoToRuntimeEndPoint");
		Communication.sendMessage("#MIRA#GOTORUNTIMEENDPOINT#", modules.get("Mira"), log);
	}

	@Override
	public void sendInit() {
		//sendPanTiltCamera(0, 0);
	}

	@Override
	public void sendInterrupt() {
		log.log("Mira: sendInterrupt()");
		Communication.sendMessage("#MIRA#INTERRUPT#", modules.get("Mira"), log);
	}

}
