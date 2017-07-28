package modules.parser;

import java.io.Serializable;
import java.util.Vector;

import main.*;
import modules.Module;
import Objects.Action;

public class STT implements IParser, Serializable{
	private static final long serialVersionUID = 1L;
	private Start start;
	
	// Parsed information
	private String spokenText;	//just returns the input from the microphone 
	private String answer;		//answer sentence if a question is asked
	private String instruction; //returns instruction if keywords like "bring", etc are detected
	private String object;		
	
	private Vector<Action> actionList; //there can be several instructions in one sentence detected

	private boolean spokenTextReceived;
	private boolean answerReceived;
	private boolean incomprehensible;
	private boolean actionReceived;
	private boolean actionsReceived;

	public boolean parse(String data, Start start) {
		this.start = start;
		
		
		//start.getLog().log(data);
		
		if (data.contains("TEXT#")) {
			this.setSpokenText(data.substring(5));
			this.setSpokenTextReceived(true);
			start.getLog().log("SpokenText: " + this.getSpokenText());
			return true;
			
		}else if(data.contains("ANSWER#")){
			this.setAnswer(data.substring(7));
			this.setAnswerReceived(true);
			start.getLog().log("Answer: " + this.getAnswer());
			return true;
			
		}else if(data.contains("RETRY#")){
			this.setAnswer(data.substring(6));
			this.setIncomprehensible(true);
			start.getLog().log("Retry: " + this.getAnswer());
			return true;
			
		}else if(data.contains("ACTIONS#")){
			this.actionList = new Vector<Action>();
			
			String[] actions = data.substring(8).split("\\|");
			
			for (String action : actions) {
				String[] actionDatas = action.split(";");
				if (actionDatas.length > 2) {
					this.actionList.add(new Action(actionDatas[0],actionDatas[1], actionDatas[2]));
				}else if(actionDatas.length > 1){
					this.actionList.add(new Action(actionDatas[0], actionDatas[1]));
				}else{
					this.actionList.add(new Action(actionDatas[0]));
				}
			}
			
			this.setActionsReceived(true);
			
			start.getLog().log("Actions: " + this.actionList);
			return true;
			
			
		}else if(data.contains("ACTION#")){
			//TODO  Action: crowd, -1|-1|-1|-1|4|-1
			String[] t = data.substring(7).split(";");
			this.setInstruction(t[0]);
			this.setObject(t[1]);
			this.setActionReceived(true);
			start.getLog().log("Action: " + this.getInstruction() + ", " + this.getObject());
			
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
	
	public int getActionListLength(){
		if (this.actionList != null) {
			return this.actionList.size();
		}else{
			return 0;
		}
	}
	
	public String getInstructionFromActionListAt(long i){
		try {
			if (this.actionList != null) {
				return this.actionList.get((int)i).getInstruction();
			}else{
				return "";
			}
		} catch (Exception e) {
			start.getLog().error("Error in getInstructionFromActionListAt(long i)");
			return "";
		}
	}
	
	public String getObjectFromActionListAt(long i){
		try{
			if (this.actionList != null) {
				return this.actionList.get((int)i).getObject();
			}else{
				return "";
			}
		} catch (Exception e) {
			start.getLog().error("Error in getObjectFromActionListAt(long i)");
			return "";
		}
	}
	
	public String getLocationFromActionListAt(long i){
		try{
			if (this.actionList != null) {
				return this.actionList.get((int)i).getLocation();
			}else{
				return "";
			}
		} catch (Exception e) {
			start.getLog().error("Error in getLocationFromActionListAt(long i)");
			return "";
		}
	}
	
	public String getAllActionCommandsSentence() {
		try{
			if (actionList.isEmpty()) {
				return "I didnt get actions. Sorry [:-(]";
			}else{
				String answer = "";
				for (int i = 0; i < this.actionList.size(); i++) {
					answer += getSingleActionCommandSentence(i) + " ";
				}
				return answer;
			}
		} catch (Exception e) {
			start.getLog().error("Error in getActionCommandSentence()");
			return "";
		}
	}
	
	public String getSingleActionCommandSentence(long index) {
		
		String answer = "The ";
		
		if (index < 0 || index >= this.actionList.size()) {
			return "";
		}
		
		switch ((int)index) {
		case 0:
			answer += "first ";
			break;
			
		case 1:
			answer += "second ";
			break;
			
		case 2:
			answer += "third ";
			break;
			
		case 3:
			answer += "fourth ";
			break;

		default:
			answer += "next ";
			break;
		}
		
		answer += "task is ";
		
		Action action = this.actionList.get((int)index);
		
		switch (action.getInstruction()) {
		case "goto":
			return answer + "to go to the " + action.getLocation() + ".";
			
		case "crowd":
			return answer + "to detect the crowd. "; // TODO: Hinzufügen, nachwas gefragt ist " + action.getLocation() + ". ";
			
		case "surrounding":
			return answer + "to look for something in the surrounding."; //TODO: Ausweiten
			
		case "bring":
			if ( action.getObject() == null || action.getObject().isEmpty()) {
				return answer + "to bring something. ";
			}else{
				return answer + "to bring the " + action.getObject() + "."; //TODO: Ausweitern
			}
					
		case "open":
			if ( action.getObject() == null || action.getObject().isEmpty()) {
				return answer + "to open something. ";
			}else{
				return answer + "to open the " + action.getObject() + ".";
			}
			
		case "followme":
			return answer + "to follow " + action.getLocation() + ".";
			
		case "tell":
			if (action.getLocation() == null || action.getLocation().isEmpty()) { //Location = Thema
				return answer + "to tell something. ";
			}else{
				return answer + "to tell about " + action.getObject() + ".";
			}
			
		case "question":
			return answer + "to answer a question.";

		default:
			return answer + "to do something unknown.";
		}
	}

	
	public void resetActionList(){
		this.actionList = new Vector<Action>();
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

	public boolean isActionsReceived() {
		return actionsReceived;
	}

	public void setActionsReceived(boolean actionsReceived) {
		this.actionsReceived = actionsReceived;
		
		if (actionsReceived) {
			start.getStatemachine().raiseEventOfSCI("STT","actionsReceived");
		}
	}

	public boolean removeParsedInformation() {
		this.spokenText = "";
		this.answer = "";
		this.instruction = "";
		this.object = "";
		this.actionList = new Vector<Action>();
		this.spokenTextReceived = false;
		this.answerReceived = false;
		this.incomprehensible = false;
		this.actionReceived = false;
		this.actionReceived = false;
		
		return true;
	}

}