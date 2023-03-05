package com.ss.leetcode.LC2023.march;

public class PassThePillow {
    // https://leetcode.com/problems/pass-the-pillow
    /** Algorithm
        1. We can observe that passing the pillow from 1st to nth person takes n-1 seconds. So a "cycle" takes n-1 seconds.
        2. Thus, time / (n-1) can tell use how many "cycles" have passed. Based on their numbers,
            we can detect the pillow direction: eg: on  even cycles the direction is 1 -> n and on
            odd cycles the direction is n -> 1
        3. The time % (n-1) tells us how many steps have passed on the last cycle.
            eg: time = 13, n = 5. 13/4 = 3. 3 cycle have been completed, so the pillow is coming back from n to 1.
        4. modulo is 1 and odd cycle: this means is the 1nd person away from the end.
     */
    public int passThePillow(int n, int time) {
        boolean fromOneToN = (time / (n-1)) % 2 == 0;
        int index = time % (n-1);
        return fromOneToN
            ? index  == 0 ? 1 : index + 1
            : n - index;
    }
}
