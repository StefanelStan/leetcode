package com.ss.leetcode.LC2024;

import com.ss.leetcode.LC2024.july.FindTheWinnerOfTheCircularGame;

public class StartJuly {
    public static void main(String[] args) {
        StartJuly start = new StartJuly();

        start.findTheWinnerOfTheCircularGame();
    }

    public void findTheWinnerOfTheCircularGame() {
        FindTheWinnerOfTheCircularGame ftwotcg = new FindTheWinnerOfTheCircularGame();

        System.out.println("3 == " + ftwotcg.findTheWinner(5, 2));
//        System.out.println("1 == " + ftwotcg.findTheWinner(6, 5));
//        System.out.println("1 == " + ftwotcg.findTheWinner(1, 1));
    }
}
