package it.polimi.ingsw.cg_10.model.game;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Observable;



import it.polimi.ingsw.cg_10.controller.rules.PossibiliAzioni;
import it.polimi.ingsw.cg_10.model.deck.DangerousSectorDeck;
import it.polimi.ingsw.cg_10.model.map.Zone;
import it.polimi.ingsw.cg_10.model.player.Player;


public class Game extends Observable implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Player> playerList;
	private Zone zone;
	private DangerousSectorDeck dangerousSectorDeck;
	private String toPublish;
	private PossibiliAzioni possibiliAzioni;
	private String userTurno;
	private int ID;
	private String message;
	
	public Game() {
		playerList = new ArrayList<Player>();
		dangerousSectorDeck = new DangerousSectorDeck();
		possibiliAzioni = new PossibiliAzioni();
	}	
	
	public ArrayList<Player> getPlayerList() {
		return playerList;
	}

	public void setPlayerList(ArrayList<Player> playerList) {
		this.playerList = playerList;
	}

	public Zone getZone() {
		return zone;
	}

	public void setZone(Zone zone) {
		this.zone = zone;
	}

	public DangerousSectorDeck getDangerousSectorDeck() {
		return dangerousSectorDeck;
	}

	public void setDangerousSectorDeck(DangerousSectorDeck dangerousSectorDeck) {
		this.dangerousSectorDeck = dangerousSectorDeck;
	}

	@Override
	public String toString() {
		String s="STANDARD GAME \nPlayerList: \n";
		for (Player player : playerList) {
			s+= player.getPlayerName() + " - " +player.isAlive() + '\n';
		}
		s+= getZone() + "\nDangerousSectorDeck: " + getDangerousSectorDeck().getCardList().size();
			
		return s;
	}

	public String serialize(){
		 try {
			 
			   ByteArrayOutputStream bo = new ByteArrayOutputStream();
			   ObjectOutputStream so = new ObjectOutputStream(bo);
			   so.writeObject(this);
			   so.flush();
			   return bo.toString("ISO-8859-1");
		    
		 } catch (Exception e) {
		     System.err.println(e);
		     return null;
		 }
	}
	
	public Game deserialize(String scommand){
		 try {
			  byte b[] = scommand.getBytes("ISO-8859-1");  
		      ByteArrayInputStream bi = new ByteArrayInputStream(b);
		      ObjectInputStream si = new ObjectInputStream(bi);
		      Game obj = (Game) si.readObject();
		      return obj;
		     } catch (Exception e) {
		    	 
		     System.err.println("deseria");	    
		     return null;
		 }
	}

	public String getToPublish() {
		return toPublish;
	}

	public void setToPublish(String toPublish) {
		if (toPublish.equals(""))
			this.toPublish = toPublish;
		else
			this.toPublish = this.toPublish + '\n' + toPublish;
	}

	public Player findFromUsername(String username){
		for(Player player: playerList){
			if(player.getPlayerName().equals(username)){
				return player;
			}
		}
		
		return null;
	}

	public void setPossibiliAzioni(PossibiliAzioni possibiliAzioni) {
		this.possibiliAzioni  = possibiliAzioni;
	}
	
	public PossibiliAzioni getPossibiliAzioni(){
		return possibiliAzioni;
	}

	public void clearToPublish() {
		toPublish = "";
		message = "";
		
	}

	public String getUserTurno() {
		return userTurno;
	}

	public void setUserTurno(String userTurno) {
		this.userTurno = userTurno;
	}


	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;

	}


	
}
