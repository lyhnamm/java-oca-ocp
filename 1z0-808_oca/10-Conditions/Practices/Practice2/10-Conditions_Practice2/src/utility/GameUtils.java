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
    public static void addGameGoals(Game game, int maxGoals) {
//        Number of Goals
        int numberOfGoals = (int)(Math.random() * (maxGoals + 1));        
        Goal[] theGoals = new Goal[numberOfGoals];

//        Get Teams
        Team homeTeam = game.getHomeTeam();
        Team awayTeam = game.getAwayTeam();
        Team[] gameTeams = {homeTeam, awayTeam};

//        Get Players
        Player[] homeTeamPlayers = homeTeam.getPlayerArray();
        Player[] awayTeamPlayers = awayTeam.getPlayerArray();
        
//        Random generator
        Random generator = new Random();
        
//        Add goals
        for (int i = 0; i < numberOfGoals; i++) {
            Goal goal = new Goal();
            goal.setTheTime((int)(Math.random() * 90) + 1);
            int genTeamIndex = generator.nextInt(2);
            goal.setTheTeam(gameTeams[genTeamIndex]);
            int genPlayerIndex = generator.nextInt(homeTeamPlayers.length);
            if (genTeamIndex == 0) {
                goal.setThePlayer(homeTeamPlayers[genPlayerIndex]);
            } else {
                goal.setThePlayer(awayTeamPlayers[genPlayerIndex]);
            }
            theGoals[i] = goal;
        }
        game.setGoals(theGoals);
    }
}
