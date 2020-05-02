package RoomGeneration;

import Abstracts.GroundObject;
import Abstracts.StandardCollidableObject;
import Objects.BaseGround;
import Objects.Door;
import Utils.Point;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class EnviromentGenerator {
    private ArrayList<StandardCollidableObject>roomLayout= new ArrayList<>();
    private Point[] spawnLocations= new Point[4];
    private int inDoor=-1;
    public ArrayList<StandardCollidableObject> genGround(String layoutName,int[] doors){
        setRoomLayout(layoutName, doors);
        spawnLocations=findSpawnlocatins(layoutName);
        return roomLayout;
    }

    public Point[] getSpawnLocations() {
        return spawnLocations;
    }

    private void setRoomLayout(String layoutname, int[] doors){
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
                    BaseGround b=null;
                    if(doors[3]==1) {
                        b = new Door("Door01.png");
                        ((Door)b).setDoorNum(3);
                        b.setName("Door");
                    }else {
                        b = new BaseGround("DoorFacade02.png");
                        b.setName("Wall");
                    }
                    if(inDoor==1){
                        ((Door)b).Unlock();
                    }
                    b.setBoundingbox("\\Ground\\Door-Points01.png");
                    b.setloc((i * 32), (j * 32));
                    roomLayout.add(b);
                }else if (clr == -7297874) {
                    BaseGround b;
                    if(doors[0]==1) {
                        b = new Door("Door02.png");
                        ((Door)b).setDoorNum(0);
                        b.setName("Door");
                    }else {
                        b = new BaseGround("DoorFacade01.png");
                        b.setName("Wall");
                    }
                    if(inDoor==2){
                        ((Door)b).Unlock();
                    }

                    b.setBoundingbox("\\Ground\\Door-Points02.png");
                    j--;
                    b.setloc((i * 32), (j * 32));
                    roomLayout.add(b);
                }else if (clr == -8875876) {
                    BaseGround b;
                    if(doors[1]==1) {
                        b = new Door("Door03.png");
                        ((Door)b).setDoorNum(1);
                        b.setName("Door");
                    }else {
                        b = new BaseGround("DoorFacade02.png");
                        b.setName("Wall");
                    }
                    if(inDoor==3){
                        ((Door)b).Unlock();
                    }
                    b.setBoundingbox("\\Ground\\Door-Points01.png");
                    b.setloc((i * 32), (j * 32));
                    roomLayout.add(b);
                }else if (clr == -10453621) {
                    BaseGround b;
                    if(doors[2]==1) {
                        b = new Door("Door04.png");
                        ((Door)b).setDoorNum(2);
                        b.setName("Door");
                    }else {
                        b = new BaseGround("DoorFacade01.png");
                        b.setName("Wall");
                    }
                    if(inDoor==0){
                        ((Door)b).Unlock();
                    }
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

    public Point[] findSpawnlocatins(String layoutname){
        Point[] spawns = new Point[4];
        BufferedImage img=null;
        try {
            img = ImageIO.read(new File(".\\Assets\\Ground\\"+layoutname+"-Spawns.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < img.getWidth(); i++) {
            for (int j = img.getHeight() - 1; j >= 0; j--) {
                int clr = img.getRGB(i, j);
                if (clr == -9614271){
                    spawns[0]=new Point(i*32,j*32);
                }
                if (clr == -10665929){
                    spawns[1]=new Point(i*32,j*32);
                }
                if (clr == -11652050){
                    spawns[2]=new Point(i*32,j*32);
                }
                if (clr == -12703965){
                    spawns[3]=new Point(i*32,j*32);
                }
            }
        }
        return spawns;
    }

    public void setInDoor(int inDoor) {
        this.inDoor = inDoor;
    }
}
