package it.polimi.ingsw.cg_10.model.card;

import java.io.Serializable;

public class ObjectCard implements Card, Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ObjectCardType objType;
	
	public ObjectCard(ObjectCardType objType) {
		this.objType = objType;
	}

	public ObjectCardType getObjType() {
		return objType;
	}

	@Override
	public String toString() {
		return getObjType().toString();
	}
}
