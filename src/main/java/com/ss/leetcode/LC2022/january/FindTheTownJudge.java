package com.ss.leetcode.LC2022.january;

public class FindTheTownJudge {
    // https://leetcode.com/problems/find-the-town-judge
    public int findJudge(int n, int[][] trust) {
        boolean[] givenTrust = new boolean[n + 1];
        int[] receivedTrust = new int[n + 1];
        for (int[] personTrust : trust) {
            givenTrust[personTrust[0]] = true;
            receivedTrust[personTrust[1]]++;
        }

        for (int i = 1; i <= n; i++) {
            if (receivedTrust[i] == n - 1 && !givenTrust[i]) {
                return i;
            }
        }
        return -1;
    }

    public int findJudge2(int n, int[][] trust) {
        int[][] peopleAndTrust = new int[n+1][2];
        int judge = -1, nrOfJudges = 0;
        for(int[] t : trust) {
            peopleAndTrust[t[0]][0]++;
            peopleAndTrust[t[1]][1]++;
        }
        for (int i = 1; i < peopleAndTrust.length; i++) {
            if (peopleAndTrust[i][0] == 0 && peopleAndTrust[i][1] == n-1) {
                judge = i;
                nrOfJudges++;
                if (nrOfJudges > 1) {
                    return -1;
                }
            }
        }
        return judge;
    }
}
