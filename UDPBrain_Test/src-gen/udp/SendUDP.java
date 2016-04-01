package udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.net.SocketException;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;

public class SendUDP
{
	private InetAddress senderAdress;
	private int senderPort;

	/**
	 * 
	 * @param senderAdress Adress of the interface from which to send the data
	 * @param senderPort Port from which to send
	 */
	public SendUDP(InetAddress senderAdress, int senderPort)
	{
		this.senderAdress = senderAdress;
		this.senderPort = senderPort;
	}

	/**
	 * 
	 * @param text the text to be send
	 * @param targetAdress the adress of the target
	 * @param targetPort the port of the target
	 */
	public void sendChannel(String text, InetAddress targetAdress, int targetPort)
	{
		SocketAddress receivingSocket = new InetSocketAddress(targetAdress, targetPort);
		SocketAddress sendingSocket = new InetSocketAddress(senderAdress, senderPort);

		ByteBuffer packet = ByteBuffer.allocate(1024);

		try
		{
			DatagramChannel channel = DatagramChannel.open();
			channel.socket().bind(sendingSocket);
			channel.connect(receivingSocket);

			packet.clear();
			packet.put(text.getBytes());
			packet.flip();

			if (channel.send(packet, receivingSocket) > 0)
				System.out.println("Packet versendet: " + ((InetSocketAddress) sendingSocket).getAddress() + ":" + ((InetSocketAddress) sendingSocket).getPort()
						+ " -> " + new String(packet.array()));

			channel.close();
		} catch (SocketException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @param message the Message
	 * @param targetAdress IP adress of the target
	 * @param targetPort Port of the target
	 */
	public void sendSocket(String message, InetAddress targetAdress, int targetPort)
	{
		DatagramSocket socket;
		
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
}
