package pl.edu.pg.eti.symulator.Organizmy.Zwierzeta;

import pl.edu.pg.eti.symulator.Organizmy.Zwierze;
import pl.edu.pg.eti.symulator.Swiat;
import pl.edu.pg.eti.symulator.Organizm;

import javax.swing.*;

public class Owca extends Zwierze implements Cloneable{

    public Owca(Swiat swiat, int y, int x) {
        super(swiat, 2, y, x, 4, 4, 0, 0, new ImageIcon("Assets/owca.png"));
    }

    @Override
    public void koliduj(Organizm o) throws CloneNotSupportedException{
        if (o.getSila() >= getSila() && o.getId() != getId()) {
            //printf("Owca zostala pozarta\n");
        }
        else if(o.getSila() < getSila() && o.getId() != getId()){
            //printf("Batalia tym razem zostala zwyciezona przez dzielna Owce\n");
        }
        else {
            //printf("Nowa mala owieczka przyszla na swiat\n");
        }
        super.koliduj(o);
    }

}
