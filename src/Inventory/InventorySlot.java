package Inventory;

import Abstracts.StandardCollidableObject;
import Objects.BaseItem;

import javax.swing.*;
import java.awt.*;

public class InventorySlot extends JLabel {
    BaseItem item = null;
    private Image im;

    public InventorySlot(){
    }

    public BaseItem getItem() {
        return item;
    }

    public void setItem(BaseItem item) {
        System.out.println(item);
        this.item = item;
        this.item.setLocation(0,0);
        repaint();
    }
    public void textr(){
        this.add(item);
    }

    @Override
    protected void paintComponent(Graphics g) {
        if(im!=null) {
            g.drawImage(im,0,0,null);
        }
        repaint();
    }
}
