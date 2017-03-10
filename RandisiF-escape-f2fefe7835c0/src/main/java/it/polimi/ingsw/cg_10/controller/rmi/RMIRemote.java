package it.polimi.ingsw.cg_10.controller.rmi;
import it.polimi.ingsw.cg_10.model.com.ComAction;
import it.polimi.ingsw.cg_10.model.deck.Deck;
import it.polimi.ingsw.cg_10.model.map.Coordinate;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * @author Manfredi
 *
 */
public interface RMIRemote extends Remote {

	public ComAction newPlayer(String nome) throws RemoteException;
	public ComAction useCard(String username, int cardIdx) throws RemoteException;
	public ComAction newAttack(String username, Coordinate coordinata)throws RemoteException;
	public ComAction newChat(String testo, String username) throws RemoteException;	
	public ComAction setRoom(int room, String username, Boolean newRoom,Boolean advancedgame, String mappa) throws RemoteException;
	public ComAction move(Coordinate coordinate, String username) throws RemoteException;
	public ComAction rumor(Coordinate coordinate, String username)throws RemoteException;
	public ComAction endTurn(String username)throws RemoteException;
	public ComAction drawCard(String username, Deck deck) throws RemoteException;

}
