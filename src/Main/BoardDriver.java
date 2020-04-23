package Main;

import Rendering.Board;

public class BoardDriver extends Thread {
    @Override
    public void run(){
        Board b = new Board();
       /* System.out.println(b.getClosing());
        Boolean flag=true;
        while (flag){
            System.out.println(flag);
            flag=!b.getClosing();
        }
        System.out.println(b.getClosing());
        b.dispose();*/
    }
}
