package com.ss.leetcode.LC2022.january;

public class FindTheTownJudge {
    public int findJudge(int n, int[][] trust) {
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
