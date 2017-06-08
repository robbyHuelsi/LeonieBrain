package communication;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import main.Log;
import modules.Module;

public class Communication {

	private static TCPServer serverTCP;
	
	public static void receive(Module brain, Log log) {
		/* UDP establish connection & receive */
		String result = null;
		UDPConnection  udpConnection = new UDPConnection();
		try{
			udpConnection.receiveSocket(InetAddress.getByName(brain.getIp()), brain.getPort(), true);
			result = udpConnection.getMessage();
			log.log("Listening UDP: " + InetAddress.getByName(brain.getIp())+":" + (brain.getPort()));
//				udpConnection.setRunThread(false);
		} catch (UnknownHostException e){
			e.printStackTrace();
		}
		
		//TCP CONNECTION
		Socket s1=null;
		InetAddress address;
		if(serverTCP==null){
			try {
				log.log("Listening TCP: " + InetAddress.getByName(brain.getIp())+":" + (brain.getPort()));
				serverTCP = new TCPServer();
			}catch (Exception e) {
				log.log("catch Op receive:");
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
	public static boolean sendMessage(String text, Module module, Log log){
		if (module == null) {
			return false;
		}
		if(module.getUdpTcp()==0){
			UDPConnection  udpConnection = new UDPConnection();
		
			try {
//					udpConnection.sendSocket(Start.instanceOf().getBrain().getSCIUdpInterface().getMessage(), InetAddress.getByName("134.103.120.108"), 8888);
				udpConnection.sendSocket(text, InetAddress.getByName(module.getIp()), module.getPort(), log);
			} catch (UnknownHostException e) {
				e.printStackTrace();
				return false;
//					log.log(Test.instanceOf().getTestBrain().getSCIUdpInterface().getData());
			}
		}else if(module.getUdpTcp()==1){
			if(serverTCP==null){
				try {
					serverTCP = new TCPServer();
				}catch (Exception e) {
					log.log("Exception in OpCallbackImpl: sendMessage if");
					e.printStackTrace();
				}
				TCPClient client = new TCPClient(text, module);
			}
		}
		return true;
	}
}
