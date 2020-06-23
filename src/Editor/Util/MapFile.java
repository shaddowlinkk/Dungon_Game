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
    private RandomAccessFile RECOUT;
    private RandomAccessFile IN;
    private RandomAccessFile RECIN;
    private final int FileHeaderOffset=16;
    private final int MapFileRecordOffset=12;
    private final int MapContentOffset=1444;
    private final int SpawnLocationOffset=12;
    private final int RecRecordOffset=8;
    private String mapPath,recPath;


    public MapFile(String recPath, String mapPath){
        this.mapPath=mapPath;
        this.recPath=recPath;
        loadMapFile(mapPath);
        loadRecFile(recPath);
    }
    private void loadMapFile(String Path){
        try {
            OUT=new RandomAccessFile(Path,"rw");
            IN=new RandomAccessFile(Path,"r");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
    private void loadRecFile(String Path){
        try {
            RECOUT=new RandomAccessFile(Path,"rw");
            RECIN=new RandomAccessFile(Path,"r");

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
            OUT.writeInt(3);
            for (int i =0;i<tiles.size();i++) {
                String text=tiles.get(i).getTextureName();
                if(text!=null) {
                    OUT.writeInt((TileTypes.valueOf(text).getID()));
                }else {
                    OUT.writeInt(0);
                }

            }
            AddFileHeader(1444);
        }catch (IOException e){
            e.printStackTrace();
        }

    }

    private void AddFileHeader(int size){
        try {
            OUT.seek(0);
            OUT.writeInt(0x30fc31);
            OUT.seek(12);
            OUT.writeInt(size);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    /**
     * gets list of item spawn point for this map
     * @return
     */
    public ArrayList<Point> getItemSpawnLocation(){
        int position=16;
        try {
            System.out.println(IN.length());
            RECIN.seek(16);
            while (position < RECIN.length()) {
                RECIN.seek(position+4);
                if(RECIN.readInt()==24){
                    RECIN.seek(position);
                    IN.seek(RECIN.readInt()+SpawnLocationOffset+4);
                    System.out.println(IN.readInt()+"t");
                    System.out.println(IN.readInt()+"s");
                }
                position+=8;
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }

    public int getFileCode(){
        try {
            IN.seek(0);
            return IN.readInt();
        } catch (IOException e) {
            return -1;
        }
    }
}