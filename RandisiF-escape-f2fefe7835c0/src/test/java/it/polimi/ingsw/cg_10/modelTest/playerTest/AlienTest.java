/**
 * 
 */
package it.polimi.ingsw.cg_10.modelTest.playerTest;

import it.polimi.ingsw.cg_10.model.player.Alien;
import it.polimi.ingsw.cg_10.model.player.AlienList;

import org.junit.Test;

import junit.framework.TestCase;

/**
 * @author Francesco
 *
 */
public class AlienTest extends TestCase {


	/**
	 * Test method for {@link it.polimi.ingsw.cg_10.model.player.Alien#Alien(java.lang.Integer)}.
	 */
	@Test
	public final void testAlien() {
		Alien alien1 = new Alien(1);
		Alien alien2 = new Alien(2);
		Alien alien3 = new Alien(3);
		alien2.setKillHuman(true);
		alien1.setAlive(false);
		alien3.setPlayerName("Giorgione");
		
		assertTrue(!alien1.getKillHuman() && alien1.getPlayerID()==1 && !alien1.isAlive());
		assertTrue(alien2.getKillHuman() && alien2.getPlayerID()==2 && alien2.isAlive());
		assertTrue(!alien3.getKillHuman() && alien3.getPlayerID()==3 && alien3.isAlive() && alien3.getPlayerName().equals("Giorgione"));
		
	}
	

	/**
	 * Test method for {@link it.polimi.ingsw.cg_10.model.player.Alien#getKillHuman()}.
	 */
	@Test
	public final void testGetKillHuman() {
		Alien alien = new Alien(1);
		assertFalse(alien.getKillHuman());
		alien.setKillHuman(true);
		assertTrue(alien.getKillHuman());

	}

	/**
	 * Test method for {@link it.polimi.ingsw.cg_10.model.player.Alien#setKillHuman(java.lang.Boolean)}.
	 */
	@Test
	public final void testSetKillHuman() {	
		Alien alien = new Alien(1);
		alien.setKillHuman(true);
		assertTrue(alien.getKillHuman());
		alien.setKillHuman(false);
		assertFalse(alien.getKillHuman());
	}

	/**
	 * Test method for {@link it.polimi.ingsw.cg_10.model.player.Alien#getAlienID()}.
	 */
	@Test
	public final void testGetAlienID() {
		Alien alien1 = new Alien(1);
		Alien alien2 = new Alien(2);
		assertEquals(null,alien1.getAlienID());
		alien1.setAlienID(AlienList.THE_FOURTH_ALIEN);
		alien2.setAlienID(AlienList.THE_FIRST_ALIEN);
		assertEquals(AlienList.THE_FOURTH_ALIEN,alien1.getAlienID());
		assertEquals(AlienList.THE_FIRST_ALIEN,alien2.getAlienID());
	}

	/**
	 * Test method for {@link it.polimi.ingsw.cg_10.model.player.Alien#setAlienID(it.polimi.ingsw.cg_10.model.player.AlienList)}.
	 */
	@Test
	public final void testSetAlienID() {
		Alien alien1 = new Alien(1);
		Alien alien2 = new Alien(2);
		alien1.setAlienID(AlienList.TEH_SECOND_ALIEN);
		alien2.setAlienID(AlienList.THE_THIRD_ALIEN);
		assertEquals(AlienList.TEH_SECOND_ALIEN,alien1.getAlienID());
		assertEquals(AlienList.THE_THIRD_ALIEN,alien2.getAlienID());	}

}
