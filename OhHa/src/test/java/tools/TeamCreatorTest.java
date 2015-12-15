/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import Objects.Team;
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
public class TeamCreatorTest {

    public TeamCreatorTest() {
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
     * Test of create method, of class TeamCreator.
     */
    @Test
    public void testCreate() throws Exception {
        System.out.println("create 2 player team, easy:");
        File teamfile = new File("simpleTestTeam.txt");
        TeamCreator instance = new TeamCreator();
        Team newTeam = instance.create(teamfile);
        System.out.println(newTeam);
    }

    @Test
    public void testCreateDEN() throws Exception {
        System.out.println("Create Denver Broncos Offence");
        File teamfile = new File("C:\\Users\\I\\Documents\\GitHub\\1st-and-Goal\\OhHa\\Files\\Teams\\DEN.txt");
        TeamCreator instance = new TeamCreator();
        Team newTeam = instance.create(teamfile);
        System.out.println(newTeam);
    }

    //Väärät tiedostomuodot failaa, mutta ei haittaa koska 
    //ohjelmaan tulee vain oikeassa muodossa olevia tiedostoja.
    //Ainakaan tämä ei nyt sekoa kun tiedosto annetaan käsittelyyn.
    @Test
    public void testCreateFailTeam1() throws Exception {
        System.out.println("create team, stupid file:");
        File teamfile = new File("simpleTestFailTeam.txt");
        TeamCreator instance = new TeamCreator();
        Team newTeam = instance.create(teamfile);
        System.out.println(newTeam);
    }

    @Test
    public void testCreateFailTeam2() throws Exception {
        System.out.println("create 2 player team, stupid file:");
        File teamfile = new File("TestTeamEmptyPositionGroupAndExtraEnter.txt");
        TeamCreator instance = new TeamCreator();
        Team newTeam = instance.create(teamfile);
        System.out.println(newTeam);
    }
}
