package main;

import java.net.UnknownHostException;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import HBrain.HBrain;
import Persons.PersonList;
import communication.Communication;
import modules.Modules;
import callbacks.InternalModulesCallback;

public class Start{
	
	private static Start instance = null;
	private static Log log;
	private Statemachine statemachine;
	private static PersonList personList;
	private static Modules modules;
	private static GUI gui;
	private static HBrain hbrain;
	
	private static String savingsFolderPath = System.getProperty ("user.home") + System.getProperty("file.separator") + "LeonieBrain" + System.getProperty("file.separator");
	
	// ---- Communication -----------------------------------------------------
	static private int UDPListeningPort = 50000;
	static private int TCPListeningPort = 50001;
	// ------------------------------------------------------------------------
	
	public static void main(String[] args) throws Exception{
		Start t = Start.instanceOf();
		log  = new Log(savingsFolderPath);
		
		//Load modules and personList
		modules = new Modules(t, savingsFolderPath);
		personList = new PersonList(savingsFolderPath);
		
		// Start listening for messages via UDP or TCP
		Communication.receive(modules.get("brain"), log);
		
		//Show GUI
		gui = new GUI(t);
		
		
		//Before stopping application
		Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
	        public void run() {
	            log.endSM();
	        }
	    }));
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
		
		//Init HBrain if needed
		if(inStart.getStatemachine().isModuleInUse("HBrain") && inStart.getModules().get("HBrain").isInternal()){
			String[] hBrainArgs = {
					"hello",
					inStart.getModules().getIp("HBrain"),
					inStart.getModules().getPort("HBrain").toString(),
					inStart.getModules().getIp("Brain"),
					inStart.getModules().getPort("Brain").toString(),
					inStart.getModules().getIp("TTS"),
					inStart.getModules().getPort("TTS").toString(),
					inStart.getModules().getIp("Emofani"),
					inStart.getModules().getPort("Emofani").toString(),
					inStart.getModules().getIp("Mira"),
					inStart.getModules().getPort("Mira").toString(),
					};
			
//			for (String string : hBrainArgs) {
//				System.out.println(string);
//			}
			
			try {
				hbrain = HBrain.instanceOf(hBrainArgs);
				InternalModulesCallback callback = new InternalModulesCallback();
				hbrain.registerCallbackLog(callback.new Log());
				hbrain.registerCallbackResponseBrain(callback.new ResponseBrain());
			} catch (UnknownHostException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		
		Statemachine sm = this.statemachine;
		log.startSM(this.statemachine.getName());
		System.out.println("----------  Statemachine " + this.statemachine.getName() + " start  ----------");
		sm.initAndEnter();
		
		new Thread(new Runnable() {
		    public void run() {
		    	while (statemachine != null)
				{
		    		sm.runCycle();
					try {
						Thread.sleep(200);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
		    	
		    	if(hbrain != null){
		    		hbrain.stop();
		    	}
		    	
		    	log.endSM();
		    	if (hbrain != null) {
					hbrain.stop();
					log.log("HBrain stopped");
				}
		    	System.out.println("----------   Statemachine " + sm.getName() + " end   ----------");
		    }
		}).start();
		
	}

	
	public static Log getLog(){
		return log;
	}
	
	public static int getUDPListeningPort() {
		return UDPListeningPort;
	}


	public static int getTCPListeningPort() {
		return TCPListeningPort;
	}


	public void setStatemachine(String statemachineName, Start inStart){
		if (statemachineName != null) {
			this.statemachine = new Statemachine(statemachineName, inStart); //Braganca, SpeechAndPersonRecognition, ...
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
	
	public static boolean setModules(Modules m){
		modules = m;
		return true;
	}
	
	public static String getSavingsFolderPath() {
		return savingsFolderPath;
	}




	public GUI getGui(){
		return gui;
	}
	
	public Vector<String> getStatemachineNames(){
		List<Class<?>> classes = ClassFinder.find("org.yakindu.scr");
		Vector<String> classNames = new Vector<String>();
		for (Class<?> clazz : classes) {
			if (clazz.getSimpleName().contains("Statemachine") && !clazz.isInterface()) {
				classNames.add(clazz.getSimpleName().substring(0, clazz.getSimpleName().lastIndexOf("Statemachine")));
				//classNames.add(clazz.getSimpleName());
			}
		}
		//System.out.println(classNames.toString());
		return classNames;
	}




	public static HBrain getHbrain() {
		return hbrain;
	}
}
