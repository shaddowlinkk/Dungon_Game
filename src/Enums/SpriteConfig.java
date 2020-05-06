package Enums;

public enum SpriteConfig {
    Player(32,48),
    Slime(32,32),
    Greenslime(16,32),
    groundpuddle(32,32),
    Dagger(16,11);


    int width,hight;
    SpriteConfig(int width, int hight) {
        this.width=width;
        this.hight=hight;
    }

    public int getWidth() {
        return width;
    }

    public int getHight() {
        return hight;
    }
}
