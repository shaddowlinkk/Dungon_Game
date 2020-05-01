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

    private MovingObjectHandler motionController = new MovingObjectHandler((ArrayList) MovingEntitys);
    private MobSpawningHandler mobSpawner = new MobSpawningHandler(MovingEntitys);
    private AnimationHandler animationController = new AnimationHandler((ArrayList) MovingEntitys);
    private CollisionHandler collisionController = new CollisionHandler((ArrayList) MovingEntitys,StaticEntity);
    private ItemSocketingHandler SocketController = new ItemSocketingHandler((ArrayList) MovingEntitys);
    private EnviromentGenerator enviromentController = new EnviromentGenerator();
    private ArrayList<StandardCollidableObject> GroundEntity = enviromentController.genGround("lay01");
    private MobHandler mobController = new MobHandler(this);

    private Rendering rend = new Rendering(this);
    private Rendering srend = new Rendering(this);
    public Board(){
        BufferedImage i = null;
        try {
            i = ImageIO.read(new File("test.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(i.getRGB(0,0));
        StaticEntity.add(new BaseItem(Items.Dagger));
        StaticEntity.add(new BaseItem(Items.Claymore));
        MovingEntitys.add(new Player());
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
            /*spawning and rendering*/
            if(!((Player)MovingEntitys.get(0)).isAlive()){
                MovingEntitys.clear();
                StaticEntity.clear();
                JPanel endScreen = new JPanel();
                getContentPane().removeAll();
                getContentPane().add(endScreen);
                revalidate();
                endScreen.setSize(608,608);
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
