package it.polimi.ingsw.cg_10.model.player;

import java.io.Serializable;

public class Player implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	
	private int playerID;
	private String playerName;
	private MovementRecords movementRec;
	private ObjectHand objOwned;
	private Boolean alive;
	private Boolean active;
	
	public Player (int playerID){
		this.playerID = playerID;
		this.playerName = "";
		this.movementRec =new MovementRecords();
		this.objOwned = new ObjectHand();
		this.alive = true;
	}
	
	
	public Player() {
	}


	public int getPlayerID(){
		return playerID;
	}

	public void setPlayerID (int playerID) {
		this.playerID = playerID;
	}
	
	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public MovementRecords getMovementRec() {
		return movementRec;
	}

	public void setMovementRec(MovementRecords movementRec) {
		this.movementRec = movementRec;
	}

	public ObjectHand getObjOwned() {
		return objOwned;
	}

	public void setObjOwned(ObjectHand objOwned) {
		this.objOwned = objOwned;
	}

	public Boolean isAlive() {
		return alive;
	}

	public void setAlive(Boolean alive) {
		this.alive = alive;
	}

	@Override
	public String toString() {
		return "ID"+getPlayerID() + ": "+ getPlayerName() + " => Player" + " Vivo: " + isAlive() ;
	}


	public Boolean getActive() {
		return active;
	}


	public void setActive(Boolean active) {
		this.active = active;
	}
}