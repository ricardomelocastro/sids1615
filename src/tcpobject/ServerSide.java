package tcpobject;

import java.net.InetAddress;
import java.net.UnknownHostException;

import db.Db;


public class ServerSide {
	
	Db db;
	String ip;
	int tcpPort;
	
	public ServerSide(int tcpPort){

		this.tcpPort = tcpPort;
	}
		
	 public void go() { 
		 System.out.println("Starting Server");
		 
		 Db db = new Db();
		 db.startDb();
		 
		 try {
			this.ip = InetAddress.getLocalHost().getHostAddress();
			System.out.println(this.ip);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		 
		 TCPServer tcpServer = new TCPServer(this.db, this.ip,this.tcpPort);
		 tcpServer.start();
		 
		 
	 }
}
