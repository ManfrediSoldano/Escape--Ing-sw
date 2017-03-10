package it.polimi.ingsw.cg_10.controller.socket;

import it.polimi.ingsw.cg_10.controller.server.ServerComunication;
import it.polimi.ingsw.cg_10.model.com.*;



	/**
	 * @author Manfredi
	 *
	 */
	public class ClientHandler extends Thread {
		private ServerComunication sc;
		private Communicator client;
		private ComAction command =new ComAction();
		public ClientHandler(Communicator c, ServerComunication sc) {
			client = c;
			this.sc = sc;
		}
		
		@Override
		public void run(){
			String a;
			while(true){
				try{
					
					a= client.receive();
					
				    // a= a+ "\n" +client.receive();
				    //System.out.println("convertendo");

					command =command.deserialize(a);
				
					if(command instanceof ComServerReply){
						a=((ComServerReply) command).getReply();
						}
						
				}
				catch(Exception exc){
				throw new AssertionError("Errore #2: C'è stato un problema di deserializzazione" + exc);
		        }
				String risposta;
				
				try{
	            ComAction serverreply = sc.setCommand(command);
	            if(serverreply!=null){
	        	risposta = serverreply.serialize();
	            }
	            else{
	            	risposta=null;
	            }
	            
				}
	            catch(Exception exc){
	            
	            	throw new AssertionError("Errore #2.1: C'è stato un problema di Serializzazione" + exc);
	            }
	            
	            reply(risposta);
			}
			//client.close();
	    }
		
		
		public void reply(String serverreply){
			client.send(serverreply);
            
		}
		
		

	}



