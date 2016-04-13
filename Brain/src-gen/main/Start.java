package main;

import org.yakindu.scr.TimerService;
import org.yakindu.scr.brain.BrainStatemachine;

import callbacks.OpCallbackImpl;

import vbrain.PersonList;

public class Start
{
	private static Start instance = null;
	
	BrainStatemachine brain;
	static private PersonList personList;
	
	static private String ipListen = "134.103.120.123";
	static private int portListen = 8888;
	
	//VBrain
	static private String ipSendVBrain = "134.103.120.108";
	static private int portSendVBrain = 8889;
	
	//HBrain
	static private String ipSendHBrain = "134.103.120.135";
	static private int portSendHBrain = 11005;
	
	//STT
	static private String ipSendSTT = "134.103.120.";
	static private int portSendSTT = 0;
	
	//Kinect1
	
	//Kinect2
	static private String ipSendKinect2 = "";
	static private int portSendKinect2 = 0;
	
	//LeapMotion
	static private String ipSendLeapMotion = "";
	static private int portSendLeapMotion = 0;
	
	//Scitos Remote Control
	static private String ipSendSRC = "";
	static private int portSendSRC = 0;
	
	//Navigation
	static private String ipSendNavigation = "";
	static private int portSendNavigation = 0;
	
	private Start()
	{
		brain = new BrainStatemachine();
		brain.setTimer(new TimerService());
		
		personList = new PersonList();
	}
	
	public static Start instanceOf()
	{
		if(instance==null)
			instance = new Start();
		
		return instance;
	}
	
	public BrainStatemachine getBrain()
	{
		return brain;
	}
	
	public static PersonList getPersonList(){
		return personList;
	}
	
	public static void main(String[] args) throws Exception
	{
		Start t = Start.instanceOf();
		
		OpCallbackImpl opCallback = new OpCallbackImpl();
		t.brain.getSCIUdpInterface().setSCIUdpInterfaceOperationCallback(opCallback);
		
		t.brain.init();
		t.brain.enter();

		while (true)
		{
//			String incomingMessage = receive.receive(true, InetAddress.getLoopbackAddress(), 9999);
//			incomingMessage = incomingMessage.trim();
////			System.out.println("Msg: " + incomingMessage);
//			if (incomingMessage != null && incomingMessage.equals("Klick"))
//			{
//				System.out.println("Switch klicked");
//				lightSwitch.getSCIUser().raiseOperate();
//			}
			t.brain.runCycle();
//			Thread.sleep(500);
		}
	}

	public static String getIpListen() {
		return ipListen;
	}

	public static int getPortListen() {
		return portListen;
	}

	public static String getIpSendVBrain() {
		return ipSendVBrain;
	}

	public static int getPortSendVBrain() {
		return portSendVBrain;
	}

	public static String getIpSendHBrain() {
		return ipSendHBrain;
	}

	public static int getPortSendHBrain() {
		return portSendHBrain;
	}

	public static String getIpSendSTT() {
		return ipSendSTT;
	}

	public static int getPortSendSTT() {
		return portSendSTT;
	}

	public static String getIpSendKinect2() {
		return ipSendKinect2;
	}

	public static int getPortSendKinect2() {
		return portSendKinect2;
	}

	public static String getIpSendLeapMotion() {
		return ipSendLeapMotion;
	}

	public static int getPortSendLeapMotion() {
		return portSendLeapMotion;
	}

	public static String getIpSendSRC() {
		return ipSendSRC;
	}

	public static int getPortSendSRC() {
		return portSendSRC;
	}

	public static String getIpSendNavigation() {
		return ipSendNavigation;
	}

	public static int getPortSendNavigation() {
		return portSendNavigation;
	}
}
