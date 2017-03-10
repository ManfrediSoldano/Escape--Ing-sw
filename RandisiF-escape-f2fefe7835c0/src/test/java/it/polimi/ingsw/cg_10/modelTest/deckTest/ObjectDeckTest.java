package it.polimi.ingsw.cg_10.modelTest.deckTest;

import it.polimi.ingsw.cg_10.model.deck.ObjectDeck;

import org.junit.Test;

import junit.framework.TestCase;

public class ObjectDeckTest extends TestCase {
	
	public ObjectDeckTest (String name){
		super (name);
	}

	@Test
	public final void testObjectDeck() {
		ObjectDeck testODeck = new ObjectDeck();
		assertEquals(12, testODeck.getCardList().size());
	}

}
