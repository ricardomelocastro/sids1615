package tcpobject;

public class Main {
	
	
	
	
	
	 public static void main(String args[]) { 
		 
		 if(args.length != 2){
			System.out.println("Usage: <localmachine ip> <TCPPort>");
			return;
		}
			
			
		int port = Integer.parseInt(args[1]);
		String ip = args[0];
		
		 ServerSide sv = new ServerSide(ip,port);
		 sv.go();
		 
	 }

}
