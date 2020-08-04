package Editor.Screens.ActionScreens;

import Editor.Interface.ListAction;
import Editor.Objects.ImageList;
import Editor.Util.SpriteCutter;

import javax.swing.*;
import java.awt.image.BufferedImage;

public class AnimationEditor extends JFrame implements ListAction {
    private ImageList animations =new ImageList(500,910);
    private SpriteCutter cutter;
    public AnimationEditor(){
        setSize(1000,900);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(null);
        animations.setLocation(30,30);
        animations.setBorder(BorderFactory.createTitledBorder("animation stated"));
        add(animations);

    }

    @Override
    public void runAction() {
        cutter=new SpriteCutter(".\\Assets\\Player-Sheet.png",48);
        setVisible(true);
        BufferedImage[] stats = cutter.cutAnimationStates();
        for (int i=0;i<stats.length;i++){
            animations.addElement(stats[i]);
        }
    }

    @Override
    public void getObject() {

    }
}
