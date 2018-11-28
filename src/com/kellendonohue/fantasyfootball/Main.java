package com.kellendonohue.fantasyfootball;

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

        Map<Player, SeasonResult> timesInPlayoff = new HashMap<>();
        players.forEach(p -> timesInPlayoff.put(p, new SeasonResult()));

        for (int i = 0; i < NUMBER_OF_EXECUTIONS; i++) {
            executeSeason(players, weeks, timesInPlayoff);
        }

        for (Map.Entry<Player, SeasonResult> e : timesInPlayoff.entrySet()) {
            printSeasonResult(e.getKey(), e.getValue());
        }

    }

    private static void printSeasonResult(Player player, SeasonResult seasonResult) {
        String outputString = "%s has %.2f%% chance of making playoffs";
        if (seasonResult.getSupportersShield() > 0) {
            outputString += ", %.2f%% chance of Supporters' Shield";
        }
        System.out.println(String.format(outputString, player.name,
                seasonResult.getTimesInPlayoff() * 100.0 / NUMBER_OF_EXECUTIONS,
                seasonResult.getSupportersShield() * 100.0 / NUMBER_OF_EXECUTIONS));
    }

    private static void executeSeason(List<Player> players, List<Week> weeks, Map<Player, SeasonResult> timesInPlayoff) {
        weeks.forEach(Week::executeWeek);

        Collections.sort(players);
        Collections.reverse(players);

        //printStandings();

        timesInPlayoff.get(players.get(0)).incrementSupportersShield();

        for (int i = 0; i < PLAYOFF_SPOTS; i++) {
            timesInPlayoff.get(players.get(i)).incrementTimesInPlayoff();
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
