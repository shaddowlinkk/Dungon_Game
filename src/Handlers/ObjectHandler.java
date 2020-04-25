package Handlers;

import Interfaces_Abstract.BaseCollidableObject;

import java.util.ArrayList;

//to do find out why images not rendering rightK
public class ObjectHandler {
    public ArrayList<BaseCollidableObject> objects = new ArrayList<BaseCollidableObject>();
    public ObjectHandler(){
    }
    public void addObject(BaseCollidableObject obj){
        objects.add(obj);
    }

    public BaseCollidableObject getObject(int i) {
        return objects.get(i);
    }

}
