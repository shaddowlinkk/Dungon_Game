package Core.Utils;

import Editor.Objects.GameTile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

public class MapFile {
    //todo finish
    private RandomAccessFile OUT;
    private RandomAccessFile IN;
    private final int FileHeaderOffset=16;
    private final int MapFileRecordOffset=12;
    private final int MapContentOffset=1444;
    private final int SpawnLocationOffset=12;
    private String mapPath;

    public MapFile( String mapPath){
        this.mapPath=mapPath;
        loadMapFile(mapPath);
    }
    public MapFile(){

    }
    public void loadMapFile(String Path){
        mapPath=Path;
        try {
            IN=new RandomAccessFile(Path,"r");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    public void LoadMapFromFile(){
        int pos=28;
        try {
            IN.seek(28);
            int count=0;
            for (int i =pos;i<1444;i+=4) {
                int in =IN.readInt();

/*                if (in!=0) {
                    tiles.get(count).resetBorder();
                    tiles.get(count).setTexture(in-1);
                    count++;
                }else {
                    tiles.get(count).resetBorder();
                    tiles.get(count).resetTexture();
                    count++;
                }*/
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
