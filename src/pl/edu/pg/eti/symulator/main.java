package pl.edu.pg.eti.symulator;

import pl.edu.pg.eti.symulator.Organizmy.Rosliny.*;
import pl.edu.pg.eti.symulator.Organizmy.Zwierzeta.*;
import pl.edu.pg.eti.symulator.Utils.MenuWindow;
import java.util.Vector;

public class main {
    public static void main(String[] args){
        Swiat swiat = new Swiat(20, 20);
        swiat.dodajOrganizm(new Czlowiek(swiat, 9, 9));
        swiat.dodajOrganizm(new Antylopa(swiat, 2, 3));
        swiat.dodajOrganizm(new Lis(swiat, 16,17));
        swiat.dodajOrganizm(new Owca(swiat, 0, 19));
        swiat.dodajOrganizm(new Wilk(swiat, 1,1));
        swiat.dodajOrganizm(new Wilk(swiat, 1,2));
        swiat.dodajOrganizm(new Wilk(swiat, 1,3));
        swiat.dodajOrganizm(new Wilk(swiat, 1,4));
        swiat.dodajOrganizm(new Zolw(swiat, 4, 19));
        swiat.dodajOrganizm(new BarszczSosnowskiego(swiat,6, 9));
        swiat.dodajOrganizm(new Guarana(swiat, 6, 15));
        swiat.dodajOrganizm(new Mlecz(swiat, 19, 1));
        swiat.dodajOrganizm(new Trawa(swiat, 4, 0));
        swiat.dodajOrganizm(new WilczeJagody(swiat, 6, 6));
        new MenuWindow(swiat);
    }
}
