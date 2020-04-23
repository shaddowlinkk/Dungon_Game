package Rendering;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class PaintImage extends JPanel {
    private static BufferedImage image;
    int x,y;
    public PaintImage( String fileName,int _x, int _y){
        super();
        x=_x;
        y=_y;
        try{
            image= ImageIO.read(new File(fileName));
        }catch (IOException e){

        }
        this.setVisible(true);
        this.setSize(image.getWidth(),image.getHeight());
        image.flush();
    }
    public void paintComponent(Graphics g){
        g.drawImage(image,x,y,this);
        repaint();
    }
    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
}
