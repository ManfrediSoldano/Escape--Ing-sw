package it.polimi.ingsw.cg_10;

import it.polimi.ingsw.cg_10.modelTest.deckTest.DangerousSectorDeckTest;
import it.polimi.ingsw.cg_10.modelTest.deckTest.DeckTest;
import it.polimi.ingsw.cg_10.modelTest.deckTest.EscapeHatchDeckTest;
import it.polimi.ingsw.cg_10.modelTest.deckTest.ObjectDeckTest;
import it.polimi.ingsw.cg_10.modelTest.playerTest.ObjectHandTest;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
    	junit.textui.TestRunner.run(new DangerousSectorDeckTest("testDangerousSectorDeck"));
    	junit.textui.TestRunner.run(new ObjectDeckTest("testObjectDeck"));
    	junit.textui.TestRunner.run(new EscapeHatchDeckTest("testEscapeHatchDeck"));
    	junit.textui.TestRunner.run(new DeckTest("testRefreshDeck"));
    	junit.textui.TestRunner.run(new DeckTest("testDrawCard"));
    	junit.textui.TestRunner.run(new DeckTest("testUseCard"));
    	
    	junit.textui.TestRunner.run(new ObjectHandTest("testAddCardToHand"));
    	junit.textui.TestRunner.run(new ObjectHandTest("testRemoveCardFromHand"));
    }
}
