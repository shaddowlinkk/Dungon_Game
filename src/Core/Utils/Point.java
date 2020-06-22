package Core.Utils;

public class Point {
    private int x,y;
    public Point(int _x,int _y){
        x=_x;
        y=_y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    public java.awt.Point getAwt(){
        return new java.awt.Point(x,y);
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
