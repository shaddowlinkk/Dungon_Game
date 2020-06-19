package Core.Handlers;

import Core.Abstracts.StandardCollidableObject;

import java.util.ArrayList;

public class DoorUnlockHandler {
    private  ArrayList<StandardCollidableObject> groundEntitys;

    public DoorUnlockHandler(ArrayList<StandardCollidableObject> groundEntitys){
        this.groundEntitys=groundEntitys;
    }
    public void unlock() {
        for (StandardCollidableObject b : groundEntitys) {

        }
    }
}
