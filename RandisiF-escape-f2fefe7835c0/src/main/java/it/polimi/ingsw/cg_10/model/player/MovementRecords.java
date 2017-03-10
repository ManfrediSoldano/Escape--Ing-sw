package it.polimi.ingsw.cg_10.model.player;

import java.io.Serializable;
import java.util.ArrayList;

public class MovementRecords implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<PlayerRecord> movementList;
	
	public MovementRecords() {
		this.movementList = new  ArrayList<PlayerRecord>();
	}
	
	public ArrayList<PlayerRecord> getMovementList() {
		return movementList;
	}
	
	public PlayerRecord getLastPlayerRecord (){
		try{
			return movementList.get(movementList.size()-1);
		}catch(ArrayIndexOutOfBoundsException e){
			return null;
		}
	}

}
