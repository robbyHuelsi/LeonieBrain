package Objects;

public class Action {
	private String instruction;
	private String object;
	private String location;
	
	public Action(String instruction, String object, String location) {
		super();
		this.instruction = instruction;
		this.object = object;
		this.location = location;
	}

	public Action(String instruction, String object) {
		super();
		this.instruction = instruction;
		
		if (instruction.equals("goto")) {
			this.location = object;
		}else{
			this.object = object;
		}
	}
	
	public Action(String instruction) {
		super();
		this.instruction = instruction;
	}

	public String getInstruction() {
		return instruction;
	}

	public void setInstruction(String instruction) {
		this.instruction = instruction;
	}

	public String getObject() {
		return object;
	}

	public void setObject(String object) {
		this.object = object;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String toString() {
		return "Action [instruction=" + instruction + ", object=" + object + ", location=" + location + "]";
	}
	
	
	
}
