/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soccer;

/**
 *
 * @author ADMIN
 */
public class Player {

    /**
     * @return the playerName
     */
    public String getPlayerName() {
        return playerName;
    }

    /**
     * @param playerName the playerName to set
     */
    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }
    private String playerName;
    
    public Player(String playerName) {
        this.playerName = playerName;
    }
    
    private int goalsScored;
    
    public Player() {
        
    }

    /**
     * @return the goalScore
     */
    public int getGoalsScored() {
        return goalsScored;
    }

    /**
     * @param goalScore the goalScore to set
     */
    public void setGoalsScored(int goalsScored) {
        this.goalsScored = goalsScored;
    }
    
    public void incGoalsScored() {
        this.goalsScored++;
    }
}
