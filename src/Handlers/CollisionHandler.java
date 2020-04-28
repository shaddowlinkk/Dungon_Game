package Handlers;

import Abstracts.StandardCollidableObject;
import Enums.ItemTypes;
import Enums.Items;
import Objects.BaseItem;
import Objects.Player;

import java.util.ArrayList;

public class CollisionHandler {
    public ArrayList<StandardCollidableObject> movingEntitys = new ArrayList<>();
    public ArrayList<StandardCollidableObject> staticEntitys = new ArrayList<>();
    public CollisionHandler(ArrayList<StandardCollidableObject> moving,ArrayList<StandardCollidableObject> staticEn){
        movingEntitys =moving;
        staticEntitys=staticEn;
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
            for (StandardCollidableObject b : staticEntitys){
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
    }
}
