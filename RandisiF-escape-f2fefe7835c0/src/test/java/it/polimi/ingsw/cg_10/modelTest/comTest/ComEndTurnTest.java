package it.polimi.ingsw.cg_10.modelTest.comTest;


import it.polimi.ingsw.cg_10.model.com.ComEndTurn;
import junit.framework.TestCase;

import org.junit.Test;


public class ComEndTurnTest extends TestCase{
	
	public ComEndTurnTest (String name){
		super (name);
	}

	@Test
	public final void testEndTurn() {
		
		ComEndTurn comaction = new ComEndTurn("Asdrubale");		
		assertEquals("Asdrubale",comaction.getUsername());


		
		
	}
	
	public final void testEndTurnSet() {
		
		ComEndTurn comaction = new ComEndTurn("Asdrubale");	
		comaction.setUsername("NessunoLeggeràMaiQuesto");
		assertEquals("NessunoLeggeràMaiQuesto",comaction.getUsername());


		
		
	}
	
}
