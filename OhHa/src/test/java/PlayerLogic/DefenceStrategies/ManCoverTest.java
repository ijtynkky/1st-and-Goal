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
public class ManCoverTest {

    public ManCoverTest() {
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
     * Test of getNextMove method, of class ManCover.
     */
    @Test
    public void testGetNextMove() {
        System.out.println("getNextMove");

        PlayerInfo pManning = new PlayerInfo("Payton Manning", 18);
        int[] alkupaikka1 = {5, 5};
        RouteRunner testiOff = new RouteRunner(alkupaikka1, "879987", "G");
        Player qb = new Player(pManning, testiOff);
        System.out.println("Payton on QB");
        Field field = new Field(53, 20);
        field.addPlayerOffensive(1, qb);

        int[] playerLocation = new int[]{5, 20};
        ManCover instance = new ManCover(new int[]{5, 5}, "J");
        instance.setPlayerToFollow(qb);
        int expResult = 2;
        int result = instance.getNextMove(field, playerLocation);
        assertEquals(expResult, result);
    }

    /**
     * Test of getStartingLocation method, of class ManCover.
     */
    @Test
    public void testGetStartingLocation() {
        System.out.println("getStartingLocation");
        ManCover instance = new ManCover(new int[]{5, 5}, "null");
        int[] expResult = {5, 5};
        int[] result = instance.getStartingLocation();
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of getIcon method, of class ManCover.
     */
    @Test
    public void testGetIcon() {
        System.out.println("getIcon");
        ManCover instance = new ManCover(null, "J");
        char expResult = 'J';
        char result = instance.getIcon();
        assertEquals(expResult, result);
    }

    /**
     * Test of getIsOffensive method, of class ManCover.
     */
    @Test
    public void testGetIsOffensive() {
        System.out.println("getIsOffensive");
        ManCover instance = new ManCover(null, "null");
        boolean expResult = false;
        boolean result = instance.getIsOffensive();
        assertEquals(expResult, result);
    }

    /**
     * Test of playerMoved method, of class ManCover.
     */
    @Test
    public void testPlayerMoved() {
        System.out.println("playerMoved");
        int[] where = new int[]{666, 666};
        ManCover instance = new ManCover(new int[]{5, 5}, "J");
        instance.playerMoved(where);
    }

}
