package com.ss.leetcode.LC2023.march;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class EliminateMaximumNumberOfMonsters {
    // https://leetcode.com/problems/eliminate-maximum-number-of-monsters
    public int eliminateMaximum(int[] dist, int[] speed) {
        int[] monsters = getMonsters(dist, speed);
        int rounds = 1;
        while(rounds < dist.length && monsters[rounds] > rounds) {
            rounds++;
        }
        return rounds;
    }

    private int[] getMonsters(int[] dist, int[] speed) {
        int[] monsters = new int[dist.length];
        for(int i = 0; i < dist.length; i++) {
            monsters[i] = (int)Math.ceil((double)dist[i] / speed[i]);
        }
        Arrays.sort(monsters);
        return monsters;
    }

    public int eliminateMaximum2(int[] dist, int[] speed) {
        int[][] monsters = getMonsters2(dist, speed);
        int rounds = 1;
        int distance = 1;
        while(rounds < dist.length && distance >= 1) {
            distance = monsters[rounds][0] - rounds * monsters[rounds][1];
            if (distance > 0) {
                rounds++;
            }
        }
        return rounds;
    }

    private int[][] getMonsters2(int[] dist, int[] speed) {
        int[][] monsters = new int[dist.length][2];
        for(int i = 0; i < dist.length; i++) {
            monsters[i][0] = dist[i];
            monsters[i][1] = speed[i];
        }
        Arrays.sort(monsters, Comparator.comparingDouble(e -> (double)e[0] / e[1]));
        return monsters;
    }

    public int eliminateMaximum3(int[] dist, int[] speed) {
        PriorityQueue<Integer> closestMonsters =  new PriorityQueue<>(Comparator.comparingDouble(i -> (double)dist[i] / speed[i]));
        for (int i = 0; i < dist.length; i++) {
            closestMonsters.add(i);
        }
        int rounds = 1;
        closestMonsters.poll();
        int distance = 1, index;
        while(!closestMonsters.isEmpty() && distance >= 1) {
            index = closestMonsters.poll();
            distance = dist[index] - rounds * speed[index];
            if (distance > 0) {
                rounds++;
            }
        }
        return rounds;
    }
}
