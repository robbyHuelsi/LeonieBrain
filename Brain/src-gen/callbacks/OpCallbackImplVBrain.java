package callbacks;

import Persons.PersonList;
import communication.Communication;
import main.Log;
import main.Start;
import modules.Modules;
import modules.parser.VBrain;

public class OpCallbackImplVBrain implements IOpCallbackImpl,
	org.yakindu.scr.braganca.IBragancaStatemachine.SCIVBrainOperationCallback
{
	
	private Log log = Start.instanceOf().getLog();
	private Modules modules = Start.instanceOf().getModules();
	private PersonList personList = Start.instanceOf().getPersonList();
	
	public void sendACIOnOff(boolean inOnOff){
		log.log(inOnOff?"ACI on":"ACI off");
		Communication.sendMessage(inOnOff?"#VBRAIN#1#":"#VBRAIN#0#", modules.get("VBrain"), log);
		Communication.sendMessage("#TRACRESET#", modules.get("TrackingZoomC"), log);
		Communication.sendMessage("#TRACRESET#", modules.get("TrackingWaC"), log);

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

	@Override
	public void sendInit() {
		sendACIOnOff(false);
	}
	
	public void sendPing() {
		Communication.sendMessage("#VBRAIN#REQUEST#READY#", modules.get("VBrain"), log);
	}
}
