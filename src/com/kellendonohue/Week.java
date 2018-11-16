package com.kellendonohue;

import java.util.List;
import java.util.Objects;

public class Week {
    private String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Week week = (Week) o;
        return Objects.equals(name, week.name) &&
                Objects.equals(matchups, week.matchups);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, matchups);
    }

    public Week(String name, List<Matchup> matchups) {

        this.name = name;
        this.matchups = matchups;
    }

    private List<Matchup> matchups;

    public void executeWeek() {
        //System.out.println("Starting " + name + ":");
        matchups.forEach(Matchup::executeMatchup);
        //System.out.println();
    }

}
