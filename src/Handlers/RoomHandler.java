package Handlers;

import RoomGeneration.EnviromentGenerator;
import RoomGeneration.Room;
import Utils.Point;

import java.util.ArrayList;

public class RoomHandler {
    private Room room = new Room();
    private Point spawn;
    int[] doors;
    EnviromentGenerator enGen = new EnviromentGenerator();
    public RoomHandler(){
        doors=room.getDoor();
    }
    public ArrayList getEnvironment(){
        return enGen.genGround("lay01",doors);
    }
    public ArrayList getEndvironment(int inddor){
        room=room.enterRoom(inddor);
        doors=room.getDoor();
        spawn=enGen.getSpawnLocations()[room.getDoorCon()[inddor]];
        return enGen.genGround("lay01",doors);
    }

    public Point getSpawn() {
        return spawn;
    }
}
