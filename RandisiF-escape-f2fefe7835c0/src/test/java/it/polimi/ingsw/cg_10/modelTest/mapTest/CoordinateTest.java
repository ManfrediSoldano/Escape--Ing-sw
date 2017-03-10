/**
 * 
 */
package it.polimi.ingsw.cg_10.modelTest.mapTest;

import it.polimi.ingsw.cg_10.model.map.Coordinate;

import org.junit.Test;

import junit.framework.TestCase;

/**
 * @author Francesco
 *
 */
public class CoordinateTest extends TestCase {

	/**
	 * Test method for {@link it.polimi.ingsw.cg_10.model.map.Coordinate#Coordinate(int, int)}.
	 */
	@Test
	public final void testCoordinateIntInt() {
		Coordinate coordinate = new Coordinate(4,6);
		assertEquals(4, coordinate.getCoordX());
		assertEquals(6, coordinate.getCoordY());
	}

	/**
	 * Test method for {@link it.polimi.ingsw.cg_10.model.map.Coordinate#Coordinate()}.
	 */
	@Test
	public final void testCoordinate() {
		Coordinate coordinate = new Coordinate();
		coordinate.setCoordX(5);
		coordinate.setCoordY(44);
		assertEquals(5, coordinate.getCoordX());
		assertEquals(44, coordinate.getCoordY());

	}

	/**
	 * Test method for {@link it.polimi.ingsw.cg_10.model.map.Coordinate#getCoordX()}.
	 */
	@Test
	public final void testGetCoordX() {
		Coordinate coordinate = new Coordinate(0,0);
		assertEquals(0, coordinate.getCoordX());
		coordinate.setCoordX(6);
		assertEquals(6, coordinate.getCoordX());
		coordinate.setCoordX(33);
		assertEquals(33, coordinate.getCoordX());
		coordinate.setCoordX(-33);
		assertEquals(-33, coordinate.getCoordX());
	}

	/**
	 * Test method for {@link it.polimi.ingsw.cg_10.model.map.Coordinate#setCoordX(java.lang.Integer)}.
	 */
	@Test
	public final void testSetCoordX() {
		Coordinate coordinate = new Coordinate(0,0);
		coordinate.setCoordX(6);
		assertEquals(6, coordinate.getCoordX());
		coordinate.setCoordX(33);
		assertEquals(33, coordinate.getCoordX());
		coordinate.setCoordX(-33);
		assertEquals(-33, coordinate.getCoordX());
	}

	/**
	 * Test method for {@link it.polimi.ingsw.cg_10.model.map.Coordinate#getCoordY()}.
	 */
	@Test
	public final void testGetCoordY() {
		Coordinate coordinate = new Coordinate(0,0);
		assertEquals(0, coordinate.getCoordY());
		coordinate.setCoordY(6);
		assertEquals(6, coordinate.getCoordY());
		coordinate.setCoordY(33);
		assertEquals(33, coordinate.getCoordY());
		coordinate.setCoordY(-33);
		assertEquals(-33, coordinate.getCoordY());
	}

	/**
	 * Test method for {@link it.polimi.ingsw.cg_10.model.map.Coordinate#setCoordY(java.lang.Integer)}.
	 */
	@Test
	public final void testSetCoordY() {
		Coordinate coordinate = new Coordinate(0,0);
		coordinate.setCoordY(6);
		assertEquals(6, coordinate.getCoordY());
		coordinate.setCoordY(33);
		assertEquals(33, coordinate.getCoordY());
		coordinate.setCoordY(-33);
		assertEquals(-33, coordinate.getCoordY());
	}

	/**
	 * Test method for {@link it.polimi.ingsw.cg_10.model.map.Coordinate#fromCoordToArrayIdx()}.
	 */
	@Test
	public final void testFromCoordToArrayIdx() {
		int idx=0;
		for(int y=0; y<16; y++){
			for (int x=0; x<25; x++){
				assertEquals(idx, new Coordinate(x, y).fromCoordToArrayIdx());
				idx++;
			}				
		}
	}

	/**
	 * Test method for {@link it.polimi.ingsw.cg_10.model.map.Coordinate#toString()}.
	 */
	@Test
	public final void testToString() {
		assertEquals("A02", new Coordinate(1,2).toString());
		assertEquals("E07", new Coordinate(5,7).toString());
		assertEquals("D03", new Coordinate(4,3).toString());
	}

}
