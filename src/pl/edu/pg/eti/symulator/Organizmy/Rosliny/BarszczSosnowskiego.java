package pl.edu.pg.eti.symulator.Organizmy.Rosliny;

import pl.edu.pg.eti.symulator.Organizm;
import pl.edu.pg.eti.symulator.Organizmy.Roslina;
import pl.edu.pg.eti.symulator.Swiat;
import pl.edu.pg.eti.symulator.Utils.Punkt;

import javax.swing.*;
import java.util.Objects;

public class BarszczSosnowskiego extends Roslina implements Cloneable{

    public BarszczSosnowskiego(Swiat swiat, int y, int x){
        super(swiat, 5, y, x, 10, 0, 0, 0, new ImageIcon("Assets/barszcz.png"));
    }

    @Override
    public void akcja() throws CloneNotSupportedException {
        int rozsiew = getSwiat().losujLiczbeWZakresie(1, 10);
        if (rozsiew == 1) {
            Organizm nowaRoslina = super.clone();
            nowaRoslina.przeniesNaWolneMiejsce();
            getSwiat().dodajOrganizm(nowaRoslina);

            //printf("Barsz sosnowskiego sie rozprzestrzenil\n");
        }

        //zabijanie wszystkich zwierzęta w sąsiedztwie
        for(int dy=-1; dy<=1; dy++){
            for(int dx=-1; dx<=1; dx++){
                for(int i=0; i<getSwiat().getOrganizmy().size(); i++){
                    if(getSwiat().getOrganizmy().get(i).getInicjatywa() > 0 &&
                            Objects.equals(getSwiat().getOrganizmy().get(i).getWspolrzedne(),
                                    new Punkt((getSwiat().getWielkoscPionowa() + getWspolrzedne().getY() + dy) % (getSwiat().getWielkoscPionowa()),
                    (getSwiat().getWielkoscPozioma() + getWspolrzedne().getX() + dx) % (getSwiat().getWielkoscPozioma())))){
                        getSwiat().getOrganizmy().get(i).setWspolrzedne(new Punkt(-100, -100));

                        System.out.println("Barsz sosnowskiego zabil zwierze w swojej okolicy\n");

                    }
                }
            }
        }

        setWiek(getWiek() + 1);
    }

    @Override
    public void koliduj(Organizm o){
        if(o.getInicjatywa() > 0){
            o.setWspolrzedne(new Punkt(-100, -100));
            setWspolrzedne(new Punkt(-100, -100));
            //printf("Antylopa zjadła barszcz sosnowskiego i wypadła z gry\n");
        }
    }
}
