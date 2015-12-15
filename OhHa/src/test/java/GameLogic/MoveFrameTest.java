/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameLogic;

import Objects.Field;
import Objects.Player;
import Objects.PlayerInfo;
import PlayerLogic.OffensiveStrategies.RouteRunner;
import PlayerLogic.PlayerStrategy;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import tools.DistanceTool;

/**
 *
 * @author I
 */
public class MoveFrameTest {

    public MoveFrameTest() {
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
     * Test of getContinuePlay method, of class MoveFrame.
     */
    @Test
    public void testGetContinuePlay() {
        System.out.println("getContinuePlay");
        MoveFrame instance = new MoveFrame(new Field(53, 20), new DistanceTool());
        boolean expResult = true;
        boolean result = instance.getContinuePlay();
        assertEquals(expResult, result);
    }

    /**
     * Test of move method, of class MoveFrame.
     */
    @Test
    public void testMove() {
        System.out.println("move");
        Field gameField = new Field(53, 20);
        int i = 0;
        int[] expResult = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        while (i < 9) {
            PlayerStrategy strategy = new RouteRunner(new int[]{i, i}, "8", "8");
            Player player = new Player(new PlayerInfo("String", 0, "WR"), strategy);
            gameField.addPlayerOffensive(i + 1, player);
            expResult[i] = (player.getLocation()[1] + 1);
            System.out.println(expResult[i]);
            i++;
//            System.out.println(player.getLocation()[0] + " " + player.getLocation()[1]);
//            System.out.println(player.getLocation()[0] + " " + player.getLocation()[1] + 1);

        }
        gameField.getPlayers().get(3).giveBall();
        MoveFrame instance = new MoveFrame(gameField, new DistanceTool());
        instance.move(gameField);
        int[] result = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        i = 0;
        while (i < 9) {
            //           System.out.println(gameField.getPlayerOff(i + 1).getLocation()[0] + " " + gameField.getPlayerOff(i + 1).getLocation()[1]);
            result[i] = gameField.getPlayerOff(i + 1).getLocation()[1];
            System.out.println(result[i]);
            i++;

        }
        expResult[0] = expResult[0] - 1;
        i = 0;
        while (i < 11) {
            System.out.println(result[i] + " oletettu: " + expResult[i]);
            i++;
        }
        assertArrayEquals(expResult,result);
    }

}
