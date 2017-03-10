package it.polimi.ingsw.cg_10.modelTest.comTest;


import it.polimi.ingsw.cg_10.model.com.ComChat;

import junit.framework.TestCase;

import org.junit.Test;


public class ComDrawCardTest extends TestCase{
	
	public ComDrawCardTest (String name){
		super (name);
	}

	@Test
	public final void testComDrawcard() {
		ComChat comaction = new ComChat("testo da inserire inchat", "Asdrubale");
		
		assertEquals("Asdrubale",comaction.getUsername());
		assertEquals("testo da inserire inchat",comaction.getTesto());

		
		
	}
	
	@Test
	public final void testComDrawCardTest() {
		ComChat comaction = new ComChat("testo da inserire inchat", "Asdrubale");
		comaction.setTesto("La chat ama i setter e getter");
		comaction.setUsername("Hofinalmenteaggiustatolabarraspaziatricemaporcaputt");
		assertEquals("Hofinalmenteaggiustatolabarraspaziatricemaporcaputt",comaction.getUsername());
		assertEquals("La chat ama i setter e getter",comaction.getTesto());

		
		
	}
	
}
