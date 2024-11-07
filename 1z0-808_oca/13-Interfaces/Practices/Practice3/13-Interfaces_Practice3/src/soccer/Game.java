/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soccer;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 *
 * @author ADMIN
 */
public class Game {
    private Team homeTeam;
    private Team awayTeam;
    private LocalDateTime theDateTime;
    private GameEvent[] gameEvents;
    
    public Game(Team homeTeam, Team awayTeam, LocalDateTime theDateTime) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.theDateTime = theDateTime;
    }
    
    public void playGame() {
        ArrayList<GameEvent> eventList = new ArrayList<>();
        GameEvent currEvent;
        for (int i = 1; i <= 90; i++) {
            if (Math.random() > 0.8) {
                currEvent = Math.random() > 0.6 ? new Goal() : new Possession();
                currEvent.setTheTeam(Math.random() > 0.5 ? homeTeam : awayTeam);
                currEvent.setThePlayer(currEvent.getTheTeam().getPlayerArray()[(int)(Math.random() * currEvent.getTheTeam().getPlayerArray().length)]);
                currEvent.setTheTime(i);
                eventList.add(currEvent);
            }
        }
        this.gameEvents = new GameEvent[eventList.size()];
        eventList.toArray(gameEvents);
    }
    
    public String getDescription() {
        int homeTeamGoals = 0;
        int awayTeamGoals = 0;
        StringBuilder returnString = new StringBuilder();
        returnString.append(homeTeam.getTeamName() + " vs. " + awayTeam.getTeamName() + "\n" +
                "Date " + this.getTheDateTime().format(DateTimeFormatter.ISO_LOCAL_DATE) + "\n");
        for (GameEvent currEvent : this.getEvents()) {
            if (currEvent instanceof Goal) {
                if (currEvent.getTheTeam() == homeTeam) {
                    homeTeamGoals++;
                    homeTeam.incGoalsTotal(1);
                } else {
                    awayTeamGoals++;
                    awayTeam.incGoalsTotal(1);
                }
                currEvent.getThePlayer().incGoalsScored();
            }
            returnString.append(currEvent + " after " + 
                    currEvent.getTheTime() + " mins by " +
                    currEvent.getThePlayer().getPlayerName() + " of " +
                    currEvent.getTheTeam().getTeamName() + "\n");
        }
        if (homeTeamGoals == awayTeamGoals) {
            returnString.append("It's a draw");
            homeTeam.incPointsTotal(1);
            awayTeam.incPointsTotal(1);
        } else if (homeTeamGoals > awayTeamGoals) {
            returnString.append(homeTeam.getTeamName() + " win");
            homeTeam.incPointsTotal(3);
        } else {
            returnString.append(awayTeam.getTeamName() + " win");
            awayTeam.incPointsTotal(3);
        }
        returnString.append(" (" + homeTeamGoals + " - " + awayTeamGoals + ")"  + "\n");
        return returnString.toString();
    }

    /**
     * @return the homeTeam
     */
    public Team getHomeTeam() {
        return homeTeam;
    }

    /**
     * @param homeTeam the homeTeam to set
     */
    public void setHomeTeam(Team homeTeam) {
        this.homeTeam = homeTeam;
    }

    /**
     * @return the awayTeam
     */
    public Team getAwayTeam() {
        return awayTeam;
    }

    /**
     * @param awayTeam the awayTeam to set
     */
    public void setAwayTeam(Team awayTeam) {
        this.awayTeam = awayTeam;
    }

    /**
     * @return the gameEvents
     */
    public GameEvent[] getEvents() {
        return gameEvents;
    }

    /**
     * @param gameEvents the gameEvents to set
     */
    public void setEvents(GameEvent[] gameEvents) {
        this.gameEvents = gameEvents;
    }

    /**
     * @return the theDateTime
     */
    public LocalDateTime getTheDateTime() {
        return theDateTime;
    }

    /**
     * @param theDateTime the theDateTime to set
     */
    public void setTheDateTime(LocalDateTime theDateTime) {
        this.theDateTime = theDateTime;
    }
}
