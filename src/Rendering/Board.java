package Rendering;


import javax.swing.*;
import java.awt.event.*;

public class Board extends JFrame{
    private Boolean closing;
    private Rendering rend;
//todoworking on over all desine
    public Board(){
        closing=false;
        setSize(600,600);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.getContentPane().setLayout(null);
        addKeyListener (new KeyEventHandler());
        rend = new Rendering(this);
        rend.addImage("test.png","player");
        rend.render();
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

    public class KeyEventHandler implements KeyListener {
        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {
        }

        @Override
        public void keyReleased(KeyEvent e) {

        }
    }
    public Boolean getClosing(){
        return closing;
    }
}
