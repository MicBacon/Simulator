package pl.edu.pg.eti.symulator.Organizmy.Zwierzeta;

import pl.edu.pg.eti.symulator.Organizmy.Zwierze;
import pl.edu.pg.eti.symulator.Swiat;
import pl.edu.pg.eti.symulator.Organizm;
import pl.edu.pg.eti.symulator.Utils.Punkt;

import javax.swing.*;

public class Lis extends Zwierze implements Cloneable{

    public Lis(Swiat swiat, int y, int x) {
        super(swiat, 3, y, x, 3, 7, 0, 0, new ImageIcon("Assets/lis.png"));
    }

    @Override
    public void akcja(){
        boolean isAvailableSpace = true;
        int dx=0, dy=0;

        while(dx == 0 || dy == 0){
            dx = getSwiat().losujLiczbeWZakresie(0, 2) - 1;
            dy = getSwiat().losujLiczbeWZakresie(0, 2) - 1;
        }

        //sprawdzenie czy na pole, na które lis planuje pójść nie jest aby zajęte przez silniejszego przeciwnika
        for(int i=0; i<getSwiat().getOrganizmy().size(); i++){
            if((getSwiat().getOrganizmy().get(i).getWspolrzedne().getX() == (getSwiat().getWielkoscPozioma() + getWspolrzedne().getX() + dx) % (getSwiat().getWielkoscPozioma()) &&
            (getSwiat().getOrganizmy().get(i).getWspolrzedne().getY() == (getSwiat().getWielkoscPionowa() + getWspolrzedne().getY() + dy) % (getSwiat().getWielkoscPionowa())) &&
            (getSwiat().getOrganizmy().get(i).getSila() > getSila()))){
                isAvailableSpace = false;
                //printf("Lis wyczul silniejszego przeciwnika i pozostal bezpiecznie na miejscu\n");
                break;
            }
        }

        if(isAvailableSpace){
           rusz(dy, dx);
            setZmianaPolozenia(new Punkt(dy, dx));
        }
        setWiek(getWiek() + 1);

    }

    @Override
    public void koliduj(Organizm o) throws CloneNotSupportedException{
        if (o.getSila() >= getSila() && o.getId() != getId()) {
            //printf("Lisek odpadl z gry :/\n");
        }
        else if (o.getSila() < getSila() && o.getId() != getId()) {
            //printf("Lis pokonal przeciwnika\n");
        }
        else {
            //printf("Populacja lisow zwieksza sie Panie\n");
        }
       super.koliduj(o);
    }
}
