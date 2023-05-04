package com.ss.leetcode.LC2021.february;

import java.util.Collection;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;

public class Dota2Senate {
    // https://leetcode.com/problems/dota2-senate/
    /** Algorithm
        1. After applying the logic of D cancels next R and R cancels next D, we observe that DRRDDR results in DRD
        2. On next round DRD => DD
        3. However, there are also some edge cases: EG: DRR : firstD cancells first R but next R cancels first D, thus resulting R
        4. We need to also consider this when traversing the string: the end letters that didn't get to do any cuts yet.
        5. Each char (R, D) will use two int states:
            - count (to know how many you have, we stop when first count reaches 0)
            - bonus (or cut power): the chars that didn't get to do their cut as they are at the end of string
            EG: DRR
                - The trick is to transfer the remaining cutting power to the next round:
            EG: DRRR -> DRR but r will transfer 2 points of cutting power. Thus, when we reach D, d cannot vote as r has bonus from prev round.
        6. Simulation
            - Round 1: "DRR"
                -  i == 0: [D]: dCount 1, dBonus 1 ; R = rCount 0, rBonus 0.
                    As rBonus == 0, this D will not be cut, so it can be put into the stringBuilder
                - i == 1 [R] as we observe that dBonus > 0, this R will NOT make it to the stringBuilder
                    dCount= 1, bBonus =0 , rCount = 0, rBonus = 0,
                - i == 2: [R] as dBonus is 0, this R cannot be cut, so it will enter the stringBuilder
                    dcount 1, dBonus = 0, rcount = 1, dBonus = 1
                    our StringBuilder is DR
            - Round 2:  "DR"
                - i = 0 [D] as rBonus > 0, this D will not enter, and will be eliminated.
                    dCount = 0, dBonus = 0, rCount = 0, rbonus = 0.
                - i == 1 [R]
                    as dBonus is == 0, this R will enter the stringBuilder
                    dCount = 0, dBonus = 0, rCount = 1, rBonus = 1.
        7. As dCount is 0 and rcount is 1, Radiant is the winnder.
     */
    public String predictPartyVictory(String senate) {
        String[] winner = new String[1];
        traverseAndCutVotes(senate, 0, 0, winner);
        return winner[0];
    }

    private void traverseAndCutVotes(String senate, int dBonus, int rBonus, String[] winner) {
        int dCount = 0, rCount = 0;
        StringBuilder stb = new StringBuilder(senate.length() / 2);
        char ch;
        for (int i = 0; i < senate.length(); i++) {
            ch = senate.charAt(i);
            if (ch == 'D') {
                if (rBonus > 0) {
                    rBonus--;
                } else {
                    dCount++;
                    dBonus++;
                    stb.append(ch);
                }
            } else {
                if (dBonus > 0) {
                    dBonus--;
                } else {
                    rCount++;
                    rBonus++;
                    stb.append(ch);
                }
            }
        }

        if (dCount <= 0) {
            winner[0] = "Radiant";
        } else if (rCount <= 0) {
            winner[0] = "Dire";
        } else {
            traverseAndCutVotes(stb.toString(), dBonus, rBonus, winner);
        }
    }


    public String predictPartyVictory2(String senate) {
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
