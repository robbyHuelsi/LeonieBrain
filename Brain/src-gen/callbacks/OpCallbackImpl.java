package callbacks;



import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Random;

import org.yakindu.scr.brain.IBrainStatemachine.SCIBGFOperationCallback;
//import org.yakindu.scr.brain.IBrainStatemachine.SCICurrPersonOperationCallback;
import org.yakindu.scr.brain.IBrainStatemachine.SCIUdpInterfaceOperationCallback;

import main.Start;
import udp.MessageParser;
import udp.UDPConnection;
import vbrain.PersonList;

public class OpCallbackImpl implements SCIUdpInterfaceOperationCallback, SCIBGFOperationCallback //, SCICurrPersonOperationCallback
{
	private PersonList personList = Start.getPersonList();
	
	
	// ---- Brain General Functions Interface ---- //
	public void print(String msg){
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
		this.sendMessage(inOnOff?"#BRAIN#1#":"#BRAIN#0#" + "\0", Start.getIpSendVBrain(), Start.getPortSendVBrain());
	}
	
	public void sendToHBrain_TTS(String inText){
		//System.out.println(inText);
		this.sendMessage(inText + "\0", Start.getIpSendHBrain(), Start.getPortSendHBrain());
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
		this.sendMessage((inOnOff?"1":"0"), Start.getIpSendKinect2(), Start.getPortSendKinect2());
	}
	
	public void sendToLeapMotion_detectionOnOff(boolean inOnOff){
		this.sendMessage("#HANDGESTURES#" + (inOnOff?"1":"0") + "#", Start.getIpSendLeapMotion(), Start.getPortSendLeapMotion());
	}
	
	public void sendToSTT_detectionOnOff(boolean inOnOff){
		this.sendMessage("#STT#" + (inOnOff?"1":"0"), Start.getIpSendSTT(), Start.getPortSendSTT());
	}
	
	public void sendToSmartphone_(){
		
	}
	
	public void sendToNav_goToGWP(String inWayPoint){
		System.out.println("Go to global way point " + inWayPoint);
		this.sendMessage("#NAV##GWP#" + inWayPoint + "#\0", Start.getIpSendNavigation(), Start.getPortSendNavigation());
	}
	
	public void sendToNav_goToLC(String inX, String inY){
		System.out.println("Go to local coordinates: x=" + inX + ", y=" + inY);
		this.sendMessage("#NAV##LC#" + inX + ";" + inY + ";#\0", Start.getIpSendNavigation(), Start.getPortSendNavigation());
	}
	
	public void sendToNav_searchOnOff(boolean inOnOff){
		System.out.println(inOnOff?"Moving from WP to WP":"Standing");
		this.sendMessage("#NAV##RUN#" + (inOnOff?"1":"0") + "#", Start.getIpSendNavigation(), Start.getPortSendNavigation());
	}
	
	public long randomNumber(){
		Random randomGenerator = new Random();
	      int randomInt = randomGenerator.nextInt(4);
		return randomInt;	
	}


	
	/*public long getId(){
		return personList.getCurrPerson().getPersonID();
	}
	
	public boolean isKnown(){
		if (personList.hasPersons()){
			return personList.getCurrPerson().isKnown();
		}else
			return false;
		
	}
	
	public String getFirstname(){
		return Start.getPersonList().getCurrPerson().getFirstName();
	}
	
	public String getLastname(){
		return Start.getPersonList().getCurrPerson().getLastName();
	}
	
	public long getBdYear(){
		return Start.getPersonList().getCurrPerson().getBdYear();
	}
	
	public long getBdMounth(){
		return Start.getPersonList().getCurrPerson().getBdMonth();
	}
	
	public long getBdDay(){
		return Start.getPersonList().getCurrPerson().getBdDay();
	}
	
	public boolean getGender(){
		return Start.getPersonList().getCurrPerson().getGender();
	}
	
	public long getEthnicity(){
		return Start.getPersonList().getCurrPerson().getEthnicity();
	}
	
	public boolean hasGlasses(){
		return Start.getPersonList().getCurrPerson().hasGlasses();
	}
	
	public double getAttractiveness(){
		return Start.getPersonList().getCurrPerson().getAttractiveness();
	}
	
	public long getCurrHeadgestures(){
		return Start.getPersonList().getCurrPerson().getCurrDynData().getHeadgesture();
	}
	
	public boolean isCurrSpeaking(){
		return Start.getPersonList().getCurrPerson().getCurrDynData().isSpeaking();
	}
	
	public long getCurrEmotion(){
		return Start.getPersonList().getCurrPerson().getCurrDynData().getEmotion();
	}
	
	public double getCurrDistance(){
		return Start.getPersonList().getCurrPerson().getCurrDynData().getDistance();
	}*/
	

//	@Override
//	public void parseString() {
//		//System.out.println(Start.instanceOf().getBrain().getSCIUdpInterface().getMessage());
//		MessageParser.ParseMessage(Start.instanceOf().getBrain().getSCIUdpInterface().getMessage());
//	}
	
}
