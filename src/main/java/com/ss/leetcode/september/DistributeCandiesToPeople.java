package com.ss.leetcode.september;

public class DistributeCandiesToPeople {
    // https://leetcode.com/problems/distribute-candies-to-people/
    public int[] distributeCandies(int candies, int num_people) {
        int[] people = new int[num_people];
        int round = 0, proposedCandy;
        while (candies > 0) {
            for (int i = 0; i < people.length; i++) {
                proposedCandy = round * num_people + (i + 1);
                if (proposedCandy < candies) {
                    people[i] += proposedCandy;
                } else {
                    people[i] += candies;
                    candies -= proposedCandy;
                    break;
                }
                candies -= proposedCandy;
            }
            round++;
        }
        return people;
    }
}
