package Inventory;

import Abstracts.StandardCollidableObject;
import Objects.BaseItem;

import javax.swing.*;
import java.awt.*;

public class InventorySlot extends JLabel {
    BaseItem item = null;
    public InventorySlot(){
    }

    public BaseItem getItem() {
        return item;
    }

    public void setItem(BaseItem item) {
        this.item = item;
        add(item,3,0);
        setText("f");
    }

}
