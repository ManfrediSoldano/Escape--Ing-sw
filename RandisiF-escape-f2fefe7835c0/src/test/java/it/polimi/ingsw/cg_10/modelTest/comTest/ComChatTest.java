package it.polimi.ingsw.cg_10.modelTest.comTest;


import java.util.ArrayList;

import it.polimi.ingsw.cg_10.model.card.Card;
import it.polimi.ingsw.cg_10.model.card.ObjectCard;
import it.polimi.ingsw.cg_10.model.card.ObjectCardType;
import it.polimi.ingsw.cg_10.model.com.ComDrawCard;
import it.polimi.ingsw.cg_10.model.deck.Deck;
import junit.framework.TestCase;

import org.junit.Test;


public class ComChatTest extends TestCase{
	
	public ComChatTest (String name){
		super (name);
	}

	@Test
	public final void testComActionCoordinate() {
		Deck deck = new Deck();
		ObjectCard card = new ObjectCard(ObjectCardType.ATTACK);
		ArrayList<Card> cardlist = new ArrayList<Card>();
		cardlist.add(card);
		deck.setCardList(cardlist);
		
		ComDrawCard comaction = new ComDrawCard(deck, "Asdrubale");		
		assertEquals("Asdrubale",comaction.getUsername());
		assertEquals(deck,comaction.getDeck());

		
		
	}
	
}
