package com.ss.leetcode.LC2023.may;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;

public class DetonateTheMaximumBombs {
    // https://leetcode.com/problems/detonate-the-maximum-bombs
    /** Algorithm
        1. Supposing the distance between 2 bombs is 10; bomb1 radius = 10, bomb2 radius = 8
            If bomb1 explodes, then bomb2 will explode too. If bomb2 explodes first, due to ita radius of 8, it won't reach bomb1.
            Thus, is is most efficient to trigger bomb1 first.
        2. Knowing this, we can observe this is a directed graph. B1 -> B2.
        3. Build a List[] of triggers: can bomb i (0..n-2) trigger bomb j (i+1.. n-1). If yes, add bomb j to the list of bombs that bomb i can trigger.
        4. Once #3 is done, simulate triggering each bomb i 0 ..n-1 and see how many others can explode. (DFS with boolean[] visited)
     */
    public int maximumDetonation(int[][] bombs) {
        List[] triggers = getTriggers(bombs);
        int maxChain = 1;
        for (int i = 0; i < bombs.length; i++) {
            maxChain = Math.max(maxChain, triggerBomb(triggers, i, new boolean[bombs.length]));
        }
        return maxChain;
    }

    private int triggerBomb(List[] triggers, int bomb, boolean[] exploded) {
        if (exploded[bomb]) {
            return 0;
        }
        exploded[bomb] = true;
        int chain = 1;
        List<Integer> chainedBombs = triggers[bomb];
        if (chainedBombs != null) {
            for (int chainedBomb : chainedBombs) {
                chain += triggerBomb(triggers, chainedBomb, exploded);
            }
        }
        return chain;
    }

    private List[] getTriggers(int[][] bombs) {
        List[] triggers = new List[bombs.length];
        double distance;
        for (int i = 0; i < bombs.length -1; i++) {
            for (int j = i + 1; j < bombs.length; j++) {
                distance = Point2D.distance(bombs[i][0], bombs[i][1], bombs[j][0], bombs[j][1]);
                if (distance <= bombs[i][2]) {
                    attachTrigger(triggers, i, j);
                }
                if (distance <= bombs[j][2]) {
                    attachTrigger(triggers, j, i);
                }
            }
        }
        return triggers;
    }

    private void attachTrigger(List[] triggers, int from, int to) {
        if (triggers[from] == null) {
            triggers[from] = new ArrayList<>();
        }
        triggers[from].add(to);
    }
}
