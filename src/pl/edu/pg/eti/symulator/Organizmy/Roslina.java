package pl.edu.pg.eti.symulator.Organizmy;

import pl.edu.pg.eti.symulator.Organizm;
import pl.edu.pg.eti.symulator.Swiat;
import pl.edu.pg.eti.symulator.Utils.Punkt;

import javax.swing.*;

public abstract class Roslina extends Organizm implements Cloneable{
    public Roslina(Swiat swiat, int id, int y, int x, int sila, int inicjatywa, int wiek, int akcja, ImageIcon asset){
        super(swiat, id, y, x, sila, inicjatywa, wiek, akcja, asset);
    }

    @Override
    public void akcja() throws CloneNotSupportedException {
        //rozsiewanie rośliny z prawdopodobieństwem 10%
        int rozsiew = getSwiat().losujLiczbeWZakresie(1, 10);
        if(rozsiew == 1){
            Organizm nowaRoslina = super.clone();
            nowaRoslina.przeniesNaWolneMiejsce();
            getSwiat().dodajOrganizm(nowaRoslina);
        }

        setWiek(getWiek() + 1);
    }

    @Override
    public void koliduj(Organizm o){
        if(o.getSila() >= getSila()){
            setWspolrzedne(new Punkt(-100, -100));
        }else{
            o.setWspolrzedne(new Punkt(-100, -100));
        }
    }
}
