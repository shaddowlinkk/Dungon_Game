package Editor.Objects;

import javax.swing.*;
import java.util.ArrayList;

public class ListObject extends JScrollPane {
    private JList list = new JList();
    private int hight=200,width=300;
    private DefaultListModel model;
    private ArrayList<int []>data = new ArrayList<>();
    public ListObject(){
        setSize(width,hight);
        setVisible(true);
        list.setVisible(true);
        list.setSize(width,hight);
         model = new DefaultListModel();
        list.setModel(model);
        setViewportView(list);
    }
    public void addElement(String name){
        model.addElement(name);
    }
    public int removeElement(){
        int i = list.getSelectedIndex();
        model.remove(i);
        return i;
    }

    public void addData(int[] data) {
        this.data.add(data);
    }

    public void setHight(int hight) {
        this.hight = hight;
    }

    public void setWidth(int width) {
        this.width = width;
    }
}
