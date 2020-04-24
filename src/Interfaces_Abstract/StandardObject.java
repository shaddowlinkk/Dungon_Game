package Interfaces_Abstract;

import Objects.BoundingBox;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.File;
import java.io.IOException;

public abstract class StandardObject extends JLabel implements BaseObject {
    public StandardObject(String filename){
        Icon im = null;
        try {
            im = new ImageIcon( ImageIO.read(new File(filename)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        setSize(im.getIconWidth(),im.getIconHeight());
        setIcon(im);
        setVisible(true);
    }
    @Override
    public BoundingBox getBoundingbox() {
        return null;
    }

    @Override
    public void setTexture(Icon img) {
        setIcon(img);
    }
}
