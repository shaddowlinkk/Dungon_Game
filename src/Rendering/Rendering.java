package Rendering;

import Interfaces_Abstract.StandardObject;

import javax.swing.*;
import java.awt.event.KeyListener;
import java.util.ArrayList;
//TODO update this class to use object based rendering with new interfaces
public class Rendering {
    JFrame mainFrame;
    ArrayList<StandardObject> object = new ArrayList<StandardObject>();
    public Rendering(JFrame frame){
        mainFrame=frame;
    }
    public void addObject(StandardObject obj){
        object.add(obj);
    }
    protected void renderObjects(){
        mainFrame.addKeyListener((KeyListener) object.get(0));
        mainFrame.getContentPane().add(object.get(0));
    }
}
