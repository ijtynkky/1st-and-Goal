/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import Objects.Team;
import Objects.PlayerInfo;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author I
 */
public class TeamCreator {

    private String positionTracker;
    private StringTools tools;

    public TeamCreator() {
        this.positionTracker = "";
        this.tools = new StringTools();
    }

    /*
     FILE HAS TO BE IN THIS FORM:
     team name                       //Anything goes
     XX                              //position whit max 2 char
     playerNumber Surname FirstName 
     playerNumber Surname FirstName 
     .
     .
     .
     XX                              //next position
     playerNumber Surname FirstName 
     XX                              //next position
     playerNumber Surname FirstName 
     .
     .
     .
    
     END or empty line will stop filereading!
     */
    public Team create(File teamFile) throws FileNotFoundException {
        this.positionTracker = "";
        Scanner fileReader = new Scanner(teamFile);
        Team newTeam = new Team(fileReader.nextLine());
        while (fileReader.hasNextLine()) {
            String readLine = fileReader.nextLine();
            if (tools.removeSpaces(readLine).equals("END")) {
                break;
            } else if (tools.removeSpaces(readLine).length() <= 2) {
                this.positionTracker = tools.removeSpaces(readLine);
            } else {
                addPlayerToTeam(newTeam, readLine);
            }
        }
        return newTeam;
    }

    private void addPlayerToTeam(Team team, String string) {
        PlayerInfo newInfo = new PlayerInfo(this.getName(string), this.getNumber(string), this.positionTracker);
        team.addPlayer(newInfo);
    }

    private String getName(String string) {
        String returnString = "";
        int i = 3;
        while (i < string.length()) {
            returnString = returnString + string.charAt(i);
            i++;
        }
        return returnString;
    }

    private int getNumber(String string) {
        return 10 * Integer.parseInt(string.charAt(0) + "") + Integer.parseInt(string.charAt(1) + "");
    }

}
