package Editor.Screens.MainScreens;

import Editor.Objects.ButtonListobject;
import Editor.DataTypes.MobData;
import Editor.Screens.ActionScreens.AnimationEditor;
import Editor.Screens.Misc.BlankGameScreen;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MobCreatorScreen extends JPanel {
    private MobData mobData = new MobData();
    private BlankGameScreen viewer = new BlankGameScreen();
    private ButtonListobject actions = new ButtonListobject("Actions");
    private ButtonListobject animationActions = new ButtonListobject("Animations");
    private ButtonListobject collisions = new ButtonListobject("Collisions");
    private JButton createButton = new JButton("Create new mob");
    private AnimationEditor animationEditor;

// todo add in location sliders-- need to import image  -- need animation editor(WIP) -- need bounding box editor --need action editor
    //todo need to work on adding a way to edit thing in the lists
    public MobCreatorScreen(){
        setVisible(true);
        setSize(1025,1000);
        setLayout(null);

        //list button configuration
        viewer.setLocation(40,30);
        viewer.setLayout(null);

        actions.setLocation(680,30);

        animationActions.setLocation(680,280);



        collisions.setLocation(680,530);

        //
        createButton.setSize(100,25);
        createButton.setLocation(30,700);
        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setDialogTitle("Select a file to save to");
                fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("Images","png"));
                fileChooser.setAcceptAllFileFilterUsed(true);
                fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
                int selected=fileChooser.showOpenDialog(MobCreatorScreen.super.getRootPane());
                if(selected== JFileChooser.APPROVE_OPTION) {
                    //creating the button actions
                    animationEditor = new AnimationEditor();
                    animationActions.setAction(animationEditor);


                    animationEditor.setPath(fileChooser.getSelectedFile().getAbsolutePath());
                    int[] spriteDimension = new int[2];
                    spriteDimension[0] =Integer.parseInt(JOptionPane.showInputDialog("Enter Height of sprite"));
                    spriteDimension[1] =Integer.parseInt(JOptionPane.showInputDialog("Enter Width of sprite"));
                    mobData.setSpriteDimensions(spriteDimension);
                    animationEditor.setHeight(spriteDimension[0]);
                    animationEditor.setWidth(spriteDimension[1]);
                }
                }
        });
        //adding comopnents to screen
        add(actions);
        add(collisions);
        add(animationActions);
        add(viewer);
        add(createButton);
    }
}
