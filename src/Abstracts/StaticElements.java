package Abstracts;

import Interfaces.BaseUncollidableObject;
import Utils.Point;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;

public abstract class StaticElements extends JLabel implements BaseUncollidableObject {
    int x,y;
    private BufferedImage im;
    public StaticElements(){
        setVisible(false);
    }

    @Override
    public void setTexture(String fileName) {
        try {
            im = ImageIO.read(new File(".\\Assets\\Elements\\"+fileName+".png"));
            setSize(im.getWidth(),im.getHeight());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void setloc(int x, int y) {
        this.x=x;
        this.y=y;
        super.setLocation(x,y);
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    protected void paintComponent(Graphics g) {
        if(im!=null) {
            g.drawImage(im,0,0,null);
        }
        super.paintComponent(g);
    }

}
