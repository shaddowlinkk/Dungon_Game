package Editor.Objects;

import Editor.Interface.ListAction;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AddRemoveButton extends JPanel {
    private JButton listAdd = new JButton("Add");
    private JButton listRemove = new JButton("Remove");
    private ListAction act;
    private ListObject list;
    private ArrayList<ListAction> elementInlist = new ArrayList<>();
    public AddRemoveButton(ListObject list){
        this.list=list;
        setLayout(null);
        setVisible(true);
                listRemove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                elementInlist.remove(list.removeElement());
            }
        });

        listAdd.setSize(80,25);
        listRemove.setSize(80,25);
        listAdd.setLocation(0,0);
        listRemove.setLocation(80,0);
        setSize(200,30);
        add(listAdd);
        add(listRemove);

    }
    public void setAddAction(ListAction act){
        this.act=act;
        listAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                act.runAction(list);
                elementInlist.add(act);
            }
        });
    }
}
