package modules;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Vector;

import Persons.Person;
import callbacks.OpCallbacksInUse;
import main.Start;

public class Modules {

	private Start start;
	private Vector<Module> modules = new Vector<Module>();
	private String filePath;
	
	public Modules(Start start, String savingsFolderPath){
		this.start = start;
		this.filePath = savingsFolderPath + "modules.brain";
		
		if(this.load()){
			//Modules wurden aus Datei geladen
			resetAllOpCallbacks();
			resetAllPongTimes();
		
			String ownIp = getOwnIpAddress();
			
			if (!get("Brain").getIp().equals(ownIp)) {
				get("Brain").setIp(ownIp);
				this.save();
				System.out.println("Brains IP was updated and saved");
			}
			
			System.out.println(modules.toString());
		}else{
			addModule("Brain", getOwnIpAddress(), Start.getUDPListeningPort(), true, false, true);
			addModule("CNS", false, true);
			this.save();
		}
	}
	
	//parameter setParser only avaible in private
	private boolean addModule(String name, String ip, Integer port, boolean internal, boolean setParser, boolean overwrite){
		//add function w/o variable setParser should be private. setParser = false just for adding Brain
		for (Module module : modules) {
			if (module.getName().equals(name)) {
				if (overwrite) {
					module = new Module(name, ip, port, internal, setParser);
					System.out.println("Module overwrite: " + module.toString());
					this.save();
					start.getGui().updateTableModulesUI();
					return true;
				}else{
					System.out.println("Module exists and overwrite forbidden");
					return false;
				}
			}
		}
		Module module = new Module(name, ip, port, internal, setParser);
		modules.add(module);
		System.out.println("New module added: " + module.toString());
		this.save();
		return true;
	}
	
	public boolean addModule(String name, String ip, Integer port, boolean internal, boolean overwrite){
		//setParser = true for all public addModule functions
		return addModule(name, ip, port, internal, true, overwrite);
	}
	
	public boolean addModule(String name, String ip, boolean internal, boolean overwrite){
		return addModule(name, ip, null, internal, overwrite);
	}
	
	public boolean addModule(String name, Integer port, boolean internal, boolean overwrite){
		return addModule(name, null, port, internal, overwrite);
	}
	
	public boolean addModule(String name, boolean internal, boolean overwrite){
		return addModule(name, null, null, internal, overwrite);
	}
	
	public boolean setIp(String name, String ip){
		for (Module module : modules) {
			if (module.getName().toLowerCase().equals(name.toLowerCase())) {
				return module.setIp(ip);
			}
		}
		return false;
	}
	
	public boolean setPort(String name, Integer port){
		for (Module module : modules) {
			if (module.getName().toLowerCase().equals(name.toLowerCase())) {
				return module.setPort(port);
			}
		}
		return false;
	}
	
	public boolean setPongTime(String name, long pongTime){
		for (Module module : modules) {
			if (module.getName().toLowerCase().equals(name.toLowerCase())) {
				return module.setPongTime(pongTime);
			}
		}
		return false;
	}
		
	public Module get(String name){
		for (Module module : modules) {
			if (module.getName().toLowerCase().equals(name.toLowerCase())) {
				return module;
			}
		}
		System.err.println(name + " not found in " + modules.toString());
		return null;
	}
	
	public Module get(int index){
		return this.modules.get(index);
	}
	
	public String getIp(String name){
		for (Module module : modules) {
			if (module.getName().toLowerCase().equals(name.toLowerCase())) {
				return module.getIp();
			}
		}
		System.err.println(name + " not found in " + modules.toString());
		return null;
	}
	
	public Integer getPort(String name){
		for (Module module : modules) {
			if (module.getName().toLowerCase().equals(name.toLowerCase())) {
				return module.getPort();
			}
		}
		System.err.println(name + " not found in " + modules.toString());
		return null;
	}
	
	public long getPongTime(String name){
		for (Module module : modules) {
			if (module.getName().toLowerCase().equals(name.toLowerCase())) {
				return module.getPongTime();
			}
		}
		System.err.println(name + " not found in " + modules.toString());
		return -1;
	}
	
	public Object getParser(String name){
		for (Module module : modules) {
			if (module.getName().toLowerCase().equals(name.toLowerCase())) {
				return module.getParser();
			}
		}
		System.err.println(name + " not found in " + modules.toString());
		return null;
	}
	
	public boolean setOpCallbackId(String name, int id){
		for (Module module : modules) {
			if (module.getName().toLowerCase().equals(name.toLowerCase())) {
				module.setOpCallbackId(id);
				return true;
			}
		}
		return false;
	}
	
	public int getOpCallback(String name){
		for (Module module : modules) {
			if (module.getName().toLowerCase().equals(name.toLowerCase())) {
				return module.getOpCallbackId();
			}
		}
		return 0;
	}
	
	public void resetAllOpCallbacks(){
		for (Module module : modules) {
			module.setOpCallbackId(0);
		}
	}
	
	public void resetAllPongTimes(){
		for (Module module : modules) {
			module.setPongTime(-1);
		}
	}
	
	public void removeAll(){
		modules.removeAllElements();
	}
	
	public void removeParsedInformation(){
		for (Module module : modules) {
			try {
				if (module.getParser() != null) {
					module.getParser().removeParsedInformation();
					System.out.println("Parsed informations in module " + module.getName() + " removed");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public int size(){
		return this.modules.size();
	}
	
	public boolean setIpAndPortOldSchool(){
		
		// ---- VBrain ------------------------------------------------------------
		//String ipSendVBrain = "134.103.120.108"; //myCampus Scitos
		//String ipSendVBrain = "192.168.1.7"; //Netgear Scitos
		//String ipSendVBrain = "192.168.1.25"; //Netgear NUC
		String ipSendVBrain = "192.168.188.11"; //FritzBox NUC
		//String ipSendVBrain = "192.168.178.40";
		int portSendVBrain = 7777;
		if (!addModule("VBrain", ipSendVBrain, portSendVBrain, false, false)) {
			System.out.println("Add VBrain failed");
			return false;
		}
		
		String ipSendAtrac = "192.168.188.10"; //FritzBox NUC
		//String ipSendAtrac = "192.168.178.40";
		int portSendAtracPTZ = 5008;
		int portSendAtracWaC = 5010;
		if (!addModule("TrackingZoomC", ipSendAtrac, portSendAtracPTZ, false, false)) {
			System.out.println("Add TrackingZoomC failed");
			return false;
		}
		if (!addModule("TrackingWaC", ipSendAtrac, portSendAtracWaC, false, false)) {
			System.out.println("Add TrackingWaC failed");
			return false;
		}
		// -------------------------------------------------------------------------
		
		
		// ---- HBrain -----------------------------------------
		String ipSendHBrain = "192.168.188.11";
		//String ipSendHBrain = "192.168.178.40";
		int portSendHBrain = 11005;
		if (!addModule("HBrain", ipSendHBrain, portSendHBrain, false, false)) {
			System.out.println("Add HBrain failed");
			return false;
		}

		// -----------------------------------------------------
		//STT
		String ipSendSTT = "192.168.188.12";
		//String ipSendSTT = "192.168.178.40";
		int portSendSTT = 50022;
		if (!addModule("STT", ipSendSTT, portSendSTT, false, false)) {
			System.out.println("Add STT failed");
			return false;
		}
		
		//Kinect1
		
		//Kinect2
		String ipSendKinect2 = "192.168.188.12";
//		String ipSendKinect2 = "192.168.178.40";
		int portSendKinect2 = 8000;
		if (!addModule("NoiseDetection", ipSendKinect2, portSendKinect2, false, false)) {
			System.out.println("Add NoiseDetection failed");
			return false;
		}
		
		//LeapMotion_vorne
		String ipSendLeapMotion = "192.168.188.11";
//		String ipSendLeapMotion = "192.168.178.40";
		int portSendLeapMotion = 50035;
		if (!addModule("HandGestures", ipSendLeapMotion, portSendLeapMotion, false, false)) {
			System.out.println("Add HandGestures failed");
			return false;
		}
		
		//Attractiveness
//				String ipSendAttractiveness = "192.168.178.40";
				String ipSendAttractiveness = "192.168.188.11";
				int portSendAttractiveness = 50011;
				if (!addModule("Attractiveness", ipSendAttractiveness, portSendAttractiveness, false, false)) {
					System.out.println("Add Attractiveness failed");
					return false;
				}
		
		//Scitos Remote Control
		
		//Navigation
		//String ipSendNavigation = "192.168.188.10"; //Netgear Scitos
		String ipSendNavigation = "192.168.188.10"; //FritzBox Scitos
//		String ipSendNavigation = "192.168.178.40";
		int portSendNavigation = 5000;
		if (!addModule("Mira", ipSendNavigation, portSendNavigation, false, false)) {
			System.out.println("Add Mira failed");
			return false;
		}
		
		return true;
	}
	
	public String getOwnIpAddress(){
		// Find OS and set command according to OS
	    String OS = System.getProperty("os.name").toLowerCase();
		if (OS.contains("win") || OS.contains("mac")) {
	        // Windows and Mac
			try {
				String ip = InetAddress.getLocalHost().toString();
				return ip.substring(ip.indexOf("/")+1);
			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return "";
			}
		}
		else{
			try {
				Socket s = new Socket("google.com", 80);
				String ip = s.getLocalAddress().getHostAddress().toString();
				s.close();
				return ip.substring(ip.indexOf("/")+1);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return "";
			}
		}
	}

	public boolean load(){
		File f = new File(this.filePath);
		if(f==null || !f.exists() || f.isDirectory()) { 
		    System.out.println("No Modules File Found");
		    return false;
		}
		
		ObjectInputStream objectinputstream = null;
		try {
			FileInputStream streamIn = new FileInputStream(filePath);
		    objectinputstream = new ObjectInputStream(streamIn);

		    Object obj= null;
		      // lese ein objekt nach dem anderen aus dem inputstream. das letzte 
		      // object, welches gelesen wird, ist null. dieses muss allerdings explizit
		      // geschrieben worden sein; andernfalls wird eine EOFException geworfen.
		      while ( (obj= objectinputstream.readObject()) != null ){
		      	this.modules = ((Vector<Module>) obj);
		      }
		    System.out.println("Opening Modules File Done");
		    return true;
		} catch (Exception e) {
			System.err.println("Opening Modules File Failed");
		    e.printStackTrace();
		    return false;
		} finally {
		    if(objectinputstream != null){
		        try {
					objectinputstream .close();
				} catch (IOException e) {
					
				}
		    } 
		}
	}
	
	public boolean save(){
		try{
			File f = new File(this.filePath);
			f.getParentFile().mkdirs();
			FileOutputStream fout = new FileOutputStream(f);
			ObjectOutputStream oos = new ObjectOutputStream(fout);
		
//			System.out.println(this.modules);
			oos.writeObject(this.modules);
		
			oos.writeObject( null );
			oos.flush();
			oos.close();
			System.out.println("Saving Modules File Done");
			return true;
		}catch(Exception ex){
			System.err.println("Saving Modules File Failed");
			ex.printStackTrace();
			return false;
		}
	}
	
}