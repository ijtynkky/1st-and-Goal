/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import PlayerLogic.*;
import PlayerLogic.DefenceStrategies.PassRusher;
import PlayerLogic.OffensiveStrategies.RouteRunner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author I
 */
public class StrategyReader {

    private File file;
    private StringTools tools;

    public StrategyReader(File file) {
        this.file = file;
        this.tools = new StringTools();
    }

    public PlayerStrategy getStrategy(String strategyName) throws FileNotFoundException {
        Scanner reader = new Scanner(this.file);
        String lineRead = "";
        while (!lineRead.contains(strategyName) || !reader.hasNextLine()) {
            lineRead = reader.nextLine();
        }
        String strategy = reader.nextLine();
        int[] startingLocation = tools.readLocation(reader.nextLine());
        String icon = reader.nextLine();
        if (strategy.equals("RouteRunner")) {
            String route = reader.nextLine();
            RouteRunner returnThis = new RouteRunner(startingLocation, route, icon);
            return returnThis;
        }

        if (strategy.equals("PassRusher")) {
            PassRusher returnThis = new PassRusher(startingLocation, icon);
            String readNext = reader.nextLine();
            if (!readNext.equals("*")) {
                returnThis.setRoute(readNext);
            }
            return returnThis;
        }
        return null;
    }

}
