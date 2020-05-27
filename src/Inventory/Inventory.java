package Inventory;

import Abstracts.StandardCollidableObject;
import Abstracts.StaticElements;
import Objects.BaseItem;
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
    private int nextSlot=0;
    private boolean added= false;
    private int selcted;
    private InventorySlot[] slots = new InventorySlot[7];
    private Point[] locations = new Point[6];
    private Border b = BorderFactory.createLineBorder(Color.gray,1);

    public Inventory(){
        setTexture("INV");
        getPoints("INV");
    }

    public void addToInventory(BaseItem item){
        for (int i =0;i<6;i++) {
            if(slots[i].getItem()==null&& !added) {
                slots[i].setItem(item);
                added=true;
                break;
            }else if(slots[i].getItem()==item){
                break;
            }
        }
    }
    public StandardCollidableObject getItem(){
        return slots[selcted].getItem();
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
        slots[index]=new InventorySlot();
        super.add(slots[index],6,0);
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
    public void resetAdd(){
        added=false;
    }
}
