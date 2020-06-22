package Core.Inventory;

import Core.Abstracts.StandardCollidableObject;
import Core.Objects.BaseElement;
import Core.Objects.BaseItem;
import Core.Objects.Player;
import Core.Rendering.GameScreen;
import Core.Utils.Point;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class InventorySlot extends BaseElement implements MouseListener {
    private ArrayList<StandardCollidableObject> itemEntity = new ArrayList<>();
    private Border b = BorderFactory.createLineBorder(Color.orange,1);
    private BaseItem item = null;
    private GameScreen mainscreen=null;
    private Image im=null;
    private Color c = Color.CYAN;
    private Player player;

    public InventorySlot(Point location){
        super();
        setSize(32,32);
        setloc(location.getX(),location.getY());
        setBorder(b);
        setVisible(true);
        addMouseListener(this);
    }

    public BaseItem getItem() {
        return item;
    }

    public void setItemEntity(ArrayList<StandardCollidableObject> itemEntity) {
        this.itemEntity = itemEntity;
    }

    public void setItem(BaseItem item) {
            im=item.getTexture();
            this.item=item;
            mainscreen.time.stop();
            itemEntity.remove(item);
            mainscreen.time.start();
            mainscreen.rerender();
            repaint();
    }

    public void setMainscreen(GameScreen mainscreen) {
        this.mainscreen = mainscreen;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    @Override
    protected void paintComponent(Graphics g) {
        if(im!=null) {
            g.drawImage(im,5,5,null);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        b = BorderFactory.createLineBorder(Color.MAGENTA,1);
        if(item!=null) {
            item.setHeld(true);
            itemEntity.remove(player.getHeldItem());
        }
        player.setHeldItem(item);
        if(item!=null){
            itemEntity.add(item);
            mainscreen.rerender();
        }
        setBorder(b);

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
        setBorder(b);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        b = BorderFactory.createLineBorder(Color.green, 1);
        setBorder(b);
    }

}
