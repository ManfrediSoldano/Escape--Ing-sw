package it.polimi.ingsw.cg_10.controller.socket;
	import it.polimi.ingsw.cg_10.model.com.ComAction;



import java.io.IOException;
import java.net.Socket;
	

	/**
	 * @author Manfredi
	 *
	 */
	public class Client {
		private String ip;
	    private int port;
	    Socket socket;
	    SocketCommunicator server;
	   
	    public Client(String ip, int port) {
	        this.ip = ip;
	        this.port = port;
		}
		
		public void startClient() {
			try {

	            socket = new Socket(ip, port);
	            server = new SocketCommunicator(socket);


	        } catch (IOException ex) {
	            throw new AssertionError("Weird errors with I/O occured, please verify environment config", ex);
	        }
			
		}
		
		
		public ComAction sendCommand(ComAction comaction){
			 
			 server.send(comaction.serialize());			
			 ComAction risp=new ComAction();
			
             return risp= risp.deserialize(server.receive());

		}
		
	
		
		public void close(){
            server.close();
		}

	
		
		
	}
		



