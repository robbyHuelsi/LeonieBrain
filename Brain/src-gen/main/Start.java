package main;

import communication.Communication;
import modules.Modules;
import vBrain.PersonList;

public class Start{
	
	private static Start instance = null;
	
	private Statemachine statemachine;
	private static PersonList personList;
	private static Modules modules;
	
	
	// ---- Communication -----------------------------------------------------
	static private int UDPListeningPort = 50000;
	static private int TCPListeningPort = 50001;
	// ------------------------------------------------------------------------
	
	public static void main(String[] args) throws Exception{
		Start t = Start.instanceOf();
		
		// Start listening for messages via UDP or TCP
		Communication.receive(modules.get("brain"));
		
		t.statemachine.setOperationCallbacks();
		
		t.statemachine.initAndEnter();

		while (true)
		{
			t.statemachine.runCycle();
			Thread.sleep(500);
		}
	}
	
	private Start(){
		statemachine = new Statemachine("Braganca"); //SpeechAndPersonRecognition
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
	
	public static Start instanceOf(){
		if(instance==null)
			instance = new Start();
		
		return instance;
	}
	

	public static PersonList getPersonList(){
		return personList;
	}

	public static Modules getModules(){
		return modules;
	}
}
