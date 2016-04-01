package udp;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;

public class ReceiveStringChannel {

	public static void main(String[] args) throws IOException {
		String result = null;
		DatagramChannel receivingChannel = DatagramChannel.open();

		SocketAddress receivingSocket = new InetSocketAddress(InetAddress.getLoopbackAddress(), 8888);
		InetSocketAddress sendingSocket = new InetSocketAddress(InetAddress.getLoopbackAddress(), 9999);

		// channel.bind(target);
		// channel.connect(target);
		// System.out.println(channel.isConnected());
		receivingChannel.socket().bind(receivingSocket);
		receivingChannel.configureBlocking(false);
		receivingChannel.connect(sendingSocket);

		ByteBuffer packet = ByteBuffer.allocate(1024);
		packet.clear();
		System.out.println(((InetSocketAddress) receivingSocket).getAddress() + ":"
				+ ((InetSocketAddress) receivingSocket).getPort());
		while (true) {
			// receivingChannel.read(packet);
			if (receivingChannel.receive(packet) != null) {
				result = new String(packet.array());
			}
			System.out.println(result);
		}
	}
}
