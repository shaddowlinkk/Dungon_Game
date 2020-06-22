package Editor.Util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class LoadTextures {
    ArrayList<String> textures = new ArrayList<>();
    public LoadTextures() {
        try {
            Scanner scan = new Scanner(new File("Tile.txt"));
            while (scan.hasNext()){
                textures.add(scan.nextLine());
            }
        }catch (FileNotFoundException e){
            System.out.println("could not load the textures");
        }
    }

    public ArrayList<String> getTextures() {
        return textures;
    }
}
