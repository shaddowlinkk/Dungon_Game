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
import java.util.Arrays;


public class MapFile {
    private RandomAccessFile OUT;
    private RandomAccessFile IN;
    private final int FileHeaderOffset=16;
    private final int MapFileRecordOffset=12;
    private final int MapContentOffset=1444;
    private final int SpawnLocationOffset=12;
    private String mapPath,recPath;
    private int count=0;


    public MapFile( String mapPath){
        this.mapPath=mapPath;
        loadMapFile(mapPath);
    }
    public MapFile(){

    }
    public void loadMapFile(String Path){
        mapPath=Path;
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
            OUT.writeInt(0x4c00a12f);
            OUT.writeInt(1444);
            OUT.writeInt(2);
            for (int i =0;i<tiles.size();i++) {
                String text=tiles.get(i).getTextureName();
                if(text!=null) {
                    if((TileTypes.valueOf(text).getID())==3){
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
    private void addSpawnlocation(int spawnType, int index){
        try {
            OUT.seek(1472+(count*24));
            OUT.writeInt(0x3fb4cc11);
            OUT.writeInt(12);
            OUT.writeInt(1);
            OUT.writeInt(spawnType);
            OUT.writeInt(index%19);
            OUT.writeInt((index)/19);
            count++;

        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public void LoadMapFromFile(ArrayList<GameTile> tiles){
        int pos=28;
        try {
            IN.seek(28);
            int count=0;
            for (int i =pos;i<1444;i+=4) {
                int in =IN.readInt();
                if (in!=0) {
                    tiles.get(count).resetBorder();
                    tiles.get(count).setTexture(in-1);
                    count++;
                }else {
                    tiles.get(count).resetBorder();
                    tiles.get(count).resetTexture();
                    count++;
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public ArrayList<Point> getItemSpawnLocation(){
        int dataOffset=16,typeOffset=12,RecordOffset=24,position=1472;
        ArrayList<Point> spawnPosition= new ArrayList<>();
        try {
            for (int i =position;i<IN.length();i+=RecordOffset){
                IN.seek(i+typeOffset);
                if(IN.readInt()==3){
                    IN.seek(i+dataOffset);
                    spawnPosition.add(new Point(IN.readInt(),IN.readInt()));
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        return spawnPosition;
    }

}