package Core.Objects;

public class Door extends BaseGround {
    private int doorNum;
    private Boolean locked=true;
    public Door(String filename){
        super(filename);
    }

    public void setDoorNum(int doorNum) {
        this.doorNum = doorNum;
    }

    public int getDoorNum() {
        return doorNum;
    }

    public Boolean getLocked() {
        return locked;
    }
    public void Unlock(){
        locked=false;
    }
}
