package Editor.Screens.MainScreens;

import Editor.Objects.ButtonListobject;
import Editor.Objects.MobData;
import Editor.Screens.ActionScreens.AnimationEditor;
import Editor.Screens.Misc.BlankGameScreen;

import javax.swing.*;

public class MobCreatorScreen extends JPanel {
    private MobData mobData = new MobData();
    private BlankGameScreen viewer = new BlankGameScreen();
    private ButtonListobject actions = new ButtonListobject("Actions");
    private ButtonListobject animationActions = new ButtonListobject("Animation Actions");
    private ButtonListobject collisions = new ButtonListobject("Collisions");

// todo add in location sliders-- need to import image  -- need animation editor -- need bounding box editor --need action editor
    public MobCreatorScreen(){
        setVisible(true);
        setSize(1025,1000);
        setLayout(null);

        viewer.setLocation(40,30);
        viewer.setLayout(null);

        //lists
        actions.setLocation(680,30);
        add(actions);

        animationActions.setLocation(680,280);
        animationActions.setAction(new AnimationEditor());
        add(animationActions);

        collisions.setLocation(680,530);
        add(collisions);

        add(viewer);

    }
}
