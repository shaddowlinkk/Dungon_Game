package Objects;

import Abstracts.AnimatedObject;
import Abstracts.StandardCollidableObject;
import Enums.Items;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Player extends AnimatedObject implements KeyListener {
     private int state=0;
     private StandardCollidableObject heldItem = null;
     private Boolean alive=true,pickingUpItem=false;

    public Player() {
        super("Player");
        setBoundingbox("Player-Points.png");
        super.setDelay(6);
        super.setFrameState(state,9);
        setName("player");
    }


    @Override
    public void collision(String type){
        if(type.equals("Mob")){
            alive=false;
        }
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
            System.out.println(state);
        }

        if (key == KeyEvent.VK_LEFT) {
            if(state<2) {
                state = 3;
                super.setDelay(2);
                super.setFrameState(state, 22);
            }
            super.setDX(-1);

        }

        if (key == KeyEvent.VK_RIGHT) {
            if(state<2) {
                state = 2;
                super.setDelay(2);
                super.setFrameState(state, 22);
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
            heldItem=null;
        }
    }
}
