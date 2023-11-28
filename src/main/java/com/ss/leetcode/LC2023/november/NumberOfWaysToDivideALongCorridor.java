package com.ss.leetcode.LC2023.november;

public class NumberOfWaysToDivideALongCorridor {
    // https://leetcode.com/problems/number-of-ways-to-divide-a-long-corridor
    /** Algorithm: EG: "SSPPSPS"
        1. Use a global variable to keep track of how many seats you have. If odd, return 0 at the end
        2. The normal DP would observe that barely at index 1 you have 2 seats, thus, you can build
            1 + waysFromPosition(1) waysFromPosition(2) + waysFromPosition(3).
        3. However, if you select posiiton 1 or 2 or 3, you can only place walls upp until index 4, where
            the next seat pair starts.
            Thus,  waysFromPosition(1) == waysFromPosition(2) == waysFromPosition(3).
            So, if you know waysFromPosition(3), then you just multiply by 3
        4. Looking further, form position 4 you can only build 1 wall: right before position 4.
            So, you have 1 + 1 + 1.
        5. Now apply a backward thinking.
            - If you start from the back, barely at position 4 you can claim you have 1 valid pair/arrangement
            - Jumping to pos 3 would give you the same amount, so pos3 = pos4
            - Jumping to pos 2 would give you ther same amount, so pos2 = pos4
        6. However, this number 3 can only be accounted only when you have a new pair of seats,
            EG: "PPSPS". At index 0 you have 3 arrangements, but without any other pair of seats, you cannot
            make them valid.
        7. With each P, keep track of a "tempSum" equal to the lastPosiiton you have a seat pair.
     */
    public int numberOfWays(String corridor) {
        int rollingWays = 0, lastWay = 0;
        int hasTwoSeats = 0, totalSeats = 0;
        for (int i = corridor.length() - 1; i >= 0; i--) {
            if (corridor.charAt(i) == 'P') {
                if (hasTwoSeats != 1) {
                    rollingWays = (rollingWays + lastWay) % 1_000_000_007;
                }
            } else {
                totalSeats++;
                if (hasTwoSeats == 1) {
                    lastWay = Math.max(rollingWays, 1);
                    rollingWays = lastWay;
                    hasTwoSeats = -1;
                }
                hasTwoSeats++;
            }
        }
        return totalSeats % 2 == 0 ? lastWay : 0;
    }
}
