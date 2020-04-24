package Rendering;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
//to do find out why images not rendering rightK
public class Rendering {
    JFrame mainFrame;
    ArrayList<JLabel> images = new ArrayList<JLabel>();
    public Rendering(JFrame frame){
        mainFrame=frame;
    }
    public void addImage(String FileName,String type){
        Icon im = null;
        try {
            im = new ImageIcon( ImageIO.read(new File(FileName)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        images.add(new JLabel());
        images.get(images.size()-1).setSize(im.getIconWidth(),im.getIconHeight());
        images.get(images.size()-1).setIcon(im);
        images.get(images.size()-1).setVisible(true);
        images.get(images.size()-1).setName(type);
        //images.get(images.size()-1).setLocation(((images.size()-1)*100),((images.size()-1)*100));
    }
    public void render(){
        for (int i =0; i<images.size();i++) {
            mainFrame.getContentPane().add(images.get(i));
        }
    }
    public void setLocation(int index, int x, int y){
    }

}
