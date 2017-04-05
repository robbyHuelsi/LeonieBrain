package callbacks;



import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Random;

import org.yakindu.scr.brain.IBrainStatemachine.SCIBGF;
import org.yakindu.scr.speechandpersonrecognition.ISpeechAndPersonRecognitionStatemachine.SCIHBrain;
import org.yakindu.scr.speechandpersonrecognition.ISpeechAndPersonRecognitionStatemachine.SCISTT;
import org.yakindu.scr.speechandpersonrecognition.ISpeechAndPersonRecognitionStatemachine.SCIUdpInterface;
import org.yakindu.scr.speechandpersonrecognition.ISpeechAndPersonRecognitionStatemachine.SCIUdpInterfaceOperationCallback;
import org.yakindu.scr.speechandpersonrecognition.ISpeechAndPersonRecognitionStatemachine.SCIVBrain;
import org.yakindu.scr.speechandpersonrecognition.ISpeechAndPersonRecognitionStatemachine.SCIVBrainOperationCallback;
import org.yakindu.scr.speechandpersonrecognition.ISpeechAndPersonRecognitionStatemachine.SCInterface;

import communication.*;
import main.Start;
import modules.Module;
import modules.Modules;
import vBrain.PersonList;

public class OpCallbackImpl2 implements SCIHBrain, SCInterface, SCIUdpInterfaceOperationCallback, SCISTT, SCIVBrainOperationCallback
{
	private PersonList personList = Start.getPersonList();
	private Modules modules = Start.getModules();
	private TCPServer serverTCP;
	private boolean TTSFinished;
	
	

	
	// ---- UDP/TCP Interface ----------------------- //
	
	public void receive(long connection){
		//connection==0: UDP
		if(connection==0){
			/* UDP establish connection & receive */
			String result = null;
			UDPConnection  udpConnection = new UDPConnection();
					
			try{
				udpConnection.receiveSocket(InetAddress.getByName(modules.getIp("Brain")), modules.getPort("Brain"), true);
				result = udpConnection.getMessage();
				System.out.println(InetAddress.getByName(modules.getIp("Brain"))+"X:" + result);
//				udpConnection.setRunThread(false);
			} catch (UnknownHostException e){
				e.printStackTrace();
			}
			//connection==1: TCP
		}else if(connection==1){
			Socket s1=null;
			InetAddress address;
			if(serverTCP==null){
				try {
					System.out.println(InetAddress.getByName(modules.getIp("Brain"))+"X:");
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
	}
	
	
	
	//@param module: module is targetmodule 
	private boolean sendMessage(String text, Module module){
		if (module == null) {
			return false;
		}
		if(module.getUdpTcp()==0){
		UDPConnection  udpConnection = new UDPConnection();
		try
		{
//			udpConnection.sendSocket(Start.instanceOf().getBrain().getSCIUdpInterface().getMessage(), InetAddress.getByName("134.103.120.108"), 8888);
			udpConnection.sendSocket(text, InetAddress.getByName(module.getIp()), module.getPort());
		} catch (UnknownHostException e) {
			e.printStackTrace();
			return false;
		//		System.out.println(Test.instanceOf().getTestBrain().getSCIUdpInterface().getData());
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
	
	
	
	
	

	@Override
	public boolean getSTTReady() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setSTTReady(boolean value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getSpeakerMsg() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setSpeakerMsg(String value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getFilteredMsg() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setFilteredMsg(String value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getFilterBubble() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setFilterBubble(String value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sendToVBrain_ACIonOff(boolean inOnOff) {
		System.out.println(inOnOff?"ACI on":"ACI off");
		this.sendMessage(inOnOff?"#VBRAIN#1#":"#VBRAIN#0#", modules.get("VBrain"));
		this.sendMessage("#TRACRESET#", modules.get("TrackingZoomC"));
		this.sendMessage("#TRACRESET#", modules.get("TrackingWaC"));
	}

	@Override
	public void sendToHBrain_TTS(String inText) {
		this.sendMessage("#HBRAIN##TEXT#" + inText , modules.get("HBrain")); 
		// # removed cause Leonie reads out the hash too		
	}

	@Override
	public void sendToHBrain_TTS2(String inT1, String inT2) {
		this.sendToHBrain_TTS(inT1 + inT2);
	}

	@Override
	public void sendToHBrain_TTS3(String inT1, String inT2, String inT3) {
		this.sendToHBrain_TTS(inT1 + inT2 + inT3);		
	}

	@Override
	public void sendToHBrain_TTS_num(long inNum) {
		this.sendMessage("#HBRAIN##TEXT#" + inNum , modules.get("HBrain")); 
		// # removed cause Leonie reads out the hash too		
	}

	@Override
	public void sendToHBrain_TTSWithPos(String inPos, String inText) {
		sendToHBrain_TTS("{0;" + inPos + "}" + inText);		
	}

	@Override
	public void sendToHBrain_PersonPosition() {
		
	}

	@Override
	public void sendToKinect2_detectionOnOff(boolean inOnOff) {
		this.sendMessage("#NOISEDETECTION#" + (inOnOff?"1":"0") + "#", modules.get("NoiseDetection"));
		
	}

	@Override
	public void sendToLeapMotion_detectionOnOff(long inOnOff) {
		this.sendMessage("#HANDGESTURES#" + (int)inOnOff + "#", modules.get("HandGestures"));		
	}

	@Override
	public void sendToSTT_detectionOnOff(long inOnOff) {
		this.sendMessage("#STT#" + (inOnOff==0?"0":(inOnOff==1?"1":(inOnOff==2?"yesno":"name"))) + "#", modules.get("STT"));
		if(inOnOff != 0){
			Start.instanceOf().getBrain().getSCISTT().setSTTReady(false);
			Start.instanceOf().getBrain().getSCISTT().setSpeakerMsg("");
			Start.instanceOf().getBrain().getSCISTT().setFilteredMsg("");
		}		
	}

	@Override
	public void sendToNav_goToGWP(long inWayPoint) {
		System.out.println("Go to global way point " + inWayPoint);
		this.sendMessage("#NAV##GWP#" + inWayPoint + "#", modules.get("Mira"));		
	}

	@Override
	public void sendToNav_goToNextGWPForConf() {
		SCIBGF BGF = Start.instanceOf().getBrain().getSCIBGF();
		
		if(BGF.getEventNum() == 0){
			this.sendToNav_goToGWP(0);
		}else if(BGF.getEventNum() <= 3){
			this.sendToNav_goToGWP(BGF.getEventNum());
		}else if(BGF.getEventNum() <= 6){
			this.sendToNav_goToGWP(BGF.getEventNum() - 3);
		}else{
			this.sendToNav_goToGWP(0);
		}		
	}

	@Override
	public void sendToNav_turnBody(String inAngle) {
		System.out.println("Turn Body: angle=" + inAngle);
		this.sendMessage("#NAV##ROTBODY#" + inAngle + "#", modules.get("Mira"));
	}

	@Override
	public void sendToNav_bodyUTurn() {
		this.sendMessage("#NAV##ROTBODY#90#", modules.get("Mira"));
		try {
			Thread.sleep(820);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.sendMessage("#NAV##ROTBODY#90#", modules.get("Mira"));
	}

	@Override
	public void sendToNav_turnHead(String inAngle) {
		  System.out.println("Turn Body: angle=" + inAngle);
		  this.sendMessage("#NAV##ROTHEAD#" + inAngle + "#", modules.get("Mira"));
	}

	@Override
	public void sendToNav_goToLC(String inX, String inY) {
		System.out.println("Go to local coordinates: x=" + inX + ", y=" + inY);
		this.sendMessage("#NAV##LC#" + inX + ";" + inY + ";#", modules.get("Mira"));
	}

	@Override
	public void sendToNav_searchOnOff(boolean inOnOff) {
		System.out.println(inOnOff?"Moving from WP to WP":"Standing");
		this.sendMessage("#NAV##RUN#" + (inOnOff?"1":"0") + "#", modules.get("Mira"));
//		this.sendToHBrain_TTS("[idle2:" + (inOnOff?"true":"false") + "]");
	}

	@Override
	public void savePersonList() {
		// TODO Auto-generated method stub
	}

	@Override
	public boolean getTTSReady() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setTTSReady(boolean value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean getTTSFinished() {
		this.sendMessage("#TTS#finished", modules.get("TTS"));
		return TTSFinished;
	}

	@Override
	public void setTTSFinished(boolean value) {
		this.TTSFinished=value;
	}
	
}
