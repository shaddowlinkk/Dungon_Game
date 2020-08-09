package Editor.Screens.MainScreens;

import Editor.Screens.Misc.TestGameBoard;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;

public class MainScreen extends JFrame {
    private MapEditor Map;
    private MobCreatorScreen mob;
    private JMenuBar menuBar= new JMenuBar();
    private JFileChooser fileChooser = new JFileChooser();
    private JMenuItem saveMap= new JMenuItem("Save Map");
    private JMenuItem loadMap= new JMenuItem("Load Map");
    private  JMenuItem loadtexture= new JMenuItem("Load Texture");
    private JMenuItem spawn= new JMenuItem("Extract SpawnPoints");
    private  JMenuItem runGame= new JMenuItem("Run Game");
    private  JMenu file = new JMenu("File");
    private JMenu run = new JMenu("Run");
    public MainScreen(){
        setResizable(false);
        setVisible(true);
        setSize(1025,1050);
        setLayout(null);
         Map =new MapEditor();
         mob= new MobCreatorScreen();
         setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JTabbedPane editors = new JTabbedPane();
        editors.setBounds(0,0,1025,1000);
        editors.add("Map", Map);
        editors.add("Mob Creator",mob);

        add(editors);

        menuBar.add(file);
        file.add(saveMap);
        file.add(loadMap);
        file.add(loadtexture);
        file.add(spawn);
        loadtexture.addActionListener(this::actionPerformed);
        loadMap.addActionListener(this::actionPerformed);
        spawn.addActionListener(this::actionPerformed);
        saveMap.addActionListener(this::actionPerformed);

        //setting up the menu for running
        menuBar.add(run);
        run.add(runGame);
        runGame.addActionListener(this::actionPerformed);
        setJMenuBar(menuBar);
        repaint();
        revalidate();
    }
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==saveMap){
            fileChooser.setDialogTitle("Select a file to save to");
            fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("Dungeon map file","map"));
            fileChooser.setAcceptAllFileFilterUsed(true);
            fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
            int selected=fileChooser.showSaveDialog(this);
            if(selected== JFileChooser.APPROVE_OPTION){
                Map.saveMap(fileChooser.getSelectedFile());
            }

        }
        if(e.getSource()==loadtexture){
            fileChooser.setDialogTitle("Select a file to open");
            fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
            int selected=fileChooser.showOpenDialog(this);
            if(selected== JFileChooser.APPROVE_OPTION){
                Map.openMap(fileChooser.getSelectedFile());
            }
        }
        if(e.getSource()==loadMap){
            fileChooser.setDialogTitle("Select a file to open");
            fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("Dungeon map file","map"));
            fileChooser.setAcceptAllFileFilterUsed(true);
            fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
            int selected=fileChooser.showOpenDialog(this);
            if(selected== JFileChooser.APPROVE_OPTION){
                Map.loadMap(fileChooser.getSelectedFile().getAbsolutePath());
            }

        }
        if(e.getSource()==spawn){
            Map.getSpawns();
        }
        if(e.getSource()==runGame){
            TestGameBoard board = new TestGameBoard();
        }
    }
}
