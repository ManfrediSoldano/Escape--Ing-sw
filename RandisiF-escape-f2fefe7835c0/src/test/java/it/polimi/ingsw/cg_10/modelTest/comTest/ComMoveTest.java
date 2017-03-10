package it.polimi.ingsw.cg_10.modelTest.comTest;


import it.polimi.ingsw.cg_10.model.com.ComAttack;

import it.polimi.ingsw.cg_10.model.map.Coordinate;
import junit.framework.TestCase;

import org.junit.Test;


public class ComMoveTest extends TestCase{
	
	public ComMoveTest (String name){
		super (name);
	}

	@Test
	public final void testMovetest() {
		Coordinate coordinate = new Coordinate();
		coordinate.setCoordX(2);
		coordinate.setCoordY(3);
		ComAttack comaction = new ComAttack(coordinate, "Asdrubale");
		comaction.setUsername("Ammaccabanane");
		
		assertEquals("Ammaccabanane",comaction.getUsername());
		assertEquals(coordinate,comaction.getCoordinata());
		assertEquals(coordinate.getCoordX(),2);
		assertEquals(coordinate.getCoordY(),3);
		
		
	}
	
	public final void testMovetestSet() {
		Coordinate coordinate = new Coordinate();
		coordinate.setCoordX(2);
		coordinate.setCoordY(3);
		ComAttack comaction = new ComAttack(coordinate, "Asdrubale");
		comaction.setUsername("Ammaccabanane");
		coordinate.setCoordX(6);
		coordinate.setCoordY(7);
		comaction.setCoordinata(coordinate);
		assertEquals("Ammaccabanane",comaction.getUsername());
		assertEquals(coordinate,comaction.getCoordinata());
		assertEquals(coordinate.getCoordX(),6);
		assertEquals(coordinate.getCoordY(),7);
		
		
	}
	
}
