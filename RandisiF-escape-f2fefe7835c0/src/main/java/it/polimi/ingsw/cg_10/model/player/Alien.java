package it.polimi.ingsw.cg_10.model.player;

import java.io.Serializable;

public class Alien extends Player  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private AlienList alienID;
	private Boolean killhuman; 

	
	public Alien (int playerID){
		super(playerID);
		this.killhuman = false;
	}
	public Boolean getKillHuman() {
		return killhuman;
	}	
	
	public void setKillHuman(Boolean killhuman){
		this.killhuman = killhuman;
	}

	public AlienList getAlienID() {
		return alienID;
	}

	public void setAlienID(AlienList alienID) {
		this.alienID = alienID;
	}
	
	@Override
	public String toString() {
		return "ID"+getPlayerID() + ": "+ getPlayerName() + " Alien" + " Vivo: " + isAlive() + " Sector: " + getMovementRec().getLastPlayerRecord().getPosition().toString() ;
	}
}
