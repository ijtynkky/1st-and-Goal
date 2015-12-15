/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import Objects.Field;
import PlayerLogic.*;
import PlayerLogic.DefenceStrategies.ManCover;
import PlayerLogic.DefenceStrategies.PassRusher;
import PlayerLogic.DefenceStrategies.ZoneCover;
import PlayerLogic.OffensiveStrategies.Quaterback;
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
        String lineRead = "asdf";
        Scanner reader = new Scanner(this.file);
        while (!lineRead.contains(strategyName) || !reader.hasNextLine()) {
            lineRead = reader.nextLine();
        }
        String strategy = reader.nextLine();
        int[] startingLocation = tools.readLocation(reader.nextLine());
        String icon = reader.nextLine();
        //OFFENCE POSITIONS
        if (strategy.equals("QB")) {
            String route = reader.nextLine();
            int passTimer = Integer.parseInt(reader.nextLine());
            Quaterback returnThis = new Quaterback(startingLocation, "B", route, passTimer);
            String read = "";
            int i = 1;
            while (true) {
                read = reader.nextLine();
                if (read.equals("*")) {
                    break;
                }
                returnThis.setPassTarget(i, Integer.parseInt(read));
                i++;
            }
            return returnThis;
        }
        if (strategy.equals("RouteRunner")) {
            String route = reader.nextLine();
            RouteRunner returnThis = new RouteRunner(startingLocation, route, "B");
            return returnThis;
        }
        //DEFNECE POSITIONS
        if (strategy.equals("PassRusher")) {
            PassRusher returnThis = new PassRusher(startingLocation, "S");
            String readNext = reader.nextLine();
            if (!readNext.equals("*")) {
                returnThis.setRoute(readNext);
            }
            return returnThis;
        }
        if (strategy.equals("ZoneCover")) {
            ZoneCover returnThis = new ZoneCover(startingLocation, "S");
            String readNext = reader.nextLine();
            if (!readNext.equals("*")) {
                returnThis.setZoneCenter(tools.readLocation(readNext));
            }
            return returnThis;
        }

        if (strategy.equals("ManCover")) {
            ManCover returnThis = new ManCover(startingLocation, "S");
            String readNext = reader.nextLine();
            if (!readNext.equals("*")) {
                int x = readNext.length() - 3;
                int y = reader.nextLine().length() - 3;
                returnThis.setAdjustmen(x, y);
            }
            return returnThis;
        }

        return null;
    }

}
