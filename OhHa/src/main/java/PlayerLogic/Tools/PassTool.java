/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PlayerLogic.Tools;

import Objects.Field;
import Objects.Player;
import tools.DistanceTool;
import tools.Randomizer;

/**
 *
 * @author I
 */
public class PassTool {

    private Randomizer random;
    private DistanceTool dt;

    public PassTool(DistanceTool dt) {
        this.random = new Randomizer();
        this.dt = dt;
    }
/*
    Metodi hakee QB:n strategiasta syöttökohteet, ja päättää kenelle syöttää käyttäen
    getTarget metodia. Metodi palauttaa syöttökohteista suurimman todennäköisyyden
    kohteen, ja pass() metodi testaa Randomizerilla syöttääkö QB kohteelle. Jos
    ei, niin kohteen todnäk asetetaan 10%, ja haetaan uusi suurimman tod näk kohde.
    Metodi ei lopeta ennen kuin kohde on löytynyt.
    Kohde on jokin hyökkäyksen pelaajista 7-11.
    Kuh kohde on arvottu, tapahtuu passi.
    */
    public boolean pass(Field field, Player qb) {
        Player targetPlayer = null;
        int[] targets = qb.getQBStrategy().getPassTargets();
        while (true) {
            int i = 0;
            while (i < 5) {
                int t = getTarget(targets);
                if (random.testRandom(targets[t])) {
                    return passBall(field, qb, field.getPlayerOff(7 + t));
                } else {
                    targets[i] = 10;
                    i++;
                }
            }
        }
    }

    
    /*
    PassBall kuvaa tilannetta, jossa pallollinen pelaaja heittää palloa nimetylle
    toiselle pelaajalle. Metodiin liittyy random testeti, ja passBall joko onnistuu
    (palautus true), tai epäonnistuu (palautus false). Onnistumisen todennäköisyyteen
    vaikuttaa syötön matka ja lähellä olevat vastustajat. 
    */
    
    public boolean passBall(Field field, Player passer, Player reseiver) {
        System.out.println(passer + " PASSES");
        int difficulty = (int) (120 - 3 * Math.floor(dt.getDistance(passer.getLocation(), reseiver.getLocation())));
        if (dt.getDistanceToNearestOpponent(field, passer) <= 2) {
            difficulty -= 25 - 5 * dt.getDistanceToNearestOpponent(field, passer);
        }
        System.out.println("DIF: " + difficulty);
        if (random.testRandom(difficulty)) {
            passer.takeBall();
            reseiver.giveBall();
            System.out.println(reseiver + " CATCHES THE BALL");
            return true;
        } else {
            System.out.println(reseiver + " DROPS THE BALL");
            return false;
        }
    }

    private int getTarget(int[] targets) {
        int returnThis = 0;
        int highest = 0;
        int i = 0;
        while (i < targets.length) {
            if (targets[i] >= highest) {
                returnThis = i;
            }
            i++;
        }
        return returnThis;
    }
}
