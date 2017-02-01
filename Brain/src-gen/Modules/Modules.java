package Modules;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Vector;

public class Modules {

	private Vector<Module> modules = new Vector<Module>();
	
	public Modules(){
		addModule("Brain", getOwnIpAddress());
	}
	
	public Modules(Integer listenPort){
		addModule("Brain", getOwnIpAddress(), listenPort);
	}
	
//	public Modules(String listenIp, Integer listenPort){
//		addModule("Brain", listenIp, listenPort);
//	}
	
	public boolean addModule(String name, String ip, Integer port){
		for (Module module : modules) {if (module.getName().equals(name)) {return false;}}
		modules.add(new Module(name, ip, port));
		return true;
	}
	
	public boolean addModule(String name, String ip){
		return addModule(name, ip, null);
	}
	
	public boolean addModule(String name, Integer port){
		return addModule(name, null, port);
	}
	
	public boolean addModule(String name){
		return addModule(name, null, null);
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
	
	public void removeAll(){
		modules.removeAllElements();
	}
	
	public boolean setIpAndPortOldSchool(){
		removeAll();
		
		// ---- VBrain ------------------------------------------------------------
		//String ipSendVBrain = "134.103.120.108"; //myCampus Scitos
		//String ipSendVBrain = "192.168.1.7"; //Netgear Scitos
		//String ipSendVBrain = "192.168.1.25"; //Netgear NUC
		//String ipSendVBrain = "192.168.188.11"; //FritzBox NUC
		String ipSendVBrain = "192.168.178.40";
		int portSendVBrain = 7777;
		if (!addModule("VBrain", ipSendVBrain, portSendVBrain)) {
			System.out.println("Add VBrain failed");
			return false;
		}
		
		//String ipSendAtrac = "192.168.188.10"; //FritzBox NUC
		String ipSendAtrac = "192.168.178.40";
		int portSendAtracPTZ = 5008;
		int portSendAtracWaC = 5010;
		if (!addModule("TrackingZoomC", ipSendAtrac, portSendAtracPTZ)) {
			System.out.println("Add TrackingZoomC failed");
			return false;
		}
		if (!addModule("TrackingWaC", ipSendAtrac, portSendAtracWaC)) {
			System.out.println("Add TrackingWaC failed");
			return false;
		}
		// -------------------------------------------------------------------------
		
		
		// ---- HBrain -----------------------------------------
		//String ipSendHBrain = "192.168.188.11";
		String ipSendHBrain = "192.168.178.40";
		int portSendHBrain = 11005;
		if (!addModule("HBrain", ipSendHBrain, portSendHBrain)) {
			System.out.println("Add HBrain failed");
			return false;
		}

		// -----------------------------------------------------
		//STT
		//String ipSendSTT = "192.168.188.12";
		String ipSendSTT = "192.168.178.40";
		int portSendSTT = 50022;
		if (!addModule("STT", ipSendSTT, portSendSTT)) {
			System.out.println("Add STT failed");
			return false;
		}
		
		//Kinect1
		
		//Kinect2
		//String ipSendKinect2 = "192.168.188.12";
		String ipSendKinect2 = "192.168.178.40";
		int portSendKinect2 = 8000;
		if (!addModule("NoiseDetection", ipSendKinect2, portSendKinect2)) {
			System.out.println("Add NoiseDetection failed");
			return false;
		}
		
		//LeapMotion_vorne
		//String ipSendLeapMotion = "192.168.188.11";
		String ipSendLeapMotion = "192.168.178.40";
		int portSendLeapMotion = 50035;
		if (!addModule("HandGestures", ipSendLeapMotion, portSendLeapMotion)) {
			System.out.println("Add HandGestures failed");
			return false;
		}
		
		//Attractiveness
				String ipSendAttractiveness = "192.168.178.40";
				int portSendAttractiveness = 50011;
				if (!addModule("Attractiveness", ipSendAttractiveness, portSendAttractiveness)) {
					System.out.println("Add Attractiveness failed");
					return false;
				}
		
		//Scitos Remote Control
		
		//Navigation
		//String ipSendNavigation = "192.168.188.10"; //Netgear Scitos
		//String ipSendNavigation = "192.168.188.21"; //FritzBox Scitos
		String ipSendNavigation = "192.168.178.40";
		int portSendNavigation = 5000;
		if (!addModule("Mira", ipSendNavigation, portSendNavigation)) {
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