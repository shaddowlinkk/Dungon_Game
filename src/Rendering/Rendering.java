package Rendering;

import Abstracts.StandardCollidableObject;
import Objects.Player;

import javax.swing.*;
import java.util.ArrayList;

public class Rendering {
    JFrame mainFrame;
    ArrayList<StandardCollidableObject> object = new ArrayList<StandardCollidableObject>();
    public Rendering(JFrame frame){
        mainFrame=frame;
    }
    public void addObject(StandardCollidableObject obj){
        object.add(obj);
    }
    public void setObject(ArrayList<StandardCollidableObject> object) {
        this.object = object;
    }
    protected void addToScreen(){
        for (int i=mainFrame.getContentPane().getComponentCount(); i <object.size();i++) {
            if (object.get(i).getName().equals("player")) {
                mainFrame.addKeyListener((Player) object.get(i));
            }
            mainFrame.getContentPane().add(object.get(i));
        }
    }
/*    protected void runAnimation(){
        for (int i =0; i<mainFrame.getContentPane().getComponentCount();i++) {
            if (mainFrame.getContentPane().getComponent(i).getName().equals("slime")) {
                ((AnimatedObject)mainFrame.getContentPane().getComponent(i)).nextFrame();
            }
        }
    }*/
}
