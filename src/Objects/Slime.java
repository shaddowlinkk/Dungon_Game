package Objects;

import Interfaces_Abstract.AnimatedObject;
import Interfaces_Abstract.ControlableObject;

public class Slime extends AnimatedObject {
    public Slime(String filename) {
        super(filename);
        setName("Mob");
    }
}
