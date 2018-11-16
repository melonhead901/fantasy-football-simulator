package com.palantir;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Player kellen = Player.generatePlayer("Kellen", 8, 1291, 19.96 );
        Player riley = Player.generatePlayer("Riley", 8, 1245, 22.50 );
        Player kyle = Player.generatePlayer("Kyle", 6, 1111, 24.18 );
        Player jordan = Player.generatePlayer("Jordan", 5, 1069, 16.06 );
        Player alex = Player.generatePlayer("Alex", 4, 1087, 26.25 );
        Player tom = Player.generatePlayer("Tom", 4, 1084, 13.95 );
        Player ellen = Player.generatePlayer("Ellen", 3, 1000, 23.20 );
        Player sam = Player.generatePlayer("Sam", 2, 1143, 24.48 );
        List<Player> players = Lists.newArrayList(riley, kellen, kyle, jordan, alex, tom, ellen, sam);


        Collections.sort(players);
        Collections.reverse(players);

        for (Player p : players) {
            System.out.println(p);
        }
    }

    static class Tuple {
        public Boolean get(int n) {
            return Boolean.FALSE;
        }
    }

    enum Nullable {
        NOT_NULLABLE(false),
        NULLABLE(true);

        final boolean val;
        Nullable(boolean val) {
            this.val = val;
        }

    };
}
