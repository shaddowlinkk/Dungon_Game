package Abstracts;

import Handlers.CollisionDetectorHandler;
import Interfaces.BaseCollidableObject;
import Utils.BoundingBox;
import Utils.Point;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public abstract class StandardCollidableObject extends JLabel implements BaseCollidableObject {
    private int _x,_y,angle;
    private int scaledWidth=0;
    private int scaledHeight=0;
    private BoundingBox  box;
    private BoundingBox  drawbox;
    private CollisionDetectorHandler Collision= new CollisionDetectorHandler();
    private Image im;

    public StandardCollidableObject(){setVisible(true);}
    @Override
    public BoundingBox getBoundingbox() {
        return box;
    }

    @Override
    public void setBoundingbox(String fileName) {
        box= new BoundingBox(fileName);
        drawbox= new BoundingBox(fileName);
    }

    @Override
    public Boolean hasCollided(StandardCollidableObject obj){
        return Collision.checkCollition(this,obj);
    }
    public void collision(String type){
    }

   public void setAngle(int angle) {
        this.angle = angle;
        box.rotate(angle);
    }
    @Override public void setTexture(Icon img) {
        setSize(img.getIconWidth(),img.getIconHeight());
        setIcon(img);
        //System.out.println("need to del call");

    }
    public void setTexture(BufferedImage i) {
        im=i;
        //setScale(im.getWidth(null),im.getHeight(null));
        setSize(i.getWidth(),i.getHeight());
    }
    public void setTexture(String fileName) {
        try {
            im = ImageIO.read(new File(".\\Assets\\"+fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        setSize(im.getWidth(null),im.getHeight(null));
        //setScale(im.getWidth(null),im.getHeight(null));
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
    public void setScale(double f){
        scaledWidth = (int) (im.getWidth(null) * f);
         scaledHeight = (int) (im.getHeight(null) * f);
    }
    public void setScale(int w, int h){
        scaledHeight=h;
        scaledWidth=w;

    }
    protected void paintComponent(Graphics g) {
/*        Graphics2D gx = (Graphics2D) g;
        gx.rotate(0.6,  getWidth()/2, getHeight()/2);*/
            Graphics2D g2 = (Graphics2D)g;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);
            AffineTransform aT = g2.getTransform();
            Shape oldshape = g2.getClip();
            double x = getWidth()/2.0;
            double y = getHeight()/2.0;
            aT.rotate(Math.toRadians(angle), x, y);
            g2.setTransform(aT);
            g2.setClip(oldshape);
       if(im!=null) {
            g.drawImage(im,0,0,null);
        }
        if(box!=null){
            Polygon hitbox = new Polygon();
            for (Point p : drawbox.getPolygon()){
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
