package Editor.Screens;

import Editor.Objects.ObjectTiles;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class ObjectScreen extends JPanel {
    JPanel mainPanel = new JPanel();
    JScrollPane scrollPane = new JScrollPane(mainPanel);
    private ObjectTiles selected=null;
    private int numSelected=-1;
    ArrayList<String>t;
    public ObjectScreen(){
        mainPanel.setBackground(Color.white);
        mainPanel.setPreferredSize(new Dimension(300,2000));
        mainPanel.setAutoscrolls(true);
        scrollPane.setPreferredSize(new Dimension(300,900));
        add(scrollPane);
        setSize(300,980);
        setVisible(true);
    }
    public void loadTextures(ArrayList<String> list ){
        t=list;
        for(int i = 0;i<list.size();i++) {
            ObjectTiles tile = new ObjectTiles(list.get(i));
            tile.setId(i);
            tile.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if(selected!=null){
                        selected.setBorder(null);
                    }
                    selected=tile;
                    numSelected=tile.getId();
                    tile.setBorder(BorderFactory.createLineBorder(Color.blue));
                }

                @Override
                public void mousePressed(MouseEvent e) {

                }

                @Override
                public void mouseReleased(MouseEvent e) {

                }

                @Override
                public void mouseEntered(MouseEvent e) {

                }

                @Override
                public void mouseExited(MouseEvent e) {

                }
            });
            mainPanel.add(tile);
        }
    }
    public String GetSelectedTexture(){
        if(numSelected!=-1) {
            return t.get(numSelected);
        }else {
            return null;
        }
    }
}
