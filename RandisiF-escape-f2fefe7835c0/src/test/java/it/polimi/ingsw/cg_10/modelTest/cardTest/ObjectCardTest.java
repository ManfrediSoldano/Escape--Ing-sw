package it.polimi.ingsw.cg_10.modelTest.cardTest;

import static org.junit.Assert.*;
import it.polimi.ingsw.cg_10.model.card.ObjectCard;
import it.polimi.ingsw.cg_10.model.card.ObjectCardType;

import org.junit.Test;

public class ObjectCardTest {

	@Test
	public void test() {
		ObjectCard oc = new ObjectCard(ObjectCardType.ADRENALINE);
		assertEquals(oc.getObjType(), ObjectCardType.ADRENALINE);
	}

}
