package Objects;

import Interfaces_Abstract.AnimatedObject;
import Interfaces_Abstract.ControlableObject;

public class Slime extends AnimatedObject {
    public Slime(String filename) {
        super(filename);
        super.setFrameState(0,9);
        setName("Mob");
    }
}
