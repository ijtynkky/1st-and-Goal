/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;

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
public class PlayerInfoTest {
    
    public PlayerInfoTest() {
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
     * Test of addTD method, of class PlayerInfo.
     */
    @Test
    public void testAddTD() {
        System.out.println("addTD");
        PlayerInfo instance = null;
        instance.addTD();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getName method, of class PlayerInfo.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        PlayerInfo instance = null;
        String expResult = "";
        String result = instance.getName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNumber method, of class PlayerInfo.
     */
    @Test
    public void testGetNumber() {
        System.out.println("getNumber");
        PlayerInfo instance = null;
        int expResult = 0;
        int result = instance.getNumber();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTD method, of class PlayerInfo.
     */
    @Test
    public void testGetTD() {
        System.out.println("getTD");
        PlayerInfo instance = null;
        int expResult = 0;
        int result = instance.getTD();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
