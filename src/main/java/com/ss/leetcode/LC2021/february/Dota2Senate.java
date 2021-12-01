package com.ss.leetcode.LC2021.february;

import java.util.Collection;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;

public class Dota2Senate {
    // https://leetcode.com/problems/dota2-senate/
    public String predictPartyVictory(String senate) {
        Deque<Integer> radiantLocations = new LinkedList<>();
        Deque<Integer> direLocations = new LinkedList<>();

        int radiantPower = 0;
        int direPower = 0;
        // give a +2 to the first
        char currentChar = senate.charAt(0);
        if (currentChar == 'R') {
            radiantPower++;
            radiantLocations.addLast(0);
        } else {
            direPower++;
            direLocations.addLast(0);
        }

        for (int i = 1; i < senate.length(); i++) {
            currentChar = senate.charAt(i);
            if (currentChar == 'R') {
                if (direPower > 0) {
                    direPower--;
                } else {
                    radiantLocations.addLast(i);
                        radiantPower++;
                }
            } else { // if D
                if (radiantPower > 0) {
                    radiantPower--;
                } else {
                    direLocations.addLast(i);
                        direPower++;
                }
            }
        }
        // verify what radiantAndDirePower we got.
        if (radiantPower > 0) {
            int stopping = Math.min(radiantPower, direLocations.size());
            for (int i = 0; i < stopping; i++)
                direLocations.removeFirst();
        }

        if (direPower > 0) {
            int stopping = Math.min(direPower, radiantLocations.size());
            for (int i = 0; i < stopping; i++)
                radiantLocations.removeFirst();
        }

        if (direLocations.isEmpty()) {
            return "Radiant";
        } else if (radiantLocations.isEmpty()) {
            return "Dire";
        } else {
            return predictPartyVictory(buildStringFromQueues(radiantLocations, direLocations));
        }
    }

    private String buildStringFromQueues(Collection<Integer> radiantLocations, Collection<Integer> direLocations) {
        final StringBuilder stb = new StringBuilder(radiantLocations.size() + direLocations.size());
        final Map<Integer, Character> words = new TreeMap<>();

        radiantLocations.forEach(location -> {
            words.put(location, 'R');
        });
        direLocations.forEach(location -> {
            words.put(location, 'D');
        });
        words.values().forEach(sign -> stb.append(sign));
        return stb.toString();
    }
}
