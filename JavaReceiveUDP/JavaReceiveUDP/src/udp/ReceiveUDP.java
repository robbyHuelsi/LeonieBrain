package udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class ReceiveUDP
{
	private InetAddress host;
	private int port;

	// private static String serverChannel = "serverChannel";
	// private static String channelType = "channelType";

	public ReceiveUDP(InetAddress host, int port)
	{
		super();
		this.host = host;
		this.port = port;
	}

	public String receive(boolean block) throws Exception
	{
		String result = null;
		DatagramChannel receivingChannel = DatagramChannel.open();

		SocketAddress receivingSocket = new InetSocketAddress(InetAddress.getLoopbackAddress(), 8888);
		InetSocketAddress sendingSocket = new InetSocketAddress(InetAddress.getLoopbackAddress(), 9999);

		receivingChannel.socket().bind(receivingSocket);
		receivingChannel.configureBlocking(block);
		receivingChannel.connect(sendingSocket);

		ByteBuffer packet = ByteBuffer.allocate(1024);
		packet.clear();
		System.out.println(((InetSocketAddress) receivingSocket).getAddress() + ":" + ((InetSocketAddress) receivingSocket).getPort());

		if (receivingChannel.receive(packet) != null)
		{
			System.out.println("XXX");
			result = new String(packet.array());
		}
		System.out.println(result);
		receivingChannel.close();

		return result;
	}

	// public String receive()
	// {
	// DatagramPacket request = null;
	// try
	// {
	// DatagramSocket socket = new DatagramSocket(port, host);
	//
	// byte[] receiveData = new byte[1024];
	// request = new DatagramPacket(receiveData, receiveData.length);
	//
	// socket.receive(request);
	//
	// socket.close();
	// } catch (UnknownHostException e)
	// {
	// System.err.println("Host Adress not found!");
	// e.printStackTrace();
	// } catch (SocketException e)
	// {
	// System.err.println("Socket creation error!");
	// e.printStackTrace();
	// } catch (IOException e)
	// {
	// System.err.println("Error on receiving package!");
	// e.printStackTrace();
	// }
	//
	// return new String(request.getData(), request.getOffset(), request.getLength());
	// }

}
