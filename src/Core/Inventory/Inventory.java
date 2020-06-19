package Core.Inventory;

import Core.Abstracts.StandardCollidableObject;
import Core.Objects.BaseElement;
import Core.Objects.BaseItem;
import Core.Objects.Player;
import Core.Rendering.GameScreen;
import Utils.Point;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Inventory extends BaseElement {
    private int nextSlot = 0;
    private boolean added = false;
    private int selcted;
    private int nextslot=0;
    private InventorySlot[] slots = new InventorySlot[7];
    private Point[] locations = new Point[6];
    private Border b = BorderFactory.createLineBorder(Color.orange, 1);

    public Inventory() {
        super("INV.png");
        getPoints("INV");
        setBorder(b);
        setVisible(false);
    }
    public void addToInventory(BaseItem item) {
            if (slots[nextSlot].getItem() == null && !added) {
                slots[nextSlot].setItem(item);
                added=true;
                nextSlot++;
            } else if (slots[nextSlot-1].getItem() != item) {
                restAdd();
            }
    }

    public StandardCollidableObject getItem() {
        return slots[selcted].getItem();
    }
    public void setMainscreen(GameScreen mainscreen) {
        for(int i =0;i<6;i++) {
            slots[i].setMainscreen(mainscreen);
        }
    }
    public void setPlayer(Player player) {
        for(int i =0;i<6;i++) {
            slots[i].setPlayer(player);
        }
    }

    public void setItemEntity(ArrayList<StandardCollidableObject> itemEntity) {
        for(int i =0;i<6;i++) {
            slots[i].setItemEntity(itemEntity);
        }
    }

    private Point[] getPoints(String fileName) {
        Point[] spawns = new Point[6];
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File(".\\Assets\\Elements\\" + fileName + "-points.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        int g = 0;
        for (int i = 0; i < img.getWidth(); i++) {
            for (int j = img.getHeight() - 1; j >= 0; j--) {
                int clr = img.getRGB(i, j);
                if (clr == -5955038) {
                    spawns[g] = new Point(i, j);
                    slots[g] = new InventorySlot(spawns[g]);
                    add(slots[g],6,0);
                    g++;
                }
            }
        }
        return spawns;
    }
    public void restAdd(){
        added=false;
    }
}
