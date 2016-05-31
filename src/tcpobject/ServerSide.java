package tcpobject;

import java.net.InetAddress;
import java.net.UnknownHostException;

import db.Db;


public class ServerSide {
	
	private Db db;
	private String ip;
	private int tcpPort;
	
	public ServerSide(int tcpPort){

		this.tcpPort = tcpPort;
	}
		
	 public void go() { 
		 System.out.println("Starting Server");
		 
		 this.db = new Db();
		 db.startDb();
		 
		 System.out.println(db.getLastRecordDate());
		 
		 String ip;
		 
		 try {
			ip = InetAddress.getLocalHost().getHostAddress();
			System.out.println(ip);
			this.ip = ip;
			System.out.println(this.ip);
			 System.out.println("IP");
			 
			 TCPServer tcpServer = new TCPServer(this.db, this.ip,this.tcpPort);
			 tcpServer.start();
			 
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		 
		 
		 
		 
	 }
}
