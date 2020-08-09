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
    public int getFrameNum(BufferedImage ing , int width){
        int i;
        for ( i=0;i<ing.getWidth()/width;i++){
            Color color2 = new Color(ing.getSubimage((i*width),0,width,height).getRGB(width/2, height/2), true);
            if (color2.getAlpha()==0 &&color2.getRed()==0&&color2.getGreen()==0&&color2.getBlue()==0){
                //System.out.println(i);
                break;
            }
        }
        return i;
    }
}
