package Handlers;

import Abstracts.StandardCollidableObject;

import java.util.ArrayList;

public class CollisionHandler {
    public ArrayList<StandardCollidableObject> objects = new ArrayList<>();
    public CollisionHandler(ArrayList<StandardCollidableObject> obj){
        objects=obj;
    }
    public void checkCollisions(){
        for (StandardCollidableObject o : objects){
            for (StandardCollidableObject b : objects){
                if(o!=b){
                    if(o.hasCollided(b)) {
                        o.collision(b.getName());
                    }
                }
            }

        }
    }
}
