package callbacks;



import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Random;

import org.yakindu.scr.brain.IBrainStatemachine.SCIAttractivenessOperationCallback;
import org.yakindu.scr.brain.IBrainStatemachine.SCIBGF;
import org.yakindu.scr.brain.IBrainStatemachine.SCIBGFOperationCallback;
import org.yakindu.scr.brain.IBrainStatemachine.SCICurrPersonOperationCallback;
import org.yakindu.scr.brain.IBrainStatemachine.SCIHBrainOperationCallback;
import org.yakindu.scr.brain.IBrainStatemachine.SCIKinect2OperationCallback;
import org.yakindu.scr.brain.IBrainStatemachine.SCILeapMotionOperationCallback;
import org.yakindu.scr.brain.IBrainStatemachine.SCIMira;
import org.yakindu.scr.brain.IBrainStatemachine.SCIMiraOperationCallback;
import org.yakindu.scr.brain.IBrainStatemachine.SCISTTOperationCallback;
import org.yakindu.scr.brain.IBrainStatemachine.SCIVBrainOperationCallback;

import communication.*;
import main.Start;
import modules.Modules;
import vBrain.PersonList;

public class OpCallbackImpl implements SCIBGFOperationCallback, SCIHBrainOperationCallback, SCIVBrainOperationCallback, SCIAttractivenessOperationCallback, SCIKinect2OperationCallback, SCILeapMotionOperationCallback, SCIMiraOperationCallback, SCISTTOperationCallback, SCICurrPersonOperationCallback
{
	private PersonList personList = Start.getPersonList();
	private Modules modules = Start.getModules();
	
	
	// ---- Brain General Functions Interface ---- //
	public void printToConsole(String msg){
		System.out.println(msg);
		System.out.println(personList.toString());
		System.out.println(Start.instanceOf().getBrain().getSCICurrPerson().getKnown());
	}
	
	public void newRandNum(long max){
		Random randGen = new Random();
		Start.instanceOf().getBrain().getSCIBGF().setRandNum(randGen.nextInt((int)max));
		System.out.println("New Random Numer: " + Start.instanceOf().getBrain().getSCIBGF().getRandNum());
	}
	
	

	
	
	
	public void sendACIOnOff(boolean inOnOff){
		System.out.println(inOnOff?"ACI on":"ACI off");
		Communication.sendMessage(inOnOff?"#VBRAIN#1#":"#VBRAIN#0#", modules.get("VBrain"));
		Communication.sendMessage("#TRACRESET#", modules.get("TrackingZoomC"));
		Communication.sendMessage("#TRACRESET#", modules.get("TrackingWaC"));

	}
	
	public void sendTTS(String inText){
		//System.out.println(inText);
		Communication.sendMessage("#HBRAIN##TEXT#" + inText , modules.get("HBrain")); // # removed cause Leonie reads out the hash too
	}
	
	public void sendTTS_num(long inNum){
		//System.out.println(inText);
		Communication.sendMessage("#HBRAIN##TEXT#" + inNum , modules.get("HBrain")); // # removed cause Leonie reads out the hash too
	}
	
	public void sendTTS2(String inT1, String inT2){
		this.sendTTS(inT1 + inT2);
	}
	
	public void sendTTS3(String inT1, String inT2, String inT3){
		this.sendTTS(inT1 + inT2 + inT3);
	}
	
	public void sendTTSWithPos(String inPos, String inText){
		//System.out.println(inText);
		sendTTS("{0;" + inPos + "}" + inText);
	}
	
	public void sendPersonPosition(){
		
	}
	
	public void sendNoiseDetectionOnOff(boolean inOnOff){
		Communication.sendMessage("#NOISEDETECTION#" + (inOnOff?"1":"0") + "#", modules.get("NoiseDetection"));
	}
	
	public void sendGestureDetectionOnOff(long inOnOff){
		Communication.sendMessage("#HANDGESTURES#" + (int)inOnOff + "#", modules.get("HandGestures"));
	}
	
	public void sendSpeechDetectionOnOff(long inOnOff){
		Communication.sendMessage("#STT#" + (inOnOff==0?"0":(inOnOff==1?"1":(inOnOff==2?"yesno":"name"))) + "#", modules.get("STT"));
		if(inOnOff != 0){
			Start.instanceOf().getBrain().getSCISTT().setSTTReady(false);
			Start.instanceOf().getBrain().getSCISTT().setSpeakerMsg("");
			Start.instanceOf().getBrain().getSCISTT().setFilteredMsg("");
		}
	}
	
	
	public void sendGoToGWP(long inWayPoint){
		System.out.println("Go to global way point " + inWayPoint);
		Communication.sendMessage("#NAV##GWP#" + inWayPoint + "#", modules.get("Mira"));
	}
	
	public void sendGoToNextGWPForConf() {
		SCIBGF BGF = Start.instanceOf().getBrain().getSCIBGF();
		
		
		if(BGF.getEventNum() == 0){
			this.sendGoToGWP(0);
		}else if(BGF.getEventNum() <= 3){
			this.sendGoToGWP(BGF.getEventNum());
		}else if(BGF.getEventNum() <= 6){
			this.sendGoToGWP(BGF.getEventNum() - 3);
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



	
	public void setKnown(boolean inKnown) {
		if(personList.getCurrPerson() != null){
			personList.getCurrPerson().setKnown(inKnown, Start.instanceOf().getBrain());
		}
	}

	
	public void setFirstname(String inFirstname) {
		if(personList.getCurrPerson() != null){
			personList.getCurrPerson().setFirstName(inFirstname, Start.instanceOf().getBrain());
		}	
	}

	
	public void setLastname(String inLastname) {
		if(personList.getCurrPerson() != null){
			personList.getCurrPerson().setLastName(inLastname, Start.instanceOf().getBrain());
		}		
	}

	
	public void setBdYear(long inBdYear) {
		if(personList.getCurrPerson() != null){
			personList.getCurrPerson().setBdYear((int)inBdYear, Start.instanceOf().getBrain());
		}			
	}

	
	public void setBdMounth(long inBdMointh) {
		if(personList.getCurrPerson() != null){
			personList.getCurrPerson().setBdMonth((int)inBdMointh, Start.instanceOf().getBrain());
		}	
	}

	
	public void setBdDay(long inBdDay) {
		if(personList.getCurrPerson() != null){
			personList.getCurrPerson().setBdDay((int)inBdDay, Start.instanceOf().getBrain());
		}			
	}

	
	public void setGender(boolean inGender) {
		if(personList.getCurrPerson() != null){
			personList.getCurrPerson().setGender(inGender, Start.instanceOf().getBrain());
		}	
	}

	
	public void setEthnicity(long inEthnicity) {
		if(personList.getCurrPerson() != null){
			personList.getCurrPerson().setEthnicity((int)inEthnicity, Start.instanceOf().getBrain());
		}			
	}
	
	public void setAttractiveness(double inAttr) {
		if(personList.getCurrPerson() != null){
			personList.getCurrPerson().setAttractiveness((int)inAttr, Start.instanceOf().getBrain());
		}	
	}


	public void savePersonList() {
		personList.save();
	}

	public void resetCurrPerson() {
		personList.setCurrPerson(null);
	}


	@Override
	public void setOldAttr() {
		// TODO Auto-generated method stub
	}

	 public void sendToAttr_estimate() {
		 Communication.sendMessage("/home/leonie/ACI/org.png", modules.get("Attractiveness"));
	 }

}
