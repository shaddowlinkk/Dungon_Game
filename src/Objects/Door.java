package Objects;

public class Door extends BaseGround {
    private int doorNum;
    public Door(String filename){
        super(filename);
    }

    public void setDoorNum(int doorNum) {
        this.doorNum = doorNum;
    }

    public int getDoorNum() {
        return doorNum;
    }
}
