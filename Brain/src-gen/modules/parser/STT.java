package modules.parser;

import java.io.Serializable;


import main.*;
import modules.Module;

public class STT implements IParser, Serializable{
	private static final long serialVersionUID = 1L;
	private Start start;
	
	// Parsed information
	private String spokenText;
	private String answer;
	private String instruction;
	private String object;

	private boolean spokenTextReceived;
	private boolean answerReceived;
	private boolean incomprehensible;
	private boolean actionReceived;

	public boolean parse(String data, Start start) {
		this.start = start;
		
		
		//System.out.println(data);
		
		if (data.contains("TEXT#")) {
			this.setSpokenText(data.substring(5));
			this.setSpokenTextReceived(true);
			return true;
			
		}else if(data.contains("ANSWER#")){
			this.setAnswer(data.substring(7));
			this.setAnswerReceived(true);
			return true;
			
		}else if(data.contains("RETRY#")){
			this.setAnswer(data.substring(6));
			this.setIncomprehensible(true);
			return true;
			
		}else if(data.contains("ACTION#")){
			String[] t = data.substring(7).split(";");
			this.setInstruction(t[0]);
			this.setObject(t[1]);
			this.setActionReceived(true);
			return true;
		}
		
		return false;
	}

	public String getSpokenText() {
		return spokenText;
	}

	public void setSpokenText(String speakerMsg) {
		this.spokenText = speakerMsg;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
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
	
	
	
	

	public boolean isSpokenTextReceived() {
		return spokenTextReceived;
	}

	public void setSpokenTextReceived(boolean textReceived) {
		this.spokenTextReceived = textReceived;
		
		if (textReceived) {
			start.getStatemachine().raiseEventOfSCI("STT","spokenTextReceived");
		}
	}
	
	public boolean isAnswerReceived() {
		return answerReceived;
	}

	public void setAnswerReceived(boolean answerReceived) {
		this.answerReceived = answerReceived;
		
		if (answerReceived) {
			start.getStatemachine().raiseEventOfSCI("STT","answerReceived");
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
		this.spokenText = "";
		this.answer = "";
		this.instruction = "";
		this.object = "";
		this.spokenTextReceived = false;
		this.answerReceived = false;
		this.incomprehensible = false;
		this.actionReceived = false;
		
		return true;
	}

}