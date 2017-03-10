package it.polimi.ingsw.cg_10.controller.gameTest;

import static org.junit.Assert.*;

import java.util.ArrayList;

import it.polimi.ingsw.cg_10.model.game.Game;
import it.polimi.ingsw.cg_10.model.player.Player;

import org.junit.Test;

public class GameTest {

	@Test
	public void test() {
		Game game = new Game();
		Player player = new Player();
		player.setPlayerID(1);
		player.setPlayerName("Perchè");
		ArrayList<Player> playerList= new ArrayList<Player>();
		playerList.add(player);
		game.setPlayerList(playerList);
		game.setToPublish("Ammaccabanane");
	
		assertEquals(game.findFromUsername("Perchè"), player);
		
		assertEquals(game.getPlayerList(), playerList);
		

		
	}

}
