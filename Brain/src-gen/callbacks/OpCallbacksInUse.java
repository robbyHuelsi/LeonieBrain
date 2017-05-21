package callbacks;

public class OpCallbacksInUse {
	private String name;
	private Class opCallbackImplClass;
	private String errorString;
	
	
	
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
	public String getErrorString() {
		return errorString;
	}
	public void setErrorString(String errorString) {
		this.errorString = errorString;
	}

	@Override
	public String toString() {
		return name;
	}
	
	
}
