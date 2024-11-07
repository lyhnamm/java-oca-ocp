/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soccer;

import utility.GameUtils;

/**
 *
 * @author ADMIN
 */
public class Game {
    public Team homeTeam;
    public Team awayTeam;
    public Goal[] goals;
    
    public void playGame(int maxGoals) {
        GameUtils.addGameGoals(this, maxGoals);
        String desc = this.getDescription();
        System.out.println(desc);
    }
    
    public void playGame() {
        playGame(6);
    }
    
    public String getDescription() {
        StringBuilder returnString = new StringBuilder();
        for (Goal goal : this.goals) { 
            returnString.append("Goal scored after " + 
                    goal.theTime + " mins by " +
                    goal.thePlayer.playerName + " of " +
                    goal.theTeam.teamName + "\n");
        }
        return returnString.toString();
    }
}
