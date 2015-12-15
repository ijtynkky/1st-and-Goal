package Objects;

import PlayerLogic.DefPlayerStrategy;
import PlayerLogic.OffensiveStrategies.Quaterback;
import PlayerLogic.PlayerStrategy;
import PlayerLogic.PlayerStrategy;
import java.util.ArrayList;

public class Player {
    /*
     Itse pelissä toimivat pelaajat. Sisältävät pelaajan tiedot, sekä pelaajalle
     annetun tehtävän (PlayerStrategy). Pitää huolta pelin kannalta tärkeistä
     asioista yksittäistä pelaajaa koskien, kuten sijainti pelikentällä
     */

    private PlayerStrategy strategy;
    private PlayerInfo playerInfo;
    private int[] location;
    private boolean hasBall;
    private final boolean isOffensivePlayer;
    private final char playerIcon;
    //private ArrayList<int[]> lastFiveLocations;

    public Player(PlayerInfo info, PlayerStrategy strategy) {
        this.hasBall = false;
        this.strategy = strategy;
        this.location = null;         //pelaajaa saa ensimmäisen sijainnin kun pelaaja lisätään Field olioon. field.addPlayer pitää huolen tästä
        this.playerInfo = info;
        this.playerIcon = strategy.getIcon();
        this.isOffensivePlayer = strategy.getIsOffensive();
        //  this.lastFiveLocations = new ArrayList();
    }

    /*playerMoved(int[]) lähettää tietoa this.strategy, jotta pelaajan strategia
     pystyy pitämään kirjaa tehdyistä liikkeistä. int[] ei usein vaikuta, mutta
     se vaaditaan tässä jotta PlayerStrategy rajapinnan toteuttavia luokkia 
     voidaan tarvittaessa tehdä monimutkaisemmiksi
     */
    public void playerMoved(int[] where) {
        this.strategy.playerMoved(where);
    }

    public int[] getLocation() {
        return this.location;
    }

    //Jos pelaajalla on pallo, on ikoni "0", muuten pelaajan oma ikoni
    //(tällä hetkellä pelissä saman joukkueen pelaajat ovat kaikki samoja ikoneita)
    public String getPlayerIcon() {
        if (this.hasBall) {
            return "0";
        } else {
            return "" + this.playerIcon;
        }
    }

    public int[] getStartingLocation() {
        return this.strategy.getStartingLocation();
    }

    public boolean askIsOffence() {
        return this.isOffensivePlayer;
    }

    public boolean isBallCarrier() {
        return this.hasBall;
    }

    public void giveBall() {
        this.hasBall = true;
    }

    public void takeBall() {
        this.hasBall = false;
    }

    //Pelaajan strategiaa voi vaihtaa lennosta tarvittaessa
    public void setPlayerStrategy(PlayerStrategy strategy) {
        this.strategy = strategy;
    }

    public void setLocation(int[] location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return this.playerInfo.toString();
    }

    /*MOVING
     directions, @ is player:
     7 8 9
     4 @ 6
     1 2 3
    
     */
    public int[] movePlayer(int direction) {
        if (direction == 1) {
            this.location[0] -= 1;
            this.location[1] -= 1;
        } else if (direction == 2) {
            this.location[1] -= 1;
        } else if (direction == 3) {
            this.location[0] += 1;
            this.location[1] -= 1;
        } else if (direction == 4) {
            this.location[0] -= 1;
        } else if (direction == 6) {
            this.location[0] += 1;
        } else if (direction == 7) {
            this.location[1] += 1;
            this.location[0] -= 1;
        } else if (direction == 8) {
            this.location[1] += 1;
        } else if (direction == 9) {
            this.location[1] += 1;
            this.location[0] += 1;
        }
        return this.location;
    }

    //PlayerMoveria varten, jotta voi testata mihin haluttu liike veisi pelaajan
    public int[] tryMovePlayer(int direction) {
        int y = this.location[1];
        int x = this.location[0];
        if (direction == 1) {
            x -= 1;
            y -= 1;
        } else if (direction == 2) {
            y -= 1;
        } else if (direction == 3) {
            x += 1;
            y -= 1;
        } else if (direction == 4) {
            x -= 1;
        } else if (direction == 6) {
            x += 1;
        } else if (direction == 7) {
            y += 1;
            x -= 1;
        } else if (direction == 8) {
            y += 1;
        } else if (direction == 9) {
            y += 1;
            x += 1;
        }
        int[] newLocation = {x, y};
        return newLocation;
    }

    //pelaaja kysyy strategialtaan mihin suuntaan strategian mukaan pitää liikkua seuraavaksi
    public int getPlayersNextMove(Field field) {
        return this.strategy.getNextMove(field, this.location);
    }

    public Quaterback getQBStrategy() {
        if (this.strategy.getClass().equals(Quaterback.class)) {
            return (Quaterback) this.strategy;
        } else {
            return null;
        }
    }

    public DefPlayerStrategy getDefPlayerStrategy() {
        if (!this.askIsOffence()) {
            return (DefPlayerStrategy) this.strategy;
        } else {
            return null;
        }
    }
}
//    public void addNewLocation() {
//        ArrayList<int[]> newList = new ArrayList();
//        newList.add(this.location);
//        int i = 0;
//        while (i < 4 && i < this.lastFiveLocations.size()) {
//            newList.add(this.lastFiveLocations.get(i));
//            i++;
//        }
//        this.lastFiveLocations = newList;
//    }
//
//    public ArrayList<int[]> getLastFiveLocations() {
//        return this.lastFiveLocations;
//    }

