package Utils;

import Utils.Point;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class BoundingBox {
    private ArrayList<Point> Polygon = new ArrayList<>();
    public BoundingBox(String fileName){
        BufferedImage img;
        try {
             img = ImageIO.read(new File(fileName));
            for (int i =0;i< img.getWidth()/2;i++){
                for (int j = img.getHeight()-1;j>=0;j--){

                    int clr=  img.getRGB(i,j);
                    if(clr!=0) {
                    }
                    //detecting the color-f200ff
                    if(clr==-917249){
                        Polygon.add(new Point(i,j));
                    }
                }
            }
            for (int i =img.getWidth()/2;i< img.getWidth();i++){
                for (int j = 0;j<img.getHeight();j++){

                    int clr=  img.getRGB(i,j);
                    if(clr!=0) {
                    }
                    //detecting the color-f200ff
                    if(clr==-917249){
                        Polygon.add(new Point(i,j));
                    }
                }

            }
            Polygon.add(Polygon.get(0));
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public ArrayList<Point> getPolygon() {
        return Polygon;
    }
}
