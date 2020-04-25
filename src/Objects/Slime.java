package Objects;

import Interfaces_Abstract.AnimatedObject;
import Interfaces_Abstract.BaseMob;

public class Slime extends BaseMob {
    public Slime(String filename) {
        super(filename);
        super.setFrameState(0,9);
    }
}
