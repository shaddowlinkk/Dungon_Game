package Handlers;

import Interfaces_Abstract.ControlableObject;
import Objects.Slime;

import java.util.ArrayList;
import java.util.Random;

public class MobSpawningHandler {
    private ArrayList<ControlableObject> entity;
    private Boolean spawned= false;
    private Random rand = new Random();
    public MobSpawningHandler(ArrayList<ControlableObject> entityList){
        entity=entityList;
    }
    public void spawnMobs(){
        int g= rand.nextInt(6);
        for (int i=0;i<=g;i++){
            Slime s = new Slime("Slime-Sheet.png");
            s.setloc(rand.nextInt(520),rand.nextInt(520));
            entity.add(s);
        }
        spawned=true;
    }

    public Boolean getSpawned() {
        return spawned;
    }
}
