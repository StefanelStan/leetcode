package com.ss.leetcode.LC2022.november;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class MinimumGeneticMutation {
    // https://leetcode.com/problems/minimum-genetic-mutation/
    public int minMutation(String start, String end, String[] bank) {
        if (bank.length == 0) {
            return -1;
        }
        if (start.equals(end)) {
            return 0;
        }
        bank = setupBank(start, end, bank);
        int[] minMutations = {Integer.MAX_VALUE};
        if (bank != null) {
            findMutations(start, end, 0, bank, minMutations);
        }
        return minMutations[0] == Integer.MAX_VALUE ? -1 : minMutations[0];
    }

    private String[] setupBank(String start, String end, String[] bank) {
        Set<String> temp = new HashSet<>();
        for (String item : bank) {
            temp.add(item);
        }
        if (!temp.contains(end)) {
            return null;
        }
        temp.add(start);
        temp.remove(end);
        String[] formattedBank = new String[temp.size()];
        int[] index = {0};
        temp.forEach(e -> formattedBank[index[0]++] = e);
        return formattedBank;
    }

    private void findMutations(String start, String end, int pathLength, String[] bank, int[] minMutations) {
        if (start.equals(end)) {
            minMutations[0] = Math.min(pathLength, minMutations[0]);
        } else {
            List<String> closestMutations = new LinkedList<>();
            for (int i = 0; i < bank.length; i++) {
                if (isValidCloseMutation(end, bank[i])) {
                    closestMutations.add(bank[i]);
                    bank[i] = null;
                }
            }
            for (String closeMutation : closestMutations) {
                findMutations(start, closeMutation, pathLength + 1, Arrays.copyOf(bank, bank.length), minMutations);
            }
        }
    }

    private boolean isValidCloseMutation(String gene1, String gene2) {
        if (gene2 == null) {
            return false;
        }
        int diffs = 0;
        for (int i = 0; i < gene1.length(); i++) {
            if (gene1.charAt(i) != gene2.charAt(i)) {
                diffs++;
            }
        }
        return diffs < 2;
    }
}
