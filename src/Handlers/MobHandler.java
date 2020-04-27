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
        for (int i =0; i<obj.size();i++ ) {
            if (obj.get(i).getName().equals("Mob")){
                if(!((BaseMob)obj.get(i)).isAlive()){
                    screen.getContentPane().remove(obj.get(i));
                    obj.remove(i);
                }
            }
        }
    }
}
