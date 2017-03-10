package it.polimi.ingsw.cg_10.modelTest.comTest;


import it.polimi.ingsw.cg_10.model.com.ComEndTurn;
import junit.framework.TestCase;

import org.junit.Test;


public class ComFirstConnectionTest extends TestCase{
	
	public ComFirstConnectionTest (String name){
		super (name);
	}

	@Test
	public final void testConnection() {
		
		ComEndTurn comaction = new ComEndTurn("Asdrubale");		
		assertEquals("Asdrubale",comaction.getUsername());


		
		
	}
	public final void testCofirstconnectoinSet() {
		
		ComEndTurn comaction = new ComEndTurn("Asdrubale");	
		comaction.setUsername("ZioMichele");
		assertEquals("ZioMichele",comaction.getUsername());


		
		
	}
	
}
