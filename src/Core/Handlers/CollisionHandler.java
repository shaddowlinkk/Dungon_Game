package Core.Handlers;

import Core.Abstracts.StandardCollidableObject;
import Core.Enums.ItemTypes;
import Core.Objects.BaseItem;
import Core.Objects.Door;
import Core.Objects.Player;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;

public class CollisionHandler {
    private boolean devloper =false;
    private ArrayList<StandardCollidableObject> movingEntitys = new ArrayList<>();
    private ArrayList<StandardCollidableObject> itemEntitys = new ArrayList<>();
    private ArrayList<StandardCollidableObject> groundEntitys = new ArrayList<>();
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
        try {
            for (StandardCollidableObject o : movingEntitys) {
                for (StandardCollidableObject b : itemEntitys) {
                    if (o != b) {
                        if (o.hasCollided(b)) {
                            if (ItemTypes.valueOf(b.getName()) != null && o.getName().equals("player")) {
                                ((BaseItem) b).collision((Player) o);
                            } else {
                                o.collision(b.getName());

                            }
                        }
                    }
                }
            }
        }catch (ConcurrentModificationException e){
            //todo why does it throw this error
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
