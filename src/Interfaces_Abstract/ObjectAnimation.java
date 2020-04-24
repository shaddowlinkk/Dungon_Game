package Interfaces_Abstract;

public interface ObjectAnimation {
    public void nextFrame();
    public int getDelay();
    public void setDelay(int dely);
    public int getNumFrame();
    public int getCount();
    public void setCount(int count);
    public void setAnimationLength(int length);
}
