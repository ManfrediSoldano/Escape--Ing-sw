/**
 * 
 */
package it.polimi.ingsw.cg_10.model.game;

import it.polimi.ingsw.cg_10.model.deck.EscapeHatchDeck;
import it.polimi.ingsw.cg_10.model.deck.ObjectDeck;
import it.polimi.ingsw.cg_10.model.player.Player;


public class AdvancedGame extends Game {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private EscapeHatchDeck escapeHatchDeck;
	private ObjectDeck objectDeck;

	public AdvancedGame() {
		super ();
		escapeHatchDeck = new EscapeHatchDeck();
		objectDeck = new ObjectDeck();
	}

	public EscapeHatchDeck getEscapeHatchDeck() {
		return escapeHatchDeck;
	}

	public void setEscapeHatchDeck(EscapeHatchDeck escapeHatchDeck) {
		this.escapeHatchDeck = escapeHatchDeck;
	}

	public ObjectDeck getObjectDeck() {
		return objectDeck;
	}

	public void setObjectDeck(ObjectDeck objectDeck) {
		this.objectDeck = objectDeck;
	}
	
	@Override
	public String toString() {
		String s="ADVANCED GAME \nPlayerList: \n";
		for (Player player : getPlayerList()) {
			s+= player.getPlayerName() + " - " +player.isAlive() + '\n';
		}
		s+= getZone() + "\nDangerousSectorDeck: " + getDangerousSectorDeck().getCardList().size()
				+"\nObjectDeck: " + getObjectDeck().getCardList().size() 
				+"\nEscapeHatchDeck: " + getEscapeHatchDeck().getCardList().size();;
		
		return s;
	}
	
}
