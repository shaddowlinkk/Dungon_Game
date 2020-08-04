package Editor.Objects;

import Editor.Interface.ListAction;

import javax.swing.*;

public class ButtonListobject extends JOptionPane {
    private ListObject List = new ListObject();
    private AddRemoveButton buttons = new AddRemoveButton(List);
    public ButtonListobject(String name){
        List.setLocation(0,20);
        buttons.setLocation(0,220);
        setSize(300,250);
        setLayout(null);
        setVisible(true);
        setBorder(BorderFactory.createTitledBorder(name));
        add(List);
        add(buttons);
    }
    public void setAction(ListAction act){
        buttons.setAddAction(act);
    }
}
