/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import PlayerLogic.PlayerStrategy;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author I
 */
public class StrategyReader {

    private File file;

    public StrategyReader(File file) {
        this.file = file;
    }

    public PlayerStrategy getStrategy(String strategy) throws FileNotFoundException {
        Scanner reader = new Scanner(this.file);
        String lineRead = "";
        while (!lineRead.contains(strategy) || !reader.hasNextLine()) {
            lineRead = reader.nextLine();
        }
        PlayerStrategy 
    }

    private int[] readPosition(String string) {
        int[] returnThis = {};
        int whereDotIs = 0;
        while (whereDotIs < string.length()) {
            if (",".equals(string.charAt(whereDotIs))) {
                break;
            } else {
                whereDotIs++;
            }
        }
        if (whereDotIs + 1 == string.length()) {
            System.out.println("VIRHE VIRHE VIRHE");
            return null;
        }
        String firstNumber = "";
        int helpInt = whereDotIs;
        while (helpInt != 0) {
            firstNumber = string.charAt(helpInt) + firstNumber;
            helpInt--;
        }
        returnThis[1] = Integer.parseInt(firstNumber);
    }
}
