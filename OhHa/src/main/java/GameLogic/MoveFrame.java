/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameLogic;

import Objects.Field;
import Objects.Player;
import PlayerLogic.PlayerMover;
import PlayerLogic.QBMover;
import PlayerLogic.Tools.MovingTool;
import PlayerLogic.Tools.PassTool;
import java.util.ArrayList;
import tools.DistanceTool;
import tools.Randomizer;

/**
 * Tämä luokka liikuttaa jokaista pelaajaa yhden ruudun eteenpäin, pitää huolta
 * kentällä tapahtuvista erikoistilanteista, jotka keskeyttävät pelin
 *
 * @author I
 */
public class MoveFrame {

    //luokalle annetaan olio Field, josta MoveFrame kaivaa tiedot ja käskyttää.
    //PlayerMover ja sen erikoistapaus QBMover liikuttavat Field oliosta löytyviä
    //pelaajia käyttäneen apua erinäköisiä työkaluja
    //Continue play kertoo että pelaaminen jatkuu kun arvo on True,
    //false tapauksessa peli vihelletään poikki
    private Field field;
    private boolean continuePlay;
    private PlayerMover mover;
    private QBMover qbMover;
    private MovingTool mt;
    private Randomizer random;
    private DistanceTool dt;
    private PassTool pt;

    public MoveFrame(Field field, DistanceTool dt) {
        this.field = field;
        this.continuePlay = true;
        this.dt = dt;
        this.random = new Randomizer();
        this.mt = new MovingTool();
        this.mover = new PlayerMover(mt);
        this.qbMover = new QBMover(mt, random, dt);
        this.pt = new PassTool(dt);
    }

    public boolean getContinuePlay() {
        return this.continuePlay;
    }

    //Metodi hakee Field oliolta kaikki pelaajat, ja liikuttaa niitä vuorotellen
    //field.getPlayers() palauttaa paikassa 0 quaterbackin (QB), jonka liike käsitellään
    //aina ensimmäisenä vuorossa. sen jälkeen muu hyökkäys liikkuu, jonka jälkeen
    //puolustus
    /*
     metodi käy seuraavat askeleet läpi:
     1. QB liike
     1.1 QB:ta liikutetaan QBMover metodilla.
     1.2 Jos QB on heittotilassa ja hänellä on pallo, käsitellään pallon heitto 
     PassingToolin (this.pt) avulla. pt.pass() palauttaa joko true jos
     pass on onnistunut, ja peli jatkuu. Falsen tapauksessa pass on epäonnistunut,
     ja peli pysähtyy. (Amerikkalaisen jalkapallon säännöissä hyökkäysyritys 
     pysähtyy epäonnistuneeseen syöttöön)
     1.3 Huolimatta siitä, onko pass tapahtunut, testataan täyttyykö touchdowin ehdot
     (=pallollinen pelaaja on maalialueella). Hyökkäysyritys päätty jos TD
     2. Muiden pelaajie liike
     2.1 PlayerMover liikuttaa yksittäistä pelaajaa
     2.2 Jos pelaaja on pallollinen pelaaja, testataan täyttyykö TD ehdot.
     2.3 Testataan onko pallollinen pelaaja maassa (=onko hänent taklattu onnistuneesti)
     Amerikkalaisen jalkapallon sääntöjen mukaan, jos pallollinen pelaaja
     taklataan maahan, päättyy hyökkäysyritys
     */
    public void move(Field gameField) {
        ArrayList<Player> players = gameField.getPlayers();
        qbMover.movePlayer(this.field, players.get(0));                     //1.1
        if (qbMover.passBoolean() && players.get(0).isBallCarrier()) {      //1.2
            continuePlay = pt.pass(this.field, players.get(0));
        }
        if (testTD()) {                                                     //1.3
            System.out.println(this.field.playerWIthBall() + " TOUCHDOWN!!!!!!");
            continuePlay = false;
        }
        int i = 1;
        while (i < players.size() && continuePlay) {                        //2.
            mover.movePlayer(this.field, players.get(i));                   //2.1
            if (players.get(i).isBallCarrier()) {                           //2.2
                if (testTD()) {
                    System.out.println(field.playerWIthBall() + " TOUCHDOWN!!!!!!");
                    continuePlay = false;
                }
            }
            this.checkIsPlayerWithBallDown();                               //2.3

            i++;
        }
    }

    //touchdownin tarkistus (=maali jenkkifutiksessa)
    //field.getBallDropedY kertoo mihin ruutuun pallo on tippunut. Palautus on
    //999, jos pallo ei ole tippunut. Tämä jotta saadaan estettyä null pointteri
    //(+Touchdown ei mahdollinen, jos pallo on tiputettu)
    //    
    //    Jos pallolinen pelaaja on pelikentän maalialueella 
    //    (eli field.PartOfField() palauttaa arvoksi 2), palautuu true, muuten false.
    private boolean testTD() {
        if (field.getBallDropedY() != 999) {
            return false;
        } else {
            return (2 == (this.field.partOfField(this.field.playerWIthBall().getLocation())));
        }
    }

    
    //Testaa onko pallollinen pelaaja maassa, ts. onko pallo pudonnut, ts.
    //onko kellään kenttäpelaajalla pallo hallussa. 
    private boolean checkIsPlayerWithBallDown() {
        if (this.field.getBallDropedY() == 999) {
            return false;
        } else {
            int playerDownAt = this.field.getSize()[1] - this.field.getBallDropedY();
            System.out.println("PLAYER DOWN " + playerDownAt + " YARDS TO ENDZONE");
            this.continuePlay = false;
            return true;
        }
    }
}
