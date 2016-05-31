package tcpobject;

import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

import db.Db;
import utils.Message;

public class ServerSide {
	
	Db db;
	public ServerSide(){
		db = new Db();
		db.startDb();
	}
		
		
	 public static void main(String args[]) { 
		 
		 Db db = new Db();
		 db.startDb();
		 
		  int port = 2002;
		  tcpHandler th= new tcpHandler(db);
		  th.start();
		  try {  
		    ServerSocket ss = new ServerSocket(port); 
		    Socket s; 
		    java.io.InputStream is;
		    ObjectInputStream ois;
		    
		    boolean running = true;
		    while(running){
		    	s = ss.accept();
		    	is = s.getInputStream();
			    ois = new ObjectInputStream(is);
			    Message to = (Message)ois.readObject();
			    String ipsender = s.getRemoteSocketAddress().toString();
			    ipsender = ipsender.replace("/", "").split(":")[0];
			    
			    System.out.println(ipsender);
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
