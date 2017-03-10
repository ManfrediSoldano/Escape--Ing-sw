package it.polimi.ingsw.cg_10.controller.client;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Observable;

import it.polimi.ingsw.cg_10.controller.rmi.RClient;
import it.polimi.ingsw.cg_10.controller.rmi.RMISubscriber;
import it.polimi.ingsw.cg_10.controller.socket.Client;
import it.polimi.ingsw.cg_10.controller.socket.SubscriberThread;
import it.polimi.ingsw.cg_10.model.com.ComAction;
import it.polimi.ingsw.cg_10.model.game.Game;

/**
 * @author Manfredi
 *
 */
public class Communication extends Observable{

	private String type;
	private Client client;
	private RClient rclient;
	private RMISubscriber subRMI;
	SubscriberThread st;
	
	public Communication(String type) {
		this.type= type;
	}
	

	public void getConnection()
	{
		if(type=="Socket")
		{
			client = new Client("127.0.0.1", 1337);
		    client.startClient();
		   
		}
		else if(type=="RMI"){
			
			try {
				rclient = new RClient();
			} catch (RemoteException | NotBoundException e) {
				
				throw new AssertionError("Errore #3: Errore inizializzazione connessione RMI."+ e);

			}
			
		}
		else{
			throw new AssertionError("Errore #3: Errore nella scelta del tipo di comunicazione, riprova.");
		}
	}
	
	public void subscribe(String username){
		 
		    if(type=="Socket")
			{
		    	st = new SubscriberThread(username,this);
			    st.start();
			   
			}
			else if(type=="RMI"){
				
				subRMI=new RMISubscriber(username,this);
				subRMI.getconnection();
				
				
			}
			else{
				throw new AssertionError("Errore #3: Errore nella scelta del tipo di comunicazione, riprova.");
			}
	}
	
	public ComAction sendMessage(ComAction comaction){
		if(type=="Socket")
		{
		   return client.sendCommand(comaction);
		}
		else{
			return rclient.setCommand(comaction);
			
		}
		
	}

	public void receivedFromPublisher(String game) {
	
		Game receviedGame = new Game();
		receviedGame = receviedGame.deserialize(game);
		System.out.println("ricevuto game");
		setChanged();
		
		if(receviedGame!=null)
			notifyObservers(receviedGame);
		else
			System.out.println(game);
			notifyObservers(game);
	}

	public void close(){
		if(type=="Socket")
		{
			 client.close();
			 st.close();
		   
		   
		}
		else if(type=="RMI"){
			
			
		}
	}

}
