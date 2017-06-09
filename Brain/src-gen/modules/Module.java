package modules;

import java.io.Serializable;
import java.lang.reflect.Constructor;

import callbacks.OpCallbacksInUse;
import modules.parser.IParser;

public class Module implements Serializable{
	private static final long serialVersionUID = 1L;
	private String name;
	private String ip;
	private Integer port;
	private long pongTime = -1;
	private IParser parser;
	private long udpTcp;
	private int opCallbackId;
	private boolean internal;
	
	
	public Module(String name, String ip, Integer port, boolean internal, boolean setParser) {
		this.pongTime = -1;
		this.name = name;
		this.ip = ip;
		this.port = port;
		this.internal = internal;
		if (setParser) this.setParser(name);
	}
	
	/*public Module(String name, String ip, boolean internal, boolean setParser) {
		this.pongTime = -1;
		this.name = name;
		this.ip = ip;
		this.internal = internal;
		if (setParser) this.setParser(name);
	}
	
	public Module(String name, Integer port, boolean internal, boolean setParser) {
		this.pongTime = -1;
		this.name = name;
		this.port = port;
		this.internal = internal;
		if (setParser) this.setParser(name);
	}*/
	
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

	public long getPongTime() {
		return pongTime;
	}

	public boolean setPongTime(long pongTime) {
		this.pongTime = pongTime;
		return true;
	}

	public IParser getParser() {
		return parser;
	}

	public boolean setParser(String moduleName) {
		try {
			Class<?> parserClass = Class.forName("modules.parser." + moduleName);
			Constructor<?> parserClassConstructor = parserClass.getConstructors()[0];
			this.parser = (IParser) parserClassConstructor.newInstance();
			return true;
		} catch (Exception e) {
			System.out.println("Setting " + name + " parser by name failed");
			return false;
		}
	}

	public String toString() {
		return name + "@" + ip + ":" + port;
	}

	public long getUdpTcp() {
		return udpTcp;
	}

	public void setUdpTcp(long connection) {
		this.udpTcp = connection;
	}

	public int getOpCallbackId() {
		return opCallbackId;
	}

	public void setOpCallbackId(int id) {
		this.opCallbackId = id;
	}

	public boolean isInternal() {
		return internal;
	}

	public void setInternal(boolean internal) {
		this.internal = internal;
	}
}
