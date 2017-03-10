package it.polimi.ingsw.cg_10.modelTest.deckTest;

import it.polimi.ingsw.cg_10.model.card.DangerousSectorCard;
import it.polimi.ingsw.cg_10.model.card.ObjectCard;
import it.polimi.ingsw.cg_10.model.deck.DangerousSectorDeck;
import it.polimi.ingsw.cg_10.model.deck.ObjectDeck;

import org.junit.Test;

import junit.framework.TestCase;

public class DeckTest extends TestCase {

	private DangerousSectorDeck testDSDeck = new DangerousSectorDeck(); 
	private ObjectDeck testODeck = new ObjectDeck();  
	
	public DeckTest (String name){
		super (name);
	}

	@Test
	public final void testRefreshDeck() {
		testDSDeck.refreshDeck();
		assertTrue(testDSDeck.getCardList().size() > 0 && testDSDeck.getCardList().size() <= 25);
		testODeck.refreshDeck();
		assertTrue(testODeck.getCardList().size() > 0 && testODeck.getCardList().size() <= 12);
	}

	@Test
	public final void testDrawCard() {
		DangerousSectorCard cDS = (DangerousSectorCard) testDSDeck.drawCard();
		assertFalse(testDSDeck.getCardList().contains(cDS));
		ObjectCard cO = (ObjectCard) testODeck.drawCard();
		assertFalse(testODeck.getCardList().contains(cO));
	}

	@Test
	public final void testUseCard() {
		DangerousSectorCard cDS = (DangerousSectorCard) testDSDeck.drawCard();
		testDSDeck.useCard(cDS);
		assertTrue(testDSDeck.getUsedCard().contains(cDS));
		ObjectCard cO = (ObjectCard) testODeck.drawCard();
		testODeck.useCard(cO);
		assertTrue(testODeck.getUsedCard().contains(cO));
	}

}
