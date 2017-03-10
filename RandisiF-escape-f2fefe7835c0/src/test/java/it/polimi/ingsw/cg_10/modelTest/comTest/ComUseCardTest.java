package it.polimi.ingsw.cg_10.modelTest.comTest;


import it.polimi.ingsw.cg_10.model.com.ComUseCard;

import junit.framework.TestCase;

import org.junit.Test;


public class ComUseCardTest extends TestCase{
	
	public ComUseCardTest (String name){
		super (name);
	}

	@Test
	public final void testComUseCard() {
		ComUseCard comaction = new ComUseCard(0, "Asdrubale");
		
		assertEquals("Asdrubale",comaction.getUsername());
		assertEquals(0,comaction.getCardIdx());
		
		
		
	}
	public final void ComUseCard() {
		ComUseCard comaction = new ComUseCard(0, "Asdrubale");
		comaction.setCardIdx(1);
		comaction.setUsername("Ammaccabanane");
		assertEquals("Ammaccabanane",comaction.getUsername());
		assertEquals(1,comaction.getCardIdx());
		
		
		
	}
}
