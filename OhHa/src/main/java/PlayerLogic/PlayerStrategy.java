/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PlayerLogic;

import Objects.Field;

/**
 * Pelaajien strategiat toteuttavat tämän rajapinnan
 */
public interface PlayerStrategy {

    //Strategian tulee aina kertoa mistä kohtaa kenttää pelaaja aloittaa
    //pelin. Plautuksen tulee olla muotoa int[]{x,y}, 
    //jossa y kertoo kuinka kaukaata pelaaja aloittaa LoS:sta omalla
//    kenttäpuoliskolla
    public int[] getStartingLocation();

    //Strategian tulee aina pystyä kertomaan tarvittaessa, mihin suuntaan
    //pelaaja haluaa liikkua seuraavaksi
    public int getNextMove(Field field, int[] playerLocation);

    //Player luokan oliot saavat aina strategialta kirjaimen, joka
    //grafiikoissa merkkaa pelaajaa
    public char getIcon();

    public boolean getIsOffensive();

    //kertoo strategialle pelaajan liikuttua, mihin pelaaja on liikkunut
    //suurimman osan ajasta liikuttaa vaan liikkeiden määrään laskuria
    public void playerMoved(int[] where);
}
