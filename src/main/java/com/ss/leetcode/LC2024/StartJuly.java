package com.ss.leetcode.LC2024;

import com.ss.leetcode.LC2024.july.CrawlerLogFolder;
import com.ss.leetcode.LC2024.july.FindTheWinnerOfTheCircularGame;

public class StartJuly {
    public static void main(String[] args) {
        StartJuly start = new StartJuly();

//        start.findTheWinnerOfTheCircularGame();
        start.crawlerLogFolder();
    }

    public void findTheWinnerOfTheCircularGame() {
        FindTheWinnerOfTheCircularGame ftwotcg = new FindTheWinnerOfTheCircularGame();

        System.out.println("3 == " + ftwotcg.findTheWinner(5, 2));
        System.out.println("1 == " + ftwotcg.findTheWinner(6, 5));
        System.out.println("1 == " + ftwotcg.findTheWinner(1, 1));
    }

    public void crawlerLogFolder() {
        CrawlerLogFolder clf = new CrawlerLogFolder();

        System.out.println("2 == " + clf.minOperations(new String[]{"d1/","d2/","../","d21/","./"}));
        System.out.println("3 == " + clf.minOperations(new String[]{"d1/","d2/","./","d3/","../","d31/"}));
        System.out.println("0 == " + clf.minOperations(new String[]{"d1/","../","../","../"}));
    }
}
