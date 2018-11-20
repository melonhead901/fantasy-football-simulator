package com.kellendonohue.fantasyfootball;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;

import java.util.List;

class League {
    /**
     * Number of games played so far this season.
     */
    static final double NUMBER_OF_GAMES_PLAYED = 11;

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
        Player kellen = Player.generatePlayer("Kellen", 9, 1401, 19.8);
        Player riley = Player.generatePlayer("Riley", 9, 1420, 26.18);
        Player kyle = Player.generatePlayer("Kyle", 7, 1228, 22.98);
        Player jordan = Player.generatePlayer("Jordan", 5, 1161, 15.98);
        Player alex = Player.generatePlayer("Alex", 5, 1223, 26.24);
        Player tom = Player.generatePlayer("Tom", 4, 1192, 13.24);
        Player ellen = Player.generatePlayer("Ellen", 2, 1260, 22.02);
        Player sam = Player.generatePlayer("Sam", 3, 1115, 24.12);
        List<Player> players = Lists.newArrayList(riley, kellen, kyle, jordan, alex, tom, ellen, sam);

        /* Commented our because week 11 happened, but left for replay
        Week week11 = new Week("Week 11", ImmutableList.of(
                new Matchup(kellen, jordan),
                new Matchup(sam, alex),
                new Matchup(riley, ellen),
                new Matchup(tom, kyle)
        ));
        */

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

        List<Week> weeks= ImmutableList.of(week12, week13, week14);

        return new League(players, weeks);
    }
}
