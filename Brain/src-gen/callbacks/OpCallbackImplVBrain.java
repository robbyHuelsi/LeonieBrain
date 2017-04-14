package callbacks;

import communication.Communication;
import main.Start;
import modules.Modules;
import modules.parser.STT;
import modules.parser.VBrain;
import vBrain.PersonList;

public class OpCallbackImplVBrain implements
	org.yakindu.scr.braganca.IBragancaStatemachine.SCIVBrainOperationCallback,
	org.yakindu.scr.speechandpersonrecognition.ISpeechAndPersonRecognitionStatemachine.SCIVBrainOperationCallback
{
	
	private Modules modules = Start.getModules();
	private PersonList personList = Start.getPersonList();
	
	public void sendACIOnOff(boolean inOnOff){
		System.out.println(inOnOff?"ACI on":"ACI off");
		Communication.sendMessage(inOnOff?"#VBRAIN#1#":"#VBRAIN#0#", modules.get("VBrain"));
		Communication.sendMessage("#TRACRESET#", modules.get("TrackingZoomC"));
		Communication.sendMessage("#TRACRESET#", modules.get("TrackingWaC"));

	}

	public void savePersonList() {
		personList.save();
	}

	public long getCountFoundFaces() {
		return ((VBrain)modules.getParser("VBrain")).getCountFoundFaces();
	}

	public void resetCountFoundFaces() {
		((VBrain)modules.getParser("VBrain")).setCountFoundFaces(0);
	}

	public boolean isNessesaryToSavePersonList() {
		return ((VBrain)modules.getParser("VBrain")).isNessesaryToSavePersonList();
	}
}
