/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soccer;

import java.time.LocalDateTime;
import java.time.Period;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.StringTokenizer;
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
        
        System.out.println(theLeague.getLeagueAnnouncement(theGames));
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
        int daysBetweenGames = 0;
        ArrayList<Game> theGames = new ArrayList<>();
        for (Team homeTeam : teams) {
            for (Team awayTeam : teams) {
                if (homeTeam != awayTeam) {
                    theGames.add(new Game(homeTeam, awayTeam, LocalDateTime.now().plusDays(daysBetweenGames)));
                    daysBetweenGames +=7;
                }
            }
        }
        return (Game[]) theGames.toArray(new Game[1]);
    }
    
    public void showBestTeam(Team[] teams) {
        Arrays.sort(teams);
        System.out.println("\nTeam Points");
        for (Team team : teams) {
            System.out.println(team.getTeamName() + ": " + team.getTotalPoints() + " (" + team.getTotalGoals() + " goals)");
        }
        System.out.println("Winner of the League is: " + teams[0].getTeamName());
    }
    
    public String getLeagueAnnouncement(Game[] theGames) {
        Period thePeriod = Period.between(theGames[0].getTheDateTime().toLocalDate(), theGames[theGames.length - 1].getTheDateTime().toLocalDate());
        return "The League is scheduled to run for " + thePeriod.getMonths() + " month(s) and " + thePeriod.getDays() + " day(s)";
    }
}
