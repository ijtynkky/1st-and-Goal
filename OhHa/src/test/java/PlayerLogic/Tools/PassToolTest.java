/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PlayerLogic.Tools;

import Objects.Field;
import Objects.Player;
import Objects.PlayerInfo;
import PlayerLogic.OffensiveStrategies.Quaterback;
import PlayerLogic.OffensiveStrategies.RouteRunner;
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
public class PassToolTest {

    public PassToolTest() {
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
     * Test of pass method, of class PassTool.
     */
    @Test
    public void testPass() {
        System.out.println("pass");
        Field field = new Field(53, 20);
        Player player = new Player(new PlayerInfo("String", 0, "QB"), new Quaterback(new int[]{1, 1}, "Q", "966", 3));
        player.giveBall();
        player.getQBStrategy().setPassTarget(1, 100);
        field.addPlayerOffensive(1, player);

        Player playerWR = new Player(new PlayerInfo("String", 0, "WR"), new RouteRunner(new int[]{2, 1}, "W", "966"));
        field.addPlayerOffensive(7, playerWR);
        field.addPlayerOffensive(8, playerWR);
        field.addPlayerOffensive(9, playerWR);
        field.addPlayerOffensive(10, playerWR);
        field.addPlayerOffensive(11, playerWR);

        PassTool instance = new PassTool(new DistanceTool());
        boolean expResult = true;
        boolean result = instance.pass(field, player);
        assertEquals(expResult, result);
    }

    /**
     * Test of passBall method, of class PassTool.
     */
    @Test
    public void testPassBall() {
        System.out.println("passBall");
        Field field = new Field(53, 20);
        Player passer = new Player(new PlayerInfo("String", 0, "QB"), new Quaterback(new int[]{1, 1}, "Q", "966", 3));
        passer.giveBall();
        passer.getQBStrategy().setPassTarget(1, 100);
        field.addPlayerOffensive(1, passer);

        Player reseiver = new Player(new PlayerInfo("String", 0, "WR"), new RouteRunner(new int[]{2, 1}, "W", "966"));
        field.addPlayerOffensive(7, reseiver);

        PassTool instance = new PassTool(new DistanceTool());
        boolean expResult = true;
        boolean result = instance.passBall(field, passer, reseiver);
        assertEquals(expResult, result);
    }

}
