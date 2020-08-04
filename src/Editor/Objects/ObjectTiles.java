package Editor.Objects;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ObjectTiles extends JLabel {
    private BufferedImage im=null;
    private String textures;
    private int id=0;
    public ObjectTiles(String textures){
        this.textures=textures;
        setSize(32,32);
        setPreferredSize(new Dimension(32,32));
        setToolTipText(textures.split(":")[0]);
        try {
            im = ImageIO.read(new File(textures.split(":")[1]));
            setSize(im.getWidth(),im.getHeight());
            setPreferredSize(new Dimension(im.getWidth(),im.getHeight()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        setVisible(true);
        repaint();
    }
    protected void paintComponent(Graphics g) {
        if(im!=null) {
            g.drawImage(im,0,0,null);
        }
        super.paintComponent(g);
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
    private class tooltips implements MouseListener {
        @Override
        public void mouseClicked(MouseEvent e) {

        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {
            ToolTipManager.sharedInstance().setDismissDelay(60000);

        }

        @Override
        public void mouseExited(MouseEvent e) {
            ToolTipManager.sharedInstance().setDismissDelay(60000);

        }
    }
}
