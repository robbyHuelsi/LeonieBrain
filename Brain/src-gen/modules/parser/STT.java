package modules.parser;

import java.io.Serializable;


import main.*;
import modules.Module;

public class STT implements IParser, Serializable{
	private static final long serialVersionUID = 1L;
	private Start start;
	
	// Parsed information
	private String text;
	private String instruction;
	private String object;

	private boolean incomprehensible;
	private boolean textReceived;
	private boolean actionReceived;

	public boolean parse(String data, Start start) {
		this.start = start;
		
		
		//TODO:  Muss überarbeitet werden:
		
		if (data.contains("TEXT#")) {
			this.setText(data.substring(5));
			this.setTextReceived(true);
			
		}else if(data.contains("RETRY#")){
			this.setText(data.substring(6));
			this.setIncomprehensible(true);
			
		}else if(data.contains("ACTION#")){
			String[] t = data.substring(7).split(";");
			this.setInstruction(t[0]);
			this.setObject(t[1]);
			this.setActionReceived(true);
		}
		
		return true;
	}

	public String getText() {
		return text;
	}

	public void setText(String speakerMsg) {
		this.text = speakerMsg;
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
	
	
	
	
	public boolean isTextReceived() {
		return textReceived;
	}

	public void setTextReceived(boolean textReceived) {
		this.textReceived = textReceived;
		
		if (textReceived) {
			start.getStatemachine().raiseEventOfSCI("STT","textReceived");
		}
	}

	public boolean isIncomprehensible() {
		return incomprehensible;
	}

	public void setIncomprehensible(boolean incomprehensible) {
		this.incomprehensible = incomprehensible;
		
		if (incomprehensible) {
			start.getStatemachine().raiseEventOfSCI("STT","incomprehensible");
		}
	}

	public boolean isActionReceived() {
		return actionReceived;
	}

	public void setActionReceived(boolean actionReceived) {
		this.actionReceived = actionReceived;
		
		if (actionReceived) {
			start.getStatemachine().raiseEventOfSCI("STT","actionReceived");
		}
	}

	public boolean removeParsedInformation() {
		this.text = "";
		this.instruction = "";
		this.object = "";
		this.incomprehensible = false;
		this.textReceived = false;
		this.actionReceived = false;
		
		return true;
	}

}