package com.ss.leetcode.LC2021.november;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class RelativeRanks {
    // https://leetcode.com/problems/relative-ranks/
    public String[] findRelativeRanks(int[] score) {
        List<Integer> positions = new ArrayList<>(score.length);
        for (int i = 0; i < score.length; i++) {
            positions.add(i);
        }
        Collections.sort(positions, Comparator.comparingInt(a -> score[a]));
        String[] ranks = new String[score.length];
        for (int i = score.length - 1, rank = 0; i >= 0; i--, rank++) {
            ranks[positions.get(i)] = getRank(rank);
        }
        return ranks;
    }

    private String getRank(int pos) {
        return switch(pos) {
            case 0 -> "Gold Medal";
            case 1 -> "Silver Medal";
            case 2 -> "Bronze Medal";
            default -> String.valueOf(pos + 1);
        };
    }



    public String[] findRelativeRanks2(int[] score) {
        if (score.length == 1) {
            return new String[]{"Gold Medal"};
        }
        if (score.length == 2) {
            return score[0] > score[1] ? new String[]{"Gold Medal", "Silver Medal"} : new String[]{"Silver Medal", "Gold Medal"};
        }

        String[] ranks =  new String[score.length];
        RelativePosition[] rp = new RelativePosition[score.length];
        for (int i = 0; i < score.length; i++) {
            rp[i] = new RelativePosition(score[i], i);
        }
        Arrays.sort(rp, Comparator.comparingInt(rr -> rr.score));
        rp[score.length -1].rank = "Gold Medal";
        rp[score.length -2].rank = "Silver Medal";
        rp[score.length -3].rank = "Bronze Medal";
        for (int i = score.length -4, r = 4; i >= 0; i--, r++) {
            rp[i].rank = String.valueOf(r);
        }
        Arrays.sort(rp, Comparator.comparingInt(rr -> rr.inputOrder));
        for (int i = 0; i < rp.length; i++) {
            ranks[i] = rp[i].rank;
        }

        return ranks;
    }

    private static class RelativePosition {
        int score;
        int inputOrder;
        String rank;

        public RelativePosition (int score, int inputOrder) {
            this.score = score;
            this.inputOrder = inputOrder;
        }
    }
}
