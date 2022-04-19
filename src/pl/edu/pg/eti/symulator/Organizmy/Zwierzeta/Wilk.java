package pl.edu.pg.eti.symulator.Organizmy.Zwierzeta;

import pl.edu.pg.eti.symulator.Organizmy.Zwierze;
import pl.edu.pg.eti.symulator.Swiat;
import pl.edu.pg.eti.symulator.Organizm;

import javax.swing.*;

public class Wilk extends Zwierze implements Cloneable{

    public Wilk(Swiat swiat, int y, int x) {
        super(swiat, 1, y, x, 9, 5, 0, 0, new ImageIcon("Assets/wilk.png"));
    }

    @Override
    public void koliduj(Organizm o) throws CloneNotSupportedException{
        if (o.getSila() >= getSila() && o.getId() != getId()) {
            //printf("Wilk dzielnie odchodzi do Wilkhalli\n");
        }
        else if(o.getSila() > getSila() && o.getId() != getId()){
            //printf("Jak zwykle zwyciestwo ~ Wilk\n");
        }
        else {
            //printf("Wilki sie rozmnozyly\n");
        }
        super.koliduj(o);
    }
}
