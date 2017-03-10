package it.polimi.ingsw.cg_10.modelTest.comTest;


import it.polimi.ingsw.cg_10.model.com.ComMove;
import it.polimi.ingsw.cg_10.model.map.Coordinate;
import junit.framework.TestCase;

import org.junit.Test;


public class ComAttacktest extends TestCase{
	
	public ComAttacktest (String name){
		super (name);
	}

	@Test
	public final void testComActionCoordinate() {
		Coordinate coordinate = new Coordinate();
		coordinate.setCoordX(2);
		coordinate.setCoordY(3);
		ComMove comaction = new ComMove(coordinate, "Asdrubale");
		comaction.setUsername("Ammaccabanane");
		
		assertEquals("Ammaccabanane",comaction.getUsername());
		assertEquals(coordinate,comaction.getCoordinate());
		assertEquals(coordinate.getCoordX(),2);
		assertEquals(coordinate.getCoordY(),3);
		
		
	}
	
}
