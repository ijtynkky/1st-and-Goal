package ohha.ohha;

import GameLogic.*;
import Graphics.*;
import Objects.*;
import PlayerLogic.*;
import PlayerLogic.DefenceStrategies.ManCover;
import PlayerLogic.OffensiveStrategies.RouteRunner;
import UserInterface.UserInterface;
import java.io.File;
import java.io.FileNotFoundException;
import javax.swing.SwingUtilities;
import teamStrategy.TeamStrategyDefence;
import teamStrategy.TeamStrategyOffence;
import tools.TeamCreator;

public class Main {

    public static void main(String[] args) throws FileNotFoundException, InterruptedException {

        UserInterface kayttoliittyma = new UserInterface();

        Field kentta = new Field(53, 20);
        PlayDown pelaaAlas = new PlayDown(kentta, kayttoliittyma);

        TeamCreator luoja = new TeamCreator();

        Team team1 = luoja.create(new File("Files\\Teams\\DEN.txt"));
        TeamStrategyOffence taktiikka = new TeamStrategyOffence(team1);
        taktiikka.getWholeTeamStrategyFromFile(new File("Files\\TestFiles\\TestiOff2.txt"));
        taktiikka.setWholeTeamOnTheField(kentta);

        System.out.println(team1);

        Team team2 = luoja.create(new File("Files\\Teams\\SEA.txt"));
        System.out.println(team2);

        TeamStrategyDefence puolustusTaktiikka = new TeamStrategyDefence(team2);

        puolustusTaktiikka.getDefenceFromFile(new File("Files\\TestFiles\\TestiDef.txt"));
        puolustusTaktiikka.setWholeTeamOnTheField(kentta);
        
        SwingUtilities.invokeLater(kayttoliittyma);
        pelaaAlas.move();

    }
}
