/**
 * 
 */
package it.polimi.ingsw.cg_10.modelTest.playerTest;

import it.polimi.ingsw.cg_10.model.player.Human;
import it.polimi.ingsw.cg_10.model.player.HumanList;

import org.junit.Test;

import junit.framework.TestCase;

/**
 * @author Francesco
 *
 */
public class HumanTest extends TestCase {


	/**
	 * Test method for {@link it.polimi.ingsw.cg_10.model.player.Human#Human(java.lang.Integer)}.
	 */
	@Test
	public final void testHuman() {
		Human human1 = new Human(1);
		Human human2 = new Human(2);
		Human human3 = new Human(3);
		Human human4 = new Human(4);
		Human human5 = new Human(5);
		human1.setAdrenaline(true);
		human2.setAlive(false);
		human3.setPlayerName("Carletto");
		human4.setSave(true);
		human5.setSedative(true);
		
		assertTrue(human1.isAdrenaline() && human1.isAlive() && !human1.getPlayerName().equals("Carletto") && !human1.isSave() && !human1.isSedative());
		assertTrue(!human2.isAdrenaline() && !human2.isAlive() && !human2.getPlayerName().equals("Carletto") && !human2.isSave() && !human2.isSedative());
		assertTrue(!human3.isAdrenaline() && human3.isAlive() && human3.getPlayerName().equals("Carletto") && !human3.isSave() && !human3.isSedative());
		assertTrue(!human4.isAdrenaline() && human4.isAlive() && !human4.getPlayerName().equals("Carletto") && human4.isSave() && !human4.isSedative());
		assertTrue(!human5.isAdrenaline() && human5.isAlive() && !human5.getPlayerName().equals("Carletto") && !human5.isSave() && human5.isSedative());
	}


	/**
	 * Test method for {@link it.polimi.ingsw.cg_10.model.player.Human#getHumanID()}.
	 */
	@Test
	public final void testGetHumanID() {
		Human human1 = new Human(1);
		assertEquals(null, human1.getHumanID());
		human1.setHumanID(HumanList.THE_PILOT);
		Human human2 = new Human(2);
		human2.setHumanID(HumanList.THE_SOLDIER);
		assertEquals(HumanList.THE_PILOT, human1.getHumanID());
		assertEquals(HumanList.THE_SOLDIER, human2.getHumanID());
	}

	/**
	 * Test method for {@link it.polimi.ingsw.cg_10.model.player.Human#setHumanID(it.polimi.ingsw.cg_10.model.player.HumanList)}.
	 */
	@Test
	public final void testSetHumanID() {
		Human human1 = new Human(1);
		human1.setHumanID(HumanList.THE_CAPTAIN);
		Human human2 = new Human(2);
		human2.setHumanID(HumanList.THE_PSYCHOLOGIST);
		assertEquals(HumanList.THE_CAPTAIN, human1.getHumanID());
		assertEquals(HumanList.THE_PSYCHOLOGIST, human2.getHumanID());
	}

	/**
	 * Test method for {@link it.polimi.ingsw.cg_10.model.player.Human#isSave()}.
	 */
	@Test
	public final void testIsSave() {
		Human human1 = new Human(1);
		assertFalse(human1.isSave());
		human1.setSave(true);
		assertTrue(human1.isSave());
	}

	/**
	 * Test method for {@link it.polimi.ingsw.cg_10.model.player.Human#setSave(boolean)}.
	 */
	@Test
	public final void testSetSave() {
		Human human1 = new Human(1);
		human1.setSave(true);
		assertTrue(human1.isSave());
		human1.setSave(false);
		assertFalse(human1.isSave());
	}

	/**
	 * Test method for {@link it.polimi.ingsw.cg_10.model.player.Human#isAdrenaline()}.
	 */
	@Test
	public final void testIsAdrenaline() {
		Human human1 = new Human(1);
		assertFalse(human1.isAdrenaline());
		human1.setAdrenaline(true);
		assertTrue(human1.isAdrenaline());
	}

	/**
	 * Test method for {@link it.polimi.ingsw.cg_10.model.player.Human#setAdrenaline(boolean)}.
	 */
	@Test
	public final void testSetAdrenaline() {
		Human human1 = new Human(1);
		human1.setAdrenaline(true);
		assertTrue(human1.isAdrenaline());
		human1.setAdrenaline(false);
		assertFalse(human1.isAdrenaline());
	}

	/**
	 * Test method for {@link it.polimi.ingsw.cg_10.model.player.Human#isSedative()}.
	 */
	@Test
	public final void testIsSedative() {
		Human human1 = new Human(1);
		assertFalse(human1.isSedative());
		human1.setSedative(true);
		assertTrue(human1.isSedative());
	}

	/**
	 * Test method for {@link it.polimi.ingsw.cg_10.model.player.Human#setSedative(boolean)}.
	 */
	@Test
	public final void testSetSedative() {
		Human human1 = new Human(1);
		human1.setSedative(true);
		assertTrue(human1.isSedative());
		human1.setSedative(false);
		assertFalse(human1.isSedative());
	}

}
