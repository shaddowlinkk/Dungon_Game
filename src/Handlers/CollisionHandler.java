package Handlers;

import Abstracts.StandardCollidableObject;
import Enums.ItemTypes;
import Objects.BaseItem;
import Objects.Door;
import Objects.Player;

import java.util.ArrayList;

public class CollisionHandler {
    public ArrayList<StandardCollidableObject> movingEntitys = new ArrayList<>();
    public ArrayList<StandardCollidableObject> itemEntitys = new ArrayList<>();
    public ArrayList<StandardCollidableObject> groundEntitys = new ArrayList<>();
    public CollisionHandler(ArrayList<StandardCollidableObject> moving,ArrayList<StandardCollidableObject> staticEn,ArrayList<StandardCollidableObject> groundEntitys){
        movingEntitys =moving;
        itemEntitys =staticEn;
        this.groundEntitys=groundEntitys;
    }
    public void checkCollisions(){
        for (StandardCollidableObject o : movingEntitys){
            for (StandardCollidableObject b : movingEntitys){
                if(o!=b){
                    if(o.hasCollided(b)) {
                        o.collision(b.getName());
                    }
                }
            }

        }
        for (StandardCollidableObject o : movingEntitys){
            for (StandardCollidableObject b : itemEntitys){
                if(o!=b){
                    if(o.hasCollided(b)) {
                        if(ItemTypes.valueOf(b.getName())!=null && o.getName().equals("player")){
                            ((BaseItem)b).collision((Player) o);
                        }else {
                            o.collision(b.getName());

                        }
                    }
                }
            }

        }
        for (StandardCollidableObject o : movingEntitys){
            for (StandardCollidableObject b : groundEntitys){
                if(o!=b){
                    if(b.getBoundingbox()!=null) {
                        if (o.hasCollided(b)) {
                            if(o.getName().equals("player")&&b.getName().equals("Door")){
                                ((Player)o).collision((Door)b);
                                itemEntitys.remove(((Player)o).getHeldItem());
                            }
                                o.collision(b.getName());
                        }
                    }
                }
            }

        }
    }
}
