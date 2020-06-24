package Editor.Main;

import Editor.Screens.MainScreen;
import Editor.Util.EnumModifier;
import Editor.Util.MapFile;

import javax.swing.*;

public class Main {
    public static void main(String[] args){
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
