package pl.edu.pg.eti.symulator.Organizmy.Zwierzeta;

import pl.edu.pg.eti.symulator.Organizmy.Zwierze;
import pl.edu.pg.eti.symulator.Swiat;
import pl.edu.pg.eti.symulator.Organizm;

import javax.swing.*;

public class Zolw extends Zwierze implements Cloneable{

    public Zolw(Swiat swiat, int y, int x) {
        super(swiat, 4, y, x, 2, 1, 0, 0, new ImageIcon("Assets/zolw.png"));
    }

    @Override
    public void akcja(){
        //sprawdzenie czy żółw wykona ruch (25% szans)
        int ruch = getSwiat().losujLiczbeWZakresie(1, 4);
        if(ruch == 1){
            super.akcja();
        }
    }

    @Override
    public void koliduj(Organizm o) throws CloneNotSupportedException{
        //odpieranie ataku przez żółwia
        if(o.getSila() < 5 && o.getId() != getId()){
            o.rusz(-o.getZmianaPolozenia().getY(), -o.getZmianaPolozenia().getX());
           //printf("Zolw obroni sie przed atakiem silniejszego przeciwnika\n");
        }else{
            if (o.getId() == getId()) {
                //printf("Zolw sie rozmnozyl\n");
            }
            else if (o.getSila() < getSila()) {
                //printf("Zolw pokonal napadajace go zwierze\n");
            }
            else if (o.getSila() >= getSila()) {
                //printf("Zolw zostal pokonany\n");
            }

            super.koliduj(o);
        }
    }

}
