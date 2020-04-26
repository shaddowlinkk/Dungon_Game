package Rendering;



import Handlers.AnimationHandler;
import Handlers.CollisionHandler;
import Handlers.MobSpawningHandler;
import Handlers.MovingObjectHandler;
import Abstracts.ControlableObject;
import Abstracts.StandardCollidableObject;
import Objects.Player;

import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;


public class Board extends JFrame{
    private ArrayList<ControlableObject> MovingEntitys= new ArrayList<>();
    private ArrayList<ControlableObject> collidableEntitys= new ArrayList<>();
    private ArrayList<StandardCollidableObject> StaticEntity = new ArrayList<>();
    private MovingObjectHandler motionController = new MovingObjectHandler();
    private MobSpawningHandler mobSpawner = new MobSpawningHandler(MovingEntitys);
    private AnimationHandler animationController = new AnimationHandler((ArrayList) MovingEntitys);
    private CollisionHandler collisionControler = new CollisionHandler((ArrayList) MovingEntitys);
    private Rendering rend;
    public Board(){
        MovingEntitys.add(new Player());
        motionController.setObjects(MovingEntitys);
        setSize(600,600);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(null);
        this.getContentPane().setLayout(null);
        rend = new Rendering(this);
        rend.setObject((ArrayList) MovingEntitys);
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
            collisionControler.checkCollisions();
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
