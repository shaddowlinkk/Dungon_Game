package Handlers;

import Interfaces_Abstract.ControlableObject;

import java.util.ArrayList;

//to do find out why objects not rendering rightK
public class MovingObjectHandler {

     public ArrayList<ControlableObject> objects = new ArrayList<ControlableObject>();
    public MovingObjectHandler(){
    }
    public void addObject(ControlableObject obj){
        objects.add(obj);
    }
    public void setObjects(ArrayList<ControlableObject> M){
        objects=M;
    }
    public void moveObjects(){
        for (ControlableObject o: objects) {
            o.move();
        }
    }
    public ControlableObject getObject( int i) {
        return objects.get(i);
    }
}

