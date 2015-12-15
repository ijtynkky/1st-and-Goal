/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PlayerLogic.Tools;

import Objects.Field;
import Objects.Player;
import Objects.PlayerInfo;
import PlayerLogic.DefenceStrategies.PassRusher;
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
public class MovingToolTest {

    public MovingToolTest() {
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
     * Test of directonTowardsPointB method, of class MovingTool.
     */
    @Test
    public void testDirectonTowardsPointB() {
        System.out.println("directonTowardsPointB");
        int[] pointA = {0, 0};
        int[] pointB = {0, 5};
        MovingTool instance = new MovingTool();
        int expResult = 8;
        int result = instance.directonTowardsPointB(pointA, pointB);
        assertEquals(expResult, result);
    }

    /**
     * Test of directionTowardsPlayerWithBall method, of class MovingTool.
     */
    @Test
    public void testDirectionTowardsPlayerWithBall() {
        System.out.println("directionTowardsPlayerWithBall");
        Field field = new Field(53, 20);

        Player player = new Player(new PlayerInfo("String", 0, "String"), new RouteRunner(new int[]{1, 5}, "String", "String"));
        player.giveBall();
        field.addPlayerOffensive(1, player);
        int[] playerLocation = {1, 20};
        MovingTool instance = new MovingTool();
        int expResult = 2;
        int result = instance.directionTowardsPlayerWithBall(field, playerLocation);
        assertEquals(expResult, result);
    }

    /**
     * Test of towardsClosestOpponent method, of class MovingTool.
     */
    @Test
    public void testTowardsClosestOpponent() {
        System.out.println("towardsClosestOpponent");
        Field field = new Field(53, 20);

        Player player = new Player(new PlayerInfo("String", 0, "String"), new RouteRunner(new int[]{5, 1}, "String", "String"));
        Player player2 = new Player(new PlayerInfo("String", 0, "String"), new RouteRunner(new int[]{20, 1}, "String", "String"));

        field.addPlayerOffensive(1, player);
        field.addPlayerOffensive(2, player2);

        int[] playerLocation = {10, 10};
        Boolean isOffensive = false;
        MovingTool instance = new MovingTool();
        int expResult = 4;
        int result = instance.towardsClosestOpponent(field, playerLocation, isOffensive);
        assertEquals(expResult, result);
    }

    /**
     * Test of awayClosestOpponent method, of class MovingTool.
     */
    @Test
    public void testAwayClosestOpponent() {
        System.out.println("awayClosestOpponent");

        Field field = new Field(53, 20);
        Player player = new Player(new PlayerInfo("String", 0, "String"), new RouteRunner(new int[]{5, 5}, "String", "String"));
        field.addPlayerOffensive(1, player);

        Player player2 = new Player(new PlayerInfo("String", 0, "String"), new PassRusher(new int[]{5, 5}, "String", "String"));

        field.addPlayerOffensive(1, player);
        field.addPlayerOffensive(2, player2);

        MovingTool instance = new MovingTool();
        int expResult = 8;
        int result = instance.awayClosestOpponent(field, player2);
        assertEquals(expResult, result);
    }

}
