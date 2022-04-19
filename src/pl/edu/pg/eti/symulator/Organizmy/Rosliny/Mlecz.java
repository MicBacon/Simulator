package pl.edu.pg.eti.symulator.Organizmy.Rosliny;

import pl.edu.pg.eti.symulator.Organizm;
import pl.edu.pg.eti.symulator.Organizmy.Roslina;
import pl.edu.pg.eti.symulator.Swiat;

import javax.swing.*;

public class Mlecz extends Roslina {

    public Mlecz(Swiat swiat, int y, int x) {
        super(swiat, 2, y, x, 0, 0, 0, 0, new ImageIcon("Assets/mlecz.png"));
    }

    @Override
    public void akcja() throws CloneNotSupportedException{
        //3 próby rozprzestrzeniania się
        for(int i=0; i<3; i++){
            int rozsiew = getSwiat().losujLiczbeWZakresie(1, 10);
            if (rozsiew == 1) {
                Organizm nowaRoslina = super.clone();
                nowaRoslina.przeniesNaWolneMiejsce();
                getSwiat().dodajOrganizm(nowaRoslina);
                //printf("Mlecz sie rozprzestrzenil\n");
                break;
            }
        }
        setWiek(getWiek() + 1);
    }

    @Override
    public void koliduj(Organizm o){
        //printf("Mlecz zostaje zjedzony\n");
        super.koliduj(o);
    }
}
