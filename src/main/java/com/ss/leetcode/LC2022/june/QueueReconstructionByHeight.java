package com.ss.leetcode.LC2022.june;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class QueueReconstructionByHeight {
    // https://leetcode.com/problems/queue-reconstruction-by-height/
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, Comparator.comparingInt(a -> a[0]));
        int[][] reconstructed = new int[people.length][2];
        for(int[] element : reconstructed) {
            Arrays.fill(element, -1);
        }
        for(int[] person : people) {
            reconstruct(reconstructed, person);
        }
        return reconstructed;
    }

    private void reconstruct(int[][] reconstructed, int[] person) {
        int i = 0, foundGoodPositions = 0;
        while(i < reconstructed.length) {
            if (person[0] <= reconstructed[i][0] || (reconstructed[i][0] == -1 && reconstructed[i][1] == -1)) {
                foundGoodPositions++;
            }
            if (foundGoodPositions == person[1] + 1) {
                break;
            }
            i++;
        }
        reconstructed[i] = person;
    }
}
