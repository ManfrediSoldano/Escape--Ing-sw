package it.polimi.ingsw.cg_10.modelTest.comTest;



import it.polimi.ingsw.cg_10.model.com.ComChooseRoom;

import junit.framework.TestCase;

import org.junit.Test;


public class ComChooseRoomTest extends TestCase{
	
	public ComChooseRoomTest (String name){
		super (name);
	}

	@Test
	public final void testComChooseRoom() {
		
		ComChooseRoom comaction = new ComChooseRoom(0,"Asdrubale",true,true,"galilei");
		
		assertEquals("Asdrubale",comaction.getUsername());
		assertEquals("galilei",comaction.getMappa());
		assertTrue(comaction.getAdvancedGame());
		assertTrue(comaction.getNewRoom());
		assertEquals(0,comaction.getRoom());
		

		
		
	}
	
	@Test
	public final void testComChooseRoomTest() {
		
		ComChooseRoom comaction = new ComChooseRoom(0,"Asdrubale",true,true,"galilei");
		
		assertEquals("Asdrubale",comaction.getUsername());
		assertEquals("galilei",comaction.getMappa());
		assertTrue(comaction.getAdvancedGame());
		assertTrue(comaction.getNewRoom());
		assertEquals(0,comaction.getRoom());
		

		
		
	}
	
}
