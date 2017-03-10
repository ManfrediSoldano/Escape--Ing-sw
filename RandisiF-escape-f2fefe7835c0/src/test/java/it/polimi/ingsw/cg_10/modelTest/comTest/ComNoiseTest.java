package it.polimi.ingsw.cg_10.modelTest.comTest;


import it.polimi.ingsw.cg_10.model.com.ComNoise;

import it.polimi.ingsw.cg_10.model.map.Coordinate;
import junit.framework.TestCase;

import org.junit.Test;


public class ComNoiseTest extends TestCase{
	
	public ComNoiseTest (String name){
		super (name);
	}

	@Test
	public final void testNoise() {
		Coordinate coordinate = new Coordinate();
		coordinate.setCoordX(2);
		coordinate.setCoordY(3);
		ComNoise comaction = new ComNoise(coordinate, "Asdrubale");
		comaction.setUsername("Ammaccabanane");
		
		assertEquals("Ammaccabanane",comaction.getUsername());
		assertEquals(coordinate,comaction.getCoordinata());
		assertEquals(coordinate.getCoordX(),2);
		assertEquals(coordinate.getCoordY(),3);
		
		
	}
	
	@Test
	public final void testNoiseSet() {
		Coordinate coordinate = new Coordinate();
		coordinate.setCoordX(2);
		coordinate.setCoordY(3);
		ComNoise comaction = new ComNoise(coordinate, "Asdrubale");
		comaction.setUsername("Ammaccabanane");
		coordinate.setCoordX(5);
		coordinate.setCoordY(6);
		comaction.setCoordinata(coordinate);
		
		assertEquals("Ammaccabanane",comaction.getUsername());
		assertEquals(coordinate,comaction.getCoordinata());
		assertEquals(coordinate.getCoordX(),5);
		assertEquals(coordinate.getCoordY(),6);
		
		
	}
	
}
