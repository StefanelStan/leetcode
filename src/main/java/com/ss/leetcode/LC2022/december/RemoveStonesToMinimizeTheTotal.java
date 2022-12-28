package com.ss.leetcode.LC2022.december;

public class RemoveStonesToMinimizeTheTotal {
    // https://leetcode.com/problems/remove-stones-to-minimize-the-total
    /** Algorithm
         1. For the maximum impact, start removing the largest stones first. Thus [5,4,9,1] can be view as [1,4,5,9]. Total:19
         2. Applying the operation on 9: floor (9/2) = 4. We remove 4 stones and keep 5 -> [1,4,5,5]. Total 15
         3. Continue to apply this to the largest stone until k remains 0 or largest stone is 1.
             [1,4,5,5] -> [1,2,4,5] .Total 12
             [1,2,4,5] -> [1,2,2,4]. Total 9
             [1,2,2,4] -> [1,2,2,2]. Total 7
         4. As we can see, the operation involves removing floor (largest/2) and inserting the leftover back in the list of stones, in the correct position.
         5. You can use a PriorityQueue with a reverseOrder() OR a TreeMap<Integer, Integer> to apply this operation in bulk.
            EG: [1,8,8,8], k = 3. Rather than applying 3 times for each 8, you can bulk-apply it for all 8s in one go, if you count
            them in a TreeMap<Integer, Integer>
         6. As the set of numbers is between [10^4], use a int[10_001] to count the groups of stones and traverse backwords in one go.
     */
    public int minStoneSum(int[] piles, int k) {
        int totalStones = 0;
        int[] count = new int[10_001];
        for (int pile : piles) {
            count[pile]++;
            totalStones += pile;
        }
        int groupsToRemove, floor;
        for (int i = 10_000; i > 1 && k > 0; i--) {
            // determine how many groups of i stones you can remove/how many operations you can do over the current group.
            groupsToRemove = Math.min(count[i], k);
            floor = i / 2;
            // deduct the removed stones from the total number of stones
            totalStones -= (groupsToRemove * floor);
            // put the remaining stones back in the list, at their correct position.
            // eg: [1,4] [0,1,0,0,1]. You remove 2 stones and keep 2 stones: [1,2] -> [0,1,1,0,0]
            // this 2 can be further removed, depending on k
            count[i - floor] += groupsToRemove;
            // deduct the number of remaing operations.
            k -= groupsToRemove;
        }
        return totalStones;
    }
}
