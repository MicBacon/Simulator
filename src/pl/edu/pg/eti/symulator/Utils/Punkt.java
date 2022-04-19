package pl.edu.pg.eti.symulator.Utils;

import java.util.Objects;

public class Punkt implements Cloneable{
    private int x, y;

    public Punkt(int y, int x) {
        this.y = y;
        this.x = x;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public Punkt clone() throws CloneNotSupportedException{
        return (Punkt) super.clone();
    }
}
