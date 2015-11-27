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
import PlayerLogic.OffensiveStrategies.RouteRunner;
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
     * Test of movePlayer method, of class PlayerMover.
     */
    @Test
    public void testMoveRouteYksiVasemmalle() {
        System.out.println("movePlayer");
        Field field = new Field(53, 20);

        PlayerInfo pManning = new PlayerInfo("Payton Manning", 18);
        int[] alkupaikka1 = {3, 3};
        RouteRunner testiOff = new RouteRunner(alkupaikka1, "4", "@");
        Player qb = new Player(pManning, testiOff);
        qb.setLocation(alkupaikka1);
        System.out.println("Payton on QB");

        PlayerMover instance = new PlayerMover(field);
        instance.movePlayer(qb);
        int[] expResult = {2, 3};
        int[] result = qb.getLocation();
        Assert.assertArrayEquals(expResult, result);

    }

    @Test
    public void testMoveRouteVasenOikee() {
        System.out.println("movePlayer");
        Field field = new Field(5, 5);

        PlayerInfo pManning = new PlayerInfo("Payton Manning", 18);
        int[] alkupaikka1 = {3, 3};
        RouteRunner testiOff = new RouteRunner(alkupaikka1, "444444666666644", "@");
        Player qb = new Player(pManning, testiOff);
        qb.setLocation(alkupaikka1);
        System.out.println("Payton on QB");

        PlayerMover instance = new PlayerMover(field);
        instance.movePlayer(qb);
        instance.movePlayer(qb);
        instance.movePlayer(qb);
        instance.movePlayer(qb);
        instance.movePlayer(qb);
        instance.movePlayer(qb);
        instance.movePlayer(qb);
        instance.movePlayer(qb);
        instance.movePlayer(qb);
        instance.movePlayer(qb);
        instance.movePlayer(qb);
        instance.movePlayer(qb);
        instance.movePlayer(qb);
        instance.movePlayer(qb);
        instance.movePlayer(qb);
        instance.movePlayer(qb);
        instance.movePlayer(qb);
        instance.movePlayer(qb);
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
        String reitti = "22222222888888888888888888";
        RouteRunner testiOff = new RouteRunner(alkupaikka1, reitti, "@");
        Player qb = new Player(pManning, testiOff);
        qb.setLocation(alkupaikka1);
        System.out.println("Payton on QB");

        PlayerMover instance = new PlayerMover(field);
        int i = 0;
        while (i < reitti.length()) {
            instance.movePlayer(qb);
            i++;
        }

        int[] expResult = {3, 15};
        int[] result = qb.getLocation();
        Assert.assertArrayEquals(expResult, result);

    }

    @Test
    public void testMoveRouteVasenAlaKulma() {
        System.out.println("movePlayer");
        Field field = new Field(53, 20);

        PlayerInfo pManning = new PlayerInfo("Payton Manning", 18);
        int[] alkupaikka1 = {3, 3};
        RouteRunner testiOff = new RouteRunner(alkupaikka1, "111", "G");
        Player qb = new Player(pManning, testiOff);
        qb.setLocation(alkupaikka1);
        System.out.println("Payton on QB");

        PlayerMover instance = new PlayerMover(field);
        instance.movePlayer(qb);
        instance.movePlayer(qb);
        instance.movePlayer(qb);
        int[] expResult = {1, 1};
        int[] result = qb.getLocation();
        Assert.assertArrayEquals(expResult, result);

    }

    @Test
    public void testMovePlayerOneStep() {
        System.out.println("movePlayerOneStep");
        SimpleGraphics piirturi = new SimpleGraphics();

        Field field = new Field(53, 20);

        PlayerMover testMover = new PlayerMover(field);

        PlayerInfo pManning = new PlayerInfo("Payton Manning", 18);
        int[] alkupaikka1 = {2, 2};
        RouteRunner testiOff = new RouteRunner(alkupaikka1, "879987", "G");
        Player qb = new Player(pManning, testiOff);
        System.out.println("Payton on QB");

        field.addPlayerOffensive(1, qb);
        System.out.println("Payton on kentällä");
        piirturi.drawField(field);
        Player instance = qb;
        boolean expResult = true;
        boolean result = testMover.movePlayerOneStep(instance, 2);
        piirturi.drawField(field);
        assertEquals(expResult, result);
    }

    @Test
    public void testMovePlayerOneStep2() {
        System.out.println("movePlayerOneStep2");
        SimpleGraphics piirturi = new SimpleGraphics();

        Field field = new Field(53, 20);

        PlayerMover testMover = new PlayerMover(field);

        PlayerInfo pManning = new PlayerInfo("Payton Manning", 18);
        int[] alkupaikka1 = {1, 10};
        RouteRunner testiOff = new RouteRunner(alkupaikka1, "879987", "G");
        Player qb = new Player(pManning, testiOff);
        System.out.println("Payton on QB");

        field.addPlayerOffensive(1, qb);

        System.out.println("Payton on kentällä");
        piirturi.drawField(field);
        Player instance = qb;
        boolean expResult = false;
        boolean result = testMover.movePlayerOneStep(instance, 2);
        piirturi.drawField(field);
        assertEquals(expResult, result);
    }

    @Test
    public void testMovePlayerOneStep3() {
        System.out.println("movePlayerOneStep TD!!!!");
        SimpleGraphics piirturi = new SimpleGraphics();

        Field field = new Field(53, 20);

        PlayerMover testMover = new PlayerMover(field);

        PlayerInfo pManning = new PlayerInfo("Payton Manning", 18);
        int[] alkupaikka1 = {5, 5};
        RouteRunner testiOff = new RouteRunner(alkupaikka1, "879987", "G");
        Player qb = new Player(pManning, testiOff);
        System.out.println("Payton on QB");

        field.addPlayerOffensive(1, qb);
        qb.setLocation(new int[]{53, 20});
        System.out.println("Payton on kentällä");

        piirturi.drawField(field);
        Player instance = qb;
        boolean expResult = true;
        testMover.movePlayerOneStep(instance, 8);
        boolean result = field.partOfField(instance.getLocation()) == 2;
        piirturi.drawField(field);
        assertEquals(expResult, result);
    }

    @Test
    public void testMovePlayerOneStep4() {
        System.out.println("movePlayerOneStep");
        SimpleGraphics piirturi = new SimpleGraphics();

        Field field = new Field(53, 20);

        PlayerMover testMover = new PlayerMover(field);

        PlayerInfo pManning = new PlayerInfo("Payton Manning", 18);
        int[] alkupaikka1 = {4, 4};
        RouteRunner testiOff = new RouteRunner(alkupaikka1, "879987", "G");
        Player qb = new Player(pManning, testiOff);
        System.out.println("Payton on QB");

        field.addPlayerOffensive(1, qb);
        qb.setLocation(alkupaikka1);
        System.out.println("Payton on kentällä");
        piirturi.drawField(field);
        testMover.movePlayerOneStep(qb, 8);
        piirturi.drawField(field);
        testMover.movePlayerOneStep(qb, 8);
        piirturi.drawField(field);
        Player instance = qb;
        boolean expResult = true;
        boolean result = testMover.movePlayerOneStep(instance, 8);
        piirturi.drawField(field);
        assertEquals(expResult, result);
    }

}
