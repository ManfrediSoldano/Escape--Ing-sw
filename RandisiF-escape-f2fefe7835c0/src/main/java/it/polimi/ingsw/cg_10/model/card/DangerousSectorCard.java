package it.polimi.ingsw.cg_10.model.card;

import java.io.Serializable;

public class DangerousSectorCard implements Card, Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private DangerousSectorCardType dscType;
	private boolean itemIcon;
	
	/**Rappresenta la carta pericolo
	 * @param dscType
	 * @param itemIcon
	 */
	public DangerousSectorCard(DangerousSectorCardType dscType, boolean itemIcon){
		this.dscType = dscType;
		this.itemIcon = itemIcon;
	}

	public DangerousSectorCardType getDSCType() {
		return dscType;
	}

	public boolean isItemIcon() {
		return itemIcon;
	}

}
