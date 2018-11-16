package com.palantir;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    private static final int NUMBER_OF_EXECUTIONS = 10000;
    private static final int PLAYOFF_SPOTS = 4;

    public static void main(String[] args) {
        League league = League.createLeague();

        List<Player> players = league.getPlayers();
        List<Week> weeks = league.getWeeks();

        Map<Player, Integer> timesInPlayoff = new HashMap<>();

        for (int i = 0; i < NUMBER_OF_EXECUTIONS; i++) {
            executeSeason(players, weeks, timesInPlayoff);
        }

        for (Map.Entry<Player, Integer> e : timesInPlayoff.entrySet()) {
            System.out.println(String.format("%s has %.2f%% chance of making playoffs", e.getKey().name,
                    e.getValue() * 100.0 / NUMBER_OF_EXECUTIONS));
        }

    }

    private static void executeSeason(List<Player> players, List<Week> weeks, Map<Player, Integer> timesInPlayoff) {
        weeks.forEach(Week::executeWeek);

        Collections.sort(players);
        Collections.reverse(players);

        //printStandings();

        for (int i = 0; i < PLAYOFF_SPOTS; i++) {
            timesInPlayoff.merge(players.get(i), 1, Integer::sum);
        }

        players.forEach(Player::reset);
    }

    private static void printStandings(List<Player> players) {
        System.out.println("Standings:");
        for (Player p : players) {
            System.out.println(p);
        }
        System.out.println();
    }

}
