package Abstracts;

import Abstracts.AnimatedObject;

public  abstract class BaseMob extends AnimatedObject {
    Boolean alive= true;
    public BaseMob(String filename) {
        super(filename);
        setBoundingbox(filename.split("-")[0]+"-Points.png");
        setName("Mob");
    }

    @Override
    public void collision(String type) {
        if(type.equals("Dagger")){
            alive=false;
        }
    }

    public Boolean isAlive() {
        return alive;
    }
}
