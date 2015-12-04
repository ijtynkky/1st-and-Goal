package ohha.ohha;

import GameLogic.*;
import Graphics.*;
import Objects.*;
import PlayerLogic.*;
import PlayerLogic.DefenceStrategies.ManCover;
import PlayerLogic.OffensiveStrategies.RouteRunner;
import java.io.File;
import java.io.FileNotFoundException;
import teamStrategy.TeamStrategyDefence;
import teamStrategy.TeamStrategyOffence;
import tools.TeamCreator;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        Field kentta = new Field(53, 20);
        TeamCreator luoja = new TeamCreator();
        Team team2 = luoja.create(new File("SEA.txt"));
        System.out.println(team2);

        TeamStrategyDefence puolustusTaktiikka = new TeamStrategyDefence(team2);

        puolustusTaktiikka.getDefenceFromFile(new File("TestiDef.txt"));
        puolustusTaktiikka.setWholeTeamOnTheField(kentta);

        Team team1 = luoja.create(new File("DEN.txt"));
        TeamStrategyOffence taktiikka = new TeamStrategyOffence(team1);
        taktiikka.getWholeTeamStrategyFromFile(new File("TestiOff2.txt"));
        taktiikka.setWholeTeamOnTheField(kentta);

        System.out.println(team1);

        //_________________________________________________________________________________________________________
        //        PlayerInfo leSeanMcCoy = new PlayerInfo("LeSean McCoy", 25, "RB");
        //        int[] alkupaikka1 = {27, 10};
        //        RouteRunner testiOff = new RouteRunner(alkupaikka1, "879987444448888888888", "@");
        //        Player leSean = new Player(leSeanMcCoy, testiOff);
        //        leSean.giveBall();
        //
        //        PlayerInfo jjWatt = new PlayerInfo("J.J. Watt", 99, "");
        //        int[] alkupaikka2 = {27, 15};
        //        PlayerStrategy testiDef = new ManCover(alkupaikka2, leSean, "J");
        //        Player def = new Player(jjWatt, testiDef);
        //
        //        kentta.addPlayer(leSean);
        //        kentta.addPlayer(def);
        PlayDown pelaaAlas = new PlayDown(kentta);

        pelaaAlas.move();
    }
}
