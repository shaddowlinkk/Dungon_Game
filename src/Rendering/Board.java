package Rendering;

import EventHandlers.TimerHandler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Arrays;

public class Board extends JFrame{
    private Boolean closing;
//todo fix rendering images to frame
    public Board(){
        closing=false;
        setSize(600,600);
        setVisible(true);
        this.getContentPane().setLayout(null);
        this.getContentPane().setSize(600,600);
        this.getContentPane().setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        /*main.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("test");
                closing=true;
                main.dispose();
            }
        });*/

        Rendering rend = new Rendering(this);
        rend.addImage("test.png");
        rend.addImage("TEST2.bmp");
        rend.render();
       //this.getContentPane().getComponent(0).setLocation(0,0);
       //this.getContentPane().getComponent(1).setLocation(100,100);
        repaint();

        Timer time = new Timer( 10,new TimerHandler(this));
        time.start();
    }
    public Boolean getClosing(){
        return closing;
    }
}
