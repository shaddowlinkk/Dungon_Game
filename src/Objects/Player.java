package Objects;

import Interfaces_Abstract.ControlableObject;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Player extends ControlableObject implements KeyListener {
    public Player(String filename) {
        super(filename);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key==KeyEvent.VK_ENTER){
            super.move();
        }

        if (key == KeyEvent.VK_LEFT) {
            super.setDX(-1);

        }

        if (key == KeyEvent.VK_RIGHT) {
            super.setDX(1);
        }

        if (key == KeyEvent.VK_UP) {
            super.setDY(-1);
        }

        if (key == KeyEvent.VK_DOWN) {
            super.setDY(1);

        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            super.setDX(0);
        }

        if (key == KeyEvent.VK_RIGHT) {
            super.setDX(0);
        }

        if (key == KeyEvent.VK_UP) {
            super.setDY(0);
        }

        if (key == KeyEvent.VK_DOWN) {
            super.setDY(0);
        }
    }
}
