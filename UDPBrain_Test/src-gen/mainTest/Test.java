package mainTest;

import org.yakindu.scr.testbrain.OpCallbackImpl;
import org.yakindu.scr.testbrain.TestBrainStatemachine;


public class Test
{
	private static Test instance = null;
	
	TestBrainStatemachine testBrain;
	
	private Test()
	{
		testBrain = new TestBrainStatemachine();
	}
	
	public static Test instanceOf()
	{
		if(instance==null)
			instance = new Test();
		
		return instance;
	}
	
	public TestBrainStatemachine getTestBrain()
	{
		return testBrain;
	}
	
	public static void main(String[] args) throws Exception
	{
		Test t = Test.instanceOf();

		OpCallbackImpl opCallback = new OpCallbackImpl();
		t.testBrain.getSCIPrintDataInterface().setSCIPrintDataInterfaceOperationCallback(opCallback);
		t.testBrain.getSCIUdpInterface().setSCIUdpInterfaceOperationCallback(opCallback);
		
		t.testBrain.init();
		t.testBrain.enter();

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
			t.testBrain.runCycle();
//			Thread.sleep(500);
		}
	}
}
