package com.palantir;

import java.util.Objects;

public class Matchup {
    private Player homePlayer;
    private Player awayPlayer;

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
        homePlayer.recordResult(homeWon, homeScore);
        awayPlayer.recordResult(!homeWon, awayScore);
    }
}
