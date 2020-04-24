package Interfaces_Abstract;

public interface MoveableObject {
    public void move();
    public Boolean collison(BaseObject obj);
    public int getDX();
    public int getDY();
    public void setDX(int _dx);
    public void setDY(int _dy);
}
