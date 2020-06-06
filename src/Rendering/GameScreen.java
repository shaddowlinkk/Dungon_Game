package Rendering;

import Abstracts.ControlableObject;
import Abstracts.StandardCollidableObject;
import Enums.Items;
import Handlers.*;
import Inventory.Inventory;
import Objects.BaseItem;
import Objects.Player;
import RoomGeneration.EnviromentGenerator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Arrays;

public class GameScreen extends JComponent {
    public Timer time;
    private Boolean dead=false;
    private boolean invToggle= false;

    private  int score =0;
    private ArrayList<ControlableObject> MovingEntitys= new ArrayList<>();
    private ArrayList<StandardCollidableObject> itemEntity = new ArrayList<>();
    private ArrayList<StandardCollidableObject> staticElement = new ArrayList<>();
    private EnviromentGenerator enviromentController = new EnviromentGenerator();

    private Inventory inventory = new Inventory();

    private RoomHandler roomController = new RoomHandler();
    private ArrayList<StandardCollidableObject> GroundEntity = roomController.getEnvironment();

    private MovingObjectHandler motionController = new MovingObjectHandler((ArrayList) MovingEntitys);
    private MobSpawningHandler mobSpawner = new MobSpawningHandler(MovingEntitys);
    private AnimationHandler animationController = new AnimationHandler((ArrayList) MovingEntitys);
    private CollisionHandler collisionController = new CollisionHandler((ArrayList) MovingEntitys, itemEntity,GroundEntity);
    private ItemSocketingHandler SocketController = new ItemSocketingHandler((ArrayList) MovingEntitys);
    private MobHandler mobController = new MobHandler(this);
    private Rendering rend = new Rendering(this);

    public GameScreen(){
        setFocusable(false);


        Player player = new Player();
        player.setIn(inventory);
        inventory.setloc(5,5);
        inventory.setItemEntity(itemEntity);
        inventory.setMainscreen(this);
        staticElement.add(inventory);
        addKeyListener( new KeyEventHandler());
        itemEntity.add(new BaseItem(Items.Dagger));
        itemEntity.add(new BaseItem(Items.Claymore));
        MovingEntitys.add(player);
        MovingEntitys.get(0).setloc(50,50);
        itemEntity.get(0).setloc(100,100);
        itemEntity.get(1).setloc(100,150);

        setSize(622,642);
        setLayout(null);
        rend.setObject((ArrayList) MovingEntitys, itemEntity,GroundEntity, staticElement);
        animationController.animateObject();
        time = new Timer( 10, new TimerHandler());
        time.start();
    }
    public boolean getDead(){
        return dead;
    }

    public int getScore() {
        return score;
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
            score+= (100*mobController.checkMobDeath((ArrayList) MovingEntitys));
            //collisions need to be last
            collisionController.checkCollisions();
            repaint();

            /*game states*/
            if(mobController.getMobCount()==0 && !roomController.getCleard()){
                roomController.setCleard(true);
                mobSpawner.resetSpawned();
                BaseItem item = new BaseItem(Items.Key);
                item.setloc(getHeight()/2,getWidth()/2);
                itemEntity.add(item);
                removeAll();
                rend.addAllToScreen();
                revalidate();
            }
            //Death trigger
            if(!((Player)MovingEntitys.get(0)).isAlive()){
                dead=true;
                MovingEntitys.clear();
                itemEntity.clear();
                GroundEntity.clear();
                removeAll();
                revalidate();
                repaint();
                time.stop();
            }
        }
    }

    private class KeyEventHandler implements KeyListener {
        @Override
        public void keyTyped(KeyEvent en) {

        }

        @Override
        public void keyPressed(KeyEvent en) {
            if (en.getKeyCode() == KeyEvent.VK_F1) {
                if(invToggle){
                    inventory.setVisible(false);
                    invToggle=false;
                }else {
                    inventory.setVisible(true);
                    invToggle=true;
                }
                removeAll();
                rend.addAllToScreen();
                revalidate();
            }
            if (en.getKeyCode() == KeyEvent.VK_F2) {
                System.out.println(((Player)MovingEntitys.get(0)).getHeldItem());
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {

        }

    }
    public void rerender(){
        removeAll();
        rend.addAllToScreen();
        revalidate();
    }
}
