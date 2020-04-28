package Objects;

import Abstracts.StandardCollidableObject;
import Enums.Items;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.File;
import java.io.IOException;

public class BaseItem extends StandardCollidableObject {
    private String type,name;
    private Items item;

    public BaseItem(Items item){
        this.item=item;
        this.type=item.getType();
        this.name=item.name();
        setName(this.type);
        setBoundingbox(item.name()+"-Points.png");
        setVisible(true);
        try {
            setTexture(new ImageIcon(ImageIO.read(new File(".\\Assets\\"+item.name()+".png"))));
        } catch (IOException e) {
            e.printStackTrace();
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
