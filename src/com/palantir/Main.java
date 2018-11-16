package com.palantir;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;

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

    private static class League {
        private final List<Player> players;
        private final List<Week> weeks;

        public League(List<Player> players, List<Week> weeks) {
            this.players = players;
            this.weeks = weeks;
        }

        public List<Player> getPlayers() {
            return players;
        }

        public List<Week> getWeeks() {
            return weeks;
        }

        public static League createLeague() {
            Player kellen = Player.generatePlayer("Kellen", 8, 1291, 19.96);
            Player riley = Player.generatePlayer("Riley", 8, 1245, 22.50);
            Player kyle = Player.generatePlayer("Kyle", 6, 1111, 24.18);
            Player jordan = Player.generatePlayer("Jordan", 5, 1069, 16.06);
            Player alex = Player.generatePlayer("Alex", 4, 1087, 26.25);
            Player tom = Player.generatePlayer("Tom", 4, 1084, 13.95);
            Player ellen = Player.generatePlayer("Ellen", 3, 1000, 23.20);
            Player sam = Player.generatePlayer("Sam", 2, 1143, 24.48);
            List<Player> players = Lists.newArrayList(riley, kellen, kyle, jordan, alex, tom, ellen, sam);

            Week week11 = new Week("Week 11", ImmutableList.of(
                    new Matchup(kellen, jordan),
                    new Matchup(sam, alex),
                    new Matchup(riley, ellen),
                    new Matchup(tom, kyle)
            ));

            Week week12 = new Week("Week 12", ImmutableList.of(
                    new Matchup(kellen, kyle),
                    new Matchup(sam, jordan),
                    new Matchup(riley, alex),
                    new Matchup(tom, ellen)
            ));

            Week week13 = new Week("Week 13", ImmutableList.of(
                    new Matchup(kellen, sam),
                    new Matchup(riley, jordan),
                    new Matchup(tom, alex),
                    new Matchup(ellen, kyle)
            ));

            Week week14 = new Week("Week 14", ImmutableList.of(
                    new Matchup(kellen, riley),
                    new Matchup(sam, kyle),
                    new Matchup(tom, jordan),
                    new Matchup(ellen, alex)
            ));

            List<Week> weeks= ImmutableList.of(week11, week12, week13, week14);

            return new League(players, weeks);
        }
    }
}
