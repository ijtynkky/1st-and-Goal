/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;

import PlayerLogic.PlayerStrategy;
import PlayerLogic.OffensiveStrategies.RouteRunner;
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
    public void testAddPlayer1() {
        System.out.println("addPlayer");
        PlayerInfo pManning = new PlayerInfo("Peyton Manning", 18);
        int[] alkupaikka1 = {5, 5};
        RouteRunner testiOff = new RouteRunner(alkupaikka1, "879987", "Q");
        Player player = new Player(pManning, testiOff);
        System.out.println("Peyton on QB");

        Field instance = new Field(10, 10);
        instance.addPlayerOffensive(1, player);
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

        PlayerInfo pManning = new PlayerInfo("Peyton Manning", 18);
        int[] alkupaikka1 = {5, 5};
        RouteRunner testiOff = new RouteRunner(alkupaikka1, "879987", "Q");
        Player player = new Player(pManning, testiOff);
        System.out.println("Peyton on QB");

        PlayerInfo eManning = new PlayerInfo("Peyton Manning", 10);
        int[] alkupaikka2 = {5, 6};
        RouteRunner testiOff2 = new RouteRunner(alkupaikka1, "879987", "H");
        Player player2 = new Player(eManning, testiOff2);
        System.out.println("Eli on QB");

        Field instance = new Field(10, 10);
        instance.addPlayerOffensive(1, player);
        instance.addPlayerOffensive(2, player2);

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
    public void testPartOfField() {
        System.out.println("partOfField");
        int[] square = {1, 1};
        Field instance = new Field(10, 9);
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

    /**
     * Test of addPlayerOffensive method, of class Field.
     */
    @Test
    public void testAddPlayerOffensive() {
        System.out.println("addPlayerOffensive");
        int position = 1;
        Player player = new Player(new PlayerInfo("String", 0, "String"), new RouteRunner(new int[]{1, 1}, "String", "String"));
        Field instance = new Field(53, 20);
        instance.addPlayerOffensive(position, player);
        int expResult = 10;
        int result = instance.getPlayerOff(1).getLocation()[1];
        assertEquals(expResult, result);
    }

    /**
     * Test of addPlayerDefensive method, of class Field.
     */
    @Test
    public void testAddPlayerDefensive() {
        System.out.println("addPlayerDefensive");
        int position = 1;
        Player player = new Player(new PlayerInfo("String", 0, "String"), new RouteRunner(new int[]{1, 1}, "String", "String"));
        Field instance = new Field(53, 20);
        instance.addPlayerDefensive(position, player);
        int expResult = 12;
        int result = instance.getPlayerDef(1).getLocation()[1];
        assertEquals(expResult, result);
    }

    /**
     * Test of getPlayerOff method, of class Field.
     */
    @Test
    public void testGetPlayerOff() {
        System.out.println("getPlayerOff");
        int position = 1;
        Player player = new Player(new PlayerInfo("String", 0, "String"), new RouteRunner(new int[]{1, 1}, "String", "String"));
        Field instance = new Field(53, 20);
        instance.addPlayerOffensive(position, player);
        Player expResult = player;
        Player result = instance.getPlayerOff(1);
        assertEquals(expResult, result);
    }

    /**
     * Test of getPlayerDef method, of class Field.
     */
    @Test
    public void testGetPlayerDef() {
        System.out.println("getPlayerDef");
        int position = 1;
        Player player = new Player(new PlayerInfo("String", 0, "String"), new RouteRunner(new int[]{1, 1}, "String", "String"));
        Field instance = new Field(53, 20);
        instance.addPlayerDefensive(position, player);
        Player expResult = player;
        Player result = instance.getPlayerDef(1);
        assertEquals(expResult, result);
    }

    /**
     * Test of getPlayerInThisPlace method, of class Field.
     */
    @Test
    public void testGetPlayerInThisPlace() {
        System.out.println("getPlayerInThisPlace");

        int position = 1;
        Player player = new Player(new PlayerInfo("String", 0, "String"), new RouteRunner(new int[]{1, 1}, "String", "String"));
        Field instance = new Field(53, 20);
        instance.addPlayerOffensive(position, player);

        int[] place = new int[]{1, 10};

        Player expResult = player;
        Player result = instance.getPlayerInThisPlace(place);
        assertEquals(expResult, result);
    }

    /**
     * Test of playerWIthBall method, of class Field.
     */
    @Test
    public void testPlayerWIthBall() {
        System.out.println("playerWIthBall");

        int position = 1;
        Player player = new Player(new PlayerInfo("String", 0, "String"), new RouteRunner(new int[]{1, 1}, "String", "String"));
        player.giveBall();
        Field instance = new Field(53, 20);
        instance.addPlayerOffensive(position, player);
        Player expResult = player;
        Player result = instance.playerWIthBall();
        assertEquals(expResult, result);
    }

    /**
     * Test of setBallDropedY method, of class Field.
     */
    @Test
    public void testSetBallDropedY() {
        System.out.println("setBallDropedY");
        int y = 10;
        Field instance = new Field(53, 20);
        instance.setBallDropedY(y);
        int expResult = 10;
        int result = instance.getBallDropedY();
        assertEquals(expResult, result);
    }

    /**
     * Test of getBallDropedY method, of class Field.
     */
    @Test
    public void testGetBallDropedY() {
        System.out.println("getBallDropedY");
        Field instance = new Field(53, 20);
        int expResult = 999;
        int result = instance.getBallDropedY();
        assertEquals(expResult, result);
    }

    /**
     * Test of getLineOfSkirmishInteger method, of class Field.
     */
    @Test
    public void testGetLineOfSkirmishInteger() {
        System.out.println("getLineOfSkirmishInteger");
        Field instance = new Field(53, 20);
        int expResult = 9;
        int result = instance.getLineOfSkirmishInteger();
        assertEquals(expResult, result);
    }

    /**
     * Test of getSize method, of class Field.
     */
    @Test
    public void testGetSize() {
        System.out.println("getSize");
        Field instance = new Field(53, 20);
        int[] expResult = new int[]{53, 20};
        int[] result = instance.getSize();
        assertArrayEquals(expResult, result);
    }
}
