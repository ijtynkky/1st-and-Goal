/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PlayerLogic;

import Graphics.SimpleGraphics;
import Objects.Field;
import Objects.Player;
import Objects.PlayerInfo;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author I
 */
public class PlayerMoverTest {

    public PlayerMoverTest() {
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
     * Test of moveRoute method, of class PlayerMover.
     */
    @Test
    public void testMoveRouteYksiVasemmalle() {
        System.out.println("moveRoute");
        Field field = new Field(5, 5);

        PlayerInfo pManning = new PlayerInfo("Payton Manning", 18);
        int[] alkupaikka1 = {3, 3};
        PlayerStrategy testiOff = new PlayerStrategy(alkupaikka1, "4", true);
        Player qb = new Player(pManning, testiOff);
        System.out.println("Payton on QB");

        PlayerMover instance = new PlayerMover(field);
        instance.moveRoute(qb);
        int[] expResult = {2, 3};
        int[] result = qb.getLocation();
        Assert.assertArrayEquals(expResult, result);

    }

    @Test
    public void testMoveRouteVasenOikee() {
        System.out.println("moveRoute");
        Field field = new Field(5, 5);

        PlayerInfo pManning = new PlayerInfo("Payton Manning", 18);
        int[] alkupaikka1 = {3, 3};
        PlayerStrategy testiOff = new PlayerStrategy(alkupaikka1, "444444666666644", true);
        Player qb = new Player(pManning, testiOff);
        System.out.println("Payton on QB");

        PlayerMover instance = new PlayerMover(field);
        instance.moveRoute(qb);
        instance.moveRoute(qb);
        instance.moveRoute(qb);
        instance.moveRoute(qb);
        instance.moveRoute(qb);
        instance.moveRoute(qb);
        instance.moveRoute(qb);
        instance.moveRoute(qb);
        instance.moveRoute(qb);
        instance.moveRoute(qb);
        instance.moveRoute(qb);
        instance.moveRoute(qb);
        instance.moveRoute(qb);
        instance.moveRoute(qb);
        instance.moveRoute(qb);
        instance.moveRoute(qb);
        instance.moveRoute(qb);
        instance.moveRoute(qb);
        int[] expResult = {3, 3};
        int[] result = qb.getLocation();
        Assert.assertArrayEquals(expResult, result);

    }

    @Test
    public void testMoveRouteAlasYos() {
        System.out.println("moveRoute");
        Field field = new Field(5, 5);

        PlayerInfo pManning = new PlayerInfo("Payton Manning", 18);
        int[] alkupaikka1 = {3, 3};
        PlayerStrategy testiOff = new PlayerStrategy(alkupaikka1, "8888888888882222222222222222222222222222222288", true);
        Player qb = new Player(pManning, testiOff);
        System.out.println("Payton on QB");

        PlayerMover instance = new PlayerMover(field);
        instance.moveRoute(qb);
        instance.moveRoute(qb);
        instance.moveRoute(qb);
        instance.moveRoute(qb);
        instance.moveRoute(qb);
        instance.moveRoute(qb);
        instance.moveRoute(qb);
        instance.moveRoute(qb);
        instance.moveRoute(qb);
        instance.moveRoute(qb);
        instance.moveRoute(qb);
        instance.moveRoute(qb);
        instance.moveRoute(qb);
        instance.moveRoute(qb);
        instance.moveRoute(qb);
        instance.moveRoute(qb);
        instance.moveRoute(qb);
        instance.moveRoute(qb);
        instance.moveRoute(qb);
        instance.moveRoute(qb);
        instance.moveRoute(qb);
        instance.moveRoute(qb);
        instance.moveRoute(qb);
        instance.moveRoute(qb);
        instance.moveRoute(qb);
        instance.moveRoute(qb);
        instance.moveRoute(qb);
        instance.moveRoute(qb);
        instance.moveRoute(qb);
        instance.moveRoute(qb);
        instance.moveRoute(qb);
        instance.moveRoute(qb);
        instance.moveRoute(qb);
        instance.moveRoute(qb);
        instance.moveRoute(qb);
        instance.moveRoute(qb);
        instance.moveRoute(qb);
        instance.moveRoute(qb);
        instance.moveRoute(qb);
        instance.moveRoute(qb);
        instance.moveRoute(qb);
        instance.moveRoute(qb);
        instance.moveRoute(qb);
        instance.moveRoute(qb);
        instance.moveRoute(qb);
        instance.moveRoute(qb);
        instance.moveRoute(qb);
        instance.moveRoute(qb);
        instance.moveRoute(qb);
        instance.moveRoute(qb);
        instance.moveRoute(qb);
        instance.moveRoute(qb);
        instance.moveRoute(qb);
        instance.moveRoute(qb);

        int[] expResult = {3, 3};
        int[] result = qb.getLocation();
        Assert.assertArrayEquals(expResult, result);

    }

    @Test
    public void testMoveRouteVasenAlaKulma() {
        System.out.println("moveRoute");
        Field field = new Field(5, 5);

        PlayerInfo pManning = new PlayerInfo("Payton Manning", 18);
        int[] alkupaikka1 = {3, 3};
        PlayerStrategy testiOff = new PlayerStrategy(alkupaikka1, "111", true);
        Player qb = new Player(pManning, testiOff);
        System.out.println("Payton on QB");

        PlayerMover instance = new PlayerMover(field);
        instance.moveRoute(qb);
        instance.moveRoute(qb);
        instance.moveRoute(qb);
        int[] expResult = {1, 1};
        int[] result = qb.getLocation();
        Assert.assertArrayEquals(expResult, result);

    }

    @Test
    public void testMovePlayerOneStep() {
        System.out.println("movePlayerOneStep");
        SimpleGraphics piirturi = new SimpleGraphics();

        Field field = new Field(5, 5);

        PlayerMover testMover = new PlayerMover(field);

        PlayerInfo pManning = new PlayerInfo("Payton Manning", 18);
        int[] alkupaikka1 = {2, 2};
        PlayerStrategy testiOff = new PlayerStrategy(alkupaikka1, "879987", true);
        Player qb = new Player(pManning, testiOff);
        System.out.println("Payton on QB");

        field.addPlayer(qb);
        System.out.println("Payton on kentällä");
        piirturi.drawSmallField(field);
        Player instance = qb;
        boolean expResult = true;
        boolean result = testMover.movePlayerOneStep(instance, 2);
        piirturi.drawSmallField(field);
        assertEquals(expResult, result);
    }

    @Test
    public void testMovePlayerOneStep2() {
        System.out.println("movePlayerOneStep");
        SimpleGraphics piirturi = new SimpleGraphics();

        Field field = new Field(5, 5);

        PlayerMover testMover = new PlayerMover(field);

        PlayerInfo pManning = new PlayerInfo("Payton Manning", 18);
        int[] alkupaikka1 = {1, 1};
        PlayerStrategy testiOff = new PlayerStrategy(alkupaikka1, "879987", true);
        Player qb = new Player(pManning, testiOff);
        System.out.println("Payton on QB");

        field.addPlayer(qb);
        System.out.println("Payton on kentällä");
        piirturi.drawSmallField(field);
        Player instance = qb;
        boolean expResult = false;
        boolean result = testMover.movePlayerOneStep(instance, 2);
        piirturi.drawSmallField(field);
        assertEquals(expResult, result);
    }

    @Test
    public void testMovePlayerOneStep3() {
        System.out.println("movePlayerOneStep TD!!!!");
        SimpleGraphics piirturi = new SimpleGraphics();

        Field field = new Field(5, 5);

        PlayerMover testMover = new PlayerMover(field);

        PlayerInfo pManning = new PlayerInfo("Payton Manning", 18);
        int[] alkupaikka1 = {5, 5};
        PlayerStrategy testiOff = new PlayerStrategy(alkupaikka1, "879987", true);
        Player qb = new Player(pManning, testiOff);
        System.out.println("Payton on QB");

        field.addPlayer(qb);
        System.out.println("Payton on kentällä");
        piirturi.drawSmallField(field);
        Player instance = qb;
        boolean expResult = true;
        boolean result = testMover.movePlayerOneStep(instance, 8);
        piirturi.drawSmallField(field);
        assertEquals(expResult, result);
    }

    @Test
    public void testMovePlayerOneStep4() {
        System.out.println("movePlayerOneStep");
        SimpleGraphics piirturi = new SimpleGraphics();

        Field field = new Field(5, 5);

        PlayerMover testMover = new PlayerMover(field);

        PlayerInfo pManning = new PlayerInfo("Payton Manning", 18);
        int[] alkupaikka1 = {4, 4};
        PlayerStrategy testiOff = new PlayerStrategy(alkupaikka1, "879987", true);
        Player qb = new Player(pManning, testiOff);
        System.out.println("Payton on QB");

        field.addPlayer(qb);
        System.out.println("Payton on kentällä");
        piirturi.drawSmallField(field);
        testMover.movePlayerOneStep(qb, 8);
        piirturi.drawSmallField(field);
        testMover.movePlayerOneStep(qb, 8);
        piirturi.drawSmallField(field);
        Player instance = qb;
        boolean expResult = true;
        boolean result = testMover.movePlayerOneStep(instance, 8);
        piirturi.drawSmallField(field);
        assertEquals(expResult, result);
    }

}
