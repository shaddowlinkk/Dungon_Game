package Rendering;

import Interfaces_Abstract.ControlableObject;
import Interfaces_Abstract.StandardObject;
import Objects.Player;

import javax.swing.*;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class Rendering {
    JFrame mainFrame;
    ArrayList<StandardObject> object = new ArrayList<StandardObject>();
    public Rendering(JFrame frame){
        mainFrame=frame;
    }
    public void addObject(StandardObject obj){
        object.add(obj);
    }
    public void setObject(ArrayList<StandardObject> object) {
        this.object = object;
    }
    protected void addToScreen(){
        for (int i=mainFrame.getContentPane().getComponentCount(); i <object.size();i++) {
            if (object.get(i).getName().equals("player")) {
                System.out.println("found");
                mainFrame.addKeyListener((Player) object.get(i));
            }
            mainFrame.getContentPane().add(object.get(i));
        }
    }
    protected void runAnimation(){
        for (int i =0; i<mainFrame.getContentPane().getComponentCount();i++) {
            if (mainFrame.getContentPane().getComponent(i).getName().equals("slime")) {
                ((ControlableObject)mainFrame.getContentPane().getComponent(i)).nextFrame();
            }
        }
    }
}
