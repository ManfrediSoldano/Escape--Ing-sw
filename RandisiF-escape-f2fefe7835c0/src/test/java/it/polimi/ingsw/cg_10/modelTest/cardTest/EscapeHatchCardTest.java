package it.polimi.ingsw.cg_10.modelTest.cardTest;

import static org.junit.Assert.*;
import it.polimi.ingsw.cg_10.model.card.EscapeHatchCard;
import it.polimi.ingsw.cg_10.model.card.EscapeHatchCardType;

import org.junit.Test;

public class EscapeHatchCardTest {

	@Test
	public void test() {
		EscapeHatchCard ehc = new EscapeHatchCard(EscapeHatchCardType.GREEN);
		assertEquals(EscapeHatchCardType.GREEN,ehc.getEHCType());
	}

}
