package it.polimi.ingsw.cg_10.modelTest.comTest;

import junit.framework.TestCase;
import it.polimi.ingsw.cg_10.model.com.ComAction;


import org.junit.Test;

public class ComActionTest extends TestCase{
	
	public ComActionTest (String name){
		super (name);
	}

	@Test
	public final void testComActionUsername() {
		ComAction comaction = new ComAction();
		comaction.setUsername("Ammaccabanane");
		assertEquals("Ammaccabanane",comaction.getUsername());
	}
	
	@Test
	public final void testComActionSerialize() {
		ComAction comaction = new ComAction();
		comaction.setUsername("Ammaccabanane");
		String temp=comaction.serialize();
		ComAction newComAction= new ComAction();
		newComAction= comaction.deserialize(temp);
		assertEquals(newComAction.getUsername(),comaction.getUsername());
	}

}
