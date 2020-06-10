package Rendering;

import javax.swing.*;

public class Board extends JFrame{
    int width,height;

    public Board() {
        int i=1;
        GameScreen m = new GameScreen();
/*        width=m.getWidth();
        height=m.getHeight();*/
        setSize(622,642);
        EndScreen e = new EndScreen(622,642);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
       add(m);
       m.setFocusable(true);
       m.setVisible(true);
       setVisible(true);
       while (true){
           try {
               Thread.sleep(0,1);
           } catch (InterruptedException interruptedException) {
               interruptedException.printStackTrace();
           }
           if(m!=null&&m.getDead()){
               add(e);
               m.setVisible(false);
               e.setScore(m.getScore());
               remove(m);
               e.setVisible(true);
               repaint();
               m=null;
           }
           if(e!=null&&e.isOutState()){
               if (e.isRespawnState()){
                   m=new GameScreen();
                   e.setVisible(false);
                   remove(e);
                   add(m);
                   m.setFocusable(true);
                   m.requestFocusInWindow();
                   m.setVisible(true);
                   repaint();
                   e.reset();
               }else {
                   e.setVisible(false);
                   remove(e);
                   e.reset();
               }
           }
       }
    }

}
