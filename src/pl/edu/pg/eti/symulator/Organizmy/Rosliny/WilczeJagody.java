package pl.edu.pg.eti.symulator.Organizmy.Rosliny;

import pl.edu.pg.eti.symulator.Organizmy.Roslina;
import pl.edu.pg.eti.symulator.Swiat;
import pl.edu.pg.eti.symulator.Organizm;
import pl.edu.pg.eti.symulator.Utils.Punkt;

import javax.swing.*;

public class WilczeJagody extends Roslina implements Cloneable {

    public WilczeJagody(Swiat swiat, int y, int x) {
        super(swiat, 4, y, x, 99, 0, 0, 0, new ImageIcon("Assets/jagody.png"));
    }

    @Override
    public void akcja() throws CloneNotSupportedException{
        int rozsiew = getSwiat().losujLiczbeWZakresie(1, 10);
        if (rozsiew == 1) {
            Organizm nowaRoslina = super.clone();
            nowaRoslina.przeniesNaWolneMiejsce();
            getSwiat().dodajOrganizm(nowaRoslina);
            //printf("Wilcze jagody siy rozprzestrzenily\n");
        }
        setWiek(getWiek() + 1);
    }

    @Override
    public void koliduj(Organizm o){
        if(o.getInicjatywa() > 0){
            o.setWspolrzedne(new Punkt(-100, -100));
            //printf("Zwierze zjadlo wilcze jagody i nie skonczylo najlepiej...\n");
        }
        setWiek(getWiek() + 1);
    }

}
