/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PlayerLogic.Strategies;

import PlayerLogic.OffensiveStrategies.RouteRunner;
import PlayerLogic.PlayerStrategy;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author I
 */
public class RouteRunnerTest {

    public RouteRunnerTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getStartingLocation method, of class RouteRunner.
     */
    @Test
    public void testGetStartingLocation() {
        System.out.println("getStartingLocation");
        int[] alku = {5, 5};
        PlayerStrategy testi = new RouteRunner(alku, "879987", "@");
        PlayerStrategy instance = testi;
        int[] expResult = {5, 5};
        int[] result = instance.getStartingLocation();
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of getNextMove method, of class RouteRunner.
     */
    @Test
    public void testGetNextMove() {
        System.out.println("getNextMove");
        int[] alku = {5, 5};
        PlayerStrategy testi = new RouteRunner(alku, "879987", "@");
        PlayerStrategy instance = testi;
        int expResult = 8;
        int result = instance.getNextMove(null, null);
        assertEquals(expResult, result);
    }

    /**
     * Test of getIcon method, of class RouteRunner.
     */
    @Test
    public void testGetIcon() {
        System.out.println("getIcon");
        RouteRunner instance = new RouteRunner(new int[]{5, 5}, "666", "G");
        char expResult = 'G';
        char result = instance.getIcon();
        assertEquals(expResult, result);
    }

    /**
     * Test of getIsOffensive method, of class RouteRunner.
     */
    @Test
    public void testGetIsOffensive() {
        System.out.println("getIsOffensive");
        RouteRunner instance = new RouteRunner("555");
        boolean expResult = true;
        boolean result = instance.getIsOffensive();
        assertEquals(expResult, result);
    }

    /**
     * Test of playerMoved method, of class RouteRunner.
     */
    @Test
    public void testPlayerMoved() {
        System.out.println("playerMoved");
        int[] where = {6, 6};
        RouteRunner instance = new RouteRunner(new int[]{5, 5}, "9", "@");
        instance.playerMoved(where);
        int expResult = 1;
        int result = instance.geMoveCounter();
    }

}
