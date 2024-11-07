/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utility;

import java.util.*;
import soccer.Player;

/**
 *
 * @author ADMIN
 */
public class PlayerDatabase {
    
    private ArrayList<Player> players = new ArrayList<>();
    
    public PlayerDatabase() {
        String authorList = "George Eliot,Graham Greene,Geoffrey Chaucer,Robert Service,Robbie Burns,Rafael Sabatini,Steven Fords,Joe Cole,Sergio Aguerro,Lionel Messi,Cristiano Ronaldo,Roberto Carlos,Ronaldo De Lima,Sergio Ramos,Kaká,Ronaldinho,Zlatan Ibrahimmovic,David Beckham";
        StringTokenizer authorTokens = new StringTokenizer(authorList, ",");
        while (authorTokens.hasMoreTokens()) {
            players.add(new Player(authorTokens.nextToken()));
        }
    }
    
    public Player[] getTeam(int numberOfPlayers) {
        Player[] teamPlayers = new Player[numberOfPlayers];
        for (int i = 0; i < numberOfPlayers; i++) {
            int playerIndex = (int) (Math.random() * players.size());
            teamPlayers[i] = players.get(playerIndex);
            players.remove(playerIndex);
        }
        return teamPlayers;
    }
    
    public static void main(String[] args) {
        new PlayerDatabase();
    }
    
}
