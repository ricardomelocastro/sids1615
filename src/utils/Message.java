package utils;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Message implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public int value;
	public String id;
	public ArrayList<dbLine> rs = new ArrayList<dbLine>();
	String senderIp;
	
	public Message(int v, String s){
		this.value = v;
		this.id = s;
		this.senderIp = "NULL";
		
	}
	
	public ArrayList<dbLine> getRs(){
		return this.rs;
	}
	
	public void addSenderIp(String Ip){
		this.senderIp = Ip;
	}
	
	
}