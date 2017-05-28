package callbacks;

public class OpCallbacksInUse {
	static int UNIQUE_ID = 0;
	private int uid = ++UNIQUE_ID;
	
	private String name;
	private Class opCallbackImplClass;
	private Exception exception;
	
	
	
	public OpCallbacksInUse(String name) {
		super();
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Class getOpCallbackImplClass() {
		return opCallbackImplClass;
	}
	public void setOpCallbackImplClass(Class opCallbackImplClass) {
		this.opCallbackImplClass = opCallbackImplClass;
	}
	public Exception getException() {
		return exception;
	}
	public void setException(Exception e) {
		this.exception = e;
	}

	public int getUid() {
		return uid;
	}

	@Override
	public String toString() {
		return name;
	}
	
	
}
