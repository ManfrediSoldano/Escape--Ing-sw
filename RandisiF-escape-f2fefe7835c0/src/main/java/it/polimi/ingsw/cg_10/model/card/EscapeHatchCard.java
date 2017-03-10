package it.polimi.ingsw.cg_10.model.card;

import java.io.Serializable;



public class EscapeHatchCard implements Card,Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private EscapeHatchCardType ehcType;
	 
	public EscapeHatchCard(EscapeHatchCardType ehcType) {
		
		this.ehcType = ehcType;
	}

	public EscapeHatchCardType getEHCType() {
		return ehcType;
	}
 
}
