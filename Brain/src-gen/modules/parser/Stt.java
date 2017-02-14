package modules.parser;

import org.yakindu.scr.brain.BrainStatemachine;

import main.*;

public class STT implements IParser{

	@Override
	public boolean parse(String data, BrainStatemachine brain, Start start) {
		brain.getSCISTT().setSpeakerMsg(data);
		String filterBubble = brain.getSCISTT().getFilterBubble();
		
		if(filterBubble == ""){
			if (data.contains("yes") || data.contains("yep") ||data.contains("ja") ||data.contains("si") ||data.contains("yeah") ||data.contains("correct") ||data.contains("ok") ||data.contains("alright")||data.contains("okay")){
				brain.getSCISTT().setFilteredMsg("yes");
			}
			
			if (data.contains("no") || data.contains("nope") ||data.contains("nein") ||data.contains("nada") ||data.contains("cancel") ||data.contains("nö")){
				brain.getSCISTT().setFilteredMsg("no");
			}
			
		}else{
			if (data.contains(filterBubble)){
				brain.getSCISTT().setFilteredMsg(data);
			}else{
				brain.getSCISTT().setFilteredMsg("");
			}
		}
		System.out.println("Filtered text: " + brain.getSCISTT().getFilteredMsg());
		
		brain.getSCISTT().setSTTReady(true);
		return true;
	}

}
