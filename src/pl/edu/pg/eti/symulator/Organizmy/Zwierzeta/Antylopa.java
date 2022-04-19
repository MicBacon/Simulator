package pl.edu.pg.eti.symulator.Organizmy.Zwierzeta;

import pl.edu.pg.eti.symulator.Organizmy.Zwierze;
import pl.edu.pg.eti.symulator.Swiat;
import pl.edu.pg.eti.symulator.Organizm;
import pl.edu.pg.eti.symulator.Utils.Punkt;

import javax.swing.*;

public class Antylopa extends Zwierze implements Cloneable {

    public Antylopa(Swiat swiat, int y, int x) {
        super(swiat, 5, y, x, 4, 4, 0, 0, new ImageIcon("Assets/antylopa.png"));
    }

    @Override
    public void akcja(){
        int dx=0, dy=0;

        while(dx == 0 || dy == 0){
            dx = getSwiat().losujLiczbeWZakresie(0, 4) - 2;
            dy = getSwiat().losujLiczbeWZakresie(0, 4) - 2;
        }

        rusz(dy, dx);
        setZmianaPolozenia(new Punkt(dy, dx));
        setWiek(getWiek() + 1);
    }

    @Override
    public void koliduj(Organizm o) throws CloneNotSupportedException{
        //ucieczka przed walką 50 %
        if (o.getSila() >= getSila() && o.getId() != getId()) {
            int flip = getSwiat().losujLiczbeWZakresie(1, 2);
            if (flip == 1) {
                przeniesNaWolneMiejsce();
                //printf("Antylopa uniknela walki\n");
            }
            else {
                //printf("Antylopa polegla na polu bitwy\n");
                super.koliduj(o);
            }
        }
        else if (o.getSila() < getSila() && o.getId() != getId()) {
            //printf("Antylopa w cudownej formie pokonuje nacierajace zwierze\n");
            super.koliduj(o);
        }
        else {
            //printf("Antylopy sie rozmnozyly\n");
            super.koliduj(o);
        }
    }

}
