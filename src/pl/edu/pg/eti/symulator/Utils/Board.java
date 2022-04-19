package pl.edu.pg.eti.symulator.Utils;

import pl.edu.pg.eti.symulator.Organizm;
import pl.edu.pg.eti.symulator.Swiat;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;

public class Board extends JPanel {
    Swiat swiat;

    Board(Swiat swiat, int width, int height) {
        this.swiat = swiat;
        this.setBounds(0, 0, width, height);
        this.setBackground(new Color(0x256514));
    }

   /* public void paint(Graphics g){
        Graphics2D g2D = (Graphics2D)g;

        for (Organizm organizm: swiat.getOrganizmy()) {
            g2D.drawImage(organizm.getAsset().getImage(), organizm.getWspolrzedne().getX()*32, organizm.getWspolrzedne().getY()*32, null);
        }
    }*/
}
