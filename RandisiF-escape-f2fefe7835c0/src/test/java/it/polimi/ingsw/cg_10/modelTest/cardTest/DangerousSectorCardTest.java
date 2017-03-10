package it.polimi.ingsw.cg_10.modelTest.cardTest;

import static org.junit.Assert.*;
import it.polimi.ingsw.cg_10.model.card.DangerousSectorCard;
import it.polimi.ingsw.cg_10.model.card.DangerousSectorCardType;

import org.junit.Test;

public class DangerousSectorCardTest {

	@Test
	public void test() {
		DangerousSectorCard dsc = new DangerousSectorCard(DangerousSectorCardType.NOISEANYSECTOR, true);
		assertEquals(dsc.getDSCType(),DangerousSectorCardType.NOISEANYSECTOR);

	}

}
