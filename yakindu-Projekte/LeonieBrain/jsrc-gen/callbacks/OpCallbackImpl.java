package org.yakindu.scr.testbrain;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.yakindu.scr.testbrain.ITestBrainStatemachine.SCIPrintDataInterfaceOperationCallback;
import org.yakindu.scr.testbrain.ITestBrainStatemachine.SCIUdpInterfaceOperationCallback;

import mainTest.Test;
import udp.MessageParser;
import udp.ReceiveUDP;
import udp.SendUDP;

public class OpCallbackImpl implements  
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
		MessageParser.ParseMessage(result);
		
//		Test.instanceOf().getTestBrain().getSCIUdpInterface().setData(result.trim());
//		System.out.println("receive test output: " + result);
	}
	
	@Override
	public void print()
	{
		
		try
		{
			SendUDP sss = new SendUDP(InetAddress.getLocalHost(), 1234);
			sss.sendSocket(Test.instanceOf().getTestBrain().getSCIUdpInterface().getData(), InetAddress.getByName("134.103.120.108"), 8888);
		} catch (UnknownHostException e)
		{
			e.printStackTrace();
		}
//		System.out.println(Test.instanceOf().getTestBrain().getSCIUdpInterface().getData());		
	}
}
