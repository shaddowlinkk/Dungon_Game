package Editor.Screens;

import Editor.Util.AssetURLs;
import Editor.Util.MapFile;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

public class MainScreen extends JFrame {
    ObjectScreen objects = new ObjectScreen();
    BoardScreen board = new BoardScreen(objects);
    JMenuBar menuBar= new JMenuBar();
    JFileChooser fileChooser = new JFileChooser();
    JMenuItem saveMap= new JMenuItem("Save Map");
    JMenuItem loadMap= new JMenuItem("Load Map");
    JMenuItem loadtexture= new JMenuItem("Load Texture");
    JMenuItem spawn= new JMenuItem("Extract SpawnPoints");
    JMenu file = new JMenu("File");
    JTextArea text = new JTextArea();
    MapFile me = new MapFile();

    ArrayList<String> textures =  new AssetURLs().getTextures();
    public MainScreen(){
        //setting up the jframe
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        setSize(1025,1000);
        setLayout(null);
        setBackground(Color.gray);


        //setting up the menu
        menuBar.add(file);
        file.add(saveMap);
        file.add(loadMap);
        file.add(loadtexture);
        file.add(spawn);
        loadtexture.addActionListener(this::actionPerformed);
        loadMap.addActionListener(this::actionPerformed);
        spawn.addActionListener(this::actionPerformed);
        saveMap.addActionListener(this::actionPerformed);
        setJMenuBar(menuBar);


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

    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==saveMap){
            fileChooser.setDialogTitle("Select a file to save to");
            fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("Dungeon map file","map"));
            fileChooser.setAcceptAllFileFilterUsed(true);
            fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
            int selected=fileChooser.showSaveDialog(this);
            if(selected== JFileChooser.APPROVE_OPTION){
                File save = fileChooser.getSelectedFile();
                String fname = save.getAbsolutePath();
                if(!fname.endsWith(".map") ) {
                    save = new File(fname + ".map");
                }
                me.loadMapFile(save.getAbsolutePath());
                me.saveMap(board.getTiles());
            }

        }
        if(e.getSource()==loadtexture){
            fileChooser.setDialogTitle("Select a file to open");
            fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
            int selected=fileChooser.showOpenDialog(this);
            if(selected== JFileChooser.APPROVE_OPTION){
                AssetURLs o =new AssetURLs();
                o.addNewGroundAsset(fileChooser.getSelectedFile());
                textures =  new AssetURLs().getTextures();
                objects.loadTextures(textures);
/*                this.remove(objects);
                objects=new ObjectScreen();
                objects.setLocation(700,26);
                objects.loadTextures(textures);
                add(objects);*/
                revalidate();
                repaint();
            }
        }
        if(e.getSource()==loadMap){
            fileChooser.setDialogTitle("Select a file to open");
            fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("Dungeon map file","map"));
            fileChooser.setAcceptAllFileFilterUsed(true);
            fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
            int selected=fileChooser.showOpenDialog(this);
            if(selected== JFileChooser.APPROVE_OPTION){
                me.loadMapFile(fileChooser.getSelectedFile().getAbsolutePath());
                me.LoadMapFromFile(board.getTiles());
                repaint();
            }

        }
        if(e.getSource()==spawn){
            text.append(Arrays.toString(me.getItemSpawnLocation().toArray()));
        }
    }
}
