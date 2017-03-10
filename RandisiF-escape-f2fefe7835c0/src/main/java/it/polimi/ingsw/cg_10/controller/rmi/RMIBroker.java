package it.polimi.ingsw.cg_10.controller.rmi;

import it.polimi.ingsw.cg_10.controller.rmi.BrokerInterface;
import it.polimi.ingsw.cg_10.controller.rmi.SubscriberInterface;
import it.polimi.ingsw.cg_10.controller.server.ServerGameCentral;
import it.polimi.ingsw.cg_10.model.player.Player;
import it.polimi.ingsw.cg_10.model.player.Room;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.NoSuchElementException;


/**
 * @author Manfredi
 *
 */
public class RMIBroker implements BrokerInterface {

	private ArrayList<SubscriberInterface> subscribers = new ArrayList<SubscriberInterface>();
	private ServerGameCentral sgc;

	public RMIBroker(ServerGameCentral sgc) {
		this.sgc=sgc;
	}

	public void startConnection() {
		try {

			
			Registry registry = LocateRegistry.createRegistry(8000);

			
			BrokerInterface stub = (BrokerInterface) UnicastRemoteObject.exportObject(this, 0);

			
			registry.rebind("Broker", stub);
						

		} catch ( RemoteException | NoSuchElementException e) {}
	}

	/**
	 * 
	 * @param msg
	 *            - message to be published to all the subscribers This is not a
	 *            remote method, however it calls the remote method
	 *            dispatchMessage for each Subscriber.
	 * @throws RemoteException 
	 */
	public void publish(String msg, int room) throws RemoteException {
	
		ArrayList<SubscriberInterface> temp = new ArrayList<SubscriberInterface>();
		for (SubscriberInterface sub : subscribers) {
				temp.add(sub);
		}
		 if (!subscribers.isEmpty()) {
			for (SubscriberInterface sub : subscribers) {
				boolean isAliveb = isAlive(sub);
				if (!isAliveb) {
					temp.remove(sub);
				}
			}
		}
		 
		 subscribers=temp;
		
		if (!subscribers.isEmpty()) {
			//System.out.println("Publish");
			for (SubscriberInterface sub : subscribers) {
				System.out.println(sub.getRoom());
				if (sub.getRoom() == room) {
					try {
						System.out.println("Dentro al room");
						//System.out.println(Integer.toBinaryString(sub.getRoom()));
						sub.dispatchMessage(msg);
					} catch (RemoteException e) {}
				}
			
			}
		} 
	}

	
	private boolean isAlive(SubscriberInterface sub) {
		try{
			sub.getUsername();
			return true;
		}catch(Exception exc){
			return false;
		}
		
	}

	/**
	 * @param r is the Subcriber's remote interface that the broker can use to publish messages
	 * The method updates the list of subscriber interfaces that are subscribed to the broker
	 * @throws RemoteException 
	 */
	@Override
	public void subscribe(SubscriberInterface r) {
		for(Room room: sgc.getRm()) {
			 
	      ArrayList<Player> ap = room.getArrayList();
	      for (Player player: ap){
	    	  
	    	  try {
				if (player.getPlayerName().equals(r.getUsername())){
					  r.setRoom(room.getID());
					  subscribers.add(r);
					  System.out.println("Subscriber added");
				  }
			} catch (RemoteException e) {}
	      }
		}
		
	}
	public void exit(){
	}



}
