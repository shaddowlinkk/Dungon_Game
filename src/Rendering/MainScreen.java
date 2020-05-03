package Rendering;

import Abstracts.ControlableObject;
import Abstracts.StandardCollidableObject;
import Enums.Items;
import Handlers.*;
import Objects.BaseItem;
import Objects.Player;
import Rendering.Rendering;
import RoomGeneration.EnviromentGenerator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class MainScreen extends JComponent {
    Timer time;
    private ArrayList<ControlableObject> MovingEntitys= new ArrayList<>();
    private ArrayList<StandardCollidableObject> StaticEntity = new ArrayList<>();
    private EnviromentGenerator enviromentController = new EnviromentGenerator();

    private RoomHandler roomController = new RoomHandler();
    private ArrayList<StandardCollidableObject> GroundEntity = roomController.getEnvironment();

    private MovingObjectHandler motionController = new MovingObjectHandler((ArrayList) MovingEntitys);
    private MobSpawningHandler mobSpawner = new MobSpawningHandler(MovingEntitys);
    private AnimationHandler animationController = new AnimationHandler((ArrayList) MovingEntitys);
    private CollisionHandler collisionController = new CollisionHandler((ArrayList) MovingEntitys,StaticEntity,GroundEntity);
    private ItemSocketingHandler SocketController = new ItemSocketingHandler((ArrayList) MovingEntitys);
    private MobHandler mobController = new MobHandler(this);
    private Rendering rend = new Rendering(this);

    public MainScreen(){
        setFocusable(true);
        addKeyListener( new KeyEventHandler());
        StaticEntity.add(new BaseItem(Items.Dagger));
        StaticEntity.add(new BaseItem(Items.Claymore));
        MovingEntitys.add(new Player());
        MovingEntitys.get(0).setloc(50,50);
        StaticEntity.get(0).setloc(100,100);
        StaticEntity.get(1).setloc(100,150);

        setSize(622,642);
        setVisible(true);

        setLayout(null);
        setLayout(null);
        rend.setObject((ArrayList) MovingEntitys,StaticEntity,GroundEntity);
        // rend.addToScreen();
        time = new Timer( 10, new TimerHandler());
        time.start();

    }


    private class TimerHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            if(((Player)MovingEntitys.get(0)).getIndoor()>=0){
                GroundEntity.clear();
                GroundEntity.addAll(roomController.getEndvironment(((Player)MovingEntitys.get(0)).getIndoor()));
                ((Player)MovingEntitys.get(0)).setloc(roomController.getSpawn().getX(),roomController.getSpawn().getY());
                ((Player)MovingEntitys.get(0)).resetIndoor();
                removeAll();
                rend.addAllToScreen();
                revalidate();
            }
            /*spawning and rendering*/
            if(!mobSpawner.getSpawned()&& !roomController.getCleard()) {
                mobSpawner.spawnMobs();
                removeAll();
                rend.addAllToScreen();
                revalidate();
            }

            /*Action controllers*/
            motionController.moveObjects();
            SocketController.AttachToSocket();
            animationController.animateObject();
            mobController.checkMobDeath((ArrayList) MovingEntitys);
            //collisions need to be last
            collisionController.checkCollisions();
            repaint();

            /*game states*/
            if(mobController.getMobCount()==0 && !roomController.getCleard()){
                System.out.println("test");
                roomController.setCleard(true);
                mobSpawner.resetSpawned();
                BaseItem item = new BaseItem(Items.Key);
                item.setloc(getHeight()/2,getWidth()/2);
                StaticEntity.add(item);
                removeAll();
                rend.addAllToScreen();
                revalidate();
            }
            if(!((Player)MovingEntitys.get(0)).isAlive()){
                MovingEntitys.clear();
                StaticEntity.clear();
                GroundEntity.clear();
                JPanel endScreen = new JPanel();
                removeAll();
                add(endScreen);
                revalidate();
                endScreen.setSize(622,642);
                endScreen.setBackground(Color.black);
                endScreen.setVisible(true);
                repaint();
                time.stop();
            }
        }
    }

    private class KeyEventHandler implements KeyListener {
        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_F1) {
                System.out.println();
            }
            if (e.getKeyCode() == KeyEvent.VK_F2) {

            }
        }

        @Override
        public void keyReleased(KeyEvent e) {

        }
    }
}
