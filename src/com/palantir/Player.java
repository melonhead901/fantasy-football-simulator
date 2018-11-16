package com.palantir;

import com.google.common.collect.Comparators;

import java.util.Comparator;
import java.util.Objects;
import java.util.Random;

public class Player implements Comparable<Player> {

    private static final double NUMBER_OF_GAMES = 10;
    private static final Random RANDOM = new Random();

    public final String name;
    private Distribution distribution;
    private int numberOfWins;
    private double seasonScore;

    public double executeGame() {
        return distribution.generateScore();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return numberOfWins == player.numberOfWins &&
                Double.compare(player.seasonScore, seasonScore) == 0 &&
                Objects.equals(name, player.name) &&
                Objects.equals(distribution, player.distribution);
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", numberOfWins=" + numberOfWins +
                ", seasonScore=" + seasonScore +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, distribution, numberOfWins, seasonScore);
    }

    public Player(String name, Distribution distribution, int numberOfWins, double seasonScore) {

        this.name = name;
        this.distribution = distribution;
        this.numberOfWins = numberOfWins;
        this.seasonScore = seasonScore;
    }

    public static Player generatePlayer(String name, int numberOfWins, double seasonScore, double standardDeviation) {
        return new Player(name, new Distribution(seasonScore / NUMBER_OF_GAMES, standardDeviation, RANDOM), numberOfWins, seasonScore);
    }

    public void recordResult(boolean didWin, double score) {
        if (didWin) {
            this.numberOfWins++;
        }
        this.seasonScore += score;
    }

    @Override
    public int compareTo(Player o) {
        return (Comparator.<Player>comparingInt(p -> p.numberOfWins))
                .thenComparingDouble(p -> p.seasonScore)
                .compare(this, o);
    }
}
