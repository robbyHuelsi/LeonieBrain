package communication;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
	private ServerSocket welcomeSocket = null;
	private Socket socket = null;

	/**
	 * Opens a socket to incoming connections on specified device and port
	 * 
	 * @param myIP the IP of the device we want to listen to, null if all available devices can be used
	 * @param myPort the port we listen to
	 * @param backlog the size of the message queue
	 * @param keepAlive true if after 2h of no com the connection should be kept alive 
	 */
	public TCPServer(InetAddress myIP, int myPort, int backlog, boolean keepAlive)
	{
		try
		{
			welcomeSocket = new ServerSocket(myPort, backlog, myIP);
			socket = welcomeSocket.accept();
			socket.setKeepAlive(keepAlive);
			System.out.println("Connection established to: " + socket.getInetAddress() + ":" + socket.getPort());
		} catch (IOException e)
		{
			System.err.println("Error on connecting to: " + myIP + ":" + myPort + ", queue size: " + backlog);
			e.printStackTrace();
		}
	}

	public boolean endConnection()
	{
		if (welcomeSocket == null || socket == null)
			return false;
		try
		{
			socket.close();
			welcomeSocket.close();
		} catch (IOException e)
		{
			System.err.println("Error closing sockets!");
		}
		return true;
	}

	public boolean send(String message)
	{
		try
		{

			DataOutputStream outToClient = new DataOutputStream(socket.getOutputStream());
			outToClient.writeBytes(message+"\n");
		} catch (IOException e)
		{
			System.err.println("Sending impossible, connection errors");
			// e.printStackTrace();
			return false;
		}

		return true;
	}

	public String receive()
	{
		try
		{
			BufferedReader inFromClient = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			System.out.println("!");
			String message = inFromClient.readLine();
			return message;
		} catch (IOException e)
		{
			System.err.println("Receiving impossible, connection errors");
			// e.printStackTrace();
			return null;
		}
	}

}
