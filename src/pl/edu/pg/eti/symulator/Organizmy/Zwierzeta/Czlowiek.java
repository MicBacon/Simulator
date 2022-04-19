package pl.edu.pg.eti.symulator.Organizmy.Zwierzeta;

import pl.edu.pg.eti.symulator.Organizmy.Zwierze;
import pl.edu.pg.eti.symulator.Swiat;
import pl.edu.pg.eti.symulator.Organizm;

import javax.swing.*;

public class Czlowiek extends Zwierze implements Cloneable {

    private boolean czyAktywnaTarczaAlzura;
    private int licznikTur;

    public Czlowiek(Swiat swiat, int y, int x){
        super(swiat, 0, y, x, 5, 4, 0, 0, new ImageIcon("Assets/czlowiek.png"));
        czyAktywnaTarczaAlzura = false;
        licznikTur = 0;
    }

    public boolean getCzyAktywnaTarczaAlzura(){
        return czyAktywnaTarczaAlzura;
    }
    public void setCzyAktywnaTarczaAlzura(boolean tf){
        czyAktywnaTarczaAlzura = tf;
        licznikTur = 5;
    }
    public void aktywujTarczeAlzura(){
        if (licznikTur == 0) {
            czyAktywnaTarczaAlzura = true;
            licznikTur = 5;
        }
    }

    @Override
    public void akcja(){

        //obsługa możliwości użycia i aktywacji umiejętności specjalnej
        if(licznikTur > 0){ licznikTur--; }
        else if(czyAktywnaTarczaAlzura){
            licznikTur = -5;
            czyAktywnaTarczaAlzura = false;
            //printf("Tarcza Alzura wyladowala sie, poczekaj 5 tur \n");
        }else if(licznikTur < 0){
            licznikTur++;
        }

        if(!czyAktywnaTarczaAlzura && licznikTur == 0){
           aktywujTarczeAlzura();
           //printf("Bezimienny uaktywnil tarcze alzura\n");
        }
        else {
            if (licznikTur < 0) {
                if (licznikTur < -1) {
                            //printf("Nie mozna jeszcze aktywowac tarczy alzura. Pozostalo: %d tur.\n", -licznikTur);
                }
                else {
                            //printf("Nie mozna jeszcze aktywowac tarczy alzura. Pozostala: 1 tura.\n");
                }
            }
            else {
                        //printf("Tarcza jest aktywna\n");
            }
        }


        setWiek(getWiek() + 1);
    }

    @Override
    public void koliduj(Organizm o) throws CloneNotSupportedException{
        if (czyAktywnaTarczaAlzura) {
            o.przeniesNaWolneMiejsce();
        }else  if (o.getSila() >= getSila()) {
            //printf("Bezimienny umarl\n");
            super.koliduj(o);
        }
    }
}
