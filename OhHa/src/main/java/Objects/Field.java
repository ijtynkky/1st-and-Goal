/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;

import java.util.ArrayList;
//tärkeä kommentti
//asdf

/**
 *
 * @author I
 */
public class Field {

    private int lineOfSkirmish;
    private int widht;
    private int lenght;
    private ArrayList<Player> players;

    public Field(int x, int y) {
        this.lineOfSkirmish = this.lenght - 10;
        this.lenght = y;
        this.widht = x;
        this.players = new ArrayList();
    }

    public void addPlayer(Player player) {
        if (this.partOfField(player.getLocation()) == 1) {
            this.players.add(player);
        }
    }

    public ArrayList<Player> getPlayers() {
        return this.players;
    }

    public ArrayList<int[]> getPlayerLocations() {
        ArrayList<int[]> locations = new ArrayList();
        for (Player player : this.players) {
            locations.add(player.getLocation());
        }
        return locations;
    }

    public Player getPlayerInThisPlace(int[] place) {
        Player thePlayerYouAreLookingFor = null;
        for (Player player : this.players) {
            if (player.getLocation()[0] == (place[0]) && player.getLocation()[1] == (place[1])) {
                thePlayerYouAreLookingFor = player;
            }
        }
        return thePlayerYouAreLookingFor;
    }

    public Player playerWIthBall() {
        for (Player player : this.players) {
            if (player.isBallCarrier()) {
                return player;
            }
        }
        return null;
    }

    public int[] getSize() {
        int[] size = {this.widht, this.lenght};
        return size;
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
