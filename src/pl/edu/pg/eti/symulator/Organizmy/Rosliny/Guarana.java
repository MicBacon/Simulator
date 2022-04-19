package pl.edu.pg.eti.symulator.Organizmy.Rosliny;

import pl.edu.pg.eti.symulator.Organizm;
import pl.edu.pg.eti.symulator.Organizmy.Roslina;
import pl.edu.pg.eti.symulator.Swiat;

import javax.swing.*;

public class Guarana extends Roslina {
    public Guarana(Swiat swiat, int y, int x){
        super(swiat, 3,y, x, 0, 0, 0, 0, new ImageIcon("Assets/guarana.png"));
    }

    @Override
    public void akcja() throws CloneNotSupportedException{
        int rozsiew = getSwiat().losujLiczbeWZakresie(1, 10);
        if (rozsiew == 1) {
            Organizm nowaRoslina = super.clone();
            nowaRoslina.przeniesNaWolneMiejsce();
            getSwiat().dodajOrganizm(nowaRoslina);
            //printf("Guarana sie rozprzestrzenila\n");
        }
        setWiek(getWiek() + 1);
    }

    @Override
    public void koliduj(Organizm o){
        //zwiekszenie siły zwierzęcia, które zjadło guaranę
        o.setSila(o.getSila() + 3);
       //printf("Guarana zostala zjedzona powiekszyla sile zwierzecia o 3\n");
        super.koliduj(o);
    }
}
