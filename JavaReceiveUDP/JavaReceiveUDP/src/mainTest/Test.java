package mainTest;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;

import lightswitch.LightSwitchStatemachine;
import udp.ReceiveUDP;

public class Test
{
	public static void main(String[] args) throws Exception
	{
		ReceiveUDP receive = new ReceiveUDP(InetAddress.getLoopbackAddress(), 8888);
		LightSwitchStatemachine lightSwitch = new LightSwitchStatemachine();

		lightSwitch.init();
		lightSwitch.enter();
		
		String result = null;
		DatagramChannel receivingChannel = DatagramChannel.open();

		SocketAddress receivingSocket = new InetSocketAddress(InetAddress.getLoopbackAddress(), 8888);
		InetSocketAddress sendingSocket = new InetSocketAddress(InetAddress.getLoopbackAddress(), 9999);

		receivingChannel.socket().bind(receivingSocket);
		receivingChannel.configureBlocking(false);
		receivingChannel.connect(sendingSocket);

		ByteBuffer packet = ByteBuffer.allocate(1024);
		packet.clear();
		System.out.println(((InetSocketAddress) receivingSocket).getAddress() + ":" + ((InetSocketAddress) receivingSocket).getPort());

		
		
		while (true)
		{
			if (receivingChannel.receive(packet) != null)
			{
				System.out.println("XXX");
				result = new String(packet.array());
			}
			System.out.println(result);
//			
//			String incomingMessage = receive.receive(false);
//			System.out.println("Msg: " + incomingMessage);
//			if (incomingMessage != null && incomingMessage.equals("Klick"))
//			{
//				System.out.println("Switch klicked");
//				lightSwitch.getSCIUser().raiseOperate();
//			}
//			lightSwitch.runCycle();
			Thread.sleep(500);
		}
	}
}
