/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PlayerLogic;

import Objects.Player;
import Objects.PlayerInfo;
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
public class RouteReaderTest {

    public RouteReaderTest() {
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
     * Test of readRoute method, of class RouteReader.
     */
    @Test
    public void testReadRoute() {
        System.out.println("readRoute");

        PlayerInfo pManning = new PlayerInfo("Payton Manning", 18);
        int[] alkupaikka1 = {5, 5};
        PlayerStrategy testiOff = new PlayerStrategy(alkupaikka1, "123456789", true);
        Player qb = new Player(pManning, testiOff);
        System.out.println("payton on QB");
        RouteReader instance = new RouteReader();
        int expResult = 1;
        int result = instance.readRoute(qb);
        assertEquals(expResult, result);
    }

    @Test
    public void testReadRoute2() {
        System.out.println("readRoute");

        PlayerInfo pManning = new PlayerInfo("Payton Manning", 18);
        int[] alkupaikka1 = {5, 5};
        PlayerStrategy testiOff = new PlayerStrategy(alkupaikka1, "123456789", true);
        Player qb = new Player(pManning, testiOff);
        System.out.println("payton on QB");
        RouteReader instance = new RouteReader();
        qb.routeMoved();
        int expResult = 2;
        int result = instance.readRoute(qb);
        assertEquals(expResult, result);
    }

    @Test
    public void testReadRoute10() {
        System.out.println("readRoute");

        PlayerInfo pManning = new PlayerInfo("Payton Manning", 18);
        int[] alkupaikka1 = {5, 5};
        PlayerStrategy testiOff = new PlayerStrategy(alkupaikka1, "123456789", true);
        Player qb = new Player(pManning, testiOff);
        System.out.println("payton on QB");
        RouteReader instance = new RouteReader();
        qb.routeMoved();
        qb.routeMoved();
        qb.routeMoved();
        qb.routeMoved();
        qb.routeMoved();
        qb.routeMoved();
        qb.routeMoved();
        qb.routeMoved();
        qb.routeMoved();
        qb.routeMoved();
        qb.routeMoved();
        qb.routeMoved();
        qb.routeMoved();
        qb.routeMoved();
        qb.routeMoved();
        qb.routeMoved();
        int expResult = 999;
        int result = instance.readRoute(qb);
        assertEquals(expResult, result);
    }

}
