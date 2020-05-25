package Rendering;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MainMenuScreen extends JPanel {
    private JLabel title = new JLabel("Untitled game");
    private JLabel play = new JLabel("play");
    private Border b = BorderFactory.createLineBorder(Color.blue,5);
    private boolean playing = false;
    public MainMenuScreen(int width, int height){
        setFocusable(true);
        setLayout(null);
        setVisible(true);
        setBackground(Color.black);
        setSize(width,height);
            //title card
            title.setFont(title.getFont().deriveFont(52f));
            title.setSize(500,75);
            title.setVerticalAlignment(SwingConstants.CENTER);
            title.setHorizontalAlignment(SwingConstants.CENTER);
            title.setForeground(Color.white);
            title.setLocation(((width/2)-(title.getWidth()/2)),50);

            play.setFont(play.getFont().deriveFont(25f));
            play.setSize(100,50);
            play.setBorder(b);
            play.setVerticalAlignment(SwingConstants.CENTER);
            play.setHorizontalAlignment(SwingConstants.CENTER);
            play.setForeground(Color.white);
            play.setLocation(((width/2)-(play.getWidth()/2)),250);
            play.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    playing=true;
                }

                @Override
                public void mousePressed(MouseEvent e) {

                }

                @Override
                public void mouseReleased(MouseEvent e) {

                }

                @Override
                public void mouseEntered(MouseEvent e) {
                    play.setSize(125,50);
                    play.setText(">play<");
                    play.setLocation(((width/2)-(play.getWidth()/2)),250);

                }

                @Override
                public void mouseExited(MouseEvent e) {
                    play.setSize(100,50);
                    play.setText("play");
                    play.setLocation(((width/2)-(play.getWidth()/2)),250);

                }
            });
            add(title);
            add(play);
        }

    public boolean isPlaying() {
        return playing;
    }
    public void reset(){
        playing=false;
    }
}
