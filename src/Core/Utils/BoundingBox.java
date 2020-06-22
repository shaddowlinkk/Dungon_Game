package Core.Utils;

import javax.imageio.ImageIO;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class BoundingBox {
    private ArrayList<Point> Polygon = new ArrayList<>();
    int w,h;
    public BoundingBox(String fileName){
        BufferedImage img;
        try {
             img = ImageIO.read(new File(".\\Assets\\"+fileName));
             w=img.getWidth();
             h=img.getHeight();
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

    public void setPolygon(ArrayList<Point> polygon) {
        Polygon = polygon;
    }
    public void rotate(int angle){
        Polygon=setrbox(rotatePointMatrix(convert(Polygon),angle));
    }
    private java.awt.Point[] rotatePointMatrix(java.awt.Point[] origPoints, double angle){
        java.awt.Point[] out= origPoints;
        AffineTransform.getRotateInstance
                (Math.toRadians(angle), w/2-1, h/2-1)
                .transform(origPoints,0,out,0,Polygon.size());
        return out;
    }
    private ArrayList<Point> setrbox(java.awt.Point[] ps) {
        ArrayList<Point> newbox= new ArrayList<>();
        for (java.awt.Point p:ps){
            newbox.add(new Point(p.x,p.y));
        }
        return newbox;
    }
    private java.awt.Point[] convert(ArrayList<Point> ps) {
        java.awt.Point[] out = new java.awt.Point[ps.size()];
        for(int i=0;i<ps.size();i++){
            out[i]=new java.awt.Point(ps.get(i).getX(),ps.get(i).getY());
        }
        return out;
    }

}
