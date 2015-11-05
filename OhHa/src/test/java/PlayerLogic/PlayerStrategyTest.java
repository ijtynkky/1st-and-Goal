package PlayerLogic;

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
public class PlayerStrategyTest {

    public PlayerStrategyTest() {
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
     * Test of getStartingLocation method, of class PlayerStrategy.
     */
    @Test
    public void testGetStartingLocation() {
        System.out.println("getStartingLocation");
        int[] alku = {5, 5};
        PlayerStrategy testi = new PlayerStrategy(alku, 666, true);
        PlayerStrategy instance = testi;
        int[] expResult = {5, 5};
        int[] result = instance.getStartingLocation();
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of getRoute method, of class PlayerStrategy.
     */
    @Test
    public void testGetRoute() {
        System.out.println("getRoute");
        int[] alku = {5, 5};
        PlayerStrategy testi = new PlayerStrategy(alku, 666, true);
        PlayerStrategy instance = testi;
        int expResult = 666;
        int result = instance.getRoute();
        assertEquals(expResult, result);
    }

//    /**
//     * Test of getGoal method, of class PlayerStrategy.
//     */
//    @Test
//    public void testGetGoal() {
//        System.out.println("getGoal");
//        PlayerStrategy instance = null;
//        int[] expResult = null;
//        int[] result = instance.getGoal();
//        assertArrayEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getIsOffensive method, of class PlayerStrategy.
//     */
//    @Test
//    public void testGetIsOffensive() {
//        System.out.println("getIsOffensive");
//        PlayerStrategy instance = null;
//        boolean expResult = false;
//        boolean result = instance.getIsOffensive();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
}
