package com.ss.leetcode.LC2023.february;

public class FriendsOfAppropriateAges {
    // https://leetcode.com/problems/friends-of-appropriate-ages
    /** Algorithm
        1. Looking at the input data, the ages are between 1 and 120.
            If person of age X can send a friend request to person of age Y, it means ALL people of age X can sent requests
            to ALL people of age Y.
            This means it makes more sense to COUNT each age in an int[121]
        2. Looking at the criteria age[y] > age[x], we see a younger person cannot befriend an older person.
            So we have to traverse this array from right to left, checking if person of age 120 can befriend age 120, 119..1.
        3. If can yes, if i == j (same group) add the permutation (n! / (n-2)!) which is n * (n-1).
            if i !=j, then add their multiplication. (group[i] * group[j]).
     */
    public int numFriendRequests(int[] ages) {
        int[] peopleAges = new int[121];
        int requests = 0;
        for (int age : ages) {
            peopleAges[age]++;
        }
        for (int i = peopleAges.length -1; i>= 1; i--) {
            if (peopleAges[i] > 0) {
                for (int j = i; j >= 1; j--) {
                    if (peopleAges[j] > 0 && canBefriend(i, j)) {
                        requests += (i == j ? peopleAges[i] * (peopleAges[i]-1) : peopleAges[i] * peopleAges[j]);
                    }
                }
            }
        }
        return requests;
    }

    private boolean canBefriend(int i, int j) {
        return !(j <= 0.5 * i + 7 || j > 100 && i < 100);
    }
}
