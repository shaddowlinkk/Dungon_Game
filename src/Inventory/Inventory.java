package Inventory;

import Abstracts.StandardCollidableObject;
import Abstracts.StaticElements;
import Utils.Point;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class Inventory extends StaticElements {
    private int nextSlot=1;
    private int selcted;
    private JLabel[] slots = new JLabel[6];
    private Point[] locations = new Point[6];
    private Border b = BorderFactory.createLineBorder(Color.gray,1);

    public Inventory(String name){
        setTexture(name);
        getPoints(name);
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
                    makeSlot(g,spawns[g]);
                    g++;
                }
            }
        }
        return spawns;
    }
    public void makeSlot(int index,Point location){
        slots[index]=new JLabel();
        add(slots[index]);
        slots[index].setSize(32,32);
        slots[index].setLocation(location.getX(),location.getY());
        slots[index].setBorder(b);
        slots[index].setVisible(true);
        slots[index].addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                b = BorderFactory.createLineBorder(Color.gray, 1);
                slots[selcted].setBorder(b);
                b = BorderFactory.createLineBorder(Color.green,1);
                selcted=index;
                slots[index].setBorder(b);

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                b = BorderFactory.createLineBorder(Color.blue,1);
                slots[index].setBorder(b);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                if(index!=selcted) {
                    b = BorderFactory.createLineBorder(Color.gray, 1);
                    slots[index].setBorder(b);
                }

            }
        });
    }
}
