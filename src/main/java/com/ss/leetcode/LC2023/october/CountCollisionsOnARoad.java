package com.ss.leetcode.LC2023.october;

public class CountCollisionsOnARoad {
    // https://leetcode.com/problems/count-collisions-on-a-road
    /** Algorithm
        1. Traverse the directions, inspect and count each direction/car, applying proper logic
        2. If Direction is R, then every car with S or L direction becomes irelevant. Set them to 0 and increase rCount
        3. If direction is S, then all the rCount will collide with S, so collisions += rCount. Reset rSount, lCount.
        4. If direction is L
            - If you have an sCount, then the L car will collide with it(collisions += 1)
            - Else if you have rCount, then the L car will crash with the first r, causing collisions +2
            The remaining rCount will collide with the "fresh collision" (collisions += rCount -1), and rCount = 0;
        5. Return total number of collisions.
     */
    public int countCollisions(String directions) {
        int sCount = 0, rCount = 0;
        int collisions = 0;
        char currentCar;
        for (int i = 0; i < directions.length(); i++) {
            currentCar = directions.charAt(i);
            if (currentCar == 'R') {
                rCount++;
                sCount = 0;
            } else if (currentCar == 'S') {
                // all R cars will collide with this.
                collisions += rCount;
                rCount = 0;
                sCount = 1;
            } else {
                // the L car will collide with the statutionary car
                if (sCount == 1) {
                    collisions++;
                } else if (rCount > 0) {
                    // the L car will collide with the last R car (+2) and the remaining r cars will collide with the
                    // "wreckage / this new stationary car"
                    collisions += (rCount + 1);
                    sCount = 1;
                    rCount = 0;
                }
            }
        }
        return collisions;
    }
}
