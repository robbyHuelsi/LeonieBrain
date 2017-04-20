package communication;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import modules.Module;

public class Communication {

	private static TCPServer serverTCP;
	
	public static void receive(Module brain) {
		/* UDP establish connection & receive */
		String result = null;
		UDPConnection  udpConnection = new UDPConnection();
		try{
			udpConnection.receiveSocket(InetAddress.getByName(brain.getIp()), brain.getPort(), true);
			result = udpConnection.getMessage();
			System.out.println("Listening UDP: " + InetAddress.getByName(brain.getIp())+":" + (brain.getPort()));
//				udpConnection.setRunThread(false);
		} catch (UnknownHostException e){
			e.printStackTrace();
		}
		
		//TCP CONNECTION
		Socket s1=null;
		InetAddress address;
		if(serverTCP==null){
			try {
				System.out.println("Listening TCP: " + InetAddress.getByName(brain.getIp())+":" + (brain.getPort()));
				serverTCP = new TCPServer();
			}catch (Exception e) {
				System.out.println("catch Op receive:");
				e.printStackTrace();
			}
		}else{
			try {
				address=InetAddress.getLocalHost();
				s1=new Socket(address, 8889); 
			} catch (IOException e) {
				e.printStackTrace();
			}
		}	
	}
		
		
		
	//@param module: module is targetmodule 
	public static boolean sendMessage(String text, Module module){
		if (module == null) {
			return false;
		}
		if(module.getUdpTcp()==0){
			UDPConnection  udpConnection = new UDPConnection();
		
			try {
//					udpConnection.sendSocket(Start.instanceOf().getBrain().getSCIUdpInterface().getMessage(), InetAddress.getByName("134.103.120.108"), 8888);
				udpConnection.sendSocket(text, InetAddress.getByName(module.getIp()), module.getPort());
			} catch (UnknownHostException e) {
				e.printStackTrace();
				return false;
//					System.out.println(Test.instanceOf().getTestBrain().getSCIUdpInterface().getData());
			}
		}else if(module.getUdpTcp()==1){
			if(serverTCP==null){
				try {
					serverTCP = new TCPServer();
				}catch (Exception e) {
					System.out.println("Exception in OpCallbackImpl: sendMessage if");
					e.printStackTrace();
				}
				TCPClient client = new TCPClient(text, module);
			}
		}
		return true;
	}
}
