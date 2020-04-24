package Handlers;

import Interfaces_Abstract.AnimatedObject;

import java.util.ArrayList;

public class AnimationHandler {
    private ArrayList<AnimatedObject> objects = new ArrayList<AnimatedObject>();
    private int delay=0,count=0;

    public AnimationHandler (ArrayList<AnimatedObject> entityList){
        objects=entityList;
    }
    public void addObject(AnimatedObject obj){
        objects.add(obj);
    }
    public void setObjects(ArrayList<AnimatedObject> M){
        objects=M;
    }
    public void setDelay(int delay) {
        this.delay = delay;
    }
    public void animateObject(){
        if(!(count<delay)) {
            for (AnimatedObject o : objects) {
                o.nextFrame();
            }
            count=0;
        }
        count++;
    }
}
