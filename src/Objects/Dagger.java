package Objects;

import Abstracts.StandardCollidableObject;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.File;
import java.io.IOException;

public class Dagger extends StandardCollidableObject {
    public Dagger(){
        setName("Dagger");
        setBoundingbox("Dagger-Points.png");
        setVisible(true);
        try {
            setTexture(new ImageIcon(ImageIO.read(new File("Dagger.png"))));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
