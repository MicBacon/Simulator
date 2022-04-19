package pl.edu.pg.eti.symulator;

import pl.edu.pg.eti.symulator.Organizmy.Zwierzeta.Czlowiek;
import pl.edu.pg.eti.symulator.Utils.GameWindow;

import javax.swing.*;
import java.util.*;

public class Swiat {

    private int wielkoscPionowa, wielkoscPozioma;
    private Vector<Organizm> organizmy = new Vector<>();

    public Swiat(int wielkoscPionowa, int wielkoscPozioma){
        setWielkoscPionowa(wielkoscPionowa);
        setWielkoscPozioma(wielkoscPozioma);
    }

    public int getWielkoscPionowa() {
        return wielkoscPionowa;
    }

    private void setWielkoscPionowa(int wielkoscPionowa) {
        if (wielkoscPionowa >= Integer.MAX_VALUE) {
            throw new IllegalArgumentException("Wielkosc pionowa jest niedopuszczalna");
        }
        this.wielkoscPionowa = wielkoscPionowa;
    }

    public int getWielkoscPozioma() {
        return wielkoscPozioma;
    }

    public void setWielkoscPozioma(int wielkoscPozioma) {
        if(wielkoscPozioma >= Integer.MAX_VALUE){
            throw new IllegalArgumentException("Wielkosc pozioma jest niedopuszczalna");
        }
        this.wielkoscPozioma = wielkoscPozioma;
    }

    public Vector<Organizm> getOrganizmy() {
        return organizmy;
    }

    public void setOrganizmy(Vector<Organizm> organizmy) {
        this.organizmy = organizmy;
    }

    public static final Comparator<Organizm> comparator = new Comparator<>() {
        @Override
        public int compare(Organizm o1, Organizm o2) {
            if(o1.getInicjatywa() < o2.getInicjatywa()){
                return 1;
            }
            else if(o1.getInicjatywa() == o2.getInicjatywa()){
                if(o1.getWiek() < o2.getWiek()){
                    return 1;
                }else{
                    return 0;
                }
            }else{
                return 0;
            }
        }
    };

    public void wykonajTure(GameWindow gameFrame) throws CloneNotSupportedException{
        int iloscOrganizmowPrzedTura = (int)organizmy.size();

        Collections.sort(organizmy, comparator);

        for (int i = 0; i < iloscOrganizmowPrzedTura; i++) {
            organizmy.get(i).akcja();

            if (organizmy.get(i).getInicjatywa() > 0) {
                for (int j = 0; j < iloscOrganizmowPrzedTura; j++) {
                    if (Objects.equals(organizmy.get(j).getWspolrzedne(), organizmy.get(i).getWspolrzedne()) &&
                    !Objects.equals(organizmy.get(j), organizmy.get(j))) {
                        organizmy.get(j).koliduj(organizmy.get(i));
                    }
                }
            }
        }

        //usuwanie zabitych organizmów
        for(int i=0; i<organizmy.size(); i++){
            if(organizmy.get(i).getWspolrzedne().getY() <= -1){
                gameFrame.remove(organizmy.get(i).getLabel());
                usunOrganizm(i);
                i--;
            }
        }

        rysuj(gameFrame);
    }

    public void rysuj(GameWindow gameFrame){
        for(int i=0; i<organizmy.size(); i++){
            organizmy.get(i).rysuj(gameFrame);
        }
    }

    public int losujLiczbeWZakresie(int min, int max){

        if(min > max){
            throw new IllegalArgumentException("Wartość minimalna nie może być większa od maksymalnej.");
        }

        Random r = new Random();

        return r.nextInt(max - min + 1) + min;
    }

    public void usunOrganizm(int i){
        organizmy.remove(i);
    }

    public void dodajOrganizm(Organizm o){
        organizmy.add(o);
    }

    public int getIndeksCzlowieka(){
        for(int i=0; i<organizmy.size(); i++){
            if(organizmy.get(i).getId() == 0){
                return i;
            }
        }
        return -1;
    }
}
