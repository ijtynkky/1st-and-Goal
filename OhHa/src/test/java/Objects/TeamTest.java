/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;

import java.util.ArrayList;
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
public class TeamTest {

    public TeamTest() {
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
     * Test of addPlayer method, of class Team.
     */
    @Test
    public void testAddPlayer() {
        System.out.println("addPlayer");
        PlayerInfo player = new PlayerInfo("testi", 1, "WR");
        Team instance = new Team("testitiimi");
        boolean expResult = true;
        boolean result = instance.addPlayer(player);
        assertEquals(expResult, result);
    }

    /**
     * Test of getPlayersByPosition method, of class Team.
     */
    @Test
    public void testGetPlayersByPosition() {
        System.out.println("getPlayersByPosition");
        String position = "WR";
        PlayerInfo player = new PlayerInfo("testi", 1, "WR");
        PlayerInfo player2 = new PlayerInfo("testi2", 2, "QB");
        Team instance = new Team("testitiimi");
        instance.addPlayer(player);
        instance.addPlayer(player2);

        ArrayList<PlayerInfo> expResult = new ArrayList();
        expResult.add(player);
        ArrayList<PlayerInfo> result = instance.getPlayersByPosition(position);
        assertEquals(expResult, result);
    }

}
