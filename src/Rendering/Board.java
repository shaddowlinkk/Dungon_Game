package Rendering;



import Enums.Items;
import Handlers.*;
import Abstracts.ControlableObject;
import Abstracts.StandardCollidableObject;
import Objects.BaseGround;
import Objects.BaseItem;
import Objects.Player;
import RoomGeneration.EnviromentGenerator;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


public class Board extends JFrame{
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
    public Board(){
/*        BufferedImage i = null;
        try {
            i = ImageIO.read(new File("test.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(i.getRGB(0,0));*/
/*        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(true);*/
        addKeyListener(new KeyEventHandler());
        StaticEntity.add(new BaseItem(Items.Dagger));
        StaticEntity.add(new BaseItem(Items.Claymore));
        MovingEntitys.add(new Player());
        MovingEntitys.get(0).setloc(50,50);
        StaticEntity.get(0).setloc(100,100);
        StaticEntity.get(1).setloc(100,150);

        setSize(622,642);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(null);
        this.getContentPane().setLayout(null);
        rend.setObject((ArrayList) MovingEntitys,StaticEntity,GroundEntity);
       // rend.addToScreen();
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

            if(((Player)MovingEntitys.get(0)).getIndoor()>=0){
                GroundEntity.clear();
                getContentPane().removeAll();
                GroundEntity=roomController.getEndvironment(((Player)MovingEntitys.get(0)).getIndoor());
                ((Player)MovingEntitys.get(0)).setloc(roomController.getSpawn().getX(),roomController.getSpawn().getY());
                ((Player)MovingEntitys.get(0)).resetIndoor();
                rend.addAllToScreen();
                getContentPane().revalidate();
            }
            /*spawning and rendering*/
            if(!mobSpawner.getSpawned()&& !roomController.getCleard()) {
                mobSpawner.spawnMobs();
                getContentPane().removeAll();
                rend.addAllToScreen();
                getContentPane().revalidate();
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
                getContentPane().removeAll();
                rend.addAllToScreen();
                getContentPane().revalidate();
            }
            if(!((Player)MovingEntitys.get(0)).isAlive()){
                MovingEntitys.clear();
                StaticEntity.clear();
                GroundEntity.clear();
                JPanel endScreen = new JPanel();
                getContentPane().removeAll();
                getContentPane().add(endScreen);
                revalidate();
                endScreen.setSize(622,642);
                endScreen.setBackground(Color.black);
                endScreen.setVisible(true);
                repaint();
                time.stop();
            }
        }
    }

    /*
    Key Event hadneler foe key based events
     */

 private class KeyEventHandler implements KeyListener {
        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {
            if(e.getKeyCode()==KeyEvent.VK_F1){
                GroundEntity.clear();
                getContentPane().removeAll();
                GroundEntity=roomController.getEndvironment(0);
                rend.addAllToScreen();
                getContentPane().revalidate();
            }
            if(e.getKeyCode()==KeyEvent.VK_F2){
                GroundEntity.clear();
                GroundEntity=roomController.getEndvironment(2);
                getContentPane().removeAll();
                rend.addAllToScreen();
                getContentPane().revalidate();

            }
        }

        @Override
        public void keyReleased(KeyEvent e) {

        }
    }

}
