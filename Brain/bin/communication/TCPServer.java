package communication;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
	
	public TCPServer(){
	    Thread t = new Thread(new Runnable(){
			@Override
			public void run(){
				ServerSocket ss2 = null;
				try{
			    	ss2 = new ServerSocket(8889); // can also use static final PORT_NUM , when defined
			    	 System.out.println("Server Listening......");
			    }catch(IOException e){
			    e.printStackTrace();
			    System.out.println("Server error");
			    }
				while(ss2!=null){
					try{
						Socket s= ss2.accept();
						System.out.println("connection Established");
						ServerThread st=new ServerThread(s);
						st.start();
					}catch(Exception e){
						e.printStackTrace();
						System.out.println("Connection Error");
					}
				}
			}
	    });
	    t.start();
	}
}
