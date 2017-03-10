package it.polimi.ingsw.cg_10.controller.rmi;

import it.polimi.ingsw.cg_10.controller.server.ServerComunication;
import it.polimi.ingsw.cg_10.model.com.*;
import it.polimi.ingsw.cg_10.model.deck.Deck;
import it.polimi.ingsw.cg_10.model.map.Coordinate;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 * @author Manfredi
 *
 */
public class Rserver extends Thread {
	private final Registry registry;
	private static final String NAME = "room";
	private ServerComunication sc;
	
	public Rserver(ServerComunication sc) throws RemoteException, AlreadyBoundException {
		this.sc=sc;
		registry = LocateRegistry.createRegistry(1099);
		
		System.out.println("Constructing server implementation");
		
	}
	@Override
	public void run(){

		
		try {
			RMIRoom game = new RMIRoom(this);
			RMIRemote gameRemote = (RMIRemote) UnicastRemoteObject.exportObject(game, 0);
			//System.out.println("Binding server implementation to registry...");
			registry.bind(NAME, gameRemote);
			//System.out.println("Waiting for invocations from clients...");
		} catch (RemoteException | AlreadyBoundException e) {
		
			throw new AssertionError("Errore: "+ e);
		}
		
	}

	public ComAction newPlayer(String nome){
		return sc.setCommand(new ComFirstConnection(nome));
	}

	public ComAction useCard(String username, int cardIdx) {
		return sc.setCommand(new ComUseCard(cardIdx,username));
		
	}
	public ComAction chooseRoom(int room, String username, Boolean newRoom, Boolean advancedgame, String mappa) {
		return sc.setCommand(new ComChooseRoom(room,username,newRoom,advancedgame, mappa));
		
	}
	public ComAction move(Coordinate coordinate, String username) {
		return sc.setCommand(new ComMove(coordinate,username));
	}
	public ComAction rumor(Coordinate coordinate, String username) {
		// TODO Auto-generated method stub
		return sc.setCommand(new ComNoise(coordinate,username));
	}
	public ComAction endTurn(String username) {
		
		return sc.setCommand(new ComEndTurn(username));
	}
	public ComAction drawCard(String username, Deck deck) {
		
		return sc.setCommand(new ComDrawCard(deck,username));
	}
	public ComAction newAttack(String username, Coordinate coordinata) {
		
		return sc.setCommand(new ComAttack(coordinata, username));
	}
	public ComAction newChat(String testo, String username) {
		return sc.setCommand(new ComChat(testo, username));
	}
	
	
	
}
