package it.polimi.ingsw.cg_10.controller.rmi;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import it.polimi.ingsw.cg_10.controller.client.Communication;
import it.polimi.ingsw.cg_10.controller.rmi.SubscriberInterface;

/**
 * @author Manfredi
 *
 */
public class RMISubscriber implements SubscriberInterface {
	private String username;
	private int room;
	private Communication communication;
	/**
	 * 
	 * @param username The name of the subscriber
	 * @param communication 
	 */
	public RMISubscriber(String username, Communication communication) {
		super();
		this.username=username;
		this.communication = communication;
		
	}

	public void getconnection(){
	 try {
     	
     	
     	//LocateRegistry class provides static methods for synthesizing 
     	//a remote reference to a registry at a particular network 
     	//address (host and port). In this case 'localhost' is assumed.
     	//The no-argument overload of getRegisry uses port 1099
 		Registry registry = LocateRegistry.getRegistry(8000);
 		
 		//lookup method searches for the remote interface binded to name "Broker" 
 		//in the server host's registry
			BrokerInterface broker = (BrokerInterface) registry.lookup("Broker");
			
			//subscriber exports its own remote interface SubscriberInterface so that it can 
			//receive invocations from remote brokers.
			//Then it invokes subscribe remote method of the BrokerInterface and passes it's 
			//own remote interface as a parameter. 
			broker.subscribe((SubscriberInterface)UnicastRemoteObject.exportObject(this,0));
			//System.out.println("Di qui passa");
		} catch (NotBoundException| RemoteException e) {
			e.printStackTrace();
		}
	}
	
	
	
	/**
	 * @param msg is the message sent by the broker by invoking subscriber's remote interface
	 * the method simply prints the message received by the broker
	 */
	@Override
	public void dispatchMessage(String msg) {
		communication.receivedFromPublisher(msg);
	}

	@Override
	public String getUsername() throws RemoteException {
		return username;
	}

	@Override
	public int getRoom() throws RemoteException {
		return room;
	}

	@Override
	public void setRoom(int room) throws RemoteException {
	this.room=room;
		
	}

}
