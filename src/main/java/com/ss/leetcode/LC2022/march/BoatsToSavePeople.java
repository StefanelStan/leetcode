package com.ss.leetcode.LC2022.march;

import java.util.Arrays;

public class BoatsToSavePeople {
    // https://leetcode.com/problems/boats-to-save-people/
    /** Algorithm
        1. Sort the people /their weight.
        2. Start with 2 pointers, one from 0 (left) and one from n (right)
        3. If people[left] + people[right] <= limit, it means they can be paired up in one boat,
            If not, it means people[right] cannot find any light person to pair, as people[left] in a pointer to the minimum sorted people
            EG: [1,3,4,7,8,9], limit 10
            loop1 (left=0, right=5): 1 and 9 <= 10, so they can be paired. left++, right--
            loop2 (left=1, right=4): 3 and 8 > 10, so 8 cannot be paired with anyone, it will need its own boat. only right--
            loop3 (left=1, right=3): 3 and 7 <= 10, so they can share a boat. left++, right--
            loop4 (left=2, right=2): this is where the loop breaks as we loop while left < right.
        4. If at the end left == right, increase the nr of boats one more time. This means that the "middle" person still needs a boat:
            EG: [1,2,3,5,7,8,9] limit =10. [1,9],[2,8],[3,7] and 5 is boatless. We need one more boat.
     */
    public int numRescueBoats(int[] people, int limit) {
        int boats = 0;
        Arrays.sort(people);
        for (int i = 0, j = people.length - 1; i <= j; j--) {
            if (people[i] + people[j] <= limit) {
                i++;
            }
            boats++;
        }
        return boats;
    }

    public int numRescueBoats2(int[] people, int limit) {
        if (people.length == 1) {
            return 1;
        }
        if (people.length == 2) {
            return people[0] + people[1] <= limit ? 1 : 2;
        }
        int boats = 0;
        Arrays.sort(people);
        int left = 0, right = people.length -1;
        while (left < right) {
            if (people[left] + people[right] <= limit) {
                left++;
            }
            boats++;
            right--;
        }
        if (left == right) {
            boats++;
        }
        return boats;
    }
}
