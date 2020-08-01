package Editor.Screens;

import Core.Main.driver;
import Editor.Util.AssetManager;
import Editor.Util.MapFile;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

public class MapEditor extends JPanel {
    private  ObjectScreen objects = new ObjectScreen();
    private  BoardScreen board = new BoardScreen(objects);

    private  JTextArea text = new JTextArea();
    private  MapFile me = new MapFile();

    ArrayList<String> textures =  new AssetManager().getTextures();
    public MapEditor(){
        //setting up the jframe

        setVisible(true);
        setSize(1025,1000);
        setLayout(null);


        //setting up the components
        board.setLocation(50,30);
        board.setLayout(null);
        add(board);
        objects.setLocation(700,26);
        objects.loadTextures(textures);
        add(objects);
        text.setSize(622,200);
        text.setLocation(50,682);
        text.setEditable(false);
        add(text,6,0);
        revalidate();
        repaint();

    }
    public void loadMap(String path){
        me.loadMapFile(path);
        me.LoadMapFromFile(board.getTiles());
        repaint();
    }
    public void openMap(File file){
        AssetManager o =new AssetManager();
        o.addNewGroundAsset(file);
        textures =  new AssetManager().getTextures();
        objects.loadTextures(textures);
/*                this.remove(objects);
                objects=new ObjectScreen();
                objects.setLocation(700,26);
                objects.loadTextures(textures);
                add(objects);*/
        revalidate();
        repaint();
    }
    public void saveMap(File file){
        File save = file;
        String fname = save.getAbsolutePath();
        if(!fname.endsWith(".map") ) {
            save = new File(fname + ".map");
        }
        me.loadMapFile(save.getAbsolutePath());
        me.saveMap(board.getTiles());
    }
    public void getSpawns(){
        text.append(Arrays.toString(me.getItemSpawnLocation().toArray()));
    }
}
