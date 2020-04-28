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
                    ((BaseItem)((Player)obj).getHeldItem()).attachToSocket(((Player)obj).gePos(),((Player)obj).getActiveSocket());
                }
            }
        }
    }
}
