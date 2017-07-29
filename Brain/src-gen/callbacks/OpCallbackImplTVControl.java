package callbacks;

import communication.Communication;
import main.Log;
import main.Start;
import modules.Module;

public class OpCallbackImplTVControl implements IOpCallbackImpl,
	org.yakindu.scr.openchallengenagoya.IOpenChallengeNagoyaStatemachine.SCITVControlOperationCallback
{
	
	private Log log = Start.instanceOf().getLog();
	private Module module = Start.instanceOf().getModules().get("TVCommand");

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
		// TODO Auto-generated method stub

	}

	@Override
	public void sendPing() {
		// TODO Auto-generated method stub

	}

	@Override
	public void sendStartVideo(String cmd) {
		send(cmd);
	}

}
