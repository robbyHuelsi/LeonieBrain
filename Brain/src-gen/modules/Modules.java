package modules;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Vector;

public class Modules {

	private Vector<Module> modules = new Vector<Module>();
	
	public Modules(){
		addModule("Brain", getOwnIpAddress(), null, false, true);
		addModule("CNS", true);
	}
	
	public Modules(Integer listenPort){
		addModule("Brain", getOwnIpAddress(), listenPort, false, true);
		addModule("CNS", true);
	}
	
	private boolean addModule(String name, String ip, Integer port, boolean setParser, boolean overwrite){
		//add function w/o variable setParser should be private. setParser = false just for adding Brain
		for (Module module : modules) {
			if (module.getName().equals(name)) {
				if (overwrite) {
					module = new Module(name, ip, port, setParser);
					return true;
				}else{
					return false;
				}
			}
		}
		modules.add(new Module(name, ip, port, setParser));
		return true;
	}
	
	public boolean addModule(String name, String ip, Integer port, boolean overwrite){
		//setParser = true for all public addModule functions
		return addModule(name, ip, port, true, overwrite);
	}
	
	public boolean addModule(String name, String ip, boolean overwrite){
		return addModule(name, ip, null, overwrite);
	}
	
	public boolean addModule(String name, Integer port, boolean overwrite){
		return addModule(name, null, port, overwrite);
	}
	
	public boolean addModule(String name, boolean overwrite){
		return addModule(name, null, null, overwrite);
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
	

	
	public Module get(String name){
		for (Module module : modules) {
			if (module.getName().toLowerCase().equals(name.toLowerCase())) {
				return module;
			}
		}
		System.out.println(name + " not found in " + modules.toString());
		return null;
	}
	
	public String getIp(String name){
		for (Module module : modules) {
			if (module.getName().toLowerCase().equals(name.toLowerCase())) {
				return module.getIp();
			}
		}
		System.out.println(name + " not found in " + modules.toString());
		return null;
	}
	
	public Integer getPort(String name){
		for (Module module : modules) {
			if (module.getName().toLowerCase().equals(name.toLowerCase())) {
				return module.getPort();
			}
		}
		System.out.println(name + " not found in " + modules.toString());
		return null;
	}
	
	public Object getParser(String name){
		for (Module module : modules) {
			if (module.getName().toLowerCase().equals(name.toLowerCase())) {
				return module.getParser();
			}
		}
		System.out.println(name + " not found in " + modules.toString());
		return null;
	}
	
	public void removeAll(){
		modules.removeAllElements();
	}
	
	public boolean setIpAndPortOldSchool(){
		
		// ---- VBrain ------------------------------------------------------------
		//String ipSendVBrain = "134.103.120.108"; //myCampus Scitos
		//String ipSendVBrain = "192.168.1.7"; //Netgear Scitos
		//String ipSendVBrain = "192.168.1.25"; //Netgear NUC
		String ipSendVBrain = "192.168.188.11"; //FritzBox NUC
		//String ipSendVBrain = "192.168.178.40";
		int portSendVBrain = 7777;
		if (!addModule("VBrain", ipSendVBrain, portSendVBrain, false)) {
			System.out.println("Add VBrain failed");
			return false;
		}
		
		String ipSendAtrac = "192.168.188.10"; //FritzBox NUC
		//String ipSendAtrac = "192.168.178.40";
		int portSendAtracPTZ = 5008;
		int portSendAtracWaC = 5010;
		if (!addModule("TrackingZoomC", ipSendAtrac, portSendAtracPTZ, false)) {
			System.out.println("Add TrackingZoomC failed");
			return false;
		}
		if (!addModule("TrackingWaC", ipSendAtrac, portSendAtracWaC, false)) {
			System.out.println("Add TrackingWaC failed");
			return false;
		}
		// -------------------------------------------------------------------------
		
		
		// ---- HBrain -----------------------------------------
		String ipSendHBrain = "192.168.188.11";
		//String ipSendHBrain = "192.168.178.40";
		int portSendHBrain = 11005;
		if (!addModule("HBrain", ipSendHBrain, portSendHBrain, false)) {
			System.out.println("Add HBrain failed");
			return false;
		}

		// -----------------------------------------------------
		//STT
		String ipSendSTT = "192.168.188.12";
		//String ipSendSTT = "192.168.178.40";
		int portSendSTT = 50022;
		if (!addModule("STT", ipSendSTT, portSendSTT, false)) {
			System.out.println("Add STT failed");
			return false;
		}
		
		//Kinect1
		
		//Kinect2
		String ipSendKinect2 = "192.168.188.12";
//		String ipSendKinect2 = "192.168.178.40";
		int portSendKinect2 = 8000;
		if (!addModule("NoiseDetection", ipSendKinect2, portSendKinect2, false)) {
			System.out.println("Add NoiseDetection failed");
			return false;
		}
		
		//LeapMotion_vorne
		String ipSendLeapMotion = "192.168.188.11";
//		String ipSendLeapMotion = "192.168.178.40";
		int portSendLeapMotion = 50035;
		if (!addModule("HandGestures", ipSendLeapMotion, portSendLeapMotion, false)) {
			System.out.println("Add HandGestures failed");
			return false;
		}
		
		//Attractiveness
//				String ipSendAttractiveness = "192.168.178.40";
				String ipSendAttractiveness = "192.168.188.11";
				int portSendAttractiveness = 50011;
				if (!addModule("Attractiveness", ipSendAttractiveness, portSendAttractiveness, false)) {
					System.out.println("Add Attractiveness failed");
					return false;
				}
		
		//Scitos Remote Control
		
		//Navigation
		//String ipSendNavigation = "192.168.188.10"; //Netgear Scitos
		String ipSendNavigation = "192.168.188.10"; //FritzBox Scitos
//		String ipSendNavigation = "192.168.178.40";
		int portSendNavigation = 5000;
		if (!addModule("Mira", ipSendNavigation, portSendNavigation, false)) {
			System.out.println("Add Mira failed");
			return false;
		}
		
		return true;
	}
	
	private String getOwnIpAddress(){
		try {
			String ip = InetAddress.getLocalHost().toString();
			return ip.substring(ip.indexOf("/")+1);
		} catch (UnknownHostException e) {
			e.printStackTrace();
			return null;
		}
	}

	
}