/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PlayerLogic;

import PlayerLogic.Tools.RouteReader;
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
        RouteReader instance = new RouteReader();
        int expResult = 1;
        int result = instance.readRoute("123346", 0);
        assertEquals(expResult, result);
    }

    @Test
    public void testReadRoute2() {
        System.out.println("readRoute");

        String route = "12345678";
        RouteReader instance = new RouteReader();
        int expResult = 5;
        int result = instance.readRoute(route, 4);
        assertEquals(expResult, result);
    }
}
