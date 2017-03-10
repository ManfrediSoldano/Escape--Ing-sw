package it.polimi.ingsw.cg_10.modelTest.comTest;


import it.polimi.ingsw.cg_10.model.com.ComServerReply;


import junit.framework.TestCase;

import org.junit.Test;


public class ComServerReplyTest extends TestCase{
	
	public ComServerReplyTest (String name){
		super (name);
	}


	@Test
	public final void testComServerReply() {

		
		ComServerReply comaction = new ComServerReply("Asdrubale",true);
		
		assertEquals("Asdrubale",comaction.getReply());
		assertTrue(comaction.getConferma());
		
	}
	
	@Test
	public final void testComServerReplySet() {

		
		ComServerReply comaction = new ComServerReply("Asdrubale",true);
		comaction.setConferma(false);
		comaction.setReply("OtorinoLaringoiatra");
		
		assertEquals("OtorinoLaringoiatra",comaction.getReply());
		assertFalse(comaction.getConferma());
		
	}
	
}
