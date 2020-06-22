package Core.Interfaces;

import Core.Utils.BoundingBox;
import javax.swing.*;

public interface BaseCollidableObject {
    public BoundingBox getBoundingbox();
    public void setBoundingbox(String fileName);
    public void setTexture(Icon img);
    public void setloc(int x, int y);
    public Boolean hasCollided(Core.Abstracts.StandardCollidableObject obj);
    public void collision(String type);
    public int getX();
    public int getY();
}
