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
import java.util.Collections;
import utility.PlayerDatabase;
import utility.PlayerDatabaseException;

/**
 *
 * @author ADMIN
 */
public class League {
    public static void main(String[] args) {
        League theLeague = new League();
        try {
            Team[] theTeams = theLeague.createTeam("Real Madrid,Barcelona,Bayern Munich,Manchester City", 11);
            Game[] theGames = theLeague.createGame(theTeams);

            Team currBestTeam = theTeams[0];

            System.out.println(theLeague.getLeagueAnnouncement(theGames));
            for (Game currGame : theGames) {
                currGame.playGame();
                System.out.println(currGame.getDescription());
            }
            theLeague.showBestTeam(theTeams);
            theLeague.showBestPlayer(theTeams);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public Team[] createTeam(String teamNames, int teamSize) throws PlayerDatabaseException {
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
    
    public void showBestPlayer(Team[] theTeams) {
        ArrayList<Player> thePlayers = new ArrayList<>();
        for (Team currTeam : theTeams) {
            thePlayers.addAll(Arrays.asList(currTeam.getPlayerArray()));
        }
        Collections.sort(thePlayers, (p1, p2) -> Double.valueOf(p2.getGoalsScored()).compareTo(Double.valueOf(p1.getGoalsScored())));
        System.out.println("\n\nBest Players");
        for (Player player : thePlayers) {
            System.out.println(player.getPlayerName() + " : " + player.getGoalsScored());
        }
    }
    
    public String getLeagueAnnouncement(Game[] theGames) {
        Period thePeriod = Period.between(theGames[0].getTheDateTime().toLocalDate(), theGames[theGames.length - 1].getTheDateTime().toLocalDate());
        return "The League is scheduled to run for " + thePeriod.getMonths() + " month(s) and " + thePeriod.getDays() + " day(s)";
    }
}
