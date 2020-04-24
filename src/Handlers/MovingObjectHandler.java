package Handlers;

import Interfaces_Abstract.MoveableObject;

import java.util.ArrayList;

//to do find out why objects not rendering rightK
public class MovingObjectHandler {

     public ArrayList<MoveableObject> objects = new ArrayList<MoveableObject>();
    public MovingObjectHandler(){
    }
    public void addObject(MoveableObject obj){
        objects.add(obj);
    }
    public void moveObjects(){
        for (MoveableObject o: objects) {
            o.move();
        }
    }
    public MoveableObject getObject( int i) {
        return objects.get(i);
    }
}

