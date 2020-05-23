package Rendering;



import Enums.Items;
import Handlers.*;
import Abstracts.ControlableObject;
import Abstracts.StandardCollidableObject;
import Objects.BaseItem;
import Objects.Player;
import RoomGeneration.EnviromentGenerator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;


public class Board extends JFrame{
    int width,height;

    public Board() {
        MainScreen m = new MainScreen();
/*        width=m.getWidth();
        height=m.getHeight();*/
        setSize(622,642);
        EndScreen e = new EndScreen(622,642);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
       add(m);
       //add(e);
       setVisible(true);
    }

}
