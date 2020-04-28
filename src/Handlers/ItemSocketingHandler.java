package Handlers;


import Objects.BaseItem;
import Abstracts.StandardCollidableObject;
import Objects.Player;
import Utils.Point;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
//to do find out why images not rendering rightK
// Socket color - 925c86 : -7185274
// ball color - 55304d : -11194291
public class ItemSocketingHandler {
    private ArrayList<StandardCollidableObject> MovingObj;
    public ItemSocketingHandler(ArrayList<StandardCollidableObject> MovingObj){
        this.MovingObj=MovingObj;

    }
    public void AttachToSocket() {
        StandardCollidableObject object;
        Point socket = null, ball =null;
        for (StandardCollidableObject obj : MovingObj) {
            if (obj.getName().equals("player")) {
                if (((Player)obj).hasItem()) {
                    object = ((Player) obj).getHeldItem();
                    BufferedImage img = null;
                    try {
                        img = ImageIO.read(new File("Player-Points.png"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    for (int i = 0; i < img.getWidth(); i++) {
                        for (int j = img.getHeight() - 1; j >= 0; j--) {
                            int clr = img.getRGB(i, j);
                            if (clr == -7185274) {
                                socket = new Point(i, j);
                            }

                        }
                    }
                    try {
                        img = ImageIO.read(new File(((BaseItem)object).getItemName() + "-Points.png"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    for (int i = 0; i < img.getWidth(); i++) {
                        for (int j = img.getHeight() - 1; j >= 0; j--) {
                            int clr = img.getRGB(i, j);
                            if (clr == -11194291) {
                                ball = new Point(i, j);
                            }

                        }
                    }
                    ((Player)obj).getHeldItem().setloc((socket.getX() - ball.getX() + (obj).getX()), (socket.getY() - ball.getY() + (obj).getY()));
                    //end of if
                }
            }
        }
    }
}
