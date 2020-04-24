package Objects;

import Interfaces_Abstract.ControlableObject;

public class Slime extends ControlableObject {
    public Slime(String filename) {
        super(filename);
        setName("Mob");
    }
}
