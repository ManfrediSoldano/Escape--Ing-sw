package it.polimi.ingsw.cg_10.model.com;

import it.polimi.ingsw.cg_10.model.deck.Deck;

/**
 * @author Manfredi
 *
 */
public class ComDrawCard extends ComAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Deck deck;
	
	/** 
	 * @param deck mazzo di carte
	 * @param username stringa che rappresetna l'utente
	 */
	public ComDrawCard(Deck deck, String username) {
		this.setDeck(deck);
		super.setUsername(username);
	}

	public ComDrawCard(Deck Deck) {
		this.setDeck(deck);
	}

	public Deck getDeck() {
		return deck;
	}

	public void setDeck(Deck deck) {
		this.deck = deck;
	}
	
	public String getUsername(){
		return super.getUsername();
	}
	
}
