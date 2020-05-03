package Handlers;

import Abstracts.StandardCollidableObject;

import java.util.ArrayList;

public class DoorUnlockhandeler {
    private  ArrayList<StandardCollidableObject> groundEntitys;

    public DoorUnlockhandeler(ArrayList<StandardCollidableObject> groundEntitys){
        this.groundEntitys=groundEntitys;
    }
    public void unlock() {
        for (StandardCollidableObject b : groundEntitys) {

        }
    }
}
