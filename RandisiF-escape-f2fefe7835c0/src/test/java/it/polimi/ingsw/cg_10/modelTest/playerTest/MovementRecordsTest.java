/**
 * 
 */
package it.polimi.ingsw.cg_10.modelTest.playerTest;

import static org.junit.Assert.*;
import it.polimi.ingsw.cg_10.model.player.MovementRecords;
import it.polimi.ingsw.cg_10.model.player.PlayerRecord;

import org.junit.Test;

/**
 * @author Francesco
 *
 */
public class MovementRecordsTest {

	/**
	 * Test method for {@link it.polimi.ingsw.cg_10.model.player.MovementRecords#MovementRecords()}.
	 */
	@Test
	public final void testMovementRecords() {
		MovementRecords movementRecords = new MovementRecords();
		movementRecords.getMovementList().add(new PlayerRecord(1));
		movementRecords.getMovementList().add(new PlayerRecord(2));
		movementRecords.getMovementList().add(new PlayerRecord(3));
		movementRecords.getMovementList().add(new PlayerRecord(4));
		assertEquals(4, movementRecords.getMovementList().size());
	}

	/**
	 * Test method for {@link it.polimi.ingsw.cg_10.model.player.MovementRecords#getLastPlayerRecord()}.
	 */
	@Test
	public final void testGetLastPlayerRecord() {
		MovementRecords movementRecords = new MovementRecords();
		movementRecords.getMovementList().add(new PlayerRecord(1));
		movementRecords.getMovementList().add(new PlayerRecord(2));
		movementRecords.getMovementList().add(new PlayerRecord(3));
		movementRecords.getMovementList().add(new PlayerRecord(4));
		assertEquals(4, movementRecords.getLastPlayerRecord().getRecordID());
		
		movementRecords.getMovementList().clear();
		assertEquals(null, movementRecords.getLastPlayerRecord());
	}
	
	/**
	 * Test method for {@link it.polimi.ingsw.cg_10.model.player.MovementRecords#getMovementList)}.
	 */
	@Test
	public final void testGetMovementList() {
		MovementRecords movementRecords = new MovementRecords();
		movementRecords.getMovementList().add(new PlayerRecord(1));
		movementRecords.getMovementList().add(new PlayerRecord(2));
		assertEquals(2, movementRecords.getMovementList().size());
		movementRecords.getMovementList().add(new PlayerRecord(3));
		movementRecords.getMovementList().add(new PlayerRecord(4));
		assertEquals(4, movementRecords.getMovementList().size());
		
		movementRecords.getMovementList().clear();
		assertEquals(0, movementRecords.getMovementList().size());
	}

}
