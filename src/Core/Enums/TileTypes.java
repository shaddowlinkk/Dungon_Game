package Core.Enums;
//DO NOT CHANGE THE LOCATION OF THE STAR OF THE DATA USED IN OTHER PROGRAME
public enum TileTypes {
	GroundCorner02(".\\Assets\\Ground\\GroundCorner02.png",12),
	GroundCorner01(".\\Assets\\Ground\\GroundCorner01.png",11),
	Door04(".\\Assets\\Ground\\Door04.png",10),
	Door03(".\\Assets\\Ground\\Door03.png",9),
	Door02(".\\Assets\\Ground\\Door02.png",8),
    Door01(".\\Assets\\Ground\\Door01.png",7),
	GroundEdge04(".\\Assets\\Ground\\GroundEdge04.png",6),
	GroundEdge03(".\\Assets\\Ground\\GroundEdge03.png",5),
	GroundEdge02(".\\Assets\\Ground\\GroundEdge02.png",4),
	GroundEdge01(".\\Assets\\Ground\\GroundEdge01.png",3),
	Dirt01(".\\Assets\\Ground\\Ground02.png",2),
    Wall01(".\\Assets\\Ground\\Wall01.png",1);
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
