package Editor.Objects;

import javax.swing.*;
import java.awt.image.BufferedImage;
import java.util.Arrays;

public class ImageList extends JScrollPane{
    private JList list = new JList();
    private DefaultListModel model;
    private int[] frames;
    public ImageList(int hight,int width){ ;
        setSize(width,hight);
        setVisible(true);
        list.setVisible(true);
        list.setSize(width,hight);
        model = new DefaultListModel();
        list.setModel(model);
        setViewportView(list);
    }
    public void addElement(BufferedImage img){
        model.addElement(new ImageIcon(img));
    }
    public int removeElement(){
        int i = list.getSelectedIndex();
        model.remove(i);
        return i;
    }
    public boolean isSelected(){
        return !list.isSelectionEmpty();
    }
    public int getIndex(){
        return list.getSelectedIndex();
    }
    public void initFrames(int size){
        this.frames = new int[size];
    }
    public void setFrames(int frames, int index) {
        this.frames[index]=frames;
    }

    public int getFrames(int i) {
        return frames[i];
    }
    public void reset(){
        list.clearSelection();
    }

}
