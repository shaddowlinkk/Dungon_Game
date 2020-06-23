package Editor.Objects;

import Editor.Screens.ObjectScreen;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GameTile extends JLabel {
    private Border border= BorderFactory. createLineBorder(Color.RED);
    private BufferedImage im;
    private ObjectScreen obj;

    public GameTile(ObjectScreen obj){
        this.obj=obj;
        setSize(32,32);
        setPreferredSize(new Dimension(32,32));
        setVisible(true);
        setBorder(border);
        setLayout(null);
        addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                border = BorderFactory.createLineBorder(Color.BLUE);
                setBorder(border);
                setTexture();
                repaint();
                revalidate();
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
               if(e.getModifiers()==16){
                   border = BorderFactory.createLineBorder(Color.BLUE);
                   setBorder(border);
                   setTexture();
                   repaint();
               }
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
    }
    public void setTexture() {
        try {
            im = ImageIO.read(new File(obj.GetSelectedTexture().split(":")[1]));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public String getTextureName(){
        try {
            return obj.GetSelectedTexture().split(":")[0];
        }catch (NullPointerException e){
            return null;
        }
    }
    @Override
    protected void paintComponent(Graphics g) {
        if(im!=null) {
            g.drawImage(im,0,0,null);
        }
        super.paintComponent(g);
    }
}
