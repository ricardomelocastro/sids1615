package tcpobject;

import db.Db;


public class ServerSide {
	
	private Db db;
	private String ip;
	private int tcpPort;
	
	public ServerSide(String ip,int tcpPort){

		this.tcpPort = tcpPort;
		this.ip = ip;
	}
		
	 public void go() { 
		 System.out.println("Starting Server");
		 
		 this.db = new Db();
		 db.startDb();
		 
		 System.out.println(db.getLastRecordDate());
		 	 
		 TCPServer tcpServer = new TCPServer(this.db, this.ip,this.tcpPort);
		 tcpServer.start();
		 
	 }
}
