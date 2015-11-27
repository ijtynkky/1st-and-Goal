package Objects;

/**
 *Tämän luokan oliot pitävät kirjaa yksittäisten pelaajien muuttumattomista
 * tiedoista, sekä pelin aikana suorituksista. Mahdollisesti myöhemmin
 * esim. eri statseja voi listätä tähän luokkaan
 */
public class PlayerInfo {

    private String name;            //Pelaajan nimi
    private int playerNumber;       //pelinumero
    private int touchdowns;         //tehtyjen maalien määrä
    private String position;        //Pelipaikka


    //FOR TESTS ONLY
    public PlayerInfo(String name, int number) {
        this.name = name;
        this.playerNumber = number;
        this.position = "?";
        this.touchdowns = 0;
    }

    public PlayerInfo(String name, int number, String position) {
        this.name = name;
        this.playerNumber = number;
        this.position = position;
        this.touchdowns = 0;
    }

    public void addTD() {
        this.touchdowns++;
    }

    public String getPosition() {
        return this.position;
    }

    public String getName() {
        return this.name;
    }

    public int getNumber() {
        return this.playerNumber;
    }

    public int getTD() {
        return this.touchdowns;
    }

    @Override
    public String toString() {
        return this.playerNumber + " " + this.name;
    }

}
