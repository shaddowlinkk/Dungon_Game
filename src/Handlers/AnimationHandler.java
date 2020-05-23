package Handlers;

import Abstracts.AnimatedGround;
import Abstracts.AnimatedObject;
import Abstracts.StandardCollidableObject;

import java.util.ArrayList;

public class AnimationHandler {
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

    //todo make this cheack the ground type
    public void animategroundObject(ArrayList<AnimatedGround> objects){
        for (StandardCollidableObject o : objects) {
            if (o.getName()!=null&&o.getName().equals("groundpuddlebig")) {
                if (!(((AnimatedGround)o).getCount() < ((AnimatedGround)o).getDelay())) {
                    ((AnimatedGround)o).nextFrame();
                    ((AnimatedGround)o).setCount(0);
                }
                ((AnimatedGround)o).setCount(((AnimatedGround)o).getCount() + 1);
            }
        }
    }
}
