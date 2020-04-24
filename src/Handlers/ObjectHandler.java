package Handlers;

import Interfaces_Abstract.BaseObject;

import java.util.ArrayList;

//to do find out why images not rendering rightK
public class ObjectHandler {
    public ArrayList<BaseObject> objects = new ArrayList<BaseObject>();
    public ObjectHandler(){
    }
    public void addObject(BaseObject obj){
        objects.add(obj);
    }

    public BaseObject getObject( int i) {
        return objects.get(i);
    }

}
