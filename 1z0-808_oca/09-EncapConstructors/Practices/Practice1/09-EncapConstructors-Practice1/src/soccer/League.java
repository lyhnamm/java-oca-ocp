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
        Game currGame = theGames[0];
        currGame.playGame();
    }
    
    public Team[] createTeam() {
        Player player1 = new Player();
        player1.setPlayerName("George Eliot");
        
        Player player2 = new Player();
        player2.setPlayerName("Graham Greene");
        
        Player player3 = new Player();
        player3.setPlayerName("Geoffrey Chaucer");
        
        Player[] thePlayers1 = {player1, player2, player3};
        
        Team team1 = new Team();
        team1.setTeamName("The Greens");
        team1.setPlayerArray(thePlayers1);
        
        Team team2 = new Team();
        team2.setTeamName("The Reds");
        
        Player[] thePlayers2 = new Player[3];
        team2.setPlayerArray(thePlayers2);
        
        team2.getPlayerArray()[0] = new Player();
        team2.getPlayerArray()[0].setPlayerName("Robert Service");
        team2.getPlayerArray()[1] = new Player();
        team2.getPlayerArray()[1].setPlayerName("Robbie Burns");
        team2.getPlayerArray()[2] = new Player();
        team2.getPlayerArray()[2].setPlayerName("Rafael Sabatini");
        
        Team[] teams = {team1, team2};
        return teams;
    }
    
    public Game[] createGame(Team[] teams) {
        Game theGame = new Game();
        theGame.setHomeTeam(teams[0]);
        theGame.setAwayTeam(teams[1]);
        
        Game[] games = {theGame};
        return games;
    }
}
