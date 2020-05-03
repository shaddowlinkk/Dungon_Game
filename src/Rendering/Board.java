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

    public Board() {
        MainScreen m = new MainScreen();
       add(m);
       setSize(m.getWidth(),m.getHeight());
       setVisible(true);
    }

}
