package it.polimi.ingsw.cg_10.controller.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * @author Manfredi
 *
 */
public interface BrokerInterface extends Remote {

	public void subscribe(SubscriberInterface r) throws RemoteException;
	
}
