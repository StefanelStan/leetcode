package com.ss.leetcode.LC2023.december;

public class CountLatticePointsInsideACircle {
    // https://leetcode.com/problems/count-lattice-points-inside-a-circle
    /** Algorithm: EG: [10,10,10]
        1. The problem asks you to find the integer coord points inside a circle:
        2. A circle represents the total points from a plane, equally distant (range) from a fixed point (center)
        3. So you need to find ALL integer coords that have a distance to the center <= range of circle.
        4. Distance between 2 points = Math.sqrt((x2-x1)^2 + (y2-y1)^2))
        5. So you need to find all points (x,y) so that Math.sqrt((x2-10)^2 + (y2-10)^2) <= 10
        6. Given the circle 10,10,10, can you find ALL integer coords OR RANGE of points that have x = 11 that are inside circle?
             - You already know the x2 (x2 = 11).
             - Let's use the formula :  sqrt((11-10)^2 + (y2-10)^2)  <= 10
             - we are not interested in a particular number, but the max range that will satisfy the formula:
             - so [x+1 y+1] are inside circle. What about [x+1, y+9] ? What is the max offset of y which is inside circle for x = x+1?
             - lift the sqrt
             - (11-10)^2 + (limit)^2 <= 100
             - 1 ^ 2 + (limit) ^ 2 <= 100  ==> limit ^2 <= 99 => limit <= Math.sqrt(99) so limit <= 9.
             - This means all points [x+1,y+[1..9] are inside circle, have the distance less than range
        7. Let's look at offset of 6
            6*6 + limit ^ 2 <= 100 ==> limit ^ 2 <= 64 ==> limit <= sqrt(64) ==> limit <= 8.
            So all points[x+4,y+[1..8]] have a distance to center less than range
        8. If you know [x+a][y+b] is inside circle, then all 4 mirror points (quadrant) along x/y axis are inside circle
            [x+a,y+b], [x+a,y-b], [x-a,y+b],[x-a,y-b]
        9. Use an int[201][201] to mark each point
        10. For each circle, expand a range from 1 to r and see how many points fall under the formula limit for each quadrant
            - EG: 10,10,10
            - when x is +1 you have 10 points on quadrant 1 (limit is 9: x+1 y+0..y+9) (you also count y+0)
            - when x is +6 you have 9 points  on quadrant 1  (limit is 8: x+6 y+0..y+8)
            - when x is +7 you have 8 points on quadrant 1  (limit is 7: x+7 y+0..y+7)
            - when x is +9 you have 5 points on quadrant 1 (limit is 4: x+9 y+0..y+4)
     */
    public int countLatticePoints(int[][] circles) {
        int[][] presentPoints = new int[201][201];
        int sum = 0;
        for (int[] circle : circles) {
            sum += markAndCountLatticePoints(circle[0], circle[1], circle[2], presentPoints);
        }
        return sum;
    }

    private int markAndCountLatticePoints(int x, int y, int r, int[][] presentPoints) {
        int count = ++presentPoints[x][y] == 1 ? 1 : 0;
        int limit;
        for (int i = 0; i <= r; i++) {
            limit = (int)Math.sqrt(r * r - i * i);
            count += countPoints(x, y, i, limit, presentPoints);
        }
        return count;
    }

    private int countPoints(int x, int y, int i, int limit, int[][] presentPoints) {
        int count = 0;
        while(limit >= 0) {
            count += (++presentPoints[x + i][y + limit] == 1 ? 1 : 0);
            count += (++presentPoints[x + i][y - limit] == 1 ? 1 : 0);
            count += (++presentPoints[x - i][y + limit] == 1 ? 1 : 0);
            count += (++presentPoints[x - i][y - limit] == 1 ? 1 : 0);
            limit--;
        }
        return count;
    }
}
