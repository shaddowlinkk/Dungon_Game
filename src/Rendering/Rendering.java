package Rendering;

import Abstracts.StandardCollidableObject;
import Objects.Player;

import javax.swing.*;
import java.util.ArrayList;

public class Rendering {
    JFrame mainFrame;
    ArrayList<StandardCollidableObject> movingObject = new ArrayList<StandardCollidableObject>();
    ArrayList<StandardCollidableObject> staticObject = new ArrayList<StandardCollidableObject>();
    public Rendering(JFrame frame){
        mainFrame=frame;
    }
    public void setObject(ArrayList<StandardCollidableObject> movingObject,ArrayList<StandardCollidableObject> staticObject) {
        this.movingObject = movingObject;
        this.staticObject =staticObject;
    }
    protected void addToScreen(){
        for (int i = mainFrame.getContentPane().getComponentCount(); i < movingObject.size(); i++) {
            if (movingObject.get(i).getName().equals("player")) {
                mainFrame.addKeyListener((Player) movingObject.get(i));
                if(((Player) movingObject.get(i)).hasItem()){
                    staticObject.add(((Player) movingObject.get(i)).getHeldItem());
                }
            }
            mainFrame.getContentPane().add(movingObject.get(i));
        }
        for (int i = mainFrame.getContentPane().getComponentCount(); i < (movingObject.size()+staticObject.size()); i++) {
            mainFrame.getContentPane().add(staticObject.get(i-movingObject.size()));
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
