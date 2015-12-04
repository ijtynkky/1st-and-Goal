/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PlayerLogic.DefenceStrategies;

import Objects.Field;
import Objects.Player;
import Objects.PlayerInfo;
import PlayerLogic.OffensiveStrategies.RouteRunner;
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
public class PassRusherTest {

    public PassRusherTest() {
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
     * Test of setRoute method, of class PassRusher.
     */
    @Test
    public void testSetRoute() {
        System.out.println("setRoute");
        String string = "666";
        PassRusher instance = new PassRusher(new int[]{666, 666}, "null");
        instance.setRoute(string);
    }

    /**
     * Test of getStartingLocation method, of class PassRusher.
     */
    @Test
    public void testGetStartingLocation() {
        System.out.println("getStartingLocation");
        PassRusher instance = new PassRusher(new int[]{666, 666}, "null");
        int[] expResult = new int[]{666, 666};
        int[] result = instance.getStartingLocation();
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of getNextMove method, of class PassRusher.
     */
    @Test
    public void testGetNextMove() {
        System.out.println("getNextMove");

        Field field = new Field(53, 20);

        PlayerInfo pManning = new PlayerInfo("Payton Manning", 18);
        int[] alkupaikka1 = {5, 3};
        RouteRunner testiOff = new RouteRunner(alkupaikka1, "4", "@");
        Player qb = new Player(pManning, testiOff);
        qb.setLocation(alkupaikka1);
        System.out.println("Payton on QB");
        qb.giveBall();
        field.addPlayerOffensive(1, qb);

        int[] playerLocation = new int[]{5, 20};
        PassRusher instance = new PassRusher(new int[]{5, 5}, "qb");
        int expResult = 2;
        int result = instance.getNextMove(field, playerLocation);
        assertEquals(expResult, result);
    }

    /**
     * Test of getIcon method, of class PassRusher.
     */
    @Test
    public void testGetIcon() {
        System.out.println("getIcon");
        PassRusher instance = new PassRusher(null, "VITTU");
        char expResult = 'V';
        char result = instance.getIcon();
        assertEquals(expResult, result);
    }

    /**
     * Test of getIsOffensive method, of class PassRusher.
     */
    @Test
    public void testGetIsOffensive() {
        System.out.println("getIsOffensive");
        PassRusher instance = new PassRusher(null, "null");
        boolean expResult = false;
        boolean result = instance.getIsOffensive();
        assertEquals(expResult, result);
   }

    /**
     * Test of playerMoved method, of class PassRusher.
     */
    @Test
    public void testPlayerMoved() {
        System.out.println("playerMoved");
        int[] where = null;
        PassRusher instance = new PassRusher(null, "null","666");
        instance.playerMoved(where);
    }

}
