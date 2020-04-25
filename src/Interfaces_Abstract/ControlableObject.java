package Interfaces_Abstract;

public  abstract  class ControlableObject extends StandardCollidableObject implements  MoveableObject{
    private int x,direction,y,dx,dy,state;
    public ControlableObject(String filename){
        //super(filename);
    }
    public ControlableObject(){
    }
    @Override
    public void move() {
        x=getX();
        y=getY();
        x = x + dx;
        y = y + dy;
        super.setloc(x, y);
    }

    @Override
    public int getDX() {
        return dx;
    }

    @Override
    public int getDY() {
        return dy;
    }

    @Override
    public void setDX(int _dx) {
        dx=_dx;
    }

    @Override
    public void setDY(int _dy) {
        dy=_dy;

    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}
