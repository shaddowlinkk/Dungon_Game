package RoomGeneration;

import Abstracts.GroundObject;
import Abstracts.StandardCollidableObject;
import Objects.BaseGround;
import Utils.Point;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class EnviromentGenerator {
    private ArrayList<StandardCollidableObject>roomLayout= new ArrayList<>();
    public ArrayList<StandardCollidableObject> genGround(String layoutName){
        setRoomLayout(layoutName);
        return roomLayout;
    }
    private void setRoomLayout(String layoutname){
        BufferedImage img=null;
        try {
            img = ImageIO.read(new File(".\\Assets\\Ground\\"+layoutname+".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < img.getWidth(); i++) {
            for (int j = img.getHeight() - 1; j >= 0; j--) {
                int clr = img.getRGB(i, j);
                if (clr == -16777216) {
                    BaseGround b = new BaseGround("black.png");
                    b.setloc((i * 32), (j * 32));
                    roomLayout.add(b);
                }else if (clr == -10498588) {
                    BaseGround b = new BaseGround("Wall01.png");
                    b.setName("Wall");
                    b.setBoundingbox("\\Ground\\Wall01-Points.png");
                    b.setloc((i * 32), (j * 32));
                    roomLayout.add(b);
                }else if (clr == -616056) {
                    BaseGround b = new BaseGround("GroundEdge01.png");
                    b.setloc((i * 32), (j * 32));
                    roomLayout.add(b);
                }else if (clr == -824224) {
                    BaseGround b = new BaseGround("GroundEdge02.png");
                    b.setloc((i * 32), (j * 32));
                    roomLayout.add(b);
                }else if (clr == -1552832) {
                    BaseGround b = new BaseGround("GroundEdge03.png");
                    b.setloc((i * 32), (j * 32));
                    roomLayout.add(b);
                }else if (clr == -1762269) {
                    BaseGround b = new BaseGround("GroundEdge04.png");
                    b.setloc((i * 32), (j * 32));
                    roomLayout.add(b);
                }else if (clr == -13184) {
                    BaseGround b = new BaseGround("GroundCorner01.png");
                    b.setloc((i * 32), (j * 32));
                    roomLayout.add(b);
                }else if (clr == -18611) {
                    BaseGround b = new BaseGround("GroundCorner02.png");
                    b.setloc((i * 32), (j * 32));
                    roomLayout.add(b);
                }else if (clr == -22746) {
                    BaseGround b = new BaseGround("GroundCorner03.png");
                    b.setloc((i * 32), (j * 32));
                    roomLayout.add(b);
                }else if (clr == -26624) {
                    BaseGround b = new BaseGround("GroundCorner04.png");
                    b.setloc((i * 32), (j * 32));
                    roomLayout.add(b);
                }else if (clr == -5194043) {
                    BaseGround b = new BaseGround("Door01.png");
                    b.setName("Door");
                    b.setBoundingbox("\\Ground\\Door-Points01.png");
                    b.setloc((i * 32), (j * 32));
                    roomLayout.add(b);
                }else if (clr == -7297874) {
                    BaseGround b = new BaseGround("Door02.png");
                    b.setName("Door");
                    b.setBoundingbox("\\Ground\\Door-Points02.png");
                    j--;
                    b.setloc((i * 32), (j * 32));
                    roomLayout.add(b);
                }else if (clr == -8875876) {
                    BaseGround b = new BaseGround("Door03.png");
                    b.setName("Door");
                    b.setBoundingbox("\\Ground\\Door-Points01.png");
                    b.setloc((i * 32), (j * 32));
                    roomLayout.add(b);
                }else if (clr == -10453621) {
                    BaseGround b = new BaseGround("Door04.png");
                    b.setName("Door");
                    b.setBoundingbox("\\Ground\\Door-Points02.png");
                    j--;
                    b.setloc((i * 32), (j * 32));
                    roomLayout.add(b);
                }else {
                    BaseGround g = new BaseGround("Ground02.png");
                    g.setloc((i * 32), (j * 32));
                    roomLayout.add(g);
                }
            }
        }
    }
}
