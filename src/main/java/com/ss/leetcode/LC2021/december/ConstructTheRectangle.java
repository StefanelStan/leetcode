package com.ss.leetcode.LC2021.december;

public class ConstructTheRectangle {
    // https://leetcode.com/problems/construct-the-rectangle/
    public int[] constructRectangle(int area) {
        int low = (int)Math.sqrt(area);
        while(low > 0) {
            if (area % low == 0) {
                return new int[]{area/low, low};
            }
            low--;
        }
        return new int[]{0,0};
    }

    public int[] constructRectangle2(int area) {
         int sqrt = (int)Math.sqrt(area);
         int low = sqrt, high = sqrt, tempSize = 0;
         int[] answer = {0,0};
         while(low > 0 && high <= area) {
             tempSize = low * high;
             if (tempSize == area) {
                 answer = new int[]{high, low};
                 break;
             } else if (tempSize > area) {
                 low--;
             } else {
                 high++;
             }
         }
         return answer;
    }
}
