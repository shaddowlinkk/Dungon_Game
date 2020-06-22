package Editor.Screens;

import Editor.Objects.GameTile;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class BoardScreen extends JPanel {
    private String text;
    public BoardScreen(ObjectScreen obj){
        setVisible(true);
        setBackground(Color.white);
        setSize(622,642);
        for (int x=0;x<19;x++){
            for(int y=0;y<19;y++) {
                GameTile tile =new GameTile(obj);
                tile.setLocation((32*x)+6,(32*y)+15);
                add(tile,6,0);
            }
        }
    }
}
