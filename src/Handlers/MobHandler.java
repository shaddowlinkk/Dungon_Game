package Handlers;

import Abstracts.BaseMob;
import Abstracts.ControlableObject;

import javax.swing.*;
import java.util.ArrayList;

public class MobHandler {
    private JFrame screen;
    public MobHandler(JFrame F){
        screen=F;
    }
    public void checkMobDeath(ArrayList<ControlableObject> obj){
        for (ControlableObject o: obj ) {
            if (o.getName().equals("Mob")){
                if(!((BaseMob)o).isAlive()){
                    screen.getContentPane().remove(o);
                }
            }
        }
    }
}
