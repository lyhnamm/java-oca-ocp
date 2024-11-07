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
public class League {
    public static void main(String[] args) {
        Player player1 = new Player();
        player1.playerName = "George";
        
        Player player2 = new Player();
        player2.playerName = "Graham";
        
        Player player3 = new Player();
        player3.playerName = "Geoffrey";
        
        Player[] thePlayers1 = {player1, player2, player3};
        
        Team team1 = new Team();
        team1.teamName = "The Greens";
        team1.playerArray = thePlayers1;
        
        Team team2 = new Team();
        team2.teamName = "The Reds";
        
        Player[] thePlayers2 = new Player[3];
        team2.playerArray = thePlayers2;
        
        team2.playerArray[0] = new Player();
        team2.playerArray[0].playerName = "Robert";
        team2.playerArray[1] = new Player();
        team2.playerArray[1].playerName = "Richard";
        team2.playerArray[2] = new Player();
        team2.playerArray[2].playerName = "Rafael";
//        player1.playerName = "Robert";
        for (Player player : team1.playerArray) {
            System.out.println(player.playerName);
        }
        
        for (Player player : team2.playerArray) {
            System.out.println(player.playerName);
        }
    }
}
