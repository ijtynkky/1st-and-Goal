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
public class ZoneCoverTest {

    public ZoneCoverTest() {
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
     * Test of setZoneCenter method, of class ZoneCover.
     */
    @Test
    public void testSetZoneCenter() {
        System.out.println("setZoneCenter");
        int[] center = {666, 666};
        ZoneCover instance = new ZoneCover(new int[]{1, 1}, "String");
        instance.setZoneCenter(center);
    }

    /**
     * Test of setPlayerToFollow method, of class ZoneCover.
     */
    @Test
    public void testSetPlayerToFollow() {
        System.out.println("setPlayerToFollow");
        Player player = new Player(new PlayerInfo("String", 0, "String"), new ZoneCover(new int[]{1, 1}, "String"));
        ZoneCover instance = new ZoneCover(new int[]{666, 666}, "String");
        instance.setPlayerToFollow(player);
    }

    /**
     * Test of getStartingLocation method, of class ZoneCover.
     */
    @Test
    public void testGetStartingLocation() {
        System.out.println("getStartingLocation");
        ZoneCover instance = new ZoneCover(new int[]{666, 666}, "String");
        int[] expResult = {666, 666};
        int[] result = instance.getStartingLocation();
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of getNextMove method, of class ZoneCover.
     */
    @Test
    public void testGetNextMove() {
        System.out.println("getNextMove");
        Field field = new Field(53, 20);

        Player qb = new Player(new PlayerInfo("String", 0, "String"), new RouteRunner(new int[]{1, 1}, "String", "55555"));
        qb.giveBall();
        field.addPlayerOffensive(1, qb);

        ZoneCover instance = new ZoneCover(new int[]{1, 1}, "String");
        instance.setZoneCenter(new int[]{1,21});
        int expResult = 8;
        int result = instance.getNextMove(field, new int[]{1,20});
        assertEquals(expResult, result);
    }

    /**
     * Test of getIcon method, of class ZoneCover.
     */
    @Test
    public void testGetIcon() {
        System.out.println("getIcon");
        ZoneCover instance = new ZoneCover(new int[]{666, 666}, "String");
        char expResult = 'S';
        char result = instance.getIcon();
        assertEquals(expResult, result);
    }

    /**
     * Test of getIsOffensive method, of class ZoneCover.
     */
    @Test
    public void testGetIsOffensive() {
        System.out.println("getIsOffensive");
        ZoneCover instance = new ZoneCover(new int[]{666, 666}, "String");
        boolean expResult = false;
        boolean result = instance.getIsOffensive();
        assertEquals(expResult, result);
    }

    /**
     * Test of playerMoved method, of class ZoneCover.
     */
    @Test
    public void testPlayerMoved() {
        System.out.println("playerMoved");
        int[] where = {1, 1};
        ZoneCover instance = new ZoneCover(new int[]{666, 666}, "String");
        instance.playerMoved(where);
    }

}
