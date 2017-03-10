package it.polimi.ingsw.cg_10.controller.rmi;

import it.polimi.ingsw.cg_10.model.com.ComAction;
import it.polimi.ingsw.cg_10.model.deck.Deck;
import it.polimi.ingsw.cg_10.model.map.Coordinate;

import java.rmi.RemoteException;

/**
 * @author Manfredi
 *
 */
public class RMIRoom implements RMIRemote{
	private Rserver rs;
	public RMIRoom (Rserver rs){
		this.rs = rs;
	}
	@Override
	public ComAction newPlayer(String nome) throws RemoteException {
		return rs.newPlayer(nome);
		
	}
	@Override
	public ComAction useCard(String username, int cardIdx) throws RemoteException {
		return rs.useCard(username,cardIdx);
		
	}
	@Override
	public ComAction setRoom(int room, String username, Boolean newRoom, Boolean advancedgame, String mappa) throws RemoteException {
		return rs.chooseRoom(room, username, newRoom, advancedgame, mappa);
	}
	@Override
	public ComAction newAttack(String username, Coordinate coordinata) throws RemoteException {
		
		return rs.newAttack(username,coordinata);
	}
	@Override
	public ComAction newChat(String testo, String username) throws RemoteException {
		return rs.newChat(testo,username);
		
	}
	
	public ComAction move(Coordinate coordinate, String username)throws RemoteException {
		return rs.move(coordinate, username);
		
	}
	@Override
	public ComAction rumor(Coordinate coordinate, String username) throws RemoteException {
		return rs.rumor(coordinate, username);
	
	}
	@Override
	public ComAction endTurn(String username) throws RemoteException {
		return rs.endTurn(username);
	}
	@Override
	public ComAction drawCard(String username, Deck deck) throws RemoteException {
	
		return rs.drawCard(username,deck);
	}
	
	

	
	
	
	

}
