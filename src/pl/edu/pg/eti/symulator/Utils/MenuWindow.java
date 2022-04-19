package pl.edu.pg.eti.symulator.Utils;

import pl.edu.pg.eti.symulator.Swiat;
import pl.edu.pg.eti.symulator.Utils.GameWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuWindow extends JFrame implements ActionListener{

    JButton play, read, close;
    Swiat swiat;

    public MenuWindow(Swiat swiat) {
        this.swiat = swiat;
        Font font = new Font("Comic Sans", Font.BOLD, 22);

        play = new JButton();
        play.setBounds(100, 50, 200, 80);
        play.addActionListener(this);
        play.setText("Graj");
        play.setFont(font);

        /*read = new JButton();
        read.setBounds(100, 140, 200, 80);
        read.addActionListener(e -> System.out.println("Wczytaj"));
        read.setText("Wczytaj");
        read.setFont(font);*/

        close = new JButton();
        close.setBounds(100, 280, 200, 80);
        close.addActionListener(e -> System.exit(0));
        close.setText("Wyjdź");
        close.setFont(font);

        this.setTitle("Symulator by Michał Boczoń s184263");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setResizable(false);
        this.setSize(400, 480);
        this.add(play);
        //this.add(read);
        this.add(close);
        this.getContentPane().setBackground(new Color(0x012345));
        this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == play){
            this.dispose();
            GameWindow game = new GameWindow(swiat);
        }
    }
}
