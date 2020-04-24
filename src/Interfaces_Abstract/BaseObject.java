package Interfaces_Abstract;

import Objects.BoundingBox;
import javax.swing.*;

public interface BaseObject {
    public BoundingBox getBoundingbox();
    public void setTexture(Icon img);
    public void setloc(int x, int y);
    public int getX();
    public int getY();
}
