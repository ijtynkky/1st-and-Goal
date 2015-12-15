/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import Objects.Field;
import PlayerLogic.PlayerStrategy;
import java.io.File;
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
public class StrategyReaderTest {

    public StrategyReaderTest() {
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
     * Test of getStrategy method, of class StrategyReader.
     */
    @Test
    public void testGetStrategy() throws Exception {
        Field field = new Field(10, 10);
        System.out.println("getStrategy");
        String strategyName = "player1";
        StrategyReader instance = new StrategyReader(new File("C:\\Users\\I\\Documents\\GitHub\\1st-and-Goal\\OhHa\\Files\\TestFiles\\TestiOff2.txt"));
        boolean expResult = true;
        boolean result = true;
        PlayerStrategy playerStrategy = instance.getStrategy(strategyName);
        if (playerStrategy.getIcon() != 'B') {
            result = false;
            System.out.println("Icon false");
            System.out.println(playerStrategy.getIcon() + "");
        }
        if (playerStrategy.getIsOffensive() != true) {
            result = false;
            System.out.println("off false");
        }
        int[] haluttuLokaatio = new int[]{27, 2};
        if (playerStrategy.getStartingLocation().equals(haluttuLokaatio)) {
            result = false;
            System.out.println("haluttu: " + haluttuLokaatio[0] + "," + haluttuLokaatio[1]);
            System.out.println("location: " + playerStrategy.getStartingLocation()[0] + "," + playerStrategy.getStartingLocation()[1]);
        }
        assertEquals(expResult, result);
    }

}
