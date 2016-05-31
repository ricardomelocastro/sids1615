package tcpobject;

import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

import db.Db;
import utils.Message;

public class TCPServer extends Thread{
	
	Db db;
	int tcpPort;
	String localIp;
	
	public TCPServer(Db db, String localIP, int tcpPort){
		this.db = db;
		this.tcpPort = tcpPort;
		this.localIp = localIp;
	}
	
	public void run(){
		
		
		tcpHandler th= new tcpHandler(db, localIp);
		th.start();
		
		try {  
		    ServerSocket ss = new ServerSocket(this.tcpPort); 
		    Socket s; 
		    java.io.InputStream is;
		    ObjectInputStream ois;
		    
		    boolean running = true;
		    while(running){
		    	s = ss.accept();
		    	is = s.getInputStream();
			    ois = new ObjectInputStream(is);
			    Message to = (Message)ois.readObject();
			    
			    /*String ipsender = s.getRemoteSocketAddress().toString();
			    ipsender = ipsender.replace("/", "").split(":")[0];
			    to.addSenderIp(ipsender);*/
			    
			    th.addMessage(to);
			    
			    ois.close();
			    s.close();  
			    
		    } 
		    
		    ss.close();  
		}catch(Exception e){
			System.out.println(e);
			e.printStackTrace();}  
		}
}
