/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PlayerLogic.OffensiveStrategies;

import Objects.Field;
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
public class QuaterbackTest {

    public QuaterbackTest() {
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
     * Test of addRoute method, of class Quaterback.
     */
    @Test
    public void testAddRoute() {
        System.out.println("addRoute");
        String string = "666";
        Quaterback instance = new Quaterback(new int[]{5, 5}, "String", "555555", 10);
        instance.addRoute(string);
    }

    /**
     * Test of getStartingLocation method, of class Quaterback.
     */
    @Test
    public void testGetStartingLocation() {
        System.out.println("getStartingLocation");
        Quaterback instance = new Quaterback(new int[]{5, 5}, "String", "555555", 10);
        int[] expResult = {5, 5};
        int[] result = instance.getStartingLocation();
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of getNextMove method, of class Quaterback.
     */
    @Test
    public void testGetNextMove() {
        System.out.println("getNextMove");
        Field field = new Field(53, 20);
        int[] playerLocation = {1, 1};
        Quaterback instance = new Quaterback(new int[]{5, 5}, "String", "555555", 10);
        int expResult = 5;
        int result = instance.getNextMove(field, playerLocation);
        assertEquals(expResult, result);
    }

    /**
     * Test of getIcon method, of class Quaterback.
     */
    @Test
    public void testGetIcon() {
        System.out.println("getIcon");
        Quaterback instance = new Quaterback(new int[]{5, 5}, "String", "555555", 10);
        char expResult = 'S';
        char result = instance.getIcon();
        assertEquals(expResult, result);
    }

    /**
     * Test of getIsOffensive method, of class Quaterback.
     */
    @Test
    public void testGetIsOffensive() {
        System.out.println("getIsOffensive");
        Quaterback instance = new Quaterback(new int[]{5, 5}, "String", "555555", 10);
        boolean expResult = true;
        boolean result = instance.getIsOffensive();
        assertEquals(expResult, result);
    }

    /**
     * Test of playerMoved method, of class Quaterback.
     */
    @Test
    public void testPlayerMoved() {
        System.out.println("playerMoved");
        int[] where = {5, 5};
        Quaterback instance = new Quaterback(new int[]{5, 5}, "String", "555555", 2);
        instance.playerMoved(where);
        instance.playerMoved(where);
        instance.playerMoved(where);
        instance.playerMoved(where);
        instance.playerMoved(where);
        instance.playerMoved(where);
        instance.playerMoved(where);
        int expResult = -5;
        int result = instance.getPassTimer();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPassTimer method, of class Quaterback.
     */
    @Test
    public void testGetPassTimer() {
        System.out.println("getPassTimer");
        Quaterback instance = new Quaterback(new int[]{5, 5}, "String", "555555", 2);
        int expResult = 2;
        int result = instance.getPassTimer();
        assertEquals(expResult, result);
    }

    /**
     * Test of setPassTarget method, of class Quaterback.
     */
    @Test
    public void testSetPassTarget() {
        System.out.println("setPassTarget");
        int player1to5 = 4;
        int proba = 100;
        Quaterback instance = new Quaterback(new int[]{5, 5}, "String", "555555", 2);
        instance.setPassTarget(player1to5, proba);
    }

    /**
     * Test of getPassTargets method, of class Quaterback.
     */
    @Test
    public void testGetPassTargets() {
        System.out.println("getPassTargets");
        Quaterback instance = new Quaterback(new int[]{5, 5}, "String", "555555", 2);
        int[] expResult = {0, 0, 0, 0, 0};
        int[] result = instance.getPassTargets();
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of hurryPass method, of class Quaterback.
     */
    @Test
    public void testHurryPass() {
        System.out.println("hurryPass");
        Quaterback instance = new Quaterback(new int[]{5, 5}, "String", "555555", 2);
        instance.hurryPass();
        int expResult = 1;
        int result = instance.getPassTimer();
        assertEquals(expResult, result);
    }

    /**
     * Test of delayPass method, of class Quaterback.
     */
    @Test
    public void testDelayPass() {
        System.out.println("delayPass");
        Quaterback instance = new Quaterback(new int[]{5, 5}, "String", "555555", 2);
        instance.delayPass();
        int expResult = 3;
        int result = instance.getPassTimer();
        assertEquals(expResult, result);
    }

}
