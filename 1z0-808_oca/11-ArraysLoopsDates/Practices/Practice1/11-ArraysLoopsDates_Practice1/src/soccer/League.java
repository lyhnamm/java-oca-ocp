/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soccer;

import java.util.ArrayList;
import java.util.StringTokenizer;
import utility.GameUtils;
import utility.PlayerDatabase;

/**
 *
 * @author ADMIN
 */
public class League {
    public static void main(String[] args) {
        League theLeague = new League();
//        When theTeams and theGames was a static-method so I can call direct to static method in the same class
//        Team[] theTeams = createTeam();
//        Game[] theGames = createGame(theTeams);
        Team[] theTeams = theLeague.createTeam("Real Madrid,Barcelona,Athletico Madrid", 3);
        Game[] theGames = theLeague.createGame(theTeams);
        
        Team currBestTeam = theTeams[0];
        
        for (Game currGame : theGames) {
            currGame.playGame();
            System.out.println(currGame.getDescription());
        }
        theLeague.showBestTeam(theTeams);
    }
    
    public Team[] createTeam(String teamNames, int teamSize) {
        PlayerDatabase playerDatabase = new PlayerDatabase();
        StringTokenizer teamNameTokens = new StringTokenizer(teamNames, ",");
        Team[] theTeams = new Team[teamNameTokens.countTokens()];
        for (int i = 0; i < theTeams.length; i++) {
            theTeams[i] = new Team(teamNameTokens.nextToken(), playerDatabase.getTeam(teamSize));
        }
        return theTeams;
    }
    
    public Game[] createGame(Team[] teams) {
        ArrayList<Game> theGames = new ArrayList<>();
        for (Team homeTeam : teams) {
            for (Team awayTeam : teams) {
                if (homeTeam != awayTeam) {
                    theGames.add(new Game(homeTeam, awayTeam));
                }
            }
        }
        return (Game[]) theGames.toArray(new Game[1]);
    }
    
    public void showBestTeam(Team[] teams) {
        Team currBestTeam = teams[0];
        System.out.println("\nTeam Points");
        for (Team team : teams) {
            if (team.getTotalPoints() > currBestTeam.getTotalPoints()) {
                currBestTeam = team;
            } else if (team.getTotalPoints() == currBestTeam.getTotalPoints()) {
                if (team.getTotalGoals() > currBestTeam.getTotalGoals()) {
                    currBestTeam = team;
                }
            }
            System.out.println(team.getTeamName() + ": " + team.getTotalPoints() + " (" + team.getTotalGoals() + " goals)");
        }
        System.out.println("Winner of the League is: " + currBestTeam.getTeamName());
    }
}
