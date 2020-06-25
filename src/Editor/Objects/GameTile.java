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
    private String textureName=null;
    private Graphics c;
    private int reset=0;

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
            textureName=obj.GetSelectedTexture().split(":")[0];
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void resetBorder(){
        setBorder(BorderFactory. createLineBorder(Color.RED));
    }
    public void resetTexture(){
        im=null;
        textureName=null;
        repaint();
    }
    public void setTexture(int i) {
        try {
            im = ImageIO.read(new File(obj.getTecture(i).split(":")[1]));
            textureName=obj.getTecture(i).split(":")[0];
            repaint();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public String getTextureName(){
            return textureName;
    }

    @Override
    protected void paintComponent(Graphics g) {
            g.drawImage(im, 0, 0,null);
        super.paintComponent(g);

    }
}
