package Abstracts;

import Interfaces.BaseUncollidableObject;

import javax.swing.*;

public abstract class GroundObject implements BaseUncollidableObject {
    @Override
    public void setTexture(Icon img) {

    }

    @Override
    public void setloc(int x, int y) {

    }

    @Override
    public int getX() {
        return 0;
    }

    @Override
    public int getY() {
        return 0;
    }
}
