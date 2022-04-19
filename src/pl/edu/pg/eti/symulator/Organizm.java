package pl.edu.pg.eti.symulator;

import pl.edu.pg.eti.symulator.Utils.GameWindow;
import pl.edu.pg.eti.symulator.Utils.Punkt;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public abstract class Organizm implements Cloneable{
    private int sila, inicjatywa, id, wiek, akcja;
    private Punkt wspolrzedne, zmianaPolozenia;
    private Swiat swiat;
    private ImageIcon asset;

    public JLabel getLabel() {
        return label;
    }

    public void setLabel(JLabel label) {
        this.label = label;
    }

    private JLabel label;

    public Organizm(Swiat swiat, int id, int y, int x, int sila, int inicjatywa, int wiek, int akcja, ImageIcon asset) {
        this.swiat = swiat;
        this.id = id;
        this.wspolrzedne = new Punkt(y, x);
        this.sila = sila;
        this.inicjatywa = inicjatywa;
        this.wiek = wiek;
        this.akcja = akcja;
        this.asset = asset;
        zmianaPolozenia = new Punkt(0, 0);
        label = new JLabel();
        label.setBounds(wspolrzedne.getY()*32, wspolrzedne.getX()*32, 32, 32);
    }

    public ImageIcon getAsset() {
        return asset;
    }

    public void setAsset(ImageIcon asset) {
        this.asset = asset;
    }

    public int getSila() {
        return sila;
    }

    public void setSila(int sila) {
        this.sila = sila;
    }

    public int getInicjatywa() {
        return inicjatywa;
    }

    public void setInicjatywa(int inicjatywa) {
        this.inicjatywa = inicjatywa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getWiek() {
        return wiek;
    }

    public void setWiek(int wiek) {
        this.wiek = wiek;
    }

    public int getAkcja() {
        return akcja;
    }

    public void setAkcja(int akcja) {
        this.akcja = akcja;
    }

    public Punkt getWspolrzedne() {
        return wspolrzedne;
    }

    public void setWspolrzedne(Punkt wspolrzedne) {
        this.wspolrzedne = wspolrzedne;
    }

    public Punkt getZmianaPolozenia() {
        return zmianaPolozenia;
    }

    public void setZmianaPolozenia(Punkt zmianaPolozenia) {
        this.zmianaPolozenia = zmianaPolozenia;
    }

    public Swiat getSwiat() {
        return swiat;
    }

    public void setSwiat(Swiat swiat) {
        this.swiat = swiat;
    }

    public void przeniesNaWolneMiejsce(){
        int dy = 0, dx = 0;
        boolean czyWolne = true;

        while (dy == 0 && dx == 0) {
            dy = swiat.losujLiczbeWZakresie(0, 2) - 1;
            dx = swiat.losujLiczbeWZakresie(0, 2) - 1;

            for(int i=0; i<swiat.getOrganizmy().size(); i++){
                if (Objects.equals(swiat.getOrganizmy().get(i).getWspolrzedne(),
                        new Punkt((swiat.getWielkoscPionowa() + getWspolrzedne().getY() + dy) % (swiat.getWielkoscPionowa()),
                        (swiat.getWielkoscPozioma() + getWspolrzedne().getX() + dx) % (swiat.getWielkoscPozioma())))) {
                    czyWolne = false;
                    break;
                }
                if (czyWolne) {
                    rusz(dy, dx);
                    setZmianaPolozenia(new Punkt(dy, dx));
                    return;
                }
            }
        }
    }

    public void rusz(int dy, int dx){
        setWspolrzedne(new Punkt((swiat.getWielkoscPionowa() + getWspolrzedne().getY() + dy) % (swiat.getWielkoscPionowa()),
        (swiat.getWielkoscPozioma() + getWspolrzedne().getX() + dx) % (swiat.getWielkoscPozioma())));
    }

    public abstract void akcja() throws CloneNotSupportedException;
    public abstract void koliduj(Organizm o) throws CloneNotSupportedException;

    @Override
    public Organizm clone() throws CloneNotSupportedException{
        Organizm nowyOrganizm = (Organizm) super.clone();

        nowyOrganizm.wspolrzedne = wspolrzedne.clone();
        nowyOrganizm.zmianaPolozenia = zmianaPolozenia.clone();
        nowyOrganizm.label = new JLabel();
        nowyOrganizm.label.setBounds(wspolrzedne.getY() * 32, wspolrzedne.getX() * 32, 32, 32);

        return nowyOrganizm;
    }

    public void rysuj(GameWindow gameFrame){
        label.setBounds(wspolrzedne.getY() * 32, wspolrzedne.getX() * 32, 32, 32);
        label.setIcon(asset);
        gameFrame.getBoard().add(label);
        gameFrame.getBoard().repaint();
    }
}