package communication;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

import main.Log;

public class UDPConnection
{
	private boolean runThread = true;
	private String message = "";

	public String getMessage()
	{
		return message.trim();
	}
	
	public boolean isRunThread()
	{
		return runThread;
	}

	public void setRunThread(boolean runThread)
	{
		this.runThread = runThread;
	}

	/**
	 * Receives String from UDP
	 * 
	 * @param myAdress
	 *            the IP Adress from the interface I want to receive from
	 * @param myPort
	 *            the Port I want to listen to
	 * @return the received message
	 */
	public void receiveSocket(InetAddress myAdress, int myPort, boolean useThread){
		if (!useThread)
		{
			DatagramPacket request = null;
			try
			{
				DatagramSocket socket = new DatagramSocket(myPort, myAdress);

				byte[] receiveData = new byte[1024];
				request = new DatagramPacket(receiveData, receiveData.length);

				socket.receive(request);

				message = new String(request.getData(), request.getOffset(), request.getLength());

				socket.close();
			} catch (UnknownHostException e)
			{
				System.err.println("Host Adress not found!");
				e.printStackTrace();
			} catch (SocketException e)
			{
				System.err.println("Socket creation error!");
				e.printStackTrace();
			} catch (IOException e)
			{
				System.err.println("Error on receiving package!");
				e.printStackTrace();
			}

		} else
		{
			Thread t = new Thread(new Runnable()
			{
				public void run()
				{
					try
					{
						DatagramSocket socket = new DatagramSocket(myPort, myAdress);
						byte[] receiveData = new byte[1024];
						DatagramPacket request = new DatagramPacket(receiveData, receiveData.length);

						while (isRunThread())
						{
							socket.receive(request);
							message = new String(request.getData(), request.getOffset(), request.getLength());
							//trim() trims whitespace from the beginning and end of a string
							//if String is just whitespace, then a new String object representing an empty string is created and returned
							MessageParser.ParseMessage(message.trim());
						}
						socket.close();
					} catch (IOException e)
					{
						e.printStackTrace();
					}
				}
			});
			t.start();
		}
	}

	/**
	 * Send message via UDP
	 * 
	 * @param message
	 *            the Message
	 * @param targetAdress
	 *            IP adress of the target
	 * @param targetPort
	 *            Port of the target
	 */
	public void sendSocket(String message, InetAddress targetAdress, int targetPort, Log log)
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
			e.printStackTrace();
		} catch (IOException e)
		{
			e.printStackTrace();
		}

		log.log("Packet versendet: " + request.getAddress() + ":" + request.getPort() + " -> "
				+ new String(request.getData()));
	}
}