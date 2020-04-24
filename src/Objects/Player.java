package Objects;

import Interfaces_Abstract.AnimatedObject;
import Interfaces_Abstract.ControlableObject;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Player extends AnimatedObject implements KeyListener {
    public Player() {
        super("Player-Sheet.png");
        setName("player");
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key==KeyEvent.VK_ENTER){
            System.out.println("test");
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
