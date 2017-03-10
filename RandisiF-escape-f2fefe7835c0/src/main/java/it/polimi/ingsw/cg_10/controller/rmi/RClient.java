package it.polimi.ingsw.cg_10.controller.rmi;

import it.polimi.ingsw.cg_10.model.com.*;
import it.polimi.ingsw.cg_10.model.deck.Deck;
import it.polimi.ingsw.cg_10.model.map.Coordinate;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;



/**
 * @author Manfredi
 *
 */
public class RClient {
	private final static String HOST = "127.0.0.1";
	private final static int PORT = 1099;
	private static final String NAME = "room";
	RMIRemote game;
	ComAction risposta;

	public RClient() throws RemoteException,
		NotBoundException {
		Registry registry = LocateRegistry.getRegistry(HOST, PORT);
		game = (RMIRemote) registry.lookup(NAME);
		System.out.println("Invoking remote object...");
	
	}
	
	public ComAction newPlayer(String nome){
		try {
			//System.out.println("Avvio richeista nome:");
			ComAction ca= game.newPlayer(nome);
			if (ca instanceof ComServerReply){
				System.out.println(((ComServerReply) ca).getConferma());
			}
			return ca;
		} catch (RemoteException e) {
			throw new AssertionError("Errore: "+ e);
		}
		
	}

	private ComAction useCard(String username, int cardIdx) {

		try {
			return game.useCard(username,cardIdx);
		} catch (RemoteException e) {
			
			throw new AssertionError("Errore: "+ e);
		}
		
	}

	private ComAction setRoom(int room, String username, Boolean newRoom, Boolean advancedgame, String mappa) {
		
		try {
			return game.setRoom(room,username,newRoom,advancedgame,mappa);
		} catch (RemoteException e) {
			
			throw new AssertionError("Errore: "+ e);
		}
	}

	private ComAction newAttack(Coordinate coordinata, String username) {
		
		try {
			return game.newAttack(username,coordinata);
			} catch (RemoteException e) {
		
			throw new AssertionError("Errore: "+ e);
		}
	}

	private ComAction newChat(String testo, String username) {
		try {
			return game.newChat(testo,username);
			} catch (RemoteException e) {
		
			throw new AssertionError("Errore: "+ e);
		}
		
	}
	
	private ComAction move(Coordinate coordinate, String username) {
		try {
			return game.move(coordinate,username);
			} catch (RemoteException e) {
		
			throw new AssertionError("Errore: "+ e);
		}
	}	
	

	private ComAction noise(Coordinate coordinate, String username) {
		try {
			return game.rumor(coordinate,username);
			} catch (RemoteException e) {
		
			throw new AssertionError("Errore: "+ e);
		}
	}
	
	private ComAction endTurn(String username) {
		try {
			return game.endTurn(username);
		    } catch (RemoteException e) {
			throw new AssertionError("Errore: "+ e);
		}
	}
	
	private ComAction drawCard(String username, Deck deck) {
		try {
			return game.drawCard(username, deck);
			} catch (RemoteException e) {
			
			throw new AssertionError("Errore: "+ e);
		}
	}
	
	public ComAction setCommand(ComAction comaction) {
		
		if(comaction instanceof ComFirstConnection){
			
		risposta = newPlayer(((ComFirstConnection) comaction).getUser());
		return risposta;
		}
		
		else if (comaction instanceof ComChat){
		risposta = newChat(((ComChat) comaction).getTesto(), ((ComChat) comaction).getUsername());
		return risposta;
		}
		
		else if(comaction instanceof ComAttack){
		risposta = newAttack(((ComAttack) comaction).getCoordinata(), ((ComAttack) comaction).getUsername());
		return risposta;
		}
		
		else if(comaction instanceof ComChooseRoom){
		risposta = setRoom(((ComChooseRoom) comaction).getRoom(), ((ComChooseRoom) comaction).getUsername(),((ComChooseRoom) comaction).getNewRoom(),((ComChooseRoom) comaction).getAdvancedGame(),((ComChooseRoom) comaction).getMappa());
		return risposta;
	
		}
		
		else if(comaction instanceof ComUseCard){
	    risposta = useCard(((ComUseCard) comaction).getUsername(), ((ComUseCard) comaction).getCardIdx());
	    return risposta;
		}
		
		else if(comaction instanceof ComMove){
		return risposta = move(((ComMove) comaction).getCoordinate(), comaction.getUsername());
		}
		
		else if(comaction instanceof ComNoise){
			return risposta= noise(((ComNoise) comaction).getCoordinata(), comaction.getUsername());
		}
		
		else if(comaction instanceof ComEndTurn){
			return risposta= endTurn(comaction.getUsername());
		}
		
		else if(comaction instanceof ComDrawCard){
			return risposta= drawCard(comaction.getUsername(), ((ComDrawCard) comaction).getDeck());
		}
		
		else{
		return null;
		}	

	}

	




	
	
	
}