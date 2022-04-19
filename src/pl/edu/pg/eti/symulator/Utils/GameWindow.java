package pl.edu.pg.eti.symulator.Utils;

import pl.edu.pg.eti.symulator.Organizmy.Zwierzeta.Czlowiek;
import pl.edu.pg.eti.symulator.Swiat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.PrintStream;

public class GameWindow extends JFrame implements KeyListener {
    private int width, height;

    public Board getBoard() {
        return board;
    }

    Board board;
    Swiat swiat;

    GameWindow(Swiat swiat){

        this.swiat = swiat;
        width = swiat.getWielkoscPozioma()*32;
        height = swiat.getWielkoscPionowa()*32;
        board = new Board(swiat, width, height);

       /* JTextArea logs = new JTextArea();
        logs.setBackground(new Color(0x012345));
        logs.setForeground(Color.WHITE);
        logs.setBounds(100, 100, 240, 20);
        logs.setEditable(false);
        logs.unregisterKeyboardAction(KeyStroke.getKeyStroke(KeyEvent.VK_UP,0));*/

       /* PrintStream printStream = new PrintStream(new CustomOutputStream(logs));
        System.setOut(printStream);*/

        /*JPanel console = new JPanel();
        console.setBackground(new Color(0x012345));
        console.setBounds(width - 250, 0, 250, height);
        console.setLayout(new BorderLayout());
        console.add(logs);
*/

        this.setTitle("Symulator by Michał Boczoń s184263");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setResizable(false);
        this.setSize(width, height);
        //this.add(console);
        this.addKeyListener(this);
        this.setVisible(true);

        this.add(board);
        System.out.println("Hello, World!");
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e){
       if(swiat.getIndeksCzlowieka() != -1) {
            switch (e.getKeyCode()) {
                case 37:
                    swiat.getOrganizmy().get(swiat.getIndeksCzlowieka()).rusz(-1, 0);
                    break;
                case 39:
                    swiat.getOrganizmy().get(swiat.getIndeksCzlowieka()).rusz(1, 0);
                    break;
                case 40:
                    swiat.getOrganizmy().get(swiat.getIndeksCzlowieka()).rusz(0, 1);
                    break;
                case 38:
                    swiat.getOrganizmy().get(swiat.getIndeksCzlowieka()).rusz(0, -1);
                    break;
                case 85:
                    try {
                        swiat.getOrganizmy().get(swiat.getIndeksCzlowieka()).akcja();
                    } catch (CloneNotSupportedException cloneNotSupportedException) {
                        cloneNotSupportedException.printStackTrace();
                    }
                    break;
            }
       }
        try {
            swiat.wykonajTure(this);
        } catch (CloneNotSupportedException cloneNotSupportedException) {
            cloneNotSupportedException.printStackTrace();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

}
