package Handlers;

import Objects.BaseMob;
import Abstracts.ControlableObject;

import javax.swing.*;
import java.util.ArrayList;

public class MobHandler {
    private JComponent screen;
    private int mobCount=0;
    public MobHandler(JComponent F){
        screen=F;
    }
    public void checkMobDeath(ArrayList<ControlableObject> obj){
        mobCount=0;
        for (int i =0; i<obj.size();i++ ) {
            if (obj.get(i).getName().equals("Mob")){
                if(!((BaseMob)obj.get(i)).isAlive()){
                    screen.remove(obj.get(i));
                    obj.remove(i);
                }else{
                    ((BaseMob) obj.get(i)).pathTo(obj.get(0));
                }
                mobCount++;
            }
        }
    }

    public int getMobCount() {
        return mobCount;
    }
}
