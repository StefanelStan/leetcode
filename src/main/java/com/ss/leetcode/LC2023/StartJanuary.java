package com.ss.leetcode.LC2023;

import com.ss.leetcode.LC2023.january.MinimumRoundsToCompleteAllTasks;

public class StartJanuary {
    public static void main(String[] args) {
        StartJanuary start = new StartJanuary();

        start.minimumRoundsToCompleteAllTasks();
    }

    public void minimumRoundsToCompleteAllTasks() {
        MinimumRoundsToCompleteAllTasks mrtcat = new MinimumRoundsToCompleteAllTasks();

        System.out.println("4 == " + mrtcat.minimumRounds(new int[]{2,2,3,3,2,4,4,4,4,4}));
        System.out.println("-1 == " + mrtcat.minimumRounds(new int[]{2,3,3}));
    }
}
