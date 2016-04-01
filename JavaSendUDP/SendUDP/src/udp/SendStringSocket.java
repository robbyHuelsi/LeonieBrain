package udp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class SendStringSocket {
	
	private DatagramSocket socket;

	/**
	 * 
	 * @param message the Message
	 * @param targetAdress IP adress of the target
	 * @param targetPort Port of the target
	 */
	public void send(String message, InetAddress targetAdress, int targetPort)
	{
		DatagramPacket request = null;
		try
		{
			socket = new DatagramSocket();
			byte[] sendData = message.getBytes();

			request = new DatagramPacket(sendData, sendData.length, targetAdress, targetPort);
			socket.send(request);
		} catch (SocketException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Packet versendet: " + request.getAddress() + ":" + request.getPort() + " -> "
				+ new String(request.getData()));
	}

	public static void main(String[] args) {
		System.out.println("Starting...");

		BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
		String sentence = null;

		while (true) {
			try {
				System.out.println("Type message: ");
				sentence = inFromUser.readLine();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			try
			{
				new SendStringSocket().send(sentence, InetAddress.getByName("134.103.120.108"), 8888);
			} catch (UnknownHostException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
