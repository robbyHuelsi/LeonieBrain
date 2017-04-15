package main;

import java.util.Vector;

import communication.Communication;
import modules.Modules;
import vBrain.PersonList;

public class Start{
	
	private static Start instance = null;
	
	private Statemachine statemachine;
	private static PersonList personList;
	private static Modules modules;
	
	private String[] statemachineNames = {
			"Braganca", 
			"SpeechAndPersonRecognition"
	};
	
	// ---- Communication -----------------------------------------------------
	static private int UDPListeningPort = 50000;
	static private int TCPListeningPort = 50001;
	// ------------------------------------------------------------------------
	
	public static void main(String[] args) throws Exception{
		Start t = Start.instanceOf();
		
		//Load modules and personList
		modules = new Modules(UDPListeningPort);
		personList = new PersonList();
		
		// Start listening for messages via UDP or TCP
		Communication.receive(modules.get("brain"));
		
		//Show GUI
		GUI gui = new GUI(t);
		
	}
	
	
	private Start(){
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
	
	public void runStatemachine(Start inStart){
		
		//Remove all parsed informations in the modules
		inStart.modules.removeParsedInformation();
		
		Statemachine sm = this.statemachine;
		sm.initAndEnter();

		new Thread(new Runnable() {
		    public void run() {
		    	while (statemachine != null)
				{
		    		sm.runCycle();
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
		    	System.out.println("Statemachine end");
		    }
		}).start();
		
	}
	
	public void setStatemachine(String statemachineName){
		if (statemachineName != null) {
			this.statemachine = new Statemachine(statemachineName); //Braganca, SpeechAndPersonRecognition, ...
			//this.statemachine.re
		}else{
			this.statemachine = null;
		}
		
	}
	
	public Statemachine getStatemachine(){
		return statemachine;
	}

	public static PersonList getPersonList(){
		return personList;
	}

	public static Modules getModules(){
		return modules;
	}
	
	public String[] getStatemachineNames(){
		return statemachineNames;
	}
}
