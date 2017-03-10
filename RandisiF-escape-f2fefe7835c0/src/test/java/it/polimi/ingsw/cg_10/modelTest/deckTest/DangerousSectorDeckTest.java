package it.polimi.ingsw.cg_10.modelTest.deckTest;

import it.polimi.ingsw.cg_10.model.deck.DangerousSectorDeck;
import junit.framework.TestCase;
import org.junit.Test;

public class DangerousSectorDeckTest extends TestCase{
		
	public DangerousSectorDeckTest (String name){
		super (name);
	}

	@Test
	public final void testDangerousSectorDeck() {
		DangerousSectorDeck testDSDeck = new DangerousSectorDeck();
		assertEquals(25, testDSDeck.getCardList().size());
	}

}
