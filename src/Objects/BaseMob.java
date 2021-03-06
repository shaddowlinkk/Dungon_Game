package Objects;

import Abstracts.AnimatedObject;
import Abstracts.ControlableObject;
import Enums.Mobs;

public  class BaseMob extends AnimatedObject {
    Boolean alive= true;
    int targetX,targetY;
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
    public void pathTo(ControlableObject object){
        targetX=object.getX();
        targetY=object.getY();
        double d =Math.sqrt(Math.pow((targetX-getX()),2)+Math.pow((targetY-getY()),2));
        if(d<=150) {
            super.setDX((int) Math.signum(((targetX+16) - getX()) * 1.0));
            super.setDY((int) Math.signum(((targetY+18)- getY()) * 1.0));
        }
    }
}
