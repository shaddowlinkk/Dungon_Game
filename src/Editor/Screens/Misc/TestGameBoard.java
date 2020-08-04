package Editor.Screens.Misc;

import Core.Rendering.EndScreen;
import Core.Rendering.GameScreen;
import Core.Rendering.MainMenuScreen;

import javax.swing.*;
import java.awt.*;

public class TestGameBoard extends JFrame{
    public TestGameBoard() {
        requestFocusInWindow();
        requestFocus();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        GameScreen gameScreen =  new GameScreen();
        setSize(622, 642);
        setVisible(true);
        setBackground(Color.cyan);
        add(gameScreen);
        gameScreen.setVisible(true);
    }
}
