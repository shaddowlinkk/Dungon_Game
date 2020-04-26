package Abstracts;

import Abstracts.AnimatedObject;

public  abstract class BaseMob extends AnimatedObject {
    public BaseMob(String filename) {
        super(filename);
        setBoundingbox(filename.split("-")[0]+"-Points.png");
        setName("Mob");
    }
}
