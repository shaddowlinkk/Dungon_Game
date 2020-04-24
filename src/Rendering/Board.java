package Rendering;



import Handlers.AnimationHandler;
import Handlers.MobSpawningHandler;
import Handlers.MovingObjectHandler;
import Interfaces_Abstract.ControlableObject;
import Interfaces_Abstract.StandardObject;
import Objects.Player;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;


public class Board extends JFrame{
    private ArrayList<ControlableObject> MovingEntity= new ArrayList<>();
    private ArrayList<StandardObject> StaticEntity = new ArrayList<>();
    private MovingObjectHandler motionController = new MovingObjectHandler();
    private MobSpawningHandler mobSpawner = new MobSpawningHandler(MovingEntity);
    private AnimationHandler animationController = new AnimationHandler(MovingEntity);
    private Rendering rend;
    public Board(){
        MovingEntity.add(new Player());
        MovingEntity.get(0).setTexture("test.png");
        motionController.setObjects(MovingEntity);
        setSize(600,600);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(null);
        this.getContentPane().setLayout(null);
        rend = new Rendering(this);
        rend.setObject((ArrayList)MovingEntity);
        rend.addToScreen();
        animationController.setDelay(6);
        Timer time = new Timer( 10,new TimerHandler());
        time.start();
    }



    /*
    Used for tick action control rate
     */
    private class TimerHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            motionController.moveObjects();
            animationController.animateObject();
            if(!mobSpawner.getSpawned()) {
                mobSpawner.spawnMobs();
                rend.addToScreen();
            }
            repaint();
        }
    }

    /*
    Key Event hadneler foe key based events
     */

/*    private class KeyEventHandler implements KeyListener {
        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {
            if(e.getKeyCode()==KeyEvent.VK_ENTER){
                System.out.println("tesyt");
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {

        }
    }
    public Boolean getClosing(){
        return closing;
    }*/
}
