package edu.up.cs301.pig;

public class PigGameState {
    int id;
    int player0Score;
    int player1Score;
    int runningTotal;
    int die;

    public PigGameState(){
        id =0;
        player0Score =0;
        player1Score=0;
        runningTotal=0;
        die=1;
    }
    public PigGameState(int id, int player0Score, int player1Score, int runningTotal, int die){
        this.id = id;
        this.player1Score = player1Score;
        this.player0Score = player0Score;
        this.runningTotal = runningTotal;
        this.die = die;
    }
    public int getId(){ return id;}
    public int getPlayer0Score() {return player0Score;}
    public int getPlayer1Score(){return player1Score;}
    public int getRunningTotal(){return runningTotal;}
    public int getDie(){return die;}
    public void setId(int id){ this.id = id;}
    public void setPlayer0Score(int score) {player0Score = score;}
    public void setPlayer1Score(int score){player1Score = score;}
    public void setRunningTotal(int total){runningTotal = total;}
    public void setDie(int die){this.die = die;}



}
