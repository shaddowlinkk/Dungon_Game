package Main;

public class driver {
    // Trello board for this project https://trello.com/b/W1yWWj6V/game-redesing
    public static void main(String[] args){
        Thread[] active = new Thread[8];
        active[0]=new BoardDriver();
        active[0].start();
        while (active[0].isAlive()){
        }
        //System.out.println(active[0].getState());
    }
}
