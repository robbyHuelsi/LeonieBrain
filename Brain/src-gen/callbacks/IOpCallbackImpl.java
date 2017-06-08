package callbacks;

public interface IOpCallbackImpl {
	public void send(String command); //Use service of other layer (connection or internal) only here
	public void sendInit();
	public void sendPing();
}
