package callbacks;

import communication.Communication;
import main.Log;
import main.Start;
import modules.Module;

public class OpCallbackImplLEDControl implements IOpCallbackImpl,
	org.yakindu.scr.openchallengenagoya.IOpenChallengeNagoyaStatemachine.SCILEDControlOperationCallback
{
	
	private Log log = Start.instanceOf().getLog();
	private Module module = Start.instanceOf().getModules().get("LEDControl");

	@Override
	public void send(String command) {
		if (module.isInternal()) {
			// for internal Modules
		}else{
			Communication.sendMessage(command, module, log);
		}
	}

	@Override
	public void sendInit() {
		send("0.0.0");
	}

	@Override
	public void sendPing() {
		// TODO Auto-generated method stub

	}

	@Override
	public void sendRainbow() {
		send("24.07.1990");
		
	}

}
