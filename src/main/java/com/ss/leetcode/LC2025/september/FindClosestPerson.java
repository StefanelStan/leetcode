package com.ss.leetcode.LC2025.september;

public class FindClosestPerson {
    // https://leetcode.com/problems/find-closest-person
    /** Algorithm
        1. Determine the abs distances between [P1,P3] and [P2, P3].
        2. If D1 < D2, then P1 is closest, if D1 > D2 then P2 is closest. Else they are both equally apart from P3.
     */
    public int findClosest(int x, int y, int z) {
        int distance1 = Math.abs(x - z);
        int distance2 = Math.abs(y - z);
        return distance1 < distance2 ? 1 : distance1 > distance2 ? 2 : 0;
    }
}
