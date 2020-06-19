package Core.Enums;

public enum Mobs {
    Slime(0,9);


    private int startState,numFrames;
    private Mobs(int startState, int numFrames ){
        this.startState=startState;
        this.numFrames=numFrames;
    }

    public int getNumFrames() {
        return numFrames;
    }

    public int getStartState() {
        return startState;
    }
}
