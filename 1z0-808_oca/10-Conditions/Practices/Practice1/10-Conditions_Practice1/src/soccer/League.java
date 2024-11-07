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
public class League {
    public static void main(String[] args) {
        League theLeague = new League();
//        When theTeams and theGames was a static-method so I can call direct to static method in the same class
//        Team[] theTeams = createTeam();
//        Game[] theGames = createGame(theTeams);
        Team[] theTeams = theLeague.createTeam();
        Game[] theGames = theLeague.createGame(theTeams);
        
        Team currBestTeam = theTeams[0];
        
        for (Game currGame : theGames) {
            currGame.playGame();
            System.out.println(currGame.getDescription());
        }
        theLeague.showBestTeam(theTeams);
        for (Team team : theTeams) {
            currBestTeam = team.getTotalPoints() > currBestTeam.getTotalPoints() ? team : currBestTeam;
        }
        System.out.println("Winner of the league is: " + currBestTeam.getTeamName());
    }
    
    public Team[] createTeam() {
        Player player1 = new Player("George Eliot");
        Player player2 = new Player("Graham Greene");
        Player player3 = new Player("Geoffrey Chaucer");
        
        Player[] thePlayers1 = {player1, player2, player3};
        
        Team team1 = new Team("The Greens", thePlayers1);
        
        Team team2 = new Team();
        team2.setTeamName("The Reds");
        
        Player[] thePlayers2 = new Player[3];
        team2.setPlayerArray(thePlayers2);
        
        team2.getPlayerArray()[0] = new Player("Robert Service");
        team2.getPlayerArray()[1] = new Player("Robbie Burns");
        team2.getPlayerArray()[2] = new Player("Rafael Sabatini");
        
        Team[] teams = {team1, team2};
        return teams;
    }
    
    public Game[] createGame(Team[] teams) {
        Game theGame = new Game(teams[0], teams[1]);
        Game theGame2 = new Game(teams[1], teams[0]);
        Game theGame3 = new Game(teams[0], teams[1]);
        Game theGame4 = new Game(teams[1], teams[0]);
        Game[] theGames = {theGame, theGame2, theGame3, theGame4};
        return theGames;
    }
    
    public void showBestTeam(Team[] teams) {
        System.out.println("\nTeam Points");
        for (Team team : teams) {
            System.out.println(team.getTeamName() + ": " + team.getTotalPoints());
        }
    }
}
