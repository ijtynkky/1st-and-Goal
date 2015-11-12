/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;

import PlayerLogic.PlayerStrategy;
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
public class PlayerTest {

    public PlayerTest() {
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

//    PlayerInfo testipelaaja1 = new PlayerInfo("Testipelaaja1", 1);
//    PlayerInfo pManning = new PlayerInfo("Payton Manning", 18);
//    
//    int[] alkupaikka2 = {5, 10};
//
//    PlayerInfo pManning = new PlayerInfo("Payton Manning", 18);
//    int[] alkupaikka1 = {5, 5};
//    PlayerStrategy testiOff = new PlayerStrategy(alkupaikka1, "879987", alkupaikka2, true);
//    Player qb = new Player(pManning, testiOff);
//
//    PlayerStrategy testiDef = new PlayerStrategy(alkupaikka2, 2224664, alkupaikka1, false);
//
//    Player qb = new Player(pManning, testiOff);
//    Player def = new Player(testipelaaja1, testiDef);
    /**
     * Test of getLocation method, of class Player.
     */
    @Test
    public void testGetLocation() {
        System.out.println("getLocation");
        PlayerInfo pManning = new PlayerInfo("Payton Manning", 18);
        int[] alkupaikka1 = {5, 5};
        PlayerStrategy testiOff = new PlayerStrategy(alkupaikka1, "879987", true);
        Player qb = new Player(pManning, testiOff);
        System.out.println("payton on QB");
        Player instance = qb;
        int[] expResult = new int[]{5, 5};
        int[] result = instance.getLocation();
        assertArrayEquals(expResult, result);

    }

    /**
     * Test of isBallCarrier method, of class Player.
     */
    @Test
    public void testIsBallCarrier() {
        System.out.println("isBallCarrier");
        PlayerInfo pManning = new PlayerInfo("Payton Manning", 18);
        int[] alkupaikka1 = {5, 5};
        PlayerStrategy testiOff = new PlayerStrategy(alkupaikka1, "879987", true);
        Player qb = new Player(pManning, testiOff);
        System.out.println("payton on QB");
        Player instance = qb;
        boolean expResult = false;
        boolean result = instance.isBallCarrier();
        assertEquals(expResult, result);
    }

    /**
     * Test of giveBall method, of class Player. Keksi miten vertaillaan
     * booleaneita
     */
    @Test
    public void testGiveBall() {
        System.out.println("giveBall");
        PlayerInfo pManning = new PlayerInfo("Payton Manning", 18);
        int[] alkupaikka1 = {5, 5};
        PlayerStrategy testiOff = new PlayerStrategy(alkupaikka1, "879987", true);
        Player qb = new Player(pManning, testiOff);
        System.out.println("payton on QB");
        Player instance = qb;
        instance.giveBall();
        System.out.println("Paytonilla on pallo " + instance.isBallCarrier());
    }

    /**
     * Test of takeBall method, of class Player.
     */
    @Test
    public void testTakeBall() {
        System.out.println("takeBall");
        PlayerInfo pManning = new PlayerInfo("Payton Manning", 18);
        int[] alkupaikka1 = {5, 5};
        PlayerStrategy testiOff = new PlayerStrategy(alkupaikka1, "879987", true);
        Player qb = new Player(pManning, testiOff);
        System.out.println("payton on QB");
        Player instance = qb;
        instance.giveBall();
        //instance.takeBall();
        System.out.println("Paytonilla on pallo " + instance.isBallCarrier());
    }

    /**
     * Test of movePlayer method, of class Player. //
     */
    @Test
    public void testMovePlayer0() {
        System.out.println("movePlayer");
        int direction = 0;
        PlayerInfo pManning = new PlayerInfo("Payton Manning", 18);
        int[] alkupaikka1 = {5, 5};
        PlayerStrategy testiOff = new PlayerStrategy(alkupaikka1, "879987", true);
        Player qb = new Player(pManning, testiOff);
        System.out.println("payton on QB");
        Player instance = qb;
        int[] expResult = {5, 5};
        int[] result = instance.movePlayer(direction);
        assertArrayEquals(expResult, result);
    }

    @Test
    public void testMovePlayer1() {
        System.out.println("movePlayer");
        int direction = 1;
        PlayerInfo pManning = new PlayerInfo("Payton Manning", 18);
        int[] alkupaikka1 = {5, 5};
        PlayerStrategy testiOff = new PlayerStrategy(alkupaikka1, "879987", true);
        Player qb = new Player(pManning, testiOff);
        System.out.println("payton on QB");
        Player instance = qb;
        int[] expResult = {4, 4};
        int[] result = instance.movePlayer(direction);
        assertArrayEquals(expResult, result);
    }

    @Test
    public void testMovePlayer2() {
        System.out.println("movePlayer");
        int direction = 2;
        PlayerInfo pManning = new PlayerInfo("Payton Manning", 18);
        int[] alkupaikka1 = {5, 5};
        PlayerStrategy testiOff = new PlayerStrategy(alkupaikka1, "879987", true);
        Player qb = new Player(pManning, testiOff);
        System.out.println("payton on QB");
        Player instance = qb;
        int[] expResult = {5, 4};
        int[] result = instance.movePlayer(direction);
        assertArrayEquals(expResult, result);
    }

    @Test
    public void testMovePlayer3() {
        System.out.println("movePlayer");
        int direction = 3;
        PlayerInfo pManning = new PlayerInfo("Payton Manning", 18);
        int[] alkupaikka1 = {5, 5};
        PlayerStrategy testiOff = new PlayerStrategy(alkupaikka1, "879987", true);
        Player qb = new Player(pManning, testiOff);
        System.out.println("payton on QB");
        Player instance = qb;
        int[] expResult = {6, 4};
        int[] result = instance.movePlayer(direction);
        assertArrayEquals(expResult, result);
    }

    @Test
    public void testMovePlayer4() {
        System.out.println("movePlayer");
        int direction = 4;
        PlayerInfo pManning = new PlayerInfo("Payton Manning", 18);
        int[] alkupaikka1 = {5, 5};
        PlayerStrategy testiOff = new PlayerStrategy(alkupaikka1, "879987", true);
        Player qb = new Player(pManning, testiOff);
        System.out.println("payton on QB");
        Player instance = qb;
        int[] expResult = {4, 5};
        int[] result = instance.movePlayer(direction);
        assertArrayEquals(expResult, result);
    }

    @Test
    public void testMovePlayer5() {
        System.out.println("movePlayer");
        int direction = 5;
        PlayerInfo pManning = new PlayerInfo("Payton Manning", 18);
        int[] alkupaikka1 = {5, 5};
        PlayerStrategy testiOff = new PlayerStrategy(alkupaikka1, "879987", true);
        Player qb = new Player(pManning, testiOff);
        System.out.println("payton on QB");
        Player instance = qb;
        int[] expResult = {5, 5};
        int[] result = instance.movePlayer(direction);
        assertArrayEquals(expResult, result);
    }

    @Test
    public void testMovePlayer6() {
        System.out.println("movePlayer");
        int direction = 6;
        PlayerInfo pManning = new PlayerInfo("Payton Manning", 18);
        int[] alkupaikka1 = {5, 5};
        PlayerStrategy testiOff = new PlayerStrategy(alkupaikka1, "879987", true);
        Player qb = new Player(pManning, testiOff);
        System.out.println("payton on QB");
        Player instance = qb;
        int[] expResult = {6, 5};
        int[] result = instance.movePlayer(direction);
        assertArrayEquals(expResult, result);
    }

    @Test
    public void testMovePlayer7() {
        System.out.println("movePlayer");
        int direction = 7;
        PlayerInfo pManning = new PlayerInfo("Payton Manning", 18);
        int[] alkupaikka1 = {5, 5};
        PlayerStrategy testiOff = new PlayerStrategy(alkupaikka1, "879987", true);
        Player qb = new Player(pManning, testiOff);
        System.out.println("payton on QB");
        Player instance = qb;
        int[] expResult = {4, 6};
        int[] result = instance.movePlayer(direction);
        assertArrayEquals(expResult, result);
    }

    @Test
    public void testMovePlayer8() {
        System.out.println("movePlayer");
        int direction = 8;
        PlayerInfo pManning = new PlayerInfo("Payton Manning", 18);
        int[] alkupaikka1 = {5, 5};
        PlayerStrategy testiOff = new PlayerStrategy(alkupaikka1, "879987", true);
        Player qb = new Player(pManning, testiOff);
        System.out.println("payton on QB");
        Player instance = qb;
        int[] expResult = {5, 6};
        int[] result = instance.movePlayer(direction);
        assertArrayEquals(expResult, result);
    }

    @Test
    public void testMovePlayer9() {
        System.out.println("movePlayer");
        int direction = 9;
        PlayerInfo pManning = new PlayerInfo("Payton Manning", 18);
        int[] alkupaikka1 = {5, 5};
        PlayerStrategy testiOff = new PlayerStrategy(alkupaikka1, "879987", true);
        Player qb = new Player(pManning, testiOff);
        System.out.println("payton on QB");
        Player instance = qb;
        int[] expResult = {6, 6};
        int[] result = instance.movePlayer(direction);
        assertArrayEquals(expResult, result);
    }
    
    //testiliikututus testi testit
    @Test
    public void testTryMovePlayer1() {
        System.out.println("tryMovePlayer");
        int direction = 1;
        PlayerInfo pManning = new PlayerInfo("Payton Manning", 18);
        int[] alkupaikka1 = {5, 5};
        PlayerStrategy testiOff = new PlayerStrategy(alkupaikka1, "879987", true);
        Player qb = new Player(pManning, testiOff);
        System.out.println("payton on QB");
        Player instance = qb;
        int[] expResult = {4, 4};
        int[] result = instance.tryMovePlayer(direction);
        assertArrayEquals(expResult, result);
    }

    @Test
    public void testTryMovePlayer2() {
        System.out.println("tryMovePlayer");
        int direction = 2;
        PlayerInfo pManning = new PlayerInfo("Payton Manning", 18);
        int[] alkupaikka1 = {5, 5};
        PlayerStrategy testiOff = new PlayerStrategy(alkupaikka1, "879987", true);
        Player qb = new Player(pManning, testiOff);
        System.out.println("payton on QB");
        Player instance = qb;
        int[] expResult = {5, 4};
        int[] result = instance.tryMovePlayer(direction);
        assertArrayEquals(expResult, result);
    }

    @Test
    public void testTryMovePlayer3() {
        System.out.println("tryMovePlayer");
        int direction = 3;
        PlayerInfo pManning = new PlayerInfo("Payton Manning", 18);
        int[] alkupaikka1 = {5, 5};
        PlayerStrategy testiOff = new PlayerStrategy(alkupaikka1, "879987", true);
        Player qb = new Player(pManning, testiOff);
        System.out.println("payton on QB");
        Player instance = qb;
        int[] expResult = {6, 4};
        int[] result = instance.tryMovePlayer(direction);
        assertArrayEquals(expResult, result);
    }

    @Test
    public void testTryMovePlayer4() {
        System.out.println("tryMovePlayer");
        int direction = 4;
        PlayerInfo pManning = new PlayerInfo("Payton Manning", 18);
        int[] alkupaikka1 = {5, 5};
        PlayerStrategy testiOff = new PlayerStrategy(alkupaikka1, "879987", true);
        Player qb = new Player(pManning, testiOff);
        System.out.println("payton on QB");
        Player instance = qb;
        int[] expResult = {4, 5};
        int[] result = instance.tryMovePlayer(direction);
        assertArrayEquals(expResult, result);
    }

    @Test
    public void testTryMovePlayer5() {
        System.out.println("tryMovePlayer");
        int direction = 5;
        PlayerInfo pManning = new PlayerInfo("Payton Manning", 18);
        int[] alkupaikka1 = {5, 5};
        PlayerStrategy testiOff = new PlayerStrategy(alkupaikka1, "879987", true);
        Player qb = new Player(pManning, testiOff);
        System.out.println("payton on QB");
        Player instance = qb;
        int[] expResult = {5, 5};
        int[] result = instance.tryMovePlayer(direction);
        assertArrayEquals(expResult, result);
    }

    @Test
    public void testTryMovePlayer6() {
        System.out.println("tryMovePlayer");
        int direction = 6;
        PlayerInfo pManning = new PlayerInfo("Payton Manning", 18);
        int[] alkupaikka1 = {5, 5};
        PlayerStrategy testiOff = new PlayerStrategy(alkupaikka1, "879987", true);
        Player qb = new Player(pManning, testiOff);
        System.out.println("payton on QB");
        Player instance = qb;
        int[] expResult = {6, 5};
        int[] result = instance.tryMovePlayer(direction);
        assertArrayEquals(expResult, result);
    }

    @Test
    public void testTryMovePlayer7() {
        System.out.println("tryMovePlayer");
        int direction = 7;
        PlayerInfo pManning = new PlayerInfo("Payton Manning", 18);
        int[] alkupaikka1 = {5, 5};
        PlayerStrategy testiOff = new PlayerStrategy(alkupaikka1, "879987", true);
        Player qb = new Player(pManning, testiOff);
        System.out.println("payton on QB");
        Player instance = qb;
        int[] expResult = {4, 6};
        int[] result = instance.tryMovePlayer(direction);
        assertArrayEquals(expResult, result);
    }

    @Test
    public void testTryMovePlayer8() {
        System.out.println("tryMovePlayer");
        int direction = 8;
        PlayerInfo pManning = new PlayerInfo("Payton Manning", 18);
        int[] alkupaikka1 = {5, 5};
        PlayerStrategy testiOff = new PlayerStrategy(alkupaikka1, "879987", true);
        Player qb = new Player(pManning, testiOff);
        System.out.println("payton on QB");
        Player instance = qb;
        int[] expResult = {5, 6};
        int[] result = instance.tryMovePlayer(direction);
        assertArrayEquals(expResult, result);
    }

    @Test
    public void testTryMovePlayer9() {
        System.out.println("tryMovePlayer");
        int direction = 9;
        PlayerInfo pManning = new PlayerInfo("Payton Manning", 18);
        int[] alkupaikka1 = {5, 5};
        PlayerStrategy testiOff = new PlayerStrategy(alkupaikka1, "879987", true);
        Player qb = new Player(pManning, testiOff);
        System.out.println("payton on QB");
        Player instance = qb;
        int[] expResult = {6, 6};
        int[] result = instance.tryMovePlayer(direction);
        assertArrayEquals(expResult, result);
    }

}
