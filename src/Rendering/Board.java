package Rendering;


import Interfaces_Abstract.BaseObject;
import Objects.Player;

import javax.swing.*;
import java.awt.event.*;

public class Board extends JFrame{
    private Rendering rend;
    private BaseObject[] test ={new Player("test.png")};

    //todoworking on over all desine
    public Board(){

        setSize(600,600);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.getContentPane().setLayout(null);
        rend = new Rendering(this);
        rend.addObject(new Player("test.png"));
        rend.renderObjects();
        Timer time = new Timer( 10,new TimerHandler());
        time.start();
    }



    /*
    Used for tick action control rate
     */
    private class TimerHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }

    /*
    Key Event hadneler foe key based events
     */

/*    private class KeyEventHandler implements KeyListener {
        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {
            if(e.getKeyCode()==KeyEvent.VK_ENTER){
                System.out.println("tesyt");
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {

        }
    }
    public Boolean getClosing(){
        return closing;
    }*/
}
