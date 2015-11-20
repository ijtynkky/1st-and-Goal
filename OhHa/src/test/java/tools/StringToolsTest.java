/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

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
public class StringToolsTest {

    public StringToolsTest() {
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
     * Test of removeSpaces method, of class StringTools.
     */
    @Test
    public void testRemoveSpaces() {
        System.out.println("removeSpaces");
        String string = " asd f as df       asdf";
        StringTools instance = new StringTools();
        String expResult = "asdfasdfasdf";
        String result = instance.removeSpaces(string);
        assertEquals(expResult, result);
    }

    @Test
    public void testReadNumbers() {
        System.out.println("readNumbers");
        String string = "99";
        StringTools instance = new StringTools();
        int expResult = 99;
        int result = instance.readNumber(string, 0, 1);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testReadNumbers2() {
        System.out.println("readNumbers");
        String string = "   99 ";
        StringTools instance = new StringTools();
        int expResult = 99;
        int result = instance.readNumber(string, 3, 4);
        assertEquals(expResult, result);
    }

}
