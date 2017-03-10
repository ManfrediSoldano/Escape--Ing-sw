package it.polimi.ingsw.cg_10.controller.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * @author Manfredi
 *
 */
public interface SubscriberInterface extends Remote {
	
	public void dispatchMessage(String msg) throws RemoteException;
	public String getUsername()throws RemoteException;
	public int getRoom()throws RemoteException;
	public void setRoom(int room)throws RemoteException;
}
