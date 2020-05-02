package Handlers;

import Abstracts.StandardCollidableObject;
import RoomGeneration.EnviromentGenerator;
import RoomGeneration.Room;
import Utils.Point;

import java.util.ArrayList;

public class RoomHandler {
    private Room room = new Room();
    private Point spawn=new Point(0,0);
    private Boolean cleard;

    public Boolean getCleard() {
        return room.getCleard();
    }

    public void setCleard(Boolean cleard) {
        room.setCleard(cleard);
    }

    int[] doors;
    EnviromentGenerator enGen = new EnviromentGenerator();
    public RoomHandler(){
        doors=room.getDoor();
    }
    public ArrayList getEnvironment(){
        return room.getEvno();
       /* return enGen.genGround("lay01",doors);*/
    }
    public ArrayList<StandardCollidableObject> getEndvironment(int inddor){
        room=room.enterRoom(inddor);
        spawn=enGen.findSpawnlocatins("lay01")[room.getDoorCon()[inddor]];
        return room.getEvno();
    }

    public Point getSpawn() {
        return spawn;
    }
}
