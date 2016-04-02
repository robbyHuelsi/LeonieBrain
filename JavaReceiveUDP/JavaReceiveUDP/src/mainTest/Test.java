package mainTest;

import java.net.InetAddress;
import java.net.UnknownHostException;

import udp.ReceiveUDP;

public class Test
{
	public static void main(String[] args) throws Exception
	{
		ReceiveUDP receiveUDP = null;
		try
		{
			receiveUDP = new ReceiveUDP(InetAddress.getByName("134.103.109.51"), 8888);
		} catch (UnknownHostException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		while (true)
				System.out.println(receiveUDP.receiveSocket().trim());
	}
}