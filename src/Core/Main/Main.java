package Core.Main;

public class Main {
    public static void main(String[] args){
        if(args.length==0||!args[0].equals("-E")) {
            driver d = new driver();
            d.run();
        }else {
            Editor.Main.Driver editor = new Editor.Main.Driver();
        }

        //System.out.println(active[0].getState());
    }
}
