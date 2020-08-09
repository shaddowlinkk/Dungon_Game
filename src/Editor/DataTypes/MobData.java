package Editor.DataTypes;

import Core.Utils.BoundingBox;

import java.util.ArrayList;

public class MobData {
    //{<frame set>,<num if frames in set>}
    private int[] idleAnimation = new int[2];

    //{<frame set>,<num if frames in set>}
    private int[] leftAnimation = new int[2];

    //{<frame set>,<num if frames in set>}
    private int[] rightAnimation = new int[2];

    //{<frame set>,<num if frames in set>}
    private int[] upAnimation = new int[2];

    //{<frame set>,<num if frames in set>}
    private int[] downAnimation = new int[2];

    //{<height>,<width>}
    private int[] spriteDimensions = new int[2];

    //int[]->{<x cord>,<y cord>}
    // this is in order
    private ArrayList<int []> boundingBox= new ArrayList<int []>();

    //int[]->{<type ID>,<collision action to be done >}
    private ArrayList<int []> collisions= new ArrayList<int []>();

    //int[]->{<location ID>,<num of frames>,<action to link to>}
    private ArrayList<int []> animationActions= new ArrayList<int []>();

    //int[]->{<action ID>,<action type>,<projectile(opt)>}
    private ArrayList<int []> actions= new ArrayList<int []>();

    public void setActions(ArrayList<int[]> actions) {
        this.actions = actions;
    }

    public void setAnimationActions(ArrayList<int[]> animationActions) {
        this.animationActions = animationActions;
    }

    public void setBoundingBox(ArrayList<int[]> boundingBox) {
        this.boundingBox = boundingBox;
    }

    public void setCollisions(ArrayList<int[]> collisions) {
        this.collisions = collisions;
    }

    public void setDownAnimation(int[] downAnimation) {
        this.downAnimation = downAnimation;
    }

    public void setIdleAnimation(int[] idleAnimation) {
        this.idleAnimation = idleAnimation;
    }

    public void setLeftAnimation(int[] leftAnimation) {
        this.leftAnimation = leftAnimation;
    }

    public void setRightAnimation(int[] rightAnimation) {
        this.rightAnimation = rightAnimation;
    }

    public void setSpriteDimensions(int[] spriteDimensions) {
        this.spriteDimensions = spriteDimensions;
    }

    public void setUpAnimation(int[] upAnimation) {
        this.upAnimation = upAnimation;
    }

    public ArrayList<int[]> getActions() {
        return actions;
    }

    public ArrayList<int[]> getAnimationOfActions() {
        return animationActions;
    }

    public ArrayList<int[]> getBoundingBox() {
        return boundingBox;
    }

    public ArrayList<int[]> getCollisions() {
        return collisions;
    }

    public int[] getDownAnimation() {
        return downAnimation;
    }

    public int[] getIdleAnimation() {
        return idleAnimation;
    }

    public int[] getLeftAnimation() {
        return leftAnimation;
    }

    public int[] getRightAnimation() {
        return rightAnimation;
    }

    public int[] getSpritesDimensions() {
        return spriteDimensions;
    }

    public int[] getUpAnimation() {
        return upAnimation;
    }

}
