package Core.Main;

import Editor.Main.Driver;

public class driver {
    // Trello board for this project https://trello.com/b/W1yWWj6V/game-redesing
    public void run(){
        Thread[] active = new Thread[8];
        active[0] = new BoardDriver();
        active[0].start();
        while (active[0].isAlive()) {
        }
    }
}
