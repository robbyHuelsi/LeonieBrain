package callbacks;

import HBrain.HBrainCallback;
import communication.MessageParser;
import main.Start;

public class InternalModulesCallback{
	private static final Start start = Start.instanceOf();
	
	public class ResponseBrain implements HBrainCallback{
		@Override
		public boolean call(String msg) {
			if(msg != null){
				MessageParser.ParseMessage(msg);
				return true;
			}
			start.getLog().error("responseBrain callback: Message is null");
			return false;
		}
	}

	public class Log implements HBrainCallback{
		@Override
		public boolean call(String msg) {
			if(msg != null){
					start.getLog().log("Inside HBrain: " + msg);
					return true;
			}
			start.getLog().error("log callback: There is a problem with param");
			return false;
		}
	}
}
