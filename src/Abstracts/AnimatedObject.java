package Abstracts;

import Handlers.SpriteHandler;
import Interfaces.ObjectAnimation;

import java.awt.image.BufferedImage;

public abstract class AnimatedObject extends ControlableObject implements ObjectAnimation {
    int delay=6,numFrame=0,animationLength=0,count=0;
    private BufferedImage[] frames;
    private SpriteHandler sp;
    public AnimatedObject(String filename) {
        sp = new SpriteHandler(filename);
        setVisible(true);

    }
    public void nextFrame(){
        if(frames!=null) {
            if (numFrame % animationLength == 0) {
                numFrame = 0;
            }
            if(numFrame<frames.length) {
                setTexture((frames[numFrame]));
                numFrame++;
            }
        }
    }

    @Override
    public int getDelay() {
        return delay;
    }

    @Override
    public void setDelay(int delay) {
        this.delay = delay;
    }

    @Override
    public int getNumFrame() {
        return numFrame;
    }

    @Override
    public int getCount() {
        return count;
    }

    @Override
    public void setCount(int _count) {
        count=_count;
    }

    @Override
    public void setAnimationLength(int animationLength) {
        this.animationLength = animationLength;
    }
    public void setFrameState(int state,int fram){
        count=0;
        numFrame=0;
        animationLength=fram;
        frames=sp.getCutSheet(state,fram);
    }
}
