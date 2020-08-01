package Editor.Main;

import Editor.Screens.MainScreen;
import Editor.Screens.MapEditor;

import javax.swing.*;

public class Driver {
    public Driver(){
        try {
            UIManager.setLookAndFeel( UIManager.getSystemLookAndFeelClassName() );
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        MainScreen m = new MainScreen();

    }
}
