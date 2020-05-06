package Handlers;

import Enums.SpriteConfig;
import Utils.Configeration;

import javax.imageio.ImageIO;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class SpriteHandler {
    String SpriteName;
    public SpriteHandler (String SpriteName){
        this.SpriteName=SpriteName;
    }


    public BufferedImage[] getCutSheet(int State,int Frames){
        Configeration con = new Configeration("Game.config");

        BufferedImage bigImg = null;
        try {
            bigImg = ImageIO.read(new File(".\\Assets\\"+SpriteName+"-Sheet.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
// The above line throws an checked IOException which must be caught.
        final int width = SpriteConfig.valueOf(SpriteName).getWidth();
        final int height =SpriteConfig.valueOf(SpriteName).getHight();
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
    public BufferedImage[] getCutSheetGround(int State,int Frames){
        Configeration con = new Configeration("Game.config");

        BufferedImage bigImg = null;
        try {
            bigImg = ImageIO.read(new File(".\\Assets\\Ground\\"+SpriteName+"-Sheet.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
// The above line throws an checked IOException which must be caught.
        final int width = SpriteConfig.valueOf(SpriteName).getWidth();
        final int height =SpriteConfig.valueOf(SpriteName).getHight();
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
