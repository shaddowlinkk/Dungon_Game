package Enums;

public enum Items {
    Dagger("Weapon"),
    Claymore("Weapon"),
    Key("Key");


    /*Used for geting item value*/
    private final String Type;
    private Items(String Type){
        this.Type=Type;
    }

    public String getType() {
        return Type;
    }
}
