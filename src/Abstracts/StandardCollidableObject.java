package Abstracts;

import Handlers.CollisionDetectorHandler;
import Interfaces.BaseCollidableObject;
import Utils.BoundingBox;
import Utils.Point;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public abstract class StandardCollidableObject extends JLabel implements BaseCollidableObject {
    private int _x,_y;
    private BoundingBox box;
    private CollisionDetectorHandler Collision= new CollisionDetectorHandler();
    private Image im;
  /* public StandardObject(String filename){
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

    }*/
    public StandardCollidableObject(){setVisible(true);}
    @Override
    public BoundingBox getBoundingbox() {
        return box;
    }

    @Override
    public void setBoundingbox(String fileName) {
        box= new BoundingBox(fileName);
    }

    @Override
    public Boolean hasCollided(StandardCollidableObject obj){
        return Collision.checkCollition(this,obj);
    }
    public void collision(String type){
    }


    @Override
    public void setTexture(Icon img) {
        setSize(img.getIconWidth(),img.getIconHeight());
        setIcon(img);

    }
    public void setTexture(BufferedImage i) {
        im=i;
        setSize(i.getWidth(),i.getHeight());
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

    protected void paintComponent(Graphics g) {
        if(im!=null) {
            g.drawImage(im,0,0,null);
        }
        if(box!=null){
            Polygon hitbox = new Polygon();
            for (Point p : box.getPolygon()){
                hitbox.addPoint(p.getX(),p.getY());
            }
            g.setColor(Color.blue);
            g.drawPolygon(hitbox);
        }
        super.paintComponent(g);
    }
/*    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(im,_x,_y,null);
        repaint();

    }*/
}
