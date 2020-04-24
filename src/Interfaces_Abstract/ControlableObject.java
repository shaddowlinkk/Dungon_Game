package Interfaces_Abstract;

import Handlers.SpriteHandler;
import Interfaces_Abstract.BaseObject;
import Interfaces_Abstract.MoveableObject;
import Objects.BoundingBox;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public  abstract  class ControlableObject extends StandardObject implements  MoveableObject{
    private int x,direction,y,dx,dy;
    public ControlableObject(String filename){
        super(filename);
    }
    public ControlableObject(){
    }
    @Override
    public void move() {
        x=getX();
        y=getY();
        x = x + dx;
        y = y + dy;
        super.setloc(x, y);
    }

    @Override
    public Boolean collison(BaseObject obj) {
        return null;
    }

    @Override
    public int getDX() {
        return dx;
    }

    @Override
    public int getDY() {
        return dy;
    }

    @Override
    public void setDX(int _dx) {
        dx=_dx;
    }

    @Override
    public void setDY(int _dy) {
        dy=_dy;

    }

}
