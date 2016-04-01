package udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ReceiveString {

	public static void main(String[] args) {
		DatagramSocket socket;
		byte[] receiveData = new byte[1024];
		
		System.out.println("Starting...");
		try {
			InetAddress host = InetAddress.getByName("134.103.109.51");
			int port = 9999;
			
			socket = new DatagramSocket(port, host);

			DatagramPacket request = new DatagramPacket(receiveData, receiveData.length);
			while (true) {
				socket.receive(request);
				System.out.println("Packet empfangen: " + request.getAddress() + ":" + request.getPort() + " -> "
						+ new String(request.getData(), request.getOffset(), request.getLength()));
			}

		} catch (IOException e) {
			System.err.println("ioError\n" + e);
		}
	}
}
