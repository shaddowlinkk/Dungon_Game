package Handlers;

import Abstracts.ControlableObject;

import java.util.ArrayList;

//to do find out why objects not rendering rightK
public class MovingObjectHandler{

     private ArrayList<ControlableObject> objects = new ArrayList<ControlableObject>();
    public MovingObjectHandler(ArrayList<ControlableObject> objects){
        this.objects=objects;
    }
    public void addObject(ControlableObject obj){
        objects.add(obj);
    }
    public void moveObjects(){
        for (ControlableObject o: objects) {
            o.move();
        }
    }
    public ControlableObject getObject(int i) {
        return objects.get(i);
    }
}

