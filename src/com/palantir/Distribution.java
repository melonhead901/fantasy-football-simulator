package com.palantir;

import java.util.Objects;
import java.util.Random;

public class Distribution {

    private double average;
    private double standardDeviation;
    private Random random;

    public Distribution(double average, double standardDeviation, Random random) {
        this.average = average;
        this.standardDeviation = standardDeviation;
        this.random = random;
    }

    @Override
    public String toString() {
        return "Distribution{" +
                "average=" + average +
                ", standardDeviation=" + standardDeviation +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Distribution that = (Distribution) o;
        return Double.compare(that.average, average) == 0 &&
                Double.compare(that.standardDeviation, standardDeviation) == 0 &&
                Objects.equals(random, that.random);
    }

    @Override
    public int hashCode() {

        return Objects.hash(average, standardDeviation, random);
    }

    public double generateScore() {
        return random.nextGaussian() * standardDeviation + average;
    }
}
