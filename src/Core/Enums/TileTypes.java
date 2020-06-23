package Core.Enums;

public enum TileTypes {
	Dirt01(".\\Assets\\Ground\\Ground02.png)",1),
    Wall01(".\\Assets\\Ground\\Wall01.png",2);
    TileTypes(String Location, int ID){
        this.Location=Location;
        this.ID=ID;
    };

    public int getID() {
        return ID;
    }

    private  String Location;
    private int ID;
}
