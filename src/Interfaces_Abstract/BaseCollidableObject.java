package Interfaces_Abstract;

import Objects.BoundingBox;
import javax.swing.*;

public interface BaseCollidableObject {
    public BoundingBox getBoundingbox();
    public void setBoundingbox(String fileName);
    public void setTexture(Icon img);
    public void setloc(int x, int y);
    public int getX();
    public int getY();
}
