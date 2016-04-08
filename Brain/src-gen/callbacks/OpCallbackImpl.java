package callbacks;



import java.net.InetAddress;
import java.net.UnknownHostException;

import org.yakindu.scr.brain.IBrainStatemachine.SCIUdpInterfaceOperationCallback;

import main.Start;
import udp.MessageParser;
import udp.ReceiveUDP;
import udp.SendUDP;

public class OpCallbackImpl implements SCIUdpInterfaceOperationCallback
{
	/**
	 * receiving data from UDP, using sockets -> blocking!
	 */
	@Override
	public void receive()
	{
		/* UDP establish connection & receive */
		String result = null;
		ReceiveUDP receiveUDP = null;
		
		//System.out.println("ReceiveUDP...");
		
		try
		{
			receiveUDP = new ReceiveUDP(InetAddress.getByName(Start.getIpListen()), Start.getPortListen());
		} catch (UnknownHostException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		result = receiveUDP.receiveSocket();
		/* END */
		
		
		// Beispiel string: #VBRAIN#0;1/2;A;Nachname;1994;12;25;false;0;false;0.0		
		
		Start.instanceOf().getBrain().getSCIUdpInterface().setMessage(result.trim());
//		System.out.println("receive test output: " + result);
	}
	
	
	private void sendMessage(String ip, int port, String text)
	{
		try
		{
			SendUDP sss = new SendUDP(InetAddress.getLocalHost(), 1234);
			//sss.sendSocket(Start.instanceOf().getBrain().getSCIUdpInterface().getMessage(), InetAddress.getByName("134.103.120.108"), 8888);
			sss.sendSocket(text, InetAddress.getByName(ip), port);
		} catch (UnknownHostException e)
		{
			e.printStackTrace();
		}
//		System.out.println(Test.instanceOf().getTestBrain().getSCIUdpInterface().getData());		
	}
	
	public void sendToVBrain_ACIonOff(boolean inOnOff){
		System.out.println(inOnOff?"ACI on":"ACI off");
		this.sendMessage(Start.getIpSendVBrain(), Start.getPortSendVBrain(), inOnOff?"#VBRAIN#11#":"#VBRAIN#00#" + "\0");
	}
	
	public void sendToHBrain_TTS(String inText){
		//System.out.println(inText);
		this.sendMessage(Start.getIpSendHBrain(), Start.getPortSendHBrain(), inText + "\0");
	}
	
	public void sendToHBrain_TTSWithPos(String inPos, String inText){
		//System.out.println(inText);
		sendToHBrain_TTS("{0;" + inPos + "}" + inText);
	}
	
	public void sendToHBrain_PersonPosition(){
		
	}
	
	public void sendToKinect2_detectionOnOff(boolean inOnOff){
		this.sendMessage(Start.getIpSendKinect2(), Start.getPortSendKinect2(), (inOnOff?"1":"0"));
	}
	
	public void sendToLeapMotion_detectionOnOff(boolean inOnOff){
		this.sendMessage(Start.getIpSendLeapMotion(), Start.getPortSendLeapMotion(), (inOnOff?"1":"0"));
	}
	
	public void sendToSTT_detectionOnOff(boolean inOnOff){
		this.sendMessage(Start.getIpSendSTT(), Start.getPortSendSTT(), (inOnOff?"1":"0"));
	}
	
	public void sendToSmartphone_(){
		
	}
	
	public void sendToNav_goToGWP(String inWayPoint){
		System.out.println("Go to global way point " + inWayPoint);
		this.sendMessage(Start.getIpSendNavigation(), Start.getPortSendNavigation(), "#NAV##GWP#" + inWayPoint + "#\0");
	}
	
	public void sendToNav_goToLC(String inX, String inY){
		System.out.println("Go to local coordinates: x=" + inX + ", y=" + inY);
		this.sendMessage(Start.getIpSendNavigation(), Start.getPortSendNavigation(), "#NAV##LC#" + inX + ";" + inY + ";#\0");
	}
	
	public void sendToNav_searchOnOff(boolean inOnOff){
		System.out.println(inOnOff?"Moving from WP to WP":"Standing");
		this.sendMessage(Start.getIpSendNavigation(), Start.getPortSendNavigation(), "#NAV##SEARCH#" + (inOnOff?"0":"1") + "#\0");
	}
	

	@Override
	public void parseString() {
		//System.out.println(Start.instanceOf().getBrain().getSCIUdpInterface().getMessage());
		MessageParser.ParseMessage(Start.instanceOf().getBrain().getSCIUdpInterface().getMessage());
	}
}
