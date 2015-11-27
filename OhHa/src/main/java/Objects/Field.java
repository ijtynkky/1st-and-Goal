package Objects;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *Field pitää pelissä huolta kentällä olevista pelaajista, sekä
 * pelikentään liittyvistä ominaisuuksista, kuten sivurajoista
 */
public class Field {

    private int lineOfSkirmish;
    private int widht;
    private int lenght;
    private HashMap<Integer, Player> OffensivePlayers;
    private HashMap<Integer, Player> DefensivePlayers;

    public Field(int x, int y) {
        this.lenght = y;
        this.lineOfSkirmish = this.lenght - 9; //pelissä lineOfSkirmish (LOS) alkaa aina 10 jaardin (ruudun) päästä maalista
        this.widht = x;
        this.OffensivePlayers = new HashMap();
        this.DefensivePlayers = new HashMap();
    }

    //asettaa hyökkäyksen pelaajan annetuun kohtaa pelikentällä
    public void addPlayerOffensive(int position, Player player) {
        if (0 < position && position < 12) {
            int[] addToThisLocation = player.getStartingLocation();
            addToThisLocation[1] = this.lineOfSkirmish - addToThisLocation[1];
            player.setLocation(addToThisLocation);
            this.OffensivePlayers.put(position, player);
        }
    }

    public void addPlayerDefensive(int position, Player player) {
        if (0 < position && position < 12) {
            int[] addToThisLocation = player.getStartingLocation();
            addToThisLocation[1] = this.lineOfSkirmish + addToThisLocation[1];
            player.setLocation(addToThisLocation);
            this.DefensivePlayers.put(position, player);
        }

    }

    public Player getPlayerOff(int i) {
        return this.OffensivePlayers.get(i);
    }

    public Player getPlayerDef(int i) {
        return this.DefensivePlayers.get(i);
    }

    public ArrayList<Player> getPlayers() {
        ArrayList<Player> returnThis = new ArrayList();
        for (Player player : this.DefensivePlayers.values()) {
            returnThis.add(player);
        }
        for (Player player : this.OffensivePlayers.values()) {
            returnThis.add(player);
        }
        return returnThis;
    }

    public ArrayList<int[]> getPlayerLocations() {
        ArrayList<int[]> locations = new ArrayList();
        for (Player player : getPlayers()) {
            locations.add(player.getLocation());
        }
        return locations;
    }

    //palauttaa pelaajan, jos kyseisestä ruudusta löytyy pelaaja, 
    //muuten palauttaa null
    public Player getPlayerInThisPlace(int[] place) {
        Player thePlayerYouAreLookingFor = null;
        for (Player player : getPlayers()) {
            if (player.getLocation()[0] == (place[0]) && player.getLocation()[1] == (place[1])) {
                thePlayerYouAreLookingFor = player;
            }
        }
        return thePlayerYouAreLookingFor;
    }

    //palauttaa pallollisen pelaajan
    public Player playerWIthBall() {
        for (Player player : getPlayers()) {
            if (player.isBallCarrier()) {
                return player;
            }
        }
        return null;
    }


    //grafiikoita varten:
    public int[] getSize() {
        int[] size = {this.widht, this.lenght};
        return size;
    }

    public int getLineOfSkirmishInteger() {
        return this.lenght - this.lineOfSkirmish;
    }

    /*
     Returns what type the squre is
     0 = totaly out, no go
     1 = normal field
     2 = Endzone
     4 = LOS 
     TO DO grafiikkaa varten, tee myöhemmin:
     3 = out of bounds     
     5 = 10 yard
     6 = Hashmark
     */
    public int partOfField(int[] square) {
        if (square[0] > 0 && square[0] < this.widht + 1) {                         //If square is between sidelines
            if (square[1] == this.lineOfSkirmish) {
                return 4;
            } else if ((square[1] > 0 && square[1] < this.lenght + 1)) {                   //if is between endlines
                return 1;
            } else if (square[1] > this.lenght && square[1] < this.lenght + 11) {   //if is in endzone
                return 2;
            }
        }
        /* Tapaus3 sivurajat, on vielä turha
         if ((square[0] > -2 && square[0] < 1) || (square[0] < (this.widht+3) && square[0] > this.widht )) {
         return 3;
         }
         */
        return 0;
    }
}
