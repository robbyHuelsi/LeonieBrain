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
	private String spokenText;
	private String answer;
	private String instruction;
	private String object;
	
	private Vector<Action> actionList;

	private boolean spokenTextReceived;
	private boolean answerReceived;
	private boolean incomprehensible;
	private boolean actionReceived;
	private boolean actionsReceived;

	public boolean parse(String data, Start start) {
		this.start = start;
		
		
		//System.out.println(data);
		
		if (data.contains("TEXT#")) {
			this.setSpokenText(data.substring(5));
			this.setSpokenTextReceived(true);
			System.out.println("SpokenText: " + this.getSpokenText());
			return true;
			
		}else if(data.contains("ANSWER#")){
			this.setAnswer(data.substring(7));
			this.setAnswerReceived(true);
			System.out.println("Answer: " + this.getAnswer());
			return true;
			
		}else if(data.contains("RETRY#")){
			this.setAnswer(data.substring(6));
			this.setIncomprehensible(true);
			System.out.println("Retry: " + this.getAnswer());
			return true;
			
		}else if(data.contains("ACTIONS#")){
			this.actionList = new Vector<Action>();
			
			String[] actions = data.substring(8).split("\\|");
			
			for (String action : actions) {
				String[] actionDatas = action.split(";");
				if (actionDatas.length > 2) {
					this.actionList.add(new Action(actionDatas[0],actionDatas[1], actionDatas[2]));
				}else{
					this.actionList.add(new Action(actionDatas[0], actionDatas[1]));
				}
			}
			
			this.setActionsReceived(true);
			
			System.out.println("Actions: " + this.actionList);
			return true;
			
			
		}else if(data.contains("ACTION#")){
			String[] t = data.substring(7).split(";");
			this.setInstruction(t[0]);
			this.setObject(t[1]);
			this.setActionReceived(true);
			System.out.println("Action: " + this.getInstruction() + ", " + this.getObject());
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
		return this.actionList.size();
	}
	
	public String getInstructionFromActionListAt(long i){
		return this.actionList.get((int)i).getInstruction();
	}
	
	public String getObjectFromActionListAt(long i){
		return this.actionList.get((int)i).getObject();
	}
	
	public String getLocationFromActionListAt(long i){
		return this.actionList.get((int)i).getLocation();
	}
	
	public String getActionCommandSentence() {
		if (actionList.isEmpty()) {
			return "I didnt get actions. Sorry [:-(]";
		}else{
			String answer = "";
			for (Action action : actionList) {
				switch (action.getInstruction()) {
				case "goto":
					answer += "I should go to the " + action.getLocation() + ". ";
					break;
					
				case "crowd":
					answer += "I should detect the crowd. "; // TODO: Hinzufügen, nachwas gefragt ist " + action.getLocation() + ". ";
					break;
					
				case "surrounding":
					answer += "I should look for something in the surrounding. "; //TODO: Ausweiten
					break;
					
				case "bring":
					if (action.getObject().isEmpty()) {
						answer += "I should bring the " + action.getObject() + ". ";
					}else{
						answer += "I should bring the " + action.getObject() + ". "; //TODO: Ausweitern
					}
					
					break;
					
				case "open":
					answer += "I should open the " + action.getObject() + ". ";
					break;
					
				case "followme":
					answer += "I should follow " + action.getLocation() + ". ";
					break;
					
				case "tell":
					answer += "I should tell: " + action.getObject() + ". ";
					break;
					
				case "question":
					answer += "I answer a question. ";
					break;

				default:
					answer += "I do something unknown. ";
					break;
				}
			}
			return answer;
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