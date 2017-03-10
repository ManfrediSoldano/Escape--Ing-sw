package it.polimi.ingsw.cg_10.controller.gameTest;

import static org.junit.Assert.*;
import it.polimi.ingsw.cg_10.model.deck.EscapeHatchDeck;
import it.polimi.ingsw.cg_10.model.deck.ObjectDeck;
import it.polimi.ingsw.cg_10.model.game.AdvancedGame;

import org.junit.Test;

public class AdvancedGameTest {

	@Test
	public void test() {
		AdvancedGame game = new AdvancedGame();
		
		EscapeHatchDeck escapeHatchDeck = new EscapeHatchDeck();
		
		game.setEscapeHatchDeck(escapeHatchDeck);
		assertEquals(game.getEscapeHatchDeck(), escapeHatchDeck);
		
		ObjectDeck obkdk = new ObjectDeck();
		game.setObjectDeck(obkdk);
		assertEquals(game.getObjectDeck(), obkdk);
		
		
		
	}

}
