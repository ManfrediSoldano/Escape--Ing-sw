package it.polimi.ingsw.cg_10.model.player;

import java.io.Serializable;

public class Human extends Player implements Serializable {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private HumanList humanID;
	private boolean save;
	private boolean adrenaline;
	private boolean sedative;
	

	public Human (int playerID){
		super(playerID);
		save = false;
		setAdrenaline(false);
		setSedative(false);
	}
	
	public HumanList getHumanID() {
		return humanID;
	}
	
	public void setHumanID(HumanList humanID) {
		this.humanID = humanID;
	}
	
	public boolean isSave() {
		return save;
	}

	public void setSave(boolean save) {
		this.save = save;
	}

	public boolean isAdrenaline() {
		return adrenaline;
	}

	public void setAdrenaline(boolean adrenaline) {
		this.adrenaline = adrenaline;
	}	
	
		@Override
	public String toString() {
			return "ID"+getPlayerID() + ": "+ getPlayerName() + " Human" + " Vivo: " + isAlive() + " Sector: " + getMovementRec().getLastPlayerRecord().getPosition().toString() ;
	}

	public boolean isSedative() {
		return sedative;
	}

	public void setSedative(boolean sedative) {
		this.sedative = sedative;
	}
}
