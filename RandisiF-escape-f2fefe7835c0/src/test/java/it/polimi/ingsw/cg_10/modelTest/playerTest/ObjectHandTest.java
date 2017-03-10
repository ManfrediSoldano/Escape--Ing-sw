package it.polimi.ingsw.cg_10.modelTest.playerTest;

import it.polimi.ingsw.cg_10.model.card.ObjectCard;
import it.polimi.ingsw.cg_10.model.deck.ObjectDeck;
import it.polimi.ingsw.cg_10.model.player.ObjectHand;

import org.junit.Test;

import junit.framework.TestCase;

public class ObjectHandTest extends TestCase {

	public ObjectHandTest(String name) {
		super(name);
	}
	
	@Test
	public final void testAddCardToHand() {
		ObjectHand objectHand = new ObjectHand();
		ObjectDeck objectDeck = new ObjectDeck();
		int i = objectHand.numObjOwned();
		int j = objectDeck.getCardList().size();
		objectHand.addCardToHand(objectDeck);
		if (i < 3){
			assertEquals (i+1, objectHand.numObjOwned());
			assertEquals (j-1, objectDeck.getCardList().size());
		}
		else{
			assertEquals (i, objectHand.numObjOwned());	
			assertEquals (j, objectDeck.getCardList().size());
		}
	}

	@Test
	public final void testRemoveCardFromHand() {
		ObjectHand objectHand = new ObjectHand();
		ObjectDeck objectDeck = new ObjectDeck();
		objectHand.addCardToHand(objectDeck);
		objectHand.addCardToHand(objectDeck);
		ObjectCard c = objectHand.getCardList().get(0);
		objectHand.removeCardFromHand(c,objectDeck);
		assertEquals(1, objectHand.numObjOwned());
	}
	
	@Test
	public final void testGetCardList() {
		ObjectHand objectHand = new ObjectHand();
		ObjectDeck objectDeck = new ObjectDeck();
		objectHand.addCardToHand(objectDeck);
		objectHand.addCardToHand(objectDeck);
		assertEquals(2, objectHand.getCardList().size());
		objectHand.addCardToHand(objectDeck);
		assertEquals(3,objectHand.getCardList().size());
		objectHand.addCardToHand(objectDeck);
		assertEquals(3,objectHand.getCardList().size());
	}
	
	@Test
	public final void testIsFull() {
		ObjectHand objectHand = new ObjectHand();
		ObjectDeck objectDeck = new ObjectDeck();
		objectHand.addCardToHand(objectDeck);
		objectHand.addCardToHand(objectDeck);
		assertFalse(objectHand.isFull());
		objectHand.addCardToHand(objectDeck);
		assertTrue(objectHand.isFull());
		objectHand.addCardToHand(objectDeck);
		assertTrue(objectHand.isFull());
	}
	
	@Test
	public final void testNumObjOwned() {
		ObjectHand objectHand = new ObjectHand();
		ObjectDeck objectDeck = new ObjectDeck();
		objectHand.addCardToHand(objectDeck);
		assertEquals(1, objectHand.numObjOwned());
		objectHand.addCardToHand(objectDeck);
		assertEquals(2, objectHand.numObjOwned());
		objectHand.addCardToHand(objectDeck);
		assertEquals(3, objectHand.numObjOwned());
	}
	

}
