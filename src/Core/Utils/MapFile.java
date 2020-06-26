package Core.Utils;

import java.io.FileNotFoundException;
import java.io.RandomAccessFile;

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
}
