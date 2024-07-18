package com.ss.leetcode.LC2024;

import com.ss.leetcode.LC2024.july.CrawlerLogFolder;
import com.ss.leetcode.LC2024.july.FindTheWinnerOfTheCircularGame;
import com.ss.leetcode.LC2024.july.RobotCollisions;

public class StartJuly {
    public static void main(String[] args) {
        StartJuly start = new StartJuly();

//        start.findTheWinnerOfTheCircularGame();
//        start.crawlerLogFolder();
        start.robotCollisions();
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

    public void robotCollisions() {
        RobotCollisions rc = new RobotCollisions();

        System.out.println("[2,17,9,15,10] == " + rc.survivedRobotsHealths(new int[]{5,4,3,2,1}, new int[]{2,17,9,15,10}, "RRRRR"));
        System.out.println("[14] == " + rc.survivedRobotsHealths(new int[]{3,5,2,6}, new int[]{10,10,15,12}, "RLRL"));
        System.out.println("[] == " + rc.survivedRobotsHealths(new int[]{1,2,5,6}, new int[]{10,10,11,11}, "RLRL"));
    }
}
