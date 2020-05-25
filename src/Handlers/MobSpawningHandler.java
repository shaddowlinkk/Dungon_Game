package Handlers;

import Abstracts.ControlableObject;
import Enums.Mobs;
import Objects.BaseMob;

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
        int low = 0;
        int high = 1;
        int g= rand.nextInt(high-low) + low;
        //System.out.println(g);
        low=35;
        high=555;
        for (int i=0;i<=g;i++){
            BaseMob s = new BaseMob(Mobs.Slime);
            s.setloc(rand.nextInt(high-low)+low,rand.nextInt(high-low)+low);
            if(entity.get(0).hasCollided(s)){
                s.setloc(rand.nextInt(high-low)+low,rand.nextInt(high-low)+low);
            }
            entity.add(s);
        }
        spawned=true;
    }

    public Boolean getSpawned() {
        return spawned;
    }
    public void resetSpawned(){
        spawned=false;
    }
}
