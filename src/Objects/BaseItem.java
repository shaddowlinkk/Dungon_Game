package Objects;

import Abstracts.StandardCollidableObject;
import Enums.Items;
import Utils.Point;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class BaseItem extends StandardCollidableObject {
    private String type,name;
    private Items item;
    private ArrayList<Point> balls =new ArrayList<>();
    private Point activeBall;
    public BaseItem(Items item){
        this.item=item;
        this.type=item.getType();
        this.name=item.name();
        getBall();
        activeBall= balls.get(0);
        setName(this.type);
        setBoundingbox(item.name()+"-Points.png");
        setVisible(true);

        try {
            setTexture(new ImageIcon(ImageIO.read(new File(".\\Assets\\"+item.name()+".png"))));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void getBall(){
        BufferedImage img=null;
        try {
            img = ImageIO.read(new File(".\\Assets\\"+name + "-Points.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < img.getWidth(); i++) {
            for (int j = img.getHeight() - 1; j >= 0; j--) {
                int clr = img.getRGB(i, j);
                if (clr == -11194291) {
                    balls.add( new Point(i, j));
                }

            }
        }
    }

    public void setActiveBall(int index) {
        this.activeBall = balls.get(index);
    }

    public void attachToSocket(Point Object, Point socket) {
        if (Object!=null&&socket!=null){
            setloc((socket.getX() - activeBall.getX() + Object.getX()), (socket.getY() - activeBall.getY() + Object.getY()));
        }
    }
    public String getItemName(){
        return name;
    }

    public String getType() {
        return type;
    }
    public Items getItem() {
        return item;
    }

    public void collision(Player ply) {
        if(ply.isPickingUpItem()){
            ply.setHeldItem(this);
        }
    }
}
