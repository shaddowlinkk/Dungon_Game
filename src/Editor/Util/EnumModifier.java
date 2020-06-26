package Editor.Util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class EnumModifier {
    public void writeToTileTypes(String name ,String Location,int ID){
        try {
            List<String> lines = Files.readAllLines(Paths.get(".\\src\\Core\\Enums\\TileTypes.java"));
            lines.add(3,"\t"+name+"(\""+Location+"\","+ID+"),");
            Files.write(Paths.get(".\\src\\Core\\Enums\\TileTypes.java"),lines);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
