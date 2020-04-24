package Interfaces_Abstract;

import Handlers.SpriteHandler;

import javax.swing.*;
import java.awt.image.BufferedImage;

public abstract class AnimatedObject extends ControlableObject {
    int delay,numFrame=0;
    private BufferedImage[] frames;
    private SpriteHandler sp = new SpriteHandler();
    public AnimatedObject(String filename) {
        frames=sp.getCutSheet(filename);
        setTexture(new ImageIcon(frames[0]));
        setVisible(true);

    }
    public void nextFrame(){
        if(frames!=null) {
            numFrame++;
            if (numFrame % 9 == 0) {
                numFrame = 0;
            }
            setTexture(new ImageIcon(frames[numFrame]));
        }
    }

}
