package callbacks;



import java.net.InetAddress;
import java.net.UnknownHostException;

import org.yakindu.scr.brain.IBrainStatemachine.SCIUdpInterfaceOperationCallback;

import main.Start;
import udp.MessageParser;
import udp.ReceiveUDP;
import udp.SendUDP;

public class OpCallbackImpl implements SCIUdpInterfaceOperationCallback
{
	/**
	 * receiving data from UDP, using sockets -> blocking!
	 */
	@Override
	public void receive()
	{
		/* UDP establish connection & receive */
		String result = null;
		ReceiveUDP receiveUDP = null;
		try
		{
			receiveUDP = new ReceiveUDP(InetAddress.getByName("134.103.109.51"), 8888);
		} catch (UnknownHostException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		result = receiveUDP.receiveSocket();
		/* END */
		
		
		// Beispiel string: #VBRAIN#0;1/2;A;Nachname;1994;12;25;false;0;false;0.0		
		
		
		Start.instanceOf().getBrain().getSCIUdpInterface().setMessage(result.trim());
//		System.out.println("receive test output: " + result);
	}
	
	
	public void sendMessage()
	{
		
		try
		{
			SendUDP sss = new SendUDP(InetAddress.getLocalHost(), 1234);
			sss.sendSocket(Start.instanceOf().getBrain().getSCIUdpInterface().getMessage(), InetAddress.getByName("134.103.120.108"), 8888);
		} catch (UnknownHostException e)
		{
			e.printStackTrace();
		}
//		System.out.println(Test.instanceOf().getTestBrain().getSCIUdpInterface().getData());		
	}

	@Override
	public void parseString() {
		// TODO Auto-generated method stub
		MessageParser.ParseMessage(Start.instanceOf().getBrain().getSCIUdpInterface().getMessage());
	}
}
