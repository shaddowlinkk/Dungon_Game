package Editor.FileIO;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class MobFile {
    private RandomAccessFile OUT;
    private RandomAccessFile IN;
    private String mapPath;

    public void loadFile(String Path){
        mapPath=Path;
        try {
            OUT=new RandomAccessFile(Path,"rw");
            IN=new RandomAccessFile(Path,"r");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
    public void saveMob(){

    }

    private void setIdleAnimation(int pos,int fameNum){
        try {
            OUT.seek(0);
            OUT.writeInt(pos);
            OUT.seek(4);
            OUT.writeInt(fameNum);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void setLeftAnimation(int pos,int fameNum){
        try {
            OUT.seek(8);
            OUT.writeInt(pos);
            OUT.seek(12);
            OUT.writeInt(fameNum);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void setRightAnimation(int pos,int fameNum){
        try {
            OUT.seek(16);
            OUT.writeInt(pos);
            OUT.seek(20);
            OUT.writeInt(fameNum);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void setUpAnimation(int pos,int fameNum){
        try {
            OUT.seek(24);
            OUT.writeInt(pos);
            OUT.seek(28);
            OUT.writeInt(fameNum);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void setDownAnimation(int pos,int fameNum){
        try {
            OUT.seek(32);
            OUT.writeInt(pos);
            OUT.seek(36);
            OUT.writeInt(fameNum);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void setActionStart(int startNum){
        try {
            OUT.seek(40);
            OUT.writeInt(startNum);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void setActionAnimationStart(int startNum){
        try {
            OUT.seek(44);
            OUT.writeInt(startNum);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void setCollisionStart(int startNum){
        try {
            OUT.seek(48);
            OUT.writeInt(startNum);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void setBoundingBoxStart(int startNum){
        try {
            OUT.seek(52);
            OUT.writeInt(startNum);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void setActionFinish(int startNum){
        try {
            OUT.seek(56);
            OUT.writeInt(startNum);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void setActionAnimationFinish(int startNum){
        try {
            OUT.seek(60);
            OUT.writeInt(startNum);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void setCollisionFinish(int startNum){
        try {
            OUT.seek(64);
            OUT.writeInt(startNum);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void setBoundingBoxFinish(int startNum){
        try {
            OUT.seek(68);
            OUT.writeInt(startNum);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void setSpriteHeight(int startNum){
        try {
            OUT.seek(72);
            OUT.writeInt(startNum);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void setSpriteWidth(int startNum){
        try {
            OUT.seek(76);
            OUT.writeInt(startNum);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
