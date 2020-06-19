package Core.Handlers;

import Core.Abstracts.AnimatedObject;

import java.util.ArrayList;

public class AnimationHandler {
    /*TODO lag in animation controller in screen rendering
    *   dont know what is causing it*/

    private ArrayList<AnimatedObject> objects = new ArrayList<AnimatedObject>();

    public AnimationHandler (ArrayList<AnimatedObject> entityList){
        objects=entityList;
    }
    public void addObject(AnimatedObject obj){
        objects.add(obj);
    }
    public void setObjects(ArrayList<AnimatedObject> M){
        objects=M;
    }
    public void animateObject(){
            for (AnimatedObject o : objects) {
                if(!(o.getCount()<o.getDelay())) {
                    o.nextFrame();
                    o.setCount(0);
                }
                o.setCount(o.getCount()+1);
            }
    }
}
