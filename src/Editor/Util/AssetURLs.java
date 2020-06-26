package Editor.Util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class AssetURLs {
    ArrayList<String> textures = new ArrayList<>();
    int currentID;
    public AssetURLs() {
        try {
            Scanner scan = new Scanner(new File(".\\Config\\Tile.txt"));
            while (scan.hasNext()){
                textures.add(scan.nextLine());
                currentID++;
            }
        }catch (FileNotFoundException e){
            System.out.println("could not load the textures");
        }
    }
    public void addNewGroundAsset(File source){

        EnumModifier Enums = new EnumModifier();
        String name = source.getName();
        File dest = new File(".\\Assets\\Ground\\"+source.getName());
        try {
            List<String> lines = Files.readAllLines(Paths.get(".\\Config\\Tile.txt"));
            lines.add(currentID,source.getName().split("\\.(?=[^\\.]+$)")[0]+":"+".\\Assets\\Ground\\"+source.getName());
            Files.write(Paths.get(".\\Config\\Tile.txt"),lines);
            Files.copy(source.toPath(),dest.toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
        currentID++;
        Enums.writeToTileTypes(source.getName().split("\\.(?=[^\\.]+$)")[0],".\\\\Assets\\\\Ground\\\\"+source.getName(),currentID);
    }


    public ArrayList<String> getTextures() {
        return textures;
    }
}
