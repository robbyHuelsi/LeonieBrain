package main;

import org.yakindu.scr.TimerService;
import org.yakindu.scr.brain.BrainStatemachine;

import callbacks.OpCallbackImpl;

public class Start
{
	private static Start instance = null;
	
	BrainStatemachine brain;
	
	private Start()
	{
		brain = new BrainStatemachine();
		brain.setTimer(new TimerService());
	}
	
	public static Start instanceOf()
	{
		if(instance==null)
			instance = new Start();
		
		return instance;
	}
	
	public BrainStatemachine getBrain()
	{
		return brain;
	}
	
	public static void main(String[] args) throws Exception
	{
		Start t = Start.instanceOf();

		OpCallbackImpl opCallback = new OpCallbackImpl();
		t.brain.getSCIUdpInterface().setSCIUdpInterfaceOperationCallback(opCallback);
		
		t.brain.init();
		t.brain.enter();

		while (true)
		{
//			String incomingMessage = receive.receive(true, InetAddress.getLoopbackAddress(), 9999);
//			incomingMessage = incomingMessage.trim();
////			System.out.println("Msg: " + incomingMessage);
//			if (incomingMessage != null && incomingMessage.equals("Klick"))
//			{
//				System.out.println("Switch klicked");
//				lightSwitch.getSCIUser().raiseOperate();
//			}
			t.brain.runCycle();
//			Thread.sleep(500);
		}
	}
}
