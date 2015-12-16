/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PlayerLogic;

import Objects.Field;
import Objects.Player;
import Objects.PlayerInfo;
import PlayerLogic.DefenceStrategies.PassRusher;
import PlayerLogic.OffensiveStrategies.Quaterback;
import PlayerLogic.Tools.MovingTool;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import tools.DistanceTool;
import tools.Randomizer;

/**
 *
 * @author I
 */
public class QBMoverTest {

    public QBMoverTest() {
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
     * Test of passBoolean method, of class QBMover.
     */
    @Test
    public void testPassBoolean() {
        System.out.println("passBoolean");
        Field field = new Field(53, 20);
        QBMover instance = new QBMover(new MovingTool(), new Randomizer(), new DistanceTool());
        boolean expResult = false;
        boolean result = instance.passBoolean();
        assertEquals(expResult, result);
    }

    /**
     * Test of movePlayer method, of class QBMover.
     */
    @Test
    public void testMovePlayer() {
        System.out.println("movePlayer");
        Field field = new Field(53, 20);
        Player player = new Player(new PlayerInfo("String", 0, "QB"), new Quaterback(new int[]{1, 1}, "Q", "966", 3));
        field.addPlayerOffensive(1, player);
        QBMover instance = new QBMover(new MovingTool(), new Randomizer(), new DistanceTool());
        instance.movePlayer(field, player);
        int[] expResult = {2, 11};
        int[] result = player.getLocation();
        assertArrayEquals(expResult, result);
    }

    public void testMovePlayerWhitBall() {
        System.out.println("movePlayerWithBall");
        Field field = new Field(53, 20);
        Player player = new Player(new PlayerInfo("String", 0, "QB"), new Quaterback(new int[]{1, 1}, "Q", "966", 3));
        player.giveBall();
        field.addPlayerOffensive(1, player);
        QBMover instance = new QBMover(new MovingTool(), new Randomizer(), new DistanceTool());
        instance.movePlayer(field, player);
        int[] expResult = {2, 11};
        int[] result = player.getLocation();
        assertArrayEquals(expResult, result);
    }

    public void testMovePlayerWhitBallAndOpponent() {
        System.out.println("movePlayerWithBall");
        Field field = new Field(53, 20);
        Player playerDef = new Player(new PlayerInfo("String", 0, "LB"), new PassRusher(new int[]{5, 5}, "S"));
        Player player = new Player(new PlayerInfo("String", 0, "QB"), new Quaterback(new int[]{1, 1}, "Q", "966", 3));
        player.giveBall();
        field.addPlayerOffensive(1, player);
        playerDef.getDefPlayerStrategy().setStartingLocationByOppPlayerLocation(player);
        field.addPlayerDefensive(1, playerDef);

        QBMover instance = new QBMover(new MovingTool(), new Randomizer(), new DistanceTool());
        instance.movePlayer(field, player);
        int[] expResult = {2, 11};
        int[] result = player.getLocation();
        assertArrayEquals(expResult, result);
    }

}
