package callbacks;



import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Random;

import org.yakindu.scr.brain.IBrainStatemachine.SCIBGFOperationCallback;
import org.yakindu.scr.brain.IBrainStatemachine.SCICurrPersonOperationCallback;
import org.yakindu.scr.brain.IBrainStatemachine.SCISTTOperationCallback;
import org.yakindu.scr.brain.IBrainStatemachine.SCIUdpInterfaceOperationCallback;

import main.Start;
import udp.UDPConnection;
import vbrain.PersonList;

public class OpCallbackImpl implements SCIUdpInterfaceOperationCallback, SCIBGFOperationCallback, SCISTTOperationCallback, SCICurrPersonOperationCallback
{
	private PersonList personList = Start.getPersonList();
	
	
	// ---- Brain General Functions Interface ---- //
	public void printToConsole(String msg){
		System.out.println(msg);
	}
	
	public void newRandNum(long max){
		Random randGen = new Random();
		Start.instanceOf().getBrain().getSCIBGF().setRandNum(randGen.nextInt((int)max-1));
	}
	
	
	
	// ---- UDP Interface ----------------------- //
	
	public void receive(){
		/* UDP establish connection & receive */
		String result = null;
		UDPConnection  udpConnection = new UDPConnection();
				
		try{
			udpConnection.receiveSocket(InetAddress.getByName(Start.getIpListen()), Start.getPortListen(), true);
			result = udpConnection.getMessage();
			System.out.println(InetAddress.getByName(Start.getIpListen())+"X:" + result);
//			udpConnection.setRunThread(false);
		} catch (UnknownHostException e){
			e.printStackTrace();
		}
	}
	
	private void sendMessage(String text, String targetAdress, int targetPort)
	{
		UDPConnection  udpConnection = new UDPConnection();
		try
		{
//			udpConnection.sendSocket(Start.instanceOf().getBrain().getSCIUdpInterface().getMessage(), InetAddress.getByName("134.103.120.108"), 8888);
			udpConnection.sendSocket(text, InetAddress.getByName(targetAdress), targetPort);
		} catch (UnknownHostException e)
		{
			e.printStackTrace();
		}
//		System.out.println(Test.instanceOf().getTestBrain().getSCIUdpInterface().getData());		
	}
	
	public void sendToVBrain_ACIonOff(boolean inOnOff){
		System.out.println(inOnOff?"ACI on":"ACI off");
		this.sendMessage(inOnOff?"#BRAIN#1#":"#BRAIN#0#" + "#", Start.getIpSendVBrain(), Start.getPortSendVBrain());
	}
	
	public void sendToHBrain_TTS(String inText){
		//System.out.println(inText);
		this.sendMessage("#BRAIN##TEXT#" + inText , Start.getIpSendHBrain(), Start.getPortSendHBrain()); // # removed cause Leonie reads out the hash too
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
		this.sendMessage("#NOISEDETECTION#" + (inOnOff?"1":"0") + "#", Start.getIpSendKinect2(), Start.getPortSendKinect2());
	}
	
	public void sendToLeapMotion_detectionOnOff(boolean inOnOff){
		this.sendMessage("#HANDGESTURES#" + (inOnOff?"1":"0") + "#", Start.getIpSendLeapMotion(), Start.getPortSendLeapMotion());
	}
	
	public void sendToSTT_detectionOnOff(boolean inOnOff){
		this.sendMessage("#STT#" + (inOnOff?"1":"0") + "#", Start.getIpSendSTT(), Start.getPortSendSTT());
	}
	
	public void sendToSmartphone_(){
		
	}
	
	public void sendToNav_goToGWP(String inWayPoint){
		System.out.println("Go to global way point " + inWayPoint);
		this.sendMessage("#NAV##GWP#" + inWayPoint + "#", Start.getIpSendNavigation(), Start.getPortSendNavigation());
	}
	
	public void sendToNav_goToLC(String inX, String inY){
		System.out.println("Go to local coordinates: x=" + inX + ", y=" + inY);
		this.sendMessage("#NAV##LC#" + inX + ";" + inY + ";#", Start.getIpSendNavigation(), Start.getPortSendNavigation());
	}
	
	public void sendToNav_turnBody(String inAngle){  //#NAV##ROTBODY#360#
		System.out.println("Turn Body: angle=" + inAngle);
		this.sendMessage("#NAV##ROTBODY#" + inAngle + "#", Start.getIpSendNavigation(), Start.getPortSendNavigation());
	}
	
	public void sendToNav_turnHead(String inAngle){  //#NAV##ROTBODY#360#
		  System.out.println("Turn Body: angle=" + inAngle);
		  this.sendMessage("#NAV##ROTHEAD#" + inAngle + "#", Start.getIpSendNavigation(), Start.getPortSendNavigation());
		 }

	
	public void sendToNav_searchOnOff(boolean inOnOff){
		System.out.println(inOnOff?"Moving from WP to WP":"Standing");
		this.sendMessage("#NAV##RUN#" + (inOnOff?"1":"0") + "#", Start.getIpSendNavigation(), Start.getPortSendNavigation());
	}

	
	public void filter(String filterString) {
		String input = Start.instanceOf().getBrain().getSCISTT().getSpeakerMsg();
		String output = Start.instanceOf().getBrain().getSCISTT().getFilteredMsg();
		
		if(filterString == ""){
			if (input.contains("yes") || input.contains("yep") ||input.contains("ja") ||input.contains("si") ||input.contains("yeah") ||input.contains("correct") ||input.contains("ok") ||input.contains("alright")||input.contains("okay")){
				input = "yes";
			}
			
			if (input.contains("no") || input.contains("nope") ||input.contains("nein") ||input.contains("nada") ||input.contains("cancel") ||input.contains("nö")){
				input = "no";
			}
			
		}else{
			if (input.contains(filterString)){
				input = filterString;
			}else{
				input = "";
			}
		}
		
		Start.instanceOf().getBrain().getSCISTT().setFilteredMsg(output);
		
		
		
		
	}

	
	public void setKnown(boolean inKnown) {
		if(personList.getCurrPerson() != null){
			personList.getCurrPerson().setKnown(inKnown);
		}
	}

	
	public void setFirstname(String inFirstname) {
		if(personList.getCurrPerson() != null){
			personList.getCurrPerson().setFirstName(inFirstname);
		}		
	}

	
	public void setLastname(String inLastname) {
		if(personList.getCurrPerson() != null){
			personList.getCurrPerson().setLastName(inLastname);
		}		
	}

	
	public void setBdYear(long inBdYear) {
		if(personList.getCurrPerson() != null){
			personList.getCurrPerson().setBdYear((int)inBdYear);
		}			
	}

	
	public void setBdMounth(long inBdMointh) {
		if(personList.getCurrPerson() != null){
			personList.getCurrPerson().setBdMonth((int)inBdMointh);
		}	
	}

	
	public void setBdDay(long inBdDay) {
		if(personList.getCurrPerson() != null){
			personList.getCurrPerson().setBdDay((int)inBdDay);
		}			
	}

	
	public void setGender(boolean inGender) {
		if(personList.getCurrPerson() != null){
			personList.getCurrPerson().setGender(inGender);
		}	
	}

	
	public void setEthnicity(long inEthnicity) {
		if(personList.getCurrPerson() != null){
			personList.getCurrPerson().setEthnicity((int)inEthnicity);
		}			
	}


	public void savePersonList() {
		personList.save();
	}


	

	
}
