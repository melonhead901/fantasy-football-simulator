package com.kellendonohue.fantasyfootball;

public class SeasonResult {
    private int timesInPlayoff;

    public SeasonResult() {
        this.timesInPlayoff = 0;
    }

    public int getTimesInPlayoff() {
        return timesInPlayoff;
    }

    public void incrementTimesInPlayoff() {
        this.timesInPlayoff++;
    }
}
