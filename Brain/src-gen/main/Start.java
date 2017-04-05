package main;

import java.net.Inet4Address;

import org.yakindu.scr.TimerService;
import org.yakindu.scr.brain.BrainStatemachine;

import callbacks.OpCallbackImpl;
import modules.Modules;
import vBrain.*;

public class Start
{
	private static Start instance = null;
	
	BrainStatemachine brain;
	static private PersonList personList;
	static private Modules modules;
	
	// ---- Communication -----------------------------------------------------
	static private int portListen = 50000;
	// ------------------------------------------------------------------------
	
	
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
		
		modules = new Modules(portListen);
		personList = new PersonList();
		
		modules.setIpAndPortOldSchool();
		
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
	
	
	
	public static void main(String[] args) throws Exception
	{
		Start t = Start.instanceOf();
		
		OpCallbackImpl opCallback = new OpCallbackImpl();
		t.brain.getSCIBGF().setSCIBGFOperationCallback(opCallback);
		t.brain.getSCIUdpInterface().setSCIUdpInterfaceOperationCallback(opCallback);
		t.brain.getSCIVBrain().setSCIVBrainOperationCallback(opCallback);
		t.brain.getSCICurrPerson().setSCICurrPersonOperationCallback(opCallback);
		t.brain.getSCIAtt().setSCIAttOperationCallback(opCallback);
		
		
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
	
//	public OpCallbackImpl getOpCallbackImpl(){
//		return this.opCallback;
//	}
	
	public BrainStatemachine getBrain(){
		return brain;
	}
	
	public static PersonList getPersonList(){
		return personList;
	}

	public static Modules getModules(){
		return modules;
	}
}
