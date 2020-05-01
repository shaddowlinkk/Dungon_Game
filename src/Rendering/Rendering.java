package Rendering;

import Abstracts.StandardCollidableObject;
import Objects.Player;

import javax.swing.*;
import java.util.ArrayList;

public class Rendering {
    JFrame mainFrame;
    ArrayList<StandardCollidableObject> movingObject = new ArrayList<StandardCollidableObject>();
    ArrayList<StandardCollidableObject> staticObject = new ArrayList<StandardCollidableObject>();
    ArrayList<StandardCollidableObject> GroundObject = new ArrayList<StandardCollidableObject>();
    public Rendering(JFrame frame){
        mainFrame=frame;
    }
    public void setObject(ArrayList<StandardCollidableObject> movingObject,ArrayList<StandardCollidableObject> staticObject,ArrayList<StandardCollidableObject> GroundObject) {
        this.movingObject = movingObject;
        this.staticObject =staticObject;
        this.GroundObject= GroundObject;
    }
    protected void addToScreen(){
        for (int i = mainFrame.getContentPane().getComponentCount(); i < movingObject.size(); i++) {
            if (movingObject.get(i).getName().equals("player")) {
                mainFrame.addKeyListener((Player) movingObject.get(i));
            }
            mainFrame.getContentPane().add(movingObject.get(i));
        }
        for (int i = mainFrame.getContentPane().getComponentCount(); i < (movingObject.size()+staticObject.size()); i++) {
            mainFrame.getContentPane().add(staticObject.get(i-movingObject.size()));
        }
        for (int i = mainFrame.getContentPane().getComponentCount(); i < (movingObject.size()+staticObject.size()+GroundObject.size()); i++) {
            StandardCollidableObject c =GroundObject.get(i-(movingObject.size()+staticObject.size()));
           // c.setScale(mainFrame.getWidth(),mainFrame.getHeight());
            mainFrame.getContentPane().add(c);
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
