package Editor.Screens;

import Editor.Objects.GameTile;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class BoardScreen extends JPanel {
    private String text;
    private ArrayList<GameTile> tiles = new ArrayList<>();
    public BoardScreen(ObjectScreen obj){
        setVisible(true);
        setBackground(Color.white);
        setSize(622,642);
        int count =0;
        for (int y=0;y<19;y++){
            for(int x=0;x<19;x++) {
                GameTile tile =new GameTile(obj,this);
                tile.setPosition(count);
                tiles.add(tile);
                tile.setLocation((32*x)+6,(32*y)+15);
                add(tile,6,0);
                count++;
            }
        }
    }

    public ArrayList<GameTile> getTiles() {
        return tiles;
    }
}
