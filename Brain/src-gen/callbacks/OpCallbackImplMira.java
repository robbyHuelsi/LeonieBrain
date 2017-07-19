package callbacks;

import communication.Communication;
import main.Log;
import main.Start;
import modules.Module;
import modules.Modules;
import modules.parser.CrowdDet;
import modules.parser.Mira;
import modules.parser.STT;

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
	org.yakindu.scr.test_leapmotionleftright.ITest_LeapMotionLeftRightStatemachine.SCIMiraOperationCallback,
	org.yakindu.scr.finale.IFinaleStatemachine.SCIMiraOperationCallback,
	org.yakindu.scr.restaurant.IRestaurantStatemachine.SCIMiraOperationCallback
{
	private Log log = Start.instanceOf().getLog();
	private Module module = Start.instanceOf().getModules().get("Mira");
	
	public void send(String command){
		if (module.isInternal()) {
			// for internal Modules
		}else{
			Communication.sendMessage(command, module, log);
		}
	}
	
	public void sendInit() {
		//sendPanTiltCamera(0, 0);
	}
	
	public void sendPing() {
		send("#MIRA#REQUEST#READY#");
	}
	
	/* ---------------------------------------------------------------- */
	
	public void sendGoToGWP(long inWayPoint){
		log.log("Go to global way point " + inWayPoint);
		send("#MIRA#GWP#" + inWayPoint + "#");
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
		send("#MIRA#RUN#" + (inOnOff?"1":"0") + "#");
//		this.sendToHBrain_TTS("[idle2:" + (inOnOff?"true":"false") + "]");
	}

	public void sendTurnBody(long inAngle) {
		log.log("Mira: Turn Body: angle=" + inAngle);
		send("#MIRA#ROTBODY#" + inAngle + "#");
	}

	public void sendTurnHead(long inAngle) {
		log.log("Mira: Turn Body: angle=" + inAngle);
		send("#MIRA#ROTHEAD#" + inAngle + "#");
	}
	
	public void sendPanCamera(long inPan){
		log.log("Mira: Pan Camera:" + inPan);
		send("#MIRA#PTU#setPanVelocity#20#");
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		send("#MIRA#PTU#pan#" + inPan + "#");
	}
	
	public void sendTiltCamera(long inTilt){
		log.log("Mira: Pan Camera:" + inTilt);
		send("#MIRA#PTU#setTiltVelocity#20#");
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		send("#MIRA#PTU#tilt#" + inTilt + "#");
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
		send("#MIRA#LC#" + inX + ";" + inY + ";#");
	}

	public void sendSaveRuntimeStartPoint() {
		log.log("Mira: sendSaveRuntimeStartPoint");
		send("#MIRA#ADDRUNTIMESTARTPOINT#");
	}

	public void sendSaveRuntimeEndPoint() {
		log.log("Mira: sendSaveRuntimeEndPoint");
		send("#MIRA#ADDRUNTIMEENDPOINT#");
	}

	public void sendGoToRuntimeEndPoint() {
		log.log("Mira: sendGoToRuntimeEndPoint");
		send("#MIRA#GOTORUNTIMEENDPOINT#");
	}

	public void sendInterrupt() {
		log.log("Mira: sendInterrupt()");
		send("#MIRA#INTERRUPT#");
	}

	@Override
	public void sendGoToPhi(long angle) {
		log.log("Mira: sendGoToPhi()");
		send("#MIRA#LC#" +  angle + "#");		
	}

}
