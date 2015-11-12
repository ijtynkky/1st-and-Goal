/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;

import PlayerLogic.PlayerStrategy;
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
public class FieldTest {

    public FieldTest() {
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
     * Test of addPlayer method, of class Field.
     */
    @Test
    public void testAddPlayer() {
        System.out.println("addPlayer");
        PlayerInfo pManning = new PlayerInfo("Payton Manning", 18);
        int[] alkupaikka1 = {3, 15};
        PlayerStrategy testiOff = new PlayerStrategy(alkupaikka1, 879987, true);
        Player player = new Player(pManning, testiOff);
        System.out.println("Payton on QB");

        Field instance = new Field(10, 10);
        instance.addPlayer(player);
        boolean expResult = false;
        boolean result = instance.getPlayers().contains(player);
        assertEquals(expResult, result);
    }

    @Test
    public void testAddPlayer2() {
        System.out.println("addPlayer");
        PlayerInfo pManning = new PlayerInfo("Payton Manning", 18);
        int[] alkupaikka1 = {5, 5};
        PlayerStrategy testiOff = new PlayerStrategy(alkupaikka1, 879987, true);
        Player player = new Player(pManning, testiOff);
        System.out.println("Payton on QB");

        Field instance = new Field(10, 10);
        instance.addPlayer(player);
        boolean expResult = true;
        boolean result = instance.getPlayers().contains(player);
        assertEquals(expResult, result);
    }

    /**
     * Test of getPlayerLocations method, of class Field.
     */
    @Test
    public void testGetPlayerLocations() {
        System.out.println("getPlayerLocations");

        PlayerInfo pManning = new PlayerInfo("Payton Manning", 18);
        int[] alkupaikka1 = {5, 5};
        PlayerStrategy testiOff = new PlayerStrategy(alkupaikka1, 879987, true);
        Player player = new Player(pManning, testiOff);
        System.out.println("Payton on QB");

        PlayerInfo eManning = new PlayerInfo("Payton Manning", 10);
        int[] alkupaikka2 = {5, 6};
        PlayerStrategy testiOff2 = new PlayerStrategy(alkupaikka1, 879987, true);
        Player player2 = new Player(eManning, testiOff2);
        System.out.println("Eli on QB");

        Field instance = new Field(10, 10);
        instance.addPlayer(player);
        instance.addPlayer(player2);

        ArrayList expResult = new ArrayList();
        expResult.add(player.getLocation());
        expResult.add(player2.getLocation());

        ArrayList result = instance.getPlayerLocations();
        assertEquals(expResult, result);
    }

    /**
     * Test of partOfField method, of class Field.
     */
    /*
     Returns what type the squre is
     0 = totaly out, no go
     1 = normal field
     2 = Endzone
     TO DO grafiikkaa varten, tee myöhemmin:
     3 = out of bounds
     4 = LOS
     5 = 10 yard
     6 = Hashmark
     */
    @Test
    public void testPartOfField1() {
        System.out.println("partOfField");
        int[] square = {1, 1};
        Field instance = new Field(10, 10);
        int expResult = 1;
        int result = instance.partOfField(square);
        assertEquals(expResult, result);
    }

    @Test
    public void testPartOfField2() {
        System.out.println("partOfField");
        int[] square = {5, 5};
        Field instance = new Field(10, 10);
        int expResult = 1;
        int result = instance.partOfField(square);
        assertEquals(expResult, result);
    }

    @Test
    public void testPartOfField3() {
        System.out.println("partOfField");
        int[] square = {10, 10};
        Field instance = new Field(10, 10);
        int expResult = 1;
        int result = instance.partOfField(square);
        assertEquals(expResult, result);
    }

    @Test
    public void testPartOfField4() {
        System.out.println("partOfField");
        int[] square = {0, 0};
        Field instance = new Field(10, 10);
        int expResult = 0;
        int result = instance.partOfField(square);
        assertEquals(expResult, result);
    }

    @Test
    public void testPartOfField5() {
        System.out.println("partOfField");
        int[] square = {5, 900000};
        Field instance = new Field(10, 10);
        int expResult = 0;
        int result = instance.partOfField(square);
        assertEquals(expResult, result);
    }

    @Test
    public void testPartOfField6() {
        System.out.println("partOfField");
        int[] square = {90000, 1};
        Field instance = new Field(10, 10);
        int expResult = 0;
        int result = instance.partOfField(square);
        assertEquals(expResult, result);
    }

    @Test
    public void testPartOfField7() {
        System.out.println("partOfField");
        int[] square = {1, -100};
        Field instance = new Field(10, 10);
        int expResult = 0;
        int result = instance.partOfField(square);
        assertEquals(expResult, result);
    }

    @Test
    public void testPartOfField8() {
        System.out.println("partOfField");
        int[] square = {-1, 1};
        Field instance = new Field(10, 10);
        int expResult = 0;
        int result = instance.partOfField(square);
        assertEquals(expResult, result);
    }

    @Test
    public void testPartOfField9() {
        System.out.println("partOfField");
        int[] square = {10, 20};
        Field instance = new Field(10, 10);
        int expResult = 2;
        int result = instance.partOfField(square);
        assertEquals(expResult, result);
    }

    @Test
    public void testPartOfField10() {
        System.out.println("partOfField");
        int[] square = {11, 10};
        Field instance = new Field(10, 10);
        int expResult = 0;
        int result = instance.partOfField(square);
        assertEquals(expResult, result);
    }

}