package pl.edu.pg.eti.symulator.Organizmy.Rosliny;

import pl.edu.pg.eti.symulator.Organizm;
import pl.edu.pg.eti.symulator.Organizmy.Roslina;
import pl.edu.pg.eti.symulator.Swiat;

import javax.swing.*;

public class Trawa extends Roslina {
    public Trawa(Swiat swiat, int y, int x)  {
        super(swiat, 1, y, x, 0, 0, 0, 0, new ImageIcon("Assets/trawa.png"));
    }

    @Override
    public void akcja() throws CloneNotSupportedException{
        int rozsiew = getSwiat().losujLiczbeWZakresie(1, 10);
        if (rozsiew == 1) {
            Organizm nowaRoslina = super.clone();
            nowaRoslina.przeniesNaWolneMiejsce();
            getSwiat().dodajOrganizm(nowaRoslina);
            //printf("Trawa się rozprzestrzenila\n");
        }
        setWiek(getWiek() + 1);
    }

    @Override
    public void koliduj(Organizm o) {
        //printf("Trawa zostala zjedzona\n");
        super.koliduj(o);
    }

}
