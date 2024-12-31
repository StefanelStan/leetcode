package com.ss.leetcode.LC2024.december;

public class NumberOfPeopleAwareOfASecret {
    // https://leetcode.com/problems/number-of-people-aware-of-a-secret
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        int[] people = new int[delay + (forget - delay)];
        int secretAware = 0;
        people[people.length - 1] = 1;
        while (n > 1) {
            secretAware = 0;
            for (int i = 0; i < people.length - 1; i++) {
                people[i] = people[i + 1];
                people[i+1] = 0;
                if (i < (forget - delay)) {
                    secretAware = (secretAware + people[i]) % 1_000_000_007;
                }
            }
            people[people.length -1] = secretAware;
            n--;
        }
        secretAware = 0;
        for (int person : people) {
            secretAware = (secretAware + person) % 1_000_000_007;
        }
        return secretAware;
    }
}
