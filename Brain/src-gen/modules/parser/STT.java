package modules.parser;

import java.io.Serializable;


import main.*;
import modules.Module;

public class STT implements IParser, Serializable{
	private static final long serialVersionUID = 1L;
	private Start start;
	
	private String message;
	private boolean STTReady;

	public boolean parse(String data, Start start) {
		this.start = start;
		
		this.setMessage(data);
		
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

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
		//TODO: brain.getSCISTT().setSpeakerMsg(message);
	}

	public boolean isSTTReady() {
		return STTReady;
	}

	public void setSTTReady(boolean sTTReady) {
		STTReady = sTTReady;
		//TODO: brain.getSCISTT().setSTTReady(sTTReady);
	}

}