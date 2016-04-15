package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.UnknownHostException;

import udp.UDPConnection;

public class Test
{

	public static void main(String[] args)
	{
		UDPConnection udpConnection = new UDPConnection();

		// Receive
		try
		{
			while (true)
				System.out.println("R: " + udpConnection.receiveSocket(InetAddress.getLocalHost(), 8888).trim());
		} catch (UnknownHostException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Send
			//Ignore: user input stuff
		BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
		String sentence = null;

		while (true)
		{
			try
			{
				System.out.println("Type message: ");
				sentence = inFromUser.readLine();
			} catch (IOException e1)
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			//END Ignore
			udpConnection.sendSocket(sentence, InetAddress.getLoopbackAddress(), 8888);
		}
	}

}
