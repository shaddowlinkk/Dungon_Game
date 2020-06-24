package Editor.Util;

import Core.Enums.TileTypes;
import Editor.Objects.GameTile;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;


public class MapFile {
    private RandomAccessFile OUT;
    private RandomAccessFile IN;
    private final int FileHeaderOffset=16;
    private final int MapFileRecordOffset=12;
    private final int MapContentOffset=1444;
    private final int SpawnLocationOffset=12;
    private String mapPath,recPath;
    private int recNum=1,count=0;


    public MapFile(String recPath, String mapPath){
        this.mapPath=mapPath;
        loadMapFile(mapPath);
    }
    private void loadMapFile(String Path){
        try {
            OUT=new RandomAccessFile(Path,"rw");
            IN=new RandomAccessFile(Path,"r");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    public void saveMap(ArrayList<GameTile> tiles){
        try {
            new FileWriter(mapPath, false).close();
            OUT.seek(16);
            OUT.writeInt(3456);
            OUT.writeInt(1444);
            OUT.writeInt(2);
            for (int i =0;i<tiles.size();i++) {
                String text=tiles.get(i).getTextureName();
                if(text!=null) {
                    if((TileTypes.valueOf(text).getID())==2){
                        addSpawnlocation(3,i);
                        OUT.seek(i*4+FileHeaderOffset+MapFileRecordOffset);
                        OUT.writeInt(0xf0000000);
                    }else {
                        OUT.writeInt((TileTypes.valueOf(text).getID()));
                    }
                }else {
                    OUT.writeInt(0);
                }

            }
            AddFileHeader((int)OUT.length());
        }catch (IOException e){
            e.printStackTrace();
        }

    }

    private void AddFileHeader(int size){
        try {
            OUT.seek(0);
            OUT.writeInt(0x1030fc31);
            OUT.seek(12);
            OUT.writeInt(size);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public void addSpawnlocation(int spawnType, int index){
        try {
            OUT.seek(1472+(count*24));
            OUT.writeInt(recNum);
            OUT.writeInt(24);
            OUT.writeInt(1);
            OUT.writeInt(spawnType);
            System.out.println(index);
            OUT.writeInt(index%19);
            OUT.writeInt((index)/19);
            count++;

        }catch (IOException e){

        }
    }
    public ArrayList<Point> getItemSpawnLocation(){
        try {
                    System.out.println(IN.readInt()+"t");
                    System.out.println(IN.readInt()+"s");
        }catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }

}