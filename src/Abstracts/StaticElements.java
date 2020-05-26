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
    private int nextSlot=1;
    private StandardCollidableObject[] inventory = new StandardCollidableObject[6];
    Point[] locations = new Point[6];

    public StaticElements(){
        setVisible(false);
    }

    @Override
    public void setTexture(String fileName) {
        try {
            im = ImageIO.read(new File(".\\Assets\\Elements\\"+fileName));
            locations=getPoints(fileName);
            System.out.println(Arrays.toString(locations));
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
    public void addToInventory(StandardCollidableObject item){

    }
    private Point[] getPoints(String fileName){
        Point[] spawns = new Point[6];
        BufferedImage img=null;
        try {
            img = ImageIO.read(new File(".\\Assets\\Elements\\"+fileName+"-points.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        int g=0;
        for (int i = 0; i < img.getWidth(); i++) {
            for (int j = img.getHeight() - 1; j >= 0; j--) {
                int clr = img.getRGB(i, j);
                if (clr == -5955038){
                    spawns[g]=new Point(i,j);
                    g++;
                }
            }
        }
        return spawns;
    }
}
