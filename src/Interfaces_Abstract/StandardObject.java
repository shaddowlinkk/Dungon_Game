package Interfaces_Abstract;

import Objects.BoundingBox;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public abstract class StandardObject extends JLabel implements BaseObject {
    private int _x,_y;
    private String file;
   public StandardObject(String filename){
        file=filename;
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
    public StandardObject(){setVisible(true);}
    @Override
    public BoundingBox getBoundingbox() {
        return null;
    }

    @Override
    public void setTexture(Icon img) {
        setSize(img.getIconWidth(),img.getIconHeight());
        setIcon(img);
    }
    public void setTexture(String fileName) {
        Icon im = null;
        try {
            im = new ImageIcon( ImageIO.read(new File(fileName)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        setSize(im.getIconWidth(),im.getIconHeight());
        setIcon(im);
    }

    @Override
    public void setloc(int x, int y) {
        _x=x;
        _y=y;
        setLocation(x,y);
    }
    @Override
    public int getX(){
        return _x;
    }
    @Override
    public int getY(){
        return _y;
    }
    //TODO work on drawing bounding box
/*    public void paint(Graphics g) {
        g.setColor(Color.blue);
        g.drawRect (0, 0, 79, 79);
        try {
            g.drawImage(ImageIO.read(new File(file)),0,0,null);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }*/
}
