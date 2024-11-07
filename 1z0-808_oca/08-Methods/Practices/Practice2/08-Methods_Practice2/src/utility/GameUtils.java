/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utility;

import java.util.Random;
import soccer.Game;
import soccer.Goal;
import soccer.Player;
import soccer.Team;

/**
 *
 * @author ADMIN
 */
public class GameUtils {
    public static void addGameGoals(Game game) {
//        Number of Goals
        int numberOfGoals = (int)(Math.random() * 7);        
        Goal[] theGoals = new Goal[numberOfGoals];

//        Get Teams
        Team homeTeam = game.homeTeam;
        Team awayTeam = game.awayTeam;
        Team[] gameTeams = {homeTeam, awayTeam};

//        Get Players
        Player[] homeTeamPlayers = homeTeam.playerArray;
        Player[] awayTeamPlayers = awayTeam.playerArray;
        
//        Random generator
        Random generator = new Random();
        
//        Add goals
        for (int i = 0; i < numberOfGoals; i++) {
            Goal goal = new Goal();
            goal.theTime = (int)(Math.random() * 90) + 1;
            int genTeamIndex = generator.nextInt(2);
            goal.theTeam = gameTeams[genTeamIndex];
            int genPlayerIndex = generator.nextInt(homeTeamPlayers.length);
            if (genTeamIndex == 0) {
                goal.thePlayer = homeTeamPlayers[genPlayerIndex];
            } else {
                goal.thePlayer = awayTeamPlayers[genPlayerIndex];
            }
            theGoals[i] = goal;
        }
        game.goals = theGoals;
    }
}
