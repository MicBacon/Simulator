package pl.edu.pg.eti.symulator.Organizmy;

import pl.edu.pg.eti.symulator.Organizm;
import pl.edu.pg.eti.symulator.Swiat;
import pl.edu.pg.eti.symulator.Utils.Punkt;

import javax.swing.*;

public abstract class Zwierze extends Organizm implements Cloneable{

    public Zwierze(Swiat swiat, int id, int y, int x, int sila, int inicjatywa, int wiek, int akcja, ImageIcon asset){
        super(swiat, id, y, x, sila, inicjatywa, wiek, akcja, asset);
    }

    @Override
    public void akcja(){
        int dx = 0, dy = 0;

        while(dx == 0 || dy == 0){
            dx = getSwiat().losujLiczbeWZakresie(0, 2) - 1;
            dy = getSwiat().losujLiczbeWZakresie(0, 2) - 1;
        }

        rusz(dy, dx);
        setZmianaPolozenia(new Punkt(dy, dx));
        setWiek(getWiek() + 1);
    }

    @Override
    public void koliduj(Organizm o) throws CloneNotSupportedException {
        //sprawdzenie czy to kolizja z innym zwierzęciem
        if(o.getInicjatywa() > 0){
            //rozmnażanie
            if(o.getId() == getId()){
                Organizm nowyOrganizm = o.clone();
                o.rusz(-o.getZmianaPolozenia().getY(), -o.getZmianaPolozenia().getX());
                nowyOrganizm.przeniesNaWolneMiejsce();
                getSwiat().dodajOrganizm(nowyOrganizm);
            }
            else if (o.getSila() >= getSila()) {
                setWspolrzedne(new Punkt(-100, -100));
            }
            else {
                o.setWspolrzedne(new Punkt(-100, -100));
            }
        }
        else {
            if (o.getSila() > getSila()) {
                setWspolrzedne(new Punkt(-100, -100));
            }
            else {
                o.setWspolrzedne(new Punkt(-100, -100));
            }
        }
    }
}
