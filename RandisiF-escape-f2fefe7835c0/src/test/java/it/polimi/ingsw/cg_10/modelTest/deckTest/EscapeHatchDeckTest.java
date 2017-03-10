package it.polimi.ingsw.cg_10.modelTest.deckTest;

import it.polimi.ingsw.cg_10.model.deck.EscapeHatchDeck;

import org.junit.Test;

import junit.framework.TestCase;

public class EscapeHatchDeckTest extends TestCase {

	public EscapeHatchDeckTest (String name){
		super (name);
	}
	
	@Test
	public final void testEscapeHatchDeck() {
		EscapeHatchDeck testEHDeck = new EscapeHatchDeck();
		assertEquals(6, testEHDeck.getCardList().size());
	}

}
