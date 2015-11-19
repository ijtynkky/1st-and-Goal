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
    Surname FirstName playerNumber
    Surname FirstName playerNumber
    .
    .
    .
    XX                              //next position
    Surname FirstName playerNumber
    XX                              //next position
    listOfPlayers inThisPosition
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
        PlayerInfo newInfo = new PlayerInfo(this.getName(string), this.positionTracker);
        team.addPlayer(newInfo);
    }

    private String getName(String string) {
        String returnString = "";
        int i = 0;
        int spaceCounter = 0;
        while (i < string.length()) {
            String helpString = string.charAt(i) + "";
            if (helpString.equals(" ")) {
                spaceCounter++;
                if (spaceCounter == 2) {
                    break;
                }
                returnString = returnString + helpString;
            } else {
                returnString = returnString + helpString;
            }
            i++;
        }
        return returnString;

    }
}

//    private String getNumber(String string) {
//
//    }
