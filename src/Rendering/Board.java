package Rendering;



import Handlers.MobSpawningHandler;
import Handlers.MovingObjectHandler;
import Interfaces_Abstract.ControlableObject;
import Interfaces_Abstract.MoveableObject;
import Interfaces_Abstract.StandardObject;
import Objects.Player;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

//todo start to work on geting objects to move
public class Board extends JFrame{
    private ArrayList<ControlableObject> MovingEntity= new ArrayList<>();
    private ArrayList<StandardObject> StaticEntity = new ArrayList<>();
    private MovingObjectHandler motionController = new MovingObjectHandler();
    private MobSpawningHandler mobSpawner = new MobSpawningHandler(MovingEntity);
    private Rendering rend;
    public Board(){
        MovingEntity.add(new Player("test.png"));
        MovingEntity.get(0).setloc(300,300);
        motionController.setObjects(MovingEntity);
        setSize(600,600);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(null);
        this.getContentPane().setLayout(null);
        rend = new Rendering(this);
        rend.setObject((ArrayList)MovingEntity);
        rend.renderObjects();
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
            if(!mobSpawner.getSpawned()) {
                mobSpawner.spawnMobs();
            }
            rend.renderObjects();
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
