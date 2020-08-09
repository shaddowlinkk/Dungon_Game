package Editor.Screens.ActionScreens;

import Editor.Interface.ListAction;
import Editor.Objects.ImageList;
import Editor.Objects.LabelledInputs;
import Editor.Objects.ListObject;
import Editor.Util.SpriteCutter;
import javafx.stage.FileChooser;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.Arrays;

public class AnimationEditor extends JFrame implements ListAction {
    private ImageList animations =new ImageList(500,910);
    private SpriteCutter cutter;
    private String[] types = {"Idle","right","left","up","down","custom" };
    private JList animationTypes = new JList(types);
    private JButton create = new JButton("Create");
    private int[] out_data = new int[2];
    private static boolean init=false;
    private  ListObject list;
    private String path;
    int height, width;
    public AnimationEditor(){
        setResizable(false);
        setSize(1000,900);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(null);
        animations.setLocation(30,30);
        animations.setBorder(BorderFactory.createTitledBorder("Animation states"));


        animationTypes.setBorder(BorderFactory.createTitledBorder("Animation Type"));
        animationTypes.setSize(100,120);
        animationTypes.setLocation(30,530);

        create.setSize(80,25);
        create.setLocation(1000-100,900-70);
        create.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!animationTypes.isSelectionEmpty()&& animations.isSelected()){
                    if(((String)animationTypes.getSelectedValue()).equalsIgnoreCase("custom")){
                        //todo add custion animation naming
                        System.out.println("test");
                    }else{
                        list.addElement((String) animationTypes.getSelectedValue());
                        out_data[0]=animations.getIndex();
                        out_data[1]=animations.getFrames(out_data[0]);
                        list.addData(out_data);
                        animationTypes.clearSelection();
                        animations.reset();
                    }
                }
            }
        });
        add(create);
        add(animations);
        add(animationTypes);

    }

    @Override
    public void runAction(ListObject list) {
        if(!init) {
            this.list=list;
            cutter = new SpriteCutter(path, height);
            setVisible(true);
            BufferedImage[] stats = cutter.cutAnimationStates();
            animations.initFrames(stats.length+1);
            for (int i = 0; i < stats.length; i++) {
                animations.addElement(stats[i]);
                animations.setFrames(cutter.getFrameNum(stats[i],width),i);
            }
            init=true;
        }else {
            setVisible(true);
        }
    }

    @Override
    public void getObject() {

    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
