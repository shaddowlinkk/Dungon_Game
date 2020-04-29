package Rendering;



import Enums.Items;
import Handlers.*;
import Abstracts.ControlableObject;
import Abstracts.StandardCollidableObject;
import Objects.BaseItem;
import Objects.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;


public class Board extends JFrame{
    Timer time;
    private ArrayList<ControlableObject> MovingEntitys= new ArrayList<>();
    private ArrayList<StandardCollidableObject> StaticEntity = new ArrayList<>();
    private MovingObjectHandler motionController = new MovingObjectHandler((ArrayList) MovingEntitys);
    private MobSpawningHandler mobSpawner = new MobSpawningHandler(MovingEntitys);
    private AnimationHandler animationController = new AnimationHandler((ArrayList) MovingEntitys);
    private CollisionHandler collisionController = new CollisionHandler((ArrayList) MovingEntitys,StaticEntity);
    private ItemSocketingHandler SocketController = new ItemSocketingHandler((ArrayList) MovingEntitys);
    private MobHandler mobController = new MobHandler(this);

    private Rendering rend = new Rendering(this);
    private Rendering srend = new Rendering(this);
    public Board(){
        StaticEntity.add(new BaseItem(Items.Dagger));
        MovingEntitys.add(new Player());

        StaticEntity.get(0).setloc(100,100);
        setSize(600,600);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(null);
        this.getContentPane().setLayout(null);
        rend.setObject((ArrayList) MovingEntitys,StaticEntity);
        rend.addToScreen();;
        Component g= this.getContentPane();
        time = new Timer( 10,new TimerHandler());
        time.start();
    }

    protected ArrayList<ControlableObject> getMovingEntitys() {
        return MovingEntitys;
    }

    protected ArrayList<StandardCollidableObject> getStaticEntity() {
        return StaticEntity;
    }

    /*
            Used for tick action control rate
             */
    private class TimerHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            /*spawning and rendering*/
            if(!((Player)MovingEntitys.get(0)).isAlive()){
                MovingEntitys.clear();
                StaticEntity.clear();
                JPanel endScreen = new JPanel();
                getContentPane().removeAll();
                getContentPane().add(endScreen);
                revalidate();
                endScreen.setSize(600,600);
                endScreen.setBackground(Color.black);
                endScreen.setVisible(true);
                repaint();
                time.stop();
            }
            if(!mobSpawner.getSpawned()) {
                mobSpawner.spawnMobs();
                rend.addToScreen();
            }

            /*Action controllers*/
            motionController.moveObjects();
            SocketController.AttachToSocket();
            animationController.animateObject();
            collisionController.checkCollisions();
            mobController.checkMobDeath((ArrayList) MovingEntitys);
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
