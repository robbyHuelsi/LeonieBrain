package modules.parser;

import java.io.Serializable;


import main.*;
import modules.Module;

public class STT implements IParser, Serializable{
	private static final long serialVersionUID = 1L;
	private Start start;
	
	private String speakerMsg;
	private String filterBubble;
	private String filteredMsg;
	private String answerToGive;
	
	private boolean STTReady;
	private boolean answerFound;

	public boolean parse(String data, Start start) {
		this.start = start;
		
		this.setSpeakerMsg(data);
		
		//TODO:  Muss überarbeitet werden:
		
//		String filterBubble = brain.getSCISTT().getFilterBubble();
//		
//		if(filterBubble == ""){
//			if (data.contains("yes") || data.contains("yep") ||data.contains("ja") ||data.contains("si") ||data.contains("yeah") ||data.contains("correct") ||data.contains("ok") ||data.contains("alright")||data.contains("okay")){
//				brain.getSCISTT().setFilteredMsg("yes");
//			}
//			
//			if (data.contains("no") || data.contains("nope") ||data.contains("nein") ||data.contains("nada") ||data.contains("cancel") ||data.contains("nö")){
//				brain.getSCISTT().setFilteredMsg("no");
//			}
//			
//		}else{
//			if (data.contains(filterBubble)){
//				brain.getSCISTT().setFilteredMsg(data);
//			}else{
//				brain.getSCISTT().setFilteredMsg("");
//			}
//		}
//		System.out.println("Filtered text: " + brain.getSCISTT().getFilteredMsg());
		
		this.setSTTReady(true);
		return true;
	}

	public String getSpeakerMsg() {
		return speakerMsg;
	}

	public void setSpeakerMsg(String speakerMsg) {
		this.speakerMsg = speakerMsg;
	}

	public String getFilterBubble() {
		return filterBubble;
	}

	public void setFilterBubble(String filterBubble) {
		this.filterBubble = filterBubble;
	}

	public String getFilteredMsg() {
		return filteredMsg;
	}

	public void setFilteredMsg(String filteredMsg) {
		this.filteredMsg = filteredMsg;
	}

	public String getAnswerToGive() {
		return answerToGive;
	}

	public void setAnswerToGive(String answerToGive) {
		this.answerToGive = answerToGive;
	}

	public boolean isSTTReady() {
		return STTReady;
	}

	public void setSTTReady(boolean sTTReady) {
		STTReady = sTTReady;
		
		if (sTTReady) {
			start.getStatemachine().raiseEventOfSCI("STT","STTReady");
		}
	}

	public boolean isAnswerFound() {
		return answerFound;
	}

	public void setAnswerFound(boolean answerFound) {
		this.answerFound = answerFound;
		
		if (answerFound) {
			start.getStatemachine().raiseEventOfSCI("STT","answerFound");
		}
	}

}