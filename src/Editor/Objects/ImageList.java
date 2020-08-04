package Editor.Objects;

import javax.swing.*;
import java.awt.image.BufferedImage;

public class ImageList extends JScrollPane{
    private JList list = new JList();
    private DefaultListModel model;
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

}
