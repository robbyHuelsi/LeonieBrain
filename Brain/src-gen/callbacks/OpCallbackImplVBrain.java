package callbacks;

import Persons.PersonList;
import communication.Communication;
import main.Log;
import main.Start;
import modules.Module;
import modules.Modules;
import modules.parser.VBrain;

public class OpCallbackImplVBrain implements IOpCallbackImpl,
	org.yakindu.scr.braganca.IBragancaStatemachine.SCIVBrainOperationCallback
{
	
	private Log log = Start.instanceOf().getLog();
	private Module module = Start.instanceOf().getModules().get("VBrain");
	private PersonList personList = Start.instanceOf().getPersonList();
	
	public void send(String command){
		if (module.isInternal()) {
			// for internal Modules
		}else{
			Communication.sendMessage(command, module, log);
		}
	}
	
	public void sendInit() {
		sendACIOnOff(false);
	}
	
	public void sendPing() {
		send("#VBRAIN#REQUEST#READY#");
	}
	
	/* ---------------------------------------------------------------- */
	
	
	public void sendACIOnOff(boolean inOnOff){
		log.log(inOnOff?"ACI on":"ACI off");
		send(inOnOff?"#VBRAIN#1#":"#VBRAIN#0#");
		//Communication.sendMessage("#TRACRESET#", modules.get("TrackingZoomC"), log);
		//Communication.sendMessage("#TRACRESET#", modules.get("TrackingWaC"), log);
		log.error("VBrain not implemented");

	}

	public void savePersonList() {
		personList.save();
	}

	public long getCountFoundFaces() {
		return ((VBrain)module.getParser()).getCountFoundFaces();
	}

	public void resetCountFoundFaces() {
		((VBrain)module.getParser()).setCountFoundFaces(0);
	}

	public boolean isNessesaryToSavePersonList() {
		return ((VBrain)module.getParser()).isNessesaryToSavePersonList();
	}
	
}
