package Core.Enums;

public enum SpriteConfig {
    Player(32,48),
    Slime(32,32),
    Dagger(16,11);


    int width,hight;
    SpriteConfig(int i, int i1) {
        width=i;
        hight=i1;
    }

    public int getWidth() {
        return width;
    }

    public int getHight() {
        return hight;
    }
}
