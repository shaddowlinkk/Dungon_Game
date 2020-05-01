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
        }else if(type.equals("Wall")){
            super.setDY((super.getDY()*(-1)));
            super.setDX((super.getDX()*(-1)));
            super.move();
            super.setDY((super.getDY()*(-1)));
            super.setDX((super.getDX()*(-1)));
        }
    }

    public Boolean isAlive() {
        return alive;
    }
}
