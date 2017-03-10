package it.polimi.ingsw.cg_10.model.player;

import java.io.Serializable;

import it.polimi.ingsw.cg_10.model.card.DangerousSectorCard;
import it.polimi.ingsw.cg_10.model.card.EscapeHatchCard;
import it.polimi.ingsw.cg_10.model.card.ObjectCard;
import it.polimi.ingsw.cg_10.model.map.Sector;

public class PlayerRecord implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int recordID;
	private Sector position;
	private DangerousSectorCard dSCard;
	private ObjectCard objCardUsed;
	private ObjectCard objCardDraw;
	private EscapeHatchCard escapeHCardDraw;
	private ObjectHand objectHand;
	
	public PlayerRecord(int recordID){
		this.recordID = recordID;
	}
	
	public PlayerRecord(int recordID, Sector position ){
		this.recordID = recordID;
		this.position = position;
	}
	
	public PlayerRecord(int recordID, Sector position, DangerousSectorCard dSCard,
			ObjectCard objCardUserd, ObjectCard objCardDraw,
			EscapeHatchCard escapeHCardDraw, ObjectHand objectHand) {
		
		this.recordID = recordID;
		this.position = position;
		this.dSCard = dSCard;
		this.objCardUsed = objCardUserd;
		this.objCardDraw = objCardDraw;
		this.escapeHCardDraw = escapeHCardDraw;
		this.objectHand = objectHand;
	}
	
	public ObjectCard getObjCardUsed() {
		return objCardUsed;
	}

	public void setObjCardUsed(ObjectCard objCardUsed) {
		this.objCardUsed = objCardUsed;
	}

	public void setRecordID(int recordID) {
		this.recordID = recordID;
	}

	public void setdSCard(DangerousSectorCard dSCard) {
		this.dSCard = dSCard;
	}

	public void setObjCardDraw(ObjectCard objCardDraw) {
		this.objCardDraw = objCardDraw;
	}

	public void setEscapeHCardDraw(EscapeHatchCard escapeHCardDraw) {
		this.escapeHCardDraw = escapeHCardDraw;
	}

	public void setObjectHand(ObjectHand objectHand) {
		this.objectHand = objectHand;
	}

	public int getRecordID(){
		return recordID;
	}
	
	public Sector getPosition(){
		return position;
	}
	
	public void setPosition(Sector position){
		this.position = position;
	}
	
	public DangerousSectorCard getdSCard() {
		return dSCard;
	}

	public ObjectCard getObjCardUserd() {
		return objCardUsed;
	}

	public ObjectCard getObjCardDraw() {
		return objCardDraw;
	}

	public EscapeHatchCard getEscapeHCardDraw() {
		return escapeHCardDraw;
	}

	public ObjectHand getObjectHand() {
		return objectHand;
	}
}
