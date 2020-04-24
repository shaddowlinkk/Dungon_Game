package Handlers;

import Utils.Configeration;

import javax.imageio.ImageIO;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class SpriteHandler {
    String Filename;
    public SpriteHandler (String f){
        Filename=f;
    }


    public BufferedImage[] getCutSheet(int State,int Frames){
        Configeration con = new Configeration("Game.config");

        BufferedImage bigImg = null;
        try {
            bigImg = ImageIO.read(new File(Filename));
        } catch (IOException e) {
            e.printStackTrace();
        }
// The above line throws an checked IOException which must be caught.
        final int width = Integer.parseInt(con.getProp(Filename.split("-")[0]+".w"));
        final int height = Integer.parseInt(con.getProp(Filename.split("-")[0]+".h"));;
        BufferedImage[] sprites = new BufferedImage[Frames];


            for (int j = 0; j < Frames; j++)
            {
                sprites[j] = bigImg.getSubimage(
                        j * width,
                        State * height,
                        width,
                        height
                );
            }
        return sprites;
    }
}
