package RoomGeneration;

import Abstracts.StandardCollidableObject;
import Utils.Point;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by nathan on 1/18/2017.
 */
public class Room {
    // create rooms and then fine orientation by adding 2 to test front add 1 for right subtract 1 for left mod by 4 to make sere nums in range
    // the test should be the same as the the number in that direction


    /* need re write this class to get the direction facting as a seprate call then when entering a room beause of data persistence it is ceaipn all the old deta when going back

     */
    private int[] doorCon = {2, 3, 0, 1};
    private Room[] rooms = new Room[4];
    private int[] door = new int[4];
    private Point spawn;
    private Boolean cleard =false;
    private EnviromentGenerator enGen = new EnviromentGenerator();
    private ArrayList<StandardCollidableObject> evno = new ArrayList<>();

    public void setCleard(Boolean cleard) {
        this.cleard = cleard;
    }

    public Boolean getCleard() {
        return cleard;
    }

    public Room() {
        this.genRoom(4);
    }

    private Room(int _intdor, Room prevRoom) {
        //System.out.println(_intdor);
        door[doorCon[_intdor]] = 1;
        rooms[doorCon[_intdor]] = prevRoom;
    }

    /**
     * generaates the doors to be placed
     * @return the door number
     */

    private int genDoor() {
        Random rand = new Random();
        int door = rand.nextInt(4);
        return door;
    }

    /**
     * gets the doors in the room
     * @return
     */
    public int[] getDoor() {
        return door;
    }

    /**
     * generated the randome room with return door
     */
    private void genRoom() {
        Random rand = new Random();
        int LCV = rand.nextInt(4);
        for (int i = 0; i < LCV; i++) {
            int doorNum = this.genDoor();
            rooms[doorNum] = (door[doorNum] == 1) ?  rooms[doorNum]: new Room(doorNum, this);
            door[doorNum] = 1;
        }


    }

    /**
     * used to create the first room
     * @param LCV the number of doors in that room
     */
    private void genRoom(int LCV) {
        for (int i = 0; i < LCV; i++) {
            rooms[i] = new Room(i, this);
            door[i] = 1;
        }
        genEvno();
    }

    /** used to tell whe strucher what door you are entering
     *
     * @param door door number you are entering
     * @return the new room
     */
    public Room enterRoom(int door) {
        rooms[door].genRoom();
        rooms[door].genEvno(door);
        return rooms[door];
    }

    public int[] getDoorCon() {
        return doorCon;
    }

    public ArrayList<StandardCollidableObject> getEvno() {
        return evno;
    }
    private void genEvno(int door){
        enGen.setInDoor(door);
        if(evno.size()==0){
            evno.addAll(enGen.genGround("lay01",this.door));
        }
        spawn=enGen.findSpawnlocatins("lay01")[doorCon[door]];
    }
    private void genEvno(){
        evno.addAll(enGen.genGround("lay01",this.door));
    }
    public Point getSpawn(){
        return spawn;
    }
}