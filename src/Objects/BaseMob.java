package Objects;

import Abstracts.AnimatedObject;
import Enums.Mobs;

public  class BaseMob extends AnimatedObject {
    Boolean alive= true;
    public BaseMob(Mobs mob) {
        super(mob.name());
        setBoundingbox(mob.name()+"-Points.png");
        super.setFrameState(mob.getStartState(),mob.getNumFrames());
        setName("Mob");
    }

    @Override
    public void collision(String type) {
        if(type.equals("Weapon")){
            alive=false;
        }
    }

    public Boolean isAlive() {
        return alive;
    }
}
