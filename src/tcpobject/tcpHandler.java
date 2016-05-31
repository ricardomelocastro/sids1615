package tcpobject;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import db.*;
import utils.*;
import protocols.*;

public class tcpHandler extends Thread {
	private Db db;
	private volatile Queue<Message> waitList= new LinkedList <Message>();
	
	public tcpHandler(Db db){
		this.db =db;
	}
	
	public void addMessage(Message m){
		waitList.add(m);
	}
	
	
	public void run() {
		
		System.out.println("tcpHandler running");
		boolean running = true;
		while(running){
			
			if(!waitList.isEmpty()){
				System.out.println("NOT EMPTY");
				Message m = waitList.remove();
				if(m.value==1){
					new saveDbProtocol(m, db).start();
				}
				if(m.value==2){
					
				}
				
			}
			
			
		}
		
	}
	
}
