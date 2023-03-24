package edu.up.cs301.pig;

import edu.up.cs301.game.GamePlayer;
import edu.up.cs301.game.LocalGame;
import edu.up.cs301.game.actionMsg.GameAction;
import edu.up.cs301.game.infoMsg.GameState;

import android.util.Log;

// dummy comment, to see if commit and push work from srvegdahl account

/**
 * class PigLocalGame controls the play of the game
 *
 * @author Andrew M. Nuxoll, modified by Steven R. Vegdahl
 * @version February 2016
 */
public class PigLocalGame extends LocalGame {

    PigGameState pigGameState;
    /**
     * This ctor creates a new game state
     */
    public PigLocalGame() {
        pigGameState = new PigGameState();
        //TODO  You will implement this constructor
    }

    /**
     * can the player with the given id take an action right now?
     */
    @Override
    protected boolean canMove(int playerIdx) {
        //TODO  You will implement this method
        if(playerIdx == pigGameState.getId()){
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * This method is called when a new action arrives from a player
     *
     * @return true if the action was taken or false if the action was invalid/illegal.
     */
    @Override
    protected boolean makeMove(GameAction action) {
        //TODO  You will implement this method
        if(action instanceof PigHoldAction){
            int currId = pigGameState.getId();
            if(currId == 0) {
                pigGameState.setPlayer0Score(pigGameState.getRunningTotal()+ pigGameState.getPlayer0Score());
                if(players.length == 2) {
                    pigGameState.setId(1);
                }
            }
            if(currId == 1){
                pigGameState.setPlayer1Score(pigGameState.getRunningTotal()+ pigGameState.getPlayer1Score());
                if(players.length == 2) {
                    pigGameState.setId(0);
                }
            }
            pigGameState.setRunningTotal(0);
            return true;
        }
        else if(action instanceof PigRollAction){
            int die = (int)(Math.random()*6)+1;
            pigGameState.setDie(die);
            if(die !=1){
                pigGameState.setRunningTotal(pigGameState.getRunningTotal() + die);
            }
            else{
                pigGameState.setRunningTotal(0);
                if(pigGameState.getId() == 0){
                    if(players.length == 2) {
                        pigGameState.setId(1);
                    }
                }
                else{
                    if(players.length == 2) {
                        pigGameState.setId(0);
                    }
                }
            }
            return true;
        }
        else
        return false;
    }//makeMove

    /**
     * send the updated state to a given player
     */
    @Override
    protected void sendUpdatedStateTo(GamePlayer p) {
        //TODO  You will implement this method
        PigGameState copy = new PigGameState(pigGameState);
        p.sendInfo(copy);
    }//sendUpdatedSate

    /**
     * Check if the game is over
     *
     * @return
     * 		a message that tells who has won the game, or null if the
     * 		game is not over
     */
    @Override
    protected String checkIfGameOver() {
        //TODO  You will implement this method
        if(pigGameState.getPlayer0Score() >= 50){
            return "Player 1 Wins! Score: " + pigGameState.getPlayer0Score();
        }
        if(pigGameState.getPlayer1Score() >=50){
            return "Player 2 Wins! Score: " + pigGameState.getPlayer1Score();
        }
        return null;
    }

}// class PigLocalGame
