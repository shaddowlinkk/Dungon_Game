package Objects;

import Abstracts.AnimatedObject;
import Abstracts.StandardCollidableObject;
import Inventory.Inventory;
import Utils.Point;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Player extends AnimatedObject implements KeyListener {
    private boolean invOpen=false;
    private Inventory in;
    private ArrayList<Point> Sockets=new ArrayList<>();
    private Point activeSocket;
     private int state=0;
     private StandardCollidableObject heldItem = null;
     private BaseItem[] refItem= new BaseItem[1];
     private Boolean alive=true,pickingUpItem=false;
     private int indor =-1;

    public Player() {
        super("Player");
        setBoundingbox("Player-Points.png");
        getSockets();
        activeSocket=Sockets.get(1);
        super.setDelay(6);
        super.setFrameState(state,9);
        setName("player");
        setBackground(new Color(0,0,0,200));
        setVisible(true);

    }

    public void setIn(Inventory in) {
        this.in = in;
        in.setPlayer(this);
    }

    private void getSockets(){
        BufferedImage img =null;
        try {
            img = ImageIO.read(new File(".\\Assets\\Player-Points.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < img.getWidth(); i++) {
            for (int j = img.getHeight() - 1; j >= 0; j--) {
                int clr = img.getRGB(i, j);
                if (clr == -7185274) {
                    Sockets.add(new Point(i, j));
                }
            }
        }
    }

    public Point getActiveSocket() {
        return activeSocket;
    }
    public Point gePos() {
        return new Point(this.getX(),this.getY());
    }


    @Override
    public void collision(String type){
        if(type.equals("Mob")){
            alive=false;
        }else if(type.equals("Wall")){
            super.setDY((super.getDY()*(-1)));
            super.setDX((super.getDX()*(-1)));
            super.move();
            super.setDY((super.getDY()*(-1)));
            super.setDX((super.getDX()*(-1)));
        }else if(type.equals("Door") && (heldItem==null||!(((BaseItem)heldItem).getName().equals("Key")))){
            super.setDY((super.getDY()*(-1)));
            super.setDX((super.getDX()*(-1)));
            super.move();
            super.setDY((super.getDY()*(-1)));
            super.setDX((super.getDX()*(-1)));
    }
    }

   public void collision(Door d){
       if(!d.getLocked()){
           indor=d.getDoorNum();
           heldItem=null;
       } else if(heldItem==null||!(((BaseItem)heldItem).getName().equals("Key"))){
            super.setDY((super.getDY()*(-1)));
            super.setDX((super.getDX()*(-1)));
            super.move();
            super.setDY((super.getDY()*(-1)));
            super.setDX((super.getDX()*(-1)));
        }else{
            d.Unlock();
       }
    }

    public int getIndoor() {
        return indor;
    }
    public void resetIndoor(){
        indor=-1;
    }

    public Boolean isAlive(){
        return alive;
    }

    public Boolean isPickingUpItem() {
        return pickingUpItem;
    }
    public void setHeldItem(StandardCollidableObject heldItem) {
        this.heldItem = heldItem;
    }
    public void addToInventory(StandardCollidableObject heldItem){
        in.addToInventory((BaseItem) heldItem);

    }
    public StandardCollidableObject getHeldItem() {
        return heldItem;
    }

    public Boolean hasItem(){
        return heldItem != null;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key==KeyEvent.VK_ENTER){
        }

        if (key == KeyEvent.VK_LEFT) {
            if(state<2) {
                state = 3;
                super.setDelay(2);
                super.setFrameState(state, 22);
                activeSocket=Sockets.get(0);
                if(hasItem()) {
                    heldItem.setAngle(180);
                    ((BaseItem)heldItem).setActiveBall(1);
                }

            }
            super.setDX(-1);

        }

        if (key == KeyEvent.VK_RIGHT) {
            if(state<2) {
                state = 2;
                super.setDelay(2);
                super.setFrameState(state, 22);
                activeSocket=Sockets.get(1);
                if(hasItem()) {
                    heldItem.setAngle(0);
                    ((BaseItem)heldItem).setActiveBall(0);
                }

            }
            super.setDX(1);
        }

        if (key == KeyEvent.VK_UP) {
            if(state<2) {
                state = state + 2;
                super.setDelay(2);
                super.setFrameState(state,22);
            }

            super.setDY(-1);
        }

        if (key == KeyEvent.VK_DOWN) {
            if (state < 2) {
                state = state + 2;
                super.setDelay(2);
                super.setFrameState(state, 22);
            }
            super.setDY(1);

        }
        if(key==KeyEvent.VK_F){
            pickingUpItem=true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            if(state>=2) {
                state = state - 2;
                super.setDelay(7);
                super.setFrameState(state,9);
            }

            super.setDX(0);
        }

        if (key == KeyEvent.VK_RIGHT) {
            if(state>=2) {
                state = state - 2;
                super.setDelay(7);
                super.setFrameState(state,9);
            }

            super.setDX(0);
        }

        if (key == KeyEvent.VK_UP) {
            if(state>=2) {
                state = state - 2;
                super.setDelay(7);
                super.setFrameState(state,9);
            }

            super.setDY(0);
        }

        if (key == KeyEvent.VK_DOWN) {
            if(state>=2) {
                state = state - 2;
                super.setDelay(7);
                super.setFrameState(state,9);
            }

            super.setDY(0);
        }
        if(key==KeyEvent.VK_F){
            pickingUpItem=false;
        }
        if(key==KeyEvent.VK_Q){
            heldItem=new NullObject();
        }
    }


}
