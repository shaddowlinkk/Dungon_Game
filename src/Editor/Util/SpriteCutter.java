package Editor.Util;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class SpriteCutter {
    String filepath;
    int height;
    public SpriteCutter(String filepath,int height){
        this.height=height;
        this.filepath=filepath;
    }
    public BufferedImage[] cutAnimationStates(){
        BufferedImage fullImg =null;
        try {
            fullImg=ImageIO.read(new File(filepath));
        }catch (IOException e){
            e.printStackTrace();
        }
        int width= fullImg.getWidth();
        BufferedImage[] animations = new BufferedImage[(fullImg.getHeight()/height)];
        for (int i =0;i<(fullImg.getHeight()/height);i++){
            animations[i] = fullImg.getSubimage(0,(i*height),fullImg.getWidth(),height);
        }
        return animations;
    }
}
