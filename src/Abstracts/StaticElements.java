package Abstracts;

import Interfaces.BaseUncollidableObject;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public abstract class StaticElements extends JPanel implements BaseUncollidableObject {
    int x,y;
    private BufferedImage im;
    private StandardCollidableObject[] inventory = new StandardCollidableObject[6];

    public StaticElements(){

    }

    @Override
    public void setTexture(String fileName) {
        try {
            im = ImageIO.read(new File(".\\Assets\\Elements\\"+fileName));
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
