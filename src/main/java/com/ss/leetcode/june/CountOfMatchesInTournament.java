package com.ss.leetcode.june;

public class CountOfMatchesInTournament {
    // https://leetcode.com/problems/count-of-matches-in-tournament/
    public int numberOfMatches(int n) {
        int totalMatches = 0;
        while (n >= 2) {
            if (n % 2 == 1) {
                n++;
                totalMatches--;
            }
            n = n/2;
            totalMatches += n;
        }
        return totalMatches;
    }
}
