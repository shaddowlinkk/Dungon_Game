package Rendering;



import Handlers.AnimationHandler;
import Handlers.CollisionHandler;
import Handlers.MobSpawningHandler;
import Handlers.MovingObjectHandler;
import Interfaces_Abstract.ControlableObject;
import Interfaces_Abstract.StandardCollidableObject;
import Objects.Player;
import Utils.Point;

import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;


public class Board extends JFrame{
    private ArrayList<ControlableObject> MovingEntity= new ArrayList<>();
    private ArrayList<StandardCollidableObject> StaticEntity = new ArrayList<>();
    private MovingObjectHandler motionController = new MovingObjectHandler();
    private MobSpawningHandler mobSpawner = new MobSpawningHandler(MovingEntity);
    private AnimationHandler animationController = new AnimationHandler((ArrayList)MovingEntity);
    private Rendering rend;
    public Board(){
        MovingEntity.add(new Player());
        motionController.setObjects(MovingEntity);
        setSize(600,600);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(null);
        this.getContentPane().setLayout(null);
        rend = new Rendering(this);
        rend.setObject((ArrayList)MovingEntity);
        rend.addToScreen();
        Timer time = new Timer( 10,new TimerHandler());
        time.start();
    }



    /*
    Used for tick action control rate
     */
    private class TimerHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            /*spawning and rendering*/
            if(!mobSpawner.getSpawned()) {
                mobSpawner.spawnMobs();
                rend.addToScreen();
            }

            /*Action controllers*/
            motionController.moveObjects();
            animationController.animateObject();
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
