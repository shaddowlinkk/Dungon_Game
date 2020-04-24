package Handlers;

import Utils.Configeration;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class SpriteHandler {
    public SpriteHandler (){
    }


    public BufferedImage[] getCutSheet(String Filename){
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
        final int rows = Integer.parseInt(con.getProp(Filename.split("-")[0]+".r"));;
        final int cols = Integer.parseInt(con.getProp(Filename.split("-")[0]+".c"));;
        BufferedImage[] sprites = new BufferedImage[rows * cols];

        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < cols; j++)
            {
                sprites[(i * cols) + j] = bigImg.getSubimage(
                        j * width,
                        i * height,
                        width,
                        height
                );
            }
        }
        return sprites;
    }
}
