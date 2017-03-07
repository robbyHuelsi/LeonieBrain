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

import org.yakindu.scr.brain.IBrainStatemachine.SCIAttOperationCallback;
import org.yakindu.scr.brain.IBrainStatemachine.SCIBGF;
import org.yakindu.scr.brain.IBrainStatemachine.SCIBGFOperationCallback;
import org.yakindu.scr.brain.IBrainStatemachine.SCICurrPersonOperationCallback;
import org.yakindu.scr.brain.IBrainStatemachine.SCIScitosRemoteControl;
import org.yakindu.scr.brain.IBrainStatemachine.SCIUdpInterfaceOperationCallback;
import org.yakindu.scr.brain.IBrainStatemachine.SCIVBrainOperationCallback;

import communication.*;
import main.Start;
import modules.Module;
import modules.Modules;
import vBrain.PersonList;

public class OpCallbackImpl implements SCIBGFOperationCallback, SCIUdpInterfaceOperationCallback, SCIVBrainOperationCallback, SCICurrPersonOperationCallback, SCIAttOperationCallback
{
	private PersonList personList = Start.getPersonList();
	private Modules modules = Start.getModules();
	private TCPServer serverTCP;
	
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
	
	

	// ---- UDP Interface ----------------------- //

//	public void receive(){
//		/* UDP establish connection & receive */
//		String result = null;
//		UDPConnection  udpConnection = new UDPConnection();
//				
//		try{
//			udpConnection.receiveSocket(InetAddress.getByName(modules.getIp("Brain")), modules.getPort("Brain"), true);
//			result = udpConnection.getMessage();
//			System.out.println(InetAddress.getByName(modules.getIp("Brain"))+"X:" + result);
////			udpConnection.setRunThread(false);
//		} catch (UnknownHostException e){
//			e.printStackTrace();
//		}
//	}
//	
//	//@param module: module is targetmodule 
//	private boolean sendMessage(String text, Module module){
//		if (module == null) {
//			return false;
//		}
//		UDPConnection  udpConnection = new UDPConnection();
//		try
//		{
////			udpConnection.sendSocket(Start.instanceOf().getBrain().getSCIUdpInterface().getMessage(), InetAddress.getByName("134.103.120.108"), 8888);
//			udpConnection.sendSocket(text, InetAddress.getByName(module.getIp()), module.getPort());
//		} catch (UnknownHostException e) {
//			e.printStackTrace();
//			return false;
//		}
////		System.out.println(Test.instanceOf().getTestBrain().getSCIUdpInterface().getData());
//		return true;
//	}
	
	
	
	
	
	
	// ---- TCP Interface ----------------------- //
	
	public void receive(){
		Socket s1=null;
		InetAddress address;
		if(serverTCP==null){
			try {
				System.out.println(InetAddress.getByName(modules.getIp("Brain"))+"X:");
				serverTCP = new TCPServer();
			}catch (Exception e) {
				System.out.println("catch Op receive:");
				e.printStackTrace();
			}
		}else{
			try {
				address=InetAddress.getLocalHost();
				s1=new Socket(address, 8889); 
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	//@param module: module is targetmodule 
	private boolean sendMessage(String text, Module module){
		if(serverTCP==null){
			try {
				serverTCP = new TCPServer();
			}catch (Exception e) {
				System.out.println("Exception in OpCallbackImpl: sendMessage if");
				e.printStackTrace();
			}
			
//		}else{
//			try {
//				client = new ClientTCP(text, module);
//				address=InetAddress.getLocalHost();
//				s1=new Socket(address, 8889);
//				DataOutputStream outToClient = new DataOutputStream(s1.getOutputStream());
//				outToClient.writeBytes(text+"\n");
//			} catch (IOException e) {
//				System.out.println("Exception in OpCallbackImpl: sendMessage else");
//				e.printStackTrace();
//			} 
//			tcpConnection.send(text);
		}
		TCPClient client = new TCPClient(text, module);
		return true;
		
//		
//		if (module == null) {
//			return false;
//		}
//		UDPConnection  udpConnection = new UDPConnection();
//		try
//		{
////			udpConnection.sendSocket(Start.instanceOf().getBrain().getSCIUdpInterface().getMessage(), InetAddress.getByName("134.103.120.108"), 8888);
//			udpConnection.sendSocket(e, module.getPort());
//		} catch (UnknownHostException e) {
//			e.printStackTrace();
//			return false;
//		}
////		System.out.println(Test.instanceOf().getTestBrain().getSCIUdpInterface().getData());
//		return true;
	}
	
	
	public void sendToVBrain_ACIonOff(boolean inOnOff){
		System.out.println(inOnOff?"ACI on":"ACI off");
		this.sendMessage(inOnOff?"#VBRAIN#1#":"#VBRAIN#0#", modules.get("VBrain"));
		this.sendMessage("#TRACRESET#", modules.get("TrackingZoomC"));
		this.sendMessage("#TRACRESET#", modules.get("TrackingWaC"));

	}
	
	public void sendToHBrain_TTS(String inText){
		//System.out.println(inText);
		this.sendMessage("#HBRAIN##TEXT#" + inText , modules.get("HBrain")); // # removed cause Leonie reads out the hash too
	}
	
	public void sendToHBrain_TTS_num(long inNum){
		//System.out.println(inText);
		this.sendMessage("#HBRAIN##TEXT#" + inNum , modules.get("HBrain")); // # removed cause Leonie reads out the hash too
	}
	
	public void sendToHBrain_TTS2(String inT1, String inT2){
		this.sendToHBrain_TTS(inT1 + inT2);
	}
	
	public void sendToHBrain_TTS3(String inT1, String inT2, String inT3){
		this.sendToHBrain_TTS(inT1 + inT2 + inT3);
	}
	
	public void sendToHBrain_TTSWithPos(String inPos, String inText){
		//System.out.println(inText);
		sendToHBrain_TTS("{0;" + inPos + "}" + inText);
	}
	
	public void sendToHBrain_PersonPosition(){
		
	}
	
	public void sendToKinect2_detectionOnOff(boolean inOnOff){
		this.sendMessage("#NOISEDETECTION#" + (inOnOff?"1":"0") + "#", modules.get("NoiseDetection"));
	}
	
	public void sendToLeapMotion_detectionOnOff(long inOnOff){
		this.sendMessage("#HANDGESTURES#" + (int)inOnOff + "#", modules.get("HandGestures"));
	}
	
	public void sendToSTT_detectionOnOff(long inOnOff){
		this.sendMessage("#STT#" + (inOnOff==0?"0":(inOnOff==1?"1":(inOnOff==2?"yesno":"name"))) + "#", modules.get("STT"));
		if(inOnOff != 0){
			Start.instanceOf().getBrain().getSCISTT().setSTTReady(false);
			Start.instanceOf().getBrain().getSCISTT().setSpeakerMsg("");
			Start.instanceOf().getBrain().getSCISTT().setFilteredMsg("");
		}
	}
	
	public void sendToSmartphone_(){
		
	}
	
	public void sendToNav_goToGWP(long inWayPoint){
		System.out.println("Go to global way point " + inWayPoint);
		this.sendMessage("#NAV##GWP#" + inWayPoint + "#", modules.get("Mira"));
	}
	
	public void sendToNav_goToNextGWPForConf() {
		SCIBGF BGF = Start.instanceOf().getBrain().getSCIBGF();
		
		
		if(BGF.getEventNum() == 0){
			this.sendToNav_goToGWP(0);
		}else if(BGF.getEventNum() <= 3){
			this.sendToNav_goToGWP(BGF.getEventNum());
		}else if(BGF.getEventNum() <= 6){
			this.sendToNav_goToGWP(BGF.getEventNum() - 3);
		}else{
			this.sendToNav_goToGWP(0);
		}
		
		
	}
	
	public void sendToNav_goToLC(String inX, String inY){
		System.out.println("Go to local coordinates: x=" + inX + ", y=" + inY);
		this.sendMessage("#NAV##LC#" + inX + ";" + inY + ";#", modules.get("Mira"));
	}
	
	public void sendToNav_turnBody(String inAngle){  //#NAV##ROTBODY#360#
		System.out.println("Turn Body: angle=" + inAngle);
		this.sendMessage("#NAV##ROTBODY#" + inAngle + "#", modules.get("Mira"));
	}
	
	public void sendToNav_bodyUTurn(){  //#NAV##ROTBODY#360#
		
		this.sendMessage("#NAV##ROTBODY#90#", modules.get("Mira"));
		try {
			Thread.sleep(820);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.sendMessage("#NAV##ROTBODY#90#", modules.get("Mira"));
	}
	
	public void sendToNav_turnHead(String inAngle){  //#NAV##ROTBODY#360#
		  System.out.println("Turn Body: angle=" + inAngle);
		  this.sendMessage("#NAV##ROTHEAD#" + inAngle + "#", modules.get("Mira"));
		 }

	
	public void sendToNav_searchOnOff(boolean inOnOff){
		System.out.println(inOnOff?"Moving from WP to WP":"Standing");
		this.sendMessage("#NAV##RUN#" + (inOnOff?"1":"0") + "#", modules.get("Mira"));
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
		 this.sendMessage("/home/leonie/ACI/org.png", modules.get("Attractiveness"));
	 }

	

	
}
