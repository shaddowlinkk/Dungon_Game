package Core.Rendering;

import javax.swing.*;

public class Board extends JFrame{
    int width,height;

    public Board() {
        int i=0;
        GameScreen gameScreen =null;
        MainMenuScreen menuscreen = new MainMenuScreen(622,642);
        EndScreen endScreen = new EndScreen(622,642);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(622,642);
        setVisible(true);
        add(menuscreen);
        menuscreen.setVisible(true);

       while (true) {
           try {
               Thread.sleep(0, 1);
           } catch (InterruptedException interruptedException) {
               interruptedException.printStackTrace();
           }
           if (menuscreen.isPlaying()) {
               if(i==0) {
                   gameScreen = new GameScreen();
                   menuscreen.setVisible(false);
                   remove(menuscreen);
                   add(gameScreen);
                   gameScreen.setFocusable(true);
                   gameScreen.requestFocusInWindow();
                   gameScreen.setVisible(true);
                   i++;
               }
               if (gameScreen != null && gameScreen.getDead()) {
                   add(endScreen);
                   gameScreen.setVisible(false);
                   endScreen.requestFocusInWindow();
                   endScreen.setScore(gameScreen.getScore());
                   remove(gameScreen);
                   endScreen.setVisible(true);
                   repaint();
                   gameScreen = null;
               }
               if (endScreen != null && endScreen.isOutState()) {
                   if (endScreen.isRespawnState()) {
                       gameScreen = new GameScreen();
                       endScreen.setVisible(false);
                       remove(endScreen);
                       add(gameScreen);
                       gameScreen.setFocusable(true);
                       gameScreen.requestFocusInWindow();
                       gameScreen.setVisible(true);
                       repaint();
                       endScreen.reset();
                   } else {
                       endScreen.setVisible(false);
                       menuscreen.setVisible(true);
                       menuscreen.reset();
                       add(menuscreen);
                       remove(endScreen);
                       endScreen.reset();
                       i--;
                   }
               }
           }else {
               // non playing code
           }
       }
    }

}
