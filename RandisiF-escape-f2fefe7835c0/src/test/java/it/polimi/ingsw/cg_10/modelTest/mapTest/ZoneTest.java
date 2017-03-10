/**
 * 
 */
package it.polimi.ingsw.cg_10.modelTest.mapTest;

import it.polimi.ingsw.cg_10.controller.logic.ZoneCreator;
import it.polimi.ingsw.cg_10.model.map.AlienSector;
import it.polimi.ingsw.cg_10.model.map.Coordinate;
import it.polimi.ingsw.cg_10.model.map.EscapeHatchSector;
import it.polimi.ingsw.cg_10.model.map.HumanSector;
import it.polimi.ingsw.cg_10.model.map.Sector;
import it.polimi.ingsw.cg_10.model.map.VoidSector;
import it.polimi.ingsw.cg_10.model.map.Zone;

import java.util.ArrayList;

import org.junit.Test;

import junit.framework.TestCase;

/**
 * @author Francesco
 *
 */
public class ZoneTest extends TestCase {

	/**
	 * Test method for {@link it.polimi.ingsw.cg_10.model.map.Zone#Zone(java.lang.String)}.
	 */
	@Test
	public final void testZone() {
		Zone zone = new Zone("zona di test");
		assertEquals("zona di test", zone.getName().toString());
	}

	/**
	 * Test method for {@link it.polimi.ingsw.cg_10.model.map.Zone#addSector(it.polimi.ingsw.cg_10.model.map.Sector)}.
	 */
	@Test
	public final void testAddSector() {
		Zone zone = new Zone("zona di test");
		VoidSector voidSector = new VoidSector(new Coordinate());
		zone.addSector(voidSector);
		assertTrue(zone.getSectors().contains(voidSector));
	}

	/**
	 * Test method for {@link it.polimi.ingsw.cg_10.model.map.Zone#getSectors()}.
	 */
	@Test
	public final void testGetSectors() {
		Zone zone = new Zone("zona di test");
		VoidSector voidSector;
		for(int i=0;i<300;i++){
			voidSector = new VoidSector(new Coordinate());
			zone.addSector(voidSector);
		}
		assertEquals(300, zone.getSectors().size());
	}

	/**
	 * Test method for {@link it.polimi.ingsw.cg_10.model.map.Zone#getName()}.
	 */
	@Test
	public final void testGetName() {
		Zone zone = new Zone("zona di test");
		assertEquals("zona di test", zone.getName().toString());
	}

	/**
	 * Test method for {@link it.polimi.ingsw.cg_10.model.map.Zone#getSpecificSector(it.polimi.ingsw.cg_10.model.map.Sector)}.
	 */
	@Test
	public final void testGetSpecificSector() {
		Zone zone = new Zone("galilei");
		
		HumanSector hs = new HumanSector(new Coordinate());
		ArrayList<Sector> sectorsList= zone.getSpecificSector(hs);
		for (int i=0; i<sectorsList.size(); i++){
			assertTrue (sectorsList.get(i) instanceof HumanSector);
		}
		
		AlienSector as = new AlienSector(new Coordinate());
		sectorsList= zone.getSpecificSector(as);
		for (int i=0; i<sectorsList.size(); i++){
			assertTrue (sectorsList.get(i) instanceof AlienSector);
		}
		
		EscapeHatchSector es = new EscapeHatchSector(new Coordinate(), 0);
		sectorsList= zone.getSpecificSector(es);
		for (int i=0; i<sectorsList.size(); i++){
			assertTrue (sectorsList.get(i) instanceof EscapeHatchSector);
		}
	}
	/**
	 * Test method for {@link it.polimi.ingsw.cg_10.model.map.Zone#toString()}.
	 */
	@Test
	public final void testToString() {
		ZoneCreator zoneCreator = new ZoneCreator();
		Zone zone = zoneCreator.zoneCreator("galilei");
		assertTrue(zone.getName().toString().contains("galilei"));
	}

}
