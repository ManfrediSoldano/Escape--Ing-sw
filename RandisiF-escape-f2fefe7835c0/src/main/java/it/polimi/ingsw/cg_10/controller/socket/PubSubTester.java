package it.polimi.ingsw.cg_10.controller.socket;

import java.util.ArrayList;

import it.polimi.ingsw.cg_10.controller.server.ServerGameCentral;
import it.polimi.ingsw.cg_10.model.player.Player;
import it.polimi.ingsw.cg_10.model.player.Room;

/**
 * @author Manfredi
 * Serve per il testing DA ELIMINARE
 */
public class PubSubTester {
	private static Broker brokerSK;
	private static ServerGameCentral sgc;
	public static void main(String[] args) {
		
		//Creazione lista player.
		ArrayList<Room> rm = new ArrayList<Room>();
		sgc= new ServerGameCentral();
		Room room = new Room(0);
		Player player1 = new Player();
		player1.setPlayerID(0);
		player1.setPlayerName("Augusto");
		room.addPlayerToRoom(player1);
		Player player2 = new Player();
		player2.setPlayerID(1);
		player2.setPlayerName("Luigi");
		room.addPlayerToRoom(player2);
		rm.add(room);
		sgc.setRm(rm);
		
		brokerSK=new Broker("0",sgc);	
	    brokerSK.start();
	    
	    SubscriberThread st0 = new SubscriberThread("Augusto");
	    SubscriberThread st1 = new SubscriberThread("Luigi");
	    st0.start();
	    st1.start();
	    
	    
		brokerSK.publish("Prima prova", 0);
		brokerSK.publish("Seconda prova", 0);
		brokerSK.publish("terza prova/n", 0);
		brokerSK.publish("quarta prova", 0);
		brokerSK.publish("quinta prova\n", 0);
		
		String temp="";
		for(int i=0; i<573; i++){
			temp= temp+ Integer.toString(i)+ " Ripeterò questo emssaggio talmente tante volte che ti verrà il vomito, devo arrivare a 1500 caratteri\n";
		}
		brokerSK.publish(temp, 0);
		

	}

}
