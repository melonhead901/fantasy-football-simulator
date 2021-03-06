package com.kellendonohue.fantasyfootball;

public class SeasonResult {
    private int timesInPlayoff;
    private int supportersShield;

    public SeasonResult() {
        this.timesInPlayoff = 0;
        this.supportersShield = 0;
    }

    public int getTimesInPlayoff() {
        return timesInPlayoff;
    }

    public void incrementTimesInPlayoff() {
        this.timesInPlayoff++;
    }

    public void incrementSupportersShield() {
        this.supportersShield++;
    }

    public int getSupportersShield() {
        return this.supportersShield;
    }
}
