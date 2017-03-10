package it.polimi.ingsw.cg_10.controller.rules;

import static org.junit.Assert.*;
import it.polimi.ingsw.cg_10.model.game.Game;
import it.polimi.ingsw.cg_10.model.player.Player;

import org.junit.Test;

public class CardControllerTest {

	@Test
	public void test() {
		Game game = new Game();
		Player player = new Player();
		
		assertFalse(CardController.useObjCard(game, player, 0));
	}

}
