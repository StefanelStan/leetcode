package com.ss.leetcode.LC2022;

import com.ss.leetcode.LC2022.march.ChampagneTower;
import com.ss.leetcode.LC2022.march.CountOperationsToObtainZero;
import com.ss.leetcode.LC2022.march.CountingWordsWithAGivenPrefix;

public class StartMarch {
    public static void main(String[] args) {
        StartMarch start = new StartMarch();

//        start.countOperationsToObtainZero();
//        start.countWordsWithAGivenPrefix();
        start.champagneTower();
    }

    public void countOperationsToObtainZero() {
        CountOperationsToObtainZero cotoz = new CountOperationsToObtainZero();

        System.out.println("3 == " + cotoz.countOperations(2, 3));
        System.out.println("1 == " + cotoz.countOperations(10, 10));
    }

    public void countWordsWithAGivenPrefix() {
        CountingWordsWithAGivenPrefix cwwagp = new CountingWordsWithAGivenPrefix();

        System.out.println("2 == " + cwwagp.prefixCount(new String[]{"pay","attention","practice","attend"}, "at"));
        System.out.println("0 == " + cwwagp.prefixCount(new String[]{"leetcode","win","loops","success"}, "code"));
    }

    public void champagneTower() {
        ChampagneTower ct = new ChampagneTower();

        System.out.println("0.0000 == " + ct.champagneTower(1, 1, 1));
        System.out.println("0.5000 == " + ct.champagneTower(2, 1, 1));
        System.out.println("1.0000 == " + ct.champagneTower(100000009, 33, 17));
        System.out.println("1.0000 == " + ct.champagneTower(50, 6, 5));
        System.out.println("1.0000 == " + ct.champagneTower(5352433, 86, 34));
    }
}
