package main;

import java.net.Inet4Address;

import org.yakindu.scr.TimerService;
import org.yakindu.scr.brain.BrainStatemachine;

import callbacks.OpCallbackImpl;
import communication.Communication;
import modules.Modules;
import vBrain.*;

public class Start
{
	private static Start instance = null;
	
	BrainStatemachine brain;
	static private PersonList personList;
	static private Modules modules;
	
	// ---- Communication -----------------------------------------------------
	static private int UDPListeningPort = 50000;
	static private int TCPListeningPort = 50001;
	// ------------------------------------------------------------------------
	
	public static void main(String[] args) throws Exception{
		Start t = Start.instanceOf();
		
		// Start listening for messages via UDP or TCP
		Communication.receive(modules.get("brain"));
		
		OpCallbackImpl opCallback = new OpCallbackImpl();
		t.brain.getSCIBGF().setSCIBGFOperationCallback(opCallback);
		t.brain.getSCIVBrain().setSCIVBrainOperationCallback(opCallback);
		t.brain.getSCIHBrain().setSCIHBrainOperationCallback(opCallback);
		t.brain.getSCIAttractiveness().setSCIAttractivenessOperationCallback(opCallback);
		t.brain.getSCIKinect2().setSCIKinect2OperationCallback(opCallback);
		t.brain.getSCILeapMotion().setSCILeapMotionOperationCallback(opCallback);
		t.brain.getSCIMira().setSCIMiraOperationCallback(opCallback);
		t.brain.getSCISTT().setSCISTTOperationCallback(opCallback);
		t.brain.getSCICurrPerson().setSCICurrPersonOperationCallback(opCallback);
		
		
		t.brain.init();
		t.brain.enter();

		while (true)
		{
			t.brain.runCycle();
			Thread.sleep(500);
		}
	}
	
	private Start()
	{
		brain = new BrainStatemachine();
		brain.setTimer(new TimerService());
		
		modules = new Modules(UDPListeningPort);
		personList = new PersonList();
		
//----> For using Brain w/o CNS Monitor:
//		modules.setIpAndPortOldSchool();
		
//---->	For testing personList:
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
