package modules;

public class Module {
	private String name;
	private String ip;
	private Integer port;
	private Object parser;
	
	
	public Module(String name, String ip, Integer port) {
		this.name = name;
		this.ip = ip;
		this.port = port;
	}
	
	public Module(String name, String ip) {
		this.name = name;
		this.ip = ip;
	}
	
	public Module(String name, Integer port) {
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

	public Object getParser() {
		return parser;
	}

	public void setParser(Object parser) {
		this.parser = parser;
	}

	public String toString() {
		return name + "@" + ip + ":" + port;
	}
}
