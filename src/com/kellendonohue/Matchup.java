package com.kellendonohue;

import java.util.Objects;

public class Matchup {
    private final Player homePlayer;
    private final Player awayPlayer;

    public Matchup(Player homePlayer, Player awayPlayer) {
        this.homePlayer = homePlayer;
        this.awayPlayer = awayPlayer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Matchup matchup = (Matchup) o;
        return Objects.equals(homePlayer, matchup.homePlayer) &&
                Objects.equals(awayPlayer, matchup.awayPlayer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(homePlayer, awayPlayer);
    }

    public void executeMatchup() {
        double homeScore = homePlayer.executeGame();
        double awayScore = awayPlayer.executeGame();
        boolean homeWon = homeScore > awayScore;
        //printWeekResult(homeScore, awayScore, homeWon);
        homePlayer.recordResult(homeWon, homeScore);
        awayPlayer.recordResult(!homeWon, awayScore);
    }

    private void printWeekResult(double homeScore, double awayScore, boolean homeWon) {
        String winnerName = homeWon ? homePlayer.name : awayPlayer.name;
        String loserName = homeWon ? awayPlayer.name : homePlayer.name;
        double winnerScore = Math.max(homeScore, awayScore);
        double loserScore = Math.min(homeScore, awayScore);
        System.out.println(String.format("%s beats %s - (%f - %f)", winnerName, loserName, winnerScore, loserScore));
    }
}
