package main;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Vector;

public class Addresses {

	private Vector<Address> addresses = new Vector<Address>();
	
	public Addresses(){
		addAddress("Brain", getOwnIpAddress());
	}
	
	public Addresses(Integer listenPort){
		addAddress("Brain", getOwnIpAddress(), listenPort);
	}
	
	public Addresses(String listenIp, Integer listenPort){
		addAddress("Brain", listenIp, listenPort);
	}
	
	public boolean addAddress(String name, String ip, Integer port){
		for (Address address : addresses) {if (address.getName().equals(name)) {return false;}}
		addresses.add(new Address(name, ip, port));
		return true;
	}
	
	public boolean addAddress(String name, String ip){
		return addAddress(name, ip, null);
	}
	
	public boolean addAddress(String name, Integer port){
		return addAddress(name, null, port);
	}
	
	public boolean addAddress(String name){
		return addAddress(name, null, null);
	}
	
	public boolean setIp(String name, String ip){
		for (Address address : addresses) {
			if (address.getName().toLowerCase().equals(name.toLowerCase())) {
				return address.setIp(ip);
			}
		}
		return false;
	}
	
	public boolean setPort(String name, Integer port){
		for (Address address : addresses) {
			if (address.getName().toLowerCase().equals(name.toLowerCase())) {
				return address.setPort(port);
			}
		}
		return false;
	}
	
	public String getIp(String name){
		for (Address address : addresses) {
			if (address.getName().toLowerCase().equals(name.toLowerCase())) {
				return address.getIp();
			}
		}
		return null;
	}
	
	public Integer getPort(String name){
		for (Address address : addresses) {
			if (address.getName().toLowerCase().equals(name.toLowerCase())) {
				return address.getPort();
			}
		}
		return null;
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




class Address {
	private String name;
	private String ip;
	private Integer port;
	
	
	public Address(String name, String ip, Integer port) {
		this.name = name;
		this.ip = ip;
		this.port = port;
	}
	
	public Address(String name, String ip) {
		this.name = name;
		this.ip = ip;
	}
	
	public Address(String name, Integer port) {
		this.name = name;
		this.port = port;
	}
	
	public String getName() {
		return name;
	}
	public boolean setName(String name) {
		this.name = name;
		return true;
	}
	public String getIp() {
		return ip;
	}
	public boolean setIp(String ip) {
		this.ip = ip;
		return true;
	}
	public Integer getPort() {
		return port;
	}
	public boolean setPort(Integer port) {
		this.port = port;
		return true;
	}
}