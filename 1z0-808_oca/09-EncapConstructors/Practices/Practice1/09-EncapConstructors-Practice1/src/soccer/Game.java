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
    private Team homeTeam;
    private Team awayTeam;
    private Goal[] goals;
    
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
        for (Goal goal : this.getGoals()) { 
            returnString.append("Goal scored after " + 
                    goal.getTheTime() + " mins by " +
                    goal.getThePlayer().getPlayerName() + " of " +
                    goal.getTheTeam().getTeamName() + "\n");
        }
        return returnString.toString();
    }

    /**
     * @return the homeTeam
     */
    public Team getHomeTeam() {
        return homeTeam;
    }

    /**
     * @param homeTeam the homeTeam to set
     */
    public void setHomeTeam(Team homeTeam) {
        this.homeTeam = homeTeam;
    }

    /**
     * @return the awayTeam
     */
    public Team getAwayTeam() {
        return awayTeam;
    }

    /**
     * @param awayTeam the awayTeam to set
     */
    public void setAwayTeam(Team awayTeam) {
        this.awayTeam = awayTeam;
    }

    /**
     * @return the goals
     */
    public Goal[] getGoals() {
        return goals;
    }

    /**
     * @param goals the goals to set
     */
    public void setGoals(Goal[] goals) {
        this.goals = goals;
    }
}
