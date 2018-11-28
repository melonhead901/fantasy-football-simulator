package com.kellendonohue.fantasyfootball;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;

import java.util.List;

class League {
    /**
     * Number of games played so far this season.
     */
    static final double NUMBER_OF_GAMES_PLAYED = 12;

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
        Player kellen = Player.generatePlayer("Kellen", 10, 1542, 19.22);
        Player riley = Player.generatePlayer("Riley", 10, 1564, 25.28);
        Player kyle = Player.generatePlayer("Kyle", 7, 1337, 21.93);
        Player jordan = Player.generatePlayer("Jordan", 6, 1291, 16.91);
        Player alex = Player.generatePlayer("Alex", 5, 1339, 25.04);
        Player tom = Player.generatePlayer("Tom", 4, 1293, 12.81);
        Player ellen = Player.generatePlayer("Ellen", 3, 1363, 21.27);
        Player sam = Player.generatePlayer("Sam", 3, 1230, 23.33);
        List<Player> players = Lists.newArrayList(riley, kellen, kyle, jordan, alex, tom, ellen, sam);

        /* Commented our because week 11 happened, but left for replay
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
        */

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

        List<Week> weeks= ImmutableList.of(week13, week14);

        return new League(players, weeks);
    }
}
