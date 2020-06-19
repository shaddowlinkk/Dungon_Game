package Core.Rendering;

import Core.Abstracts.StandardCollidableObject;
import Core.Objects.Player;

import javax.swing.*;
import java.util.ArrayList;

public class Rendering {
    JComponent mainFrame;
    ArrayList<StandardCollidableObject> movingObject = new ArrayList<StandardCollidableObject>();
    ArrayList<StandardCollidableObject> staticObject = new ArrayList<StandardCollidableObject>();
    ArrayList<StandardCollidableObject> GroundObject = new ArrayList<StandardCollidableObject>();
    ArrayList<StandardCollidableObject> staticElement = new ArrayList<StandardCollidableObject>();
    public Rendering(JComponent frame){
        mainFrame=frame;
    }
    public void setObject(ArrayList<StandardCollidableObject> movingObject,ArrayList<StandardCollidableObject> staticObject,ArrayList<StandardCollidableObject> GroundObject,ArrayList<StandardCollidableObject> staticElement) {
        this.movingObject = movingObject;
        this.staticObject =staticObject;
        this.GroundObject= GroundObject;
        this.staticElement= staticElement;
    }
    protected void addAllToScreen(){
        for (int i = mainFrame.getComponentCount(); i < movingObject.size(); i++) {
            if (movingObject.get(i).getName().equals("player")) {
                mainFrame.addKeyListener((Player) movingObject.get(i));
            }
            mainFrame.add(movingObject.get(i));
        }
        for (int i = mainFrame.getComponentCount(); i < (movingObject.size()+staticObject.size()); i++) {
            mainFrame.add(staticObject.get(i-movingObject.size()));
        }
        for (int i = mainFrame.getComponentCount(); i < (movingObject.size()+staticObject.size()+GroundObject.size()); i++) {
            StandardCollidableObject c =GroundObject.get(i-(movingObject.size()+staticObject.size()));
            mainFrame.add(c);
        }
        for (int i = mainFrame.getComponentCount(); i < (movingObject.size()+staticObject.size()+GroundObject.size()+staticElement.size()); i++) {
            try {
                StandardCollidableObject c = staticElement.get(i - (movingObject.size() + staticObject.size() + GroundObject.size()));
                mainFrame.add(c,3,0);
            }catch (IndexOutOfBoundsException e){
                //todo findout why this is happening
            }

        }
    }

    protected void setGroundObject(ArrayList<StandardCollidableObject> groundObject) {
        GroundObject = groundObject;
    }
/*    protected void runAnimation(){
        for (int i =0; i<mainFrame.getContentPane().getComponentCount();i++) {
            if (mainFrame.getContentPane().getComponent(i).getName().equals("slime")) {
                ((AnimatedObject)mainFrame.getContentPane().getComponent(i)).nextFrame();
            }
        }
    }*/
}
