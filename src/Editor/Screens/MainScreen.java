package Editor.Screens;

import Editor.Util.LoadTextures;
import Editor.Util.MapFile;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class MainScreen extends JFrame {
    ObjectScreen objects = new ObjectScreen();
    BoardScreen board = new BoardScreen(objects);
    JMenuBar menuBar= new JMenuBar();
    JMenuItem saveMap= new JMenuItem("Save Map");
    JMenu file = new JMenu("File");
    JTextArea text = new JTextArea();
    ArrayList<String> textures =  new LoadTextures().getTextures();
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
        add(text);
    }
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==saveMap){
            MapFile me = new MapFile(".\\Saves\\test.rec",".\\Saves\\test.map");
            me.saveMap(board.getTiles());
        }
    }
}
