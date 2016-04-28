package main;

import java.net.Inet4Address;

import org.yakindu.scr.TimerService;
import org.yakindu.scr.brain.BrainStatemachine;

import callbacks.OpCallbackImpl;
import vbrain.Person;
import vbrain.PersonDynData;
import vbrain.PersonList;

public class Start
{
	private static Start instance = null;
	
	BrainStatemachine brain;
	static private PersonList personList;
	
	
	// ---- BRAIN -------------------------------------------------------------
	//static private String ipListen = "134.103.120.123";	//myCampus PC
	//static private String ipListen = "192.168.1.21";		//Netgear PC
	static private String ipListen = "192.168.188.23";	//FritzBox Laptop
	static private int portListen = 8888;
	// ------------------------------------------------------------------------
	
	
	// ---- VBrain ------------------------------------------------------------
	//static private String ipSendVBrain = "134.103.120.108"; //myCampus Scitos
	//static private String ipSendVBrain = "192.168.1.7"; //Netgear Scitos
	//static private String ipSendVBrain = "192.168.1.25"; //Netgear NUC
	static private String ipSendVBrain = "192.168.188.11"; //FritzBox NUC
	static private int portSendVBrain = 7777;
	// -------------------------------------------------------------------------
	
	// ---- HBrain -----------------------------------------
	static private String ipSendHBrain = "192.168.188.11";
	static private int portSendHBrain = 11005;
	// -----------------------------------------------------
	//STT
	static private String ipSendSTT = "192.168.188.12";
	static private int portSendSTT = 7000;
	
	//Kinect1
	
	//Kinect2
	static private String ipSendKinect2 = "192.168.188.12";
	static private int portSendKinect2 = 8000;
	
	//LeapMotion
	static private String ipSendLeapMotion = "192.168.188.12";
	static private int portSendLeapMotion = 7000;
	
	//Scitos Remote Control
	static private String ipSendSRC = "";
	static private int portSendSRC = 0;
	
	//Navigation
	static private String ipSendNavigation = "192.168.188.10"; //Netgear Scitos
	//static private String ipSendNavigation = "192.168.188.21"; //FritzBox Scitos
	static private int portSendNavigation = 5000;
	
//	public enum Emotion {
//	    neutral, happy, sad, laugthing, angry;
//		private final int value;
//		private static Emotion[] allValues = values();
//		public static Emotion fromInt(int n) {return allValues[n];}
//		 public int getValue() {return value;}
//	}
	
	private Start()
	{
		brain = new BrainStatemachine();
		brain.setTimer(new TimerService());
		
		personList = new PersonList();
		
		
//		Person p = new Person();
//		p.setGender(false, brain);
//		p.setFirstName("Leonie", brain);
//		personList.addPerson(p);
//		personList.save();
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
		t.brain.getSCIBGF().setSCIBGFOperationCallback(opCallback);
		t.brain.getSCIUdpInterface().setSCIUdpInterfaceOperationCallback(opCallback);
		t.brain.getSCIVBrain().setSCIVBrainOperationCallback(opCallback);
		t.brain.getSCICurrPerson().setSCICurrPersonOperationCallback(opCallback);
		
		
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
			Thread.sleep(500);
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
