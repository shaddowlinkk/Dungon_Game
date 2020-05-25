package Rendering;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class EndScreen extends JPanel {
    private JLabel endtext = new JLabel("You Have Died");
    private JLabel score = new JLabel("Score:");
    private JLabel num = new JLabel();
    private JLabel retrun = new JLabel("Back to main menu");
    private JLabel respawn = new JLabel("Respawn");
    private Border b = BorderFactory.createLineBorder(Color.blue,5);
    private boolean respawnState =false, outState=false;
    private int scorenum=0;
    public EndScreen(int width,int height) {
        //Panel parameters
        setFocusable(false);
        setLayout(null);
        setVisible(true);
        setBackground(Color.black);
        setSize(width,height);
        // End text parameters
        endtext.setFont(endtext.getFont().deriveFont(52f));
        endtext.setSize(500,75);
        //endtext.setBorder(b);
        endtext.setVerticalAlignment(SwingConstants.CENTER);
        endtext.setHorizontalAlignment(SwingConstants.CENTER);
        endtext.setForeground(Color.white);
        endtext.setLocation(((width/2)-(endtext.getWidth()/2)),50);
        
        //return
        retrun.setFont(retrun.getFont().deriveFont(25f));
        retrun.setSize(250,50);
        retrun.setBorder(b);
        retrun.setVerticalAlignment(SwingConstants.CENTER);
        retrun.setHorizontalAlignment(SwingConstants.CENTER);
        retrun.setForeground(Color.white);
        retrun.setLocation(((width/2)-(retrun.getWidth()/2)),250);
        retrun.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                outState=true;
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                retrun.setSize(275,50);
                retrun.setText(">Back to main menu<");
                retrun.setLocation(((width/2)-(retrun.getWidth()/2)),250);

            }

            @Override
            public void mouseExited(MouseEvent e) {
                retrun.setSize(250,50);
                retrun.setText("Back to main menu");
                retrun.setLocation(((width/2)-(retrun.getWidth()/2)),250);

            }
        });
        
        //respawn
        respawn.setFont(respawn.getFont().deriveFont(25f));
        respawn.setSize(150,50);
        respawn.setBorder(b);
        respawn.setVerticalAlignment(SwingConstants.CENTER);
        respawn.setHorizontalAlignment(SwingConstants.CENTER);
        respawn.setForeground(Color.white);
        respawn.setLocation(((width/2)-(respawn.getWidth()/2)),300);
        respawn.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                outState=true;
                respawnState =true;
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                respawn.setSize(175,50);
                respawn.setText(">Respawn<");
                respawn.setLocation(((width/2)-(respawn.getWidth()/2)),300);

            }

            @Override
            public void mouseExited(MouseEvent e) {
                respawn.setSize(150,50);
                respawn.setText("Respawn");
                respawn.setLocation(((width/2)-(respawn.getWidth()/2)),300);

            }
        });

        //Score
        score.setFont(score.getFont().deriveFont(25f));
        score.setSize(125,50);
        //score.setBorder(b);
        score.setVerticalAlignment(SwingConstants.CENTER);
        score.setHorizontalAlignment(SwingConstants.CENTER);
        score.setForeground(Color.white);
        score.setLocation(((width/2)-(score.getWidth()/2)),125);
        
        //num

        num.setFont(num.getFont().deriveFont(25f));
        num.setSize(125,30);
        //num.setBorder(b);
        num.setVerticalAlignment(SwingConstants.CENTER);
        num.setHorizontalAlignment(SwingConstants.CENTER);
        num.setForeground(Color.white);
        num.setLocation(((width/2)-(num.getWidth()/2)),175);

        
        
        
        // adds
        add(num);
        add(score);
        add(respawn);
        add(retrun);
        add(endtext);
        repaint();
    }

    public boolean isOutState() {
        return outState;
    }
    public void reset(){
        outState=false;
        respawnState=false;
        setFocusable(false);
    }

    public void setScore(int score) {
        num.setText(""+score);
    }

    public boolean isRespawnState() {
        return respawnState;
    }
}