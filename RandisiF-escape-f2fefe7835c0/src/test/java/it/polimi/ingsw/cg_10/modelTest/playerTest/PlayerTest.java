/**
 * 
 */
package it.polimi.ingsw.cg_10.modelTest.playerTest;

import static org.junit.Assert.*;
import it.polimi.ingsw.cg_10.model.deck.ObjectDeck;
import it.polimi.ingsw.cg_10.model.player.MovementRecords;
import it.polimi.ingsw.cg_10.model.player.ObjectHand;
import it.polimi.ingsw.cg_10.model.player.Player;
import it.polimi.ingsw.cg_10.model.player.PlayerRecord;

import org.junit.Test;

/**
 * @author Francesco
 *
 */
public class PlayerTest {

	/**
	 * Test method for {@link it.polimi.ingsw.cg_10.model.player.Player#Player(java.lang.Integer)}.
	 */
	@Test
	public final void testPlayer() {
		Player player1 = new Player(1);
		Player player2 = new Player(2);
		assertEquals(1, player1.getPlayerID());
		assertEquals(2, player2.getPlayerID());
	}

	/**
	 * Test method for {@link it.polimi.ingsw.cg_10.model.player.Player#getPlayerID()}.
	 */
	@Test
	public final void testGetPlayerID() {
		Player player1 = new Player(1);
		Player player2 = new Player(2);
		assertEquals(1, player1.getPlayerID());
		assertEquals(2, player2.getPlayerID());
	}

	/**
	 * Test method for {@link it.polimi.ingsw.cg_10.model.player.Player#setPlayerID(java.lang.Integer)}.
	 */
	@Test
	public final void testSetPlayerID() {
		Player player1 = new Player(1);
		Player player2 = new Player(2);
		player1.setPlayerID(4890);
		player2.setPlayerID(-4890);
		player1.setPlayerName("Player 1");
		player2.setPlayerName("Player 2");
		assertEquals(4890, player1.getPlayerID());
		assertEquals("Player 1", player1.getPlayerName());
		assertEquals(-4890, player2.getPlayerID());	
		assertEquals("Player 2", player2.getPlayerName());
}

	/**
	 * Test method for {@link it.polimi.ingsw.cg_10.model.player.Player#getPlayerName()}.
	 */
	@Test
	public final void testGetPlayerName() {
		Player player1 = new Player(1);
		player1.setPlayerName("Player 1");
		assertEquals("Player 1", player1.getPlayerName());
		player1.setPlayerName("tricheco");
		assertEquals("tricheco", player1.getPlayerName());

	}

	/**
	 * Test method for {@link it.polimi.ingsw.cg_10.model.player.Player#setPlayerName(java.lang.String)}.
	 */
	@Test
	public final void testSetPlayerName() {
		Player player1 = new Player(1);
		player1.setPlayerName("4u58rjf948");
		assertEquals("4u58rjf948", player1.getPlayerName());
		player1.setPlayerName("tricheco");
		assertEquals("tricheco", player1.getPlayerName());
	}

	/**
	 * Test method for {@link it.polimi.ingsw.cg_10.model.player.Player#getMovementRec()}.
	 */
	@Test
	public final void testGetMovementRec() {
		Player player1 = new Player(1);
		assertEquals(0, player1.getMovementRec().getMovementList().size());
		MovementRecords movementRecords = new MovementRecords();
		for(int i=0;i<22;i++){
			movementRecords.getMovementList().add(new PlayerRecord(i));
			player1.setMovementRec(movementRecords);
			assertEquals(i+1,player1.getMovementRec().getMovementList().size());
		}
	}

	/**
	 * Test method for {@link it.polimi.ingsw.cg_10.model.player.Player#setMovementRec(it.polimi.ingsw.cg_10.model.player.MovementRecords)}.
	 */
	@Test
	public final void testSetMovementRec() {
		Player player1 = new Player(1);
		assertEquals(0, player1.getMovementRec().getMovementList().size());
		MovementRecords movementRecords = new MovementRecords();
		for(int i=0;i<22;i++){
			movementRecords.getMovementList().add(new PlayerRecord(i));
			player1.setMovementRec(movementRecords);
			assertEquals(i+1,player1.getMovementRec().getMovementList().size());
		}	
	}

	/**
	 * Test method for {@link it.polimi.ingsw.cg_10.model.player.Player#getObjOwned()}.
	 */
	@Test
	public final void testGetObjOwned() {
		Player player1 = new Player(1);
		ObjectHand objectHand = new ObjectHand();
		ObjectDeck objectDeck = new ObjectDeck();
		assertEquals(0, player1.getObjOwned().getCardList().size() );
		objectHand.addCardToHand(objectDeck);
		player1.setObjOwned(objectHand);
		assertEquals(1, player1.getObjOwned().getCardList().size() );
		objectHand.addCardToHand(objectDeck);
		player1.setObjOwned(objectHand);
		assertEquals(2, player1.getObjOwned().getCardList().size() );
		objectHand.addCardToHand(objectDeck);
		player1.setObjOwned(objectHand);
		assertEquals(3, player1.getObjOwned().getCardList().size() );

		
	}

	/**
	 * Test method for {@link it.polimi.ingsw.cg_10.model.player.Player#setObjOwned(it.polimi.ingsw.cg_10.model.player.ObjectHand)}.
	 */
	@Test
	public final void testSetObjOwned() {
		Player player1 = new Player(1);
		ObjectHand objectHand = new ObjectHand();
		ObjectDeck objectDeck = new ObjectDeck();
		objectHand.addCardToHand(objectDeck);
		player1.setObjOwned(objectHand);
		assertEquals(1, player1.getObjOwned().getCardList().size() );
		objectHand.addCardToHand(objectDeck);
		player1.setObjOwned(objectHand);
		assertEquals(2, player1.getObjOwned().getCardList().size() );
		objectHand.addCardToHand(objectDeck);
		player1.setObjOwned(objectHand);
		assertEquals(3, player1.getObjOwned().getCardList().size() );
	}

	/**
	 * Test method for {@link it.polimi.ingsw.cg_10.model.player.Player#isAlive()}.
	 */
	@Test
	public final void testIsAlive() {
		Player player1 = new Player(1);
		assertTrue(player1.isAlive());
		player1.setAlive(false);
		assertFalse(player1.isAlive());
	}

	/**
	 * Test method for {@link it.polimi.ingsw.cg_10.model.player.Player#setAlive(java.lang.Boolean)}.
	 */
	@Test
	public final void testSetAlive() {
		Player player1 = new Player(1);
		player1.setAlive(false);
		assertFalse(player1.isAlive());
		player1.setAlive(true);
		assertTrue(player1.isAlive());
	}

	/**
	 * Test method for {@link it.polimi.ingsw.cg_10.model.player.Player#toString()}.
	 */
	@Test
	public final void testToString() {
		Player player1 = new Player(1);
		player1.setPlayerName("Player 1");
		assertEquals("ID1: Player 1 => Player Vivo: true" , player1.toString()) ;
	}

}
