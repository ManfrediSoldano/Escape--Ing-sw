package it.polimi.ingsw.cg_10.controller.gameTest;

import static org.junit.Assert.*;



import it.polimi.ingsw.cg_10.model.game.Chat;
import it.polimi.ingsw.cg_10.model.player.Player;

import org.junit.Test;

public class ChatTest {

	@Test
	public void test() {
		Chat chat = new Chat();
		Player player = new Player();
		player.setPlayerName("Mrs simpatia");
		
		chat.addMsg("Trolololo", player);

		assertEquals(chat.getMsgList().get(0),"Mrs simpatia: Trolololo");
	}

}
