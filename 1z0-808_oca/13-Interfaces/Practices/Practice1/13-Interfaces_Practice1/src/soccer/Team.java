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
public class Team {
    
    public Team(String teamName) {
        this.teamName = teamName;
    }

    public Team(String teamName, Player[] players) {
        this(teamName);
        this.playerArray = players;
    }
    
    public Team() {}
    
    /**
     * @return the teamName
     */
    public String getTeamName() {
        return teamName;
    }

    /**
     * @param teamName the teamName to set
     */
    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    /**
     * @return the playerArray
     */
    public Player[] getPlayerArray() {
        return playerArray;
    }

    /**
     * @param playerArray the playerArray to set
     */
    public void setPlayerArray(Player[] playerArray) {
        this.playerArray = playerArray;
    }
    private String teamName;
    private Player[] playerArray;
    private int totalPoints;
    private int totalGoals;

    /**
     * @return the totalPoints
     */
    public int getTotalPoints() {
        return totalPoints;
    }

    /**
     * @param totalPoints the totalPoints to set
     */
    public void setTotalPoints(int totalPoints) {
        this.totalPoints = totalPoints;
    }
    
    public void incPointsTotal(int cumulativePoints) {
        this.totalPoints += cumulativePoints;
    }

    /**
     * @return the totalGoals
     */
    public int getTotalGoals() {
        return totalGoals;
    }

    /**
     * @param totalGoals the totalGoals to set
     */
    public void setTotalGoals(int totalGoals) {
        this.totalGoals = totalGoals;
    }
    
    public void incGoalsTotal(int scoredGoals) {
        this.totalGoals += scoredGoals;
    }
}
